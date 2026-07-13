# Java Hot-Reload MVP Implementation Plan

> **For agentic workers:** REQUIRED SUB-SKILL: Use superpowers:subagent-driven-development (recommended) or superpowers:executing-plans to implement this plan task-by-task. Steps use checkbox (`- [ ]`) syntax for tracking.

**Goal:** Recargar en vivo cambios de cuerpo de métodos Java en una app EWT sin reiniciar el proceso, viendo la UI actualizada al guardar.

**Architecture:** Un wrapper interno `HotReloadRoot` (SubStatefulWidget Java, en package `dev.equo.ewt.internal`) envuelve el árbol raíz. Un plugin Gradle `dev.equo.ewt.hot-reload` que el usuario aplica en su módulo registra el task `hotRun`, que arranca un cliente JDI (subproyecto `hot-reload-client`) auto-configurado con los source dirs, la task de compilación y el mainClass del módulo. El cliente watchea sources, recompila con el `classes` task del módulo, redefine bytecode via JDWP (`localhost:5005`), y abre un TCP a Dart (`localhost:5006`) para disparar `WidgetsBinding.instance.reassembleApplication()`. Flutter reassemble re-invoca `build()` del wrapper, que llama al `Callable<Widget>` cacheado — corriendo bytecode nuevo.

**Tech Stack:** Java (JDK 21+ FFM, `com.sun.jdi` para JDWP), Dart (`dart:io` ServerSocket, Flutter `WidgetsBinding`), Gradle (application plugin, daemon), C (sin cambios).

## Global Constraints

- **Language of user-visible content**: ALL code that a client of EWT could see MUST be in **English**. This includes: console logs (`print`, `println`, `System.out/err`), exception messages, code comments and docstrings/Javadoc/dartdoc, Gradle task `description`/`group`, README sections, plugin help text, and any file the client could open. Internal-only plan documentation (this file) remains in Spanish. When implementing, translate any Spanish string in the code blocks below to English before writing it to disk. If in doubt about a specific string, default to English.
- **JVM debug flag**: `-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=localhost:5005`. Solo `localhost` — bindear a interfaz pública es RCE.
- **Puertos**: JDWP en 5005, hot-reload signal en 5006. Ambos hardcodeados en MVP.
- **Scope de redefinición**: solo cuerpos de método. Cambios de signature, campos nuevos, clases nuevas no soportadas por JDWP puro — documentar y fallar limpio.
- **State no se preserva**: `SubStatefulWidget` usa `UniqueKey()` por default (`widgets/lib/subwidgets.dart:62`), así que cada rebuild recrea `State`. Limitación aceptada para MVP.
- **Sistemas de build**: `:generator:generator` y `:ewt.api:jar` con `JAVA_HOME=~/bin/jdk-22` son los comandos canónicos. No corremos `./gradlew test`.
- **Verificación**: build limpio de los dos targets canónicos + walkthrough manual del demo `Counter`. No hay tests unitarios en este MVP.

---

### Task 1: `HotReloadRoot` wrapper en Java

**Files:**
- Create: `ewt.api/src/main/java/dev/equo/ewt/internal/HotReloadRoot.java`

**Interfaces:**
- Consumes: `SubStatefulWidget`, `SubState`, `Widget`, `BuildContext` (existentes, en `dev.equo.ewt`).
- Produces: `dev.equo.ewt.internal.HotReloadRoot(Callable<Widget> userBuilder)` — instancia envolvente que Task 2 usa desde `App.runApp`.

**Contexto:** El wrapper es un `SubStatefulWidget` cuya `SubState` guarda el `Callable<Widget>` del usuario. Cada vez que Flutter lo reconstruye (via reassemble global), su `build()` re-invoca `userBuilder.call()` — ejecutando bytecode nuevo. Fuera de hot-reload es transparente: en el primer frame, arma el árbol una vez y ya. `SubStatefulWidget` existente usa `UniqueKey`, así que del lado Dart nuestro wrapper participa de la reconciliación como cualquier otro widget.

Vive en el subpaquete `dev.equo.ewt.internal` como garantía estructural: el generator solo escribe a `dev/equo/ewt/$clazz.java` (nunca a subpaquetes; verificado en `generator/lib/gen.dart:1755-1758`), por lo que jamás va a sobreescribir este archivo aunque en el futuro exista un widget Flutter llamado `HotReloadRoot`. La clase es package-private a `dev.equo.ewt` via un método bridge — ver Step 1b.

- [ ] **Step 1a: Crear la clase**

Crear el archivo con este contenido:

