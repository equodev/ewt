package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class ExpansionTile extends StatefulWidget implements ExpansionTileI {
  protected ExpansionTile() {}
  ExpansionTile(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget ExpansionTile");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static ExpansionTile expansionTileExpansionTile(Optional<WidgetI> leading, WidgetI title, Optional<WidgetI> subtitle, Optional<Consumer<Boolean>> onExpansionChanged, Optional<List<WidgetI>> children, Optional<WidgetI> trailing, Optional<Boolean> showTrailingIcon, Optional<Boolean> initiallyExpanded, Optional<Boolean> maintainState, Optional<EdgeInsetsGeometryI> tilePadding, Optional<CrossAxisAlignment> expandedCrossAxisAlignment, Optional<AlignmentGeometryI> expandedAlignment, Optional<EdgeInsetsGeometryI> childrenPadding, Optional<ColorI> backgroundColor, Optional<ColorI> collapsedBackgroundColor, Optional<ColorI> textColor, Optional<ColorI> collapsedTextColor, Optional<ColorI> iconColor, Optional<ColorI> collapsedIconColor, Optional<ShapeBorderI> shape, Optional<ShapeBorderI> collapsedShape, Optional<Clip> clipBehavior, Optional<ListTileControlAffinity> controlAffinity, Optional<Boolean> dense, Optional<ColorI> splashColor, Optional<VisualDensityI> visualDensity, OptionalDouble minTileHeight, Optional<Boolean> enableFeedback, Optional<Boolean> enabled, Optional<Boolean> internalAddSemanticForOnTap) {
    int id = factories.expansionTileExpansionTile(leading.map(WidgetI::build),
      title.build(),
      subtitle.map(WidgetI::build),
      onExpansionChanged,
      children.map(i -> i.stream().map(WidgetI::build).collect(java.util.stream.Collectors.toList())),
      trailing.map(WidgetI::build),
      showTrailingIcon,
      initiallyExpanded,
      maintainState,
      tilePadding.map(EdgeInsetsGeometryI::build),
      expandedCrossAxisAlignment,
      expandedAlignment.map(AlignmentGeometryI::build),
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
      splashColor.map(ColorI::build),
      visualDensity.map(VisualDensityI::build),
      minTileHeight,
      enableFeedback,
      enabled,
      internalAddSemanticForOnTap);
    if (id <= 0) throw new RuntimeException("Failed to created widget ExpansionTile");
    return new ExpansionTile(id);
  }
  public static ExpansionTileExpansionTileBuilder expansionTile() {
    return ExpansionTileExpansionTileBuilder.expansionTileExpansionTile();
  }
  public Widget leading() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("expansionTileLeading not supported on web");
    return factories.ExpansionTile_readBack_leading(nativeStruct);
  }
  public Widget title() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("expansionTileTitle not supported on web");
    return factories.ExpansionTile_readBack_title(nativeStruct);
  }
  public Widget subtitle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("expansionTileSubtitle not supported on web");
    return factories.ExpansionTile_readBack_subtitle(nativeStruct);
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("expansionTileBackgroundColor", getId());
      return new Color(__nid);
    }
    return factories.ExpansionTile_readBack_backgroundColor(nativeStruct);
  }
  public Color collapsedBackgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("expansionTileCollapsedBackgroundColor", getId());
      return new Color(__nid);
    }
    return factories.ExpansionTile_readBack_collapsedBackgroundColor(nativeStruct);
  }
  public Widget trailing() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("expansionTileTrailing not supported on web");
    return factories.ExpansionTile_readBack_trailing(nativeStruct);
  }
  public boolean showTrailingIcon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("expansionTileShowTrailingIcon not supported on web");
    return factories.ExpansionTile_readBack_showTrailingIcon(nativeStruct);
  }
  public boolean initiallyExpanded() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("expansionTileInitiallyExpanded not supported on web");
    return factories.ExpansionTile_readBack_initiallyExpanded(nativeStruct);
  }
  public boolean maintainState() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("expansionTileMaintainState not supported on web");
    return factories.ExpansionTile_readBack_maintainState(nativeStruct);
  }
  public EdgeInsetsGeometry tilePadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("expansionTileTilePadding not supported on web");
    return factories.ExpansionTile_readBack_tilePadding(nativeStruct);
  }
  public AlignmentGeometry expandedAlignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("expansionTileExpandedAlignment not supported on web");
    return factories.ExpansionTile_readBack_expandedAlignment(nativeStruct);
  }
  public CrossAxisAlignment expandedCrossAxisAlignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("expansionTileExpandedCrossAxisAlignment not supported on web");
    return factories.ExpansionTile_readBack_expandedCrossAxisAlignment(nativeStruct);
  }
  public EdgeInsetsGeometry childrenPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("expansionTileChildrenPadding not supported on web");
    return factories.ExpansionTile_readBack_childrenPadding(nativeStruct);
  }
  public Color iconColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("expansionTileIconColor", getId());
      return new Color(__nid);
    }
    return factories.ExpansionTile_readBack_iconColor(nativeStruct);
  }
  public Color collapsedIconColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("expansionTileCollapsedIconColor", getId());
      return new Color(__nid);
    }
    return factories.ExpansionTile_readBack_collapsedIconColor(nativeStruct);
  }
  public Color textColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("expansionTileTextColor", getId());
      return new Color(__nid);
    }
    return factories.ExpansionTile_readBack_textColor(nativeStruct);
  }
  public Color collapsedTextColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("expansionTileCollapsedTextColor", getId());
      return new Color(__nid);
    }
    return factories.ExpansionTile_readBack_collapsedTextColor(nativeStruct);
  }
  public ShapeBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("expansionTileShape not supported on web");
    return factories.ExpansionTile_readBack_shape(nativeStruct);
  }
  public ShapeBorder collapsedShape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("expansionTileCollapsedShape not supported on web");
    return factories.ExpansionTile_readBack_collapsedShape(nativeStruct);
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("expansionTileClipBehavior not supported on web");
    return factories.ExpansionTile_readBack_clipBehavior(nativeStruct);
  }
  public ListTileControlAffinity controlAffinity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("expansionTileControlAffinity not supported on web");
    return factories.ExpansionTile_readBack_controlAffinity(nativeStruct);
  }
  public boolean dense() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("expansionTileDense not supported on web");
    return factories.ExpansionTile_readBack_dense(nativeStruct);
  }
  public Color splashColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("expansionTileSplashColor", getId());
      return new Color(__nid);
    }
    return factories.ExpansionTile_readBack_splashColor(nativeStruct);
  }
  public VisualDensity visualDensity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("expansionTileVisualDensity", getId());
      return new VisualDensity(__nid);
    }
    return factories.ExpansionTile_readBack_visualDensity(nativeStruct);
  }
  public double minTileHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("expansionTileMinTileHeight not supported on web");
    return factories.ExpansionTile_readBack_minTileHeight(nativeStruct);
  }
  public boolean enableFeedback() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("expansionTileEnableFeedback not supported on web");
    return factories.ExpansionTile_readBack_enableFeedback(nativeStruct);
  }
  public boolean enabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("expansionTileEnabled not supported on web");
    return factories.ExpansionTile_readBack_enabled(nativeStruct);
  }
  public boolean internalAddSemanticForOnTap() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("expansionTileInternalAddSemanticForOnTap not supported on web");
    return factories.ExpansionTile_readBack_internalAddSemanticForOnTap(nativeStruct);
  }
  @Override
  public ExpansionTile build() {
    return this;
  }
}
