package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.AboutListTileObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class AboutListTile extends StatelessWidget implements AboutListTileI {
  private MemorySegment st;
  protected AboutListTile() {}
  AboutListTile(MemorySegment st) {
    this.id = AboutListTileObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget AboutListTile");
    System.out.println("New AboutListTile id:"+id);
  }
  AboutListTile(int id) { this.id = id; }
  @Builder.Factory
  static AboutListTile aboutListTileAboutListTile(Optional<WidgetI> icon, Optional<WidgetI> child, Optional<String> applicationName, Optional<String> applicationVersion, Optional<WidgetI> applicationIcon, Optional<String> applicationLegalese, Optional<List<WidgetI>> aboutBoxChildren, Optional<Boolean> dense) {
    var st = factories.aboutListTileAboutListTile(icon.map(WidgetI::build),
      child.map(WidgetI::build),
      applicationName,
      applicationVersion,
      applicationIcon.map(WidgetI::build),
      applicationLegalese,
      aboutBoxChildren.map(i -> i.stream().map(WidgetI::build).toList()),
      dense);
    if (st == null) throw new RuntimeException("Failed to created widget AboutListTile");
    return new AboutListTile(st);
  }
  public static AboutListTileAboutListTileBuilder aboutListTile() {
    return AboutListTileAboutListTileBuilder.aboutListTileAboutListTile();
  }
  public Widget icon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("aboutListTileIcon not supported on web");
    return new Widget(AboutListTileObjSt.icon(st)) {};
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("aboutListTileChild not supported on web");
    return new Widget(AboutListTileObjSt.child(st)) {};
  }
  public String applicationName() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("aboutListTileApplicationName not supported on web");
    return AboutListTileObjSt.applicationName(st).getString(0);
  }
  public String applicationVersion() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("aboutListTileApplicationVersion not supported on web");
    return AboutListTileObjSt.applicationVersion(st).getString(0);
  }
  public Widget applicationIcon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("aboutListTileApplicationIcon not supported on web");
    return new Widget(AboutListTileObjSt.applicationIcon(st)) {};
  }
  public String applicationLegalese() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("aboutListTileApplicationLegalese not supported on web");
    return AboutListTileObjSt.applicationLegalese(st).getString(0);
  }
  public boolean dense() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("aboutListTileDense not supported on web");
    return intToBool(AboutListTileObjSt.dense(st));
  }
  @Override
  public AboutListTile build() {
    return this;
  }
}
