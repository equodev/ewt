package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ImageFilteredObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class ImageFiltered extends SingleChildRenderObjectWidget implements ImageFilteredI {
  private MemorySegment st;
  protected ImageFiltered() {}
  ImageFiltered(MemorySegment st) {
    this.id = ImageFilteredObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget ImageFiltered");
    System.out.println("New ImageFiltered id:"+id);
  }
  ImageFiltered(int id) { this.id = id; }
  @Builder.Factory
  static ImageFiltered imageFilteredImageFiltered(@Builder.Parameter ImageFilterI imageFilter, Optional<WidgetI> child, Optional<Boolean> enabled) {
    var st = factories.imageFilteredImageFiltered(imageFilter.build(),
      child.map(WidgetI::build),
      enabled);
    if (st == null) throw new RuntimeException("Failed to created widget ImageFiltered");
    return new ImageFiltered(st);
  }
  public static ImageFilteredImageFilteredBuilder imageFiltered(ImageFilterI imageFilter) {
    return ImageFilteredImageFilteredBuilder.imageFilteredImageFiltered(imageFilter);
  }
  public ImageFilter imageFilter() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("imageFilteredImageFilter not supported on web");
    return new ImageFilter(ImageFilteredObjSt.imageFilter(st)) {};
  }
  public boolean enabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("imageFilteredEnabled not supported on web");
    return intToBool(ImageFilteredObjSt.enabled(st));
  }
  @Override
  public ImageFiltered build() {
    return this;
  }
}
