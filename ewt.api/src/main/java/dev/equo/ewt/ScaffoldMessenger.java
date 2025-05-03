package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ScaffoldMessengerObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class ScaffoldMessenger extends StatefulWidget implements ScaffoldMessengerI {
  private MemorySegment st;
  protected ScaffoldMessenger() {}
  ScaffoldMessenger(MemorySegment st) {
    this.id = ScaffoldMessengerObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget ScaffoldMessenger");
    System.out.println("New ScaffoldMessenger id:"+id);
  }
  @Builder.Factory
  static ScaffoldMessenger scaffoldMessengerScaffoldMessenger(@Builder.Parameter WidgetI child) {
    var st = factories.scaffoldMessengerScaffoldMessenger(child.build());
    if (st == null) throw new RuntimeException("Failed to created widget ScaffoldMessenger");
    return new ScaffoldMessenger(st);
  }
  public static ScaffoldMessengerScaffoldMessengerBuilder scaffoldMessenger(WidgetI child) {
    return ScaffoldMessengerScaffoldMessengerBuilder.scaffoldMessengerScaffoldMessenger(child);
  }
  public Widget child() {
    return new Widget(ScaffoldMessengerObjSt.child(st)) {};
  }
  @Override
  public ScaffoldMessenger build() {
    return this;
  }
}
