package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class CloseButtonIcon extends StatelessWidget implements CloseButtonIconI {
  protected CloseButtonIcon() {}
  CloseButtonIcon(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget CloseButtonIcon");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static CloseButtonIcon closeButtonIconCloseButtonIcon() {
    int id = factories.closeButtonIconCloseButtonIcon();
    if (id <= 0) throw new RuntimeException("Failed to created widget CloseButtonIcon");
    return new CloseButtonIcon(id);
  }
  public static CloseButtonIconCloseButtonIconBuilder closeButtonIcon() {
    return CloseButtonIconCloseButtonIconBuilder.closeButtonIconCloseButtonIcon();
  }
  @Override
  public CloseButtonIcon build() {
    return this;
  }
}
