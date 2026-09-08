package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.EndDrawerButtonIconObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class EndDrawerButtonIcon extends StatelessWidget implements EndDrawerButtonIconI {
  private MemorySegment st;
  protected EndDrawerButtonIcon() {}
  EndDrawerButtonIcon(MemorySegment st) {
    this.id = EndDrawerButtonIconObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget EndDrawerButtonIcon");
    System.out.println("New EndDrawerButtonIcon id:"+id);
  }
  EndDrawerButtonIcon(int id) { this.id = id; }
  @Builder.Factory
  static EndDrawerButtonIcon endDrawerButtonIconEndDrawerButtonIcon() {
    var st = factories.endDrawerButtonIconEndDrawerButtonIcon();
    if (st == null) throw new RuntimeException("Failed to created widget EndDrawerButtonIcon");
    return new EndDrawerButtonIcon(st);
  }
  public static EndDrawerButtonIconEndDrawerButtonIconBuilder endDrawerButtonIcon() {
    return EndDrawerButtonIconEndDrawerButtonIconBuilder.endDrawerButtonIconEndDrawerButtonIcon();
  }
  @Override
  public EndDrawerButtonIcon build() {
    return this;
  }
}
