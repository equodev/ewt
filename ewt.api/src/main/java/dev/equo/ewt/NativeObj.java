package dev.equo.ewt;

public interface NativeObj {

    int getId();

    abstract class Base implements NativeObj {
        static final WidgetConstructors factories = WidgetConstructors.instance;
        int id;

        public int getId() {
            return id;
        }
    }
}
