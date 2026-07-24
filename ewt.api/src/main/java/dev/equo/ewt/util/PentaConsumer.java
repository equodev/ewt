package dev.equo.ewt.util;

@FunctionalInterface
public interface PentaConsumer<T, U, X, Y, Z> {
    void accept(T t, U u, X x, Y y, Z z);
}
