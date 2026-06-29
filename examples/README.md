# EWT Examples

Java examples for the Equo Widget Toolkit.

## Requirements
- JDK 21+
- Linux, macOS, or Windows

## Run an example
```
./gradlew :examples:run                              # default: dev.equo.Counter
./gradlew :examples:run -PmainClass=dev.equo.HelloWorld
./gradlew :examples:run -PewtApiVersion=0.1.0        # pin a specific version
```

The example downloads the latest published `ewt.api` JAR from GitLab Packages —
no local Flutter/Dart build required.

## Developing against local `ewt.api`
```
./gradlew :ewt.api:jar
./gradlew :examples:run -PuseLocal=true
```
