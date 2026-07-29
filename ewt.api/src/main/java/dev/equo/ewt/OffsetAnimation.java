package dev.equo.ewt;

/**
 * An {@link Animation} of {@link Offset} values for the web path.
 *
 * <p>Equivalent to {@code Tween<Offset>(begin: begin, end: end).animate(parent)} in Dart.
 * The Dart web decoder resolves the serialized node to a real {@code Animation<Offset>} via
 * {@code offsetTween} in {@code factories_web_gen.dart}.
 *
 * <p>Web-only: the native FFI path throws {@link UnsupportedOperationException} because native
 * Dart handles {@code Animation<Offset>} creation directly via {@code Tween<Offset>} in Dart code.
 */
public class OffsetAnimation extends NativeObj.Base implements Animation<Offset>, AnimationI {
  protected OffsetAnimation() {}

  OffsetAnimation(int id) {
    this.id = id;
  }

  /**
   * Creates an {@code Animation<Offset>} that interpolates from {@code begin} to {@code end}
   * driven by {@code parent} (an {@code Animation<double>} such as {@code AnimationController}).
   *
   * <p>Web-only.
   */
  public static OffsetAnimation create(Offset begin, Offset end, Animation parent) {
    if (!dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      throw new UnsupportedOperationException(
          "OffsetAnimation is web-only; on the native path create Animation<Offset> in Dart via Tween<Offset>");
    }
    return new OffsetAnimation(factories.offsetTween(begin, end, parent));
  }

  @Override
  public OffsetAnimation build() {
    return this;
  }
}
