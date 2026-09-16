import java.util.jar.JarFile

/*
 * Assembles the ewt-evolve p2 repository (workstream 10 — see ../ewt-evolve-p2-distribution-spec.md).
 *
 *   feature (dev.equo.ewt.evolve.feature) = ewt-evolve fragment + demo plugin,
 *   pinned to the EXACT swt-evolve version it was built against (p2.inf requires [X,X]),
 *   published as a p2 repo via the Eclipse p2 publisher.
 *
 * Consumes ALREADY-BUILT artifacts as inputs (does not rebuild ewt or swt-evolve):
 *   - ewt-evolve fragment jar   ← :ewt.api:ewtEvolveJar   (dev.equo.ewt.evolve, per-OS)
 *   - swt-evolve hybrid host jar ← swt-evolve :swt_native  (read Bundle-Version for the pin)
 *   - an Eclipse install         ← equinox launcher + p2 publisher apps + platform bundles
 *
 * Run (local):
 *   gradle assembleP2 \
 *     -PewtEvolveJar=../ewt.api/build/libs/ewt-evolve-0.1.6-linux.jar \
 *     -PevolveHostJar=../../../swt-evolve/swt_native/build/libs/org.eclipse.swt-hybrid.jar
 * Defaults resolve those from the sibling repos + a local Eclipse; override per-flag or via env.
 */

plugins { base }

// ---- Inputs (all overridable via -P<name> or env; sane local defaults) ----

/** Eclipse install providing the equinox launcher, p2 publisher apps, and platform bundles. */
val eclipseHome: String = (findProperty("eclipseHome") as String?)
    ?: System.getenv("ECLIPSE_HOME")
    ?: "/home/equo/Downloads/renesas_linux_x64/eclipse"

/** The per-OS ewt-evolve fragment jar (dev.equo.ewt.evolve). Built by :ewt.api:ewtEvolveJar. */
val ewtEvolveJar: File? = (findProperty("ewtEvolveJar") as String?)?.let { file(it) }
    ?: fileTree("../ewt.api/build/libs") { include("ewt-evolve-*.jar") }.files
        .sortedBy { it.name }.firstOrNull()

/** swt-evolve hybrid host jar — its Bundle-Version is the exact-version pin. */
val evolveHostJar: File = (findProperty("evolveHostJar") as String?)?.let { file(it) }
    ?: file("../../../swt-evolve/swt_native/build/libs/org.eclipse.swt-hybrid.jar")

/**
 * IU whose exact version pins Evolve. Per Mati/CLI (2026-09-16): require Evolve's SWT-layer FEATURE
 * GROUP, the same unit the director installs — NOT the org.eclipse.swt host. That feature group is
 * assembled by the CLI-side publishing pipeline (not swt-evolve), so its version is NOT in any local
 * jar: pass it via -PevolveVersion (CI reads it from Evolve's published desktop-hybrid p2).
 * For LOCAL testing you can still pin the host: -PevolveIu=org.eclipse.swt (version read from the host jar).
 */
val evolveIu: String = (findProperty("evolveIu") as String?) ?: "dev.equo.swt.evolve.feat.hybrid.feature.group"

/** Exact version to pin. Required unless evolveIu is org.eclipse.swt (then read from the host jar). */
val evolveVersionOverride: String? = findProperty("evolveVersion") as String?

val featureVersion: String = (findProperty("featureVersion") as String?) ?: "0.1.0"
val demoVersion: String = (findProperty("demoVersion") as String?) ?: "0.1.0"

// ---- Helpers ----

fun bundleVersion(jar: File): String = JarFile(jar).use { jf ->
    val mf = jf.manifest ?: throw GradleException("No MANIFEST in $jar")
    (mf.mainAttributes.getValue("Bundle-Version")
        ?: throw GradleException("No Bundle-Version in $jar")).trim()
}

fun firstJar(glob: String): File = fileTree("$eclipseHome/plugins") { include(glob) }.files
    .sortedBy { it.name }.lastOrNull()
    ?: throw GradleException("Not found in $eclipseHome/plugins: $glob (set -PeclipseHome)")

