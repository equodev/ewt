package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class DropdownMenuEntry<T> extends NativeObj.Base implements DropdownMenuEntryI {
  protected DropdownMenuEntry() {}
  DropdownMenuEntry(int id) {
    this.id = id;
  }
  public static DropdownMenuEntry byId(int id) { return new DropdownMenuEntry(id); }
  @Builder.Factory
  static <T extends NativeObj> DropdownMenuEntry<T> dropdownMenuEntryDropdownMenuEntry(@Builder.Parameter NativeObj value, @Builder.Parameter String label, Optional<WidgetI> labelWidget, Optional<WidgetI> leadingIcon, Optional<WidgetI> trailingIcon, Optional<Boolean> enabled) {
    int id = factories.dropdownMenuEntryDropdownMenuEntry(value,
      label,
      labelWidget.map(WidgetI::build),
      leadingIcon.map(WidgetI::build),
      trailingIcon.map(WidgetI::build),
      enabled);
    if (id <= 0) throw new RuntimeException("Failed to created widget DropdownMenuEntry<T>");
    System.out.println("New DropdownMenuEntry<T> id:"+id);
    return new DropdownMenuEntry(id);
  }
  public static <T extends NativeObj> DropdownMenuEntryDropdownMenuEntryBuilder<T> dropdownMenuEntry(NativeObj value, String label) {
    return DropdownMenuEntryDropdownMenuEntryBuilder.dropdownMenuEntryDropdownMenuEntry(value, label);
  }
  @Override
  public DropdownMenuEntry build() {
    return this;
  }
}
