package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.CupertinoTextThemeDataObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class CupertinoTextThemeData extends NativeObj.Base implements CupertinoTextThemeDataI {
  private MemorySegment st;
  protected CupertinoTextThemeData() {}
  CupertinoTextThemeData(MemorySegment st) {
    this.id = CupertinoTextThemeDataObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoTextThemeData");
    System.out.println("New CupertinoTextThemeData id:"+id);
  }
  CupertinoTextThemeData(int id) { this.id = id; }
  @Builder.Factory
  static CupertinoTextThemeData cupertinoTextThemeDataCupertinoTextThemeData(Optional<ColorI> primaryColor, Optional<TextStyleI> textStyle, Optional<TextStyleI> actionTextStyle, Optional<TextStyleI> actionSmallTextStyle, Optional<TextStyleI> tabLabelTextStyle, Optional<TextStyleI> navTitleTextStyle, Optional<TextStyleI> navLargeTitleTextStyle, Optional<TextStyleI> navActionTextStyle, Optional<TextStyleI> pickerTextStyle, Optional<TextStyleI> dateTimePickerTextStyle) {
    var st = factories.cupertinoTextThemeDataCupertinoTextThemeData(primaryColor.map(ColorI::build),
      textStyle.map(TextStyleI::build),
      actionTextStyle.map(TextStyleI::build),
      actionSmallTextStyle.map(TextStyleI::build),
      tabLabelTextStyle.map(TextStyleI::build),
      navTitleTextStyle.map(TextStyleI::build),
      navLargeTitleTextStyle.map(TextStyleI::build),
      navActionTextStyle.map(TextStyleI::build),
      pickerTextStyle.map(TextStyleI::build),
      dateTimePickerTextStyle.map(TextStyleI::build));
    if (st == null) throw new RuntimeException("Failed to created widget CupertinoTextThemeData");
    return new CupertinoTextThemeData(st);
  }
  public static CupertinoTextThemeDataCupertinoTextThemeDataBuilder cupertinoTextThemeData() {
    return CupertinoTextThemeDataCupertinoTextThemeDataBuilder.cupertinoTextThemeDataCupertinoTextThemeData();
  }
  public TextStyle textStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoTextThemeDataTextStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(CupertinoTextThemeDataObjSt.textStyle(st));
  }
  public TextStyle actionTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoTextThemeDataActionTextStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(CupertinoTextThemeDataObjSt.actionTextStyle(st));
  }
  public TextStyle actionSmallTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoTextThemeDataActionSmallTextStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(CupertinoTextThemeDataObjSt.actionSmallTextStyle(st));
  }
  public TextStyle tabLabelTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoTextThemeDataTabLabelTextStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(CupertinoTextThemeDataObjSt.tabLabelTextStyle(st));
  }
  public TextStyle navTitleTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoTextThemeDataNavTitleTextStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(CupertinoTextThemeDataObjSt.navTitleTextStyle(st));
  }
  public TextStyle navLargeTitleTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoTextThemeDataNavLargeTitleTextStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(CupertinoTextThemeDataObjSt.navLargeTitleTextStyle(st));
  }
  public TextStyle navActionTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoTextThemeDataNavActionTextStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(CupertinoTextThemeDataObjSt.navActionTextStyle(st));
  }
  public TextStyle pickerTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoTextThemeDataPickerTextStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(CupertinoTextThemeDataObjSt.pickerTextStyle(st));
  }
  public TextStyle dateTimePickerTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoTextThemeDataDateTimePickerTextStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(CupertinoTextThemeDataObjSt.dateTimePickerTextStyle(st));
  }
  @Override
  public CupertinoTextThemeData build() {
    return this;
  }
}
