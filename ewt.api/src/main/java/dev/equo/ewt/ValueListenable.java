package dev.equo.ewt;
import java.util.*;
public interface ValueListenable<T> extends Listenable, ValueListenableI {
  @Override
  default ValueListenable build() {
    return this;
  }
}
