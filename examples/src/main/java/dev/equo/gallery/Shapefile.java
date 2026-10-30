package dev.equo.gallery;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * A minimal, dependency-free reader for Esri shapefiles — the native format
 * DecisionSpace loads. A "shapefile" is a set of sibling files: {@code .shp}
 * (binary geometry), {@code .dbf} (dBASE attribute table), {@code .shx} (index),
 * {@code .prj} (CRS). This reads the {@code .shp} geometry + {@code .dbf}
 * attributes and emits a GeoJSON FeatureCollection the EWT map already renders,
 * proving the viewer ingests their data straight from {@code .shp} rather than a
 * pre-converted GeoJSON.
 *
 * <p>Supports Point(1), PolyLine(3), Polygon(5) and their Z/M variants' XY.
 * Coordinates are assumed WGS84 lon/lat (the sample {@code .prj} is GCS_WGS_1984).
 * The {@code .shp} main header and record headers are big-endian; record content
 * and the whole {@code .dbf} are little-endian — per the Esri spec.
 */
public final class Shapefile {
  private Shapefile() {}

  /** Wraps the (lease, pipelines, wells) feature fragments into one collection. */
  public static String merge(String... featureArrays) {
    StringBuilder sb = new StringBuilder("{\"type\":\"FeatureCollection\",\"features\":[");
    boolean first = true;
    for (String fa : featureArrays) {
      if (fa == null || fa.isEmpty()) continue;
      if (!first) sb.append(",");
      sb.append(fa);
      first = false;
    }
    return sb.append("]}").toString();
  }

  /** Reads one shapefile to a GeoJSON FeatureCollection string. */
  public static String toGeoJson(byte[] shp, byte[] dbf) {
    return merge(featureArray(shp, dbf));
  }

  /** Reads one shapefile to the comma-joined Feature list (no collection wrapper). */
  public static String featureArray(byte[] shp, byte[] dbf) {
    if (shp == null || shp.length < 100) return "";
    List<String> geoms = shapes(shp);
    List<Map<String, Object>> attrs = (dbf != null && dbf.length >= 32)
        ? dbf(dbf) : new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    boolean first = true;
    for (int i = 0; i < geoms.size(); i++) {
      if (geoms.get(i) == null) continue;
      if (!first) sb.append(",");
      sb.append("{\"type\":\"Feature\",\"properties\":")
        .append(i < attrs.size() ? propsJson(attrs.get(i)) : "{}")
        .append(",\"geometry\":").append(geoms.get(i)).append("}");
      first = false;
    }
    return sb.toString();
  }

  // --- .shp geometry ---------------------------------------------------------

  private static List<String> shapes(byte[] shp) {
    List<String> out = new ArrayList<>();
    ByteBuffer bb = ByteBuffer.wrap(shp);
    int pos = 100; // skip the 100-byte main header
    while (pos + 8 <= shp.length) {
      bb.order(ByteOrder.BIG_ENDIAN);
      int contentLen = bb.getInt(pos + 4); // 16-bit words
      int cs = pos + 8;
      int bytes = contentLen * 2;
      if (cs + bytes > shp.length || bytes < 4) break;
      bb.order(ByteOrder.LITTLE_ENDIAN);
      out.add(geom(bb, cs, bb.getInt(cs)));
      pos = cs + bytes;
    }
    return out;
  }

  private static String geom(ByteBuffer bb, int cs, int type) {
    switch (type) {
      case 1:   // Point
      case 11:  // PointZ
      case 21:  // PointM
        return "{\"type\":\"Point\",\"coordinates\":["
            + num(bb.getDouble(cs + 4)) + "," + num(bb.getDouble(cs + 12)) + "]}";
      case 3:   // PolyLine
      case 13:  // PolyLineZ
      case 23:  // PolyLineM
        return multi(bb, cs, "LineString");
      case 5:   // Polygon
      case 15:  // PolygonZ
      case 25:  // PolygonM
        return multi(bb, cs, "Polygon");
      case 8:   // MultiPoint
      case 18:
      case 28:
        return multipoint(bb, cs);
      default:  // Null or unsupported
        return null;
    }
  }

