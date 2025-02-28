plugins {
    id("java")
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
}

tasks.test {
    useJUnitPlatform()
}