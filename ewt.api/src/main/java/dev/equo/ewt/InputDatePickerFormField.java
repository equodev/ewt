package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class InputDatePickerFormField extends StatefulWidget implements InputDatePickerFormFieldI {
  protected InputDatePickerFormField() {}
  InputDatePickerFormField(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget InputDatePickerFormField");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static InputDatePickerFormField inputDatePickerFormFieldInputDatePickerFormField(Optional<DateTimeI> initialDate, DateTimeI firstDate, DateTimeI lastDate, Optional<Consumer<DateTime>> onDateSubmitted, Optional<Consumer<DateTime>> onDateSaved, Optional<Function<DateTime, Boolean>> selectableDayPredicate, Optional<String> errorFormatText, Optional<String> errorInvalidText, Optional<String> fieldHintText, Optional<String> fieldLabelText, Optional<Boolean> autofocus, Optional<Boolean> acceptEmptyDate) {
    int id = factories.inputDatePickerFormFieldInputDatePickerFormField(initialDate.map(DateTimeI::build),
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
    if (id <= 0) throw new RuntimeException("Failed to created widget InputDatePickerFormField");
    return new InputDatePickerFormField(id);
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
    return factories.InputDatePickerFormField_readBack_initialDate(nativeStruct);
  }
  public DateTime firstDate() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputDatePickerFormFieldFirstDate", getId());
      return new DateTime(__nid);
    }
    return factories.InputDatePickerFormField_readBack_firstDate(nativeStruct);
  }
  public DateTime lastDate() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("inputDatePickerFormFieldLastDate", getId());
      return new DateTime(__nid);
    }
    return factories.InputDatePickerFormField_readBack_lastDate(nativeStruct);
  }
  public String errorFormatText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDatePickerFormFieldErrorFormatText not supported on web");
    return factories.InputDatePickerFormField_readBack_errorFormatText(nativeStruct);
  }
  public String errorInvalidText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDatePickerFormFieldErrorInvalidText not supported on web");
    return factories.InputDatePickerFormField_readBack_errorInvalidText(nativeStruct);
  }
  public String fieldHintText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDatePickerFormFieldFieldHintText not supported on web");
    return factories.InputDatePickerFormField_readBack_fieldHintText(nativeStruct);
  }
  public String fieldLabelText() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDatePickerFormFieldFieldLabelText not supported on web");
    return factories.InputDatePickerFormField_readBack_fieldLabelText(nativeStruct);
  }
  public boolean autofocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDatePickerFormFieldAutofocus not supported on web");
    return factories.InputDatePickerFormField_readBack_autofocus(nativeStruct);
  }
  public boolean acceptEmptyDate() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("inputDatePickerFormFieldAcceptEmptyDate not supported on web");
    return factories.InputDatePickerFormField_readBack_acceptEmptyDate(nativeStruct);
  }
  @Override
  public InputDatePickerFormField build() {
    return this;
  }
}
