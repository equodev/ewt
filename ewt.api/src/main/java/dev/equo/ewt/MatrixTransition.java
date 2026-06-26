package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.MatrixTransitionObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class MatrixTransition extends AnimatedWidget implements MatrixTransitionI {
  private MemorySegment st;
  protected MatrixTransition() {}
  MatrixTransition(MemorySegment st) {
    this.id = MatrixTransitionObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget MatrixTransition");
    System.out.println("New MatrixTransition id:"+id);
  }
  public Alignment alignment() {
    return new Alignment(MatrixTransitionObjSt.alignment(st));
  }
  public FilterQuality filterQuality() {
    return FilterQuality.values()[MatrixTransitionObjSt.filterQuality(st)];
  }
  public Widget child() {
    return new Widget(MatrixTransitionObjSt.child(st)) {};
  }
  public Animation animation() {
    return new Animation() { public int getId() { return MatrixTransitionObjSt.animation(st); } };
  }
  @Override
  public MatrixTransition build() {
    return this;
  }
}
