package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.LayoutBuilderObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class LayoutBuilder extends ConstrainedLayoutBuilder<BoxConstraints> implements LayoutBuilderI {
  private MemorySegment st;
  protected LayoutBuilder() {}
  LayoutBuilder(MemorySegment st) {
    this.id = LayoutBuilderObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget LayoutBuilder");
    System.out.println("New LayoutBuilder id:"+id);
  }
  LayoutBuilder(int id) { this.id = id; }
  @Builder.Factory
  static LayoutBuilder layoutBuilderLayoutBuilder(@Builder.Parameter BiFunction<BuildContext, BoxConstraints, Widget> builder) {
    var st = factories.layoutBuilderLayoutBuilder(builder);
    if (st == null) throw new RuntimeException("Failed to created widget LayoutBuilder");
    return new LayoutBuilder(st);
  }
  public static LayoutBuilderLayoutBuilderBuilder layoutBuilder(BiFunction<BuildContext, BoxConstraints, Widget> builder) {
    return LayoutBuilderLayoutBuilderBuilder.layoutBuilderLayoutBuilder(builder);
  }
  @Override
  public LayoutBuilder build() {
    return this;
  }
}
