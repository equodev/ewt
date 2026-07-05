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

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    if (useLocal) {
        implementation(files(ewtApiJar))
    } else {
        implementation("dev.equo:ewt.api:${ewtApiVersion}:${currentOs}@jar")
    }
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
