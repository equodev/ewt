package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.TextFieldTapRegionObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class TextFieldTapRegion extends TapRegion implements TextFieldTapRegionI {
  private MemorySegment st;
  protected TextFieldTapRegion() {}
  TextFieldTapRegion(MemorySegment st) {
    this.id = TextFieldTapRegionObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget TextFieldTapRegion");
    System.out.println("New TextFieldTapRegion id:"+id);
  }
  TextFieldTapRegion(int id) { this.id = id; }
  @Builder.Factory
  static TextFieldTapRegion textFieldTapRegionTextFieldTapRegion(@Builder.Parameter WidgetI child, Optional<Boolean> enabled, Optional<Consumer<PointerDownEvent>> onTapOutside, Optional<Consumer<PointerDownEvent>> onTapInside, Optional<Consumer<PointerUpEvent>> onTapUpOutside, Optional<Consumer<PointerUpEvent>> onTapUpInside, Optional<Boolean> consumeOutsideTaps, Optional<String> debugLabel, Optional<NativeObj.I> groupId) {
    var st = factories.textFieldTapRegionTextFieldTapRegion(child.build(),
      enabled,
      onTapOutside,
      onTapInside,
      onTapUpOutside,
      onTapUpInside,
      consumeOutsideTaps,
      debugLabel,
      groupId.map(NativeObj.I::build));
    if (st == null) throw new RuntimeException("Failed to created widget TextFieldTapRegion");
    return new TextFieldTapRegion(st);
  }
  public static TextFieldTapRegionTextFieldTapRegionBuilder textFieldTapRegion(WidgetI child) {
    return TextFieldTapRegionTextFieldTapRegionBuilder.textFieldTapRegionTextFieldTapRegion(child);
  }
  @Override
  public TextFieldTapRegion build() {
    return this;
  }
}
