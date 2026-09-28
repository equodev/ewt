package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class Stepper extends StatefulWidget implements StepperI {
  protected Stepper() {}
  Stepper(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget Stepper");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static Stepper stepperStepper(@Builder.Parameter List<StepI> steps, Optional<StepperType> type, OptionalInt currentStep, Optional<Consumer<Integer>> onStepTapped, Optional<Runnable> onStepContinue, Optional<Runnable> onStepCancel, OptionalDouble elevation, Optional<EdgeInsetsGeometryI> margin, Optional<ColorI> connectorColor, OptionalDouble connectorThickness, Optional<BiFunction<Integer, StepState, Widget>> stepIconBuilder, OptionalDouble stepIconHeight, OptionalDouble stepIconWidth, Optional<EdgeInsetsI> stepIconMargin, Optional<Clip> clipBehavior, Optional<EdgeInsetsGeometryI> headerPadding, Optional<EdgeInsetsGeometryI> contentPadding) {
    int id = factories.stepperStepper(steps.stream().map(StepI::build).collect(java.util.stream.Collectors.toList()),
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
      clipBehavior,
      headerPadding.map(EdgeInsetsGeometryI::build),
      contentPadding.map(EdgeInsetsGeometryI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget Stepper");
    return new Stepper(id);
  }
  public static StepperStepperBuilder stepper(List<StepI> steps) {
    return StepperStepperBuilder.stepperStepper(steps);
  }
  public StepperType type() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("stepperType not supported on web");
    return factories.Stepper_readBack_type(nativeStruct);
  }
  public int currentStep() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("stepperCurrentStep not supported on web");
    return factories.Stepper_readBack_currentStep(nativeStruct);
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("stepperElevation not supported on web");
    return factories.Stepper_readBack_elevation(nativeStruct);
  }
  public EdgeInsetsGeometry margin() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("stepperMargin not supported on web");
    return factories.Stepper_readBack_margin(nativeStruct);
  }
  public double connectorThickness() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("stepperConnectorThickness not supported on web");
    return factories.Stepper_readBack_connectorThickness(nativeStruct);
  }
  public double stepIconHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("stepperStepIconHeight not supported on web");
    return factories.Stepper_readBack_stepIconHeight(nativeStruct);
  }
  public double stepIconWidth() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("stepperStepIconWidth not supported on web");
    return factories.Stepper_readBack_stepIconWidth(nativeStruct);
  }
  public EdgeInsets stepIconMargin() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("stepperStepIconMargin", getId());
      return new EdgeInsets(__nid);
    }
    return factories.Stepper_readBack_stepIconMargin(nativeStruct);
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("stepperClipBehavior not supported on web");
    return factories.Stepper_readBack_clipBehavior(nativeStruct);
  }
  public EdgeInsetsGeometry headerPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("stepperHeaderPadding not supported on web");
    return factories.Stepper_readBack_headerPadding(nativeStruct);
  }
  public EdgeInsetsGeometry contentPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("stepperContentPadding not supported on web");
    return factories.Stepper_readBack_contentPadding(nativeStruct);
  }
  @Override
  public Stepper build() {
    return this;
  }
}
