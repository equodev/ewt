package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class AboutListTile extends StatelessWidget implements AboutListTileI {
  protected AboutListTile() {}
  AboutListTile(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget AboutListTile");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static AboutListTile aboutListTileAboutListTile(Optional<WidgetI> icon, Optional<WidgetI> child, Optional<String> applicationName, Optional<String> applicationVersion, Optional<WidgetI> applicationIcon, Optional<String> applicationLegalese, Optional<List<WidgetI>> aboutBoxChildren, Optional<Boolean> dense) {
    int id = factories.aboutListTileAboutListTile(icon.map(WidgetI::build),
      child.map(WidgetI::build),
      applicationName,
      applicationVersion,
      applicationIcon.map(WidgetI::build),
      applicationLegalese,
      aboutBoxChildren.map(i -> i.stream().map(WidgetI::build).collect(java.util.stream.Collectors.toList())),
      dense);
    if (id <= 0) throw new RuntimeException("Failed to created widget AboutListTile");
    return new AboutListTile(id);
  }
  public static AboutListTileAboutListTileBuilder aboutListTile() {
    return AboutListTileAboutListTileBuilder.aboutListTileAboutListTile();
  }
  public Widget icon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("aboutListTileIcon not supported on web");
    return factories.AboutListTile_readBack_icon(nativeStruct);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("aboutListTileChild not supported on web");
    return factories.AboutListTile_readBack_child(nativeStruct);
  }
  public String applicationName() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("aboutListTileApplicationName not supported on web");
    return factories.AboutListTile_readBack_applicationName(nativeStruct);
  }
  public String applicationVersion() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("aboutListTileApplicationVersion not supported on web");
    return factories.AboutListTile_readBack_applicationVersion(nativeStruct);
  }
  public Widget applicationIcon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("aboutListTileApplicationIcon not supported on web");
    return factories.AboutListTile_readBack_applicationIcon(nativeStruct);
  }
  public String applicationLegalese() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("aboutListTileApplicationLegalese not supported on web");
    return factories.AboutListTile_readBack_applicationLegalese(nativeStruct);
  }
  public boolean dense() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("aboutListTileDense not supported on web");
    return factories.AboutListTile_readBack_dense(nativeStruct);
  }
  @Override
  public AboutListTile build() {
    return this;
  }
}
