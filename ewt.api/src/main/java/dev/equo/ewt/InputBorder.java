package dev.equo.ewt;
import java.util.*;
public abstract class InputBorder extends ShapeBorder implements InputBorderI {
  protected InputBorder() {}
  InputBorder(int id) {
    this.id = id;
  }
  public static InputBorder none() {
    int id = factories.inputBorderNone();
    if (id <= 0) throw new RuntimeException("Failed to create const none");
    System.out.println("Const none id:"+id);
    return new InputBorder(id) {};
  }
  @Override
  public InputBorder build() {
    return this;
  }
}
