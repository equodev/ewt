package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class CupertinoFormRow extends StatelessWidget implements CupertinoFormRowI {
  protected CupertinoFormRow() {}
  CupertinoFormRow(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoFormRow");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static CupertinoFormRow cupertinoFormRowCupertinoFormRow(@Builder.Parameter WidgetI child, Optional<WidgetI> prefix, Optional<EdgeInsetsGeometryI> padding, Optional<WidgetI> helper, Optional<WidgetI> error) {
    int id = factories.cupertinoFormRowCupertinoFormRow(child.build(),
      prefix.map(WidgetI::build),
      padding.map(EdgeInsetsGeometryI::build),
      helper.map(WidgetI::build),
      error.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoFormRow");
    return new CupertinoFormRow(id);
  }
  public static CupertinoFormRowCupertinoFormRowBuilder cupertinoFormRow(WidgetI child) {
    return CupertinoFormRowCupertinoFormRowBuilder.cupertinoFormRowCupertinoFormRow(child);
  }
  public Widget prefix() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoFormRowPrefix not supported on web");
    return factories.CupertinoFormRow_readBack_prefix(nativeStruct);
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoFormRowPadding not supported on web");
    return factories.CupertinoFormRow_readBack_padding(nativeStruct);
  }
  public Widget helper() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoFormRowHelper not supported on web");
    return factories.CupertinoFormRow_readBack_helper(nativeStruct);
  }
  public Widget error() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoFormRowError not supported on web");
    return factories.CupertinoFormRow_readBack_error(nativeStruct);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoFormRowChild not supported on web");
    return factories.CupertinoFormRow_readBack_child(nativeStruct);
  }
  @Override
  public CupertinoFormRow build() {
    return this;
  }
}
