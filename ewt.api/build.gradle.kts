plugins {
    id("java")
    id("maven-publish")
}

group = "dev.equo"

// Map a Gradle version to a valid OSGi version: keep major.minor.micro, and turn any
// trailing qualifier (e.g. "-SNAPSHOT") into an OSGi-legal ".SNAPSHOT". "0.1.4" stays as-is.
fun osgiVersion(v: String): String {
    val m = Regex("""^(\d+)\.(\d+)\.(\d+)(?:[.-](.+))?$""").find(v) ?: return v
    val (maj, min, mic, q) = m.destructured
    return if (q.isEmpty()) "$maj.$min.$mic"
           else "$maj.$min.$mic." + q.replace(Regex("[^A-Za-z0-9_-]"), "_")
}

// Target JDK 22 bytecode (class file v66) so JDK 22 stays the minimum runtime requirement,
// independent of which JDK runs the build (e.g. the CI image ships JDK 23). The FFM API used
// by the jextract bindings was finalized in JDK 22, so 22 is the real floor. Using release
// (instead of a toolchain) avoids requiring a JDK 22 install on every build machine/CI.
tasks.withType<JavaCompile>().configureEach {
    options.release.set(22)
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.assertj:assertj-core:3.27.2")

    compileOnly("org.immutables:value-annotations:2.10.1")
    compileOnly("org.immutables:builder:2.10.1")
    annotationProcessor("org.immutables:value:2.10.1")
    annotationProcessor("org.immutables:builder:2.10.1")
    annotationProcessor(project(":annotation-processor"))
}

// Split annotation processors from compile to modify immutable generated classes
val processCustom = tasks.register<JavaCompile>("processCustom") {
    source = sourceSets.main.get().java
    classpath = sourceSets.main.get().compileClasspath
    destinationDirectory.set(layout.buildDirectory.dir("generated/sources/immutables"))
    options.compilerArgs.add("-proc:only")
    options.annotationProcessorPath = configurations.annotationProcessor.get()
}

tasks.named<JavaCompile>("compileJava") {
    options.compilerArgs.add("-proc:none")
    dependsOn(processCustom)
}

sourceSets {
    main {
        java {
            srcDir("${layout.buildDirectory.get()}/generated/sources/immutables")
        }
        resources {
            srcDir(layout.buildDirectory.dir("generated/resources/main"))
        }
    }
}

// Integration-only source set: the SPI provider that hands Evolve the combined-bundle base.
// Gated on the sibling swt-evolve jar (compileOnly), so base ewt.api still builds without it.
// The swt-evolve checkout defaults to the conventional sibling layout; override its location
// with -PevolveHome=<path> (absolute, or relative to this repo root) — e.g. the CI passes the
// path it cloned to instead of relying on the implicit ../../ .
// Locate the sibling swt-evolve repo. -PevolveHome wins (the CI passes the path it cloned to);
// otherwise probe the conventional dev layouts — a true sibling of this repo (../swt-evolve) or
// one level up (../../swt-evolve) — picking the first that actually holds swt-evolve (swt_native/).
// Falls back to the sibling location so the "not found" error points at the natural spot.
val evolveHome = (project.findProperty("evolveHome") as String?)
    ?.let { rootProject.projectDir.resolve(it) }
    ?: listOf("../swt-evolve", "../../swt-evolve")
        .map { rootProject.projectDir.resolve(it) }
        .firstOrNull { it.resolve("swt_native").isDirectory }
    ?: rootProject.projectDir.resolve("../swt-evolve")
val evolvePlatform = System.getProperty("os.name").lowercase().let {
    when {
        it.contains("linux") -> "linux-x86_64"
        it.contains("win")   -> "windows-x86_64"
        // Evolve's macOS jar is per-arch (macos-aarch64 / macos-x86_64); follow the host JVM.
        it.contains("mac")   -> "macos-" +
            (if (System.getProperty("os.arch").lowercase().contains("aarch64")) "aarch64" else "x86_64")
        else -> throw GradleException("Unsupported OS: $it")
    }
}
val evolveJar = evolveHome.resolve("swt_native/build/libs/swt_evolve-$evolvePlatform.jar")
val evolveAvailable = evolveJar.exists()

