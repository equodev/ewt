package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.SliderThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class SliderTheme extends InheritedTheme implements SliderThemeI {
  private MemorySegment st;
  protected SliderTheme() {}
  SliderTheme(MemorySegment st) {
    this.id = SliderThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget SliderTheme");
    System.out.println("New SliderTheme id:"+id);
  }
  SliderTheme(int id) { this.id = id; }
  @Builder.Factory
  static SliderTheme sliderThemeSliderTheme(@Builder.Parameter SliderThemeDataI data, @Builder.Parameter WidgetI child) {
    var st = factories.sliderThemeSliderTheme(data.build(),
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget SliderTheme");
    return new SliderTheme(st);
  }
  public static SliderThemeSliderThemeBuilder sliderTheme(SliderThemeDataI data, WidgetI child) {
    return SliderThemeSliderThemeBuilder.sliderThemeSliderTheme(data, child);
  }
  public static SliderThemeData of(BuildContextI context) {
    var st = factories.sliderThemeOf(context.build());
    if (st == null) throw new RuntimeException("Failed to created widget SliderThemeData");
    return new SliderThemeData(st);
  }
  public SliderThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("sliderThemeData", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.SliderThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.SliderThemeDataObjSt.id(__st, __nid);
      return new SliderThemeData(__st);
    }
    return new SliderThemeData(SliderThemeObjSt.data(st));
  }
  @Override
  public SliderTheme build() {
    return this;
  }
}
