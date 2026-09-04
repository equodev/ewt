package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.CarouselViewThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class CarouselViewTheme extends InheritedTheme implements CarouselViewThemeI {
  private MemorySegment st;
  protected CarouselViewTheme() {}
  CarouselViewTheme(MemorySegment st) {
    this.id = CarouselViewThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget CarouselViewTheme");
    System.out.println("New CarouselViewTheme id:"+id);
  }
  CarouselViewTheme(int id) { this.id = id; }
  @Override
  public CarouselViewTheme build() {
    return this;
  }
}
