package dev.equo.ewt;

public interface NativeObj {

    int getId();

    abstract class Base implements NativeObj, I {
        static final WidgetConstructors factories = WidgetConstructors.instance;
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
