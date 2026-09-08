package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.SliverVariedExtentListObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class SliverVariedExtentList extends SliverMultiBoxAdaptorWidget implements SliverVariedExtentListI {
  private MemorySegment st;
  protected SliverVariedExtentList() {}
  SliverVariedExtentList(MemorySegment st) {
    this.id = SliverVariedExtentListObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverVariedExtentList");
    System.out.println("New SliverVariedExtentList id:"+id);
  }
  SliverVariedExtentList(int id) { this.id = id; }
  @Override
  public SliverVariedExtentList build() {
    return this;
  }
}