  // PolyLine/Polygon share a layout: box(32) numParts(4) numPoints(4) parts[] points[].
  private static String multi(ByteBuffer bb, int cs, String kind) {
    int numParts = bb.getInt(cs + 36);
    int numPoints = bb.getInt(cs + 40);
    int partsOff = cs + 44;
    int ptsOff = partsOff + numParts * 4;
    int[] parts = new int[numParts + 1];
    for (int i = 0; i < numParts; i++) parts[i] = bb.getInt(partsOff + i * 4);
    parts[numParts] = numPoints;

    List<String> rings = new ArrayList<>();
    for (int p = 0; p < numParts; p++) {
      StringBuilder r = new StringBuilder("[");
      for (int i = parts[p]; i < parts[p + 1]; i++) {
        int o = ptsOff + i * 16;
        if (i > parts[p]) r.append(",");
        r.append("[").append(num(bb.getDouble(o))).append(",")
         .append(num(bb.getDouble(o + 8))).append("]");
      }
      rings.add(r.append("]").toString());
    }
    if (kind.equals("Polygon")) {
      return "{\"type\":\"Polygon\",\"coordinates\":[" + String.join(",", rings) + "]}";
    }
    // PolyLine: one part → LineString, many → MultiLineString.
    if (rings.size() == 1) {
      return "{\"type\":\"LineString\",\"coordinates\":" + rings.get(0) + "}";
    }
    return "{\"type\":\"MultiLineString\",\"coordinates\":[" + String.join(",", rings) + "]}";
  }

  private static String multipoint(ByteBuffer bb, int cs) {
    int numPoints = bb.getInt(cs + 36);
    int ptsOff = cs + 40;
    StringBuilder r = new StringBuilder("{\"type\":\"MultiPoint\",\"coordinates\":[");
    for (int i = 0; i < numPoints; i++) {
      int o = ptsOff + i * 16;
      if (i > 0) r.append(",");
      r.append("[").append(num(bb.getDouble(o))).append(",")
       .append(num(bb.getDouble(o + 8))).append("]");
    }
    return r.append("]}").toString();
  }

  // --- .dbf attributes (dBASE III) -------------------------------------------

  private static List<Map<String, Object>> dbf(byte[] d) {
    List<Map<String, Object>> out = new ArrayList<>();
    ByteBuffer bb = ByteBuffer.wrap(d).order(ByteOrder.LITTLE_ENDIAN);
    int numRec = bb.getInt(4);
    int headerSize = bb.getShort(8) & 0xFFFF;
    int recSize = bb.getShort(10) & 0xFFFF;

    List<String> names = new ArrayList<>();
    List<Character> types = new ArrayList<>();
    List<Integer> lens = new ArrayList<>();
    int p = 32;
    while (p + 32 <= headerSize && (d[p] & 0xFF) != 0x0D) {
      StringBuilder nm = new StringBuilder();
      for (int j = 0; j < 11; j++) {
        int ch = d[p + j] & 0xFF;
        if (ch != 0) nm.append((char) ch);
      }
      names.add(nm.toString().trim());
      types.add((char) (d[p + 11] & 0xFF));
      lens.add(d[p + 16] & 0xFF);
      p += 32;
    }

    int rp = headerSize;
    for (int r = 0; r < numRec && rp + recSize <= d.length; r++) {
      int fp = rp + 1; // skip the deletion flag
      Map<String, Object> row = new LinkedHashMap<>();
      for (int f = 0; f < names.size(); f++) {
        int len = lens.get(f);
        String val = new String(d, fp, len, StandardCharsets.ISO_8859_1).trim();
        char t = types.get(f);
        row.put(names.get(f), (t == 'N' || t == 'F') ? (Object) num(val) : val);
        fp += len;
      }
      out.add(row);
      rp += recSize;
    }
    return out;
  }

  // --- JSON helpers ----------------------------------------------------------

  private static String propsJson(Map<String, Object> row) {
    StringBuilder sb = new StringBuilder("{");
    boolean first = true;
    for (Map.Entry<String, Object> e : row.entrySet()) {
      if (!first) sb.append(",");
      sb.append("\"").append(esc(e.getKey())).append("\":");
      Object v = e.getValue();
      if (v instanceof Number) sb.append(v.toString());
      else sb.append("\"").append(esc(String.valueOf(v))).append("\"");
      first = false;
    }
    return sb.append("}").toString();
  }

  // A numeric string → Integer/Double, or the raw string if it is not numeric.
  private static Object num(String s) {
    if (s.isEmpty()) return "";
    try {
      if (s.indexOf('.') < 0 && s.indexOf('e') < 0 && s.indexOf('E') < 0) {
        return Long.parseLong(s);
      }
      return Double.parseDouble(s);
    } catch (NumberFormatException e) {
      return s;
    }
  }

  private static String num(double d) {
    if (d == Math.floor(d) && !Double.isInfinite(d)) return Long.toString((long) d);
    return Double.toString(d);
  }

  private static String esc(String s) {
    return s.replace("\\", "\\\\").replace("\"", "\\\"");
  }
}
