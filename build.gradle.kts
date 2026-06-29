plugins {
    kotlin("jvm") version "2.0.20"
}

group = "dev.equo"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.register("generateVersionEnv") {
    group = "versioning"
    description = "Write build/published/version.env for CI dotenv consumption"
    doLast {
        val releaseNext = project.version.toString()
        val releasePrev = try {
            providers.exec {
                commandLine("git", "describe", "--tags", "--abbrev=0", "HEAD^")
            }.standardOutput.asText.get().trim().removePrefix("v")
        } catch (e: Exception) {
            "0.0.0"
        }

        val outDir = file("$buildDir/published")
        outDir.mkdirs()
        file("$outDir/version.env").writeText(
            "RELEASE_PREV=$releasePrev\nRELEASE_NEXT=$releaseNext\n"
        )
        println("RELEASE_PREV=$releasePrev  RELEASE_NEXT=$releaseNext")
    }
}