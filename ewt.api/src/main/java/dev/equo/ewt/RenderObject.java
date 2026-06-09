package dev.equo.ewt;
import java.util.*;
public interface RenderObject extends NativeObj, RenderObjectI {
  @Override
  default RenderObject build() {
    return this;
  }
}
