package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class ActionIconTheme extends InheritedTheme implements ActionIconThemeI {
  protected ActionIconTheme() {}
  ActionIconTheme(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget ActionIconTheme");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static ActionIconTheme actionIconThemeActionIconTheme(@Builder.Parameter ActionIconThemeDataI data, @Builder.Parameter WidgetI child) {
    int id = factories.actionIconThemeActionIconTheme(data.build(),
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget ActionIconTheme");
    return new ActionIconTheme(id);
  }
  public static ActionIconThemeActionIconThemeBuilder actionIconTheme(ActionIconThemeDataI data, WidgetI child) {
    return ActionIconThemeActionIconThemeBuilder.actionIconThemeActionIconTheme(data, child);
  }
  public static ActionIconThemeData of(BuildContextI context) {
    int id = factories.actionIconThemeOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget ActionIconThemeData");
    return new ActionIconThemeData(id);
  }
  public ActionIconThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("actionIconThemeData", getId());
      return new ActionIconThemeData(__nid);
    }
    return factories.ActionIconTheme_readBack_data(nativeStruct);
  }
  @Override
  public ActionIconTheme build() {
    return this;
  }
}
