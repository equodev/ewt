package dev.equo.ide.model;

/** Open editor tab. {@code path} matches the ProjectNode path. */
public record EditorTab(String path, String fileName, NodeKind kind) {}
