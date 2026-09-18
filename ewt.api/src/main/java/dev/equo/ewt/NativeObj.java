package dev.equo.ewt;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.IntFunction;

public interface NativeObj {

    int getId();

    /**
     * Default identity build so callers can treat any {@code NativeObj} the same
     * way they treat {@link I} builders — the generator emits {@code x.build().getId()}
     * uniformly for widget/object args, and a raw {@code NativeObj} (used when a
     * Dart param is {@code Object}, e.g. {@code Hero.tag}) needs this to compile.
     */
    default NativeObj build() { return this; }

    // ------------------------------------------------------------------------
    // Type registry — Dart runtime type name → Java `byId` constructor.
    //
    // Populated at class-load time by every generator-emitted `NativeObj`-
    // backed class via a `static { NativeObj.register("DartName", ThisClass::byId); }`
    // block. Consumed by callback-arg marshallers that receive an opaque
    // widget id + the value's Dart `runtimeType.toString()` from the FFI — see
    // `paramValueFFMtoJ` in `generator/lib/types.dart` and the emitted
    // extensions in `widgets/lib/factories_gen.dart`. Without this, an
    // `Object?` callback arg would only be reachable as a bare wrapper with
    // no way to reify it into the concrete Java class the caller declared.
    //
    // Why a registry (not reflection or a compile-time switch): reflection
    // over `Class.forName(dartName + ".java")` couples package layout to
    // Dart type spelling and doesn't survive Java-side renames; a hand-
    // maintained switch would need touching every time a widget joins
    // `generation_index.dart`. A registry populated by generator-emitted
    // `register` calls scales automatically with widget coverage.
    // ------------------------------------------------------------------------

    Map<String, IntFunction<? extends NativeObj>> _REGISTRY = new ConcurrentHashMap<>();

    /**
     * Register the {@code byId} constructor for a Dart runtime type name.
     * Called from static initializers on every generator-emitted NativeObj
     * class; also safe to call from hand-written classes that expose an
     * {@code (int id)} constructor.
     */
    static void register(String dartTypeName, IntFunction<? extends NativeObj> byId) {
        _REGISTRY.put(dartTypeName, byId);
    }

    /**
     * Reconstruct a typed NativeObj from a widget id + the value's Dart
     * runtime type name. Returns {@code null} for id ≤ 0 (Dart-side null).
     * Falls back to a bare {@code NativeObj.Base} wrapper (id-only) if the
     * type isn't registered — logs to stderr so the missing registration is
     * visible without crashing the callback.
     */
    static NativeObj byIdAndType(int id, String dartTypeName) {
        if (id <= 0) return null;
        if (dartTypeName == null || dartTypeName.isEmpty()) {
            return _bareWrapper(id);
        }
        IntFunction<? extends NativeObj> ctor = _REGISTRY.get(dartTypeName);
        if (ctor == null) {
            // Strip generic type arguments — "List<int>" → "List", etc. Dart's
            // `runtimeType.toString()` includes them, but our Java classes are
            // registered by the base name.
            int lt = dartTypeName.indexOf('<');
            if (lt > 0) {
                ctor = _REGISTRY.get(dartTypeName.substring(0, lt));
            }
        }
        if (ctor == null) {
            System.err.println("[NativeObj] no Java class registered for Dart type '"
                + dartTypeName + "' (id=" + id + "); returning bare wrapper.");
            return _bareWrapper(id);
        }
        return ctor.apply(id);
    }

    private static NativeObj _bareWrapper(int id) {
        return new Base() { { this.id = id; } };
    }

    abstract class Base implements NativeObj, I {
        static volatile WidgetConstructors factories = WidgetConstructorsBase.instance;
        int id;

        public int getId() {
            return id;
        }

        @Override
        public NativeObj build() {
            return this;
        }
    }

    interface I {
        NativeObj build();
    }
}
