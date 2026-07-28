package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.CupertinoTabViewObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class CupertinoTabView extends StatefulWidget implements CupertinoTabViewI {
  private MemorySegment st;
  protected CupertinoTabView() {}
  CupertinoTabView(MemorySegment st) {
    this.id = CupertinoTabViewObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoTabView");
    System.out.println("New CupertinoTabView id:"+id);
  }
  CupertinoTabView(int id) { this.id = id; }
  @Builder.Factory
  static CupertinoTabView cupertinoTabViewCupertinoTabView(Optional<Function<BuildContext, Widget>> builder, Optional<String> defaultTitle, Optional<String> restorationScopeId) {
    var st = factories.cupertinoTabViewCupertinoTabView(builder,
      defaultTitle,
      restorationScopeId);
    if (st == null) throw new RuntimeException("Failed to created widget CupertinoTabView");
    return new CupertinoTabView(st);
  }
  public static CupertinoTabViewCupertinoTabViewBuilder cupertinoTabView() {
    return CupertinoTabViewCupertinoTabViewBuilder.cupertinoTabViewCupertinoTabView();
  }
  public String defaultTitle() {
    return CupertinoTabViewObjSt.defaultTitle(st).getString(0);
  }
  public String restorationScopeId() {
    return CupertinoTabViewObjSt.restorationScopeId(st).getString(0);
  }
  @Override
  public CupertinoTabView build() {
    return this;
  }
}
