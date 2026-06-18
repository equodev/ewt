plugins {
    id("java")
    id("maven-publish")
}

group = "dev.equo"
version = "1.0-SNAPSHOT"

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

tasks.test {
    useJUnitPlatform()

    systemProperty("os.name", System.getProperty("os.name"))

    if (System.getProperty("os.name").lowercase().contains("mac")) {
        jvmArgs("-XstartOnFirstThread")
    }
}

fun nativeOsDir(): String {
    val os = System.getProperty("os.name").lowercase()
    return when {
        os.contains("linux") -> "linux-x64"
        os.contains("mac")   -> "macos-arm64"
        os.contains("win")   -> "windows-x64"
        else -> throw GradleException("Unsupported OS: $os")
    }
}

fun flutterBuildTarget(): String {
    val os = System.getProperty("os.name").lowercase()
    return when {
        os.contains("linux") -> "linux"
        os.contains("mac")   -> "macos"
        os.contains("win")   -> "windows"
        else -> throw GradleException("Unsupported OS: $os")
    }
}

fun flutterExecutable(): String {
    val isWindows = System.getProperty("os.name").lowercase().contains("win")
    return if (isWindows) "flutter.bat" else "flutter"
}

tasks.register<Exec>("buildFlutter") {
    group = "native"
    description = "Build Flutter widgets/example for the current platform (always re-runs)"
    workingDir = rootProject.file("widgets/example")
    commandLine(flutterExecutable(), "build", flutterBuildTarget(), "--release")
    outputs.upToDateWhen { false }
}

tasks.register<Copy>("copyNativeLibs") {
    group = "native"
    description = "Copy platform native libs from Flutter build into jar resources"
    dependsOn("buildFlutter")
    val (libDir, libs) = when (flutterBuildTarget()) {
        "linux" -> Pair(
            rootProject.file("widgets/example/build/linux/x64/release/bundle/lib"),
            listOf("libflutter_linux_gtk.so", "libwidgets.so", "libStarter.so", "libapp.so")
        )
        "macos" -> Pair(
            // NOTE: macOS — FlutterMacOS.framework and widgets.framework are directory trees,
            // not flat files; full macOS extraction needs more work.
            rootProject.file("widgets/example/build/macos/Build/Products/Release"),
            listOf("libStarter.dylib")
        )
        "windows" -> Pair(
            rootProject.file("widgets/example/build/windows/x64/runner/Release"),
            listOf("flutter_windows.dll", "widgets.dll", "Starter.dll")
        )
        else -> throw GradleException("Unsupported OS: ${flutterBuildTarget()}")
    }
    from(libDir) { include(libs) }
    into(layout.buildDirectory.dir("generated/resources/main/native/${nativeOsDir()}/lib"))
}

tasks.named("processResources") {
    dependsOn("copyNativeLibs", "copyFlutterData")
}

tasks.register<Copy>("copyFlutterData") {
    group = "native"
    description = "Copy Flutter assets and ICU data from Flutter build into jar resources"
    dependsOn("buildFlutter")
    val dataDir = when (flutterBuildTarget()) {
        "linux"   -> rootProject.file("widgets/example/build/linux/x64/release/bundle/data")
        "macos"   -> rootProject.file("widgets/example/build/macos/Build/Products/Release/data")
        "windows" -> rootProject.file("widgets/example/build/windows/x64/runner/Release/data")
        else -> throw GradleException("Unsupported OS: ${flutterBuildTarget()}")
    }
    from(dataDir)
    into(layout.buildDirectory.dir("generated/resources/main/native/${nativeOsDir()}/data"))
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
    executable = if (isWindows) "jextract.exe" else "jextract"
    val header = "../widgets/example/native/Starter.h"
    val output = "./src/main/java"
    args("-t", "dev.equo.ewt.ffm", "--header-class-name", "StarterBridge", "--output", output, header)
    inputs.files(header, "../widgets/src/common.h", "../widgets/src/factories.h", "../widgets/src/objects.h")
    outputs.dir("$output/dev/equo/ewt/ffm")
}

publishing {
    publications {
        create<MavenPublication>("ewt") {
            from(components["java"])
        }
    }
}