package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.CupertinoSearchTextFieldObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class CupertinoSearchTextField extends StatefulWidget implements CupertinoSearchTextFieldI {
  private MemorySegment st;
  protected CupertinoSearchTextField() {}
  CupertinoSearchTextField(MemorySegment st) {
    this.id = CupertinoSearchTextFieldObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoSearchTextField");
    System.out.println("New CupertinoSearchTextField id:"+id);
  }
  CupertinoSearchTextField(int id) { this.id = id; }
  @Builder.Factory
  static CupertinoSearchTextField cupertinoSearchTextFieldCupertinoSearchTextField(Optional<Consumer<String>> onChanged, Optional<Consumer<String>> onSubmitted, Optional<TextStyleI> style, Optional<String> placeholder, Optional<TextStyleI> placeholderStyle, Optional<BoxDecorationI> decoration, Optional<ColorI> backgroundColor, Optional<BorderRadiusI> borderRadius, Optional<EdgeInsetsGeometryI> padding, Optional<ColorI> itemColor, OptionalDouble itemSize, Optional<EdgeInsetsGeometryI> prefixInsets, Optional<WidgetI> prefixIcon, Optional<EdgeInsetsGeometryI> suffixInsets, Optional<IconI> suffixIcon, Optional<OverlayVisibilityMode> suffixMode, Optional<Runnable> onSuffixTap, Optional<String> restorationId, Optional<SmartQuotesType> smartQuotesType, Optional<SmartDashesType> smartDashesType, Optional<Boolean> enableIMEPersonalizedLearning, Optional<Boolean> autofocus, Optional<Runnable> onTap, Optional<Boolean> autocorrect, Optional<Boolean> enabled, OptionalDouble cursorWidth, OptionalDouble cursorHeight, Optional<RadiusI> cursorRadius, Optional<Boolean> cursorOpacityAnimates, Optional<ColorI> cursorColor) {
    var st = factories.cupertinoSearchTextFieldCupertinoSearchTextField(onChanged,
      onSubmitted,
      style.map(TextStyleI::build),
      placeholder,
      placeholderStyle.map(TextStyleI::build),
      decoration.map(BoxDecorationI::build),
      backgroundColor.map(ColorI::build),
      borderRadius.map(BorderRadiusI::build),
      padding.map(EdgeInsetsGeometryI::build),
      itemColor.map(ColorI::build),
      itemSize,
      prefixInsets.map(EdgeInsetsGeometryI::build),
      prefixIcon.map(WidgetI::build),
      suffixInsets.map(EdgeInsetsGeometryI::build),
      suffixIcon.map(IconI::build),
      suffixMode,
      onSuffixTap,
      restorationId,
      smartQuotesType,
      smartDashesType,
      enableIMEPersonalizedLearning,
      autofocus,
      onTap,
      autocorrect,
      enabled,
      cursorWidth,
      cursorHeight,
      cursorRadius.map(RadiusI::build),
      cursorOpacityAnimates,
      cursorColor.map(ColorI::build));
    if (st == null) throw new RuntimeException("Failed to created widget CupertinoSearchTextField");
    return new CupertinoSearchTextField(st);
  }
  public static CupertinoSearchTextFieldCupertinoSearchTextFieldBuilder cupertinoSearchTextField() {
    return CupertinoSearchTextFieldCupertinoSearchTextFieldBuilder.cupertinoSearchTextFieldCupertinoSearchTextField();
  }
  public TextStyle style() {
    return new TextStyle(CupertinoSearchTextFieldObjSt.style(st));
  }
  public String placeholder() {
    return CupertinoSearchTextFieldObjSt.placeholder(st).getString(0);
  }
  public TextStyle placeholderStyle() {
    return new TextStyle(CupertinoSearchTextFieldObjSt.placeholderStyle(st));
  }
  public BoxDecoration decoration() {
    return new BoxDecoration(CupertinoSearchTextFieldObjSt.decoration(st));
  }
  public Color backgroundColor() {
    return new Color(CupertinoSearchTextFieldObjSt.backgroundColor(st));
  }
  public BorderRadius borderRadius() {
    return new BorderRadius(CupertinoSearchTextFieldObjSt.borderRadius(st));
  }
  public EdgeInsetsGeometry padding() {
    return new EdgeInsetsGeometry(CupertinoSearchTextFieldObjSt.padding(st)) {};
  }
  public Color itemColor() {
    return new Color(CupertinoSearchTextFieldObjSt.itemColor(st));
  }
  public double itemSize() {
    return CupertinoSearchTextFieldObjSt.itemSize(st);
  }
  public EdgeInsetsGeometry prefixInsets() {
    return new EdgeInsetsGeometry(CupertinoSearchTextFieldObjSt.prefixInsets(st)) {};
  }
  public Widget prefixIcon() {
    return new Widget(CupertinoSearchTextFieldObjSt.prefixIcon(st)) {};
  }
  public EdgeInsetsGeometry suffixInsets() {
    return new EdgeInsetsGeometry(CupertinoSearchTextFieldObjSt.suffixInsets(st)) {};
  }
  public Icon suffixIcon() {
    return new Icon(CupertinoSearchTextFieldObjSt.suffixIcon(st));
  }
  public OverlayVisibilityMode suffixMode() {
    return OverlayVisibilityMode.values()[CupertinoSearchTextFieldObjSt.suffixMode(st)];
  }
  public String restorationId() {
    return CupertinoSearchTextFieldObjSt.restorationId(st).getString(0);
  }
  public boolean autofocus() {
    return intToBool(CupertinoSearchTextFieldObjSt.autofocus(st));
  }
  public boolean autocorrect() {
    return intToBool(CupertinoSearchTextFieldObjSt.autocorrect(st));
  }
  public SmartQuotesType smartQuotesType() {
    return SmartQuotesType.values()[CupertinoSearchTextFieldObjSt.smartQuotesType(st)];
  }
  public SmartDashesType smartDashesType() {
    return SmartDashesType.values()[CupertinoSearchTextFieldObjSt.smartDashesType(st)];
  }
  public boolean enableIMEPersonalizedLearning() {
    return intToBool(CupertinoSearchTextFieldObjSt.enableIMEPersonalizedLearning(st));
  }
  public boolean enabled() {
    return intToBool(CupertinoSearchTextFieldObjSt.enabled(st));
  }
  public double cursorWidth() {
    return CupertinoSearchTextFieldObjSt.cursorWidth(st);
  }
  public double cursorHeight() {
    return CupertinoSearchTextFieldObjSt.cursorHeight(st);
  }
  public Radius cursorRadius() {
    return new Radius(CupertinoSearchTextFieldObjSt.cursorRadius(st));
  }
  public boolean cursorOpacityAnimates() {
    return intToBool(CupertinoSearchTextFieldObjSt.cursorOpacityAnimates(st));
  }
  public Color cursorColor() {
    return new Color(CupertinoSearchTextFieldObjSt.cursorColor(st));
  }
  @Override
  public CupertinoSearchTextField build() {
    return this;
  }
}
