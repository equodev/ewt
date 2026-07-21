package org.eclipse.swt.widgets;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import org.junit.jupiter.api.Test;

class EwtWidgetCallbackTest {
  @Test
  void resolveDispatchesZeroArgAndValueCallbacks() {
    boolean[] ran = {false};
    Object[] got = {null};
    Runnable zero = () -> ran[0] = true;
    Consumer<Object> value = v -> got[0] = v;
    Map<Integer, Object> cbs = Map.of(5, zero, 7, value);

    // zero-arg: [5] -> runs the Runnable
    Runnable r0 = EwtWidget.resolveCallback(cbs, List.of(5));
    assertNotNull(r0);
    r0.run();
    assertTrue(ran[0]);

    // value: [7, true] -> Consumer.accept(true)
    Runnable r1 = EwtWidget.resolveCallback(cbs, List.of(7, true));
    assertNotNull(r1);
    r1.run();
    assertEquals(Boolean.TRUE, got[0]);

    // unknown id, wrong shape, non-list -> null
    assertNull(EwtWidget.resolveCallback(cbs, List.of(99)));
    assertNull(EwtWidget.resolveCallback(cbs, List.of()));
    assertNull(EwtWidget.resolveCallback(cbs, "nope"));
    assertNull(EwtWidget.resolveCallback(null, List.of(5)));
  }
}
