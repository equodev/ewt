package dev.equo.ewt;
import java.util.*;
import org.immutables.builder.Builder;
public abstract class SubState<T extends StatefulWidget> extends State<T> {
  protected SubState() {
    int id = factories.subStateSubState(() -> {System.out.println("errrr");});
    if (id == -1) throw new RuntimeException("Failed to created widget SubState");
    System.out.println("New SubState id:"+id);
    this.id = id;
  }
  protected abstract Widget build();
}
