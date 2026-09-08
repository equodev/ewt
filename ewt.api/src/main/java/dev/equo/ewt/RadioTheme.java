package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.RadioThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class RadioTheme extends InheritedWidget implements RadioThemeI {
  private MemorySegment st;
  protected RadioTheme() {}
  RadioTheme(MemorySegment st) {
    this.id = RadioThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget RadioTheme");
    System.out.println("New RadioTheme id:"+id);
  }
  RadioTheme(int id) { this.id = id; }
  @Builder.Factory
  static RadioTheme radioThemeRadioTheme(@Builder.Parameter RadioThemeDataI data, @Builder.Parameter WidgetI child) {
    var st = factories.radioThemeRadioTheme(data.build(),
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget RadioTheme");
    return new RadioTheme(st);
  }
  public static RadioThemeRadioThemeBuilder radioTheme(RadioThemeDataI data, WidgetI child) {
    return RadioThemeRadioThemeBuilder.radioThemeRadioTheme(data, child);
  }
  public static RadioThemeData of(BuildContextI context) {
    var st = factories.radioThemeOf(context.build());
    if (st == null) throw new RuntimeException("Failed to created widget RadioThemeData");
    return new RadioThemeData(st);
  }
  public RadioThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("radioThemeData", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.RadioThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.RadioThemeDataObjSt.id(__st, __nid);
      return new RadioThemeData(__st);
    }
    return new RadioThemeData(RadioThemeObjSt.data(st));
  }
  @Override
  public RadioTheme build() {
    return this;
  }
}
