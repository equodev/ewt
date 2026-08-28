package dev.equo.ewt.support;

import dev.equo.ewt.FlutterErrorRecord;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Thrown by the render-test harness when Flutter reported one or more errors during
 * the frame that rendered a variant.  Bundles all captured records for the test window.
 */
public final class FlutterRenderException extends RuntimeException {

    public FlutterRenderException(List<FlutterErrorRecord> records) {
        super(records.stream()
            .map(r -> "frame=" + r.frameId() + " kind=" + r.kind() + " msg=" + r.message()
                    + (r.stack() == null || r.stack().isEmpty() ? "" : "\n    " + r.stack().replace("\n", "\n    ")))
            .collect(Collectors.joining("\n  ", "flutter errors in window:\n  ", "")));
    }
}
