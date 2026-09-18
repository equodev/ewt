package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.DropdownMenuItemObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class DropdownMenuItem<T> extends StatelessWidget implements DropdownMenuItemI {
  private MemorySegment st;
  protected DropdownMenuItem() {}
  DropdownMenuItem(MemorySegment st) {
    this.id = DropdownMenuItemObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget DropdownMenuItem");
    System.out.println("New DropdownMenuItem id:"+id);
  }
  DropdownMenuItem(int id) { this.id = id; }
  @Builder.Factory
  static <T extends NativeObj> DropdownMenuItem<T> dropdownMenuItemDropdownMenuItem(Optional<Runnable> onTap, Optional<NativeObj> value, Optional<Boolean> enabled, Optional<AlignmentGeometryI> alignment, WidgetI child) {
    var st = factories.dropdownMenuItemDropdownMenuItem(onTap,
      value,
      enabled,
      alignment.map(AlignmentGeometryI::build),
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget DropdownMenuItem");
    return new DropdownMenuItem(st);
  }
  public static <T extends NativeObj> DropdownMenuItemDropdownMenuItemBuilder<T> dropdownMenuItem() {
    return DropdownMenuItemDropdownMenuItemBuilder.dropdownMenuItemDropdownMenuItem();
  }
  public boolean enabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dropdownMenuItemEnabled not supported on web");
    return intToBool(DropdownMenuItemObjSt.enabled(st));
  }
  @Override
  public DropdownMenuItem build() {
    return this;
  }
}
