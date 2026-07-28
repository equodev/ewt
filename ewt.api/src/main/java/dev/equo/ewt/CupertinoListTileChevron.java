package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.CupertinoListTileChevronObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class CupertinoListTileChevron extends StatelessWidget implements CupertinoListTileChevronI {
  private MemorySegment st;
  protected CupertinoListTileChevron() {}
  CupertinoListTileChevron(MemorySegment st) {
    this.id = CupertinoListTileChevronObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoListTileChevron");
    System.out.println("New CupertinoListTileChevron id:"+id);
  }
  CupertinoListTileChevron(int id) { this.id = id; }
  @Builder.Factory
  static CupertinoListTileChevron cupertinoListTileChevronCupertinoListTileChevron() {
    var st = factories.cupertinoListTileChevronCupertinoListTileChevron();
    if (st == null) throw new RuntimeException("Failed to created widget CupertinoListTileChevron");
    return new CupertinoListTileChevron(st);
  }
  public static CupertinoListTileChevronCupertinoListTileChevronBuilder cupertinoListTileChevron() {
    return CupertinoListTileChevronCupertinoListTileChevronBuilder.cupertinoListTileChevronCupertinoListTileChevron();
  }
  @Override
  public CupertinoListTileChevron build() {
    return this;
  }
}
