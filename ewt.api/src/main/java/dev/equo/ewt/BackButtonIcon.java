package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.BackButtonIconObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class BackButtonIcon extends StatelessWidget implements BackButtonIconI {
  private MemorySegment st;
  protected BackButtonIcon() {}
  BackButtonIcon(MemorySegment st) {
    this.id = BackButtonIconObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget BackButtonIcon");
    System.out.println("New BackButtonIcon id:"+id);
  }
  BackButtonIcon(int id) { this.id = id; }
  @Builder.Factory
  static BackButtonIcon backButtonIconBackButtonIcon() {
    var st = factories.backButtonIconBackButtonIcon();
    if (st == null) throw new RuntimeException("Failed to created widget BackButtonIcon");
    return new BackButtonIcon(st);
  }
  public static BackButtonIconBackButtonIconBuilder backButtonIcon() {
    return BackButtonIconBackButtonIconBuilder.backButtonIconBackButtonIcon();
  }
  @Override
  public BackButtonIcon build() {
    return this;
  }
}
