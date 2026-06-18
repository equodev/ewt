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

    if (System.getProperty("os.name").toLowerCase().contains("mac")) {
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

tasks.register<Copy>("copyNativeLibs") {
    group = "native"
    description = "Copy platform native libs from Flutter build into jar resources"
    val os = System.getProperty("os.name").lowercase()
    val (libDir, libs) = when {
        os.contains("linux") -> Pair(
            rootProject.file("widgets/example/build/linux/x64/release/bundle/lib"),
            listOf("libflutter_linux_gtk.so", "libwidgets.so", "libStarter.so", "libapp.so")
        )
        os.contains("mac") -> Pair(
            // NOTE: macOS support is a stub — FlutterMacOS.framework and widgets.framework
            // are directory trees, not flat files. Full macOS extraction is tracked in Open Questions.
            rootProject.file("widgets/example/build/macos/Build/Products/Release"),
            listOf("libStarter.dylib")
        )
        os.contains("win") -> Pair(
            rootProject.file("widgets/example/build/windows/x64/runner/Release"),
            listOf("flutter_windows.dll", "widgets.dll", "Starter.dll")
        )
        else -> throw GradleException("Unsupported OS: $os")
    }
    onlyIf { libDir.exists() }
    from(libDir) { include(libs) }
    into("src/main/resources/native/${nativeOsDir()}")
}

tasks.named("processResources") {
    dependsOn("copyNativeLibs", "copyFlutterData")
}

tasks.register<Copy>("copyFlutterData") {
    group = "native"
    description = "Copy Flutter assets and ICU data from Flutter build into jar resources"
    val os = System.getProperty("os.name").lowercase()
    val dataDir = when {
        os.contains("linux") ->
            rootProject.file("widgets/example/build/linux/x64/release/bundle/data")
        os.contains("mac") ->
            // STUB: macOS data path TBD — see Open Questions in embedded-native-libs plan
            rootProject.file("widgets/example/build/macos/Build/Products/Release/data")
        os.contains("win") ->
            rootProject.file("widgets/example/build/windows/x64/runner/Release/data")
        else -> throw GradleException("Unsupported OS: $os")
    }
    onlyIf { dataDir.exists() }
    from(dataDir)
    into("src/main/resources/flutter_data/${nativeOsDir()}")
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
    description = "Generate Starter lib FFM bindiings"
    executable = "${System.getenv("HOME")}/bin/jextract-22/bin/jextract"
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