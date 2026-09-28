package dev.equo.ewt;

/**
 * An immutable snapshot of one Flutter framework error, correlated to the frame that produced it.
 * {@code frameId} is the monotonic frame counter at capture time; {@code kind} the exception's
 * runtime type name; {@code message} the summary line; {@code stack} the full Dart stack trace.
 *
 * <p>java-11 split: a plain class (not a record) so it compiles at {@code --release 11}.
 */
public final class FlutterErrorRecord {
  private final long frameId;
  private final String kind;
  private final String message;
  private final String stack;

  public FlutterErrorRecord(long frameId, String kind, String message, String stack) {
    this.frameId = frameId;
    this.kind = kind;
    this.message = message;
    this.stack = stack;
  }

  public long frameId() { return frameId; }
  public String kind() { return kind; }
  public String message() { return message; }
  public String stack() { return stack; }
}
