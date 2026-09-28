package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class BackButtonIcon extends StatelessWidget implements BackButtonIconI {
  protected BackButtonIcon() {}
  BackButtonIcon(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget BackButtonIcon");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static BackButtonIcon backButtonIconBackButtonIcon() {
    int id = factories.backButtonIconBackButtonIcon();
    if (id <= 0) throw new RuntimeException("Failed to created widget BackButtonIcon");
    return new BackButtonIcon(id);
  }
  public static BackButtonIconBackButtonIconBuilder backButtonIcon() {
    return BackButtonIconBackButtonIconBuilder.backButtonIconBackButtonIcon();
  }
  @Override
  public BackButtonIcon build() {
    return this;
  }
}
