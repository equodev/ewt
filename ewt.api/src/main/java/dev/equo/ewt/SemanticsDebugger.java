package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class SemanticsDebugger extends StatefulWidget implements SemanticsDebuggerI {
  protected SemanticsDebugger() {}
  SemanticsDebugger(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget SemanticsDebugger");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static SemanticsDebugger semanticsDebuggerSemanticsDebugger(@Builder.Parameter WidgetI child, Optional<TextStyleI> labelStyle) {
    int id = factories.semanticsDebuggerSemanticsDebugger(child.build(),
      labelStyle.map(TextStyleI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget SemanticsDebugger");
    return new SemanticsDebugger(id);
  }
  public static SemanticsDebuggerSemanticsDebuggerBuilder semanticsDebugger(WidgetI child) {
    return SemanticsDebuggerSemanticsDebuggerBuilder.semanticsDebuggerSemanticsDebugger(child);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("semanticsDebuggerChild not supported on web");
    return factories.SemanticsDebugger_readBack_child(nativeStruct);
  }
  public TextStyle labelStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("semanticsDebuggerLabelStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.SemanticsDebugger_readBack_labelStyle(nativeStruct);
  }
  @Override
  public SemanticsDebugger build() {
    return this;
  }
}
