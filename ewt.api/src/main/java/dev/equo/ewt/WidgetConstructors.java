package dev.equo.ewt;
import dev.equo.ewt.ffm.*;
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
  int textOf(String data, java.util.Optional<TextAlign> textAlign, java.util.Optional<TextDirection> textDirection, java.util.Optional<Boolean> softWrap, java.util.Optional<TextOverflow> overflow, java.util.OptionalDouble textScaleFactor, java.util.OptionalInt maxLines, java.util.Optional<String> semanticsLabel, java.util.Optional<TextWidthBasis> textWidthBasis) {
    var st = WidgetFactories.text(factories);
    var fn = WidgetFactories.text.of(st);
    return WidgetFactories.text.of.invoke(fn, arena.allocateFrom(data), ptrEnum(textAlign), ptrEnum(textDirection), ptrBool(softWrap), ptrEnum(overflow), ptr(textScaleFactor), ptr(maxLines), ptrStr(semanticsLabel), ptrEnum(textWidthBasis));
  }
  int textRich(InlineSpan textSpan, java.util.Optional<TextAlign> textAlign, java.util.Optional<TextDirection> textDirection, java.util.Optional<Boolean> softWrap, java.util.Optional<TextOverflow> overflow, java.util.OptionalDouble textScaleFactor, java.util.OptionalInt maxLines, java.util.Optional<String> semanticsLabel, java.util.Optional<TextWidthBasis> textWidthBasis) {
    var st = WidgetFactories.text(factories);
    var fn = WidgetFactories.text.rich(st);
    return WidgetFactories.text.rich.invoke(fn, textSpan.getId(), ptrEnum(textAlign), ptrEnum(textDirection), ptrBool(softWrap), ptrEnum(overflow), ptr(textScaleFactor), ptr(maxLines), ptrStr(semanticsLabel), ptrEnum(textWidthBasis));
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
}
