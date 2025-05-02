package dev.equo.ewt;
import java.util.*;
public interface Future<T> extends NativeObj, FutureI {
  @Override
  default Future build() {
    return this;
  }
}
