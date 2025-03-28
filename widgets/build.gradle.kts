tasks.register<Exec>("generator") {
    group = "native"
    description = "Generate source from flutter widgets"

    executable = "/Users/guillez/bin/flutter/bin/dart"
    args("run", "tool/generator.dart")
    inputs.files("tool/generator.dart", "tool/generation_index.dart", "tool/pregeneration_index.dart")
    outputs.dirs("../ewt.api/src/main/java/dev/equo/ewt")
    outputs.files("src/factories.h", "lib/factories.dart")
    finalizedBy(ffigen, project(":ewt.api").tasks.named("jextract"))
}

val ffigen = tasks.register<Exec>("ffigen") {
    group = "native"
    description = "Generate widgets lib Dart ffigen bindings"
    
    executable = "/Users/guillez/bin/flutter/bin/dart"
    args("run", "ffigen", "--config", "ffigen.yaml")
    inputs.files("ffigen.yaml", "src/widgets.h", "src/common.h", "src/factories.h", "src/objects.h")
    outputs.file("lib/widgets_bindings_generated.dart")
}
