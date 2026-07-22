package dev.equo.ewt.web;

import java.util.List;
import java.util.Map;

/** Neutral, transport-agnostic description of one EWT widget node. */
public record EwtNode(int id, String type, Map<String, Object> params, List<EwtNode> children) {
}
