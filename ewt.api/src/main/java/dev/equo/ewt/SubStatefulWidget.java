package dev.equo.ewt;
import java.util.*;
import org.immutables.builder.Builder;

import static dev.equo.ewt.EWT.Text;

public abstract class SubStatefulWidget extends StatefulWidget {
  protected SubStatefulWidget() {
    System.out.println(Thread.currentThread() +" SubStatefulWidget.new");
    int id = factories.subStatefulWidgetSubStatefulWidget(() -> {
      System.out.println(Thread.currentThread() +" SubStatefulWidget createState 1");
//        MyHomePageState myHomePageState = new MyHomePageState(this);
      Text("sdaa").build();
      System.out.println("SubStatefulWidget createState 2");
    });
    if (id == -1) throw new RuntimeException("Failed to created widget SubStatefulWidget");
    System.out.println("New SubStatefulWidget id:"+id);
    this.id = id;
  }
  protected abstract <T extends StatefulWidget> State<T> createState();
}
