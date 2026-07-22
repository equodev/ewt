package dev.equo.ewt;
import java.util.*;
public abstract class BoxScrollView extends ScrollView implements BoxScrollViewI {
  protected BoxScrollView() {}
  BoxScrollView(int id) {
    this.id = id;
  }
  @Override
  public BoxScrollView build() {
    return this;
  }
}
