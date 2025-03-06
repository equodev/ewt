tasks.register<Exec>("ffigen") {
    group = "native"
    description = "Generate widgets lib Dart ffigen bindings"
    
    executable = "dart"
    args("run", "ffigen", "--config", "ffigen.yaml")
    inputs.files("ffigen.yaml", "src/*.h")
    outputs.file("lib/widgets_bindings_generated.dart")
}
