package dev.equo.ewt;
import java.util.*;
public interface Listenable extends NativeObj, ListenableI {
  @Override
  default Listenable build() {
    return this;
  }
}
