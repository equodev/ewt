package dev.equo.ewt;

/**
 * An immutable snapshot of one Flutter framework error, correlated to the frame that
 * produced it.
 *
 * @param frameId the monotonic frame counter value at the time the error was captured
 * @param kind    the runtime type name of the exception (from
 *                {@code FlutterErrorDetails.exception.runtimeType.toString()})
 * @param message the first-line / summary of the error message
 * @param stack   full Dart stack trace as a string
 */
public record FlutterErrorRecord(long frameId, String kind, String message, String stack) {}
