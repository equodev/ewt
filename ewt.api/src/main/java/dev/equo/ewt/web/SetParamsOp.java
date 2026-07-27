package dev.equo.ewt.web;

import java.util.List;
import java.util.Map;

/** One patch op: merge {@code set} (primitive params) into the node at {@code path}.
 *  {@code path} elements are String (param key) or Integer (list index). */
public record SetParamsOp(List<Object> path, Map<String, Object> set) {}