```java
package dev.equo.ewt.internal;

import dev.equo.ewt.BuildContext;
import dev.equo.ewt.State;
import dev.equo.ewt.SubState;
import dev.equo.ewt.SubStatefulWidget;
import dev.equo.ewt.Widget;

import java.util.concurrent.Callable;

/**
 * Internal wrapper around the user's root widget that enables hot-reload.
 * Instantiated exactly once from App.runApp; not intended for direct use by
 * user code.
 *
 * Whenever Flutter fires reassemble on the tree (for example when the
 * hot-reload signal arrives), this SubStatefulWidget is marked dirty and
 * build() is re-invoked, which calls the user's Callable<Widget> again. That
 * Callable instantiates widgets against the bytecode currently loaded in the
 * JVM, so any redefined method bodies take effect on the next frame.
 */
public final class HotReloadRoot extends SubStatefulWidget {
    private final Callable<Widget> userBuilder;

    public HotReloadRoot(Callable<Widget> userBuilder) {
        this.userBuilder = userBuilder;
    }

    @Override
    protected State<HotReloadRoot> createState() {
        return new HotReloadRootState(userBuilder);
    }

    static final class HotReloadRootState extends SubState<HotReloadRoot> {
        private final Callable<Widget> userBuilder;

        HotReloadRootState(Callable<Widget> userBuilder) {
            this.userBuilder = userBuilder;
        }

        @Override
        protected Widget build(BuildContext context) {
            try {
                return userBuilder.call();
            } catch (Exception e) {
                throw new RuntimeException("EWT hot-reload root builder threw", e);
            }
        }
    }
}
```

- [ ] **Step 1b: Verificar que compila**

Ejecutar:
```bash
cd /home/equo/Desktop/equo/equo-ewt/ewt && JAVA_HOME=~/bin/jdk-22 ./gradlew :ewt.api:jar
```
Esperado: BUILD SUCCESSFUL.

Si falla por acceso a `SubState`/`SubStatefulWidget` (algún método package-private que necesitamos), la solución más limpia es NO exponerlos: el override de `createState` y `build` solo requieren API `protected`, que sí atraviesa paquetes via herencia. Si aparece un error de tipo genérico, revisar cómo `Counter.MyHomePage` en `examples/src/main/java/dev/equo/Counter.java` implementa `createState()` y alinear la declaración.

- [ ] **Step 2: Commit**

```bash
git add ewt.api/src/main/java/dev/equo/ewt/internal/HotReloadRoot.java
git commit -m "feat(hot-reload): add internal HotReloadRoot wrapper"
```

---

### Task 2: Cablear `App.runApp` para envolver el root

**Files:**
- Modify: `ewt.api/src/main/java/dev/equo/ewt/App.java:27-44`

**Interfaces:**
- Consumes: `HotReloadRoot(Callable<Widget>)` de Task 1.
- Produces: comportamiento sin cambio para el usuario. `App.runApp(builder)` sigue siendo la única API pública. El wrapper es interno.

**Contexto:** `App.runApp` recibe un `Callable<Widget>` que devuelve el root del usuario. Hoy lo llama una vez dentro del `buildWidgetTreeFn` FFM. Queremos envolverlo en un `HotReloadRoot` para que Flutter tenga siempre un `SubStatefulWidget` de nivel superior sobre el que hacer reassemble. El `Callable` original queda capturado adentro del wrapper. No cacheamos nada nuevo en `App` — el wrapper mismo es el que mantiene la referencia.

- [ ] **Step 1: Reemplazar el cuerpo de `run()`**

Editar `ewt.api/src/main/java/dev/equo/ewt/App.java`, reemplazando el método `run()` (líneas 31-44) para envolver el builder:

```java
    private void run() {
        Callable<Widget> wrappedBuilder = () -> new dev.equo.ewt.internal.HotReloadRoot(builderFn);
        MemorySegment ffmFn = buildWidgetTreeFn.allocate((MemorySegment widgetFactories) -> {
            try {
                WidgetConstructors.instance.set(WidgetFactories.reinterpret(widgetFactories, Arena.ofShared(), (ms) -> {}));
                Widget w = wrappedBuilder.call().build();
                return ((NativeObj) w).getId();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }, Arena.ofShared());
        int r = StarterBridge.startApp(ffmFn);
        if (r != 0)
            throw new RuntimeException("Could not startup EWT app, error: " + r);
    }
```

- [ ] **Step 2: Rebuildear e inspeccionar visualmente**

Ejecutar:
```bash
cd /home/equo/Desktop/equo/equo-ewt/ewt && JAVA_HOME=~/bin/jdk-22 ./gradlew :ewt.api:jar
```
Esperado: BUILD SUCCESSFUL.

- [ ] **Step 3: Correr el demo Counter y verificar UI intacta**

Ejecutar:
```bash
cd /home/equo/Desktop/equo/equo-ewt/ewt && JAVA_HOME=~/bin/jdk-22 ./gradlew :examples:run -PmainClass=dev.equo.Counter -PuseLocal=true
```

Esperado: la app abre igual que antes del cambio. Contador funciona con `setState`. El wrapper es transparente — si algo se rompe acá, hay un bug en Task 1 o 2.

