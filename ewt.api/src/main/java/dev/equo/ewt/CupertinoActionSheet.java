package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.CupertinoActionSheetObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class CupertinoActionSheet extends StatefulWidget implements CupertinoActionSheetI {
  private MemorySegment st;
  protected CupertinoActionSheet() {}
  CupertinoActionSheet(MemorySegment st) {
    this.id = CupertinoActionSheetObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoActionSheet");
    System.out.println("New CupertinoActionSheet id:"+id);
  }
  CupertinoActionSheet(int id) { this.id = id; }
  @Builder.Factory
  static CupertinoActionSheet cupertinoActionSheetCupertinoActionSheet(Optional<WidgetI> title, Optional<WidgetI> message, Optional<List<WidgetI>> actions, Optional<WidgetI> cancelButton) {
    var st = factories.cupertinoActionSheetCupertinoActionSheet(title.map(WidgetI::build),
      message.map(WidgetI::build),
      actions.map(i -> i.stream().map(WidgetI::build).toList()),
      cancelButton.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget CupertinoActionSheet");
    return new CupertinoActionSheet(st);
  }
  public static CupertinoActionSheetCupertinoActionSheetBuilder cupertinoActionSheet() {
    return CupertinoActionSheetCupertinoActionSheetBuilder.cupertinoActionSheetCupertinoActionSheet();
  }
  public Widget title() {
    return new Widget(CupertinoActionSheetObjSt.title(st)) {};
  }
  public Widget message() {
    return new Widget(CupertinoActionSheetObjSt.message(st)) {};
  }
  public Widget cancelButton() {
    return new Widget(CupertinoActionSheetObjSt.cancelButton(st)) {};
  }
  @Override
  public CupertinoActionSheet build() {
    return this;
  }
}
