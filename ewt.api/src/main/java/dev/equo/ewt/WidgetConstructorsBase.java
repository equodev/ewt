package dev.equo.ewt;
import dev.equo.ewt.ffm.*;

import java.util.*;
import java.lang.foreign.*;

class WidgetConstructorsBase {
  static WidgetConstructors instance = new WidgetConstructors();
  MemorySegment factories;
  Arena arena = Arena.ofShared();

  public void set(MemorySegment factories) {
    this.factories = factories;
  }

  static boolean intToBool(int i) {
    // The Dart side marshals with `this == true ? 1 : 0` (factories.dart), so
    // non-zero is true.
    return i != 0;
  }

  /// Reads an `int*` carrying a nullable bool, as the Dart `boolOrNul()` does.
  static Boolean memToBool(MemorySegment ptr) {
    if (ptr == null || MemorySegment.NULL.equals(ptr)) {
      return null;
    }
    return intToBool(ptr.reinterpret(StarterBridge.C_INT.byteSize()).get(StarterBridge.C_INT, 0));
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
  MemorySegment ptrObj(Widget opt) {
    return arena.allocateFrom(StarterBridge.C_INT, opt.getId());
  }
  // Optional callback params are emitted as ffi.Pointer<FFI> (Type*) in C, so they
  // expect an 8-byte holder that contains the stub's address, not the stub address
  // itself. Passing the stub directly makes Dart dereference its code bytes -> SIGSEGV.
  // Use JAVA_LONG (raw address); C_POINTER's target layout misbehaves with upcall
  // stubs on JDK 23.
  MemorySegment ptrHolder(MemorySegment stub) {
    MemorySegment h = arena.allocate(8, 8);
    h.set(ValueLayout.JAVA_LONG, 0, stub.address());
    return h;
  }
  <T extends NativeObj> MemorySegment ptrList(Optional<List<T>> opt) {
    if (opt.isPresent()) {
      List<T> list = opt.get();
      return ptrList(list);
    }
    return MemorySegment.NULL;
  }
  <T extends NativeObj> MemorySegment ptrList(List<T> list) {
    MemorySegment struct = ArrayC.allocate(arena);
    ArrayC.size(struct, list.size());
    MemorySegment array = arena.allocateFrom(StarterBridge.C_INT, list.stream().mapToInt(NativeObj::getId).toArray());
    ArrayC.list(struct, array);
    return struct;
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
  <T extends NativeObj> MemorySegment ptrMap(Map<Integer, T> map) {
    MemorySegment struct = MapC.allocate(arena);
    MapC.size(struct, map.size());

    MemorySegment entriesC = EntryC.allocateArray(map.size(), arena);
    Set<Map.Entry<Integer, T>> entries = map.entrySet();
    int i = 0;
    for (Map.Entry<Integer, T> entry: entries) {
      MemorySegment slice = EntryC.asSlice(entriesC, i++);
      EntryC.key(slice, entry.getKey());
      EntryC.value(slice, entry.getValue().getId());
    }
    MapC.entries(struct, entriesC);
    return struct;
  }
//  MemorySegment ptrFn(Runnable runnable) {
//    return VoidCallbackFFI.allocate(runnable::run, arena);
//  }
//  <T extends NativeObj> MemorySegment ptrFn(Supplier<T> runnable) {
//    return DartObjCallback.allocate(() -> runnable.get().getId(), arena);
//  }
//  <T extends NativeObj, R extends NativeObj> MemorySegment ptrFn(Function<T, R> f) {
//    return DartObjCallbackDartObj.allocate((ctx) -> {
//      System.out.println("java buil ctx: "+ctx);
//      return f.apply((T) new BuildContext(ctx){}).getId() ;
//    }, arena);
//  }
//  MemorySegment ptrFn(Optional<Consumer<Boolean>> opt) {
//    if (opt.isPresent()) {
//      return DrawerCallbackFFI.allocate((i) -> opt.get().accept(i == 1), arena);
//    }
//    return MemorySegment.NULL;
//  }
}
