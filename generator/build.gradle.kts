tasks.register<Exec>("generator") {
    group = "native"
    description = "Generate source from flutter widgets"

    executable = "/Users/guillez/bin/flutter/bin/dart"
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
