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

/**
 * The per-platform ewt-evolve fragment jars — each a distinct Bundle-SymbolicName
 * (dev.equo.ewt.evolve.<ws>.<os>.<arch>). Each jar carries BOTH bundles (desktop native + web) and
 * BOTH SPI providers, so one addon works whichever mode the POC runs. ONE p2 repo carries them all;
 * p2 installs the platform match. -PewtEvolveJar=<one jar> OR -PewtEvolveJarsDir=<dir> (glob all).
 */
val ewtEvolveJars: List<File> = when {
    findProperty("ewtEvolveJar") != null -> listOf(file(findProperty("ewtEvolveJar") as String))
    else -> fileTree((findProperty("ewtEvolveJarsDir") as String?)?.let { file(it) }
        ?: file("../ewt.api/build/libs")) { include("ewt-evolve-*.jar") }
        .files.sortedBy { it.name }.toList()
}
val firstFragment: File? = ewtEvolveJars.firstOrNull()   // any one carries the demo's compile deps

/**
 * IU whose EXACT version pins Evolve, so p2 refuses to install onto a mismatched Evolve (fail-closed).
 * We pin **org.eclipse.swt** (the Evolve SWT host) because the addon is COMBINED (both modes): a mode-
 * specific feature group (feat.hybrid / feat.web) isn't present in the other mode, whereas org.eclipse.swt
 * is the single bundle that serves both. Its version encodes the Eclipse line (e.g. 3.133.0.v0_336_0-hyb),
 * so the p2 repo is published PER LINE — the version comes from -PevolveVersion (CI reads the exact
 * org.eclipse.swt hyb version of each line from that line's Evolve p2).
 */
val evolveIu: String = (findProperty("evolveIu") as String?) ?: "org.eclipse.swt"

/** Exact version to pin. Required. CI passes each line's org.eclipse.swt hyb version. */
val evolveVersionOverride: String? = findProperty("evolveVersion") as String?

/** Local-test fallback: read the version from a built swt-evolve host jar if -PevolveVersion is absent. */
val evolveHostJar: File = (findProperty("evolveHostJar") as String?)?.let { file(it) }
    ?: file("../../../swt-evolve/swt_native/build/libs/org.eclipse.swt-hybrid.jar")

val featureVersion: String = (findProperty("featureVersion") as String?) ?: "0.1.0"
val demoVersion: String = (findProperty("demoVersion") as String?) ?: "0.1.0"
val featureId = "dev.equo.ewt.evolve.feature"

// ---- Helpers ----

fun bundleVersion(jar: File): String = JarFile(jar).use { jf ->
    val mf = jf.manifest ?: throw GradleException("No MANIFEST in $jar")
    (mf.mainAttributes.getValue("Bundle-Version")
        ?: throw GradleException("No Bundle-Version in $jar")).trim()
}

fun firstJar(glob: String): File = fileTree("$eclipseHome/plugins") { include(glob) }.files
    .sortedBy { it.name }.lastOrNull()
    ?: throw GradleException("Not found in $eclipseHome/plugins: $glob (set -PeclipseHome)")

// -Pp2Out=<name> roots the output under build/<name>/ so the CI can assemble one repo per Eclipse
// line (build/2026-03/p2-repo, build/2026-06/p2-repo, …) without them colliding.
val p2Out: String? = findProperty("p2Out") as String?
fun bdir(sub: String) = if (p2Out == null) layout.buildDirectory.dir(sub)
                        else layout.buildDirectory.dir("$p2Out/$sub")
val p2SourceDir = bdir("p2-source")   // plugins/ + features/ the publisher reads
val p2RepoDir = bdir("p2-repo")       // the assembled p2 repository (output)

// ---- Feature p2.inf: substitute the exact Evolve version read from the built host jar ----

