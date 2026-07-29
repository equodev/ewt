package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class ExpansionPanel extends NativeObj.Base implements ExpansionPanelI {
  protected ExpansionPanel() {}
  ExpansionPanel(int id) {
    this.id = id;
  }
  public static ExpansionPanel byId(int id) { return new ExpansionPanel(id); }
  @Builder.Factory
  static ExpansionPanel expansionPanelExpansionPanel(@Builder.Parameter BiFunction<BuildContext, Boolean, Widget> headerBuilder, @Builder.Parameter WidgetI body, Optional<Boolean> isExpanded, Optional<Boolean> canTapOnHeader, Optional<ColorI> backgroundColor, Optional<ColorI> splashColor, Optional<ColorI> highlightColor) {
    int id = factories.expansionPanelExpansionPanel(headerBuilder,
      body.build(),
      isExpanded,
      canTapOnHeader,
      backgroundColor.map(ColorI::build),
      splashColor.map(ColorI::build),
      highlightColor.map(ColorI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget ExpansionPanel");
    System.out.println("New ExpansionPanel id:"+id);
    return new ExpansionPanel(id);
  }
  public static ExpansionPanelExpansionPanelBuilder expansionPanel(BiFunction<BuildContext, Boolean, Widget> headerBuilder, WidgetI body) {
    return ExpansionPanelExpansionPanelBuilder.expansionPanelExpansionPanel(headerBuilder, body);
  }
  @Override
  public ExpansionPanel build() {
    return this;
  }
}
