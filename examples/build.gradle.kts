plugins {
    id("java")
    application
}

group = "dev.equo"
version = "1.0-SNAPSHOT"

val useLocal = (project.findProperty("useLocal") as String?)?.toBoolean() ?: false

val currentOs = when {
    org.gradle.internal.os.OperatingSystem.current().isWindows -> "windows"
    org.gradle.internal.os.OperatingSystem.current().isMacOsX  -> "macos"
    else                                                       -> "linux"
}

val ewtApiVersion = (project.findProperty("ewtApiVersion") as String?) ?: "+"

repositories {
    mavenCentral()
    if (!useLocal) {
        maven {
            name = "EWT GitLab Packages"
            url  = uri("https://gitlab.com/api/v4/projects/67882950/packages/maven")
            content { includeGroup("dev.equo") }
        }
    }
}

val ewtApiJar = rootProject.file("ewt.api/build/libs/ewt.api-${rootProject.version}.jar")

// EWT ↔ Evolve integration (dependency direction EWT → Evolve). Paths to the sibling
// swt-evolve repo + the EWT-owned combined binary (built from ../evolve-app).
// NOTE: the integration sample (EvolveEwtButtons) uses API that only exists in the LOCAL
// ewt.api on this branch — build with -PuseLocal=true until ewt.api republishes. The
// integration is fail-safe: without swt-evolve it is dropped (see evolveAvailable below).
val evolveRepo = rootProject.projectDir.resolve("../../swt-evolve").normalize()
val evolveJar = evolveRepo.resolve("swt_native/build/libs/swt_evolve-linux-x86_64.jar")
val combinedBuild = rootProject.projectDir.resolve("evolve-app/build")

// The integration is optional: the sibling swt-evolve build may not be checked out. When
// its jar is absent, the plain (non-Evolve) examples must still build — so the integration
// sources (which extend/import Evolve's org.eclipse.swt.* types) and the Evolve dependency
// are wired in ONLY when the jar exists, and runEvolveEwt fails with a clear message instead
// of a cryptic compile error.
val evolveAvailable = evolveJar.exists()

// EwtWidget lives in ewt.api's `evolve` source set (it ships in the evolve-bundle classifier
// jar). These are its compiled classes — used to compile EvolveEwtButtons and to run the dev
// demo, WITHOUT pulling the Flutter combined-bundle build that the classifier jar requires.
val evolveClasses = if (evolveAvailable)
    files(rootProject.file("ewt.api/build/classes/java/evolve")) { builtBy(":ewt.api:compileEvolveJava") }
else files()

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    if (useLocal) {
        implementation(files(ewtApiJar))
    } else {
        implementation("dev.equo:ewt.api:${ewtApiVersion}:${currentOs}@jar")
    }
    // Evolve = the swt.jar replacement (locally-built jar; carries the Evolve-side changes:
    // EwtWidget routing + the loader override). Wired only when the sibling build is present.
    if (evolveAvailable) {
        implementation(files(evolveJar))
        // EwtWidget now lives in ewt.api's evolve source set (ships in the evolve-bundle
        // classifier jar). Compile EvolveEwtButtons against those classes; the bundle-carrying
        // jar itself is only needed at run time (see the run tasks).
        compileOnly(evolveClasses)
    }
}

// Drop the integration-only sources when swt-evolve isn't available, so the rest of the
// examples still compile (these two extend/import Evolve's org.eclipse.swt.* types).
if (!evolveAvailable) {
    sourceSets["main"].java.exclude(
        "dev/equo/EvolveEwtButtons.java"
    )
}

tasks.test {
    useJUnitPlatform()
}

application {
    mainClass = providers.gradleProperty("mainClass").getOrElse("dev.equo.ide.IdeApp")
    applicationDefaultJvmArgs = buildList {
        add("--enable-native-access=ALL-UNNAMED")
        // macOS requires the Flutter/Cocoa run loop to own the first thread,
        // otherwise startApp crashes because it is not running on the main thread.
        if (System.getProperty("os.name").lowercase().contains("mac")) {
            add("-XstartOnFirstThread")
        }
    }
}

tasks.named<JavaExec>("run") {
    if (useLocal) {
        doFirst {
            if (!ewtApiJar.exists()) {
                throw GradleException(
                    "ewt.api jar not found at ${ewtApiJar.absolutePath}. " +
                    "Build it first with: ./gradlew :ewt.api:jar  " +
                    "(or drop -PuseLocal=true to use the published JAR)"
                )
            }
        }
    }
}

