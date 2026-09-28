package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class DefaultAssetBundle extends InheritedWidget implements DefaultAssetBundleI {
  protected DefaultAssetBundle() {}
  DefaultAssetBundle(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget DefaultAssetBundle");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Override
  public DefaultAssetBundle build() {
    return this;
  }
}
