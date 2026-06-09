package dev.equo.ewt;
import java.util.*;
public interface TickerProvider extends NativeObj, TickerProviderI {
  @Override
  default TickerProvider build() {
    return this;
  }
}