if (evolveAvailable) {
    val evolve by sourceSets.creating {
        compileClasspath += sourceSets.main.get().output + files(evolveJar)
        runtimeClasspath += sourceSets.main.get().output + files(evolveJar)
    }
    tasks.named<JavaCompile>("compileEvolveJava") {
        dependsOn("compileJava")
        options.release.set(22)
    }

    // OS this ewt-evolve jar is built for. -Pclassifier=<os> overrides (CI); otherwise the
    // current OS. The combined-bundle subpath mirrors Evolve's per-OS external-bundle
    // constants (LINUX_X64_RELEASE / WIN_X64_RELEASE), so Evolve finds the bundle unchanged.
    val ewtEvolveOs = (project.findProperty("classifier") as String?)?.takeIf { it.isNotEmpty() }
        ?: System.getProperty("os.name").lowercase().let {
            when {
                it.contains("linux") -> "linux"
                it.contains("win")   -> "windows"
                it.contains("mac")   -> "macos"
                else -> throw GradleException("Unsupported OS: $it")
            }
        }
    val ewtEvolveBundleSubpath = when (ewtEvolveOs) {
        "linux"   -> "linux/x64/release"
        "windows" -> "windows/x64/runner/Release"
        "macos"   -> "macos/Build/Products/Release/swtflutter.app/Contents"
        else -> throw GradleException("Unsupported OS: $ewtEvolveOs")
    }

    // The EWT-owned combined bundle produced by :examples:buildCombinedBundle (per-OS layout).
    // Each OS mirrors its Flutter desktop embedder's convention: Linux nests the payload under
    // bundle/{lib,data}; Windows puts it directly under <Release>/data (no bundle/ wrapper, and
    // the snapshot is app.so — the Windows Evolve bridge creates its DartProject at <base>/data);
    // macOS uses Flutter's .app/Contents/Frameworks/*.framework layout, so the subpath IS the
    // bundle root.
    val ewtEvolveContentRel = when (ewtEvolveOs) {
        "macos"   -> ""
        "windows" -> "/data"
        else      -> "/bundle"
    }
    val combinedBundleDir = rootProject.projectDir.resolve(
        "evolve-app/build/$ewtEvolveBundleSubpath$ewtEvolveContentRel")
    // Where the bundle tree lands inside the jar (mirrors the property contract) and the cheapest
    // proof the assemble ran, both per-OS to match the layout above.
    val ewtEvolveIntoPath = "evolve-bundle/$ewtEvolveBundleSubpath$ewtEvolveContentRel"
    val ewtEvolveProbe = when (ewtEvolveOs) {
        "macos"   -> "Frameworks/App.framework/App"
        "windows" -> "app.so"
        else      -> "lib/libapp.so"
    }

    // Self-contained integration artifact (dev.equo:ewt-evolve). A consumer that already ships
    // Evolve (as its swt.jar replacement) adds only this jar + the Evolve jar — no separate base
    // ewt.api. It bundles the whole EWT toolkit, EwtWidget, the SPI provider and the combined
    // Flutter bundle, minus the standalone native resources (dead weight in attach mode).
    tasks.register<Jar>("ewtEvolveJar") {
        group = "native"
        description = "Package the self-contained EWT↔Evolve integration jar (dev.equo:ewt-evolve, per-OS)."
        archiveBaseName.set("ewt-evolve")
        archiveClassifier.set(ewtEvolveOs)
        dependsOn(":examples:buildCombinedBundle", "compileEvolveJava")
        // The EWT toolkit classes (EWT.*, App, NativeLibLoader, EvolveBundleExtractor, the
        // generated builders and the ffm bindings). Taken straight from compileJava's output,
        // NOT the main resources: those are just the standalone native libs under native/, which
        // are dead weight in attach mode (EWT uses Evolve's engine and the combined libwidgets
        // from the bundle). Keeping them out holds this jar to classes + the combined bundle.
        from(tasks.named<JavaCompile>("compileJava").flatMap { it.destinationDirectory })
        // Provider classes + META-INF/services + EwtWidget.
        from(sourceSets["evolve"].output)
        // The combined bundle as a resource tree mirroring the property contract.
        from(combinedBundleDir) { into(ewtEvolveIntoPath) }
        manifest {
            attributes(
                "Bundle-ManifestVersion" to 2,
                "Bundle-Name" to "EWT to Evolve integration",
                "Bundle-Vendor" to "Equo Tech, Inc.",
                "Bundle-SymbolicName" to "dev.equo.ewt.evolve",
                "Bundle-Version" to osgiVersion(project.version.toString()),
                // Attach to the org.eclipse.swt host Evolve provides, so EwtWidget joins the
                // host-exported org.eclipse.swt.widgets package (host has Eclipse-ExtensibleAPI:true)
                // and this fragment's META-INF/services is visible to the host classloader.
                "Fragment-Host" to "org.eclipse.swt;bundle-version=\"[3.100,4.0.0)\"",
                // Export only the EWT public API the integrator bundle imports. The jextract
                // bindings (dev.equo.ewt.ffm) and the SPI internals (dev.equo.ewt.evolve) stay
                // unexported. org.eclipse.swt.widgets is already exported by the host.
                "Export-Package" to "dev.equo.ewt,dev.equo.ewt.util",
                // Needed so the OSGi-aware bundle extraction can reach the framework API
                // (BundleReference / FrameworkUtil / Bundle) reflectively: reflection still
                // requires the classes to be visible, and the org.eclipse.swt host does not
                // import them. The system bundle always exports this package under OSGi;
                // on a flat classpath the whole manifest is ignored.
                "Import-Package" to "org.osgi.framework",
                "Automatic-Module-Name" to "dev.equo.ewt.evolve",
            )
        }
        doFirst {
            if (!combinedBundleDir.resolve(ewtEvolveProbe).exists()) {
                throw GradleException(
                    "Combined bundle missing at ${combinedBundleDir}. " +
                    "Run :examples:buildCombinedBundle first (needs the sibling swt-evolve).")
            }
        }
    }

    // Publish ewt-evolve as its own artifact (a real artifactId, not a classifier of ewt.api).
    // Gated on Evolve availability, so base ewt.api still builds/publishes without swt-evolve.
    publishing {
        publications {
            create<MavenPublication>("ewtEvolve") {
                groupId = "dev.equo"
                artifactId = "ewt-evolve"
                version = project.version.toString()
                // Reference the built file (as the ewtApi publication does) rather than the
                // task, so publishing uploads an already-built jar without re-running the
                // combined-bundle merge — the CI publish job restores the jar as an artifact.
                artifact(file("build/libs/ewt-evolve-${project.version}-${ewtEvolveOs}.jar")) {
                    classifier = ewtEvolveOs
                }
                pom {
                    name.set("EWT ↔ Evolve integration")
                    description.set(
                        "Self-contained EWT toolkit + EwtWidget + SPI provider + combined " +
                        "Flutter bundle for embedding EWT widgets in an SWT Evolve surface (per-OS)."
                    )
                }
            }
        }
    }
}

