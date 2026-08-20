package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.InputDecoratorObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class InputDecorator extends StatefulWidget implements InputDecoratorI {
  private MemorySegment st;
  protected InputDecorator() {}
  InputDecorator(MemorySegment st) {
    this.id = InputDecoratorObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget InputDecorator");
    System.out.println("New InputDecorator id:"+id);
  }
  InputDecorator(int id) { this.id = id; }
  @Builder.Factory
  static InputDecorator inputDecoratorInputDecorator(@Builder.Parameter InputDecorationI decoration, Optional<TextStyleI> baseStyle, Optional<TextAlign> textAlign, Optional<Boolean> isFocused, Optional<Boolean> isHovering, Optional<Boolean> expands, Optional<Boolean> isEmpty, Optional<WidgetI> child) {
    var st = factories.inputDecoratorInputDecorator(decoration.build(),
      baseStyle.map(TextStyleI::build),
      textAlign,
      isFocused,
      isHovering,
      expands,
      isEmpty,
      child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget InputDecorator");
    return new InputDecorator(st);
  }
  public static InputDecoratorInputDecoratorBuilder inputDecorator(InputDecorationI decoration) {
    return InputDecoratorInputDecoratorBuilder.inputDecoratorInputDecorator(decoration);
  }
  public static RenderBox containerOf(BuildContextI context) {
    int id = factories.inputDecoratorContainerOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget RenderBox?");
    System.out.println("New RenderBox? id:"+id);
    return new RenderBox(id) {};
  }
  public InputDecoration decoration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputDecoratorDecoration", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.InputDecorationObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.InputDecorationObjSt.id(__st, __nid);
      return new InputDecoration(__st);
    }
    return new InputDecoration(InputDecoratorObjSt.decoration(st));
  }
  public TextStyle baseStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputDecoratorBaseStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(InputDecoratorObjSt.baseStyle(st));
  }
  public TextAlign textAlign() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecoratorTextAlign not supported on web");
    return TextAlign.values()[InputDecoratorObjSt.textAlign(st)];
  }
  public boolean isFocused() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecoratorIsFocused not supported on web");
    return intToBool(InputDecoratorObjSt.isFocused(st));
  }
  public boolean isHovering() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecoratorIsHovering not supported on web");
    return intToBool(InputDecoratorObjSt.isHovering(st));
  }
  public boolean expands() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecoratorExpands not supported on web");
    return intToBool(InputDecoratorObjSt.expands(st));
  }
  public boolean isEmpty() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecoratorIsEmpty not supported on web");
    return intToBool(InputDecoratorObjSt.isEmpty(st));
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDecoratorChild not supported on web");
    return new Widget(InputDecoratorObjSt.child(st)) {};
  }
  @Override
  public InputDecorator build() {
    return this;
  }
}
