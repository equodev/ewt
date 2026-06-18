tasks.register<Exec>("generator") {
    group = "native"
    description = "Generate source from flutter widgets"

    val home = System.getProperty("user.home")
    val sep = System.getProperty("file.separator")
    val isWindows = System.getProperty("os.name").lowercase().contains("win")
    executable = if (isWindows)
        listOf(home, "flutter", "bin", "dart.bat").joinToString(sep)
    else
        listOf(home, "bin", "flutter", "bin", "dart").joinToString(sep)
    args("run", "bin/generator.dart")
    inputs.dir("lib")
    inputs.file("bin/generator.dart")
    outputs.dirs("../ewt.api/src/main/java/dev/equo/ewt")
    outputs.files("../widgets/src/factories.h", "../widgets/lib/factories_gen.dart")
    finalizedBy(project(":widgets").tasks.named("ffigen"),
        project(":ewt.api").tasks.named("jextract")
        /*,project(":widgets").tasks.named("native")*/
        /*project(":ewt.api").tasks.named("processCustom")*/)
}
