# EWT Examples

Java examples for the Equo Widget Toolkit.

## Requirements
- JDK 23+

## Run an example

From this folder run:
```
../gradlew :examples:run                              # default: dev.equo.ide.IdeApp
../gradlew :examples:run -PmainClass=dev.equo.WidgetGallery
../gradlew :examples:run -PmainClass=dev.equo.AnimationPlaygroundDemo
../gradlew :examples:run -PmainClass=dev.equo.AnalyticsDashboard
../gradlew :examples:run -PmainClass=dev.equo.ProfileCard
```

The example downloads the latest published `ewt.api` JAR from a maven repository

## Developing against local `ewt.api`
```
./gradlew :ewt.api:jar
./gradlew :examples:run -PuseLocal=true
```
