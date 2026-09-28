package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class AboutDialog extends StatelessWidget implements AboutDialogI {
  protected AboutDialog() {}
  AboutDialog(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget AboutDialog");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static AboutDialog aboutDialogAboutDialog(Optional<String> applicationName, Optional<String> applicationVersion, Optional<WidgetI> applicationIcon, Optional<String> applicationLegalese, Optional<List<WidgetI>> children) {
    int id = factories.aboutDialogAboutDialog(applicationName,
      applicationVersion,
      applicationIcon.map(WidgetI::build),
      applicationLegalese,
      children.map(i -> i.stream().map(WidgetI::build).collect(java.util.stream.Collectors.toList())));
    if (id <= 0) throw new RuntimeException("Failed to created widget AboutDialog");
    return new AboutDialog(id);
  }
  public static AboutDialogAboutDialogBuilder aboutDialog() {
    return AboutDialogAboutDialogBuilder.aboutDialogAboutDialog();
  }
  @Builder.Factory
  static AboutDialog aboutDialogAdaptive(Optional<String> applicationName, Optional<String> applicationVersion, Optional<WidgetI> applicationIcon, Optional<String> applicationLegalese, Optional<List<WidgetI>> children) {
    int id = factories.aboutDialogAdaptive(applicationName,
      applicationVersion,
      applicationIcon.map(WidgetI::build),
      applicationLegalese,
      children.map(i -> i.stream().map(WidgetI::build).collect(java.util.stream.Collectors.toList())));
    if (id <= 0) throw new RuntimeException("Failed to created widget AboutDialog");
    return new AboutDialog(id);
  }
  public static AboutDialogAdaptiveBuilder adaptive() {
    return AboutDialogAdaptiveBuilder.aboutDialogAdaptive();
  }
  public String applicationName() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("aboutDialogApplicationName not supported on web");
    return factories.AboutDialog_readBack_applicationName(nativeStruct);
  }
  public String applicationVersion() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("aboutDialogApplicationVersion not supported on web");
    return factories.AboutDialog_readBack_applicationVersion(nativeStruct);
  }
  public Widget applicationIcon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("aboutDialogApplicationIcon not supported on web");
    return factories.AboutDialog_readBack_applicationIcon(nativeStruct);
  }
  public String applicationLegalese() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("aboutDialogApplicationLegalese not supported on web");
    return factories.AboutDialog_readBack_applicationLegalese(nativeStruct);
  }
  @Override
  public AboutDialog build() {
    return this;
  }
}
