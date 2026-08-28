package dev.equo.ewt.support;

/**
 * One element in a {@link TreeSnapshot}: its widget-type name, tree depth,
 * whether it has a RenderObject/RenderBox size, and its rendered dimensions.
 *
 * @param type      element.widget.runtimeType (e.g. "Text", "MaterialApp")
 * @param depth     depth-first traversal depth (root = 0)
 * @param hasRO     true if the element has any RenderObject
 * @param hasSize   true iff the RenderObject is a RenderBox with a set size
 * @param width     size.width (only meaningful when {@code hasSize} is true)
 * @param height    size.height (only meaningful when {@code hasSize} is true)
 * @param key       widget.key.toString() when non-null, else {@code null}
 */
public record SnapshotNode(
    String type,
    int depth,
    boolean hasRO,
    boolean hasSize,
    double width,
    double height,
    String key
) {}