tasks.test {
    useJUnitPlatform {
        if (System.getProperty("skipNativeTests") != null) {
            excludeTags("native")
        }
    }

    systemProperty("os.name", System.getProperty("os.name"))

    if (System.getProperty("os.name").lowercase().contains("mac")) {
        jvmArgs("-XstartOnFirstThread")
    }
}

fun flutterBuildTarget(): String {
    val clf = project.findProperty("classifier")?.toString()
    if (!clf.isNullOrEmpty()) return clf
    val os = System.getProperty("os.name").lowercase()
    return when {
        os.contains("linux") -> "linux"
        os.contains("mac")   -> "macos"
        os.contains("win")   -> "windows"
        else -> throw GradleException("Unsupported OS: $os")
    }
}

fun nativeOsDir(): String = when (flutterBuildTarget()) {
    "linux"   -> "linux-x64"
    "macos"   -> "macos-arm64"
    "windows" -> "windows-x64"
    else -> throw GradleException("Unsupported platform: ${flutterBuildTarget()}")
}

val skipFlutter = System.getProperty("skipFlutterBuild") != null

fun flutterExecutable(): String {
    val isWindows = System.getProperty("os.name").lowercase().contains("win")
    return if (isWindows) "flutter.bat" else "flutter"
}

tasks.register<Exec>("buildFlutter") {
    group = "native"
    description = "Build Flutter widgets/example for the current platform (always re-runs)"
    workingDir = rootProject.file("widgets/example")
    commandLine(flutterExecutable(), "build", flutterBuildTarget(), "--release", "--no-tree-shake-icons")
    outputs.upToDateWhen { false }
}

