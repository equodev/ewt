package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.CupertinoAlertDialogObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class CupertinoAlertDialog extends StatefulWidget implements CupertinoAlertDialogI {
  private MemorySegment st;
  protected CupertinoAlertDialog() {}
  CupertinoAlertDialog(MemorySegment st) {
    this.id = CupertinoAlertDialogObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoAlertDialog");
    System.out.println("New CupertinoAlertDialog id:"+id);
  }
  CupertinoAlertDialog(int id) { this.id = id; }
  @Builder.Factory
  static CupertinoAlertDialog cupertinoAlertDialogCupertinoAlertDialog(Optional<WidgetI> title, Optional<WidgetI> content, Optional<List<WidgetI>> actions, Optional<DurationI> insetAnimationDuration, Optional<CurveI> insetAnimationCurve) {
    var st = factories.cupertinoAlertDialogCupertinoAlertDialog(title.map(WidgetI::build),
      content.map(WidgetI::build),
      actions.map(i -> i.stream().map(WidgetI::build).toList()),
      insetAnimationDuration.map(DurationI::build),
      insetAnimationCurve.map(CurveI::build));
    if (st == null) throw new RuntimeException("Failed to created widget CupertinoAlertDialog");
    return new CupertinoAlertDialog(st);
  }
  public static CupertinoAlertDialogCupertinoAlertDialogBuilder cupertinoAlertDialog() {
    return CupertinoAlertDialogCupertinoAlertDialogBuilder.cupertinoAlertDialogCupertinoAlertDialog();
  }
  public Widget title() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoAlertDialogTitle not supported on web");
    return new Widget(CupertinoAlertDialogObjSt.title(st)) {};
  }
  public Widget content() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoAlertDialogContent not supported on web");
    return new Widget(CupertinoAlertDialogObjSt.content(st)) {};
  }
  public Duration insetAnimationDuration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoAlertDialogInsetAnimationDuration", getId());
      return new Duration(__nid);
    }
    return new Duration(CupertinoAlertDialogObjSt.insetAnimationDuration(st));
  }
  public Curve insetAnimationCurve() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoAlertDialogInsetAnimationCurve not supported on web");
    return new Curve(CupertinoAlertDialogObjSt.insetAnimationCurve(st)) {};
  }
  @Override
  public CupertinoAlertDialog build() {
    return this;
  }
}
