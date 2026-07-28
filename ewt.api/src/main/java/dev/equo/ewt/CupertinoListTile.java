package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.CupertinoListTileObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class CupertinoListTile extends StatefulWidget implements CupertinoListTileI {
  private MemorySegment st;
  protected CupertinoListTile() {}
  CupertinoListTile(MemorySegment st) {
    this.id = CupertinoListTileObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoListTile");
    System.out.println("New CupertinoListTile id:"+id);
  }
  CupertinoListTile(int id) { this.id = id; }
  @Builder.Factory
  static CupertinoListTile cupertinoListTileCupertinoListTile(@Builder.Parameter WidgetI title, Optional<WidgetI> subtitle, Optional<WidgetI> additionalInfo, Optional<WidgetI> leading, Optional<WidgetI> trailing, Optional<ColorI> backgroundColor, Optional<ColorI> backgroundColorActivated, Optional<EdgeInsetsGeometryI> padding, OptionalDouble leadingSize, OptionalDouble leadingToTitle) {
    var st = factories.cupertinoListTileCupertinoListTile(title.build(),
      subtitle.map(WidgetI::build),
      additionalInfo.map(WidgetI::build),
      leading.map(WidgetI::build),
      trailing.map(WidgetI::build),
      backgroundColor.map(ColorI::build),
      backgroundColorActivated.map(ColorI::build),
      padding.map(EdgeInsetsGeometryI::build),
      leadingSize,
      leadingToTitle);
    if (st == null) throw new RuntimeException("Failed to created widget CupertinoListTile");
    return new CupertinoListTile(st);
  }
  public static CupertinoListTileCupertinoListTileBuilder cupertinoListTile(WidgetI title) {
    return CupertinoListTileCupertinoListTileBuilder.cupertinoListTileCupertinoListTile(title);
  }
  @Builder.Factory
  static CupertinoListTile cupertinoListTileNotched(@Builder.Parameter WidgetI title, Optional<WidgetI> subtitle, Optional<WidgetI> additionalInfo, Optional<WidgetI> leading, Optional<WidgetI> trailing, Optional<ColorI> backgroundColor, Optional<ColorI> backgroundColorActivated, Optional<EdgeInsetsGeometryI> padding, OptionalDouble leadingSize, OptionalDouble leadingToTitle) {
    var st = factories.cupertinoListTileNotched(title.build(),
      subtitle.map(WidgetI::build),
      additionalInfo.map(WidgetI::build),
      leading.map(WidgetI::build),
      trailing.map(WidgetI::build),
      backgroundColor.map(ColorI::build),
      backgroundColorActivated.map(ColorI::build),
      padding.map(EdgeInsetsGeometryI::build),
      leadingSize,
      leadingToTitle);
    if (st == null) throw new RuntimeException("Failed to created widget CupertinoListTile");
    return new CupertinoListTile(st);
  }
  public static CupertinoListTileNotchedBuilder notched(WidgetI title) {
    return CupertinoListTileNotchedBuilder.cupertinoListTileNotched(title);
  }
  public Widget title() {
    return new Widget(CupertinoListTileObjSt.title(st)) {};
  }
  public Widget subtitle() {
    return new Widget(CupertinoListTileObjSt.subtitle(st)) {};
  }
  public Widget additionalInfo() {
    return new Widget(CupertinoListTileObjSt.additionalInfo(st)) {};
  }
  public Widget leading() {
    return new Widget(CupertinoListTileObjSt.leading(st)) {};
  }
  public Widget trailing() {
    return new Widget(CupertinoListTileObjSt.trailing(st)) {};
  }
  public Color backgroundColor() {
    return new Color(CupertinoListTileObjSt.backgroundColor(st));
  }
  public Color backgroundColorActivated() {
    return new Color(CupertinoListTileObjSt.backgroundColorActivated(st));
  }
  public EdgeInsetsGeometry padding() {
    return new EdgeInsetsGeometry(CupertinoListTileObjSt.padding(st)) {};
  }
  public double leadingSize() {
    return CupertinoListTileObjSt.leadingSize(st);
  }
  public double leadingToTitle() {
    return CupertinoListTileObjSt.leadingToTitle(st);
  }
  @Override
  public CupertinoListTile build() {
    return this;
  }
}
