package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class BackButton extends IconButton implements BackButtonI {
  protected BackButton() {}
  BackButton(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget BackButton");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static BackButton backButtonBackButton(Optional<ColorI> color, Optional<Runnable> onPressed) {
    int id = factories.backButtonBackButton(color.map(ColorI::build),
      onPressed);
    if (id <= 0) throw new RuntimeException("Failed to created widget BackButton");
    return new BackButton(id);
  }
  public static BackButtonBackButtonBuilder backButton() {
    return BackButtonBackButtonBuilder.backButtonBackButton();
  }
  @Override
  public BackButton build() {
    return this;
  }
}
