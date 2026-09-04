package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.TimePickerThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class TimePickerTheme extends InheritedTheme implements TimePickerThemeI {
  private MemorySegment st;
  protected TimePickerTheme() {}
  TimePickerTheme(MemorySegment st) {
    this.id = TimePickerThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget TimePickerTheme");
    System.out.println("New TimePickerTheme id:"+id);
  }
  TimePickerTheme(int id) { this.id = id; }
  @Override
  public TimePickerTheme build() {
    return this;
  }
}
