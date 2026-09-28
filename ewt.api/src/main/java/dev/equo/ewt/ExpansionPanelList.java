package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class ExpansionPanelList extends StatefulWidget implements ExpansionPanelListI {
  protected ExpansionPanelList() {}
  ExpansionPanelList(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget ExpansionPanelList");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static ExpansionPanelList expansionPanelListExpansionPanelList(Optional<List<ExpansionPanelI>> children, Optional<BiConsumer<Integer, Boolean>> expansionCallback, Optional<DurationI> animationDuration, Optional<ColorI> dividerColor, OptionalDouble elevation, Optional<ColorI> expandIconColor, OptionalDouble materialGapSize) {
    int id = factories.expansionPanelListExpansionPanelList(children.map(i -> i.stream().map(ExpansionPanelI::build).collect(java.util.stream.Collectors.toList())),
      expansionCallback,
      animationDuration.map(DurationI::build),
      dividerColor.map(ColorI::build),
      elevation,
      expandIconColor.map(ColorI::build),
      materialGapSize);
    if (id <= 0) throw new RuntimeException("Failed to created widget ExpansionPanelList");
    return new ExpansionPanelList(id);
  }
  public static ExpansionPanelListExpansionPanelListBuilder expansionPanelList() {
    return ExpansionPanelListExpansionPanelListBuilder.expansionPanelListExpansionPanelList();
  }
  @Builder.Factory
  static ExpansionPanelList expansionPanelListRadio(Optional<List<ExpansionPanelI>> children, Optional<BiConsumer<Integer, Boolean>> expansionCallback, Optional<DurationI> animationDuration, Optional<NativeObj.I> initialOpenPanelValue, Optional<ColorI> dividerColor, OptionalDouble elevation, Optional<ColorI> expandIconColor, OptionalDouble materialGapSize) {
    int id = factories.expansionPanelListRadio(children.map(i -> i.stream().map(ExpansionPanelI::build).collect(java.util.stream.Collectors.toList())),
      expansionCallback,
      animationDuration.map(DurationI::build),
      initialOpenPanelValue.map(NativeObj.I::build),
      dividerColor.map(ColorI::build),
      elevation,
      expandIconColor.map(ColorI::build),
      materialGapSize);
    if (id <= 0) throw new RuntimeException("Failed to created widget ExpansionPanelList");
    return new ExpansionPanelList(id);
  }
  public static ExpansionPanelListRadioBuilder radio() {
    return ExpansionPanelListRadioBuilder.expansionPanelListRadio();
  }
  public Duration animationDuration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("expansionPanelListAnimationDuration", getId());
      return new Duration(__nid);
    }
    return factories.ExpansionPanelList_readBack_animationDuration(nativeStruct);
  }
  public EdgeInsets expandedHeaderPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("expansionPanelListExpandedHeaderPadding", getId());
      return new EdgeInsets(__nid);
    }
    return factories.ExpansionPanelList_readBack_expandedHeaderPadding(nativeStruct);
  }
  public Color dividerColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("expansionPanelListDividerColor", getId());
      return new Color(__nid);
    }
    return factories.ExpansionPanelList_readBack_dividerColor(nativeStruct);
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("expansionPanelListElevation not supported on web");
    return factories.ExpansionPanelList_readBack_elevation(nativeStruct);
  }
  public Color expandIconColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("expansionPanelListExpandIconColor", getId());
      return new Color(__nid);
    }
    return factories.ExpansionPanelList_readBack_expandIconColor(nativeStruct);
  }
  public double materialGapSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("expansionPanelListMaterialGapSize not supported on web");
    return factories.ExpansionPanelList_readBack_materialGapSize(nativeStruct);
  }
  @Override
  public ExpansionPanelList build() {
    return this;
  }
}
