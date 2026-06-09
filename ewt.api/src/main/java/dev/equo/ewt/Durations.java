package dev.equo.ewt;
import java.util.*;
public abstract class Durations extends NativeObj.Base implements DurationsI {
  protected Durations() {}
  Durations(int id) {
    this.id = id;
  }
  public static Duration short1() {
    return Duration.duration().milliseconds(50).build();
  }
  public static Duration short2() {
    return Duration.duration().milliseconds(100).build();
  }
  public static Duration short3() {
    return Duration.duration().milliseconds(150).build();
  }
  public static Duration short4() {
    return Duration.duration().milliseconds(200).build();
  }
  public static Duration medium1() {
    return Duration.duration().milliseconds(250).build();
  }
  public static Duration medium2() {
    return Duration.duration().milliseconds(300).build();
  }
  public static Duration medium3() {
    return Duration.duration().milliseconds(350).build();
  }
  public static Duration medium4() {
    return Duration.duration().milliseconds(400).build();
  }
  public static Duration long1() {
    return Duration.duration().milliseconds(450).build();
  }
  public static Duration long2() {
    return Duration.duration().milliseconds(500).build();
  }
  public static Duration long3() {
    return Duration.duration().milliseconds(550).build();
  }
  public static Duration long4() {
    return Duration.duration().milliseconds(600).build();
  }
  public static Duration extralong1() {
    return Duration.duration().milliseconds(700).build();
  }
  public static Duration extralong2() {
    return Duration.duration().milliseconds(800).build();
  }
  public static Duration extralong3() {
    return Duration.duration().milliseconds(900).build();
  }
  public static Duration extralong4() {
    return Duration.duration().milliseconds(1000).build();
  }
  @Override
  public Durations build() {
    return this;
  }
}
