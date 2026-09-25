package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.CloseButtonObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class CloseButton extends IconButton implements CloseButtonI {
  private MemorySegment st;
  protected CloseButton() {}
  CloseButton(MemorySegment st) {
    this.id = CloseButtonObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget CloseButton");
    System.out.println("New CloseButton id:"+id);
  }
  CloseButton(int id) { this.id = id; }
  @Builder.Factory
  static CloseButton closeButtonCloseButton(Optional<ColorI> color, Optional<Runnable> onPressed) {
    var st = factories.closeButtonCloseButton(color.map(ColorI::build),
      onPressed);
    if (st == null) throw new RuntimeException("Failed to created widget CloseButton");
    return new CloseButton(st);
  }
  public static CloseButtonCloseButtonBuilder closeButton() {
    return CloseButtonCloseButtonBuilder.closeButtonCloseButton();
  }
  @Override
  public CloseButton build() {
    return this;
  }
}
