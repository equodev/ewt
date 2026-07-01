package dev.equo.ide;

import java.util.List;
import dev.equo.ide.model.ConsoleLine;
import dev.equo.ide.model.NodeKind;
import dev.equo.ide.model.Problem;
import dev.equo.ide.model.ProjectNode;

/** Static mock content shown throughout the IDE showcase. */
public final class SampleProject {
    private SampleProject() {}

    public static ProjectNode root() {
        return ProjectNode.project("sample-app", "sample-app", List.of(
                ProjectNode.folder("sample-app/src", "src", List.of(
                        ProjectNode.file("src/Main.java",   "Main.java",   NodeKind.JAVA),
                        ProjectNode.file("src/Utils.java",  "Utils.java",  NodeKind.JAVA),
                        ProjectNode.file("src/Config.java", "Config.java", NodeKind.JAVA)
                )),
                ProjectNode.folder("sample-app/resources", "resources", List.of(
                        ProjectNode.file("resources/app.properties", "app.properties", NodeKind.RESOURCE),
                        ProjectNode.file("resources/logo.svg",       "logo.svg",       NodeKind.RESOURCE)
                )),
                ProjectNode.file("README.md",     "README.md",     NodeKind.MARKDOWN),
                ProjectNode.file("build.gradle",  "build.gradle",  NodeKind.RESOURCE),
                ProjectNode.file(".gitignore",    ".gitignore",    NodeKind.RESOURCE)
        ));
    }

    public static List<Problem> problems() {
        return List.of(
                new Problem(Problem.Severity.WARN, "src/Utils.java", 8,
                        "Parameter 's' can be marked as @Nullable."),
                new Problem(Problem.Severity.INFO, "src/Config.java", 5,
                        "Field 'VERSION' could be moved to a constants file.")
        );
    }

    public static List<ConsoleLine> console(boolean running) {
        List<ConsoleLine> base = List.of(
                new ConsoleLine(ConsoleLine.Level.INFO,  "10:24:11", "Loading project sample-app"),
                new ConsoleLine(ConsoleLine.Level.INFO,  "10:24:11", "Resolving dependencies"),
                new ConsoleLine(ConsoleLine.Level.INFO,  "10:24:12", "Compiling 3 source files"),
                new ConsoleLine(ConsoleLine.Level.WARN,  "10:24:12", "Utils.java:8 – parameter 's' can be @Nullable"),
                new ConsoleLine(ConsoleLine.Level.INFO,  "10:24:12", "Build finished in 0.42s")
        );
        if (!running) return base;
        java.util.ArrayList<ConsoleLine> out = new java.util.ArrayList<>(base);
        out.add(new ConsoleLine(ConsoleLine.Level.INFO, "10:24:14", "Application started..."));
        out.add(new ConsoleLine(ConsoleLine.Level.INFO, "10:24:14", "Listening on 127.0.0.1:8080"));
        return out;
    }
}
