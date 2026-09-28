package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class IntrinsicHeight extends SingleChildRenderObjectWidget implements IntrinsicHeightI {
  protected IntrinsicHeight() {}
  IntrinsicHeight(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget IntrinsicHeight");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static IntrinsicHeight intrinsicHeightIntrinsicHeight(Optional<WidgetI> child) {
    int id = factories.intrinsicHeightIntrinsicHeight(child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget IntrinsicHeight");
    return new IntrinsicHeight(id);
  }
  public static IntrinsicHeightIntrinsicHeightBuilder intrinsicHeight() {
    return IntrinsicHeightIntrinsicHeightBuilder.intrinsicHeightIntrinsicHeight();
  }
  @Override
  public IntrinsicHeight build() {
    return this;
  }
}
