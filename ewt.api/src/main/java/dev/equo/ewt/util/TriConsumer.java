package dev.equo.ewt.util;

@FunctionalInterface
public interface TriConsumer<T, U, X> {

    /**
     * Performs this operation on the given arguments.
     *
     * @param t the first argument
     * @param u the second argument
     * @param x the third argument
     */
    void accept(T t, U u, X x);
}
