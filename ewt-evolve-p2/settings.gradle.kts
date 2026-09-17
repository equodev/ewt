// Standalone Gradle build for assembling the ewt-evolve p2 repository.
// Kept OUT of the main ewt build (not in ../settings.gradle.kts) so it can't destabilise the
// existing build/CI while workstream 10 is in review. Promote it into the main build later.
rootProject.name = "ewt-evolve-p2"
