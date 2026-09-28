package dev.equo.ewt;

/**
 * FFM {@link NativeFactoryProvider} (release-22 layer). Returns the shared native {@link
 * FfmWidgetConstructors} singleton ({@code WidgetConstructorsBase.instance}), which {@code App} /
 * {@code EngineHandle} wire the native factories pointer into via {@code set(...)}. Registered under
 * {@code META-INF/versions/22}, so it is invisible to a JVM &lt; 22.
 */
public final class FfmNativeFactoryProvider implements NativeFactoryProvider {
  @Override
  public WidgetConstructors create() {
    return WidgetConstructorsBase.instance;
  }
}