tasks.register<Copy>("copyNativeLibs") {
    group = "native"
    description = "Copy platform native libs from Flutter build into jar resources"
    if (!skipFlutter) dependsOn("buildFlutter")
    val releaseDir = when (flutterBuildTarget()) {
        "linux"   -> rootProject.file("widgets/example/build/linux/x64/release/bundle/lib")
        "windows" -> rootProject.file("widgets/example/build/windows/x64/runner/Release")
        // macOS: libStarter.dylib is at Release/; frameworks are inside the .app bundle.
        // NativeLibLoader loads FlutterMacOS and widgets before libStarter so that dyld can
        // resolve their LC_LOAD_DYLIB entries without needing rpath adjustments.
        "macos"   -> rootProject.file("widgets/example/build/macos/Build/Products/Release")
        else -> throw GradleException("Unsupported OS: ${flutterBuildTarget()}")
    }
    val libs = when (flutterBuildTarget()) {
        "linux"   -> listOf("libflutter_linux_gtk.so", "libwidgets.so", "libStarter.so", "libapp.so")
        "windows" -> listOf("flutter_windows.dll", "widgets.dll", "Starter.dll")
        "macos"   -> listOf("libStarter.dylib")
        else -> throw GradleException("Unsupported OS: ${flutterBuildTarget()}")
    }
    from(releaseDir) { include(libs) }
    into(layout.buildDirectory.dir("generated/resources/main/native/${nativeOsDir()}/lib"))
}

// macOS only: copy FlutterMacOS.framework and widgets.framework binaries so they can be
// loaded via System.load() before libStarter.dylib (see NativeLibLoader macOS load order).
tasks.register<Copy>("copyMacOSFrameworkLibs") {
    group = "native"
    description = "Copy FlutterMacOS and widgets framework binaries for macOS JAR embedding"
    enabled = flutterBuildTarget() == "macos"
    if (!skipFlutter) dependsOn("buildFlutter")
    val frameworksDir = rootProject.file(
        "widgets/example/build/macos/Build/Products/Release/" +
        "widgets_example.app/Contents/Frameworks")
    from(frameworksDir) {
        include("FlutterMacOS.framework/FlutterMacOS")
        include("FlutterMacOS.framework/Resources/icudtl.dat")
        include("widgets.framework/widgets")
    }
    into(layout.buildDirectory.dir("generated/resources/main/native/${nativeOsDir()}/lib"))
}

tasks.named("processResources") {
    dependsOn("copyNativeLibs", "copyFlutterData")
    if (flutterBuildTarget() == "macos") dependsOn("copyMacOSFrameworkLibs")
}

tasks.register<Copy>("copyFlutterData") {
    group = "native"
    description = "Copy Flutter data from Flutter build into jar resources"
    if (!skipFlutter) dependsOn("buildFlutter")
    // macOS embeds Dart code and assets inside App.framework (a directory bundle), not a flat
    // data/ dir. We copy the entire framework so NativeLibLoader can pass it to FlutterDartProject.
    // Linux and Windows use a flat data/ dir with flutter_assets/ and icudtl.dat.
    when (flutterBuildTarget()) {
        "linux" -> {
            from(rootProject.file("widgets/example/build/linux/x64/release/bundle/data"))
            into(layout.buildDirectory.dir("generated/resources/main/native/${nativeOsDir()}/data"))
        }
        "macos" -> {
            from(rootProject.file(
                "widgets/example/build/macos/Build/Products/Release/" +
                "widgets_example.app/Contents/Frameworks/App.framework"))
            into(layout.buildDirectory.dir(
                "generated/resources/main/native/${nativeOsDir()}/data/App.framework"))
        }
        "windows" -> {
            from(rootProject.file("widgets/example/build/windows/x64/runner/Release/data"))
            into(layout.buildDirectory.dir("generated/resources/main/native/${nativeOsDir()}/data"))
        }
        else -> throw GradleException("Unsupported OS: ${flutterBuildTarget()}")
    }
}

// Append OS classifier to JAR name when -Pclassifier=<os> is passed (used by CI)
val classifier = project.findProperty("classifier")?.toString() ?: ""
if (classifier.isNotEmpty()) {
    tasks.jar {
        archiveClassifier.set(classifier)
    }
}

