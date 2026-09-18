package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.BackButtonObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class BackButton extends IconButton implements BackButtonI {
  private MemorySegment st;
  protected BackButton() {}
  BackButton(MemorySegment st) {
    this.id = BackButtonObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget BackButton");
    System.out.println("New BackButton id:"+id);
  }
  BackButton(int id) { this.id = id; }
  @Builder.Factory
  static BackButton backButtonBackButton(Optional<ColorI> color, Optional<Runnable> onPressed) {
    var st = factories.backButtonBackButton(color.map(ColorI::build),
      onPressed);
    if (st == null) throw new RuntimeException("Failed to created widget BackButton");
    return new BackButton(st);
  }
  public static BackButtonBackButtonBuilder backButton() {
    return BackButtonBackButtonBuilder.backButtonBackButton();
  }
  @Override
  public BackButton build() {
    return this;
  }
}
