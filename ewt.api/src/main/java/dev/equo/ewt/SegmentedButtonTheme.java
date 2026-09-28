package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class SegmentedButtonTheme extends InheritedTheme implements SegmentedButtonThemeI {
  protected SegmentedButtonTheme() {}
  SegmentedButtonTheme(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget SegmentedButtonTheme");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static SegmentedButtonTheme segmentedButtonThemeSegmentedButtonTheme(@Builder.Parameter SegmentedButtonThemeDataI data, @Builder.Parameter WidgetI child) {
    int id = factories.segmentedButtonThemeSegmentedButtonTheme(data.build(),
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget SegmentedButtonTheme");
    return new SegmentedButtonTheme(id);
  }
  public static SegmentedButtonThemeSegmentedButtonThemeBuilder segmentedButtonTheme(SegmentedButtonThemeDataI data, WidgetI child) {
    return SegmentedButtonThemeSegmentedButtonThemeBuilder.segmentedButtonThemeSegmentedButtonTheme(data, child);
  }
  public static SegmentedButtonThemeData of(BuildContextI context) {
    int id = factories.segmentedButtonThemeOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget SegmentedButtonThemeData");
    return new SegmentedButtonThemeData(id);
  }
  public static SegmentedButtonThemeData maybeOf(BuildContextI context) {
    int id = factories.segmentedButtonThemeMaybeOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget SegmentedButtonThemeData");
    return new SegmentedButtonThemeData(id);
  }
  public SegmentedButtonThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("segmentedButtonThemeData", getId());
      return new SegmentedButtonThemeData(__nid);
    }
    return factories.SegmentedButtonTheme_readBack_data(nativeStruct);
  }
  @Override
  public SegmentedButtonTheme build() {
    return this;
  }
}
