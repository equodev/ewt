package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class InputDecorator extends StatefulWidget implements InputDecoratorI {
  protected InputDecorator() {}
  InputDecorator(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget InputDecorator");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static InputDecorator inputDecoratorInputDecorator(@Builder.Parameter InputDecorationI decoration, Optional<TextStyleI> baseStyle, Optional<TextAlign> textAlign, Optional<Boolean> isFocused, Optional<Boolean> isHovering, Optional<Boolean> expands, Optional<Boolean> isEmpty, Optional<WidgetI> child) {
    int id = factories.inputDecoratorInputDecorator(decoration.build(),
      baseStyle.map(TextStyleI::build),
      textAlign,
      isFocused,
      isHovering,
      expands,
      isEmpty,
      child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget InputDecorator");
    return new InputDecorator(id);
  }
  public static InputDecoratorInputDecoratorBuilder inputDecorator(InputDecorationI decoration) {
    return InputDecoratorInputDecoratorBuilder.inputDecoratorInputDecorator(decoration);
  }
  public static RenderBox containerOf(BuildContextI context) {
    var id = factories.inputDecoratorContainerOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget RenderBox?");
    return new RenderBox(id) {};
  }
  public InputDecoration decoration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputDecoratorDecoration", getId());
      return new InputDecoration(__nid);
    }
    return factories.InputDecorator_readBack_decoration(nativeStruct);
  }
  public TextStyle baseStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputDecoratorBaseStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.InputDecorator_readBack_baseStyle(nativeStruct);
  }
  public TextAlign textAlign() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecoratorTextAlign not supported on web");
    return factories.InputDecorator_readBack_textAlign(nativeStruct);
  }
  public boolean isFocused() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecoratorIsFocused not supported on web");
    return factories.InputDecorator_readBack_isFocused(nativeStruct);
  }
  public boolean isHovering() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecoratorIsHovering not supported on web");
    return factories.InputDecorator_readBack_isHovering(nativeStruct);
  }
  public boolean expands() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecoratorExpands not supported on web");
    return factories.InputDecorator_readBack_expands(nativeStruct);
  }
  public boolean isEmpty() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecoratorIsEmpty not supported on web");
    return factories.InputDecorator_readBack_isEmpty(nativeStruct);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecoratorChild not supported on web");
    return factories.InputDecorator_readBack_child(nativeStruct);
  }
  @Override
  public InputDecorator build() {
    return this;
  }
}
