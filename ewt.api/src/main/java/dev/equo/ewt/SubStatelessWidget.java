package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public abstract class SubStatelessWidget extends StatelessWidget implements SubStatelessWidgetI, SubclassedInJava {
  protected SubStatelessWidget() {
    id = factories.subStatelessWidgetSubStatelessWidget(this::buildFn);
    if (id <= 0) throw new RuntimeException("Failed to created widget SubStatelessWidget");
    SubclassedInJava.addSubNatObj(this);
  }
  protected abstract Widget build(BuildContext context);
  Widget buildFn(BuildContext context) {
    return build(context.build()).build();
  }
  @Override
  public SubStatelessWidget build() {
    return this;
  }
}
