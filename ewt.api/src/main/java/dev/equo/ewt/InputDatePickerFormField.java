package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.InputDatePickerFormFieldObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class InputDatePickerFormField extends StatefulWidget implements InputDatePickerFormFieldI {
  private MemorySegment st;
  protected InputDatePickerFormField() {}
  InputDatePickerFormField(MemorySegment st) {
    this.id = InputDatePickerFormFieldObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget InputDatePickerFormField");
    System.out.println("New InputDatePickerFormField id:"+id);
  }
  InputDatePickerFormField(int id) { this.id = id; }
  @Builder.Factory
  static InputDatePickerFormField inputDatePickerFormFieldInputDatePickerFormField(Optional<DateTimeI> initialDate, DateTimeI firstDate, DateTimeI lastDate, Optional<Consumer<DateTime>> onDateSubmitted, Optional<Consumer<DateTime>> onDateSaved, Optional<Function<DateTime, Boolean>> selectableDayPredicate, Optional<String> errorFormatText, Optional<String> errorInvalidText, Optional<String> fieldHintText, Optional<String> fieldLabelText, Optional<Boolean> autofocus, Optional<Boolean> acceptEmptyDate) {
    var st = factories.inputDatePickerFormFieldInputDatePickerFormField(initialDate.map(DateTimeI::build),
      firstDate.build(),
      lastDate.build(),
      onDateSubmitted,
      onDateSaved,
      selectableDayPredicate,
      errorFormatText,
      errorInvalidText,
      fieldHintText,
      fieldLabelText,
      autofocus,
      acceptEmptyDate);
    if (st == null) throw new RuntimeException("Failed to created widget InputDatePickerFormField");
    return new InputDatePickerFormField(st);
  }
  public static InputDatePickerFormFieldInputDatePickerFormFieldBuilder inputDatePickerFormField() {
    return InputDatePickerFormFieldInputDatePickerFormFieldBuilder.inputDatePickerFormFieldInputDatePickerFormField();
  }
  public DateTime initialDate() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputDatePickerFormFieldInitialDate", getId());
      return new DateTime(__nid);
    }
    return new DateTime(InputDatePickerFormFieldObjSt.initialDate(st));
  }
  public DateTime firstDate() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputDatePickerFormFieldFirstDate", getId());
      return new DateTime(__nid);
    }
    return new DateTime(InputDatePickerFormFieldObjSt.firstDate(st));
  }
  public DateTime lastDate() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputDatePickerFormFieldLastDate", getId());
      return new DateTime(__nid);
    }
    return new DateTime(InputDatePickerFormFieldObjSt.lastDate(st));
  }
  public String errorFormatText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDatePickerFormFieldErrorFormatText not supported on web");
    return InputDatePickerFormFieldObjSt.errorFormatText(st).getString(0);
  }
  public String errorInvalidText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDatePickerFormFieldErrorInvalidText not supported on web");
    return InputDatePickerFormFieldObjSt.errorInvalidText(st).getString(0);
  }
  public String fieldHintText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDatePickerFormFieldFieldHintText not supported on web");
    return InputDatePickerFormFieldObjSt.fieldHintText(st).getString(0);
  }
  public String fieldLabelText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDatePickerFormFieldFieldLabelText not supported on web");
    return InputDatePickerFormFieldObjSt.fieldLabelText(st).getString(0);
  }
  public boolean autofocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDatePickerFormFieldAutofocus not supported on web");
    return intToBool(InputDatePickerFormFieldObjSt.autofocus(st));
  }
  public boolean acceptEmptyDate() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDatePickerFormFieldAcceptEmptyDate not supported on web");
    return intToBool(InputDatePickerFormFieldObjSt.acceptEmptyDate(st));
  }
  @Override
  public InputDatePickerFormField build() {
    return this;
  }
}
