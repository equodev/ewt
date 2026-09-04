package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.PageStorageObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class PageStorage extends StatelessWidget implements PageStorageI {
  private MemorySegment st;
  protected PageStorage() {}
  PageStorage(MemorySegment st) {
    this.id = PageStorageObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget PageStorage");
    System.out.println("New PageStorage id:"+id);
  }
  PageStorage(int id) { this.id = id; }
  @Builder.Factory
  static PageStorage pageStoragePageStorage(@Builder.Parameter PageStorageBucketI bucket, @Builder.Parameter WidgetI child) {
    var st = factories.pageStoragePageStorage(bucket.build(),
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget PageStorage");
    return new PageStorage(st);
  }
  public static PageStoragePageStorageBuilder pageStorage(PageStorageBucketI bucket, WidgetI child) {
    return PageStoragePageStorageBuilder.pageStoragePageStorage(bucket, child);
  }
  public static PageStorageBucket maybeOf(BuildContextI context) {
    int id = factories.pageStorageMaybeOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget PageStorageBucket?");
    System.out.println("New PageStorageBucket? id:"+id);
    return new PageStorageBucket(id);
  }
  public static PageStorageBucket of(BuildContextI context) {
    int id = factories.pageStorageOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget PageStorageBucket");
    System.out.println("New PageStorageBucket id:"+id);
    return new PageStorageBucket(id);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("pageStorageChild not supported on web");
    return new Widget(PageStorageObjSt.child(st)) {};
  }
  public PageStorageBucket bucket() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("pageStorageBucket", getId());
      return new PageStorageBucket(__nid);
    }
    return new PageStorageBucket(PageStorageObjSt.bucket(st));
  }
  @Override
  public PageStorage build() {
    return this;
  }
}
