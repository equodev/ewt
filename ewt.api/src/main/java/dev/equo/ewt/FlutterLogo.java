package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class FlutterLogo extends StatelessWidget implements FlutterLogoI {
  protected FlutterLogo() {}
  FlutterLogo(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget FlutterLogo");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static FlutterLogo flutterLogoFlutterLogo(OptionalDouble size, Optional<ColorI> textColor, Optional<FlutterLogoStyle> style, Optional<DurationI> duration, Optional<CurveI> curve) {
    int id = factories.flutterLogoFlutterLogo(size,
      textColor.map(ColorI::build),
      style,
      duration.map(DurationI::build),
      curve.map(CurveI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget FlutterLogo");
    return new FlutterLogo(id);
  }
  public static FlutterLogoFlutterLogoBuilder flutterLogo() {
    return FlutterLogoFlutterLogoBuilder.flutterLogoFlutterLogo();
  }
  public double size() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("flutterLogoSize not supported on web");
    return factories.FlutterLogo_readBack_size(nativeStruct);
  }
  public Color textColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("flutterLogoTextColor", getId());
      return new Color(__nid);
    }
    return factories.FlutterLogo_readBack_textColor(nativeStruct);
  }
  public FlutterLogoStyle style() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("flutterLogoStyle not supported on web");
    return factories.FlutterLogo_readBack_style(nativeStruct);
  }
  public Duration duration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("flutterLogoDuration", getId());
      return new Duration(__nid);
    }
    return factories.FlutterLogo_readBack_duration(nativeStruct);
  }
  public Curve curve() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("flutterLogoCurve not supported on web");
    return factories.FlutterLogo_readBack_curve(nativeStruct);
  }
  @Override
  public FlutterLogo build() {
    return this;
  }
}
