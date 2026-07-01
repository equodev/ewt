package dev.equo.ide.model;

/** Row in the outline panel for the active file. */
public record OutlineItem(Kind kind, String signature, int depth) {
    public enum Kind { CLASS, METHOD, FIELD, HEADING }
}
