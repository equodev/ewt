package dev.equo.ewt;
import java.util.*;
public abstract class SliderComponentShape extends NativeObj.Base implements SliderComponentShapeI {
  protected SliderComponentShape() {}
  SliderComponentShape(int id) {
    this.id = id;
  }
  @Override
  public SliderComponentShape build() {
    return this;
  }
}
