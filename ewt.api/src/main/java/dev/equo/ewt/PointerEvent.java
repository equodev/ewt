package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import static dev.equo.ewt.NativeObj.Base.intToBool;
public abstract class PointerEvent extends NativeObj.Base implements PointerEventI {
  protected PointerEvent() {}
  PointerEvent(int id) {
    this.id = id;
  }
  public Offset position() {
    var id = factories.pointerEventPosition(this);
    if (id <= 0) throw new RuntimeException("Failed to call position");
    return new Offset(id);
  }
  public Offset delta() {
    var id = factories.pointerEventDelta(this);
    if (id <= 0) throw new RuntimeException("Failed to call delta");
    return new Offset(id);
  }
  public int pointer() {
    var id = factories.pointerEventPointer(this);
    if (id <= 0) throw new RuntimeException("Failed to call pointer");
    return id;
  }
  public int buttons() {
    var id = factories.pointerEventButtons(this);
    if (id <= 0) throw new RuntimeException("Failed to call buttons");
    return id;
  }
  public boolean down() {
    var id = factories.pointerEventDown(this);
    if (id <= 0) throw new RuntimeException("Failed to call down");
    return intToBool(id);
  }
  public double pressure() {
    var id = factories.pointerEventPressure(this);
    return id;
  }
  public double distance() {
    var id = factories.pointerEventDistance(this);
    return id;
  }
  public double size() {
    var id = factories.pointerEventSize(this);
    return id;
  }
  @Override
  public PointerEvent build() {
    return this;
  }
}
