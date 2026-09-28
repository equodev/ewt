package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class Step extends NativeObj.Base implements StepI {
  protected Step() {}
  Step(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget Step");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static Step stepStep(@Builder.Parameter WidgetI title, Optional<WidgetI> subtitle, WidgetI content, Optional<StepState> state, Optional<Boolean> isActive, Optional<WidgetI> label) {
    int id = factories.stepStep(title.build(),
      subtitle.map(WidgetI::build),
      content.build(),
      state,
      isActive,
      label.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget Step");
    return new Step(id);
  }
  public static StepStepBuilder step(WidgetI title) {
    return StepStepBuilder.stepStep(title);
  }
  public Widget title() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("stepTitle not supported on web");
    return factories.Step_readBack_title(nativeStruct);
  }
  public Widget subtitle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("stepSubtitle not supported on web");
    return factories.Step_readBack_subtitle(nativeStruct);
  }
  public Widget content() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("stepContent not supported on web");
    return factories.Step_readBack_content(nativeStruct);
  }
  public StepState state() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("stepState not supported on web");
    return factories.Step_readBack_state(nativeStruct);
  }
  public boolean isActive() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("stepIsActive not supported on web");
    return factories.Step_readBack_isActive(nativeStruct);
  }
  public Widget label() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("stepLabel not supported on web");
    return factories.Step_readBack_label(nativeStruct);
  }
  @Override
  public Step build() {
    return this;
  }
}
