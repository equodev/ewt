package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class Shadow extends NativeObj.Base implements ShadowI {
  protected Shadow() {}
  Shadow(int id) {
    this.id = id;
  }
  @Builder.Factory
  static Shadow shadowShadow(Optional<ColorI> color, Optional<OffsetI> offset, OptionalDouble blurRadius) {
    int id = factories.shadowShadow(color.map(ColorI::build),
      offset.map(OffsetI::build),
      blurRadius);
    if (id <= 0) throw new RuntimeException("Failed to created widget Shadow");
    System.out.println("New Shadow id:"+id);
    return new Shadow(id);
  }
  public static ShadowShadowBuilder shadow() {
    return ShadowShadowBuilder.shadowShadow();
  }
  public static Shadow lerp(ShadowI a, ShadowI b, double t) {
    int id = factories.shadowLerp(a.build(),
      b.build(),
      t);
    if (id <= 0) throw new RuntimeException("Failed to created widget Shadow?");
    System.out.println("New Shadow? id:"+id);
    return new Shadow(id);
  }
  private static int _kColorDefault() {
    return 0xFF000000;
  }
  private static int _kBytesPerShadow() {
    return 16;
  }
  private static int _kColorOffset() {
    return 0 << 2;
  }
  private static int _kXOffset() {
    return 1 << 2;
  }
  private static int _kYOffset() {
    return 2 << 2;
  }
  private static int _kBlurOffset() {
    return 3 << 2;
  }
  @Override
  public Shadow build() {
    return this;
  }
}
