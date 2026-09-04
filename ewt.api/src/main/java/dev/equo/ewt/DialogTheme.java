package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.DialogThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class DialogTheme extends InheritedTheme implements DialogThemeI {
  private MemorySegment st;
  protected DialogTheme() {}
  DialogTheme(MemorySegment st) {
    this.id = DialogThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget DialogTheme");
    System.out.println("New DialogTheme id:"+id);
  }
  DialogTheme(int id) { this.id = id; }
  @Builder.Factory
  static DialogTheme dialogThemeDialogTheme(Optional<ColorI> backgroundColor, OptionalDouble elevation, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, Optional<ShapeBorderI> shape, Optional<AlignmentGeometryI> alignment, Optional<ColorI> iconColor, Optional<TextStyleI> titleTextStyle, Optional<TextStyleI> contentTextStyle, Optional<EdgeInsetsGeometryI> actionsPadding, Optional<ColorI> barrierColor, Optional<EdgeInsetsI> insetPadding, Optional<Clip> clipBehavior, Optional<WidgetI> child) {
    var st = factories.dialogThemeDialogTheme(backgroundColor.map(ColorI::build),
      elevation,
      shadowColor.map(ColorI::build),
      surfaceTintColor.map(ColorI::build),
      shape.map(ShapeBorderI::build),
      alignment.map(AlignmentGeometryI::build),
      iconColor.map(ColorI::build),
      titleTextStyle.map(TextStyleI::build),
      contentTextStyle.map(TextStyleI::build),
      actionsPadding.map(EdgeInsetsGeometryI::build),
      barrierColor.map(ColorI::build),
      insetPadding.map(EdgeInsetsI::build),
      clipBehavior,
      child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget DialogTheme");
    return new DialogTheme(st);
  }
  public static DialogThemeDialogThemeBuilder dialogTheme() {
    return DialogThemeDialogThemeBuilder.dialogThemeDialogTheme();
  }
  public static DialogTheme lerp(DialogThemeI a, DialogThemeI b, double t) {
    var st = factories.dialogThemeLerp(a.build(),
      b.build(),
      t);
    if (st == null) throw new RuntimeException("Failed to created widget DialogTheme");
    return new DialogTheme(st);
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dialogThemeBackgroundColor", getId());
      return new Color(__nid);
    }
    return new Color(DialogThemeObjSt.backgroundColor(st));
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dialogThemeElevation not supported on web");
    return DialogThemeObjSt.elevation(st);
  }
  public Color shadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dialogThemeShadowColor", getId());
      return new Color(__nid);
    }
    return new Color(DialogThemeObjSt.shadowColor(st));
  }
  public Color surfaceTintColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dialogThemeSurfaceTintColor", getId());
      return new Color(__nid);
    }
    return new Color(DialogThemeObjSt.surfaceTintColor(st));
  }
  public ShapeBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dialogThemeShape not supported on web");
    return new ShapeBorder(DialogThemeObjSt.shape(st)) {};
  }
  public AlignmentGeometry alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dialogThemeAlignment not supported on web");
    return new AlignmentGeometry(DialogThemeObjSt.alignment(st)) {};
  }
  public TextStyle titleTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dialogThemeTitleTextStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(DialogThemeObjSt.titleTextStyle(st));
  }
  public TextStyle contentTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dialogThemeContentTextStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(DialogThemeObjSt.contentTextStyle(st));
  }
  public EdgeInsetsGeometry actionsPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dialogThemeActionsPadding not supported on web");
    return new EdgeInsetsGeometry(DialogThemeObjSt.actionsPadding(st)) {};
  }
  public Color iconColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dialogThemeIconColor", getId());
      return new Color(__nid);
    }
    return new Color(DialogThemeObjSt.iconColor(st));
  }
  public Color barrierColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dialogThemeBarrierColor", getId());
      return new Color(__nid);
    }
    return new Color(DialogThemeObjSt.barrierColor(st));
  }
  public EdgeInsets insetPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dialogThemeInsetPadding", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.EdgeInsetsObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.EdgeInsetsObjSt.id(__st, __nid);
      return new EdgeInsets(__st);
    }
    return new EdgeInsets(DialogThemeObjSt.insetPadding(st));
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dialogThemeClipBehavior not supported on web");
    return Clip.values()[DialogThemeObjSt.clipBehavior(st)];
  }
  @Override
  public DialogTheme build() {
    return this;
  }
}
