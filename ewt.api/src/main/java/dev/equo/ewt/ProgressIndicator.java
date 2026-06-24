package dev.equo.ewt;
import java.util.*;
public abstract class ProgressIndicator extends StatefulWidget implements ProgressIndicatorI {
  protected ProgressIndicator() {}
  ProgressIndicator(int id) {
    this.id = id;
  }
  @Override
  public ProgressIndicator build() {
    return this;
  }
}
