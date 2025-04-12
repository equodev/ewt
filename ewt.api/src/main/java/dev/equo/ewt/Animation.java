package dev.equo.ewt;
import java.util.*;
public interface Animation<T> extends Listenable {
  @Override
  default Animation build() {
    return this;
  }
}
