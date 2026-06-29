plugins {
    id("java")
    id("maven-publish")
}

group = "dev.equo"

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
        listOf("linux", "macos", "windows").forEach { os ->
            create<MavenPublication>("ewt-$os") {
                groupId = "dev.equo"
                artifactId = "ewt.api"
                version = project.version.toString()
                artifact(file("build/libs/ewt.api-${project.version}-${os}.jar")) {
                    classifier = os
                }
                pom {
                    name.set("EWT API ($os)")
                    description.set("Equo Widget Toolkit — $os platform JAR")
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