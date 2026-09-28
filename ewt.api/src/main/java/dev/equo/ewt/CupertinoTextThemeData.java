package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class CupertinoTextThemeData extends NativeObj.Base implements CupertinoTextThemeDataI {
  protected CupertinoTextThemeData() {}
  CupertinoTextThemeData(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoTextThemeData");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static CupertinoTextThemeData cupertinoTextThemeDataCupertinoTextThemeData(Optional<ColorI> primaryColor, Optional<TextStyleI> textStyle, Optional<TextStyleI> actionTextStyle, Optional<TextStyleI> actionSmallTextStyle, Optional<TextStyleI> tabLabelTextStyle, Optional<TextStyleI> navTitleTextStyle, Optional<TextStyleI> navLargeTitleTextStyle, Optional<TextStyleI> navActionTextStyle, Optional<TextStyleI> pickerTextStyle, Optional<TextStyleI> dateTimePickerTextStyle) {
    int id = factories.cupertinoTextThemeDataCupertinoTextThemeData(primaryColor.map(ColorI::build),
      textStyle.map(TextStyleI::build),
      actionTextStyle.map(TextStyleI::build),
      actionSmallTextStyle.map(TextStyleI::build),
      tabLabelTextStyle.map(TextStyleI::build),
      navTitleTextStyle.map(TextStyleI::build),
      navLargeTitleTextStyle.map(TextStyleI::build),
      navActionTextStyle.map(TextStyleI::build),
      pickerTextStyle.map(TextStyleI::build),
      dateTimePickerTextStyle.map(TextStyleI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoTextThemeData");
    return new CupertinoTextThemeData(id);
  }
  public static CupertinoTextThemeDataCupertinoTextThemeDataBuilder cupertinoTextThemeData() {
    return CupertinoTextThemeDataCupertinoTextThemeDataBuilder.cupertinoTextThemeDataCupertinoTextThemeData();
  }
  public TextStyle textStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoTextThemeDataTextStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.CupertinoTextThemeData_readBack_textStyle(nativeStruct);
  }
  public TextStyle actionTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoTextThemeDataActionTextStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.CupertinoTextThemeData_readBack_actionTextStyle(nativeStruct);
  }
  public TextStyle actionSmallTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoTextThemeDataActionSmallTextStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.CupertinoTextThemeData_readBack_actionSmallTextStyle(nativeStruct);
  }
  public TextStyle tabLabelTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoTextThemeDataTabLabelTextStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.CupertinoTextThemeData_readBack_tabLabelTextStyle(nativeStruct);
  }
  public TextStyle navTitleTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoTextThemeDataNavTitleTextStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.CupertinoTextThemeData_readBack_navTitleTextStyle(nativeStruct);
  }
  public TextStyle navLargeTitleTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoTextThemeDataNavLargeTitleTextStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.CupertinoTextThemeData_readBack_navLargeTitleTextStyle(nativeStruct);
  }
  public TextStyle navActionTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoTextThemeDataNavActionTextStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.CupertinoTextThemeData_readBack_navActionTextStyle(nativeStruct);
  }
  public TextStyle pickerTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoTextThemeDataPickerTextStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.CupertinoTextThemeData_readBack_pickerTextStyle(nativeStruct);
  }
  public TextStyle dateTimePickerTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoTextThemeDataDateTimePickerTextStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.CupertinoTextThemeData_readBack_dateTimePickerTextStyle(nativeStruct);
  }
  @Override
  public CupertinoTextThemeData build() {
    return this;
  }
}
