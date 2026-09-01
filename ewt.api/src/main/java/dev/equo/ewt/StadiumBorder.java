package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.StadiumBorderObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class StadiumBorder extends OutlinedBorder implements StadiumBorderI {
  private MemorySegment st;
  protected StadiumBorder() {}
  StadiumBorder(MemorySegment st) {
    this.id = StadiumBorderObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget StadiumBorder");
    System.out.println("New StadiumBorder id:"+id);
  }
  StadiumBorder(int id) { this.id = id; }
  @Builder.Factory
  static StadiumBorder stadiumBorderStadiumBorder(Optional<BorderSideI> side) {
    var st = factories.stadiumBorderStadiumBorder(side.map(BorderSideI::build));
    if (st == null) throw new RuntimeException("Failed to created widget StadiumBorder");
    return new StadiumBorder(st);
  }
  public static StadiumBorderStadiumBorderBuilder stadiumBorder() {
    return StadiumBorderStadiumBorderBuilder.stadiumBorderStadiumBorder();
  }
  @Override
  public StadiumBorder build() {
    return this;
  }
}
