package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class SelectionArea extends StatefulWidget implements SelectionAreaI {
  protected SelectionArea() {}
  SelectionArea(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget SelectionArea");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static SelectionArea selectionAreaSelectionArea(@Builder.Parameter WidgetI child) {
    int id = factories.selectionAreaSelectionArea(child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget SelectionArea");
    return new SelectionArea(id);
  }
  public static SelectionAreaSelectionAreaBuilder selectionArea(WidgetI child) {
    return SelectionAreaSelectionAreaBuilder.selectionAreaSelectionArea(child);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("selectionAreaChild not supported on web");
    return factories.SelectionArea_readBack_child(nativeStruct);
  }
  @Override
  public SelectionArea build() {
    return this;
  }
}
