package dev.equo.ewt;
import java.util.*;
public abstract class InheritedTheme extends InheritedWidget implements InheritedThemeI {
  protected InheritedTheme() {}
  InheritedTheme(int id) {
    this.id = id;
  }
  @Override
  public InheritedTheme build() {
    return this;
  }
}
