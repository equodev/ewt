package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class CupertinoActionSheet extends StatefulWidget implements CupertinoActionSheetI {
  protected CupertinoActionSheet() {}
  CupertinoActionSheet(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoActionSheet");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static CupertinoActionSheet cupertinoActionSheetCupertinoActionSheet(Optional<WidgetI> title, Optional<WidgetI> message, Optional<List<WidgetI>> actions, Optional<WidgetI> cancelButton) {
    int id = factories.cupertinoActionSheetCupertinoActionSheet(title.map(WidgetI::build),
      message.map(WidgetI::build),
      actions.map(i -> i.stream().map(WidgetI::build).collect(java.util.stream.Collectors.toList())),
      cancelButton.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoActionSheet");
    return new CupertinoActionSheet(id);
  }
  public static CupertinoActionSheetCupertinoActionSheetBuilder cupertinoActionSheet() {
    return CupertinoActionSheetCupertinoActionSheetBuilder.cupertinoActionSheetCupertinoActionSheet();
  }
  public Widget title() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoActionSheetTitle not supported on web");
    return factories.CupertinoActionSheet_readBack_title(nativeStruct);
  }
  public Widget message() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoActionSheetMessage not supported on web");
    return factories.CupertinoActionSheet_readBack_message(nativeStruct);
  }
  public Widget cancelButton() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoActionSheetCancelButton not supported on web");
    return factories.CupertinoActionSheet_readBack_cancelButton(nativeStruct);
  }
  @Override
  public CupertinoActionSheet build() {
    return this;
  }
}
