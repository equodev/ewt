package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class CloseButton extends IconButton implements CloseButtonI {
  protected CloseButton() {}
  CloseButton(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget CloseButton");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static CloseButton closeButtonCloseButton(Optional<ColorI> color, Optional<Runnable> onPressed) {
    int id = factories.closeButtonCloseButton(color.map(ColorI::build),
      onPressed);
    if (id <= 0) throw new RuntimeException("Failed to created widget CloseButton");
    return new CloseButton(id);
  }
  public static CloseButtonCloseButtonBuilder closeButton() {
    return CloseButtonCloseButtonBuilder.closeButtonCloseButton();
  }
  @Override
  public CloseButton build() {
    return this;
  }
}
