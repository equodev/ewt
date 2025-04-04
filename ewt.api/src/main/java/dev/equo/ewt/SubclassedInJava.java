package dev.equo.ewt;

import java.util.HashMap;
import java.util.Map;

interface SubclassedInJava extends NativeObj {
  Map<Integer, SubclassedInJava> ids = new HashMap<>();

  static <T extends NativeObj> T getSubNatObj(int widget) {
    return (T) ids.get(widget);
  }
  static void addSubNatObj(SubclassedInJava w) {
    ids.put(w.getId(), w);
  }
}
