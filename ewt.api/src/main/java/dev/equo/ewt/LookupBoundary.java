package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class LookupBoundary extends InheritedWidget implements LookupBoundaryI {
  protected LookupBoundary() {}
  LookupBoundary(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget LookupBoundary");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static LookupBoundary lookupBoundaryLookupBoundary(@Builder.Parameter WidgetI child) {
    int id = factories.lookupBoundaryLookupBoundary(child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget LookupBoundary");
    return new LookupBoundary(id);
  }
  public static LookupBoundaryLookupBoundaryBuilder lookupBoundary(WidgetI child) {
    return LookupBoundaryLookupBoundaryBuilder.lookupBoundaryLookupBoundary(child);
  }
  public static NativeObj dependOnInheritedWidgetOfExactType(BuildContextI context) {
    var id = factories.lookupBoundaryDependOnInheritedWidgetOfExactType(context.build(),
      Optional.empty());
    if (id <= 0) throw new RuntimeException("Failed to created widget T?");
    System.out.println("New T? id:"+id);
    return NativeObj.byIdAndType(id, dev.equo.ewt.EWT.widgetTypeOf(id));
  }
  public static NativeObj getInheritedWidgetOfExactType(BuildContextI context) {
    var id = factories.lookupBoundaryGetInheritedWidgetOfExactType(context.build(),
      Optional.empty());
    if (id <= 0) throw new RuntimeException("Failed to created widget T?");
    System.out.println("New T? id:"+id);
    return NativeObj.byIdAndType(id, dev.equo.ewt.EWT.widgetTypeOf(id));
  }
  public static NativeObj findAncestorWidgetOfExactType(BuildContextI context) {
    var id = factories.lookupBoundaryFindAncestorWidgetOfExactType(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget T?");
    System.out.println("New T? id:"+id);
    return NativeObj.byIdAndType(id, dev.equo.ewt.EWT.widgetTypeOf(id));
  }
  public static NativeObj findAncestorStateOfType(BuildContextI context) {
    var id = factories.lookupBoundaryFindAncestorStateOfType(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget T?");
    System.out.println("New T? id:"+id);
    return NativeObj.byIdAndType(id, dev.equo.ewt.EWT.widgetTypeOf(id));
  }
  public static NativeObj findRootAncestorStateOfType(BuildContextI context) {
    var id = factories.lookupBoundaryFindRootAncestorStateOfType(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget T?");
    System.out.println("New T? id:"+id);
    return NativeObj.byIdAndType(id, dev.equo.ewt.EWT.widgetTypeOf(id));
  }
  public static NativeObj findAncestorRenderObjectOfType(BuildContextI context) {
    var id = factories.lookupBoundaryFindAncestorRenderObjectOfType(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget T?");
    System.out.println("New T? id:"+id);
    return NativeObj.byIdAndType(id, dev.equo.ewt.EWT.widgetTypeOf(id));
  }
  public static boolean debugIsHidingAncestorWidgetOfExactType(BuildContextI context) {
    var id = factories.lookupBoundaryDebugIsHidingAncestorWidgetOfExactType(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget bool");
    System.out.println("New bool id:"+id);
    return intToBool(id);
  }
  public static boolean debugIsHidingAncestorStateOfType(BuildContextI context) {
    var id = factories.lookupBoundaryDebugIsHidingAncestorStateOfType(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget bool");
    System.out.println("New bool id:"+id);
    return intToBool(id);
  }
  public static boolean debugIsHidingAncestorRenderObjectOfType(BuildContextI context) {
    var id = factories.lookupBoundaryDebugIsHidingAncestorRenderObjectOfType(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget bool");
    System.out.println("New bool id:"+id);
    return intToBool(id);
  }
  @Override
  public LookupBoundary build() {
    return this;
  }
}
