package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public abstract class SubStatefulWidget extends StatefulWidget implements SubStatefulWidgetI, SubclassedInJava {
  protected SubStatefulWidget() {
    id = factories.subStatefulWidgetSubStatefulWidget(this::createStateFn);
    if (id <= 0) throw new RuntimeException("Failed to created widget SubStatefulWidget");
    SubclassedInJava.addSubNatObj(this);
  }
  protected abstract <S extends StatefulWidget> State<S> createState();
  <S extends StatefulWidget> State<S> createStateFn() {
    return createState().build();
  }
  @Override
  public SubStatefulWidget build() {
    return this;
  }
}
