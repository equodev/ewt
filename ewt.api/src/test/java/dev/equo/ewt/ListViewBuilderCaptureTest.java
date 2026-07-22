package dev.equo.ewt;

import static org.junit.jupiter.api.Assertions.*;
import java.util.concurrent.Callable;
import org.junit.jupiter.api.Test;
import dev.equo.ewt.web.EwtNodeJson;
import static dev.equo.ewt.EWT.*;

class ListViewBuilderCaptureTest {
  static class ListProbe extends SubStatefulWidget {
    @Override protected State<ListProbe> createState() { return new S(); }
    static class S extends SubState<ListProbe> {
      @Override public Widget build(BuildContext context) {
        return ListView_builder()
            .itemCount(3)
            .itemBuilder((ctx, i) -> Text("item" + i).build())
            .build();
      }
    }
  }

  @Test
  void listViewBuilderEagerlyExpandsToPlainListNode() throws Exception {
    Callable<Widget> builder = ListProbe::new;
    EwtCapture cap = EwtWebCapture.captureSubtree(builder);
    String json = EwtNodeJson.encode(cap.root);
    // Recorded as the plain constructor with the 3 expanded children, not an inert builder node.
    assertTrue(json.contains("listViewListView"), "recorded as plain ListView");
    assertFalse(json.contains("listViewBuilder"), "no inert builder node");
    assertTrue(json.contains("item0") && json.contains("item1") && json.contains("item2"),
        "all 3 items eagerly built");
  }
}
