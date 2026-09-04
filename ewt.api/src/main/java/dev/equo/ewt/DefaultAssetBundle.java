package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.DefaultAssetBundleObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class DefaultAssetBundle extends InheritedWidget implements DefaultAssetBundleI {
  private MemorySegment st;
  protected DefaultAssetBundle() {}
  DefaultAssetBundle(MemorySegment st) {
    this.id = DefaultAssetBundleObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget DefaultAssetBundle");
    System.out.println("New DefaultAssetBundle id:"+id);
  }
  DefaultAssetBundle(int id) { this.id = id; }
  @Override
  public DefaultAssetBundle build() {
    return this;
  }
}
