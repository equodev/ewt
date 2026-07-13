plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
}

group = "dev.equo.ewt"
version = "0.1.0"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

repositories {
    mavenCentral()
    gradlePluginPortal()
}

gradlePlugin {
    plugins {
        create("hotReload") {
            id = "dev.equo.ewt.hot-reload"
            implementationClass = "dev.equo.ewt.hotreload.HotReloadPlugin"
        }
    }
}
