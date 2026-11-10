package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class EwtGraphView extends StatefulWidget implements EwtGraphViewI {
  protected EwtGraphView() {}
  EwtGraphView(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget EwtGraphView");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static EwtGraphView ewtGraphViewEwtGraphView(@Builder.Parameter List<WidgetI> nodes, Optional<String> edges, Optional<String> positions, Optional<Consumer<String>> onNodeMoved, OptionalDouble nodeWidth, OptionalDouble nodeHeight) {
    int id = factories.ewtGraphViewEwtGraphView(nodes.stream().map(WidgetI::build).collect(java.util.stream.Collectors.toList()),
      edges,
      positions,
      onNodeMoved,
      nodeWidth,
      nodeHeight);
    if (id <= 0) throw new RuntimeException("Failed to created widget EwtGraphView");
    return new EwtGraphView(id);
  }
  public static EwtGraphViewEwtGraphViewBuilder ewtGraphView(List<WidgetI> nodes) {
    return EwtGraphViewEwtGraphViewBuilder.ewtGraphViewEwtGraphView(nodes);
  }
  public String edges() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("ewtGraphViewEdges not supported on web");
    return factories.EwtGraphView_readBack_edges(nativeStruct);
  }
  public String positions() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("ewtGraphViewPositions not supported on web");
    return factories.EwtGraphView_readBack_positions(nativeStruct);
  }
  public double nodeWidth() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("ewtGraphViewNodeWidth not supported on web");
    return factories.EwtGraphView_readBack_nodeWidth(nativeStruct);
  }
  public double nodeHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("ewtGraphViewNodeHeight not supported on web");
    return factories.EwtGraphView_readBack_nodeHeight(nativeStruct);
  }
  @Override
  public EwtGraphView build() {
    return this;
  }
}
