package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public abstract class ImageFilter extends NativeObj.Base implements ImageFilterI {
  protected ImageFilter() {}
  ImageFilter(int id) {
    this.id = id;
  }
  @Builder.Factory
  static ImageFilter imageFilterBlur(OptionalDouble sigmaX, OptionalDouble sigmaY, Optional<TileMode> tileMode) {
    int id = factories.imageFilterBlur(sigmaX,
      sigmaY,
      tileMode);
    if (id <= 0) throw new RuntimeException("Failed to created widget ImageFilter");
    System.out.println("New ImageFilter id:"+id);
    return new ImageFilter(id) {};
  }
  public static ImageFilterBlurBuilder blur() {
    return ImageFilterBlurBuilder.imageFilterBlur();
  }
  @Builder.Factory
  static ImageFilter imageFilterDilate(OptionalDouble radiusX, OptionalDouble radiusY) {
    int id = factories.imageFilterDilate(radiusX,
      radiusY);
    if (id <= 0) throw new RuntimeException("Failed to created widget ImageFilter");
    System.out.println("New ImageFilter id:"+id);
    return new ImageFilter(id) {};
  }
  public static ImageFilterDilateBuilder dilate() {
    return ImageFilterDilateBuilder.imageFilterDilate();
  }
  @Builder.Factory
  static ImageFilter imageFilterErode(OptionalDouble radiusX, OptionalDouble radiusY) {
    int id = factories.imageFilterErode(radiusX,
      radiusY);
    if (id <= 0) throw new RuntimeException("Failed to created widget ImageFilter");
    System.out.println("New ImageFilter id:"+id);
    return new ImageFilter(id) {};
  }
  public static ImageFilterErodeBuilder erode() {
    return ImageFilterErodeBuilder.imageFilterErode();
  }
  @Builder.Factory
  static ImageFilter imageFilterCompose(@Builder.Parameter ImageFilterI outer, @Builder.Parameter ImageFilterI inner) {
    int id = factories.imageFilterCompose(outer.build(),
      inner.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget ImageFilter");
    System.out.println("New ImageFilter id:"+id);
    return new ImageFilter(id) {};
  }
  public static ImageFilterComposeBuilder compose(ImageFilterI outer, ImageFilterI inner) {
    return ImageFilterComposeBuilder.imageFilterCompose(outer, inner);
  }
  @Override
  public ImageFilter build() {
    return this;
  }
}
