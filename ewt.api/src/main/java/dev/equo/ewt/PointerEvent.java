package dev.equo.ewt;
import java.util.*;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public abstract class PointerEvent extends NativeObj.Base implements PointerEventI {
  protected PointerEvent() {}
  PointerEvent(int id) {
    this.id = id;
  }
  public Offset position() {
    int id = factories.pointerEventPosition(this);
    if (id <= 0) throw new RuntimeException("Failed to call position");
    return new Offset(id);
  }
  public Offset delta() {
    int id = factories.pointerEventDelta(this);
    if (id <= 0) throw new RuntimeException("Failed to call delta");
    return new Offset(id);
  }
  public int pointer() {
    int id = factories.pointerEventPointer(this);
    if (id <= 0) throw new RuntimeException("Failed to call pointer");
    return id;
  }
  public int buttons() {
    int id = factories.pointerEventButtons(this);
    if (id <= 0) throw new RuntimeException("Failed to call buttons");
    return id;
  }
  public boolean down() {
    int id = factories.pointerEventDown(this);
    if (id <= 0) throw new RuntimeException("Failed to call down");
    return intToBool(id);
  }
  public double pressure() {
    double id = factories.pointerEventPressure(this);
    return id;
  }
  public double distance() {
    double id = factories.pointerEventDistance(this);
    return id;
  }
  public double size() {
    double id = factories.pointerEventSize(this);
    return id;
  }
  @Override
  public PointerEvent build() {
    return this;
  }
}
