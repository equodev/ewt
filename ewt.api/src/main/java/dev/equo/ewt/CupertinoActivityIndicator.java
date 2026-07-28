package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.CupertinoActivityIndicatorObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class CupertinoActivityIndicator extends StatefulWidget implements CupertinoActivityIndicatorI {
  private MemorySegment st;
  protected CupertinoActivityIndicator() {}
  CupertinoActivityIndicator(MemorySegment st) {
    this.id = CupertinoActivityIndicatorObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoActivityIndicator");
    System.out.println("New CupertinoActivityIndicator id:"+id);
  }
  CupertinoActivityIndicator(int id) { this.id = id; }
  @Builder.Factory
  static CupertinoActivityIndicator cupertinoActivityIndicatorCupertinoActivityIndicator(Optional<ColorI> color, Optional<Boolean> animating, OptionalDouble radius) {
    var st = factories.cupertinoActivityIndicatorCupertinoActivityIndicator(color.map(ColorI::build),
      animating,
      radius);
    if (st == null) throw new RuntimeException("Failed to created widget CupertinoActivityIndicator");
    return new CupertinoActivityIndicator(st);
  }
  public static CupertinoActivityIndicatorCupertinoActivityIndicatorBuilder cupertinoActivityIndicator() {
    return CupertinoActivityIndicatorCupertinoActivityIndicatorBuilder.cupertinoActivityIndicatorCupertinoActivityIndicator();
  }
  @Builder.Factory
  static CupertinoActivityIndicator cupertinoActivityIndicatorPartiallyRevealed(Optional<ColorI> color, OptionalDouble radius, OptionalDouble progress) {
    var st = factories.cupertinoActivityIndicatorPartiallyRevealed(color.map(ColorI::build),
      radius,
      progress);
    if (st == null) throw new RuntimeException("Failed to created widget CupertinoActivityIndicator");
    return new CupertinoActivityIndicator(st);
  }
  public static CupertinoActivityIndicatorPartiallyRevealedBuilder partiallyRevealed() {
    return CupertinoActivityIndicatorPartiallyRevealedBuilder.cupertinoActivityIndicatorPartiallyRevealed();
  }
  public Color color() {
    return new Color(CupertinoActivityIndicatorObjSt.color(st));
  }
  public boolean animating() {
    return intToBool(CupertinoActivityIndicatorObjSt.animating(st));
  }
  public double radius() {
    return CupertinoActivityIndicatorObjSt.radius(st);
  }
  public double progress() {
    return CupertinoActivityIndicatorObjSt.progress(st);
  }
  @Override
  public CupertinoActivityIndicator build() {
    return this;
  }
}
