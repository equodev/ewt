package dev.equo.ewt;
import java.util.*;
public abstract class ScrollView extends StatelessWidget implements ScrollViewI {
  protected ScrollView() {}
  ScrollView(int id) {
    this.id = id;
  }
  @Override
  public ScrollView build() {
    return this;
  }
}