- [ ] **Step 4: Commit**

```bash
git add ewt.api/src/main/java/dev/equo/ewt/App.java
git commit -m "feat(hot-reload): wrap root in HotReloadRoot for reassemble hook"
```

---

### Task 3: Servidor TCP de hot-reload en Dart

**Files:**
- Create: `widgets/lib/hot_reload.dart`
- Modify: `widgets/lib/widgets.dart:1-12` (agregar import + init)

**Interfaces:**
- Consumes: `WidgetsBinding` de Flutter.
- Produces: `initHotReloadServer()` — inicia el listener TCP en `localhost:5006`. Idempotente (no reintenta si ya está corriendo).

**Contexto:** Un `ServerSocket` en `localhost:5006` acepta conexiones y por cada una llama `WidgetsBinding.instance.reassembleApplication()`. Ese llamado es equivalente a lo que hace Flutter cuando el `flutter run` detecta cambio de sources — recorre el element tree marcando todo dirty y dispara reassemble en cada State. Como nuestro `HotReloadRoot` es un `SubStatefulWidget`, su State recibe reassemble, se marca dirty, y en el próximo frame Flutter re-invoca su `build()` — que vuelve a Java a re-ejecutar el `Callable<Widget>` con bytecode nuevo.

Debemos llamar `initHotReloadServer()` una sola vez tras la inicialización de Flutter. Punto de entrada natural: la primera vez que `callToBuildWidgetTree` es invocada desde C, `WidgetsBinding.instance` ya está lista.

- [ ] **Step 1: Crear `hot_reload.dart`**

Crear `widgets/lib/hot_reload.dart` con:

```dart
import 'dart:io';
import 'package:flutter/widgets.dart';

/// TCP port on which Dart listens for hot-reload signals from the JDI client.
const int _hotReloadPort = 5006;

ServerSocket? _server;

/// Starts the TCP listener for hot-reload signals. Idempotent: the first call
/// binds the socket, subsequent calls are no-ops.
///
/// Must be called after WidgetsBinding is initialized. Fails silently if the
/// port is already in use (e.g. another instance of the app is running) — the
/// app still starts, but hot-reload will not fire.
Future<void> initHotReloadServer() async {
  if (_server != null) return;
  try {
    _server = await ServerSocket.bind(
      InternetAddress.loopbackIPv4,
      _hotReloadPort,
      shared: false,
    );
  } on SocketException catch (e) {
    print('[EWT] Hot-reload server could not bind port $_hotReloadPort: $e');
    return;
  }
  print('[EWT] Hot-reload server listening on localhost:$_hotReloadPort');
  _server!.listen((client) {
    client.destroy();
    final binding = WidgetsBinding.instance;
    // reassembleApplication schedules a frame and fires reassemble on the
    // entire State tree — including our HotReloadRoot.
    binding.reassembleApplication();
  });
}
```

- [ ] **Step 2: Cablear el init en `widgets.dart`**

Editar `widgets/lib/widgets.dart` para agregar el import y llamar init en la primera invocación de `callToBuildWidgetTree`.

Reemplazar líneas 1-12 con:

```dart

import 'dart:async';
import 'dart:ffi' as ffi;
import 'package:ffi/ffi.dart';
import 'dart:io';
import 'dart:isolate';

import 'package:flutter/widgets.dart';

import 'widgets_bindings_generated.dart';
import 'hot_reload.dart';

bool _hotReloadInitTriggered = false;

int callToBuildWidgetTree(ffi.Pointer<WidgetFactories> factories) {
  if (!_hotReloadInitTriggered) {
    _hotReloadInitTriggered = true;
    // Fire-and-forget: do not block the initial build waiting for the bind.
    initHotReloadServer();
  }
  return _bindings.callToBuildWidgetTree(factories);
}
```

- [ ] **Step 3: Rebuildear la parte Dart via generator**

Ejecutar:
```bash
cd /home/equo/Desktop/equo/equo-ewt/ewt && JAVA_HOME=~/bin/jdk-22 ./gradlew :generator:generator
```
Esperado: BUILD SUCCESSFUL. El generator corre ffigen que compila Dart — un error de sintaxis Dart aparece acá.

- [ ] **Step 4: Correr demo y verificar que el socket se levanta**

Terminal 1:
```bash
cd /home/equo/Desktop/equo/equo-ewt/ewt && JAVA_HOME=~/bin/jdk-22 ./gradlew :examples:run -PmainClass=dev.equo.Counter -PuseLocal=true
```
Buscar en stdout: `[EWT] Hot-reload server escuchando en localhost:5006`.

Terminal 2 — probar que el trigger funciona:
```bash
echo "reload" | nc localhost 5006
```
Esperado: la UI se re-renderiza (visualmente no cambia porque no cambió código, pero verificable con un `print` temporal en el `build()` del `HotReloadRoot` que aparezca dos veces).

