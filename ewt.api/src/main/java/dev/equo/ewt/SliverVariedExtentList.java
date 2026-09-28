package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class SliverVariedExtentList extends SliverMultiBoxAdaptorWidget implements SliverVariedExtentListI {
  protected SliverVariedExtentList() {}
  SliverVariedExtentList(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverVariedExtentList");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Override
  public SliverVariedExtentList build() {
    return this;
  }
}
