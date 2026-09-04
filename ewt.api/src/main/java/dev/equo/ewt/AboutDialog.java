package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.AboutDialogObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class AboutDialog extends StatelessWidget implements AboutDialogI {
  private MemorySegment st;
  protected AboutDialog() {}
  AboutDialog(MemorySegment st) {
    this.id = AboutDialogObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget AboutDialog");
    System.out.println("New AboutDialog id:"+id);
  }
  AboutDialog(int id) { this.id = id; }
  @Builder.Factory
  static AboutDialog aboutDialogAboutDialog(Optional<String> applicationName, Optional<String> applicationVersion, Optional<WidgetI> applicationIcon, Optional<String> applicationLegalese, Optional<List<WidgetI>> children) {
    var st = factories.aboutDialogAboutDialog(applicationName,
      applicationVersion,
      applicationIcon.map(WidgetI::build),
      applicationLegalese,
      children.map(i -> i.stream().map(WidgetI::build).toList()));
    if (st == null) throw new RuntimeException("Failed to created widget AboutDialog");
    return new AboutDialog(st);
  }
  public static AboutDialogAboutDialogBuilder aboutDialog() {
    return AboutDialogAboutDialogBuilder.aboutDialogAboutDialog();
  }
  @Builder.Factory
  static AboutDialog aboutDialogAdaptive(Optional<String> applicationName, Optional<String> applicationVersion, Optional<WidgetI> applicationIcon, Optional<String> applicationLegalese, Optional<List<WidgetI>> children) {
    var st = factories.aboutDialogAdaptive(applicationName,
      applicationVersion,
      applicationIcon.map(WidgetI::build),
      applicationLegalese,
      children.map(i -> i.stream().map(WidgetI::build).toList()));
    if (st == null) throw new RuntimeException("Failed to created widget AboutDialog");
    return new AboutDialog(st);
  }
  public static AboutDialogAdaptiveBuilder adaptive() {
    return AboutDialogAdaptiveBuilder.aboutDialogAdaptive();
  }
  public String applicationName() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("aboutDialogApplicationName not supported on web");
    return AboutDialogObjSt.applicationName(st).getString(0);
  }
  public String applicationVersion() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("aboutDialogApplicationVersion not supported on web");
    return AboutDialogObjSt.applicationVersion(st).getString(0);
  }
  public Widget applicationIcon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("aboutDialogApplicationIcon not supported on web");
    return new Widget(AboutDialogObjSt.applicationIcon(st)) {};
  }
  public String applicationLegalese() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("aboutDialogApplicationLegalese not supported on web");
    return AboutDialogObjSt.applicationLegalese(st).getString(0);
  }
  @Override
  public AboutDialog build() {
    return this;
  }
}
