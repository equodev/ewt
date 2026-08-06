package dev.equo.ide;

import java.util.ArrayList;
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

    /** Same as {@link #root()} but every branch's {@code children} is a mutable
     * {@link ArrayList}, so the v2 IDE demo can reorder files in place via
     * drag-and-drop without rebuilding the whole tree. */
    public static ProjectNode mutableRoot() {
        return ProjectNode.project("sample-app", "sample-app", new ArrayList<>(List.of(
                ProjectNode.folder("sample-app/src", "src", new ArrayList<>(List.of(
                        ProjectNode.file("src/Main.java",   "Main.java",   NodeKind.JAVA),
                        ProjectNode.file("src/Utils.java",  "Utils.java",  NodeKind.JAVA),
                        ProjectNode.file("src/Config.java", "Config.java", NodeKind.JAVA)
                ))),
                ProjectNode.folder("sample-app/resources", "resources", new ArrayList<>(List.of(
                        ProjectNode.file("resources/app.properties", "app.properties", NodeKind.RESOURCE),
                        ProjectNode.file("resources/logo.svg",       "logo.svg",       NodeKind.RESOURCE)
                ))),
                ProjectNode.file("README.md",     "README.md",     NodeKind.MARKDOWN),
                ProjectNode.file("build.gradle",  "build.gradle",  NodeKind.RESOURCE),
                ProjectNode.file(".gitignore",    ".gitignore",    NodeKind.RESOURCE)
        )));
    }

    public static List<Problem> problems() {
        return List.of(
                new Problem(Problem.Severity.ERROR, "src/Main.java",       42,
                        "Cannot resolve symbol 'HttpServer'."),
                new Problem(Problem.Severity.ERROR, "src/Main.java",       58,
                        "Method 'run()' throws unhandled InterruptedException."),
                new Problem(Problem.Severity.ERROR, "src/db/Repo.java",    17,
                        "Incompatible types: List<String> cannot be converted to List<UUID>."),
                new Problem(Problem.Severity.ERROR, "src/Server.java",     93,
                        "Missing return statement in path 'else if (state == CLOSED)'."),
                new Problem(Problem.Severity.WARN,  "src/Utils.java",       8,
                        "Parameter 's' can be marked as @Nullable."),
                new Problem(Problem.Severity.WARN,  "src/Utils.java",      27,
                        "Unused import: 'java.util.Collections'."),
                new Problem(Problem.Severity.WARN,  "src/db/Repo.java",    64,
                        "Raw use of parameterized class 'Query'."),
                new Problem(Problem.Severity.WARN,  "src/db/Repo.java",   102,
                        "Autoboxing of long inside a hot loop."),
                new Problem(Problem.Severity.WARN,  "src/Server.java",     11,
                        "Field 'DEFAULT_PORT' should be static final."),
                new Problem(Problem.Severity.WARN,  "src/api/Users.java",  33,
                        "Public method 'delete' has no Javadoc."),
                new Problem(Problem.Severity.WARN,  "src/api/Users.java",  71,
                        "'password' should be char[] instead of String."),
                new Problem(Problem.Severity.WARN,  "src/api/Auth.java",   19,
                        "Deprecated call: 'PasswordEncoder.encode(String)'."),
                new Problem(Problem.Severity.WARN,  "src/api/Auth.java",   84,
                        "Empty catch block."),
                new Problem(Problem.Severity.INFO,  "src/Config.java",      5,
                        "Field 'VERSION' could be moved to a constants file."),
                new Problem(Problem.Severity.INFO,  "src/Config.java",     22,
                        "TODO: read timeout from properties file."),
                new Problem(Problem.Severity.INFO,  "src/api/Users.java", 128,
                        "Consider using Stream.toList() instead of collect(toList())."),
                new Problem(Problem.Severity.INFO,  "src/api/Auth.java",   47,
                        "Method reference is more concise than lambda."),
                new Problem(Problem.Severity.INFO,  "src/db/Repo.java",   146,
                        "Extract magic number 3600 to a constant."),
                new Problem(Problem.Severity.INFO,  "src/Server.java",    150,
                        "Chained calls: consider a fluent builder."),
                new Problem(Problem.Severity.INFO,  "src/Main.java",       17,
                        "String literal could be moved to a resource bundle.")
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
