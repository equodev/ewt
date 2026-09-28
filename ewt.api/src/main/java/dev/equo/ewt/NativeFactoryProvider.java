package dev.equo.ewt;

/**
 * ServiceLoader SPI (core, foreign-free) for supplying the FFM {@link WidgetConstructors} impl. The
 * FFM provider lives in the release-22 layer and is registered only under {@code META-INF/versions/22},
 * so a JVM &lt; 22 never sees the provider class and stays on the comm/serializing impl. See {@link Bootstrap}.
 */
public interface NativeFactoryProvider {
  WidgetConstructors create();
}
