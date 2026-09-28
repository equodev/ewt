package dev.equo.ewt;

/**
 * A post-frame notification carrying the frame identifier and the depth-first element-tree
 * snapshot emitted by Dart after an armed rebuild.
 *
 * <p>{@code frameId} is the monotonic frame counter value for this frame (set by
 * {@code engine_hooks.dart}'s {@code _frameId} before the rebuild fires). {@code snapshotJson} is a
 * depth-first JSON array of element descriptors; each entry has at minimum
 * {@code {"t":"WidgetType","d":depth,"r":hasRenderObject}}. The first (bootstrap) frame delivers
 * {@code "[]"} because no rebuild has been armed.
 *
 * <p>java-11 split: a plain class (not a record) so it compiles at {@code --release 11}.
 */
public final class PostFrame {
  private final long frameId;
  private final String snapshotJson;

  public PostFrame(long frameId, String snapshotJson) {
    this.frameId = frameId;
    this.snapshotJson = snapshotJson;
  }

  public long frameId() { return frameId; }
  public String snapshotJson() { return snapshotJson; }
}
