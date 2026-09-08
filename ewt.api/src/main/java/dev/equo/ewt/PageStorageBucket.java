package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class PageStorageBucket extends NativeObj.Base implements PageStorageBucketI {
  protected PageStorageBucket() {}
  PageStorageBucket(int id) {
    this.id = id;
  }
  public static PageStorageBucket byId(int id) { return new PageStorageBucket(id); }
  @Builder.Factory
  static PageStorageBucket pageStorageBucketPageStorageBucket() {
    int id = factories.pageStorageBucketPageStorageBucket();
    if (id <= 0) throw new RuntimeException("Failed to created widget PageStorageBucket");
    System.out.println("New PageStorageBucket id:"+id);
    return new PageStorageBucket(id);
  }
  public static PageStorageBucketPageStorageBucketBuilder pageStorageBucket() {
    return PageStorageBucketPageStorageBucketBuilder.pageStorageBucketPageStorageBucket();
  }
  @Override
  public PageStorageBucket build() {
    return this;
  }
}
