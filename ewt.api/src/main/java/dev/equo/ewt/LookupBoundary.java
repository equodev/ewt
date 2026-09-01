package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.LookupBoundaryObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class LookupBoundary extends InheritedWidget implements LookupBoundaryI {
  private MemorySegment st;
  protected LookupBoundary() {}
  LookupBoundary(MemorySegment st) {
    this.id = LookupBoundaryObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget LookupBoundary");
    System.out.println("New LookupBoundary id:"+id);
  }
  LookupBoundary(int id) { this.id = id; }
  @Builder.Factory
  static LookupBoundary lookupBoundaryLookupBoundary(@Builder.Parameter WidgetI child) {
    var st = factories.lookupBoundaryLookupBoundary(child.build());
    if (st == null) throw new RuntimeException("Failed to created widget LookupBoundary");
    return new LookupBoundary(st);
  }
  public static LookupBoundaryLookupBoundaryBuilder lookupBoundary(WidgetI child) {
    return LookupBoundaryLookupBoundaryBuilder.lookupBoundaryLookupBoundary(child);
  }
  public static NativeObj dependOnInheritedWidgetOfExactType(BuildContextI context) {
    int id = factories.lookupBoundaryDependOnInheritedWidgetOfExactType(context.build(),
      Optional.empty());
    if (id <= 0) throw new RuntimeException("Failed to created widget T?");
    System.out.println("New T? id:"+id);
    return (NativeObj) new NativeObj.Base() {{ this.id = id; }};
  }
  public static NativeObj findAncestorWidgetOfExactType(BuildContextI context) {
    int id = factories.lookupBoundaryFindAncestorWidgetOfExactType(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget T?");
    System.out.println("New T? id:"+id);
    return (NativeObj) new NativeObj.Base() {{ this.id = id; }};
  }
  public static NativeObj findAncestorStateOfType(BuildContextI context) {
    int id = factories.lookupBoundaryFindAncestorStateOfType(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget T?");
    System.out.println("New T? id:"+id);
    return (NativeObj) new NativeObj.Base() {{ this.id = id; }};
  }
  public static NativeObj findRootAncestorStateOfType(BuildContextI context) {
    int id = factories.lookupBoundaryFindRootAncestorStateOfType(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget T?");
    System.out.println("New T? id:"+id);
    return (NativeObj) new NativeObj.Base() {{ this.id = id; }};
  }
  public static NativeObj findAncestorRenderObjectOfType(BuildContextI context) {
    int id = factories.lookupBoundaryFindAncestorRenderObjectOfType(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget T?");
    System.out.println("New T? id:"+id);
    return (NativeObj) new NativeObj.Base() {{ this.id = id; }};
  }
  public static boolean debugIsHidingAncestorWidgetOfExactType(BuildContextI context) {
    int id = factories.lookupBoundaryDebugIsHidingAncestorWidgetOfExactType(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget bool");
    System.out.println("New bool id:"+id);
    return intToBool(id);
  }
  public static boolean debugIsHidingAncestorStateOfType(BuildContextI context) {
    int id = factories.lookupBoundaryDebugIsHidingAncestorStateOfType(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget bool");
    System.out.println("New bool id:"+id);
    return intToBool(id);
  }
  public static boolean debugIsHidingAncestorRenderObjectOfType(BuildContextI context) {
    int id = factories.lookupBoundaryDebugIsHidingAncestorRenderObjectOfType(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget bool");
    System.out.println("New bool id:"+id);
    return intToBool(id);
  }
  @Override
  public LookupBoundary build() {
    return this;
  }
}
