package dev.equo.ide;

import java.util.ArrayList;
import java.util.List;
import dev.equo.ewt.*;
import static dev.equo.ewt.EWT.*;

import dev.equo.ide.model.EditorTab;
import dev.equo.ide.model.NodeKind;
import dev.equo.ide.model.OutlineItem;

/**
 * Hardcoded fake-highlighted source samples and matching outlines for the
 * project files rendered in the editor. Each call to {@link #span} produces
 * a fresh {@code InlineSpanI} tree because EWT consumes each span's native
 * handle when the parent RichText is realized.
 */
public final class CodeSamples {
    private CodeSamples() {}

    // ── Public API ───────────────────────────────────────────────────────────

    /** Build a highlighted RichText span tree for the given file path. */
    public static InlineSpanI span(String path, boolean dark) {
        return switch (path) {
            case "src/Main.java"     -> mainJava(dark);
            case "src/Utils.java"    -> utilsJava(dark);
            case "src/Config.java"   -> configJava(dark);
            case "README.md"         -> readmeMd(dark);
            default                  -> plain("// no preview available for " + path, dark);
        };
    }

    /** Outline of the given file. Returned fresh each time. */
    public static List<OutlineItem> outline(String path) {
        return switch (path) {
            case "src/Main.java" -> List.of(
                    new OutlineItem(OutlineItem.Kind.CLASS,  "Main",                    0),
                    new OutlineItem(OutlineItem.Kind.METHOD, "main(String[] args)",     1),
                    new OutlineItem(OutlineItem.Kind.METHOD, "greet(String name)",      1)
            );
            case "src/Utils.java" -> List.of(
                    new OutlineItem(OutlineItem.Kind.CLASS,  "Utils",                   0),
                    new OutlineItem(OutlineItem.Kind.METHOD, "capitalize(String)",      1),
                    new OutlineItem(OutlineItem.Kind.METHOD, "isBlank(String)",         1)
            );
            case "src/Config.java" -> List.of(
                    new OutlineItem(OutlineItem.Kind.CLASS,  "Config",                  0),
                    new OutlineItem(OutlineItem.Kind.FIELD,  "VERSION",                 1),
                    new OutlineItem(OutlineItem.Kind.FIELD,  "ENCODING",                1),
                    new OutlineItem(OutlineItem.Kind.METHOD, "defaults()",              1)
            );
            case "README.md" -> List.of(
                    new OutlineItem(OutlineItem.Kind.HEADING, "sample-app",             0),
                    new OutlineItem(OutlineItem.Kind.HEADING, "Getting Started",        1),
                    new OutlineItem(OutlineItem.Kind.HEADING, "License",                1)
            );
            default -> List.of();
        };
    }

    /** How many lines the sample renders — used to draw the gutter. */
    public static int lineCount(String path) {
        return switch (path) {
            case "src/Main.java"   -> 10;
            case "src/Utils.java"  -> 14;
            case "src/Config.java" -> 12;
            case "README.md"       -> 9;
            default                -> 1;
        };
    }

    /** All tabs the tree can open, keyed for quick lookup. */
    public static EditorTab tabFor(String path, String name, NodeKind kind) {
        return new EditorTab(path, name, kind);
    }

    // ── Samples ──────────────────────────────────────────────────────────────

    private static InlineSpanI mainJava(boolean dark) {
        List<InlineSpanI> lines = new ArrayList<>();
        lines.add(line(
                kw("package ", dark), plain("dev.equo.sample;", dark)
        ));
        lines.add(blank());
        lines.add(line(
                cmt("/** Entry point for the sample app. */", dark)
        ));
        lines.add(line(
                kw("public ", dark), kw("class ", dark), ty("Main ", dark), plain("{", dark)
        ));
        lines.add(blank());
        lines.add(line(
                plain("    ", dark),
                kw("public ", dark), kw("static ", dark), kw("void ", dark),
                plain("main(", dark), ty("String", dark), plain("[] args) {", dark)
        ));
        lines.add(line(
                plain("        ", dark), ty("System", dark), plain(".out.println(", dark),
                str("\"Application started...\"", dark), plain(");", dark)
        ));
        lines.add(line(
                plain("    }", dark)
        ));
        lines.add(blank());
        lines.add(line(plain("}", dark)));
        return root(lines);
    }

