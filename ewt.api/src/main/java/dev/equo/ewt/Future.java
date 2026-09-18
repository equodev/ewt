package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public interface Future<T> extends NativeObj, FutureI {
  public default void then(Consumer<NativeObj> onValue) {
    NativeObj.Base.factories.futureThen(((Future) this),
      onValue);
  }
  @Override
  default Future build() {
    return this;
  }
}