Cerrar la app.

- [ ] **Step 5: Commit**

```bash
git add widgets/lib/hot_reload.dart widgets/lib/widgets.dart
git commit -m "feat(hot-reload): TCP server on Dart side triggers reassembleApplication"
```

---

### Task 4: Subproyecto `hot-reload-client` con Gradle

**Files:**
- Modify: `settings.gradle.kts` (agregar `include("hot-reload-client")`)
- Create: `hot-reload-client/build.gradle.kts`
- Create: `hot-reload-client/src/main/java/dev/equo/ewt/hotreload/Main.java`

**Interfaces:**
- Produces: task Gradle `:hot-reload-client:run` que arranca el watcher. Params via system properties: `-DsourceDirs=...` (coma-separado), `-DjdwpAddress=localhost:5005`, `-DdartTriggerAddress=localhost:5006`, `-DgradleCompileTask=:examples:classes`.

**Contexto:** Un `main` Java que (a) attach a un JVM remoto via JDWP, (b) watchea directorios de source con `java.nio.file.WatchService`, (c) cuando detecta cambio en `.java`, ejecuta `./gradlew :examples:classes` con daemon, (d) para cada `.class` cambiado (comparando timestamps o hashes), lee los bytes, encuentra el `ReferenceType` correspondiente en el JVM remoto, y llama `vm.redefineClasses(Map.of(refType, bytes))`, (e) tras redefinir, abre TCP a `localhost:5006` y cierra.

`com.sun.jdi` vive en el módulo `jdk.jdi`, que Gradle no incluye por default en JDK 21+. Hay que agregarlo con `--add-modules jdk.jdi` a la JVM del task `run`.

- [ ] **Step 1: Registrar el subproyecto**

Editar `settings.gradle.kts` y agregar al final:

```kotlin
include("hot-reload-client")
```

- [ ] **Step 2: Crear `build.gradle.kts` del cliente**

Crear `hot-reload-client/build.gradle.kts`:

```kotlin
plugins {
    id("java")
    application
}

group = "dev.equo"
version = "1.0-SNAPSHOT"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

repositories {
    mavenCentral()
}

application {
    mainClass = "dev.equo.ewt.hotreload.Main"
    applicationDefaultJvmArgs = listOf(
        "--add-modules", "jdk.jdi"
    )
}
```

- [ ] **Step 3: Crear `Main.java`**

Crear `hot-reload-client/src/main/java/dev/equo/ewt/hotreload/Main.java`:

