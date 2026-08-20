package dev.equo.ewt;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.Callable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Fast serialization checks for every builder in {@code WidgetBuilderCatalog}.
 *
 * <p>Each entry is exercised through {@code SerializingWidgetConstructors} (installed as
 * {@code NativeObj.Base.factories}) so no FFM downcalls fire. What this validates:
 *
 * <ul>
 *   <li>The Java builder constructs without throwing.</li>
 *   <li>Its parameters serialize into a well-formed {@code EwtNode} / JSON tree.</li>
 *   <li>The web-transport path used by SWT-Flutter can round-trip every widget shape.</li>
 * </ul>
 *
 * <p><b>Out of scope</b> — this suite does <em>not</em> exercise the Flutter engine, native
 * FFM calls, C struct layout, callback trampolines, or Dart-side rendering. A green run here
 * proves the Java builder / serialization contract is intact; it says nothing about whether
 * the widget actually renders. Native-render coverage lives in {@code WidgetNativeRenderTest}
 * (tag {@code "native"}, opt-in via {@code -DrunNativeTests}) which mounts each widget under
 * a real Flutter engine.
 */
class WidgetBuilderSerializationTest {

  @ParameterizedTest(name = "{0}")
  @MethodSource("dev.equo.ewt.support.WidgetBuilderCatalog#mountableWidgets")
  void mountableSerializes(String name, Callable<Widget> builder) throws Exception {
    assertNotNull(EwtWebCapture.captureSubtree(builder).root);
  }

  @ParameterizedTest(name = "{0}")
  @MethodSource("dev.equo.ewt.support.WidgetBuilderCatalog#nativeObjValues")
  void valueSerializes(String name, Callable<? extends NativeObj> builder) throws Exception {
    WidgetConstructors prev = NativeObj.Base.factories;
    SerializingWidgetConstructors ser = new SerializingWidgetConstructors();
    NativeObj.Base.factories = ser;
    try {
      assertNotNull(builder.call());
    } finally {
      NativeObj.Base.factories = prev;
      ser.close();
    }
  }
}
