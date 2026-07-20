package dev.equo.ewt;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Map;
import org.junit.jupiter.api.Test;

class CallbackCaptureTest {
  @Test
  void zeroArgCallbackIsStoredUnderItsReservedId() throws Exception {
    WidgetConstructors previous = NativeObj.Base.factories;
    SerializingWidgetConstructors s = new SerializingWidgetConstructors();
    NativeObj.Base.factories = s;
    try {
      boolean[] ran = {false};
      // FilledButton(onPressed).child(Text) — onPressed is a zero-arg Runnable.
      var btn = EWT.FilledButton(() -> ran[0] = true)
          .child(EWT.Text("Follow"))
          .build();
      Map<Integer, Object> cbs = s.callbacks();
      assertEquals(1, cbs.size(), "exactly one zero-arg callback recorded");
      Object cb = cbs.values().iterator().next();
      assertInstanceOf(Runnable.class, cb);
      ((Runnable) cb).run();
      assertTrue(ran[0], "stored Runnable is the original onPressed");
    } finally {
      NativeObj.Base.factories = previous;
    }
  }
}
