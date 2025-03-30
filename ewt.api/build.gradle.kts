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

//tasks.withType<JavaCompile>().configureEach {
    // Disable annotation processing in the main compile task
//    options.compilerArgs.add("-proc:none")
//}

// Create a task for Immutables processing
val processImmutables = tasks.register<JavaCompile>("processImmutables") {
    source = sourceSets.main.get().java
    classpath = sourceSets.main.get().compileClasspath
    destinationDirectory.set(layout.buildDirectory.dir("generated/sources/immutables"))
    options.annotationProcessorPath = configurations.annotationProcessor.get()
    options.compilerArgs.removeIf { it.contains("Processor") || it.startsWith("-proc") }
    options.compilerArgs.add("-processor")
    options.compilerArgs.add("org.immutables.processor.ProxyProcessor")
    // Use processor-specific output directory
    options.compilerArgs.add("-s")
    options.compilerArgs.add("${layout.buildDirectory.get()}/generated/sources/immutables")
}

// Create a task for your custom processing that depends on Immutables
val processCustom = tasks.register<JavaCompile>("processCustom") {
    // Include both original sources and immutables-generated sources
    source = sourceSets.main.get().java + fileTree("${layout.buildDirectory.get()}/generated/sources/immutables")
    classpath = sourceSets.main.get().compileClasspath
    destinationDirectory.set(layout.buildDirectory.dir("generated/sources/custom"))
    options.annotationProcessorPath = configurations.annotationProcessor.get()
    options.compilerArgs.removeIf { it.contains("Processor") || it.startsWith("-proc") }
    options.compilerArgs.clear()
    options.compilerArgs.add("-processor")
    options.compilerArgs.add("dev.equo.ewt.processor.BuilderModifierProcessor")
    options.compilerArgs.add("-s")
    options.compilerArgs.add("${layout.buildDirectory.get()}/generated/sources/custom")
    dependsOn(processImmutables)
}

// Final compilation that includes everything
tasks.named<JavaCompile>("compileJava") {
    // Include both original and all generated sources
    options.compilerArgs.add("-proc:none")
    source = sourceSets.main.get().java +
            fileTree("${layout.buildDirectory.get()}/generated/sources/immutables") +
            fileTree("${layout.buildDirectory.get()}/generated/sources/custom")
    dependsOn(processCustom)
}

// Make sure other tasks depend on the custom process
val classes = tasks.named("classes") {
    dependsOn(processCustom)
}

//tasks.withType<JavaCompile>().configureEach {
//    options.compilerArgs.add("-processor")
//    options.compilerArgs.add("org.immutables.processor.ProxyProcessor,dev.equo.BuilderModifierProcessor")
//
//    // Force incremental processing off to ensure full reprocessing
//    options.isIncremental = false
//}


// 3. Add generated source directories to your source sets
sourceSets {
    main {
        java {
            srcDir("${layout.buildDirectory.get()}/generated/sources/immutables")
            srcDir("${layout.buildDirectory.get()}/generated/sources/custom")
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