    private static InlineSpanI utilsJava(boolean dark) {
        List<InlineSpanI> lines = new ArrayList<>();
        lines.add(line(kw("package ", dark), plain("dev.equo.sample;", dark)));
        lines.add(blank());
        lines.add(line(cmt("/** Small string helpers. */", dark)));
        lines.add(line(kw("public ", dark), kw("final ", dark), kw("class ", dark), ty("Utils ", dark), plain("{", dark)));
        lines.add(blank());
        lines.add(line(
                plain("    ", dark), kw("public ", dark), kw("static ", dark), ty("String ", dark),
                plain("capitalize(", dark), ty("String", dark), plain(" s) {", dark)
        ));
        lines.add(line(
                plain("        ", dark), kw("if ", dark), plain("(s == ", dark), kw("null", dark),
                plain(" || s.isEmpty()) ", dark), kw("return", dark), plain(" s;", dark)
        ));
        lines.add(line(
                plain("        ", dark), kw("return ", dark), ty("Character", dark),
                plain(".toUpperCase(s.charAt(", dark), num("0", dark), plain(")) + s.substring(", dark),
                num("1", dark), plain(");", dark)
        ));
        lines.add(line(plain("    }", dark)));
        lines.add(blank());
        lines.add(line(
                plain("    ", dark), kw("public ", dark), kw("static ", dark), kw("boolean ", dark),
                plain("isBlank(", dark), ty("String", dark), plain(" s) {", dark)
        ));
        lines.add(line(
                plain("        ", dark), kw("return ", dark),
                plain("s == ", dark), kw("null", dark), plain(" || s.trim().isEmpty();", dark)
        ));
        lines.add(line(plain("    }", dark)));
        lines.add(line(plain("}", dark)));
        return root(lines);
    }

    private static InlineSpanI configJava(boolean dark) {
        List<InlineSpanI> lines = new ArrayList<>();
        lines.add(line(kw("package ", dark), plain("dev.equo.sample;", dark)));
        lines.add(blank());
        lines.add(line(cmt("// Build-time constants used across the sample.", dark)));
        lines.add(line(kw("public ", dark), kw("final ", dark), kw("class ", dark), ty("Config ", dark), plain("{", dark)));
        lines.add(blank());
        lines.add(line(
                plain("    ", dark), kw("public ", dark), kw("static ", dark), kw("final ", dark),
                ty("String ", dark), plain("VERSION  = ", dark), str("\"1.0.0\"", dark), plain(";", dark)
        ));
        lines.add(line(
                plain("    ", dark), kw("public ", dark), kw("static ", dark), kw("final ", dark),
                ty("String ", dark), plain("ENCODING = ", dark), str("\"UTF-8\"", dark), plain(";", dark)
        ));
        lines.add(blank());
        lines.add(line(
                plain("    ", dark), kw("public ", dark), kw("static ", dark), ty("Config ", dark),
                plain("defaults() {", dark)
        ));
        lines.add(line(
                plain("        ", dark), kw("return ", dark), kw("new ", dark), ty("Config", dark), plain("();", dark)
        ));
        lines.add(line(plain("    }", dark)));
        lines.add(line(plain("}", dark)));
        return root(lines);
    }

    private static InlineSpanI readmeMd(boolean dark) {
        List<InlineSpanI> lines = new ArrayList<>();
        lines.add(line(mdHeading("# sample-app", dark)));
        lines.add(blank());
        lines.add(line(plain("A tiny showcase project rendered inside EWT's IDE demo.", dark)));
        lines.add(blank());
        lines.add(line(mdHeading("## Getting Started", dark)));
        lines.add(blank());
        lines.add(line(plain("Run ", dark), mdCode("./gradlew :examples:run", dark), plain(" to launch the sample.", dark)));
        lines.add(blank());
        lines.add(line(mdHeading("## License", dark)));
        return root(lines);
    }

    // ── Token helpers ────────────────────────────────────────────────────────

    private static InlineSpanI root(List<InlineSpanI> lines) {
        return TextSpan().style(IdePalette.code(false)).children(lines).build();
    }

    private static InlineSpanI line(InlineSpanI... spans) {
        List<InlineSpanI> children = new ArrayList<>(spans.length + 1);
        for (InlineSpanI s : spans) children.add(s);
        children.add(TextSpan().text("\n").build());
        return TextSpan().children(children).build();
    }

    private static InlineSpanI blank() {
        return TextSpan().text("\n").build();
    }

    private static InlineSpanI plain(String text, boolean dark) {
        return TextSpan().text(text).style(IdePalette.code(dark)).build();
    }

    private static InlineSpanI kw(String text, boolean dark) {
        return TextSpan().text(text).style(IdePalette.codeSpanBold(dark, IdePalette.synKeyword(dark))).build();
    }

    private static InlineSpanI ty(String text, boolean dark) {
        return TextSpan().text(text).style(IdePalette.codeSpan(dark, IdePalette.synType(dark))).build();
    }

    private static InlineSpanI str(String text, boolean dark) {
        return TextSpan().text(text).style(IdePalette.codeSpan(dark, IdePalette.synString(dark))).build();
    }

    private static InlineSpanI cmt(String text, boolean dark) {
        return TextSpan().text(text).style(IdePalette.codeSpan(dark, IdePalette.synComment(dark))).build();
    }

    private static InlineSpanI num(String text, boolean dark) {
        return TextSpan().text(text).style(IdePalette.codeSpan(dark, IdePalette.synNumber(dark))).build();
    }

    private static InlineSpanI mdHeading(String text, boolean dark) {
        return TextSpan().text(text)
                .style(IdePalette.codeSpanBold(dark, IdePalette.synKeyword(dark))).build();
    }

    private static InlineSpanI mdCode(String text, boolean dark) {
        return TextSpan().text(text).style(IdePalette.codeSpan(dark, IdePalette.synString(dark))).build();
    }
}
