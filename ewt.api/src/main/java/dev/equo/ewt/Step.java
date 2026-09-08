package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.StepObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class Step extends NativeObj.Base implements StepI {
  private MemorySegment st;
  protected Step() {}
  Step(MemorySegment st) {
    this.id = StepObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget Step");
    System.out.println("New Step id:"+id);
  }
  Step(int id) { this.id = id; }
  @Builder.Factory
  static Step stepStep(@Builder.Parameter WidgetI title, Optional<WidgetI> subtitle, WidgetI content, Optional<StepState> state, Optional<Boolean> isActive, Optional<WidgetI> label) {
    var st = factories.stepStep(title.build(),
      subtitle.map(WidgetI::build),
      content.build(),
      state,
      isActive,
      label.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget Step");
    return new Step(st);
  }
  public static StepStepBuilder step(WidgetI title) {
    return StepStepBuilder.stepStep(title);
  }
  public Widget title() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("stepTitle not supported on web");
    return new Widget(StepObjSt.title(st)) {};
  }
  public Widget subtitle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("stepSubtitle not supported on web");
    return new Widget(StepObjSt.subtitle(st)) {};
  }
  public Widget content() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("stepContent not supported on web");
    return new Widget(StepObjSt.content(st)) {};
  }
  public StepState state() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("stepState not supported on web");
    return StepState.values()[StepObjSt.state(st)];
  }
  public boolean isActive() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("stepIsActive not supported on web");
    return intToBool(StepObjSt.isActive(st));
  }
  public Widget label() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("stepLabel not supported on web");
    return new Widget(StepObjSt.label(st)) {};
  }
  @Override
  public Step build() {
    return this;
  }
}
