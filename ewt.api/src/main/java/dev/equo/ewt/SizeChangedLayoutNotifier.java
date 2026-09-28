package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class SizeChangedLayoutNotifier extends SingleChildRenderObjectWidget implements SizeChangedLayoutNotifierI {
  protected SizeChangedLayoutNotifier() {}
  SizeChangedLayoutNotifier(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget SizeChangedLayoutNotifier");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static SizeChangedLayoutNotifier sizeChangedLayoutNotifierSizeChangedLayoutNotifier(Optional<WidgetI> child) {
    int id = factories.sizeChangedLayoutNotifierSizeChangedLayoutNotifier(child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget SizeChangedLayoutNotifier");
    return new SizeChangedLayoutNotifier(id);
  }
  public static SizeChangedLayoutNotifierSizeChangedLayoutNotifierBuilder sizeChangedLayoutNotifier() {
    return SizeChangedLayoutNotifierSizeChangedLayoutNotifierBuilder.sizeChangedLayoutNotifierSizeChangedLayoutNotifier();
  }
  @Override
  public SizeChangedLayoutNotifier build() {
    return this;
  }
}