tasks.register<Exec>("jextract") {
    group = "native"
    description = "Generate Starter lib FFM bindings"
    val isWindows = System.getProperty("os.name").lowercase().contains("win")
    val home = System.getProperty("user.home")
    val jextractBin = if (isWindows) "jextract.exe" else "$home/bin/jextract-25/bin/jextract"
    executable = jextractBin
    val header = "../widgets/example/native/Starter.h"
    val output = "./src/main/java"
    args("-t", "dev.equo.ewt.ffm", "--header-class-name", "StarterBridge", "--output", output, header)
    inputs.files(header, "../widgets/src/common.h", "../widgets/src/factories.h", "../widgets/src/objects.h")
    outputs.dir("$output/dev/equo/ewt/ffm")

    doLast {
        // jextract 25 emits SymbolLookup.findOrThrow(...), which only exists in JDK 23+.
        // Rewrite it to the JDK 22-compatible find(...).orElseThrow() so the generated
        // bindings keep JDK 22 as the minimum runtime requirement.
        val ffmDir = file("$output/dev/equo/ewt/ffm")
        val pattern = Regex("""\.findOrThrow\((.*?)\)""")
        ffmDir.walkTopDown()
            .filter { it.isFile && it.extension == "java" }
            .forEach { f ->
                val text = f.readText()
                if (pattern.containsMatchIn(text)) {
                    f.writeText(pattern.replace(text) { ".find(${it.groupValues[1]}).orElseThrow()" })
                }
            }

        // jextract hardcodes C_LONG as a cast to ValueLayout.OfLong, assuming the 8-byte
        // "long" of LP64 (Linux/macOS). On Windows (LLP64), native "long" is 4 bytes, so
        // canonicalLayouts().get("long") returns an OfInt at runtime and the cast throws
        // ClassCastException during class init. Starter.h never actually uses C `long`,
        // so declare the field as the common MemoryLayout supertype instead of casting.
        val sharedFile = file("$output/dev/equo/ewt/ffm/StarterBridge\$shared.java")
        if (sharedFile.exists()) {
            val longPattern = Regex("""ValueLayout\.OfLong C_LONG = \(ValueLayout\.OfLong\) (Linker\.nativeLinker\(\)\.canonicalLayouts\(\)\.get\("long"\));""")
            val text = sharedFile.readText()
            if (longPattern.containsMatchIn(text)) {
                sharedFile.writeText(longPattern.replace(text) { "MemoryLayout C_LONG = ${it.groupValues[1]};" })
            }
        }
    }

    doFirst {
        val versionOutput = ProcessBuilder(jextractBin, "--version")
            .redirectErrorStream(true)
            .start()
            .inputStream.bufferedReader().readText()
        if (!versionOutput.trimStart().startsWith("jextract 25")) {
            throw GradleException(
                "Wrong jextract version. Expected jextract 25, got:\n$versionOutput\n" +
                "Install jextract 25 to ~/bin/jextract-25/bin/jextract\n" +
                "Download: https://jdk.java.net/jextract/"
            )
        }
    }
}

publishing {
    repositories {
        maven {
            name = "Gitlab"
            url = uri(
                "${System.getenv("CI_API_V4_URL") ?: "http://localhost"}" +
                        "/projects/${System.getenv("CI_PROJECT_ID") ?: "0"}/packages/maven"
            )
            credentials(HttpHeaderCredentials::class) {
                name = "Job-Token"
                value = System.getenv("CI_JOB_TOKEN") ?: ""
            }
            authentication {
                create<HttpHeaderAuthentication>("header")
            }
        }
    }
    publications {
        // Single publication with three classifier-distinct artifacts so a single
        // POM/module is published for dev.equo:ewt.api:VERSION. Three separate
        // publications with the same GAV would trip Gradle's duplicate-coordinates
        // warning and leave a non-deterministic POM (last-write-wins) in the registry.
        create<MavenPublication>("ewtApi") {
            groupId = "dev.equo"
            artifactId = "ewt.api"
            version = project.version.toString()
            pom {
                name.set("EWT API")
                description.set("Equo Widget Toolkit — multi-platform JARs (linux/macos/windows classifiers)")
            }
            listOf("linux", "macos", "windows").forEach { os ->
                artifact(file("build/libs/ewt.api-${project.version}-${os}.jar")) {
                    classifier = os
                }
            }
        }
    }
}

tasks.register("publishAllPlatforms") {
    group = "publishing"
    description = "Publish all three platform JARs to the configured Maven repository"
    dependsOn(tasks.withType<PublishToMavenRepository>())
}