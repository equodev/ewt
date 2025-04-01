package dev.equo.ewt;
import java.util.*;
public interface PreferredSizeWidget extends NativeObj, PreferredSizeWidgetI {
  @Override
  default PreferredSizeWidget build() {
    return this;
  }
}
