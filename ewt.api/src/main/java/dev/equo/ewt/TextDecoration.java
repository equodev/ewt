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
  public static TextDecoration byId(int id) { return new TextDecoration(id); }
  static { NativeObj.register("TextDecoration", TextDecoration::byId); }
  @Builder.Factory
  static TextDecoration textDecorationCombine(@Builder.Parameter List<TextDecorationI> decorations) {
    var id = factories.textDecorationCombine(decorations.stream().map(TextDecorationI::build).collect(java.util.stream.Collectors.toList()));
    if (id <= 0) throw new RuntimeException("Failed to created widget TextDecoration");
    return new TextDecoration(id);
  }
  public static TextDecorationCombineBuilder combine(List<TextDecorationI> decorations) {
    return TextDecorationCombineBuilder.textDecorationCombine(decorations);
  }
  public static TextDecoration none() {
    int id = factories.textDecorationNone();
    if (id <= 0) throw new RuntimeException("Failed to create const none");
    return new TextDecoration(id);
  }
  public static TextDecoration underline() {
    int id = factories.textDecorationUnderline();
    if (id <= 0) throw new RuntimeException("Failed to create const underline");
    return new TextDecoration(id);
  }
  public static TextDecoration overline() {
    int id = factories.textDecorationOverline();
    if (id <= 0) throw new RuntimeException("Failed to create const overline");
    return new TextDecoration(id);
  }
  public static TextDecoration lineThrough() {
    int id = factories.textDecorationLineThrough();
    if (id <= 0) throw new RuntimeException("Failed to create const lineThrough");
    return new TextDecoration(id);
  }
  @Override
  public TextDecoration build() {
    return this;
  }
}
