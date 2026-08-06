package dev.equo.ewt;
import java.util.*;
public abstract class PopupMenuEntry<T> extends StatefulWidget implements PopupMenuEntryI {
  protected PopupMenuEntry() {}
  PopupMenuEntry(int id) {
    this.id = id;
  }
  @Override
  public PopupMenuEntry build() {
    return this;
  }
}
