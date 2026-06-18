
val isWindows = System.getProperty("os.name").lowercase().contains("win")
val home = System.getProperty("user.home")
val sep = System.getProperty("file.separator")
val dartExecutable = if (isWindows)
    listOf(home, "flutter", "bin", "dart.bat").joinToString(sep)
else
    listOf(home, "bin", "flutter", "bin", "dart").joinToString(sep)
val flutterExecutable = if (isWindows)
    listOf(home, "flutter", "bin", "flutter.bat").joinToString(sep)
else
    listOf(home, "bin", "flutter", "bin", "flutter").joinToString(sep)

val ffigen = tasks.register<Exec>("ffigen") {
    group = "native"
    description = "Generate widgets lib Dart ffigen bindings"

    executable = dartExecutable
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
    executable = flutterExecutable
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