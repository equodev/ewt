package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class StadiumBorder extends OutlinedBorder implements StadiumBorderI {
  protected StadiumBorder() {}
  StadiumBorder(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget StadiumBorder");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static StadiumBorder stadiumBorderStadiumBorder(Optional<BorderSideI> side) {
    int id = factories.stadiumBorderStadiumBorder(side.map(BorderSideI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget StadiumBorder");
    return new StadiumBorder(id);
  }
  public static StadiumBorderStadiumBorderBuilder stadiumBorder() {
    return StadiumBorderStadiumBorderBuilder.stadiumBorderStadiumBorder();
  }
  @Override
  public StadiumBorder build() {
    return this;
  }
}
