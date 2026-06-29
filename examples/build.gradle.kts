plugins {
    id("java")
    application
}

group = "dev.equo"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val ewtApiJar = rootProject.file("ewt.api/build/libs/ewt.api-${rootProject.version}.jar")

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    implementation(files(ewtApiJar))
}

tasks.test {
    useJUnitPlatform()
}

application {
    mainClass = providers.gradleProperty("mainClass").getOrElse("dev.equo.Counter")
    applicationDefaultJvmArgs = listOf(
        "--enable-native-access=ALL-UNNAMED"
    )
}

tasks.named<JavaExec>("run") {
    environment("EWT_HOME", System.getenv("EWT_HOME") ?: rootProject.projectDir.absolutePath)
    doFirst {
        if (!ewtApiJar.exists()) {
            throw GradleException(
                "ewt.api jar not found at ${ewtApiJar.absolutePath}. " +
                "Build it first with: ./gradlew :ewt.api:jar"
            )
        }
    }
}