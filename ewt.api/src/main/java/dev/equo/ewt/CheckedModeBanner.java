package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.CheckedModeBannerObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class CheckedModeBanner extends StatelessWidget implements CheckedModeBannerI {
  private MemorySegment st;
  protected CheckedModeBanner() {}
  CheckedModeBanner(MemorySegment st) {
    this.id = CheckedModeBannerObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget CheckedModeBanner");
    System.out.println("New CheckedModeBanner id:"+id);
  }
  CheckedModeBanner(int id) { this.id = id; }
  @Builder.Factory
  static CheckedModeBanner checkedModeBannerCheckedModeBanner(@Builder.Parameter WidgetI child) {
    var st = factories.checkedModeBannerCheckedModeBanner(child.build());
    if (st == null) throw new RuntimeException("Failed to created widget CheckedModeBanner");
    return new CheckedModeBanner(st);
  }
  public static CheckedModeBannerCheckedModeBannerBuilder checkedModeBanner(WidgetI child) {
    return CheckedModeBannerCheckedModeBannerBuilder.checkedModeBannerCheckedModeBanner(child);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkedModeBannerChild not supported on web");
    return new Widget(CheckedModeBannerObjSt.child(st)) {};
  }
  @Override
  public CheckedModeBanner build() {
    return this;
  }
}
