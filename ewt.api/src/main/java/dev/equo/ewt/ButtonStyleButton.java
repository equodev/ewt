package dev.equo.ewt;
import java.util.*;
public abstract class ButtonStyleButton extends StatefulWidget implements ButtonStyleButtonI {
  protected ButtonStyleButton() {}
  ButtonStyleButton(int id) {
    this.id = id;
  }
  @Override
  public ButtonStyleButton build() {
    return this;
  }
}