val genFeatureP2Inf = tasks.register("genFeatureP2Inf") {
    description = "Generate the feature p2.inf pinned to the exact Evolve version."
    val template = file("feature/p2.inf")
    val outFile = bdir("feature-staged").map { it.file("p2.inf") }
    inputs.file(template)
    inputs.property("evolveIu", evolveIu)
    inputs.property("evolveVersion", evolveVersionOverride ?: "")
    outputs.file(outFile)
    doLast {
        val src = if (evolveVersionOverride != null) "-PevolveVersion" else evolveHostJar.name
        val ver = evolveVersionOverride ?: run {
            if (!evolveHostJar.exists()) throw GradleException(
                "No -PevolveVersion and no swt-evolve host jar at $evolveHostJar. Pass -PevolveVersion " +
                "(each line's exact org.eclipse.swt hyb version, e.g. 3.133.0.v0_336_0-hyb) or -PevolveHostJar.")
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
    into(bdir("feature-staged"))
}

val featureJar = tasks.register<Jar>("featureJar") {
    description = "Package $featureId (feature.xml + exact-version p2.inf)."
    dependsOn(stageFeatureXml, genFeatureP2Inf)
    destinationDirectory.set(p2SourceDir.map { it.dir("features") })
    archiveFileName.set("${featureId}_$featureVersion.jar")
    from(bdir("feature-staged")) { include("feature.xml", "p2.inf") }
}

// ---- Demo plugin: compile the ViewPart, jar it → p2-source/plugins/ ----

val compileDemo = tasks.register<JavaCompile>("compileDemo") {
    description = "Compile the demo ViewPart against the Eclipse platform + ewt-evolve fragment."
    doFirst {
        if (firstFragment == null) throw GradleException(
            "No ewt-evolve fragment jar found. Build it first:\n" +
            "  (cd .. && ./gradlew :ewt.api:ewtEvolveJar -PuseLocal=true -PevolveHome=../../swt-evolve)\n" +
            "or pass -PewtEvolveJar=<path> / -PewtEvolveJarsDir=<dir>.")
    }
    source = fileTree("demo/src")
    // Eclipse platform (ViewPart, SWT, core.runtime, …) + a fragment (EwtWidget, dev.equo.ewt.* —
    // the Java is identical across platforms, so any one fragment resolves the demo's compile deps).
    classpath = files(fileTree("$eclipseHome/plugins") { include("*.jar") }) +
        (firstFragment?.let { files(it) } ?: files())
    destinationDirectory.set(layout.buildDirectory.dir("demo/classes"))
    // Standalone JavaCompile (no source set) → set both explicitly, else Gradle's task validation
    // fails with "targetCompatibility not set". JDK 22 floor (matches the ewt-evolve fragment).
    sourceCompatibility = "22"
    targetCompatibility = "22"
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
    from(ewtEvolveJars)      // all per-platform fragments → one repo; p2 filters at install
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

// ---- Publish stub. The real per-line publish is done by the CI job (loop over versions.json,
// one repo per Eclipse release at <bucket>/ewt-evolve/<eclipseRelease>/p2). This local convenience
// pushes the currently-assembled repo to one release path; needs -Pp2Bucket + -PeclipseRelease. ----

val publishP2 = tasks.register<Exec>("publishP2") {
    group = "p2"
    description = "rsync the assembled p2 repo to <bucket>/ewt-evolve/<eclipseRelease>/p2 (needs -Pp2Bucket)."
    dependsOn(assembleP2)
    val bucket = findProperty("p2Bucket") as String?               // e.g. gs://equo-ewt/ewt-evolve
    val release = (findProperty("eclipseRelease") as String?) ?: "latest"
    onlyIf {
        if (bucket == null) logger.warn(
            "publishP2 skipped: pass -Pp2Bucket=<gs://…> + -PeclipseRelease=<2026-03|…>. " +
            "Layout: <bucket>/<eclipseRelease>/p2 (one repo per Eclipse line).")
        bucket != null
    }
    doFirst {
        commandLine("bash", "-lc",
            "gsutil -m -h 'Cache-Control:no-cache' rsync -r -d '${p2RepoDir.get().asFile}' '$bucket/$release/p2'")
    }
}