// Output root — set -Pp2Out=<os> to build a per-OS repo (build/<os>/p2-repo), so ONE Linux CI job
// can assemble linux/macos/windows repos in a loop (the p2 publisher is OS-agnostic Java).
val p2Out: String? = findProperty("p2Out") as String?
fun bdir(sub: String) = if (p2Out == null) layout.buildDirectory.dir(sub)
                        else layout.buildDirectory.dir("$p2Out/$sub")
val p2SourceDir = bdir("p2-source")   // plugins/ + features/ the publisher reads
val p2RepoDir = bdir("p2-repo")       // the assembled p2 repository (output)

// ---- Feature p2.inf: substitute the exact Evolve version read from the built host jar ----

val genFeatureP2Inf = tasks.register("genFeatureP2Inf") {
    description = "Generate feature/p2.inf pinned to the built swt-evolve Bundle-Version."
    val template = file("feature/p2.inf")
    val outFile = layout.buildDirectory.file("feature-staged/p2.inf")
    inputs.file(template)
    inputs.property("evolveIu", evolveIu)
    inputs.property("evolveVersion", evolveVersionOverride ?: "")
    outputs.file(outFile)
    doLast {
        val src = if (evolveVersionOverride != null) "-PevolveVersion" else evolveHostJar.name
        val ver = evolveVersionOverride ?: run {
            if (evolveIu != "org.eclipse.swt") throw GradleException(
                "evolveIu=$evolveIu needs an explicit -PevolveVersion — the feature-group version is " +
                "not in any local jar (it's assembled by the CLI-side pipeline). CI must read it from " +
                "Evolve's published desktop-hybrid p2. See ewt-evolve-p2-distribution-spec.md Q1.")
            if (!evolveHostJar.exists()) throw GradleException(
                "swt-evolve host jar not found: $evolveHostJar (pass -PevolveHostJar or -PevolveVersion)")
            bundleVersion(evolveHostJar)
        }
        val f = outFile.get().asFile
        f.parentFile.mkdirs()
        f.writeText(
            "# Generated by genFeatureP2Inf (version from $src) — do not edit.\n" +
            "# Human template + rationale: ewt-evolve-p2/feature/p2.inf\n" +
            "requires.1.namespace = org.eclipse.equinox.p2.iu\n" +
            "requires.1.name = $evolveIu\n" +
            "requires.1.range = [$ver,$ver]\n"
        )
        logger.lifecycle("ewt-evolve.feature pinned to  $evolveIu  [$ver,$ver]")
    }
}

// ---- Feature jar (feature.xml + generated p2.inf) → p2-source/features/ ----

val stageFeatureXml = tasks.register<Copy>("stageFeatureXml") {
    from("feature/feature.xml") { filter { it.replace("0.1.0.qualifier", featureVersion) } }
    into(layout.buildDirectory.dir("feature-staged"))
}

val featureJar = tasks.register<Jar>("featureJar") {
    description = "Package dev.equo.ewt.evolve.feature (feature.xml + exact-version p2.inf)."
    dependsOn(stageFeatureXml, genFeatureP2Inf)
    destinationDirectory.set(p2SourceDir.map { it.dir("features") })
    archiveFileName.set("dev.equo.ewt.evolve.feature_$featureVersion.jar")
    from(layout.buildDirectory.dir("feature-staged")) { include("feature.xml", "p2.inf") }
}

// ---- Demo plugin: compile the ViewPart, jar it → p2-source/plugins/ ----

val compileDemo = tasks.register<JavaCompile>("compileDemo") {
    description = "Compile the demo ViewPart against the Eclipse platform + ewt-evolve fragment."
    doFirst {
        if (ewtEvolveJar == null) throw GradleException(
            "ewt-evolve fragment jar not found. Build it first:\n" +
            "  (cd .. && ./gradlew :ewt.api:ewtEvolveJar -PuseLocal=true -PevolveHome=../../swt-evolve)\n" +
            "or pass -PewtEvolveJar=<path>.")
    }
    source = fileTree("demo/src")
    // Eclipse platform (ViewPart, SWT, core.runtime, …) + the fragment (EwtWidget, dev.equo.ewt.*).
    classpath = files(fileTree("$eclipseHome/plugins") { include("*.jar") }) +
        (ewtEvolveJar?.let { files(it) } ?: files())
    destinationDirectory.set(layout.buildDirectory.dir("demo/classes"))
    options.release.set(22)
}

