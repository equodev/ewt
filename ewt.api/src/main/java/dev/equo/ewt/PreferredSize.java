package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class PreferredSize extends StatelessWidget implements PreferredSizeWidget, PreferredSizeI {
  protected PreferredSize() {}
  PreferredSize(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget PreferredSize");
    this.nativeStruct = factories.takeLastStruct();
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("preferredSizeChild not supported on web");
    return factories.PreferredSize_readBack_child(nativeStruct);
  }
  @Override
  public PreferredSize build() {
    return this;
  }
}
