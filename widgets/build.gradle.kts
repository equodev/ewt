
val ffigen = tasks.register<Exec>("ffigen") {
    group = "native"
    description = "Generate widgets lib Dart ffigen bindings"
    
    executable = "/Users/guillez/bin/flutter/bin/dart"
    args("run", "ffigen", "--config", "ffigen.yaml")
    inputs.file("ffigen.yaml")
    inputs.dir("src")
    outputs.file("lib/widgets_bindings_generated.dart")
}

val os = getOS(if (project.hasProperty("os")) project.property("os").toString() else System.getProperty("os.name"))

//tasks.register<Exec>("web") {
//    group = "flutter"
//    executable = "flutter"
//    args("build", "web", "-d", "chrome")
//    inputs.dir("lib")
//    outputs.dir("build/web")
//}

tasks.register<Exec>("native") {
    println("path: "+System.getenv("PATH"))
    group = "Flutter"
    executable = "${System.getProperty("user.home")}/bin/flutter/bin/flutter"
    args("build", os, "--release", "--no-tree-shake-icons")
    workingDir("example")
    inputs.dir("lib")
    outputs.dir("build/$os")

}

fun getOS(os: String) = when {
    os.lowercase().contains("win") -> "windows"
    os.lowercase().contains("mac") -> "macos"
    else -> "linux"
}