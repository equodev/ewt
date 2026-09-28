package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class EndDrawerButtonIcon extends StatelessWidget implements EndDrawerButtonIconI {
  protected EndDrawerButtonIcon() {}
  EndDrawerButtonIcon(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget EndDrawerButtonIcon");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static EndDrawerButtonIcon endDrawerButtonIconEndDrawerButtonIcon() {
    int id = factories.endDrawerButtonIconEndDrawerButtonIcon();
    if (id <= 0) throw new RuntimeException("Failed to created widget EndDrawerButtonIcon");
    return new EndDrawerButtonIcon(id);
  }
  public static EndDrawerButtonIconEndDrawerButtonIconBuilder endDrawerButtonIcon() {
    return EndDrawerButtonIconEndDrawerButtonIconBuilder.endDrawerButtonIconEndDrawerButtonIcon();
  }
  @Override
  public EndDrawerButtonIcon build() {
    return this;
  }
}
