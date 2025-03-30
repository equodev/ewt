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
    annotationProcessor(project(":annotation-processor"))
    implementation("jakarta.annotation:jakarta.annotation-api:3.0.0")
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
    }
}

tasks.test {
    useJUnitPlatform()

    systemProperty("os.name", System.getProperty("os.name"))

    if (System.getProperty("os.name").toLowerCase().contains("mac")) {
        jvmArgs("-XstartOnFirstThread")
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
