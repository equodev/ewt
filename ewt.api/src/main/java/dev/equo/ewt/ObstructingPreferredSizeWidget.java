package dev.equo.ewt;
import java.util.*;
public interface ObstructingPreferredSizeWidget extends NativeObj, ObstructingPreferredSizeWidgetI, PreferredSizeWidget {
  @Override
  default ObstructingPreferredSizeWidget build() {
    return this;
  }
}
