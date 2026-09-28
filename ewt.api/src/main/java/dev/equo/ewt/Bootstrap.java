package dev.equo.ewt;

import java.util.ServiceLoader;

/**
 * Resolves the active {@link WidgetConstructors} (java-11 split). On java &gt;= 22 it tries the FFM
 * provider via {@link ServiceLoader}; otherwise (or if none is found) it uses the foreign-free
 * serializing/comm impl. The version guard means a JVM &lt; 22 never iterates the loader, so it never
 * attempts to load the release-22 FFM class — belt-and-suspenders on top of the MRJAR hiding it under
 * {@code META-INF/versions/22}. Foreign-free: the FFM impl is only reached reflectively via the SPI.
 */
public final class Bootstrap {
  private Bootstrap() {}

  static WidgetConstructors resolve() {
    if (Runtime.version().feature() >= 22) {
      for (NativeFactoryProvider p : ServiceLoader.load(NativeFactoryProvider.class, Bootstrap.class.getClassLoader())) {
        try {
          WidgetConstructors wc = p.create();
          if (wc != null) return wc;
        } catch (Throwable t) {
          System.out.println("Bootstrap: FFM provider failed, falling back to comm: " + t);
        }
      }
    }
    return new SerializingWidgetConstructors();
  }
}
