package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.CupertinoFormRowObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class CupertinoFormRow extends StatelessWidget implements CupertinoFormRowI {
  private MemorySegment st;
  protected CupertinoFormRow() {}
  CupertinoFormRow(MemorySegment st) {
    this.id = CupertinoFormRowObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoFormRow");
    System.out.println("New CupertinoFormRow id:"+id);
  }
  CupertinoFormRow(int id) { this.id = id; }
  @Builder.Factory
  static CupertinoFormRow cupertinoFormRowCupertinoFormRow(@Builder.Parameter WidgetI child, Optional<WidgetI> prefix, Optional<EdgeInsetsGeometryI> padding, Optional<WidgetI> helper, Optional<WidgetI> error) {
    var st = factories.cupertinoFormRowCupertinoFormRow(child.build(),
      prefix.map(WidgetI::build),
      padding.map(EdgeInsetsGeometryI::build),
      helper.map(WidgetI::build),
      error.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget CupertinoFormRow");
    return new CupertinoFormRow(st);
  }
  public static CupertinoFormRowCupertinoFormRowBuilder cupertinoFormRow(WidgetI child) {
    return CupertinoFormRowCupertinoFormRowBuilder.cupertinoFormRowCupertinoFormRow(child);
  }
  public Widget prefix() {
    return new Widget(CupertinoFormRowObjSt.prefix(st)) {};
  }
  public EdgeInsetsGeometry padding() {
    return new EdgeInsetsGeometry(CupertinoFormRowObjSt.padding(st)) {};
  }
  public Widget helper() {
    return new Widget(CupertinoFormRowObjSt.helper(st)) {};
  }
  public Widget error() {
    return new Widget(CupertinoFormRowObjSt.error(st)) {};
  }
  public Widget child() {
    return new Widget(CupertinoFormRowObjSt.child(st)) {};
  }
  @Override
  public CupertinoFormRow build() {
    return this;
  }
}