```java
package dev.equo.ewt.hotreload;

import com.sun.jdi.Bootstrap;
import com.sun.jdi.ReferenceType;
import com.sun.jdi.VirtualMachine;
import com.sun.jdi.connect.AttachingConnector;
import com.sun.jdi.connect.Connector;

import java.io.IOException;
import java.net.Socket;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public final class Main {

    private static final String JDWP_HOSTNAME = "localhost";
    private static final String JDWP_PORT = "5005";
    private static final String DART_TRIGGER_HOST = "localhost";
    private static final int DART_TRIGGER_PORT = 5006;

    public static void main(String[] args) throws Exception {
        String sourceDirsProp = System.getProperty("sourceDirs");
        String gradleTask = System.getProperty("gradleCompileTask", ":examples:classes");
        Path projectRoot = Paths.get(System.getProperty("projectRoot", ".")).toAbsolutePath();

        if (sourceDirsProp == null || sourceDirsProp.isBlank()) {
            System.err.println("Usage: -DsourceDirs=<path1,path2,...> -DprojectRoot=<ewt-root>");
            System.exit(2);
        }

        List<Path> sourceDirs = new ArrayList<>();
        for (String s : sourceDirsProp.split(",")) sourceDirs.add(Paths.get(s.trim()).toAbsolutePath());

        System.out.println("[hot-reload] Connecting to JDWP at " + JDWP_HOSTNAME + ":" + JDWP_PORT + " (retrying until ready)...");
        VirtualMachine vm = attachWithRetry();
        System.out.println("[hot-reload] Connected. Watching: " + sourceDirs);

        WatchService watcher = FileSystems.getDefault().newWatchService();
        Map<WatchKey, Path> keyRoots = new HashMap<>();
        for (Path root : sourceDirs) registerRecursive(root, watcher, keyRoots);

        Path classesOutputRoot = projectRoot.resolve("examples/build/classes/java/main");
        Map<Path, Long> classMtimes = snapshotMtimes(classesOutputRoot);

        while (true) {
            WatchKey key = watcher.take();
            // Debounce: coalesce burst events (e.g. IDE saving multiple files at once).
            Thread.sleep(150);
            List<WatchKey> collected = new ArrayList<>();
            collected.add(key);
            WatchKey more;
            while ((more = watcher.poll()) != null) collected.add(more);

            boolean sawJava = false;
            for (WatchKey k : collected) {
                for (WatchEvent<?> ev : k.pollEvents()) {
                    Object ctx = ev.context();
                    if (ctx instanceof Path p && p.toString().endsWith(".java")) sawJava = true;
                }
                k.reset();
            }
            if (!sawJava) continue;

            System.out.println("[hot-reload] Change detected, recompiling...");
            long t0 = System.currentTimeMillis();
            int rc = runGradle(projectRoot, gradleTask);
            long dt = System.currentTimeMillis() - t0;
            if (rc != 0) {
                System.err.println("[hot-reload] Compilation failed (exit " + rc + "), skipping.");
                continue;
            }
            System.out.println("[hot-reload] Recompiled in " + dt + "ms.");

            Map<Path, Long> newMtimes = snapshotMtimes(classesOutputRoot);
            List<Path> changed = new ArrayList<>();
            for (var e : newMtimes.entrySet()) {
                Long prev = classMtimes.get(e.getKey());
                if (prev == null || !prev.equals(e.getValue())) changed.add(e.getKey());
            }
            classMtimes = newMtimes;

            if (changed.isEmpty()) {
                System.out.println("[hot-reload] No .class changes detected.");
                continue;
            }
            System.out.println("[hot-reload] Redefining " + changed.size() + " class(es).");

            Map<ReferenceType, byte[]> toRedefine = new HashMap<>();
            for (Path classFile : changed) {
                String fqcn = classesOutputRoot.relativize(classFile).toString()
                        .replace(java.io.File.separatorChar, '.')
                        .replaceAll("\\.class$", "");
                List<ReferenceType> refs = vm.classesByName(fqcn);
                if (refs.isEmpty()) {
                    System.out.println("[hot-reload] " + fqcn + " not loaded yet in target VM, skipping.");
                    continue;
                }
                byte[] bytes = Files.readAllBytes(classFile);
                for (ReferenceType r : refs) toRedefine.put(r, bytes);
            }

            if (toRedefine.isEmpty()) {
                System.out.println("[hot-reload] Nothing to redefine.");
                continue;
            }

            try {
                vm.redefineClasses(toRedefine);
            } catch (UnsupportedOperationException e) {
                System.err.println("[hot-reload] Redefinition unsupported (structural change?): " + e.getMessage());
                continue;
            } catch (Exception e) {
                System.err.println("[hot-reload] Error while redefining: " + e.getMessage());
                continue;
            }

            triggerDartReassemble();
            System.out.println("[hot-reload] Reload applied.");
        }
    }

    private static VirtualMachine attachWithRetry() throws Exception {
        AttachingConnector conn = Bootstrap.virtualMachineManager().attachingConnectors().stream()
                .filter(c -> c.name().equals("com.sun.jdi.SocketAttach"))
                .findFirst().orElseThrow(() -> new IllegalStateException("No SocketAttach connector"));

        Map<String, Connector.Argument> args = conn.defaultArguments();
        args.get("hostname").setValue(JDWP_HOSTNAME);
        args.get("port").setValue(JDWP_PORT);

        long deadline = System.currentTimeMillis() + 60_000;
        while (true) {
            try {
                return conn.attach(args);
            } catch (Exception e) {
                if (System.currentTimeMillis() > deadline) throw e;
                Thread.sleep(500);
            }
        }
    }

    private static void registerRecursive(Path root, WatchService watcher, Map<WatchKey, Path> keyRoots) throws IOException {
        Files.walkFileTree(root, new SimpleFileVisitor<>() {
            @Override public FileVisitResult preVisitDirectory(Path dir, java.nio.file.attribute.BasicFileAttributes attrs) throws IOException {
                WatchKey k = dir.register(watcher,
                        StandardWatchEventKinds.ENTRY_CREATE,
                        StandardWatchEventKinds.ENTRY_MODIFY,
                        StandardWatchEventKinds.ENTRY_DELETE);
                keyRoots.put(k, dir);
                return FileVisitResult.CONTINUE;
            }
        });
    }

    private static Map<Path, Long> snapshotMtimes(Path root) throws IOException {
        Map<Path, Long> out = new HashMap<>();
        if (!Files.exists(root)) return out;
        Files.walk(root)
                .filter(p -> p.toString().endsWith(".class"))
                .forEach(p -> {
                    try { out.put(p, Files.getLastModifiedTime(p).toMillis()); } catch (IOException ignored) {}
                });
        return out;
    }

    private static int runGradle(Path projectRoot, String task) throws Exception {
        ProcessBuilder pb = new ProcessBuilder("./gradlew", task, "--daemon", "-q")
                .directory(projectRoot.toFile())
                .redirectErrorStream(true)
                .inheritIO();
        pb.environment().put("JAVA_HOME", System.getenv().getOrDefault("JAVA_HOME", System.getProperty("java.home")));
        Process p = pb.start();
        if (!p.waitFor(120, TimeUnit.SECONDS)) {
            p.destroyForcibly();
            return -1;
        }
        return p.exitValue();
    }

    private static void triggerDartReassemble() {
        try (Socket s = new Socket(DART_TRIGGER_HOST, DART_TRIGGER_PORT)) {
            s.getOutputStream().write("reload\n".getBytes());
            s.getOutputStream().flush();
        } catch (IOException e) {
            System.err.println("[hot-reload] Could not connect to Dart at " + DART_TRIGGER_HOST + ":" + DART_TRIGGER_PORT + ": " + e.getMessage());
        }
    }
}
```

