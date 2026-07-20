plugins {
    id("java")
    application
    id("dev.equo.ewt.hot-reload")
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

// EWT ↔ Evolve integration (dependency direction EWT → Evolve). Location of the sibling
// swt-evolve repo (defaults to the conventional sibling layout; override with
// -PevolveHome=<path>) + the EWT-owned combined binary (built from ../evolve-app).
// NOTE: the integration sample (EvolveEwtButtons) uses API that only exists in the LOCAL
// ewt.api on this branch — build with -PuseLocal=true until ewt.api republishes. The
// integration is fail-safe: without swt-evolve it is dropped (see evolveAvailable below).
// Locate the sibling swt-evolve repo. -PevolveHome wins; otherwise probe the conventional dev
// layouts — a true sibling of this repo (../swt-evolve) or one level up (../../swt-evolve) —
// picking the first that actually holds swt-evolve (swt_native/). Falls back to the sibling
// location so the "not found" error points at the natural spot.
val evolveHome = ((project.findProperty("evolveHome") as String?)
    ?.let { rootProject.projectDir.resolve(it) }
    ?: listOf("../swt-evolve", "../../swt-evolve")
        .map { rootProject.projectDir.resolve(it) }
        .firstOrNull { it.resolve("swt_native").isDirectory }
    ?: rootProject.projectDir.resolve("../swt-evolve")).normalize()
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
val combinedBuild = rootProject.projectDir.resolve("evolve-app/build")

// The integration is optional: the sibling swt-evolve build may not be checked out. When
// its jar is absent, the plain (non-Evolve) examples must still build — so the integration
// sources (which extend/import Evolve's org.eclipse.swt.* types) and the Evolve dependency
// are wired in ONLY when the jar exists, and runEvolveEwtDev fails with a clear message instead
// of a cryptic compile error.
val evolveAvailable = evolveJar.exists()

// EwtWidget lives in ewt.api's `evolve` source set (it ships in the ewt-evolve jar). These are
// its compiled classes — used to compile EvolveEwtButtons and to run the dev demo, WITHOUT
// pulling the Flutter combined-bundle build that the ewt-evolve jar requires.
val evolveClasses = if (evolveAvailable)
    files(rootProject.file("ewt.api/build/classes/java/evolve")) { builtBy(":ewt.api:compileEvolveJava") }
else files()

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    if (useLocal) {
        // builtBy so :examples:compileJava declares its dependency on the jar task — otherwise
        // Gradle flags an implicit dependency when both run in one invocation (as CI does).
        implementation(files(ewtApiJar) { builtBy(":ewt.api:jar") })
    } else {
        implementation("dev.equo:ewt.api:${ewtApiVersion}:${currentOs}@jar")
    }
    // Evolve = the swt.jar replacement (locally-built jar; carries the Evolve-side changes:
    // EwtWidget routing + the loader override). Wired only when the sibling build is present.
    if (evolveAvailable) {
        implementation(files(evolveJar))
        // EwtWidget now lives in ewt.api's evolve source set (ships in the ewt-evolve jar).
        // Compile EvolveEwtButtons against those classes; the bundle-carrying jar itself is only
        // needed at run time (see the run tasks).
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
// emits the merged Dart snapshot + flutter_assets; the widgets native lib is built directly from
// widgets/src; the two are arranged into the loader-expected layout, which mirrors each Flutter
// desktop embedder's convention — bundle/{lib,data} on Linux, <Release>/data on Windows,
// .app/Contents/Frameworks on macOS. Evolve supplies the native bridge/engine at runtime.
tasks.register<Exec>("buildCombinedBundle") {
    group = "examples"
    description = "Assemble the EWT+Evolve combined Dart bundle (no runner)."
    val appDir = rootProject.projectDir.resolve("evolve-app")
    workingDir = appDir
    val widgetsSrc = rootProject.projectDir.resolve("widgets/src")
    val widgetsBuild = rootProject.projectDir.resolve("widgets/build/native")
    if (currentOs == "macos") {
        // macOS does NOT use the Linux/Windows bundle/{lib,data} layout. Flutter emits the
        // merged Dart AOT snapshot as the `App` binary inside App.framework, plus a separate
        // FlutterMacOS.framework (engine + icudtl.dat). The Dart target that produces this
        // framework layout is release_macos_bundle_flutter_assets. Arch follows the host JVM.
        val darwinArch = if (System.getProperty("os.arch").lowercase().contains("aarch64")) "arm64" else "x86_64"
        commandLine(
            "bash", "-lc",
            "flutter pub get && flutter assemble --no-version-check --output=build " +
            "-dTargetPlatform=darwin -dDarwinArchs=$darwinArch -dBuildMode=release " +
            "-dTargetFile=lib/main.dart -dTreeShakeIcons=false " +
            "release_macos_bundle_flutter_assets"
        )
        doLast {
            // libwidgets.dylib (standalone C FFI lib, no engine/runner)
            exec { commandLine("cmake", "-S", widgetsSrc, "-B", widgetsBuild, "-DCMAKE_BUILD_TYPE=Release") }
            exec { commandLine("cmake", "--build", widgetsBuild) }
            // Arrange the layout Evolve+EWT expect: everything under
            // swtflutter.app/Contents/Frameworks, matching FlutterLibraryLoader.SWTFLUTTER_APP_CONTENTS
            // and the native bridge's bundleBase() + "/Frameworks/App.framework".
            val contents = appDir.resolve("build/macos/Build/Products/Release/swtflutter.app/Contents")
            val frameworks = contents.resolve("Frameworks").apply { mkdirs() }
            // App.framework (Dart AOT snapshot + flutter_assets) and FlutterMacOS.framework
            // (engine + Resources/icudtl.dat) come straight from assemble's output root.
            copy { from(appDir.resolve("build/App.framework")); into(frameworks.resolve("App.framework")) }
            copy { from(appDir.resolve("build/FlutterMacOS.framework")); into(frameworks.resolve("FlutterMacOS.framework")) }
            // The EWT FFI plugin: package the cmake dylib as widgets.framework/widgets — the path
            // EWT's NativeLibLoader attach-loads and widgets.dart's DynamicLibrary.open resolves.
            val widgetsFw = frameworks.resolve("widgets.framework").apply { mkdirs() }
            copy { from(widgetsBuild.resolve("libwidgets.dylib")); into(widgetsFw); rename { "widgets" } }
            // Set the install name (LC_ID_DYLIB) to the EXACT relative string widgets.dart opens
            // ("widgets.framework/widgets"), NOT @rpath/…. NativeLibLoader preloads this dylib by
            // absolute path; the embedded Evolve process has no cwd/rpath pointing at Frameworks/,
            // so the later DynamicLibrary.open('widgets.framework/widgets') can only resolve by
            // matching an already-loaded image's install name verbatim. Nothing links widgets via
            // LC_LOAD_DYLIB (it is only ever dlopen'd), so a relative id is safe here.
            exec {
                commandLine(
                    "install_name_tool", "-id", "widgets.framework/widgets",
                    widgetsFw.resolve("widgets").absolutePath)
            }
        }
    } else if (currentOs == "windows") {
        // 1) merged Dart snapshot + assets (no runner/CMake)
        commandLine(
            "cmd", "/c",
            "flutter pub get && flutter assemble --no-version-check --output=build " +
            "-dTargetPlatform=windows-x64 -dBuildMode=release " +
            "-dTargetFile=lib/main.dart -dTreeShakeIcons=false " +
            "release_bundle_windows-x64_assets"
        )
        doLast {
            // 2) widgets.dll (standalone C lib, no engine/runner). MSVC is a multi-config
            // generator: the build config goes on `--build`, not `-DCMAKE_BUILD_TYPE`, and the
            // binary lands under a Release/ subdir.
            exec { commandLine("cmake", "-S", widgetsSrc, "-B", widgetsBuild, "-DCMAKE_BUILD_TYPE=Release") }
            exec { commandLine("cmake", "--build", widgetsBuild, "--config", "Release") }
            // 3) arrange the loader-expected layout:
            // evolve-app/build/windows/x64/runner/Release/data. Unlike Linux there is NO bundle/
            // wrapper: the Windows Evolve bridge creates its DartProject at <base>/data, so the
            // AOT snapshot, flutter_assets and icudtl.dat all live directly under data/.
            // widgets.dll (EWT's own lib, attach-loaded by NativeLibLoader via System.load by
            // absolute path) is placed here too, so the whole payload is the single data/ dir.
            val release = appDir.resolve("build/windows/x64/runner/Release")
            val dataDir = release.resolve("data").apply { mkdirs() }
            // Real assemble output paths (verified on Windows):
            //  - app.so (no "lib" prefix on Windows) lands in build/windows/ (NOT build/lib/)
            //  - flutter_assets lands in build/flutter_assets/ (same as Linux)
            //  - icudtl.dat is NOT emitted by assemble; source it from the engine cache
            copy { from(appDir.resolve("build/windows/app.so")); into(dataDir) }
            copy { from(widgetsBuild.resolve("Release/widgets.dll")); into(dataDir) }
            copy { from(appDir.resolve("build/flutter_assets")); into(dataDir.resolve("flutter_assets")) }
            val flutterRoot = System.getenv("FLUTTER_ROOT")
                ?: file(System.getProperty("user.home")).resolve("flutter").absolutePath
            copy {
                from(file(flutterRoot).resolve("bin/cache/artifacts/engine/windows-x64/icudtl.dat"))
                into(dataDir)
            }
        }
    } else {
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
            val icudtl = file(flutterRoot).resolve("bin/cache/artifacts/engine/linux-x64/icudtl.dat")
            // Fail loudly: a missing source makes `copy` a silent no-op, shipping a bundle that
            // builds green but aborts at runtime on ICU init. Set FLUTTER_ROOT to the Flutter SDK.
            if (!icudtl.exists())
                throw GradleException("icudtl.dat not found at $icudtl — set FLUTTER_ROOT correctly.")
            copy { from(icudtl); into(dataDir) }
        }
    }
}

// EWT ↔ Evolve same-surface demo — DEV mode (fast local iteration). An EWT card inside an
// Evolve window, one shared Flutter engine. The ONLY difference vs runEvolveEwtPackaged below
// is where the combined bundle comes from: this task shortcuts straight to the dev build dir
// (dev.equo.ewt.bundleDir=evolve-app/build) and runs against the compiled evolve classes, so
// it needs NO ewt-evolve jar. runEvolveEwtPackaged is the PRODUCTION path: no property, the
// bundle is discovered+extracted from the ewt-evolve jar via SPI (what a real RCP does).
// Prereqs:
//   1. build the combined bundle:  ./gradlew :examples:buildCombinedBundle -PuseLocal=true
//   2. build the FULL Evolve jar (with its own native bridge/engine, NOT -DskipFlutterLib):
//                                  (swt-evolve) ./gradlew :swt_native:linux-x86_64Jar
//      Evolve now loads its OWN bridge/engine from that jar and is pointed at EWT's external
//      combined bundle via dev.equo.ewt.bundleDir. The old -DskipFlutterLib dev-mode path no
//      longer applies: the property names the external bundle, not Evolve's own natives.
//   3. build the local ewt.api jar and run with -PuseLocal=true
tasks.register<JavaExec>("runEvolveEwtDev") {
    group = "examples"
    description = "EWT ↔ Evolve same-surface (DEV): bundle from the dev build dir via the property."
    dependsOn("buildCombinedBundle")
    // EwtWidget at run time comes from the evolve classes (dev mode uses the dev build dir for
    // the bundle, so it does not need the ewt-evolve jar).
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
    // macOS: Evolve's window controller bootstraps NSApp and sets the main menu, which Cocoa
    // only allows on the first thread — so the JVM must own it (as the `run` task already does).
    // We pass -XstartOnFirstThread here, so also signal NativeLibLoader that the first-thread
    // requirement is already met: otherwise it self-relaunches a second JVM to add the flag
    // itself, leaving a phantom waiter process and an unclean shutdown.
    if (currentOs == "macos") {
        jvmArgs("-XstartOnFirstThread")
        environment("_EWT_MACOS_RELAUNCHED", "1")
    }
}

// EWT ↔ Evolve same-surface — PACKAGED (production) mode. Proves the real RCP path: no dev
// build dir and no property set — the combined bundle is discovered via SPI from the
// self-contained ewt-evolve jar and extracted to ~/.equo/ewt. Contrast runEvolveEwtDev above,
// which shortcuts to the dev build dir via the property.
val ewtEvolveJar = rootProject.file(
    "ewt.api/build/libs/ewt-evolve-${rootProject.version}-${currentOs}.jar")

tasks.register<JavaExec>("runEvolveEwtPackaged") {
    group = "examples"
    description = "EWT ↔ Evolve packaged-mode: bundle discovered via SPI, extracted to ~/.equo/ewt."
    // Guarded: the ewtEvolveJar task only exists when swt-evolve is present (fail-safe).
    if (evolveAvailable) dependsOn(":ewt.api:ewtEvolveJar")
    // The RCP contract: exactly the two library jars (ewt-evolve + Evolve) plus the example
    // classes. Deliberately NOT the base ewt.api — ewt-evolve carries the EWT toolkit itself,
    // and the two must not share a classpath (both define dev.equo.ewt.*).
    classpath = sourceSets["main"].output + files(evolveJar) + files(ewtEvolveJar)
    mainClass.set("dev.equo.EvolveEwtButtons")
    doFirst {
        if (!evolveAvailable) {
            throw GradleException("swt-evolve build not found at ${evolveJar.absolutePath}.")
        }
        if (!ewtEvolveJar.exists()) {
            throw GradleException("ewt-evolve jar not found: build :ewt.api:ewtEvolveJar first.")
        }
    }
    systemProperty("dev.equo.swt.mode", "desktop")
    systemProperty("dev.equo.swt.crashReport.disabled", "true")
    // NOTE: intentionally NO dev.equo.ewt.bundleDir — the SPI provider supplies it.
    jvmArgs("--enable-native-access=ALL-UNNAMED")
    // macOS: Evolve's window controller bootstraps NSApp and sets the main menu, which Cocoa
    // only allows on the first thread — so the JVM must own it (as the `run` task already does).
    // We pass -XstartOnFirstThread here, so also signal NativeLibLoader that the first-thread
    // requirement is already met: otherwise it self-relaunches a second JVM to add the flag
    // itself, leaving a phantom waiter process and an unclean shutdown.
    if (currentOs == "macos") {
        jvmArgs("-XstartOnFirstThread")
        environment("_EWT_MACOS_RELAUNCHED", "1")
    }
}
