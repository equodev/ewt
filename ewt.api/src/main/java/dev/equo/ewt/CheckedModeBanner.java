package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class CheckedModeBanner extends StatelessWidget implements CheckedModeBannerI {
  protected CheckedModeBanner() {}
  CheckedModeBanner(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget CheckedModeBanner");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static CheckedModeBanner checkedModeBannerCheckedModeBanner(@Builder.Parameter WidgetI child) {
    int id = factories.checkedModeBannerCheckedModeBanner(child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget CheckedModeBanner");
    return new CheckedModeBanner(id);
  }
  public static CheckedModeBannerCheckedModeBannerBuilder checkedModeBanner(WidgetI child) {
    return CheckedModeBannerCheckedModeBannerBuilder.checkedModeBannerCheckedModeBanner(child);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkedModeBannerChild not supported on web");
    return factories.CheckedModeBanner_readBack_child(nativeStruct);
  }
  @Override
  public CheckedModeBanner build() {
    return this;
  }
}
