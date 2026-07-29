package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ExpansionPanelListObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class ExpansionPanelList extends StatefulWidget implements ExpansionPanelListI {
  private MemorySegment st;
  protected ExpansionPanelList() {}
  ExpansionPanelList(MemorySegment st) {
    this.id = ExpansionPanelListObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget ExpansionPanelList");
    System.out.println("New ExpansionPanelList id:"+id);
  }
  ExpansionPanelList(int id) { this.id = id; }
  @Builder.Factory
  static ExpansionPanelList expansionPanelListExpansionPanelList(Optional<List<ExpansionPanelI>> children, Optional<BiConsumer<Integer, Boolean>> expansionCallback, Optional<DurationI> animationDuration, Optional<ColorI> dividerColor, OptionalDouble elevation, Optional<ColorI> expandIconColor, OptionalDouble materialGapSize) {
    var st = factories.expansionPanelListExpansionPanelList(children.map(i -> i.stream().map(ExpansionPanelI::build).toList()),
      expansionCallback,
      animationDuration.map(DurationI::build),
      dividerColor.map(ColorI::build),
      elevation,
      expandIconColor.map(ColorI::build),
      materialGapSize);
    if (st == null) throw new RuntimeException("Failed to created widget ExpansionPanelList");
    return new ExpansionPanelList(st);
  }
  public static ExpansionPanelListExpansionPanelListBuilder expansionPanelList() {
    return ExpansionPanelListExpansionPanelListBuilder.expansionPanelListExpansionPanelList();
  }
  @Builder.Factory
  static ExpansionPanelList expansionPanelListRadio(Optional<List<ExpansionPanelI>> children, Optional<BiConsumer<Integer, Boolean>> expansionCallback, Optional<DurationI> animationDuration, Optional<NativeObj.I> initialOpenPanelValue, Optional<ColorI> dividerColor, OptionalDouble elevation, Optional<ColorI> expandIconColor, OptionalDouble materialGapSize) {
    var st = factories.expansionPanelListRadio(children.map(i -> i.stream().map(ExpansionPanelI::build).toList()),
      expansionCallback,
      animationDuration.map(DurationI::build),
      initialOpenPanelValue.map(NativeObj.I::build),
      dividerColor.map(ColorI::build),
      elevation,
      expandIconColor.map(ColorI::build),
      materialGapSize);
    if (st == null) throw new RuntimeException("Failed to created widget ExpansionPanelList");
    return new ExpansionPanelList(st);
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
    return new Duration(ExpansionPanelListObjSt.animationDuration(st));
  }
  public EdgeInsets expandedHeaderPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("expansionPanelListExpandedHeaderPadding", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.EdgeInsetsObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.EdgeInsetsObjSt.id(__st, __nid);
      return new EdgeInsets(__st);
    }
    return new EdgeInsets(ExpansionPanelListObjSt.expandedHeaderPadding(st));
  }
  public Color dividerColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("expansionPanelListDividerColor", getId());
      return new Color(__nid);
    }
    return new Color(ExpansionPanelListObjSt.dividerColor(st));
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("expansionPanelListElevation not supported on web");
    return ExpansionPanelListObjSt.elevation(st);
  }
  public Color expandIconColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("expansionPanelListExpandIconColor", getId());
      return new Color(__nid);
    }
    return new Color(ExpansionPanelListObjSt.expandIconColor(st));
  }
  public double materialGapSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("expansionPanelListMaterialGapSize not supported on web");
    return ExpansionPanelListObjSt.materialGapSize(st);
  }
  @Override
  public ExpansionPanelList build() {
    return this;
  }
}
