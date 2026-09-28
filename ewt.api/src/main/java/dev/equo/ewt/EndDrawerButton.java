package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class EndDrawerButton extends IconButton implements EndDrawerButtonI {
  protected EndDrawerButton() {}
  EndDrawerButton(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget EndDrawerButton");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static EndDrawerButton endDrawerButtonEndDrawerButton(Optional<ColorI> color, Optional<Runnable> onPressed) {
    int id = factories.endDrawerButtonEndDrawerButton(color.map(ColorI::build),
      onPressed);
    if (id <= 0) throw new RuntimeException("Failed to created widget EndDrawerButton");
    return new EndDrawerButton(id);
  }
  public static EndDrawerButtonEndDrawerButtonBuilder endDrawerButton() {
    return EndDrawerButtonEndDrawerButtonBuilder.endDrawerButtonEndDrawerButton();
  }
  @Override
  public EndDrawerButton build() {
    return this;
  }
}
