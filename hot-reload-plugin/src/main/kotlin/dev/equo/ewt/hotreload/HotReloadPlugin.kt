package dev.equo.ewt.hotreload

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.JavaExec
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.api.tasks.SourceSetContainer

class HotReloadPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.tasks.register("hotRun") {
            group = "application"
            description = "Runs the EWT application with Java hot-reload enabled."

            // Depends on the standard `run` task provided by the application plugin.
            val runTask = target.tasks.named("run", JavaExec::class.java).get()
            dependsOn(runTask.taskDependencies)

            doFirst {
                // 1. Enable JDWP on the target JVM.
                val jdwp = "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=localhost:5005"
                val existingJvmArgs = runTask.jvmArgs.toMutableList()
                if (existingJvmArgs.none { it.startsWith("-agentlib:jdwp") }) {
                    existingJvmArgs.add(jdwp)
                    runTask.jvmArgs = existingJvmArgs
                }

                // 2. Auto-discover source dirs of the target module.
                val sourceSets = target.extensions.getByType(JavaPluginExtension::class.java).sourceSets
                val mainJava = sourceSets.getByName("main").java.srcDirs
                    .filter { it.exists() }
                    .map { it.absolutePath }
                    .toMutableList()
                // Also include ewt.api so contributors can edit the framework itself if desired.
                val ewtApiSrc = target.rootProject.file("ewt.api/src/main/java")
                if (ewtApiSrc.exists()) mainJava.add(ewtApiSrc.absolutePath)
                val sourceDirs = mainJava.joinToString(",")

                // 3. Compile task of the target module.
                val gradleCompileTask = "${target.path}:classes"

                // 4. Ensure the client is installed.
                target.exec {
                    workingDir = target.rootProject.projectDir
                    commandLine("./gradlew", ":hot-reload-client:installDist", "-q")
                }

                // 5. Launch the client in the background.
                val clientScript = target.rootProject.file(
                    "hot-reload-client/build/install/hot-reload-client/bin/hot-reload-client"
                )
                if (!clientScript.exists()) {
                    throw org.gradle.api.GradleException("hot-reload-client not installed at ${clientScript}")
                }

                val pb = ProcessBuilder(
                    clientScript.absolutePath,
                    "-DsourceDirs=$sourceDirs",
                    "-DclassesOutputRoot=${target.layout.buildDirectory.dir("classes/java/main").get().asFile.absolutePath}",
                    "-DprojectRoot=${target.rootProject.projectDir.absolutePath}",
                    "-DgradleCompileTask=$gradleCompileTask"
                ).inheritIO()
                pb.environment()["JAVA_HOME"] =
                    System.getenv("JAVA_HOME") ?: System.getProperty("java.home")
                val clientProcess = pb.start()

                Runtime.getRuntime().addShutdownHook(Thread {
                    clientProcess.destroy()
                })
                println("[hot-reload] Client launched (PID ${clientProcess.pid()}).")
            }

            finalizedBy(runTask)
        }
    }
}
