package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class TextDecoration extends NativeObj.Base implements TextDecorationI {
  protected TextDecoration() {}
  TextDecoration(int id) {
    this.id = id;
  }
  @Builder.Factory
  static TextDecoration textDecorationCombine(@Builder.Parameter List<TextDecorationI> decorations) {
    int id = factories.textDecorationCombine(decorations.stream().map(TextDecorationI::build).toList());
    if (id == -1) throw new RuntimeException("Failed to created widget TextDecoration");
    System.out.println("New TextDecoration id:"+id);
    return new TextDecoration(id);
  }
  public static TextDecorationCombineBuilder combine(List<TextDecorationI> decorations) {
    return TextDecorationCombineBuilder.textDecorationCombine(decorations);
  }
  public static TextDecoration none() {
    int id = factories.textDecorationNone();
    if (id == -1) throw new RuntimeException("Failed to create const none");
    System.out.println("Const none id:"+id);
    return new TextDecoration(id);
  }
  public static TextDecoration underline() {
    int id = factories.textDecorationUnderline();
    if (id == -1) throw new RuntimeException("Failed to create const underline");
    System.out.println("Const underline id:"+id);
    return new TextDecoration(id);
  }
  public static TextDecoration overline() {
    int id = factories.textDecorationOverline();
    if (id == -1) throw new RuntimeException("Failed to create const overline");
    System.out.println("Const overline id:"+id);
    return new TextDecoration(id);
  }
  public static TextDecoration lineThrough() {
    int id = factories.textDecorationLineThrough();
    if (id == -1) throw new RuntimeException("Failed to create const lineThrough");
    System.out.println("Const lineThrough id:"+id);
    return new TextDecoration(id);
  }
  @Override
  public TextDecoration build() {
    return this;
  }
}
