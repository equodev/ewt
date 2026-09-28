package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class LayoutBuilder extends ConstrainedLayoutBuilder<BoxConstraints> implements LayoutBuilderI {
  protected LayoutBuilder() {}
  LayoutBuilder(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget LayoutBuilder");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static LayoutBuilder layoutBuilderLayoutBuilder(@Builder.Parameter BiFunction<BuildContext, BoxConstraints, Widget> builder) {
    int id = factories.layoutBuilderLayoutBuilder(builder);
    if (id <= 0) throw new RuntimeException("Failed to created widget LayoutBuilder");
    return new LayoutBuilder(id);
  }
  public static LayoutBuilderLayoutBuilderBuilder layoutBuilder(BiFunction<BuildContext, BoxConstraints, Widget> builder) {
    return LayoutBuilderLayoutBuilderBuilder.layoutBuilderLayoutBuilder(builder);
  }
  @Override
  public LayoutBuilder build() {
    return this;
  }
}
