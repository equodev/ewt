package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class CupertinoListTileChevron extends StatelessWidget implements CupertinoListTileChevronI {
  protected CupertinoListTileChevron() {}
  CupertinoListTileChevron(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoListTileChevron");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static CupertinoListTileChevron cupertinoListTileChevronCupertinoListTileChevron() {
    int id = factories.cupertinoListTileChevronCupertinoListTileChevron();
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoListTileChevron");
    return new CupertinoListTileChevron(id);
  }
  public static CupertinoListTileChevronCupertinoListTileChevronBuilder cupertinoListTileChevron() {
    return CupertinoListTileChevronCupertinoListTileChevronBuilder.cupertinoListTileChevronCupertinoListTileChevron();
  }
  @Override
  public CupertinoListTileChevron build() {
    return this;
  }
}
