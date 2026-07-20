package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.SpacerObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class Spacer extends StatelessWidget implements SpacerI {
  private MemorySegment st;
  protected Spacer() {}
  Spacer(MemorySegment st) {
    this.id = SpacerObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget Spacer");
    System.out.println("New Spacer id:"+id);
  }
  @Builder.Factory
  static Spacer spacerSpacer(OptionalInt flex) {
    var st = factories.spacerSpacer(flex);
    if (st == null) throw new RuntimeException("Failed to created widget Spacer");
    return new Spacer(st);
  }
  public static SpacerSpacerBuilder spacer() {
    return SpacerSpacerBuilder.spacerSpacer();
  }
  public int flex() {
    return SpacerObjSt.flex(st);
  }
  @Override
  public Spacer build() {
    return this;
  }
}
