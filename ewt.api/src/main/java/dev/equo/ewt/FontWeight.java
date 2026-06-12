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
  @Builder.Factory
  static FontWeight fontWeightFontWeight(@Builder.Parameter int value) {
    int id = factories.fontWeightFontWeight(value);
    if (id <= 0) throw new RuntimeException("Failed to created widget FontWeight");
    System.out.println("New FontWeight id:"+id);
    return new FontWeight(id);
  }
  public static FontWeightFontWeightBuilder fontWeight(int value) {
    return FontWeightFontWeightBuilder.fontWeightFontWeight(value);
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
    return FontWeight.fontWeight(100).build();
  }
  public static FontWeight w200() {
    return FontWeight.fontWeight(200).build();
  }
  public static FontWeight w300() {
    return FontWeight.fontWeight(300).build();
  }
  public static FontWeight w400() {
    return FontWeight.fontWeight(400).build();
  }
  public static FontWeight w500() {
    return FontWeight.fontWeight(500).build();
  }
  public static FontWeight w600() {
    return FontWeight.fontWeight(600).build();
  }
  public static FontWeight w700() {
    return FontWeight.fontWeight(700).build();
  }
  public static FontWeight w800() {
    return FontWeight.fontWeight(800).build();
  }
  public static FontWeight w900() {
    return FontWeight.fontWeight(900).build();
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
