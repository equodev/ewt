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
val evolveFatJar = evolveRepo.resolve("swt_native/build/libs/swt_evolve-linux-x86_64.jar")
val evolveNatives = evolveRepo.resolve("swt_native/build/natives/linux-x86_64")
val combinedBuild = rootProject.projectDir.resolve("evolve-app/build")

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    if (useLocal) {
        implementation(files(ewtApiJar))
    } else {
        implementation("dev.equo:ewt.api:${ewtApiVersion}:${currentOs}@jar")
    }
    // Evolve = the swt.jar replacement (locally-built fat jar; carries the Evolve-side
    // changes: EwtWidget routing + the loader override).
    implementation(files(evolveFatJar))
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
// one shared Flutter engine. Runs the EWT-authored sample against Evolve (the fat jar) with
// the EWT-owned combined binary. Prereqs (see spec paso 4.5):
//   1. build the combined binary:  (cd evolve-app && flutter build linux --release)
//   2. build the Evolve fat jar:   (swt-evolve) ./gradlew :swt_native:linux-x86_64Jar -DskipFlutterLib
//   3. extract SWT natives:        (swt-evolve) ./gradlew :swt_native:linux-x86_64ExtractNatives
//   4. build the local ewt.api jar and run with -PuseLocal=true
tasks.register<JavaExec>("runEvolveEwt") {
    group = "examples"
    description = "EWT ↔ Evolve same-surface: an EWT card inside an Evolve window."
    classpath = sourceSets["main"].runtimeClasspath
    mainClass.set("dev.equo.EvolveEwtButtons")
    systemProperty("dev.equo.swt.mode", "desktop")
    systemProperty("dev.equo.swt.crashReport.disabled", "true")
    // Point Evolve's loader at the EWT-owned combined binary (dependency EWT → Evolve).
    systemProperty("dev.equo.swt.flutterBuildDir", combinedBuild.absolutePath)
    // Attach mode: load ONLY the combined bundle's libwidgets — the same copy the engine runs.
    systemProperty("ewt.attach.libwidgets",
        combinedBuild.resolve("linux/x64/release/bundle/lib/libwidgets.so").absolutePath)
    // Evolve's DeskDisplayBridge uses the real SWT GTK native for the toplevel window.
    systemProperty("swt.library.path", evolveNatives.absolutePath)
    jvmArgs("--enable-native-access=ALL-UNNAMED")
}
