package dev.equo.ewt;
import dev.equo.ewt.ffm.*;

import javax.swing.text.html.Option;
import java.util.*;
import java.lang.foreign.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Supplier;

class WidgetConstructorsBase {
  static WidgetConstructors instance = new WidgetConstructors();
  MemorySegment factories;
  Arena arena = Arena.ofShared();

  public void set(MemorySegment factories) {
    this.factories = factories;
  }

  static boolean intToBool(int i) {
    return i == 0;
  }

  static List<String> memToStrList(MemorySegment ptr) {
    List<String> list = new ArrayList<>();
    for (int i = 0; ; i++) {
      MemorySegment atIndex = ptr.getAtIndex(StarterBridge.C_POINTER, i);
      if (atIndex == MemorySegment.NULL)
        break;
      String stri = atIndex.getString(0);
      list.add(stri);
    }
    return list;
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
    return MemorySegment.NULL;
  }
  MemorySegment ptrStrList(Optional<List<String>> opt) {
    if (opt.isPresent()) {
      MemorySegment array = arena.allocate(StarterBridge.C_POINTER, opt.get().size());
      for (int i = 0; i < opt.get().size(); i++) {
        var cStr = arena.allocateFrom(opt.get().get(i));
        array.setAtIndex(StarterBridge.C_POINTER, i,  cStr);
      }
      return array;
    }
    return MemorySegment.NULL;
  }
  MemorySegment ptrFn(Runnable runnable) {
    return VoidCallbackFFI.allocate(runnable::run, arena);
  }
  <T extends NativeObj> MemorySegment ptrFn(Supplier<T> runnable) {
    return DartObjCallback.allocate(() -> runnable.get().getId(), arena);
  }
  <T extends NativeObj, R extends NativeObj> MemorySegment ptrFn(Function<T, R> f) {
    return DartObjCallbackDartObj.allocate((ctx) -> {
      System.out.println("java buil ctx: "+ctx);
      return f.apply((T) new BuildContext(ctx){}).getId() ;
    }, arena);
  }
//  MemorySegment ptrFn(Optional<Consumer<Boolean>> opt) {
//    if (opt.isPresent()) {
//      return DrawerCallbackFFI.allocate((i) -> opt.get().accept(i == 1), arena);
//    }
//    return MemorySegment.NULL;
//  }
}
