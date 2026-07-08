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
// NOTE: the integration sources (EwtWidget, EvolveEwtButtons) call App.registerBuilder,
// which only exists in the LOCAL ewt.api on this branch — build examples with
// -PuseLocal=true until ewt.api republishes.
val evolveRepo = rootProject.projectDir.resolve("../../swt-evolve").normalize()
val evolveJar = evolveRepo.resolve("swt_native/build/libs/swt_evolve-linux-x86_64.jar")
val combinedBuild = rootProject.projectDir.resolve("evolve-app/build")

// The integration is optional: the sibling swt-evolve build may not be checked out. When
// its jar is absent, the plain (non-Evolve) examples must still build — so the integration
// sources (which extend/import Evolve's org.eclipse.swt.* types) and the Evolve dependency
// are wired in ONLY when the jar exists, and runEvolveEwt fails with a clear message instead
// of a cryptic compile error.
val evolveAvailable = evolveJar.exists()

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
    }
}

// Drop the integration-only sources when swt-evolve isn't available, so the rest of the
// examples still compile (these two extend/import Evolve's org.eclipse.swt.* types).
if (!evolveAvailable) {
    sourceSets["main"].java.exclude(
        "org/eclipse/swt/widgets/EwtWidget.java",
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

// EWT ↔ Evolve same-surface demo: an EWT profile card rendered inside an Evolve window,
// one shared Flutter engine. Runs the EWT-authored sample against Evolve (the jar) with
// the EWT-owned combined binary. Prereqs (see spec paso 4.5):
//   1. build the combined binary:  (cd evolve-app && flutter build linux --release)
//   2. build the Evolve jar:       (swt-evolve) ./gradlew :swt_native:linux-x86_64Jar -DskipFlutterLib
//   3. build the local ewt.api jar and run with -PuseLocal=true
tasks.register<JavaExec>("runEvolveEwt") {
    group = "examples"
    description = "EWT ↔ Evolve same-surface: an EWT card inside an Evolve window."
    classpath = sourceSets["main"].runtimeClasspath
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
    // libwidgets per-OS — no separate hardcoded lib path needed (boss review ②).
    systemProperty("dev.equo.swt.flutterBuildDir", combinedBuild.absolutePath)
    // No real SWT native needed: DeskDisplayBridge is 100% Flutter — it creates the toplevel
    // window via FlutterNative (JNI), and the tree is all Dart* widgets, so libswt-gtk is never
    // loaded (verified: runs with an empty swt.library.path). Hence no swt.library.path here.
    jvmArgs("--enable-native-access=ALL-UNNAMED")
}
