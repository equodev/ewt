package dev.equo.ewt;
import java.util.*;
import org.immutables.builder.Builder;
public abstract class SubStatefulWidget extends StatefulWidget {
  protected SubStatefulWidget() {
    int id = factories.subStatefulWidgetSubStatefulWidget(this::createState);
    if (id == -1) throw new RuntimeException("Failed to created widget SubStatefulWidget");
    System.out.println("New SubStatefulWidget id:"+id);
    this.id = id;
  }
  protected abstract <S extends StatefulWidget> State<S> createState();

}
