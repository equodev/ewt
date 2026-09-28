package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class ScaffoldMessenger extends StatefulWidget implements ScaffoldMessengerI {
  protected ScaffoldMessenger() {}
  ScaffoldMessenger(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget ScaffoldMessenger");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static ScaffoldMessenger scaffoldMessengerScaffoldMessenger(@Builder.Parameter WidgetI child) {
    int id = factories.scaffoldMessengerScaffoldMessenger(child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget ScaffoldMessenger");
    return new ScaffoldMessenger(id);
  }
  public static ScaffoldMessengerScaffoldMessengerBuilder scaffoldMessenger(WidgetI child) {
    return ScaffoldMessengerScaffoldMessengerBuilder.scaffoldMessengerScaffoldMessenger(child);
  }
  public static void showSnackBar(BuildContextI context, SnackBarI snackBar) {
    factories.scaffoldMessengerShowSnackBar(context.build(),
      snackBar.build());
  }
  public static void removeCurrentSnackBar(BuildContextI context) {
    factories.scaffoldMessengerRemoveCurrentSnackBar(context.build(),
      Optional.empty());
  }
  public static void hideCurrentSnackBar(BuildContextI context) {
    factories.scaffoldMessengerHideCurrentSnackBar(context.build(),
      Optional.empty());
  }
  public static void clearSnackBars(BuildContextI context) {
    factories.scaffoldMessengerClearSnackBars(context.build());
  }
  public static void showMaterialBanner(BuildContextI context, MaterialBannerI materialBanner) {
    factories.scaffoldMessengerShowMaterialBanner(context.build(),
      materialBanner.build());
  }
  public static void removeCurrentMaterialBanner(BuildContextI context) {
    factories.scaffoldMessengerRemoveCurrentMaterialBanner(context.build(),
      Optional.empty());
  }
  public static void hideCurrentMaterialBanner(BuildContextI context) {
    factories.scaffoldMessengerHideCurrentMaterialBanner(context.build(),
      Optional.empty());
  }
  public static void clearMaterialBanners(BuildContextI context) {
    factories.scaffoldMessengerClearMaterialBanners(context.build());
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("scaffoldMessengerChild not supported on web");
    return factories.ScaffoldMessenger_readBack_child(nativeStruct);
  }
  @Override
  public ScaffoldMessenger build() {
    return this;
  }
}
