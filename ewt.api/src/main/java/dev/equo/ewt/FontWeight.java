package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class FontWeight extends NativeObj.Base implements FontWeightI {
  protected FontWeight() {}
  FontWeight(int id) {
    this.id = id;
  }
  public static FontWeight lerp(FontWeightI a, FontWeightI b, double t) {
    int id = factories.fontWeightLerp(a.build(),
      b.build(),
      t);
    if (id <= 0) throw new RuntimeException("Failed to created widget FontWeight?");
    System.out.println("New FontWeight? id:"+id);
    return new FontWeight(id);
  }
  public static FontWeight w100() {
    int id = factories.fontWeightW100();
    if (id <= 0) throw new RuntimeException("Failed to create const w100");
    System.out.println("Const w100 id:"+id);
    return new FontWeight(id);
  }
  public static FontWeight w200() {
    int id = factories.fontWeightW200();
    if (id <= 0) throw new RuntimeException("Failed to create const w200");
    System.out.println("Const w200 id:"+id);
    return new FontWeight(id);
  }
  public static FontWeight w300() {
    int id = factories.fontWeightW300();
    if (id <= 0) throw new RuntimeException("Failed to create const w300");
    System.out.println("Const w300 id:"+id);
    return new FontWeight(id);
  }
  public static FontWeight w400() {
    int id = factories.fontWeightW400();
    if (id <= 0) throw new RuntimeException("Failed to create const w400");
    System.out.println("Const w400 id:"+id);
    return new FontWeight(id);
  }
  public static FontWeight w500() {
    int id = factories.fontWeightW500();
    if (id <= 0) throw new RuntimeException("Failed to create const w500");
    System.out.println("Const w500 id:"+id);
    return new FontWeight(id);
  }
  public static FontWeight w600() {
    int id = factories.fontWeightW600();
    if (id <= 0) throw new RuntimeException("Failed to create const w600");
    System.out.println("Const w600 id:"+id);
    return new FontWeight(id);
  }
  public static FontWeight w700() {
    int id = factories.fontWeightW700();
    if (id <= 0) throw new RuntimeException("Failed to create const w700");
    System.out.println("Const w700 id:"+id);
    return new FontWeight(id);
  }
  public static FontWeight w800() {
    int id = factories.fontWeightW800();
    if (id <= 0) throw new RuntimeException("Failed to create const w800");
    System.out.println("Const w800 id:"+id);
    return new FontWeight(id);
  }
  public static FontWeight w900() {
    int id = factories.fontWeightW900();
    if (id <= 0) throw new RuntimeException("Failed to create const w900");
    System.out.println("Const w900 id:"+id);
    return new FontWeight(id);
  }
  public static FontWeight normal() {
    return w400();
  }
  public static FontWeight bold() {
    return w700();
  }
  public static List<FontWeight> values() {
    return List.of(w100(), w200(), w300(), w400(), w500(), w600(), w700(), w800(), w900());
  }
  @Override
  public FontWeight build() {
    return this;
  }
}
