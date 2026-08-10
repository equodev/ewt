package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.FlutterLogoObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class FlutterLogo extends StatelessWidget implements FlutterLogoI {
  private MemorySegment st;
  protected FlutterLogo() {}
  FlutterLogo(MemorySegment st) {
    this.id = FlutterLogoObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget FlutterLogo");
    System.out.println("New FlutterLogo id:"+id);
  }
  FlutterLogo(int id) { this.id = id; }
  @Builder.Factory
  static FlutterLogo flutterLogoFlutterLogo(OptionalDouble size, Optional<ColorI> textColor, Optional<FlutterLogoStyle> style, Optional<DurationI> duration, Optional<CurveI> curve) {
    var st = factories.flutterLogoFlutterLogo(size,
      textColor.map(ColorI::build),
      style,
      duration.map(DurationI::build),
      curve.map(CurveI::build));
    if (st == null) throw new RuntimeException("Failed to created widget FlutterLogo");
    return new FlutterLogo(st);
  }
  public static FlutterLogoFlutterLogoBuilder flutterLogo() {
    return FlutterLogoFlutterLogoBuilder.flutterLogoFlutterLogo();
  }
  public double size() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("flutterLogoSize not supported on web");
    return FlutterLogoObjSt.size(st);
  }
  public Color textColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("flutterLogoTextColor", getId());
      return new Color(__nid);
    }
    return new Color(FlutterLogoObjSt.textColor(st));
  }
  public FlutterLogoStyle style() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("flutterLogoStyle not supported on web");
    return FlutterLogoStyle.values()[FlutterLogoObjSt.style(st)];
  }
  public Duration duration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("flutterLogoDuration", getId());
      return new Duration(__nid);
    }
    return new Duration(FlutterLogoObjSt.duration(st));
  }
  public Curve curve() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("flutterLogoCurve not supported on web");
    return new Curve(FlutterLogoObjSt.curve(st)) {};
  }
  @Override
  public FlutterLogo build() {
    return this;
  }
}
