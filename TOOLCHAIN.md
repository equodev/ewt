# Toolchain Versions

External tools required to build and run the code generation pipeline.
Library dependencies are locked in `pubspec.lock` and Gradle files.

| Tool | Version | Required by | Install path |
|------|---------|-------------|--------------|
| Flutter | 3.32.2 | `:generator:generator`, `:widgets:ffigen` | `~/bin/flutter` |
| Dart | 3.8.1 | bundled with Flutter | — |
| JDK | 23.0.2 (Temurin) | `:ewt.api:build`, `:annotation-processor` | `~/bin/jdk-23` |
| jextract | 22 | `:ewt.api:jextract` | `~/bin/jextract-22` |
| Clang | 22.x | `:widgets:ffigen` (via libclang) | system (`pacman -S clang`) |
| Gradle | 8.10.2 | all tasks | via wrapper (`./gradlew`) |

## Notes

- **Flutter version is critical**: the generator reads Flutter widget sources via the Dart analyzer.
  Regenerating with a different Flutter version will produce different output files.
  All committed generated files under `ewt.api/src/` and `widgets/` were produced with Flutter 3.32.2.

- **jextract must be version 22**: it generates Java FFM bindings from `Starter.h`.
  The expected path is `~/bin/jextract-22/bin/jextract`.
  Download from: https://jdk.java.net/jextract/

- **JDK 23+ is required**: the annotation processor uses `Elements.getFileObjectOf()` (added JDK 23)
  and `Messager.printNote()` (added JDK 21). Pass via `JAVA_HOME=/home/equo/bin/jdk-23 ./gradlew ...`
  until a toolchain is configured in Gradle.

- **Clang system headers**: on Linux, ffigen needs Clang's resource include directory.
  This is already configured in `widgets/ffigen.yaml` via `-isystem`.
  If you upgrade Clang, update the version path in that file.
