package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class DropdownMenuItem<T> extends StatelessWidget implements DropdownMenuItemI {
  protected DropdownMenuItem() {}
  DropdownMenuItem(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget DropdownMenuItem");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static <T extends NativeObj> DropdownMenuItem<T> dropdownMenuItemDropdownMenuItem(Optional<Runnable> onTap, Optional<NativeObj> value, Optional<Boolean> enabled, Optional<AlignmentGeometryI> alignment, WidgetI child) {
    int id = factories.dropdownMenuItemDropdownMenuItem(onTap,
      value,
      enabled,
      alignment.map(AlignmentGeometryI::build),
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget DropdownMenuItem");
    return new DropdownMenuItem(id);
  }
  public static <T extends NativeObj> DropdownMenuItemDropdownMenuItemBuilder<T> dropdownMenuItem() {
    return DropdownMenuItemDropdownMenuItemBuilder.dropdownMenuItemDropdownMenuItem();
  }
  public boolean enabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dropdownMenuItemEnabled not supported on web");
    return factories.DropdownMenuItem_readBack_enabled(nativeStruct);
  }
  @Override
  public DropdownMenuItem build() {
    return this;
  }
}
