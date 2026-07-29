package dev.equo.ewt;

public interface NativeObj {

    int getId();

    /**
     * Default identity build so callers can treat any {@code NativeObj} the same
     * way they treat {@link I} builders — the generator emits {@code x.build().getId()}
     * uniformly for widget/object args, and a raw {@code NativeObj} (used when a
     * Dart param is {@code Object}, e.g. {@code Hero.tag}) needs this to compile.
     */
    default NativeObj build() { return this; }

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
