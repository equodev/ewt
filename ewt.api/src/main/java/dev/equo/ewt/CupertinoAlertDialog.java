package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class CupertinoAlertDialog extends StatefulWidget implements CupertinoAlertDialogI {
  protected CupertinoAlertDialog() {}
  CupertinoAlertDialog(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoAlertDialog");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static CupertinoAlertDialog cupertinoAlertDialogCupertinoAlertDialog(Optional<WidgetI> title, Optional<WidgetI> content, Optional<List<WidgetI>> actions, Optional<DurationI> insetAnimationDuration, Optional<CurveI> insetAnimationCurve) {
    int id = factories.cupertinoAlertDialogCupertinoAlertDialog(title.map(WidgetI::build),
      content.map(WidgetI::build),
      actions.map(i -> i.stream().map(WidgetI::build).collect(java.util.stream.Collectors.toList())),
      insetAnimationDuration.map(DurationI::build),
      insetAnimationCurve.map(CurveI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoAlertDialog");
    return new CupertinoAlertDialog(id);
  }
  public static CupertinoAlertDialogCupertinoAlertDialogBuilder cupertinoAlertDialog() {
    return CupertinoAlertDialogCupertinoAlertDialogBuilder.cupertinoAlertDialogCupertinoAlertDialog();
  }
  public Widget title() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoAlertDialogTitle not supported on web");
    return factories.CupertinoAlertDialog_readBack_title(nativeStruct);
  }
  public Widget content() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoAlertDialogContent not supported on web");
    return factories.CupertinoAlertDialog_readBack_content(nativeStruct);
  }
  public Duration insetAnimationDuration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoAlertDialogInsetAnimationDuration", getId());
      return new Duration(__nid);
    }
    return factories.CupertinoAlertDialog_readBack_insetAnimationDuration(nativeStruct);
  }
  public Curve insetAnimationCurve() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoAlertDialogInsetAnimationCurve not supported on web");
    return factories.CupertinoAlertDialog_readBack_insetAnimationCurve(nativeStruct);
  }
  @Override
  public CupertinoAlertDialog build() {
    return this;
  }
}
