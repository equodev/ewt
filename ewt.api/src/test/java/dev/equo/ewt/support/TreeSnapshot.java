package dev.equo.ewt.support;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * In-memory representation of the depth-first element-tree JSON snapshot that
 * Dart's {@code engine_hooks.dart} pushes to Java after every rebuild.
 *
 * <p>The snapshot format is a JSON array of objects, one per element:
 * <pre>
 *   [{"t":"MaterialApp","d":0,"r":true},
 *    {"t":"Scaffold","d":1,"r":true},
 *    {"t":"Text","d":5,"r":true,"s":true,"w":120.0,"h":24.0,"k":"my-key"}]
 * </pre>
 *
 * <p>This class deliberately does not depend on Jackson or any external JSON library
 * — the snapshot format is generator-produced and predictable, so a small hand-written
 * walker is enough (~60 lines).
 */
public final class TreeSnapshot {

    private final List<SnapshotNode> nodes;

    private TreeSnapshot(List<SnapshotNode> nodes) {
        this.nodes = nodes;
    }

    /** Returns the first node in traversal order whose widget-type name equals {@code widgetType}. */
    public Optional<SnapshotNode> findFirst(String widgetType) {
        for (SnapshotNode n : nodes) {
            if (widgetType.equals(n.type())) return Optional.of(n);
        }
        return Optional.empty();
    }

    /** All parsed nodes, in the depth-first order Dart emitted them. */
    public List<SnapshotNode> nodes() { return nodes; }

    /** Compact one-line summary of the snapshot — for assertion failure messages. */
    public String summary() {
        var sb = new StringBuilder("[");
        for (int i = 0; i < nodes.size(); i++) {
            if (i > 0) sb.append(", ");
            var n = nodes.get(i);
            sb.append(n.type());
            if (n.hasSize()) sb.append("(").append(n.width()).append("×").append(n.height()).append(")");
        }
        return sb.append("]").toString();
    }

    // ---------------------------------------------------------------------------
    // Minimal JSON parser for the specific format we emit
    // ---------------------------------------------------------------------------

    public static TreeSnapshot parse(String json) {
        List<SnapshotNode> out = new ArrayList<>();
        int i = 0, n = json.length();
        i = skipWs(json, i);
        if (i >= n || json.charAt(i) != '[') return new TreeSnapshot(out);
        i++; // consume '['
        while (i < n) {
            i = skipWs(json, i);
            if (i < n && json.charAt(i) == ']') break;
            if (i < n && json.charAt(i) == ',') { i++; continue; }
            if (i < n && json.charAt(i) == '{') {
                int end = findMatchingBrace(json, i);
                out.add(parseObject(json.substring(i + 1, end)));
                i = end + 1;
            } else {
                i++;
            }
        }
        return new TreeSnapshot(out);
    }

    private static SnapshotNode parseObject(String body) {
        String type = "";
        int depth = 0;
        boolean hasRO = false, hasSize = false;
        double w = 0, h = 0;
        String key = null;

        int i = 0, n = body.length();
        while (i < n) {
            i = skipWs(body, i);
            if (i >= n) break;
            if (body.charAt(i) != '"') { i++; continue; }
            int keyStart = ++i;
            while (i < n && body.charAt(i) != '"') i++;
            String field = body.substring(keyStart, i);
            i++; // closing quote
            i = skipWs(body, i);
            if (i < n && body.charAt(i) == ':') i++;
            i = skipWs(body, i);

            switch (field) {
                case "t" -> { var s = readString(body, i); type = s.value; i = s.next; }
                case "k" -> { var s = readString(body, i); key = s.value; i = s.next; }
                case "d" -> { var num = readNumber(body, i); depth = (int) num.value; i = num.next; }
                case "r" -> { var b = readBool(body, i); hasRO = b.value; i = b.next; }
                case "s" -> { var b = readBool(body, i); hasSize = b.value; i = b.next; }
                case "w" -> { var num = readNumber(body, i); w = num.value; i = num.next; }
                case "h" -> { var num = readNumber(body, i); h = num.value; i = num.next; }
                default -> i = skipValue(body, i);
            }
            i = skipWs(body, i);
            if (i < n && body.charAt(i) == ',') i++;
        }

        return new SnapshotNode(type, depth, hasRO, hasSize, w, h, key);
    }

    private record StrResult(String value, int next) {}
    private record NumResult(double value, int next) {}
    private record BoolResult(boolean value, int next) {}

    private static StrResult readString(String s, int i) {
        if (i < s.length() && s.charAt(i) == '"') i++;
        int start = i;
        while (i < s.length() && s.charAt(i) != '"') i++;
        return new StrResult(s.substring(start, i), i + 1);
    }

    private static NumResult readNumber(String s, int i) {
        int start = i;
        while (i < s.length() && "0123456789.-eE+".indexOf(s.charAt(i)) >= 0) i++;
        return new NumResult(Double.parseDouble(s.substring(start, i)), i);
    }

    private static BoolResult readBool(String s, int i) {
        if (s.startsWith("true", i)) return new BoolResult(true, i + 4);
        if (s.startsWith("false", i)) return new BoolResult(false, i + 5);
        return new BoolResult(false, i);
    }

    private static int skipWs(String s, int i) {
        while (i < s.length() && Character.isWhitespace(s.charAt(i))) i++;
        return i;
    }

    private static int skipValue(String s, int i) {
        i = skipWs(s, i);
        if (i >= s.length()) return i;
        char c = s.charAt(i);
        if (c == '"') return readString(s, i).next;
        if (c == 't' || c == 'f') return readBool(s, i).next;
        if (c == '-' || Character.isDigit(c)) return readNumber(s, i).next;
        return i + 1;
    }

    private static int findMatchingBrace(String s, int openIdx) {
        int depth = 0;
        boolean inStr = false;
        for (int i = openIdx; i < s.length(); i++) {
            char c = s.charAt(i);
            if (inStr) {
                if (c == '"' && s.charAt(i - 1) != '\\') inStr = false;
                continue;
            }
            if (c == '"') { inStr = true; continue; }
            if (c == '{') depth++;
            else if (c == '}') { depth--; if (depth == 0) return i; }
        }
        return s.length();
    }
}
