package dev.equo.ewt.util;

@FunctionalInterface
public interface QuadConsumer<T, U, X, Y> {

    /**
     * Performs this operation on the given arguments.
     *
     * @param t the first argument
     * @param u the second argument
     * @param x the third argument
     * @param y the fourth argument
     */
    void accept(T t, U u, X x, Y y);
}
