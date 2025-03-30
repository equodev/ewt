package dev.equo.ewt;
public interface PreferredSizeWidget extends NativeObj, PreferredSizeWidgetI {
  @Override
  default PreferredSizeWidget build() {
    return this;
  }
}
