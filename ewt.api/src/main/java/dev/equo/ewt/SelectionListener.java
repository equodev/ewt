package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class SelectionListener extends StatefulWidget implements SelectionListenerI {
  protected SelectionListener() {}
  SelectionListener(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget SelectionListener");
    this.nativeStruct = factories.takeLastStruct();
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("selectionListenerChild not supported on web");
    return factories.SelectionListener_readBack_child(nativeStruct);
  }
  @Override
  public SelectionListener build() {
    return this;
  }
}