// Builds the EWT-owned combined bundle WITHOUT any per-platform runner: `flutter assemble`
// emits the merged libapp.so + flutter_assets; libwidgets.so is built directly from
// widgets/src; the two are arranged into the loader-expected bundle/{lib,data} layout.
// Evolve supplies the native bridge/engine at runtime.
tasks.register<Exec>("buildCombinedBundle") {
    group = "examples"
    description = "Assemble the EWT+Evolve combined Dart bundle (no runner)."
    val appDir = rootProject.projectDir.resolve("evolve-app")
    workingDir = appDir
    // 1) merged Dart snapshot + assets (no runner/CMake)
    commandLine(
        "bash", "-lc",
        "flutter pub get && flutter assemble --no-version-check --output=build " +
        "-dTargetPlatform=linux-x64 -dBuildMode=release " +
        "-dTargetFile=lib/main.dart -dTreeShakeIcons=false " +
        "release_bundle_linux-x64_assets"
    )
    doLast {
        // 2) libwidgets.so (standalone C lib, no engine/runner)
        val widgetsSrc = rootProject.projectDir.resolve("widgets/src")
        val widgetsBuild = rootProject.projectDir.resolve("widgets/build/native")
        exec { commandLine("cmake", "-S", widgetsSrc, "-B", widgetsBuild, "-DCMAKE_BUILD_TYPE=Release") }
        exec { commandLine("cmake", "--build", widgetsBuild) }
        // 3) arrange the loader-expected layout: evolve-app/build/linux/x64/release/bundle/{lib,data}
        val release = appDir.resolve("build/linux/x64/release")
        val libDir = release.resolve("bundle/lib").apply { mkdirs() }
        val dataDir = release.resolve("bundle/data").apply { mkdirs() }
        // Real assemble output paths (verified on Linux):
        //  - libapp.so lands in build/lib/ (NOT build/)
        //  - flutter_assets lands in build/flutter_assets/
        //  - icudtl.dat is NOT emitted by assemble; source it from the engine cache
        copy { from(appDir.resolve("build/lib/libapp.so")); into(libDir) }
        copy { from(widgetsBuild.resolve("libwidgets.so")); into(libDir) }
        copy { from(appDir.resolve("build/flutter_assets")); into(dataDir.resolve("flutter_assets")) }
        val flutterRoot = System.getenv("FLUTTER_ROOT")
            ?: file(System.getProperty("user.home")).resolve("flutter").absolutePath
        copy {
            from(file(flutterRoot).resolve("bin/cache/artifacts/engine/linux-x64/icudtl.dat"))
            into(dataDir)
        }
    }
}

// EWT ↔ Evolve same-surface demo: an EWT profile card rendered inside an Evolve window,
// one shared Flutter engine. Runs the EWT-authored sample against Evolve (the jar) with
// the EWT-owned combined binary. Prereqs:
//   1. build the combined bundle:  ./gradlew :examples:buildCombinedBundle -PuseLocal=true
//   2. build the FULL Evolve jar (with its own native bridge/engine, NOT -DskipFlutterLib):
//                                  (swt-evolve) ./gradlew :swt_native:linux-x86_64Jar
//      Evolve now loads its OWN bridge/engine from that jar and is pointed at EWT's external
//      combined bundle via dev.equo.ewt.bundleDir. The old -DskipFlutterLib dev-mode path no
//      longer applies: the property names the external bundle, not Evolve's own natives.
//   3. build the local ewt.api jar and run with -PuseLocal=true
tasks.register<JavaExec>("runEvolveEwt") {
    group = "examples"
    description = "EWT ↔ Evolve same-surface: an EWT card inside an Evolve window."
    dependsOn("buildCombinedBundle")
    // EwtWidget at run time comes from the evolve classes (dev demo uses the dev build dir for
    // the bundle, so it does not need the heavier classifier jar).
    classpath = sourceSets["main"].runtimeClasspath + evolveClasses
    mainClass.set("dev.equo.EvolveEwtButtons")
    doFirst {
        if (!evolveAvailable) {
            throw GradleException(
                "swt-evolve build not found at ${evolveJar.absolutePath}. " +
                "This demo needs the sibling swt-evolve repo built (see the prereqs above)."
            )
        }
    }
    systemProperty("dev.equo.swt.mode", "desktop")
    systemProperty("dev.equo.swt.crashReport.disabled", "true")
    // Point Evolve's loader at the EWT-owned combined binary (dependency EWT → Evolve).
    // EWT's NativeLibLoader reads this SAME property to attach-load the combined bundle's
    // libwidgets per-OS — no separate hardcoded lib path needed.
    systemProperty("dev.equo.ewt.bundleDir", combinedBuild.absolutePath)
    // No real SWT native needed: DeskDisplayBridge is 100% Flutter — it creates the toplevel
    // window via FlutterNative (JNI), and the tree is all Dart* widgets, so libswt-gtk is never
    // loaded (verified: runs with an empty swt.library.path). Hence no swt.library.path here.
    // EWT calls libwidgets via the JDK FFM (Panama) API; this flag grants the native-access
    // permission it requires (else a restricted-method warning now, a hard error in future JDKs).
    jvmArgs("--enable-native-access=ALL-UNNAMED")
}

// Packaged-mode acceptance: proves the PRODUCTION path (no dev build dir, no property set).
// The combined bundle is discovered via SPI from the evolve-bundle classifier jar and extracted
// to ~/.equo/ewt. Distinct from runEvolveEwt, which points at the dev build dir via the property.
val evolveBundleJar = rootProject.file(
    "ewt.api/build/libs/ewt.api-${rootProject.version}-evolve-bundle-linux.jar")

tasks.register<JavaExec>("runEvolveEwtPackaged") {
    group = "examples"
    description = "EWT ↔ Evolve packaged-mode: bundle discovered via SPI, extracted to ~/.equo/ewt."
    // Guarded: the evolveBundleJar task only exists when swt-evolve is present (fail-safe).
    if (evolveAvailable) dependsOn(":ewt.api:evolveBundleJar")
    // The lean base ewt.api + the classifier jar + Evolve jar + examples classes.
    classpath = sourceSets["main"].runtimeClasspath + files(evolveBundleJar)
    mainClass.set("dev.equo.EvolveEwtButtons")
    doFirst {
        if (!evolveAvailable) {
            throw GradleException("swt-evolve build not found at ${evolveJar.absolutePath}.")
        }
        if (!evolveBundleJar.exists()) {
            throw GradleException("evolve-bundle jar not found: build :ewt.api:evolveBundleJar first.")
        }
    }
    systemProperty("dev.equo.swt.mode", "desktop")
    systemProperty("dev.equo.swt.crashReport.disabled", "true")
    // NOTE: intentionally NO dev.equo.ewt.bundleDir — the SPI provider supplies it.
    jvmArgs("--enable-native-access=ALL-UNNAMED")
}