- [ ] **Step 4: Verificar que compila**

Ejecutar:
```bash
cd /home/equo/Desktop/equo/equo-ewt/ewt && JAVA_HOME=~/bin/jdk-22 ./gradlew :hot-reload-client:build
```
Esperado: BUILD SUCCESSFUL.

- [ ] **Step 5: Commit**

```bash
git add settings.gradle.kts hot-reload-client/build.gradle.kts hot-reload-client/src/main/java/dev/equo/ewt/hotreload/Main.java
git commit -m "feat(hot-reload): add hot-reload-client subproject (JDWP + TCP trigger)"
```

---

### Task 5: Plugin Gradle `dev.equo.ewt.hot-reload`

**Files:**
- Modify: `settings.gradle.kts` (agregar `include("hot-reload-plugin")`)
- Create: `hot-reload-plugin/build.gradle.kts`
- Create: `hot-reload-plugin/src/main/kotlin/dev/equo/ewt/hotreload/HotReloadPlugin.kt`
- Modify: `examples/build.gradle.kts` (aplicar el plugin y agregar dependencia via `includeBuild` style: como está en el mismo repo, se referencia con `id("dev.equo.ewt.hot-reload")` gracias al `settings` compartido)
- Modify: `settings.gradle.kts` (habilitar plugin management del subproyecto)

**Interfaces:**
- Consumes: subproyecto `:hot-reload-client` (Task 4).
- Produces: plugin ID `dev.equo.ewt.hot-reload`. Cuando un módulo lo aplica, gana un task `hotRun`. El task auto-descubre source dirs, `classes` task del módulo, y `mainClass` del bloque `application`. Cero configuración explícita.

**Contexto:** Un plugin de Gradle es una clase que implementa `org.gradle.api.Plugin<Project>` y se registra vía `pluginManagement` o Gradle Plugin Portal. Para MVP no publicamos — usamos composición de builds locales: el subproyecto `hot-reload-plugin` se agrega a `settings.gradle.kts`, y `examples/build.gradle.kts` lo aplica.

El task `hotRun` que registra el plugin hace:
1. Lee `sourceSets.main.java.srcDirs` del módulo objetivo → pasa al cliente como `sourceDirs`.
2. Lee el nombre completo de la task de compilación (`":<module>:classes"`) → pasa como `gradleCompileTask`.
3. Depende de `tasks.named<JavaExec>("run")` para reutilizar mainClass, classpath, jvmArgs.
4. Antes de ejecutar `run`, inyecta `-agentlib:jdwp=...` a los `jvmArgs` de `run`.
5. Antes de ejecutar `run`, arranca el cliente `hot-reload-client` en background (via `ProcessBuilder`, con shutdown hook para matarlo al terminar).
6. `finalizedBy(runTask)` para que Gradle corra el `run` después del setup.

Kotlin/JVM plugin porque Gradle soporta plugins en Kotlin nativamente y da tipos.

- [ ] **Step 1: Registrar el subproyecto y habilitar el plugin en `pluginManagement`**

Editar `settings.gradle.kts`. Al principio del archivo (antes de `rootProject.name`), agregar el bloque `pluginManagement` que incluye el subproyecto como builder de plugins locales, y al final agregar el `include`:

```kotlin
pluginManagement {
    includeBuild("hot-reload-plugin")
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "ewt"
include("annotation-processor")
include("ewt.api")
include("examples")
include("generator")
include("widgets")
include("hot-reload-client")
include("hot-reload-plugin")
```

(Task 4 ya agregó `include("hot-reload-client")` — verificar que quede una sola vez.)

- [ ] **Step 2: Crear `hot-reload-plugin/settings.gradle.kts`**

Como `hot-reload-plugin` se declara con `includeBuild`, necesita su propio `settings.gradle.kts` para que Gradle lo trate como composite build. Crear `hot-reload-plugin/settings.gradle.kts`:

```kotlin
rootProject.name = "hot-reload-plugin"
```

- [ ] **Step 3: Crear `hot-reload-plugin/build.gradle.kts`**

```kotlin
plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
}

group = "dev.equo.ewt"
version = "0.1.0"

repositories {
    mavenCentral()
    gradlePluginPortal()
}

gradlePlugin {
    plugins {
        create("hotReload") {
            id = "dev.equo.ewt.hot-reload"
            implementationClass = "dev.equo.ewt.hotreload.HotReloadPlugin"
        }
    }
}
```

