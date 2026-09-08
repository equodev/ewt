package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.CloseButtonIconObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class CloseButtonIcon extends StatelessWidget implements CloseButtonIconI {
  private MemorySegment st;
  protected CloseButtonIcon() {}
  CloseButtonIcon(MemorySegment st) {
    this.id = CloseButtonIconObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget CloseButtonIcon");
    System.out.println("New CloseButtonIcon id:"+id);
  }
  CloseButtonIcon(int id) { this.id = id; }
  @Builder.Factory
  static CloseButtonIcon closeButtonIconCloseButtonIcon() {
    var st = factories.closeButtonIconCloseButtonIcon();
    if (st == null) throw new RuntimeException("Failed to created widget CloseButtonIcon");
    return new CloseButtonIcon(st);
  }
  public static CloseButtonIconCloseButtonIconBuilder closeButtonIcon() {
    return CloseButtonIconCloseButtonIconBuilder.closeButtonIconCloseButtonIcon();
  }
  @Override
  public CloseButtonIcon build() {
    return this;
  }
}
