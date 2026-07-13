plugins {
    id("java")
    application
}

group = "dev.equo"
version = "1.0-SNAPSHOT"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
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