- [ ] **Step 4: Crear `HotReloadPlugin.kt`**

Crear `hot-reload-plugin/src/main/kotlin/dev/equo/ewt/hotreload/HotReloadPlugin.kt`:

```kotlin
package dev.equo.ewt.hotreload

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.JavaExec
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.api.tasks.SourceSetContainer

class HotReloadPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.tasks.register("hotRun") {
            group = "application"
            description = "Runs the EWT application with Java hot-reload enabled."

            // Depends on the standard `run` task provided by the application plugin.
            val runTask = target.tasks.named("run", JavaExec::class.java).get()
            dependsOn(runTask.taskDependencies)

            doFirst {
                // 1. Enable JDWP on the target JVM.
                val jdwp = "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=localhost:5005"
                val existingJvmArgs = runTask.jvmArgs?.toMutableList() ?: mutableListOf()
                if (existingJvmArgs.none { it.startsWith("-agentlib:jdwp") }) {
                    existingJvmArgs.add(jdwp)
                    runTask.jvmArgs = existingJvmArgs
                }

                // 2. Auto-discover source dirs of the target module.
                val sourceSets = target.extensions.getByType(JavaPluginExtension::class.java).sourceSets
                val mainJava = sourceSets.getByName("main").java.srcDirs
                    .filter { it.exists() }
                    .map { it.absolutePath }
                    .toMutableList()
                // Also include ewt.api so contributors can edit the framework itself if desired.
                val ewtApiSrc = target.rootProject.file("ewt.api/src/main/java")
                if (ewtApiSrc.exists()) mainJava.add(ewtApiSrc.absolutePath)
                val sourceDirs = mainJava.joinToString(",")

                // 3. Compile task of the target module.
                val gradleCompileTask = "${target.path}:classes"

                // 4. Ensure the client is installed.
                target.exec {
                    workingDir = target.rootProject.projectDir
                    commandLine("./gradlew", ":hot-reload-client:installDist", "-q")
                }

                // 5. Launch the client in the background.
                val clientScript = target.rootProject.file(
                    "hot-reload-client/build/install/hot-reload-client/bin/hot-reload-client"
                )
                if (!clientScript.exists()) {
                    throw org.gradle.api.GradleException("hot-reload-client not installed at ${clientScript}")
                }

                val pb = ProcessBuilder(
                    clientScript.absolutePath,
                    "-DsourceDirs=$sourceDirs",
                    "-DprojectRoot=${target.rootProject.projectDir.absolutePath}",
                    "-DgradleCompileTask=$gradleCompileTask"
                ).inheritIO()
                pb.environment()["JAVA_HOME"] =
                    System.getenv("JAVA_HOME") ?: System.getProperty("java.home")
                val clientProcess = pb.start()

                Runtime.getRuntime().addShutdownHook(Thread {
                    clientProcess.destroy()
                })
                println("[hot-reload] Client launched (PID ${clientProcess.pid()}).")
            }

            finalizedBy(runTask)
        }
    }
}
```

- [ ] **Step 5: Aplicar el plugin en `:examples` para validar**

Editar `examples/build.gradle.kts`. En el bloque `plugins`, agregar:

```kotlin
plugins {
    id("java")
    application
    id("dev.equo.ewt.hot-reload")
}
```

(Nada más — sin properties, sin extension, sin configuración explícita. Es la validación de que el plugin auto-descubre todo.)

- [ ] **Step 6: Verificar que Gradle reconoce el plugin y el task**

Ejecutar:
```bash
cd /home/equo/Desktop/equo/equo-ewt/ewt && JAVA_HOME=~/bin/jdk-22 ./gradlew :examples:tasks --group=application
```
Esperado: `hotRun` aparece en la lista.

- [ ] **Step 7: Commit**

```bash
git add settings.gradle.kts hot-reload-plugin/ examples/build.gradle.kts
git commit -m "feat(hot-reload): add Gradle plugin dev.equo.ewt.hot-reload"
```

---

### Task 6: Walkthrough manual end-to-end

**Files:** ninguno (solo verificación).

**Interfaces:** ninguna.

**Contexto:** Con todo cableado, correr un ciclo real de hot-reload sobre el ejemplo `Counter`. Cambiar un string en el `build()` de `MyHomePage`, guardar, observar el ciclo compilación + redefine + reassemble + repaint.

- [ ] **Step 1: Build limpio del stack**

Ejecutar en orden:
```bash
cd /home/equo/Desktop/equo/equo-ewt/ewt && JAVA_HOME=~/bin/jdk-22 ./gradlew :generator:generator
cd /home/equo/Desktop/equo/equo-ewt/ewt && JAVA_HOME=~/bin/jdk-22 ./gradlew :ewt.api:jar
cd /home/equo/Desktop/equo/equo-ewt/ewt && JAVA_HOME=~/bin/jdk-22 ./gradlew :hot-reload-client:installDist
```
Esperado: los tres BUILD SUCCESSFUL.

