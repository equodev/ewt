package dev.equo.ewt;
import java.util.*;
public interface BuildContext extends NativeObj, BuildContextI {
  @Override
  default BuildContext build() {
    return this;
  }
}
