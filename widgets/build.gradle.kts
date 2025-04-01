
val ffigen = tasks.register<Exec>("ffigen") {
    group = "native"
    description = "Generate widgets lib Dart ffigen bindings"
    
    executable = "/Users/guillez/bin/flutter/bin/dart"
    args("run", "ffigen", "--config", "ffigen.yaml")
    inputs.file("ffigen.yaml")
    inputs.dir("src")
    outputs.file("lib/widgets_bindings_generated.dart")
}
