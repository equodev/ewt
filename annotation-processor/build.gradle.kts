plugins {
    id("java")
}

group = "dev.equo"
version = "1.0-SNAPSHOT"

// Target JDK 22 bytecode so this build-time processor stays loadable on JDK 22 toolchains too.
tasks.withType<JavaCompile>().configureEach {
    options.release.set(22)
}

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("com.google.auto.service:auto-service-annotations:1.0.1")
    annotationProcessor("com.google.auto.service:auto-service:1.0.1")

    implementation("javax.annotation:javax.annotation-api:1.3.2")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}