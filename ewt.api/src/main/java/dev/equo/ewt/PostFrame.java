package dev.equo.ewt;

/**
 * A post-frame notification carrying the frame identifier and the depth-first element-tree
 * snapshot emitted by Dart after an armed rebuild.
 *
 * @param frameId      the monotonic frame counter value for this frame (set by
 *                     {@code engine_hooks.dart}'s {@code _frameId} before the rebuild fires)
 * @param snapshotJson depth-first JSON array of element descriptors; each entry has at minimum
 *                     {@code {"t":"WidgetType","d":depth,"r":hasRenderObject}}.  The first
 *                     (bootstrap) frame delivers {@code "[]"} because no rebuild has been armed.
 */
public record PostFrame(long frameId, String snapshotJson) {}
