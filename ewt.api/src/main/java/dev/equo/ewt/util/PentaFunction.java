package dev.equo.ewt.util;

@FunctionalInterface
public interface PentaFunction<T, U, X, Y, Z, R> {
    R apply(T t, U u, X x, Y y, Z z);
}
