package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class ExpansionPanelRadio extends ExpansionPanel implements ExpansionPanelRadioI {
  protected ExpansionPanelRadio() {}
  ExpansionPanelRadio(int id) {
    this.id = id;
  }
  public static ExpansionPanelRadio byId(int id) { return new ExpansionPanelRadio(id); }
  @Builder.Factory
  static ExpansionPanelRadio expansionPanelRadioExpansionPanelRadio(@Builder.Parameter NativeObj.I value, @Builder.Parameter BiFunction<BuildContext, Boolean, Widget> headerBuilder, @Builder.Parameter WidgetI body, Optional<Boolean> canTapOnHeader, Optional<ColorI> backgroundColor, Optional<ColorI> splashColor, Optional<ColorI> highlightColor) {
    int id = factories.expansionPanelRadioExpansionPanelRadio(value.build(),
      headerBuilder,
      body.build(),
      canTapOnHeader,
      backgroundColor.map(ColorI::build),
      splashColor.map(ColorI::build),
      highlightColor.map(ColorI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget ExpansionPanelRadio");
    System.out.println("New ExpansionPanelRadio id:"+id);
    return new ExpansionPanelRadio(id);
  }
  public static ExpansionPanelRadioExpansionPanelRadioBuilder expansionPanelRadio(NativeObj.I value, BiFunction<BuildContext, Boolean, Widget> headerBuilder, WidgetI body) {
    return ExpansionPanelRadioExpansionPanelRadioBuilder.expansionPanelRadioExpansionPanelRadio(value, headerBuilder, body);
  }
  @Override
  public ExpansionPanelRadio build() {
    return this;
  }
}
