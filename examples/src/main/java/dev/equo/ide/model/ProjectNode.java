package dev.equo.ide.model;

import java.util.List;

/**
 * Node in the project tree. Folder nodes carry children; leaf files
 * carry an empty list. {@code path} is a stable id for expansion state
 * and tab identity.
 */
public record ProjectNode(String path, String name, NodeKind kind, List<ProjectNode> children) {

    public static ProjectNode file(String path, String name, NodeKind kind) {
        return new ProjectNode(path, name, kind, List.of());
    }

    public static ProjectNode folder(String path, String name, List<ProjectNode> children) {
        return new ProjectNode(path, name, NodeKind.FOLDER, children);
    }

    public static ProjectNode project(String path, String name, List<ProjectNode> children) {
        return new ProjectNode(path, name, NodeKind.PROJECT, children);
    }

    public boolean isBranch() {
        return kind == NodeKind.FOLDER || kind == NodeKind.PROJECT;
    }
}
