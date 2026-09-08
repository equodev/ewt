package dev.equo.ewt;
import java.util.*;
public abstract class Feedback extends NativeObj.Base implements FeedbackI {
  protected Feedback() {}
  Feedback(int id) {
    this.id = id;
  }
  @Override
  public Feedback build() {
    return this;
  }
}
