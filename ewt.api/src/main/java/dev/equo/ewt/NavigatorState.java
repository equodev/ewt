package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import org.immutables.builder.Builder;
public class NavigatorState extends State<Navigator> implements NavigatorStateI {
  protected NavigatorState() {}
  NavigatorState(int id) {
    this.id = id;
  }
  @Builder.Factory
  static NavigatorState navigatorStateNavigatorState() {
    int id = factories.navigatorStateNavigatorState();
    if (id == -1) throw new RuntimeException("Failed to created widget NavigatorState");
    System.out.println("New NavigatorState id:"+id);
    return new NavigatorState(id);
  }
  public static NavigatorStateNavigatorStateBuilder navigatorState() {
    return NavigatorStateNavigatorStateBuilder.navigatorStateNavigatorState();
  }
  @Override
  public NavigatorState build() {
    return this;
  }
}
