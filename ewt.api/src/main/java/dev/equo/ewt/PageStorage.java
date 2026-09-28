package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class PageStorage extends StatelessWidget implements PageStorageI {
  protected PageStorage() {}
  PageStorage(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget PageStorage");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static PageStorage pageStoragePageStorage(@Builder.Parameter PageStorageBucketI bucket, @Builder.Parameter WidgetI child) {
    int id = factories.pageStoragePageStorage(bucket.build(),
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget PageStorage");
    return new PageStorage(id);
  }
  public static PageStoragePageStorageBuilder pageStorage(PageStorageBucketI bucket, WidgetI child) {
    return PageStoragePageStorageBuilder.pageStoragePageStorage(bucket, child);
  }
  public static PageStorageBucket maybeOf(BuildContextI context) {
    var id = factories.pageStorageMaybeOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget PageStorageBucket?");
    System.out.println("New PageStorageBucket? id:"+id);
    return new PageStorageBucket(id);
  }
  public static PageStorageBucket of(BuildContextI context) {
    var id = factories.pageStorageOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget PageStorageBucket");
    System.out.println("New PageStorageBucket id:"+id);
    return new PageStorageBucket(id);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("pageStorageChild not supported on web");
    return factories.PageStorage_readBack_child(nativeStruct);
  }
  public PageStorageBucket bucket() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("pageStorageBucket", getId());
      return new PageStorageBucket(__nid);
    }
    return factories.PageStorage_readBack_bucket(nativeStruct);
  }
  @Override
  public PageStorage build() {
    return this;
  }
}
