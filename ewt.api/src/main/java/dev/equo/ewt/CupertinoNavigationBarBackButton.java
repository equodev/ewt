package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class CupertinoNavigationBarBackButton extends StatelessWidget implements CupertinoNavigationBarBackButtonI {
  protected CupertinoNavigationBarBackButton() {}
  CupertinoNavigationBarBackButton(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoNavigationBarBackButton");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static CupertinoNavigationBarBackButton cupertinoNavigationBarBackButtonCupertinoNavigationBarBackButton(Optional<ColorI> color, Optional<String> previousPageTitle, Optional<Runnable> onPressed) {
    int id = factories.cupertinoNavigationBarBackButtonCupertinoNavigationBarBackButton(color.map(ColorI::build),
      previousPageTitle,
      onPressed);
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoNavigationBarBackButton");
    return new CupertinoNavigationBarBackButton(id);
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
    return factories.CupertinoNavigationBarBackButton_readBack_color(nativeStruct);
  }
  public String previousPageTitle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoNavigationBarBackButtonPreviousPageTitle not supported on web");
    return factories.CupertinoNavigationBarBackButton_readBack_previousPageTitle(nativeStruct);
  }
  @Override
  public CupertinoNavigationBarBackButton build() {
    return this;
  }
}
