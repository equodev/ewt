package dev.equo.ewt;
import java.util.*;
public interface ValueListenable<T> extends Listenable {
  @Override
  default ValueListenable build() {
    return this;
  }
}
