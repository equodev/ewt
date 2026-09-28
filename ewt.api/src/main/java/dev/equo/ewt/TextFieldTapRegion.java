package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class TextFieldTapRegion extends TapRegion implements TextFieldTapRegionI {
  protected TextFieldTapRegion() {}
  TextFieldTapRegion(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget TextFieldTapRegion");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static TextFieldTapRegion textFieldTapRegionTextFieldTapRegion(Optional<WidgetI> child, Optional<Boolean> enabled, Optional<Consumer<PointerDownEvent>> onTapOutside, Optional<Consumer<PointerDownEvent>> onTapInside, Optional<Consumer<PointerUpEvent>> onTapUpOutside, Optional<Consumer<PointerUpEvent>> onTapUpInside, Optional<Boolean> consumeOutsideTaps, Optional<String> debugLabel, Optional<NativeObj.I> groupId) {
    int id = factories.textFieldTapRegionTextFieldTapRegion(child.map(WidgetI::build),
      enabled,
      onTapOutside,
      onTapInside,
      onTapUpOutside,
      onTapUpInside,
      consumeOutsideTaps,
      debugLabel,
      groupId.map(NativeObj.I::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget TextFieldTapRegion");
    return new TextFieldTapRegion(id);
  }
  public static TextFieldTapRegionTextFieldTapRegionBuilder textFieldTapRegion() {
    return TextFieldTapRegionTextFieldTapRegionBuilder.textFieldTapRegionTextFieldTapRegion();
  }
  @Override
  public TextFieldTapRegion build() {
    return this;
  }
}
