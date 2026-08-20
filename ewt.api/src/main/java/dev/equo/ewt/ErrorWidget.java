package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ErrorWidgetObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class ErrorWidget extends LeafRenderObjectWidget implements ErrorWidgetI {
  private MemorySegment st;
  protected ErrorWidget() {}
  ErrorWidget(MemorySegment st) {
    this.id = ErrorWidgetObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget ErrorWidget");
    System.out.println("New ErrorWidget id:"+id);
  }
  ErrorWidget(int id) { this.id = id; }
  @Builder.Factory
  static ErrorWidget errorWidgetErrorWidget(@Builder.Parameter NativeObj.I exception) {
    var st = factories.errorWidgetErrorWidget(exception.build());
    if (st == null) throw new RuntimeException("Failed to created widget ErrorWidget");
    return new ErrorWidget(st);
  }
  public static ErrorWidgetErrorWidgetBuilder errorWidget(NativeObj.I exception) {
    return ErrorWidgetErrorWidgetBuilder.errorWidgetErrorWidget(exception);
  }
  @Builder.Factory
  static ErrorWidget errorWidgetWithDetails(Optional<String> message) {
    var st = factories.errorWidgetWithDetails(message);
    if (st == null) throw new RuntimeException("Failed to created widget ErrorWidget");
    return new ErrorWidget(st);
  }
  public static ErrorWidgetWithDetailsBuilder withDetails() {
    return ErrorWidgetWithDetailsBuilder.errorWidgetWithDetails();
  }
  public String message() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("errorWidgetMessage not supported on web");
    return ErrorWidgetObjSt.message(st).getString(0);
  }
  @Override
  public ErrorWidget build() {
    return this;
  }
}
