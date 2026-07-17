package dev.equo.ewt;

import dev.equo.ewt.ffm.SizedBoxObjSt;
import dev.equo.ewt.ffm.TextObjSt;
import dev.equo.ewt.web.EwtNode;

import java.lang.foreign.MemorySegment;
import java.util.*;

/**
 * Web-mode replacement for the FFM {@link WidgetConstructors}. Instead of marshaling params to
 * native, each override records an {@link EwtNode} and returns an id-only {@code *ObjSt} segment
 * so the existing Java builder code (which reads {@code *ObjSt.id(st)}) is unaffected. No native
 * call is made. Phase 0 records only {@code Text} and {@code SizedBox}; unrecorded widgets fall
 * through to the FFM superclass and must not be used on web yet.
 */
public class SerializingWidgetConstructors extends WidgetConstructors {

  private int nextId = 1;
  private final Map<Integer, EwtNode> byId = new HashMap<>();

  /** Returns the recorded node whose widget id equals {@code rootWidgetId}. */
  public EwtNode rootNode(int rootWidgetId) {
    EwtNode n = byId.get(rootWidgetId);
    if (n == null) throw new IllegalStateException("No recorded node for id " + rootWidgetId);
    return n;
  }

  /**
   * Web path: build {@code builder}'s subtree through a fresh SerializingWidgetConstructors
   * installed as the active constructors, and return its root node. Restores the previous
   * constructors afterward. No native call is made. Widget construction reads
   * {@code NativeObj.Base.factories}, so that is the field swapped here.
   */
  public static EwtNode captureSubtree(java.util.concurrent.Callable<Widget> builder) throws Exception {
    WidgetConstructors previous = NativeObj.Base.factories;
    SerializingWidgetConstructors serializing = new SerializingWidgetConstructors();
    NativeObj.Base.factories = serializing;
    try {
      Widget root = builder.call().build();
      return serializing.rootNode(root.getId());
    } finally {
      NativeObj.Base.factories = previous;
    }
  }

  private EwtNode record(int id, String type, Map<String, Object> params, List<EwtNode> children) {
    EwtNode n = new EwtNode(id, type, params, children);
    byId.put(id, n);
    return n;
  }

  @Override
  MemorySegment textText(String data, Optional<TextStyle> style, Optional<TextAlign> textAlign,
      Optional<TextDirection> textDirection, Optional<Boolean> softWrap, Optional<TextOverflow> overflow,
      OptionalDouble textScaleFactor, OptionalInt maxLines, Optional<String> semanticsLabel,
      Optional<String> semanticsIdentifier, Optional<TextWidthBasis> textWidthBasis,
      Optional<Color> selectionColor) {
    int id = nextId++;
    Map<String, Object> p = new LinkedHashMap<>();
    p.put("data", data);
    record(id, "Text", p, List.of());
    MemorySegment st = TextObjSt.allocate(arena);
    TextObjSt.id(st, id);
    return st;
  }

  @Override
  MemorySegment sizedBoxSizedBox(OptionalDouble width, OptionalDouble height, Optional<Widget> child) {
    int id = nextId++;
    Map<String, Object> p = new LinkedHashMap<>();
    if (width.isPresent()) p.put("width", width.getAsDouble());
    if (height.isPresent()) p.put("height", height.getAsDouble());
    List<EwtNode> children = child.map(c -> List.of(byId.get(c.getId()))).orElse(List.of());
    record(id, "SizedBox", p, children);
    MemorySegment st = SizedBoxObjSt.allocate(arena);
    SizedBoxObjSt.id(st, id);
    return st;
  }
}
