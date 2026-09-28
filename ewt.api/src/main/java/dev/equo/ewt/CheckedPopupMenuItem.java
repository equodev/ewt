package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class CheckedPopupMenuItem<T> extends PopupMenuItem<T> implements CheckedPopupMenuItemI {
  protected CheckedPopupMenuItem() {}
  CheckedPopupMenuItem(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget CheckedPopupMenuItem");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static <T extends NativeObj> CheckedPopupMenuItem<T> checkedPopupMenuItemCheckedPopupMenuItem(Optional<NativeObj> value, Optional<Boolean> checked, Optional<Boolean> enabled, Optional<EdgeInsetsI> padding, OptionalDouble height, Optional<TextStyleI> labelTextStyle, Optional<WidgetI> child, Optional<Runnable> onTap) {
    int id = factories.checkedPopupMenuItemCheckedPopupMenuItem(value,
      checked,
      enabled,
      padding.map(EdgeInsetsI::build),
      height,
      labelTextStyle.map(TextStyleI::build),
      child.map(WidgetI::build),
      onTap);
    if (id <= 0) throw new RuntimeException("Failed to created widget CheckedPopupMenuItem");
    return new CheckedPopupMenuItem(id);
  }
  public static <T extends NativeObj> CheckedPopupMenuItemCheckedPopupMenuItemBuilder<T> checkedPopupMenuItem() {
    return CheckedPopupMenuItemCheckedPopupMenuItemBuilder.checkedPopupMenuItemCheckedPopupMenuItem();
  }
  public boolean checked() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("checkedPopupMenuItemChecked not supported on web");
    return factories.CheckedPopupMenuItem_readBack_checked(nativeStruct);
  }
  @Override
  public CheckedPopupMenuItem build() {
    return this;
  }
}
