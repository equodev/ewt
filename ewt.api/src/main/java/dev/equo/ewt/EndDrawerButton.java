package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.EndDrawerButtonObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class EndDrawerButton extends IconButton implements EndDrawerButtonI {
  private MemorySegment st;
  protected EndDrawerButton() {}
  EndDrawerButton(MemorySegment st) {
    this.id = EndDrawerButtonObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget EndDrawerButton");
    System.out.println("New EndDrawerButton id:"+id);
  }
  EndDrawerButton(int id) { this.id = id; }
  @Builder.Factory
  static EndDrawerButton endDrawerButtonEndDrawerButton(Optional<ColorI> color, Optional<Runnable> onPressed) {
    var st = factories.endDrawerButtonEndDrawerButton(color.map(ColorI::build),
      onPressed);
    if (st == null) throw new RuntimeException("Failed to created widget EndDrawerButton");
    return new EndDrawerButton(st);
  }
  public static EndDrawerButtonEndDrawerButtonBuilder endDrawerButton() {
    return EndDrawerButtonEndDrawerButtonBuilder.endDrawerButtonEndDrawerButton();
  }
  @Override
  public EndDrawerButton build() {
    return this;
  }
}
