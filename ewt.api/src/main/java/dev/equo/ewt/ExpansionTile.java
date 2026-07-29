package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ExpansionTileObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class ExpansionTile extends StatefulWidget implements ExpansionTileI {
  private MemorySegment st;
  protected ExpansionTile() {}
  ExpansionTile(MemorySegment st) {
    this.id = ExpansionTileObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget ExpansionTile");
    System.out.println("New ExpansionTile id:"+id);
  }
  ExpansionTile(int id) { this.id = id; }
  @Builder.Factory
  static ExpansionTile expansionTileExpansionTile(Optional<WidgetI> leading, WidgetI title, Optional<WidgetI> subtitle, Optional<Consumer<Boolean>> onExpansionChanged, Optional<List<WidgetI>> children, Optional<WidgetI> trailing, Optional<Boolean> showTrailingIcon, Optional<Boolean> initiallyExpanded, Optional<Boolean> maintainState, Optional<EdgeInsetsGeometryI> tilePadding, Optional<CrossAxisAlignment> expandedCrossAxisAlignment, Optional<AlignmentI> expandedAlignment, Optional<EdgeInsetsGeometryI> childrenPadding, Optional<ColorI> backgroundColor, Optional<ColorI> collapsedBackgroundColor, Optional<ColorI> textColor, Optional<ColorI> collapsedTextColor, Optional<ColorI> iconColor, Optional<ColorI> collapsedIconColor, Optional<ShapeBorderI> shape, Optional<ShapeBorderI> collapsedShape, Optional<Clip> clipBehavior, Optional<ListTileControlAffinity> controlAffinity, Optional<Boolean> dense, Optional<VisualDensityI> visualDensity, OptionalDouble minTileHeight, Optional<Boolean> enableFeedback, Optional<Boolean> enabled, Optional<Boolean> internalAddSemanticForOnTap) {
    var st = factories.expansionTileExpansionTile(leading.map(WidgetI::build),
      title.build(),
      subtitle.map(WidgetI::build),
      onExpansionChanged,
      children.map(i -> i.stream().map(WidgetI::build).toList()),
      trailing.map(WidgetI::build),
      showTrailingIcon,
      initiallyExpanded,
      maintainState,
      tilePadding.map(EdgeInsetsGeometryI::build),
      expandedCrossAxisAlignment,
      expandedAlignment.map(AlignmentI::build),
      childrenPadding.map(EdgeInsetsGeometryI::build),
      backgroundColor.map(ColorI::build),
      collapsedBackgroundColor.map(ColorI::build),
      textColor.map(ColorI::build),
      collapsedTextColor.map(ColorI::build),
      iconColor.map(ColorI::build),
      collapsedIconColor.map(ColorI::build),
      shape.map(ShapeBorderI::build),
      collapsedShape.map(ShapeBorderI::build),
      clipBehavior,
      controlAffinity,
      dense,
      visualDensity.map(VisualDensityI::build),
      minTileHeight,
      enableFeedback,
      enabled,
      internalAddSemanticForOnTap);
    if (st == null) throw new RuntimeException("Failed to created widget ExpansionTile");
    return new ExpansionTile(st);
  }
  public static ExpansionTileExpansionTileBuilder expansionTile() {
    return ExpansionTileExpansionTileBuilder.expansionTileExpansionTile();
  }
  public Widget leading() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("expansionTileLeading not supported on web");
    return new Widget(ExpansionTileObjSt.leading(st)) {};
  }
  public Widget title() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("expansionTileTitle not supported on web");
    return new Widget(ExpansionTileObjSt.title(st)) {};
  }
  public Widget subtitle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("expansionTileSubtitle not supported on web");
    return new Widget(ExpansionTileObjSt.subtitle(st)) {};
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("expansionTileBackgroundColor", getId());
      return new Color(__nid);
    }
    return new Color(ExpansionTileObjSt.backgroundColor(st));
  }
  public Color collapsedBackgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("expansionTileCollapsedBackgroundColor", getId());
      return new Color(__nid);
    }
    return new Color(ExpansionTileObjSt.collapsedBackgroundColor(st));
  }
  public Widget trailing() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("expansionTileTrailing not supported on web");
    return new Widget(ExpansionTileObjSt.trailing(st)) {};
  }
  public boolean showTrailingIcon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("expansionTileShowTrailingIcon not supported on web");
    return intToBool(ExpansionTileObjSt.showTrailingIcon(st));
  }
  public boolean initiallyExpanded() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("expansionTileInitiallyExpanded not supported on web");
    return intToBool(ExpansionTileObjSt.initiallyExpanded(st));
  }
  public boolean maintainState() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("expansionTileMaintainState not supported on web");
    return intToBool(ExpansionTileObjSt.maintainState(st));
  }
  public EdgeInsetsGeometry tilePadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("expansionTileTilePadding not supported on web");
    return new EdgeInsetsGeometry(ExpansionTileObjSt.tilePadding(st)) {};
  }
  public Alignment expandedAlignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("expansionTileExpandedAlignment", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.AlignmentObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.AlignmentObjSt.id(__st, __nid);
      return new Alignment(__st);
    }
    return new Alignment(ExpansionTileObjSt.expandedAlignment(st));
  }
  public CrossAxisAlignment expandedCrossAxisAlignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("expansionTileExpandedCrossAxisAlignment not supported on web");
    return CrossAxisAlignment.values()[ExpansionTileObjSt.expandedCrossAxisAlignment(st)];
  }
  public EdgeInsetsGeometry childrenPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("expansionTileChildrenPadding not supported on web");
    return new EdgeInsetsGeometry(ExpansionTileObjSt.childrenPadding(st)) {};
  }
  public Color iconColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("expansionTileIconColor", getId());
      return new Color(__nid);
    }
    return new Color(ExpansionTileObjSt.iconColor(st));
  }
  public Color collapsedIconColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("expansionTileCollapsedIconColor", getId());
      return new Color(__nid);
    }
    return new Color(ExpansionTileObjSt.collapsedIconColor(st));
  }
  public Color textColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("expansionTileTextColor", getId());
      return new Color(__nid);
    }
    return new Color(ExpansionTileObjSt.textColor(st));
  }
  public Color collapsedTextColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("expansionTileCollapsedTextColor", getId());
      return new Color(__nid);
    }
    return new Color(ExpansionTileObjSt.collapsedTextColor(st));
  }
  public ShapeBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("expansionTileShape not supported on web");
    return new ShapeBorder(ExpansionTileObjSt.shape(st)) {};
  }
  public ShapeBorder collapsedShape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("expansionTileCollapsedShape not supported on web");
    return new ShapeBorder(ExpansionTileObjSt.collapsedShape(st)) {};
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("expansionTileClipBehavior not supported on web");
    return Clip.values()[ExpansionTileObjSt.clipBehavior(st)];
  }
  public ListTileControlAffinity controlAffinity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("expansionTileControlAffinity not supported on web");
    return ListTileControlAffinity.values()[ExpansionTileObjSt.controlAffinity(st)];
  }
  public boolean dense() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("expansionTileDense not supported on web");
    return intToBool(ExpansionTileObjSt.dense(st));
  }
  public VisualDensity visualDensity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("expansionTileVisualDensity", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.VisualDensityObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.VisualDensityObjSt.id(__st, __nid);
      return new VisualDensity(__st);
    }
    return new VisualDensity(ExpansionTileObjSt.visualDensity(st));
  }
  public double minTileHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("expansionTileMinTileHeight not supported on web");
    return ExpansionTileObjSt.minTileHeight(st);
  }
  public boolean enableFeedback() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("expansionTileEnableFeedback not supported on web");
    return intToBool(ExpansionTileObjSt.enableFeedback(st));
  }
  public boolean enabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("expansionTileEnabled not supported on web");
    return intToBool(ExpansionTileObjSt.enabled(st));
  }
  public boolean internalAddSemanticForOnTap() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("expansionTileInternalAddSemanticForOnTap not supported on web");
    return intToBool(ExpansionTileObjSt.internalAddSemanticForOnTap(st));
  }
  @Override
  public ExpansionTile build() {
    return this;
  }
}
