plugins {
    id("java")
    application
}

group = "dev.equo"
version = "1.0-SNAPSHOT"

tasks.withType<JavaCompile>().configureEach {
    options.release.set(22)
}

repositories {
    mavenCentral()
}

application {
    mainClass = "dev.equo.ewt.hotreload.Main"
    applicationDefaultJvmArgs = listOf(
        "--add-modules", "jdk.jdi"
    )
}
