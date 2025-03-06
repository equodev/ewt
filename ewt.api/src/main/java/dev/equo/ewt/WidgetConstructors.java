package dev.equo.ewt;

import dev.equo.ewt.ffm.WidgetFactories;

import java.lang.foreign.MemorySegment;

public class WidgetConstructors {
    private static MemorySegment factories;

    public static MemorySegment get() {
        return factories;
    }

    public static void set(MemorySegment reinterpret) {
        WidgetConstructors.factories = reinterpret;
    }
}
