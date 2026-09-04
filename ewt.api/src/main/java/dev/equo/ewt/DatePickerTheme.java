package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.DatePickerThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class DatePickerTheme extends InheritedTheme implements DatePickerThemeI {
  private MemorySegment st;
  protected DatePickerTheme() {}
  DatePickerTheme(MemorySegment st) {
    this.id = DatePickerThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget DatePickerTheme");
    System.out.println("New DatePickerTheme id:"+id);
  }
  DatePickerTheme(int id) { this.id = id; }
  @Override
  public DatePickerTheme build() {
    return this;
  }
}
