package dev.equo.ewt;

public interface NativeObj {

    int getId();

    abstract class Base implements NativeObj {
        int id;

        public int getId() {
            return id;
        }
    }
}
