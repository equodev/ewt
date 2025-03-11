package dev.equo.ewt;
import dev.equo.ewt.ffm.*;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.OptionalDouble;
import java.lang.foreign.*;
class WidgetConstructors {
  static WidgetConstructors instance = new WidgetConstructors();
  private MemorySegment factories;
  private Arena arena = Arena.ofAuto();
  public void set(MemorySegment factories) {
    this.factories = factories;
  }
  int textOf(String data, Optional<TextAlign> textAlign, Optional<TextDirection> textDirection, Optional<Boolean> softWrap, Optional<TextOverflow> overflow, OptionalDouble textScaleFactor, OptionalInt maxLines, Optional<String> semanticsLabel, Optional<TextWidthBasis> textWidthBasis) {
    var st = WidgetFactories.text(factories);
    var fn = WidgetFactories.text.of(st);
    return WidgetFactories.text.of.invoke(fn, arena.allocateFrom(data), ptrEnum(textAlign), ptrEnum(textDirection), ptrBool(softWrap), ptrEnum(overflow), ptr(textScaleFactor), ptr(maxLines), ptrStr(semanticsLabel), ptrEnum(textWidthBasis));
  }
  int textRich(InlineSpan textSpan, Optional<TextAlign> textAlign, Optional<TextDirection> textDirection, Optional<Boolean> softWrap, Optional<TextOverflow> overflow, OptionalDouble textScaleFactor, OptionalInt maxLines, Optional<String> semanticsLabel, Optional<TextWidthBasis> textWidthBasis) {
    var st = WidgetFactories.text(factories);
    var fn = WidgetFactories.text.rich(st);
    return WidgetFactories.text.rich.invoke(fn, textSpan.getId(), ptrEnum(textAlign), ptrEnum(textDirection), ptrBool(softWrap), ptrEnum(overflow), ptr(textScaleFactor), ptr(maxLines), ptrStr(semanticsLabel), ptrEnum(textWidthBasis));
  }

  int centerOf(OptionalDouble widthFactor, OptionalDouble heightFactor, Optional<Widget> child) {
    var st = WidgetFactories.center(factories);
    var fn = WidgetFactories.center.of(st);
    return WidgetFactories.center.of.invoke(fn, ptr(widthFactor), ptr(heightFactor), ptrObj(child));
  }

  int columnOf(Optional<MainAxisAlignment> mainAxisAlignment, Optional<MainAxisSize> mainAxisSize, Optional<CrossAxisAlignment> crossAxisAlignment, Optional<TextDirection> textDirection, Optional<VerticalDirection> verticalDirection, Optional<TextBaseline> textBaseline, OptionalDouble spacing, Optional<List<Widget>> children) {
    var st = WidgetFactories.column(factories);
    var fn = WidgetFactories.column.of(st);
    return WidgetFactories.column.of.invoke(fn, ptrEnum(mainAxisAlignment), ptrEnum(mainAxisSize), ptrEnum(crossAxisAlignment), ptrEnum(textDirection), ptrEnum(verticalDirection), ptrEnum(textBaseline), ptr(spacing), ptrList(children));
  }

  MemorySegment ptr(OptionalInt opt) {
    return opt.isPresent() ? arena.allocateFrom(StarterBridge.C_INT, opt.getAsInt()) : MemorySegment.NULL;
  }
  MemorySegment ptr(OptionalDouble opt) {
    return opt.isPresent() ? arena.allocateFrom(StarterBridge.C_DOUBLE, opt.getAsDouble()) : MemorySegment.NULL;
  }
  MemorySegment ptrBool(Optional<Boolean> opt) {
    return opt.isPresent() ? arena.allocateFrom(StarterBridge.C_INT, opt.get() ? 1 : 0) : MemorySegment.NULL;
  }
  MemorySegment ptrStr(Optional<String> opt) {
    return opt.isPresent() ? arena.allocateFrom(opt.get()) : MemorySegment.NULL;
  }
  <T extends Enum<?>> MemorySegment ptrEnum(Optional<T> opt) {
    return opt.isPresent() ? arena.allocateFrom(StarterBridge.C_INT, opt.get().ordinal()) : MemorySegment.NULL;
  }
  <T extends NativeObj> MemorySegment ptrObj(Optional<T> opt) {
    return opt.isPresent() ? arena.allocateFrom(StarterBridge.C_INT, opt.get().getId()) : MemorySegment.NULL;
  }
  <T extends NativeObj> MemorySegment ptrList(Optional<List<T>> opt) {
    if (opt.isPresent()) {
      MemorySegment struct = ArrayC.allocate(arena);
      ArrayC.size(struct, opt.get().size());
      MemorySegment array = arena.allocateFrom(StarterBridge.C_INT, opt.get().stream().mapToInt(NativeObj::getId).toArray());
      ArrayC.list(struct, array);
      return struct;
    }
    return MemorySegment.NULL
;  }
}
