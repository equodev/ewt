package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class ImageFiltered extends SingleChildRenderObjectWidget implements ImageFilteredI {
  protected ImageFiltered() {}
  ImageFiltered(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget ImageFiltered");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static ImageFiltered imageFilteredImageFiltered(@Builder.Parameter ImageFilterI imageFilter, Optional<WidgetI> child, Optional<Boolean> enabled) {
    int id = factories.imageFilteredImageFiltered(imageFilter.build(),
      child.map(WidgetI::build),
      enabled);
    if (id <= 0) throw new RuntimeException("Failed to created widget ImageFiltered");
    return new ImageFiltered(id);
  }
  public static ImageFilteredImageFilteredBuilder imageFiltered(ImageFilterI imageFilter) {
    return ImageFilteredImageFilteredBuilder.imageFilteredImageFiltered(imageFilter);
  }
  public ImageFilter imageFilter() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("imageFilteredImageFilter not supported on web");
    return factories.ImageFiltered_readBack_imageFilter(nativeStruct);
  }
  public boolean enabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("imageFilteredEnabled not supported on web");
    return factories.ImageFiltered_readBack_enabled(nativeStruct);
  }
  @Override
  public ImageFiltered build() {
    return this;
  }
}
