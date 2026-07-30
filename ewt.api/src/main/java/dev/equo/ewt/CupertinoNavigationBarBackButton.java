package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.CupertinoNavigationBarBackButtonObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class CupertinoNavigationBarBackButton extends StatelessWidget implements CupertinoNavigationBarBackButtonI {
  private MemorySegment st;
  protected CupertinoNavigationBarBackButton() {}
  CupertinoNavigationBarBackButton(MemorySegment st) {
    this.id = CupertinoNavigationBarBackButtonObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoNavigationBarBackButton");
    System.out.println("New CupertinoNavigationBarBackButton id:"+id);
  }
  CupertinoNavigationBarBackButton(int id) { this.id = id; }
  @Builder.Factory
  static CupertinoNavigationBarBackButton cupertinoNavigationBarBackButtonCupertinoNavigationBarBackButton(Optional<ColorI> color, Optional<String> previousPageTitle, Optional<Runnable> onPressed) {
    var st = factories.cupertinoNavigationBarBackButtonCupertinoNavigationBarBackButton(color.map(ColorI::build),
      previousPageTitle,
      onPressed);
    if (st == null) throw new RuntimeException("Failed to created widget CupertinoNavigationBarBackButton");
    return new CupertinoNavigationBarBackButton(st);
  }
  public static CupertinoNavigationBarBackButtonCupertinoNavigationBarBackButtonBuilder cupertinoNavigationBarBackButton() {
    return CupertinoNavigationBarBackButtonCupertinoNavigationBarBackButtonBuilder.cupertinoNavigationBarBackButtonCupertinoNavigationBarBackButton();
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoNavigationBarBackButtonColor", getId());
      return new Color(__nid);
    }
    return new Color(CupertinoNavigationBarBackButtonObjSt.color(st));
  }
  public String previousPageTitle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoNavigationBarBackButtonPreviousPageTitle not supported on web");
    return CupertinoNavigationBarBackButtonObjSt.previousPageTitle(st).getString(0);
  }
  @Override
  public CupertinoNavigationBarBackButton build() {
    return this;
  }
}
