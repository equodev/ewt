package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.CheckedPopupMenuItemObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class CheckedPopupMenuItem<T> extends PopupMenuItem<T> implements CheckedPopupMenuItemI {
  private MemorySegment st;
  protected CheckedPopupMenuItem() {}
  CheckedPopupMenuItem(MemorySegment st) {
    this.id = CheckedPopupMenuItemObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget CheckedPopupMenuItem");
    System.out.println("New CheckedPopupMenuItem id:"+id);
  }
  CheckedPopupMenuItem(int id) { this.id = id; }
  @Builder.Factory
  static <T extends NativeObj> CheckedPopupMenuItem<T> checkedPopupMenuItemCheckedPopupMenuItem(Optional<NativeObj> value, Optional<Boolean> checked, Optional<Boolean> enabled, Optional<EdgeInsetsI> padding, OptionalDouble height, Optional<WidgetI> child, Optional<Runnable> onTap) {
    var st = factories.checkedPopupMenuItemCheckedPopupMenuItem(value,
      checked,
      enabled,
      padding.map(EdgeInsetsI::build),
      height,
      child.map(WidgetI::build),
      onTap);
    if (st == null) throw new RuntimeException("Failed to created widget CheckedPopupMenuItem");
    return new CheckedPopupMenuItem(st);
  }
  public static <T extends NativeObj> CheckedPopupMenuItemCheckedPopupMenuItemBuilder<T> checkedPopupMenuItem() {
    return CheckedPopupMenuItemCheckedPopupMenuItemBuilder.checkedPopupMenuItemCheckedPopupMenuItem();
  }
  public boolean checked() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkedPopupMenuItemChecked not supported on web");
    return intToBool(CheckedPopupMenuItemObjSt.checked(st));
  }
  @Override
  public CheckedPopupMenuItem build() {
    return this;
  }
}
