package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.StepperObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class Stepper extends StatefulWidget implements StepperI {
  private MemorySegment st;
  protected Stepper() {}
  Stepper(MemorySegment st) {
    this.id = StepperObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget Stepper");
    System.out.println("New Stepper id:"+id);
  }
  Stepper(int id) { this.id = id; }
  @Builder.Factory
  static Stepper stepperStepper(@Builder.Parameter List<StepI> steps, Optional<StepperType> type, OptionalInt currentStep, Optional<Consumer<Integer>> onStepTapped, Optional<Runnable> onStepContinue, Optional<Runnable> onStepCancel, OptionalDouble elevation, Optional<EdgeInsetsGeometryI> margin, Optional<ColorI> connectorColor, OptionalDouble connectorThickness, Optional<BiFunction<Integer, StepState, Widget>> stepIconBuilder, OptionalDouble stepIconHeight, OptionalDouble stepIconWidth, Optional<EdgeInsetsI> stepIconMargin, Optional<Clip> clipBehavior) {
    var st = factories.stepperStepper(steps.stream().map(StepI::build).toList(),
      type,
      currentStep,
      onStepTapped,
      onStepContinue,
      onStepCancel,
      elevation,
      margin.map(EdgeInsetsGeometryI::build),
      connectorColor.map(ColorI::build),
      connectorThickness,
      stepIconBuilder,
      stepIconHeight,
      stepIconWidth,
      stepIconMargin.map(EdgeInsetsI::build),
      clipBehavior);
    if (st == null) throw new RuntimeException("Failed to created widget Stepper");
    return new Stepper(st);
  }
  public static StepperStepperBuilder stepper(List<StepI> steps) {
    return StepperStepperBuilder.stepperStepper(steps);
  }
  public StepperType type() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("stepperType not supported on web");
    return StepperType.values()[StepperObjSt.type(st)];
  }
  public int currentStep() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("stepperCurrentStep not supported on web");
    return StepperObjSt.currentStep(st);
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("stepperElevation not supported on web");
    return StepperObjSt.elevation(st);
  }
  public EdgeInsetsGeometry margin() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("stepperMargin not supported on web");
    return new EdgeInsetsGeometry(StepperObjSt.margin(st)) {};
  }
  public double connectorThickness() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("stepperConnectorThickness not supported on web");
    return StepperObjSt.connectorThickness(st);
  }
  public double stepIconHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("stepperStepIconHeight not supported on web");
    return StepperObjSt.stepIconHeight(st);
  }
  public double stepIconWidth() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("stepperStepIconWidth not supported on web");
    return StepperObjSt.stepIconWidth(st);
  }
  public EdgeInsets stepIconMargin() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("stepperStepIconMargin", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.EdgeInsetsObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.EdgeInsetsObjSt.id(__st, __nid);
      return new EdgeInsets(__st);
    }
    return new EdgeInsets(StepperObjSt.stepIconMargin(st));
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("stepperClipBehavior not supported on web");
    return Clip.values()[StepperObjSt.clipBehavior(st)];
  }
  @Override
  public Stepper build() {
    return this;
  }
}