val demoJar = tasks.register<Jar>("demoJar") {
    description = "Package dev.equo.ewt.evolve.demo (ViewPart + plugin.xml)."
    dependsOn(compileDemo)
    destinationDirectory.set(p2SourceDir.map { it.dir("plugins") })
    archiveFileName.set("dev.equo.ewt.evolve.demo_$demoVersion.jar")
    manifest {
        from("demo/META-INF/MANIFEST.MF")
        attributes("Bundle-Version" to demoVersion)   // concretise 0.1.0.qualifier
    }
    from(compileDemo.map { it.destinationDirectory })
    from("demo") { include("plugin.xml") }
}

// ---- Stage the prebuilt ewt-evolve fragment jar into p2-source/plugins/ (publisher reads its manifest) ----

val stageFragment = tasks.register<Copy>("stageFragment") {
    dependsOn(compileDemo)   // shares the same missing-input guard message via compileDemo.doFirst
    from(ewtEvolveJar ?: files())
    into(p2SourceDir.map { it.dir("plugins") })
}

// ---- Assemble the p2 repo with the Eclipse p2 publisher apps ----

fun p2App(taskName: String, app: String, extraArgs: List<String>) =
    tasks.register<JavaExec>(taskName) {
        classpath = files(firstJar("org.eclipse.equinox.launcher_*.jar"))
        mainClass.set("org.eclipse.equinox.launcher.Main")
        val repoUri = p2RepoDir.get().asFile.toURI().toString()
        args = listOf(
            "-nosplash",
            "-configuration", layout.buildDirectory.dir("p2-config").get().asFile.absolutePath,
            "-application", app,
            "-metadataRepository", repoUri,
            "-artifactRepository", repoUri,
        ) + extraArgs
    }

val publishBundlesAndFeatures = p2App(
    "publishBundlesAndFeatures",
    "org.eclipse.equinox.p2.publisher.FeaturesAndBundlesPublisher",
    listOf(
        "-source", p2SourceDir.get().asFile.absolutePath,
        "-configs", "ANY",
        "-compress", "-publishArtifacts",
    ),
).apply { configure { dependsOn(demoJar, featureJar, stageFragment) } }

val publishCategory = p2App(
    "publishCategory",
    "org.eclipse.equinox.p2.publisher.CategoryPublisher",
    listOf(
        "-categoryDefinition", file("category.xml").toURI().toString(),
        "-compress",
    ),
).apply { configure { dependsOn(publishBundlesAndFeatures) } }

val assembleP2 = tasks.register("assembleP2") {
    group = "p2"
    description = "Build the ewt-evolve p2 repository into build/p2-repo/."
    dependsOn(publishCategory)
    doLast { logger.lifecycle("p2 repository assembled at ${p2RepoDir.get().asFile}") }
}

// ---- Publish (Q2 pending — fixed bucket/URL). Parameterised stub; no-op without -Pp2Bucket. ----

val publishP2 = tasks.register<Exec>("publishP2") {
    group = "p2"
    description = "rsync the assembled p2 repo to the versioned bucket layout (needs -Pp2Bucket)."
    dependsOn(assembleP2)
    val bucket = findProperty("p2Bucket") as String?          // e.g. gs://equo-evolve
    val variant = (findProperty("variant") as String?) ?: "desktop-hybrid"
    onlyIf {
        if (bucket == null) logger.warn(
            "publishP2 skipped: pass -Pp2Bucket=<gs://…> (Q2). Layout: " +
            "<bucket>/ewt-evolve/<evolveVersion>/$variant/p2 (immutable) + …/latest/$variant/p2 (moved on success).")
        bucket != null
    }
    doFirst {
        val ver = bundleVersion(evolveHostJar)
        // Immutable per-version copy, then move latest/ (only reached on a successful assemble).
        commandLine("bash", "-lc",
            "set -e; " +
            "gsutil -m rsync -r -d '${p2RepoDir.get().asFile}' '$bucket/ewt-evolve/$ver/$variant/p2'; " +
            "gsutil -m rsync -r -d '$bucket/ewt-evolve/$ver/$variant/p2' '$bucket/ewt-evolve/latest/$variant/p2'")
    }
}
