package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class ErrorWidget extends LeafRenderObjectWidget implements ErrorWidgetI {
  protected ErrorWidget() {}
  ErrorWidget(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget ErrorWidget");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static ErrorWidget errorWidgetErrorWidget(@Builder.Parameter NativeObj.I exception) {
    int id = factories.errorWidgetErrorWidget(exception.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget ErrorWidget");
    return new ErrorWidget(id);
  }
  public static ErrorWidgetErrorWidgetBuilder errorWidget(NativeObj.I exception) {
    return ErrorWidgetErrorWidgetBuilder.errorWidgetErrorWidget(exception);
  }
  @Builder.Factory
  static ErrorWidget errorWidgetWithDetails(Optional<String> message) {
    int id = factories.errorWidgetWithDetails(message);
    if (id <= 0) throw new RuntimeException("Failed to created widget ErrorWidget");
    return new ErrorWidget(id);
  }
  public static ErrorWidgetWithDetailsBuilder withDetails() {
    return ErrorWidgetWithDetailsBuilder.errorWidgetWithDetails();
  }
  public String message() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("errorWidgetMessage not supported on web");
    return factories.ErrorWidget_readBack_message(nativeStruct);
  }
  @Override
  public ErrorWidget build() {
    return this;
  }
}