- [ ] **Step 2: Lanzar el demo con hot-reload**

```bash
cd /home/equo/Desktop/equo/equo-ewt/ewt && JAVA_HOME=~/bin/jdk-22 ./gradlew :examples:hotRun -PmainClass=dev.equo.Counter -PuseLocal=true
```

Buscar en stdout:
- `[EWT] Hot-reload server escuchando en localhost:5006`
- `[hot-reload] Conectando a JDWP en localhost:5005...`
- `[hot-reload] Conectado. Watching: ...`

La UI del Counter debe estar visible y funcional (botón +).

- [ ] **Step 3: Editar el título de la home page**

En `examples/src/main/java/dev/equo/Counter.java`, encontrar el string `"Flutter Demo Home Page"` (el que pasan a `new MyHomePage(...)`) y cambiarlo a algo distinto, ej. `"HOT RELOAD WORKS"`.

Guardar el archivo.

- [ ] **Step 4: Observar el ciclo en stdout**

Esperado en el stdout del task:
- `[hot-reload] Cambio detectado, recompilando...`
- `[hot-reload] Recompilado en NNNNms.`
- `[hot-reload] Redefiniendo N clase(s).`
- `[hot-reload] Reload aplicado.`

En la UI: el AppBar de la home page muestra el nuevo string. **El contador vuelve a 0** — es la limitación conocida de UniqueKey; documentada.

- [ ] **Step 5: Editar el cuerpo del handler y verificar**

En el mismo archivo, encontrar `_counter++` en `_incrementCounter` (o el equivalente en el ejemplo). Cambiarlo a `_counter += 2`. Guardar.

Esperado: nuevo ciclo de reload. Al apretar `+`, ahora incrementa de a 2.

- [ ] **Step 6: Editar signature (debe fallar limpio)**

Agregar un campo nuevo a `_MyHomePageState`, ej. `private int extra = 0;`. Guardar.

Esperado: `[hot-reload] Redefinición no soportada (cambio de estructura?): ...`. La app sigue corriendo con bytecode viejo. Documenta que MVP no soporta esto.

- [ ] **Step 7: Cerrar app**

Ctrl+C. El shutdown hook del task debe matar el cliente watcher.

- [ ] **Step 8: Documentar en README y commit final**

Agregar sección a `README.md`:

```markdown
## Hot-Reload (Experimental, MVP)

In any EWT consumer module, apply the plugin:

```kotlin
plugins {
    application
    id("dev.equo.ewt.hot-reload")
}

application {
    mainClass = "com.mycompany.MyApp"
}
```

Run with hot-reload enabled:

```bash
./gradlew hotRun
```

Edit any `.java` under the module's `src/main/java`. On save, the client:
1. Recompiles via `./gradlew :<module>:classes` (module is auto-discovered).
2. Redefines the bytecode in the running JVM through JDWP (`localhost:5005`).
3. Triggers `WidgetsBinding.reassembleApplication()` on the Dart side (over `localhost:5006`).

**MVP limitations:**
- Method-body changes only. Signature changes, new fields, or new classes require a restart.
- State is not preserved (counters reset to 0). This is a consequence of the `UniqueKey` used by `SubStatefulWidget`.
- Debug port is bound to `localhost:5005` only. Do not expose to public interfaces; avoid containerized images that expose it without changes.
```

Commit:
```bash
git add README.md
git commit -m "docs: document hot-reload MVP usage and limitations"
```

---

## Notas para el implementador

- **Cache misses del daemon Gradle**: la primera compilación tras arrancar puede tardar 10s+. Subsecuentes suelen ser 1-3s. Documentar si duele.
- **Debounce**: WatchService dispara múltiples eventos por save de IDE (temp files, atomic rename). El sleep de 150ms + `poll()` recolector cubre eso para MVP.
- **Kernel Linux WatchService**: `java.nio.file.WatchService` en Linux usa `inotify`. Está bien para árboles chicos; si `examples/` crece mucho hay que reevaluar.
- **Windows/macOS**: no probado en MVP. `Path.register` y `redefineClasses` son cross-platform, pero el shell script `hot-reload-client/bin/hot-reload-client` no corre en Windows — hay `.bat`. Ajustar el `ProcessBuilder` en Task 5 con `Os.isFamily` si aparece el caso.
- **Errores comunes**:
  - "Connection refused" al inicio: el JVM aún no bindeó JDWP. El retry de 60s cubre esto.
  - "Unable to open debug port": puerto ocupado. Matar cualquier proceso `java` colgado.
  - "class not loaded in target VM": la clase aún no fue tocada por el mainClass path. Interactuar con la UI para forzar carga y reintentar.
