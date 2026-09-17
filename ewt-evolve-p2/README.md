# ewt-evolve-p2 — CLI-installable feature + p2 repo (scaffolding)

Scaffolding for **workstream 10** of the EWT↔Evolve integration: publish ewt+evolve as a
**p2 repository with a feature** so `equo modernize` can install it via p2director (the CLI
installs features, not maven jars).

Full design + requirements + open questions: **`../ewt-evolve-p2-distribution-spec.md`**.

> ⚠️ **Not wired into the Gradle build yet.** These are standalone artifacts under review.
> Nothing here is referenced by `settings.gradle.kts`, so it does not affect the existing
> build/CI. Wiring happens once the open questions (esp. Q1) are settled.

## Layout

```
ewt-evolve-p2/
├── demo/                       # dev.equo.ewt.evolve.demo — RCP plugin with the showcase view
│   ├── META-INF/MANIFEST.MF    #   OSGi bundle manifest (imports dev.equo.ewt + org.eclipse.swt.widgets)
│   ├── plugin.xml              #   org.eclipse.ui.views extension → EwtShowcaseView
│   ├── build.properties
│   └── src/.../EwtShowcaseView.java   # ViewPart.createPartControl mounts an EwtWidget
├── feature/                    # dev.equo.ewt.evolve.feature
│   ├── feature.xml             #   includes the ewt-evolve fragment + the demo plugin
│   ├── p2.inf                  #   EXACT-Evolve-version requires (tokens filled by the build)
│   └── build.properties
├── category.xml                # p2 category for the feature
└── README.md
```

## The two things this scaffolding encodes

1. **The demo plugin with a view** (requirement 1b) — a real Eclipse `ViewPart` that mounts an
   `EwtWidget`, so after a p2 install you can open *Window → Show View → EWT → EWT Showcase* and
   see the Flutter subtree render inside the target RCP.

2. **The exact-Evolve pin** (requirement 2) — `feature/p2.inf` adds a p2 `requires` with range
   `[X,X]` to the Evolve IU, mirroring swt-evolve's `genHostP2Inf`. If the target product has a
   different Evolve, p2director's resolution fails → the refresh fails → the previous working
   artifact stays published (no blank IDE).

## Planned Gradle wiring (approach: Gradle + Eclipse p2 publisher, no Tycho)

Add to the `ewt` build (sketch — see spec §4.3):

```kotlin
// 1) Fill the p2.inf tokens from the BUILT swt-evolve host Bundle-Version (not the git tag).
val evolveIu      = /* read from the built swt-evolve p2/host — spec Q1 */
val evolveVersion = /* e.g. 3.132.0.v0_2_0-hyb */
tasks.register<Copy>("ewtEvolveFeatureP2Inf") {
    from("ewt-evolve-p2/feature/p2.inf")
    into(layout.buildDirectory.dir("ewt-evolve-p2/feature"))
    expand("EVOLVE_IU" to evolveIu, "EVOLVE_VERSION" to evolveVersion)  // or filter/replace tokens
}

// 2) Stage a source tree:  plugins/ (ewt-evolve fragment jar + demo jar)  features/ (feature jar).
//    The ewt-evolve fragment jar already comes from :ewt.api:ewtEvolveJar (per-OS).

// 3) Assemble the p2 repo with the Eclipse p2 publisher apps (same tools that build Evolve's p2):
//    org.eclipse.equinox.p2.publisher.FeaturesAndBundlesPublisher  (bundles + feature → content/artifacts.jar)
//    org.eclipse.equinox.p2.publisher.CategoryPublisher            (category.xml)
//    invoked via the equinox launcher jar; -compress -publishArtifacts.

// 4) gsutil rsync the repo to the versioned bucket layout below.
```

## Bucket layout (requirement 3 — keep previous builds; fixed URL for the CLI)

```
gs://<bucket>/ewt-evolve/<evolveVersion>/<variant>/p2/   # immutable per Evolve version
gs://<bucket>/ewt-evolve/latest/<variant>/p2/            # moved only on a SUCCESSFUL build
```

- `<variant>` = `desktop-hybrid` (per-OS incl. both mac arches) and `web` (if the POC is web).
- A failed build never overwrites `latest/`, so the last working p2 keeps serving.
- The CLI would point p2director at `.../ewt-evolve/latest/<variant>/p2` (spec Q2/Q5).

## Open before wiring (from the spec)

- **Q1** exact Evolve IU + version for the `requires` (fill `@EVOLVE_IU@` / `@EVOLVE_VERSION@`).
- **Q2** fixed bucket + public URL.
- **Q3** which repo hosts this build (ewt for now).
- **Q4** trigger on each Evolve release.
- **Q5** how the CLI/POC opts into installing this feature.
- Per-OS fragment handling in `feature.xml` (one symbolic name + per-platform p2 vs per-arch names).
