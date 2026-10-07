package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class Directionality extends InheritedWidget implements DirectionalityI {
  protected Directionality() {}
  Directionality(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget Directionality");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static Directionality directionalityDirectionality(@Builder.Parameter TextDirection textDirection, @Builder.Parameter WidgetI child) {
    int id = factories.directionalityDirectionality(textDirection,
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget Directionality");
    return new Directionality(id);
  }
  public static DirectionalityDirectionalityBuilder directionality(TextDirection textDirection, WidgetI child) {
    return DirectionalityDirectionalityBuilder.directionalityDirectionality(textDirection, child);
  }
  public static TextDirection of(BuildContextI context) {
    var id = factories.directionalityOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget TextDirection");
    return TextDirection.values()[id];
  }
  public static TextDirection maybeOf(BuildContextI context) {
    var id = factories.directionalityMaybeOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget TextDirection?");
    return TextDirection.values()[id];
  }
  public TextDirection textDirection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("directionalityTextDirection not supported on web");
    return factories.Directionality_readBack_textDirection(nativeStruct);
  }
  @Override
  public Directionality build() {
    return this;
  }
}
