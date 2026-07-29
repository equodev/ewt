package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.CupertinoPageScaffoldObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class CupertinoPageScaffold extends StatefulWidget implements CupertinoPageScaffoldI {
  private MemorySegment st;
  protected CupertinoPageScaffold() {}
  CupertinoPageScaffold(MemorySegment st) {
    this.id = CupertinoPageScaffoldObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoPageScaffold");
    System.out.println("New CupertinoPageScaffold id:"+id);
  }
  CupertinoPageScaffold(int id) { this.id = id; }
  @Builder.Factory
  static CupertinoPageScaffold cupertinoPageScaffoldCupertinoPageScaffold(Optional<ObstructingPreferredSizeWidgetI> navigationBar, Optional<ColorI> backgroundColor, Optional<Boolean> resizeToAvoidBottomInset, WidgetI child) {
    var st = factories.cupertinoPageScaffoldCupertinoPageScaffold(navigationBar.map(ObstructingPreferredSizeWidgetI::build),
      backgroundColor.map(ColorI::build),
      resizeToAvoidBottomInset,
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget CupertinoPageScaffold");
    return new CupertinoPageScaffold(st);
  }
  public static CupertinoPageScaffoldCupertinoPageScaffoldBuilder cupertinoPageScaffold() {
    return CupertinoPageScaffoldCupertinoPageScaffoldBuilder.cupertinoPageScaffoldCupertinoPageScaffold();
  }
  public ObstructingPreferredSizeWidget navigationBar() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoPageScaffoldNavigationBar not supported on web");
    return new ObstructingPreferredSizeWidget() { public int getId() { return CupertinoPageScaffoldObjSt.navigationBar(st); } };
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoPageScaffoldChild not supported on web");
    return new Widget(CupertinoPageScaffoldObjSt.child(st)) {};
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoPageScaffoldBackgroundColor", getId());
      return new Color(__nid);
    }
    return new Color(CupertinoPageScaffoldObjSt.backgroundColor(st));
  }
  public boolean resizeToAvoidBottomInset() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoPageScaffoldResizeToAvoidBottomInset not supported on web");
    return intToBool(CupertinoPageScaffoldObjSt.resizeToAvoidBottomInset(st));
  }
  @Override
  public CupertinoPageScaffold build() {
    return this;
  }
}
