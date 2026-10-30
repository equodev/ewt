package dev.equo.ewt;
import dev.equo.ewt.util.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.OptionalDouble;
import java.util.function.*;
public interface WidgetConstructors {
  default Object takeLastStruct() { return null; }
  default <T> int dialogShowDialog(BuildContext context, Function<BuildContext, Widget> builder, Optional<Boolean> barrierDismissible, Optional<Color> barrierColor, Optional<String> barrierLabel, Optional<Boolean> useSafeArea, Optional<Boolean> useRootNavigator, Optional<Offset> anchorPoint, Optional<TraversalEdgeBehavior> traversalEdgeBehavior, Optional<Boolean> fullscreenDialog, Optional<Boolean> requestFocus) {
    throw new UnsupportedOperationException("dialogShowDialog has no default (FFM/comm impl required)");
  }
  default int date_pickerShowDatePicker(BuildContext context, Optional<DateTime> initialDate, DateTime firstDate, DateTime lastDate, Optional<DateTime> currentDate, Optional<DatePickerEntryMode> initialEntryMode, Optional<Function<DateTime, Boolean>> selectableDayPredicate, Optional<String> helpText, Optional<String> cancelText, Optional<String> confirmText, Optional<Boolean> barrierDismissible, Optional<Color> barrierColor, Optional<String> barrierLabel, Optional<Boolean> useRootNavigator, Optional<TextDirection> textDirection, Optional<BiFunction<BuildContext, Widget, Widget>> builder, Optional<DatePickerMode> initialDatePickerMode, Optional<String> errorFormatText, Optional<String> errorInvalidText, Optional<String> fieldHintText, Optional<String> fieldLabelText, Optional<Offset> anchorPoint, Optional<Consumer<DatePickerEntryMode>> onDatePickerModeChange, Optional<Icon> switchToInputEntryModeIcon, Optional<Icon> switchToCalendarEntryModeIcon) {
    throw new UnsupportedOperationException("date_pickerShowDatePicker has no default (FFM/comm impl required)");
  }
  default int time_pickerShowTimePicker(BuildContext context, TimeOfDay initialTime, Optional<BiFunction<BuildContext, Widget, Widget>> builder, Optional<Boolean> barrierDismissible, Optional<Color> barrierColor, Optional<String> barrierLabel, Optional<Boolean> useRootNavigator, Optional<TimePickerEntryMode> initialEntryMode, Optional<String> cancelText, Optional<String> confirmText, Optional<String> helpText, Optional<String> errorInvalidText, Optional<String> hourLabelText, Optional<String> minuteLabelText, Optional<Consumer<TimePickerEntryMode>> onEntryModeChanged, Optional<Offset> anchorPoint, Optional<Orientation> orientation, Optional<Icon> switchToInputEntryModeIcon, Optional<Icon> switchToTimerEntryModeIcon, Optional<Boolean> emptyInitialInput) {
    throw new UnsupportedOperationException("time_pickerShowTimePicker has no default (FFM/comm impl required)");
  }
  default int date_pickerShowDateRangePicker(BuildContext context, DateTime firstDate, DateTime lastDate, Optional<DateTime> currentDate, Optional<DatePickerEntryMode> initialEntryMode, Optional<String> helpText, Optional<String> cancelText, Optional<String> confirmText, Optional<String> saveText, Optional<String> errorFormatText, Optional<String> errorInvalidText, Optional<String> errorInvalidRangeText, Optional<String> fieldStartHintText, Optional<String> fieldEndHintText, Optional<String> fieldStartLabelText, Optional<String> fieldEndLabelText, Optional<Boolean> barrierDismissible, Optional<Color> barrierColor, Optional<String> barrierLabel, Optional<Boolean> useRootNavigator, Optional<TextDirection> textDirection, Optional<BiFunction<BuildContext, Widget, Widget>> builder, Optional<Offset> anchorPoint, Optional<Icon> switchToInputEntryModeIcon, Optional<Icon> switchToCalendarEntryModeIcon, Optional<TriFunction<DateTime, DateTime, DateTime, Boolean>> selectableDayPredicate) {
    throw new UnsupportedOperationException("date_pickerShowDateRangePicker has no default (FFM/comm impl required)");
  }
  default String type_registry_helpersWidgetTypeOf(int id) {
    throw new UnsupportedOperationException("type_registry_helpersWidgetTypeOf has no default (FFM/comm impl required)");
  }
  default int textStyleTextStyle(Optional<Boolean> inherit, Optional<Color> color, Optional<Color> backgroundColor, OptionalDouble fontSize, Optional<FontWeight> fontWeight, Optional<FontStyle> fontStyle, OptionalDouble letterSpacing, OptionalDouble wordSpacing, Optional<TextBaseline> textBaseline, OptionalDouble height, Optional<TextLeadingDistribution> leadingDistribution, Optional<List<Shadow>> shadows, Optional<TextDecoration> decoration, Optional<Color> decorationColor, Optional<TextDecorationStyle> decorationStyle, OptionalDouble decorationThickness, Optional<String> debugLabel, Optional<String> fontFamily, Optional<List<String>> fontFamilyFallback, Optional<String> _package, Optional<TextOverflow> overflow) {
    throw new UnsupportedOperationException("textStyleTextStyle has no default (FFM/comm impl required)");
  }
  default int textStyleLerp(TextStyle a, TextStyle b, double t) {
    throw new UnsupportedOperationException("textStyleLerp has no default (FFM/comm impl required)");
  }
  default boolean TextStyle_readBack_inherit(Object st) {
    throw new UnsupportedOperationException("TextStyle_readBack_inherit read-back requires FFM/java22");
  }
  default Color TextStyle_readBack_color(Object st) {
    throw new UnsupportedOperationException("TextStyle_readBack_color read-back requires FFM/java22");
  }
  default Color TextStyle_readBack_backgroundColor(Object st) {
    throw new UnsupportedOperationException("TextStyle_readBack_backgroundColor read-back requires FFM/java22");
  }
  default String TextStyle_readBack_fontFamily(Object st) {
    throw new UnsupportedOperationException("TextStyle_readBack_fontFamily read-back requires FFM/java22");
  }
  default double TextStyle_readBack_fontSize(Object st) {
    throw new UnsupportedOperationException("TextStyle_readBack_fontSize read-back requires FFM/java22");
  }
  default FontWeight TextStyle_readBack_fontWeight(Object st) {
    throw new UnsupportedOperationException("TextStyle_readBack_fontWeight read-back requires FFM/java22");
  }
  default FontStyle TextStyle_readBack_fontStyle(Object st) {
    throw new UnsupportedOperationException("TextStyle_readBack_fontStyle read-back requires FFM/java22");
  }
  default double TextStyle_readBack_letterSpacing(Object st) {
    throw new UnsupportedOperationException("TextStyle_readBack_letterSpacing read-back requires FFM/java22");
  }
  default double TextStyle_readBack_wordSpacing(Object st) {
    throw new UnsupportedOperationException("TextStyle_readBack_wordSpacing read-back requires FFM/java22");
  }
  default TextBaseline TextStyle_readBack_textBaseline(Object st) {
    throw new UnsupportedOperationException("TextStyle_readBack_textBaseline read-back requires FFM/java22");
  }
  default double TextStyle_readBack_height(Object st) {
    throw new UnsupportedOperationException("TextStyle_readBack_height read-back requires FFM/java22");
  }
  default TextLeadingDistribution TextStyle_readBack_leadingDistribution(Object st) {
    throw new UnsupportedOperationException("TextStyle_readBack_leadingDistribution read-back requires FFM/java22");
  }
  default TextDecoration TextStyle_readBack_decoration(Object st) {
    throw new UnsupportedOperationException("TextStyle_readBack_decoration read-back requires FFM/java22");
  }
  default Color TextStyle_readBack_decorationColor(Object st) {
    throw new UnsupportedOperationException("TextStyle_readBack_decorationColor read-back requires FFM/java22");
  }
  default TextDecorationStyle TextStyle_readBack_decorationStyle(Object st) {
    throw new UnsupportedOperationException("TextStyle_readBack_decorationStyle read-back requires FFM/java22");
  }
  default double TextStyle_readBack_decorationThickness(Object st) {
    throw new UnsupportedOperationException("TextStyle_readBack_decorationThickness read-back requires FFM/java22");
  }
  default String TextStyle_readBack_debugLabel(Object st) {
    throw new UnsupportedOperationException("TextStyle_readBack_debugLabel read-back requires FFM/java22");
  }
  default TextOverflow TextStyle_readBack_overflow(Object st) {
    throw new UnsupportedOperationException("TextStyle_readBack_overflow read-back requires FFM/java22");
  }

  default int colorColor(int value) {
    throw new UnsupportedOperationException("colorColor has no default (FFM/comm impl required)");
  }
  default int colorFrom(double alpha, double red, double green, double blue, Optional<ColorSpace> colorSpace) {
    throw new UnsupportedOperationException("colorFrom has no default (FFM/comm impl required)");
  }
  default int colorFromARGB(int a, int r, int g, int b) {
    throw new UnsupportedOperationException("colorFromARGB has no default (FFM/comm impl required)");
  }
  default int colorFromRGBO(int r, int g, int b, double opacity) {
    throw new UnsupportedOperationException("colorFromRGBO has no default (FFM/comm impl required)");
  }
  default int colorLerp(Color x, Color y, double t) {
    throw new UnsupportedOperationException("colorLerp has no default (FFM/comm impl required)");
  }
  default int colorAlphaBlend(Color foreground, Color background) {
    throw new UnsupportedOperationException("colorAlphaBlend has no default (FFM/comm impl required)");
  }
  default int colorGetAlphaFromOpacity(double opacity) {
    throw new UnsupportedOperationException("colorGetAlphaFromOpacity has no default (FFM/comm impl required)");
  }

  default int offsetOffset(double dx, double dy) {
    throw new UnsupportedOperationException("offsetOffset has no default (FFM/comm impl required)");
  }
  default int offsetFromDirection(double direction, OptionalDouble distance) {
    throw new UnsupportedOperationException("offsetFromDirection has no default (FFM/comm impl required)");
  }
  default int offsetLerp(Offset a, Offset b, double t) {
    throw new UnsupportedOperationException("offsetLerp has no default (FFM/comm impl required)");
  }
  default double offsetDx(Offset self) {
    throw new UnsupportedOperationException("offsetDx has no default (FFM/comm impl required)");
  }
  default double offsetDy(Offset self) {
    throw new UnsupportedOperationException("offsetDy has no default (FFM/comm impl required)");
  }

  default void futureThen(Future<NativeObj> self, Consumer<NativeObj> onValue) {
    throw new UnsupportedOperationException("futureThen has no default (FFM/comm impl required)");
  }

  default int dateTimeDateTime(int year, OptionalInt month, OptionalInt day, OptionalInt hour, OptionalInt minute, OptionalInt second, OptionalInt millisecond, OptionalInt microsecond) {
    throw new UnsupportedOperationException("dateTimeDateTime has no default (FFM/comm impl required)");
  }
  default int dateTimeUtc(int year, OptionalInt month, OptionalInt day, OptionalInt hour, OptionalInt minute, OptionalInt second, OptionalInt millisecond, OptionalInt microsecond) {
    throw new UnsupportedOperationException("dateTimeUtc has no default (FFM/comm impl required)");
  }
  default int dateTimeNow() {
    throw new UnsupportedOperationException("dateTimeNow has no default (FFM/comm impl required)");
  }
  default int dateTimeTimestamp() {
    throw new UnsupportedOperationException("dateTimeTimestamp has no default (FFM/comm impl required)");
  }
  default int dateTimeFromMillisecondsSinceEpoch(int millisecondsSinceEpoch, Optional<Boolean> isUtc) {
    throw new UnsupportedOperationException("dateTimeFromMillisecondsSinceEpoch has no default (FFM/comm impl required)");
  }
  default int dateTimeFromMicrosecondsSinceEpoch(int microsecondsSinceEpoch, Optional<Boolean> isUtc) {
    throw new UnsupportedOperationException("dateTimeFromMicrosecondsSinceEpoch has no default (FFM/comm impl required)");
  }
  default int dateTimeParse(String formattedString) {
    throw new UnsupportedOperationException("dateTimeParse has no default (FFM/comm impl required)");
  }
  default int dateTimeTryParse(String formattedString) {
    throw new UnsupportedOperationException("dateTimeTryParse has no default (FFM/comm impl required)");
  }
  default int dateTimeYear(DateTime self) {
    throw new UnsupportedOperationException("dateTimeYear has no default (FFM/comm impl required)");
  }
  default int dateTimeMonth(DateTime self) {
    throw new UnsupportedOperationException("dateTimeMonth has no default (FFM/comm impl required)");
  }
  default int dateTimeDay(DateTime self) {
    throw new UnsupportedOperationException("dateTimeDay has no default (FFM/comm impl required)");
  }
  default int dateTimeHour(DateTime self) {
    throw new UnsupportedOperationException("dateTimeHour has no default (FFM/comm impl required)");
  }
  default int dateTimeMinute(DateTime self) {
    throw new UnsupportedOperationException("dateTimeMinute has no default (FFM/comm impl required)");
  }
  default int dateTimeSecond(DateTime self) {
    throw new UnsupportedOperationException("dateTimeSecond has no default (FFM/comm impl required)");
  }
  default int dateTimeMillisecondsSinceEpoch(DateTime self) {
    throw new UnsupportedOperationException("dateTimeMillisecondsSinceEpoch has no default (FFM/comm impl required)");
  }

  default int iconIcon(IconData icon, OptionalDouble size, OptionalDouble fill, OptionalDouble weight, OptionalDouble grade, OptionalDouble opticalSize, Optional<Color> color, Optional<List<Shadow>> shadows, Optional<String> semanticLabel, Optional<TextDirection> textDirection, Optional<Boolean> applyTextScaling, Optional<BlendMode> blendMode, Optional<FontWeight> fontWeight) {
    throw new UnsupportedOperationException("iconIcon has no default (FFM/comm impl required)");
  }
  default IconData Icon_readBack_icon(Object st) {
    throw new UnsupportedOperationException("Icon_readBack_icon read-back requires FFM/java22");
  }
  default double Icon_readBack_size(Object st) {
    throw new UnsupportedOperationException("Icon_readBack_size read-back requires FFM/java22");
  }
  default double Icon_readBack_fill(Object st) {
    throw new UnsupportedOperationException("Icon_readBack_fill read-back requires FFM/java22");
  }
  default double Icon_readBack_weight(Object st) {
    throw new UnsupportedOperationException("Icon_readBack_weight read-back requires FFM/java22");
  }
  default double Icon_readBack_grade(Object st) {
    throw new UnsupportedOperationException("Icon_readBack_grade read-back requires FFM/java22");
  }
  default double Icon_readBack_opticalSize(Object st) {
    throw new UnsupportedOperationException("Icon_readBack_opticalSize read-back requires FFM/java22");
  }
  default Color Icon_readBack_color(Object st) {
    throw new UnsupportedOperationException("Icon_readBack_color read-back requires FFM/java22");
  }
  default String Icon_readBack_semanticLabel(Object st) {
    throw new UnsupportedOperationException("Icon_readBack_semanticLabel read-back requires FFM/java22");
  }
  default TextDirection Icon_readBack_textDirection(Object st) {
    throw new UnsupportedOperationException("Icon_readBack_textDirection read-back requires FFM/java22");
  }
  default boolean Icon_readBack_applyTextScaling(Object st) {
    throw new UnsupportedOperationException("Icon_readBack_applyTextScaling read-back requires FFM/java22");
  }
  default BlendMode Icon_readBack_blendMode(Object st) {
    throw new UnsupportedOperationException("Icon_readBack_blendMode read-back requires FFM/java22");
  }
  default FontWeight Icon_readBack_fontWeight(Object st) {
    throw new UnsupportedOperationException("Icon_readBack_fontWeight read-back requires FFM/java22");
  }

  default int timeOfDayTimeOfDay(int hour, int minute) {
    throw new UnsupportedOperationException("timeOfDayTimeOfDay has no default (FFM/comm impl required)");
  }
  default int timeOfDayFromDateTime(DateTime time) {
    throw new UnsupportedOperationException("timeOfDayFromDateTime has no default (FFM/comm impl required)");
  }
  default int timeOfDayNow() {
    throw new UnsupportedOperationException("timeOfDayNow has no default (FFM/comm impl required)");
  }
  default int TimeOfDay_readBack_hour(Object st) {
    throw new UnsupportedOperationException("TimeOfDay_readBack_hour read-back requires FFM/java22");
  }
  default int TimeOfDay_readBack_minute(Object st) {
    throw new UnsupportedOperationException("TimeOfDay_readBack_minute read-back requires FFM/java22");
  }
  default DayPeriod TimeOfDay_readBack_period(Object st) {
    throw new UnsupportedOperationException("TimeOfDay_readBack_period read-back requires FFM/java22");
  }
  default int TimeOfDay_readBack_hourOfPeriod(Object st) {
    throw new UnsupportedOperationException("TimeOfDay_readBack_hourOfPeriod read-back requires FFM/java22");
  }
  default int TimeOfDay_readBack_periodOffset(Object st) {
    throw new UnsupportedOperationException("TimeOfDay_readBack_periodOffset read-back requires FFM/java22");
  }

  default int fontWeightFontWeight(int value) {
    throw new UnsupportedOperationException("fontWeightFontWeight has no default (FFM/comm impl required)");
  }
  default int fontWeightLerp(FontWeight a, FontWeight b, double t) {
    throw new UnsupportedOperationException("fontWeightLerp has no default (FFM/comm impl required)");
  }

  default int shadowShadow(Optional<Color> color, Optional<Offset> offset, OptionalDouble blurRadius) {
    throw new UnsupportedOperationException("shadowShadow has no default (FFM/comm impl required)");
  }
  default double shadowConvertRadiusToSigma(double radius) {
    throw new UnsupportedOperationException("shadowConvertRadiusToSigma has no default (FFM/comm impl required)");
  }
  default int shadowLerp(Shadow a, Shadow b, double t) {
    throw new UnsupportedOperationException("shadowLerp has no default (FFM/comm impl required)");
  }

  default int textDecorationCombine(List<TextDecoration> decorations) {
    throw new UnsupportedOperationException("textDecorationCombine has no default (FFM/comm impl required)");
  }
  default int textDecorationNone() {
    throw new UnsupportedOperationException("textDecorationNone has no default (FFM/comm impl required)");
  }
  default int textDecorationUnderline() {
    throw new UnsupportedOperationException("textDecorationUnderline has no default (FFM/comm impl required)");
  }
  default int textDecorationOverline() {
    throw new UnsupportedOperationException("textDecorationOverline has no default (FFM/comm impl required)");
  }
  default int textDecorationLineThrough() {
    throw new UnsupportedOperationException("textDecorationLineThrough has no default (FFM/comm impl required)");
  }

  default int iconDataIconData(int codePoint, Optional<String> fontFamily, Optional<String> fontPackage, Optional<Boolean> matchTextDirection, Optional<List<String>> fontFamilyFallback) {
    throw new UnsupportedOperationException("iconDataIconData has no default (FFM/comm impl required)");
  }
  default int IconData_readBack_codePoint(Object st) {
    throw new UnsupportedOperationException("IconData_readBack_codePoint read-back requires FFM/java22");
  }
  default String IconData_readBack_fontFamily(Object st) {
    throw new UnsupportedOperationException("IconData_readBack_fontFamily read-back requires FFM/java22");
  }
  default String IconData_readBack_fontPackage(Object st) {
    throw new UnsupportedOperationException("IconData_readBack_fontPackage read-back requires FFM/java22");
  }
  default boolean IconData_readBack_matchTextDirection(Object st) {
    throw new UnsupportedOperationException("IconData_readBack_matchTextDirection read-back requires FFM/java22");
  }

  default int textText(String data, Optional<TextStyle> style, Optional<TextAlign> textAlign, Optional<TextDirection> textDirection, Optional<Boolean> softWrap, Optional<TextOverflow> overflow, OptionalDouble textScaleFactor, OptionalInt maxLines, Optional<String> semanticsLabel, Optional<String> semanticsIdentifier, Optional<TextWidthBasis> textWidthBasis, Optional<Color> selectionColor) {
    throw new UnsupportedOperationException("textText has no default (FFM/comm impl required)");
  }
  default int textRich(InlineSpan textSpan, Optional<TextStyle> style, Optional<TextAlign> textAlign, Optional<TextDirection> textDirection, Optional<Boolean> softWrap, Optional<TextOverflow> overflow, OptionalDouble textScaleFactor, OptionalInt maxLines, Optional<String> semanticsLabel, Optional<String> semanticsIdentifier, Optional<TextWidthBasis> textWidthBasis, Optional<Color> selectionColor) {
    throw new UnsupportedOperationException("textRich has no default (FFM/comm impl required)");
  }
  default String Text_readBack_data(Object st) {
    throw new UnsupportedOperationException("Text_readBack_data read-back requires FFM/java22");
  }
  default InlineSpan Text_readBack_textSpan(Object st) {
    throw new UnsupportedOperationException("Text_readBack_textSpan read-back requires FFM/java22");
  }
  default TextStyle Text_readBack_style(Object st) {
    throw new UnsupportedOperationException("Text_readBack_style read-back requires FFM/java22");
  }
  default TextAlign Text_readBack_textAlign(Object st) {
    throw new UnsupportedOperationException("Text_readBack_textAlign read-back requires FFM/java22");
  }
  default TextDirection Text_readBack_textDirection(Object st) {
    throw new UnsupportedOperationException("Text_readBack_textDirection read-back requires FFM/java22");
  }
  default boolean Text_readBack_softWrap(Object st) {
    throw new UnsupportedOperationException("Text_readBack_softWrap read-back requires FFM/java22");
  }
  default TextOverflow Text_readBack_overflow(Object st) {
    throw new UnsupportedOperationException("Text_readBack_overflow read-back requires FFM/java22");
  }
  default double Text_readBack_textScaleFactor(Object st) {
    throw new UnsupportedOperationException("Text_readBack_textScaleFactor read-back requires FFM/java22");
  }
  default int Text_readBack_maxLines(Object st) {
    throw new UnsupportedOperationException("Text_readBack_maxLines read-back requires FFM/java22");
  }
  default String Text_readBack_semanticsLabel(Object st) {
    throw new UnsupportedOperationException("Text_readBack_semanticsLabel read-back requires FFM/java22");
  }
  default String Text_readBack_semanticsIdentifier(Object st) {
    throw new UnsupportedOperationException("Text_readBack_semanticsIdentifier read-back requires FFM/java22");
  }
  default TextWidthBasis Text_readBack_textWidthBasis(Object st) {
    throw new UnsupportedOperationException("Text_readBack_textWidthBasis read-back requires FFM/java22");
  }
  default Color Text_readBack_selectionColor(Object st) {
    throw new UnsupportedOperationException("Text_readBack_selectionColor read-back requires FFM/java22");
  }

  default int textSpanTextSpan(Optional<String> text, Optional<List<InlineSpan>> children, Optional<TextStyle> style, Optional<Consumer<PointerEnterEvent>> onEnter, Optional<Consumer<PointerExitEvent>> onExit, Optional<String> semanticsLabel, Optional<String> semanticsIdentifier, Optional<Boolean> spellOut) {
    throw new UnsupportedOperationException("textSpanTextSpan has no default (FFM/comm impl required)");
  }
  default String TextSpan_readBack_text(Object st) {
    throw new UnsupportedOperationException("TextSpan_readBack_text read-back requires FFM/java22");
  }
  default String TextSpan_readBack_semanticsLabel(Object st) {
    throw new UnsupportedOperationException("TextSpan_readBack_semanticsLabel read-back requires FFM/java22");
  }
  default String TextSpan_readBack_semanticsIdentifier(Object st) {
    throw new UnsupportedOperationException("TextSpan_readBack_semanticsIdentifier read-back requires FFM/java22");
  }
  default boolean TextSpan_readBack_spellOut(Object st) {
    throw new UnsupportedOperationException("TextSpan_readBack_spellOut read-back requires FFM/java22");
  }

  default int pointerEnterEventPointerEnterEvent(OptionalInt viewId, Optional<Duration> timeStamp, OptionalInt pointer, Optional<PointerDeviceKind> kind, OptionalInt device, Optional<Offset> position, Optional<Offset> delta, OptionalInt buttons, Optional<Boolean> obscured, OptionalDouble pressureMin, OptionalDouble pressureMax, OptionalDouble distance, OptionalDouble distanceMax, OptionalDouble size, OptionalDouble radiusMajor, OptionalDouble radiusMinor, OptionalDouble radiusMin, OptionalDouble radiusMax, OptionalDouble orientation, OptionalDouble tilt, Optional<Boolean> down, Optional<Boolean> synthesized, OptionalInt embedderId) {
    throw new UnsupportedOperationException("pointerEnterEventPointerEnterEvent has no default (FFM/comm impl required)");
  }
  default int pointerEnterEventFromMouseEvent(PointerEvent event) {
    throw new UnsupportedOperationException("pointerEnterEventFromMouseEvent has no default (FFM/comm impl required)");
  }

  default int pointerExitEventPointerExitEvent(OptionalInt viewId, Optional<Duration> timeStamp, Optional<PointerDeviceKind> kind, OptionalInt pointer, OptionalInt device, Optional<Offset> position, Optional<Offset> delta, OptionalInt buttons, Optional<Boolean> obscured, OptionalDouble pressureMin, OptionalDouble pressureMax, OptionalDouble distance, OptionalDouble distanceMax, OptionalDouble size, OptionalDouble radiusMajor, OptionalDouble radiusMinor, OptionalDouble radiusMin, OptionalDouble radiusMax, OptionalDouble orientation, OptionalDouble tilt, Optional<Boolean> down, Optional<Boolean> synthesized, OptionalInt embedderId) {
    throw new UnsupportedOperationException("pointerExitEventPointerExitEvent has no default (FFM/comm impl required)");
  }
  default int pointerExitEventFromMouseEvent(PointerEvent event) {
    throw new UnsupportedOperationException("pointerExitEventFromMouseEvent has no default (FFM/comm impl required)");
  }

  default int durationDuration(OptionalInt days, OptionalInt hours, OptionalInt minutes, OptionalInt seconds, OptionalInt milliseconds, OptionalInt microseconds) {
    throw new UnsupportedOperationException("durationDuration has no default (FFM/comm impl required)");
  }

  default int pointerEventPosition(PointerEvent self) {
    throw new UnsupportedOperationException("pointerEventPosition has no default (FFM/comm impl required)");
  }
  default int pointerEventDelta(PointerEvent self) {
    throw new UnsupportedOperationException("pointerEventDelta has no default (FFM/comm impl required)");
  }
  default int pointerEventPointer(PointerEvent self) {
    throw new UnsupportedOperationException("pointerEventPointer has no default (FFM/comm impl required)");
  }
  default int pointerEventButtons(PointerEvent self) {
    throw new UnsupportedOperationException("pointerEventButtons has no default (FFM/comm impl required)");
  }
  default int pointerEventDown(PointerEvent self) {
    throw new UnsupportedOperationException("pointerEventDown has no default (FFM/comm impl required)");
  }
  default double pointerEventPressure(PointerEvent self) {
    throw new UnsupportedOperationException("pointerEventPressure has no default (FFM/comm impl required)");
  }
  default double pointerEventDistance(PointerEvent self) {
    throw new UnsupportedOperationException("pointerEventDistance has no default (FFM/comm impl required)");
  }
  default double pointerEventSize(PointerEvent self) {
    throw new UnsupportedOperationException("pointerEventSize has no default (FFM/comm impl required)");
  }

  default int richTextRichText(InlineSpan text, Optional<TextAlign> textAlign, Optional<TextDirection> textDirection, Optional<Boolean> softWrap, Optional<TextOverflow> overflow, OptionalDouble textScaleFactor, OptionalInt maxLines, Optional<TextWidthBasis> textWidthBasis, Optional<Color> selectionColor) {
    throw new UnsupportedOperationException("richTextRichText has no default (FFM/comm impl required)");
  }
  default InlineSpan RichText_readBack_text(Object st) {
    throw new UnsupportedOperationException("RichText_readBack_text read-back requires FFM/java22");
  }
  default TextAlign RichText_readBack_textAlign(Object st) {
    throw new UnsupportedOperationException("RichText_readBack_textAlign read-back requires FFM/java22");
  }
  default TextDirection RichText_readBack_textDirection(Object st) {
    throw new UnsupportedOperationException("RichText_readBack_textDirection read-back requires FFM/java22");
  }
  default boolean RichText_readBack_softWrap(Object st) {
    throw new UnsupportedOperationException("RichText_readBack_softWrap read-back requires FFM/java22");
  }
  default TextOverflow RichText_readBack_overflow(Object st) {
    throw new UnsupportedOperationException("RichText_readBack_overflow read-back requires FFM/java22");
  }
  default int RichText_readBack_maxLines(Object st) {
    throw new UnsupportedOperationException("RichText_readBack_maxLines read-back requires FFM/java22");
  }
  default TextWidthBasis RichText_readBack_textWidthBasis(Object st) {
    throw new UnsupportedOperationException("RichText_readBack_textWidthBasis read-back requires FFM/java22");
  }
  default Color RichText_readBack_selectionColor(Object st) {
    throw new UnsupportedOperationException("RichText_readBack_selectionColor read-back requires FFM/java22");
  }
  default double RichText_readBack_textScaleFactor(Object st) {
    throw new UnsupportedOperationException("RichText_readBack_textScaleFactor read-back requires FFM/java22");
  }

  default int centerCenter(OptionalDouble widthFactor, OptionalDouble heightFactor, Optional<Widget> child) {
    throw new UnsupportedOperationException("centerCenter has no default (FFM/comm impl required)");
  }

  default int alignAlign(Optional<AlignmentGeometry> alignment, OptionalDouble widthFactor, OptionalDouble heightFactor, Optional<Widget> child) {
    throw new UnsupportedOperationException("alignAlign has no default (FFM/comm impl required)");
  }
  default AlignmentGeometry Align_readBack_alignment(Object st) {
    throw new UnsupportedOperationException("Align_readBack_alignment read-back requires FFM/java22");
  }
  default double Align_readBack_widthFactor(Object st) {
    throw new UnsupportedOperationException("Align_readBack_widthFactor read-back requires FFM/java22");
  }
  default double Align_readBack_heightFactor(Object st) {
    throw new UnsupportedOperationException("Align_readBack_heightFactor read-back requires FFM/java22");
  }

  default int columnColumn(Optional<MainAxisAlignment> mainAxisAlignment, Optional<MainAxisSize> mainAxisSize, Optional<CrossAxisAlignment> crossAxisAlignment, Optional<TextDirection> textDirection, Optional<VerticalDirection> verticalDirection, Optional<TextBaseline> textBaseline, OptionalDouble spacing, Optional<List<Widget>> children) {
    throw new UnsupportedOperationException("columnColumn has no default (FFM/comm impl required)");
  }

  default int flexFlex(Axis direction, Optional<MainAxisAlignment> mainAxisAlignment, Optional<MainAxisSize> mainAxisSize, Optional<CrossAxisAlignment> crossAxisAlignment, Optional<TextDirection> textDirection, Optional<VerticalDirection> verticalDirection, Optional<TextBaseline> textBaseline, Optional<Clip> clipBehavior, OptionalDouble spacing, Optional<List<Widget>> children) {
    throw new UnsupportedOperationException("flexFlex has no default (FFM/comm impl required)");
  }
  default Axis Flex_readBack_direction(Object st) {
    throw new UnsupportedOperationException("Flex_readBack_direction read-back requires FFM/java22");
  }
  default MainAxisAlignment Flex_readBack_mainAxisAlignment(Object st) {
    throw new UnsupportedOperationException("Flex_readBack_mainAxisAlignment read-back requires FFM/java22");
  }
  default MainAxisSize Flex_readBack_mainAxisSize(Object st) {
    throw new UnsupportedOperationException("Flex_readBack_mainAxisSize read-back requires FFM/java22");
  }
  default CrossAxisAlignment Flex_readBack_crossAxisAlignment(Object st) {
    throw new UnsupportedOperationException("Flex_readBack_crossAxisAlignment read-back requires FFM/java22");
  }
  default TextDirection Flex_readBack_textDirection(Object st) {
    throw new UnsupportedOperationException("Flex_readBack_textDirection read-back requires FFM/java22");
  }
  default VerticalDirection Flex_readBack_verticalDirection(Object st) {
    throw new UnsupportedOperationException("Flex_readBack_verticalDirection read-back requires FFM/java22");
  }
  default TextBaseline Flex_readBack_textBaseline(Object st) {
    throw new UnsupportedOperationException("Flex_readBack_textBaseline read-back requires FFM/java22");
  }
  default Clip Flex_readBack_clipBehavior(Object st) {
    throw new UnsupportedOperationException("Flex_readBack_clipBehavior read-back requires FFM/java22");
  }
  default double Flex_readBack_spacing(Object st) {
    throw new UnsupportedOperationException("Flex_readBack_spacing read-back requires FFM/java22");
  }

  default int rowRow(Optional<MainAxisAlignment> mainAxisAlignment, Optional<MainAxisSize> mainAxisSize, Optional<CrossAxisAlignment> crossAxisAlignment, Optional<TextDirection> textDirection, Optional<VerticalDirection> verticalDirection, Optional<TextBaseline> textBaseline, OptionalDouble spacing, Optional<List<Widget>> children) {
    throw new UnsupportedOperationException("rowRow has no default (FFM/comm impl required)");
  }

  default int ewtGraphViewEwtGraphView(List<Widget> nodes, Optional<String> edges, Optional<String> positions, Optional<Consumer<String>> onNodeMoved, OptionalDouble nodeWidth, OptionalDouble nodeHeight) {
    throw new UnsupportedOperationException("ewtGraphViewEwtGraphView has no default (FFM/comm impl required)");
  }
  default String EwtGraphView_readBack_edges(Object st) {
    throw new UnsupportedOperationException("EwtGraphView_readBack_edges read-back requires FFM/java22");
  }
  default String EwtGraphView_readBack_positions(Object st) {
    throw new UnsupportedOperationException("EwtGraphView_readBack_positions read-back requires FFM/java22");
  }
  default double EwtGraphView_readBack_nodeWidth(Object st) {
    throw new UnsupportedOperationException("EwtGraphView_readBack_nodeWidth read-back requires FFM/java22");
  }
  default double EwtGraphView_readBack_nodeHeight(Object st) {
    throw new UnsupportedOperationException("EwtGraphView_readBack_nodeHeight read-back requires FFM/java22");
  }

  default int ewtMapViewEwtMapView(List<Widget> markers, Optional<String> markerCoords, Optional<String> tileUrl, Optional<String> camera, Optional<Consumer<String>> onCameraMoved, Optional<Consumer<String>> onMarkerTap, Optional<String> polygons, Optional<String> polylines, Optional<Consumer<String>> onMapTap, OptionalInt selected, OptionalDouble minZoom, OptionalDouble maxZoom) {
    throw new UnsupportedOperationException("ewtMapViewEwtMapView has no default (FFM/comm impl required)");
  }
  default String EwtMapView_readBack_markerCoords(Object st) {
    throw new UnsupportedOperationException("EwtMapView_readBack_markerCoords read-back requires FFM/java22");
  }
  default String EwtMapView_readBack_tileUrl(Object st) {
    throw new UnsupportedOperationException("EwtMapView_readBack_tileUrl read-back requires FFM/java22");
  }
  default String EwtMapView_readBack_camera(Object st) {
    throw new UnsupportedOperationException("EwtMapView_readBack_camera read-back requires FFM/java22");
  }
  default String EwtMapView_readBack_polygons(Object st) {
    throw new UnsupportedOperationException("EwtMapView_readBack_polygons read-back requires FFM/java22");
  }
  default String EwtMapView_readBack_polylines(Object st) {
    throw new UnsupportedOperationException("EwtMapView_readBack_polylines read-back requires FFM/java22");
  }
  default int EwtMapView_readBack_selected(Object st) {
    throw new UnsupportedOperationException("EwtMapView_readBack_selected read-back requires FFM/java22");
  }
  default double EwtMapView_readBack_minZoom(Object st) {
    throw new UnsupportedOperationException("EwtMapView_readBack_minZoom read-back requires FFM/java22");
  }
  default double EwtMapView_readBack_maxZoom(Object st) {
    throw new UnsupportedOperationException("EwtMapView_readBack_maxZoom read-back requires FFM/java22");
  }

  default int transformRotate(double angle, Optional<Offset> origin, Optional<AlignmentGeometry> alignment, Optional<Boolean> transformHitTests, Optional<FilterQuality> filterQuality, Optional<Widget> child) {
    throw new UnsupportedOperationException("transformRotate has no default (FFM/comm impl required)");
  }
  default int transformTranslate(Offset offset, Optional<Boolean> transformHitTests, Optional<FilterQuality> filterQuality, Optional<Widget> child) {
    throw new UnsupportedOperationException("transformTranslate has no default (FFM/comm impl required)");
  }
  default int transformScale(OptionalDouble scale, OptionalDouble scaleX, OptionalDouble scaleY, Optional<Offset> origin, Optional<AlignmentGeometry> alignment, Optional<Boolean> transformHitTests, Optional<FilterQuality> filterQuality, Optional<Widget> child) {
    throw new UnsupportedOperationException("transformScale has no default (FFM/comm impl required)");
  }
  default int transformFlip(Optional<Boolean> flipX, Optional<Boolean> flipY, Optional<Offset> origin, Optional<Boolean> transformHitTests, Optional<FilterQuality> filterQuality, Optional<Widget> child) {
    throw new UnsupportedOperationException("transformFlip has no default (FFM/comm impl required)");
  }
  default Offset Transform_readBack_origin(Object st) {
    throw new UnsupportedOperationException("Transform_readBack_origin read-back requires FFM/java22");
  }
  default AlignmentGeometry Transform_readBack_alignment(Object st) {
    throw new UnsupportedOperationException("Transform_readBack_alignment read-back requires FFM/java22");
  }
  default boolean Transform_readBack_transformHitTests(Object st) {
    throw new UnsupportedOperationException("Transform_readBack_transformHitTests read-back requires FFM/java22");
  }
  default FilterQuality Transform_readBack_filterQuality(Object st) {
    throw new UnsupportedOperationException("Transform_readBack_filterQuality read-back requires FFM/java22");
  }

  default int opacityOpacity(double opacity, Optional<Boolean> alwaysIncludeSemantics, Optional<Widget> child) {
    throw new UnsupportedOperationException("opacityOpacity has no default (FFM/comm impl required)");
  }
  default double Opacity_readBack_opacity(Object st) {
    throw new UnsupportedOperationException("Opacity_readBack_opacity read-back requires FFM/java22");
  }
  default boolean Opacity_readBack_alwaysIncludeSemantics(Object st) {
    throw new UnsupportedOperationException("Opacity_readBack_alwaysIncludeSemantics read-back requires FFM/java22");
  }

  default int stackStack(Optional<AlignmentGeometry> alignment, Optional<TextDirection> textDirection, Optional<StackFit> fit, Optional<Clip> clipBehavior, Optional<List<Widget>> children) {
    throw new UnsupportedOperationException("stackStack has no default (FFM/comm impl required)");
  }
  default AlignmentGeometry Stack_readBack_alignment(Object st) {
    throw new UnsupportedOperationException("Stack_readBack_alignment read-back requires FFM/java22");
  }
  default TextDirection Stack_readBack_textDirection(Object st) {
    throw new UnsupportedOperationException("Stack_readBack_textDirection read-back requires FFM/java22");
  }
  default StackFit Stack_readBack_fit(Object st) {
    throw new UnsupportedOperationException("Stack_readBack_fit read-back requires FFM/java22");
  }
  default Clip Stack_readBack_clipBehavior(Object st) {
    throw new UnsupportedOperationException("Stack_readBack_clipBehavior read-back requires FFM/java22");
  }

  default int boxConstraintsBoxConstraints(OptionalDouble minWidth, OptionalDouble maxWidth, OptionalDouble minHeight, OptionalDouble maxHeight) {
    throw new UnsupportedOperationException("boxConstraintsBoxConstraints has no default (FFM/comm impl required)");
  }
  default int boxConstraintsTightFor(OptionalDouble width, OptionalDouble height) {
    throw new UnsupportedOperationException("boxConstraintsTightFor has no default (FFM/comm impl required)");
  }
  default int boxConstraintsTightForFinite(OptionalDouble width, OptionalDouble height) {
    throw new UnsupportedOperationException("boxConstraintsTightForFinite has no default (FFM/comm impl required)");
  }
  default int boxConstraintsExpand(OptionalDouble width, OptionalDouble height) {
    throw new UnsupportedOperationException("boxConstraintsExpand has no default (FFM/comm impl required)");
  }
  default int boxConstraintsLerp(BoxConstraints a, BoxConstraints b, double t) {
    throw new UnsupportedOperationException("boxConstraintsLerp has no default (FFM/comm impl required)");
  }
  default double BoxConstraints_readBack_minWidth(Object st) {
    throw new UnsupportedOperationException("BoxConstraints_readBack_minWidth read-back requires FFM/java22");
  }
  default double BoxConstraints_readBack_maxWidth(Object st) {
    throw new UnsupportedOperationException("BoxConstraints_readBack_maxWidth read-back requires FFM/java22");
  }
  default double BoxConstraints_readBack_minHeight(Object st) {
    throw new UnsupportedOperationException("BoxConstraints_readBack_minHeight read-back requires FFM/java22");
  }
  default double BoxConstraints_readBack_maxHeight(Object st) {
    throw new UnsupportedOperationException("BoxConstraints_readBack_maxHeight read-back requires FFM/java22");
  }
  default boolean BoxConstraints_readBack_hasTightWidth(Object st) {
    throw new UnsupportedOperationException("BoxConstraints_readBack_hasTightWidth read-back requires FFM/java22");
  }
  default boolean BoxConstraints_readBack_hasTightHeight(Object st) {
    throw new UnsupportedOperationException("BoxConstraints_readBack_hasTightHeight read-back requires FFM/java22");
  }
  default boolean BoxConstraints_readBack_hasBoundedWidth(Object st) {
    throw new UnsupportedOperationException("BoxConstraints_readBack_hasBoundedWidth read-back requires FFM/java22");
  }
  default boolean BoxConstraints_readBack_hasBoundedHeight(Object st) {
    throw new UnsupportedOperationException("BoxConstraints_readBack_hasBoundedHeight read-back requires FFM/java22");
  }
  default boolean BoxConstraints_readBack_hasInfiniteWidth(Object st) {
    throw new UnsupportedOperationException("BoxConstraints_readBack_hasInfiniteWidth read-back requires FFM/java22");
  }
  default boolean BoxConstraints_readBack_hasInfiniteHeight(Object st) {
    throw new UnsupportedOperationException("BoxConstraints_readBack_hasInfiniteHeight read-back requires FFM/java22");
  }

  default int containerContainer(Optional<AlignmentGeometry> alignment, Optional<EdgeInsetsGeometry> padding, Optional<Color> color, Optional<Boolean> isAntiAlias, Optional<Decoration> decoration, Optional<Decoration> foregroundDecoration, OptionalDouble width, OptionalDouble height, Optional<BoxConstraints> constraints, Optional<EdgeInsetsGeometry> margin, Optional<AlignmentGeometry> transformAlignment, Optional<Widget> child, Optional<Clip> clipBehavior) {
    throw new UnsupportedOperationException("containerContainer has no default (FFM/comm impl required)");
  }
  default Widget Container_readBack_child(Object st) {
    throw new UnsupportedOperationException("Container_readBack_child read-back requires FFM/java22");
  }
  default AlignmentGeometry Container_readBack_alignment(Object st) {
    throw new UnsupportedOperationException("Container_readBack_alignment read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry Container_readBack_padding(Object st) {
    throw new UnsupportedOperationException("Container_readBack_padding read-back requires FFM/java22");
  }
  default Color Container_readBack_color(Object st) {
    throw new UnsupportedOperationException("Container_readBack_color read-back requires FFM/java22");
  }
  default boolean Container_readBack_isAntiAlias(Object st) {
    throw new UnsupportedOperationException("Container_readBack_isAntiAlias read-back requires FFM/java22");
  }
  default Decoration Container_readBack_decoration(Object st) {
    throw new UnsupportedOperationException("Container_readBack_decoration read-back requires FFM/java22");
  }
  default Decoration Container_readBack_foregroundDecoration(Object st) {
    throw new UnsupportedOperationException("Container_readBack_foregroundDecoration read-back requires FFM/java22");
  }
  default BoxConstraints Container_readBack_constraints(Object st) {
    throw new UnsupportedOperationException("Container_readBack_constraints read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry Container_readBack_margin(Object st) {
    throw new UnsupportedOperationException("Container_readBack_margin read-back requires FFM/java22");
  }
  default AlignmentGeometry Container_readBack_transformAlignment(Object st) {
    throw new UnsupportedOperationException("Container_readBack_transformAlignment read-back requires FFM/java22");
  }
  default Clip Container_readBack_clipBehavior(Object st) {
    throw new UnsupportedOperationException("Container_readBack_clipBehavior read-back requires FFM/java22");
  }

  default int edgeInsetsGeometryInfinity() {
    throw new UnsupportedOperationException("edgeInsetsGeometryInfinity has no default (FFM/comm impl required)");
  }

  default int stackParentDataStackParentData() {
    throw new UnsupportedOperationException("stackParentDataStackParentData has no default (FFM/comm impl required)");
  }

  default int boxParentDataBoxParentData() {
    throw new UnsupportedOperationException("boxParentDataBoxParentData has no default (FFM/comm impl required)");
  }

  default int parentDataParentData() {
    throw new UnsupportedOperationException("parentDataParentData has no default (FFM/comm impl required)");
  }

  default int flexParentDataFlexParentData() {
    throw new UnsupportedOperationException("flexParentDataFlexParentData has no default (FFM/comm impl required)");
  }

  default int positionedPositioned(OptionalDouble left, OptionalDouble top, OptionalDouble right, OptionalDouble bottom, OptionalDouble width, OptionalDouble height, Widget child) {
    throw new UnsupportedOperationException("positionedPositioned has no default (FFM/comm impl required)");
  }
  default int positionedFill(OptionalDouble left, OptionalDouble top, OptionalDouble right, OptionalDouble bottom, Widget child) {
    throw new UnsupportedOperationException("positionedFill has no default (FFM/comm impl required)");
  }
  default int positionedDirectional(TextDirection textDirection, OptionalDouble start, OptionalDouble top, OptionalDouble end, OptionalDouble bottom, OptionalDouble width, OptionalDouble height, Widget child) {
    throw new UnsupportedOperationException("positionedDirectional has no default (FFM/comm impl required)");
  }
  default double Positioned_readBack_left(Object st) {
    throw new UnsupportedOperationException("Positioned_readBack_left read-back requires FFM/java22");
  }
  default double Positioned_readBack_top(Object st) {
    throw new UnsupportedOperationException("Positioned_readBack_top read-back requires FFM/java22");
  }
  default double Positioned_readBack_right(Object st) {
    throw new UnsupportedOperationException("Positioned_readBack_right read-back requires FFM/java22");
  }
  default double Positioned_readBack_bottom(Object st) {
    throw new UnsupportedOperationException("Positioned_readBack_bottom read-back requires FFM/java22");
  }
  default double Positioned_readBack_width(Object st) {
    throw new UnsupportedOperationException("Positioned_readBack_width read-back requires FFM/java22");
  }
  default double Positioned_readBack_height(Object st) {
    throw new UnsupportedOperationException("Positioned_readBack_height read-back requires FFM/java22");
  }

  default int boxDecorationBoxDecoration(Optional<Color> color, Optional<BoxBorder> border, Optional<BorderRadiusGeometry> borderRadius, Optional<List<BoxShadow>> boxShadow, Optional<BlendMode> backgroundBlendMode, Optional<BoxShape> shape) {
    throw new UnsupportedOperationException("boxDecorationBoxDecoration has no default (FFM/comm impl required)");
  }
  default int boxDecorationLerp(BoxDecoration a, BoxDecoration b, double t) {
    throw new UnsupportedOperationException("boxDecorationLerp has no default (FFM/comm impl required)");
  }
  default Color BoxDecoration_readBack_color(Object st) {
    throw new UnsupportedOperationException("BoxDecoration_readBack_color read-back requires FFM/java22");
  }
  default BoxBorder BoxDecoration_readBack_border(Object st) {
    throw new UnsupportedOperationException("BoxDecoration_readBack_border read-back requires FFM/java22");
  }
  default BorderRadiusGeometry BoxDecoration_readBack_borderRadius(Object st) {
    throw new UnsupportedOperationException("BoxDecoration_readBack_borderRadius read-back requires FFM/java22");
  }
  default BlendMode BoxDecoration_readBack_backgroundBlendMode(Object st) {
    throw new UnsupportedOperationException("BoxDecoration_readBack_backgroundBlendMode read-back requires FFM/java22");
  }
  default BoxShape BoxDecoration_readBack_shape(Object st) {
    throw new UnsupportedOperationException("BoxDecoration_readBack_shape read-back requires FFM/java22");
  }

  default int boxShadowBoxShadow(Optional<Color> color, Optional<Offset> offset, OptionalDouble blurRadius, OptionalDouble spreadRadius, Optional<BlurStyle> blurStyle) {
    throw new UnsupportedOperationException("boxShadowBoxShadow has no default (FFM/comm impl required)");
  }
  default int boxShadowLerp(BoxShadow a, BoxShadow b, double t) {
    throw new UnsupportedOperationException("boxShadowLerp has no default (FFM/comm impl required)");
  }
  default double BoxShadow_readBack_spreadRadius(Object st) {
    throw new UnsupportedOperationException("BoxShadow_readBack_spreadRadius read-back requires FFM/java22");
  }
  default BlurStyle BoxShadow_readBack_blurStyle(Object st) {
    throw new UnsupportedOperationException("BoxShadow_readBack_blurStyle read-back requires FFM/java22");
  }

  default int radiusCircular(double radius) {
    throw new UnsupportedOperationException("radiusCircular has no default (FFM/comm impl required)");
  }
  default int radiusElliptical(double x, double y) {
    throw new UnsupportedOperationException("radiusElliptical has no default (FFM/comm impl required)");
  }
  default int radiusLerp(Radius a, Radius b, double t) {
    throw new UnsupportedOperationException("radiusLerp has no default (FFM/comm impl required)");
  }

  default int borderRadiusAll(Radius radius) {
    throw new UnsupportedOperationException("borderRadiusAll has no default (FFM/comm impl required)");
  }
  default int borderRadiusCircular(double radius) {
    throw new UnsupportedOperationException("borderRadiusCircular has no default (FFM/comm impl required)");
  }
  default int borderRadiusVertical(Optional<Radius> top, Optional<Radius> bottom) {
    throw new UnsupportedOperationException("borderRadiusVertical has no default (FFM/comm impl required)");
  }
  default int borderRadiusHorizontal(Optional<Radius> left, Optional<Radius> right) {
    throw new UnsupportedOperationException("borderRadiusHorizontal has no default (FFM/comm impl required)");
  }
  default int borderRadiusOnly(Optional<Radius> topLeft, Optional<Radius> topRight, Optional<Radius> bottomLeft, Optional<Radius> bottomRight) {
    throw new UnsupportedOperationException("borderRadiusOnly has no default (FFM/comm impl required)");
  }
  default int borderRadiusLerp(BorderRadius a, BorderRadius b, double t) {
    throw new UnsupportedOperationException("borderRadiusLerp has no default (FFM/comm impl required)");
  }
  default Radius BorderRadius_readBack_topLeft(Object st) {
    throw new UnsupportedOperationException("BorderRadius_readBack_topLeft read-back requires FFM/java22");
  }
  default Radius BorderRadius_readBack_topRight(Object st) {
    throw new UnsupportedOperationException("BorderRadius_readBack_topRight read-back requires FFM/java22");
  }
  default Radius BorderRadius_readBack_bottomLeft(Object st) {
    throw new UnsupportedOperationException("BorderRadius_readBack_bottomLeft read-back requires FFM/java22");
  }
  default Radius BorderRadius_readBack_bottomRight(Object st) {
    throw new UnsupportedOperationException("BorderRadius_readBack_bottomRight read-back requires FFM/java22");
  }

  default int paddingPadding(EdgeInsetsGeometry padding, Optional<Widget> child) {
    throw new UnsupportedOperationException("paddingPadding has no default (FFM/comm impl required)");
  }
  default EdgeInsetsGeometry Padding_readBack_padding(Object st) {
    throw new UnsupportedOperationException("Padding_readBack_padding read-back requires FFM/java22");
  }

  default int edgeInsetsFromLTRB(double left, double top, double right, double bottom) {
    throw new UnsupportedOperationException("edgeInsetsFromLTRB has no default (FFM/comm impl required)");
  }
  default int edgeInsetsAll(double value) {
    throw new UnsupportedOperationException("edgeInsetsAll has no default (FFM/comm impl required)");
  }
  default int edgeInsetsOnly(OptionalDouble left, OptionalDouble top, OptionalDouble right, OptionalDouble bottom) {
    throw new UnsupportedOperationException("edgeInsetsOnly has no default (FFM/comm impl required)");
  }
  default int edgeInsetsSymmetric(OptionalDouble vertical, OptionalDouble horizontal) {
    throw new UnsupportedOperationException("edgeInsetsSymmetric has no default (FFM/comm impl required)");
  }
  default int edgeInsetsLerp(EdgeInsets a, EdgeInsets b, double t) {
    throw new UnsupportedOperationException("edgeInsetsLerp has no default (FFM/comm impl required)");
  }
  default double EdgeInsets_readBack_left(Object st) {
    throw new UnsupportedOperationException("EdgeInsets_readBack_left read-back requires FFM/java22");
  }
  default double EdgeInsets_readBack_top(Object st) {
    throw new UnsupportedOperationException("EdgeInsets_readBack_top read-back requires FFM/java22");
  }
  default double EdgeInsets_readBack_right(Object st) {
    throw new UnsupportedOperationException("EdgeInsets_readBack_right read-back requires FFM/java22");
  }
  default double EdgeInsets_readBack_bottom(Object st) {
    throw new UnsupportedOperationException("EdgeInsets_readBack_bottom read-back requires FFM/java22");
  }
  default Offset EdgeInsets_readBack_topLeft(Object st) {
    throw new UnsupportedOperationException("EdgeInsets_readBack_topLeft read-back requires FFM/java22");
  }
  default Offset EdgeInsets_readBack_topRight(Object st) {
    throw new UnsupportedOperationException("EdgeInsets_readBack_topRight read-back requires FFM/java22");
  }
  default Offset EdgeInsets_readBack_bottomLeft(Object st) {
    throw new UnsupportedOperationException("EdgeInsets_readBack_bottomLeft read-back requires FFM/java22");
  }
  default Offset EdgeInsets_readBack_bottomRight(Object st) {
    throw new UnsupportedOperationException("EdgeInsets_readBack_bottomRight read-back requires FFM/java22");
  }

  default int borderSideBorderSide(Optional<Color> color, OptionalDouble width, Optional<BorderStyle> style, OptionalDouble strokeAlign) {
    throw new UnsupportedOperationException("borderSideBorderSide has no default (FFM/comm impl required)");
  }
  default int borderSideMerge(BorderSide a, BorderSide b) {
    throw new UnsupportedOperationException("borderSideMerge has no default (FFM/comm impl required)");
  }
  default int borderSideCanMerge(BorderSide a, BorderSide b) {
    throw new UnsupportedOperationException("borderSideCanMerge has no default (FFM/comm impl required)");
  }
  default int borderSideLerp(BorderSide a, BorderSide b, double t) {
    throw new UnsupportedOperationException("borderSideLerp has no default (FFM/comm impl required)");
  }
  default Color BorderSide_readBack_color(Object st) {
    throw new UnsupportedOperationException("BorderSide_readBack_color read-back requires FFM/java22");
  }
  default double BorderSide_readBack_width(Object st) {
    throw new UnsupportedOperationException("BorderSide_readBack_width read-back requires FFM/java22");
  }
  default BorderStyle BorderSide_readBack_style(Object st) {
    throw new UnsupportedOperationException("BorderSide_readBack_style read-back requires FFM/java22");
  }
  default double BorderSide_readBack_strokeAlign(Object st) {
    throw new UnsupportedOperationException("BorderSide_readBack_strokeAlign read-back requires FFM/java22");
  }
  default double BorderSide_readBack_strokeInset(Object st) {
    throw new UnsupportedOperationException("BorderSide_readBack_strokeInset read-back requires FFM/java22");
  }
  default double BorderSide_readBack_strokeOutset(Object st) {
    throw new UnsupportedOperationException("BorderSide_readBack_strokeOutset read-back requires FFM/java22");
  }
  default double BorderSide_readBack_strokeOffset(Object st) {
    throw new UnsupportedOperationException("BorderSide_readBack_strokeOffset read-back requires FFM/java22");
  }

  default int borderBorder(Optional<BorderSide> top, Optional<BorderSide> right, Optional<BorderSide> bottom, Optional<BorderSide> left) {
    throw new UnsupportedOperationException("borderBorder has no default (FFM/comm impl required)");
  }
  default int borderFromBorderSide(BorderSide side) {
    throw new UnsupportedOperationException("borderFromBorderSide has no default (FFM/comm impl required)");
  }
  default int borderSymmetric(Optional<BorderSide> vertical, Optional<BorderSide> horizontal) {
    throw new UnsupportedOperationException("borderSymmetric has no default (FFM/comm impl required)");
  }
  default int borderAll(Optional<Color> color, OptionalDouble width, Optional<BorderStyle> style, OptionalDouble strokeAlign) {
    throw new UnsupportedOperationException("borderAll has no default (FFM/comm impl required)");
  }
  default int borderMerge(Border a, Border b) {
    throw new UnsupportedOperationException("borderMerge has no default (FFM/comm impl required)");
  }
  default int borderLerp(Border a, Border b, double t) {
    throw new UnsupportedOperationException("borderLerp has no default (FFM/comm impl required)");
  }
  default BorderSide Border_readBack_top(Object st) {
    throw new UnsupportedOperationException("Border_readBack_top read-back requires FFM/java22");
  }
  default BorderSide Border_readBack_right(Object st) {
    throw new UnsupportedOperationException("Border_readBack_right read-back requires FFM/java22");
  }
  default BorderSide Border_readBack_bottom(Object st) {
    throw new UnsupportedOperationException("Border_readBack_bottom read-back requires FFM/java22");
  }
  default BorderSide Border_readBack_left(Object st) {
    throw new UnsupportedOperationException("Border_readBack_left read-back requires FFM/java22");
  }

  default int roundedRectangleBorderRoundedRectangleBorder(Optional<BorderSide> side, Optional<BorderRadiusGeometry> borderRadius) {
    throw new UnsupportedOperationException("roundedRectangleBorderRoundedRectangleBorder has no default (FFM/comm impl required)");
  }
  default BorderRadiusGeometry RoundedRectangleBorder_readBack_borderRadius(Object st) {
    throw new UnsupportedOperationException("RoundedRectangleBorder_readBack_borderRadius read-back requires FFM/java22");
  }

  default int animationControllerAnimationController(OptionalDouble value, Optional<Duration> duration, Optional<Duration> reverseDuration, Optional<String> debugLabel, OptionalDouble lowerBound, OptionalDouble upperBound, Optional<AnimationBehavior> animationBehavior, TickerProvider vsync) {
    throw new UnsupportedOperationException("animationControllerAnimationController has no default (FFM/comm impl required)");
  }
  default int animationControllerUnbounded(OptionalDouble value, Optional<Duration> duration, Optional<Duration> reverseDuration, Optional<String> debugLabel, TickerProvider vsync, Optional<AnimationBehavior> animationBehavior) {
    throw new UnsupportedOperationException("animationControllerUnbounded has no default (FFM/comm impl required)");
  }
  default int animationControllerForward(AnimationController self) {
    throw new UnsupportedOperationException("animationControllerForward has no default (FFM/comm impl required)");
  }
  default int animationControllerReverse(AnimationController self) {
    throw new UnsupportedOperationException("animationControllerReverse has no default (FFM/comm impl required)");
  }
  default int animationControllerRepeat(AnimationController self) {
    throw new UnsupportedOperationException("animationControllerRepeat has no default (FFM/comm impl required)");
  }
  default int animationControllerToggle(AnimationController self) {
    throw new UnsupportedOperationException("animationControllerToggle has no default (FFM/comm impl required)");
  }
  default int animationControllerFling(AnimationController self, double velocity) {
    throw new UnsupportedOperationException("animationControllerFling has no default (FFM/comm impl required)");
  }
  default int animationControllerAnimateTo(AnimationController self, double target, Duration duration) {
    throw new UnsupportedOperationException("animationControllerAnimateTo has no default (FFM/comm impl required)");
  }
  default int animationControllerAnimateBack(AnimationController self, double target, Duration duration) {
    throw new UnsupportedOperationException("animationControllerAnimateBack has no default (FFM/comm impl required)");
  }
  default void animationControllerStop(AnimationController self) {
    throw new UnsupportedOperationException("animationControllerStop has no default (FFM/comm impl required)");
  }
  default void animationControllerReset(AnimationController self) {
    throw new UnsupportedOperationException("animationControllerReset has no default (FFM/comm impl required)");
  }
  default void animationControllerSetValue(AnimationController self, double v) {
    throw new UnsupportedOperationException("animationControllerSetValue has no default (FFM/comm impl required)");
  }
  default void animationControllerSetDuration(AnimationController self, Duration d) {
    throw new UnsupportedOperationException("animationControllerSetDuration has no default (FFM/comm impl required)");
  }
  default void animationControllerSetReverseDuration(AnimationController self, Duration d) {
    throw new UnsupportedOperationException("animationControllerSetReverseDuration has no default (FFM/comm impl required)");
  }

  default int animatedBuilderAnimatedBuilder(Listenable animation, BiFunction<BuildContext, Widget, Widget> builder, Optional<Widget> child) {
    throw new UnsupportedOperationException("animatedBuilderAnimatedBuilder has no default (FFM/comm impl required)");
  }
  default Listenable AnimatedBuilder_readBack_animation(Object st) {
    throw new UnsupportedOperationException("AnimatedBuilder_readBack_animation read-back requires FFM/java22");
  }

  default int listenableBuilderListenableBuilder(Listenable listenable, BiFunction<BuildContext, Widget, Widget> builder, Optional<Widget> child) {
    throw new UnsupportedOperationException("listenableBuilderListenableBuilder has no default (FFM/comm impl required)");
  }
  default Widget ListenableBuilder_readBack_child(Object st) {
    throw new UnsupportedOperationException("ListenableBuilder_readBack_child read-back requires FFM/java22");
  }

  default int velocityVelocity(Offset pixelsPerSecond) {
    throw new UnsupportedOperationException("velocityVelocity has no default (FFM/comm impl required)");
  }
  default Offset Velocity_readBack_pixelsPerSecond(Object st) {
    throw new UnsupportedOperationException("Velocity_readBack_pixelsPerSecond read-back requires FFM/java22");
  }

  default int tapDownDetailsTapDownDetails(Optional<Offset> globalPosition, Optional<Offset> localPosition, Optional<PointerDeviceKind> kind) {
    throw new UnsupportedOperationException("tapDownDetailsTapDownDetails has no default (FFM/comm impl required)");
  }
  default int tapDownDetailsGlobalPosition(TapDownDetails self) {
    throw new UnsupportedOperationException("tapDownDetailsGlobalPosition has no default (FFM/comm impl required)");
  }
  default int tapDownDetailsLocalPosition(TapDownDetails self) {
    throw new UnsupportedOperationException("tapDownDetailsLocalPosition has no default (FFM/comm impl required)");
  }

  default int tapUpDetailsTapUpDetails(Optional<Offset> globalPosition, Optional<Offset> localPosition, PointerDeviceKind kind) {
    throw new UnsupportedOperationException("tapUpDetailsTapUpDetails has no default (FFM/comm impl required)");
  }
  default int tapUpDetailsGlobalPosition(TapUpDetails self) {
    throw new UnsupportedOperationException("tapUpDetailsGlobalPosition has no default (FFM/comm impl required)");
  }
  default int tapUpDetailsLocalPosition(TapUpDetails self) {
    throw new UnsupportedOperationException("tapUpDetailsLocalPosition has no default (FFM/comm impl required)");
  }

  default int tapMoveDetailsTapMoveDetails(PointerDeviceKind kind, Optional<Offset> globalPosition, Optional<Offset> delta, Optional<Offset> localPosition) {
    throw new UnsupportedOperationException("tapMoveDetailsTapMoveDetails has no default (FFM/comm impl required)");
  }
  default int tapMoveDetailsGlobalPosition(TapMoveDetails self) {
    throw new UnsupportedOperationException("tapMoveDetailsGlobalPosition has no default (FFM/comm impl required)");
  }
  default int tapMoveDetailsLocalPosition(TapMoveDetails self) {
    throw new UnsupportedOperationException("tapMoveDetailsLocalPosition has no default (FFM/comm impl required)");
  }
  default int tapMoveDetailsDelta(TapMoveDetails self) {
    throw new UnsupportedOperationException("tapMoveDetailsDelta has no default (FFM/comm impl required)");
  }

  default int longPressDownDetailsLongPressDownDetails(Optional<Offset> globalPosition, Optional<Offset> localPosition, Optional<PointerDeviceKind> kind) {
    throw new UnsupportedOperationException("longPressDownDetailsLongPressDownDetails has no default (FFM/comm impl required)");
  }
  default int longPressDownDetailsGlobalPosition(LongPressDownDetails self) {
    throw new UnsupportedOperationException("longPressDownDetailsGlobalPosition has no default (FFM/comm impl required)");
  }
  default int longPressDownDetailsLocalPosition(LongPressDownDetails self) {
    throw new UnsupportedOperationException("longPressDownDetailsLocalPosition has no default (FFM/comm impl required)");
  }

  default int longPressStartDetailsLongPressStartDetails(Optional<Offset> globalPosition, Optional<Offset> localPosition) {
    throw new UnsupportedOperationException("longPressStartDetailsLongPressStartDetails has no default (FFM/comm impl required)");
  }
  default int longPressStartDetailsGlobalPosition(LongPressStartDetails self) {
    throw new UnsupportedOperationException("longPressStartDetailsGlobalPosition has no default (FFM/comm impl required)");
  }
  default int longPressStartDetailsLocalPosition(LongPressStartDetails self) {
    throw new UnsupportedOperationException("longPressStartDetailsLocalPosition has no default (FFM/comm impl required)");
  }

  default int longPressMoveUpdateDetailsLongPressMoveUpdateDetails(Optional<Offset> globalPosition, Optional<Offset> localPosition, Optional<Offset> offsetFromOrigin, Optional<Offset> localOffsetFromOrigin) {
    throw new UnsupportedOperationException("longPressMoveUpdateDetailsLongPressMoveUpdateDetails has no default (FFM/comm impl required)");
  }
  default int longPressMoveUpdateDetailsGlobalPosition(LongPressMoveUpdateDetails self) {
    throw new UnsupportedOperationException("longPressMoveUpdateDetailsGlobalPosition has no default (FFM/comm impl required)");
  }
  default int longPressMoveUpdateDetailsLocalPosition(LongPressMoveUpdateDetails self) {
    throw new UnsupportedOperationException("longPressMoveUpdateDetailsLocalPosition has no default (FFM/comm impl required)");
  }
  default int longPressMoveUpdateDetailsOffsetFromOrigin(LongPressMoveUpdateDetails self) {
    throw new UnsupportedOperationException("longPressMoveUpdateDetailsOffsetFromOrigin has no default (FFM/comm impl required)");
  }
  default int longPressMoveUpdateDetailsLocalOffsetFromOrigin(LongPressMoveUpdateDetails self) {
    throw new UnsupportedOperationException("longPressMoveUpdateDetailsLocalOffsetFromOrigin has no default (FFM/comm impl required)");
  }

  default int longPressEndDetailsLongPressEndDetails(Optional<Offset> globalPosition, Optional<Offset> localPosition, Optional<Velocity> velocity) {
    throw new UnsupportedOperationException("longPressEndDetailsLongPressEndDetails has no default (FFM/comm impl required)");
  }
  default int longPressEndDetailsGlobalPosition(LongPressEndDetails self) {
    throw new UnsupportedOperationException("longPressEndDetailsGlobalPosition has no default (FFM/comm impl required)");
  }
  default int longPressEndDetailsLocalPosition(LongPressEndDetails self) {
    throw new UnsupportedOperationException("longPressEndDetailsLocalPosition has no default (FFM/comm impl required)");
  }
  default int longPressEndDetailsVelocity(LongPressEndDetails self) {
    throw new UnsupportedOperationException("longPressEndDetailsVelocity has no default (FFM/comm impl required)");
  }

  default int dragDownDetailsDragDownDetails(Optional<Offset> globalPosition, Optional<Offset> localPosition) {
    throw new UnsupportedOperationException("dragDownDetailsDragDownDetails has no default (FFM/comm impl required)");
  }
  default int dragDownDetailsGlobalPosition(DragDownDetails self) {
    throw new UnsupportedOperationException("dragDownDetailsGlobalPosition has no default (FFM/comm impl required)");
  }
  default int dragDownDetailsLocalPosition(DragDownDetails self) {
    throw new UnsupportedOperationException("dragDownDetailsLocalPosition has no default (FFM/comm impl required)");
  }

  default int dragStartDetailsDragStartDetails(Optional<Offset> globalPosition, Optional<Offset> localPosition, Optional<Duration> sourceTimeStamp, Optional<PointerDeviceKind> kind) {
    throw new UnsupportedOperationException("dragStartDetailsDragStartDetails has no default (FFM/comm impl required)");
  }
  default int dragStartDetailsGlobalPosition(DragStartDetails self) {
    throw new UnsupportedOperationException("dragStartDetailsGlobalPosition has no default (FFM/comm impl required)");
  }
  default int dragStartDetailsLocalPosition(DragStartDetails self) {
    throw new UnsupportedOperationException("dragStartDetailsLocalPosition has no default (FFM/comm impl required)");
  }

  default int dragUpdateDetailsDragUpdateDetails(Offset globalPosition, Optional<Offset> localPosition, Optional<Duration> sourceTimeStamp, Optional<Offset> delta, OptionalDouble primaryDelta, Optional<PointerDeviceKind> kind) {
    throw new UnsupportedOperationException("dragUpdateDetailsDragUpdateDetails has no default (FFM/comm impl required)");
  }
  default int dragUpdateDetailsGlobalPosition(DragUpdateDetails self) {
    throw new UnsupportedOperationException("dragUpdateDetailsGlobalPosition has no default (FFM/comm impl required)");
  }
  default int dragUpdateDetailsLocalPosition(DragUpdateDetails self) {
    throw new UnsupportedOperationException("dragUpdateDetailsLocalPosition has no default (FFM/comm impl required)");
  }
  default int dragUpdateDetailsDelta(DragUpdateDetails self) {
    throw new UnsupportedOperationException("dragUpdateDetailsDelta has no default (FFM/comm impl required)");
  }

  default int dragEndDetailsDragEndDetails(Optional<Offset> globalPosition, Optional<Offset> localPosition, Optional<Velocity> velocity, OptionalDouble primaryVelocity) {
    throw new UnsupportedOperationException("dragEndDetailsDragEndDetails has no default (FFM/comm impl required)");
  }
  default int dragEndDetailsGlobalPosition(DragEndDetails self) {
    throw new UnsupportedOperationException("dragEndDetailsGlobalPosition has no default (FFM/comm impl required)");
  }
  default int dragEndDetailsLocalPosition(DragEndDetails self) {
    throw new UnsupportedOperationException("dragEndDetailsLocalPosition has no default (FFM/comm impl required)");
  }
  default int dragEndDetailsVelocity(DragEndDetails self) {
    throw new UnsupportedOperationException("dragEndDetailsVelocity has no default (FFM/comm impl required)");
  }

  default int scaleStartDetailsScaleStartDetails(Optional<Offset> focalPoint, Optional<Offset> localFocalPoint, OptionalInt pointerCount, Optional<Duration> sourceTimeStamp, Optional<PointerDeviceKind> kind) {
    throw new UnsupportedOperationException("scaleStartDetailsScaleStartDetails has no default (FFM/comm impl required)");
  }
  default int scaleStartDetailsFocalPoint(ScaleStartDetails self) {
    throw new UnsupportedOperationException("scaleStartDetailsFocalPoint has no default (FFM/comm impl required)");
  }
  default int scaleStartDetailsLocalFocalPoint(ScaleStartDetails self) {
    throw new UnsupportedOperationException("scaleStartDetailsLocalFocalPoint has no default (FFM/comm impl required)");
  }
  default int scaleStartDetailsPointerCount(ScaleStartDetails self) {
    throw new UnsupportedOperationException("scaleStartDetailsPointerCount has no default (FFM/comm impl required)");
  }

  default int scaleUpdateDetailsScaleUpdateDetails(Optional<Offset> focalPoint, Optional<Offset> localFocalPoint, OptionalDouble scale, OptionalDouble horizontalScale, OptionalDouble verticalScale, OptionalDouble rotation, OptionalInt pointerCount, Optional<Offset> focalPointDelta, Optional<Duration> sourceTimeStamp) {
    throw new UnsupportedOperationException("scaleUpdateDetailsScaleUpdateDetails has no default (FFM/comm impl required)");
  }
  default int scaleUpdateDetailsFocalPoint(ScaleUpdateDetails self) {
    throw new UnsupportedOperationException("scaleUpdateDetailsFocalPoint has no default (FFM/comm impl required)");
  }
  default int scaleUpdateDetailsLocalFocalPoint(ScaleUpdateDetails self) {
    throw new UnsupportedOperationException("scaleUpdateDetailsLocalFocalPoint has no default (FFM/comm impl required)");
  }
  default int scaleUpdateDetailsFocalPointDelta(ScaleUpdateDetails self) {
    throw new UnsupportedOperationException("scaleUpdateDetailsFocalPointDelta has no default (FFM/comm impl required)");
  }
  default double scaleUpdateDetailsScale(ScaleUpdateDetails self) {
    throw new UnsupportedOperationException("scaleUpdateDetailsScale has no default (FFM/comm impl required)");
  }
  default double scaleUpdateDetailsHorizontalScale(ScaleUpdateDetails self) {
    throw new UnsupportedOperationException("scaleUpdateDetailsHorizontalScale has no default (FFM/comm impl required)");
  }
  default double scaleUpdateDetailsVerticalScale(ScaleUpdateDetails self) {
    throw new UnsupportedOperationException("scaleUpdateDetailsVerticalScale has no default (FFM/comm impl required)");
  }
  default double scaleUpdateDetailsRotation(ScaleUpdateDetails self) {
    throw new UnsupportedOperationException("scaleUpdateDetailsRotation has no default (FFM/comm impl required)");
  }
  default int scaleUpdateDetailsPointerCount(ScaleUpdateDetails self) {
    throw new UnsupportedOperationException("scaleUpdateDetailsPointerCount has no default (FFM/comm impl required)");
  }

  default int scaleEndDetailsScaleEndDetails(Optional<Velocity> velocity, OptionalDouble scaleVelocity, OptionalInt pointerCount) {
    throw new UnsupportedOperationException("scaleEndDetailsScaleEndDetails has no default (FFM/comm impl required)");
  }
  default int scaleEndDetailsVelocity(ScaleEndDetails self) {
    throw new UnsupportedOperationException("scaleEndDetailsVelocity has no default (FFM/comm impl required)");
  }
  default double scaleEndDetailsScaleVelocity(ScaleEndDetails self) {
    throw new UnsupportedOperationException("scaleEndDetailsScaleVelocity has no default (FFM/comm impl required)");
  }
  default int scaleEndDetailsPointerCount(ScaleEndDetails self) {
    throw new UnsupportedOperationException("scaleEndDetailsPointerCount has no default (FFM/comm impl required)");
  }

  default int forcePressDetailsForcePressDetails(Offset globalPosition, Optional<Offset> localPosition, double pressure) {
    throw new UnsupportedOperationException("forcePressDetailsForcePressDetails has no default (FFM/comm impl required)");
  }
  default int forcePressDetailsGlobalPosition(ForcePressDetails self) {
    throw new UnsupportedOperationException("forcePressDetailsGlobalPosition has no default (FFM/comm impl required)");
  }
  default int forcePressDetailsLocalPosition(ForcePressDetails self) {
    throw new UnsupportedOperationException("forcePressDetailsLocalPosition has no default (FFM/comm impl required)");
  }
  default double forcePressDetailsPressure(ForcePressDetails self) {
    throw new UnsupportedOperationException("forcePressDetailsPressure has no default (FFM/comm impl required)");
  }

  default int draggableDetailsDraggableDetails(Optional<Boolean> wasAccepted, Velocity velocity, Offset offset) {
    throw new UnsupportedOperationException("draggableDetailsDraggableDetails has no default (FFM/comm impl required)");
  }
  default int draggableDetailsWasAccepted(DraggableDetails self) {
    throw new UnsupportedOperationException("draggableDetailsWasAccepted has no default (FFM/comm impl required)");
  }
  default int draggableDetailsVelocity(DraggableDetails self) {
    throw new UnsupportedOperationException("draggableDetailsVelocity has no default (FFM/comm impl required)");
  }
  default int draggableDetailsOffset(DraggableDetails self) {
    throw new UnsupportedOperationException("draggableDetailsOffset has no default (FFM/comm impl required)");
  }

  default <T> int dragTargetDetailsDragTargetDetails(NativeObj data, Offset offset) {
    throw new UnsupportedOperationException("dragTargetDetailsDragTargetDetails has no default (FFM/comm impl required)");
  }

  default int pointerDownEventPointerDownEvent(OptionalInt viewId, Optional<Duration> timeStamp, OptionalInt pointer, Optional<PointerDeviceKind> kind, OptionalInt device, Optional<Offset> position, OptionalInt buttons, Optional<Boolean> obscured, OptionalDouble pressure, OptionalDouble pressureMin, OptionalDouble pressureMax, OptionalDouble distanceMax, OptionalDouble size, OptionalDouble radiusMajor, OptionalDouble radiusMinor, OptionalDouble radiusMin, OptionalDouble radiusMax, OptionalDouble orientation, OptionalDouble tilt, OptionalInt embedderId) {
    throw new UnsupportedOperationException("pointerDownEventPointerDownEvent has no default (FFM/comm impl required)");
  }

  default int pointerUpEventPointerUpEvent(OptionalInt viewId, Optional<Duration> timeStamp, OptionalInt pointer, Optional<PointerDeviceKind> kind, OptionalInt device, Optional<Offset> position, OptionalInt buttons, Optional<Boolean> obscured, OptionalDouble pressure, OptionalDouble pressureMin, OptionalDouble pressureMax, OptionalDouble distance, OptionalDouble distanceMax, OptionalDouble size, OptionalDouble radiusMajor, OptionalDouble radiusMinor, OptionalDouble radiusMin, OptionalDouble radiusMax, OptionalDouble orientation, OptionalDouble tilt, OptionalInt embedderId) {
    throw new UnsupportedOperationException("pointerUpEventPointerUpEvent has no default (FFM/comm impl required)");
  }

  default int pointerHoverEventPointerHoverEvent(OptionalInt viewId, Optional<Duration> timeStamp, Optional<PointerDeviceKind> kind, OptionalInt pointer, OptionalInt device, Optional<Offset> position, Optional<Offset> delta, OptionalInt buttons, Optional<Boolean> obscured, OptionalDouble pressureMin, OptionalDouble pressureMax, OptionalDouble distance, OptionalDouble distanceMax, OptionalDouble size, OptionalDouble radiusMajor, OptionalDouble radiusMinor, OptionalDouble radiusMin, OptionalDouble radiusMax, OptionalDouble orientation, OptionalDouble tilt, Optional<Boolean> synthesized, OptionalInt embedderId) {
    throw new UnsupportedOperationException("pointerHoverEventPointerHoverEvent has no default (FFM/comm impl required)");
  }

  default int cubicCubic(double a, double b, double c, double d) {
    throw new UnsupportedOperationException("cubicCubic has no default (FFM/comm impl required)");
  }
  default double Cubic_readBack_a(Object st) {
    throw new UnsupportedOperationException("Cubic_readBack_a read-back requires FFM/java22");
  }
  default double Cubic_readBack_b(Object st) {
    throw new UnsupportedOperationException("Cubic_readBack_b read-back requires FFM/java22");
  }
  default double Cubic_readBack_c(Object st) {
    throw new UnsupportedOperationException("Cubic_readBack_c read-back requires FFM/java22");
  }
  default double Cubic_readBack_d(Object st) {
    throw new UnsupportedOperationException("Cubic_readBack_d read-back requires FFM/java22");
  }

  default int threePointCubicThreePointCubic(Offset a1, Offset b1, Offset midpoint, Offset a2, Offset b2) {
    throw new UnsupportedOperationException("threePointCubicThreePointCubic has no default (FFM/comm impl required)");
  }
  default Offset ThreePointCubic_readBack_a1(Object st) {
    throw new UnsupportedOperationException("ThreePointCubic_readBack_a1 read-back requires FFM/java22");
  }
  default Offset ThreePointCubic_readBack_b1(Object st) {
    throw new UnsupportedOperationException("ThreePointCubic_readBack_b1 read-back requires FFM/java22");
  }
  default Offset ThreePointCubic_readBack_midpoint(Object st) {
    throw new UnsupportedOperationException("ThreePointCubic_readBack_midpoint read-back requires FFM/java22");
  }
  default Offset ThreePointCubic_readBack_a2(Object st) {
    throw new UnsupportedOperationException("ThreePointCubic_readBack_a2 read-back requires FFM/java22");
  }
  default Offset ThreePointCubic_readBack_b2(Object st) {
    throw new UnsupportedOperationException("ThreePointCubic_readBack_b2 read-back requires FFM/java22");
  }

  default int elasticOutCurveElasticOutCurve(OptionalDouble period) {
    throw new UnsupportedOperationException("elasticOutCurveElasticOutCurve has no default (FFM/comm impl required)");
  }
  default double ElasticOutCurve_readBack_period(Object st) {
    throw new UnsupportedOperationException("ElasticOutCurve_readBack_period read-back requires FFM/java22");
  }

  default int elasticInCurveElasticInCurve(OptionalDouble period) {
    throw new UnsupportedOperationException("elasticInCurveElasticInCurve has no default (FFM/comm impl required)");
  }
  default double ElasticInCurve_readBack_period(Object st) {
    throw new UnsupportedOperationException("ElasticInCurve_readBack_period read-back requires FFM/java22");
  }

  default int elasticInOutCurveElasticInOutCurve(OptionalDouble period) {
    throw new UnsupportedOperationException("elasticInOutCurveElasticInOutCurve has no default (FFM/comm impl required)");
  }
  default double ElasticInOutCurve_readBack_period(Object st) {
    throw new UnsupportedOperationException("ElasticInOutCurve_readBack_period read-back requires FFM/java22");
  }

  default int curvesLinear() {
    throw new UnsupportedOperationException("curvesLinear has no default (FFM/comm impl required)");
  }
  default int curvesDecelerate() {
    throw new UnsupportedOperationException("curvesDecelerate has no default (FFM/comm impl required)");
  }
  default int curvesBounceIn() {
    throw new UnsupportedOperationException("curvesBounceIn has no default (FFM/comm impl required)");
  }
  default int curvesBounceOut() {
    throw new UnsupportedOperationException("curvesBounceOut has no default (FFM/comm impl required)");
  }
  default int curvesBounceInOut() {
    throw new UnsupportedOperationException("curvesBounceInOut has no default (FFM/comm impl required)");
  }

  default int curvedAnimationCurvedAnimation(Animation parent, Curve curve, Optional<Curve> reverseCurve) {
    throw new UnsupportedOperationException("curvedAnimationCurvedAnimation has no default (FFM/comm impl required)");
  }

  default int sizedBoxSizedBox(OptionalDouble width, OptionalDouble height, Optional<Widget> child) {
    throw new UnsupportedOperationException("sizedBoxSizedBox has no default (FFM/comm impl required)");
  }
  default int sizedBoxExpand(Optional<Widget> child) {
    throw new UnsupportedOperationException("sizedBoxExpand has no default (FFM/comm impl required)");
  }
  default int sizedBoxShrink(Optional<Widget> child) {
    throw new UnsupportedOperationException("sizedBoxShrink has no default (FFM/comm impl required)");
  }
  default int sizedBoxFromSize(Optional<Widget> child) {
    throw new UnsupportedOperationException("sizedBoxFromSize has no default (FFM/comm impl required)");
  }
  default int sizedBoxSquare(Optional<Widget> child, OptionalDouble dimension) {
    throw new UnsupportedOperationException("sizedBoxSquare has no default (FFM/comm impl required)");
  }
  default double SizedBox_readBack_width(Object st) {
    throw new UnsupportedOperationException("SizedBox_readBack_width read-back requires FFM/java22");
  }
  default double SizedBox_readBack_height(Object st) {
    throw new UnsupportedOperationException("SizedBox_readBack_height read-back requires FFM/java22");
  }

  default int alignmentAlignment(double x, double y) {
    throw new UnsupportedOperationException("alignmentAlignment has no default (FFM/comm impl required)");
  }
  default int alignmentLerp(Alignment a, Alignment b, double t) {
    throw new UnsupportedOperationException("alignmentLerp has no default (FFM/comm impl required)");
  }
  default double Alignment_readBack_x(Object st) {
    throw new UnsupportedOperationException("Alignment_readBack_x read-back requires FFM/java22");
  }
  default double Alignment_readBack_y(Object st) {
    throw new UnsupportedOperationException("Alignment_readBack_y read-back requires FFM/java22");
  }

  default int alignmentDirectionalAlignmentDirectional(double start, double y) {
    throw new UnsupportedOperationException("alignmentDirectionalAlignmentDirectional has no default (FFM/comm impl required)");
  }
  default int alignmentDirectionalLerp(AlignmentDirectional a, AlignmentDirectional b, double t) {
    throw new UnsupportedOperationException("alignmentDirectionalLerp has no default (FFM/comm impl required)");
  }
  default double AlignmentDirectional_readBack_start(Object st) {
    throw new UnsupportedOperationException("AlignmentDirectional_readBack_start read-back requires FFM/java22");
  }
  default double AlignmentDirectional_readBack_y(Object st) {
    throw new UnsupportedOperationException("AlignmentDirectional_readBack_y read-back requires FFM/java22");
  }

  default int mouseRegionMouseRegion(Optional<Consumer<PointerEnterEvent>> onEnter, Optional<Consumer<PointerExitEvent>> onExit, Optional<Consumer<PointerHoverEvent>> onHover, Optional<Boolean> opaque, Optional<HitTestBehavior> hitTestBehavior, Optional<Widget> child) {
    throw new UnsupportedOperationException("mouseRegionMouseRegion has no default (FFM/comm impl required)");
  }
  default boolean MouseRegion_readBack_opaque(Object st) {
    throw new UnsupportedOperationException("MouseRegion_readBack_opaque read-back requires FFM/java22");
  }
  default HitTestBehavior MouseRegion_readBack_hitTestBehavior(Object st) {
    throw new UnsupportedOperationException("MouseRegion_readBack_hitTestBehavior read-back requires FFM/java22");
  }

  default int expandedExpanded(OptionalInt flex, Widget child) {
    throw new UnsupportedOperationException("expandedExpanded has no default (FFM/comm impl required)");
  }

  default int flexibleFlexible(OptionalInt flex, Optional<FlexFit> fit, Widget child) {
    throw new UnsupportedOperationException("flexibleFlexible has no default (FFM/comm impl required)");
  }
  default int Flexible_readBack_flex(Object st) {
    throw new UnsupportedOperationException("Flexible_readBack_flex read-back requires FFM/java22");
  }
  default FlexFit Flexible_readBack_fit(Object st) {
    throw new UnsupportedOperationException("Flexible_readBack_fit read-back requires FFM/java22");
  }

  default int safeAreaSafeArea(Optional<Boolean> left, Optional<Boolean> top, Optional<Boolean> right, Optional<Boolean> bottom, Optional<EdgeInsets> minimum, Optional<Boolean> maintainBottomViewPadding, Widget child) {
    throw new UnsupportedOperationException("safeAreaSafeArea has no default (FFM/comm impl required)");
  }
  default boolean SafeArea_readBack_left(Object st) {
    throw new UnsupportedOperationException("SafeArea_readBack_left read-back requires FFM/java22");
  }
  default boolean SafeArea_readBack_top(Object st) {
    throw new UnsupportedOperationException("SafeArea_readBack_top read-back requires FFM/java22");
  }
  default boolean SafeArea_readBack_right(Object st) {
    throw new UnsupportedOperationException("SafeArea_readBack_right read-back requires FFM/java22");
  }
  default boolean SafeArea_readBack_bottom(Object st) {
    throw new UnsupportedOperationException("SafeArea_readBack_bottom read-back requires FFM/java22");
  }
  default EdgeInsets SafeArea_readBack_minimum(Object st) {
    throw new UnsupportedOperationException("SafeArea_readBack_minimum read-back requires FFM/java22");
  }
  default boolean SafeArea_readBack_maintainBottomViewPadding(Object st) {
    throw new UnsupportedOperationException("SafeArea_readBack_maintainBottomViewPadding read-back requires FFM/java22");
  }
  default Widget SafeArea_readBack_child(Object st) {
    throw new UnsupportedOperationException("SafeArea_readBack_child read-back requires FFM/java22");
  }

  default Alignment MatrixTransition_readBack_alignment(Object st) {
    throw new UnsupportedOperationException("MatrixTransition_readBack_alignment read-back requires FFM/java22");
  }
  default FilterQuality MatrixTransition_readBack_filterQuality(Object st) {
    throw new UnsupportedOperationException("MatrixTransition_readBack_filterQuality read-back requires FFM/java22");
  }
  default Widget MatrixTransition_readBack_child(Object st) {
    throw new UnsupportedOperationException("MatrixTransition_readBack_child read-back requires FFM/java22");
  }
  default Animation MatrixTransition_readBack_animation(Object st) {
    throw new UnsupportedOperationException("MatrixTransition_readBack_animation read-back requires FFM/java22");
  }

  default int rotationTransitionRotationTransition(Animation turns, Optional<Alignment> alignment, Optional<FilterQuality> filterQuality, Optional<Widget> child) {
    throw new UnsupportedOperationException("rotationTransitionRotationTransition has no default (FFM/comm impl required)");
  }
  default Animation RotationTransition_readBack_turns(Object st) {
    throw new UnsupportedOperationException("RotationTransition_readBack_turns read-back requires FFM/java22");
  }

  default int fadeTransitionFadeTransition(Animation opacity, Optional<Boolean> alwaysIncludeSemantics, Optional<Widget> child) {
    throw new UnsupportedOperationException("fadeTransitionFadeTransition has no default (FFM/comm impl required)");
  }
  default Animation FadeTransition_readBack_opacity(Object st) {
    throw new UnsupportedOperationException("FadeTransition_readBack_opacity read-back requires FFM/java22");
  }
  default boolean FadeTransition_readBack_alwaysIncludeSemantics(Object st) {
    throw new UnsupportedOperationException("FadeTransition_readBack_alwaysIncludeSemantics read-back requires FFM/java22");
  }

  default int scaleTransitionScaleTransition(Animation scale, Optional<Alignment> alignment, Optional<FilterQuality> filterQuality, Optional<Widget> child) {
    throw new UnsupportedOperationException("scaleTransitionScaleTransition has no default (FFM/comm impl required)");
  }
  default Animation ScaleTransition_readBack_scale(Object st) {
    throw new UnsupportedOperationException("ScaleTransition_readBack_scale read-back requires FFM/java22");
  }

  default int aspectRatioAspectRatio(double aspectRatio, Optional<Widget> child) {
    throw new UnsupportedOperationException("aspectRatioAspectRatio has no default (FFM/comm impl required)");
  }
  default double AspectRatio_readBack_aspectRatio(Object st) {
    throw new UnsupportedOperationException("AspectRatio_readBack_aspectRatio read-back requires FFM/java22");
  }

  default int clipOvalClipOval(Optional<Clip> clipBehavior, Optional<Widget> child) {
    throw new UnsupportedOperationException("clipOvalClipOval has no default (FFM/comm impl required)");
  }
  default Clip ClipOval_readBack_clipBehavior(Object st) {
    throw new UnsupportedOperationException("ClipOval_readBack_clipBehavior read-back requires FFM/java22");
  }

  default int clipRRectClipRRect(Optional<BorderRadiusGeometry> borderRadius, Optional<Clip> clipBehavior, Optional<Widget> child) {
    throw new UnsupportedOperationException("clipRRectClipRRect has no default (FFM/comm impl required)");
  }
  default BorderRadiusGeometry ClipRRect_readBack_borderRadius(Object st) {
    throw new UnsupportedOperationException("ClipRRect_readBack_borderRadius read-back requires FFM/java22");
  }
  default Clip ClipRRect_readBack_clipBehavior(Object st) {
    throw new UnsupportedOperationException("ClipRRect_readBack_clipBehavior read-back requires FFM/java22");
  }

  default int clipRectClipRect(Optional<Clip> clipBehavior, Optional<Widget> child) {
    throw new UnsupportedOperationException("clipRectClipRect has no default (FFM/comm impl required)");
  }
  default Clip ClipRect_readBack_clipBehavior(Object st) {
    throw new UnsupportedOperationException("ClipRect_readBack_clipBehavior read-back requires FFM/java22");
  }

  default int clipRSuperellipseClipRSuperellipse(Optional<BorderRadiusGeometry> borderRadius, Optional<Clip> clipBehavior, Optional<Widget> child) {
    throw new UnsupportedOperationException("clipRSuperellipseClipRSuperellipse has no default (FFM/comm impl required)");
  }
  default BorderRadiusGeometry ClipRSuperellipse_readBack_borderRadius(Object st) {
    throw new UnsupportedOperationException("ClipRSuperellipse_readBack_borderRadius read-back requires FFM/java22");
  }
  default Clip ClipRSuperellipse_readBack_clipBehavior(Object st) {
    throw new UnsupportedOperationException("ClipRSuperellipse_readBack_clipBehavior read-back requires FFM/java22");
  }

  default int coloredBoxColoredBox(Color color, Optional<Boolean> isAntiAlias, Optional<Widget> child) {
    throw new UnsupportedOperationException("coloredBoxColoredBox has no default (FFM/comm impl required)");
  }
  default Color ColoredBox_readBack_color(Object st) {
    throw new UnsupportedOperationException("ColoredBox_readBack_color read-back requires FFM/java22");
  }
  default boolean ColoredBox_readBack_isAntiAlias(Object st) {
    throw new UnsupportedOperationException("ColoredBox_readBack_isAntiAlias read-back requires FFM/java22");
  }

  default int constrainedBoxConstrainedBox(BoxConstraints constraints, Optional<Widget> child) {
    throw new UnsupportedOperationException("constrainedBoxConstrainedBox has no default (FFM/comm impl required)");
  }
  default BoxConstraints ConstrainedBox_readBack_constraints(Object st) {
    throw new UnsupportedOperationException("ConstrainedBox_readBack_constraints read-back requires FFM/java22");
  }

  default int decoratedBoxDecoratedBox(Decoration decoration, Optional<DecorationPosition> position, Optional<Widget> child) {
    throw new UnsupportedOperationException("decoratedBoxDecoratedBox has no default (FFM/comm impl required)");
  }
  default Decoration DecoratedBox_readBack_decoration(Object st) {
    throw new UnsupportedOperationException("DecoratedBox_readBack_decoration read-back requires FFM/java22");
  }
  default DecorationPosition DecoratedBox_readBack_position(Object st) {
    throw new UnsupportedOperationException("DecoratedBox_readBack_position read-back requires FFM/java22");
  }

  default int fittedBoxFittedBox(Optional<BoxFit> fit, Optional<AlignmentGeometry> alignment, Optional<Clip> clipBehavior, Optional<Widget> child) {
    throw new UnsupportedOperationException("fittedBoxFittedBox has no default (FFM/comm impl required)");
  }
  default BoxFit FittedBox_readBack_fit(Object st) {
    throw new UnsupportedOperationException("FittedBox_readBack_fit read-back requires FFM/java22");
  }
  default AlignmentGeometry FittedBox_readBack_alignment(Object st) {
    throw new UnsupportedOperationException("FittedBox_readBack_alignment read-back requires FFM/java22");
  }
  default Clip FittedBox_readBack_clipBehavior(Object st) {
    throw new UnsupportedOperationException("FittedBox_readBack_clipBehavior read-back requires FFM/java22");
  }

  default int fractionallySizedBoxFractionallySizedBox(Optional<AlignmentGeometry> alignment, OptionalDouble widthFactor, OptionalDouble heightFactor, Optional<Widget> child) {
    throw new UnsupportedOperationException("fractionallySizedBoxFractionallySizedBox has no default (FFM/comm impl required)");
  }
  default double FractionallySizedBox_readBack_widthFactor(Object st) {
    throw new UnsupportedOperationException("FractionallySizedBox_readBack_widthFactor read-back requires FFM/java22");
  }
  default double FractionallySizedBox_readBack_heightFactor(Object st) {
    throw new UnsupportedOperationException("FractionallySizedBox_readBack_heightFactor read-back requires FFM/java22");
  }
  default AlignmentGeometry FractionallySizedBox_readBack_alignment(Object st) {
    throw new UnsupportedOperationException("FractionallySizedBox_readBack_alignment read-back requires FFM/java22");
  }

  default int intrinsicHeightIntrinsicHeight(Optional<Widget> child) {
    throw new UnsupportedOperationException("intrinsicHeightIntrinsicHeight has no default (FFM/comm impl required)");
  }

  default int intrinsicWidthIntrinsicWidth(OptionalDouble stepWidth, OptionalDouble stepHeight, Optional<Widget> child) {
    throw new UnsupportedOperationException("intrinsicWidthIntrinsicWidth has no default (FFM/comm impl required)");
  }
  default double IntrinsicWidth_readBack_stepWidth(Object st) {
    throw new UnsupportedOperationException("IntrinsicWidth_readBack_stepWidth read-back requires FFM/java22");
  }
  default double IntrinsicWidth_readBack_stepHeight(Object st) {
    throw new UnsupportedOperationException("IntrinsicWidth_readBack_stepHeight read-back requires FFM/java22");
  }

  default int limitedBoxLimitedBox(OptionalDouble maxWidth, OptionalDouble maxHeight, Optional<Widget> child) {
    throw new UnsupportedOperationException("limitedBoxLimitedBox has no default (FFM/comm impl required)");
  }
  default double LimitedBox_readBack_maxWidth(Object st) {
    throw new UnsupportedOperationException("LimitedBox_readBack_maxWidth read-back requires FFM/java22");
  }
  default double LimitedBox_readBack_maxHeight(Object st) {
    throw new UnsupportedOperationException("LimitedBox_readBack_maxHeight read-back requires FFM/java22");
  }

  default int placeholderPlaceholder(Optional<Color> color, OptionalDouble strokeWidth, OptionalDouble fallbackWidth, OptionalDouble fallbackHeight, Optional<Widget> child) {
    throw new UnsupportedOperationException("placeholderPlaceholder has no default (FFM/comm impl required)");
  }
  default Color Placeholder_readBack_color(Object st) {
    throw new UnsupportedOperationException("Placeholder_readBack_color read-back requires FFM/java22");
  }
  default double Placeholder_readBack_strokeWidth(Object st) {
    throw new UnsupportedOperationException("Placeholder_readBack_strokeWidth read-back requires FFM/java22");
  }
  default double Placeholder_readBack_fallbackWidth(Object st) {
    throw new UnsupportedOperationException("Placeholder_readBack_fallbackWidth read-back requires FFM/java22");
  }
  default double Placeholder_readBack_fallbackHeight(Object st) {
    throw new UnsupportedOperationException("Placeholder_readBack_fallbackHeight read-back requires FFM/java22");
  }
  default Widget Placeholder_readBack_child(Object st) {
    throw new UnsupportedOperationException("Placeholder_readBack_child read-back requires FFM/java22");
  }

  default int spacerSpacer(OptionalInt flex) {
    throw new UnsupportedOperationException("spacerSpacer has no default (FFM/comm impl required)");
  }
  default int Spacer_readBack_flex(Object st) {
    throw new UnsupportedOperationException("Spacer_readBack_flex read-back requires FFM/java22");
  }

  default int visibilityVisibility(Widget child, Optional<Widget> replacement, Optional<Boolean> visible, Optional<Boolean> maintainState, Optional<Boolean> maintainAnimation, Optional<Boolean> maintainSize, Optional<Boolean> maintainSemantics, Optional<Boolean> maintainInteractivity, Optional<Boolean> maintainFocusability) {
    throw new UnsupportedOperationException("visibilityVisibility has no default (FFM/comm impl required)");
  }
  default int visibilityMaintain(Widget child, Optional<Boolean> visible) {
    throw new UnsupportedOperationException("visibilityMaintain has no default (FFM/comm impl required)");
  }
  default int visibilityOf(BuildContext context) {
    throw new UnsupportedOperationException("visibilityOf has no default (FFM/comm impl required)");
  }
  default Widget Visibility_readBack_child(Object st) {
    throw new UnsupportedOperationException("Visibility_readBack_child read-back requires FFM/java22");
  }
  default Widget Visibility_readBack_replacement(Object st) {
    throw new UnsupportedOperationException("Visibility_readBack_replacement read-back requires FFM/java22");
  }
  default boolean Visibility_readBack_visible(Object st) {
    throw new UnsupportedOperationException("Visibility_readBack_visible read-back requires FFM/java22");
  }
  default boolean Visibility_readBack_maintainState(Object st) {
    throw new UnsupportedOperationException("Visibility_readBack_maintainState read-back requires FFM/java22");
  }
  default boolean Visibility_readBack_maintainAnimation(Object st) {
    throw new UnsupportedOperationException("Visibility_readBack_maintainAnimation read-back requires FFM/java22");
  }
  default boolean Visibility_readBack_maintainSize(Object st) {
    throw new UnsupportedOperationException("Visibility_readBack_maintainSize read-back requires FFM/java22");
  }
  default boolean Visibility_readBack_maintainSemantics(Object st) {
    throw new UnsupportedOperationException("Visibility_readBack_maintainSemantics read-back requires FFM/java22");
  }
  default boolean Visibility_readBack_maintainInteractivity(Object st) {
    throw new UnsupportedOperationException("Visibility_readBack_maintainInteractivity read-back requires FFM/java22");
  }
  default boolean Visibility_readBack_maintainFocusability(Object st) {
    throw new UnsupportedOperationException("Visibility_readBack_maintainFocusability read-back requires FFM/java22");
  }

  default int rotatedBoxRotatedBox(int quarterTurns, Optional<Widget> child) {
    throw new UnsupportedOperationException("rotatedBoxRotatedBox has no default (FFM/comm impl required)");
  }
  default int RotatedBox_readBack_quarterTurns(Object st) {
    throw new UnsupportedOperationException("RotatedBox_readBack_quarterTurns read-back requires FFM/java22");
  }

  default int baselineBaseline(double baseline, TextBaseline baselineType, Optional<Widget> child) {
    throw new UnsupportedOperationException("baselineBaseline has no default (FFM/comm impl required)");
  }
  default double Baseline_readBack_baseline(Object st) {
    throw new UnsupportedOperationException("Baseline_readBack_baseline read-back requires FFM/java22");
  }
  default TextBaseline Baseline_readBack_baselineType(Object st) {
    throw new UnsupportedOperationException("Baseline_readBack_baselineType read-back requires FFM/java22");
  }

  default int defaultTextStyleDefaultTextStyle(TextStyle style, Optional<TextAlign> textAlign, Optional<Boolean> softWrap, Optional<TextOverflow> overflow, OptionalInt maxLines, Optional<TextWidthBasis> textWidthBasis, Widget child) {
    throw new UnsupportedOperationException("defaultTextStyleDefaultTextStyle has no default (FFM/comm impl required)");
  }
  default int defaultTextStyleFallback() {
    throw new UnsupportedOperationException("defaultTextStyleFallback has no default (FFM/comm impl required)");
  }
  default int defaultTextStyleMerge(Optional<TextStyle> style, Optional<TextAlign> textAlign, Optional<Boolean> softWrap, Optional<TextOverflow> overflow, OptionalInt maxLines, Optional<TextWidthBasis> textWidthBasis, Widget child) {
    throw new UnsupportedOperationException("defaultTextStyleMerge has no default (FFM/comm impl required)");
  }
  default int defaultTextStyleOf(BuildContext context) {
    throw new UnsupportedOperationException("defaultTextStyleOf has no default (FFM/comm impl required)");
  }
  default TextStyle DefaultTextStyle_readBack_style(Object st) {
    throw new UnsupportedOperationException("DefaultTextStyle_readBack_style read-back requires FFM/java22");
  }
  default TextAlign DefaultTextStyle_readBack_textAlign(Object st) {
    throw new UnsupportedOperationException("DefaultTextStyle_readBack_textAlign read-back requires FFM/java22");
  }
  default boolean DefaultTextStyle_readBack_softWrap(Object st) {
    throw new UnsupportedOperationException("DefaultTextStyle_readBack_softWrap read-back requires FFM/java22");
  }
  default TextOverflow DefaultTextStyle_readBack_overflow(Object st) {
    throw new UnsupportedOperationException("DefaultTextStyle_readBack_overflow read-back requires FFM/java22");
  }
  default int DefaultTextStyle_readBack_maxLines(Object st) {
    throw new UnsupportedOperationException("DefaultTextStyle_readBack_maxLines read-back requires FFM/java22");
  }
  default TextWidthBasis DefaultTextStyle_readBack_textWidthBasis(Object st) {
    throw new UnsupportedOperationException("DefaultTextStyle_readBack_textWidthBasis read-back requires FFM/java22");
  }

  default int directionalityDirectionality(TextDirection textDirection, Widget child) {
    throw new UnsupportedOperationException("directionalityDirectionality has no default (FFM/comm impl required)");
  }
  default int directionalityOf(BuildContext context) {
    throw new UnsupportedOperationException("directionalityOf has no default (FFM/comm impl required)");
  }
  default int directionalityMaybeOf(BuildContext context) {
    throw new UnsupportedOperationException("directionalityMaybeOf has no default (FFM/comm impl required)");
  }
  default TextDirection Directionality_readBack_textDirection(Object st) {
    throw new UnsupportedOperationException("Directionality_readBack_textDirection read-back requires FFM/java22");
  }

  default int overflowBoxOverflowBox(Optional<AlignmentGeometry> alignment, OptionalDouble minWidth, OptionalDouble maxWidth, OptionalDouble minHeight, OptionalDouble maxHeight, Optional<OverflowBoxFit> fit, Optional<Widget> child) {
    throw new UnsupportedOperationException("overflowBoxOverflowBox has no default (FFM/comm impl required)");
  }
  default AlignmentGeometry OverflowBox_readBack_alignment(Object st) {
    throw new UnsupportedOperationException("OverflowBox_readBack_alignment read-back requires FFM/java22");
  }
  default double OverflowBox_readBack_minWidth(Object st) {
    throw new UnsupportedOperationException("OverflowBox_readBack_minWidth read-back requires FFM/java22");
  }
  default double OverflowBox_readBack_maxWidth(Object st) {
    throw new UnsupportedOperationException("OverflowBox_readBack_maxWidth read-back requires FFM/java22");
  }
  default double OverflowBox_readBack_minHeight(Object st) {
    throw new UnsupportedOperationException("OverflowBox_readBack_minHeight read-back requires FFM/java22");
  }
  default double OverflowBox_readBack_maxHeight(Object st) {
    throw new UnsupportedOperationException("OverflowBox_readBack_maxHeight read-back requires FFM/java22");
  }
  default OverflowBoxFit OverflowBox_readBack_fit(Object st) {
    throw new UnsupportedOperationException("OverflowBox_readBack_fit read-back requires FFM/java22");
  }

  default int absorbPointerAbsorbPointer(Optional<Boolean> absorbing, Optional<Boolean> ignoringSemantics, Optional<Widget> child) {
    throw new UnsupportedOperationException("absorbPointerAbsorbPointer has no default (FFM/comm impl required)");
  }
  default boolean AbsorbPointer_readBack_absorbing(Object st) {
    throw new UnsupportedOperationException("AbsorbPointer_readBack_absorbing read-back requires FFM/java22");
  }
  default boolean AbsorbPointer_readBack_ignoringSemantics(Object st) {
    throw new UnsupportedOperationException("AbsorbPointer_readBack_ignoringSemantics read-back requires FFM/java22");
  }

  default int ignorePointerIgnorePointer(Optional<Boolean> ignoring, Optional<Boolean> ignoringSemantics, Optional<Widget> child) {
    throw new UnsupportedOperationException("ignorePointerIgnorePointer has no default (FFM/comm impl required)");
  }
  default boolean IgnorePointer_readBack_ignoring(Object st) {
    throw new UnsupportedOperationException("IgnorePointer_readBack_ignoring read-back requires FFM/java22");
  }
  default boolean IgnorePointer_readBack_ignoringSemantics(Object st) {
    throw new UnsupportedOperationException("IgnorePointer_readBack_ignoringSemantics read-back requires FFM/java22");
  }

  default int repaintBoundaryRepaintBoundary(Optional<Widget> child) {
    throw new UnsupportedOperationException("repaintBoundaryRepaintBoundary has no default (FFM/comm impl required)");
  }
  default int repaintBoundaryWrap(Widget child, int childIndex) {
    throw new UnsupportedOperationException("repaintBoundaryWrap has no default (FFM/comm impl required)");
  }

  default int fractionalTranslationFractionalTranslation(Offset translation, Optional<Boolean> transformHitTests, Optional<Widget> child) {
    throw new UnsupportedOperationException("fractionalTranslationFractionalTranslation has no default (FFM/comm impl required)");
  }
  default Offset FractionalTranslation_readBack_translation(Object st) {
    throw new UnsupportedOperationException("FractionalTranslation_readBack_translation read-back requires FFM/java22");
  }
  default boolean FractionalTranslation_readBack_transformHitTests(Object st) {
    throw new UnsupportedOperationException("FractionalTranslation_readBack_transformHitTests read-back requires FFM/java22");
  }

  default int unconstrainedBoxUnconstrainedBox(Optional<Widget> child, Optional<TextDirection> textDirection, Optional<AlignmentGeometry> alignment, Optional<Axis> constrainedAxis, Optional<Clip> clipBehavior) {
    throw new UnsupportedOperationException("unconstrainedBoxUnconstrainedBox has no default (FFM/comm impl required)");
  }
  default TextDirection UnconstrainedBox_readBack_textDirection(Object st) {
    throw new UnsupportedOperationException("UnconstrainedBox_readBack_textDirection read-back requires FFM/java22");
  }
  default AlignmentGeometry UnconstrainedBox_readBack_alignment(Object st) {
    throw new UnsupportedOperationException("UnconstrainedBox_readBack_alignment read-back requires FFM/java22");
  }
  default Axis UnconstrainedBox_readBack_constrainedAxis(Object st) {
    throw new UnsupportedOperationException("UnconstrainedBox_readBack_constrainedAxis read-back requires FFM/java22");
  }
  default Clip UnconstrainedBox_readBack_clipBehavior(Object st) {
    throw new UnsupportedOperationException("UnconstrainedBox_readBack_clipBehavior read-back requires FFM/java22");
  }
  default Widget UnconstrainedBox_readBack_child(Object st) {
    throw new UnsupportedOperationException("UnconstrainedBox_readBack_child read-back requires FFM/java22");
  }

  default int flutterLogoFlutterLogo(OptionalDouble size, Optional<Color> textColor, Optional<FlutterLogoStyle> style, Optional<Duration> duration, Optional<Curve> curve) {
    throw new UnsupportedOperationException("flutterLogoFlutterLogo has no default (FFM/comm impl required)");
  }
  default double FlutterLogo_readBack_size(Object st) {
    throw new UnsupportedOperationException("FlutterLogo_readBack_size read-back requires FFM/java22");
  }
  default Color FlutterLogo_readBack_textColor(Object st) {
    throw new UnsupportedOperationException("FlutterLogo_readBack_textColor read-back requires FFM/java22");
  }
  default FlutterLogoStyle FlutterLogo_readBack_style(Object st) {
    throw new UnsupportedOperationException("FlutterLogo_readBack_style read-back requires FFM/java22");
  }
  default Duration FlutterLogo_readBack_duration(Object st) {
    throw new UnsupportedOperationException("FlutterLogo_readBack_duration read-back requires FFM/java22");
  }
  default Curve FlutterLogo_readBack_curve(Object st) {
    throw new UnsupportedOperationException("FlutterLogo_readBack_curve read-back requires FFM/java22");
  }

  default int physicalModelPhysicalModel(Optional<BoxShape> shape, Optional<Clip> clipBehavior, Optional<BorderRadius> borderRadius, OptionalDouble elevation, Color color, Optional<Color> shadowColor, Optional<Widget> child) {
    throw new UnsupportedOperationException("physicalModelPhysicalModel has no default (FFM/comm impl required)");
  }
  default BoxShape PhysicalModel_readBack_shape(Object st) {
    throw new UnsupportedOperationException("PhysicalModel_readBack_shape read-back requires FFM/java22");
  }
  default Clip PhysicalModel_readBack_clipBehavior(Object st) {
    throw new UnsupportedOperationException("PhysicalModel_readBack_clipBehavior read-back requires FFM/java22");
  }
  default BorderRadius PhysicalModel_readBack_borderRadius(Object st) {
    throw new UnsupportedOperationException("PhysicalModel_readBack_borderRadius read-back requires FFM/java22");
  }
  default double PhysicalModel_readBack_elevation(Object st) {
    throw new UnsupportedOperationException("PhysicalModel_readBack_elevation read-back requires FFM/java22");
  }
  default Color PhysicalModel_readBack_color(Object st) {
    throw new UnsupportedOperationException("PhysicalModel_readBack_color read-back requires FFM/java22");
  }
  default Color PhysicalModel_readBack_shadowColor(Object st) {
    throw new UnsupportedOperationException("PhysicalModel_readBack_shadowColor read-back requires FFM/java22");
  }

  default int bannerBanner(Optional<Widget> child, String message, Optional<TextDirection> textDirection, BannerLocation location, Optional<TextDirection> layoutDirection, Optional<Color> color, Optional<BoxShadow> shadow) {
    throw new UnsupportedOperationException("bannerBanner has no default (FFM/comm impl required)");
  }
  default Widget Banner_readBack_child(Object st) {
    throw new UnsupportedOperationException("Banner_readBack_child read-back requires FFM/java22");
  }
  default String Banner_readBack_message(Object st) {
    throw new UnsupportedOperationException("Banner_readBack_message read-back requires FFM/java22");
  }
  default TextDirection Banner_readBack_textDirection(Object st) {
    throw new UnsupportedOperationException("Banner_readBack_textDirection read-back requires FFM/java22");
  }
  default BannerLocation Banner_readBack_location(Object st) {
    throw new UnsupportedOperationException("Banner_readBack_location read-back requires FFM/java22");
  }
  default TextDirection Banner_readBack_layoutDirection(Object st) {
    throw new UnsupportedOperationException("Banner_readBack_layoutDirection read-back requires FFM/java22");
  }
  default Color Banner_readBack_color(Object st) {
    throw new UnsupportedOperationException("Banner_readBack_color read-back requires FFM/java22");
  }
  default TextStyle Banner_readBack_textStyle(Object st) {
    throw new UnsupportedOperationException("Banner_readBack_textStyle read-back requires FFM/java22");
  }
  default BoxShadow Banner_readBack_shadow(Object st) {
    throw new UnsupportedOperationException("Banner_readBack_shadow read-back requires FFM/java22");
  }

  default int animatedContainerAnimatedContainer(Optional<AlignmentGeometry> alignment, Optional<EdgeInsetsGeometry> padding, Optional<Color> color, Optional<Decoration> decoration, Optional<Decoration> foregroundDecoration, OptionalDouble width, OptionalDouble height, Optional<BoxConstraints> constraints, Optional<EdgeInsetsGeometry> margin, Optional<AlignmentGeometry> transformAlignment, Optional<Widget> child, Optional<Clip> clipBehavior, Optional<Curve> curve, Duration duration, Optional<Runnable> onEnd) {
    throw new UnsupportedOperationException("animatedContainerAnimatedContainer has no default (FFM/comm impl required)");
  }
  default Widget AnimatedContainer_readBack_child(Object st) {
    throw new UnsupportedOperationException("AnimatedContainer_readBack_child read-back requires FFM/java22");
  }
  default AlignmentGeometry AnimatedContainer_readBack_alignment(Object st) {
    throw new UnsupportedOperationException("AnimatedContainer_readBack_alignment read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry AnimatedContainer_readBack_padding(Object st) {
    throw new UnsupportedOperationException("AnimatedContainer_readBack_padding read-back requires FFM/java22");
  }
  default Decoration AnimatedContainer_readBack_decoration(Object st) {
    throw new UnsupportedOperationException("AnimatedContainer_readBack_decoration read-back requires FFM/java22");
  }
  default Decoration AnimatedContainer_readBack_foregroundDecoration(Object st) {
    throw new UnsupportedOperationException("AnimatedContainer_readBack_foregroundDecoration read-back requires FFM/java22");
  }
  default BoxConstraints AnimatedContainer_readBack_constraints(Object st) {
    throw new UnsupportedOperationException("AnimatedContainer_readBack_constraints read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry AnimatedContainer_readBack_margin(Object st) {
    throw new UnsupportedOperationException("AnimatedContainer_readBack_margin read-back requires FFM/java22");
  }
  default AlignmentGeometry AnimatedContainer_readBack_transformAlignment(Object st) {
    throw new UnsupportedOperationException("AnimatedContainer_readBack_transformAlignment read-back requires FFM/java22");
  }
  default Clip AnimatedContainer_readBack_clipBehavior(Object st) {
    throw new UnsupportedOperationException("AnimatedContainer_readBack_clipBehavior read-back requires FFM/java22");
  }

  default int animatedOpacityAnimatedOpacity(Optional<Widget> child, double opacity, Optional<Curve> curve, Duration duration, Optional<Runnable> onEnd, Optional<Boolean> alwaysIncludeSemantics) {
    throw new UnsupportedOperationException("animatedOpacityAnimatedOpacity has no default (FFM/comm impl required)");
  }
  default Widget AnimatedOpacity_readBack_child(Object st) {
    throw new UnsupportedOperationException("AnimatedOpacity_readBack_child read-back requires FFM/java22");
  }
  default double AnimatedOpacity_readBack_opacity(Object st) {
    throw new UnsupportedOperationException("AnimatedOpacity_readBack_opacity read-back requires FFM/java22");
  }
  default boolean AnimatedOpacity_readBack_alwaysIncludeSemantics(Object st) {
    throw new UnsupportedOperationException("AnimatedOpacity_readBack_alwaysIncludeSemantics read-back requires FFM/java22");
  }

  default int animatedPaddingAnimatedPadding(EdgeInsetsGeometry padding, Optional<Widget> child, Optional<Curve> curve, Duration duration, Optional<Runnable> onEnd) {
    throw new UnsupportedOperationException("animatedPaddingAnimatedPadding has no default (FFM/comm impl required)");
  }
  default EdgeInsetsGeometry AnimatedPadding_readBack_padding(Object st) {
    throw new UnsupportedOperationException("AnimatedPadding_readBack_padding read-back requires FFM/java22");
  }
  default Widget AnimatedPadding_readBack_child(Object st) {
    throw new UnsupportedOperationException("AnimatedPadding_readBack_child read-back requires FFM/java22");
  }

  default int animatedAlignAnimatedAlign(AlignmentGeometry alignment, Optional<Widget> child, OptionalDouble heightFactor, OptionalDouble widthFactor, Optional<Curve> curve, Duration duration, Optional<Runnable> onEnd) {
    throw new UnsupportedOperationException("animatedAlignAnimatedAlign has no default (FFM/comm impl required)");
  }
  default AlignmentGeometry AnimatedAlign_readBack_alignment(Object st) {
    throw new UnsupportedOperationException("AnimatedAlign_readBack_alignment read-back requires FFM/java22");
  }
  default Widget AnimatedAlign_readBack_child(Object st) {
    throw new UnsupportedOperationException("AnimatedAlign_readBack_child read-back requires FFM/java22");
  }
  default double AnimatedAlign_readBack_heightFactor(Object st) {
    throw new UnsupportedOperationException("AnimatedAlign_readBack_heightFactor read-back requires FFM/java22");
  }
  default double AnimatedAlign_readBack_widthFactor(Object st) {
    throw new UnsupportedOperationException("AnimatedAlign_readBack_widthFactor read-back requires FFM/java22");
  }

  default int listViewListView(Optional<Axis> scrollDirection, Optional<Boolean> reverse, Optional<Boolean> primary, Optional<Boolean> shrinkWrap, Optional<EdgeInsetsGeometry> padding, OptionalDouble itemExtent, Optional<Widget> prototypeItem, Optional<Boolean> addAutomaticKeepAlives, Optional<Boolean> addRepaintBoundaries, Optional<Boolean> addSemanticIndexes, OptionalDouble cacheExtent, Optional<List<Widget>> children, OptionalInt semanticChildCount, Optional<DragStartBehavior> dragStartBehavior, Optional<ScrollViewKeyboardDismissBehavior> keyboardDismissBehavior, Optional<String> restorationId, Optional<Clip> clipBehavior, Optional<HitTestBehavior> hitTestBehavior) {
    throw new UnsupportedOperationException("listViewListView has no default (FFM/comm impl required)");
  }
  default int listViewBuilder(Optional<Axis> scrollDirection, Optional<Boolean> reverse, Optional<Boolean> primary, Optional<Boolean> shrinkWrap, Optional<EdgeInsetsGeometry> padding, OptionalDouble itemExtent, Optional<Widget> prototypeItem, BiFunction<BuildContext, Integer, Widget> itemBuilder, OptionalInt itemCount, Optional<Boolean> addAutomaticKeepAlives, Optional<Boolean> addRepaintBoundaries, Optional<Boolean> addSemanticIndexes, OptionalDouble cacheExtent, OptionalInt semanticChildCount, Optional<DragStartBehavior> dragStartBehavior, Optional<ScrollViewKeyboardDismissBehavior> keyboardDismissBehavior, Optional<String> restorationId, Optional<Clip> clipBehavior, Optional<HitTestBehavior> hitTestBehavior) {
    throw new UnsupportedOperationException("listViewBuilder has no default (FFM/comm impl required)");
  }
  default int listViewSeparated(Optional<Axis> scrollDirection, Optional<Boolean> reverse, Optional<Boolean> primary, Optional<Boolean> shrinkWrap, Optional<EdgeInsetsGeometry> padding, BiFunction<BuildContext, Integer, Widget> itemBuilder, BiFunction<BuildContext, Integer, Widget> separatorBuilder, int itemCount, Optional<Boolean> addAutomaticKeepAlives, Optional<Boolean> addRepaintBoundaries, Optional<Boolean> addSemanticIndexes, OptionalDouble cacheExtent, Optional<DragStartBehavior> dragStartBehavior, Optional<ScrollViewKeyboardDismissBehavior> keyboardDismissBehavior, Optional<String> restorationId, Optional<Clip> clipBehavior, Optional<HitTestBehavior> hitTestBehavior) {
    throw new UnsupportedOperationException("listViewSeparated has no default (FFM/comm impl required)");
  }
  default double ListView_readBack_itemExtent(Object st) {
    throw new UnsupportedOperationException("ListView_readBack_itemExtent read-back requires FFM/java22");
  }
  default Widget ListView_readBack_prototypeItem(Object st) {
    throw new UnsupportedOperationException("ListView_readBack_prototypeItem read-back requires FFM/java22");
  }

  default int gridViewCount(Optional<Axis> scrollDirection, Optional<Boolean> reverse, Optional<Boolean> primary, Optional<Boolean> shrinkWrap, Optional<EdgeInsetsGeometry> padding, int crossAxisCount, OptionalDouble mainAxisSpacing, OptionalDouble crossAxisSpacing, OptionalDouble childAspectRatio, OptionalDouble mainAxisExtent, Optional<Boolean> addAutomaticKeepAlives, Optional<Boolean> addRepaintBoundaries, Optional<Boolean> addSemanticIndexes, OptionalDouble cacheExtent, Optional<List<Widget>> children, OptionalInt semanticChildCount, Optional<DragStartBehavior> dragStartBehavior, Optional<ScrollViewKeyboardDismissBehavior> keyboardDismissBehavior, Optional<String> restorationId, Optional<Clip> clipBehavior, Optional<HitTestBehavior> hitTestBehavior) {
    throw new UnsupportedOperationException("gridViewCount has no default (FFM/comm impl required)");
  }
  default int gridViewExtent(Optional<Axis> scrollDirection, Optional<Boolean> reverse, Optional<Boolean> primary, Optional<Boolean> shrinkWrap, Optional<EdgeInsetsGeometry> padding, double maxCrossAxisExtent, OptionalDouble mainAxisSpacing, OptionalDouble crossAxisSpacing, OptionalDouble childAspectRatio, OptionalDouble mainAxisExtent, Optional<Boolean> addAutomaticKeepAlives, Optional<Boolean> addRepaintBoundaries, Optional<Boolean> addSemanticIndexes, OptionalDouble cacheExtent, Optional<List<Widget>> children, OptionalInt semanticChildCount, Optional<DragStartBehavior> dragStartBehavior, Optional<ScrollViewKeyboardDismissBehavior> keyboardDismissBehavior, Optional<String> restorationId, Optional<Clip> clipBehavior, Optional<HitTestBehavior> hitTestBehavior) {
    throw new UnsupportedOperationException("gridViewExtent has no default (FFM/comm impl required)");
  }

  default int pageViewPageView(Optional<Axis> scrollDirection, Optional<Boolean> reverse, Optional<Boolean> pageSnapping, Optional<Consumer<Integer>> onPageChanged, Optional<List<Widget>> children, Optional<DragStartBehavior> dragStartBehavior, Optional<Boolean> allowImplicitScrolling, Optional<String> restorationId, Optional<Clip> clipBehavior, Optional<HitTestBehavior> hitTestBehavior, Optional<Boolean> padEnds) {
    throw new UnsupportedOperationException("pageViewPageView has no default (FFM/comm impl required)");
  }
  default int pageViewBuilder(Optional<Axis> scrollDirection, Optional<Boolean> reverse, Optional<Boolean> pageSnapping, Optional<Consumer<Integer>> onPageChanged, BiFunction<BuildContext, Integer, Widget> itemBuilder, OptionalInt itemCount, Optional<DragStartBehavior> dragStartBehavior, Optional<Boolean> allowImplicitScrolling, Optional<String> restorationId, Optional<Clip> clipBehavior, Optional<HitTestBehavior> hitTestBehavior, Optional<Boolean> padEnds) {
    throw new UnsupportedOperationException("pageViewBuilder has no default (FFM/comm impl required)");
  }
  default boolean PageView_readBack_allowImplicitScrolling(Object st) {
    throw new UnsupportedOperationException("PageView_readBack_allowImplicitScrolling read-back requires FFM/java22");
  }
  default String PageView_readBack_restorationId(Object st) {
    throw new UnsupportedOperationException("PageView_readBack_restorationId read-back requires FFM/java22");
  }
  default Axis PageView_readBack_scrollDirection(Object st) {
    throw new UnsupportedOperationException("PageView_readBack_scrollDirection read-back requires FFM/java22");
  }
  default boolean PageView_readBack_reverse(Object st) {
    throw new UnsupportedOperationException("PageView_readBack_reverse read-back requires FFM/java22");
  }
  default boolean PageView_readBack_pageSnapping(Object st) {
    throw new UnsupportedOperationException("PageView_readBack_pageSnapping read-back requires FFM/java22");
  }
  default DragStartBehavior PageView_readBack_dragStartBehavior(Object st) {
    throw new UnsupportedOperationException("PageView_readBack_dragStartBehavior read-back requires FFM/java22");
  }
  default Clip PageView_readBack_clipBehavior(Object st) {
    throw new UnsupportedOperationException("PageView_readBack_clipBehavior read-back requires FFM/java22");
  }
  default HitTestBehavior PageView_readBack_hitTestBehavior(Object st) {
    throw new UnsupportedOperationException("PageView_readBack_hitTestBehavior read-back requires FFM/java22");
  }
  default boolean PageView_readBack_padEnds(Object st) {
    throw new UnsupportedOperationException("PageView_readBack_padEnds read-back requires FFM/java22");
  }

  default int listWheelScrollViewListWheelScrollView(OptionalDouble diameterRatio, OptionalDouble perspective, OptionalDouble offAxisFraction, Optional<Boolean> useMagnifier, OptionalDouble magnification, OptionalDouble overAndUnderCenterOpacity, double itemExtent, OptionalDouble squeeze, Optional<Consumer<Integer>> onSelectedItemChanged, Optional<Boolean> renderChildrenOutsideViewport, Optional<Clip> clipBehavior, Optional<HitTestBehavior> hitTestBehavior, Optional<String> restorationId, Optional<DragStartBehavior> dragStartBehavior, Optional<ChangeReportingBehavior> changeReportingBehavior, List<Widget> children) {
    throw new UnsupportedOperationException("listWheelScrollViewListWheelScrollView has no default (FFM/comm impl required)");
  }
  default double ListWheelScrollView_readBack_diameterRatio(Object st) {
    throw new UnsupportedOperationException("ListWheelScrollView_readBack_diameterRatio read-back requires FFM/java22");
  }
  default double ListWheelScrollView_readBack_perspective(Object st) {
    throw new UnsupportedOperationException("ListWheelScrollView_readBack_perspective read-back requires FFM/java22");
  }
  default double ListWheelScrollView_readBack_offAxisFraction(Object st) {
    throw new UnsupportedOperationException("ListWheelScrollView_readBack_offAxisFraction read-back requires FFM/java22");
  }
  default boolean ListWheelScrollView_readBack_useMagnifier(Object st) {
    throw new UnsupportedOperationException("ListWheelScrollView_readBack_useMagnifier read-back requires FFM/java22");
  }
  default double ListWheelScrollView_readBack_magnification(Object st) {
    throw new UnsupportedOperationException("ListWheelScrollView_readBack_magnification read-back requires FFM/java22");
  }
  default double ListWheelScrollView_readBack_overAndUnderCenterOpacity(Object st) {
    throw new UnsupportedOperationException("ListWheelScrollView_readBack_overAndUnderCenterOpacity read-back requires FFM/java22");
  }
  default double ListWheelScrollView_readBack_itemExtent(Object st) {
    throw new UnsupportedOperationException("ListWheelScrollView_readBack_itemExtent read-back requires FFM/java22");
  }
  default double ListWheelScrollView_readBack_squeeze(Object st) {
    throw new UnsupportedOperationException("ListWheelScrollView_readBack_squeeze read-back requires FFM/java22");
  }
  default boolean ListWheelScrollView_readBack_renderChildrenOutsideViewport(Object st) {
    throw new UnsupportedOperationException("ListWheelScrollView_readBack_renderChildrenOutsideViewport read-back requires FFM/java22");
  }
  default Clip ListWheelScrollView_readBack_clipBehavior(Object st) {
    throw new UnsupportedOperationException("ListWheelScrollView_readBack_clipBehavior read-back requires FFM/java22");
  }
  default HitTestBehavior ListWheelScrollView_readBack_hitTestBehavior(Object st) {
    throw new UnsupportedOperationException("ListWheelScrollView_readBack_hitTestBehavior read-back requires FFM/java22");
  }
  default String ListWheelScrollView_readBack_restorationId(Object st) {
    throw new UnsupportedOperationException("ListWheelScrollView_readBack_restorationId read-back requires FFM/java22");
  }
  default DragStartBehavior ListWheelScrollView_readBack_dragStartBehavior(Object st) {
    throw new UnsupportedOperationException("ListWheelScrollView_readBack_dragStartBehavior read-back requires FFM/java22");
  }
  default ChangeReportingBehavior ListWheelScrollView_readBack_changeReportingBehavior(Object st) {
    throw new UnsupportedOperationException("ListWheelScrollView_readBack_changeReportingBehavior read-back requires FFM/java22");
  }

  default int animatedSizeAnimatedSize(Optional<Widget> child, Optional<AlignmentGeometry> alignment, Optional<Curve> curve, Duration duration, Optional<Duration> reverseDuration, Optional<Clip> clipBehavior, Optional<Runnable> onEnd) {
    throw new UnsupportedOperationException("animatedSizeAnimatedSize has no default (FFM/comm impl required)");
  }
  default Widget AnimatedSize_readBack_child(Object st) {
    throw new UnsupportedOperationException("AnimatedSize_readBack_child read-back requires FFM/java22");
  }
  default AlignmentGeometry AnimatedSize_readBack_alignment(Object st) {
    throw new UnsupportedOperationException("AnimatedSize_readBack_alignment read-back requires FFM/java22");
  }
  default Curve AnimatedSize_readBack_curve(Object st) {
    throw new UnsupportedOperationException("AnimatedSize_readBack_curve read-back requires FFM/java22");
  }
  default Duration AnimatedSize_readBack_duration(Object st) {
    throw new UnsupportedOperationException("AnimatedSize_readBack_duration read-back requires FFM/java22");
  }
  default Duration AnimatedSize_readBack_reverseDuration(Object st) {
    throw new UnsupportedOperationException("AnimatedSize_readBack_reverseDuration read-back requires FFM/java22");
  }
  default Clip AnimatedSize_readBack_clipBehavior(Object st) {
    throw new UnsupportedOperationException("AnimatedSize_readBack_clipBehavior read-back requires FFM/java22");
  }

  default int animatedScaleAnimatedScale(Optional<Widget> child, double scale, Optional<Alignment> alignment, Optional<FilterQuality> filterQuality, Optional<Curve> curve, Duration duration, Optional<Runnable> onEnd) {
    throw new UnsupportedOperationException("animatedScaleAnimatedScale has no default (FFM/comm impl required)");
  }
  default Widget AnimatedScale_readBack_child(Object st) {
    throw new UnsupportedOperationException("AnimatedScale_readBack_child read-back requires FFM/java22");
  }
  default double AnimatedScale_readBack_scale(Object st) {
    throw new UnsupportedOperationException("AnimatedScale_readBack_scale read-back requires FFM/java22");
  }
  default Alignment AnimatedScale_readBack_alignment(Object st) {
    throw new UnsupportedOperationException("AnimatedScale_readBack_alignment read-back requires FFM/java22");
  }
  default FilterQuality AnimatedScale_readBack_filterQuality(Object st) {
    throw new UnsupportedOperationException("AnimatedScale_readBack_filterQuality read-back requires FFM/java22");
  }

  default int animatedRotationAnimatedRotation(Optional<Widget> child, double turns, Optional<Alignment> alignment, Optional<FilterQuality> filterQuality, Optional<Curve> curve, Duration duration, Optional<Runnable> onEnd) {
    throw new UnsupportedOperationException("animatedRotationAnimatedRotation has no default (FFM/comm impl required)");
  }
  default Widget AnimatedRotation_readBack_child(Object st) {
    throw new UnsupportedOperationException("AnimatedRotation_readBack_child read-back requires FFM/java22");
  }
  default double AnimatedRotation_readBack_turns(Object st) {
    throw new UnsupportedOperationException("AnimatedRotation_readBack_turns read-back requires FFM/java22");
  }
  default Alignment AnimatedRotation_readBack_alignment(Object st) {
    throw new UnsupportedOperationException("AnimatedRotation_readBack_alignment read-back requires FFM/java22");
  }
  default FilterQuality AnimatedRotation_readBack_filterQuality(Object st) {
    throw new UnsupportedOperationException("AnimatedRotation_readBack_filterQuality read-back requires FFM/java22");
  }

  default int animatedSlideAnimatedSlide(Optional<Widget> child, Offset offset, Optional<Curve> curve, Duration duration, Optional<Runnable> onEnd) {
    throw new UnsupportedOperationException("animatedSlideAnimatedSlide has no default (FFM/comm impl required)");
  }
  default Widget AnimatedSlide_readBack_child(Object st) {
    throw new UnsupportedOperationException("AnimatedSlide_readBack_child read-back requires FFM/java22");
  }
  default Offset AnimatedSlide_readBack_offset(Object st) {
    throw new UnsupportedOperationException("AnimatedSlide_readBack_offset read-back requires FFM/java22");
  }

  default int animatedCrossFadeAnimatedCrossFade(Widget firstChild, Widget secondChild, Optional<Curve> firstCurve, Optional<Curve> secondCurve, Optional<Curve> sizeCurve, Optional<AlignmentGeometry> alignment, CrossFadeState crossFadeState, Duration duration, Optional<Duration> reverseDuration, Optional<Boolean> excludeBottomFocus, Optional<Clip> clipBehavior, Optional<Runnable> onEnd) {
    throw new UnsupportedOperationException("animatedCrossFadeAnimatedCrossFade has no default (FFM/comm impl required)");
  }
  default Widget AnimatedCrossFade_readBack_firstChild(Object st) {
    throw new UnsupportedOperationException("AnimatedCrossFade_readBack_firstChild read-back requires FFM/java22");
  }
  default Widget AnimatedCrossFade_readBack_secondChild(Object st) {
    throw new UnsupportedOperationException("AnimatedCrossFade_readBack_secondChild read-back requires FFM/java22");
  }
  default CrossFadeState AnimatedCrossFade_readBack_crossFadeState(Object st) {
    throw new UnsupportedOperationException("AnimatedCrossFade_readBack_crossFadeState read-back requires FFM/java22");
  }
  default Duration AnimatedCrossFade_readBack_duration(Object st) {
    throw new UnsupportedOperationException("AnimatedCrossFade_readBack_duration read-back requires FFM/java22");
  }
  default Duration AnimatedCrossFade_readBack_reverseDuration(Object st) {
    throw new UnsupportedOperationException("AnimatedCrossFade_readBack_reverseDuration read-back requires FFM/java22");
  }
  default Curve AnimatedCrossFade_readBack_firstCurve(Object st) {
    throw new UnsupportedOperationException("AnimatedCrossFade_readBack_firstCurve read-back requires FFM/java22");
  }
  default Curve AnimatedCrossFade_readBack_secondCurve(Object st) {
    throw new UnsupportedOperationException("AnimatedCrossFade_readBack_secondCurve read-back requires FFM/java22");
  }
  default Curve AnimatedCrossFade_readBack_sizeCurve(Object st) {
    throw new UnsupportedOperationException("AnimatedCrossFade_readBack_sizeCurve read-back requires FFM/java22");
  }
  default AlignmentGeometry AnimatedCrossFade_readBack_alignment(Object st) {
    throw new UnsupportedOperationException("AnimatedCrossFade_readBack_alignment read-back requires FFM/java22");
  }
  default boolean AnimatedCrossFade_readBack_excludeBottomFocus(Object st) {
    throw new UnsupportedOperationException("AnimatedCrossFade_readBack_excludeBottomFocus read-back requires FFM/java22");
  }
  default Clip AnimatedCrossFade_readBack_clipBehavior(Object st) {
    throw new UnsupportedOperationException("AnimatedCrossFade_readBack_clipBehavior read-back requires FFM/java22");
  }

  default int slideTransitionSlideTransition(Animation position, Optional<Boolean> transformHitTests, Optional<TextDirection> textDirection, Optional<Widget> child) {
    throw new UnsupportedOperationException("slideTransitionSlideTransition has no default (FFM/comm impl required)");
  }
  default TextDirection SlideTransition_readBack_textDirection(Object st) {
    throw new UnsupportedOperationException("SlideTransition_readBack_textDirection read-back requires FFM/java22");
  }
  default boolean SlideTransition_readBack_transformHitTests(Object st) {
    throw new UnsupportedOperationException("SlideTransition_readBack_transformHitTests read-back requires FFM/java22");
  }
  default Widget SlideTransition_readBack_child(Object st) {
    throw new UnsupportedOperationException("SlideTransition_readBack_child read-back requires FFM/java22");
  }
  default Animation SlideTransition_readBack_position(Object st) {
    throw new UnsupportedOperationException("SlideTransition_readBack_position read-back requires FFM/java22");
  }

  default int sizeTransitionSizeTransition(Optional<Axis> axis, Animation sizeFactor, OptionalDouble axisAlignment, Optional<AlignmentGeometry> alignment, OptionalDouble fixedCrossAxisSizeFactor, Optional<Widget> child) {
    throw new UnsupportedOperationException("sizeTransitionSizeTransition has no default (FFM/comm impl required)");
  }
  default Axis SizeTransition_readBack_axis(Object st) {
    throw new UnsupportedOperationException("SizeTransition_readBack_axis read-back requires FFM/java22");
  }
  default double SizeTransition_readBack_axisAlignment(Object st) {
    throw new UnsupportedOperationException("SizeTransition_readBack_axisAlignment read-back requires FFM/java22");
  }
  default AlignmentGeometry SizeTransition_readBack_alignment(Object st) {
    throw new UnsupportedOperationException("SizeTransition_readBack_alignment read-back requires FFM/java22");
  }
  default double SizeTransition_readBack_fixedCrossAxisSizeFactor(Object st) {
    throw new UnsupportedOperationException("SizeTransition_readBack_fixedCrossAxisSizeFactor read-back requires FFM/java22");
  }
  default Widget SizeTransition_readBack_child(Object st) {
    throw new UnsupportedOperationException("SizeTransition_readBack_child read-back requires FFM/java22");
  }
  default Animation SizeTransition_readBack_sizeFactor(Object st) {
    throw new UnsupportedOperationException("SizeTransition_readBack_sizeFactor read-back requires FFM/java22");
  }

  default int indexedStackIndexedStack(Optional<AlignmentGeometry> alignment, Optional<TextDirection> textDirection, Optional<Clip> clipBehavior, Optional<StackFit> sizing, OptionalInt index, Optional<List<Widget>> children) {
    throw new UnsupportedOperationException("indexedStackIndexedStack has no default (FFM/comm impl required)");
  }
  default AlignmentGeometry IndexedStack_readBack_alignment(Object st) {
    throw new UnsupportedOperationException("IndexedStack_readBack_alignment read-back requires FFM/java22");
  }
  default TextDirection IndexedStack_readBack_textDirection(Object st) {
    throw new UnsupportedOperationException("IndexedStack_readBack_textDirection read-back requires FFM/java22");
  }
  default Clip IndexedStack_readBack_clipBehavior(Object st) {
    throw new UnsupportedOperationException("IndexedStack_readBack_clipBehavior read-back requires FFM/java22");
  }
  default StackFit IndexedStack_readBack_sizing(Object st) {
    throw new UnsupportedOperationException("IndexedStack_readBack_sizing read-back requires FFM/java22");
  }
  default int IndexedStack_readBack_index(Object st) {
    throw new UnsupportedOperationException("IndexedStack_readBack_index read-back requires FFM/java22");
  }

  default int interactiveViewerInteractiveViewer(Optional<Clip> clipBehavior, Optional<PanAxis> panAxis, Optional<EdgeInsets> boundaryMargin, Optional<Boolean> constrained, OptionalDouble maxScale, OptionalDouble minScale, OptionalDouble interactionEndFrictionCoefficient, Optional<Consumer<ScaleEndDetails>> onInteractionEnd, Optional<Consumer<ScaleStartDetails>> onInteractionStart, Optional<Consumer<ScaleUpdateDetails>> onInteractionUpdate, Optional<Boolean> panEnabled, Optional<Boolean> scaleEnabled, OptionalDouble scaleFactor, Optional<Alignment> alignment, Optional<Boolean> trackpadScrollCausesScale, Widget child) {
    throw new UnsupportedOperationException("interactiveViewerInteractiveViewer has no default (FFM/comm impl required)");
  }
  default Alignment InteractiveViewer_readBack_alignment(Object st) {
    throw new UnsupportedOperationException("InteractiveViewer_readBack_alignment read-back requires FFM/java22");
  }
  default Clip InteractiveViewer_readBack_clipBehavior(Object st) {
    throw new UnsupportedOperationException("InteractiveViewer_readBack_clipBehavior read-back requires FFM/java22");
  }
  default PanAxis InteractiveViewer_readBack_panAxis(Object st) {
    throw new UnsupportedOperationException("InteractiveViewer_readBack_panAxis read-back requires FFM/java22");
  }
  default EdgeInsets InteractiveViewer_readBack_boundaryMargin(Object st) {
    throw new UnsupportedOperationException("InteractiveViewer_readBack_boundaryMargin read-back requires FFM/java22");
  }
  default Widget InteractiveViewer_readBack_child(Object st) {
    throw new UnsupportedOperationException("InteractiveViewer_readBack_child read-back requires FFM/java22");
  }
  default boolean InteractiveViewer_readBack_constrained(Object st) {
    throw new UnsupportedOperationException("InteractiveViewer_readBack_constrained read-back requires FFM/java22");
  }
  default boolean InteractiveViewer_readBack_panEnabled(Object st) {
    throw new UnsupportedOperationException("InteractiveViewer_readBack_panEnabled read-back requires FFM/java22");
  }
  default boolean InteractiveViewer_readBack_scaleEnabled(Object st) {
    throw new UnsupportedOperationException("InteractiveViewer_readBack_scaleEnabled read-back requires FFM/java22");
  }
  default boolean InteractiveViewer_readBack_trackpadScrollCausesScale(Object st) {
    throw new UnsupportedOperationException("InteractiveViewer_readBack_trackpadScrollCausesScale read-back requires FFM/java22");
  }
  default double InteractiveViewer_readBack_scaleFactor(Object st) {
    throw new UnsupportedOperationException("InteractiveViewer_readBack_scaleFactor read-back requires FFM/java22");
  }
  default double InteractiveViewer_readBack_maxScale(Object st) {
    throw new UnsupportedOperationException("InteractiveViewer_readBack_maxScale read-back requires FFM/java22");
  }
  default double InteractiveViewer_readBack_minScale(Object st) {
    throw new UnsupportedOperationException("InteractiveViewer_readBack_minScale read-back requires FFM/java22");
  }
  default double InteractiveViewer_readBack_interactionEndFrictionCoefficient(Object st) {
    throw new UnsupportedOperationException("InteractiveViewer_readBack_interactionEndFrictionCoefficient read-back requires FFM/java22");
  }

  default <T extends NativeObj> int draggableDraggable(Widget child, Widget feedback, Optional<NativeObj> data, Optional<Axis> axis, Optional<Widget> childWhenDragging, Optional<Offset> feedbackOffset, Optional<TriFunction<Draggable, BuildContext, Offset, Offset>> dragAnchorStrategy, Optional<Axis> affinity, OptionalInt maxSimultaneousDrags, Optional<Runnable> onDragStarted, Optional<Consumer<DragUpdateDetails>> onDragUpdate, Optional<BiConsumer<Velocity, Offset>> onDraggableCanceled, Optional<Consumer<DraggableDetails>> onDragEnd, Optional<Runnable> onDragCompleted, Optional<Boolean> ignoringFeedbackSemantics, Optional<Boolean> ignoringFeedbackPointer, Optional<Boolean> rootOverlay, Optional<HitTestBehavior> hitTestBehavior, Optional<Function<Integer, Boolean>> allowedButtonsFilter) {
    throw new UnsupportedOperationException("draggableDraggable has no default (FFM/comm impl required)");
  }
  default Axis Draggable_readBack_axis(Object st) {
    throw new UnsupportedOperationException("Draggable_readBack_axis read-back requires FFM/java22");
  }
  default Widget Draggable_readBack_child(Object st) {
    throw new UnsupportedOperationException("Draggable_readBack_child read-back requires FFM/java22");
  }
  default Widget Draggable_readBack_childWhenDragging(Object st) {
    throw new UnsupportedOperationException("Draggable_readBack_childWhenDragging read-back requires FFM/java22");
  }
  default Widget Draggable_readBack_feedback(Object st) {
    throw new UnsupportedOperationException("Draggable_readBack_feedback read-back requires FFM/java22");
  }
  default Offset Draggable_readBack_feedbackOffset(Object st) {
    throw new UnsupportedOperationException("Draggable_readBack_feedbackOffset read-back requires FFM/java22");
  }
  default boolean Draggable_readBack_ignoringFeedbackSemantics(Object st) {
    throw new UnsupportedOperationException("Draggable_readBack_ignoringFeedbackSemantics read-back requires FFM/java22");
  }
  default boolean Draggable_readBack_ignoringFeedbackPointer(Object st) {
    throw new UnsupportedOperationException("Draggable_readBack_ignoringFeedbackPointer read-back requires FFM/java22");
  }
  default Axis Draggable_readBack_affinity(Object st) {
    throw new UnsupportedOperationException("Draggable_readBack_affinity read-back requires FFM/java22");
  }
  default int Draggable_readBack_maxSimultaneousDrags(Object st) {
    throw new UnsupportedOperationException("Draggable_readBack_maxSimultaneousDrags read-back requires FFM/java22");
  }
  default boolean Draggable_readBack_rootOverlay(Object st) {
    throw new UnsupportedOperationException("Draggable_readBack_rootOverlay read-back requires FFM/java22");
  }
  default HitTestBehavior Draggable_readBack_hitTestBehavior(Object st) {
    throw new UnsupportedOperationException("Draggable_readBack_hitTestBehavior read-back requires FFM/java22");
  }

  default <T extends NativeObj> int dragTargetDragTarget(TriFunction<BuildContext, List<NativeObj>, List<NativeObj>, Widget> builder, Optional<Function<NativeObj, Boolean>> onWillAccept, Optional<Function<DragTargetDetails, Boolean>> onWillAcceptWithDetails, Optional<Consumer<NativeObj>> onAccept, Optional<Consumer<DragTargetDetails>> onAcceptWithDetails, Optional<Consumer<NativeObj>> onLeave, Optional<Consumer<DragTargetDetails>> onMove, Optional<HitTestBehavior> hitTestBehavior) {
    throw new UnsupportedOperationException("dragTargetDragTarget has no default (FFM/comm impl required)");
  }
  default HitTestBehavior DragTarget_readBack_hitTestBehavior(Object st) {
    throw new UnsupportedOperationException("DragTarget_readBack_hitTestBehavior read-back requires FFM/java22");
  }

  default int heroHero(NativeObj tag, Optional<PentaFunction<BuildContext, Animation, HeroFlightDirection, BuildContext, BuildContext, Widget>> flightShuttleBuilder, Optional<Boolean> transitionOnUserGestures, Optional<Curve> curve, Optional<Curve> reverseCurve, Widget child) {
    throw new UnsupportedOperationException("heroHero has no default (FFM/comm impl required)");
  }
  default Widget Hero_readBack_child(Object st) {
    throw new UnsupportedOperationException("Hero_readBack_child read-back requires FFM/java22");
  }
  default boolean Hero_readBack_transitionOnUserGestures(Object st) {
    throw new UnsupportedOperationException("Hero_readBack_transitionOnUserGestures read-back requires FFM/java22");
  }
  default Curve Hero_readBack_curve(Object st) {
    throw new UnsupportedOperationException("Hero_readBack_curve read-back requires FFM/java22");
  }
  default Curve Hero_readBack_reverseCurve(Object st) {
    throw new UnsupportedOperationException("Hero_readBack_reverseCurve read-back requires FFM/java22");
  }

  default int animatedSwitcherAnimatedSwitcher(Optional<Widget> child, Duration duration, Optional<Duration> reverseDuration, Optional<Curve> switchInCurve, Optional<Curve> switchOutCurve, Optional<BiFunction<Widget, Animation, Widget>> transitionBuilder, Optional<BiFunction<Widget, List<Widget>, Widget>> layoutBuilder) {
    throw new UnsupportedOperationException("animatedSwitcherAnimatedSwitcher has no default (FFM/comm impl required)");
  }
  default int animatedSwitcherDefaultTransitionBuilder(Widget child, Animation animation) {
    throw new UnsupportedOperationException("animatedSwitcherDefaultTransitionBuilder has no default (FFM/comm impl required)");
  }
  default int animatedSwitcherDefaultLayoutBuilder(Widget currentChild, List<Widget> previousChildren) {
    throw new UnsupportedOperationException("animatedSwitcherDefaultLayoutBuilder has no default (FFM/comm impl required)");
  }
  default Widget AnimatedSwitcher_readBack_child(Object st) {
    throw new UnsupportedOperationException("AnimatedSwitcher_readBack_child read-back requires FFM/java22");
  }
  default Duration AnimatedSwitcher_readBack_duration(Object st) {
    throw new UnsupportedOperationException("AnimatedSwitcher_readBack_duration read-back requires FFM/java22");
  }
  default Duration AnimatedSwitcher_readBack_reverseDuration(Object st) {
    throw new UnsupportedOperationException("AnimatedSwitcher_readBack_reverseDuration read-back requires FFM/java22");
  }
  default Curve AnimatedSwitcher_readBack_switchInCurve(Object st) {
    throw new UnsupportedOperationException("AnimatedSwitcher_readBack_switchInCurve read-back requires FFM/java22");
  }
  default Curve AnimatedSwitcher_readBack_switchOutCurve(Object st) {
    throw new UnsupportedOperationException("AnimatedSwitcher_readBack_switchOutCurve read-back requires FFM/java22");
  }

  default int colorFilterMode(Color color, BlendMode blendMode) {
    throw new UnsupportedOperationException("colorFilterMode has no default (FFM/comm impl required)");
  }
  default int colorFilterLinearToSrgbGamma() {
    throw new UnsupportedOperationException("colorFilterLinearToSrgbGamma has no default (FFM/comm impl required)");
  }
  default int colorFilterSrgbToLinearGamma() {
    throw new UnsupportedOperationException("colorFilterSrgbToLinearGamma has no default (FFM/comm impl required)");
  }
  default int colorFilterSaturation(double saturation) {
    throw new UnsupportedOperationException("colorFilterSaturation has no default (FFM/comm impl required)");
  }

  default int backdropFilterBackdropFilter(Optional<ImageFilter> filter, Optional<Widget> child, Optional<BlendMode> blendMode, Optional<Boolean> enabled) {
    throw new UnsupportedOperationException("backdropFilterBackdropFilter has no default (FFM/comm impl required)");
  }
  default int backdropFilterGrouped(Optional<ImageFilter> filter, Optional<Widget> child, Optional<BlendMode> blendMode, Optional<Boolean> enabled) {
    throw new UnsupportedOperationException("backdropFilterGrouped has no default (FFM/comm impl required)");
  }
  default ImageFilter BackdropFilter_readBack_filter(Object st) {
    throw new UnsupportedOperationException("BackdropFilter_readBack_filter read-back requires FFM/java22");
  }
  default BlendMode BackdropFilter_readBack_blendMode(Object st) {
    throw new UnsupportedOperationException("BackdropFilter_readBack_blendMode read-back requires FFM/java22");
  }
  default boolean BackdropFilter_readBack_enabled(Object st) {
    throw new UnsupportedOperationException("BackdropFilter_readBack_enabled read-back requires FFM/java22");
  }

  default int imageFilterBlur(OptionalDouble sigmaX, OptionalDouble sigmaY, Optional<TileMode> tileMode) {
    throw new UnsupportedOperationException("imageFilterBlur has no default (FFM/comm impl required)");
  }
  default int imageFilterDilate(OptionalDouble radiusX, OptionalDouble radiusY) {
    throw new UnsupportedOperationException("imageFilterDilate has no default (FFM/comm impl required)");
  }
  default int imageFilterErode(OptionalDouble radiusX, OptionalDouble radiusY) {
    throw new UnsupportedOperationException("imageFilterErode has no default (FFM/comm impl required)");
  }
  default int imageFilterCompose(ImageFilter outer, ImageFilter inner) {
    throw new UnsupportedOperationException("imageFilterCompose has no default (FFM/comm impl required)");
  }

  default int colorFilteredColorFiltered(ColorFilter colorFilter, Optional<Widget> child) {
    throw new UnsupportedOperationException("colorFilteredColorFiltered has no default (FFM/comm impl required)");
  }
  default ColorFilter ColorFiltered_readBack_colorFilter(Object st) {
    throw new UnsupportedOperationException("ColorFiltered_readBack_colorFilter read-back requires FFM/java22");
  }

  default int imageFilteredImageFiltered(ImageFilter imageFilter, Optional<Widget> child, Optional<Boolean> enabled) {
    throw new UnsupportedOperationException("imageFilteredImageFiltered has no default (FFM/comm impl required)");
  }
  default ImageFilter ImageFiltered_readBack_imageFilter(Object st) {
    throw new UnsupportedOperationException("ImageFiltered_readBack_imageFilter read-back requires FFM/java22");
  }
  default boolean ImageFiltered_readBack_enabled(Object st) {
    throw new UnsupportedOperationException("ImageFiltered_readBack_enabled read-back requires FFM/java22");
  }

  default int heroModeHeroMode(Widget child, Optional<Boolean> enabled) {
    throw new UnsupportedOperationException("heroModeHeroMode has no default (FFM/comm impl required)");
  }
  default Widget HeroMode_readBack_child(Object st) {
    throw new UnsupportedOperationException("HeroMode_readBack_child read-back requires FFM/java22");
  }
  default boolean HeroMode_readBack_enabled(Object st) {
    throw new UnsupportedOperationException("HeroMode_readBack_enabled read-back requires FFM/java22");
  }

  default int blockSemanticsBlockSemantics(Optional<Boolean> blocking, Optional<Widget> child) {
    throw new UnsupportedOperationException("blockSemanticsBlockSemantics has no default (FFM/comm impl required)");
  }
  default boolean BlockSemantics_readBack_blocking(Object st) {
    throw new UnsupportedOperationException("BlockSemantics_readBack_blocking read-back requires FFM/java22");
  }

  default int mergeSemanticsMergeSemantics(Optional<Widget> child) {
    throw new UnsupportedOperationException("mergeSemanticsMergeSemantics has no default (FFM/comm impl required)");
  }

  default int excludeSemanticsExcludeSemantics(Optional<Boolean> excluding, Optional<Widget> child) {
    throw new UnsupportedOperationException("excludeSemanticsExcludeSemantics has no default (FFM/comm impl required)");
  }
  default boolean ExcludeSemantics_readBack_excluding(Object st) {
    throw new UnsupportedOperationException("ExcludeSemantics_readBack_excluding read-back requires FFM/java22");
  }

  default int indexedSemanticsIndexedSemantics(int index, Optional<Widget> child) {
    throw new UnsupportedOperationException("indexedSemanticsIndexedSemantics has no default (FFM/comm impl required)");
  }
  default int IndexedSemantics_readBack_index(Object st) {
    throw new UnsupportedOperationException("IndexedSemantics_readBack_index read-back requires FFM/java22");
  }

  default int automaticKeepAliveAutomaticKeepAlive(Widget child) {
    throw new UnsupportedOperationException("automaticKeepAliveAutomaticKeepAlive has no default (FFM/comm impl required)");
  }
  default Widget AutomaticKeepAlive_readBack_child(Object st) {
    throw new UnsupportedOperationException("AutomaticKeepAlive_readBack_child read-back requires FFM/java22");
  }

  default int sliverToBoxAdapterSliverToBoxAdapter(Optional<Widget> child) {
    throw new UnsupportedOperationException("sliverToBoxAdapterSliverToBoxAdapter has no default (FFM/comm impl required)");
  }

  default int listBodyListBody(Optional<Axis> mainAxis, Optional<Boolean> reverse, Optional<List<Widget>> children) {
    throw new UnsupportedOperationException("listBodyListBody has no default (FFM/comm impl required)");
  }
  default Axis ListBody_readBack_mainAxis(Object st) {
    throw new UnsupportedOperationException("ListBody_readBack_mainAxis read-back requires FFM/java22");
  }
  default boolean ListBody_readBack_reverse(Object st) {
    throw new UnsupportedOperationException("ListBody_readBack_reverse read-back requires FFM/java22");
  }

  default int gridPaperGridPaper(Optional<Color> color, OptionalDouble interval, OptionalInt divisions, OptionalInt subdivisions, Optional<Widget> child) {
    throw new UnsupportedOperationException("gridPaperGridPaper has no default (FFM/comm impl required)");
  }
  default Color GridPaper_readBack_color(Object st) {
    throw new UnsupportedOperationException("GridPaper_readBack_color read-back requires FFM/java22");
  }
  default double GridPaper_readBack_interval(Object st) {
    throw new UnsupportedOperationException("GridPaper_readBack_interval read-back requires FFM/java22");
  }
  default int GridPaper_readBack_divisions(Object st) {
    throw new UnsupportedOperationException("GridPaper_readBack_divisions read-back requires FFM/java22");
  }
  default int GridPaper_readBack_subdivisions(Object st) {
    throw new UnsupportedOperationException("GridPaper_readBack_subdivisions read-back requires FFM/java22");
  }
  default Widget GridPaper_readBack_child(Object st) {
    throw new UnsupportedOperationException("GridPaper_readBack_child read-back requires FFM/java22");
  }

  default int navigationToolbarNavigationToolbar(Optional<Widget> leading, Optional<Widget> middle, Optional<Widget> trailing, Optional<Boolean> centerMiddle, OptionalDouble middleSpacing) {
    throw new UnsupportedOperationException("navigationToolbarNavigationToolbar has no default (FFM/comm impl required)");
  }
  default Widget NavigationToolbar_readBack_leading(Object st) {
    throw new UnsupportedOperationException("NavigationToolbar_readBack_leading read-back requires FFM/java22");
  }
  default Widget NavigationToolbar_readBack_middle(Object st) {
    throw new UnsupportedOperationException("NavigationToolbar_readBack_middle read-back requires FFM/java22");
  }
  default Widget NavigationToolbar_readBack_trailing(Object st) {
    throw new UnsupportedOperationException("NavigationToolbar_readBack_trailing read-back requires FFM/java22");
  }
  default boolean NavigationToolbar_readBack_centerMiddle(Object st) {
    throw new UnsupportedOperationException("NavigationToolbar_readBack_centerMiddle read-back requires FFM/java22");
  }
  default double NavigationToolbar_readBack_middleSpacing(Object st) {
    throw new UnsupportedOperationException("NavigationToolbar_readBack_middleSpacing read-back requires FFM/java22");
  }

  default int checkedModeBannerCheckedModeBanner(Widget child) {
    throw new UnsupportedOperationException("checkedModeBannerCheckedModeBanner has no default (FFM/comm impl required)");
  }
  default Widget CheckedModeBanner_readBack_child(Object st) {
    throw new UnsupportedOperationException("CheckedModeBanner_readBack_child read-back requires FFM/java22");
  }

  default int ignoreBaselineIgnoreBaseline(Optional<Widget> child) {
    throw new UnsupportedOperationException("ignoreBaselineIgnoreBaseline has no default (FFM/comm impl required)");
  }

  default int tickerModeTickerMode(boolean enabled, Widget child, Optional<Boolean> forceFrames) {
    throw new UnsupportedOperationException("tickerModeTickerMode has no default (FFM/comm impl required)");
  }
  default int tickerModeOf(BuildContext context) {
    throw new UnsupportedOperationException("tickerModeOf has no default (FFM/comm impl required)");
  }
  default int tickerModeGetNotifier(BuildContext context) {
    throw new UnsupportedOperationException("tickerModeGetNotifier has no default (FFM/comm impl required)");
  }
  default int tickerModeGetValuesNotifier(BuildContext context) {
    throw new UnsupportedOperationException("tickerModeGetValuesNotifier has no default (FFM/comm impl required)");
  }
  default int tickerModeMerge(Optional<Boolean> enabled, Optional<Boolean> forceFrames, Widget child) {
    throw new UnsupportedOperationException("tickerModeMerge has no default (FFM/comm impl required)");
  }
  default boolean TickerMode_readBack_enabled(Object st) {
    throw new UnsupportedOperationException("TickerMode_readBack_enabled read-back requires FFM/java22");
  }
  default boolean TickerMode_readBack_forceFrames(Object st) {
    throw new UnsupportedOperationException("TickerMode_readBack_forceFrames read-back requires FFM/java22");
  }
  default Widget TickerMode_readBack_child(Object st) {
    throw new UnsupportedOperationException("TickerMode_readBack_child read-back requires FFM/java22");
  }

  default int tapRegionSurfaceTapRegionSurface(Widget child) {
    throw new UnsupportedOperationException("tapRegionSurfaceTapRegionSurface has no default (FFM/comm impl required)");
  }

  default int lookupBoundaryLookupBoundary(Widget child) {
    throw new UnsupportedOperationException("lookupBoundaryLookupBoundary has no default (FFM/comm impl required)");
  }
  default <T extends InheritedWidget> int lookupBoundaryDependOnInheritedWidgetOfExactType(BuildContext context, Optional<NativeObj> aspect) {
    throw new UnsupportedOperationException("lookupBoundaryDependOnInheritedWidgetOfExactType has no default (FFM/comm impl required)");
  }
  default <T extends InheritedWidget> int lookupBoundaryGetInheritedWidgetOfExactType(BuildContext context, Optional<NativeObj> aspect) {
    throw new UnsupportedOperationException("lookupBoundaryGetInheritedWidgetOfExactType has no default (FFM/comm impl required)");
  }
  default <T extends Widget> int lookupBoundaryFindAncestorWidgetOfExactType(BuildContext context) {
    throw new UnsupportedOperationException("lookupBoundaryFindAncestorWidgetOfExactType has no default (FFM/comm impl required)");
  }
  default <T extends State<StatefulWidget>> int lookupBoundaryFindAncestorStateOfType(BuildContext context) {
    throw new UnsupportedOperationException("lookupBoundaryFindAncestorStateOfType has no default (FFM/comm impl required)");
  }
  default <T extends State<StatefulWidget>> int lookupBoundaryFindRootAncestorStateOfType(BuildContext context) {
    throw new UnsupportedOperationException("lookupBoundaryFindRootAncestorStateOfType has no default (FFM/comm impl required)");
  }
  default <T extends RenderObject> int lookupBoundaryFindAncestorRenderObjectOfType(BuildContext context) {
    throw new UnsupportedOperationException("lookupBoundaryFindAncestorRenderObjectOfType has no default (FFM/comm impl required)");
  }
  default int lookupBoundaryDebugIsHidingAncestorWidgetOfExactType(BuildContext context) {
    throw new UnsupportedOperationException("lookupBoundaryDebugIsHidingAncestorWidgetOfExactType has no default (FFM/comm impl required)");
  }
  default int lookupBoundaryDebugIsHidingAncestorStateOfType(BuildContext context) {
    throw new UnsupportedOperationException("lookupBoundaryDebugIsHidingAncestorStateOfType has no default (FFM/comm impl required)");
  }
  default int lookupBoundaryDebugIsHidingAncestorRenderObjectOfType(BuildContext context) {
    throw new UnsupportedOperationException("lookupBoundaryDebugIsHidingAncestorRenderObjectOfType has no default (FFM/comm impl required)");
  }

  default int semanticsDebuggerSemanticsDebugger(Widget child, Optional<TextStyle> labelStyle) {
    throw new UnsupportedOperationException("semanticsDebuggerSemanticsDebugger has no default (FFM/comm impl required)");
  }
  default Widget SemanticsDebugger_readBack_child(Object st) {
    throw new UnsupportedOperationException("SemanticsDebugger_readBack_child read-back requires FFM/java22");
  }
  default TextStyle SemanticsDebugger_readBack_labelStyle(Object st) {
    throw new UnsupportedOperationException("SemanticsDebugger_readBack_labelStyle read-back requires FFM/java22");
  }

  default int excludeFocusExcludeFocus(Optional<Boolean> excluding, Widget child) {
    throw new UnsupportedOperationException("excludeFocusExcludeFocus has no default (FFM/comm impl required)");
  }
  default boolean ExcludeFocus_readBack_excluding(Object st) {
    throw new UnsupportedOperationException("ExcludeFocus_readBack_excluding read-back requires FFM/java22");
  }
  default Widget ExcludeFocus_readBack_child(Object st) {
    throw new UnsupportedOperationException("ExcludeFocus_readBack_child read-back requires FFM/java22");
  }

  default int excludeFocusTraversalExcludeFocusTraversal(Optional<Boolean> excluding, Widget child) {
    throw new UnsupportedOperationException("excludeFocusTraversalExcludeFocusTraversal has no default (FFM/comm impl required)");
  }
  default boolean ExcludeFocusTraversal_readBack_excluding(Object st) {
    throw new UnsupportedOperationException("ExcludeFocusTraversal_readBack_excluding read-back requires FFM/java22");
  }
  default Widget ExcludeFocusTraversal_readBack_child(Object st) {
    throw new UnsupportedOperationException("ExcludeFocusTraversal_readBack_child read-back requires FFM/java22");
  }

  default int autofillGroupAutofillGroup(Widget child, Optional<AutofillContextAction> onDisposeAction) {
    throw new UnsupportedOperationException("autofillGroupAutofillGroup has no default (FFM/comm impl required)");
  }
  default Widget AutofillGroup_readBack_child(Object st) {
    throw new UnsupportedOperationException("AutofillGroup_readBack_child read-back requires FFM/java22");
  }
  default AutofillContextAction AutofillGroup_readBack_onDisposeAction(Object st) {
    throw new UnsupportedOperationException("AutofillGroup_readBack_onDisposeAction read-back requires FFM/java22");
  }

  default int positionedDirectionalPositionedDirectional(OptionalDouble start, OptionalDouble top, OptionalDouble end, OptionalDouble bottom, OptionalDouble width, OptionalDouble height, Widget child) {
    throw new UnsupportedOperationException("positionedDirectionalPositionedDirectional has no default (FFM/comm impl required)");
  }
  default double PositionedDirectional_readBack_start(Object st) {
    throw new UnsupportedOperationException("PositionedDirectional_readBack_start read-back requires FFM/java22");
  }
  default double PositionedDirectional_readBack_top(Object st) {
    throw new UnsupportedOperationException("PositionedDirectional_readBack_top read-back requires FFM/java22");
  }
  default double PositionedDirectional_readBack_end(Object st) {
    throw new UnsupportedOperationException("PositionedDirectional_readBack_end read-back requires FFM/java22");
  }
  default double PositionedDirectional_readBack_bottom(Object st) {
    throw new UnsupportedOperationException("PositionedDirectional_readBack_bottom read-back requires FFM/java22");
  }
  default double PositionedDirectional_readBack_width(Object st) {
    throw new UnsupportedOperationException("PositionedDirectional_readBack_width read-back requires FFM/java22");
  }
  default double PositionedDirectional_readBack_height(Object st) {
    throw new UnsupportedOperationException("PositionedDirectional_readBack_height read-back requires FFM/java22");
  }
  default Widget PositionedDirectional_readBack_child(Object st) {
    throw new UnsupportedOperationException("PositionedDirectional_readBack_child read-back requires FFM/java22");
  }

  default int verticalDividerVerticalDivider(OptionalDouble width, OptionalDouble thickness, OptionalDouble indent, OptionalDouble endIndent, Optional<Color> color, Optional<BorderRadiusGeometry> radius) {
    throw new UnsupportedOperationException("verticalDividerVerticalDivider has no default (FFM/comm impl required)");
  }
  default double VerticalDivider_readBack_width(Object st) {
    throw new UnsupportedOperationException("VerticalDivider_readBack_width read-back requires FFM/java22");
  }
  default double VerticalDivider_readBack_thickness(Object st) {
    throw new UnsupportedOperationException("VerticalDivider_readBack_thickness read-back requires FFM/java22");
  }
  default double VerticalDivider_readBack_indent(Object st) {
    throw new UnsupportedOperationException("VerticalDivider_readBack_indent read-back requires FFM/java22");
  }
  default double VerticalDivider_readBack_endIndent(Object st) {
    throw new UnsupportedOperationException("VerticalDivider_readBack_endIndent read-back requires FFM/java22");
  }
  default Color VerticalDivider_readBack_color(Object st) {
    throw new UnsupportedOperationException("VerticalDivider_readBack_color read-back requires FFM/java22");
  }
  default BorderRadiusGeometry VerticalDivider_readBack_radius(Object st) {
    throw new UnsupportedOperationException("VerticalDivider_readBack_radius read-back requires FFM/java22");
  }

  default int expandIconExpandIcon(Optional<Boolean> isExpanded, OptionalDouble size, Optional<Consumer<Boolean>> onPressed, Optional<EdgeInsetsGeometry> padding, Optional<Color> color, Optional<Color> disabledColor, Optional<Color> expandedColor, Optional<Color> splashColor, Optional<Color> highlightColor) {
    throw new UnsupportedOperationException("expandIconExpandIcon has no default (FFM/comm impl required)");
  }
  default boolean ExpandIcon_readBack_isExpanded(Object st) {
    throw new UnsupportedOperationException("ExpandIcon_readBack_isExpanded read-back requires FFM/java22");
  }
  default double ExpandIcon_readBack_size(Object st) {
    throw new UnsupportedOperationException("ExpandIcon_readBack_size read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry ExpandIcon_readBack_padding(Object st) {
    throw new UnsupportedOperationException("ExpandIcon_readBack_padding read-back requires FFM/java22");
  }
  default Color ExpandIcon_readBack_color(Object st) {
    throw new UnsupportedOperationException("ExpandIcon_readBack_color read-back requires FFM/java22");
  }
  default Color ExpandIcon_readBack_disabledColor(Object st) {
    throw new UnsupportedOperationException("ExpandIcon_readBack_disabledColor read-back requires FFM/java22");
  }
  default Color ExpandIcon_readBack_expandedColor(Object st) {
    throw new UnsupportedOperationException("ExpandIcon_readBack_expandedColor read-back requires FFM/java22");
  }
  default Color ExpandIcon_readBack_splashColor(Object st) {
    throw new UnsupportedOperationException("ExpandIcon_readBack_splashColor read-back requires FFM/java22");
  }
  default Color ExpandIcon_readBack_highlightColor(Object st) {
    throw new UnsupportedOperationException("ExpandIcon_readBack_highlightColor read-back requires FFM/java22");
  }

  default int sliverPaddingSliverPadding(EdgeInsetsGeometry padding, Optional<Widget> sliver) {
    throw new UnsupportedOperationException("sliverPaddingSliverPadding has no default (FFM/comm impl required)");
  }
  default EdgeInsetsGeometry SliverPadding_readBack_padding(Object st) {
    throw new UnsupportedOperationException("SliverPadding_readBack_padding read-back requires FFM/java22");
  }

  default int sliverOpacitySliverOpacity(double opacity, Optional<Boolean> alwaysIncludeSemantics, Optional<Widget> sliver) {
    throw new UnsupportedOperationException("sliverOpacitySliverOpacity has no default (FFM/comm impl required)");
  }
  default double SliverOpacity_readBack_opacity(Object st) {
    throw new UnsupportedOperationException("SliverOpacity_readBack_opacity read-back requires FFM/java22");
  }
  default boolean SliverOpacity_readBack_alwaysIncludeSemantics(Object st) {
    throw new UnsupportedOperationException("SliverOpacity_readBack_alwaysIncludeSemantics read-back requires FFM/java22");
  }

  default int sliverIgnorePointerSliverIgnorePointer(Optional<Boolean> ignoring, Optional<Boolean> ignoringSemantics, Optional<Widget> sliver) {
    throw new UnsupportedOperationException("sliverIgnorePointerSliverIgnorePointer has no default (FFM/comm impl required)");
  }
  default boolean SliverIgnorePointer_readBack_ignoring(Object st) {
    throw new UnsupportedOperationException("SliverIgnorePointer_readBack_ignoring read-back requires FFM/java22");
  }
  default boolean SliverIgnorePointer_readBack_ignoringSemantics(Object st) {
    throw new UnsupportedOperationException("SliverIgnorePointer_readBack_ignoringSemantics read-back requires FFM/java22");
  }

  default int sliverOffstageSliverOffstage(Optional<Boolean> offstage, Optional<Widget> sliver) {
    throw new UnsupportedOperationException("sliverOffstageSliverOffstage has no default (FFM/comm impl required)");
  }
  default boolean SliverOffstage_readBack_offstage(Object st) {
    throw new UnsupportedOperationException("SliverOffstage_readBack_offstage read-back requires FFM/java22");
  }

  default int sliverSafeAreaSliverSafeArea(Optional<Boolean> left, Optional<Boolean> top, Optional<Boolean> right, Optional<Boolean> bottom, Optional<EdgeInsets> minimum, Widget sliver) {
    throw new UnsupportedOperationException("sliverSafeAreaSliverSafeArea has no default (FFM/comm impl required)");
  }
  default boolean SliverSafeArea_readBack_left(Object st) {
    throw new UnsupportedOperationException("SliverSafeArea_readBack_left read-back requires FFM/java22");
  }
  default boolean SliverSafeArea_readBack_top(Object st) {
    throw new UnsupportedOperationException("SliverSafeArea_readBack_top read-back requires FFM/java22");
  }
  default boolean SliverSafeArea_readBack_right(Object st) {
    throw new UnsupportedOperationException("SliverSafeArea_readBack_right read-back requires FFM/java22");
  }
  default boolean SliverSafeArea_readBack_bottom(Object st) {
    throw new UnsupportedOperationException("SliverSafeArea_readBack_bottom read-back requires FFM/java22");
  }
  default EdgeInsets SliverSafeArea_readBack_minimum(Object st) {
    throw new UnsupportedOperationException("SliverSafeArea_readBack_minimum read-back requires FFM/java22");
  }
  default Widget SliverSafeArea_readBack_sliver(Object st) {
    throw new UnsupportedOperationException("SliverSafeArea_readBack_sliver read-back requires FFM/java22");
  }

  default int sliverVisibilitySliverVisibility(Widget sliver, Optional<Widget> replacementSliver, Optional<Boolean> visible, Optional<Boolean> maintainState, Optional<Boolean> maintainAnimation, Optional<Boolean> maintainSize, Optional<Boolean> maintainSemantics, Optional<Boolean> maintainInteractivity) {
    throw new UnsupportedOperationException("sliverVisibilitySliverVisibility has no default (FFM/comm impl required)");
  }
  default int sliverVisibilityMaintain(Widget sliver, Optional<Widget> replacementSliver, Optional<Boolean> visible) {
    throw new UnsupportedOperationException("sliverVisibilityMaintain has no default (FFM/comm impl required)");
  }
  default Widget SliverVisibility_readBack_sliver(Object st) {
    throw new UnsupportedOperationException("SliverVisibility_readBack_sliver read-back requires FFM/java22");
  }
  default Widget SliverVisibility_readBack_replacementSliver(Object st) {
    throw new UnsupportedOperationException("SliverVisibility_readBack_replacementSliver read-back requires FFM/java22");
  }
  default boolean SliverVisibility_readBack_visible(Object st) {
    throw new UnsupportedOperationException("SliverVisibility_readBack_visible read-back requires FFM/java22");
  }
  default boolean SliverVisibility_readBack_maintainState(Object st) {
    throw new UnsupportedOperationException("SliverVisibility_readBack_maintainState read-back requires FFM/java22");
  }
  default boolean SliverVisibility_readBack_maintainAnimation(Object st) {
    throw new UnsupportedOperationException("SliverVisibility_readBack_maintainAnimation read-back requires FFM/java22");
  }
  default boolean SliverVisibility_readBack_maintainSize(Object st) {
    throw new UnsupportedOperationException("SliverVisibility_readBack_maintainSize read-back requires FFM/java22");
  }
  default boolean SliverVisibility_readBack_maintainSemantics(Object st) {
    throw new UnsupportedOperationException("SliverVisibility_readBack_maintainSemantics read-back requires FFM/java22");
  }
  default boolean SliverVisibility_readBack_maintainInteractivity(Object st) {
    throw new UnsupportedOperationException("SliverVisibility_readBack_maintainInteractivity read-back requires FFM/java22");
  }

  default int sliverMainAxisGroupSliverMainAxisGroup(List<Widget> slivers) {
    throw new UnsupportedOperationException("sliverMainAxisGroupSliverMainAxisGroup has no default (FFM/comm impl required)");
  }

  default int sliverCrossAxisGroupSliverCrossAxisGroup(List<Widget> slivers) {
    throw new UnsupportedOperationException("sliverCrossAxisGroupSliverCrossAxisGroup has no default (FFM/comm impl required)");
  }

  default int sliverFillRemainingSliverFillRemaining(Optional<Widget> child, Optional<Boolean> hasScrollBody, Optional<Boolean> fillOverscroll) {
    throw new UnsupportedOperationException("sliverFillRemainingSliverFillRemaining has no default (FFM/comm impl required)");
  }
  default Widget SliverFillRemaining_readBack_child(Object st) {
    throw new UnsupportedOperationException("SliverFillRemaining_readBack_child read-back requires FFM/java22");
  }
  default boolean SliverFillRemaining_readBack_hasScrollBody(Object st) {
    throw new UnsupportedOperationException("SliverFillRemaining_readBack_hasScrollBody read-back requires FFM/java22");
  }
  default boolean SliverFillRemaining_readBack_fillOverscroll(Object st) {
    throw new UnsupportedOperationException("SliverFillRemaining_readBack_fillOverscroll read-back requires FFM/java22");
  }

  default int sliverEnsureSemanticsSliverEnsureSemantics(Widget sliver) {
    throw new UnsupportedOperationException("sliverEnsureSemanticsSliverEnsureSemantics has no default (FFM/comm impl required)");
  }

  default int sliverConstrainedCrossAxisSliverConstrainedCrossAxis(double maxExtent, Widget sliver) {
    throw new UnsupportedOperationException("sliverConstrainedCrossAxisSliverConstrainedCrossAxis has no default (FFM/comm impl required)");
  }
  default double SliverConstrainedCrossAxis_readBack_maxExtent(Object st) {
    throw new UnsupportedOperationException("SliverConstrainedCrossAxis_readBack_maxExtent read-back requires FFM/java22");
  }
  default Widget SliverConstrainedCrossAxis_readBack_sliver(Object st) {
    throw new UnsupportedOperationException("SliverConstrainedCrossAxis_readBack_sliver read-back requires FFM/java22");
  }

  default int customScrollViewCustomScrollView(Optional<Axis> scrollDirection, Optional<Boolean> reverse, Optional<Boolean> primary, Optional<Boolean> shrinkWrap, OptionalDouble anchor, OptionalDouble cacheExtent, Optional<SliverPaintOrder> paintOrder, Optional<List<Widget>> slivers, OptionalInt semanticChildCount, Optional<DragStartBehavior> dragStartBehavior, Optional<ScrollViewKeyboardDismissBehavior> keyboardDismissBehavior, Optional<String> restorationId, Optional<Clip> clipBehavior, Optional<HitTestBehavior> hitTestBehavior) {
    throw new UnsupportedOperationException("customScrollViewCustomScrollView has no default (FFM/comm impl required)");
  }

  default int drawerHeaderDrawerHeader(Optional<Decoration> decoration, Optional<EdgeInsetsGeometry> margin, Optional<EdgeInsetsGeometry> padding, Optional<Duration> duration, Optional<Curve> curve, Optional<Widget> child) {
    throw new UnsupportedOperationException("drawerHeaderDrawerHeader has no default (FFM/comm impl required)");
  }
  default Decoration DrawerHeader_readBack_decoration(Object st) {
    throw new UnsupportedOperationException("DrawerHeader_readBack_decoration read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry DrawerHeader_readBack_padding(Object st) {
    throw new UnsupportedOperationException("DrawerHeader_readBack_padding read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry DrawerHeader_readBack_margin(Object st) {
    throw new UnsupportedOperationException("DrawerHeader_readBack_margin read-back requires FFM/java22");
  }
  default Duration DrawerHeader_readBack_duration(Object st) {
    throw new UnsupportedOperationException("DrawerHeader_readBack_duration read-back requires FFM/java22");
  }
  default Curve DrawerHeader_readBack_curve(Object st) {
    throw new UnsupportedOperationException("DrawerHeader_readBack_curve read-back requires FFM/java22");
  }
  default Widget DrawerHeader_readBack_child(Object st) {
    throw new UnsupportedOperationException("DrawerHeader_readBack_child read-back requires FFM/java22");
  }

  default int selectionAreaSelectionArea(Widget child) {
    throw new UnsupportedOperationException("selectionAreaSelectionArea has no default (FFM/comm impl required)");
  }
  default Widget SelectionArea_readBack_child(Object st) {
    throw new UnsupportedOperationException("SelectionArea_readBack_child read-back requires FFM/java22");
  }

  default int sizeChangedLayoutNotifierSizeChangedLayoutNotifier(Optional<Widget> child) {
    throw new UnsupportedOperationException("sizeChangedLayoutNotifierSizeChangedLayoutNotifier has no default (FFM/comm impl required)");
  }

  default int draggableScrollableActuatorDraggableScrollableActuator(Widget child) {
    throw new UnsupportedOperationException("draggableScrollableActuatorDraggableScrollableActuator has no default (FFM/comm impl required)");
  }
  default int draggableScrollableActuatorReset(BuildContext context) {
    throw new UnsupportedOperationException("draggableScrollableActuatorReset has no default (FFM/comm impl required)");
  }
  default Widget DraggableScrollableActuator_readBack_child(Object st) {
    throw new UnsupportedOperationException("DraggableScrollableActuator_readBack_child read-back requires FFM/java22");
  }

  default int scrollNotificationObserverScrollNotificationObserver(Widget child) {
    throw new UnsupportedOperationException("scrollNotificationObserverScrollNotificationObserver has no default (FFM/comm impl required)");
  }
  default Widget ScrollNotificationObserver_readBack_child(Object st) {
    throw new UnsupportedOperationException("ScrollNotificationObserver_readBack_child read-back requires FFM/java22");
  }

  default int modalBarrierModalBarrier(Optional<Color> color, Optional<Boolean> dismissible, Optional<Runnable> onDismiss, Optional<String> semanticsLabel, Optional<Boolean> barrierSemanticsDismissible, Optional<String> semanticsOnTapHint) {
    throw new UnsupportedOperationException("modalBarrierModalBarrier has no default (FFM/comm impl required)");
  }
  default Color ModalBarrier_readBack_color(Object st) {
    throw new UnsupportedOperationException("ModalBarrier_readBack_color read-back requires FFM/java22");
  }
  default boolean ModalBarrier_readBack_dismissible(Object st) {
    throw new UnsupportedOperationException("ModalBarrier_readBack_dismissible read-back requires FFM/java22");
  }
  default boolean ModalBarrier_readBack_barrierSemanticsDismissible(Object st) {
    throw new UnsupportedOperationException("ModalBarrier_readBack_barrierSemanticsDismissible read-back requires FFM/java22");
  }
  default String ModalBarrier_readBack_semanticsLabel(Object st) {
    throw new UnsupportedOperationException("ModalBarrier_readBack_semanticsLabel read-back requires FFM/java22");
  }
  default String ModalBarrier_readBack_semanticsOnTapHint(Object st) {
    throw new UnsupportedOperationException("ModalBarrier_readBack_semanticsOnTapHint read-back requires FFM/java22");
  }

  default int listenerListener(Optional<Consumer<PointerDownEvent>> onPointerDown, Optional<Consumer<PointerUpEvent>> onPointerUp, Optional<Consumer<PointerHoverEvent>> onPointerHover, Optional<HitTestBehavior> behavior, Optional<Widget> child) {
    throw new UnsupportedOperationException("listenerListener has no default (FFM/comm impl required)");
  }
  default HitTestBehavior Listener_readBack_behavior(Object st) {
    throw new UnsupportedOperationException("Listener_readBack_behavior read-back requires FFM/java22");
  }

  default int overflowBarOverflowBar(OptionalDouble spacing, Optional<MainAxisAlignment> alignment, OptionalDouble overflowSpacing, Optional<OverflowBarAlignment> overflowAlignment, Optional<VerticalDirection> overflowDirection, Optional<TextDirection> textDirection, Optional<List<Widget>> children) {
    throw new UnsupportedOperationException("overflowBarOverflowBar has no default (FFM/comm impl required)");
  }
  default double OverflowBar_readBack_spacing(Object st) {
    throw new UnsupportedOperationException("OverflowBar_readBack_spacing read-back requires FFM/java22");
  }
  default MainAxisAlignment OverflowBar_readBack_alignment(Object st) {
    throw new UnsupportedOperationException("OverflowBar_readBack_alignment read-back requires FFM/java22");
  }
  default double OverflowBar_readBack_overflowSpacing(Object st) {
    throw new UnsupportedOperationException("OverflowBar_readBack_overflowSpacing read-back requires FFM/java22");
  }
  default OverflowBarAlignment OverflowBar_readBack_overflowAlignment(Object st) {
    throw new UnsupportedOperationException("OverflowBar_readBack_overflowAlignment read-back requires FFM/java22");
  }
  default VerticalDirection OverflowBar_readBack_overflowDirection(Object st) {
    throw new UnsupportedOperationException("OverflowBar_readBack_overflowDirection read-back requires FFM/java22");
  }
  default TextDirection OverflowBar_readBack_textDirection(Object st) {
    throw new UnsupportedOperationException("OverflowBar_readBack_textDirection read-back requires FFM/java22");
  }

  default int defaultSelectionStyleDefaultSelectionStyle(Optional<Color> cursorColor, Optional<Color> selectionColor, Widget child) {
    throw new UnsupportedOperationException("defaultSelectionStyleDefaultSelectionStyle has no default (FFM/comm impl required)");
  }
  default int defaultSelectionStyleFallback() {
    throw new UnsupportedOperationException("defaultSelectionStyleFallback has no default (FFM/comm impl required)");
  }
  default int defaultSelectionStyleMerge(Optional<Color> cursorColor, Optional<Color> selectionColor, Widget child) {
    throw new UnsupportedOperationException("defaultSelectionStyleMerge has no default (FFM/comm impl required)");
  }
  default int defaultSelectionStyleOf(BuildContext context) {
    throw new UnsupportedOperationException("defaultSelectionStyleOf has no default (FFM/comm impl required)");
  }
  default Color DefaultSelectionStyle_readBack_cursorColor(Object st) {
    throw new UnsupportedOperationException("DefaultSelectionStyle_readBack_cursorColor read-back requires FFM/java22");
  }
  default Color DefaultSelectionStyle_readBack_selectionColor(Object st) {
    throw new UnsupportedOperationException("DefaultSelectionStyle_readBack_selectionColor read-back requires FFM/java22");
  }

  default int inkInk(Optional<EdgeInsetsGeometry> padding, Optional<Color> color, Optional<Decoration> decoration, OptionalDouble width, OptionalDouble height, Optional<Widget> child) {
    throw new UnsupportedOperationException("inkInk has no default (FFM/comm impl required)");
  }
  default Widget Ink_readBack_child(Object st) {
    throw new UnsupportedOperationException("Ink_readBack_child read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry Ink_readBack_padding(Object st) {
    throw new UnsupportedOperationException("Ink_readBack_padding read-back requires FFM/java22");
  }
  default Decoration Ink_readBack_decoration(Object st) {
    throw new UnsupportedOperationException("Ink_readBack_decoration read-back requires FFM/java22");
  }
  default double Ink_readBack_width(Object st) {
    throw new UnsupportedOperationException("Ink_readBack_width read-back requires FFM/java22");
  }
  default double Ink_readBack_height(Object st) {
    throw new UnsupportedOperationException("Ink_readBack_height read-back requires FFM/java22");
  }

  default int bottomAppBarBottomAppBar(Optional<Color> color, OptionalDouble elevation, Optional<Clip> clipBehavior, OptionalDouble notchMargin, Optional<Widget> child, Optional<EdgeInsetsGeometry> padding, Optional<Color> surfaceTintColor, Optional<Color> shadowColor, OptionalDouble height) {
    throw new UnsupportedOperationException("bottomAppBarBottomAppBar has no default (FFM/comm impl required)");
  }
  default Widget BottomAppBar_readBack_child(Object st) {
    throw new UnsupportedOperationException("BottomAppBar_readBack_child read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry BottomAppBar_readBack_padding(Object st) {
    throw new UnsupportedOperationException("BottomAppBar_readBack_padding read-back requires FFM/java22");
  }
  default Color BottomAppBar_readBack_color(Object st) {
    throw new UnsupportedOperationException("BottomAppBar_readBack_color read-back requires FFM/java22");
  }
  default double BottomAppBar_readBack_elevation(Object st) {
    throw new UnsupportedOperationException("BottomAppBar_readBack_elevation read-back requires FFM/java22");
  }
  default Clip BottomAppBar_readBack_clipBehavior(Object st) {
    throw new UnsupportedOperationException("BottomAppBar_readBack_clipBehavior read-back requires FFM/java22");
  }
  default double BottomAppBar_readBack_notchMargin(Object st) {
    throw new UnsupportedOperationException("BottomAppBar_readBack_notchMargin read-back requires FFM/java22");
  }
  default Color BottomAppBar_readBack_surfaceTintColor(Object st) {
    throw new UnsupportedOperationException("BottomAppBar_readBack_surfaceTintColor read-back requires FFM/java22");
  }
  default Color BottomAppBar_readBack_shadowColor(Object st) {
    throw new UnsupportedOperationException("BottomAppBar_readBack_shadowColor read-back requires FFM/java22");
  }
  default double BottomAppBar_readBack_height(Object st) {
    throw new UnsupportedOperationException("BottomAppBar_readBack_height read-back requires FFM/java22");
  }

  default int choiceChipChoiceChip(Optional<Widget> avatar, Widget label, Optional<TextStyle> labelStyle, Optional<EdgeInsetsGeometry> labelPadding, Optional<Consumer<Boolean>> onSelected, OptionalDouble pressElevation, boolean selected, Optional<Color> selectedColor, Optional<Color> disabledColor, Optional<String> tooltip, Optional<BorderSide> side, Optional<OutlinedBorder> shape, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, Optional<Color> color, Optional<Color> backgroundColor, Optional<EdgeInsetsGeometry> padding, Optional<VisualDensity> visualDensity, Optional<MaterialTapTargetSize> materialTapTargetSize, OptionalDouble elevation, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, Optional<IconThemeData> iconTheme, Optional<Color> selectedShadowColor, Optional<Boolean> showCheckmark, Optional<Color> checkmarkColor, Optional<ShapeBorder> avatarBorder, Optional<BoxConstraints> avatarBoxConstraints) {
    throw new UnsupportedOperationException("choiceChipChoiceChip has no default (FFM/comm impl required)");
  }
  default int choiceChipElevated(Optional<Widget> avatar, Widget label, Optional<TextStyle> labelStyle, Optional<EdgeInsetsGeometry> labelPadding, Optional<Consumer<Boolean>> onSelected, OptionalDouble pressElevation, boolean selected, Optional<Color> selectedColor, Optional<Color> disabledColor, Optional<String> tooltip, Optional<BorderSide> side, Optional<OutlinedBorder> shape, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, Optional<Color> color, Optional<Color> backgroundColor, Optional<EdgeInsetsGeometry> padding, Optional<VisualDensity> visualDensity, Optional<MaterialTapTargetSize> materialTapTargetSize, OptionalDouble elevation, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, Optional<IconThemeData> iconTheme, Optional<Color> selectedShadowColor, Optional<Boolean> showCheckmark, Optional<Color> checkmarkColor, Optional<ShapeBorder> avatarBorder, Optional<BoxConstraints> avatarBoxConstraints) {
    throw new UnsupportedOperationException("choiceChipElevated has no default (FFM/comm impl required)");
  }
  default Widget ChoiceChip_readBack_avatar(Object st) {
    throw new UnsupportedOperationException("ChoiceChip_readBack_avatar read-back requires FFM/java22");
  }
  default Widget ChoiceChip_readBack_label(Object st) {
    throw new UnsupportedOperationException("ChoiceChip_readBack_label read-back requires FFM/java22");
  }
  default TextStyle ChoiceChip_readBack_labelStyle(Object st) {
    throw new UnsupportedOperationException("ChoiceChip_readBack_labelStyle read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry ChoiceChip_readBack_labelPadding(Object st) {
    throw new UnsupportedOperationException("ChoiceChip_readBack_labelPadding read-back requires FFM/java22");
  }
  default double ChoiceChip_readBack_pressElevation(Object st) {
    throw new UnsupportedOperationException("ChoiceChip_readBack_pressElevation read-back requires FFM/java22");
  }
  default boolean ChoiceChip_readBack_selected(Object st) {
    throw new UnsupportedOperationException("ChoiceChip_readBack_selected read-back requires FFM/java22");
  }
  default Color ChoiceChip_readBack_disabledColor(Object st) {
    throw new UnsupportedOperationException("ChoiceChip_readBack_disabledColor read-back requires FFM/java22");
  }
  default Color ChoiceChip_readBack_selectedColor(Object st) {
    throw new UnsupportedOperationException("ChoiceChip_readBack_selectedColor read-back requires FFM/java22");
  }
  default String ChoiceChip_readBack_tooltip(Object st) {
    throw new UnsupportedOperationException("ChoiceChip_readBack_tooltip read-back requires FFM/java22");
  }
  default BorderSide ChoiceChip_readBack_side(Object st) {
    throw new UnsupportedOperationException("ChoiceChip_readBack_side read-back requires FFM/java22");
  }
  default OutlinedBorder ChoiceChip_readBack_shape(Object st) {
    throw new UnsupportedOperationException("ChoiceChip_readBack_shape read-back requires FFM/java22");
  }
  default Clip ChoiceChip_readBack_clipBehavior(Object st) {
    throw new UnsupportedOperationException("ChoiceChip_readBack_clipBehavior read-back requires FFM/java22");
  }
  default boolean ChoiceChip_readBack_autofocus(Object st) {
    throw new UnsupportedOperationException("ChoiceChip_readBack_autofocus read-back requires FFM/java22");
  }
  default Color ChoiceChip_readBack_backgroundColor(Object st) {
    throw new UnsupportedOperationException("ChoiceChip_readBack_backgroundColor read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry ChoiceChip_readBack_padding(Object st) {
    throw new UnsupportedOperationException("ChoiceChip_readBack_padding read-back requires FFM/java22");
  }
  default VisualDensity ChoiceChip_readBack_visualDensity(Object st) {
    throw new UnsupportedOperationException("ChoiceChip_readBack_visualDensity read-back requires FFM/java22");
  }
  default MaterialTapTargetSize ChoiceChip_readBack_materialTapTargetSize(Object st) {
    throw new UnsupportedOperationException("ChoiceChip_readBack_materialTapTargetSize read-back requires FFM/java22");
  }
  default double ChoiceChip_readBack_elevation(Object st) {
    throw new UnsupportedOperationException("ChoiceChip_readBack_elevation read-back requires FFM/java22");
  }
  default Color ChoiceChip_readBack_shadowColor(Object st) {
    throw new UnsupportedOperationException("ChoiceChip_readBack_shadowColor read-back requires FFM/java22");
  }
  default Color ChoiceChip_readBack_surfaceTintColor(Object st) {
    throw new UnsupportedOperationException("ChoiceChip_readBack_surfaceTintColor read-back requires FFM/java22");
  }
  default Color ChoiceChip_readBack_selectedShadowColor(Object st) {
    throw new UnsupportedOperationException("ChoiceChip_readBack_selectedShadowColor read-back requires FFM/java22");
  }
  default boolean ChoiceChip_readBack_showCheckmark(Object st) {
    throw new UnsupportedOperationException("ChoiceChip_readBack_showCheckmark read-back requires FFM/java22");
  }
  default Color ChoiceChip_readBack_checkmarkColor(Object st) {
    throw new UnsupportedOperationException("ChoiceChip_readBack_checkmarkColor read-back requires FFM/java22");
  }
  default ShapeBorder ChoiceChip_readBack_avatarBorder(Object st) {
    throw new UnsupportedOperationException("ChoiceChip_readBack_avatarBorder read-back requires FFM/java22");
  }
  default IconThemeData ChoiceChip_readBack_iconTheme(Object st) {
    throw new UnsupportedOperationException("ChoiceChip_readBack_iconTheme read-back requires FFM/java22");
  }
  default BoxConstraints ChoiceChip_readBack_avatarBoxConstraints(Object st) {
    throw new UnsupportedOperationException("ChoiceChip_readBack_avatarBoxConstraints read-back requires FFM/java22");
  }

  default int visualDensityVisualDensity(OptionalDouble horizontal, OptionalDouble vertical) {
    throw new UnsupportedOperationException("visualDensityVisualDensity has no default (FFM/comm impl required)");
  }
  default int visualDensityDefaultDensityForPlatform(TargetPlatform platform) {
    throw new UnsupportedOperationException("visualDensityDefaultDensityForPlatform has no default (FFM/comm impl required)");
  }
  default int visualDensityLerp(VisualDensity a, VisualDensity b, double t) {
    throw new UnsupportedOperationException("visualDensityLerp has no default (FFM/comm impl required)");
  }
  default double VisualDensity_readBack_horizontal(Object st) {
    throw new UnsupportedOperationException("VisualDensity_readBack_horizontal read-back requires FFM/java22");
  }
  default double VisualDensity_readBack_vertical(Object st) {
    throw new UnsupportedOperationException("VisualDensity_readBack_vertical read-back requires FFM/java22");
  }
  default Offset VisualDensity_readBack_baseSizeAdjustment(Object st) {
    throw new UnsupportedOperationException("VisualDensity_readBack_baseSizeAdjustment read-back requires FFM/java22");
  }

  default int iconThemeDataIconThemeData(OptionalDouble size, OptionalDouble fill, OptionalDouble weight, OptionalDouble grade, OptionalDouble opticalSize, Optional<Color> color, OptionalDouble opacity, Optional<List<Shadow>> shadows, Optional<Boolean> applyTextScaling) {
    throw new UnsupportedOperationException("iconThemeDataIconThemeData has no default (FFM/comm impl required)");
  }
  default int iconThemeDataFallback() {
    throw new UnsupportedOperationException("iconThemeDataFallback has no default (FFM/comm impl required)");
  }
  default int iconThemeDataLerp(IconThemeData a, IconThemeData b, double t) {
    throw new UnsupportedOperationException("iconThemeDataLerp has no default (FFM/comm impl required)");
  }
  default double IconThemeData_readBack_size(Object st) {
    throw new UnsupportedOperationException("IconThemeData_readBack_size read-back requires FFM/java22");
  }
  default double IconThemeData_readBack_fill(Object st) {
    throw new UnsupportedOperationException("IconThemeData_readBack_fill read-back requires FFM/java22");
  }
  default double IconThemeData_readBack_weight(Object st) {
    throw new UnsupportedOperationException("IconThemeData_readBack_weight read-back requires FFM/java22");
  }
  default double IconThemeData_readBack_grade(Object st) {
    throw new UnsupportedOperationException("IconThemeData_readBack_grade read-back requires FFM/java22");
  }
  default double IconThemeData_readBack_opticalSize(Object st) {
    throw new UnsupportedOperationException("IconThemeData_readBack_opticalSize read-back requires FFM/java22");
  }
  default Color IconThemeData_readBack_color(Object st) {
    throw new UnsupportedOperationException("IconThemeData_readBack_color read-back requires FFM/java22");
  }
  default boolean IconThemeData_readBack_applyTextScaling(Object st) {
    throw new UnsupportedOperationException("IconThemeData_readBack_applyTextScaling read-back requires FFM/java22");
  }
  default boolean IconThemeData_readBack_isConcrete(Object st) {
    throw new UnsupportedOperationException("IconThemeData_readBack_isConcrete read-back requires FFM/java22");
  }
  default double IconThemeData_readBack_opacity(Object st) {
    throw new UnsupportedOperationException("IconThemeData_readBack_opacity read-back requires FFM/java22");
  }

  default int filterChipFilterChip(Optional<Widget> avatar, Widget label, Optional<TextStyle> labelStyle, Optional<EdgeInsetsGeometry> labelPadding, Optional<Boolean> selected, Optional<Consumer<Boolean>> onSelected, Optional<Widget> deleteIcon, Optional<Runnable> onDeleted, Optional<Color> deleteIconColor, Optional<String> deleteButtonTooltipMessage, OptionalDouble pressElevation, Optional<Color> disabledColor, Optional<Color> selectedColor, Optional<String> tooltip, Optional<BorderSide> side, Optional<OutlinedBorder> shape, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, Optional<Color> color, Optional<Color> backgroundColor, Optional<EdgeInsetsGeometry> padding, Optional<VisualDensity> visualDensity, Optional<MaterialTapTargetSize> materialTapTargetSize, OptionalDouble elevation, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, Optional<IconThemeData> iconTheme, Optional<Color> selectedShadowColor, Optional<Boolean> showCheckmark, Optional<Color> checkmarkColor, Optional<ShapeBorder> avatarBorder, Optional<BoxConstraints> avatarBoxConstraints, Optional<BoxConstraints> deleteIconBoxConstraints) {
    throw new UnsupportedOperationException("filterChipFilterChip has no default (FFM/comm impl required)");
  }
  default int filterChipElevated(Optional<Widget> avatar, Widget label, Optional<TextStyle> labelStyle, Optional<EdgeInsetsGeometry> labelPadding, Optional<Boolean> selected, Optional<Consumer<Boolean>> onSelected, Optional<Widget> deleteIcon, Optional<Runnable> onDeleted, Optional<Color> deleteIconColor, Optional<String> deleteButtonTooltipMessage, OptionalDouble pressElevation, Optional<Color> disabledColor, Optional<Color> selectedColor, Optional<String> tooltip, Optional<BorderSide> side, Optional<OutlinedBorder> shape, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, Optional<Color> color, Optional<Color> backgroundColor, Optional<EdgeInsetsGeometry> padding, Optional<VisualDensity> visualDensity, Optional<MaterialTapTargetSize> materialTapTargetSize, OptionalDouble elevation, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, Optional<IconThemeData> iconTheme, Optional<Color> selectedShadowColor, Optional<Boolean> showCheckmark, Optional<Color> checkmarkColor, Optional<ShapeBorder> avatarBorder, Optional<BoxConstraints> avatarBoxConstraints, Optional<BoxConstraints> deleteIconBoxConstraints) {
    throw new UnsupportedOperationException("filterChipElevated has no default (FFM/comm impl required)");
  }
  default Widget FilterChip_readBack_avatar(Object st) {
    throw new UnsupportedOperationException("FilterChip_readBack_avatar read-back requires FFM/java22");
  }
  default Widget FilterChip_readBack_label(Object st) {
    throw new UnsupportedOperationException("FilterChip_readBack_label read-back requires FFM/java22");
  }
  default TextStyle FilterChip_readBack_labelStyle(Object st) {
    throw new UnsupportedOperationException("FilterChip_readBack_labelStyle read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry FilterChip_readBack_labelPadding(Object st) {
    throw new UnsupportedOperationException("FilterChip_readBack_labelPadding read-back requires FFM/java22");
  }
  default boolean FilterChip_readBack_selected(Object st) {
    throw new UnsupportedOperationException("FilterChip_readBack_selected read-back requires FFM/java22");
  }
  default Widget FilterChip_readBack_deleteIcon(Object st) {
    throw new UnsupportedOperationException("FilterChip_readBack_deleteIcon read-back requires FFM/java22");
  }
  default Color FilterChip_readBack_deleteIconColor(Object st) {
    throw new UnsupportedOperationException("FilterChip_readBack_deleteIconColor read-back requires FFM/java22");
  }
  default String FilterChip_readBack_deleteButtonTooltipMessage(Object st) {
    throw new UnsupportedOperationException("FilterChip_readBack_deleteButtonTooltipMessage read-back requires FFM/java22");
  }
  default double FilterChip_readBack_pressElevation(Object st) {
    throw new UnsupportedOperationException("FilterChip_readBack_pressElevation read-back requires FFM/java22");
  }
  default Color FilterChip_readBack_disabledColor(Object st) {
    throw new UnsupportedOperationException("FilterChip_readBack_disabledColor read-back requires FFM/java22");
  }
  default Color FilterChip_readBack_selectedColor(Object st) {
    throw new UnsupportedOperationException("FilterChip_readBack_selectedColor read-back requires FFM/java22");
  }
  default String FilterChip_readBack_tooltip(Object st) {
    throw new UnsupportedOperationException("FilterChip_readBack_tooltip read-back requires FFM/java22");
  }
  default BorderSide FilterChip_readBack_side(Object st) {
    throw new UnsupportedOperationException("FilterChip_readBack_side read-back requires FFM/java22");
  }
  default OutlinedBorder FilterChip_readBack_shape(Object st) {
    throw new UnsupportedOperationException("FilterChip_readBack_shape read-back requires FFM/java22");
  }
  default Clip FilterChip_readBack_clipBehavior(Object st) {
    throw new UnsupportedOperationException("FilterChip_readBack_clipBehavior read-back requires FFM/java22");
  }
  default boolean FilterChip_readBack_autofocus(Object st) {
    throw new UnsupportedOperationException("FilterChip_readBack_autofocus read-back requires FFM/java22");
  }
  default Color FilterChip_readBack_backgroundColor(Object st) {
    throw new UnsupportedOperationException("FilterChip_readBack_backgroundColor read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry FilterChip_readBack_padding(Object st) {
    throw new UnsupportedOperationException("FilterChip_readBack_padding read-back requires FFM/java22");
  }
  default VisualDensity FilterChip_readBack_visualDensity(Object st) {
    throw new UnsupportedOperationException("FilterChip_readBack_visualDensity read-back requires FFM/java22");
  }
  default MaterialTapTargetSize FilterChip_readBack_materialTapTargetSize(Object st) {
    throw new UnsupportedOperationException("FilterChip_readBack_materialTapTargetSize read-back requires FFM/java22");
  }
  default double FilterChip_readBack_elevation(Object st) {
    throw new UnsupportedOperationException("FilterChip_readBack_elevation read-back requires FFM/java22");
  }
  default Color FilterChip_readBack_shadowColor(Object st) {
    throw new UnsupportedOperationException("FilterChip_readBack_shadowColor read-back requires FFM/java22");
  }
  default Color FilterChip_readBack_surfaceTintColor(Object st) {
    throw new UnsupportedOperationException("FilterChip_readBack_surfaceTintColor read-back requires FFM/java22");
  }
  default Color FilterChip_readBack_selectedShadowColor(Object st) {
    throw new UnsupportedOperationException("FilterChip_readBack_selectedShadowColor read-back requires FFM/java22");
  }
  default boolean FilterChip_readBack_showCheckmark(Object st) {
    throw new UnsupportedOperationException("FilterChip_readBack_showCheckmark read-back requires FFM/java22");
  }
  default Color FilterChip_readBack_checkmarkColor(Object st) {
    throw new UnsupportedOperationException("FilterChip_readBack_checkmarkColor read-back requires FFM/java22");
  }
  default ShapeBorder FilterChip_readBack_avatarBorder(Object st) {
    throw new UnsupportedOperationException("FilterChip_readBack_avatarBorder read-back requires FFM/java22");
  }
  default IconThemeData FilterChip_readBack_iconTheme(Object st) {
    throw new UnsupportedOperationException("FilterChip_readBack_iconTheme read-back requires FFM/java22");
  }
  default BoxConstraints FilterChip_readBack_avatarBoxConstraints(Object st) {
    throw new UnsupportedOperationException("FilterChip_readBack_avatarBoxConstraints read-back requires FFM/java22");
  }
  default BoxConstraints FilterChip_readBack_deleteIconBoxConstraints(Object st) {
    throw new UnsupportedOperationException("FilterChip_readBack_deleteIconBoxConstraints read-back requires FFM/java22");
  }

  default int actionChipActionChip(Optional<Widget> avatar, Widget label, Optional<TextStyle> labelStyle, Optional<EdgeInsetsGeometry> labelPadding, Optional<Runnable> onPressed, OptionalDouble pressElevation, Optional<String> tooltip, Optional<BorderSide> side, Optional<OutlinedBorder> shape, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, Optional<Color> color, Optional<Color> backgroundColor, Optional<Color> disabledColor, Optional<EdgeInsetsGeometry> padding, Optional<VisualDensity> visualDensity, Optional<MaterialTapTargetSize> materialTapTargetSize, OptionalDouble elevation, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, Optional<IconThemeData> iconTheme, Optional<BoxConstraints> avatarBoxConstraints) {
    throw new UnsupportedOperationException("actionChipActionChip has no default (FFM/comm impl required)");
  }
  default int actionChipElevated(Optional<Widget> avatar, Widget label, Optional<TextStyle> labelStyle, Optional<EdgeInsetsGeometry> labelPadding, Optional<Runnable> onPressed, OptionalDouble pressElevation, Optional<String> tooltip, Optional<BorderSide> side, Optional<OutlinedBorder> shape, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, Optional<Color> color, Optional<Color> backgroundColor, Optional<Color> disabledColor, Optional<EdgeInsetsGeometry> padding, Optional<VisualDensity> visualDensity, Optional<MaterialTapTargetSize> materialTapTargetSize, OptionalDouble elevation, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, Optional<IconThemeData> iconTheme, Optional<BoxConstraints> avatarBoxConstraints) {
    throw new UnsupportedOperationException("actionChipElevated has no default (FFM/comm impl required)");
  }
  default Widget ActionChip_readBack_avatar(Object st) {
    throw new UnsupportedOperationException("ActionChip_readBack_avatar read-back requires FFM/java22");
  }
  default Widget ActionChip_readBack_label(Object st) {
    throw new UnsupportedOperationException("ActionChip_readBack_label read-back requires FFM/java22");
  }
  default TextStyle ActionChip_readBack_labelStyle(Object st) {
    throw new UnsupportedOperationException("ActionChip_readBack_labelStyle read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry ActionChip_readBack_labelPadding(Object st) {
    throw new UnsupportedOperationException("ActionChip_readBack_labelPadding read-back requires FFM/java22");
  }
  default double ActionChip_readBack_pressElevation(Object st) {
    throw new UnsupportedOperationException("ActionChip_readBack_pressElevation read-back requires FFM/java22");
  }
  default String ActionChip_readBack_tooltip(Object st) {
    throw new UnsupportedOperationException("ActionChip_readBack_tooltip read-back requires FFM/java22");
  }
  default BorderSide ActionChip_readBack_side(Object st) {
    throw new UnsupportedOperationException("ActionChip_readBack_side read-back requires FFM/java22");
  }
  default OutlinedBorder ActionChip_readBack_shape(Object st) {
    throw new UnsupportedOperationException("ActionChip_readBack_shape read-back requires FFM/java22");
  }
  default Clip ActionChip_readBack_clipBehavior(Object st) {
    throw new UnsupportedOperationException("ActionChip_readBack_clipBehavior read-back requires FFM/java22");
  }
  default boolean ActionChip_readBack_autofocus(Object st) {
    throw new UnsupportedOperationException("ActionChip_readBack_autofocus read-back requires FFM/java22");
  }
  default Color ActionChip_readBack_backgroundColor(Object st) {
    throw new UnsupportedOperationException("ActionChip_readBack_backgroundColor read-back requires FFM/java22");
  }
  default Color ActionChip_readBack_disabledColor(Object st) {
    throw new UnsupportedOperationException("ActionChip_readBack_disabledColor read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry ActionChip_readBack_padding(Object st) {
    throw new UnsupportedOperationException("ActionChip_readBack_padding read-back requires FFM/java22");
  }
  default VisualDensity ActionChip_readBack_visualDensity(Object st) {
    throw new UnsupportedOperationException("ActionChip_readBack_visualDensity read-back requires FFM/java22");
  }
  default MaterialTapTargetSize ActionChip_readBack_materialTapTargetSize(Object st) {
    throw new UnsupportedOperationException("ActionChip_readBack_materialTapTargetSize read-back requires FFM/java22");
  }
  default double ActionChip_readBack_elevation(Object st) {
    throw new UnsupportedOperationException("ActionChip_readBack_elevation read-back requires FFM/java22");
  }
  default Color ActionChip_readBack_shadowColor(Object st) {
    throw new UnsupportedOperationException("ActionChip_readBack_shadowColor read-back requires FFM/java22");
  }
  default Color ActionChip_readBack_surfaceTintColor(Object st) {
    throw new UnsupportedOperationException("ActionChip_readBack_surfaceTintColor read-back requires FFM/java22");
  }
  default IconThemeData ActionChip_readBack_iconTheme(Object st) {
    throw new UnsupportedOperationException("ActionChip_readBack_iconTheme read-back requires FFM/java22");
  }
  default BoxConstraints ActionChip_readBack_avatarBoxConstraints(Object st) {
    throw new UnsupportedOperationException("ActionChip_readBack_avatarBoxConstraints read-back requires FFM/java22");
  }

  default int simpleDialogSimpleDialog(Optional<Widget> title, Optional<EdgeInsetsGeometry> titlePadding, Optional<TextStyle> titleTextStyle, Optional<List<Widget>> children, Optional<EdgeInsetsGeometry> contentPadding, Optional<TextStyle> contentTextStyle, Optional<Color> backgroundColor, OptionalDouble elevation, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, Optional<String> semanticLabel, Optional<EdgeInsets> insetPadding, Optional<Clip> clipBehavior, Optional<ShapeBorder> shape, Optional<AlignmentGeometry> alignment, Optional<BoxConstraints> constraints) {
    throw new UnsupportedOperationException("simpleDialogSimpleDialog has no default (FFM/comm impl required)");
  }
  default Widget SimpleDialog_readBack_title(Object st) {
    throw new UnsupportedOperationException("SimpleDialog_readBack_title read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry SimpleDialog_readBack_titlePadding(Object st) {
    throw new UnsupportedOperationException("SimpleDialog_readBack_titlePadding read-back requires FFM/java22");
  }
  default TextStyle SimpleDialog_readBack_titleTextStyle(Object st) {
    throw new UnsupportedOperationException("SimpleDialog_readBack_titleTextStyle read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry SimpleDialog_readBack_contentPadding(Object st) {
    throw new UnsupportedOperationException("SimpleDialog_readBack_contentPadding read-back requires FFM/java22");
  }
  default Color SimpleDialog_readBack_backgroundColor(Object st) {
    throw new UnsupportedOperationException("SimpleDialog_readBack_backgroundColor read-back requires FFM/java22");
  }
  default double SimpleDialog_readBack_elevation(Object st) {
    throw new UnsupportedOperationException("SimpleDialog_readBack_elevation read-back requires FFM/java22");
  }
  default Color SimpleDialog_readBack_shadowColor(Object st) {
    throw new UnsupportedOperationException("SimpleDialog_readBack_shadowColor read-back requires FFM/java22");
  }
  default Color SimpleDialog_readBack_surfaceTintColor(Object st) {
    throw new UnsupportedOperationException("SimpleDialog_readBack_surfaceTintColor read-back requires FFM/java22");
  }
  default TextStyle SimpleDialog_readBack_contentTextStyle(Object st) {
    throw new UnsupportedOperationException("SimpleDialog_readBack_contentTextStyle read-back requires FFM/java22");
  }
  default String SimpleDialog_readBack_semanticLabel(Object st) {
    throw new UnsupportedOperationException("SimpleDialog_readBack_semanticLabel read-back requires FFM/java22");
  }
  default EdgeInsets SimpleDialog_readBack_insetPadding(Object st) {
    throw new UnsupportedOperationException("SimpleDialog_readBack_insetPadding read-back requires FFM/java22");
  }
  default Clip SimpleDialog_readBack_clipBehavior(Object st) {
    throw new UnsupportedOperationException("SimpleDialog_readBack_clipBehavior read-back requires FFM/java22");
  }
  default ShapeBorder SimpleDialog_readBack_shape(Object st) {
    throw new UnsupportedOperationException("SimpleDialog_readBack_shape read-back requires FFM/java22");
  }
  default AlignmentGeometry SimpleDialog_readBack_alignment(Object st) {
    throw new UnsupportedOperationException("SimpleDialog_readBack_alignment read-back requires FFM/java22");
  }
  default BoxConstraints SimpleDialog_readBack_constraints(Object st) {
    throw new UnsupportedOperationException("SimpleDialog_readBack_constraints read-back requires FFM/java22");
  }

  default int simpleDialogOptionSimpleDialogOption(Optional<Runnable> onPressed, Optional<EdgeInsets> padding, Optional<Widget> child) {
    throw new UnsupportedOperationException("simpleDialogOptionSimpleDialogOption has no default (FFM/comm impl required)");
  }
  default Widget SimpleDialogOption_readBack_child(Object st) {
    throw new UnsupportedOperationException("SimpleDialogOption_readBack_child read-back requires FFM/java22");
  }
  default EdgeInsets SimpleDialogOption_readBack_padding(Object st) {
    throw new UnsupportedOperationException("SimpleDialogOption_readBack_padding read-back requires FFM/java22");
  }

  default int circleBorderCircleBorder(Optional<BorderSide> side, OptionalDouble eccentricity) {
    throw new UnsupportedOperationException("circleBorderCircleBorder has no default (FFM/comm impl required)");
  }
  default double CircleBorder_readBack_eccentricity(Object st) {
    throw new UnsupportedOperationException("CircleBorder_readBack_eccentricity read-back requires FFM/java22");
  }

  default int stadiumBorderStadiumBorder(Optional<BorderSide> side) {
    throw new UnsupportedOperationException("stadiumBorderStadiumBorder has no default (FFM/comm impl required)");
  }

  default int beveledRectangleBorderBeveledRectangleBorder(Optional<BorderSide> side, Optional<BorderRadiusGeometry> borderRadius) {
    throw new UnsupportedOperationException("beveledRectangleBorderBeveledRectangleBorder has no default (FFM/comm impl required)");
  }
  default BorderRadiusGeometry BeveledRectangleBorder_readBack_borderRadius(Object st) {
    throw new UnsupportedOperationException("BeveledRectangleBorder_readBack_borderRadius read-back requires FFM/java22");
  }

  default int continuousRectangleBorderContinuousRectangleBorder(Optional<BorderSide> side, Optional<BorderRadiusGeometry> borderRadius) {
    throw new UnsupportedOperationException("continuousRectangleBorderContinuousRectangleBorder has no default (FFM/comm impl required)");
  }
  default BorderRadiusGeometry ContinuousRectangleBorder_readBack_borderRadius(Object st) {
    throw new UnsupportedOperationException("ContinuousRectangleBorder_readBack_borderRadius read-back requires FFM/java22");
  }

  default int linearBorderLinearBorder(Optional<BorderSide> side) {
    throw new UnsupportedOperationException("linearBorderLinearBorder has no default (FFM/comm impl required)");
  }
  default int linearBorderStart(Optional<BorderSide> side, OptionalDouble alignment, OptionalDouble size) {
    throw new UnsupportedOperationException("linearBorderStart has no default (FFM/comm impl required)");
  }
  default int linearBorderEnd(Optional<BorderSide> side, OptionalDouble alignment, OptionalDouble size) {
    throw new UnsupportedOperationException("linearBorderEnd has no default (FFM/comm impl required)");
  }
  default int linearBorderTop(Optional<BorderSide> side, OptionalDouble alignment, OptionalDouble size) {
    throw new UnsupportedOperationException("linearBorderTop has no default (FFM/comm impl required)");
  }
  default int linearBorderBottom(Optional<BorderSide> side, OptionalDouble alignment, OptionalDouble size) {
    throw new UnsupportedOperationException("linearBorderBottom has no default (FFM/comm impl required)");
  }

  default int starBorderStarBorder(Optional<BorderSide> side, OptionalDouble points, OptionalDouble innerRadiusRatio, OptionalDouble pointRounding, OptionalDouble valleyRounding, OptionalDouble rotation, OptionalDouble squash) {
    throw new UnsupportedOperationException("starBorderStarBorder has no default (FFM/comm impl required)");
  }
  default int starBorderPolygon(Optional<BorderSide> side, OptionalDouble sides, OptionalDouble pointRounding, OptionalDouble rotation, OptionalDouble squash) {
    throw new UnsupportedOperationException("starBorderPolygon has no default (FFM/comm impl required)");
  }
  default double StarBorder_readBack_points(Object st) {
    throw new UnsupportedOperationException("StarBorder_readBack_points read-back requires FFM/java22");
  }
  default double StarBorder_readBack_pointRounding(Object st) {
    throw new UnsupportedOperationException("StarBorder_readBack_pointRounding read-back requires FFM/java22");
  }
  default double StarBorder_readBack_valleyRounding(Object st) {
    throw new UnsupportedOperationException("StarBorder_readBack_valleyRounding read-back requires FFM/java22");
  }
  default double StarBorder_readBack_squash(Object st) {
    throw new UnsupportedOperationException("StarBorder_readBack_squash read-back requires FFM/java22");
  }
  default double StarBorder_readBack_innerRadiusRatio(Object st) {
    throw new UnsupportedOperationException("StarBorder_readBack_innerRadiusRatio read-back requires FFM/java22");
  }
  default double StarBorder_readBack_rotation(Object st) {
    throw new UnsupportedOperationException("StarBorder_readBack_rotation read-back requires FFM/java22");
  }

  default int materialBannerMaterialBanner(Widget content, Optional<TextStyle> contentTextStyle, List<Widget> actions, OptionalDouble elevation, Optional<Widget> leading, Optional<Color> backgroundColor, Optional<Color> surfaceTintColor, Optional<Color> shadowColor, Optional<Color> dividerColor, Optional<EdgeInsetsGeometry> padding, Optional<EdgeInsetsGeometry> margin, Optional<EdgeInsetsGeometry> leadingPadding, Optional<Boolean> forceActionsBelow, Optional<OverflowBarAlignment> overflowAlignment, Optional<Animation> animation, Optional<Runnable> onVisible, OptionalDouble minActionBarHeight) {
    throw new UnsupportedOperationException("materialBannerMaterialBanner has no default (FFM/comm impl required)");
  }
  default int materialBannerCreateAnimationController(TickerProvider vsync) {
    throw new UnsupportedOperationException("materialBannerCreateAnimationController has no default (FFM/comm impl required)");
  }
  default Widget MaterialBanner_readBack_content(Object st) {
    throw new UnsupportedOperationException("MaterialBanner_readBack_content read-back requires FFM/java22");
  }
  default TextStyle MaterialBanner_readBack_contentTextStyle(Object st) {
    throw new UnsupportedOperationException("MaterialBanner_readBack_contentTextStyle read-back requires FFM/java22");
  }
  default double MaterialBanner_readBack_elevation(Object st) {
    throw new UnsupportedOperationException("MaterialBanner_readBack_elevation read-back requires FFM/java22");
  }
  default Widget MaterialBanner_readBack_leading(Object st) {
    throw new UnsupportedOperationException("MaterialBanner_readBack_leading read-back requires FFM/java22");
  }
  default double MaterialBanner_readBack_minActionBarHeight(Object st) {
    throw new UnsupportedOperationException("MaterialBanner_readBack_minActionBarHeight read-back requires FFM/java22");
  }
  default Color MaterialBanner_readBack_backgroundColor(Object st) {
    throw new UnsupportedOperationException("MaterialBanner_readBack_backgroundColor read-back requires FFM/java22");
  }
  default Color MaterialBanner_readBack_surfaceTintColor(Object st) {
    throw new UnsupportedOperationException("MaterialBanner_readBack_surfaceTintColor read-back requires FFM/java22");
  }
  default Color MaterialBanner_readBack_shadowColor(Object st) {
    throw new UnsupportedOperationException("MaterialBanner_readBack_shadowColor read-back requires FFM/java22");
  }
  default Color MaterialBanner_readBack_dividerColor(Object st) {
    throw new UnsupportedOperationException("MaterialBanner_readBack_dividerColor read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry MaterialBanner_readBack_padding(Object st) {
    throw new UnsupportedOperationException("MaterialBanner_readBack_padding read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry MaterialBanner_readBack_margin(Object st) {
    throw new UnsupportedOperationException("MaterialBanner_readBack_margin read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry MaterialBanner_readBack_leadingPadding(Object st) {
    throw new UnsupportedOperationException("MaterialBanner_readBack_leadingPadding read-back requires FFM/java22");
  }
  default boolean MaterialBanner_readBack_forceActionsBelow(Object st) {
    throw new UnsupportedOperationException("MaterialBanner_readBack_forceActionsBelow read-back requires FFM/java22");
  }
  default OverflowBarAlignment MaterialBanner_readBack_overflowAlignment(Object st) {
    throw new UnsupportedOperationException("MaterialBanner_readBack_overflowAlignment read-back requires FFM/java22");
  }
  default Animation MaterialBanner_readBack_animation(Object st) {
    throw new UnsupportedOperationException("MaterialBanner_readBack_animation read-back requires FFM/java22");
  }

  default int tabPageSelectorIndicatorTabPageSelectorIndicator(Color backgroundColor, Color borderColor, double size, Optional<BorderStyle> borderStyle) {
    throw new UnsupportedOperationException("tabPageSelectorIndicatorTabPageSelectorIndicator has no default (FFM/comm impl required)");
  }
  default Color TabPageSelectorIndicator_readBack_backgroundColor(Object st) {
    throw new UnsupportedOperationException("TabPageSelectorIndicator_readBack_backgroundColor read-back requires FFM/java22");
  }
  default Color TabPageSelectorIndicator_readBack_borderColor(Object st) {
    throw new UnsupportedOperationException("TabPageSelectorIndicator_readBack_borderColor read-back requires FFM/java22");
  }
  default double TabPageSelectorIndicator_readBack_size(Object st) {
    throw new UnsupportedOperationException("TabPageSelectorIndicator_readBack_size read-back requires FFM/java22");
  }
  default BorderStyle TabPageSelectorIndicator_readBack_borderStyle(Object st) {
    throw new UnsupportedOperationException("TabPageSelectorIndicator_readBack_borderStyle read-back requires FFM/java22");
  }

  default int reorderableDragStartListenerReorderableDragStartListener(Widget child, int index, Optional<Boolean> enabled) {
    throw new UnsupportedOperationException("reorderableDragStartListenerReorderableDragStartListener has no default (FFM/comm impl required)");
  }
  default Widget ReorderableDragStartListener_readBack_child(Object st) {
    throw new UnsupportedOperationException("ReorderableDragStartListener_readBack_child read-back requires FFM/java22");
  }
  default int ReorderableDragStartListener_readBack_index(Object st) {
    throw new UnsupportedOperationException("ReorderableDragStartListener_readBack_index read-back requires FFM/java22");
  }
  default boolean ReorderableDragStartListener_readBack_enabled(Object st) {
    throw new UnsupportedOperationException("ReorderableDragStartListener_readBack_enabled read-back requires FFM/java22");
  }

  default int reorderableDelayedDragStartListenerReorderableDelayedDragStartListener(Widget child, int index, Optional<Boolean> enabled) {
    throw new UnsupportedOperationException("reorderableDelayedDragStartListenerReorderableDelayedDragStartListener has no default (FFM/comm impl required)");
  }

  default int aboutListTileAboutListTile(Optional<Widget> icon, Optional<Widget> child, Optional<String> applicationName, Optional<String> applicationVersion, Optional<Widget> applicationIcon, Optional<String> applicationLegalese, Optional<List<Widget>> aboutBoxChildren, Optional<Boolean> dense) {
    throw new UnsupportedOperationException("aboutListTileAboutListTile has no default (FFM/comm impl required)");
  }
  default Widget AboutListTile_readBack_icon(Object st) {
    throw new UnsupportedOperationException("AboutListTile_readBack_icon read-back requires FFM/java22");
  }
  default Widget AboutListTile_readBack_child(Object st) {
    throw new UnsupportedOperationException("AboutListTile_readBack_child read-back requires FFM/java22");
  }
  default String AboutListTile_readBack_applicationName(Object st) {
    throw new UnsupportedOperationException("AboutListTile_readBack_applicationName read-back requires FFM/java22");
  }
  default String AboutListTile_readBack_applicationVersion(Object st) {
    throw new UnsupportedOperationException("AboutListTile_readBack_applicationVersion read-back requires FFM/java22");
  }
  default Widget AboutListTile_readBack_applicationIcon(Object st) {
    throw new UnsupportedOperationException("AboutListTile_readBack_applicationIcon read-back requires FFM/java22");
  }
  default String AboutListTile_readBack_applicationLegalese(Object st) {
    throw new UnsupportedOperationException("AboutListTile_readBack_applicationLegalese read-back requires FFM/java22");
  }
  default boolean AboutListTile_readBack_dense(Object st) {
    throw new UnsupportedOperationException("AboutListTile_readBack_dense read-back requires FFM/java22");
  }

  default int dialogDialog(Optional<Color> backgroundColor, OptionalDouble elevation, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, Optional<Duration> insetAnimationDuration, Optional<Curve> insetAnimationCurve, Optional<EdgeInsets> insetPadding, Optional<Clip> clipBehavior, Optional<ShapeBorder> shape, Optional<AlignmentGeometry> alignment, Optional<Widget> child, Optional<SemanticsRole> semanticsRole, Optional<BoxConstraints> constraints) {
    throw new UnsupportedOperationException("dialogDialog has no default (FFM/comm impl required)");
  }
  default int dialogFullscreen(Optional<Color> backgroundColor, Optional<Duration> insetAnimationDuration, Optional<Curve> insetAnimationCurve, Optional<Widget> child, Optional<SemanticsRole> semanticsRole) {
    throw new UnsupportedOperationException("dialogFullscreen has no default (FFM/comm impl required)");
  }
  default Color Dialog_readBack_backgroundColor(Object st) {
    throw new UnsupportedOperationException("Dialog_readBack_backgroundColor read-back requires FFM/java22");
  }
  default double Dialog_readBack_elevation(Object st) {
    throw new UnsupportedOperationException("Dialog_readBack_elevation read-back requires FFM/java22");
  }
  default Color Dialog_readBack_shadowColor(Object st) {
    throw new UnsupportedOperationException("Dialog_readBack_shadowColor read-back requires FFM/java22");
  }
  default Color Dialog_readBack_surfaceTintColor(Object st) {
    throw new UnsupportedOperationException("Dialog_readBack_surfaceTintColor read-back requires FFM/java22");
  }
  default Duration Dialog_readBack_insetAnimationDuration(Object st) {
    throw new UnsupportedOperationException("Dialog_readBack_insetAnimationDuration read-back requires FFM/java22");
  }
  default Curve Dialog_readBack_insetAnimationCurve(Object st) {
    throw new UnsupportedOperationException("Dialog_readBack_insetAnimationCurve read-back requires FFM/java22");
  }
  default EdgeInsets Dialog_readBack_insetPadding(Object st) {
    throw new UnsupportedOperationException("Dialog_readBack_insetPadding read-back requires FFM/java22");
  }
  default Clip Dialog_readBack_clipBehavior(Object st) {
    throw new UnsupportedOperationException("Dialog_readBack_clipBehavior read-back requires FFM/java22");
  }
  default ShapeBorder Dialog_readBack_shape(Object st) {
    throw new UnsupportedOperationException("Dialog_readBack_shape read-back requires FFM/java22");
  }
  default AlignmentGeometry Dialog_readBack_alignment(Object st) {
    throw new UnsupportedOperationException("Dialog_readBack_alignment read-back requires FFM/java22");
  }
  default Widget Dialog_readBack_child(Object st) {
    throw new UnsupportedOperationException("Dialog_readBack_child read-back requires FFM/java22");
  }
  default SemanticsRole Dialog_readBack_semanticsRole(Object st) {
    throw new UnsupportedOperationException("Dialog_readBack_semanticsRole read-back requires FFM/java22");
  }
  default BoxConstraints Dialog_readBack_constraints(Object st) {
    throw new UnsupportedOperationException("Dialog_readBack_constraints read-back requires FFM/java22");
  }

  default int gridTileGridTile(Optional<Widget> header, Optional<Widget> footer, Widget child) {
    throw new UnsupportedOperationException("gridTileGridTile has no default (FFM/comm impl required)");
  }
  default Widget GridTile_readBack_header(Object st) {
    throw new UnsupportedOperationException("GridTile_readBack_header read-back requires FFM/java22");
  }
  default Widget GridTile_readBack_footer(Object st) {
    throw new UnsupportedOperationException("GridTile_readBack_footer read-back requires FFM/java22");
  }
  default Widget GridTile_readBack_child(Object st) {
    throw new UnsupportedOperationException("GridTile_readBack_child read-back requires FFM/java22");
  }

  default int gridTileBarGridTileBar(Optional<Color> backgroundColor, Optional<Widget> leading, Optional<Widget> title, Optional<Widget> subtitle, Optional<Widget> trailing) {
    throw new UnsupportedOperationException("gridTileBarGridTileBar has no default (FFM/comm impl required)");
  }
  default Color GridTileBar_readBack_backgroundColor(Object st) {
    throw new UnsupportedOperationException("GridTileBar_readBack_backgroundColor read-back requires FFM/java22");
  }
  default Widget GridTileBar_readBack_leading(Object st) {
    throw new UnsupportedOperationException("GridTileBar_readBack_leading read-back requires FFM/java22");
  }
  default Widget GridTileBar_readBack_title(Object st) {
    throw new UnsupportedOperationException("GridTileBar_readBack_title read-back requires FFM/java22");
  }
  default Widget GridTileBar_readBack_subtitle(Object st) {
    throw new UnsupportedOperationException("GridTileBar_readBack_subtitle read-back requires FFM/java22");
  }
  default Widget GridTileBar_readBack_trailing(Object st) {
    throw new UnsupportedOperationException("GridTileBar_readBack_trailing read-back requires FFM/java22");
  }

  default int refreshProgressIndicatorRefreshProgressIndicator(OptionalDouble value, Optional<Color> backgroundColor, Optional<Color> color, Optional<Animation> valueColor, OptionalDouble strokeWidth, OptionalDouble strokeAlign, Optional<String> semanticsLabel, Optional<String> semanticsValue, Optional<StrokeCap> strokeCap, OptionalDouble elevation, Optional<EdgeInsetsGeometry> indicatorMargin, Optional<EdgeInsetsGeometry> indicatorPadding) {
    throw new UnsupportedOperationException("refreshProgressIndicatorRefreshProgressIndicator has no default (FFM/comm impl required)");
  }
  default double RefreshProgressIndicator_readBack_elevation(Object st) {
    throw new UnsupportedOperationException("RefreshProgressIndicator_readBack_elevation read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry RefreshProgressIndicator_readBack_indicatorMargin(Object st) {
    throw new UnsupportedOperationException("RefreshProgressIndicator_readBack_indicatorMargin read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry RefreshProgressIndicator_readBack_indicatorPadding(Object st) {
    throw new UnsupportedOperationException("RefreshProgressIndicator_readBack_indicatorPadding read-back requires FFM/java22");
  }

  default int circularProgressIndicatorCircularProgressIndicator(OptionalDouble value, Optional<Color> backgroundColor, Optional<Color> color, Optional<Animation> valueColor, OptionalDouble strokeWidth, OptionalDouble strokeAlign, Optional<String> semanticsLabel, Optional<String> semanticsValue, Optional<StrokeCap> strokeCap, Optional<BoxConstraints> constraints, OptionalDouble trackGap, Optional<Boolean> year2023, Optional<EdgeInsetsGeometry> padding, Optional<AnimationController> controller) {
    throw new UnsupportedOperationException("circularProgressIndicatorCircularProgressIndicator has no default (FFM/comm impl required)");
  }
  default int circularProgressIndicatorAdaptive(OptionalDouble value, Optional<Color> backgroundColor, Optional<Animation> valueColor, OptionalDouble strokeWidth, Optional<String> semanticsLabel, Optional<String> semanticsValue, Optional<StrokeCap> strokeCap, OptionalDouble strokeAlign, Optional<BoxConstraints> constraints, OptionalDouble trackGap, Optional<Boolean> year2023, Optional<EdgeInsetsGeometry> padding, Optional<AnimationController> controller) {
    throw new UnsupportedOperationException("circularProgressIndicatorAdaptive has no default (FFM/comm impl required)");
  }
  default double CircularProgressIndicator_readBack_strokeWidth(Object st) {
    throw new UnsupportedOperationException("CircularProgressIndicator_readBack_strokeWidth read-back requires FFM/java22");
  }
  default double CircularProgressIndicator_readBack_strokeAlign(Object st) {
    throw new UnsupportedOperationException("CircularProgressIndicator_readBack_strokeAlign read-back requires FFM/java22");
  }
  default StrokeCap CircularProgressIndicator_readBack_strokeCap(Object st) {
    throw new UnsupportedOperationException("CircularProgressIndicator_readBack_strokeCap read-back requires FFM/java22");
  }
  default BoxConstraints CircularProgressIndicator_readBack_constraints(Object st) {
    throw new UnsupportedOperationException("CircularProgressIndicator_readBack_constraints read-back requires FFM/java22");
  }
  default double CircularProgressIndicator_readBack_trackGap(Object st) {
    throw new UnsupportedOperationException("CircularProgressIndicator_readBack_trackGap read-back requires FFM/java22");
  }
  default boolean CircularProgressIndicator_readBack_year2023(Object st) {
    throw new UnsupportedOperationException("CircularProgressIndicator_readBack_year2023 read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry CircularProgressIndicator_readBack_padding(Object st) {
    throw new UnsupportedOperationException("CircularProgressIndicator_readBack_padding read-back requires FFM/java22");
  }
  default AnimationController CircularProgressIndicator_readBack_controller(Object st) {
    throw new UnsupportedOperationException("CircularProgressIndicator_readBack_controller read-back requires FFM/java22");
  }

  default int inputDecoratorInputDecorator(InputDecoration decoration, Optional<TextStyle> baseStyle, Optional<TextAlign> textAlign, Optional<Boolean> isFocused, Optional<Boolean> isHovering, Optional<Boolean> expands, Optional<Boolean> isEmpty, Optional<Widget> child) {
    throw new UnsupportedOperationException("inputDecoratorInputDecorator has no default (FFM/comm impl required)");
  }
  default int inputDecoratorContainerOf(BuildContext context) {
    throw new UnsupportedOperationException("inputDecoratorContainerOf has no default (FFM/comm impl required)");
  }
  default InputDecoration InputDecorator_readBack_decoration(Object st) {
    throw new UnsupportedOperationException("InputDecorator_readBack_decoration read-back requires FFM/java22");
  }
  default TextStyle InputDecorator_readBack_baseStyle(Object st) {
    throw new UnsupportedOperationException("InputDecorator_readBack_baseStyle read-back requires FFM/java22");
  }
  default TextAlign InputDecorator_readBack_textAlign(Object st) {
    throw new UnsupportedOperationException("InputDecorator_readBack_textAlign read-back requires FFM/java22");
  }
  default boolean InputDecorator_readBack_isFocused(Object st) {
    throw new UnsupportedOperationException("InputDecorator_readBack_isFocused read-back requires FFM/java22");
  }
  default boolean InputDecorator_readBack_isHovering(Object st) {
    throw new UnsupportedOperationException("InputDecorator_readBack_isHovering read-back requires FFM/java22");
  }
  default boolean InputDecorator_readBack_expands(Object st) {
    throw new UnsupportedOperationException("InputDecorator_readBack_expands read-back requires FFM/java22");
  }
  default boolean InputDecorator_readBack_isEmpty(Object st) {
    throw new UnsupportedOperationException("InputDecorator_readBack_isEmpty read-back requires FFM/java22");
  }
  default Widget InputDecorator_readBack_child(Object st) {
    throw new UnsupportedOperationException("InputDecorator_readBack_child read-back requires FFM/java22");
  }

  default int inputDecorationInputDecoration(Optional<Widget> icon, Optional<Color> iconColor, Optional<Widget> label, Optional<String> labelText, Optional<TextStyle> labelStyle, Optional<TextStyle> floatingLabelStyle, Optional<Widget> helper, Optional<String> helperText, Optional<TextStyle> helperStyle, OptionalInt helperMaxLines, Optional<String> hintText, Optional<Widget> hint, Optional<TextStyle> hintStyle, Optional<TextDirection> hintTextDirection, OptionalInt hintMaxLines, Optional<Duration> hintFadeDuration, Optional<Boolean> maintainHintHeight, Optional<Boolean> maintainHintSize, Optional<Boolean> maintainLabelSize, Optional<Widget> error, Optional<String> errorText, Optional<TextStyle> errorStyle, OptionalInt errorMaxLines, Optional<FloatingLabelBehavior> floatingLabelBehavior, Optional<Boolean> isCollapsed, Optional<Boolean> isDense, Optional<EdgeInsetsGeometry> contentPadding, Optional<Widget> prefixIcon, Optional<BoxConstraints> prefixIconConstraints, Optional<Widget> prefix, Optional<String> prefixText, Optional<TextStyle> prefixStyle, Optional<Color> prefixIconColor, Optional<Widget> suffixIcon, Optional<Widget> suffix, Optional<String> suffixText, Optional<TextStyle> suffixStyle, Optional<Color> suffixIconColor, Optional<BoxConstraints> suffixIconConstraints, Optional<Widget> counter, Optional<String> counterText, Optional<TextStyle> counterStyle, Optional<Boolean> filled, Optional<Color> fillColor, Optional<Color> focusColor, Optional<Color> hoverColor, Optional<InputBorder> errorBorder, Optional<InputBorder> focusedBorder, Optional<InputBorder> focusedErrorBorder, Optional<InputBorder> disabledBorder, Optional<InputBorder> enabledBorder, Optional<InputBorder> border, Optional<Boolean> enabled, Optional<String> semanticCounterText, Optional<Boolean> alignLabelWithHint, Optional<BoxConstraints> constraints, Optional<VisualDensity> visualDensity) {
    throw new UnsupportedOperationException("inputDecorationInputDecoration has no default (FFM/comm impl required)");
  }
  default int inputDecorationCollapsed(Optional<String> hintText, Optional<FloatingLabelBehavior> floatingLabelBehavior, Optional<TextStyle> hintStyle, Optional<Widget> hint, Optional<TextDirection> hintTextDirection, OptionalInt hintMaxLines, Optional<Duration> hintFadeDuration, Optional<Boolean> maintainHintHeight, Optional<Boolean> maintainHintSize, Optional<Boolean> maintainLabelSize, Optional<Boolean> filled, Optional<Color> fillColor, Optional<Color> focusColor, Optional<Color> hoverColor, Optional<InputBorder> border, Optional<Boolean> enabled, Optional<BoxConstraints> constraints) {
    throw new UnsupportedOperationException("inputDecorationCollapsed has no default (FFM/comm impl required)");
  }
  default Widget InputDecoration_readBack_icon(Object st) {
    throw new UnsupportedOperationException("InputDecoration_readBack_icon read-back requires FFM/java22");
  }
  default Color InputDecoration_readBack_iconColor(Object st) {
    throw new UnsupportedOperationException("InputDecoration_readBack_iconColor read-back requires FFM/java22");
  }
  default Widget InputDecoration_readBack_label(Object st) {
    throw new UnsupportedOperationException("InputDecoration_readBack_label read-back requires FFM/java22");
  }
  default String InputDecoration_readBack_labelText(Object st) {
    throw new UnsupportedOperationException("InputDecoration_readBack_labelText read-back requires FFM/java22");
  }
  default TextStyle InputDecoration_readBack_labelStyle(Object st) {
    throw new UnsupportedOperationException("InputDecoration_readBack_labelStyle read-back requires FFM/java22");
  }
  default TextStyle InputDecoration_readBack_floatingLabelStyle(Object st) {
    throw new UnsupportedOperationException("InputDecoration_readBack_floatingLabelStyle read-back requires FFM/java22");
  }
  default Widget InputDecoration_readBack_helper(Object st) {
    throw new UnsupportedOperationException("InputDecoration_readBack_helper read-back requires FFM/java22");
  }
  default String InputDecoration_readBack_helperText(Object st) {
    throw new UnsupportedOperationException("InputDecoration_readBack_helperText read-back requires FFM/java22");
  }
  default TextStyle InputDecoration_readBack_helperStyle(Object st) {
    throw new UnsupportedOperationException("InputDecoration_readBack_helperStyle read-back requires FFM/java22");
  }
  default int InputDecoration_readBack_helperMaxLines(Object st) {
    throw new UnsupportedOperationException("InputDecoration_readBack_helperMaxLines read-back requires FFM/java22");
  }
  default String InputDecoration_readBack_hintText(Object st) {
    throw new UnsupportedOperationException("InputDecoration_readBack_hintText read-back requires FFM/java22");
  }
  default Widget InputDecoration_readBack_hint(Object st) {
    throw new UnsupportedOperationException("InputDecoration_readBack_hint read-back requires FFM/java22");
  }
  default TextStyle InputDecoration_readBack_hintStyle(Object st) {
    throw new UnsupportedOperationException("InputDecoration_readBack_hintStyle read-back requires FFM/java22");
  }
  default TextDirection InputDecoration_readBack_hintTextDirection(Object st) {
    throw new UnsupportedOperationException("InputDecoration_readBack_hintTextDirection read-back requires FFM/java22");
  }
  default int InputDecoration_readBack_hintMaxLines(Object st) {
    throw new UnsupportedOperationException("InputDecoration_readBack_hintMaxLines read-back requires FFM/java22");
  }
  default Duration InputDecoration_readBack_hintFadeDuration(Object st) {
    throw new UnsupportedOperationException("InputDecoration_readBack_hintFadeDuration read-back requires FFM/java22");
  }
  default boolean InputDecoration_readBack_maintainHintHeight(Object st) {
    throw new UnsupportedOperationException("InputDecoration_readBack_maintainHintHeight read-back requires FFM/java22");
  }
  default boolean InputDecoration_readBack_maintainHintSize(Object st) {
    throw new UnsupportedOperationException("InputDecoration_readBack_maintainHintSize read-back requires FFM/java22");
  }
  default boolean InputDecoration_readBack_maintainLabelSize(Object st) {
    throw new UnsupportedOperationException("InputDecoration_readBack_maintainLabelSize read-back requires FFM/java22");
  }
  default Widget InputDecoration_readBack_error(Object st) {
    throw new UnsupportedOperationException("InputDecoration_readBack_error read-back requires FFM/java22");
  }
  default String InputDecoration_readBack_errorText(Object st) {
    throw new UnsupportedOperationException("InputDecoration_readBack_errorText read-back requires FFM/java22");
  }
  default TextStyle InputDecoration_readBack_errorStyle(Object st) {
    throw new UnsupportedOperationException("InputDecoration_readBack_errorStyle read-back requires FFM/java22");
  }
  default int InputDecoration_readBack_errorMaxLines(Object st) {
    throw new UnsupportedOperationException("InputDecoration_readBack_errorMaxLines read-back requires FFM/java22");
  }
  default FloatingLabelBehavior InputDecoration_readBack_floatingLabelBehavior(Object st) {
    throw new UnsupportedOperationException("InputDecoration_readBack_floatingLabelBehavior read-back requires FFM/java22");
  }
  default boolean InputDecoration_readBack_isDense(Object st) {
    throw new UnsupportedOperationException("InputDecoration_readBack_isDense read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry InputDecoration_readBack_contentPadding(Object st) {
    throw new UnsupportedOperationException("InputDecoration_readBack_contentPadding read-back requires FFM/java22");
  }
  default boolean InputDecoration_readBack_isCollapsed(Object st) {
    throw new UnsupportedOperationException("InputDecoration_readBack_isCollapsed read-back requires FFM/java22");
  }
  default Widget InputDecoration_readBack_prefixIcon(Object st) {
    throw new UnsupportedOperationException("InputDecoration_readBack_prefixIcon read-back requires FFM/java22");
  }
  default BoxConstraints InputDecoration_readBack_prefixIconConstraints(Object st) {
    throw new UnsupportedOperationException("InputDecoration_readBack_prefixIconConstraints read-back requires FFM/java22");
  }
  default Widget InputDecoration_readBack_prefix(Object st) {
    throw new UnsupportedOperationException("InputDecoration_readBack_prefix read-back requires FFM/java22");
  }
  default String InputDecoration_readBack_prefixText(Object st) {
    throw new UnsupportedOperationException("InputDecoration_readBack_prefixText read-back requires FFM/java22");
  }
  default TextStyle InputDecoration_readBack_prefixStyle(Object st) {
    throw new UnsupportedOperationException("InputDecoration_readBack_prefixStyle read-back requires FFM/java22");
  }
  default Color InputDecoration_readBack_prefixIconColor(Object st) {
    throw new UnsupportedOperationException("InputDecoration_readBack_prefixIconColor read-back requires FFM/java22");
  }
  default Widget InputDecoration_readBack_suffixIcon(Object st) {
    throw new UnsupportedOperationException("InputDecoration_readBack_suffixIcon read-back requires FFM/java22");
  }
  default Widget InputDecoration_readBack_suffix(Object st) {
    throw new UnsupportedOperationException("InputDecoration_readBack_suffix read-back requires FFM/java22");
  }
  default String InputDecoration_readBack_suffixText(Object st) {
    throw new UnsupportedOperationException("InputDecoration_readBack_suffixText read-back requires FFM/java22");
  }
  default TextStyle InputDecoration_readBack_suffixStyle(Object st) {
    throw new UnsupportedOperationException("InputDecoration_readBack_suffixStyle read-back requires FFM/java22");
  }
  default Color InputDecoration_readBack_suffixIconColor(Object st) {
    throw new UnsupportedOperationException("InputDecoration_readBack_suffixIconColor read-back requires FFM/java22");
  }
  default BoxConstraints InputDecoration_readBack_suffixIconConstraints(Object st) {
    throw new UnsupportedOperationException("InputDecoration_readBack_suffixIconConstraints read-back requires FFM/java22");
  }
  default String InputDecoration_readBack_counterText(Object st) {
    throw new UnsupportedOperationException("InputDecoration_readBack_counterText read-back requires FFM/java22");
  }
  default Widget InputDecoration_readBack_counter(Object st) {
    throw new UnsupportedOperationException("InputDecoration_readBack_counter read-back requires FFM/java22");
  }
  default TextStyle InputDecoration_readBack_counterStyle(Object st) {
    throw new UnsupportedOperationException("InputDecoration_readBack_counterStyle read-back requires FFM/java22");
  }
  default boolean InputDecoration_readBack_filled(Object st) {
    throw new UnsupportedOperationException("InputDecoration_readBack_filled read-back requires FFM/java22");
  }
  default Color InputDecoration_readBack_fillColor(Object st) {
    throw new UnsupportedOperationException("InputDecoration_readBack_fillColor read-back requires FFM/java22");
  }
  default Color InputDecoration_readBack_focusColor(Object st) {
    throw new UnsupportedOperationException("InputDecoration_readBack_focusColor read-back requires FFM/java22");
  }
  default Color InputDecoration_readBack_hoverColor(Object st) {
    throw new UnsupportedOperationException("InputDecoration_readBack_hoverColor read-back requires FFM/java22");
  }
  default InputBorder InputDecoration_readBack_errorBorder(Object st) {
    throw new UnsupportedOperationException("InputDecoration_readBack_errorBorder read-back requires FFM/java22");
  }
  default InputBorder InputDecoration_readBack_focusedBorder(Object st) {
    throw new UnsupportedOperationException("InputDecoration_readBack_focusedBorder read-back requires FFM/java22");
  }
  default InputBorder InputDecoration_readBack_focusedErrorBorder(Object st) {
    throw new UnsupportedOperationException("InputDecoration_readBack_focusedErrorBorder read-back requires FFM/java22");
  }
  default InputBorder InputDecoration_readBack_disabledBorder(Object st) {
    throw new UnsupportedOperationException("InputDecoration_readBack_disabledBorder read-back requires FFM/java22");
  }
  default InputBorder InputDecoration_readBack_enabledBorder(Object st) {
    throw new UnsupportedOperationException("InputDecoration_readBack_enabledBorder read-back requires FFM/java22");
  }
  default InputBorder InputDecoration_readBack_border(Object st) {
    throw new UnsupportedOperationException("InputDecoration_readBack_border read-back requires FFM/java22");
  }
  default boolean InputDecoration_readBack_enabled(Object st) {
    throw new UnsupportedOperationException("InputDecoration_readBack_enabled read-back requires FFM/java22");
  }
  default String InputDecoration_readBack_semanticCounterText(Object st) {
    throw new UnsupportedOperationException("InputDecoration_readBack_semanticCounterText read-back requires FFM/java22");
  }
  default boolean InputDecoration_readBack_alignLabelWithHint(Object st) {
    throw new UnsupportedOperationException("InputDecoration_readBack_alignLabelWithHint read-back requires FFM/java22");
  }
  default BoxConstraints InputDecoration_readBack_constraints(Object st) {
    throw new UnsupportedOperationException("InputDecoration_readBack_constraints read-back requires FFM/java22");
  }
  default VisualDensity InputDecoration_readBack_visualDensity(Object st) {
    throw new UnsupportedOperationException("InputDecoration_readBack_visualDensity read-back requires FFM/java22");
  }

  default int inputBorderNone() {
    throw new UnsupportedOperationException("inputBorderNone has no default (FFM/comm impl required)");
  }

  default int userAccountsDrawerHeaderUserAccountsDrawerHeader(Optional<Decoration> decoration, Optional<EdgeInsetsGeometry> margin, Optional<Widget> currentAccountPicture, Optional<List<Widget>> otherAccountsPictures, Optional<Widget> accountName, Optional<Widget> accountEmail, Optional<Runnable> onDetailsPressed, Optional<Color> arrowColor) {
    throw new UnsupportedOperationException("userAccountsDrawerHeaderUserAccountsDrawerHeader has no default (FFM/comm impl required)");
  }
  default Decoration UserAccountsDrawerHeader_readBack_decoration(Object st) {
    throw new UnsupportedOperationException("UserAccountsDrawerHeader_readBack_decoration read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry UserAccountsDrawerHeader_readBack_margin(Object st) {
    throw new UnsupportedOperationException("UserAccountsDrawerHeader_readBack_margin read-back requires FFM/java22");
  }
  default Widget UserAccountsDrawerHeader_readBack_currentAccountPicture(Object st) {
    throw new UnsupportedOperationException("UserAccountsDrawerHeader_readBack_currentAccountPicture read-back requires FFM/java22");
  }
  default Widget UserAccountsDrawerHeader_readBack_accountName(Object st) {
    throw new UnsupportedOperationException("UserAccountsDrawerHeader_readBack_accountName read-back requires FFM/java22");
  }
  default Widget UserAccountsDrawerHeader_readBack_accountEmail(Object st) {
    throw new UnsupportedOperationException("UserAccountsDrawerHeader_readBack_accountEmail read-back requires FFM/java22");
  }
  default Color UserAccountsDrawerHeader_readBack_arrowColor(Object st) {
    throw new UnsupportedOperationException("UserAccountsDrawerHeader_readBack_arrowColor read-back requires FFM/java22");
  }

  default int inputChipInputChip(Optional<Widget> avatar, Widget label, Optional<TextStyle> labelStyle, Optional<EdgeInsetsGeometry> labelPadding, Optional<Boolean> selected, Optional<Boolean> isEnabled, Optional<Consumer<Boolean>> onSelected, Optional<Widget> deleteIcon, Optional<Runnable> onDeleted, Optional<Color> deleteIconColor, Optional<String> deleteButtonTooltipMessage, Optional<Runnable> onPressed, OptionalDouble pressElevation, Optional<Color> disabledColor, Optional<Color> selectedColor, Optional<String> tooltip, Optional<BorderSide> side, Optional<OutlinedBorder> shape, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, Optional<Color> color, Optional<Color> backgroundColor, Optional<EdgeInsetsGeometry> padding, Optional<VisualDensity> visualDensity, Optional<MaterialTapTargetSize> materialTapTargetSize, OptionalDouble elevation, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, Optional<IconThemeData> iconTheme, Optional<Color> selectedShadowColor, Optional<Boolean> showCheckmark, Optional<Color> checkmarkColor, Optional<ShapeBorder> avatarBorder, Optional<BoxConstraints> avatarBoxConstraints, Optional<BoxConstraints> deleteIconBoxConstraints) {
    throw new UnsupportedOperationException("inputChipInputChip has no default (FFM/comm impl required)");
  }
  default Widget InputChip_readBack_avatar(Object st) {
    throw new UnsupportedOperationException("InputChip_readBack_avatar read-back requires FFM/java22");
  }
  default Widget InputChip_readBack_label(Object st) {
    throw new UnsupportedOperationException("InputChip_readBack_label read-back requires FFM/java22");
  }
  default TextStyle InputChip_readBack_labelStyle(Object st) {
    throw new UnsupportedOperationException("InputChip_readBack_labelStyle read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry InputChip_readBack_labelPadding(Object st) {
    throw new UnsupportedOperationException("InputChip_readBack_labelPadding read-back requires FFM/java22");
  }
  default boolean InputChip_readBack_selected(Object st) {
    throw new UnsupportedOperationException("InputChip_readBack_selected read-back requires FFM/java22");
  }
  default boolean InputChip_readBack_isEnabled(Object st) {
    throw new UnsupportedOperationException("InputChip_readBack_isEnabled read-back requires FFM/java22");
  }
  default Widget InputChip_readBack_deleteIcon(Object st) {
    throw new UnsupportedOperationException("InputChip_readBack_deleteIcon read-back requires FFM/java22");
  }
  default Color InputChip_readBack_deleteIconColor(Object st) {
    throw new UnsupportedOperationException("InputChip_readBack_deleteIconColor read-back requires FFM/java22");
  }
  default String InputChip_readBack_deleteButtonTooltipMessage(Object st) {
    throw new UnsupportedOperationException("InputChip_readBack_deleteButtonTooltipMessage read-back requires FFM/java22");
  }
  default double InputChip_readBack_pressElevation(Object st) {
    throw new UnsupportedOperationException("InputChip_readBack_pressElevation read-back requires FFM/java22");
  }
  default Color InputChip_readBack_disabledColor(Object st) {
    throw new UnsupportedOperationException("InputChip_readBack_disabledColor read-back requires FFM/java22");
  }
  default Color InputChip_readBack_selectedColor(Object st) {
    throw new UnsupportedOperationException("InputChip_readBack_selectedColor read-back requires FFM/java22");
  }
  default String InputChip_readBack_tooltip(Object st) {
    throw new UnsupportedOperationException("InputChip_readBack_tooltip read-back requires FFM/java22");
  }
  default BorderSide InputChip_readBack_side(Object st) {
    throw new UnsupportedOperationException("InputChip_readBack_side read-back requires FFM/java22");
  }
  default OutlinedBorder InputChip_readBack_shape(Object st) {
    throw new UnsupportedOperationException("InputChip_readBack_shape read-back requires FFM/java22");
  }
  default Clip InputChip_readBack_clipBehavior(Object st) {
    throw new UnsupportedOperationException("InputChip_readBack_clipBehavior read-back requires FFM/java22");
  }
  default boolean InputChip_readBack_autofocus(Object st) {
    throw new UnsupportedOperationException("InputChip_readBack_autofocus read-back requires FFM/java22");
  }
  default Color InputChip_readBack_backgroundColor(Object st) {
    throw new UnsupportedOperationException("InputChip_readBack_backgroundColor read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry InputChip_readBack_padding(Object st) {
    throw new UnsupportedOperationException("InputChip_readBack_padding read-back requires FFM/java22");
  }
  default VisualDensity InputChip_readBack_visualDensity(Object st) {
    throw new UnsupportedOperationException("InputChip_readBack_visualDensity read-back requires FFM/java22");
  }
  default MaterialTapTargetSize InputChip_readBack_materialTapTargetSize(Object st) {
    throw new UnsupportedOperationException("InputChip_readBack_materialTapTargetSize read-back requires FFM/java22");
  }
  default double InputChip_readBack_elevation(Object st) {
    throw new UnsupportedOperationException("InputChip_readBack_elevation read-back requires FFM/java22");
  }
  default Color InputChip_readBack_shadowColor(Object st) {
    throw new UnsupportedOperationException("InputChip_readBack_shadowColor read-back requires FFM/java22");
  }
  default Color InputChip_readBack_surfaceTintColor(Object st) {
    throw new UnsupportedOperationException("InputChip_readBack_surfaceTintColor read-back requires FFM/java22");
  }
  default Color InputChip_readBack_selectedShadowColor(Object st) {
    throw new UnsupportedOperationException("InputChip_readBack_selectedShadowColor read-back requires FFM/java22");
  }
  default boolean InputChip_readBack_showCheckmark(Object st) {
    throw new UnsupportedOperationException("InputChip_readBack_showCheckmark read-back requires FFM/java22");
  }
  default Color InputChip_readBack_checkmarkColor(Object st) {
    throw new UnsupportedOperationException("InputChip_readBack_checkmarkColor read-back requires FFM/java22");
  }
  default ShapeBorder InputChip_readBack_avatarBorder(Object st) {
    throw new UnsupportedOperationException("InputChip_readBack_avatarBorder read-back requires FFM/java22");
  }
  default IconThemeData InputChip_readBack_iconTheme(Object st) {
    throw new UnsupportedOperationException("InputChip_readBack_iconTheme read-back requires FFM/java22");
  }
  default BoxConstraints InputChip_readBack_avatarBoxConstraints(Object st) {
    throw new UnsupportedOperationException("InputChip_readBack_avatarBoxConstraints read-back requires FFM/java22");
  }
  default BoxConstraints InputChip_readBack_deleteIconBoxConstraints(Object st) {
    throw new UnsupportedOperationException("InputChip_readBack_deleteIconBoxConstraints read-back requires FFM/java22");
  }

  default int alignTransitionAlignTransition(Animation alignment, Widget child, OptionalDouble widthFactor, OptionalDouble heightFactor) {
    throw new UnsupportedOperationException("alignTransitionAlignTransition has no default (FFM/comm impl required)");
  }
  default double AlignTransition_readBack_widthFactor(Object st) {
    throw new UnsupportedOperationException("AlignTransition_readBack_widthFactor read-back requires FFM/java22");
  }
  default double AlignTransition_readBack_heightFactor(Object st) {
    throw new UnsupportedOperationException("AlignTransition_readBack_heightFactor read-back requires FFM/java22");
  }
  default Widget AlignTransition_readBack_child(Object st) {
    throw new UnsupportedOperationException("AlignTransition_readBack_child read-back requires FFM/java22");
  }
  default Animation AlignTransition_readBack_alignment(Object st) {
    throw new UnsupportedOperationException("AlignTransition_readBack_alignment read-back requires FFM/java22");
  }

  default int animatedDefaultTextStyleAnimatedDefaultTextStyle(Widget child, TextStyle style, Optional<TextAlign> textAlign, Optional<Boolean> softWrap, Optional<TextOverflow> overflow, OptionalInt maxLines, Optional<TextWidthBasis> textWidthBasis, Optional<Curve> curve, Duration duration, Optional<Runnable> onEnd) {
    throw new UnsupportedOperationException("animatedDefaultTextStyleAnimatedDefaultTextStyle has no default (FFM/comm impl required)");
  }
  default Widget AnimatedDefaultTextStyle_readBack_child(Object st) {
    throw new UnsupportedOperationException("AnimatedDefaultTextStyle_readBack_child read-back requires FFM/java22");
  }
  default TextStyle AnimatedDefaultTextStyle_readBack_style(Object st) {
    throw new UnsupportedOperationException("AnimatedDefaultTextStyle_readBack_style read-back requires FFM/java22");
  }
  default TextAlign AnimatedDefaultTextStyle_readBack_textAlign(Object st) {
    throw new UnsupportedOperationException("AnimatedDefaultTextStyle_readBack_textAlign read-back requires FFM/java22");
  }
  default boolean AnimatedDefaultTextStyle_readBack_softWrap(Object st) {
    throw new UnsupportedOperationException("AnimatedDefaultTextStyle_readBack_softWrap read-back requires FFM/java22");
  }
  default TextOverflow AnimatedDefaultTextStyle_readBack_overflow(Object st) {
    throw new UnsupportedOperationException("AnimatedDefaultTextStyle_readBack_overflow read-back requires FFM/java22");
  }
  default int AnimatedDefaultTextStyle_readBack_maxLines(Object st) {
    throw new UnsupportedOperationException("AnimatedDefaultTextStyle_readBack_maxLines read-back requires FFM/java22");
  }
  default TextWidthBasis AnimatedDefaultTextStyle_readBack_textWidthBasis(Object st) {
    throw new UnsupportedOperationException("AnimatedDefaultTextStyle_readBack_textWidthBasis read-back requires FFM/java22");
  }

  default int animatedFractionallySizedBoxAnimatedFractionallySizedBox(Optional<AlignmentGeometry> alignment, Optional<Widget> child, OptionalDouble heightFactor, OptionalDouble widthFactor, Optional<Curve> curve, Duration duration, Optional<Runnable> onEnd) {
    throw new UnsupportedOperationException("animatedFractionallySizedBoxAnimatedFractionallySizedBox has no default (FFM/comm impl required)");
  }
  default Widget AnimatedFractionallySizedBox_readBack_child(Object st) {
    throw new UnsupportedOperationException("AnimatedFractionallySizedBox_readBack_child read-back requires FFM/java22");
  }
  default double AnimatedFractionallySizedBox_readBack_heightFactor(Object st) {
    throw new UnsupportedOperationException("AnimatedFractionallySizedBox_readBack_heightFactor read-back requires FFM/java22");
  }
  default double AnimatedFractionallySizedBox_readBack_widthFactor(Object st) {
    throw new UnsupportedOperationException("AnimatedFractionallySizedBox_readBack_widthFactor read-back requires FFM/java22");
  }
  default AlignmentGeometry AnimatedFractionallySizedBox_readBack_alignment(Object st) {
    throw new UnsupportedOperationException("AnimatedFractionallySizedBox_readBack_alignment read-back requires FFM/java22");
  }

  default int animatedPositionedAnimatedPositioned(Widget child, OptionalDouble left, OptionalDouble top, OptionalDouble right, OptionalDouble bottom, OptionalDouble width, OptionalDouble height, Optional<Curve> curve, Duration duration, Optional<Runnable> onEnd) {
    throw new UnsupportedOperationException("animatedPositionedAnimatedPositioned has no default (FFM/comm impl required)");
  }
  default Widget AnimatedPositioned_readBack_child(Object st) {
    throw new UnsupportedOperationException("AnimatedPositioned_readBack_child read-back requires FFM/java22");
  }
  default double AnimatedPositioned_readBack_left(Object st) {
    throw new UnsupportedOperationException("AnimatedPositioned_readBack_left read-back requires FFM/java22");
  }
  default double AnimatedPositioned_readBack_top(Object st) {
    throw new UnsupportedOperationException("AnimatedPositioned_readBack_top read-back requires FFM/java22");
  }
  default double AnimatedPositioned_readBack_right(Object st) {
    throw new UnsupportedOperationException("AnimatedPositioned_readBack_right read-back requires FFM/java22");
  }
  default double AnimatedPositioned_readBack_bottom(Object st) {
    throw new UnsupportedOperationException("AnimatedPositioned_readBack_bottom read-back requires FFM/java22");
  }
  default double AnimatedPositioned_readBack_width(Object st) {
    throw new UnsupportedOperationException("AnimatedPositioned_readBack_width read-back requires FFM/java22");
  }
  default double AnimatedPositioned_readBack_height(Object st) {
    throw new UnsupportedOperationException("AnimatedPositioned_readBack_height read-back requires FFM/java22");
  }

  default int animatedPositionedDirectionalAnimatedPositionedDirectional(Widget child, OptionalDouble start, OptionalDouble top, OptionalDouble end, OptionalDouble bottom, OptionalDouble width, OptionalDouble height, Optional<Curve> curve, Duration duration, Optional<Runnable> onEnd) {
    throw new UnsupportedOperationException("animatedPositionedDirectionalAnimatedPositionedDirectional has no default (FFM/comm impl required)");
  }
  default Widget AnimatedPositionedDirectional_readBack_child(Object st) {
    throw new UnsupportedOperationException("AnimatedPositionedDirectional_readBack_child read-back requires FFM/java22");
  }
  default double AnimatedPositionedDirectional_readBack_start(Object st) {
    throw new UnsupportedOperationException("AnimatedPositionedDirectional_readBack_start read-back requires FFM/java22");
  }
  default double AnimatedPositionedDirectional_readBack_top(Object st) {
    throw new UnsupportedOperationException("AnimatedPositionedDirectional_readBack_top read-back requires FFM/java22");
  }
  default double AnimatedPositionedDirectional_readBack_end(Object st) {
    throw new UnsupportedOperationException("AnimatedPositionedDirectional_readBack_end read-back requires FFM/java22");
  }
  default double AnimatedPositionedDirectional_readBack_bottom(Object st) {
    throw new UnsupportedOperationException("AnimatedPositionedDirectional_readBack_bottom read-back requires FFM/java22");
  }
  default double AnimatedPositionedDirectional_readBack_width(Object st) {
    throw new UnsupportedOperationException("AnimatedPositionedDirectional_readBack_width read-back requires FFM/java22");
  }
  default double AnimatedPositionedDirectional_readBack_height(Object st) {
    throw new UnsupportedOperationException("AnimatedPositionedDirectional_readBack_height read-back requires FFM/java22");
  }

  default int displayFeatureSubScreenDisplayFeatureSubScreen(Optional<Offset> anchorPoint, Widget child) {
    throw new UnsupportedOperationException("displayFeatureSubScreenDisplayFeatureSubScreen has no default (FFM/comm impl required)");
  }
  default Offset DisplayFeatureSubScreen_readBack_anchorPoint(Object st) {
    throw new UnsupportedOperationException("DisplayFeatureSubScreen_readBack_anchorPoint read-back requires FFM/java22");
  }
  default Widget DisplayFeatureSubScreen_readBack_child(Object st) {
    throw new UnsupportedOperationException("DisplayFeatureSubScreen_readBack_child read-back requires FFM/java22");
  }

  default int errorWidgetErrorWidget(NativeObj exception) {
    throw new UnsupportedOperationException("errorWidgetErrorWidget has no default (FFM/comm impl required)");
  }
  default int errorWidgetWithDetails(Optional<String> message) {
    throw new UnsupportedOperationException("errorWidgetWithDetails has no default (FFM/comm impl required)");
  }
  default String ErrorWidget_readBack_message(Object st) {
    throw new UnsupportedOperationException("ErrorWidget_readBack_message read-back requires FFM/java22");
  }

  default int restorationScopeRestorationScope(Optional<String> restorationId, Widget child) {
    throw new UnsupportedOperationException("restorationScopeRestorationScope has no default (FFM/comm impl required)");
  }
  default Widget RestorationScope_readBack_child(Object st) {
    throw new UnsupportedOperationException("RestorationScope_readBack_child read-back requires FFM/java22");
  }
  default String RestorationScope_readBack_restorationId(Object st) {
    throw new UnsupportedOperationException("RestorationScope_readBack_restorationId read-back requires FFM/java22");
  }

  default int rootRestorationScopeRootRestorationScope(Optional<String> restorationId, Widget child) {
    throw new UnsupportedOperationException("rootRestorationScopeRootRestorationScope has no default (FFM/comm impl required)");
  }
  default Widget RootRestorationScope_readBack_child(Object st) {
    throw new UnsupportedOperationException("RootRestorationScope_readBack_child read-back requires FFM/java22");
  }
  default String RootRestorationScope_readBack_restorationId(Object st) {
    throw new UnsupportedOperationException("RootRestorationScope_readBack_restorationId read-back requires FFM/java22");
  }

  default int stretchingOverscrollIndicatorStretchingOverscrollIndicator(AxisDirection axisDirection, Optional<Clip> clipBehavior, Optional<Widget> child) {
    throw new UnsupportedOperationException("stretchingOverscrollIndicatorStretchingOverscrollIndicator has no default (FFM/comm impl required)");
  }
  default AxisDirection StretchingOverscrollIndicator_readBack_axisDirection(Object st) {
    throw new UnsupportedOperationException("StretchingOverscrollIndicator_readBack_axisDirection read-back requires FFM/java22");
  }
  default Clip StretchingOverscrollIndicator_readBack_clipBehavior(Object st) {
    throw new UnsupportedOperationException("StretchingOverscrollIndicator_readBack_clipBehavior read-back requires FFM/java22");
  }
  default Widget StretchingOverscrollIndicator_readBack_child(Object st) {
    throw new UnsupportedOperationException("StretchingOverscrollIndicator_readBack_child read-back requires FFM/java22");
  }
  default Axis StretchingOverscrollIndicator_readBack_axis(Object st) {
    throw new UnsupportedOperationException("StretchingOverscrollIndicator_readBack_axis read-back requires FFM/java22");
  }

  default int tapRegionTapRegion(Optional<Widget> child, Optional<Boolean> enabled, Optional<HitTestBehavior> behavior, Optional<Consumer<PointerDownEvent>> onTapOutside, Optional<Consumer<PointerDownEvent>> onTapInside, Optional<Consumer<PointerUpEvent>> onTapUpOutside, Optional<Consumer<PointerUpEvent>> onTapUpInside, Optional<NativeObj> groupId, Optional<Boolean> consumeOutsideTaps, Optional<String> debugLabel) {
    throw new UnsupportedOperationException("tapRegionTapRegion has no default (FFM/comm impl required)");
  }
  default boolean TapRegion_readBack_enabled(Object st) {
    throw new UnsupportedOperationException("TapRegion_readBack_enabled read-back requires FFM/java22");
  }
  default HitTestBehavior TapRegion_readBack_behavior(Object st) {
    throw new UnsupportedOperationException("TapRegion_readBack_behavior read-back requires FFM/java22");
  }
  default boolean TapRegion_readBack_consumeOutsideTaps(Object st) {
    throw new UnsupportedOperationException("TapRegion_readBack_consumeOutsideTaps read-back requires FFM/java22");
  }
  default String TapRegion_readBack_debugLabel(Object st) {
    throw new UnsupportedOperationException("TapRegion_readBack_debugLabel read-back requires FFM/java22");
  }

  default int textFieldTapRegionTextFieldTapRegion(Optional<Widget> child, Optional<Boolean> enabled, Optional<Consumer<PointerDownEvent>> onTapOutside, Optional<Consumer<PointerDownEvent>> onTapInside, Optional<Consumer<PointerUpEvent>> onTapUpOutside, Optional<Consumer<PointerUpEvent>> onTapUpInside, Optional<Boolean> consumeOutsideTaps, Optional<String> debugLabel, Optional<NativeObj> groupId) {
    throw new UnsupportedOperationException("textFieldTapRegionTextFieldTapRegion has no default (FFM/comm impl required)");
  }

  default int colorSchemeColorScheme(Brightness brightness, Color primary, Color onPrimary, Optional<Color> primaryContainer, Optional<Color> onPrimaryContainer, Optional<Color> primaryFixed, Optional<Color> primaryFixedDim, Optional<Color> onPrimaryFixed, Optional<Color> onPrimaryFixedVariant, Color secondary, Color onSecondary, Optional<Color> secondaryContainer, Optional<Color> onSecondaryContainer, Optional<Color> secondaryFixed, Optional<Color> secondaryFixedDim, Optional<Color> onSecondaryFixed, Optional<Color> onSecondaryFixedVariant, Optional<Color> tertiary, Optional<Color> onTertiary, Optional<Color> tertiaryContainer, Optional<Color> onTertiaryContainer, Optional<Color> tertiaryFixed, Optional<Color> tertiaryFixedDim, Optional<Color> onTertiaryFixed, Optional<Color> onTertiaryFixedVariant, Color error, Color onError, Optional<Color> errorContainer, Optional<Color> onErrorContainer, Color surface, Color onSurface, Optional<Color> surfaceDim, Optional<Color> surfaceBright, Optional<Color> surfaceContainerLowest, Optional<Color> surfaceContainerLow, Optional<Color> surfaceContainer, Optional<Color> surfaceContainerHigh, Optional<Color> surfaceContainerHighest, Optional<Color> onSurfaceVariant, Optional<Color> outline, Optional<Color> outlineVariant, Optional<Color> shadow, Optional<Color> scrim, Optional<Color> inverseSurface, Optional<Color> onInverseSurface, Optional<Color> inversePrimary, Optional<Color> surfaceTint, Optional<Color> background, Optional<Color> onBackground, Optional<Color> surfaceVariant) {
    throw new UnsupportedOperationException("colorSchemeColorScheme has no default (FFM/comm impl required)");
  }
  default int colorSchemeFromSeed(Color seedColor, Optional<Brightness> brightness, Optional<DynamicSchemeVariant> dynamicSchemeVariant, OptionalDouble contrastLevel, Optional<Color> primary, Optional<Color> onPrimary, Optional<Color> primaryContainer, Optional<Color> onPrimaryContainer, Optional<Color> primaryFixed, Optional<Color> primaryFixedDim, Optional<Color> onPrimaryFixed, Optional<Color> onPrimaryFixedVariant, Optional<Color> secondary, Optional<Color> onSecondary, Optional<Color> secondaryContainer, Optional<Color> onSecondaryContainer, Optional<Color> secondaryFixed, Optional<Color> secondaryFixedDim, Optional<Color> onSecondaryFixed, Optional<Color> onSecondaryFixedVariant, Optional<Color> tertiary, Optional<Color> onTertiary, Optional<Color> tertiaryContainer, Optional<Color> onTertiaryContainer, Optional<Color> tertiaryFixed, Optional<Color> tertiaryFixedDim, Optional<Color> onTertiaryFixed, Optional<Color> onTertiaryFixedVariant, Optional<Color> error, Optional<Color> onError, Optional<Color> errorContainer, Optional<Color> onErrorContainer, Optional<Color> outline, Optional<Color> outlineVariant, Optional<Color> surface, Optional<Color> onSurface, Optional<Color> surfaceDim, Optional<Color> surfaceBright, Optional<Color> surfaceContainerLowest, Optional<Color> surfaceContainerLow, Optional<Color> surfaceContainer, Optional<Color> surfaceContainerHigh, Optional<Color> surfaceContainerHighest, Optional<Color> onSurfaceVariant, Optional<Color> inverseSurface, Optional<Color> onInverseSurface, Optional<Color> inversePrimary, Optional<Color> shadow, Optional<Color> scrim, Optional<Color> surfaceTint, Optional<Color> background, Optional<Color> onBackground, Optional<Color> surfaceVariant) {
    throw new UnsupportedOperationException("colorSchemeFromSeed has no default (FFM/comm impl required)");
  }
  default int colorSchemeLight(Optional<Brightness> brightness, Optional<Color> primary, Optional<Color> onPrimary, Optional<Color> primaryContainer, Optional<Color> onPrimaryContainer, Optional<Color> primaryFixed, Optional<Color> primaryFixedDim, Optional<Color> onPrimaryFixed, Optional<Color> onPrimaryFixedVariant, Optional<Color> secondary, Optional<Color> onSecondary, Optional<Color> secondaryContainer, Optional<Color> onSecondaryContainer, Optional<Color> secondaryFixed, Optional<Color> secondaryFixedDim, Optional<Color> onSecondaryFixed, Optional<Color> onSecondaryFixedVariant, Optional<Color> tertiary, Optional<Color> onTertiary, Optional<Color> tertiaryContainer, Optional<Color> onTertiaryContainer, Optional<Color> tertiaryFixed, Optional<Color> tertiaryFixedDim, Optional<Color> onTertiaryFixed, Optional<Color> onTertiaryFixedVariant, Optional<Color> error, Optional<Color> onError, Optional<Color> errorContainer, Optional<Color> onErrorContainer, Optional<Color> surface, Optional<Color> onSurface, Optional<Color> surfaceDim, Optional<Color> surfaceBright, Optional<Color> surfaceContainerLowest, Optional<Color> surfaceContainerLow, Optional<Color> surfaceContainer, Optional<Color> surfaceContainerHigh, Optional<Color> surfaceContainerHighest, Optional<Color> onSurfaceVariant, Optional<Color> outline, Optional<Color> outlineVariant, Optional<Color> shadow, Optional<Color> scrim, Optional<Color> inverseSurface, Optional<Color> onInverseSurface, Optional<Color> inversePrimary, Optional<Color> surfaceTint, Optional<Color> background, Optional<Color> onBackground, Optional<Color> surfaceVariant) {
    throw new UnsupportedOperationException("colorSchemeLight has no default (FFM/comm impl required)");
  }
  default int colorSchemeDark(Optional<Brightness> brightness, Optional<Color> primary, Optional<Color> onPrimary, Optional<Color> primaryContainer, Optional<Color> onPrimaryContainer, Optional<Color> primaryFixed, Optional<Color> primaryFixedDim, Optional<Color> onPrimaryFixed, Optional<Color> onPrimaryFixedVariant, Optional<Color> secondary, Optional<Color> onSecondary, Optional<Color> secondaryContainer, Optional<Color> onSecondaryContainer, Optional<Color> secondaryFixed, Optional<Color> secondaryFixedDim, Optional<Color> onSecondaryFixed, Optional<Color> onSecondaryFixedVariant, Optional<Color> tertiary, Optional<Color> onTertiary, Optional<Color> tertiaryContainer, Optional<Color> onTertiaryContainer, Optional<Color> tertiaryFixed, Optional<Color> tertiaryFixedDim, Optional<Color> onTertiaryFixed, Optional<Color> onTertiaryFixedVariant, Optional<Color> error, Optional<Color> onError, Optional<Color> errorContainer, Optional<Color> onErrorContainer, Optional<Color> surface, Optional<Color> onSurface, Optional<Color> surfaceDim, Optional<Color> surfaceBright, Optional<Color> surfaceContainerLowest, Optional<Color> surfaceContainerLow, Optional<Color> surfaceContainer, Optional<Color> surfaceContainerHigh, Optional<Color> surfaceContainerHighest, Optional<Color> onSurfaceVariant, Optional<Color> outline, Optional<Color> outlineVariant, Optional<Color> shadow, Optional<Color> scrim, Optional<Color> inverseSurface, Optional<Color> onInverseSurface, Optional<Color> inversePrimary, Optional<Color> surfaceTint, Optional<Color> background, Optional<Color> onBackground, Optional<Color> surfaceVariant) {
    throw new UnsupportedOperationException("colorSchemeDark has no default (FFM/comm impl required)");
  }
  default int colorSchemeHighContrastLight(Optional<Brightness> brightness, Optional<Color> primary, Optional<Color> onPrimary, Optional<Color> primaryContainer, Optional<Color> onPrimaryContainer, Optional<Color> primaryFixed, Optional<Color> primaryFixedDim, Optional<Color> onPrimaryFixed, Optional<Color> onPrimaryFixedVariant, Optional<Color> secondary, Optional<Color> onSecondary, Optional<Color> secondaryContainer, Optional<Color> onSecondaryContainer, Optional<Color> secondaryFixed, Optional<Color> secondaryFixedDim, Optional<Color> onSecondaryFixed, Optional<Color> onSecondaryFixedVariant, Optional<Color> tertiary, Optional<Color> onTertiary, Optional<Color> tertiaryContainer, Optional<Color> onTertiaryContainer, Optional<Color> tertiaryFixed, Optional<Color> tertiaryFixedDim, Optional<Color> onTertiaryFixed, Optional<Color> onTertiaryFixedVariant, Optional<Color> error, Optional<Color> onError, Optional<Color> errorContainer, Optional<Color> onErrorContainer, Optional<Color> surface, Optional<Color> onSurface, Optional<Color> surfaceDim, Optional<Color> surfaceBright, Optional<Color> surfaceContainerLowest, Optional<Color> surfaceContainerLow, Optional<Color> surfaceContainer, Optional<Color> surfaceContainerHigh, Optional<Color> surfaceContainerHighest, Optional<Color> onSurfaceVariant, Optional<Color> outline, Optional<Color> outlineVariant, Optional<Color> shadow, Optional<Color> scrim, Optional<Color> inverseSurface, Optional<Color> onInverseSurface, Optional<Color> inversePrimary, Optional<Color> surfaceTint, Optional<Color> background, Optional<Color> onBackground, Optional<Color> surfaceVariant) {
    throw new UnsupportedOperationException("colorSchemeHighContrastLight has no default (FFM/comm impl required)");
  }
  default int colorSchemeHighContrastDark(Optional<Brightness> brightness, Optional<Color> primary, Optional<Color> onPrimary, Optional<Color> primaryContainer, Optional<Color> onPrimaryContainer, Optional<Color> primaryFixed, Optional<Color> primaryFixedDim, Optional<Color> onPrimaryFixed, Optional<Color> onPrimaryFixedVariant, Optional<Color> secondary, Optional<Color> onSecondary, Optional<Color> secondaryContainer, Optional<Color> onSecondaryContainer, Optional<Color> secondaryFixed, Optional<Color> secondaryFixedDim, Optional<Color> onSecondaryFixed, Optional<Color> onSecondaryFixedVariant, Optional<Color> tertiary, Optional<Color> onTertiary, Optional<Color> tertiaryContainer, Optional<Color> onTertiaryContainer, Optional<Color> tertiaryFixed, Optional<Color> tertiaryFixedDim, Optional<Color> onTertiaryFixed, Optional<Color> onTertiaryFixedVariant, Optional<Color> error, Optional<Color> onError, Optional<Color> errorContainer, Optional<Color> onErrorContainer, Optional<Color> surface, Optional<Color> onSurface, Optional<Color> surfaceDim, Optional<Color> surfaceBright, Optional<Color> surfaceContainerLowest, Optional<Color> surfaceContainerLow, Optional<Color> surfaceContainer, Optional<Color> surfaceContainerHigh, Optional<Color> surfaceContainerHighest, Optional<Color> onSurfaceVariant, Optional<Color> outline, Optional<Color> outlineVariant, Optional<Color> shadow, Optional<Color> scrim, Optional<Color> inverseSurface, Optional<Color> onInverseSurface, Optional<Color> inversePrimary, Optional<Color> surfaceTint, Optional<Color> background, Optional<Color> onBackground, Optional<Color> surfaceVariant) {
    throw new UnsupportedOperationException("colorSchemeHighContrastDark has no default (FFM/comm impl required)");
  }
  default int colorSchemeFromSwatch(Optional<MaterialColor> primarySwatch, Optional<Color> accentColor, Optional<Color> cardColor, Optional<Color> backgroundColor, Optional<Color> errorColor, Optional<Brightness> brightness) {
    throw new UnsupportedOperationException("colorSchemeFromSwatch has no default (FFM/comm impl required)");
  }
  default int colorSchemeLerp(ColorScheme a, ColorScheme b, double t) {
    throw new UnsupportedOperationException("colorSchemeLerp has no default (FFM/comm impl required)");
  }
  default int colorSchemeOf(BuildContext context) {
    throw new UnsupportedOperationException("colorSchemeOf has no default (FFM/comm impl required)");
  }
  default Brightness ColorScheme_readBack_brightness(Object st) {
    throw new UnsupportedOperationException("ColorScheme_readBack_brightness read-back requires FFM/java22");
  }
  default Color ColorScheme_readBack_primary(Object st) {
    throw new UnsupportedOperationException("ColorScheme_readBack_primary read-back requires FFM/java22");
  }
  default Color ColorScheme_readBack_onPrimary(Object st) {
    throw new UnsupportedOperationException("ColorScheme_readBack_onPrimary read-back requires FFM/java22");
  }
  default Color ColorScheme_readBack_secondary(Object st) {
    throw new UnsupportedOperationException("ColorScheme_readBack_secondary read-back requires FFM/java22");
  }
  default Color ColorScheme_readBack_onSecondary(Object st) {
    throw new UnsupportedOperationException("ColorScheme_readBack_onSecondary read-back requires FFM/java22");
  }
  default Color ColorScheme_readBack_error(Object st) {
    throw new UnsupportedOperationException("ColorScheme_readBack_error read-back requires FFM/java22");
  }
  default Color ColorScheme_readBack_onError(Object st) {
    throw new UnsupportedOperationException("ColorScheme_readBack_onError read-back requires FFM/java22");
  }
  default Color ColorScheme_readBack_surface(Object st) {
    throw new UnsupportedOperationException("ColorScheme_readBack_surface read-back requires FFM/java22");
  }
  default Color ColorScheme_readBack_onSurface(Object st) {
    throw new UnsupportedOperationException("ColorScheme_readBack_onSurface read-back requires FFM/java22");
  }
  default Color ColorScheme_readBack_primaryContainer(Object st) {
    throw new UnsupportedOperationException("ColorScheme_readBack_primaryContainer read-back requires FFM/java22");
  }
  default Color ColorScheme_readBack_onPrimaryContainer(Object st) {
    throw new UnsupportedOperationException("ColorScheme_readBack_onPrimaryContainer read-back requires FFM/java22");
  }
  default Color ColorScheme_readBack_primaryFixed(Object st) {
    throw new UnsupportedOperationException("ColorScheme_readBack_primaryFixed read-back requires FFM/java22");
  }
  default Color ColorScheme_readBack_primaryFixedDim(Object st) {
    throw new UnsupportedOperationException("ColorScheme_readBack_primaryFixedDim read-back requires FFM/java22");
  }
  default Color ColorScheme_readBack_onPrimaryFixed(Object st) {
    throw new UnsupportedOperationException("ColorScheme_readBack_onPrimaryFixed read-back requires FFM/java22");
  }
  default Color ColorScheme_readBack_onPrimaryFixedVariant(Object st) {
    throw new UnsupportedOperationException("ColorScheme_readBack_onPrimaryFixedVariant read-back requires FFM/java22");
  }
  default Color ColorScheme_readBack_secondaryContainer(Object st) {
    throw new UnsupportedOperationException("ColorScheme_readBack_secondaryContainer read-back requires FFM/java22");
  }
  default Color ColorScheme_readBack_onSecondaryContainer(Object st) {
    throw new UnsupportedOperationException("ColorScheme_readBack_onSecondaryContainer read-back requires FFM/java22");
  }
  default Color ColorScheme_readBack_secondaryFixed(Object st) {
    throw new UnsupportedOperationException("ColorScheme_readBack_secondaryFixed read-back requires FFM/java22");
  }
  default Color ColorScheme_readBack_secondaryFixedDim(Object st) {
    throw new UnsupportedOperationException("ColorScheme_readBack_secondaryFixedDim read-back requires FFM/java22");
  }
  default Color ColorScheme_readBack_onSecondaryFixed(Object st) {
    throw new UnsupportedOperationException("ColorScheme_readBack_onSecondaryFixed read-back requires FFM/java22");
  }
  default Color ColorScheme_readBack_onSecondaryFixedVariant(Object st) {
    throw new UnsupportedOperationException("ColorScheme_readBack_onSecondaryFixedVariant read-back requires FFM/java22");
  }
  default Color ColorScheme_readBack_tertiary(Object st) {
    throw new UnsupportedOperationException("ColorScheme_readBack_tertiary read-back requires FFM/java22");
  }
  default Color ColorScheme_readBack_onTertiary(Object st) {
    throw new UnsupportedOperationException("ColorScheme_readBack_onTertiary read-back requires FFM/java22");
  }
  default Color ColorScheme_readBack_tertiaryContainer(Object st) {
    throw new UnsupportedOperationException("ColorScheme_readBack_tertiaryContainer read-back requires FFM/java22");
  }
  default Color ColorScheme_readBack_onTertiaryContainer(Object st) {
    throw new UnsupportedOperationException("ColorScheme_readBack_onTertiaryContainer read-back requires FFM/java22");
  }
  default Color ColorScheme_readBack_tertiaryFixed(Object st) {
    throw new UnsupportedOperationException("ColorScheme_readBack_tertiaryFixed read-back requires FFM/java22");
  }
  default Color ColorScheme_readBack_tertiaryFixedDim(Object st) {
    throw new UnsupportedOperationException("ColorScheme_readBack_tertiaryFixedDim read-back requires FFM/java22");
  }
  default Color ColorScheme_readBack_onTertiaryFixed(Object st) {
    throw new UnsupportedOperationException("ColorScheme_readBack_onTertiaryFixed read-back requires FFM/java22");
  }
  default Color ColorScheme_readBack_onTertiaryFixedVariant(Object st) {
    throw new UnsupportedOperationException("ColorScheme_readBack_onTertiaryFixedVariant read-back requires FFM/java22");
  }
  default Color ColorScheme_readBack_errorContainer(Object st) {
    throw new UnsupportedOperationException("ColorScheme_readBack_errorContainer read-back requires FFM/java22");
  }
  default Color ColorScheme_readBack_onErrorContainer(Object st) {
    throw new UnsupportedOperationException("ColorScheme_readBack_onErrorContainer read-back requires FFM/java22");
  }
  default Color ColorScheme_readBack_surfaceVariant(Object st) {
    throw new UnsupportedOperationException("ColorScheme_readBack_surfaceVariant read-back requires FFM/java22");
  }
  default Color ColorScheme_readBack_surfaceDim(Object st) {
    throw new UnsupportedOperationException("ColorScheme_readBack_surfaceDim read-back requires FFM/java22");
  }
  default Color ColorScheme_readBack_surfaceBright(Object st) {
    throw new UnsupportedOperationException("ColorScheme_readBack_surfaceBright read-back requires FFM/java22");
  }
  default Color ColorScheme_readBack_surfaceContainerLowest(Object st) {
    throw new UnsupportedOperationException("ColorScheme_readBack_surfaceContainerLowest read-back requires FFM/java22");
  }
  default Color ColorScheme_readBack_surfaceContainerLow(Object st) {
    throw new UnsupportedOperationException("ColorScheme_readBack_surfaceContainerLow read-back requires FFM/java22");
  }
  default Color ColorScheme_readBack_surfaceContainer(Object st) {
    throw new UnsupportedOperationException("ColorScheme_readBack_surfaceContainer read-back requires FFM/java22");
  }
  default Color ColorScheme_readBack_surfaceContainerHigh(Object st) {
    throw new UnsupportedOperationException("ColorScheme_readBack_surfaceContainerHigh read-back requires FFM/java22");
  }
  default Color ColorScheme_readBack_surfaceContainerHighest(Object st) {
    throw new UnsupportedOperationException("ColorScheme_readBack_surfaceContainerHighest read-back requires FFM/java22");
  }
  default Color ColorScheme_readBack_onSurfaceVariant(Object st) {
    throw new UnsupportedOperationException("ColorScheme_readBack_onSurfaceVariant read-back requires FFM/java22");
  }
  default Color ColorScheme_readBack_outline(Object st) {
    throw new UnsupportedOperationException("ColorScheme_readBack_outline read-back requires FFM/java22");
  }
  default Color ColorScheme_readBack_outlineVariant(Object st) {
    throw new UnsupportedOperationException("ColorScheme_readBack_outlineVariant read-back requires FFM/java22");
  }
  default Color ColorScheme_readBack_shadow(Object st) {
    throw new UnsupportedOperationException("ColorScheme_readBack_shadow read-back requires FFM/java22");
  }
  default Color ColorScheme_readBack_scrim(Object st) {
    throw new UnsupportedOperationException("ColorScheme_readBack_scrim read-back requires FFM/java22");
  }
  default Color ColorScheme_readBack_inverseSurface(Object st) {
    throw new UnsupportedOperationException("ColorScheme_readBack_inverseSurface read-back requires FFM/java22");
  }
  default Color ColorScheme_readBack_onInverseSurface(Object st) {
    throw new UnsupportedOperationException("ColorScheme_readBack_onInverseSurface read-back requires FFM/java22");
  }
  default Color ColorScheme_readBack_inversePrimary(Object st) {
    throw new UnsupportedOperationException("ColorScheme_readBack_inversePrimary read-back requires FFM/java22");
  }
  default Color ColorScheme_readBack_surfaceTint(Object st) {
    throw new UnsupportedOperationException("ColorScheme_readBack_surfaceTint read-back requires FFM/java22");
  }
  default Color ColorScheme_readBack_background(Object st) {
    throw new UnsupportedOperationException("ColorScheme_readBack_background read-back requires FFM/java22");
  }
  default Color ColorScheme_readBack_onBackground(Object st) {
    throw new UnsupportedOperationException("ColorScheme_readBack_onBackground read-back requires FFM/java22");
  }

  default int materialColorMaterialColor(int primary, Map<Integer, Color> swatch) {
    throw new UnsupportedOperationException("materialColorMaterialColor has no default (FFM/comm impl required)");
  }
  default Color MaterialColor_readBack_shade50(Object st) {
    throw new UnsupportedOperationException("MaterialColor_readBack_shade50 read-back requires FFM/java22");
  }
  default Color MaterialColor_readBack_shade100(Object st) {
    throw new UnsupportedOperationException("MaterialColor_readBack_shade100 read-back requires FFM/java22");
  }
  default Color MaterialColor_readBack_shade200(Object st) {
    throw new UnsupportedOperationException("MaterialColor_readBack_shade200 read-back requires FFM/java22");
  }
  default Color MaterialColor_readBack_shade300(Object st) {
    throw new UnsupportedOperationException("MaterialColor_readBack_shade300 read-back requires FFM/java22");
  }
  default Color MaterialColor_readBack_shade400(Object st) {
    throw new UnsupportedOperationException("MaterialColor_readBack_shade400 read-back requires FFM/java22");
  }
  default Color MaterialColor_readBack_shade500(Object st) {
    throw new UnsupportedOperationException("MaterialColor_readBack_shade500 read-back requires FFM/java22");
  }
  default Color MaterialColor_readBack_shade600(Object st) {
    throw new UnsupportedOperationException("MaterialColor_readBack_shade600 read-back requires FFM/java22");
  }
  default Color MaterialColor_readBack_shade700(Object st) {
    throw new UnsupportedOperationException("MaterialColor_readBack_shade700 read-back requires FFM/java22");
  }
  default Color MaterialColor_readBack_shade800(Object st) {
    throw new UnsupportedOperationException("MaterialColor_readBack_shade800 read-back requires FFM/java22");
  }
  default Color MaterialColor_readBack_shade900(Object st) {
    throw new UnsupportedOperationException("MaterialColor_readBack_shade900 read-back requires FFM/java22");
  }

  default <T> int colorSwatchLerp(ColorSwatch a, ColorSwatch b, double t) {
    throw new UnsupportedOperationException("colorSwatchLerp has no default (FFM/comm impl required)");
  }

  default int textThemeTextTheme(Optional<TextStyle> displayLarge, Optional<TextStyle> displayMedium, Optional<TextStyle> displaySmall, Optional<TextStyle> headlineLarge, Optional<TextStyle> headlineMedium, Optional<TextStyle> headlineSmall, Optional<TextStyle> titleLarge, Optional<TextStyle> titleMedium, Optional<TextStyle> titleSmall, Optional<TextStyle> bodyLarge, Optional<TextStyle> bodyMedium, Optional<TextStyle> bodySmall, Optional<TextStyle> labelLarge, Optional<TextStyle> labelMedium, Optional<TextStyle> labelSmall) {
    throw new UnsupportedOperationException("textThemeTextTheme has no default (FFM/comm impl required)");
  }
  default int textThemeLerp(TextTheme a, TextTheme b, double t) {
    throw new UnsupportedOperationException("textThemeLerp has no default (FFM/comm impl required)");
  }
  default int textThemeOf(BuildContext context) {
    throw new UnsupportedOperationException("textThemeOf has no default (FFM/comm impl required)");
  }
  default int textThemePrimaryOf(BuildContext context) {
    throw new UnsupportedOperationException("textThemePrimaryOf has no default (FFM/comm impl required)");
  }
  default TextStyle TextTheme_readBack_displayLarge(Object st) {
    throw new UnsupportedOperationException("TextTheme_readBack_displayLarge read-back requires FFM/java22");
  }
  default TextStyle TextTheme_readBack_displayMedium(Object st) {
    throw new UnsupportedOperationException("TextTheme_readBack_displayMedium read-back requires FFM/java22");
  }
  default TextStyle TextTheme_readBack_displaySmall(Object st) {
    throw new UnsupportedOperationException("TextTheme_readBack_displaySmall read-back requires FFM/java22");
  }
  default TextStyle TextTheme_readBack_headlineLarge(Object st) {
    throw new UnsupportedOperationException("TextTheme_readBack_headlineLarge read-back requires FFM/java22");
  }
  default TextStyle TextTheme_readBack_headlineMedium(Object st) {
    throw new UnsupportedOperationException("TextTheme_readBack_headlineMedium read-back requires FFM/java22");
  }
  default TextStyle TextTheme_readBack_headlineSmall(Object st) {
    throw new UnsupportedOperationException("TextTheme_readBack_headlineSmall read-back requires FFM/java22");
  }
  default TextStyle TextTheme_readBack_titleLarge(Object st) {
    throw new UnsupportedOperationException("TextTheme_readBack_titleLarge read-back requires FFM/java22");
  }
  default TextStyle TextTheme_readBack_titleMedium(Object st) {
    throw new UnsupportedOperationException("TextTheme_readBack_titleMedium read-back requires FFM/java22");
  }
  default TextStyle TextTheme_readBack_titleSmall(Object st) {
    throw new UnsupportedOperationException("TextTheme_readBack_titleSmall read-back requires FFM/java22");
  }
  default TextStyle TextTheme_readBack_bodyLarge(Object st) {
    throw new UnsupportedOperationException("TextTheme_readBack_bodyLarge read-back requires FFM/java22");
  }
  default TextStyle TextTheme_readBack_bodyMedium(Object st) {
    throw new UnsupportedOperationException("TextTheme_readBack_bodyMedium read-back requires FFM/java22");
  }
  default TextStyle TextTheme_readBack_bodySmall(Object st) {
    throw new UnsupportedOperationException("TextTheme_readBack_bodySmall read-back requires FFM/java22");
  }
  default TextStyle TextTheme_readBack_labelLarge(Object st) {
    throw new UnsupportedOperationException("TextTheme_readBack_labelLarge read-back requires FFM/java22");
  }
  default TextStyle TextTheme_readBack_labelMedium(Object st) {
    throw new UnsupportedOperationException("TextTheme_readBack_labelMedium read-back requires FFM/java22");
  }
  default TextStyle TextTheme_readBack_labelSmall(Object st) {
    throw new UnsupportedOperationException("TextTheme_readBack_labelSmall read-back requires FFM/java22");
  }

  default int themeDataThemeData(Optional<Boolean> applyElevationOverlayColor, Optional<NoDefaultCupertinoThemeData> cupertinoOverrideTheme, Optional<NativeObj> inputDecorationTheme, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<TargetPlatform> platform, Optional<Boolean> useMaterial3, Optional<Boolean> useSystemColors, Optional<VisualDensity> visualDensity, Optional<ColorScheme> colorScheme, Optional<Brightness> brightness, Optional<Color> colorSchemeSeed, Optional<Color> canvasColor, Optional<Color> cardColor, Optional<Color> disabledColor, Optional<Color> dividerColor, Optional<Color> focusColor, Optional<Color> highlightColor, Optional<Color> hintColor, Optional<Color> hoverColor, Optional<Color> primaryColor, Optional<Color> primaryColorDark, Optional<Color> primaryColorLight, Optional<MaterialColor> primarySwatch, Optional<Color> scaffoldBackgroundColor, Optional<Color> secondaryHeaderColor, Optional<Color> shadowColor, Optional<Color> splashColor, Optional<Color> unselectedWidgetColor, Optional<String> fontFamily, Optional<List<String>> fontFamilyFallback, Optional<String> _package, Optional<IconThemeData> iconTheme, Optional<IconThemeData> primaryIconTheme, Optional<TextTheme> primaryTextTheme, Optional<TextTheme> textTheme, Optional<ActionIconThemeData> actionIconTheme, Optional<NativeObj> appBarTheme, Optional<BadgeThemeData> badgeTheme, Optional<BottomAppBarThemeData> bottomAppBarTheme, Optional<BottomNavigationBarThemeData> bottomNavigationBarTheme, Optional<BottomSheetThemeData> bottomSheetTheme, Optional<ButtonThemeData> buttonTheme, Optional<CardThemeData> cardTheme, Optional<CarouselViewThemeData> carouselViewTheme, Optional<CheckboxThemeData> checkboxTheme, Optional<ChipThemeData> chipTheme, Optional<DataTableThemeData> dataTableTheme, Optional<DatePickerThemeData> datePickerTheme, Optional<DialogThemeData> dialogTheme, Optional<DividerThemeData> dividerTheme, Optional<DrawerThemeData> drawerTheme, Optional<DropdownMenuThemeData> dropdownMenuTheme, Optional<ElevatedButtonThemeData> elevatedButtonTheme, Optional<ExpansionTileThemeData> expansionTileTheme, Optional<FilledButtonThemeData> filledButtonTheme, Optional<FloatingActionButtonThemeData> floatingActionButtonTheme, Optional<IconButtonThemeData> iconButtonTheme, Optional<MenuBarThemeData> menuBarTheme, Optional<MenuButtonThemeData> menuButtonTheme, Optional<MenuThemeData> menuTheme, Optional<NavigationBarThemeData> navigationBarTheme, Optional<NavigationDrawerThemeData> navigationDrawerTheme, Optional<NavigationRailThemeData> navigationRailTheme, Optional<OutlinedButtonThemeData> outlinedButtonTheme, Optional<PopupMenuThemeData> popupMenuTheme, Optional<ProgressIndicatorThemeData> progressIndicatorTheme, Optional<RadioThemeData> radioTheme, Optional<SearchBarThemeData> searchBarTheme, Optional<SearchViewThemeData> searchViewTheme, Optional<SegmentedButtonThemeData> segmentedButtonTheme, Optional<SliderThemeData> sliderTheme, Optional<SnackBarThemeData> snackBarTheme, Optional<SwitchThemeData> switchTheme, Optional<TabBarThemeData> tabBarTheme, Optional<TextButtonThemeData> textButtonTheme, Optional<TextSelectionThemeData> textSelectionTheme, Optional<TimePickerThemeData> timePickerTheme, Optional<ToggleButtonsThemeData> toggleButtonsTheme, Optional<TooltipThemeData> tooltipTheme, Optional<Color> dialogBackgroundColor, Optional<Color> indicatorColor) {
    throw new UnsupportedOperationException("themeDataThemeData has no default (FFM/comm impl required)");
  }
  default int themeDataFrom(ColorScheme colorScheme, Optional<TextTheme> textTheme, Optional<Boolean> useMaterial3) {
    throw new UnsupportedOperationException("themeDataFrom has no default (FFM/comm impl required)");
  }
  default int themeDataLight(Optional<Boolean> useMaterial3) {
    throw new UnsupportedOperationException("themeDataLight has no default (FFM/comm impl required)");
  }
  default int themeDataDark(Optional<Boolean> useMaterial3) {
    throw new UnsupportedOperationException("themeDataDark has no default (FFM/comm impl required)");
  }
  default int themeDataFallback(Optional<Boolean> useMaterial3) {
    throw new UnsupportedOperationException("themeDataFallback has no default (FFM/comm impl required)");
  }
  default int themeDataLocalize(ThemeData baseTheme, TextTheme localTextGeometry) {
    throw new UnsupportedOperationException("themeDataLocalize has no default (FFM/comm impl required)");
  }
  default int themeDataEstimateBrightnessForColor(Color color) {
    throw new UnsupportedOperationException("themeDataEstimateBrightnessForColor has no default (FFM/comm impl required)");
  }
  default int themeDataLerp(ThemeData a, ThemeData b, double t) {
    throw new UnsupportedOperationException("themeDataLerp has no default (FFM/comm impl required)");
  }
  default boolean ThemeData_readBack_applyElevationOverlayColor(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_applyElevationOverlayColor read-back requires FFM/java22");
  }
  default NoDefaultCupertinoThemeData ThemeData_readBack_cupertinoOverrideTheme(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_cupertinoOverrideTheme read-back requires FFM/java22");
  }
  default MaterialTapTargetSize ThemeData_readBack_materialTapTargetSize(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_materialTapTargetSize read-back requires FFM/java22");
  }
  default TargetPlatform ThemeData_readBack_platform(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_platform read-back requires FFM/java22");
  }
  default boolean ThemeData_readBack_useMaterial3(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_useMaterial3 read-back requires FFM/java22");
  }
  default VisualDensity ThemeData_readBack_visualDensity(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_visualDensity read-back requires FFM/java22");
  }
  default Color ThemeData_readBack_canvasColor(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_canvasColor read-back requires FFM/java22");
  }
  default Color ThemeData_readBack_cardColor(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_cardColor read-back requires FFM/java22");
  }
  default ColorScheme ThemeData_readBack_colorScheme(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_colorScheme read-back requires FFM/java22");
  }
  default Color ThemeData_readBack_disabledColor(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_disabledColor read-back requires FFM/java22");
  }
  default Color ThemeData_readBack_dividerColor(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_dividerColor read-back requires FFM/java22");
  }
  default Color ThemeData_readBack_focusColor(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_focusColor read-back requires FFM/java22");
  }
  default Color ThemeData_readBack_highlightColor(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_highlightColor read-back requires FFM/java22");
  }
  default Color ThemeData_readBack_hintColor(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_hintColor read-back requires FFM/java22");
  }
  default Color ThemeData_readBack_hoverColor(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_hoverColor read-back requires FFM/java22");
  }
  default Color ThemeData_readBack_primaryColor(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_primaryColor read-back requires FFM/java22");
  }
  default Color ThemeData_readBack_primaryColorDark(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_primaryColorDark read-back requires FFM/java22");
  }
  default Color ThemeData_readBack_primaryColorLight(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_primaryColorLight read-back requires FFM/java22");
  }
  default Color ThemeData_readBack_scaffoldBackgroundColor(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_scaffoldBackgroundColor read-back requires FFM/java22");
  }
  default Color ThemeData_readBack_secondaryHeaderColor(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_secondaryHeaderColor read-back requires FFM/java22");
  }
  default Color ThemeData_readBack_shadowColor(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_shadowColor read-back requires FFM/java22");
  }
  default Color ThemeData_readBack_splashColor(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_splashColor read-back requires FFM/java22");
  }
  default Color ThemeData_readBack_unselectedWidgetColor(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_unselectedWidgetColor read-back requires FFM/java22");
  }
  default IconThemeData ThemeData_readBack_iconTheme(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_iconTheme read-back requires FFM/java22");
  }
  default IconThemeData ThemeData_readBack_primaryIconTheme(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_primaryIconTheme read-back requires FFM/java22");
  }
  default TextTheme ThemeData_readBack_primaryTextTheme(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_primaryTextTheme read-back requires FFM/java22");
  }
  default TextTheme ThemeData_readBack_textTheme(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_textTheme read-back requires FFM/java22");
  }
  default ActionIconThemeData ThemeData_readBack_actionIconTheme(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_actionIconTheme read-back requires FFM/java22");
  }
  default AppBarThemeData ThemeData_readBack_appBarTheme(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_appBarTheme read-back requires FFM/java22");
  }
  default BadgeThemeData ThemeData_readBack_badgeTheme(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_badgeTheme read-back requires FFM/java22");
  }
  default BottomAppBarThemeData ThemeData_readBack_bottomAppBarTheme(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_bottomAppBarTheme read-back requires FFM/java22");
  }
  default BottomNavigationBarThemeData ThemeData_readBack_bottomNavigationBarTheme(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_bottomNavigationBarTheme read-back requires FFM/java22");
  }
  default BottomSheetThemeData ThemeData_readBack_bottomSheetTheme(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_bottomSheetTheme read-back requires FFM/java22");
  }
  default ButtonThemeData ThemeData_readBack_buttonTheme(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_buttonTheme read-back requires FFM/java22");
  }
  default CardThemeData ThemeData_readBack_cardTheme(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_cardTheme read-back requires FFM/java22");
  }
  default CarouselViewThemeData ThemeData_readBack_carouselViewTheme(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_carouselViewTheme read-back requires FFM/java22");
  }
  default CheckboxThemeData ThemeData_readBack_checkboxTheme(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_checkboxTheme read-back requires FFM/java22");
  }
  default ChipThemeData ThemeData_readBack_chipTheme(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_chipTheme read-back requires FFM/java22");
  }
  default DataTableThemeData ThemeData_readBack_dataTableTheme(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_dataTableTheme read-back requires FFM/java22");
  }
  default DatePickerThemeData ThemeData_readBack_datePickerTheme(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_datePickerTheme read-back requires FFM/java22");
  }
  default DialogThemeData ThemeData_readBack_dialogTheme(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_dialogTheme read-back requires FFM/java22");
  }
  default DividerThemeData ThemeData_readBack_dividerTheme(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_dividerTheme read-back requires FFM/java22");
  }
  default DrawerThemeData ThemeData_readBack_drawerTheme(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_drawerTheme read-back requires FFM/java22");
  }
  default DropdownMenuThemeData ThemeData_readBack_dropdownMenuTheme(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_dropdownMenuTheme read-back requires FFM/java22");
  }
  default ElevatedButtonThemeData ThemeData_readBack_elevatedButtonTheme(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_elevatedButtonTheme read-back requires FFM/java22");
  }
  default ExpansionTileThemeData ThemeData_readBack_expansionTileTheme(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_expansionTileTheme read-back requires FFM/java22");
  }
  default FilledButtonThemeData ThemeData_readBack_filledButtonTheme(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_filledButtonTheme read-back requires FFM/java22");
  }
  default FloatingActionButtonThemeData ThemeData_readBack_floatingActionButtonTheme(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_floatingActionButtonTheme read-back requires FFM/java22");
  }
  default IconButtonThemeData ThemeData_readBack_iconButtonTheme(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_iconButtonTheme read-back requires FFM/java22");
  }
  default MenuBarThemeData ThemeData_readBack_menuBarTheme(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_menuBarTheme read-back requires FFM/java22");
  }
  default MenuButtonThemeData ThemeData_readBack_menuButtonTheme(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_menuButtonTheme read-back requires FFM/java22");
  }
  default MenuThemeData ThemeData_readBack_menuTheme(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_menuTheme read-back requires FFM/java22");
  }
  default NavigationBarThemeData ThemeData_readBack_navigationBarTheme(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_navigationBarTheme read-back requires FFM/java22");
  }
  default NavigationDrawerThemeData ThemeData_readBack_navigationDrawerTheme(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_navigationDrawerTheme read-back requires FFM/java22");
  }
  default NavigationRailThemeData ThemeData_readBack_navigationRailTheme(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_navigationRailTheme read-back requires FFM/java22");
  }
  default OutlinedButtonThemeData ThemeData_readBack_outlinedButtonTheme(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_outlinedButtonTheme read-back requires FFM/java22");
  }
  default PopupMenuThemeData ThemeData_readBack_popupMenuTheme(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_popupMenuTheme read-back requires FFM/java22");
  }
  default ProgressIndicatorThemeData ThemeData_readBack_progressIndicatorTheme(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_progressIndicatorTheme read-back requires FFM/java22");
  }
  default RadioThemeData ThemeData_readBack_radioTheme(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_radioTheme read-back requires FFM/java22");
  }
  default SearchBarThemeData ThemeData_readBack_searchBarTheme(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_searchBarTheme read-back requires FFM/java22");
  }
  default SearchViewThemeData ThemeData_readBack_searchViewTheme(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_searchViewTheme read-back requires FFM/java22");
  }
  default SegmentedButtonThemeData ThemeData_readBack_segmentedButtonTheme(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_segmentedButtonTheme read-back requires FFM/java22");
  }
  default SliderThemeData ThemeData_readBack_sliderTheme(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_sliderTheme read-back requires FFM/java22");
  }
  default SnackBarThemeData ThemeData_readBack_snackBarTheme(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_snackBarTheme read-back requires FFM/java22");
  }
  default SwitchThemeData ThemeData_readBack_switchTheme(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_switchTheme read-back requires FFM/java22");
  }
  default TabBarThemeData ThemeData_readBack_tabBarTheme(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_tabBarTheme read-back requires FFM/java22");
  }
  default TextButtonThemeData ThemeData_readBack_textButtonTheme(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_textButtonTheme read-back requires FFM/java22");
  }
  default TextSelectionThemeData ThemeData_readBack_textSelectionTheme(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_textSelectionTheme read-back requires FFM/java22");
  }
  default TimePickerThemeData ThemeData_readBack_timePickerTheme(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_timePickerTheme read-back requires FFM/java22");
  }
  default ToggleButtonsThemeData ThemeData_readBack_toggleButtonsTheme(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_toggleButtonsTheme read-back requires FFM/java22");
  }
  default TooltipThemeData ThemeData_readBack_tooltipTheme(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_tooltipTheme read-back requires FFM/java22");
  }
  default Color ThemeData_readBack_dialogBackgroundColor(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_dialogBackgroundColor read-back requires FFM/java22");
  }
  default Color ThemeData_readBack_indicatorColor(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_indicatorColor read-back requires FFM/java22");
  }
  default Brightness ThemeData_readBack_brightness(Object st) {
    throw new UnsupportedOperationException("ThemeData_readBack_brightness read-back requires FFM/java22");
  }

  default int noDefaultCupertinoThemeDataNoDefaultCupertinoThemeData(Optional<Brightness> brightness, Optional<Color> primaryColor, Optional<Color> primaryContrastingColor, Optional<CupertinoTextThemeData> textTheme, Optional<Color> barBackgroundColor, Optional<Color> scaffoldBackgroundColor, Optional<Color> selectionHandleColor, Optional<Boolean> applyThemeToAll) {
    throw new UnsupportedOperationException("noDefaultCupertinoThemeDataNoDefaultCupertinoThemeData has no default (FFM/comm impl required)");
  }
  default Brightness NoDefaultCupertinoThemeData_readBack_brightness(Object st) {
    throw new UnsupportedOperationException("NoDefaultCupertinoThemeData_readBack_brightness read-back requires FFM/java22");
  }
  default Color NoDefaultCupertinoThemeData_readBack_primaryColor(Object st) {
    throw new UnsupportedOperationException("NoDefaultCupertinoThemeData_readBack_primaryColor read-back requires FFM/java22");
  }
  default Color NoDefaultCupertinoThemeData_readBack_primaryContrastingColor(Object st) {
    throw new UnsupportedOperationException("NoDefaultCupertinoThemeData_readBack_primaryContrastingColor read-back requires FFM/java22");
  }
  default CupertinoTextThemeData NoDefaultCupertinoThemeData_readBack_textTheme(Object st) {
    throw new UnsupportedOperationException("NoDefaultCupertinoThemeData_readBack_textTheme read-back requires FFM/java22");
  }
  default Color NoDefaultCupertinoThemeData_readBack_barBackgroundColor(Object st) {
    throw new UnsupportedOperationException("NoDefaultCupertinoThemeData_readBack_barBackgroundColor read-back requires FFM/java22");
  }
  default Color NoDefaultCupertinoThemeData_readBack_scaffoldBackgroundColor(Object st) {
    throw new UnsupportedOperationException("NoDefaultCupertinoThemeData_readBack_scaffoldBackgroundColor read-back requires FFM/java22");
  }
  default Color NoDefaultCupertinoThemeData_readBack_selectionHandleColor(Object st) {
    throw new UnsupportedOperationException("NoDefaultCupertinoThemeData_readBack_selectionHandleColor read-back requires FFM/java22");
  }
  default boolean NoDefaultCupertinoThemeData_readBack_applyThemeToAll(Object st) {
    throw new UnsupportedOperationException("NoDefaultCupertinoThemeData_readBack_applyThemeToAll read-back requires FFM/java22");
  }

  default int actionIconThemeDataActionIconThemeData(Optional<Function<BuildContext, Widget>> backButtonIconBuilder, Optional<Function<BuildContext, Widget>> closeButtonIconBuilder, Optional<Function<BuildContext, Widget>> drawerButtonIconBuilder, Optional<Function<BuildContext, Widget>> endDrawerButtonIconBuilder) {
    throw new UnsupportedOperationException("actionIconThemeDataActionIconThemeData has no default (FFM/comm impl required)");
  }
  default int actionIconThemeDataLerp(ActionIconThemeData a, ActionIconThemeData b, double t) {
    throw new UnsupportedOperationException("actionIconThemeDataLerp has no default (FFM/comm impl required)");
  }

  default int badgeThemeDataBadgeThemeData(Optional<Color> backgroundColor, Optional<Color> textColor, OptionalDouble smallSize, OptionalDouble largeSize, Optional<TextStyle> textStyle, Optional<EdgeInsetsGeometry> padding, Optional<AlignmentGeometry> alignment, Optional<Offset> offset) {
    throw new UnsupportedOperationException("badgeThemeDataBadgeThemeData has no default (FFM/comm impl required)");
  }
  default int badgeThemeDataLerp(BadgeThemeData a, BadgeThemeData b, double t) {
    throw new UnsupportedOperationException("badgeThemeDataLerp has no default (FFM/comm impl required)");
  }
  default Color BadgeThemeData_readBack_backgroundColor(Object st) {
    throw new UnsupportedOperationException("BadgeThemeData_readBack_backgroundColor read-back requires FFM/java22");
  }
  default Color BadgeThemeData_readBack_textColor(Object st) {
    throw new UnsupportedOperationException("BadgeThemeData_readBack_textColor read-back requires FFM/java22");
  }
  default double BadgeThemeData_readBack_smallSize(Object st) {
    throw new UnsupportedOperationException("BadgeThemeData_readBack_smallSize read-back requires FFM/java22");
  }
  default double BadgeThemeData_readBack_largeSize(Object st) {
    throw new UnsupportedOperationException("BadgeThemeData_readBack_largeSize read-back requires FFM/java22");
  }
  default TextStyle BadgeThemeData_readBack_textStyle(Object st) {
    throw new UnsupportedOperationException("BadgeThemeData_readBack_textStyle read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry BadgeThemeData_readBack_padding(Object st) {
    throw new UnsupportedOperationException("BadgeThemeData_readBack_padding read-back requires FFM/java22");
  }
  default AlignmentGeometry BadgeThemeData_readBack_alignment(Object st) {
    throw new UnsupportedOperationException("BadgeThemeData_readBack_alignment read-back requires FFM/java22");
  }
  default Offset BadgeThemeData_readBack_offset(Object st) {
    throw new UnsupportedOperationException("BadgeThemeData_readBack_offset read-back requires FFM/java22");
  }

  default int bottomAppBarThemeDataBottomAppBarThemeData(Optional<Color> color, OptionalDouble elevation, OptionalDouble height, Optional<Color> surfaceTintColor, Optional<Color> shadowColor, Optional<EdgeInsetsGeometry> padding) {
    throw new UnsupportedOperationException("bottomAppBarThemeDataBottomAppBarThemeData has no default (FFM/comm impl required)");
  }
  default int bottomAppBarThemeDataLerp(BottomAppBarThemeData a, BottomAppBarThemeData b, double t) {
    throw new UnsupportedOperationException("bottomAppBarThemeDataLerp has no default (FFM/comm impl required)");
  }
  default Color BottomAppBarThemeData_readBack_color(Object st) {
    throw new UnsupportedOperationException("BottomAppBarThemeData_readBack_color read-back requires FFM/java22");
  }
  default double BottomAppBarThemeData_readBack_elevation(Object st) {
    throw new UnsupportedOperationException("BottomAppBarThemeData_readBack_elevation read-back requires FFM/java22");
  }
  default double BottomAppBarThemeData_readBack_height(Object st) {
    throw new UnsupportedOperationException("BottomAppBarThemeData_readBack_height read-back requires FFM/java22");
  }
  default Color BottomAppBarThemeData_readBack_surfaceTintColor(Object st) {
    throw new UnsupportedOperationException("BottomAppBarThemeData_readBack_surfaceTintColor read-back requires FFM/java22");
  }
  default Color BottomAppBarThemeData_readBack_shadowColor(Object st) {
    throw new UnsupportedOperationException("BottomAppBarThemeData_readBack_shadowColor read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry BottomAppBarThemeData_readBack_padding(Object st) {
    throw new UnsupportedOperationException("BottomAppBarThemeData_readBack_padding read-back requires FFM/java22");
  }

  default int bottomNavigationBarThemeDataBottomNavigationBarThemeData(Optional<Color> backgroundColor, OptionalDouble elevation, Optional<IconThemeData> selectedIconTheme, Optional<IconThemeData> unselectedIconTheme, Optional<Color> selectedItemColor, Optional<Color> unselectedItemColor, Optional<TextStyle> selectedLabelStyle, Optional<TextStyle> unselectedLabelStyle, Optional<Boolean> showSelectedLabels, Optional<Boolean> showUnselectedLabels, Optional<BottomNavigationBarType> type, Optional<Boolean> enableFeedback, Optional<BottomNavigationBarLandscapeLayout> landscapeLayout) {
    throw new UnsupportedOperationException("bottomNavigationBarThemeDataBottomNavigationBarThemeData has no default (FFM/comm impl required)");
  }
  default int bottomNavigationBarThemeDataLerp(BottomNavigationBarThemeData a, BottomNavigationBarThemeData b, double t) {
    throw new UnsupportedOperationException("bottomNavigationBarThemeDataLerp has no default (FFM/comm impl required)");
  }
  default Color BottomNavigationBarThemeData_readBack_backgroundColor(Object st) {
    throw new UnsupportedOperationException("BottomNavigationBarThemeData_readBack_backgroundColor read-back requires FFM/java22");
  }
  default double BottomNavigationBarThemeData_readBack_elevation(Object st) {
    throw new UnsupportedOperationException("BottomNavigationBarThemeData_readBack_elevation read-back requires FFM/java22");
  }
  default IconThemeData BottomNavigationBarThemeData_readBack_selectedIconTheme(Object st) {
    throw new UnsupportedOperationException("BottomNavigationBarThemeData_readBack_selectedIconTheme read-back requires FFM/java22");
  }
  default IconThemeData BottomNavigationBarThemeData_readBack_unselectedIconTheme(Object st) {
    throw new UnsupportedOperationException("BottomNavigationBarThemeData_readBack_unselectedIconTheme read-back requires FFM/java22");
  }
  default Color BottomNavigationBarThemeData_readBack_selectedItemColor(Object st) {
    throw new UnsupportedOperationException("BottomNavigationBarThemeData_readBack_selectedItemColor read-back requires FFM/java22");
  }
  default Color BottomNavigationBarThemeData_readBack_unselectedItemColor(Object st) {
    throw new UnsupportedOperationException("BottomNavigationBarThemeData_readBack_unselectedItemColor read-back requires FFM/java22");
  }
  default TextStyle BottomNavigationBarThemeData_readBack_selectedLabelStyle(Object st) {
    throw new UnsupportedOperationException("BottomNavigationBarThemeData_readBack_selectedLabelStyle read-back requires FFM/java22");
  }
  default TextStyle BottomNavigationBarThemeData_readBack_unselectedLabelStyle(Object st) {
    throw new UnsupportedOperationException("BottomNavigationBarThemeData_readBack_unselectedLabelStyle read-back requires FFM/java22");
  }
  default boolean BottomNavigationBarThemeData_readBack_showSelectedLabels(Object st) {
    throw new UnsupportedOperationException("BottomNavigationBarThemeData_readBack_showSelectedLabels read-back requires FFM/java22");
  }
  default boolean BottomNavigationBarThemeData_readBack_showUnselectedLabels(Object st) {
    throw new UnsupportedOperationException("BottomNavigationBarThemeData_readBack_showUnselectedLabels read-back requires FFM/java22");
  }
  default BottomNavigationBarType BottomNavigationBarThemeData_readBack_type(Object st) {
    throw new UnsupportedOperationException("BottomNavigationBarThemeData_readBack_type read-back requires FFM/java22");
  }
  default boolean BottomNavigationBarThemeData_readBack_enableFeedback(Object st) {
    throw new UnsupportedOperationException("BottomNavigationBarThemeData_readBack_enableFeedback read-back requires FFM/java22");
  }
  default BottomNavigationBarLandscapeLayout BottomNavigationBarThemeData_readBack_landscapeLayout(Object st) {
    throw new UnsupportedOperationException("BottomNavigationBarThemeData_readBack_landscapeLayout read-back requires FFM/java22");
  }

  default int bottomSheetThemeDataBottomSheetThemeData(Optional<Color> backgroundColor, Optional<Color> surfaceTintColor, OptionalDouble elevation, Optional<Color> modalBackgroundColor, Optional<Color> modalBarrierColor, Optional<Color> shadowColor, OptionalDouble modalElevation, Optional<ShapeBorder> shape, Optional<Boolean> showDragHandle, Optional<Color> dragHandleColor, Optional<Clip> clipBehavior, Optional<BoxConstraints> constraints) {
    throw new UnsupportedOperationException("bottomSheetThemeDataBottomSheetThemeData has no default (FFM/comm impl required)");
  }
  default int bottomSheetThemeDataLerp(BottomSheetThemeData a, BottomSheetThemeData b, double t) {
    throw new UnsupportedOperationException("bottomSheetThemeDataLerp has no default (FFM/comm impl required)");
  }
  default Color BottomSheetThemeData_readBack_backgroundColor(Object st) {
    throw new UnsupportedOperationException("BottomSheetThemeData_readBack_backgroundColor read-back requires FFM/java22");
  }
  default Color BottomSheetThemeData_readBack_surfaceTintColor(Object st) {
    throw new UnsupportedOperationException("BottomSheetThemeData_readBack_surfaceTintColor read-back requires FFM/java22");
  }
  default double BottomSheetThemeData_readBack_elevation(Object st) {
    throw new UnsupportedOperationException("BottomSheetThemeData_readBack_elevation read-back requires FFM/java22");
  }
  default Color BottomSheetThemeData_readBack_modalBackgroundColor(Object st) {
    throw new UnsupportedOperationException("BottomSheetThemeData_readBack_modalBackgroundColor read-back requires FFM/java22");
  }
  default Color BottomSheetThemeData_readBack_modalBarrierColor(Object st) {
    throw new UnsupportedOperationException("BottomSheetThemeData_readBack_modalBarrierColor read-back requires FFM/java22");
  }
  default Color BottomSheetThemeData_readBack_shadowColor(Object st) {
    throw new UnsupportedOperationException("BottomSheetThemeData_readBack_shadowColor read-back requires FFM/java22");
  }
  default double BottomSheetThemeData_readBack_modalElevation(Object st) {
    throw new UnsupportedOperationException("BottomSheetThemeData_readBack_modalElevation read-back requires FFM/java22");
  }
  default ShapeBorder BottomSheetThemeData_readBack_shape(Object st) {
    throw new UnsupportedOperationException("BottomSheetThemeData_readBack_shape read-back requires FFM/java22");
  }
  default boolean BottomSheetThemeData_readBack_showDragHandle(Object st) {
    throw new UnsupportedOperationException("BottomSheetThemeData_readBack_showDragHandle read-back requires FFM/java22");
  }
  default Color BottomSheetThemeData_readBack_dragHandleColor(Object st) {
    throw new UnsupportedOperationException("BottomSheetThemeData_readBack_dragHandleColor read-back requires FFM/java22");
  }
  default Clip BottomSheetThemeData_readBack_clipBehavior(Object st) {
    throw new UnsupportedOperationException("BottomSheetThemeData_readBack_clipBehavior read-back requires FFM/java22");
  }
  default BoxConstraints BottomSheetThemeData_readBack_constraints(Object st) {
    throw new UnsupportedOperationException("BottomSheetThemeData_readBack_constraints read-back requires FFM/java22");
  }

  default int buttonThemeDataButtonThemeData(Optional<ButtonTextTheme> textTheme, OptionalDouble minWidth, OptionalDouble height, Optional<EdgeInsetsGeometry> padding, Optional<ShapeBorder> shape, Optional<ButtonBarLayoutBehavior> layoutBehavior, Optional<Boolean> alignedDropdown, Optional<Color> buttonColor, Optional<Color> disabledColor, Optional<Color> focusColor, Optional<Color> hoverColor, Optional<Color> highlightColor, Optional<Color> splashColor, Optional<ColorScheme> colorScheme, Optional<MaterialTapTargetSize> materialTapTargetSize) {
    throw new UnsupportedOperationException("buttonThemeDataButtonThemeData has no default (FFM/comm impl required)");
  }
  default double ButtonThemeData_readBack_minWidth(Object st) {
    throw new UnsupportedOperationException("ButtonThemeData_readBack_minWidth read-back requires FFM/java22");
  }
  default double ButtonThemeData_readBack_height(Object st) {
    throw new UnsupportedOperationException("ButtonThemeData_readBack_height read-back requires FFM/java22");
  }
  default ButtonTextTheme ButtonThemeData_readBack_textTheme(Object st) {
    throw new UnsupportedOperationException("ButtonThemeData_readBack_textTheme read-back requires FFM/java22");
  }
  default ButtonBarLayoutBehavior ButtonThemeData_readBack_layoutBehavior(Object st) {
    throw new UnsupportedOperationException("ButtonThemeData_readBack_layoutBehavior read-back requires FFM/java22");
  }
  default boolean ButtonThemeData_readBack_alignedDropdown(Object st) {
    throw new UnsupportedOperationException("ButtonThemeData_readBack_alignedDropdown read-back requires FFM/java22");
  }
  default ColorScheme ButtonThemeData_readBack_colorScheme(Object st) {
    throw new UnsupportedOperationException("ButtonThemeData_readBack_colorScheme read-back requires FFM/java22");
  }
  default BoxConstraints ButtonThemeData_readBack_constraints(Object st) {
    throw new UnsupportedOperationException("ButtonThemeData_readBack_constraints read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry ButtonThemeData_readBack_padding(Object st) {
    throw new UnsupportedOperationException("ButtonThemeData_readBack_padding read-back requires FFM/java22");
  }
  default ShapeBorder ButtonThemeData_readBack_shape(Object st) {
    throw new UnsupportedOperationException("ButtonThemeData_readBack_shape read-back requires FFM/java22");
  }

  default int cardThemeDataCardThemeData(Optional<Clip> clipBehavior, Optional<Color> color, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, OptionalDouble elevation, Optional<EdgeInsetsGeometry> margin, Optional<ShapeBorder> shape) {
    throw new UnsupportedOperationException("cardThemeDataCardThemeData has no default (FFM/comm impl required)");
  }
  default int cardThemeDataLerp(CardThemeData a, CardThemeData b, double t) {
    throw new UnsupportedOperationException("cardThemeDataLerp has no default (FFM/comm impl required)");
  }
  default Clip CardThemeData_readBack_clipBehavior(Object st) {
    throw new UnsupportedOperationException("CardThemeData_readBack_clipBehavior read-back requires FFM/java22");
  }
  default Color CardThemeData_readBack_color(Object st) {
    throw new UnsupportedOperationException("CardThemeData_readBack_color read-back requires FFM/java22");
  }
  default Color CardThemeData_readBack_shadowColor(Object st) {
    throw new UnsupportedOperationException("CardThemeData_readBack_shadowColor read-back requires FFM/java22");
  }
  default Color CardThemeData_readBack_surfaceTintColor(Object st) {
    throw new UnsupportedOperationException("CardThemeData_readBack_surfaceTintColor read-back requires FFM/java22");
  }
  default double CardThemeData_readBack_elevation(Object st) {
    throw new UnsupportedOperationException("CardThemeData_readBack_elevation read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry CardThemeData_readBack_margin(Object st) {
    throw new UnsupportedOperationException("CardThemeData_readBack_margin read-back requires FFM/java22");
  }
  default ShapeBorder CardThemeData_readBack_shape(Object st) {
    throw new UnsupportedOperationException("CardThemeData_readBack_shape read-back requires FFM/java22");
  }

  default int carouselViewThemeDataCarouselViewThemeData(OptionalDouble elevation, Optional<Color> backgroundColor, Optional<Color> overlayColor, Optional<OutlinedBorder> shape, Optional<EdgeInsets> padding, Optional<Clip> itemClipBehavior) {
    throw new UnsupportedOperationException("carouselViewThemeDataCarouselViewThemeData has no default (FFM/comm impl required)");
  }
  default int carouselViewThemeDataLerp(CarouselViewThemeData a, CarouselViewThemeData b, double t) {
    throw new UnsupportedOperationException("carouselViewThemeDataLerp has no default (FFM/comm impl required)");
  }
  default EdgeInsets CarouselViewThemeData_readBack_padding(Object st) {
    throw new UnsupportedOperationException("CarouselViewThemeData_readBack_padding read-back requires FFM/java22");
  }
  default Color CarouselViewThemeData_readBack_backgroundColor(Object st) {
    throw new UnsupportedOperationException("CarouselViewThemeData_readBack_backgroundColor read-back requires FFM/java22");
  }
  default double CarouselViewThemeData_readBack_elevation(Object st) {
    throw new UnsupportedOperationException("CarouselViewThemeData_readBack_elevation read-back requires FFM/java22");
  }
  default OutlinedBorder CarouselViewThemeData_readBack_shape(Object st) {
    throw new UnsupportedOperationException("CarouselViewThemeData_readBack_shape read-back requires FFM/java22");
  }
  default Clip CarouselViewThemeData_readBack_itemClipBehavior(Object st) {
    throw new UnsupportedOperationException("CarouselViewThemeData_readBack_itemClipBehavior read-back requires FFM/java22");
  }

  default int checkboxThemeDataCheckboxThemeData(Optional<Color> fillColor, Optional<Color> checkColor, Optional<Color> overlayColor, OptionalDouble splashRadius, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<VisualDensity> visualDensity, Optional<OutlinedBorder> shape, Optional<BorderSide> side) {
    throw new UnsupportedOperationException("checkboxThemeDataCheckboxThemeData has no default (FFM/comm impl required)");
  }
  default int checkboxThemeDataLerp(CheckboxThemeData a, CheckboxThemeData b, double t) {
    throw new UnsupportedOperationException("checkboxThemeDataLerp has no default (FFM/comm impl required)");
  }
  default double CheckboxThemeData_readBack_splashRadius(Object st) {
    throw new UnsupportedOperationException("CheckboxThemeData_readBack_splashRadius read-back requires FFM/java22");
  }
  default MaterialTapTargetSize CheckboxThemeData_readBack_materialTapTargetSize(Object st) {
    throw new UnsupportedOperationException("CheckboxThemeData_readBack_materialTapTargetSize read-back requires FFM/java22");
  }
  default VisualDensity CheckboxThemeData_readBack_visualDensity(Object st) {
    throw new UnsupportedOperationException("CheckboxThemeData_readBack_visualDensity read-back requires FFM/java22");
  }
  default OutlinedBorder CheckboxThemeData_readBack_shape(Object st) {
    throw new UnsupportedOperationException("CheckboxThemeData_readBack_shape read-back requires FFM/java22");
  }
  default BorderSide CheckboxThemeData_readBack_side(Object st) {
    throw new UnsupportedOperationException("CheckboxThemeData_readBack_side read-back requires FFM/java22");
  }

  default int chipThemeDataChipThemeData(Optional<Color> color, Optional<Color> backgroundColor, Optional<Color> deleteIconColor, Optional<Color> disabledColor, Optional<Color> selectedColor, Optional<Color> secondarySelectedColor, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, Optional<Color> selectedShadowColor, Optional<Boolean> showCheckmark, Optional<Color> checkmarkColor, Optional<EdgeInsetsGeometry> labelPadding, Optional<EdgeInsetsGeometry> padding, Optional<BorderSide> side, Optional<OutlinedBorder> shape, Optional<TextStyle> labelStyle, Optional<TextStyle> secondaryLabelStyle, Optional<Brightness> brightness, OptionalDouble elevation, OptionalDouble pressElevation, Optional<IconThemeData> iconTheme, Optional<BoxConstraints> avatarBoxConstraints, Optional<BoxConstraints> deleteIconBoxConstraints) {
    throw new UnsupportedOperationException("chipThemeDataChipThemeData has no default (FFM/comm impl required)");
  }
  default int chipThemeDataFromDefaults(Optional<Brightness> brightness, Optional<Color> primaryColor, Color secondaryColor, TextStyle labelStyle) {
    throw new UnsupportedOperationException("chipThemeDataFromDefaults has no default (FFM/comm impl required)");
  }
  default int chipThemeDataLerp(ChipThemeData a, ChipThemeData b, double t) {
    throw new UnsupportedOperationException("chipThemeDataLerp has no default (FFM/comm impl required)");
  }
  default Color ChipThemeData_readBack_backgroundColor(Object st) {
    throw new UnsupportedOperationException("ChipThemeData_readBack_backgroundColor read-back requires FFM/java22");
  }
  default Color ChipThemeData_readBack_deleteIconColor(Object st) {
    throw new UnsupportedOperationException("ChipThemeData_readBack_deleteIconColor read-back requires FFM/java22");
  }
  default Color ChipThemeData_readBack_disabledColor(Object st) {
    throw new UnsupportedOperationException("ChipThemeData_readBack_disabledColor read-back requires FFM/java22");
  }
  default Color ChipThemeData_readBack_selectedColor(Object st) {
    throw new UnsupportedOperationException("ChipThemeData_readBack_selectedColor read-back requires FFM/java22");
  }
  default Color ChipThemeData_readBack_secondarySelectedColor(Object st) {
    throw new UnsupportedOperationException("ChipThemeData_readBack_secondarySelectedColor read-back requires FFM/java22");
  }
  default Color ChipThemeData_readBack_shadowColor(Object st) {
    throw new UnsupportedOperationException("ChipThemeData_readBack_shadowColor read-back requires FFM/java22");
  }
  default Color ChipThemeData_readBack_surfaceTintColor(Object st) {
    throw new UnsupportedOperationException("ChipThemeData_readBack_surfaceTintColor read-back requires FFM/java22");
  }
  default Color ChipThemeData_readBack_selectedShadowColor(Object st) {
    throw new UnsupportedOperationException("ChipThemeData_readBack_selectedShadowColor read-back requires FFM/java22");
  }
  default boolean ChipThemeData_readBack_showCheckmark(Object st) {
    throw new UnsupportedOperationException("ChipThemeData_readBack_showCheckmark read-back requires FFM/java22");
  }
  default Color ChipThemeData_readBack_checkmarkColor(Object st) {
    throw new UnsupportedOperationException("ChipThemeData_readBack_checkmarkColor read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry ChipThemeData_readBack_labelPadding(Object st) {
    throw new UnsupportedOperationException("ChipThemeData_readBack_labelPadding read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry ChipThemeData_readBack_padding(Object st) {
    throw new UnsupportedOperationException("ChipThemeData_readBack_padding read-back requires FFM/java22");
  }
  default BorderSide ChipThemeData_readBack_side(Object st) {
    throw new UnsupportedOperationException("ChipThemeData_readBack_side read-back requires FFM/java22");
  }
  default OutlinedBorder ChipThemeData_readBack_shape(Object st) {
    throw new UnsupportedOperationException("ChipThemeData_readBack_shape read-back requires FFM/java22");
  }
  default TextStyle ChipThemeData_readBack_labelStyle(Object st) {
    throw new UnsupportedOperationException("ChipThemeData_readBack_labelStyle read-back requires FFM/java22");
  }
  default TextStyle ChipThemeData_readBack_secondaryLabelStyle(Object st) {
    throw new UnsupportedOperationException("ChipThemeData_readBack_secondaryLabelStyle read-back requires FFM/java22");
  }
  default Brightness ChipThemeData_readBack_brightness(Object st) {
    throw new UnsupportedOperationException("ChipThemeData_readBack_brightness read-back requires FFM/java22");
  }
  default double ChipThemeData_readBack_elevation(Object st) {
    throw new UnsupportedOperationException("ChipThemeData_readBack_elevation read-back requires FFM/java22");
  }
  default double ChipThemeData_readBack_pressElevation(Object st) {
    throw new UnsupportedOperationException("ChipThemeData_readBack_pressElevation read-back requires FFM/java22");
  }
  default IconThemeData ChipThemeData_readBack_iconTheme(Object st) {
    throw new UnsupportedOperationException("ChipThemeData_readBack_iconTheme read-back requires FFM/java22");
  }
  default BoxConstraints ChipThemeData_readBack_avatarBoxConstraints(Object st) {
    throw new UnsupportedOperationException("ChipThemeData_readBack_avatarBoxConstraints read-back requires FFM/java22");
  }
  default BoxConstraints ChipThemeData_readBack_deleteIconBoxConstraints(Object st) {
    throw new UnsupportedOperationException("ChipThemeData_readBack_deleteIconBoxConstraints read-back requires FFM/java22");
  }

  default int dataTableThemeDataDataTableThemeData(Optional<Decoration> decoration, Optional<Color> dataRowColor, OptionalDouble dataRowHeight, OptionalDouble dataRowMinHeight, OptionalDouble dataRowMaxHeight, Optional<TextStyle> dataTextStyle, Optional<Color> headingRowColor, OptionalDouble headingRowHeight, Optional<TextStyle> headingTextStyle, OptionalDouble horizontalMargin, OptionalDouble columnSpacing, OptionalDouble dividerThickness, OptionalDouble checkboxHorizontalMargin, Optional<MainAxisAlignment> headingRowAlignment) {
    throw new UnsupportedOperationException("dataTableThemeDataDataTableThemeData has no default (FFM/comm impl required)");
  }
  default int dataTableThemeDataLerp(DataTableThemeData a, DataTableThemeData b, double t) {
    throw new UnsupportedOperationException("dataTableThemeDataLerp has no default (FFM/comm impl required)");
  }
  default Decoration DataTableThemeData_readBack_decoration(Object st) {
    throw new UnsupportedOperationException("DataTableThemeData_readBack_decoration read-back requires FFM/java22");
  }
  default double DataTableThemeData_readBack_dataRowMinHeight(Object st) {
    throw new UnsupportedOperationException("DataTableThemeData_readBack_dataRowMinHeight read-back requires FFM/java22");
  }
  default double DataTableThemeData_readBack_dataRowMaxHeight(Object st) {
    throw new UnsupportedOperationException("DataTableThemeData_readBack_dataRowMaxHeight read-back requires FFM/java22");
  }
  default TextStyle DataTableThemeData_readBack_dataTextStyle(Object st) {
    throw new UnsupportedOperationException("DataTableThemeData_readBack_dataTextStyle read-back requires FFM/java22");
  }
  default double DataTableThemeData_readBack_headingRowHeight(Object st) {
    throw new UnsupportedOperationException("DataTableThemeData_readBack_headingRowHeight read-back requires FFM/java22");
  }
  default TextStyle DataTableThemeData_readBack_headingTextStyle(Object st) {
    throw new UnsupportedOperationException("DataTableThemeData_readBack_headingTextStyle read-back requires FFM/java22");
  }
  default double DataTableThemeData_readBack_horizontalMargin(Object st) {
    throw new UnsupportedOperationException("DataTableThemeData_readBack_horizontalMargin read-back requires FFM/java22");
  }
  default double DataTableThemeData_readBack_columnSpacing(Object st) {
    throw new UnsupportedOperationException("DataTableThemeData_readBack_columnSpacing read-back requires FFM/java22");
  }
  default double DataTableThemeData_readBack_dividerThickness(Object st) {
    throw new UnsupportedOperationException("DataTableThemeData_readBack_dividerThickness read-back requires FFM/java22");
  }
  default double DataTableThemeData_readBack_checkboxHorizontalMargin(Object st) {
    throw new UnsupportedOperationException("DataTableThemeData_readBack_checkboxHorizontalMargin read-back requires FFM/java22");
  }
  default MainAxisAlignment DataTableThemeData_readBack_headingRowAlignment(Object st) {
    throw new UnsupportedOperationException("DataTableThemeData_readBack_headingRowAlignment read-back requires FFM/java22");
  }
  default double DataTableThemeData_readBack_dataRowHeight(Object st) {
    throw new UnsupportedOperationException("DataTableThemeData_readBack_dataRowHeight read-back requires FFM/java22");
  }

  default int datePickerThemeDataDatePickerThemeData(Optional<Color> backgroundColor, OptionalDouble elevation, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, Optional<ShapeBorder> shape, Optional<Color> headerBackgroundColor, Optional<Color> headerForegroundColor, Optional<TextStyle> headerHeadlineStyle, Optional<TextStyle> headerHelpStyle, Optional<TextStyle> weekdayStyle, Optional<TextStyle> dayStyle, Optional<Color> dayForegroundColor, Optional<Color> dayBackgroundColor, Optional<Color> dayOverlayColor, Optional<OutlinedBorder> dayShape, Optional<Color> todayForegroundColor, Optional<Color> todayBackgroundColor, Optional<BorderSide> todayBorder, Optional<TextStyle> yearStyle, Optional<Color> yearForegroundColor, Optional<Color> yearBackgroundColor, Optional<Color> yearOverlayColor, Optional<OutlinedBorder> yearShape, Optional<Color> rangePickerBackgroundColor, OptionalDouble rangePickerElevation, Optional<Color> rangePickerShadowColor, Optional<Color> rangePickerSurfaceTintColor, Optional<ShapeBorder> rangePickerShape, Optional<Color> rangePickerHeaderBackgroundColor, Optional<Color> rangePickerHeaderForegroundColor, Optional<TextStyle> rangePickerHeaderHeadlineStyle, Optional<TextStyle> rangePickerHeaderHelpStyle, Optional<Color> rangeSelectionBackgroundColor, Optional<Color> rangeSelectionOverlayColor, Optional<Color> dividerColor, Optional<NativeObj> inputDecorationTheme, Optional<TextStyle> toggleButtonTextStyle, Optional<Color> subHeaderForegroundColor) {
    throw new UnsupportedOperationException("datePickerThemeDataDatePickerThemeData has no default (FFM/comm impl required)");
  }
  default int datePickerThemeDataLerp(DatePickerThemeData a, DatePickerThemeData b, double t) {
    throw new UnsupportedOperationException("datePickerThemeDataLerp has no default (FFM/comm impl required)");
  }
  default Color DatePickerThemeData_readBack_backgroundColor(Object st) {
    throw new UnsupportedOperationException("DatePickerThemeData_readBack_backgroundColor read-back requires FFM/java22");
  }
  default double DatePickerThemeData_readBack_elevation(Object st) {
    throw new UnsupportedOperationException("DatePickerThemeData_readBack_elevation read-back requires FFM/java22");
  }
  default Color DatePickerThemeData_readBack_shadowColor(Object st) {
    throw new UnsupportedOperationException("DatePickerThemeData_readBack_shadowColor read-back requires FFM/java22");
  }
  default Color DatePickerThemeData_readBack_surfaceTintColor(Object st) {
    throw new UnsupportedOperationException("DatePickerThemeData_readBack_surfaceTintColor read-back requires FFM/java22");
  }
  default ShapeBorder DatePickerThemeData_readBack_shape(Object st) {
    throw new UnsupportedOperationException("DatePickerThemeData_readBack_shape read-back requires FFM/java22");
  }
  default Color DatePickerThemeData_readBack_headerBackgroundColor(Object st) {
    throw new UnsupportedOperationException("DatePickerThemeData_readBack_headerBackgroundColor read-back requires FFM/java22");
  }
  default Color DatePickerThemeData_readBack_headerForegroundColor(Object st) {
    throw new UnsupportedOperationException("DatePickerThemeData_readBack_headerForegroundColor read-back requires FFM/java22");
  }
  default TextStyle DatePickerThemeData_readBack_headerHeadlineStyle(Object st) {
    throw new UnsupportedOperationException("DatePickerThemeData_readBack_headerHeadlineStyle read-back requires FFM/java22");
  }
  default TextStyle DatePickerThemeData_readBack_headerHelpStyle(Object st) {
    throw new UnsupportedOperationException("DatePickerThemeData_readBack_headerHelpStyle read-back requires FFM/java22");
  }
  default TextStyle DatePickerThemeData_readBack_weekdayStyle(Object st) {
    throw new UnsupportedOperationException("DatePickerThemeData_readBack_weekdayStyle read-back requires FFM/java22");
  }
  default TextStyle DatePickerThemeData_readBack_dayStyle(Object st) {
    throw new UnsupportedOperationException("DatePickerThemeData_readBack_dayStyle read-back requires FFM/java22");
  }
  default BorderSide DatePickerThemeData_readBack_todayBorder(Object st) {
    throw new UnsupportedOperationException("DatePickerThemeData_readBack_todayBorder read-back requires FFM/java22");
  }
  default TextStyle DatePickerThemeData_readBack_yearStyle(Object st) {
    throw new UnsupportedOperationException("DatePickerThemeData_readBack_yearStyle read-back requires FFM/java22");
  }
  default Color DatePickerThemeData_readBack_rangePickerBackgroundColor(Object st) {
    throw new UnsupportedOperationException("DatePickerThemeData_readBack_rangePickerBackgroundColor read-back requires FFM/java22");
  }
  default double DatePickerThemeData_readBack_rangePickerElevation(Object st) {
    throw new UnsupportedOperationException("DatePickerThemeData_readBack_rangePickerElevation read-back requires FFM/java22");
  }
  default Color DatePickerThemeData_readBack_rangePickerShadowColor(Object st) {
    throw new UnsupportedOperationException("DatePickerThemeData_readBack_rangePickerShadowColor read-back requires FFM/java22");
  }
  default Color DatePickerThemeData_readBack_rangePickerSurfaceTintColor(Object st) {
    throw new UnsupportedOperationException("DatePickerThemeData_readBack_rangePickerSurfaceTintColor read-back requires FFM/java22");
  }
  default ShapeBorder DatePickerThemeData_readBack_rangePickerShape(Object st) {
    throw new UnsupportedOperationException("DatePickerThemeData_readBack_rangePickerShape read-back requires FFM/java22");
  }
  default Color DatePickerThemeData_readBack_rangePickerHeaderBackgroundColor(Object st) {
    throw new UnsupportedOperationException("DatePickerThemeData_readBack_rangePickerHeaderBackgroundColor read-back requires FFM/java22");
  }
  default Color DatePickerThemeData_readBack_rangePickerHeaderForegroundColor(Object st) {
    throw new UnsupportedOperationException("DatePickerThemeData_readBack_rangePickerHeaderForegroundColor read-back requires FFM/java22");
  }
  default TextStyle DatePickerThemeData_readBack_rangePickerHeaderHeadlineStyle(Object st) {
    throw new UnsupportedOperationException("DatePickerThemeData_readBack_rangePickerHeaderHeadlineStyle read-back requires FFM/java22");
  }
  default TextStyle DatePickerThemeData_readBack_rangePickerHeaderHelpStyle(Object st) {
    throw new UnsupportedOperationException("DatePickerThemeData_readBack_rangePickerHeaderHelpStyle read-back requires FFM/java22");
  }
  default Color DatePickerThemeData_readBack_rangeSelectionBackgroundColor(Object st) {
    throw new UnsupportedOperationException("DatePickerThemeData_readBack_rangeSelectionBackgroundColor read-back requires FFM/java22");
  }
  default Color DatePickerThemeData_readBack_dividerColor(Object st) {
    throw new UnsupportedOperationException("DatePickerThemeData_readBack_dividerColor read-back requires FFM/java22");
  }
  default TextStyle DatePickerThemeData_readBack_toggleButtonTextStyle(Object st) {
    throw new UnsupportedOperationException("DatePickerThemeData_readBack_toggleButtonTextStyle read-back requires FFM/java22");
  }
  default Color DatePickerThemeData_readBack_subHeaderForegroundColor(Object st) {
    throw new UnsupportedOperationException("DatePickerThemeData_readBack_subHeaderForegroundColor read-back requires FFM/java22");
  }

  default int dialogThemeDataDialogThemeData(Optional<Color> backgroundColor, OptionalDouble elevation, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, Optional<ShapeBorder> shape, Optional<AlignmentGeometry> alignment, Optional<Color> iconColor, Optional<TextStyle> titleTextStyle, Optional<TextStyle> contentTextStyle, Optional<EdgeInsetsGeometry> actionsPadding, Optional<Color> barrierColor, Optional<EdgeInsets> insetPadding, Optional<Clip> clipBehavior, Optional<BoxConstraints> constraints) {
    throw new UnsupportedOperationException("dialogThemeDataDialogThemeData has no default (FFM/comm impl required)");
  }
  default int dialogThemeDataLerp(DialogThemeData a, DialogThemeData b, double t) {
    throw new UnsupportedOperationException("dialogThemeDataLerp has no default (FFM/comm impl required)");
  }
  default Color DialogThemeData_readBack_backgroundColor(Object st) {
    throw new UnsupportedOperationException("DialogThemeData_readBack_backgroundColor read-back requires FFM/java22");
  }
  default double DialogThemeData_readBack_elevation(Object st) {
    throw new UnsupportedOperationException("DialogThemeData_readBack_elevation read-back requires FFM/java22");
  }
  default Color DialogThemeData_readBack_shadowColor(Object st) {
    throw new UnsupportedOperationException("DialogThemeData_readBack_shadowColor read-back requires FFM/java22");
  }
  default Color DialogThemeData_readBack_surfaceTintColor(Object st) {
    throw new UnsupportedOperationException("DialogThemeData_readBack_surfaceTintColor read-back requires FFM/java22");
  }
  default ShapeBorder DialogThemeData_readBack_shape(Object st) {
    throw new UnsupportedOperationException("DialogThemeData_readBack_shape read-back requires FFM/java22");
  }
  default AlignmentGeometry DialogThemeData_readBack_alignment(Object st) {
    throw new UnsupportedOperationException("DialogThemeData_readBack_alignment read-back requires FFM/java22");
  }
  default TextStyle DialogThemeData_readBack_titleTextStyle(Object st) {
    throw new UnsupportedOperationException("DialogThemeData_readBack_titleTextStyle read-back requires FFM/java22");
  }
  default TextStyle DialogThemeData_readBack_contentTextStyle(Object st) {
    throw new UnsupportedOperationException("DialogThemeData_readBack_contentTextStyle read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry DialogThemeData_readBack_actionsPadding(Object st) {
    throw new UnsupportedOperationException("DialogThemeData_readBack_actionsPadding read-back requires FFM/java22");
  }
  default Color DialogThemeData_readBack_iconColor(Object st) {
    throw new UnsupportedOperationException("DialogThemeData_readBack_iconColor read-back requires FFM/java22");
  }
  default Color DialogThemeData_readBack_barrierColor(Object st) {
    throw new UnsupportedOperationException("DialogThemeData_readBack_barrierColor read-back requires FFM/java22");
  }
  default EdgeInsets DialogThemeData_readBack_insetPadding(Object st) {
    throw new UnsupportedOperationException("DialogThemeData_readBack_insetPadding read-back requires FFM/java22");
  }
  default Clip DialogThemeData_readBack_clipBehavior(Object st) {
    throw new UnsupportedOperationException("DialogThemeData_readBack_clipBehavior read-back requires FFM/java22");
  }
  default BoxConstraints DialogThemeData_readBack_constraints(Object st) {
    throw new UnsupportedOperationException("DialogThemeData_readBack_constraints read-back requires FFM/java22");
  }

  default int dividerThemeDataDividerThemeData(Optional<Color> color, OptionalDouble space, OptionalDouble thickness, OptionalDouble indent, OptionalDouble endIndent, Optional<BorderRadiusGeometry> radius) {
    throw new UnsupportedOperationException("dividerThemeDataDividerThemeData has no default (FFM/comm impl required)");
  }
  default int dividerThemeDataLerp(DividerThemeData a, DividerThemeData b, double t) {
    throw new UnsupportedOperationException("dividerThemeDataLerp has no default (FFM/comm impl required)");
  }
  default Color DividerThemeData_readBack_color(Object st) {
    throw new UnsupportedOperationException("DividerThemeData_readBack_color read-back requires FFM/java22");
  }
  default double DividerThemeData_readBack_space(Object st) {
    throw new UnsupportedOperationException("DividerThemeData_readBack_space read-back requires FFM/java22");
  }
  default double DividerThemeData_readBack_thickness(Object st) {
    throw new UnsupportedOperationException("DividerThemeData_readBack_thickness read-back requires FFM/java22");
  }
  default double DividerThemeData_readBack_indent(Object st) {
    throw new UnsupportedOperationException("DividerThemeData_readBack_indent read-back requires FFM/java22");
  }
  default double DividerThemeData_readBack_endIndent(Object st) {
    throw new UnsupportedOperationException("DividerThemeData_readBack_endIndent read-back requires FFM/java22");
  }
  default BorderRadiusGeometry DividerThemeData_readBack_radius(Object st) {
    throw new UnsupportedOperationException("DividerThemeData_readBack_radius read-back requires FFM/java22");
  }

  default int drawerThemeDataDrawerThemeData(Optional<Color> backgroundColor, Optional<Color> scrimColor, OptionalDouble elevation, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, Optional<ShapeBorder> shape, Optional<ShapeBorder> endShape, OptionalDouble width, Optional<Clip> clipBehavior) {
    throw new UnsupportedOperationException("drawerThemeDataDrawerThemeData has no default (FFM/comm impl required)");
  }
  default int drawerThemeDataLerp(DrawerThemeData a, DrawerThemeData b, double t) {
    throw new UnsupportedOperationException("drawerThemeDataLerp has no default (FFM/comm impl required)");
  }
  default Color DrawerThemeData_readBack_backgroundColor(Object st) {
    throw new UnsupportedOperationException("DrawerThemeData_readBack_backgroundColor read-back requires FFM/java22");
  }
  default Color DrawerThemeData_readBack_scrimColor(Object st) {
    throw new UnsupportedOperationException("DrawerThemeData_readBack_scrimColor read-back requires FFM/java22");
  }
  default double DrawerThemeData_readBack_elevation(Object st) {
    throw new UnsupportedOperationException("DrawerThemeData_readBack_elevation read-back requires FFM/java22");
  }
  default Color DrawerThemeData_readBack_shadowColor(Object st) {
    throw new UnsupportedOperationException("DrawerThemeData_readBack_shadowColor read-back requires FFM/java22");
  }
  default Color DrawerThemeData_readBack_surfaceTintColor(Object st) {
    throw new UnsupportedOperationException("DrawerThemeData_readBack_surfaceTintColor read-back requires FFM/java22");
  }
  default ShapeBorder DrawerThemeData_readBack_shape(Object st) {
    throw new UnsupportedOperationException("DrawerThemeData_readBack_shape read-back requires FFM/java22");
  }
  default ShapeBorder DrawerThemeData_readBack_endShape(Object st) {
    throw new UnsupportedOperationException("DrawerThemeData_readBack_endShape read-back requires FFM/java22");
  }
  default double DrawerThemeData_readBack_width(Object st) {
    throw new UnsupportedOperationException("DrawerThemeData_readBack_width read-back requires FFM/java22");
  }
  default Clip DrawerThemeData_readBack_clipBehavior(Object st) {
    throw new UnsupportedOperationException("DrawerThemeData_readBack_clipBehavior read-back requires FFM/java22");
  }

  default int dropdownMenuThemeDataDropdownMenuThemeData(Optional<TextStyle> textStyle, Optional<NativeObj> inputDecorationTheme, Optional<Color> disabledColor) {
    throw new UnsupportedOperationException("dropdownMenuThemeDataDropdownMenuThemeData has no default (FFM/comm impl required)");
  }
  default int dropdownMenuThemeDataLerp(DropdownMenuThemeData a, DropdownMenuThemeData b, double t) {
    throw new UnsupportedOperationException("dropdownMenuThemeDataLerp has no default (FFM/comm impl required)");
  }
  default TextStyle DropdownMenuThemeData_readBack_textStyle(Object st) {
    throw new UnsupportedOperationException("DropdownMenuThemeData_readBack_textStyle read-back requires FFM/java22");
  }
  default Color DropdownMenuThemeData_readBack_disabledColor(Object st) {
    throw new UnsupportedOperationException("DropdownMenuThemeData_readBack_disabledColor read-back requires FFM/java22");
  }

  default int elevatedButtonThemeDataElevatedButtonThemeData() {
    throw new UnsupportedOperationException("elevatedButtonThemeDataElevatedButtonThemeData has no default (FFM/comm impl required)");
  }
  default int elevatedButtonThemeDataLerp(ElevatedButtonThemeData a, ElevatedButtonThemeData b, double t) {
    throw new UnsupportedOperationException("elevatedButtonThemeDataLerp has no default (FFM/comm impl required)");
  }

  default int expansionTileThemeDataExpansionTileThemeData(Optional<Color> backgroundColor, Optional<Color> collapsedBackgroundColor, Optional<EdgeInsetsGeometry> tilePadding, Optional<AlignmentGeometry> expandedAlignment, Optional<EdgeInsetsGeometry> childrenPadding, Optional<Color> iconColor, Optional<Color> collapsedIconColor, Optional<Color> textColor, Optional<Color> collapsedTextColor, Optional<ShapeBorder> shape, Optional<ShapeBorder> collapsedShape, Optional<Clip> clipBehavior) {
    throw new UnsupportedOperationException("expansionTileThemeDataExpansionTileThemeData has no default (FFM/comm impl required)");
  }
  default int expansionTileThemeDataLerp(ExpansionTileThemeData a, ExpansionTileThemeData b, double t) {
    throw new UnsupportedOperationException("expansionTileThemeDataLerp has no default (FFM/comm impl required)");
  }
  default Color ExpansionTileThemeData_readBack_backgroundColor(Object st) {
    throw new UnsupportedOperationException("ExpansionTileThemeData_readBack_backgroundColor read-back requires FFM/java22");
  }
  default Color ExpansionTileThemeData_readBack_collapsedBackgroundColor(Object st) {
    throw new UnsupportedOperationException("ExpansionTileThemeData_readBack_collapsedBackgroundColor read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry ExpansionTileThemeData_readBack_tilePadding(Object st) {
    throw new UnsupportedOperationException("ExpansionTileThemeData_readBack_tilePadding read-back requires FFM/java22");
  }
  default AlignmentGeometry ExpansionTileThemeData_readBack_expandedAlignment(Object st) {
    throw new UnsupportedOperationException("ExpansionTileThemeData_readBack_expandedAlignment read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry ExpansionTileThemeData_readBack_childrenPadding(Object st) {
    throw new UnsupportedOperationException("ExpansionTileThemeData_readBack_childrenPadding read-back requires FFM/java22");
  }
  default Color ExpansionTileThemeData_readBack_iconColor(Object st) {
    throw new UnsupportedOperationException("ExpansionTileThemeData_readBack_iconColor read-back requires FFM/java22");
  }
  default Color ExpansionTileThemeData_readBack_collapsedIconColor(Object st) {
    throw new UnsupportedOperationException("ExpansionTileThemeData_readBack_collapsedIconColor read-back requires FFM/java22");
  }
  default Color ExpansionTileThemeData_readBack_textColor(Object st) {
    throw new UnsupportedOperationException("ExpansionTileThemeData_readBack_textColor read-back requires FFM/java22");
  }
  default Color ExpansionTileThemeData_readBack_collapsedTextColor(Object st) {
    throw new UnsupportedOperationException("ExpansionTileThemeData_readBack_collapsedTextColor read-back requires FFM/java22");
  }
  default ShapeBorder ExpansionTileThemeData_readBack_shape(Object st) {
    throw new UnsupportedOperationException("ExpansionTileThemeData_readBack_shape read-back requires FFM/java22");
  }
  default ShapeBorder ExpansionTileThemeData_readBack_collapsedShape(Object st) {
    throw new UnsupportedOperationException("ExpansionTileThemeData_readBack_collapsedShape read-back requires FFM/java22");
  }
  default Clip ExpansionTileThemeData_readBack_clipBehavior(Object st) {
    throw new UnsupportedOperationException("ExpansionTileThemeData_readBack_clipBehavior read-back requires FFM/java22");
  }

  default int filledButtonThemeDataFilledButtonThemeData() {
    throw new UnsupportedOperationException("filledButtonThemeDataFilledButtonThemeData has no default (FFM/comm impl required)");
  }
  default int filledButtonThemeDataLerp(FilledButtonThemeData a, FilledButtonThemeData b, double t) {
    throw new UnsupportedOperationException("filledButtonThemeDataLerp has no default (FFM/comm impl required)");
  }

  default int floatingActionButtonThemeDataFloatingActionButtonThemeData(Optional<Color> foregroundColor, Optional<Color> backgroundColor, Optional<Color> focusColor, Optional<Color> hoverColor, Optional<Color> splashColor, OptionalDouble elevation, OptionalDouble focusElevation, OptionalDouble hoverElevation, OptionalDouble disabledElevation, OptionalDouble highlightElevation, Optional<ShapeBorder> shape, Optional<Boolean> enableFeedback, OptionalDouble iconSize, Optional<BoxConstraints> sizeConstraints, Optional<BoxConstraints> smallSizeConstraints, Optional<BoxConstraints> largeSizeConstraints, Optional<BoxConstraints> extendedSizeConstraints, OptionalDouble extendedIconLabelSpacing, Optional<EdgeInsetsGeometry> extendedPadding, Optional<TextStyle> extendedTextStyle) {
    throw new UnsupportedOperationException("floatingActionButtonThemeDataFloatingActionButtonThemeData has no default (FFM/comm impl required)");
  }
  default int floatingActionButtonThemeDataLerp(FloatingActionButtonThemeData a, FloatingActionButtonThemeData b, double t) {
    throw new UnsupportedOperationException("floatingActionButtonThemeDataLerp has no default (FFM/comm impl required)");
  }
  default Color FloatingActionButtonThemeData_readBack_foregroundColor(Object st) {
    throw new UnsupportedOperationException("FloatingActionButtonThemeData_readBack_foregroundColor read-back requires FFM/java22");
  }
  default Color FloatingActionButtonThemeData_readBack_backgroundColor(Object st) {
    throw new UnsupportedOperationException("FloatingActionButtonThemeData_readBack_backgroundColor read-back requires FFM/java22");
  }
  default Color FloatingActionButtonThemeData_readBack_focusColor(Object st) {
    throw new UnsupportedOperationException("FloatingActionButtonThemeData_readBack_focusColor read-back requires FFM/java22");
  }
  default Color FloatingActionButtonThemeData_readBack_hoverColor(Object st) {
    throw new UnsupportedOperationException("FloatingActionButtonThemeData_readBack_hoverColor read-back requires FFM/java22");
  }
  default Color FloatingActionButtonThemeData_readBack_splashColor(Object st) {
    throw new UnsupportedOperationException("FloatingActionButtonThemeData_readBack_splashColor read-back requires FFM/java22");
  }
  default double FloatingActionButtonThemeData_readBack_elevation(Object st) {
    throw new UnsupportedOperationException("FloatingActionButtonThemeData_readBack_elevation read-back requires FFM/java22");
  }
  default double FloatingActionButtonThemeData_readBack_focusElevation(Object st) {
    throw new UnsupportedOperationException("FloatingActionButtonThemeData_readBack_focusElevation read-back requires FFM/java22");
  }
  default double FloatingActionButtonThemeData_readBack_hoverElevation(Object st) {
    throw new UnsupportedOperationException("FloatingActionButtonThemeData_readBack_hoverElevation read-back requires FFM/java22");
  }
  default double FloatingActionButtonThemeData_readBack_disabledElevation(Object st) {
    throw new UnsupportedOperationException("FloatingActionButtonThemeData_readBack_disabledElevation read-back requires FFM/java22");
  }
  default double FloatingActionButtonThemeData_readBack_highlightElevation(Object st) {
    throw new UnsupportedOperationException("FloatingActionButtonThemeData_readBack_highlightElevation read-back requires FFM/java22");
  }
  default ShapeBorder FloatingActionButtonThemeData_readBack_shape(Object st) {
    throw new UnsupportedOperationException("FloatingActionButtonThemeData_readBack_shape read-back requires FFM/java22");
  }
  default boolean FloatingActionButtonThemeData_readBack_enableFeedback(Object st) {
    throw new UnsupportedOperationException("FloatingActionButtonThemeData_readBack_enableFeedback read-back requires FFM/java22");
  }
  default double FloatingActionButtonThemeData_readBack_iconSize(Object st) {
    throw new UnsupportedOperationException("FloatingActionButtonThemeData_readBack_iconSize read-back requires FFM/java22");
  }
  default BoxConstraints FloatingActionButtonThemeData_readBack_sizeConstraints(Object st) {
    throw new UnsupportedOperationException("FloatingActionButtonThemeData_readBack_sizeConstraints read-back requires FFM/java22");
  }
  default BoxConstraints FloatingActionButtonThemeData_readBack_smallSizeConstraints(Object st) {
    throw new UnsupportedOperationException("FloatingActionButtonThemeData_readBack_smallSizeConstraints read-back requires FFM/java22");
  }
  default BoxConstraints FloatingActionButtonThemeData_readBack_largeSizeConstraints(Object st) {
    throw new UnsupportedOperationException("FloatingActionButtonThemeData_readBack_largeSizeConstraints read-back requires FFM/java22");
  }
  default BoxConstraints FloatingActionButtonThemeData_readBack_extendedSizeConstraints(Object st) {
    throw new UnsupportedOperationException("FloatingActionButtonThemeData_readBack_extendedSizeConstraints read-back requires FFM/java22");
  }
  default double FloatingActionButtonThemeData_readBack_extendedIconLabelSpacing(Object st) {
    throw new UnsupportedOperationException("FloatingActionButtonThemeData_readBack_extendedIconLabelSpacing read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry FloatingActionButtonThemeData_readBack_extendedPadding(Object st) {
    throw new UnsupportedOperationException("FloatingActionButtonThemeData_readBack_extendedPadding read-back requires FFM/java22");
  }
  default TextStyle FloatingActionButtonThemeData_readBack_extendedTextStyle(Object st) {
    throw new UnsupportedOperationException("FloatingActionButtonThemeData_readBack_extendedTextStyle read-back requires FFM/java22");
  }

  default int iconButtonThemeDataIconButtonThemeData() {
    throw new UnsupportedOperationException("iconButtonThemeDataIconButtonThemeData has no default (FFM/comm impl required)");
  }
  default int iconButtonThemeDataLerp(IconButtonThemeData a, IconButtonThemeData b, double t) {
    throw new UnsupportedOperationException("iconButtonThemeDataLerp has no default (FFM/comm impl required)");
  }

  default int menuBarThemeDataMenuBarThemeData() {
    throw new UnsupportedOperationException("menuBarThemeDataMenuBarThemeData has no default (FFM/comm impl required)");
  }
  default int menuBarThemeDataLerp(MenuBarThemeData a, MenuBarThemeData b, double t) {
    throw new UnsupportedOperationException("menuBarThemeDataLerp has no default (FFM/comm impl required)");
  }

  default int menuButtonThemeDataMenuButtonThemeData() {
    throw new UnsupportedOperationException("menuButtonThemeDataMenuButtonThemeData has no default (FFM/comm impl required)");
  }
  default int menuButtonThemeDataLerp(MenuButtonThemeData a, MenuButtonThemeData b, double t) {
    throw new UnsupportedOperationException("menuButtonThemeDataLerp has no default (FFM/comm impl required)");
  }

  default int menuThemeDataMenuThemeData(Optional<Widget> submenuIcon) {
    throw new UnsupportedOperationException("menuThemeDataMenuThemeData has no default (FFM/comm impl required)");
  }
  default int menuThemeDataLerp(MenuThemeData a, MenuThemeData b, double t) {
    throw new UnsupportedOperationException("menuThemeDataLerp has no default (FFM/comm impl required)");
  }

  default int navigationBarThemeDataNavigationBarThemeData(OptionalDouble height, Optional<Color> backgroundColor, OptionalDouble elevation, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, Optional<Color> indicatorColor, Optional<ShapeBorder> indicatorShape, Optional<TextStyle> labelTextStyle, Optional<IconThemeData> iconTheme, Optional<NavigationDestinationLabelBehavior> labelBehavior, Optional<Color> overlayColor, Optional<EdgeInsetsGeometry> labelPadding) {
    throw new UnsupportedOperationException("navigationBarThemeDataNavigationBarThemeData has no default (FFM/comm impl required)");
  }
  default int navigationBarThemeDataLerp(NavigationBarThemeData a, NavigationBarThemeData b, double t) {
    throw new UnsupportedOperationException("navigationBarThemeDataLerp has no default (FFM/comm impl required)");
  }
  default double NavigationBarThemeData_readBack_height(Object st) {
    throw new UnsupportedOperationException("NavigationBarThemeData_readBack_height read-back requires FFM/java22");
  }
  default Color NavigationBarThemeData_readBack_backgroundColor(Object st) {
    throw new UnsupportedOperationException("NavigationBarThemeData_readBack_backgroundColor read-back requires FFM/java22");
  }
  default double NavigationBarThemeData_readBack_elevation(Object st) {
    throw new UnsupportedOperationException("NavigationBarThemeData_readBack_elevation read-back requires FFM/java22");
  }
  default Color NavigationBarThemeData_readBack_shadowColor(Object st) {
    throw new UnsupportedOperationException("NavigationBarThemeData_readBack_shadowColor read-back requires FFM/java22");
  }
  default Color NavigationBarThemeData_readBack_surfaceTintColor(Object st) {
    throw new UnsupportedOperationException("NavigationBarThemeData_readBack_surfaceTintColor read-back requires FFM/java22");
  }
  default Color NavigationBarThemeData_readBack_indicatorColor(Object st) {
    throw new UnsupportedOperationException("NavigationBarThemeData_readBack_indicatorColor read-back requires FFM/java22");
  }
  default ShapeBorder NavigationBarThemeData_readBack_indicatorShape(Object st) {
    throw new UnsupportedOperationException("NavigationBarThemeData_readBack_indicatorShape read-back requires FFM/java22");
  }
  default NavigationDestinationLabelBehavior NavigationBarThemeData_readBack_labelBehavior(Object st) {
    throw new UnsupportedOperationException("NavigationBarThemeData_readBack_labelBehavior read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry NavigationBarThemeData_readBack_labelPadding(Object st) {
    throw new UnsupportedOperationException("NavigationBarThemeData_readBack_labelPadding read-back requires FFM/java22");
  }

  default int navigationDrawerThemeDataNavigationDrawerThemeData(OptionalDouble tileHeight, Optional<Color> backgroundColor, OptionalDouble elevation, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, Optional<Color> indicatorColor, Optional<ShapeBorder> indicatorShape, Optional<TextStyle> labelTextStyle, Optional<IconThemeData> iconTheme) {
    throw new UnsupportedOperationException("navigationDrawerThemeDataNavigationDrawerThemeData has no default (FFM/comm impl required)");
  }
  default int navigationDrawerThemeDataLerp(NavigationDrawerThemeData a, NavigationDrawerThemeData b, double t) {
    throw new UnsupportedOperationException("navigationDrawerThemeDataLerp has no default (FFM/comm impl required)");
  }
  default double NavigationDrawerThemeData_readBack_tileHeight(Object st) {
    throw new UnsupportedOperationException("NavigationDrawerThemeData_readBack_tileHeight read-back requires FFM/java22");
  }
  default Color NavigationDrawerThemeData_readBack_backgroundColor(Object st) {
    throw new UnsupportedOperationException("NavigationDrawerThemeData_readBack_backgroundColor read-back requires FFM/java22");
  }
  default double NavigationDrawerThemeData_readBack_elevation(Object st) {
    throw new UnsupportedOperationException("NavigationDrawerThemeData_readBack_elevation read-back requires FFM/java22");
  }
  default Color NavigationDrawerThemeData_readBack_shadowColor(Object st) {
    throw new UnsupportedOperationException("NavigationDrawerThemeData_readBack_shadowColor read-back requires FFM/java22");
  }
  default Color NavigationDrawerThemeData_readBack_surfaceTintColor(Object st) {
    throw new UnsupportedOperationException("NavigationDrawerThemeData_readBack_surfaceTintColor read-back requires FFM/java22");
  }
  default Color NavigationDrawerThemeData_readBack_indicatorColor(Object st) {
    throw new UnsupportedOperationException("NavigationDrawerThemeData_readBack_indicatorColor read-back requires FFM/java22");
  }
  default ShapeBorder NavigationDrawerThemeData_readBack_indicatorShape(Object st) {
    throw new UnsupportedOperationException("NavigationDrawerThemeData_readBack_indicatorShape read-back requires FFM/java22");
  }

  default int navigationRailThemeDataNavigationRailThemeData(Optional<Color> backgroundColor, OptionalDouble elevation, Optional<TextStyle> unselectedLabelTextStyle, Optional<TextStyle> selectedLabelTextStyle, Optional<IconThemeData> unselectedIconTheme, Optional<IconThemeData> selectedIconTheme, OptionalDouble groupAlignment, Optional<NavigationRailLabelType> labelType, Optional<Boolean> useIndicator, Optional<Color> indicatorColor, Optional<ShapeBorder> indicatorShape, OptionalDouble minWidth, OptionalDouble minExtendedWidth) {
    throw new UnsupportedOperationException("navigationRailThemeDataNavigationRailThemeData has no default (FFM/comm impl required)");
  }
  default int navigationRailThemeDataLerp(NavigationRailThemeData a, NavigationRailThemeData b, double t) {
    throw new UnsupportedOperationException("navigationRailThemeDataLerp has no default (FFM/comm impl required)");
  }
  default Color NavigationRailThemeData_readBack_backgroundColor(Object st) {
    throw new UnsupportedOperationException("NavigationRailThemeData_readBack_backgroundColor read-back requires FFM/java22");
  }
  default double NavigationRailThemeData_readBack_elevation(Object st) {
    throw new UnsupportedOperationException("NavigationRailThemeData_readBack_elevation read-back requires FFM/java22");
  }
  default TextStyle NavigationRailThemeData_readBack_unselectedLabelTextStyle(Object st) {
    throw new UnsupportedOperationException("NavigationRailThemeData_readBack_unselectedLabelTextStyle read-back requires FFM/java22");
  }
  default TextStyle NavigationRailThemeData_readBack_selectedLabelTextStyle(Object st) {
    throw new UnsupportedOperationException("NavigationRailThemeData_readBack_selectedLabelTextStyle read-back requires FFM/java22");
  }
  default IconThemeData NavigationRailThemeData_readBack_unselectedIconTheme(Object st) {
    throw new UnsupportedOperationException("NavigationRailThemeData_readBack_unselectedIconTheme read-back requires FFM/java22");
  }
  default IconThemeData NavigationRailThemeData_readBack_selectedIconTheme(Object st) {
    throw new UnsupportedOperationException("NavigationRailThemeData_readBack_selectedIconTheme read-back requires FFM/java22");
  }
  default double NavigationRailThemeData_readBack_groupAlignment(Object st) {
    throw new UnsupportedOperationException("NavigationRailThemeData_readBack_groupAlignment read-back requires FFM/java22");
  }
  default NavigationRailLabelType NavigationRailThemeData_readBack_labelType(Object st) {
    throw new UnsupportedOperationException("NavigationRailThemeData_readBack_labelType read-back requires FFM/java22");
  }
  default boolean NavigationRailThemeData_readBack_useIndicator(Object st) {
    throw new UnsupportedOperationException("NavigationRailThemeData_readBack_useIndicator read-back requires FFM/java22");
  }
  default Color NavigationRailThemeData_readBack_indicatorColor(Object st) {
    throw new UnsupportedOperationException("NavigationRailThemeData_readBack_indicatorColor read-back requires FFM/java22");
  }
  default ShapeBorder NavigationRailThemeData_readBack_indicatorShape(Object st) {
    throw new UnsupportedOperationException("NavigationRailThemeData_readBack_indicatorShape read-back requires FFM/java22");
  }
  default double NavigationRailThemeData_readBack_minWidth(Object st) {
    throw new UnsupportedOperationException("NavigationRailThemeData_readBack_minWidth read-back requires FFM/java22");
  }
  default double NavigationRailThemeData_readBack_minExtendedWidth(Object st) {
    throw new UnsupportedOperationException("NavigationRailThemeData_readBack_minExtendedWidth read-back requires FFM/java22");
  }

  default int outlinedButtonThemeDataOutlinedButtonThemeData() {
    throw new UnsupportedOperationException("outlinedButtonThemeDataOutlinedButtonThemeData has no default (FFM/comm impl required)");
  }
  default int outlinedButtonThemeDataLerp(OutlinedButtonThemeData a, OutlinedButtonThemeData b, double t) {
    throw new UnsupportedOperationException("outlinedButtonThemeDataLerp has no default (FFM/comm impl required)");
  }

  default int popupMenuThemeDataPopupMenuThemeData(Optional<Color> color, Optional<ShapeBorder> shape, Optional<EdgeInsetsGeometry> menuPadding, OptionalDouble elevation, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, Optional<TextStyle> textStyle, Optional<TextStyle> labelTextStyle, Optional<Boolean> enableFeedback, Optional<PopupMenuPosition> position, Optional<Color> iconColor, OptionalDouble iconSize) {
    throw new UnsupportedOperationException("popupMenuThemeDataPopupMenuThemeData has no default (FFM/comm impl required)");
  }
  default int popupMenuThemeDataLerp(PopupMenuThemeData a, PopupMenuThemeData b, double t) {
    throw new UnsupportedOperationException("popupMenuThemeDataLerp has no default (FFM/comm impl required)");
  }
  default Color PopupMenuThemeData_readBack_color(Object st) {
    throw new UnsupportedOperationException("PopupMenuThemeData_readBack_color read-back requires FFM/java22");
  }
  default ShapeBorder PopupMenuThemeData_readBack_shape(Object st) {
    throw new UnsupportedOperationException("PopupMenuThemeData_readBack_shape read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry PopupMenuThemeData_readBack_menuPadding(Object st) {
    throw new UnsupportedOperationException("PopupMenuThemeData_readBack_menuPadding read-back requires FFM/java22");
  }
  default double PopupMenuThemeData_readBack_elevation(Object st) {
    throw new UnsupportedOperationException("PopupMenuThemeData_readBack_elevation read-back requires FFM/java22");
  }
  default Color PopupMenuThemeData_readBack_shadowColor(Object st) {
    throw new UnsupportedOperationException("PopupMenuThemeData_readBack_shadowColor read-back requires FFM/java22");
  }
  default Color PopupMenuThemeData_readBack_surfaceTintColor(Object st) {
    throw new UnsupportedOperationException("PopupMenuThemeData_readBack_surfaceTintColor read-back requires FFM/java22");
  }
  default TextStyle PopupMenuThemeData_readBack_textStyle(Object st) {
    throw new UnsupportedOperationException("PopupMenuThemeData_readBack_textStyle read-back requires FFM/java22");
  }
  default boolean PopupMenuThemeData_readBack_enableFeedback(Object st) {
    throw new UnsupportedOperationException("PopupMenuThemeData_readBack_enableFeedback read-back requires FFM/java22");
  }
  default PopupMenuPosition PopupMenuThemeData_readBack_position(Object st) {
    throw new UnsupportedOperationException("PopupMenuThemeData_readBack_position read-back requires FFM/java22");
  }
  default Color PopupMenuThemeData_readBack_iconColor(Object st) {
    throw new UnsupportedOperationException("PopupMenuThemeData_readBack_iconColor read-back requires FFM/java22");
  }
  default double PopupMenuThemeData_readBack_iconSize(Object st) {
    throw new UnsupportedOperationException("PopupMenuThemeData_readBack_iconSize read-back requires FFM/java22");
  }

  default int progressIndicatorThemeDataProgressIndicatorThemeData(Optional<Color> color, Optional<Color> linearTrackColor, OptionalDouble linearMinHeight, Optional<Color> circularTrackColor, Optional<Color> refreshBackgroundColor, Optional<BorderRadiusGeometry> borderRadius, Optional<Color> stopIndicatorColor, OptionalDouble stopIndicatorRadius, OptionalDouble strokeWidth, OptionalDouble strokeAlign, Optional<StrokeCap> strokeCap, Optional<BoxConstraints> constraints, OptionalDouble trackGap, Optional<EdgeInsetsGeometry> circularTrackPadding, Optional<Boolean> year2023, Optional<AnimationController> controller) {
    throw new UnsupportedOperationException("progressIndicatorThemeDataProgressIndicatorThemeData has no default (FFM/comm impl required)");
  }
  default int progressIndicatorThemeDataLerp(ProgressIndicatorThemeData a, ProgressIndicatorThemeData b, double t) {
    throw new UnsupportedOperationException("progressIndicatorThemeDataLerp has no default (FFM/comm impl required)");
  }
  default Color ProgressIndicatorThemeData_readBack_color(Object st) {
    throw new UnsupportedOperationException("ProgressIndicatorThemeData_readBack_color read-back requires FFM/java22");
  }
  default Color ProgressIndicatorThemeData_readBack_linearTrackColor(Object st) {
    throw new UnsupportedOperationException("ProgressIndicatorThemeData_readBack_linearTrackColor read-back requires FFM/java22");
  }
  default double ProgressIndicatorThemeData_readBack_linearMinHeight(Object st) {
    throw new UnsupportedOperationException("ProgressIndicatorThemeData_readBack_linearMinHeight read-back requires FFM/java22");
  }
  default Color ProgressIndicatorThemeData_readBack_circularTrackColor(Object st) {
    throw new UnsupportedOperationException("ProgressIndicatorThemeData_readBack_circularTrackColor read-back requires FFM/java22");
  }
  default Color ProgressIndicatorThemeData_readBack_refreshBackgroundColor(Object st) {
    throw new UnsupportedOperationException("ProgressIndicatorThemeData_readBack_refreshBackgroundColor read-back requires FFM/java22");
  }
  default BorderRadiusGeometry ProgressIndicatorThemeData_readBack_borderRadius(Object st) {
    throw new UnsupportedOperationException("ProgressIndicatorThemeData_readBack_borderRadius read-back requires FFM/java22");
  }
  default Color ProgressIndicatorThemeData_readBack_stopIndicatorColor(Object st) {
    throw new UnsupportedOperationException("ProgressIndicatorThemeData_readBack_stopIndicatorColor read-back requires FFM/java22");
  }
  default double ProgressIndicatorThemeData_readBack_stopIndicatorRadius(Object st) {
    throw new UnsupportedOperationException("ProgressIndicatorThemeData_readBack_stopIndicatorRadius read-back requires FFM/java22");
  }
  default double ProgressIndicatorThemeData_readBack_strokeWidth(Object st) {
    throw new UnsupportedOperationException("ProgressIndicatorThemeData_readBack_strokeWidth read-back requires FFM/java22");
  }
  default double ProgressIndicatorThemeData_readBack_strokeAlign(Object st) {
    throw new UnsupportedOperationException("ProgressIndicatorThemeData_readBack_strokeAlign read-back requires FFM/java22");
  }
  default StrokeCap ProgressIndicatorThemeData_readBack_strokeCap(Object st) {
    throw new UnsupportedOperationException("ProgressIndicatorThemeData_readBack_strokeCap read-back requires FFM/java22");
  }
  default BoxConstraints ProgressIndicatorThemeData_readBack_constraints(Object st) {
    throw new UnsupportedOperationException("ProgressIndicatorThemeData_readBack_constraints read-back requires FFM/java22");
  }
  default double ProgressIndicatorThemeData_readBack_trackGap(Object st) {
    throw new UnsupportedOperationException("ProgressIndicatorThemeData_readBack_trackGap read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry ProgressIndicatorThemeData_readBack_circularTrackPadding(Object st) {
    throw new UnsupportedOperationException("ProgressIndicatorThemeData_readBack_circularTrackPadding read-back requires FFM/java22");
  }
  default boolean ProgressIndicatorThemeData_readBack_year2023(Object st) {
    throw new UnsupportedOperationException("ProgressIndicatorThemeData_readBack_year2023 read-back requires FFM/java22");
  }
  default AnimationController ProgressIndicatorThemeData_readBack_controller(Object st) {
    throw new UnsupportedOperationException("ProgressIndicatorThemeData_readBack_controller read-back requires FFM/java22");
  }

  default int radioThemeDataRadioThemeData(Optional<Color> fillColor, Optional<Color> overlayColor, OptionalDouble splashRadius, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<VisualDensity> visualDensity, Optional<Color> backgroundColor, Optional<BorderSide> side, OptionalDouble innerRadius) {
    throw new UnsupportedOperationException("radioThemeDataRadioThemeData has no default (FFM/comm impl required)");
  }
  default int radioThemeDataLerp(RadioThemeData a, RadioThemeData b, double t) {
    throw new UnsupportedOperationException("radioThemeDataLerp has no default (FFM/comm impl required)");
  }
  default double RadioThemeData_readBack_splashRadius(Object st) {
    throw new UnsupportedOperationException("RadioThemeData_readBack_splashRadius read-back requires FFM/java22");
  }
  default MaterialTapTargetSize RadioThemeData_readBack_materialTapTargetSize(Object st) {
    throw new UnsupportedOperationException("RadioThemeData_readBack_materialTapTargetSize read-back requires FFM/java22");
  }
  default VisualDensity RadioThemeData_readBack_visualDensity(Object st) {
    throw new UnsupportedOperationException("RadioThemeData_readBack_visualDensity read-back requires FFM/java22");
  }
  default BorderSide RadioThemeData_readBack_side(Object st) {
    throw new UnsupportedOperationException("RadioThemeData_readBack_side read-back requires FFM/java22");
  }

  default int searchBarThemeDataSearchBarThemeData(OptionalDouble elevation, Optional<Color> backgroundColor, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, Optional<Color> overlayColor, Optional<BorderSide> side, Optional<OutlinedBorder> shape, Optional<EdgeInsetsGeometry> padding, Optional<TextStyle> textStyle, Optional<TextStyle> hintStyle, Optional<BoxConstraints> constraints, Optional<TextCapitalization> textCapitalization) {
    throw new UnsupportedOperationException("searchBarThemeDataSearchBarThemeData has no default (FFM/comm impl required)");
  }
  default int searchBarThemeDataLerp(SearchBarThemeData a, SearchBarThemeData b, double t) {
    throw new UnsupportedOperationException("searchBarThemeDataLerp has no default (FFM/comm impl required)");
  }
  default BoxConstraints SearchBarThemeData_readBack_constraints(Object st) {
    throw new UnsupportedOperationException("SearchBarThemeData_readBack_constraints read-back requires FFM/java22");
  }
  default TextCapitalization SearchBarThemeData_readBack_textCapitalization(Object st) {
    throw new UnsupportedOperationException("SearchBarThemeData_readBack_textCapitalization read-back requires FFM/java22");
  }

  default int searchViewThemeDataSearchViewThemeData(Optional<Color> backgroundColor, OptionalDouble elevation, Optional<Color> surfaceTintColor, Optional<BoxConstraints> constraints, Optional<EdgeInsetsGeometry> padding, Optional<EdgeInsetsGeometry> barPadding, Optional<Boolean> shrinkWrap, Optional<BorderSide> side, Optional<OutlinedBorder> shape, OptionalDouble headerHeight, Optional<TextStyle> headerTextStyle, Optional<TextStyle> headerHintStyle, Optional<Color> dividerColor) {
    throw new UnsupportedOperationException("searchViewThemeDataSearchViewThemeData has no default (FFM/comm impl required)");
  }
  default int searchViewThemeDataLerp(SearchViewThemeData a, SearchViewThemeData b, double t) {
    throw new UnsupportedOperationException("searchViewThemeDataLerp has no default (FFM/comm impl required)");
  }
  default Color SearchViewThemeData_readBack_backgroundColor(Object st) {
    throw new UnsupportedOperationException("SearchViewThemeData_readBack_backgroundColor read-back requires FFM/java22");
  }
  default double SearchViewThemeData_readBack_elevation(Object st) {
    throw new UnsupportedOperationException("SearchViewThemeData_readBack_elevation read-back requires FFM/java22");
  }
  default Color SearchViewThemeData_readBack_surfaceTintColor(Object st) {
    throw new UnsupportedOperationException("SearchViewThemeData_readBack_surfaceTintColor read-back requires FFM/java22");
  }
  default BorderSide SearchViewThemeData_readBack_side(Object st) {
    throw new UnsupportedOperationException("SearchViewThemeData_readBack_side read-back requires FFM/java22");
  }
  default OutlinedBorder SearchViewThemeData_readBack_shape(Object st) {
    throw new UnsupportedOperationException("SearchViewThemeData_readBack_shape read-back requires FFM/java22");
  }
  default double SearchViewThemeData_readBack_headerHeight(Object st) {
    throw new UnsupportedOperationException("SearchViewThemeData_readBack_headerHeight read-back requires FFM/java22");
  }
  default TextStyle SearchViewThemeData_readBack_headerTextStyle(Object st) {
    throw new UnsupportedOperationException("SearchViewThemeData_readBack_headerTextStyle read-back requires FFM/java22");
  }
  default TextStyle SearchViewThemeData_readBack_headerHintStyle(Object st) {
    throw new UnsupportedOperationException("SearchViewThemeData_readBack_headerHintStyle read-back requires FFM/java22");
  }
  default BoxConstraints SearchViewThemeData_readBack_constraints(Object st) {
    throw new UnsupportedOperationException("SearchViewThemeData_readBack_constraints read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry SearchViewThemeData_readBack_padding(Object st) {
    throw new UnsupportedOperationException("SearchViewThemeData_readBack_padding read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry SearchViewThemeData_readBack_barPadding(Object st) {
    throw new UnsupportedOperationException("SearchViewThemeData_readBack_barPadding read-back requires FFM/java22");
  }
  default boolean SearchViewThemeData_readBack_shrinkWrap(Object st) {
    throw new UnsupportedOperationException("SearchViewThemeData_readBack_shrinkWrap read-back requires FFM/java22");
  }
  default Color SearchViewThemeData_readBack_dividerColor(Object st) {
    throw new UnsupportedOperationException("SearchViewThemeData_readBack_dividerColor read-back requires FFM/java22");
  }

  default int segmentedButtonThemeDataSegmentedButtonThemeData(Optional<Widget> selectedIcon) {
    throw new UnsupportedOperationException("segmentedButtonThemeDataSegmentedButtonThemeData has no default (FFM/comm impl required)");
  }
  default int segmentedButtonThemeDataLerp(SegmentedButtonThemeData a, SegmentedButtonThemeData b, double t) {
    throw new UnsupportedOperationException("segmentedButtonThemeDataLerp has no default (FFM/comm impl required)");
  }
  default Widget SegmentedButtonThemeData_readBack_selectedIcon(Object st) {
    throw new UnsupportedOperationException("SegmentedButtonThemeData_readBack_selectedIcon read-back requires FFM/java22");
  }

  default int sliderThemeDataSliderThemeData(OptionalDouble trackHeight, Optional<Color> activeTrackColor, Optional<Color> inactiveTrackColor, Optional<Color> secondaryActiveTrackColor, Optional<Color> disabledActiveTrackColor, Optional<Color> disabledInactiveTrackColor, Optional<Color> disabledSecondaryActiveTrackColor, Optional<Color> activeTickMarkColor, Optional<Color> inactiveTickMarkColor, Optional<Color> disabledActiveTickMarkColor, Optional<Color> disabledInactiveTickMarkColor, Optional<Color> thumbColor, Optional<Color> overlappingShapeStrokeColor, Optional<Color> disabledThumbColor, Optional<Color> overlayColor, Optional<Color> valueIndicatorColor, Optional<Color> valueIndicatorStrokeColor, Optional<SliderComponentShape> overlayShape, Optional<SliderComponentShape> thumbShape, Optional<SliderComponentShape> valueIndicatorShape, Optional<ShowValueIndicator> showValueIndicator, Optional<TextStyle> valueIndicatorTextStyle, OptionalDouble minThumbSeparation, Optional<SliderInteraction> allowedInteraction, Optional<EdgeInsetsGeometry> padding, OptionalDouble trackGap, Optional<Boolean> year2023) {
    throw new UnsupportedOperationException("sliderThemeDataSliderThemeData has no default (FFM/comm impl required)");
  }
  default int sliderThemeDataFromPrimaryColors(Color primaryColor, Color primaryColorDark, Color primaryColorLight, TextStyle valueIndicatorTextStyle) {
    throw new UnsupportedOperationException("sliderThemeDataFromPrimaryColors has no default (FFM/comm impl required)");
  }
  default int sliderThemeDataLerp(SliderThemeData a, SliderThemeData b, double t) {
    throw new UnsupportedOperationException("sliderThemeDataLerp has no default (FFM/comm impl required)");
  }
  default double SliderThemeData_readBack_trackHeight(Object st) {
    throw new UnsupportedOperationException("SliderThemeData_readBack_trackHeight read-back requires FFM/java22");
  }
  default Color SliderThemeData_readBack_activeTrackColor(Object st) {
    throw new UnsupportedOperationException("SliderThemeData_readBack_activeTrackColor read-back requires FFM/java22");
  }
  default Color SliderThemeData_readBack_inactiveTrackColor(Object st) {
    throw new UnsupportedOperationException("SliderThemeData_readBack_inactiveTrackColor read-back requires FFM/java22");
  }
  default Color SliderThemeData_readBack_secondaryActiveTrackColor(Object st) {
    throw new UnsupportedOperationException("SliderThemeData_readBack_secondaryActiveTrackColor read-back requires FFM/java22");
  }
  default Color SliderThemeData_readBack_disabledActiveTrackColor(Object st) {
    throw new UnsupportedOperationException("SliderThemeData_readBack_disabledActiveTrackColor read-back requires FFM/java22");
  }
  default Color SliderThemeData_readBack_disabledSecondaryActiveTrackColor(Object st) {
    throw new UnsupportedOperationException("SliderThemeData_readBack_disabledSecondaryActiveTrackColor read-back requires FFM/java22");
  }
  default Color SliderThemeData_readBack_disabledInactiveTrackColor(Object st) {
    throw new UnsupportedOperationException("SliderThemeData_readBack_disabledInactiveTrackColor read-back requires FFM/java22");
  }
  default Color SliderThemeData_readBack_activeTickMarkColor(Object st) {
    throw new UnsupportedOperationException("SliderThemeData_readBack_activeTickMarkColor read-back requires FFM/java22");
  }
  default Color SliderThemeData_readBack_inactiveTickMarkColor(Object st) {
    throw new UnsupportedOperationException("SliderThemeData_readBack_inactiveTickMarkColor read-back requires FFM/java22");
  }
  default Color SliderThemeData_readBack_disabledActiveTickMarkColor(Object st) {
    throw new UnsupportedOperationException("SliderThemeData_readBack_disabledActiveTickMarkColor read-back requires FFM/java22");
  }
  default Color SliderThemeData_readBack_disabledInactiveTickMarkColor(Object st) {
    throw new UnsupportedOperationException("SliderThemeData_readBack_disabledInactiveTickMarkColor read-back requires FFM/java22");
  }
  default Color SliderThemeData_readBack_thumbColor(Object st) {
    throw new UnsupportedOperationException("SliderThemeData_readBack_thumbColor read-back requires FFM/java22");
  }
  default Color SliderThemeData_readBack_overlappingShapeStrokeColor(Object st) {
    throw new UnsupportedOperationException("SliderThemeData_readBack_overlappingShapeStrokeColor read-back requires FFM/java22");
  }
  default Color SliderThemeData_readBack_disabledThumbColor(Object st) {
    throw new UnsupportedOperationException("SliderThemeData_readBack_disabledThumbColor read-back requires FFM/java22");
  }
  default Color SliderThemeData_readBack_overlayColor(Object st) {
    throw new UnsupportedOperationException("SliderThemeData_readBack_overlayColor read-back requires FFM/java22");
  }
  default Color SliderThemeData_readBack_valueIndicatorColor(Object st) {
    throw new UnsupportedOperationException("SliderThemeData_readBack_valueIndicatorColor read-back requires FFM/java22");
  }
  default Color SliderThemeData_readBack_valueIndicatorStrokeColor(Object st) {
    throw new UnsupportedOperationException("SliderThemeData_readBack_valueIndicatorStrokeColor read-back requires FFM/java22");
  }
  default SliderComponentShape SliderThemeData_readBack_overlayShape(Object st) {
    throw new UnsupportedOperationException("SliderThemeData_readBack_overlayShape read-back requires FFM/java22");
  }
  default SliderComponentShape SliderThemeData_readBack_thumbShape(Object st) {
    throw new UnsupportedOperationException("SliderThemeData_readBack_thumbShape read-back requires FFM/java22");
  }
  default SliderComponentShape SliderThemeData_readBack_valueIndicatorShape(Object st) {
    throw new UnsupportedOperationException("SliderThemeData_readBack_valueIndicatorShape read-back requires FFM/java22");
  }
  default ShowValueIndicator SliderThemeData_readBack_showValueIndicator(Object st) {
    throw new UnsupportedOperationException("SliderThemeData_readBack_showValueIndicator read-back requires FFM/java22");
  }
  default TextStyle SliderThemeData_readBack_valueIndicatorTextStyle(Object st) {
    throw new UnsupportedOperationException("SliderThemeData_readBack_valueIndicatorTextStyle read-back requires FFM/java22");
  }
  default double SliderThemeData_readBack_minThumbSeparation(Object st) {
    throw new UnsupportedOperationException("SliderThemeData_readBack_minThumbSeparation read-back requires FFM/java22");
  }
  default SliderInteraction SliderThemeData_readBack_allowedInteraction(Object st) {
    throw new UnsupportedOperationException("SliderThemeData_readBack_allowedInteraction read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry SliderThemeData_readBack_padding(Object st) {
    throw new UnsupportedOperationException("SliderThemeData_readBack_padding read-back requires FFM/java22");
  }
  default double SliderThemeData_readBack_trackGap(Object st) {
    throw new UnsupportedOperationException("SliderThemeData_readBack_trackGap read-back requires FFM/java22");
  }
  default boolean SliderThemeData_readBack_year2023(Object st) {
    throw new UnsupportedOperationException("SliderThemeData_readBack_year2023 read-back requires FFM/java22");
  }

  default int snackBarThemeDataSnackBarThemeData(Optional<Color> backgroundColor, Optional<Color> actionTextColor, Optional<Color> disabledActionTextColor, Optional<TextStyle> contentTextStyle, OptionalDouble elevation, Optional<ShapeBorder> shape, Optional<SnackBarBehavior> behavior, OptionalDouble width, Optional<EdgeInsets> insetPadding, Optional<Boolean> showCloseIcon, Optional<Color> closeIconColor, OptionalDouble actionOverflowThreshold, Optional<Color> actionBackgroundColor, Optional<Color> disabledActionBackgroundColor, Optional<DismissDirection> dismissDirection) {
    throw new UnsupportedOperationException("snackBarThemeDataSnackBarThemeData has no default (FFM/comm impl required)");
  }
  default int snackBarThemeDataLerp(SnackBarThemeData a, SnackBarThemeData b, double t) {
    throw new UnsupportedOperationException("snackBarThemeDataLerp has no default (FFM/comm impl required)");
  }
  default Color SnackBarThemeData_readBack_backgroundColor(Object st) {
    throw new UnsupportedOperationException("SnackBarThemeData_readBack_backgroundColor read-back requires FFM/java22");
  }
  default Color SnackBarThemeData_readBack_actionTextColor(Object st) {
    throw new UnsupportedOperationException("SnackBarThemeData_readBack_actionTextColor read-back requires FFM/java22");
  }
  default Color SnackBarThemeData_readBack_disabledActionTextColor(Object st) {
    throw new UnsupportedOperationException("SnackBarThemeData_readBack_disabledActionTextColor read-back requires FFM/java22");
  }
  default TextStyle SnackBarThemeData_readBack_contentTextStyle(Object st) {
    throw new UnsupportedOperationException("SnackBarThemeData_readBack_contentTextStyle read-back requires FFM/java22");
  }
  default double SnackBarThemeData_readBack_elevation(Object st) {
    throw new UnsupportedOperationException("SnackBarThemeData_readBack_elevation read-back requires FFM/java22");
  }
  default ShapeBorder SnackBarThemeData_readBack_shape(Object st) {
    throw new UnsupportedOperationException("SnackBarThemeData_readBack_shape read-back requires FFM/java22");
  }
  default SnackBarBehavior SnackBarThemeData_readBack_behavior(Object st) {
    throw new UnsupportedOperationException("SnackBarThemeData_readBack_behavior read-back requires FFM/java22");
  }
  default double SnackBarThemeData_readBack_width(Object st) {
    throw new UnsupportedOperationException("SnackBarThemeData_readBack_width read-back requires FFM/java22");
  }
  default EdgeInsets SnackBarThemeData_readBack_insetPadding(Object st) {
    throw new UnsupportedOperationException("SnackBarThemeData_readBack_insetPadding read-back requires FFM/java22");
  }
  default boolean SnackBarThemeData_readBack_showCloseIcon(Object st) {
    throw new UnsupportedOperationException("SnackBarThemeData_readBack_showCloseIcon read-back requires FFM/java22");
  }
  default Color SnackBarThemeData_readBack_closeIconColor(Object st) {
    throw new UnsupportedOperationException("SnackBarThemeData_readBack_closeIconColor read-back requires FFM/java22");
  }
  default double SnackBarThemeData_readBack_actionOverflowThreshold(Object st) {
    throw new UnsupportedOperationException("SnackBarThemeData_readBack_actionOverflowThreshold read-back requires FFM/java22");
  }
  default Color SnackBarThemeData_readBack_actionBackgroundColor(Object st) {
    throw new UnsupportedOperationException("SnackBarThemeData_readBack_actionBackgroundColor read-back requires FFM/java22");
  }
  default Color SnackBarThemeData_readBack_disabledActionBackgroundColor(Object st) {
    throw new UnsupportedOperationException("SnackBarThemeData_readBack_disabledActionBackgroundColor read-back requires FFM/java22");
  }
  default DismissDirection SnackBarThemeData_readBack_dismissDirection(Object st) {
    throw new UnsupportedOperationException("SnackBarThemeData_readBack_dismissDirection read-back requires FFM/java22");
  }

  default int switchThemeDataSwitchThemeData(Optional<Color> thumbColor, Optional<Color> trackColor, Optional<Color> trackOutlineColor, OptionalDouble trackOutlineWidth, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<Color> overlayColor, OptionalDouble splashRadius, Optional<Icon> thumbIcon, Optional<EdgeInsetsGeometry> padding) {
    throw new UnsupportedOperationException("switchThemeDataSwitchThemeData has no default (FFM/comm impl required)");
  }
  default int switchThemeDataLerp(SwitchThemeData a, SwitchThemeData b, double t) {
    throw new UnsupportedOperationException("switchThemeDataLerp has no default (FFM/comm impl required)");
  }
  default MaterialTapTargetSize SwitchThemeData_readBack_materialTapTargetSize(Object st) {
    throw new UnsupportedOperationException("SwitchThemeData_readBack_materialTapTargetSize read-back requires FFM/java22");
  }
  default double SwitchThemeData_readBack_splashRadius(Object st) {
    throw new UnsupportedOperationException("SwitchThemeData_readBack_splashRadius read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry SwitchThemeData_readBack_padding(Object st) {
    throw new UnsupportedOperationException("SwitchThemeData_readBack_padding read-back requires FFM/java22");
  }

  default int tabBarThemeDataTabBarThemeData(Optional<Decoration> indicator, Optional<Color> indicatorColor, Optional<TabBarIndicatorSize> indicatorSize, Optional<Color> dividerColor, OptionalDouble dividerHeight, Optional<Color> labelColor, Optional<EdgeInsetsGeometry> labelPadding, Optional<TextStyle> labelStyle, Optional<Color> unselectedLabelColor, Optional<TextStyle> unselectedLabelStyle, Optional<Color> overlayColor, Optional<TabAlignment> tabAlignment, Optional<TabIndicatorAnimation> indicatorAnimation, Optional<BorderRadius> splashBorderRadius) {
    throw new UnsupportedOperationException("tabBarThemeDataTabBarThemeData has no default (FFM/comm impl required)");
  }
  default int tabBarThemeDataLerp(TabBarThemeData a, TabBarThemeData b, double t) {
    throw new UnsupportedOperationException("tabBarThemeDataLerp has no default (FFM/comm impl required)");
  }
  default Decoration TabBarThemeData_readBack_indicator(Object st) {
    throw new UnsupportedOperationException("TabBarThemeData_readBack_indicator read-back requires FFM/java22");
  }
  default Color TabBarThemeData_readBack_indicatorColor(Object st) {
    throw new UnsupportedOperationException("TabBarThemeData_readBack_indicatorColor read-back requires FFM/java22");
  }
  default TabBarIndicatorSize TabBarThemeData_readBack_indicatorSize(Object st) {
    throw new UnsupportedOperationException("TabBarThemeData_readBack_indicatorSize read-back requires FFM/java22");
  }
  default Color TabBarThemeData_readBack_dividerColor(Object st) {
    throw new UnsupportedOperationException("TabBarThemeData_readBack_dividerColor read-back requires FFM/java22");
  }
  default double TabBarThemeData_readBack_dividerHeight(Object st) {
    throw new UnsupportedOperationException("TabBarThemeData_readBack_dividerHeight read-back requires FFM/java22");
  }
  default Color TabBarThemeData_readBack_labelColor(Object st) {
    throw new UnsupportedOperationException("TabBarThemeData_readBack_labelColor read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry TabBarThemeData_readBack_labelPadding(Object st) {
    throw new UnsupportedOperationException("TabBarThemeData_readBack_labelPadding read-back requires FFM/java22");
  }
  default TextStyle TabBarThemeData_readBack_labelStyle(Object st) {
    throw new UnsupportedOperationException("TabBarThemeData_readBack_labelStyle read-back requires FFM/java22");
  }
  default Color TabBarThemeData_readBack_unselectedLabelColor(Object st) {
    throw new UnsupportedOperationException("TabBarThemeData_readBack_unselectedLabelColor read-back requires FFM/java22");
  }
  default TextStyle TabBarThemeData_readBack_unselectedLabelStyle(Object st) {
    throw new UnsupportedOperationException("TabBarThemeData_readBack_unselectedLabelStyle read-back requires FFM/java22");
  }
  default TabAlignment TabBarThemeData_readBack_tabAlignment(Object st) {
    throw new UnsupportedOperationException("TabBarThemeData_readBack_tabAlignment read-back requires FFM/java22");
  }
  default TabIndicatorAnimation TabBarThemeData_readBack_indicatorAnimation(Object st) {
    throw new UnsupportedOperationException("TabBarThemeData_readBack_indicatorAnimation read-back requires FFM/java22");
  }
  default BorderRadius TabBarThemeData_readBack_splashBorderRadius(Object st) {
    throw new UnsupportedOperationException("TabBarThemeData_readBack_splashBorderRadius read-back requires FFM/java22");
  }

  default int textButtonThemeDataTextButtonThemeData() {
    throw new UnsupportedOperationException("textButtonThemeDataTextButtonThemeData has no default (FFM/comm impl required)");
  }
  default int textButtonThemeDataLerp(TextButtonThemeData a, TextButtonThemeData b, double t) {
    throw new UnsupportedOperationException("textButtonThemeDataLerp has no default (FFM/comm impl required)");
  }

  default int textSelectionThemeDataTextSelectionThemeData(Optional<Color> cursorColor, Optional<Color> selectionColor, Optional<Color> selectionHandleColor) {
    throw new UnsupportedOperationException("textSelectionThemeDataTextSelectionThemeData has no default (FFM/comm impl required)");
  }
  default int textSelectionThemeDataLerp(TextSelectionThemeData a, TextSelectionThemeData b, double t) {
    throw new UnsupportedOperationException("textSelectionThemeDataLerp has no default (FFM/comm impl required)");
  }
  default Color TextSelectionThemeData_readBack_cursorColor(Object st) {
    throw new UnsupportedOperationException("TextSelectionThemeData_readBack_cursorColor read-back requires FFM/java22");
  }
  default Color TextSelectionThemeData_readBack_selectionColor(Object st) {
    throw new UnsupportedOperationException("TextSelectionThemeData_readBack_selectionColor read-back requires FFM/java22");
  }
  default Color TextSelectionThemeData_readBack_selectionHandleColor(Object st) {
    throw new UnsupportedOperationException("TextSelectionThemeData_readBack_selectionHandleColor read-back requires FFM/java22");
  }

  default int timePickerThemeDataTimePickerThemeData(Optional<Color> backgroundColor, Optional<BorderSide> dayPeriodBorderSide, Optional<Color> dayPeriodColor, Optional<OutlinedBorder> dayPeriodShape, Optional<Color> dayPeriodTextColor, Optional<TextStyle> dayPeriodTextStyle, Optional<Color> dialBackgroundColor, Optional<Color> dialHandColor, Optional<Color> dialTextColor, Optional<TextStyle> dialTextStyle, OptionalDouble elevation, Optional<Color> entryModeIconColor, Optional<TextStyle> helpTextStyle, Optional<Color> hourMinuteColor, Optional<ShapeBorder> hourMinuteShape, Optional<Color> hourMinuteTextColor, Optional<TextStyle> hourMinuteTextStyle, Optional<NativeObj> inputDecorationTheme, Optional<EdgeInsetsGeometry> padding, Optional<ShapeBorder> shape, Optional<Color> timeSelectorSeparatorColor, Optional<TextStyle> timeSelectorSeparatorTextStyle) {
    throw new UnsupportedOperationException("timePickerThemeDataTimePickerThemeData has no default (FFM/comm impl required)");
  }
  default int timePickerThemeDataLerp(TimePickerThemeData a, TimePickerThemeData b, double t) {
    throw new UnsupportedOperationException("timePickerThemeDataLerp has no default (FFM/comm impl required)");
  }
  default Color TimePickerThemeData_readBack_backgroundColor(Object st) {
    throw new UnsupportedOperationException("TimePickerThemeData_readBack_backgroundColor read-back requires FFM/java22");
  }
  default BorderSide TimePickerThemeData_readBack_dayPeriodBorderSide(Object st) {
    throw new UnsupportedOperationException("TimePickerThemeData_readBack_dayPeriodBorderSide read-back requires FFM/java22");
  }
  default OutlinedBorder TimePickerThemeData_readBack_dayPeriodShape(Object st) {
    throw new UnsupportedOperationException("TimePickerThemeData_readBack_dayPeriodShape read-back requires FFM/java22");
  }
  default Color TimePickerThemeData_readBack_dayPeriodTextColor(Object st) {
    throw new UnsupportedOperationException("TimePickerThemeData_readBack_dayPeriodTextColor read-back requires FFM/java22");
  }
  default TextStyle TimePickerThemeData_readBack_dayPeriodTextStyle(Object st) {
    throw new UnsupportedOperationException("TimePickerThemeData_readBack_dayPeriodTextStyle read-back requires FFM/java22");
  }
  default Color TimePickerThemeData_readBack_dialBackgroundColor(Object st) {
    throw new UnsupportedOperationException("TimePickerThemeData_readBack_dialBackgroundColor read-back requires FFM/java22");
  }
  default Color TimePickerThemeData_readBack_dialHandColor(Object st) {
    throw new UnsupportedOperationException("TimePickerThemeData_readBack_dialHandColor read-back requires FFM/java22");
  }
  default Color TimePickerThemeData_readBack_dialTextColor(Object st) {
    throw new UnsupportedOperationException("TimePickerThemeData_readBack_dialTextColor read-back requires FFM/java22");
  }
  default TextStyle TimePickerThemeData_readBack_dialTextStyle(Object st) {
    throw new UnsupportedOperationException("TimePickerThemeData_readBack_dialTextStyle read-back requires FFM/java22");
  }
  default double TimePickerThemeData_readBack_elevation(Object st) {
    throw new UnsupportedOperationException("TimePickerThemeData_readBack_elevation read-back requires FFM/java22");
  }
  default Color TimePickerThemeData_readBack_entryModeIconColor(Object st) {
    throw new UnsupportedOperationException("TimePickerThemeData_readBack_entryModeIconColor read-back requires FFM/java22");
  }
  default TextStyle TimePickerThemeData_readBack_helpTextStyle(Object st) {
    throw new UnsupportedOperationException("TimePickerThemeData_readBack_helpTextStyle read-back requires FFM/java22");
  }
  default Color TimePickerThemeData_readBack_hourMinuteColor(Object st) {
    throw new UnsupportedOperationException("TimePickerThemeData_readBack_hourMinuteColor read-back requires FFM/java22");
  }
  default ShapeBorder TimePickerThemeData_readBack_hourMinuteShape(Object st) {
    throw new UnsupportedOperationException("TimePickerThemeData_readBack_hourMinuteShape read-back requires FFM/java22");
  }
  default Color TimePickerThemeData_readBack_hourMinuteTextColor(Object st) {
    throw new UnsupportedOperationException("TimePickerThemeData_readBack_hourMinuteTextColor read-back requires FFM/java22");
  }
  default TextStyle TimePickerThemeData_readBack_hourMinuteTextStyle(Object st) {
    throw new UnsupportedOperationException("TimePickerThemeData_readBack_hourMinuteTextStyle read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry TimePickerThemeData_readBack_padding(Object st) {
    throw new UnsupportedOperationException("TimePickerThemeData_readBack_padding read-back requires FFM/java22");
  }
  default ShapeBorder TimePickerThemeData_readBack_shape(Object st) {
    throw new UnsupportedOperationException("TimePickerThemeData_readBack_shape read-back requires FFM/java22");
  }
  default Color TimePickerThemeData_readBack_dayPeriodColor(Object st) {
    throw new UnsupportedOperationException("TimePickerThemeData_readBack_dayPeriodColor read-back requires FFM/java22");
  }

  default int toggleButtonsThemeDataToggleButtonsThemeData(Optional<TextStyle> textStyle, Optional<BoxConstraints> constraints, Optional<Color> color, Optional<Color> selectedColor, Optional<Color> disabledColor, Optional<Color> fillColor, Optional<Color> focusColor, Optional<Color> highlightColor, Optional<Color> hoverColor, Optional<Color> splashColor, Optional<Color> borderColor, Optional<Color> selectedBorderColor, Optional<Color> disabledBorderColor, Optional<BorderRadius> borderRadius, OptionalDouble borderWidth) {
    throw new UnsupportedOperationException("toggleButtonsThemeDataToggleButtonsThemeData has no default (FFM/comm impl required)");
  }
  default int toggleButtonsThemeDataLerp(ToggleButtonsThemeData a, ToggleButtonsThemeData b, double t) {
    throw new UnsupportedOperationException("toggleButtonsThemeDataLerp has no default (FFM/comm impl required)");
  }
  default TextStyle ToggleButtonsThemeData_readBack_textStyle(Object st) {
    throw new UnsupportedOperationException("ToggleButtonsThemeData_readBack_textStyle read-back requires FFM/java22");
  }
  default BoxConstraints ToggleButtonsThemeData_readBack_constraints(Object st) {
    throw new UnsupportedOperationException("ToggleButtonsThemeData_readBack_constraints read-back requires FFM/java22");
  }
  default Color ToggleButtonsThemeData_readBack_color(Object st) {
    throw new UnsupportedOperationException("ToggleButtonsThemeData_readBack_color read-back requires FFM/java22");
  }
  default Color ToggleButtonsThemeData_readBack_selectedColor(Object st) {
    throw new UnsupportedOperationException("ToggleButtonsThemeData_readBack_selectedColor read-back requires FFM/java22");
  }
  default Color ToggleButtonsThemeData_readBack_disabledColor(Object st) {
    throw new UnsupportedOperationException("ToggleButtonsThemeData_readBack_disabledColor read-back requires FFM/java22");
  }
  default Color ToggleButtonsThemeData_readBack_fillColor(Object st) {
    throw new UnsupportedOperationException("ToggleButtonsThemeData_readBack_fillColor read-back requires FFM/java22");
  }
  default Color ToggleButtonsThemeData_readBack_focusColor(Object st) {
    throw new UnsupportedOperationException("ToggleButtonsThemeData_readBack_focusColor read-back requires FFM/java22");
  }
  default Color ToggleButtonsThemeData_readBack_highlightColor(Object st) {
    throw new UnsupportedOperationException("ToggleButtonsThemeData_readBack_highlightColor read-back requires FFM/java22");
  }
  default Color ToggleButtonsThemeData_readBack_splashColor(Object st) {
    throw new UnsupportedOperationException("ToggleButtonsThemeData_readBack_splashColor read-back requires FFM/java22");
  }
  default Color ToggleButtonsThemeData_readBack_hoverColor(Object st) {
    throw new UnsupportedOperationException("ToggleButtonsThemeData_readBack_hoverColor read-back requires FFM/java22");
  }
  default Color ToggleButtonsThemeData_readBack_borderColor(Object st) {
    throw new UnsupportedOperationException("ToggleButtonsThemeData_readBack_borderColor read-back requires FFM/java22");
  }
  default Color ToggleButtonsThemeData_readBack_selectedBorderColor(Object st) {
    throw new UnsupportedOperationException("ToggleButtonsThemeData_readBack_selectedBorderColor read-back requires FFM/java22");
  }
  default Color ToggleButtonsThemeData_readBack_disabledBorderColor(Object st) {
    throw new UnsupportedOperationException("ToggleButtonsThemeData_readBack_disabledBorderColor read-back requires FFM/java22");
  }
  default double ToggleButtonsThemeData_readBack_borderWidth(Object st) {
    throw new UnsupportedOperationException("ToggleButtonsThemeData_readBack_borderWidth read-back requires FFM/java22");
  }
  default BorderRadius ToggleButtonsThemeData_readBack_borderRadius(Object st) {
    throw new UnsupportedOperationException("ToggleButtonsThemeData_readBack_borderRadius read-back requires FFM/java22");
  }

  default int tooltipThemeDataTooltipThemeData(OptionalDouble height, Optional<BoxConstraints> constraints, Optional<EdgeInsetsGeometry> padding, Optional<EdgeInsetsGeometry> margin, OptionalDouble verticalOffset, Optional<Boolean> preferBelow, Optional<Boolean> excludeFromSemantics, Optional<Decoration> decoration, Optional<TextStyle> textStyle, Optional<TextAlign> textAlign, Optional<Duration> waitDuration, Optional<Duration> showDuration, Optional<Duration> exitDuration, Optional<TooltipTriggerMode> triggerMode, Optional<Boolean> enableFeedback) {
    throw new UnsupportedOperationException("tooltipThemeDataTooltipThemeData has no default (FFM/comm impl required)");
  }
  default int tooltipThemeDataLerp(TooltipThemeData a, TooltipThemeData b, double t) {
    throw new UnsupportedOperationException("tooltipThemeDataLerp has no default (FFM/comm impl required)");
  }
  default double TooltipThemeData_readBack_height(Object st) {
    throw new UnsupportedOperationException("TooltipThemeData_readBack_height read-back requires FFM/java22");
  }
  default BoxConstraints TooltipThemeData_readBack_constraints(Object st) {
    throw new UnsupportedOperationException("TooltipThemeData_readBack_constraints read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry TooltipThemeData_readBack_padding(Object st) {
    throw new UnsupportedOperationException("TooltipThemeData_readBack_padding read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry TooltipThemeData_readBack_margin(Object st) {
    throw new UnsupportedOperationException("TooltipThemeData_readBack_margin read-back requires FFM/java22");
  }
  default double TooltipThemeData_readBack_verticalOffset(Object st) {
    throw new UnsupportedOperationException("TooltipThemeData_readBack_verticalOffset read-back requires FFM/java22");
  }
  default boolean TooltipThemeData_readBack_preferBelow(Object st) {
    throw new UnsupportedOperationException("TooltipThemeData_readBack_preferBelow read-back requires FFM/java22");
  }
  default boolean TooltipThemeData_readBack_excludeFromSemantics(Object st) {
    throw new UnsupportedOperationException("TooltipThemeData_readBack_excludeFromSemantics read-back requires FFM/java22");
  }
  default Decoration TooltipThemeData_readBack_decoration(Object st) {
    throw new UnsupportedOperationException("TooltipThemeData_readBack_decoration read-back requires FFM/java22");
  }
  default TextStyle TooltipThemeData_readBack_textStyle(Object st) {
    throw new UnsupportedOperationException("TooltipThemeData_readBack_textStyle read-back requires FFM/java22");
  }
  default TextAlign TooltipThemeData_readBack_textAlign(Object st) {
    throw new UnsupportedOperationException("TooltipThemeData_readBack_textAlign read-back requires FFM/java22");
  }
  default Duration TooltipThemeData_readBack_waitDuration(Object st) {
    throw new UnsupportedOperationException("TooltipThemeData_readBack_waitDuration read-back requires FFM/java22");
  }
  default Duration TooltipThemeData_readBack_showDuration(Object st) {
    throw new UnsupportedOperationException("TooltipThemeData_readBack_showDuration read-back requires FFM/java22");
  }
  default Duration TooltipThemeData_readBack_exitDuration(Object st) {
    throw new UnsupportedOperationException("TooltipThemeData_readBack_exitDuration read-back requires FFM/java22");
  }
  default TooltipTriggerMode TooltipThemeData_readBack_triggerMode(Object st) {
    throw new UnsupportedOperationException("TooltipThemeData_readBack_triggerMode read-back requires FFM/java22");
  }
  default boolean TooltipThemeData_readBack_enableFeedback(Object st) {
    throw new UnsupportedOperationException("TooltipThemeData_readBack_enableFeedback read-back requires FFM/java22");
  }

  default int appBarThemeDataAppBarThemeData(Optional<Color> backgroundColor, Optional<Color> foregroundColor, Optional<Color> color, OptionalDouble elevation, OptionalDouble scrolledUnderElevation, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, Optional<ShapeBorder> shape, Optional<IconThemeData> iconTheme, Optional<IconThemeData> actionsIconTheme, Optional<Boolean> centerTitle, OptionalDouble titleSpacing, OptionalDouble leadingWidth, OptionalDouble toolbarHeight, Optional<TextStyle> toolbarTextStyle, Optional<TextStyle> titleTextStyle, Optional<EdgeInsetsGeometry> actionsPadding) {
    throw new UnsupportedOperationException("appBarThemeDataAppBarThemeData has no default (FFM/comm impl required)");
  }
  default int appBarThemeDataLerp(AppBarThemeData a, AppBarThemeData b, double t) {
    throw new UnsupportedOperationException("appBarThemeDataLerp has no default (FFM/comm impl required)");
  }
  default Color AppBarThemeData_readBack_backgroundColor(Object st) {
    throw new UnsupportedOperationException("AppBarThemeData_readBack_backgroundColor read-back requires FFM/java22");
  }
  default Color AppBarThemeData_readBack_foregroundColor(Object st) {
    throw new UnsupportedOperationException("AppBarThemeData_readBack_foregroundColor read-back requires FFM/java22");
  }
  default double AppBarThemeData_readBack_elevation(Object st) {
    throw new UnsupportedOperationException("AppBarThemeData_readBack_elevation read-back requires FFM/java22");
  }
  default double AppBarThemeData_readBack_scrolledUnderElevation(Object st) {
    throw new UnsupportedOperationException("AppBarThemeData_readBack_scrolledUnderElevation read-back requires FFM/java22");
  }
  default Color AppBarThemeData_readBack_shadowColor(Object st) {
    throw new UnsupportedOperationException("AppBarThemeData_readBack_shadowColor read-back requires FFM/java22");
  }
  default Color AppBarThemeData_readBack_surfaceTintColor(Object st) {
    throw new UnsupportedOperationException("AppBarThemeData_readBack_surfaceTintColor read-back requires FFM/java22");
  }
  default ShapeBorder AppBarThemeData_readBack_shape(Object st) {
    throw new UnsupportedOperationException("AppBarThemeData_readBack_shape read-back requires FFM/java22");
  }
  default IconThemeData AppBarThemeData_readBack_iconTheme(Object st) {
    throw new UnsupportedOperationException("AppBarThemeData_readBack_iconTheme read-back requires FFM/java22");
  }
  default IconThemeData AppBarThemeData_readBack_actionsIconTheme(Object st) {
    throw new UnsupportedOperationException("AppBarThemeData_readBack_actionsIconTheme read-back requires FFM/java22");
  }
  default boolean AppBarThemeData_readBack_centerTitle(Object st) {
    throw new UnsupportedOperationException("AppBarThemeData_readBack_centerTitle read-back requires FFM/java22");
  }
  default double AppBarThemeData_readBack_titleSpacing(Object st) {
    throw new UnsupportedOperationException("AppBarThemeData_readBack_titleSpacing read-back requires FFM/java22");
  }
  default double AppBarThemeData_readBack_leadingWidth(Object st) {
    throw new UnsupportedOperationException("AppBarThemeData_readBack_leadingWidth read-back requires FFM/java22");
  }
  default double AppBarThemeData_readBack_toolbarHeight(Object st) {
    throw new UnsupportedOperationException("AppBarThemeData_readBack_toolbarHeight read-back requires FFM/java22");
  }
  default TextStyle AppBarThemeData_readBack_toolbarTextStyle(Object st) {
    throw new UnsupportedOperationException("AppBarThemeData_readBack_toolbarTextStyle read-back requires FFM/java22");
  }
  default TextStyle AppBarThemeData_readBack_titleTextStyle(Object st) {
    throw new UnsupportedOperationException("AppBarThemeData_readBack_titleTextStyle read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry AppBarThemeData_readBack_actionsPadding(Object st) {
    throw new UnsupportedOperationException("AppBarThemeData_readBack_actionsPadding read-back requires FFM/java22");
  }

  default int cupertinoTextThemeDataCupertinoTextThemeData(Optional<Color> primaryColor, Optional<TextStyle> textStyle, Optional<TextStyle> actionTextStyle, Optional<TextStyle> actionSmallTextStyle, Optional<TextStyle> tabLabelTextStyle, Optional<TextStyle> navTitleTextStyle, Optional<TextStyle> navLargeTitleTextStyle, Optional<TextStyle> navActionTextStyle, Optional<TextStyle> pickerTextStyle, Optional<TextStyle> dateTimePickerTextStyle) {
    throw new UnsupportedOperationException("cupertinoTextThemeDataCupertinoTextThemeData has no default (FFM/comm impl required)");
  }
  default TextStyle CupertinoTextThemeData_readBack_textStyle(Object st) {
    throw new UnsupportedOperationException("CupertinoTextThemeData_readBack_textStyle read-back requires FFM/java22");
  }
  default TextStyle CupertinoTextThemeData_readBack_actionTextStyle(Object st) {
    throw new UnsupportedOperationException("CupertinoTextThemeData_readBack_actionTextStyle read-back requires FFM/java22");
  }
  default TextStyle CupertinoTextThemeData_readBack_actionSmallTextStyle(Object st) {
    throw new UnsupportedOperationException("CupertinoTextThemeData_readBack_actionSmallTextStyle read-back requires FFM/java22");
  }
  default TextStyle CupertinoTextThemeData_readBack_tabLabelTextStyle(Object st) {
    throw new UnsupportedOperationException("CupertinoTextThemeData_readBack_tabLabelTextStyle read-back requires FFM/java22");
  }
  default TextStyle CupertinoTextThemeData_readBack_navTitleTextStyle(Object st) {
    throw new UnsupportedOperationException("CupertinoTextThemeData_readBack_navTitleTextStyle read-back requires FFM/java22");
  }
  default TextStyle CupertinoTextThemeData_readBack_navLargeTitleTextStyle(Object st) {
    throw new UnsupportedOperationException("CupertinoTextThemeData_readBack_navLargeTitleTextStyle read-back requires FFM/java22");
  }
  default TextStyle CupertinoTextThemeData_readBack_navActionTextStyle(Object st) {
    throw new UnsupportedOperationException("CupertinoTextThemeData_readBack_navActionTextStyle read-back requires FFM/java22");
  }
  default TextStyle CupertinoTextThemeData_readBack_pickerTextStyle(Object st) {
    throw new UnsupportedOperationException("CupertinoTextThemeData_readBack_pickerTextStyle read-back requires FFM/java22");
  }
  default TextStyle CupertinoTextThemeData_readBack_dateTimePickerTextStyle(Object st) {
    throw new UnsupportedOperationException("CupertinoTextThemeData_readBack_dateTimePickerTextStyle read-back requires FFM/java22");
  }

  default int materialAccentColorMaterialAccentColor(int primary, Map<Integer, Color> swatch) {
    throw new UnsupportedOperationException("materialAccentColorMaterialAccentColor has no default (FFM/comm impl required)");
  }
  default Color MaterialAccentColor_readBack_shade100(Object st) {
    throw new UnsupportedOperationException("MaterialAccentColor_readBack_shade100 read-back requires FFM/java22");
  }
  default Color MaterialAccentColor_readBack_shade200(Object st) {
    throw new UnsupportedOperationException("MaterialAccentColor_readBack_shade200 read-back requires FFM/java22");
  }
  default Color MaterialAccentColor_readBack_shade400(Object st) {
    throw new UnsupportedOperationException("MaterialAccentColor_readBack_shade400 read-back requires FFM/java22");
  }
  default Color MaterialAccentColor_readBack_shade700(Object st) {
    throw new UnsupportedOperationException("MaterialAccentColor_readBack_shade700 read-back requires FFM/java22");
  }

  default int materialMaterial(Optional<MaterialType> type, OptionalDouble elevation, Optional<Color> color, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, Optional<TextStyle> textStyle, Optional<BorderRadiusGeometry> borderRadius, Optional<ShapeBorder> shape, Optional<Boolean> borderOnForeground, Optional<Clip> clipBehavior, Optional<Duration> animationDuration, Optional<Widget> child, Optional<Boolean> animateColor) {
    throw new UnsupportedOperationException("materialMaterial has no default (FFM/comm impl required)");
  }
  default Widget Material_readBack_child(Object st) {
    throw new UnsupportedOperationException("Material_readBack_child read-back requires FFM/java22");
  }
  default MaterialType Material_readBack_type(Object st) {
    throw new UnsupportedOperationException("Material_readBack_type read-back requires FFM/java22");
  }
  default boolean Material_readBack_animateColor(Object st) {
    throw new UnsupportedOperationException("Material_readBack_animateColor read-back requires FFM/java22");
  }
  default double Material_readBack_elevation(Object st) {
    throw new UnsupportedOperationException("Material_readBack_elevation read-back requires FFM/java22");
  }
  default Color Material_readBack_color(Object st) {
    throw new UnsupportedOperationException("Material_readBack_color read-back requires FFM/java22");
  }
  default Color Material_readBack_shadowColor(Object st) {
    throw new UnsupportedOperationException("Material_readBack_shadowColor read-back requires FFM/java22");
  }
  default Color Material_readBack_surfaceTintColor(Object st) {
    throw new UnsupportedOperationException("Material_readBack_surfaceTintColor read-back requires FFM/java22");
  }
  default TextStyle Material_readBack_textStyle(Object st) {
    throw new UnsupportedOperationException("Material_readBack_textStyle read-back requires FFM/java22");
  }
  default ShapeBorder Material_readBack_shape(Object st) {
    throw new UnsupportedOperationException("Material_readBack_shape read-back requires FFM/java22");
  }
  default boolean Material_readBack_borderOnForeground(Object st) {
    throw new UnsupportedOperationException("Material_readBack_borderOnForeground read-back requires FFM/java22");
  }
  default Clip Material_readBack_clipBehavior(Object st) {
    throw new UnsupportedOperationException("Material_readBack_clipBehavior read-back requires FFM/java22");
  }
  default Duration Material_readBack_animationDuration(Object st) {
    throw new UnsupportedOperationException("Material_readBack_animationDuration read-back requires FFM/java22");
  }
  default BorderRadiusGeometry Material_readBack_borderRadius(Object st) {
    throw new UnsupportedOperationException("Material_readBack_borderRadius read-back requires FFM/java22");
  }

  default int iconButtonIconButton(OptionalDouble iconSize, Optional<VisualDensity> visualDensity, Optional<EdgeInsetsGeometry> padding, Optional<AlignmentGeometry> alignment, OptionalDouble splashRadius, Optional<Color> color, Optional<Color> focusColor, Optional<Color> hoverColor, Optional<Color> highlightColor, Optional<Color> splashColor, Optional<Color> disabledColor, Optional<Runnable> onPressed, Optional<Consumer<Boolean>> onHover, Optional<Runnable> onLongPress, Optional<Boolean> autofocus, Optional<String> tooltip, Optional<Boolean> enableFeedback, Optional<BoxConstraints> constraints, Optional<Boolean> isSelected, Optional<Widget> selectedIcon, Widget icon) {
    throw new UnsupportedOperationException("iconButtonIconButton has no default (FFM/comm impl required)");
  }
  default int iconButtonFilled(OptionalDouble iconSize, Optional<VisualDensity> visualDensity, Optional<EdgeInsetsGeometry> padding, Optional<AlignmentGeometry> alignment, OptionalDouble splashRadius, Optional<Color> color, Optional<Color> focusColor, Optional<Color> hoverColor, Optional<Color> highlightColor, Optional<Color> splashColor, Optional<Color> disabledColor, Optional<Runnable> onPressed, Optional<Consumer<Boolean>> onHover, Optional<Runnable> onLongPress, Optional<Boolean> autofocus, Optional<String> tooltip, Optional<Boolean> enableFeedback, Optional<BoxConstraints> constraints, Optional<Boolean> isSelected, Optional<Widget> selectedIcon, Widget icon) {
    throw new UnsupportedOperationException("iconButtonFilled has no default (FFM/comm impl required)");
  }
  default int iconButtonFilledTonal(OptionalDouble iconSize, Optional<VisualDensity> visualDensity, Optional<EdgeInsetsGeometry> padding, Optional<AlignmentGeometry> alignment, OptionalDouble splashRadius, Optional<Color> color, Optional<Color> focusColor, Optional<Color> hoverColor, Optional<Color> highlightColor, Optional<Color> splashColor, Optional<Color> disabledColor, Optional<Runnable> onPressed, Optional<Consumer<Boolean>> onHover, Optional<Runnable> onLongPress, Optional<Boolean> autofocus, Optional<String> tooltip, Optional<Boolean> enableFeedback, Optional<BoxConstraints> constraints, Optional<Boolean> isSelected, Optional<Widget> selectedIcon, Widget icon) {
    throw new UnsupportedOperationException("iconButtonFilledTonal has no default (FFM/comm impl required)");
  }
  default int iconButtonOutlined(OptionalDouble iconSize, Optional<VisualDensity> visualDensity, Optional<EdgeInsetsGeometry> padding, Optional<AlignmentGeometry> alignment, OptionalDouble splashRadius, Optional<Color> color, Optional<Color> focusColor, Optional<Color> hoverColor, Optional<Color> highlightColor, Optional<Color> splashColor, Optional<Color> disabledColor, Optional<Runnable> onPressed, Optional<Consumer<Boolean>> onHover, Optional<Runnable> onLongPress, Optional<Boolean> autofocus, Optional<String> tooltip, Optional<Boolean> enableFeedback, Optional<BoxConstraints> constraints, Optional<Boolean> isSelected, Optional<Widget> selectedIcon, Widget icon) {
    throw new UnsupportedOperationException("iconButtonOutlined has no default (FFM/comm impl required)");
  }
  default double IconButton_readBack_iconSize(Object st) {
    throw new UnsupportedOperationException("IconButton_readBack_iconSize read-back requires FFM/java22");
  }
  default VisualDensity IconButton_readBack_visualDensity(Object st) {
    throw new UnsupportedOperationException("IconButton_readBack_visualDensity read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry IconButton_readBack_padding(Object st) {
    throw new UnsupportedOperationException("IconButton_readBack_padding read-back requires FFM/java22");
  }
  default AlignmentGeometry IconButton_readBack_alignment(Object st) {
    throw new UnsupportedOperationException("IconButton_readBack_alignment read-back requires FFM/java22");
  }
  default double IconButton_readBack_splashRadius(Object st) {
    throw new UnsupportedOperationException("IconButton_readBack_splashRadius read-back requires FFM/java22");
  }
  default Widget IconButton_readBack_icon(Object st) {
    throw new UnsupportedOperationException("IconButton_readBack_icon read-back requires FFM/java22");
  }
  default Color IconButton_readBack_focusColor(Object st) {
    throw new UnsupportedOperationException("IconButton_readBack_focusColor read-back requires FFM/java22");
  }
  default Color IconButton_readBack_hoverColor(Object st) {
    throw new UnsupportedOperationException("IconButton_readBack_hoverColor read-back requires FFM/java22");
  }
  default Color IconButton_readBack_color(Object st) {
    throw new UnsupportedOperationException("IconButton_readBack_color read-back requires FFM/java22");
  }
  default Color IconButton_readBack_splashColor(Object st) {
    throw new UnsupportedOperationException("IconButton_readBack_splashColor read-back requires FFM/java22");
  }
  default Color IconButton_readBack_highlightColor(Object st) {
    throw new UnsupportedOperationException("IconButton_readBack_highlightColor read-back requires FFM/java22");
  }
  default Color IconButton_readBack_disabledColor(Object st) {
    throw new UnsupportedOperationException("IconButton_readBack_disabledColor read-back requires FFM/java22");
  }
  default boolean IconButton_readBack_autofocus(Object st) {
    throw new UnsupportedOperationException("IconButton_readBack_autofocus read-back requires FFM/java22");
  }
  default String IconButton_readBack_tooltip(Object st) {
    throw new UnsupportedOperationException("IconButton_readBack_tooltip read-back requires FFM/java22");
  }
  default boolean IconButton_readBack_enableFeedback(Object st) {
    throw new UnsupportedOperationException("IconButton_readBack_enableFeedback read-back requires FFM/java22");
  }
  default BoxConstraints IconButton_readBack_constraints(Object st) {
    throw new UnsupportedOperationException("IconButton_readBack_constraints read-back requires FFM/java22");
  }
  default boolean IconButton_readBack_isSelected(Object st) {
    throw new UnsupportedOperationException("IconButton_readBack_isSelected read-back requires FFM/java22");
  }
  default Widget IconButton_readBack_selectedIcon(Object st) {
    throw new UnsupportedOperationException("IconButton_readBack_selectedIcon read-back requires FFM/java22");
  }

  default int appBarAppBar(Optional<Widget> leading, Optional<Boolean> automaticallyImplyLeading, Optional<Widget> title, Optional<List<Widget>> actions, Optional<Boolean> automaticallyImplyActions, Optional<Widget> flexibleSpace, Optional<PreferredSizeWidget> bottom, OptionalDouble elevation, OptionalDouble scrolledUnderElevation, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, Optional<ShapeBorder> shape, Optional<Color> backgroundColor, Optional<Color> foregroundColor, Optional<IconThemeData> iconTheme, Optional<IconThemeData> actionsIconTheme, Optional<Boolean> primary, Optional<Boolean> centerTitle, Optional<Boolean> excludeHeaderSemantics, OptionalDouble titleSpacing, OptionalDouble toolbarOpacity, OptionalDouble bottomOpacity, OptionalDouble toolbarHeight, OptionalDouble leadingWidth, Optional<TextStyle> toolbarTextStyle, Optional<TextStyle> titleTextStyle, Optional<Boolean> forceMaterialTransparency, Optional<Boolean> useDefaultSemanticsOrder, Optional<Clip> clipBehavior, Optional<EdgeInsetsGeometry> actionsPadding, Optional<Boolean> animateColor) {
    throw new UnsupportedOperationException("appBarAppBar has no default (FFM/comm impl required)");
  }
  default Widget AppBar_readBack_leading(Object st) {
    throw new UnsupportedOperationException("AppBar_readBack_leading read-back requires FFM/java22");
  }
  default boolean AppBar_readBack_automaticallyImplyLeading(Object st) {
    throw new UnsupportedOperationException("AppBar_readBack_automaticallyImplyLeading read-back requires FFM/java22");
  }
  default Widget AppBar_readBack_title(Object st) {
    throw new UnsupportedOperationException("AppBar_readBack_title read-back requires FFM/java22");
  }
  default boolean AppBar_readBack_automaticallyImplyActions(Object st) {
    throw new UnsupportedOperationException("AppBar_readBack_automaticallyImplyActions read-back requires FFM/java22");
  }
  default Widget AppBar_readBack_flexibleSpace(Object st) {
    throw new UnsupportedOperationException("AppBar_readBack_flexibleSpace read-back requires FFM/java22");
  }
  default PreferredSizeWidget AppBar_readBack_bottom(Object st) {
    throw new UnsupportedOperationException("AppBar_readBack_bottom read-back requires FFM/java22");
  }
  default double AppBar_readBack_elevation(Object st) {
    throw new UnsupportedOperationException("AppBar_readBack_elevation read-back requires FFM/java22");
  }
  default double AppBar_readBack_scrolledUnderElevation(Object st) {
    throw new UnsupportedOperationException("AppBar_readBack_scrolledUnderElevation read-back requires FFM/java22");
  }
  default Color AppBar_readBack_shadowColor(Object st) {
    throw new UnsupportedOperationException("AppBar_readBack_shadowColor read-back requires FFM/java22");
  }
  default Color AppBar_readBack_surfaceTintColor(Object st) {
    throw new UnsupportedOperationException("AppBar_readBack_surfaceTintColor read-back requires FFM/java22");
  }
  default ShapeBorder AppBar_readBack_shape(Object st) {
    throw new UnsupportedOperationException("AppBar_readBack_shape read-back requires FFM/java22");
  }
  default Color AppBar_readBack_backgroundColor(Object st) {
    throw new UnsupportedOperationException("AppBar_readBack_backgroundColor read-back requires FFM/java22");
  }
  default Color AppBar_readBack_foregroundColor(Object st) {
    throw new UnsupportedOperationException("AppBar_readBack_foregroundColor read-back requires FFM/java22");
  }
  default IconThemeData AppBar_readBack_iconTheme(Object st) {
    throw new UnsupportedOperationException("AppBar_readBack_iconTheme read-back requires FFM/java22");
  }
  default IconThemeData AppBar_readBack_actionsIconTheme(Object st) {
    throw new UnsupportedOperationException("AppBar_readBack_actionsIconTheme read-back requires FFM/java22");
  }
  default boolean AppBar_readBack_primary(Object st) {
    throw new UnsupportedOperationException("AppBar_readBack_primary read-back requires FFM/java22");
  }
  default boolean AppBar_readBack_centerTitle(Object st) {
    throw new UnsupportedOperationException("AppBar_readBack_centerTitle read-back requires FFM/java22");
  }
  default boolean AppBar_readBack_excludeHeaderSemantics(Object st) {
    throw new UnsupportedOperationException("AppBar_readBack_excludeHeaderSemantics read-back requires FFM/java22");
  }
  default double AppBar_readBack_titleSpacing(Object st) {
    throw new UnsupportedOperationException("AppBar_readBack_titleSpacing read-back requires FFM/java22");
  }
  default double AppBar_readBack_toolbarOpacity(Object st) {
    throw new UnsupportedOperationException("AppBar_readBack_toolbarOpacity read-back requires FFM/java22");
  }
  default double AppBar_readBack_bottomOpacity(Object st) {
    throw new UnsupportedOperationException("AppBar_readBack_bottomOpacity read-back requires FFM/java22");
  }
  default double AppBar_readBack_toolbarHeight(Object st) {
    throw new UnsupportedOperationException("AppBar_readBack_toolbarHeight read-back requires FFM/java22");
  }
  default double AppBar_readBack_leadingWidth(Object st) {
    throw new UnsupportedOperationException("AppBar_readBack_leadingWidth read-back requires FFM/java22");
  }
  default TextStyle AppBar_readBack_toolbarTextStyle(Object st) {
    throw new UnsupportedOperationException("AppBar_readBack_toolbarTextStyle read-back requires FFM/java22");
  }
  default TextStyle AppBar_readBack_titleTextStyle(Object st) {
    throw new UnsupportedOperationException("AppBar_readBack_titleTextStyle read-back requires FFM/java22");
  }
  default boolean AppBar_readBack_forceMaterialTransparency(Object st) {
    throw new UnsupportedOperationException("AppBar_readBack_forceMaterialTransparency read-back requires FFM/java22");
  }
  default boolean AppBar_readBack_useDefaultSemanticsOrder(Object st) {
    throw new UnsupportedOperationException("AppBar_readBack_useDefaultSemanticsOrder read-back requires FFM/java22");
  }
  default Clip AppBar_readBack_clipBehavior(Object st) {
    throw new UnsupportedOperationException("AppBar_readBack_clipBehavior read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry AppBar_readBack_actionsPadding(Object st) {
    throw new UnsupportedOperationException("AppBar_readBack_actionsPadding read-back requires FFM/java22");
  }
  default boolean AppBar_readBack_animateColor(Object st) {
    throw new UnsupportedOperationException("AppBar_readBack_animateColor read-back requires FFM/java22");
  }

  default int scaffoldScaffold(Optional<PreferredSizeWidget> appBar, Optional<Widget> body, Optional<Widget> floatingActionButton, Optional<List<Widget>> persistentFooterButtons, Optional<AlignmentDirectional> persistentFooterAlignment, Optional<BoxDecoration> persistentFooterDecoration, Optional<Widget> drawer, Optional<Consumer<Boolean>> onDrawerChanged, Optional<Widget> endDrawer, Optional<Consumer<Boolean>> onEndDrawerChanged, Optional<Widget> bottomNavigationBar, Optional<Widget> bottomSheet, Optional<Color> backgroundColor, Optional<Boolean> resizeToAvoidBottomInset, Optional<Boolean> primary, Optional<DragStartBehavior> drawerDragStartBehavior, Optional<Boolean> extendBody, Optional<Boolean> drawerBarrierDismissible, Optional<Boolean> extendBodyBehindAppBar, Optional<Color> drawerScrimColor, Optional<BiFunction<BuildContext, Animation, Widget>> bottomSheetScrimBuilder, OptionalDouble drawerEdgeDragWidth, Optional<Boolean> drawerEnableOpenDragGesture, Optional<Boolean> endDrawerEnableOpenDragGesture, Optional<String> restorationId) {
    throw new UnsupportedOperationException("scaffoldScaffold has no default (FFM/comm impl required)");
  }
  default int scaffoldGeometryOf(BuildContext context) {
    throw new UnsupportedOperationException("scaffoldGeometryOf has no default (FFM/comm impl required)");
  }
  default int scaffoldHasDrawer(BuildContext context, Optional<Boolean> registerForUpdates) {
    throw new UnsupportedOperationException("scaffoldHasDrawer has no default (FFM/comm impl required)");
  }
  default boolean Scaffold_readBack_extendBody(Object st) {
    throw new UnsupportedOperationException("Scaffold_readBack_extendBody read-back requires FFM/java22");
  }
  default boolean Scaffold_readBack_drawerBarrierDismissible(Object st) {
    throw new UnsupportedOperationException("Scaffold_readBack_drawerBarrierDismissible read-back requires FFM/java22");
  }
  default boolean Scaffold_readBack_extendBodyBehindAppBar(Object st) {
    throw new UnsupportedOperationException("Scaffold_readBack_extendBodyBehindAppBar read-back requires FFM/java22");
  }
  default PreferredSizeWidget Scaffold_readBack_appBar(Object st) {
    throw new UnsupportedOperationException("Scaffold_readBack_appBar read-back requires FFM/java22");
  }
  default Widget Scaffold_readBack_body(Object st) {
    throw new UnsupportedOperationException("Scaffold_readBack_body read-back requires FFM/java22");
  }
  default Widget Scaffold_readBack_floatingActionButton(Object st) {
    throw new UnsupportedOperationException("Scaffold_readBack_floatingActionButton read-back requires FFM/java22");
  }
  default AlignmentDirectional Scaffold_readBack_persistentFooterAlignment(Object st) {
    throw new UnsupportedOperationException("Scaffold_readBack_persistentFooterAlignment read-back requires FFM/java22");
  }
  default BoxDecoration Scaffold_readBack_persistentFooterDecoration(Object st) {
    throw new UnsupportedOperationException("Scaffold_readBack_persistentFooterDecoration read-back requires FFM/java22");
  }
  default Widget Scaffold_readBack_drawer(Object st) {
    throw new UnsupportedOperationException("Scaffold_readBack_drawer read-back requires FFM/java22");
  }
  default Widget Scaffold_readBack_endDrawer(Object st) {
    throw new UnsupportedOperationException("Scaffold_readBack_endDrawer read-back requires FFM/java22");
  }
  default Color Scaffold_readBack_drawerScrimColor(Object st) {
    throw new UnsupportedOperationException("Scaffold_readBack_drawerScrimColor read-back requires FFM/java22");
  }
  default Color Scaffold_readBack_backgroundColor(Object st) {
    throw new UnsupportedOperationException("Scaffold_readBack_backgroundColor read-back requires FFM/java22");
  }
  default Widget Scaffold_readBack_bottomNavigationBar(Object st) {
    throw new UnsupportedOperationException("Scaffold_readBack_bottomNavigationBar read-back requires FFM/java22");
  }
  default Widget Scaffold_readBack_bottomSheet(Object st) {
    throw new UnsupportedOperationException("Scaffold_readBack_bottomSheet read-back requires FFM/java22");
  }
  default boolean Scaffold_readBack_resizeToAvoidBottomInset(Object st) {
    throw new UnsupportedOperationException("Scaffold_readBack_resizeToAvoidBottomInset read-back requires FFM/java22");
  }
  default boolean Scaffold_readBack_primary(Object st) {
    throw new UnsupportedOperationException("Scaffold_readBack_primary read-back requires FFM/java22");
  }
  default DragStartBehavior Scaffold_readBack_drawerDragStartBehavior(Object st) {
    throw new UnsupportedOperationException("Scaffold_readBack_drawerDragStartBehavior read-back requires FFM/java22");
  }
  default double Scaffold_readBack_drawerEdgeDragWidth(Object st) {
    throw new UnsupportedOperationException("Scaffold_readBack_drawerEdgeDragWidth read-back requires FFM/java22");
  }
  default boolean Scaffold_readBack_drawerEnableOpenDragGesture(Object st) {
    throw new UnsupportedOperationException("Scaffold_readBack_drawerEnableOpenDragGesture read-back requires FFM/java22");
  }
  default boolean Scaffold_readBack_endDrawerEnableOpenDragGesture(Object st) {
    throw new UnsupportedOperationException("Scaffold_readBack_endDrawerEnableOpenDragGesture read-back requires FFM/java22");
  }
  default String Scaffold_readBack_restorationId(Object st) {
    throw new UnsupportedOperationException("Scaffold_readBack_restorationId read-back requires FFM/java22");
  }

  default int materialAppMaterialApp(Optional<Widget> home, Optional<String> initialRoute, Optional<BiFunction<BuildContext, Widget, Widget>> builder, Optional<String> title, Optional<Function<BuildContext, String>> onGenerateTitle, Optional<Color> color, Optional<ThemeData> theme, Optional<ThemeData> darkTheme, Optional<ThemeData> highContrastTheme, Optional<ThemeData> highContrastDarkTheme, Optional<ThemeMode> themeMode, Optional<Duration> themeAnimationDuration, Optional<Curve> themeAnimationCurve, Optional<Boolean> debugShowMaterialGrid, Optional<Boolean> showPerformanceOverlay, Optional<Boolean> checkerboardRasterCacheImages, Optional<Boolean> checkerboardOffscreenLayers, Optional<Boolean> showSemanticsDebugger, Optional<Boolean> debugShowCheckedModeBanner, Optional<String> restorationScopeId, Optional<Boolean> useInheritedMediaQuery) {
    throw new UnsupportedOperationException("materialAppMaterialApp has no default (FFM/comm impl required)");
  }
  default int materialAppRouter(Optional<BiFunction<BuildContext, Widget, Widget>> builder, Optional<String> title, Optional<Function<BuildContext, String>> onGenerateTitle, Optional<Color> color, Optional<ThemeData> theme, Optional<ThemeData> darkTheme, Optional<ThemeData> highContrastTheme, Optional<ThemeData> highContrastDarkTheme, Optional<ThemeMode> themeMode, Optional<Duration> themeAnimationDuration, Optional<Curve> themeAnimationCurve, Optional<Boolean> debugShowMaterialGrid, Optional<Boolean> showPerformanceOverlay, Optional<Boolean> checkerboardRasterCacheImages, Optional<Boolean> checkerboardOffscreenLayers, Optional<Boolean> showSemanticsDebugger, Optional<Boolean> debugShowCheckedModeBanner, Optional<String> restorationScopeId, Optional<Boolean> useInheritedMediaQuery) {
    throw new UnsupportedOperationException("materialAppRouter has no default (FFM/comm impl required)");
  }
  default Widget MaterialApp_readBack_home(Object st) {
    throw new UnsupportedOperationException("MaterialApp_readBack_home read-back requires FFM/java22");
  }
  default String MaterialApp_readBack_initialRoute(Object st) {
    throw new UnsupportedOperationException("MaterialApp_readBack_initialRoute read-back requires FFM/java22");
  }
  default String MaterialApp_readBack_title(Object st) {
    throw new UnsupportedOperationException("MaterialApp_readBack_title read-back requires FFM/java22");
  }
  default ThemeData MaterialApp_readBack_theme(Object st) {
    throw new UnsupportedOperationException("MaterialApp_readBack_theme read-back requires FFM/java22");
  }
  default ThemeData MaterialApp_readBack_darkTheme(Object st) {
    throw new UnsupportedOperationException("MaterialApp_readBack_darkTheme read-back requires FFM/java22");
  }
  default ThemeData MaterialApp_readBack_highContrastTheme(Object st) {
    throw new UnsupportedOperationException("MaterialApp_readBack_highContrastTheme read-back requires FFM/java22");
  }
  default ThemeData MaterialApp_readBack_highContrastDarkTheme(Object st) {
    throw new UnsupportedOperationException("MaterialApp_readBack_highContrastDarkTheme read-back requires FFM/java22");
  }
  default ThemeMode MaterialApp_readBack_themeMode(Object st) {
    throw new UnsupportedOperationException("MaterialApp_readBack_themeMode read-back requires FFM/java22");
  }
  default Duration MaterialApp_readBack_themeAnimationDuration(Object st) {
    throw new UnsupportedOperationException("MaterialApp_readBack_themeAnimationDuration read-back requires FFM/java22");
  }
  default Curve MaterialApp_readBack_themeAnimationCurve(Object st) {
    throw new UnsupportedOperationException("MaterialApp_readBack_themeAnimationCurve read-back requires FFM/java22");
  }
  default Color MaterialApp_readBack_color(Object st) {
    throw new UnsupportedOperationException("MaterialApp_readBack_color read-back requires FFM/java22");
  }
  default boolean MaterialApp_readBack_showPerformanceOverlay(Object st) {
    throw new UnsupportedOperationException("MaterialApp_readBack_showPerformanceOverlay read-back requires FFM/java22");
  }
  default boolean MaterialApp_readBack_checkerboardRasterCacheImages(Object st) {
    throw new UnsupportedOperationException("MaterialApp_readBack_checkerboardRasterCacheImages read-back requires FFM/java22");
  }
  default boolean MaterialApp_readBack_checkerboardOffscreenLayers(Object st) {
    throw new UnsupportedOperationException("MaterialApp_readBack_checkerboardOffscreenLayers read-back requires FFM/java22");
  }
  default boolean MaterialApp_readBack_showSemanticsDebugger(Object st) {
    throw new UnsupportedOperationException("MaterialApp_readBack_showSemanticsDebugger read-back requires FFM/java22");
  }
  default boolean MaterialApp_readBack_debugShowCheckedModeBanner(Object st) {
    throw new UnsupportedOperationException("MaterialApp_readBack_debugShowCheckedModeBanner read-back requires FFM/java22");
  }
  default String MaterialApp_readBack_restorationScopeId(Object st) {
    throw new UnsupportedOperationException("MaterialApp_readBack_restorationScopeId read-back requires FFM/java22");
  }
  default boolean MaterialApp_readBack_debugShowMaterialGrid(Object st) {
    throw new UnsupportedOperationException("MaterialApp_readBack_debugShowMaterialGrid read-back requires FFM/java22");
  }
  default boolean MaterialApp_readBack_useInheritedMediaQuery(Object st) {
    throw new UnsupportedOperationException("MaterialApp_readBack_useInheritedMediaQuery read-back requires FFM/java22");
  }

  default int floatingActionButtonFloatingActionButton(Optional<Widget> child, Optional<String> tooltip, Optional<Color> foregroundColor, Optional<Color> backgroundColor, Optional<Color> focusColor, Optional<Color> hoverColor, Optional<Color> splashColor, Optional<NativeObj> heroTag, OptionalDouble elevation, OptionalDouble focusElevation, OptionalDouble hoverElevation, OptionalDouble highlightElevation, OptionalDouble disabledElevation, Optional<Runnable> onPressed, Optional<Boolean> mini, Optional<ShapeBorder> shape, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<Boolean> isExtended, Optional<Boolean> enableFeedback) {
    throw new UnsupportedOperationException("floatingActionButtonFloatingActionButton has no default (FFM/comm impl required)");
  }
  default int floatingActionButtonSmall(Optional<Widget> child, Optional<String> tooltip, Optional<Color> foregroundColor, Optional<Color> backgroundColor, Optional<Color> focusColor, Optional<Color> hoverColor, Optional<Color> splashColor, Optional<NativeObj> heroTag, OptionalDouble elevation, OptionalDouble focusElevation, OptionalDouble hoverElevation, OptionalDouble highlightElevation, OptionalDouble disabledElevation, Optional<Runnable> onPressed, Optional<ShapeBorder> shape, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<Boolean> enableFeedback) {
    throw new UnsupportedOperationException("floatingActionButtonSmall has no default (FFM/comm impl required)");
  }
  default int floatingActionButtonLarge(Optional<Widget> child, Optional<String> tooltip, Optional<Color> foregroundColor, Optional<Color> backgroundColor, Optional<Color> focusColor, Optional<Color> hoverColor, Optional<Color> splashColor, Optional<NativeObj> heroTag, OptionalDouble elevation, OptionalDouble focusElevation, OptionalDouble hoverElevation, OptionalDouble highlightElevation, OptionalDouble disabledElevation, Optional<Runnable> onPressed, Optional<ShapeBorder> shape, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<Boolean> enableFeedback) {
    throw new UnsupportedOperationException("floatingActionButtonLarge has no default (FFM/comm impl required)");
  }
  default int floatingActionButtonExtended(Optional<String> tooltip, Optional<Color> foregroundColor, Optional<Color> backgroundColor, Optional<Color> focusColor, Optional<Color> hoverColor, Optional<NativeObj> heroTag, OptionalDouble elevation, OptionalDouble focusElevation, OptionalDouble hoverElevation, Optional<Color> splashColor, OptionalDouble highlightElevation, OptionalDouble disabledElevation, Optional<Runnable> onPressed, Optional<ShapeBorder> shape, Optional<Boolean> isExtended, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, OptionalDouble extendedIconLabelSpacing, Optional<EdgeInsetsGeometry> extendedPadding, Optional<TextStyle> extendedTextStyle, Optional<Widget> icon, Widget label, Optional<Boolean> enableFeedback) {
    throw new UnsupportedOperationException("floatingActionButtonExtended has no default (FFM/comm impl required)");
  }
  default Widget FloatingActionButton_readBack_child(Object st) {
    throw new UnsupportedOperationException("FloatingActionButton_readBack_child read-back requires FFM/java22");
  }
  default String FloatingActionButton_readBack_tooltip(Object st) {
    throw new UnsupportedOperationException("FloatingActionButton_readBack_tooltip read-back requires FFM/java22");
  }
  default Color FloatingActionButton_readBack_foregroundColor(Object st) {
    throw new UnsupportedOperationException("FloatingActionButton_readBack_foregroundColor read-back requires FFM/java22");
  }
  default Color FloatingActionButton_readBack_backgroundColor(Object st) {
    throw new UnsupportedOperationException("FloatingActionButton_readBack_backgroundColor read-back requires FFM/java22");
  }
  default Color FloatingActionButton_readBack_focusColor(Object st) {
    throw new UnsupportedOperationException("FloatingActionButton_readBack_focusColor read-back requires FFM/java22");
  }
  default Color FloatingActionButton_readBack_hoverColor(Object st) {
    throw new UnsupportedOperationException("FloatingActionButton_readBack_hoverColor read-back requires FFM/java22");
  }
  default Color FloatingActionButton_readBack_splashColor(Object st) {
    throw new UnsupportedOperationException("FloatingActionButton_readBack_splashColor read-back requires FFM/java22");
  }
  default double FloatingActionButton_readBack_elevation(Object st) {
    throw new UnsupportedOperationException("FloatingActionButton_readBack_elevation read-back requires FFM/java22");
  }
  default double FloatingActionButton_readBack_focusElevation(Object st) {
    throw new UnsupportedOperationException("FloatingActionButton_readBack_focusElevation read-back requires FFM/java22");
  }
  default double FloatingActionButton_readBack_hoverElevation(Object st) {
    throw new UnsupportedOperationException("FloatingActionButton_readBack_hoverElevation read-back requires FFM/java22");
  }
  default double FloatingActionButton_readBack_highlightElevation(Object st) {
    throw new UnsupportedOperationException("FloatingActionButton_readBack_highlightElevation read-back requires FFM/java22");
  }
  default double FloatingActionButton_readBack_disabledElevation(Object st) {
    throw new UnsupportedOperationException("FloatingActionButton_readBack_disabledElevation read-back requires FFM/java22");
  }
  default boolean FloatingActionButton_readBack_mini(Object st) {
    throw new UnsupportedOperationException("FloatingActionButton_readBack_mini read-back requires FFM/java22");
  }
  default ShapeBorder FloatingActionButton_readBack_shape(Object st) {
    throw new UnsupportedOperationException("FloatingActionButton_readBack_shape read-back requires FFM/java22");
  }
  default Clip FloatingActionButton_readBack_clipBehavior(Object st) {
    throw new UnsupportedOperationException("FloatingActionButton_readBack_clipBehavior read-back requires FFM/java22");
  }
  default boolean FloatingActionButton_readBack_isExtended(Object st) {
    throw new UnsupportedOperationException("FloatingActionButton_readBack_isExtended read-back requires FFM/java22");
  }
  default boolean FloatingActionButton_readBack_autofocus(Object st) {
    throw new UnsupportedOperationException("FloatingActionButton_readBack_autofocus read-back requires FFM/java22");
  }
  default MaterialTapTargetSize FloatingActionButton_readBack_materialTapTargetSize(Object st) {
    throw new UnsupportedOperationException("FloatingActionButton_readBack_materialTapTargetSize read-back requires FFM/java22");
  }
  default boolean FloatingActionButton_readBack_enableFeedback(Object st) {
    throw new UnsupportedOperationException("FloatingActionButton_readBack_enableFeedback read-back requires FFM/java22");
  }
  default double FloatingActionButton_readBack_extendedIconLabelSpacing(Object st) {
    throw new UnsupportedOperationException("FloatingActionButton_readBack_extendedIconLabelSpacing read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry FloatingActionButton_readBack_extendedPadding(Object st) {
    throw new UnsupportedOperationException("FloatingActionButton_readBack_extendedPadding read-back requires FFM/java22");
  }
  default TextStyle FloatingActionButton_readBack_extendedTextStyle(Object st) {
    throw new UnsupportedOperationException("FloatingActionButton_readBack_extendedTextStyle read-back requires FFM/java22");
  }

  default int themeTheme(ThemeData data, Widget child) {
    throw new UnsupportedOperationException("themeTheme has no default (FFM/comm impl required)");
  }
  default int themeOf(BuildContext context) {
    throw new UnsupportedOperationException("themeOf has no default (FFM/comm impl required)");
  }
  default int themeBrightnessOf(BuildContext context) {
    throw new UnsupportedOperationException("themeBrightnessOf has no default (FFM/comm impl required)");
  }
  default int themeMaybeBrightnessOf(BuildContext context) {
    throw new UnsupportedOperationException("themeMaybeBrightnessOf has no default (FFM/comm impl required)");
  }
  default ThemeData Theme_readBack_data(Object st) {
    throw new UnsupportedOperationException("Theme_readBack_data read-back requires FFM/java22");
  }
  default Widget Theme_readBack_child(Object st) {
    throw new UnsupportedOperationException("Theme_readBack_child read-back requires FFM/java22");
  }

  default int elevatedButtonElevatedButton(Optional<Runnable> onPressed, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Clip> clipBehavior, Optional<Widget> child) {
    throw new UnsupportedOperationException("elevatedButtonElevatedButton has no default (FFM/comm impl required)");
  }
  default int elevatedButtonIcon(Optional<Runnable> onPressed, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Clip> clipBehavior, Optional<Widget> icon, Widget label, Optional<IconAlignment> iconAlignment) {
    throw new UnsupportedOperationException("elevatedButtonIcon has no default (FFM/comm impl required)");
  }

  default int outlinedButtonOutlinedButton(Optional<Runnable> onPressed, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Clip> clipBehavior, Optional<Widget> child) {
    throw new UnsupportedOperationException("outlinedButtonOutlinedButton has no default (FFM/comm impl required)");
  }
  default int outlinedButtonIcon(Optional<Runnable> onPressed, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Clip> clipBehavior, Optional<Widget> icon, Widget label, Optional<IconAlignment> iconAlignment) {
    throw new UnsupportedOperationException("outlinedButtonIcon has no default (FFM/comm impl required)");
  }

  default int textButtonTextButton(Optional<Runnable> onPressed, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Clip> clipBehavior, Optional<Boolean> isSemanticButton, Widget child) {
    throw new UnsupportedOperationException("textButtonTextButton has no default (FFM/comm impl required)");
  }
  default int textButtonIcon(Optional<Runnable> onPressed, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Clip> clipBehavior, Optional<Widget> icon, Widget label, Optional<IconAlignment> iconAlignment) {
    throw new UnsupportedOperationException("textButtonIcon has no default (FFM/comm impl required)");
  }

  default int navigatorStateNavigatorState() {
    throw new UnsupportedOperationException("navigatorStateNavigatorState has no default (FFM/comm impl required)");
  }

  default int navigatorNavigator(Optional<String> initialRoute, Optional<Boolean> reportsRouteUpdateToEngine, Optional<Clip> clipBehavior, Optional<Boolean> requestFocus, Optional<String> restorationScopeId, Optional<TraversalEdgeBehavior> routeTraversalEdgeBehavior, Optional<TraversalEdgeBehavior> routeDirectionalTraversalEdgeBehavior) {
    throw new UnsupportedOperationException("navigatorNavigator has no default (FFM/comm impl required)");
  }
  default <T extends NativeObj> int navigatorPushNamed(BuildContext context, String routeName, Optional<NativeObj> arguments) {
    throw new UnsupportedOperationException("navigatorPushNamed has no default (FFM/comm impl required)");
  }
  default String navigatorRestorablePushNamed(BuildContext context, String routeName, Optional<NativeObj> arguments) {
    throw new UnsupportedOperationException("navigatorRestorablePushNamed has no default (FFM/comm impl required)");
  }
  default <TO extends NativeObj, T extends NativeObj> int navigatorPushReplacementNamed(BuildContext context, String routeName, Optional<NativeObj> result, Optional<NativeObj> arguments) {
    throw new UnsupportedOperationException("navigatorPushReplacementNamed has no default (FFM/comm impl required)");
  }
  default <TO extends NativeObj> String navigatorRestorablePushReplacementNamed(BuildContext context, String routeName, Optional<NativeObj> result, Optional<NativeObj> arguments) {
    throw new UnsupportedOperationException("navigatorRestorablePushReplacementNamed has no default (FFM/comm impl required)");
  }
  default <TO extends NativeObj, T extends NativeObj> int navigatorPopAndPushNamed(BuildContext context, String routeName, Optional<NativeObj> result, Optional<NativeObj> arguments) {
    throw new UnsupportedOperationException("navigatorPopAndPushNamed has no default (FFM/comm impl required)");
  }
  default <TO extends NativeObj> String navigatorRestorablePopAndPushNamed(BuildContext context, String routeName, Optional<NativeObj> result, Optional<NativeObj> arguments) {
    throw new UnsupportedOperationException("navigatorRestorablePopAndPushNamed has no default (FFM/comm impl required)");
  }
  default int navigatorCanPop(BuildContext context) {
    throw new UnsupportedOperationException("navigatorCanPop has no default (FFM/comm impl required)");
  }
  default <T extends NativeObj> int navigatorMaybePop(BuildContext context, Optional<NativeObj> result) {
    throw new UnsupportedOperationException("navigatorMaybePop has no default (FFM/comm impl required)");
  }
  default <T extends NativeObj> void navigatorPop(BuildContext context, Optional<NativeObj> result) {
    throw new UnsupportedOperationException("navigatorPop has no default (FFM/comm impl required)");
  }
  default int navigatorOf(BuildContext context, Optional<Boolean> rootNavigator) {
    throw new UnsupportedOperationException("navigatorOf has no default (FFM/comm impl required)");
  }
  default int navigatorMaybeOf(BuildContext context, Optional<Boolean> rootNavigator) {
    throw new UnsupportedOperationException("navigatorMaybeOf has no default (FFM/comm impl required)");
  }
  default String Navigator_readBack_initialRoute(Object st) {
    throw new UnsupportedOperationException("Navigator_readBack_initialRoute read-back requires FFM/java22");
  }
  default String Navigator_readBack_restorationScopeId(Object st) {
    throw new UnsupportedOperationException("Navigator_readBack_restorationScopeId read-back requires FFM/java22");
  }
  default TraversalEdgeBehavior Navigator_readBack_routeTraversalEdgeBehavior(Object st) {
    throw new UnsupportedOperationException("Navigator_readBack_routeTraversalEdgeBehavior read-back requires FFM/java22");
  }
  default TraversalEdgeBehavior Navigator_readBack_routeDirectionalTraversalEdgeBehavior(Object st) {
    throw new UnsupportedOperationException("Navigator_readBack_routeDirectionalTraversalEdgeBehavior read-back requires FFM/java22");
  }
  default boolean Navigator_readBack_reportsRouteUpdateToEngine(Object st) {
    throw new UnsupportedOperationException("Navigator_readBack_reportsRouteUpdateToEngine read-back requires FFM/java22");
  }
  default Clip Navigator_readBack_clipBehavior(Object st) {
    throw new UnsupportedOperationException("Navigator_readBack_clipBehavior read-back requires FFM/java22");
  }
  default boolean Navigator_readBack_requestFocus(Object st) {
    throw new UnsupportedOperationException("Navigator_readBack_requestFocus read-back requires FFM/java22");
  }

  default int alertDialogAlertDialog(Optional<Widget> icon, Optional<EdgeInsetsGeometry> iconPadding, Optional<Color> iconColor, Optional<Widget> title, Optional<EdgeInsetsGeometry> titlePadding, Optional<TextStyle> titleTextStyle, Optional<Widget> content, Optional<EdgeInsetsGeometry> contentPadding, Optional<TextStyle> contentTextStyle, Optional<List<Widget>> actions, Optional<EdgeInsetsGeometry> actionsPadding, Optional<MainAxisAlignment> actionsAlignment, Optional<OverflowBarAlignment> actionsOverflowAlignment, Optional<VerticalDirection> actionsOverflowDirection, OptionalDouble actionsOverflowButtonSpacing, Optional<EdgeInsetsGeometry> buttonPadding, Optional<Color> backgroundColor, OptionalDouble elevation, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, Optional<String> semanticLabel, Optional<EdgeInsets> insetPadding, Optional<Clip> clipBehavior, Optional<ShapeBorder> shape, Optional<AlignmentGeometry> alignment, Optional<BoxConstraints> constraints, Optional<Boolean> scrollable) {
    throw new UnsupportedOperationException("alertDialogAlertDialog has no default (FFM/comm impl required)");
  }
  default int alertDialogAdaptive(Optional<Widget> icon, Optional<EdgeInsetsGeometry> iconPadding, Optional<Color> iconColor, Optional<Widget> title, Optional<EdgeInsetsGeometry> titlePadding, Optional<TextStyle> titleTextStyle, Optional<Widget> content, Optional<EdgeInsetsGeometry> contentPadding, Optional<TextStyle> contentTextStyle, Optional<List<Widget>> actions, Optional<EdgeInsetsGeometry> actionsPadding, Optional<MainAxisAlignment> actionsAlignment, Optional<OverflowBarAlignment> actionsOverflowAlignment, Optional<VerticalDirection> actionsOverflowDirection, OptionalDouble actionsOverflowButtonSpacing, Optional<EdgeInsetsGeometry> buttonPadding, Optional<Color> backgroundColor, OptionalDouble elevation, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, Optional<String> semanticLabel, Optional<EdgeInsets> insetPadding, Optional<Clip> clipBehavior, Optional<ShapeBorder> shape, Optional<AlignmentGeometry> alignment, Optional<BoxConstraints> constraints, Optional<Boolean> scrollable, Optional<Duration> insetAnimationDuration, Optional<Curve> insetAnimationCurve) {
    throw new UnsupportedOperationException("alertDialogAdaptive has no default (FFM/comm impl required)");
  }
  default Widget AlertDialog_readBack_icon(Object st) {
    throw new UnsupportedOperationException("AlertDialog_readBack_icon read-back requires FFM/java22");
  }
  default Color AlertDialog_readBack_iconColor(Object st) {
    throw new UnsupportedOperationException("AlertDialog_readBack_iconColor read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry AlertDialog_readBack_iconPadding(Object st) {
    throw new UnsupportedOperationException("AlertDialog_readBack_iconPadding read-back requires FFM/java22");
  }
  default Widget AlertDialog_readBack_title(Object st) {
    throw new UnsupportedOperationException("AlertDialog_readBack_title read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry AlertDialog_readBack_titlePadding(Object st) {
    throw new UnsupportedOperationException("AlertDialog_readBack_titlePadding read-back requires FFM/java22");
  }
  default TextStyle AlertDialog_readBack_titleTextStyle(Object st) {
    throw new UnsupportedOperationException("AlertDialog_readBack_titleTextStyle read-back requires FFM/java22");
  }
  default Widget AlertDialog_readBack_content(Object st) {
    throw new UnsupportedOperationException("AlertDialog_readBack_content read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry AlertDialog_readBack_contentPadding(Object st) {
    throw new UnsupportedOperationException("AlertDialog_readBack_contentPadding read-back requires FFM/java22");
  }
  default TextStyle AlertDialog_readBack_contentTextStyle(Object st) {
    throw new UnsupportedOperationException("AlertDialog_readBack_contentTextStyle read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry AlertDialog_readBack_actionsPadding(Object st) {
    throw new UnsupportedOperationException("AlertDialog_readBack_actionsPadding read-back requires FFM/java22");
  }
  default MainAxisAlignment AlertDialog_readBack_actionsAlignment(Object st) {
    throw new UnsupportedOperationException("AlertDialog_readBack_actionsAlignment read-back requires FFM/java22");
  }
  default OverflowBarAlignment AlertDialog_readBack_actionsOverflowAlignment(Object st) {
    throw new UnsupportedOperationException("AlertDialog_readBack_actionsOverflowAlignment read-back requires FFM/java22");
  }
  default VerticalDirection AlertDialog_readBack_actionsOverflowDirection(Object st) {
    throw new UnsupportedOperationException("AlertDialog_readBack_actionsOverflowDirection read-back requires FFM/java22");
  }
  default double AlertDialog_readBack_actionsOverflowButtonSpacing(Object st) {
    throw new UnsupportedOperationException("AlertDialog_readBack_actionsOverflowButtonSpacing read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry AlertDialog_readBack_buttonPadding(Object st) {
    throw new UnsupportedOperationException("AlertDialog_readBack_buttonPadding read-back requires FFM/java22");
  }
  default Color AlertDialog_readBack_backgroundColor(Object st) {
    throw new UnsupportedOperationException("AlertDialog_readBack_backgroundColor read-back requires FFM/java22");
  }
  default double AlertDialog_readBack_elevation(Object st) {
    throw new UnsupportedOperationException("AlertDialog_readBack_elevation read-back requires FFM/java22");
  }
  default Color AlertDialog_readBack_shadowColor(Object st) {
    throw new UnsupportedOperationException("AlertDialog_readBack_shadowColor read-back requires FFM/java22");
  }
  default Color AlertDialog_readBack_surfaceTintColor(Object st) {
    throw new UnsupportedOperationException("AlertDialog_readBack_surfaceTintColor read-back requires FFM/java22");
  }
  default String AlertDialog_readBack_semanticLabel(Object st) {
    throw new UnsupportedOperationException("AlertDialog_readBack_semanticLabel read-back requires FFM/java22");
  }
  default EdgeInsets AlertDialog_readBack_insetPadding(Object st) {
    throw new UnsupportedOperationException("AlertDialog_readBack_insetPadding read-back requires FFM/java22");
  }
  default Clip AlertDialog_readBack_clipBehavior(Object st) {
    throw new UnsupportedOperationException("AlertDialog_readBack_clipBehavior read-back requires FFM/java22");
  }
  default ShapeBorder AlertDialog_readBack_shape(Object st) {
    throw new UnsupportedOperationException("AlertDialog_readBack_shape read-back requires FFM/java22");
  }
  default AlignmentGeometry AlertDialog_readBack_alignment(Object st) {
    throw new UnsupportedOperationException("AlertDialog_readBack_alignment read-back requires FFM/java22");
  }
  default BoxConstraints AlertDialog_readBack_constraints(Object st) {
    throw new UnsupportedOperationException("AlertDialog_readBack_constraints read-back requires FFM/java22");
  }
  default boolean AlertDialog_readBack_scrollable(Object st) {
    throw new UnsupportedOperationException("AlertDialog_readBack_scrollable read-back requires FFM/java22");
  }

  default int textFieldTextField(Optional<NativeObj> groupId, Optional<InputDecoration> decoration, Optional<TextInputAction> textInputAction, Optional<TextCapitalization> textCapitalization, Optional<TextStyle> style, Optional<TextAlign> textAlign, Optional<TextDirection> textDirection, Optional<Boolean> readOnly, Optional<Boolean> showCursor, Optional<Boolean> autofocus, Optional<String> obscuringCharacter, Optional<Boolean> obscureText, Optional<Boolean> autocorrect, Optional<SmartDashesType> smartDashesType, Optional<SmartQuotesType> smartQuotesType, Optional<Boolean> enableSuggestions, OptionalInt maxLines, OptionalInt minLines, Optional<Boolean> expands, OptionalInt maxLength, Optional<MaxLengthEnforcement> maxLengthEnforcement, Optional<Consumer<String>> onChanged, Optional<Runnable> onEditingComplete, Optional<Consumer<String>> onSubmitted, Optional<Boolean> enabled, Optional<Boolean> ignorePointers, OptionalDouble cursorWidth, OptionalDouble cursorHeight, Optional<Radius> cursorRadius, Optional<Boolean> cursorOpacityAnimates, Optional<Color> cursorColor, Optional<Color> cursorErrorColor, Optional<BoxHeightStyle> selectionHeightStyle, Optional<BoxWidthStyle> selectionWidthStyle, Optional<Brightness> keyboardAppearance, Optional<EdgeInsets> scrollPadding, Optional<DragStartBehavior> dragStartBehavior, Optional<Boolean> enableInteractiveSelection, Optional<Boolean> selectAllOnFocus, Optional<Runnable> onTap, Optional<Boolean> onTapAlwaysCalled, Optional<Consumer<PointerDownEvent>> onTapOutside, Optional<Consumer<PointerUpEvent>> onTapUpOutside, Optional<QuadFunction<BuildContext, Integer, Boolean, Integer, Widget>> buildCounter, Optional<List<String>> autofillHints, Optional<Clip> clipBehavior, Optional<String> restorationId, Optional<Boolean> scribbleEnabled, Optional<Boolean> stylusHandwritingEnabled, Optional<Boolean> enableIMEPersonalizedLearning, Optional<Boolean> enableInlinePrediction, Optional<Boolean> canRequestFocus) {
    throw new UnsupportedOperationException("textFieldTextField has no default (FFM/comm impl required)");
  }
  default InputDecoration TextField_readBack_decoration(Object st) {
    throw new UnsupportedOperationException("TextField_readBack_decoration read-back requires FFM/java22");
  }
  default TextInputAction TextField_readBack_textInputAction(Object st) {
    throw new UnsupportedOperationException("TextField_readBack_textInputAction read-back requires FFM/java22");
  }
  default TextCapitalization TextField_readBack_textCapitalization(Object st) {
    throw new UnsupportedOperationException("TextField_readBack_textCapitalization read-back requires FFM/java22");
  }
  default TextStyle TextField_readBack_style(Object st) {
    throw new UnsupportedOperationException("TextField_readBack_style read-back requires FFM/java22");
  }
  default TextAlign TextField_readBack_textAlign(Object st) {
    throw new UnsupportedOperationException("TextField_readBack_textAlign read-back requires FFM/java22");
  }
  default TextDirection TextField_readBack_textDirection(Object st) {
    throw new UnsupportedOperationException("TextField_readBack_textDirection read-back requires FFM/java22");
  }
  default boolean TextField_readBack_autofocus(Object st) {
    throw new UnsupportedOperationException("TextField_readBack_autofocus read-back requires FFM/java22");
  }
  default String TextField_readBack_obscuringCharacter(Object st) {
    throw new UnsupportedOperationException("TextField_readBack_obscuringCharacter read-back requires FFM/java22");
  }
  default boolean TextField_readBack_obscureText(Object st) {
    throw new UnsupportedOperationException("TextField_readBack_obscureText read-back requires FFM/java22");
  }
  default boolean TextField_readBack_autocorrect(Object st) {
    throw new UnsupportedOperationException("TextField_readBack_autocorrect read-back requires FFM/java22");
  }
  default SmartDashesType TextField_readBack_smartDashesType(Object st) {
    throw new UnsupportedOperationException("TextField_readBack_smartDashesType read-back requires FFM/java22");
  }
  default SmartQuotesType TextField_readBack_smartQuotesType(Object st) {
    throw new UnsupportedOperationException("TextField_readBack_smartQuotesType read-back requires FFM/java22");
  }
  default boolean TextField_readBack_enableSuggestions(Object st) {
    throw new UnsupportedOperationException("TextField_readBack_enableSuggestions read-back requires FFM/java22");
  }
  default int TextField_readBack_maxLines(Object st) {
    throw new UnsupportedOperationException("TextField_readBack_maxLines read-back requires FFM/java22");
  }
  default int TextField_readBack_minLines(Object st) {
    throw new UnsupportedOperationException("TextField_readBack_minLines read-back requires FFM/java22");
  }
  default boolean TextField_readBack_expands(Object st) {
    throw new UnsupportedOperationException("TextField_readBack_expands read-back requires FFM/java22");
  }
  default boolean TextField_readBack_readOnly(Object st) {
    throw new UnsupportedOperationException("TextField_readBack_readOnly read-back requires FFM/java22");
  }
  default boolean TextField_readBack_showCursor(Object st) {
    throw new UnsupportedOperationException("TextField_readBack_showCursor read-back requires FFM/java22");
  }
  default int TextField_readBack_maxLength(Object st) {
    throw new UnsupportedOperationException("TextField_readBack_maxLength read-back requires FFM/java22");
  }
  default MaxLengthEnforcement TextField_readBack_maxLengthEnforcement(Object st) {
    throw new UnsupportedOperationException("TextField_readBack_maxLengthEnforcement read-back requires FFM/java22");
  }
  default boolean TextField_readBack_enabled(Object st) {
    throw new UnsupportedOperationException("TextField_readBack_enabled read-back requires FFM/java22");
  }
  default boolean TextField_readBack_ignorePointers(Object st) {
    throw new UnsupportedOperationException("TextField_readBack_ignorePointers read-back requires FFM/java22");
  }
  default double TextField_readBack_cursorWidth(Object st) {
    throw new UnsupportedOperationException("TextField_readBack_cursorWidth read-back requires FFM/java22");
  }
  default double TextField_readBack_cursorHeight(Object st) {
    throw new UnsupportedOperationException("TextField_readBack_cursorHeight read-back requires FFM/java22");
  }
  default Radius TextField_readBack_cursorRadius(Object st) {
    throw new UnsupportedOperationException("TextField_readBack_cursorRadius read-back requires FFM/java22");
  }
  default boolean TextField_readBack_cursorOpacityAnimates(Object st) {
    throw new UnsupportedOperationException("TextField_readBack_cursorOpacityAnimates read-back requires FFM/java22");
  }
  default Color TextField_readBack_cursorColor(Object st) {
    throw new UnsupportedOperationException("TextField_readBack_cursorColor read-back requires FFM/java22");
  }
  default Color TextField_readBack_cursorErrorColor(Object st) {
    throw new UnsupportedOperationException("TextField_readBack_cursorErrorColor read-back requires FFM/java22");
  }
  default BoxHeightStyle TextField_readBack_selectionHeightStyle(Object st) {
    throw new UnsupportedOperationException("TextField_readBack_selectionHeightStyle read-back requires FFM/java22");
  }
  default BoxWidthStyle TextField_readBack_selectionWidthStyle(Object st) {
    throw new UnsupportedOperationException("TextField_readBack_selectionWidthStyle read-back requires FFM/java22");
  }
  default Brightness TextField_readBack_keyboardAppearance(Object st) {
    throw new UnsupportedOperationException("TextField_readBack_keyboardAppearance read-back requires FFM/java22");
  }
  default EdgeInsets TextField_readBack_scrollPadding(Object st) {
    throw new UnsupportedOperationException("TextField_readBack_scrollPadding read-back requires FFM/java22");
  }
  default boolean TextField_readBack_enableInteractiveSelection(Object st) {
    throw new UnsupportedOperationException("TextField_readBack_enableInteractiveSelection read-back requires FFM/java22");
  }
  default boolean TextField_readBack_selectAllOnFocus(Object st) {
    throw new UnsupportedOperationException("TextField_readBack_selectAllOnFocus read-back requires FFM/java22");
  }
  default DragStartBehavior TextField_readBack_dragStartBehavior(Object st) {
    throw new UnsupportedOperationException("TextField_readBack_dragStartBehavior read-back requires FFM/java22");
  }
  default boolean TextField_readBack_onTapAlwaysCalled(Object st) {
    throw new UnsupportedOperationException("TextField_readBack_onTapAlwaysCalled read-back requires FFM/java22");
  }
  default Clip TextField_readBack_clipBehavior(Object st) {
    throw new UnsupportedOperationException("TextField_readBack_clipBehavior read-back requires FFM/java22");
  }
  default String TextField_readBack_restorationId(Object st) {
    throw new UnsupportedOperationException("TextField_readBack_restorationId read-back requires FFM/java22");
  }
  default boolean TextField_readBack_scribbleEnabled(Object st) {
    throw new UnsupportedOperationException("TextField_readBack_scribbleEnabled read-back requires FFM/java22");
  }
  default boolean TextField_readBack_stylusHandwritingEnabled(Object st) {
    throw new UnsupportedOperationException("TextField_readBack_stylusHandwritingEnabled read-back requires FFM/java22");
  }
  default boolean TextField_readBack_enableIMEPersonalizedLearning(Object st) {
    throw new UnsupportedOperationException("TextField_readBack_enableIMEPersonalizedLearning read-back requires FFM/java22");
  }
  default boolean TextField_readBack_enableInlinePrediction(Object st) {
    throw new UnsupportedOperationException("TextField_readBack_enableInlinePrediction read-back requires FFM/java22");
  }
  default boolean TextField_readBack_canRequestFocus(Object st) {
    throw new UnsupportedOperationException("TextField_readBack_canRequestFocus read-back requires FFM/java22");
  }
  default boolean TextField_readBack_selectionEnabled(Object st) {
    throw new UnsupportedOperationException("TextField_readBack_selectionEnabled read-back requires FFM/java22");
  }

  default int dividerDivider(OptionalDouble height, OptionalDouble thickness, OptionalDouble indent, OptionalDouble endIndent, Optional<Color> color, Optional<BorderRadiusGeometry> radius) {
    throw new UnsupportedOperationException("dividerDivider has no default (FFM/comm impl required)");
  }
  default int dividerCreateBorderSide(BuildContext context, Optional<Color> color, OptionalDouble width) {
    throw new UnsupportedOperationException("dividerCreateBorderSide has no default (FFM/comm impl required)");
  }
  default double Divider_readBack_height(Object st) {
    throw new UnsupportedOperationException("Divider_readBack_height read-back requires FFM/java22");
  }
  default double Divider_readBack_thickness(Object st) {
    throw new UnsupportedOperationException("Divider_readBack_thickness read-back requires FFM/java22");
  }
  default double Divider_readBack_indent(Object st) {
    throw new UnsupportedOperationException("Divider_readBack_indent read-back requires FFM/java22");
  }
  default double Divider_readBack_endIndent(Object st) {
    throw new UnsupportedOperationException("Divider_readBack_endIndent read-back requires FFM/java22");
  }
  default BorderRadiusGeometry Divider_readBack_radius(Object st) {
    throw new UnsupportedOperationException("Divider_readBack_radius read-back requires FFM/java22");
  }
  default Color Divider_readBack_color(Object st) {
    throw new UnsupportedOperationException("Divider_readBack_color read-back requires FFM/java22");
  }

  default int filledButtonFilledButton(Optional<Runnable> onPressed, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Clip> clipBehavior, Optional<Widget> child) {
    throw new UnsupportedOperationException("filledButtonFilledButton has no default (FFM/comm impl required)");
  }
  default int filledButtonIcon(Optional<Runnable> onPressed, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Clip> clipBehavior, Optional<Widget> icon, Widget label, Optional<IconAlignment> iconAlignment) {
    throw new UnsupportedOperationException("filledButtonIcon has no default (FFM/comm impl required)");
  }
  default int filledButtonTonal(Optional<Runnable> onPressed, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Clip> clipBehavior, Optional<Widget> child) {
    throw new UnsupportedOperationException("filledButtonTonal has no default (FFM/comm impl required)");
  }
  default int filledButtonTonalIcon(Optional<Runnable> onPressed, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Clip> clipBehavior, Optional<Widget> icon, Widget label, Optional<IconAlignment> iconAlignment) {
    throw new UnsupportedOperationException("filledButtonTonalIcon has no default (FFM/comm impl required)");
  }

  default int outlineInputBorderOutlineInputBorder(Optional<BorderSide> borderSide, Optional<BorderRadius> borderRadius, OptionalDouble gapPadding) {
    throw new UnsupportedOperationException("outlineInputBorderOutlineInputBorder has no default (FFM/comm impl required)");
  }
  default double OutlineInputBorder_readBack_gapPadding(Object st) {
    throw new UnsupportedOperationException("OutlineInputBorder_readBack_gapPadding read-back requires FFM/java22");
  }
  default BorderRadius OutlineInputBorder_readBack_borderRadius(Object st) {
    throw new UnsupportedOperationException("OutlineInputBorder_readBack_borderRadius read-back requires FFM/java22");
  }

  default int snackBarActionSnackBarAction(Optional<Color> textColor, Optional<Color> disabledTextColor, Optional<Color> backgroundColor, Optional<Color> disabledBackgroundColor, String label, Runnable onPressed) {
    throw new UnsupportedOperationException("snackBarActionSnackBarAction has no default (FFM/comm impl required)");
  }
  default Color SnackBarAction_readBack_textColor(Object st) {
    throw new UnsupportedOperationException("SnackBarAction_readBack_textColor read-back requires FFM/java22");
  }
  default Color SnackBarAction_readBack_backgroundColor(Object st) {
    throw new UnsupportedOperationException("SnackBarAction_readBack_backgroundColor read-back requires FFM/java22");
  }
  default Color SnackBarAction_readBack_disabledTextColor(Object st) {
    throw new UnsupportedOperationException("SnackBarAction_readBack_disabledTextColor read-back requires FFM/java22");
  }
  default Color SnackBarAction_readBack_disabledBackgroundColor(Object st) {
    throw new UnsupportedOperationException("SnackBarAction_readBack_disabledBackgroundColor read-back requires FFM/java22");
  }
  default String SnackBarAction_readBack_label(Object st) {
    throw new UnsupportedOperationException("SnackBarAction_readBack_label read-back requires FFM/java22");
  }

  default int snackBarSnackBar(Widget content, Optional<Color> backgroundColor, OptionalDouble elevation, Optional<EdgeInsetsGeometry> margin, Optional<EdgeInsetsGeometry> padding, OptionalDouble width, Optional<ShapeBorder> shape, Optional<HitTestBehavior> hitTestBehavior, Optional<SnackBarBehavior> behavior, Optional<SnackBarAction> action, OptionalDouble actionOverflowThreshold, Optional<Boolean> showCloseIcon, Optional<Color> closeIconColor, Optional<Duration> duration, Optional<Boolean> persist, Optional<Animation> animation, Optional<Runnable> onVisible, Optional<DismissDirection> dismissDirection, Optional<Clip> clipBehavior) {
    throw new UnsupportedOperationException("snackBarSnackBar has no default (FFM/comm impl required)");
  }
  default int snackBarCreateAnimationController(TickerProvider vsync, Optional<Duration> duration, Optional<Duration> reverseDuration) {
    throw new UnsupportedOperationException("snackBarCreateAnimationController has no default (FFM/comm impl required)");
  }
  default Widget SnackBar_readBack_content(Object st) {
    throw new UnsupportedOperationException("SnackBar_readBack_content read-back requires FFM/java22");
  }
  default Color SnackBar_readBack_backgroundColor(Object st) {
    throw new UnsupportedOperationException("SnackBar_readBack_backgroundColor read-back requires FFM/java22");
  }
  default double SnackBar_readBack_elevation(Object st) {
    throw new UnsupportedOperationException("SnackBar_readBack_elevation read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry SnackBar_readBack_margin(Object st) {
    throw new UnsupportedOperationException("SnackBar_readBack_margin read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry SnackBar_readBack_padding(Object st) {
    throw new UnsupportedOperationException("SnackBar_readBack_padding read-back requires FFM/java22");
  }
  default double SnackBar_readBack_width(Object st) {
    throw new UnsupportedOperationException("SnackBar_readBack_width read-back requires FFM/java22");
  }
  default ShapeBorder SnackBar_readBack_shape(Object st) {
    throw new UnsupportedOperationException("SnackBar_readBack_shape read-back requires FFM/java22");
  }
  default HitTestBehavior SnackBar_readBack_hitTestBehavior(Object st) {
    throw new UnsupportedOperationException("SnackBar_readBack_hitTestBehavior read-back requires FFM/java22");
  }
  default SnackBarBehavior SnackBar_readBack_behavior(Object st) {
    throw new UnsupportedOperationException("SnackBar_readBack_behavior read-back requires FFM/java22");
  }
  default SnackBarAction SnackBar_readBack_action(Object st) {
    throw new UnsupportedOperationException("SnackBar_readBack_action read-back requires FFM/java22");
  }
  default double SnackBar_readBack_actionOverflowThreshold(Object st) {
    throw new UnsupportedOperationException("SnackBar_readBack_actionOverflowThreshold read-back requires FFM/java22");
  }
  default boolean SnackBar_readBack_showCloseIcon(Object st) {
    throw new UnsupportedOperationException("SnackBar_readBack_showCloseIcon read-back requires FFM/java22");
  }
  default Color SnackBar_readBack_closeIconColor(Object st) {
    throw new UnsupportedOperationException("SnackBar_readBack_closeIconColor read-back requires FFM/java22");
  }
  default Duration SnackBar_readBack_duration(Object st) {
    throw new UnsupportedOperationException("SnackBar_readBack_duration read-back requires FFM/java22");
  }
  default boolean SnackBar_readBack_persist(Object st) {
    throw new UnsupportedOperationException("SnackBar_readBack_persist read-back requires FFM/java22");
  }
  default Animation SnackBar_readBack_animation(Object st) {
    throw new UnsupportedOperationException("SnackBar_readBack_animation read-back requires FFM/java22");
  }
  default DismissDirection SnackBar_readBack_dismissDirection(Object st) {
    throw new UnsupportedOperationException("SnackBar_readBack_dismissDirection read-back requires FFM/java22");
  }
  default Clip SnackBar_readBack_clipBehavior(Object st) {
    throw new UnsupportedOperationException("SnackBar_readBack_clipBehavior read-back requires FFM/java22");
  }

  default int scaffoldMessengerScaffoldMessenger(Widget child) {
    throw new UnsupportedOperationException("scaffoldMessengerScaffoldMessenger has no default (FFM/comm impl required)");
  }
  default void scaffoldMessengerShowSnackBar(BuildContext context, SnackBar snackBar) {
    throw new UnsupportedOperationException("scaffoldMessengerShowSnackBar has no default (FFM/comm impl required)");
  }
  default void scaffoldMessengerRemoveCurrentSnackBar(BuildContext context, Optional<SnackBarClosedReason> reason) {
    throw new UnsupportedOperationException("scaffoldMessengerRemoveCurrentSnackBar has no default (FFM/comm impl required)");
  }
  default void scaffoldMessengerHideCurrentSnackBar(BuildContext context, Optional<SnackBarClosedReason> reason) {
    throw new UnsupportedOperationException("scaffoldMessengerHideCurrentSnackBar has no default (FFM/comm impl required)");
  }
  default void scaffoldMessengerClearSnackBars(BuildContext context) {
    throw new UnsupportedOperationException("scaffoldMessengerClearSnackBars has no default (FFM/comm impl required)");
  }
  default void scaffoldMessengerShowMaterialBanner(BuildContext context, MaterialBanner materialBanner) {
    throw new UnsupportedOperationException("scaffoldMessengerShowMaterialBanner has no default (FFM/comm impl required)");
  }
  default void scaffoldMessengerRemoveCurrentMaterialBanner(BuildContext context, Optional<MaterialBannerClosedReason> reason) {
    throw new UnsupportedOperationException("scaffoldMessengerRemoveCurrentMaterialBanner has no default (FFM/comm impl required)");
  }
  default void scaffoldMessengerHideCurrentMaterialBanner(BuildContext context, Optional<MaterialBannerClosedReason> reason) {
    throw new UnsupportedOperationException("scaffoldMessengerHideCurrentMaterialBanner has no default (FFM/comm impl required)");
  }
  default void scaffoldMessengerClearMaterialBanners(BuildContext context) {
    throw new UnsupportedOperationException("scaffoldMessengerClearMaterialBanners has no default (FFM/comm impl required)");
  }
  default Widget ScaffoldMessenger_readBack_child(Object st) {
    throw new UnsupportedOperationException("ScaffoldMessenger_readBack_child read-back requires FFM/java22");
  }

  default int cardCard(Optional<Color> color, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, OptionalDouble elevation, Optional<ShapeBorder> shape, Optional<Boolean> borderOnForeground, Optional<EdgeInsetsGeometry> margin, Optional<Clip> clipBehavior, Optional<Widget> child, Optional<Boolean> semanticContainer) {
    throw new UnsupportedOperationException("cardCard has no default (FFM/comm impl required)");
  }
  default int cardFilled(Optional<Color> color, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, OptionalDouble elevation, Optional<ShapeBorder> shape, Optional<Boolean> borderOnForeground, Optional<EdgeInsetsGeometry> margin, Optional<Clip> clipBehavior, Optional<Widget> child, Optional<Boolean> semanticContainer) {
    throw new UnsupportedOperationException("cardFilled has no default (FFM/comm impl required)");
  }
  default int cardOutlined(Optional<Color> color, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, OptionalDouble elevation, Optional<ShapeBorder> shape, Optional<Boolean> borderOnForeground, Optional<EdgeInsetsGeometry> margin, Optional<Clip> clipBehavior, Optional<Widget> child, Optional<Boolean> semanticContainer) {
    throw new UnsupportedOperationException("cardOutlined has no default (FFM/comm impl required)");
  }
  default Color Card_readBack_color(Object st) {
    throw new UnsupportedOperationException("Card_readBack_color read-back requires FFM/java22");
  }
  default Color Card_readBack_shadowColor(Object st) {
    throw new UnsupportedOperationException("Card_readBack_shadowColor read-back requires FFM/java22");
  }
  default Color Card_readBack_surfaceTintColor(Object st) {
    throw new UnsupportedOperationException("Card_readBack_surfaceTintColor read-back requires FFM/java22");
  }
  default double Card_readBack_elevation(Object st) {
    throw new UnsupportedOperationException("Card_readBack_elevation read-back requires FFM/java22");
  }
  default ShapeBorder Card_readBack_shape(Object st) {
    throw new UnsupportedOperationException("Card_readBack_shape read-back requires FFM/java22");
  }
  default boolean Card_readBack_borderOnForeground(Object st) {
    throw new UnsupportedOperationException("Card_readBack_borderOnForeground read-back requires FFM/java22");
  }
  default Clip Card_readBack_clipBehavior(Object st) {
    throw new UnsupportedOperationException("Card_readBack_clipBehavior read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry Card_readBack_margin(Object st) {
    throw new UnsupportedOperationException("Card_readBack_margin read-back requires FFM/java22");
  }
  default boolean Card_readBack_semanticContainer(Object st) {
    throw new UnsupportedOperationException("Card_readBack_semanticContainer read-back requires FFM/java22");
  }
  default Widget Card_readBack_child(Object st) {
    throw new UnsupportedOperationException("Card_readBack_child read-back requires FFM/java22");
  }

  default int chipChip(Optional<Widget> avatar, Widget label, Optional<TextStyle> labelStyle, Optional<EdgeInsetsGeometry> labelPadding, Optional<Widget> deleteIcon, Optional<Runnable> onDeleted, Optional<Color> deleteIconColor, Optional<String> deleteButtonTooltipMessage, Optional<BorderSide> side, Optional<OutlinedBorder> shape, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, Optional<Color> color, Optional<Color> backgroundColor, Optional<EdgeInsetsGeometry> padding, Optional<VisualDensity> visualDensity, Optional<MaterialTapTargetSize> materialTapTargetSize, OptionalDouble elevation, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, Optional<IconThemeData> iconTheme, Optional<BoxConstraints> avatarBoxConstraints, Optional<BoxConstraints> deleteIconBoxConstraints) {
    throw new UnsupportedOperationException("chipChip has no default (FFM/comm impl required)");
  }
  default Widget Chip_readBack_avatar(Object st) {
    throw new UnsupportedOperationException("Chip_readBack_avatar read-back requires FFM/java22");
  }
  default Widget Chip_readBack_label(Object st) {
    throw new UnsupportedOperationException("Chip_readBack_label read-back requires FFM/java22");
  }
  default TextStyle Chip_readBack_labelStyle(Object st) {
    throw new UnsupportedOperationException("Chip_readBack_labelStyle read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry Chip_readBack_labelPadding(Object st) {
    throw new UnsupportedOperationException("Chip_readBack_labelPadding read-back requires FFM/java22");
  }
  default BorderSide Chip_readBack_side(Object st) {
    throw new UnsupportedOperationException("Chip_readBack_side read-back requires FFM/java22");
  }
  default OutlinedBorder Chip_readBack_shape(Object st) {
    throw new UnsupportedOperationException("Chip_readBack_shape read-back requires FFM/java22");
  }
  default Clip Chip_readBack_clipBehavior(Object st) {
    throw new UnsupportedOperationException("Chip_readBack_clipBehavior read-back requires FFM/java22");
  }
  default boolean Chip_readBack_autofocus(Object st) {
    throw new UnsupportedOperationException("Chip_readBack_autofocus read-back requires FFM/java22");
  }
  default Color Chip_readBack_backgroundColor(Object st) {
    throw new UnsupportedOperationException("Chip_readBack_backgroundColor read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry Chip_readBack_padding(Object st) {
    throw new UnsupportedOperationException("Chip_readBack_padding read-back requires FFM/java22");
  }
  default VisualDensity Chip_readBack_visualDensity(Object st) {
    throw new UnsupportedOperationException("Chip_readBack_visualDensity read-back requires FFM/java22");
  }
  default Widget Chip_readBack_deleteIcon(Object st) {
    throw new UnsupportedOperationException("Chip_readBack_deleteIcon read-back requires FFM/java22");
  }
  default Color Chip_readBack_deleteIconColor(Object st) {
    throw new UnsupportedOperationException("Chip_readBack_deleteIconColor read-back requires FFM/java22");
  }
  default String Chip_readBack_deleteButtonTooltipMessage(Object st) {
    throw new UnsupportedOperationException("Chip_readBack_deleteButtonTooltipMessage read-back requires FFM/java22");
  }
  default MaterialTapTargetSize Chip_readBack_materialTapTargetSize(Object st) {
    throw new UnsupportedOperationException("Chip_readBack_materialTapTargetSize read-back requires FFM/java22");
  }
  default double Chip_readBack_elevation(Object st) {
    throw new UnsupportedOperationException("Chip_readBack_elevation read-back requires FFM/java22");
  }
  default Color Chip_readBack_shadowColor(Object st) {
    throw new UnsupportedOperationException("Chip_readBack_shadowColor read-back requires FFM/java22");
  }
  default Color Chip_readBack_surfaceTintColor(Object st) {
    throw new UnsupportedOperationException("Chip_readBack_surfaceTintColor read-back requires FFM/java22");
  }
  default IconThemeData Chip_readBack_iconTheme(Object st) {
    throw new UnsupportedOperationException("Chip_readBack_iconTheme read-back requires FFM/java22");
  }
  default BoxConstraints Chip_readBack_avatarBoxConstraints(Object st) {
    throw new UnsupportedOperationException("Chip_readBack_avatarBoxConstraints read-back requires FFM/java22");
  }
  default BoxConstraints Chip_readBack_deleteIconBoxConstraints(Object st) {
    throw new UnsupportedOperationException("Chip_readBack_deleteIconBoxConstraints read-back requires FFM/java22");
  }

  default int gestureDetectorGestureDetector(Optional<Widget> child, Optional<Consumer<TapDownDetails>> onTapDown, Optional<Consumer<TapUpDetails>> onTapUp, Optional<Runnable> onTap, Optional<Consumer<TapMoveDetails>> onTapMove, Optional<Runnable> onTapCancel, Optional<Runnable> onSecondaryTap, Optional<Consumer<TapDownDetails>> onSecondaryTapDown, Optional<Consumer<TapUpDetails>> onSecondaryTapUp, Optional<Runnable> onSecondaryTapCancel, Optional<Consumer<TapDownDetails>> onTertiaryTapDown, Optional<Consumer<TapUpDetails>> onTertiaryTapUp, Optional<Runnable> onTertiaryTapCancel, Optional<Consumer<TapDownDetails>> onDoubleTapDown, Optional<Runnable> onDoubleTap, Optional<Runnable> onDoubleTapCancel, Optional<Consumer<LongPressDownDetails>> onLongPressDown, Optional<Runnable> onLongPressCancel, Optional<Runnable> onLongPress, Optional<Consumer<LongPressStartDetails>> onLongPressStart, Optional<Consumer<LongPressMoveUpdateDetails>> onLongPressMoveUpdate, Optional<Runnable> onLongPressUp, Optional<Consumer<LongPressEndDetails>> onLongPressEnd, Optional<Consumer<LongPressDownDetails>> onSecondaryLongPressDown, Optional<Runnable> onSecondaryLongPressCancel, Optional<Runnable> onSecondaryLongPress, Optional<Consumer<LongPressStartDetails>> onSecondaryLongPressStart, Optional<Consumer<LongPressMoveUpdateDetails>> onSecondaryLongPressMoveUpdate, Optional<Runnable> onSecondaryLongPressUp, Optional<Consumer<LongPressEndDetails>> onSecondaryLongPressEnd, Optional<Consumer<LongPressDownDetails>> onTertiaryLongPressDown, Optional<Runnable> onTertiaryLongPressCancel, Optional<Runnable> onTertiaryLongPress, Optional<Consumer<LongPressStartDetails>> onTertiaryLongPressStart, Optional<Consumer<LongPressMoveUpdateDetails>> onTertiaryLongPressMoveUpdate, Optional<Runnable> onTertiaryLongPressUp, Optional<Consumer<LongPressEndDetails>> onTertiaryLongPressEnd, Optional<Consumer<DragDownDetails>> onVerticalDragDown, Optional<Consumer<DragStartDetails>> onVerticalDragStart, Optional<Consumer<DragUpdateDetails>> onVerticalDragUpdate, Optional<Consumer<DragEndDetails>> onVerticalDragEnd, Optional<Runnable> onVerticalDragCancel, Optional<Consumer<DragDownDetails>> onHorizontalDragDown, Optional<Consumer<DragStartDetails>> onHorizontalDragStart, Optional<Consumer<DragUpdateDetails>> onHorizontalDragUpdate, Optional<Consumer<DragEndDetails>> onHorizontalDragEnd, Optional<Runnable> onHorizontalDragCancel, Optional<Consumer<ForcePressDetails>> onForcePressStart, Optional<Consumer<ForcePressDetails>> onForcePressPeak, Optional<Consumer<ForcePressDetails>> onForcePressUpdate, Optional<Consumer<ForcePressDetails>> onForcePressEnd, Optional<Consumer<DragDownDetails>> onPanDown, Optional<Consumer<DragStartDetails>> onPanStart, Optional<Consumer<DragUpdateDetails>> onPanUpdate, Optional<Consumer<DragEndDetails>> onPanEnd, Optional<Runnable> onPanCancel, Optional<Consumer<ScaleStartDetails>> onScaleStart, Optional<Consumer<ScaleUpdateDetails>> onScaleUpdate, Optional<Consumer<ScaleEndDetails>> onScaleEnd, Optional<HitTestBehavior> behavior, Optional<Boolean> excludeFromSemantics, Optional<DragStartBehavior> dragStartBehavior, Optional<Boolean> trackpadScrollCausesScale, Optional<Offset> trackpadScrollToScaleFactor) {
    throw new UnsupportedOperationException("gestureDetectorGestureDetector has no default (FFM/comm impl required)");
  }
  default Widget GestureDetector_readBack_child(Object st) {
    throw new UnsupportedOperationException("GestureDetector_readBack_child read-back requires FFM/java22");
  }
  default HitTestBehavior GestureDetector_readBack_behavior(Object st) {
    throw new UnsupportedOperationException("GestureDetector_readBack_behavior read-back requires FFM/java22");
  }
  default boolean GestureDetector_readBack_excludeFromSemantics(Object st) {
    throw new UnsupportedOperationException("GestureDetector_readBack_excludeFromSemantics read-back requires FFM/java22");
  }
  default DragStartBehavior GestureDetector_readBack_dragStartBehavior(Object st) {
    throw new UnsupportedOperationException("GestureDetector_readBack_dragStartBehavior read-back requires FFM/java22");
  }
  default boolean GestureDetector_readBack_trackpadScrollCausesScale(Object st) {
    throw new UnsupportedOperationException("GestureDetector_readBack_trackpadScrollCausesScale read-back requires FFM/java22");
  }
  default Offset GestureDetector_readBack_trackpadScrollToScaleFactor(Object st) {
    throw new UnsupportedOperationException("GestureDetector_readBack_trackpadScrollToScaleFactor read-back requires FFM/java22");
  }

  default int listTileListTile(Optional<Widget> leading, Optional<Widget> title, Optional<Widget> subtitle, Optional<Widget> trailing, Optional<Boolean> isThreeLine, Optional<Boolean> dense, Optional<VisualDensity> visualDensity, Optional<ShapeBorder> shape, Optional<ListTileStyle> style, Optional<Color> selectedColor, Optional<Color> iconColor, Optional<Color> textColor, Optional<TextStyle> titleTextStyle, Optional<TextStyle> subtitleTextStyle, Optional<TextStyle> leadingAndTrailingTextStyle, Optional<EdgeInsetsGeometry> contentPadding, Optional<Boolean> enabled, Optional<Runnable> onTap, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> selected, Optional<Color> focusColor, Optional<Color> hoverColor, Optional<Color> splashColor, Optional<Boolean> autofocus, Optional<Color> tileColor, Optional<Color> selectedTileColor, Optional<Boolean> enableFeedback, OptionalDouble horizontalTitleGap, OptionalDouble minVerticalPadding, OptionalDouble minLeadingWidth, OptionalDouble minTileHeight, Optional<ListTileTitleAlignment> titleAlignment, Optional<Boolean> internalAddSemanticForOnTap) {
    throw new UnsupportedOperationException("listTileListTile has no default (FFM/comm impl required)");
  }
  default Widget ListTile_readBack_leading(Object st) {
    throw new UnsupportedOperationException("ListTile_readBack_leading read-back requires FFM/java22");
  }
  default Widget ListTile_readBack_title(Object st) {
    throw new UnsupportedOperationException("ListTile_readBack_title read-back requires FFM/java22");
  }
  default Widget ListTile_readBack_subtitle(Object st) {
    throw new UnsupportedOperationException("ListTile_readBack_subtitle read-back requires FFM/java22");
  }
  default Widget ListTile_readBack_trailing(Object st) {
    throw new UnsupportedOperationException("ListTile_readBack_trailing read-back requires FFM/java22");
  }
  default boolean ListTile_readBack_isThreeLine(Object st) {
    throw new UnsupportedOperationException("ListTile_readBack_isThreeLine read-back requires FFM/java22");
  }
  default boolean ListTile_readBack_dense(Object st) {
    throw new UnsupportedOperationException("ListTile_readBack_dense read-back requires FFM/java22");
  }
  default VisualDensity ListTile_readBack_visualDensity(Object st) {
    throw new UnsupportedOperationException("ListTile_readBack_visualDensity read-back requires FFM/java22");
  }
  default ShapeBorder ListTile_readBack_shape(Object st) {
    throw new UnsupportedOperationException("ListTile_readBack_shape read-back requires FFM/java22");
  }
  default Color ListTile_readBack_selectedColor(Object st) {
    throw new UnsupportedOperationException("ListTile_readBack_selectedColor read-back requires FFM/java22");
  }
  default Color ListTile_readBack_iconColor(Object st) {
    throw new UnsupportedOperationException("ListTile_readBack_iconColor read-back requires FFM/java22");
  }
  default Color ListTile_readBack_textColor(Object st) {
    throw new UnsupportedOperationException("ListTile_readBack_textColor read-back requires FFM/java22");
  }
  default TextStyle ListTile_readBack_titleTextStyle(Object st) {
    throw new UnsupportedOperationException("ListTile_readBack_titleTextStyle read-back requires FFM/java22");
  }
  default TextStyle ListTile_readBack_subtitleTextStyle(Object st) {
    throw new UnsupportedOperationException("ListTile_readBack_subtitleTextStyle read-back requires FFM/java22");
  }
  default TextStyle ListTile_readBack_leadingAndTrailingTextStyle(Object st) {
    throw new UnsupportedOperationException("ListTile_readBack_leadingAndTrailingTextStyle read-back requires FFM/java22");
  }
  default ListTileStyle ListTile_readBack_style(Object st) {
    throw new UnsupportedOperationException("ListTile_readBack_style read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry ListTile_readBack_contentPadding(Object st) {
    throw new UnsupportedOperationException("ListTile_readBack_contentPadding read-back requires FFM/java22");
  }
  default boolean ListTile_readBack_enabled(Object st) {
    throw new UnsupportedOperationException("ListTile_readBack_enabled read-back requires FFM/java22");
  }
  default boolean ListTile_readBack_selected(Object st) {
    throw new UnsupportedOperationException("ListTile_readBack_selected read-back requires FFM/java22");
  }
  default Color ListTile_readBack_focusColor(Object st) {
    throw new UnsupportedOperationException("ListTile_readBack_focusColor read-back requires FFM/java22");
  }
  default Color ListTile_readBack_hoverColor(Object st) {
    throw new UnsupportedOperationException("ListTile_readBack_hoverColor read-back requires FFM/java22");
  }
  default Color ListTile_readBack_splashColor(Object st) {
    throw new UnsupportedOperationException("ListTile_readBack_splashColor read-back requires FFM/java22");
  }
  default boolean ListTile_readBack_autofocus(Object st) {
    throw new UnsupportedOperationException("ListTile_readBack_autofocus read-back requires FFM/java22");
  }
  default Color ListTile_readBack_tileColor(Object st) {
    throw new UnsupportedOperationException("ListTile_readBack_tileColor read-back requires FFM/java22");
  }
  default Color ListTile_readBack_selectedTileColor(Object st) {
    throw new UnsupportedOperationException("ListTile_readBack_selectedTileColor read-back requires FFM/java22");
  }
  default boolean ListTile_readBack_enableFeedback(Object st) {
    throw new UnsupportedOperationException("ListTile_readBack_enableFeedback read-back requires FFM/java22");
  }
  default double ListTile_readBack_horizontalTitleGap(Object st) {
    throw new UnsupportedOperationException("ListTile_readBack_horizontalTitleGap read-back requires FFM/java22");
  }
  default double ListTile_readBack_minVerticalPadding(Object st) {
    throw new UnsupportedOperationException("ListTile_readBack_minVerticalPadding read-back requires FFM/java22");
  }
  default double ListTile_readBack_minLeadingWidth(Object st) {
    throw new UnsupportedOperationException("ListTile_readBack_minLeadingWidth read-back requires FFM/java22");
  }
  default double ListTile_readBack_minTileHeight(Object st) {
    throw new UnsupportedOperationException("ListTile_readBack_minTileHeight read-back requires FFM/java22");
  }
  default ListTileTitleAlignment ListTile_readBack_titleAlignment(Object st) {
    throw new UnsupportedOperationException("ListTile_readBack_titleAlignment read-back requires FFM/java22");
  }
  default boolean ListTile_readBack_internalAddSemanticForOnTap(Object st) {
    throw new UnsupportedOperationException("ListTile_readBack_internalAddSemanticForOnTap read-back requires FFM/java22");
  }

  default int wrapWrap(Optional<Axis> direction, Optional<WrapAlignment> alignment, OptionalDouble spacing, Optional<WrapAlignment> runAlignment, OptionalDouble runSpacing, Optional<WrapCrossAlignment> crossAxisAlignment, Optional<TextDirection> textDirection, Optional<VerticalDirection> verticalDirection, Optional<Clip> clipBehavior, Optional<List<Widget>> children) {
    throw new UnsupportedOperationException("wrapWrap has no default (FFM/comm impl required)");
  }
  default Axis Wrap_readBack_direction(Object st) {
    throw new UnsupportedOperationException("Wrap_readBack_direction read-back requires FFM/java22");
  }
  default WrapAlignment Wrap_readBack_alignment(Object st) {
    throw new UnsupportedOperationException("Wrap_readBack_alignment read-back requires FFM/java22");
  }
  default double Wrap_readBack_spacing(Object st) {
    throw new UnsupportedOperationException("Wrap_readBack_spacing read-back requires FFM/java22");
  }
  default WrapAlignment Wrap_readBack_runAlignment(Object st) {
    throw new UnsupportedOperationException("Wrap_readBack_runAlignment read-back requires FFM/java22");
  }
  default double Wrap_readBack_runSpacing(Object st) {
    throw new UnsupportedOperationException("Wrap_readBack_runSpacing read-back requires FFM/java22");
  }
  default WrapCrossAlignment Wrap_readBack_crossAxisAlignment(Object st) {
    throw new UnsupportedOperationException("Wrap_readBack_crossAxisAlignment read-back requires FFM/java22");
  }
  default TextDirection Wrap_readBack_textDirection(Object st) {
    throw new UnsupportedOperationException("Wrap_readBack_textDirection read-back requires FFM/java22");
  }
  default VerticalDirection Wrap_readBack_verticalDirection(Object st) {
    throw new UnsupportedOperationException("Wrap_readBack_verticalDirection read-back requires FFM/java22");
  }
  default Clip Wrap_readBack_clipBehavior(Object st) {
    throw new UnsupportedOperationException("Wrap_readBack_clipBehavior read-back requires FFM/java22");
  }

  default int singleChildScrollViewSingleChildScrollView(Optional<Axis> scrollDirection, Optional<Boolean> reverse, Optional<EdgeInsetsGeometry> padding, Optional<Boolean> primary, Optional<Widget> child, Optional<DragStartBehavior> dragStartBehavior, Optional<Clip> clipBehavior, Optional<HitTestBehavior> hitTestBehavior, Optional<String> restorationId, Optional<ScrollViewKeyboardDismissBehavior> keyboardDismissBehavior) {
    throw new UnsupportedOperationException("singleChildScrollViewSingleChildScrollView has no default (FFM/comm impl required)");
  }
  default Axis SingleChildScrollView_readBack_scrollDirection(Object st) {
    throw new UnsupportedOperationException("SingleChildScrollView_readBack_scrollDirection read-back requires FFM/java22");
  }
  default boolean SingleChildScrollView_readBack_reverse(Object st) {
    throw new UnsupportedOperationException("SingleChildScrollView_readBack_reverse read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry SingleChildScrollView_readBack_padding(Object st) {
    throw new UnsupportedOperationException("SingleChildScrollView_readBack_padding read-back requires FFM/java22");
  }
  default boolean SingleChildScrollView_readBack_primary(Object st) {
    throw new UnsupportedOperationException("SingleChildScrollView_readBack_primary read-back requires FFM/java22");
  }
  default Widget SingleChildScrollView_readBack_child(Object st) {
    throw new UnsupportedOperationException("SingleChildScrollView_readBack_child read-back requires FFM/java22");
  }
  default DragStartBehavior SingleChildScrollView_readBack_dragStartBehavior(Object st) {
    throw new UnsupportedOperationException("SingleChildScrollView_readBack_dragStartBehavior read-back requires FFM/java22");
  }
  default Clip SingleChildScrollView_readBack_clipBehavior(Object st) {
    throw new UnsupportedOperationException("SingleChildScrollView_readBack_clipBehavior read-back requires FFM/java22");
  }
  default HitTestBehavior SingleChildScrollView_readBack_hitTestBehavior(Object st) {
    throw new UnsupportedOperationException("SingleChildScrollView_readBack_hitTestBehavior read-back requires FFM/java22");
  }
  default String SingleChildScrollView_readBack_restorationId(Object st) {
    throw new UnsupportedOperationException("SingleChildScrollView_readBack_restorationId read-back requires FFM/java22");
  }
  default ScrollViewKeyboardDismissBehavior SingleChildScrollView_readBack_keyboardDismissBehavior(Object st) {
    throw new UnsupportedOperationException("SingleChildScrollView_readBack_keyboardDismissBehavior read-back requires FFM/java22");
  }

  default int linearProgressIndicatorLinearProgressIndicator(OptionalDouble value, Optional<Color> backgroundColor, Optional<Color> color, Optional<Animation> valueColor, OptionalDouble minHeight, Optional<String> semanticsLabel, Optional<String> semanticsValue, Optional<BorderRadiusGeometry> borderRadius, Optional<Color> stopIndicatorColor, OptionalDouble stopIndicatorRadius, OptionalDouble trackGap, Optional<Boolean> year2023, Optional<AnimationController> controller) {
    throw new UnsupportedOperationException("linearProgressIndicatorLinearProgressIndicator has no default (FFM/comm impl required)");
  }
  default double LinearProgressIndicator_readBack_minHeight(Object st) {
    throw new UnsupportedOperationException("LinearProgressIndicator_readBack_minHeight read-back requires FFM/java22");
  }
  default BorderRadiusGeometry LinearProgressIndicator_readBack_borderRadius(Object st) {
    throw new UnsupportedOperationException("LinearProgressIndicator_readBack_borderRadius read-back requires FFM/java22");
  }
  default Color LinearProgressIndicator_readBack_stopIndicatorColor(Object st) {
    throw new UnsupportedOperationException("LinearProgressIndicator_readBack_stopIndicatorColor read-back requires FFM/java22");
  }
  default double LinearProgressIndicator_readBack_stopIndicatorRadius(Object st) {
    throw new UnsupportedOperationException("LinearProgressIndicator_readBack_stopIndicatorRadius read-back requires FFM/java22");
  }
  default double LinearProgressIndicator_readBack_trackGap(Object st) {
    throw new UnsupportedOperationException("LinearProgressIndicator_readBack_trackGap read-back requires FFM/java22");
  }
  default boolean LinearProgressIndicator_readBack_year2023(Object st) {
    throw new UnsupportedOperationException("LinearProgressIndicator_readBack_year2023 read-back requires FFM/java22");
  }
  default AnimationController LinearProgressIndicator_readBack_controller(Object st) {
    throw new UnsupportedOperationException("LinearProgressIndicator_readBack_controller read-back requires FFM/java22");
  }

  default int checkboxCheckbox(Optional<Boolean> value, Optional<Boolean> tristate, Optional<Consumer<Boolean>> onChanged, Optional<Color> activeColor, Optional<Color> fillColor, Optional<Color> checkColor, Optional<Color> focusColor, Optional<Color> hoverColor, Optional<Color> overlayColor, OptionalDouble splashRadius, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<VisualDensity> visualDensity, Optional<Boolean> autofocus, Optional<OutlinedBorder> shape, Optional<BorderSide> side, Optional<Boolean> isError, Optional<String> semanticLabel) {
    throw new UnsupportedOperationException("checkboxCheckbox has no default (FFM/comm impl required)");
  }
  default int checkboxAdaptive(Optional<Boolean> value, Optional<Boolean> tristate, Optional<Consumer<Boolean>> onChanged, Optional<Color> activeColor, Optional<Color> fillColor, Optional<Color> checkColor, Optional<Color> focusColor, Optional<Color> hoverColor, Optional<Color> overlayColor, OptionalDouble splashRadius, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<VisualDensity> visualDensity, Optional<Boolean> autofocus, Optional<OutlinedBorder> shape, Optional<BorderSide> side, Optional<Boolean> isError, Optional<String> semanticLabel) {
    throw new UnsupportedOperationException("checkboxAdaptive has no default (FFM/comm impl required)");
  }
  default boolean Checkbox_readBack_value(Object st) {
    throw new UnsupportedOperationException("Checkbox_readBack_value read-back requires FFM/java22");
  }
  default Color Checkbox_readBack_activeColor(Object st) {
    throw new UnsupportedOperationException("Checkbox_readBack_activeColor read-back requires FFM/java22");
  }
  default Color Checkbox_readBack_checkColor(Object st) {
    throw new UnsupportedOperationException("Checkbox_readBack_checkColor read-back requires FFM/java22");
  }
  default boolean Checkbox_readBack_tristate(Object st) {
    throw new UnsupportedOperationException("Checkbox_readBack_tristate read-back requires FFM/java22");
  }
  default MaterialTapTargetSize Checkbox_readBack_materialTapTargetSize(Object st) {
    throw new UnsupportedOperationException("Checkbox_readBack_materialTapTargetSize read-back requires FFM/java22");
  }
  default VisualDensity Checkbox_readBack_visualDensity(Object st) {
    throw new UnsupportedOperationException("Checkbox_readBack_visualDensity read-back requires FFM/java22");
  }
  default Color Checkbox_readBack_focusColor(Object st) {
    throw new UnsupportedOperationException("Checkbox_readBack_focusColor read-back requires FFM/java22");
  }
  default Color Checkbox_readBack_hoverColor(Object st) {
    throw new UnsupportedOperationException("Checkbox_readBack_hoverColor read-back requires FFM/java22");
  }
  default double Checkbox_readBack_splashRadius(Object st) {
    throw new UnsupportedOperationException("Checkbox_readBack_splashRadius read-back requires FFM/java22");
  }
  default boolean Checkbox_readBack_autofocus(Object st) {
    throw new UnsupportedOperationException("Checkbox_readBack_autofocus read-back requires FFM/java22");
  }
  default OutlinedBorder Checkbox_readBack_shape(Object st) {
    throw new UnsupportedOperationException("Checkbox_readBack_shape read-back requires FFM/java22");
  }
  default BorderSide Checkbox_readBack_side(Object st) {
    throw new UnsupportedOperationException("Checkbox_readBack_side read-back requires FFM/java22");
  }
  default boolean Checkbox_readBack_isError(Object st) {
    throw new UnsupportedOperationException("Checkbox_readBack_isError read-back requires FFM/java22");
  }
  default String Checkbox_readBack_semanticLabel(Object st) {
    throw new UnsupportedOperationException("Checkbox_readBack_semanticLabel read-back requires FFM/java22");
  }

  default int switch_Switch_(boolean value, Optional<Consumer<Boolean>> onChanged, Optional<Color> activeColor, Optional<Color> activeThumbColor, Optional<Color> activeTrackColor, Optional<Color> inactiveThumbColor, Optional<Color> inactiveTrackColor, Optional<Color> thumbColor, Optional<Color> trackColor, Optional<Color> trackOutlineColor, OptionalDouble trackOutlineWidth, Optional<Icon> thumbIcon, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<DragStartBehavior> dragStartBehavior, Optional<Color> focusColor, Optional<Color> hoverColor, Optional<Color> overlayColor, OptionalDouble splashRadius, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<EdgeInsetsGeometry> padding) {
    throw new UnsupportedOperationException("switch_Switch_ has no default (FFM/comm impl required)");
  }
  default int switch_Adaptive(boolean value, Optional<Consumer<Boolean>> onChanged, Optional<Color> activeColor, Optional<Color> activeThumbColor, Optional<Color> activeTrackColor, Optional<Color> inactiveThumbColor, Optional<Color> inactiveTrackColor, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<Color> thumbColor, Optional<Color> trackColor, Optional<Color> trackOutlineColor, OptionalDouble trackOutlineWidth, Optional<Icon> thumbIcon, Optional<DragStartBehavior> dragStartBehavior, Optional<Color> focusColor, Optional<Color> hoverColor, Optional<Color> overlayColor, OptionalDouble splashRadius, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<EdgeInsetsGeometry> padding, Optional<Boolean> applyCupertinoTheme) {
    throw new UnsupportedOperationException("switch_Adaptive has no default (FFM/comm impl required)");
  }
  default boolean Switch_readBack_value(Object st) {
    throw new UnsupportedOperationException("Switch_readBack_value read-back requires FFM/java22");
  }
  default Color Switch_readBack_activeColor(Object st) {
    throw new UnsupportedOperationException("Switch_readBack_activeColor read-back requires FFM/java22");
  }
  default Color Switch_readBack_activeThumbColor(Object st) {
    throw new UnsupportedOperationException("Switch_readBack_activeThumbColor read-back requires FFM/java22");
  }
  default Color Switch_readBack_activeTrackColor(Object st) {
    throw new UnsupportedOperationException("Switch_readBack_activeTrackColor read-back requires FFM/java22");
  }
  default Color Switch_readBack_inactiveThumbColor(Object st) {
    throw new UnsupportedOperationException("Switch_readBack_inactiveThumbColor read-back requires FFM/java22");
  }
  default Color Switch_readBack_inactiveTrackColor(Object st) {
    throw new UnsupportedOperationException("Switch_readBack_inactiveTrackColor read-back requires FFM/java22");
  }
  default MaterialTapTargetSize Switch_readBack_materialTapTargetSize(Object st) {
    throw new UnsupportedOperationException("Switch_readBack_materialTapTargetSize read-back requires FFM/java22");
  }
  default boolean Switch_readBack_applyCupertinoTheme(Object st) {
    throw new UnsupportedOperationException("Switch_readBack_applyCupertinoTheme read-back requires FFM/java22");
  }
  default DragStartBehavior Switch_readBack_dragStartBehavior(Object st) {
    throw new UnsupportedOperationException("Switch_readBack_dragStartBehavior read-back requires FFM/java22");
  }
  default Color Switch_readBack_focusColor(Object st) {
    throw new UnsupportedOperationException("Switch_readBack_focusColor read-back requires FFM/java22");
  }
  default Color Switch_readBack_hoverColor(Object st) {
    throw new UnsupportedOperationException("Switch_readBack_hoverColor read-back requires FFM/java22");
  }
  default double Switch_readBack_splashRadius(Object st) {
    throw new UnsupportedOperationException("Switch_readBack_splashRadius read-back requires FFM/java22");
  }
  default boolean Switch_readBack_autofocus(Object st) {
    throw new UnsupportedOperationException("Switch_readBack_autofocus read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry Switch_readBack_padding(Object st) {
    throw new UnsupportedOperationException("Switch_readBack_padding read-back requires FFM/java22");
  }

  default int sliderSlider(double value, OptionalDouble secondaryTrackValue, Optional<Consumer<Double>> onChanged, Optional<Consumer<Double>> onChangeStart, Optional<Consumer<Double>> onChangeEnd, OptionalDouble min, OptionalDouble max, OptionalInt divisions, Optional<String> label, Optional<Color> activeColor, Optional<Color> inactiveColor, Optional<Color> secondaryActiveColor, Optional<Color> thumbColor, Optional<Color> overlayColor, Optional<Function<Double, String>> semanticFormatterCallback, Optional<Boolean> autofocus, Optional<SliderInteraction> allowedInteraction, Optional<EdgeInsetsGeometry> padding, Optional<ShowValueIndicator> showValueIndicator, Optional<Boolean> year2023) {
    throw new UnsupportedOperationException("sliderSlider has no default (FFM/comm impl required)");
  }
  default int sliderAdaptive(double value, OptionalDouble secondaryTrackValue, Optional<Consumer<Double>> onChanged, Optional<Consumer<Double>> onChangeStart, Optional<Consumer<Double>> onChangeEnd, OptionalDouble min, OptionalDouble max, OptionalInt divisions, Optional<String> label, Optional<Color> activeColor, Optional<Color> inactiveColor, Optional<Color> secondaryActiveColor, Optional<Color> thumbColor, Optional<Color> overlayColor, Optional<Function<Double, String>> semanticFormatterCallback, Optional<Boolean> autofocus, Optional<SliderInteraction> allowedInteraction, Optional<ShowValueIndicator> showValueIndicator, Optional<Boolean> year2023) {
    throw new UnsupportedOperationException("sliderAdaptive has no default (FFM/comm impl required)");
  }
  default double Slider_readBack_value(Object st) {
    throw new UnsupportedOperationException("Slider_readBack_value read-back requires FFM/java22");
  }
  default double Slider_readBack_secondaryTrackValue(Object st) {
    throw new UnsupportedOperationException("Slider_readBack_secondaryTrackValue read-back requires FFM/java22");
  }
  default double Slider_readBack_min(Object st) {
    throw new UnsupportedOperationException("Slider_readBack_min read-back requires FFM/java22");
  }
  default double Slider_readBack_max(Object st) {
    throw new UnsupportedOperationException("Slider_readBack_max read-back requires FFM/java22");
  }
  default int Slider_readBack_divisions(Object st) {
    throw new UnsupportedOperationException("Slider_readBack_divisions read-back requires FFM/java22");
  }
  default String Slider_readBack_label(Object st) {
    throw new UnsupportedOperationException("Slider_readBack_label read-back requires FFM/java22");
  }
  default Color Slider_readBack_activeColor(Object st) {
    throw new UnsupportedOperationException("Slider_readBack_activeColor read-back requires FFM/java22");
  }
  default Color Slider_readBack_inactiveColor(Object st) {
    throw new UnsupportedOperationException("Slider_readBack_inactiveColor read-back requires FFM/java22");
  }
  default Color Slider_readBack_secondaryActiveColor(Object st) {
    throw new UnsupportedOperationException("Slider_readBack_secondaryActiveColor read-back requires FFM/java22");
  }
  default Color Slider_readBack_thumbColor(Object st) {
    throw new UnsupportedOperationException("Slider_readBack_thumbColor read-back requires FFM/java22");
  }
  default boolean Slider_readBack_autofocus(Object st) {
    throw new UnsupportedOperationException("Slider_readBack_autofocus read-back requires FFM/java22");
  }
  default SliderInteraction Slider_readBack_allowedInteraction(Object st) {
    throw new UnsupportedOperationException("Slider_readBack_allowedInteraction read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry Slider_readBack_padding(Object st) {
    throw new UnsupportedOperationException("Slider_readBack_padding read-back requires FFM/java22");
  }
  default ShowValueIndicator Slider_readBack_showValueIndicator(Object st) {
    throw new UnsupportedOperationException("Slider_readBack_showValueIndicator read-back requires FFM/java22");
  }
  default boolean Slider_readBack_year2023(Object st) {
    throw new UnsupportedOperationException("Slider_readBack_year2023 read-back requires FFM/java22");
  }

  default int drawerDrawer(Optional<Color> backgroundColor, OptionalDouble elevation, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, Optional<ShapeBorder> shape, OptionalDouble width, Optional<Widget> child, Optional<String> semanticLabel, Optional<Clip> clipBehavior) {
    throw new UnsupportedOperationException("drawerDrawer has no default (FFM/comm impl required)");
  }
  default Color Drawer_readBack_backgroundColor(Object st) {
    throw new UnsupportedOperationException("Drawer_readBack_backgroundColor read-back requires FFM/java22");
  }
  default double Drawer_readBack_elevation(Object st) {
    throw new UnsupportedOperationException("Drawer_readBack_elevation read-back requires FFM/java22");
  }
  default Color Drawer_readBack_shadowColor(Object st) {
    throw new UnsupportedOperationException("Drawer_readBack_shadowColor read-back requires FFM/java22");
  }
  default Color Drawer_readBack_surfaceTintColor(Object st) {
    throw new UnsupportedOperationException("Drawer_readBack_surfaceTintColor read-back requires FFM/java22");
  }
  default ShapeBorder Drawer_readBack_shape(Object st) {
    throw new UnsupportedOperationException("Drawer_readBack_shape read-back requires FFM/java22");
  }
  default double Drawer_readBack_width(Object st) {
    throw new UnsupportedOperationException("Drawer_readBack_width read-back requires FFM/java22");
  }
  default Widget Drawer_readBack_child(Object st) {
    throw new UnsupportedOperationException("Drawer_readBack_child read-back requires FFM/java22");
  }
  default String Drawer_readBack_semanticLabel(Object st) {
    throw new UnsupportedOperationException("Drawer_readBack_semanticLabel read-back requires FFM/java22");
  }
  default Clip Drawer_readBack_clipBehavior(Object st) {
    throw new UnsupportedOperationException("Drawer_readBack_clipBehavior read-back requires FFM/java22");
  }

  default int tooltipTooltip(Optional<String> message, Optional<InlineSpan> richMessage, OptionalDouble height, Optional<BoxConstraints> constraints, Optional<EdgeInsetsGeometry> padding, Optional<EdgeInsetsGeometry> margin, OptionalDouble verticalOffset, Optional<Boolean> preferBelow, Optional<Boolean> excludeFromSemantics, Optional<Decoration> decoration, Optional<TextStyle> textStyle, Optional<TextAlign> textAlign, Optional<Duration> waitDuration, Optional<Duration> showDuration, Optional<Duration> exitDuration, Optional<Boolean> enableTapToDismiss, Optional<TooltipTriggerMode> triggerMode, Optional<Boolean> enableFeedback, Optional<Runnable> onTriggered, Optional<Boolean> ignorePointer, Optional<Widget> child) {
    throw new UnsupportedOperationException("tooltipTooltip has no default (FFM/comm impl required)");
  }
  default int tooltipDismissAllToolTips() {
    throw new UnsupportedOperationException("tooltipDismissAllToolTips has no default (FFM/comm impl required)");
  }
  default String Tooltip_readBack_message(Object st) {
    throw new UnsupportedOperationException("Tooltip_readBack_message read-back requires FFM/java22");
  }
  default InlineSpan Tooltip_readBack_richMessage(Object st) {
    throw new UnsupportedOperationException("Tooltip_readBack_richMessage read-back requires FFM/java22");
  }
  default double Tooltip_readBack_height(Object st) {
    throw new UnsupportedOperationException("Tooltip_readBack_height read-back requires FFM/java22");
  }
  default BoxConstraints Tooltip_readBack_constraints(Object st) {
    throw new UnsupportedOperationException("Tooltip_readBack_constraints read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry Tooltip_readBack_padding(Object st) {
    throw new UnsupportedOperationException("Tooltip_readBack_padding read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry Tooltip_readBack_margin(Object st) {
    throw new UnsupportedOperationException("Tooltip_readBack_margin read-back requires FFM/java22");
  }
  default double Tooltip_readBack_verticalOffset(Object st) {
    throw new UnsupportedOperationException("Tooltip_readBack_verticalOffset read-back requires FFM/java22");
  }
  default boolean Tooltip_readBack_preferBelow(Object st) {
    throw new UnsupportedOperationException("Tooltip_readBack_preferBelow read-back requires FFM/java22");
  }
  default boolean Tooltip_readBack_excludeFromSemantics(Object st) {
    throw new UnsupportedOperationException("Tooltip_readBack_excludeFromSemantics read-back requires FFM/java22");
  }
  default Widget Tooltip_readBack_child(Object st) {
    throw new UnsupportedOperationException("Tooltip_readBack_child read-back requires FFM/java22");
  }
  default Decoration Tooltip_readBack_decoration(Object st) {
    throw new UnsupportedOperationException("Tooltip_readBack_decoration read-back requires FFM/java22");
  }
  default TextStyle Tooltip_readBack_textStyle(Object st) {
    throw new UnsupportedOperationException("Tooltip_readBack_textStyle read-back requires FFM/java22");
  }
  default TextAlign Tooltip_readBack_textAlign(Object st) {
    throw new UnsupportedOperationException("Tooltip_readBack_textAlign read-back requires FFM/java22");
  }
  default Duration Tooltip_readBack_waitDuration(Object st) {
    throw new UnsupportedOperationException("Tooltip_readBack_waitDuration read-back requires FFM/java22");
  }
  default Duration Tooltip_readBack_showDuration(Object st) {
    throw new UnsupportedOperationException("Tooltip_readBack_showDuration read-back requires FFM/java22");
  }
  default Duration Tooltip_readBack_exitDuration(Object st) {
    throw new UnsupportedOperationException("Tooltip_readBack_exitDuration read-back requires FFM/java22");
  }
  default boolean Tooltip_readBack_enableTapToDismiss(Object st) {
    throw new UnsupportedOperationException("Tooltip_readBack_enableTapToDismiss read-back requires FFM/java22");
  }
  default TooltipTriggerMode Tooltip_readBack_triggerMode(Object st) {
    throw new UnsupportedOperationException("Tooltip_readBack_triggerMode read-back requires FFM/java22");
  }
  default boolean Tooltip_readBack_enableFeedback(Object st) {
    throw new UnsupportedOperationException("Tooltip_readBack_enableFeedback read-back requires FFM/java22");
  }
  default boolean Tooltip_readBack_ignorePointer(Object st) {
    throw new UnsupportedOperationException("Tooltip_readBack_ignorePointer read-back requires FFM/java22");
  }

  default int tabTab(Optional<String> text, Optional<Widget> icon, Optional<EdgeInsetsGeometry> iconMargin, OptionalDouble height, Optional<Widget> child) {
    throw new UnsupportedOperationException("tabTab has no default (FFM/comm impl required)");
  }
  default String Tab_readBack_text(Object st) {
    throw new UnsupportedOperationException("Tab_readBack_text read-back requires FFM/java22");
  }
  default Widget Tab_readBack_child(Object st) {
    throw new UnsupportedOperationException("Tab_readBack_child read-back requires FFM/java22");
  }
  default Widget Tab_readBack_icon(Object st) {
    throw new UnsupportedOperationException("Tab_readBack_icon read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry Tab_readBack_iconMargin(Object st) {
    throw new UnsupportedOperationException("Tab_readBack_iconMargin read-back requires FFM/java22");
  }
  default double Tab_readBack_height(Object st) {
    throw new UnsupportedOperationException("Tab_readBack_height read-back requires FFM/java22");
  }

  default int tabBarTabBar(List<Widget> tabs, Optional<Boolean> isScrollable, Optional<EdgeInsetsGeometry> padding, Optional<Color> indicatorColor, Optional<Boolean> automaticIndicatorColorAdjustment, OptionalDouble indicatorWeight, Optional<EdgeInsetsGeometry> indicatorPadding, Optional<Decoration> indicator, Optional<TabBarIndicatorSize> indicatorSize, Optional<Color> dividerColor, OptionalDouble dividerHeight, Optional<Color> labelColor, Optional<TextStyle> labelStyle, Optional<EdgeInsetsGeometry> labelPadding, Optional<Color> unselectedLabelColor, Optional<TextStyle> unselectedLabelStyle, Optional<DragStartBehavior> dragStartBehavior, Optional<Color> overlayColor, Optional<Boolean> enableFeedback, Optional<Consumer<Integer>> onTap, Optional<BiConsumer<Boolean, Integer>> onHover, Optional<BiConsumer<Boolean, Integer>> onFocusChange, Optional<BorderRadius> splashBorderRadius, Optional<TabAlignment> tabAlignment, Optional<TabIndicatorAnimation> indicatorAnimation) {
    throw new UnsupportedOperationException("tabBarTabBar has no default (FFM/comm impl required)");
  }
  default int tabBarSecondary(List<Widget> tabs, Optional<Boolean> isScrollable, Optional<EdgeInsetsGeometry> padding, Optional<Color> indicatorColor, Optional<Boolean> automaticIndicatorColorAdjustment, OptionalDouble indicatorWeight, Optional<EdgeInsetsGeometry> indicatorPadding, Optional<Decoration> indicator, Optional<TabBarIndicatorSize> indicatorSize, Optional<Color> dividerColor, OptionalDouble dividerHeight, Optional<Color> labelColor, Optional<TextStyle> labelStyle, Optional<EdgeInsetsGeometry> labelPadding, Optional<Color> unselectedLabelColor, Optional<TextStyle> unselectedLabelStyle, Optional<DragStartBehavior> dragStartBehavior, Optional<Color> overlayColor, Optional<Boolean> enableFeedback, Optional<Consumer<Integer>> onTap, Optional<BiConsumer<Boolean, Integer>> onHover, Optional<BiConsumer<Boolean, Integer>> onFocusChange, Optional<BorderRadius> splashBorderRadius, Optional<TabAlignment> tabAlignment, Optional<TabIndicatorAnimation> indicatorAnimation) {
    throw new UnsupportedOperationException("tabBarSecondary has no default (FFM/comm impl required)");
  }
  default boolean TabBar_readBack_isScrollable(Object st) {
    throw new UnsupportedOperationException("TabBar_readBack_isScrollable read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry TabBar_readBack_padding(Object st) {
    throw new UnsupportedOperationException("TabBar_readBack_padding read-back requires FFM/java22");
  }
  default Color TabBar_readBack_indicatorColor(Object st) {
    throw new UnsupportedOperationException("TabBar_readBack_indicatorColor read-back requires FFM/java22");
  }
  default double TabBar_readBack_indicatorWeight(Object st) {
    throw new UnsupportedOperationException("TabBar_readBack_indicatorWeight read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry TabBar_readBack_indicatorPadding(Object st) {
    throw new UnsupportedOperationException("TabBar_readBack_indicatorPadding read-back requires FFM/java22");
  }
  default Decoration TabBar_readBack_indicator(Object st) {
    throw new UnsupportedOperationException("TabBar_readBack_indicator read-back requires FFM/java22");
  }
  default boolean TabBar_readBack_automaticIndicatorColorAdjustment(Object st) {
    throw new UnsupportedOperationException("TabBar_readBack_automaticIndicatorColorAdjustment read-back requires FFM/java22");
  }
  default TabBarIndicatorSize TabBar_readBack_indicatorSize(Object st) {
    throw new UnsupportedOperationException("TabBar_readBack_indicatorSize read-back requires FFM/java22");
  }
  default Color TabBar_readBack_dividerColor(Object st) {
    throw new UnsupportedOperationException("TabBar_readBack_dividerColor read-back requires FFM/java22");
  }
  default double TabBar_readBack_dividerHeight(Object st) {
    throw new UnsupportedOperationException("TabBar_readBack_dividerHeight read-back requires FFM/java22");
  }
  default Color TabBar_readBack_labelColor(Object st) {
    throw new UnsupportedOperationException("TabBar_readBack_labelColor read-back requires FFM/java22");
  }
  default Color TabBar_readBack_unselectedLabelColor(Object st) {
    throw new UnsupportedOperationException("TabBar_readBack_unselectedLabelColor read-back requires FFM/java22");
  }
  default TextStyle TabBar_readBack_labelStyle(Object st) {
    throw new UnsupportedOperationException("TabBar_readBack_labelStyle read-back requires FFM/java22");
  }
  default TextStyle TabBar_readBack_unselectedLabelStyle(Object st) {
    throw new UnsupportedOperationException("TabBar_readBack_unselectedLabelStyle read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry TabBar_readBack_labelPadding(Object st) {
    throw new UnsupportedOperationException("TabBar_readBack_labelPadding read-back requires FFM/java22");
  }
  default DragStartBehavior TabBar_readBack_dragStartBehavior(Object st) {
    throw new UnsupportedOperationException("TabBar_readBack_dragStartBehavior read-back requires FFM/java22");
  }
  default boolean TabBar_readBack_enableFeedback(Object st) {
    throw new UnsupportedOperationException("TabBar_readBack_enableFeedback read-back requires FFM/java22");
  }
  default BorderRadius TabBar_readBack_splashBorderRadius(Object st) {
    throw new UnsupportedOperationException("TabBar_readBack_splashBorderRadius read-back requires FFM/java22");
  }
  default TabAlignment TabBar_readBack_tabAlignment(Object st) {
    throw new UnsupportedOperationException("TabBar_readBack_tabAlignment read-back requires FFM/java22");
  }
  default TabIndicatorAnimation TabBar_readBack_indicatorAnimation(Object st) {
    throw new UnsupportedOperationException("TabBar_readBack_indicatorAnimation read-back requires FFM/java22");
  }
  default boolean TabBar_readBack_tabHasTextAndIcon(Object st) {
    throw new UnsupportedOperationException("TabBar_readBack_tabHasTextAndIcon read-back requires FFM/java22");
  }

  default int tabBarViewTabBarView(List<Widget> children, Optional<DragStartBehavior> dragStartBehavior, OptionalDouble viewportFraction, Optional<Clip> clipBehavior) {
    throw new UnsupportedOperationException("tabBarViewTabBarView has no default (FFM/comm impl required)");
  }
  default DragStartBehavior TabBarView_readBack_dragStartBehavior(Object st) {
    throw new UnsupportedOperationException("TabBarView_readBack_dragStartBehavior read-back requires FFM/java22");
  }
  default double TabBarView_readBack_viewportFraction(Object st) {
    throw new UnsupportedOperationException("TabBarView_readBack_viewportFraction read-back requires FFM/java22");
  }
  default Clip TabBarView_readBack_clipBehavior(Object st) {
    throw new UnsupportedOperationException("TabBarView_readBack_clipBehavior read-back requires FFM/java22");
  }

  default int defaultTabControllerDefaultTabController(int length, OptionalInt initialIndex, Widget child, Optional<Duration> animationDuration) {
    throw new UnsupportedOperationException("defaultTabControllerDefaultTabController has no default (FFM/comm impl required)");
  }
  default int DefaultTabController_readBack_length(Object st) {
    throw new UnsupportedOperationException("DefaultTabController_readBack_length read-back requires FFM/java22");
  }
  default int DefaultTabController_readBack_initialIndex(Object st) {
    throw new UnsupportedOperationException("DefaultTabController_readBack_initialIndex read-back requires FFM/java22");
  }
  default Duration DefaultTabController_readBack_animationDuration(Object st) {
    throw new UnsupportedOperationException("DefaultTabController_readBack_animationDuration read-back requires FFM/java22");
  }
  default Widget DefaultTabController_readBack_child(Object st) {
    throw new UnsupportedOperationException("DefaultTabController_readBack_child read-back requires FFM/java22");
  }

  default int checkboxListTileCheckboxListTile(Optional<Boolean> value, Optional<Consumer<Boolean>> onChanged, Optional<Color> activeColor, Optional<Color> fillColor, Optional<Color> checkColor, Optional<Color> hoverColor, Optional<Color> overlayColor, OptionalDouble splashRadius, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<VisualDensity> visualDensity, Optional<Boolean> autofocus, Optional<ShapeBorder> shape, Optional<BorderSide> side, Optional<Boolean> isError, Optional<Boolean> enabled, Optional<Color> tileColor, Optional<Widget> title, Optional<Widget> subtitle, Optional<Boolean> isThreeLine, Optional<Boolean> dense, Optional<Widget> secondary, Optional<Boolean> selected, Optional<ListTileControlAffinity> controlAffinity, Optional<EdgeInsetsGeometry> contentPadding, Optional<Boolean> tristate, Optional<OutlinedBorder> checkboxShape, Optional<Color> selectedTileColor, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> enableFeedback, OptionalDouble horizontalTitleGap, OptionalDouble minVerticalPadding, OptionalDouble minLeadingWidth, OptionalDouble minTileHeight, Optional<String> checkboxSemanticLabel, OptionalDouble checkboxScaleFactor, Optional<ListTileTitleAlignment> titleAlignment, Optional<Boolean> internalAddSemanticForOnTap) {
    throw new UnsupportedOperationException("checkboxListTileCheckboxListTile has no default (FFM/comm impl required)");
  }
  default int checkboxListTileAdaptive(Optional<Boolean> value, Optional<Consumer<Boolean>> onChanged, Optional<Color> activeColor, Optional<Color> fillColor, Optional<Color> checkColor, Optional<Color> hoverColor, Optional<Color> overlayColor, OptionalDouble splashRadius, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<VisualDensity> visualDensity, Optional<Boolean> autofocus, Optional<ShapeBorder> shape, Optional<BorderSide> side, Optional<Boolean> isError, Optional<Boolean> enabled, Optional<Color> tileColor, Optional<Widget> title, Optional<Widget> subtitle, Optional<Boolean> isThreeLine, Optional<Boolean> dense, Optional<Widget> secondary, Optional<Boolean> selected, Optional<ListTileControlAffinity> controlAffinity, Optional<EdgeInsetsGeometry> contentPadding, Optional<Boolean> tristate, Optional<OutlinedBorder> checkboxShape, Optional<Color> selectedTileColor, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> enableFeedback, OptionalDouble horizontalTitleGap, OptionalDouble minVerticalPadding, OptionalDouble minLeadingWidth, OptionalDouble minTileHeight, Optional<String> checkboxSemanticLabel, OptionalDouble checkboxScaleFactor, Optional<ListTileTitleAlignment> titleAlignment, Optional<Boolean> internalAddSemanticForOnTap) {
    throw new UnsupportedOperationException("checkboxListTileAdaptive has no default (FFM/comm impl required)");
  }
  default boolean CheckboxListTile_readBack_value(Object st) {
    throw new UnsupportedOperationException("CheckboxListTile_readBack_value read-back requires FFM/java22");
  }
  default Color CheckboxListTile_readBack_activeColor(Object st) {
    throw new UnsupportedOperationException("CheckboxListTile_readBack_activeColor read-back requires FFM/java22");
  }
  default Color CheckboxListTile_readBack_checkColor(Object st) {
    throw new UnsupportedOperationException("CheckboxListTile_readBack_checkColor read-back requires FFM/java22");
  }
  default Color CheckboxListTile_readBack_hoverColor(Object st) {
    throw new UnsupportedOperationException("CheckboxListTile_readBack_hoverColor read-back requires FFM/java22");
  }
  default double CheckboxListTile_readBack_splashRadius(Object st) {
    throw new UnsupportedOperationException("CheckboxListTile_readBack_splashRadius read-back requires FFM/java22");
  }
  default MaterialTapTargetSize CheckboxListTile_readBack_materialTapTargetSize(Object st) {
    throw new UnsupportedOperationException("CheckboxListTile_readBack_materialTapTargetSize read-back requires FFM/java22");
  }
  default VisualDensity CheckboxListTile_readBack_visualDensity(Object st) {
    throw new UnsupportedOperationException("CheckboxListTile_readBack_visualDensity read-back requires FFM/java22");
  }
  default boolean CheckboxListTile_readBack_autofocus(Object st) {
    throw new UnsupportedOperationException("CheckboxListTile_readBack_autofocus read-back requires FFM/java22");
  }
  default ShapeBorder CheckboxListTile_readBack_shape(Object st) {
    throw new UnsupportedOperationException("CheckboxListTile_readBack_shape read-back requires FFM/java22");
  }
  default BorderSide CheckboxListTile_readBack_side(Object st) {
    throw new UnsupportedOperationException("CheckboxListTile_readBack_side read-back requires FFM/java22");
  }
  default boolean CheckboxListTile_readBack_isError(Object st) {
    throw new UnsupportedOperationException("CheckboxListTile_readBack_isError read-back requires FFM/java22");
  }
  default Color CheckboxListTile_readBack_tileColor(Object st) {
    throw new UnsupportedOperationException("CheckboxListTile_readBack_tileColor read-back requires FFM/java22");
  }
  default Widget CheckboxListTile_readBack_title(Object st) {
    throw new UnsupportedOperationException("CheckboxListTile_readBack_title read-back requires FFM/java22");
  }
  default Widget CheckboxListTile_readBack_subtitle(Object st) {
    throw new UnsupportedOperationException("CheckboxListTile_readBack_subtitle read-back requires FFM/java22");
  }
  default Widget CheckboxListTile_readBack_secondary(Object st) {
    throw new UnsupportedOperationException("CheckboxListTile_readBack_secondary read-back requires FFM/java22");
  }
  default boolean CheckboxListTile_readBack_isThreeLine(Object st) {
    throw new UnsupportedOperationException("CheckboxListTile_readBack_isThreeLine read-back requires FFM/java22");
  }
  default boolean CheckboxListTile_readBack_dense(Object st) {
    throw new UnsupportedOperationException("CheckboxListTile_readBack_dense read-back requires FFM/java22");
  }
  default boolean CheckboxListTile_readBack_selected(Object st) {
    throw new UnsupportedOperationException("CheckboxListTile_readBack_selected read-back requires FFM/java22");
  }
  default ListTileControlAffinity CheckboxListTile_readBack_controlAffinity(Object st) {
    throw new UnsupportedOperationException("CheckboxListTile_readBack_controlAffinity read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry CheckboxListTile_readBack_contentPadding(Object st) {
    throw new UnsupportedOperationException("CheckboxListTile_readBack_contentPadding read-back requires FFM/java22");
  }
  default boolean CheckboxListTile_readBack_tristate(Object st) {
    throw new UnsupportedOperationException("CheckboxListTile_readBack_tristate read-back requires FFM/java22");
  }
  default OutlinedBorder CheckboxListTile_readBack_checkboxShape(Object st) {
    throw new UnsupportedOperationException("CheckboxListTile_readBack_checkboxShape read-back requires FFM/java22");
  }
  default Color CheckboxListTile_readBack_selectedTileColor(Object st) {
    throw new UnsupportedOperationException("CheckboxListTile_readBack_selectedTileColor read-back requires FFM/java22");
  }
  default boolean CheckboxListTile_readBack_enableFeedback(Object st) {
    throw new UnsupportedOperationException("CheckboxListTile_readBack_enableFeedback read-back requires FFM/java22");
  }
  default double CheckboxListTile_readBack_horizontalTitleGap(Object st) {
    throw new UnsupportedOperationException("CheckboxListTile_readBack_horizontalTitleGap read-back requires FFM/java22");
  }
  default double CheckboxListTile_readBack_minVerticalPadding(Object st) {
    throw new UnsupportedOperationException("CheckboxListTile_readBack_minVerticalPadding read-back requires FFM/java22");
  }
  default double CheckboxListTile_readBack_minLeadingWidth(Object st) {
    throw new UnsupportedOperationException("CheckboxListTile_readBack_minLeadingWidth read-back requires FFM/java22");
  }
  default double CheckboxListTile_readBack_minTileHeight(Object st) {
    throw new UnsupportedOperationException("CheckboxListTile_readBack_minTileHeight read-back requires FFM/java22");
  }
  default boolean CheckboxListTile_readBack_enabled(Object st) {
    throw new UnsupportedOperationException("CheckboxListTile_readBack_enabled read-back requires FFM/java22");
  }
  default ListTileTitleAlignment CheckboxListTile_readBack_titleAlignment(Object st) {
    throw new UnsupportedOperationException("CheckboxListTile_readBack_titleAlignment read-back requires FFM/java22");
  }
  default boolean CheckboxListTile_readBack_internalAddSemanticForOnTap(Object st) {
    throw new UnsupportedOperationException("CheckboxListTile_readBack_internalAddSemanticForOnTap read-back requires FFM/java22");
  }
  default double CheckboxListTile_readBack_checkboxScaleFactor(Object st) {
    throw new UnsupportedOperationException("CheckboxListTile_readBack_checkboxScaleFactor read-back requires FFM/java22");
  }
  default String CheckboxListTile_readBack_checkboxSemanticLabel(Object st) {
    throw new UnsupportedOperationException("CheckboxListTile_readBack_checkboxSemanticLabel read-back requires FFM/java22");
  }

  default int switchListTileSwitchListTile(boolean value, Optional<Consumer<Boolean>> onChanged, Optional<Color> activeColor, Optional<Color> activeThumbColor, Optional<Color> activeTrackColor, Optional<Color> inactiveThumbColor, Optional<Color> inactiveTrackColor, Optional<Color> thumbColor, Optional<Color> trackColor, Optional<Color> trackOutlineColor, Optional<Icon> thumbIcon, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<DragStartBehavior> dragStartBehavior, Optional<Color> overlayColor, OptionalDouble splashRadius, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Color> tileColor, Optional<Widget> title, Optional<Widget> subtitle, Optional<Boolean> isThreeLine, Optional<Boolean> dense, Optional<EdgeInsetsGeometry> contentPadding, Optional<Widget> secondary, Optional<Boolean> selected, Optional<ListTileControlAffinity> controlAffinity, Optional<ShapeBorder> shape, Optional<Color> selectedTileColor, Optional<VisualDensity> visualDensity, Optional<Boolean> enableFeedback, OptionalDouble horizontalTitleGap, OptionalDouble minVerticalPadding, OptionalDouble minLeadingWidth, OptionalDouble minTileHeight, Optional<Color> hoverColor, Optional<Boolean> internalAddSemanticForOnTap) {
    throw new UnsupportedOperationException("switchListTileSwitchListTile has no default (FFM/comm impl required)");
  }
  default int switchListTileAdaptive(boolean value, Optional<Consumer<Boolean>> onChanged, Optional<Color> activeColor, Optional<Color> activeThumbColor, Optional<Color> activeTrackColor, Optional<Color> inactiveThumbColor, Optional<Color> inactiveTrackColor, Optional<Color> thumbColor, Optional<Color> trackColor, Optional<Color> trackOutlineColor, Optional<Icon> thumbIcon, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<DragStartBehavior> dragStartBehavior, Optional<Color> overlayColor, OptionalDouble splashRadius, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Boolean> applyCupertinoTheme, Optional<Color> tileColor, Optional<Widget> title, Optional<Widget> subtitle, Optional<Boolean> isThreeLine, Optional<Boolean> dense, Optional<EdgeInsetsGeometry> contentPadding, Optional<Widget> secondary, Optional<Boolean> selected, Optional<ListTileControlAffinity> controlAffinity, Optional<ShapeBorder> shape, Optional<Color> selectedTileColor, Optional<VisualDensity> visualDensity, Optional<Boolean> enableFeedback, OptionalDouble horizontalTitleGap, OptionalDouble minVerticalPadding, OptionalDouble minLeadingWidth, OptionalDouble minTileHeight, Optional<Color> hoverColor, Optional<Boolean> internalAddSemanticForOnTap) {
    throw new UnsupportedOperationException("switchListTileAdaptive has no default (FFM/comm impl required)");
  }
  default boolean SwitchListTile_readBack_value(Object st) {
    throw new UnsupportedOperationException("SwitchListTile_readBack_value read-back requires FFM/java22");
  }
  default Color SwitchListTile_readBack_activeColor(Object st) {
    throw new UnsupportedOperationException("SwitchListTile_readBack_activeColor read-back requires FFM/java22");
  }
  default Color SwitchListTile_readBack_activeThumbColor(Object st) {
    throw new UnsupportedOperationException("SwitchListTile_readBack_activeThumbColor read-back requires FFM/java22");
  }
  default Color SwitchListTile_readBack_activeTrackColor(Object st) {
    throw new UnsupportedOperationException("SwitchListTile_readBack_activeTrackColor read-back requires FFM/java22");
  }
  default Color SwitchListTile_readBack_inactiveThumbColor(Object st) {
    throw new UnsupportedOperationException("SwitchListTile_readBack_inactiveThumbColor read-back requires FFM/java22");
  }
  default Color SwitchListTile_readBack_inactiveTrackColor(Object st) {
    throw new UnsupportedOperationException("SwitchListTile_readBack_inactiveTrackColor read-back requires FFM/java22");
  }
  default MaterialTapTargetSize SwitchListTile_readBack_materialTapTargetSize(Object st) {
    throw new UnsupportedOperationException("SwitchListTile_readBack_materialTapTargetSize read-back requires FFM/java22");
  }
  default DragStartBehavior SwitchListTile_readBack_dragStartBehavior(Object st) {
    throw new UnsupportedOperationException("SwitchListTile_readBack_dragStartBehavior read-back requires FFM/java22");
  }
  default double SwitchListTile_readBack_splashRadius(Object st) {
    throw new UnsupportedOperationException("SwitchListTile_readBack_splashRadius read-back requires FFM/java22");
  }
  default boolean SwitchListTile_readBack_autofocus(Object st) {
    throw new UnsupportedOperationException("SwitchListTile_readBack_autofocus read-back requires FFM/java22");
  }
  default Color SwitchListTile_readBack_tileColor(Object st) {
    throw new UnsupportedOperationException("SwitchListTile_readBack_tileColor read-back requires FFM/java22");
  }
  default Widget SwitchListTile_readBack_title(Object st) {
    throw new UnsupportedOperationException("SwitchListTile_readBack_title read-back requires FFM/java22");
  }
  default Widget SwitchListTile_readBack_subtitle(Object st) {
    throw new UnsupportedOperationException("SwitchListTile_readBack_subtitle read-back requires FFM/java22");
  }
  default Widget SwitchListTile_readBack_secondary(Object st) {
    throw new UnsupportedOperationException("SwitchListTile_readBack_secondary read-back requires FFM/java22");
  }
  default boolean SwitchListTile_readBack_isThreeLine(Object st) {
    throw new UnsupportedOperationException("SwitchListTile_readBack_isThreeLine read-back requires FFM/java22");
  }
  default boolean SwitchListTile_readBack_dense(Object st) {
    throw new UnsupportedOperationException("SwitchListTile_readBack_dense read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry SwitchListTile_readBack_contentPadding(Object st) {
    throw new UnsupportedOperationException("SwitchListTile_readBack_contentPadding read-back requires FFM/java22");
  }
  default boolean SwitchListTile_readBack_selected(Object st) {
    throw new UnsupportedOperationException("SwitchListTile_readBack_selected read-back requires FFM/java22");
  }
  default ListTileControlAffinity SwitchListTile_readBack_controlAffinity(Object st) {
    throw new UnsupportedOperationException("SwitchListTile_readBack_controlAffinity read-back requires FFM/java22");
  }
  default ShapeBorder SwitchListTile_readBack_shape(Object st) {
    throw new UnsupportedOperationException("SwitchListTile_readBack_shape read-back requires FFM/java22");
  }
  default Color SwitchListTile_readBack_selectedTileColor(Object st) {
    throw new UnsupportedOperationException("SwitchListTile_readBack_selectedTileColor read-back requires FFM/java22");
  }
  default VisualDensity SwitchListTile_readBack_visualDensity(Object st) {
    throw new UnsupportedOperationException("SwitchListTile_readBack_visualDensity read-back requires FFM/java22");
  }
  default boolean SwitchListTile_readBack_enableFeedback(Object st) {
    throw new UnsupportedOperationException("SwitchListTile_readBack_enableFeedback read-back requires FFM/java22");
  }
  default double SwitchListTile_readBack_horizontalTitleGap(Object st) {
    throw new UnsupportedOperationException("SwitchListTile_readBack_horizontalTitleGap read-back requires FFM/java22");
  }
  default double SwitchListTile_readBack_minVerticalPadding(Object st) {
    throw new UnsupportedOperationException("SwitchListTile_readBack_minVerticalPadding read-back requires FFM/java22");
  }
  default double SwitchListTile_readBack_minLeadingWidth(Object st) {
    throw new UnsupportedOperationException("SwitchListTile_readBack_minLeadingWidth read-back requires FFM/java22");
  }
  default double SwitchListTile_readBack_minTileHeight(Object st) {
    throw new UnsupportedOperationException("SwitchListTile_readBack_minTileHeight read-back requires FFM/java22");
  }
  default Color SwitchListTile_readBack_hoverColor(Object st) {
    throw new UnsupportedOperationException("SwitchListTile_readBack_hoverColor read-back requires FFM/java22");
  }
  default boolean SwitchListTile_readBack_applyCupertinoTheme(Object st) {
    throw new UnsupportedOperationException("SwitchListTile_readBack_applyCupertinoTheme read-back requires FFM/java22");
  }
  default boolean SwitchListTile_readBack_internalAddSemanticForOnTap(Object st) {
    throw new UnsupportedOperationException("SwitchListTile_readBack_internalAddSemanticForOnTap read-back requires FFM/java22");
  }

  default int badgeBadge(Optional<Color> backgroundColor, Optional<Color> textColor, OptionalDouble smallSize, OptionalDouble largeSize, Optional<TextStyle> textStyle, Optional<EdgeInsetsGeometry> padding, Optional<AlignmentGeometry> alignment, Optional<Offset> offset, Optional<Widget> label, Optional<Boolean> isLabelVisible, Optional<Widget> child) {
    throw new UnsupportedOperationException("badgeBadge has no default (FFM/comm impl required)");
  }
  default int badgeCount(Optional<Color> backgroundColor, Optional<Color> textColor, OptionalDouble smallSize, OptionalDouble largeSize, Optional<TextStyle> textStyle, Optional<EdgeInsetsGeometry> padding, Optional<AlignmentGeometry> alignment, Optional<Offset> offset, int count, OptionalInt maxCount, Optional<Boolean> isLabelVisible, Optional<Widget> child) {
    throw new UnsupportedOperationException("badgeCount has no default (FFM/comm impl required)");
  }
  default Color Badge_readBack_backgroundColor(Object st) {
    throw new UnsupportedOperationException("Badge_readBack_backgroundColor read-back requires FFM/java22");
  }
  default Color Badge_readBack_textColor(Object st) {
    throw new UnsupportedOperationException("Badge_readBack_textColor read-back requires FFM/java22");
  }
  default double Badge_readBack_smallSize(Object st) {
    throw new UnsupportedOperationException("Badge_readBack_smallSize read-back requires FFM/java22");
  }
  default double Badge_readBack_largeSize(Object st) {
    throw new UnsupportedOperationException("Badge_readBack_largeSize read-back requires FFM/java22");
  }
  default TextStyle Badge_readBack_textStyle(Object st) {
    throw new UnsupportedOperationException("Badge_readBack_textStyle read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry Badge_readBack_padding(Object st) {
    throw new UnsupportedOperationException("Badge_readBack_padding read-back requires FFM/java22");
  }
  default AlignmentGeometry Badge_readBack_alignment(Object st) {
    throw new UnsupportedOperationException("Badge_readBack_alignment read-back requires FFM/java22");
  }
  default Offset Badge_readBack_offset(Object st) {
    throw new UnsupportedOperationException("Badge_readBack_offset read-back requires FFM/java22");
  }
  default Widget Badge_readBack_label(Object st) {
    throw new UnsupportedOperationException("Badge_readBack_label read-back requires FFM/java22");
  }
  default boolean Badge_readBack_isLabelVisible(Object st) {
    throw new UnsupportedOperationException("Badge_readBack_isLabelVisible read-back requires FFM/java22");
  }
  default Widget Badge_readBack_child(Object st) {
    throw new UnsupportedOperationException("Badge_readBack_child read-back requires FFM/java22");
  }

  default int selectableTextSelectableText(String data, Optional<TextStyle> style, Optional<TextAlign> textAlign, Optional<TextDirection> textDirection, OptionalDouble textScaleFactor, Optional<Boolean> showCursor, Optional<Boolean> autofocus, OptionalInt minLines, OptionalInt maxLines, OptionalDouble cursorWidth, OptionalDouble cursorHeight, Optional<Radius> cursorRadius, Optional<Color> cursorColor, Optional<Color> selectionColor, Optional<BoxHeightStyle> selectionHeightStyle, Optional<BoxWidthStyle> selectionWidthStyle, Optional<DragStartBehavior> dragStartBehavior, Optional<Boolean> enableInteractiveSelection, Optional<Runnable> onTap, Optional<String> semanticsLabel, Optional<TextWidthBasis> textWidthBasis) {
    throw new UnsupportedOperationException("selectableTextSelectableText has no default (FFM/comm impl required)");
  }
  default int selectableTextRich(TextSpan textSpan, Optional<TextStyle> style, Optional<TextAlign> textAlign, Optional<TextDirection> textDirection, OptionalDouble textScaleFactor, Optional<Boolean> showCursor, Optional<Boolean> autofocus, OptionalInt minLines, OptionalInt maxLines, OptionalDouble cursorWidth, OptionalDouble cursorHeight, Optional<Radius> cursorRadius, Optional<Color> cursorColor, Optional<Color> selectionColor, Optional<BoxHeightStyle> selectionHeightStyle, Optional<BoxWidthStyle> selectionWidthStyle, Optional<DragStartBehavior> dragStartBehavior, Optional<Boolean> enableInteractiveSelection, Optional<Runnable> onTap, Optional<String> semanticsLabel, Optional<TextWidthBasis> textWidthBasis) {
    throw new UnsupportedOperationException("selectableTextRich has no default (FFM/comm impl required)");
  }
  default String SelectableText_readBack_data(Object st) {
    throw new UnsupportedOperationException("SelectableText_readBack_data read-back requires FFM/java22");
  }
  default TextSpan SelectableText_readBack_textSpan(Object st) {
    throw new UnsupportedOperationException("SelectableText_readBack_textSpan read-back requires FFM/java22");
  }
  default TextStyle SelectableText_readBack_style(Object st) {
    throw new UnsupportedOperationException("SelectableText_readBack_style read-back requires FFM/java22");
  }
  default TextAlign SelectableText_readBack_textAlign(Object st) {
    throw new UnsupportedOperationException("SelectableText_readBack_textAlign read-back requires FFM/java22");
  }
  default TextDirection SelectableText_readBack_textDirection(Object st) {
    throw new UnsupportedOperationException("SelectableText_readBack_textDirection read-back requires FFM/java22");
  }
  default double SelectableText_readBack_textScaleFactor(Object st) {
    throw new UnsupportedOperationException("SelectableText_readBack_textScaleFactor read-back requires FFM/java22");
  }
  default boolean SelectableText_readBack_autofocus(Object st) {
    throw new UnsupportedOperationException("SelectableText_readBack_autofocus read-back requires FFM/java22");
  }
  default int SelectableText_readBack_minLines(Object st) {
    throw new UnsupportedOperationException("SelectableText_readBack_minLines read-back requires FFM/java22");
  }
  default int SelectableText_readBack_maxLines(Object st) {
    throw new UnsupportedOperationException("SelectableText_readBack_maxLines read-back requires FFM/java22");
  }
  default boolean SelectableText_readBack_showCursor(Object st) {
    throw new UnsupportedOperationException("SelectableText_readBack_showCursor read-back requires FFM/java22");
  }
  default double SelectableText_readBack_cursorWidth(Object st) {
    throw new UnsupportedOperationException("SelectableText_readBack_cursorWidth read-back requires FFM/java22");
  }
  default double SelectableText_readBack_cursorHeight(Object st) {
    throw new UnsupportedOperationException("SelectableText_readBack_cursorHeight read-back requires FFM/java22");
  }
  default Radius SelectableText_readBack_cursorRadius(Object st) {
    throw new UnsupportedOperationException("SelectableText_readBack_cursorRadius read-back requires FFM/java22");
  }
  default Color SelectableText_readBack_cursorColor(Object st) {
    throw new UnsupportedOperationException("SelectableText_readBack_cursorColor read-back requires FFM/java22");
  }
  default Color SelectableText_readBack_selectionColor(Object st) {
    throw new UnsupportedOperationException("SelectableText_readBack_selectionColor read-back requires FFM/java22");
  }
  default BoxHeightStyle SelectableText_readBack_selectionHeightStyle(Object st) {
    throw new UnsupportedOperationException("SelectableText_readBack_selectionHeightStyle read-back requires FFM/java22");
  }
  default BoxWidthStyle SelectableText_readBack_selectionWidthStyle(Object st) {
    throw new UnsupportedOperationException("SelectableText_readBack_selectionWidthStyle read-back requires FFM/java22");
  }
  default boolean SelectableText_readBack_enableInteractiveSelection(Object st) {
    throw new UnsupportedOperationException("SelectableText_readBack_enableInteractiveSelection read-back requires FFM/java22");
  }
  default DragStartBehavior SelectableText_readBack_dragStartBehavior(Object st) {
    throw new UnsupportedOperationException("SelectableText_readBack_dragStartBehavior read-back requires FFM/java22");
  }
  default String SelectableText_readBack_semanticsLabel(Object st) {
    throw new UnsupportedOperationException("SelectableText_readBack_semanticsLabel read-back requires FFM/java22");
  }
  default TextWidthBasis SelectableText_readBack_textWidthBasis(Object st) {
    throw new UnsupportedOperationException("SelectableText_readBack_textWidthBasis read-back requires FFM/java22");
  }
  default boolean SelectableText_readBack_selectionEnabled(Object st) {
    throw new UnsupportedOperationException("SelectableText_readBack_selectionEnabled read-back requires FFM/java22");
  }

  default int inkWellInkWell(Optional<Widget> child, Optional<Runnable> onTap, Optional<Runnable> onDoubleTap, Optional<Runnable> onLongPress, Optional<Runnable> onLongPressUp, Optional<Consumer<TapDownDetails>> onTapDown, Optional<Consumer<TapUpDetails>> onTapUp, Optional<Runnable> onTapCancel, Optional<Runnable> onSecondaryTap, Optional<Consumer<TapUpDetails>> onSecondaryTapUp, Optional<Consumer<TapDownDetails>> onSecondaryTapDown, Optional<Runnable> onSecondaryTapCancel, Optional<Consumer<Boolean>> onHighlightChanged, Optional<Consumer<Boolean>> onHover, Optional<Color> focusColor, Optional<Color> hoverColor, Optional<Color> highlightColor, Optional<Color> overlayColor, Optional<Color> splashColor, OptionalDouble radius, Optional<BorderRadius> borderRadius, Optional<ShapeBorder> customBorder, Optional<Boolean> enableFeedback, Optional<Boolean> excludeFromSemantics, Optional<Boolean> canRequestFocus, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Duration> hoverDuration) {
    throw new UnsupportedOperationException("inkWellInkWell has no default (FFM/comm impl required)");
  }

  default int inkResponseInkResponse(Optional<Widget> child, Optional<Runnable> onTap, Optional<Consumer<TapDownDetails>> onTapDown, Optional<Consumer<TapUpDetails>> onTapUp, Optional<Runnable> onTapCancel, Optional<Runnable> onDoubleTap, Optional<Runnable> onLongPress, Optional<Runnable> onLongPressUp, Optional<Runnable> onSecondaryTap, Optional<Consumer<TapUpDetails>> onSecondaryTapUp, Optional<Consumer<TapDownDetails>> onSecondaryTapDown, Optional<Runnable> onSecondaryTapCancel, Optional<Consumer<Boolean>> onHighlightChanged, Optional<Consumer<Boolean>> onHover, Optional<Boolean> containedInkWell, Optional<BoxShape> highlightShape, OptionalDouble radius, Optional<BorderRadius> borderRadius, Optional<ShapeBorder> customBorder, Optional<Color> focusColor, Optional<Color> hoverColor, Optional<Color> highlightColor, Optional<Color> overlayColor, Optional<Color> splashColor, Optional<Boolean> enableFeedback, Optional<Boolean> excludeFromSemantics, Optional<Boolean> canRequestFocus, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Duration> hoverDuration) {
    throw new UnsupportedOperationException("inkResponseInkResponse has no default (FFM/comm impl required)");
  }
  default Widget InkResponse_readBack_child(Object st) {
    throw new UnsupportedOperationException("InkResponse_readBack_child read-back requires FFM/java22");
  }
  default boolean InkResponse_readBack_containedInkWell(Object st) {
    throw new UnsupportedOperationException("InkResponse_readBack_containedInkWell read-back requires FFM/java22");
  }
  default BoxShape InkResponse_readBack_highlightShape(Object st) {
    throw new UnsupportedOperationException("InkResponse_readBack_highlightShape read-back requires FFM/java22");
  }
  default double InkResponse_readBack_radius(Object st) {
    throw new UnsupportedOperationException("InkResponse_readBack_radius read-back requires FFM/java22");
  }
  default BorderRadius InkResponse_readBack_borderRadius(Object st) {
    throw new UnsupportedOperationException("InkResponse_readBack_borderRadius read-back requires FFM/java22");
  }
  default ShapeBorder InkResponse_readBack_customBorder(Object st) {
    throw new UnsupportedOperationException("InkResponse_readBack_customBorder read-back requires FFM/java22");
  }
  default Color InkResponse_readBack_focusColor(Object st) {
    throw new UnsupportedOperationException("InkResponse_readBack_focusColor read-back requires FFM/java22");
  }
  default Color InkResponse_readBack_hoverColor(Object st) {
    throw new UnsupportedOperationException("InkResponse_readBack_hoverColor read-back requires FFM/java22");
  }
  default Color InkResponse_readBack_highlightColor(Object st) {
    throw new UnsupportedOperationException("InkResponse_readBack_highlightColor read-back requires FFM/java22");
  }
  default Color InkResponse_readBack_splashColor(Object st) {
    throw new UnsupportedOperationException("InkResponse_readBack_splashColor read-back requires FFM/java22");
  }
  default boolean InkResponse_readBack_enableFeedback(Object st) {
    throw new UnsupportedOperationException("InkResponse_readBack_enableFeedback read-back requires FFM/java22");
  }
  default boolean InkResponse_readBack_excludeFromSemantics(Object st) {
    throw new UnsupportedOperationException("InkResponse_readBack_excludeFromSemantics read-back requires FFM/java22");
  }
  default boolean InkResponse_readBack_autofocus(Object st) {
    throw new UnsupportedOperationException("InkResponse_readBack_autofocus read-back requires FFM/java22");
  }
  default boolean InkResponse_readBack_canRequestFocus(Object st) {
    throw new UnsupportedOperationException("InkResponse_readBack_canRequestFocus read-back requires FFM/java22");
  }
  default Duration InkResponse_readBack_hoverDuration(Object st) {
    throw new UnsupportedOperationException("InkResponse_readBack_hoverDuration read-back requires FFM/java22");
  }

  default int dataTableDataTable(List<DataColumn> columns, OptionalInt sortColumnIndex, Optional<Boolean> sortAscending, Optional<Consumer<Boolean>> onSelectAll, Optional<Decoration> decoration, Optional<Color> dataRowColor, OptionalDouble dataRowHeight, OptionalDouble dataRowMinHeight, OptionalDouble dataRowMaxHeight, Optional<TextStyle> dataTextStyle, Optional<Color> headingRowColor, OptionalDouble headingRowHeight, Optional<TextStyle> headingTextStyle, OptionalDouble horizontalMargin, OptionalDouble columnSpacing, Optional<Boolean> showCheckboxColumn, Optional<Boolean> showBottomBorder, OptionalDouble dividerThickness, List<DataRow> rows, OptionalDouble checkboxHorizontalMargin, Optional<Clip> clipBehavior) {
    throw new UnsupportedOperationException("dataTableDataTable has no default (FFM/comm impl required)");
  }
  default int DataTable_readBack_sortColumnIndex(Object st) {
    throw new UnsupportedOperationException("DataTable_readBack_sortColumnIndex read-back requires FFM/java22");
  }
  default boolean DataTable_readBack_sortAscending(Object st) {
    throw new UnsupportedOperationException("DataTable_readBack_sortAscending read-back requires FFM/java22");
  }
  default Decoration DataTable_readBack_decoration(Object st) {
    throw new UnsupportedOperationException("DataTable_readBack_decoration read-back requires FFM/java22");
  }
  default double DataTable_readBack_dataRowMinHeight(Object st) {
    throw new UnsupportedOperationException("DataTable_readBack_dataRowMinHeight read-back requires FFM/java22");
  }
  default double DataTable_readBack_dataRowMaxHeight(Object st) {
    throw new UnsupportedOperationException("DataTable_readBack_dataRowMaxHeight read-back requires FFM/java22");
  }
  default TextStyle DataTable_readBack_dataTextStyle(Object st) {
    throw new UnsupportedOperationException("DataTable_readBack_dataTextStyle read-back requires FFM/java22");
  }
  default double DataTable_readBack_headingRowHeight(Object st) {
    throw new UnsupportedOperationException("DataTable_readBack_headingRowHeight read-back requires FFM/java22");
  }
  default TextStyle DataTable_readBack_headingTextStyle(Object st) {
    throw new UnsupportedOperationException("DataTable_readBack_headingTextStyle read-back requires FFM/java22");
  }
  default double DataTable_readBack_horizontalMargin(Object st) {
    throw new UnsupportedOperationException("DataTable_readBack_horizontalMargin read-back requires FFM/java22");
  }
  default double DataTable_readBack_columnSpacing(Object st) {
    throw new UnsupportedOperationException("DataTable_readBack_columnSpacing read-back requires FFM/java22");
  }
  default boolean DataTable_readBack_showCheckboxColumn(Object st) {
    throw new UnsupportedOperationException("DataTable_readBack_showCheckboxColumn read-back requires FFM/java22");
  }
  default double DataTable_readBack_dividerThickness(Object st) {
    throw new UnsupportedOperationException("DataTable_readBack_dividerThickness read-back requires FFM/java22");
  }
  default boolean DataTable_readBack_showBottomBorder(Object st) {
    throw new UnsupportedOperationException("DataTable_readBack_showBottomBorder read-back requires FFM/java22");
  }
  default double DataTable_readBack_checkboxHorizontalMargin(Object st) {
    throw new UnsupportedOperationException("DataTable_readBack_checkboxHorizontalMargin read-back requires FFM/java22");
  }
  default Clip DataTable_readBack_clipBehavior(Object st) {
    throw new UnsupportedOperationException("DataTable_readBack_clipBehavior read-back requires FFM/java22");
  }
  default double DataTable_readBack_dataRowHeight(Object st) {
    throw new UnsupportedOperationException("DataTable_readBack_dataRowHeight read-back requires FFM/java22");
  }

  default int dataColumnDataColumn(Widget label, Optional<String> tooltip, Optional<Boolean> numeric, Optional<BiConsumer<Integer, Boolean>> onSort, Optional<MainAxisAlignment> headingRowAlignment) {
    throw new UnsupportedOperationException("dataColumnDataColumn has no default (FFM/comm impl required)");
  }
  default Widget DataColumn_readBack_label(Object st) {
    throw new UnsupportedOperationException("DataColumn_readBack_label read-back requires FFM/java22");
  }
  default String DataColumn_readBack_tooltip(Object st) {
    throw new UnsupportedOperationException("DataColumn_readBack_tooltip read-back requires FFM/java22");
  }
  default boolean DataColumn_readBack_numeric(Object st) {
    throw new UnsupportedOperationException("DataColumn_readBack_numeric read-back requires FFM/java22");
  }
  default MainAxisAlignment DataColumn_readBack_headingRowAlignment(Object st) {
    throw new UnsupportedOperationException("DataColumn_readBack_headingRowAlignment read-back requires FFM/java22");
  }

  default int dataRowDataRow(Optional<Boolean> selected, Optional<Consumer<Boolean>> onSelectChanged, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onHover, Optional<Color> color, List<DataCell> cells) {
    throw new UnsupportedOperationException("dataRowDataRow has no default (FFM/comm impl required)");
  }
  default int dataRowByIndex(OptionalInt index, Optional<Boolean> selected, Optional<Consumer<Boolean>> onSelectChanged, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onHover, Optional<Color> color, List<DataCell> cells) {
    throw new UnsupportedOperationException("dataRowByIndex has no default (FFM/comm impl required)");
  }
  default boolean DataRow_readBack_selected(Object st) {
    throw new UnsupportedOperationException("DataRow_readBack_selected read-back requires FFM/java22");
  }

  default int dataCellDataCell(Widget child, Optional<Boolean> placeholder, Optional<Boolean> showEditIcon, Optional<Runnable> onTap, Optional<Runnable> onLongPress, Optional<Consumer<TapDownDetails>> onTapDown, Optional<Runnable> onDoubleTap, Optional<Runnable> onTapCancel) {
    throw new UnsupportedOperationException("dataCellDataCell has no default (FFM/comm impl required)");
  }
  default Widget DataCell_readBack_child(Object st) {
    throw new UnsupportedOperationException("DataCell_readBack_child read-back requires FFM/java22");
  }
  default boolean DataCell_readBack_placeholder(Object st) {
    throw new UnsupportedOperationException("DataCell_readBack_placeholder read-back requires FFM/java22");
  }
  default boolean DataCell_readBack_showEditIcon(Object st) {
    throw new UnsupportedOperationException("DataCell_readBack_showEditIcon read-back requires FFM/java22");
  }

  default <T> int dropdownMenuEntryDropdownMenuEntry(NativeObj value, String label, Optional<Widget> labelWidget, Optional<Widget> leadingIcon, Optional<Widget> trailingIcon, Optional<Boolean> enabled) {
    throw new UnsupportedOperationException("dropdownMenuEntryDropdownMenuEntry has no default (FFM/comm impl required)");
  }

  default <T> int dropdownMenuItemDropdownMenuItem(Optional<Runnable> onTap, Optional<NativeObj> value, Optional<Boolean> enabled, Optional<AlignmentGeometry> alignment, Widget child) {
    throw new UnsupportedOperationException("dropdownMenuItemDropdownMenuItem has no default (FFM/comm impl required)");
  }
  default boolean DropdownMenuItem_readBack_enabled(Object st) {
    throw new UnsupportedOperationException("DropdownMenuItem_readBack_enabled read-back requires FFM/java22");
  }

  default <T> int dropdownButtonDropdownButton(Optional<List<DropdownMenuItem>> items, Optional<Function<BuildContext, List<Widget>>> selectedItemBuilder, Optional<NativeObj> value, Optional<Widget> hint, Optional<Widget> disabledHint, Optional<Consumer<NativeObj>> onChanged, Optional<Runnable> onTap, OptionalInt elevation, Optional<TextStyle> style, Optional<Widget> underline, Optional<Widget> icon, Optional<Color> iconDisabledColor, Optional<Color> iconEnabledColor, OptionalDouble iconSize, Optional<Boolean> isDense, Optional<Boolean> isExpanded, OptionalDouble itemHeight, OptionalDouble menuWidth, Optional<Color> focusColor, Optional<Boolean> autofocus, Optional<Color> dropdownColor, OptionalDouble menuMaxHeight, Optional<Boolean> enableFeedback, Optional<AlignmentGeometry> alignment, Optional<BorderRadius> borderRadius, Optional<EdgeInsetsGeometry> padding, Optional<Boolean> barrierDismissible) {
    throw new UnsupportedOperationException("dropdownButtonDropdownButton has no default (FFM/comm impl required)");
  }
  default Widget DropdownButton_readBack_hint(Object st) {
    throw new UnsupportedOperationException("DropdownButton_readBack_hint read-back requires FFM/java22");
  }
  default Widget DropdownButton_readBack_disabledHint(Object st) {
    throw new UnsupportedOperationException("DropdownButton_readBack_disabledHint read-back requires FFM/java22");
  }
  default int DropdownButton_readBack_elevation(Object st) {
    throw new UnsupportedOperationException("DropdownButton_readBack_elevation read-back requires FFM/java22");
  }
  default TextStyle DropdownButton_readBack_style(Object st) {
    throw new UnsupportedOperationException("DropdownButton_readBack_style read-back requires FFM/java22");
  }
  default Widget DropdownButton_readBack_underline(Object st) {
    throw new UnsupportedOperationException("DropdownButton_readBack_underline read-back requires FFM/java22");
  }
  default Widget DropdownButton_readBack_icon(Object st) {
    throw new UnsupportedOperationException("DropdownButton_readBack_icon read-back requires FFM/java22");
  }
  default Color DropdownButton_readBack_iconDisabledColor(Object st) {
    throw new UnsupportedOperationException("DropdownButton_readBack_iconDisabledColor read-back requires FFM/java22");
  }
  default Color DropdownButton_readBack_iconEnabledColor(Object st) {
    throw new UnsupportedOperationException("DropdownButton_readBack_iconEnabledColor read-back requires FFM/java22");
  }
  default double DropdownButton_readBack_iconSize(Object st) {
    throw new UnsupportedOperationException("DropdownButton_readBack_iconSize read-back requires FFM/java22");
  }
  default boolean DropdownButton_readBack_isDense(Object st) {
    throw new UnsupportedOperationException("DropdownButton_readBack_isDense read-back requires FFM/java22");
  }
  default boolean DropdownButton_readBack_isExpanded(Object st) {
    throw new UnsupportedOperationException("DropdownButton_readBack_isExpanded read-back requires FFM/java22");
  }
  default double DropdownButton_readBack_itemHeight(Object st) {
    throw new UnsupportedOperationException("DropdownButton_readBack_itemHeight read-back requires FFM/java22");
  }
  default double DropdownButton_readBack_menuWidth(Object st) {
    throw new UnsupportedOperationException("DropdownButton_readBack_menuWidth read-back requires FFM/java22");
  }
  default Color DropdownButton_readBack_focusColor(Object st) {
    throw new UnsupportedOperationException("DropdownButton_readBack_focusColor read-back requires FFM/java22");
  }
  default boolean DropdownButton_readBack_autofocus(Object st) {
    throw new UnsupportedOperationException("DropdownButton_readBack_autofocus read-back requires FFM/java22");
  }
  default Color DropdownButton_readBack_dropdownColor(Object st) {
    throw new UnsupportedOperationException("DropdownButton_readBack_dropdownColor read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry DropdownButton_readBack_padding(Object st) {
    throw new UnsupportedOperationException("DropdownButton_readBack_padding read-back requires FFM/java22");
  }
  default double DropdownButton_readBack_menuMaxHeight(Object st) {
    throw new UnsupportedOperationException("DropdownButton_readBack_menuMaxHeight read-back requires FFM/java22");
  }
  default boolean DropdownButton_readBack_enableFeedback(Object st) {
    throw new UnsupportedOperationException("DropdownButton_readBack_enableFeedback read-back requires FFM/java22");
  }
  default AlignmentGeometry DropdownButton_readBack_alignment(Object st) {
    throw new UnsupportedOperationException("DropdownButton_readBack_alignment read-back requires FFM/java22");
  }
  default BorderRadius DropdownButton_readBack_borderRadius(Object st) {
    throw new UnsupportedOperationException("DropdownButton_readBack_borderRadius read-back requires FFM/java22");
  }
  default boolean DropdownButton_readBack_barrierDismissible(Object st) {
    throw new UnsupportedOperationException("DropdownButton_readBack_barrierDismissible read-back requires FFM/java22");
  }

  default <T> int radioRadio(NativeObj value, Optional<NativeObj> groupValue, Optional<Consumer<NativeObj>> onChanged, Optional<Boolean> toggleable, Optional<Color> activeColor, Optional<Color> fillColor, Optional<Color> focusColor, Optional<Color> hoverColor, Optional<Color> overlayColor, OptionalDouble splashRadius, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<VisualDensity> visualDensity, Optional<Boolean> autofocus, Optional<Boolean> enabled, Optional<Color> backgroundColor, Optional<BorderSide> side, OptionalDouble innerRadius) {
    throw new UnsupportedOperationException("radioRadio has no default (FFM/comm impl required)");
  }
  default <T> int radioAdaptive(NativeObj value, Optional<NativeObj> groupValue, Optional<Consumer<NativeObj>> onChanged, Optional<Boolean> toggleable, Optional<Color> activeColor, Optional<Color> fillColor, Optional<Color> focusColor, Optional<Color> hoverColor, Optional<Color> overlayColor, OptionalDouble splashRadius, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<VisualDensity> visualDensity, Optional<Boolean> autofocus, Optional<Boolean> useCupertinoCheckmarkStyle, Optional<Boolean> enabled, Optional<Color> backgroundColor, Optional<BorderSide> side, OptionalDouble innerRadius) {
    throw new UnsupportedOperationException("radioAdaptive has no default (FFM/comm impl required)");
  }
  default boolean Radio_readBack_toggleable(Object st) {
    throw new UnsupportedOperationException("Radio_readBack_toggleable read-back requires FFM/java22");
  }
  default Color Radio_readBack_activeColor(Object st) {
    throw new UnsupportedOperationException("Radio_readBack_activeColor read-back requires FFM/java22");
  }
  default MaterialTapTargetSize Radio_readBack_materialTapTargetSize(Object st) {
    throw new UnsupportedOperationException("Radio_readBack_materialTapTargetSize read-back requires FFM/java22");
  }
  default VisualDensity Radio_readBack_visualDensity(Object st) {
    throw new UnsupportedOperationException("Radio_readBack_visualDensity read-back requires FFM/java22");
  }
  default Color Radio_readBack_focusColor(Object st) {
    throw new UnsupportedOperationException("Radio_readBack_focusColor read-back requires FFM/java22");
  }
  default Color Radio_readBack_hoverColor(Object st) {
    throw new UnsupportedOperationException("Radio_readBack_hoverColor read-back requires FFM/java22");
  }
  default double Radio_readBack_splashRadius(Object st) {
    throw new UnsupportedOperationException("Radio_readBack_splashRadius read-back requires FFM/java22");
  }
  default boolean Radio_readBack_autofocus(Object st) {
    throw new UnsupportedOperationException("Radio_readBack_autofocus read-back requires FFM/java22");
  }
  default boolean Radio_readBack_useCupertinoCheckmarkStyle(Object st) {
    throw new UnsupportedOperationException("Radio_readBack_useCupertinoCheckmarkStyle read-back requires FFM/java22");
  }
  default boolean Radio_readBack_enabled(Object st) {
    throw new UnsupportedOperationException("Radio_readBack_enabled read-back requires FFM/java22");
  }
  default BorderSide Radio_readBack_side(Object st) {
    throw new UnsupportedOperationException("Radio_readBack_side read-back requires FFM/java22");
  }

  default <T> int radioListTileRadioListTile(NativeObj value, Optional<NativeObj> groupValue, Optional<Consumer<NativeObj>> onChanged, Optional<Boolean> toggleable, Optional<Color> activeColor, Optional<Color> fillColor, Optional<Color> hoverColor, Optional<Color> overlayColor, OptionalDouble splashRadius, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<Widget> title, Optional<Widget> subtitle, Optional<Boolean> isThreeLine, Optional<Boolean> dense, Optional<Widget> secondary, Optional<Boolean> selected, Optional<ListTileControlAffinity> controlAffinity, Optional<Boolean> autofocus, Optional<EdgeInsetsGeometry> contentPadding, Optional<ShapeBorder> shape, Optional<Color> tileColor, Optional<Color> selectedTileColor, Optional<VisualDensity> visualDensity, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> enableFeedback, OptionalDouble horizontalTitleGap, OptionalDouble minVerticalPadding, OptionalDouble minLeadingWidth, OptionalDouble minTileHeight, OptionalDouble radioScaleFactor, Optional<ListTileTitleAlignment> titleAlignment, Optional<Boolean> enabled, Optional<Boolean> internalAddSemanticForOnTap, Optional<Color> radioBackgroundColor, Optional<BorderSide> radioSide, OptionalDouble radioInnerRadius) {
    throw new UnsupportedOperationException("radioListTileRadioListTile has no default (FFM/comm impl required)");
  }
  default <T> int radioListTileAdaptive(NativeObj value, Optional<NativeObj> groupValue, Optional<Consumer<NativeObj>> onChanged, Optional<Boolean> toggleable, Optional<Color> activeColor, Optional<Color> fillColor, Optional<Color> hoverColor, Optional<Color> overlayColor, OptionalDouble splashRadius, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<Widget> title, Optional<Widget> subtitle, Optional<Boolean> isThreeLine, Optional<Boolean> dense, Optional<Widget> secondary, Optional<Boolean> selected, Optional<ListTileControlAffinity> controlAffinity, Optional<Boolean> autofocus, Optional<EdgeInsetsGeometry> contentPadding, Optional<ShapeBorder> shape, Optional<Color> tileColor, Optional<Color> selectedTileColor, Optional<VisualDensity> visualDensity, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> enableFeedback, OptionalDouble horizontalTitleGap, OptionalDouble minVerticalPadding, OptionalDouble minLeadingWidth, OptionalDouble minTileHeight, OptionalDouble radioScaleFactor, Optional<Boolean> enabled, Optional<Boolean> useCupertinoCheckmarkStyle, Optional<ListTileTitleAlignment> titleAlignment, Optional<Boolean> internalAddSemanticForOnTap, Optional<Color> radioBackgroundColor, Optional<BorderSide> radioSide, OptionalDouble radioInnerRadius) {
    throw new UnsupportedOperationException("radioListTileAdaptive has no default (FFM/comm impl required)");
  }
  default boolean RadioListTile_readBack_toggleable(Object st) {
    throw new UnsupportedOperationException("RadioListTile_readBack_toggleable read-back requires FFM/java22");
  }
  default Color RadioListTile_readBack_activeColor(Object st) {
    throw new UnsupportedOperationException("RadioListTile_readBack_activeColor read-back requires FFM/java22");
  }
  default MaterialTapTargetSize RadioListTile_readBack_materialTapTargetSize(Object st) {
    throw new UnsupportedOperationException("RadioListTile_readBack_materialTapTargetSize read-back requires FFM/java22");
  }
  default Color RadioListTile_readBack_hoverColor(Object st) {
    throw new UnsupportedOperationException("RadioListTile_readBack_hoverColor read-back requires FFM/java22");
  }
  default double RadioListTile_readBack_splashRadius(Object st) {
    throw new UnsupportedOperationException("RadioListTile_readBack_splashRadius read-back requires FFM/java22");
  }
  default Widget RadioListTile_readBack_title(Object st) {
    throw new UnsupportedOperationException("RadioListTile_readBack_title read-back requires FFM/java22");
  }
  default Widget RadioListTile_readBack_subtitle(Object st) {
    throw new UnsupportedOperationException("RadioListTile_readBack_subtitle read-back requires FFM/java22");
  }
  default Widget RadioListTile_readBack_secondary(Object st) {
    throw new UnsupportedOperationException("RadioListTile_readBack_secondary read-back requires FFM/java22");
  }
  default boolean RadioListTile_readBack_isThreeLine(Object st) {
    throw new UnsupportedOperationException("RadioListTile_readBack_isThreeLine read-back requires FFM/java22");
  }
  default boolean RadioListTile_readBack_dense(Object st) {
    throw new UnsupportedOperationException("RadioListTile_readBack_dense read-back requires FFM/java22");
  }
  default boolean RadioListTile_readBack_selected(Object st) {
    throw new UnsupportedOperationException("RadioListTile_readBack_selected read-back requires FFM/java22");
  }
  default ListTileControlAffinity RadioListTile_readBack_controlAffinity(Object st) {
    throw new UnsupportedOperationException("RadioListTile_readBack_controlAffinity read-back requires FFM/java22");
  }
  default boolean RadioListTile_readBack_autofocus(Object st) {
    throw new UnsupportedOperationException("RadioListTile_readBack_autofocus read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry RadioListTile_readBack_contentPadding(Object st) {
    throw new UnsupportedOperationException("RadioListTile_readBack_contentPadding read-back requires FFM/java22");
  }
  default ShapeBorder RadioListTile_readBack_shape(Object st) {
    throw new UnsupportedOperationException("RadioListTile_readBack_shape read-back requires FFM/java22");
  }
  default Color RadioListTile_readBack_tileColor(Object st) {
    throw new UnsupportedOperationException("RadioListTile_readBack_tileColor read-back requires FFM/java22");
  }
  default Color RadioListTile_readBack_selectedTileColor(Object st) {
    throw new UnsupportedOperationException("RadioListTile_readBack_selectedTileColor read-back requires FFM/java22");
  }
  default VisualDensity RadioListTile_readBack_visualDensity(Object st) {
    throw new UnsupportedOperationException("RadioListTile_readBack_visualDensity read-back requires FFM/java22");
  }
  default boolean RadioListTile_readBack_enableFeedback(Object st) {
    throw new UnsupportedOperationException("RadioListTile_readBack_enableFeedback read-back requires FFM/java22");
  }
  default double RadioListTile_readBack_horizontalTitleGap(Object st) {
    throw new UnsupportedOperationException("RadioListTile_readBack_horizontalTitleGap read-back requires FFM/java22");
  }
  default double RadioListTile_readBack_minVerticalPadding(Object st) {
    throw new UnsupportedOperationException("RadioListTile_readBack_minVerticalPadding read-back requires FFM/java22");
  }
  default double RadioListTile_readBack_minLeadingWidth(Object st) {
    throw new UnsupportedOperationException("RadioListTile_readBack_minLeadingWidth read-back requires FFM/java22");
  }
  default double RadioListTile_readBack_minTileHeight(Object st) {
    throw new UnsupportedOperationException("RadioListTile_readBack_minTileHeight read-back requires FFM/java22");
  }
  default ListTileTitleAlignment RadioListTile_readBack_titleAlignment(Object st) {
    throw new UnsupportedOperationException("RadioListTile_readBack_titleAlignment read-back requires FFM/java22");
  }
  default boolean RadioListTile_readBack_internalAddSemanticForOnTap(Object st) {
    throw new UnsupportedOperationException("RadioListTile_readBack_internalAddSemanticForOnTap read-back requires FFM/java22");
  }
  default boolean RadioListTile_readBack_useCupertinoCheckmarkStyle(Object st) {
    throw new UnsupportedOperationException("RadioListTile_readBack_useCupertinoCheckmarkStyle read-back requires FFM/java22");
  }
  default double RadioListTile_readBack_radioScaleFactor(Object st) {
    throw new UnsupportedOperationException("RadioListTile_readBack_radioScaleFactor read-back requires FFM/java22");
  }
  default boolean RadioListTile_readBack_enabled(Object st) {
    throw new UnsupportedOperationException("RadioListTile_readBack_enabled read-back requires FFM/java22");
  }
  default BorderSide RadioListTile_readBack_radioSide(Object st) {
    throw new UnsupportedOperationException("RadioListTile_readBack_radioSide read-back requires FFM/java22");
  }
  default boolean RadioListTile_readBack_checked(Object st) {
    throw new UnsupportedOperationException("RadioListTile_readBack_checked read-back requires FFM/java22");
  }

  default int expansionTileExpansionTile(Optional<Widget> leading, Widget title, Optional<Widget> subtitle, Optional<Consumer<Boolean>> onExpansionChanged, Optional<List<Widget>> children, Optional<Widget> trailing, Optional<Boolean> showTrailingIcon, Optional<Boolean> initiallyExpanded, Optional<Boolean> maintainState, Optional<EdgeInsetsGeometry> tilePadding, Optional<CrossAxisAlignment> expandedCrossAxisAlignment, Optional<AlignmentGeometry> expandedAlignment, Optional<EdgeInsetsGeometry> childrenPadding, Optional<Color> backgroundColor, Optional<Color> collapsedBackgroundColor, Optional<Color> textColor, Optional<Color> collapsedTextColor, Optional<Color> iconColor, Optional<Color> collapsedIconColor, Optional<ShapeBorder> shape, Optional<ShapeBorder> collapsedShape, Optional<Clip> clipBehavior, Optional<ListTileControlAffinity> controlAffinity, Optional<Boolean> dense, Optional<Color> splashColor, Optional<VisualDensity> visualDensity, OptionalDouble minTileHeight, Optional<Boolean> enableFeedback, Optional<Boolean> enabled, Optional<Boolean> internalAddSemanticForOnTap) {
    throw new UnsupportedOperationException("expansionTileExpansionTile has no default (FFM/comm impl required)");
  }
  default Widget ExpansionTile_readBack_leading(Object st) {
    throw new UnsupportedOperationException("ExpansionTile_readBack_leading read-back requires FFM/java22");
  }
  default Widget ExpansionTile_readBack_title(Object st) {
    throw new UnsupportedOperationException("ExpansionTile_readBack_title read-back requires FFM/java22");
  }
  default Widget ExpansionTile_readBack_subtitle(Object st) {
    throw new UnsupportedOperationException("ExpansionTile_readBack_subtitle read-back requires FFM/java22");
  }
  default Color ExpansionTile_readBack_backgroundColor(Object st) {
    throw new UnsupportedOperationException("ExpansionTile_readBack_backgroundColor read-back requires FFM/java22");
  }
  default Color ExpansionTile_readBack_collapsedBackgroundColor(Object st) {
    throw new UnsupportedOperationException("ExpansionTile_readBack_collapsedBackgroundColor read-back requires FFM/java22");
  }
  default Widget ExpansionTile_readBack_trailing(Object st) {
    throw new UnsupportedOperationException("ExpansionTile_readBack_trailing read-back requires FFM/java22");
  }
  default boolean ExpansionTile_readBack_showTrailingIcon(Object st) {
    throw new UnsupportedOperationException("ExpansionTile_readBack_showTrailingIcon read-back requires FFM/java22");
  }
  default boolean ExpansionTile_readBack_initiallyExpanded(Object st) {
    throw new UnsupportedOperationException("ExpansionTile_readBack_initiallyExpanded read-back requires FFM/java22");
  }
  default boolean ExpansionTile_readBack_maintainState(Object st) {
    throw new UnsupportedOperationException("ExpansionTile_readBack_maintainState read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry ExpansionTile_readBack_tilePadding(Object st) {
    throw new UnsupportedOperationException("ExpansionTile_readBack_tilePadding read-back requires FFM/java22");
  }
  default AlignmentGeometry ExpansionTile_readBack_expandedAlignment(Object st) {
    throw new UnsupportedOperationException("ExpansionTile_readBack_expandedAlignment read-back requires FFM/java22");
  }
  default CrossAxisAlignment ExpansionTile_readBack_expandedCrossAxisAlignment(Object st) {
    throw new UnsupportedOperationException("ExpansionTile_readBack_expandedCrossAxisAlignment read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry ExpansionTile_readBack_childrenPadding(Object st) {
    throw new UnsupportedOperationException("ExpansionTile_readBack_childrenPadding read-back requires FFM/java22");
  }
  default Color ExpansionTile_readBack_iconColor(Object st) {
    throw new UnsupportedOperationException("ExpansionTile_readBack_iconColor read-back requires FFM/java22");
  }
  default Color ExpansionTile_readBack_collapsedIconColor(Object st) {
    throw new UnsupportedOperationException("ExpansionTile_readBack_collapsedIconColor read-back requires FFM/java22");
  }
  default Color ExpansionTile_readBack_textColor(Object st) {
    throw new UnsupportedOperationException("ExpansionTile_readBack_textColor read-back requires FFM/java22");
  }
  default Color ExpansionTile_readBack_collapsedTextColor(Object st) {
    throw new UnsupportedOperationException("ExpansionTile_readBack_collapsedTextColor read-back requires FFM/java22");
  }
  default ShapeBorder ExpansionTile_readBack_shape(Object st) {
    throw new UnsupportedOperationException("ExpansionTile_readBack_shape read-back requires FFM/java22");
  }
  default ShapeBorder ExpansionTile_readBack_collapsedShape(Object st) {
    throw new UnsupportedOperationException("ExpansionTile_readBack_collapsedShape read-back requires FFM/java22");
  }
  default Clip ExpansionTile_readBack_clipBehavior(Object st) {
    throw new UnsupportedOperationException("ExpansionTile_readBack_clipBehavior read-back requires FFM/java22");
  }
  default ListTileControlAffinity ExpansionTile_readBack_controlAffinity(Object st) {
    throw new UnsupportedOperationException("ExpansionTile_readBack_controlAffinity read-back requires FFM/java22");
  }
  default boolean ExpansionTile_readBack_dense(Object st) {
    throw new UnsupportedOperationException("ExpansionTile_readBack_dense read-back requires FFM/java22");
  }
  default Color ExpansionTile_readBack_splashColor(Object st) {
    throw new UnsupportedOperationException("ExpansionTile_readBack_splashColor read-back requires FFM/java22");
  }
  default VisualDensity ExpansionTile_readBack_visualDensity(Object st) {
    throw new UnsupportedOperationException("ExpansionTile_readBack_visualDensity read-back requires FFM/java22");
  }
  default double ExpansionTile_readBack_minTileHeight(Object st) {
    throw new UnsupportedOperationException("ExpansionTile_readBack_minTileHeight read-back requires FFM/java22");
  }
  default boolean ExpansionTile_readBack_enableFeedback(Object st) {
    throw new UnsupportedOperationException("ExpansionTile_readBack_enableFeedback read-back requires FFM/java22");
  }
  default boolean ExpansionTile_readBack_enabled(Object st) {
    throw new UnsupportedOperationException("ExpansionTile_readBack_enabled read-back requires FFM/java22");
  }
  default boolean ExpansionTile_readBack_internalAddSemanticForOnTap(Object st) {
    throw new UnsupportedOperationException("ExpansionTile_readBack_internalAddSemanticForOnTap read-back requires FFM/java22");
  }

  default int expansionPanelExpansionPanel(BiFunction<BuildContext, Boolean, Widget> headerBuilder, Widget body, Optional<Boolean> isExpanded, Optional<Boolean> canTapOnHeader, Optional<Color> backgroundColor, Optional<Color> splashColor, Optional<Color> highlightColor) {
    throw new UnsupportedOperationException("expansionPanelExpansionPanel has no default (FFM/comm impl required)");
  }

  default int expansionPanelListExpansionPanelList(Optional<List<ExpansionPanel>> children, Optional<BiConsumer<Integer, Boolean>> expansionCallback, Optional<Duration> animationDuration, Optional<Color> dividerColor, OptionalDouble elevation, Optional<Color> expandIconColor, OptionalDouble materialGapSize) {
    throw new UnsupportedOperationException("expansionPanelListExpansionPanelList has no default (FFM/comm impl required)");
  }
  default int expansionPanelListRadio(Optional<List<ExpansionPanel>> children, Optional<BiConsumer<Integer, Boolean>> expansionCallback, Optional<Duration> animationDuration, Optional<NativeObj> initialOpenPanelValue, Optional<Color> dividerColor, OptionalDouble elevation, Optional<Color> expandIconColor, OptionalDouble materialGapSize) {
    throw new UnsupportedOperationException("expansionPanelListRadio has no default (FFM/comm impl required)");
  }
  default Duration ExpansionPanelList_readBack_animationDuration(Object st) {
    throw new UnsupportedOperationException("ExpansionPanelList_readBack_animationDuration read-back requires FFM/java22");
  }
  default EdgeInsets ExpansionPanelList_readBack_expandedHeaderPadding(Object st) {
    throw new UnsupportedOperationException("ExpansionPanelList_readBack_expandedHeaderPadding read-back requires FFM/java22");
  }
  default Color ExpansionPanelList_readBack_dividerColor(Object st) {
    throw new UnsupportedOperationException("ExpansionPanelList_readBack_dividerColor read-back requires FFM/java22");
  }
  default double ExpansionPanelList_readBack_elevation(Object st) {
    throw new UnsupportedOperationException("ExpansionPanelList_readBack_elevation read-back requires FFM/java22");
  }
  default Color ExpansionPanelList_readBack_expandIconColor(Object st) {
    throw new UnsupportedOperationException("ExpansionPanelList_readBack_expandIconColor read-back requires FFM/java22");
  }
  default double ExpansionPanelList_readBack_materialGapSize(Object st) {
    throw new UnsupportedOperationException("ExpansionPanelList_readBack_materialGapSize read-back requires FFM/java22");
  }

  default int expansionPanelRadioExpansionPanelRadio(NativeObj value, BiFunction<BuildContext, Boolean, Widget> headerBuilder, Widget body, Optional<Boolean> canTapOnHeader, Optional<Color> backgroundColor, Optional<Color> splashColor, Optional<Color> highlightColor) {
    throw new UnsupportedOperationException("expansionPanelRadioExpansionPanelRadio has no default (FFM/comm impl required)");
  }

  default int navigationRailNavigationRail(Optional<Color> backgroundColor, Optional<Boolean> extended, Optional<Widget> leading, Optional<Widget> trailing, List<NavigationRailDestination> destinations, OptionalInt selectedIndex, Optional<Consumer<Integer>> onDestinationSelected, OptionalDouble elevation, OptionalDouble groupAlignment, Optional<NavigationRailLabelType> labelType, Optional<TextStyle> unselectedLabelTextStyle, Optional<TextStyle> selectedLabelTextStyle, Optional<IconThemeData> unselectedIconTheme, Optional<IconThemeData> selectedIconTheme, OptionalDouble minWidth, OptionalDouble minExtendedWidth, Optional<Boolean> useIndicator, Optional<Color> indicatorColor, Optional<ShapeBorder> indicatorShape, Optional<Boolean> leadingAtTop, Optional<Boolean> trailingAtBottom, Optional<Boolean> scrollable, Optional<MainAxisAlignment> mainAxisAlignment) {
    throw new UnsupportedOperationException("navigationRailNavigationRail has no default (FFM/comm impl required)");
  }
  default int navigationRailExtendedAnimation(BuildContext context) {
    throw new UnsupportedOperationException("navigationRailExtendedAnimation has no default (FFM/comm impl required)");
  }
  default Color NavigationRail_readBack_backgroundColor(Object st) {
    throw new UnsupportedOperationException("NavigationRail_readBack_backgroundColor read-back requires FFM/java22");
  }
  default boolean NavigationRail_readBack_extended(Object st) {
    throw new UnsupportedOperationException("NavigationRail_readBack_extended read-back requires FFM/java22");
  }
  default Widget NavigationRail_readBack_leading(Object st) {
    throw new UnsupportedOperationException("NavigationRail_readBack_leading read-back requires FFM/java22");
  }
  default Widget NavigationRail_readBack_trailing(Object st) {
    throw new UnsupportedOperationException("NavigationRail_readBack_trailing read-back requires FFM/java22");
  }
  default int NavigationRail_readBack_selectedIndex(Object st) {
    throw new UnsupportedOperationException("NavigationRail_readBack_selectedIndex read-back requires FFM/java22");
  }
  default double NavigationRail_readBack_elevation(Object st) {
    throw new UnsupportedOperationException("NavigationRail_readBack_elevation read-back requires FFM/java22");
  }
  default double NavigationRail_readBack_groupAlignment(Object st) {
    throw new UnsupportedOperationException("NavigationRail_readBack_groupAlignment read-back requires FFM/java22");
  }
  default NavigationRailLabelType NavigationRail_readBack_labelType(Object st) {
    throw new UnsupportedOperationException("NavigationRail_readBack_labelType read-back requires FFM/java22");
  }
  default TextStyle NavigationRail_readBack_unselectedLabelTextStyle(Object st) {
    throw new UnsupportedOperationException("NavigationRail_readBack_unselectedLabelTextStyle read-back requires FFM/java22");
  }
  default TextStyle NavigationRail_readBack_selectedLabelTextStyle(Object st) {
    throw new UnsupportedOperationException("NavigationRail_readBack_selectedLabelTextStyle read-back requires FFM/java22");
  }
  default IconThemeData NavigationRail_readBack_unselectedIconTheme(Object st) {
    throw new UnsupportedOperationException("NavigationRail_readBack_unselectedIconTheme read-back requires FFM/java22");
  }
  default IconThemeData NavigationRail_readBack_selectedIconTheme(Object st) {
    throw new UnsupportedOperationException("NavigationRail_readBack_selectedIconTheme read-back requires FFM/java22");
  }
  default double NavigationRail_readBack_minWidth(Object st) {
    throw new UnsupportedOperationException("NavigationRail_readBack_minWidth read-back requires FFM/java22");
  }
  default double NavigationRail_readBack_minExtendedWidth(Object st) {
    throw new UnsupportedOperationException("NavigationRail_readBack_minExtendedWidth read-back requires FFM/java22");
  }
  default boolean NavigationRail_readBack_useIndicator(Object st) {
    throw new UnsupportedOperationException("NavigationRail_readBack_useIndicator read-back requires FFM/java22");
  }
  default Color NavigationRail_readBack_indicatorColor(Object st) {
    throw new UnsupportedOperationException("NavigationRail_readBack_indicatorColor read-back requires FFM/java22");
  }
  default ShapeBorder NavigationRail_readBack_indicatorShape(Object st) {
    throw new UnsupportedOperationException("NavigationRail_readBack_indicatorShape read-back requires FFM/java22");
  }
  default boolean NavigationRail_readBack_leadingAtTop(Object st) {
    throw new UnsupportedOperationException("NavigationRail_readBack_leadingAtTop read-back requires FFM/java22");
  }
  default boolean NavigationRail_readBack_trailingAtBottom(Object st) {
    throw new UnsupportedOperationException("NavigationRail_readBack_trailingAtBottom read-back requires FFM/java22");
  }
  default boolean NavigationRail_readBack_scrollable(Object st) {
    throw new UnsupportedOperationException("NavigationRail_readBack_scrollable read-back requires FFM/java22");
  }
  default MainAxisAlignment NavigationRail_readBack_mainAxisAlignment(Object st) {
    throw new UnsupportedOperationException("NavigationRail_readBack_mainAxisAlignment read-back requires FFM/java22");
  }

  default int navigationRailDestinationNavigationRailDestination(Widget icon, Optional<Widget> selectedIcon, Optional<Color> indicatorColor, Optional<ShapeBorder> indicatorShape, Widget label, Optional<EdgeInsetsGeometry> padding, Optional<Boolean> disabled) {
    throw new UnsupportedOperationException("navigationRailDestinationNavigationRailDestination has no default (FFM/comm impl required)");
  }

  default int navigationBarNavigationBar(Optional<Duration> animationDuration, OptionalInt selectedIndex, List<Widget> destinations, Optional<Consumer<Integer>> onDestinationSelected, Optional<Color> backgroundColor, OptionalDouble elevation, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, Optional<Color> indicatorColor, Optional<ShapeBorder> indicatorShape, OptionalDouble height, Optional<NavigationDestinationLabelBehavior> labelBehavior, Optional<Color> overlayColor, Optional<TextStyle> labelTextStyle, Optional<EdgeInsetsGeometry> labelPadding, Optional<Boolean> maintainBottomViewPadding) {
    throw new UnsupportedOperationException("navigationBarNavigationBar has no default (FFM/comm impl required)");
  }
  default Duration NavigationBar_readBack_animationDuration(Object st) {
    throw new UnsupportedOperationException("NavigationBar_readBack_animationDuration read-back requires FFM/java22");
  }
  default int NavigationBar_readBack_selectedIndex(Object st) {
    throw new UnsupportedOperationException("NavigationBar_readBack_selectedIndex read-back requires FFM/java22");
  }
  default Color NavigationBar_readBack_backgroundColor(Object st) {
    throw new UnsupportedOperationException("NavigationBar_readBack_backgroundColor read-back requires FFM/java22");
  }
  default double NavigationBar_readBack_elevation(Object st) {
    throw new UnsupportedOperationException("NavigationBar_readBack_elevation read-back requires FFM/java22");
  }
  default Color NavigationBar_readBack_shadowColor(Object st) {
    throw new UnsupportedOperationException("NavigationBar_readBack_shadowColor read-back requires FFM/java22");
  }
  default Color NavigationBar_readBack_surfaceTintColor(Object st) {
    throw new UnsupportedOperationException("NavigationBar_readBack_surfaceTintColor read-back requires FFM/java22");
  }
  default Color NavigationBar_readBack_indicatorColor(Object st) {
    throw new UnsupportedOperationException("NavigationBar_readBack_indicatorColor read-back requires FFM/java22");
  }
  default ShapeBorder NavigationBar_readBack_indicatorShape(Object st) {
    throw new UnsupportedOperationException("NavigationBar_readBack_indicatorShape read-back requires FFM/java22");
  }
  default double NavigationBar_readBack_height(Object st) {
    throw new UnsupportedOperationException("NavigationBar_readBack_height read-back requires FFM/java22");
  }
  default NavigationDestinationLabelBehavior NavigationBar_readBack_labelBehavior(Object st) {
    throw new UnsupportedOperationException("NavigationBar_readBack_labelBehavior read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry NavigationBar_readBack_labelPadding(Object st) {
    throw new UnsupportedOperationException("NavigationBar_readBack_labelPadding read-back requires FFM/java22");
  }
  default boolean NavigationBar_readBack_maintainBottomViewPadding(Object st) {
    throw new UnsupportedOperationException("NavigationBar_readBack_maintainBottomViewPadding read-back requires FFM/java22");
  }

  default int navigationDestinationNavigationDestination(Widget icon, Optional<Widget> selectedIcon, String label, Optional<String> tooltip, Optional<Boolean> enabled) {
    throw new UnsupportedOperationException("navigationDestinationNavigationDestination has no default (FFM/comm impl required)");
  }
  default Widget NavigationDestination_readBack_icon(Object st) {
    throw new UnsupportedOperationException("NavigationDestination_readBack_icon read-back requires FFM/java22");
  }
  default Widget NavigationDestination_readBack_selectedIcon(Object st) {
    throw new UnsupportedOperationException("NavigationDestination_readBack_selectedIcon read-back requires FFM/java22");
  }
  default String NavigationDestination_readBack_label(Object st) {
    throw new UnsupportedOperationException("NavigationDestination_readBack_label read-back requires FFM/java22");
  }
  default String NavigationDestination_readBack_tooltip(Object st) {
    throw new UnsupportedOperationException("NavigationDestination_readBack_tooltip read-back requires FFM/java22");
  }
  default boolean NavigationDestination_readBack_enabled(Object st) {
    throw new UnsupportedOperationException("NavigationDestination_readBack_enabled read-back requires FFM/java22");
  }

  default int navigationDrawerNavigationDrawer(List<Widget> children, Optional<Widget> header, Optional<Widget> footer, Optional<Color> backgroundColor, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, OptionalDouble elevation, Optional<Color> indicatorColor, Optional<ShapeBorder> indicatorShape, Optional<Consumer<Integer>> onDestinationSelected, OptionalInt selectedIndex, Optional<EdgeInsetsGeometry> tilePadding) {
    throw new UnsupportedOperationException("navigationDrawerNavigationDrawer has no default (FFM/comm impl required)");
  }
  default Color NavigationDrawer_readBack_backgroundColor(Object st) {
    throw new UnsupportedOperationException("NavigationDrawer_readBack_backgroundColor read-back requires FFM/java22");
  }
  default Color NavigationDrawer_readBack_shadowColor(Object st) {
    throw new UnsupportedOperationException("NavigationDrawer_readBack_shadowColor read-back requires FFM/java22");
  }
  default Color NavigationDrawer_readBack_surfaceTintColor(Object st) {
    throw new UnsupportedOperationException("NavigationDrawer_readBack_surfaceTintColor read-back requires FFM/java22");
  }
  default double NavigationDrawer_readBack_elevation(Object st) {
    throw new UnsupportedOperationException("NavigationDrawer_readBack_elevation read-back requires FFM/java22");
  }
  default Color NavigationDrawer_readBack_indicatorColor(Object st) {
    throw new UnsupportedOperationException("NavigationDrawer_readBack_indicatorColor read-back requires FFM/java22");
  }
  default ShapeBorder NavigationDrawer_readBack_indicatorShape(Object st) {
    throw new UnsupportedOperationException("NavigationDrawer_readBack_indicatorShape read-back requires FFM/java22");
  }
  default Widget NavigationDrawer_readBack_header(Object st) {
    throw new UnsupportedOperationException("NavigationDrawer_readBack_header read-back requires FFM/java22");
  }
  default Widget NavigationDrawer_readBack_footer(Object st) {
    throw new UnsupportedOperationException("NavigationDrawer_readBack_footer read-back requires FFM/java22");
  }
  default int NavigationDrawer_readBack_selectedIndex(Object st) {
    throw new UnsupportedOperationException("NavigationDrawer_readBack_selectedIndex read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry NavigationDrawer_readBack_tilePadding(Object st) {
    throw new UnsupportedOperationException("NavigationDrawer_readBack_tilePadding read-back requires FFM/java22");
  }

  default int navigationDrawerDestinationNavigationDrawerDestination(Optional<Color> backgroundColor, Widget icon, Optional<Widget> selectedIcon, Widget label, Optional<Boolean> enabled) {
    throw new UnsupportedOperationException("navigationDrawerDestinationNavigationDrawerDestination has no default (FFM/comm impl required)");
  }
  default Color NavigationDrawerDestination_readBack_backgroundColor(Object st) {
    throw new UnsupportedOperationException("NavigationDrawerDestination_readBack_backgroundColor read-back requires FFM/java22");
  }
  default Widget NavigationDrawerDestination_readBack_icon(Object st) {
    throw new UnsupportedOperationException("NavigationDrawerDestination_readBack_icon read-back requires FFM/java22");
  }
  default Widget NavigationDrawerDestination_readBack_selectedIcon(Object st) {
    throw new UnsupportedOperationException("NavigationDrawerDestination_readBack_selectedIcon read-back requires FFM/java22");
  }
  default Widget NavigationDrawerDestination_readBack_label(Object st) {
    throw new UnsupportedOperationException("NavigationDrawerDestination_readBack_label read-back requires FFM/java22");
  }
  default boolean NavigationDrawerDestination_readBack_enabled(Object st) {
    throw new UnsupportedOperationException("NavigationDrawerDestination_readBack_enabled read-back requires FFM/java22");
  }

  default <T> int popupMenuButtonPopupMenuButton(Function<BuildContext, List<PopupMenuEntry>> itemBuilder, Optional<NativeObj> initialValue, Optional<Runnable> onOpened, Optional<Consumer<NativeObj>> onSelected, Optional<Runnable> onCanceled, Optional<String> tooltip, OptionalDouble elevation, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, Optional<EdgeInsetsGeometry> padding, Optional<EdgeInsetsGeometry> menuPadding, Optional<Widget> child, Optional<BorderRadius> borderRadius, OptionalDouble splashRadius, Optional<Widget> icon, OptionalDouble iconSize, Optional<Offset> offset, Optional<Boolean> enabled, Optional<ShapeBorder> shape, Optional<Color> color, Optional<Color> iconColor, Optional<Boolean> enableFeedback, Optional<BoxConstraints> constraints, Optional<PopupMenuPosition> position, Optional<Clip> clipBehavior, Optional<Boolean> useRootNavigator, Optional<Boolean> requestFocus) {
    throw new UnsupportedOperationException("popupMenuButtonPopupMenuButton has no default (FFM/comm impl required)");
  }
  default String PopupMenuButton_readBack_tooltip(Object st) {
    throw new UnsupportedOperationException("PopupMenuButton_readBack_tooltip read-back requires FFM/java22");
  }
  default double PopupMenuButton_readBack_elevation(Object st) {
    throw new UnsupportedOperationException("PopupMenuButton_readBack_elevation read-back requires FFM/java22");
  }
  default Color PopupMenuButton_readBack_shadowColor(Object st) {
    throw new UnsupportedOperationException("PopupMenuButton_readBack_shadowColor read-back requires FFM/java22");
  }
  default Color PopupMenuButton_readBack_surfaceTintColor(Object st) {
    throw new UnsupportedOperationException("PopupMenuButton_readBack_surfaceTintColor read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry PopupMenuButton_readBack_padding(Object st) {
    throw new UnsupportedOperationException("PopupMenuButton_readBack_padding read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry PopupMenuButton_readBack_menuPadding(Object st) {
    throw new UnsupportedOperationException("PopupMenuButton_readBack_menuPadding read-back requires FFM/java22");
  }
  default double PopupMenuButton_readBack_splashRadius(Object st) {
    throw new UnsupportedOperationException("PopupMenuButton_readBack_splashRadius read-back requires FFM/java22");
  }
  default Widget PopupMenuButton_readBack_child(Object st) {
    throw new UnsupportedOperationException("PopupMenuButton_readBack_child read-back requires FFM/java22");
  }
  default BorderRadius PopupMenuButton_readBack_borderRadius(Object st) {
    throw new UnsupportedOperationException("PopupMenuButton_readBack_borderRadius read-back requires FFM/java22");
  }
  default Widget PopupMenuButton_readBack_icon(Object st) {
    throw new UnsupportedOperationException("PopupMenuButton_readBack_icon read-back requires FFM/java22");
  }
  default Offset PopupMenuButton_readBack_offset(Object st) {
    throw new UnsupportedOperationException("PopupMenuButton_readBack_offset read-back requires FFM/java22");
  }
  default boolean PopupMenuButton_readBack_enabled(Object st) {
    throw new UnsupportedOperationException("PopupMenuButton_readBack_enabled read-back requires FFM/java22");
  }
  default ShapeBorder PopupMenuButton_readBack_shape(Object st) {
    throw new UnsupportedOperationException("PopupMenuButton_readBack_shape read-back requires FFM/java22");
  }
  default Color PopupMenuButton_readBack_color(Object st) {
    throw new UnsupportedOperationException("PopupMenuButton_readBack_color read-back requires FFM/java22");
  }
  default Color PopupMenuButton_readBack_iconColor(Object st) {
    throw new UnsupportedOperationException("PopupMenuButton_readBack_iconColor read-back requires FFM/java22");
  }
  default boolean PopupMenuButton_readBack_enableFeedback(Object st) {
    throw new UnsupportedOperationException("PopupMenuButton_readBack_enableFeedback read-back requires FFM/java22");
  }
  default double PopupMenuButton_readBack_iconSize(Object st) {
    throw new UnsupportedOperationException("PopupMenuButton_readBack_iconSize read-back requires FFM/java22");
  }
  default BoxConstraints PopupMenuButton_readBack_constraints(Object st) {
    throw new UnsupportedOperationException("PopupMenuButton_readBack_constraints read-back requires FFM/java22");
  }
  default PopupMenuPosition PopupMenuButton_readBack_position(Object st) {
    throw new UnsupportedOperationException("PopupMenuButton_readBack_position read-back requires FFM/java22");
  }
  default Clip PopupMenuButton_readBack_clipBehavior(Object st) {
    throw new UnsupportedOperationException("PopupMenuButton_readBack_clipBehavior read-back requires FFM/java22");
  }
  default boolean PopupMenuButton_readBack_useRootNavigator(Object st) {
    throw new UnsupportedOperationException("PopupMenuButton_readBack_useRootNavigator read-back requires FFM/java22");
  }
  default boolean PopupMenuButton_readBack_requestFocus(Object st) {
    throw new UnsupportedOperationException("PopupMenuButton_readBack_requestFocus read-back requires FFM/java22");
  }

  default <T> int popupMenuItemPopupMenuItem(Optional<NativeObj> value, Optional<Runnable> onTap, Optional<Boolean> enabled, OptionalDouble height, Optional<EdgeInsets> padding, Optional<TextStyle> textStyle, Optional<TextStyle> labelTextStyle, Optional<Widget> child) {
    throw new UnsupportedOperationException("popupMenuItemPopupMenuItem has no default (FFM/comm impl required)");
  }
  default boolean PopupMenuItem_readBack_enabled(Object st) {
    throw new UnsupportedOperationException("PopupMenuItem_readBack_enabled read-back requires FFM/java22");
  }
  default double PopupMenuItem_readBack_height(Object st) {
    throw new UnsupportedOperationException("PopupMenuItem_readBack_height read-back requires FFM/java22");
  }
  default EdgeInsets PopupMenuItem_readBack_padding(Object st) {
    throw new UnsupportedOperationException("PopupMenuItem_readBack_padding read-back requires FFM/java22");
  }
  default TextStyle PopupMenuItem_readBack_textStyle(Object st) {
    throw new UnsupportedOperationException("PopupMenuItem_readBack_textStyle read-back requires FFM/java22");
  }
  default Widget PopupMenuItem_readBack_child(Object st) {
    throw new UnsupportedOperationException("PopupMenuItem_readBack_child read-back requires FFM/java22");
  }

  default int popupMenuDividerPopupMenuDivider(OptionalDouble height, OptionalDouble thickness, OptionalDouble indent, OptionalDouble endIndent, Optional<BorderRadiusGeometry> radius, Optional<Color> color) {
    throw new UnsupportedOperationException("popupMenuDividerPopupMenuDivider has no default (FFM/comm impl required)");
  }
  default double PopupMenuDivider_readBack_height(Object st) {
    throw new UnsupportedOperationException("PopupMenuDivider_readBack_height read-back requires FFM/java22");
  }
  default double PopupMenuDivider_readBack_thickness(Object st) {
    throw new UnsupportedOperationException("PopupMenuDivider_readBack_thickness read-back requires FFM/java22");
  }
  default double PopupMenuDivider_readBack_indent(Object st) {
    throw new UnsupportedOperationException("PopupMenuDivider_readBack_indent read-back requires FFM/java22");
  }
  default double PopupMenuDivider_readBack_endIndent(Object st) {
    throw new UnsupportedOperationException("PopupMenuDivider_readBack_endIndent read-back requires FFM/java22");
  }
  default BorderRadiusGeometry PopupMenuDivider_readBack_radius(Object st) {
    throw new UnsupportedOperationException("PopupMenuDivider_readBack_radius read-back requires FFM/java22");
  }
  default Color PopupMenuDivider_readBack_color(Object st) {
    throw new UnsupportedOperationException("PopupMenuDivider_readBack_color read-back requires FFM/java22");
  }

  default <T> int checkedPopupMenuItemCheckedPopupMenuItem(Optional<NativeObj> value, Optional<Boolean> checked, Optional<Boolean> enabled, Optional<EdgeInsets> padding, OptionalDouble height, Optional<TextStyle> labelTextStyle, Optional<Widget> child, Optional<Runnable> onTap) {
    throw new UnsupportedOperationException("checkedPopupMenuItemCheckedPopupMenuItem has no default (FFM/comm impl required)");
  }
  default boolean CheckedPopupMenuItem_readBack_checked(Object st) {
    throw new UnsupportedOperationException("CheckedPopupMenuItem_readBack_checked read-back requires FFM/java22");
  }

  default int circleAvatarCircleAvatar(Optional<Widget> child, Optional<Color> backgroundColor, Optional<Color> foregroundColor, OptionalDouble radius, OptionalDouble minRadius, OptionalDouble maxRadius) {
    throw new UnsupportedOperationException("circleAvatarCircleAvatar has no default (FFM/comm impl required)");
  }
  default Widget CircleAvatar_readBack_child(Object st) {
    throw new UnsupportedOperationException("CircleAvatar_readBack_child read-back requires FFM/java22");
  }
  default Color CircleAvatar_readBack_backgroundColor(Object st) {
    throw new UnsupportedOperationException("CircleAvatar_readBack_backgroundColor read-back requires FFM/java22");
  }
  default Color CircleAvatar_readBack_foregroundColor(Object st) {
    throw new UnsupportedOperationException("CircleAvatar_readBack_foregroundColor read-back requires FFM/java22");
  }
  default double CircleAvatar_readBack_radius(Object st) {
    throw new UnsupportedOperationException("CircleAvatar_readBack_radius read-back requires FFM/java22");
  }
  default double CircleAvatar_readBack_minRadius(Object st) {
    throw new UnsupportedOperationException("CircleAvatar_readBack_minRadius read-back requires FFM/java22");
  }
  default double CircleAvatar_readBack_maxRadius(Object st) {
    throw new UnsupportedOperationException("CircleAvatar_readBack_maxRadius read-back requires FFM/java22");
  }

  default int scrollbarScrollbar(Widget child, Optional<Boolean> thumbVisibility, Optional<Boolean> trackVisibility, OptionalDouble thickness, Optional<Radius> radius, Optional<Boolean> interactive, Optional<ScrollbarOrientation> scrollbarOrientation) {
    throw new UnsupportedOperationException("scrollbarScrollbar has no default (FFM/comm impl required)");
  }
  default Widget Scrollbar_readBack_child(Object st) {
    throw new UnsupportedOperationException("Scrollbar_readBack_child read-back requires FFM/java22");
  }
  default boolean Scrollbar_readBack_thumbVisibility(Object st) {
    throw new UnsupportedOperationException("Scrollbar_readBack_thumbVisibility read-back requires FFM/java22");
  }
  default boolean Scrollbar_readBack_trackVisibility(Object st) {
    throw new UnsupportedOperationException("Scrollbar_readBack_trackVisibility read-back requires FFM/java22");
  }
  default double Scrollbar_readBack_thickness(Object st) {
    throw new UnsupportedOperationException("Scrollbar_readBack_thickness read-back requires FFM/java22");
  }
  default Radius Scrollbar_readBack_radius(Object st) {
    throw new UnsupportedOperationException("Scrollbar_readBack_radius read-back requires FFM/java22");
  }
  default boolean Scrollbar_readBack_interactive(Object st) {
    throw new UnsupportedOperationException("Scrollbar_readBack_interactive read-back requires FFM/java22");
  }
  default ScrollbarOrientation Scrollbar_readBack_scrollbarOrientation(Object st) {
    throw new UnsupportedOperationException("Scrollbar_readBack_scrollbarOrientation read-back requires FFM/java22");
  }

  default int menuBarMenuBar(Optional<Clip> clipBehavior, List<Widget> children) {
    throw new UnsupportedOperationException("menuBarMenuBar has no default (FFM/comm impl required)");
  }
  default Clip MenuBar_readBack_clipBehavior(Object st) {
    throw new UnsupportedOperationException("MenuBar_readBack_clipBehavior read-back requires FFM/java22");
  }

  default int menuAnchorMenuAnchor(Optional<Offset> alignmentOffset, Optional<EdgeInsetsGeometry> reservedPadding, Optional<Clip> clipBehavior, Optional<Boolean> anchorTapClosesMenu, Optional<Boolean> consumeOutsideTap, Optional<Runnable> onOpen, Optional<Runnable> onClose, Optional<Boolean> crossAxisUnconstrained, Optional<Boolean> useRootOverlay, Optional<Boolean> animated, Optional<Consumer<AnimationStatus>> onAnimationStatusChanged, List<Widget> menuChildren, Optional<Widget> child) {
    throw new UnsupportedOperationException("menuAnchorMenuAnchor has no default (FFM/comm impl required)");
  }
  default Offset MenuAnchor_readBack_alignmentOffset(Object st) {
    throw new UnsupportedOperationException("MenuAnchor_readBack_alignmentOffset read-back requires FFM/java22");
  }
  default Clip MenuAnchor_readBack_clipBehavior(Object st) {
    throw new UnsupportedOperationException("MenuAnchor_readBack_clipBehavior read-back requires FFM/java22");
  }
  default boolean MenuAnchor_readBack_anchorTapClosesMenu(Object st) {
    throw new UnsupportedOperationException("MenuAnchor_readBack_anchorTapClosesMenu read-back requires FFM/java22");
  }
  default boolean MenuAnchor_readBack_consumeOutsideTap(Object st) {
    throw new UnsupportedOperationException("MenuAnchor_readBack_consumeOutsideTap read-back requires FFM/java22");
  }
  default boolean MenuAnchor_readBack_crossAxisUnconstrained(Object st) {
    throw new UnsupportedOperationException("MenuAnchor_readBack_crossAxisUnconstrained read-back requires FFM/java22");
  }
  default boolean MenuAnchor_readBack_useRootOverlay(Object st) {
    throw new UnsupportedOperationException("MenuAnchor_readBack_useRootOverlay read-back requires FFM/java22");
  }
  default boolean MenuAnchor_readBack_animated(Object st) {
    throw new UnsupportedOperationException("MenuAnchor_readBack_animated read-back requires FFM/java22");
  }
  default Widget MenuAnchor_readBack_child(Object st) {
    throw new UnsupportedOperationException("MenuAnchor_readBack_child read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry MenuAnchor_readBack_reservedPadding(Object st) {
    throw new UnsupportedOperationException("MenuAnchor_readBack_reservedPadding read-back requires FFM/java22");
  }

  default int submenuButtonSubmenuButton(Optional<Consumer<Boolean>> onHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Runnable> onOpen, Optional<Runnable> onClose, Optional<Offset> alignmentOffset, Optional<Clip> clipBehavior, Optional<Widget> leadingIcon, Optional<Widget> trailingIcon, Optional<Widget> submenuIcon, Optional<Boolean> useRootOverlay, Optional<Duration> hoverOpenDelay, Optional<Boolean> animated, Optional<Consumer<AnimationStatus>> onAnimationStatusChanged, List<Widget> menuChildren, Optional<Widget> child) {
    throw new UnsupportedOperationException("submenuButtonSubmenuButton has no default (FFM/comm impl required)");
  }
  default Offset SubmenuButton_readBack_alignmentOffset(Object st) {
    throw new UnsupportedOperationException("SubmenuButton_readBack_alignmentOffset read-back requires FFM/java22");
  }
  default Clip SubmenuButton_readBack_clipBehavior(Object st) {
    throw new UnsupportedOperationException("SubmenuButton_readBack_clipBehavior read-back requires FFM/java22");
  }
  default Widget SubmenuButton_readBack_leadingIcon(Object st) {
    throw new UnsupportedOperationException("SubmenuButton_readBack_leadingIcon read-back requires FFM/java22");
  }
  default Widget SubmenuButton_readBack_trailingIcon(Object st) {
    throw new UnsupportedOperationException("SubmenuButton_readBack_trailingIcon read-back requires FFM/java22");
  }
  default boolean SubmenuButton_readBack_useRootOverlay(Object st) {
    throw new UnsupportedOperationException("SubmenuButton_readBack_useRootOverlay read-back requires FFM/java22");
  }
  default Duration SubmenuButton_readBack_hoverOpenDelay(Object st) {
    throw new UnsupportedOperationException("SubmenuButton_readBack_hoverOpenDelay read-back requires FFM/java22");
  }
  default boolean SubmenuButton_readBack_animated(Object st) {
    throw new UnsupportedOperationException("SubmenuButton_readBack_animated read-back requires FFM/java22");
  }
  default Widget SubmenuButton_readBack_child(Object st) {
    throw new UnsupportedOperationException("SubmenuButton_readBack_child read-back requires FFM/java22");
  }

  default int menuItemButtonMenuItemButton(Optional<Runnable> onPressed, Optional<Consumer<Boolean>> onHover, Optional<Boolean> requestFocusOnHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<String> semanticsLabel, Optional<Clip> clipBehavior, Optional<Widget> leadingIcon, Optional<Widget> trailingIcon, Optional<Boolean> closeOnActivate, Optional<Axis> overflowAxis, Optional<Widget> child) {
    throw new UnsupportedOperationException("menuItemButtonMenuItemButton has no default (FFM/comm impl required)");
  }
  default boolean MenuItemButton_readBack_requestFocusOnHover(Object st) {
    throw new UnsupportedOperationException("MenuItemButton_readBack_requestFocusOnHover read-back requires FFM/java22");
  }
  default boolean MenuItemButton_readBack_autofocus(Object st) {
    throw new UnsupportedOperationException("MenuItemButton_readBack_autofocus read-back requires FFM/java22");
  }
  default String MenuItemButton_readBack_semanticsLabel(Object st) {
    throw new UnsupportedOperationException("MenuItemButton_readBack_semanticsLabel read-back requires FFM/java22");
  }
  default Clip MenuItemButton_readBack_clipBehavior(Object st) {
    throw new UnsupportedOperationException("MenuItemButton_readBack_clipBehavior read-back requires FFM/java22");
  }
  default Widget MenuItemButton_readBack_leadingIcon(Object st) {
    throw new UnsupportedOperationException("MenuItemButton_readBack_leadingIcon read-back requires FFM/java22");
  }
  default Widget MenuItemButton_readBack_trailingIcon(Object st) {
    throw new UnsupportedOperationException("MenuItemButton_readBack_trailingIcon read-back requires FFM/java22");
  }
  default boolean MenuItemButton_readBack_closeOnActivate(Object st) {
    throw new UnsupportedOperationException("MenuItemButton_readBack_closeOnActivate read-back requires FFM/java22");
  }
  default Axis MenuItemButton_readBack_overflowAxis(Object st) {
    throw new UnsupportedOperationException("MenuItemButton_readBack_overflowAxis read-back requires FFM/java22");
  }
  default Widget MenuItemButton_readBack_child(Object st) {
    throw new UnsupportedOperationException("MenuItemButton_readBack_child read-back requires FFM/java22");
  }
  default boolean MenuItemButton_readBack_enabled(Object st) {
    throw new UnsupportedOperationException("MenuItemButton_readBack_enabled read-back requires FFM/java22");
  }

  default int checkboxMenuButtonCheckboxMenuButton(Optional<Boolean> value, Optional<Boolean> tristate, Optional<Boolean> isError, Optional<Consumer<Boolean>> onChanged, Optional<Consumer<Boolean>> onHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Clip> clipBehavior, Optional<Widget> trailingIcon, Optional<Boolean> closeOnActivate, Optional<Widget> child) {
    throw new UnsupportedOperationException("checkboxMenuButtonCheckboxMenuButton has no default (FFM/comm impl required)");
  }
  default boolean CheckboxMenuButton_readBack_value(Object st) {
    throw new UnsupportedOperationException("CheckboxMenuButton_readBack_value read-back requires FFM/java22");
  }
  default boolean CheckboxMenuButton_readBack_tristate(Object st) {
    throw new UnsupportedOperationException("CheckboxMenuButton_readBack_tristate read-back requires FFM/java22");
  }
  default boolean CheckboxMenuButton_readBack_isError(Object st) {
    throw new UnsupportedOperationException("CheckboxMenuButton_readBack_isError read-back requires FFM/java22");
  }
  default Clip CheckboxMenuButton_readBack_clipBehavior(Object st) {
    throw new UnsupportedOperationException("CheckboxMenuButton_readBack_clipBehavior read-back requires FFM/java22");
  }
  default Widget CheckboxMenuButton_readBack_trailingIcon(Object st) {
    throw new UnsupportedOperationException("CheckboxMenuButton_readBack_trailingIcon read-back requires FFM/java22");
  }
  default boolean CheckboxMenuButton_readBack_closeOnActivate(Object st) {
    throw new UnsupportedOperationException("CheckboxMenuButton_readBack_closeOnActivate read-back requires FFM/java22");
  }
  default Widget CheckboxMenuButton_readBack_child(Object st) {
    throw new UnsupportedOperationException("CheckboxMenuButton_readBack_child read-back requires FFM/java22");
  }
  default boolean CheckboxMenuButton_readBack_enabled(Object st) {
    throw new UnsupportedOperationException("CheckboxMenuButton_readBack_enabled read-back requires FFM/java22");
  }

  default <T> int radioMenuButtonRadioMenuButton(NativeObj value, Optional<NativeObj> groupValue, Optional<Consumer<NativeObj>> onChanged, Optional<Boolean> toggleable, Optional<Consumer<Boolean>> onHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Clip> clipBehavior, Optional<Widget> trailingIcon, Optional<Boolean> closeOnActivate, Optional<Widget> child) {
    throw new UnsupportedOperationException("radioMenuButtonRadioMenuButton has no default (FFM/comm impl required)");
  }
  default boolean RadioMenuButton_readBack_toggleable(Object st) {
    throw new UnsupportedOperationException("RadioMenuButton_readBack_toggleable read-back requires FFM/java22");
  }
  default Clip RadioMenuButton_readBack_clipBehavior(Object st) {
    throw new UnsupportedOperationException("RadioMenuButton_readBack_clipBehavior read-back requires FFM/java22");
  }
  default Widget RadioMenuButton_readBack_trailingIcon(Object st) {
    throw new UnsupportedOperationException("RadioMenuButton_readBack_trailingIcon read-back requires FFM/java22");
  }
  default boolean RadioMenuButton_readBack_closeOnActivate(Object st) {
    throw new UnsupportedOperationException("RadioMenuButton_readBack_closeOnActivate read-back requires FFM/java22");
  }
  default Widget RadioMenuButton_readBack_child(Object st) {
    throw new UnsupportedOperationException("RadioMenuButton_readBack_child read-back requires FFM/java22");
  }
  default boolean RadioMenuButton_readBack_enabled(Object st) {
    throw new UnsupportedOperationException("RadioMenuButton_readBack_enabled read-back requires FFM/java22");
  }

  default int datePickerDialogDatePickerDialog(Optional<DateTime> initialDate, DateTime firstDate, DateTime lastDate, Optional<DateTime> currentDate, Optional<DatePickerEntryMode> initialEntryMode, Optional<Function<DateTime, Boolean>> selectableDayPredicate, Optional<String> cancelText, Optional<String> confirmText, Optional<String> helpText, Optional<DatePickerMode> initialCalendarMode, Optional<String> errorFormatText, Optional<String> errorInvalidText, Optional<String> fieldHintText, Optional<String> fieldLabelText, Optional<String> restorationId, Optional<Consumer<DatePickerEntryMode>> onDatePickerModeChange, Optional<Icon> switchToInputEntryModeIcon, Optional<Icon> switchToCalendarEntryModeIcon, Optional<EdgeInsets> insetPadding) {
    throw new UnsupportedOperationException("datePickerDialogDatePickerDialog has no default (FFM/comm impl required)");
  }
  default DateTime DatePickerDialog_readBack_initialDate(Object st) {
    throw new UnsupportedOperationException("DatePickerDialog_readBack_initialDate read-back requires FFM/java22");
  }
  default DateTime DatePickerDialog_readBack_firstDate(Object st) {
    throw new UnsupportedOperationException("DatePickerDialog_readBack_firstDate read-back requires FFM/java22");
  }
  default DateTime DatePickerDialog_readBack_lastDate(Object st) {
    throw new UnsupportedOperationException("DatePickerDialog_readBack_lastDate read-back requires FFM/java22");
  }
  default DateTime DatePickerDialog_readBack_currentDate(Object st) {
    throw new UnsupportedOperationException("DatePickerDialog_readBack_currentDate read-back requires FFM/java22");
  }
  default DatePickerEntryMode DatePickerDialog_readBack_initialEntryMode(Object st) {
    throw new UnsupportedOperationException("DatePickerDialog_readBack_initialEntryMode read-back requires FFM/java22");
  }
  default String DatePickerDialog_readBack_cancelText(Object st) {
    throw new UnsupportedOperationException("DatePickerDialog_readBack_cancelText read-back requires FFM/java22");
  }
  default String DatePickerDialog_readBack_confirmText(Object st) {
    throw new UnsupportedOperationException("DatePickerDialog_readBack_confirmText read-back requires FFM/java22");
  }
  default String DatePickerDialog_readBack_helpText(Object st) {
    throw new UnsupportedOperationException("DatePickerDialog_readBack_helpText read-back requires FFM/java22");
  }
  default DatePickerMode DatePickerDialog_readBack_initialCalendarMode(Object st) {
    throw new UnsupportedOperationException("DatePickerDialog_readBack_initialCalendarMode read-back requires FFM/java22");
  }
  default String DatePickerDialog_readBack_errorFormatText(Object st) {
    throw new UnsupportedOperationException("DatePickerDialog_readBack_errorFormatText read-back requires FFM/java22");
  }
  default String DatePickerDialog_readBack_errorInvalidText(Object st) {
    throw new UnsupportedOperationException("DatePickerDialog_readBack_errorInvalidText read-back requires FFM/java22");
  }
  default String DatePickerDialog_readBack_fieldHintText(Object st) {
    throw new UnsupportedOperationException("DatePickerDialog_readBack_fieldHintText read-back requires FFM/java22");
  }
  default String DatePickerDialog_readBack_fieldLabelText(Object st) {
    throw new UnsupportedOperationException("DatePickerDialog_readBack_fieldLabelText read-back requires FFM/java22");
  }
  default String DatePickerDialog_readBack_restorationId(Object st) {
    throw new UnsupportedOperationException("DatePickerDialog_readBack_restorationId read-back requires FFM/java22");
  }
  default Icon DatePickerDialog_readBack_switchToInputEntryModeIcon(Object st) {
    throw new UnsupportedOperationException("DatePickerDialog_readBack_switchToInputEntryModeIcon read-back requires FFM/java22");
  }
  default Icon DatePickerDialog_readBack_switchToCalendarEntryModeIcon(Object st) {
    throw new UnsupportedOperationException("DatePickerDialog_readBack_switchToCalendarEntryModeIcon read-back requires FFM/java22");
  }
  default EdgeInsets DatePickerDialog_readBack_insetPadding(Object st) {
    throw new UnsupportedOperationException("DatePickerDialog_readBack_insetPadding read-back requires FFM/java22");
  }

  default int calendarDatePickerCalendarDatePicker(Optional<DateTime> initialDate, DateTime firstDate, DateTime lastDate, Optional<DateTime> currentDate, Consumer<DateTime> onDateChanged, Optional<Consumer<DateTime>> onDisplayedMonthChanged, Optional<DatePickerMode> initialCalendarMode, Optional<Function<DateTime, Boolean>> selectableDayPredicate) {
    throw new UnsupportedOperationException("calendarDatePickerCalendarDatePicker has no default (FFM/comm impl required)");
  }
  default DateTime CalendarDatePicker_readBack_initialDate(Object st) {
    throw new UnsupportedOperationException("CalendarDatePicker_readBack_initialDate read-back requires FFM/java22");
  }
  default DateTime CalendarDatePicker_readBack_firstDate(Object st) {
    throw new UnsupportedOperationException("CalendarDatePicker_readBack_firstDate read-back requires FFM/java22");
  }
  default DateTime CalendarDatePicker_readBack_lastDate(Object st) {
    throw new UnsupportedOperationException("CalendarDatePicker_readBack_lastDate read-back requires FFM/java22");
  }
  default DateTime CalendarDatePicker_readBack_currentDate(Object st) {
    throw new UnsupportedOperationException("CalendarDatePicker_readBack_currentDate read-back requires FFM/java22");
  }
  default DatePickerMode CalendarDatePicker_readBack_initialCalendarMode(Object st) {
    throw new UnsupportedOperationException("CalendarDatePicker_readBack_initialCalendarMode read-back requires FFM/java22");
  }

  default int timePickerDialogTimePickerDialog(TimeOfDay initialTime, Optional<String> cancelText, Optional<String> confirmText, Optional<String> helpText, Optional<String> errorInvalidText, Optional<String> hourLabelText, Optional<String> minuteLabelText, Optional<String> restorationId, Optional<TimePickerEntryMode> initialEntryMode, Optional<Orientation> orientation, Optional<Consumer<TimePickerEntryMode>> onEntryModeChanged, Optional<Icon> switchToInputEntryModeIcon, Optional<Icon> switchToTimerEntryModeIcon, Optional<Boolean> emptyInitialInput) {
    throw new UnsupportedOperationException("timePickerDialogTimePickerDialog has no default (FFM/comm impl required)");
  }
  default TimeOfDay TimePickerDialog_readBack_initialTime(Object st) {
    throw new UnsupportedOperationException("TimePickerDialog_readBack_initialTime read-back requires FFM/java22");
  }
  default String TimePickerDialog_readBack_cancelText(Object st) {
    throw new UnsupportedOperationException("TimePickerDialog_readBack_cancelText read-back requires FFM/java22");
  }
  default String TimePickerDialog_readBack_confirmText(Object st) {
    throw new UnsupportedOperationException("TimePickerDialog_readBack_confirmText read-back requires FFM/java22");
  }
  default String TimePickerDialog_readBack_helpText(Object st) {
    throw new UnsupportedOperationException("TimePickerDialog_readBack_helpText read-back requires FFM/java22");
  }
  default String TimePickerDialog_readBack_errorInvalidText(Object st) {
    throw new UnsupportedOperationException("TimePickerDialog_readBack_errorInvalidText read-back requires FFM/java22");
  }
  default String TimePickerDialog_readBack_hourLabelText(Object st) {
    throw new UnsupportedOperationException("TimePickerDialog_readBack_hourLabelText read-back requires FFM/java22");
  }
  default String TimePickerDialog_readBack_minuteLabelText(Object st) {
    throw new UnsupportedOperationException("TimePickerDialog_readBack_minuteLabelText read-back requires FFM/java22");
  }
  default String TimePickerDialog_readBack_restorationId(Object st) {
    throw new UnsupportedOperationException("TimePickerDialog_readBack_restorationId read-back requires FFM/java22");
  }
  default TimePickerEntryMode TimePickerDialog_readBack_initialEntryMode(Object st) {
    throw new UnsupportedOperationException("TimePickerDialog_readBack_initialEntryMode read-back requires FFM/java22");
  }
  default Orientation TimePickerDialog_readBack_orientation(Object st) {
    throw new UnsupportedOperationException("TimePickerDialog_readBack_orientation read-back requires FFM/java22");
  }
  default Icon TimePickerDialog_readBack_switchToInputEntryModeIcon(Object st) {
    throw new UnsupportedOperationException("TimePickerDialog_readBack_switchToInputEntryModeIcon read-back requires FFM/java22");
  }
  default Icon TimePickerDialog_readBack_switchToTimerEntryModeIcon(Object st) {
    throw new UnsupportedOperationException("TimePickerDialog_readBack_switchToTimerEntryModeIcon read-back requires FFM/java22");
  }
  default boolean TimePickerDialog_readBack_emptyInitialInput(Object st) {
    throw new UnsupportedOperationException("TimePickerDialog_readBack_emptyInitialInput read-back requires FFM/java22");
  }

  default int dateRangePickerDialogDateRangePickerDialog(DateTime firstDate, DateTime lastDate, Optional<DateTime> currentDate, Optional<DatePickerEntryMode> initialEntryMode, Optional<String> helpText, Optional<String> cancelText, Optional<String> confirmText, Optional<String> saveText, Optional<String> errorInvalidRangeText, Optional<String> errorFormatText, Optional<String> errorInvalidText, Optional<String> fieldStartHintText, Optional<String> fieldEndHintText, Optional<String> fieldStartLabelText, Optional<String> fieldEndLabelText, Optional<String> restorationId, Optional<Icon> switchToInputEntryModeIcon, Optional<Icon> switchToCalendarEntryModeIcon, Optional<TriFunction<DateTime, DateTime, DateTime, Boolean>> selectableDayPredicate) {
    throw new UnsupportedOperationException("dateRangePickerDialogDateRangePickerDialog has no default (FFM/comm impl required)");
  }
  default DateTime DateRangePickerDialog_readBack_firstDate(Object st) {
    throw new UnsupportedOperationException("DateRangePickerDialog_readBack_firstDate read-back requires FFM/java22");
  }
  default DateTime DateRangePickerDialog_readBack_lastDate(Object st) {
    throw new UnsupportedOperationException("DateRangePickerDialog_readBack_lastDate read-back requires FFM/java22");
  }
  default DatePickerEntryMode DateRangePickerDialog_readBack_initialEntryMode(Object st) {
    throw new UnsupportedOperationException("DateRangePickerDialog_readBack_initialEntryMode read-back requires FFM/java22");
  }
  default String DateRangePickerDialog_readBack_cancelText(Object st) {
    throw new UnsupportedOperationException("DateRangePickerDialog_readBack_cancelText read-back requires FFM/java22");
  }
  default String DateRangePickerDialog_readBack_confirmText(Object st) {
    throw new UnsupportedOperationException("DateRangePickerDialog_readBack_confirmText read-back requires FFM/java22");
  }
  default String DateRangePickerDialog_readBack_saveText(Object st) {
    throw new UnsupportedOperationException("DateRangePickerDialog_readBack_saveText read-back requires FFM/java22");
  }
  default String DateRangePickerDialog_readBack_helpText(Object st) {
    throw new UnsupportedOperationException("DateRangePickerDialog_readBack_helpText read-back requires FFM/java22");
  }
  default String DateRangePickerDialog_readBack_errorInvalidRangeText(Object st) {
    throw new UnsupportedOperationException("DateRangePickerDialog_readBack_errorInvalidRangeText read-back requires FFM/java22");
  }
  default String DateRangePickerDialog_readBack_errorFormatText(Object st) {
    throw new UnsupportedOperationException("DateRangePickerDialog_readBack_errorFormatText read-back requires FFM/java22");
  }
  default String DateRangePickerDialog_readBack_errorInvalidText(Object st) {
    throw new UnsupportedOperationException("DateRangePickerDialog_readBack_errorInvalidText read-back requires FFM/java22");
  }
  default String DateRangePickerDialog_readBack_fieldStartHintText(Object st) {
    throw new UnsupportedOperationException("DateRangePickerDialog_readBack_fieldStartHintText read-back requires FFM/java22");
  }
  default String DateRangePickerDialog_readBack_fieldEndHintText(Object st) {
    throw new UnsupportedOperationException("DateRangePickerDialog_readBack_fieldEndHintText read-back requires FFM/java22");
  }
  default String DateRangePickerDialog_readBack_fieldStartLabelText(Object st) {
    throw new UnsupportedOperationException("DateRangePickerDialog_readBack_fieldStartLabelText read-back requires FFM/java22");
  }
  default String DateRangePickerDialog_readBack_fieldEndLabelText(Object st) {
    throw new UnsupportedOperationException("DateRangePickerDialog_readBack_fieldEndLabelText read-back requires FFM/java22");
  }
  default String DateRangePickerDialog_readBack_restorationId(Object st) {
    throw new UnsupportedOperationException("DateRangePickerDialog_readBack_restorationId read-back requires FFM/java22");
  }
  default Icon DateRangePickerDialog_readBack_switchToInputEntryModeIcon(Object st) {
    throw new UnsupportedOperationException("DateRangePickerDialog_readBack_switchToInputEntryModeIcon read-back requires FFM/java22");
  }
  default Icon DateRangePickerDialog_readBack_switchToCalendarEntryModeIcon(Object st) {
    throw new UnsupportedOperationException("DateRangePickerDialog_readBack_switchToCalendarEntryModeIcon read-back requires FFM/java22");
  }
  default DateTime DateRangePickerDialog_readBack_currentDate(Object st) {
    throw new UnsupportedOperationException("DateRangePickerDialog_readBack_currentDate read-back requires FFM/java22");
  }

  default int yearPickerYearPicker(Optional<DateTime> currentDate, DateTime firstDate, DateTime lastDate, Optional<DateTime> initialDate, Optional<DateTime> selectedDate, Consumer<DateTime> onChanged, Optional<DragStartBehavior> dragStartBehavior) {
    throw new UnsupportedOperationException("yearPickerYearPicker has no default (FFM/comm impl required)");
  }
  default DateTime YearPicker_readBack_currentDate(Object st) {
    throw new UnsupportedOperationException("YearPicker_readBack_currentDate read-back requires FFM/java22");
  }
  default DateTime YearPicker_readBack_firstDate(Object st) {
    throw new UnsupportedOperationException("YearPicker_readBack_firstDate read-back requires FFM/java22");
  }
  default DateTime YearPicker_readBack_lastDate(Object st) {
    throw new UnsupportedOperationException("YearPicker_readBack_lastDate read-back requires FFM/java22");
  }
  default DateTime YearPicker_readBack_selectedDate(Object st) {
    throw new UnsupportedOperationException("YearPicker_readBack_selectedDate read-back requires FFM/java22");
  }
  default DragStartBehavior YearPicker_readBack_dragStartBehavior(Object st) {
    throw new UnsupportedOperationException("YearPicker_readBack_dragStartBehavior read-back requires FFM/java22");
  }

  default int inputDatePickerFormFieldInputDatePickerFormField(Optional<DateTime> initialDate, DateTime firstDate, DateTime lastDate, Optional<Consumer<DateTime>> onDateSubmitted, Optional<Consumer<DateTime>> onDateSaved, Optional<Function<DateTime, Boolean>> selectableDayPredicate, Optional<String> errorFormatText, Optional<String> errorInvalidText, Optional<String> fieldHintText, Optional<String> fieldLabelText, Optional<Boolean> autofocus, Optional<Boolean> acceptEmptyDate) {
    throw new UnsupportedOperationException("inputDatePickerFormFieldInputDatePickerFormField has no default (FFM/comm impl required)");
  }
  default DateTime InputDatePickerFormField_readBack_initialDate(Object st) {
    throw new UnsupportedOperationException("InputDatePickerFormField_readBack_initialDate read-back requires FFM/java22");
  }
  default DateTime InputDatePickerFormField_readBack_firstDate(Object st) {
    throw new UnsupportedOperationException("InputDatePickerFormField_readBack_firstDate read-back requires FFM/java22");
  }
  default DateTime InputDatePickerFormField_readBack_lastDate(Object st) {
    throw new UnsupportedOperationException("InputDatePickerFormField_readBack_lastDate read-back requires FFM/java22");
  }
  default String InputDatePickerFormField_readBack_errorFormatText(Object st) {
    throw new UnsupportedOperationException("InputDatePickerFormField_readBack_errorFormatText read-back requires FFM/java22");
  }
  default String InputDatePickerFormField_readBack_errorInvalidText(Object st) {
    throw new UnsupportedOperationException("InputDatePickerFormField_readBack_errorInvalidText read-back requires FFM/java22");
  }
  default String InputDatePickerFormField_readBack_fieldHintText(Object st) {
    throw new UnsupportedOperationException("InputDatePickerFormField_readBack_fieldHintText read-back requires FFM/java22");
  }
  default String InputDatePickerFormField_readBack_fieldLabelText(Object st) {
    throw new UnsupportedOperationException("InputDatePickerFormField_readBack_fieldLabelText read-back requires FFM/java22");
  }
  default boolean InputDatePickerFormField_readBack_autofocus(Object st) {
    throw new UnsupportedOperationException("InputDatePickerFormField_readBack_autofocus read-back requires FFM/java22");
  }
  default boolean InputDatePickerFormField_readBack_acceptEmptyDate(Object st) {
    throw new UnsupportedOperationException("InputDatePickerFormField_readBack_acceptEmptyDate read-back requires FFM/java22");
  }

  default int searchBarSearchBar(Optional<String> hintText, Optional<Widget> leading, Optional<List<Widget>> trailing, Optional<Runnable> onTap, Optional<Consumer<PointerDownEvent>> onTapOutside, Optional<Consumer<String>> onChanged, Optional<Consumer<String>> onSubmitted, Optional<BoxConstraints> constraints, OptionalDouble elevation, Optional<Color> backgroundColor, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, Optional<Color> overlayColor, Optional<BorderSide> side, Optional<OutlinedBorder> shape, Optional<EdgeInsetsGeometry> padding, Optional<TextStyle> textStyle, Optional<TextStyle> hintStyle, Optional<TextCapitalization> textCapitalization, Optional<Boolean> enabled, Optional<Boolean> autoFocus, Optional<TextInputAction> textInputAction, Optional<EdgeInsets> scrollPadding, Optional<Boolean> readOnly, Optional<SmartDashesType> smartDashesType, Optional<SmartQuotesType> smartQuotesType) {
    throw new UnsupportedOperationException("searchBarSearchBar has no default (FFM/comm impl required)");
  }
  default String SearchBar_readBack_hintText(Object st) {
    throw new UnsupportedOperationException("SearchBar_readBack_hintText read-back requires FFM/java22");
  }
  default Widget SearchBar_readBack_leading(Object st) {
    throw new UnsupportedOperationException("SearchBar_readBack_leading read-back requires FFM/java22");
  }
  default BoxConstraints SearchBar_readBack_constraints(Object st) {
    throw new UnsupportedOperationException("SearchBar_readBack_constraints read-back requires FFM/java22");
  }
  default TextCapitalization SearchBar_readBack_textCapitalization(Object st) {
    throw new UnsupportedOperationException("SearchBar_readBack_textCapitalization read-back requires FFM/java22");
  }
  default boolean SearchBar_readBack_enabled(Object st) {
    throw new UnsupportedOperationException("SearchBar_readBack_enabled read-back requires FFM/java22");
  }
  default boolean SearchBar_readBack_autoFocus(Object st) {
    throw new UnsupportedOperationException("SearchBar_readBack_autoFocus read-back requires FFM/java22");
  }
  default TextInputAction SearchBar_readBack_textInputAction(Object st) {
    throw new UnsupportedOperationException("SearchBar_readBack_textInputAction read-back requires FFM/java22");
  }
  default EdgeInsets SearchBar_readBack_scrollPadding(Object st) {
    throw new UnsupportedOperationException("SearchBar_readBack_scrollPadding read-back requires FFM/java22");
  }
  default boolean SearchBar_readBack_readOnly(Object st) {
    throw new UnsupportedOperationException("SearchBar_readBack_readOnly read-back requires FFM/java22");
  }
  default SmartDashesType SearchBar_readBack_smartDashesType(Object st) {
    throw new UnsupportedOperationException("SearchBar_readBack_smartDashesType read-back requires FFM/java22");
  }
  default SmartQuotesType SearchBar_readBack_smartQuotesType(Object st) {
    throw new UnsupportedOperationException("SearchBar_readBack_smartQuotesType read-back requires FFM/java22");
  }

  default int cupertinoAppCupertinoApp(Optional<Widget> home, Optional<CupertinoThemeData> theme, Optional<String> initialRoute, Optional<BiFunction<BuildContext, Widget, Widget>> builder, Optional<String> title, Optional<Function<BuildContext, String>> onGenerateTitle, Optional<Color> color, Optional<Boolean> showPerformanceOverlay, Optional<Boolean> checkerboardRasterCacheImages, Optional<Boolean> checkerboardOffscreenLayers, Optional<Boolean> showSemanticsDebugger, Optional<Boolean> debugShowCheckedModeBanner, Optional<String> restorationScopeId, Optional<Boolean> useInheritedMediaQuery) {
    throw new UnsupportedOperationException("cupertinoAppCupertinoApp has no default (FFM/comm impl required)");
  }
  default int cupertinoAppRouter(Optional<CupertinoThemeData> theme, Optional<BiFunction<BuildContext, Widget, Widget>> builder, Optional<String> title, Optional<Function<BuildContext, String>> onGenerateTitle, Optional<Color> color, Optional<Boolean> showPerformanceOverlay, Optional<Boolean> checkerboardRasterCacheImages, Optional<Boolean> checkerboardOffscreenLayers, Optional<Boolean> showSemanticsDebugger, Optional<Boolean> debugShowCheckedModeBanner, Optional<String> restorationScopeId, Optional<Boolean> useInheritedMediaQuery) {
    throw new UnsupportedOperationException("cupertinoAppRouter has no default (FFM/comm impl required)");
  }
  default Widget CupertinoApp_readBack_home(Object st) {
    throw new UnsupportedOperationException("CupertinoApp_readBack_home read-back requires FFM/java22");
  }
  default CupertinoThemeData CupertinoApp_readBack_theme(Object st) {
    throw new UnsupportedOperationException("CupertinoApp_readBack_theme read-back requires FFM/java22");
  }
  default String CupertinoApp_readBack_initialRoute(Object st) {
    throw new UnsupportedOperationException("CupertinoApp_readBack_initialRoute read-back requires FFM/java22");
  }
  default String CupertinoApp_readBack_title(Object st) {
    throw new UnsupportedOperationException("CupertinoApp_readBack_title read-back requires FFM/java22");
  }
  default Color CupertinoApp_readBack_color(Object st) {
    throw new UnsupportedOperationException("CupertinoApp_readBack_color read-back requires FFM/java22");
  }
  default boolean CupertinoApp_readBack_showPerformanceOverlay(Object st) {
    throw new UnsupportedOperationException("CupertinoApp_readBack_showPerformanceOverlay read-back requires FFM/java22");
  }
  default boolean CupertinoApp_readBack_checkerboardRasterCacheImages(Object st) {
    throw new UnsupportedOperationException("CupertinoApp_readBack_checkerboardRasterCacheImages read-back requires FFM/java22");
  }
  default boolean CupertinoApp_readBack_checkerboardOffscreenLayers(Object st) {
    throw new UnsupportedOperationException("CupertinoApp_readBack_checkerboardOffscreenLayers read-back requires FFM/java22");
  }
  default boolean CupertinoApp_readBack_showSemanticsDebugger(Object st) {
    throw new UnsupportedOperationException("CupertinoApp_readBack_showSemanticsDebugger read-back requires FFM/java22");
  }
  default boolean CupertinoApp_readBack_debugShowCheckedModeBanner(Object st) {
    throw new UnsupportedOperationException("CupertinoApp_readBack_debugShowCheckedModeBanner read-back requires FFM/java22");
  }
  default String CupertinoApp_readBack_restorationScopeId(Object st) {
    throw new UnsupportedOperationException("CupertinoApp_readBack_restorationScopeId read-back requires FFM/java22");
  }
  default boolean CupertinoApp_readBack_useInheritedMediaQuery(Object st) {
    throw new UnsupportedOperationException("CupertinoApp_readBack_useInheritedMediaQuery read-back requires FFM/java22");
  }

  default int cupertinoThemeDataCupertinoThemeData(Optional<Brightness> brightness, Optional<Color> primaryColor, Optional<Color> primaryContrastingColor, Optional<CupertinoTextThemeData> textTheme, Optional<Color> barBackgroundColor, Optional<Color> scaffoldBackgroundColor, Optional<Color> selectionHandleColor, Optional<Boolean> applyThemeToAll) {
    throw new UnsupportedOperationException("cupertinoThemeDataCupertinoThemeData has no default (FFM/comm impl required)");
  }
  default int cupertinoThemeDataRaw(Brightness brightness, Color primaryColor, Color primaryContrastingColor, CupertinoTextThemeData textTheme, Color barBackgroundColor, Color scaffoldBackgroundColor, Color selectionHandleColor, boolean applyThemeToAll) {
    throw new UnsupportedOperationException("cupertinoThemeDataRaw has no default (FFM/comm impl required)");
  }

  default int cupertinoPageScaffoldCupertinoPageScaffold(Optional<ObstructingPreferredSizeWidget> navigationBar, Optional<Color> backgroundColor, Optional<Boolean> resizeToAvoidBottomInset, Widget child) {
    throw new UnsupportedOperationException("cupertinoPageScaffoldCupertinoPageScaffold has no default (FFM/comm impl required)");
  }
  default ObstructingPreferredSizeWidget CupertinoPageScaffold_readBack_navigationBar(Object st) {
    throw new UnsupportedOperationException("CupertinoPageScaffold_readBack_navigationBar read-back requires FFM/java22");
  }
  default Widget CupertinoPageScaffold_readBack_child(Object st) {
    throw new UnsupportedOperationException("CupertinoPageScaffold_readBack_child read-back requires FFM/java22");
  }
  default Color CupertinoPageScaffold_readBack_backgroundColor(Object st) {
    throw new UnsupportedOperationException("CupertinoPageScaffold_readBack_backgroundColor read-back requires FFM/java22");
  }
  default boolean CupertinoPageScaffold_readBack_resizeToAvoidBottomInset(Object st) {
    throw new UnsupportedOperationException("CupertinoPageScaffold_readBack_resizeToAvoidBottomInset read-back requires FFM/java22");
  }

  default int cupertinoNavigationBarCupertinoNavigationBar(Optional<Widget> leading, Optional<Boolean> automaticallyImplyLeading, Optional<Boolean> automaticallyImplyMiddle, Optional<String> previousPageTitle, Optional<Widget> middle, Optional<Widget> trailing, Optional<Border> border, Optional<Color> backgroundColor, Optional<Boolean> automaticBackgroundVisibility, Optional<Boolean> enableBackgroundFilterBlur, Optional<Brightness> brightness, Optional<Boolean> transitionBetweenRoutes, Optional<PreferredSizeWidget> bottom) {
    throw new UnsupportedOperationException("cupertinoNavigationBarCupertinoNavigationBar has no default (FFM/comm impl required)");
  }
  default int cupertinoNavigationBarLarge(Optional<Widget> largeTitle, Optional<Widget> leading, Optional<Boolean> automaticallyImplyLeading, Optional<Boolean> automaticallyImplyTitle, Optional<String> previousPageTitle, Optional<Widget> trailing, Optional<Border> border, Optional<Color> backgroundColor, Optional<Boolean> automaticBackgroundVisibility, Optional<Boolean> enableBackgroundFilterBlur, Optional<Brightness> brightness, Optional<Boolean> transitionBetweenRoutes, Optional<PreferredSizeWidget> bottom) {
    throw new UnsupportedOperationException("cupertinoNavigationBarLarge has no default (FFM/comm impl required)");
  }
  default Widget CupertinoNavigationBar_readBack_largeTitle(Object st) {
    throw new UnsupportedOperationException("CupertinoNavigationBar_readBack_largeTitle read-back requires FFM/java22");
  }
  default Widget CupertinoNavigationBar_readBack_leading(Object st) {
    throw new UnsupportedOperationException("CupertinoNavigationBar_readBack_leading read-back requires FFM/java22");
  }
  default boolean CupertinoNavigationBar_readBack_automaticallyImplyLeading(Object st) {
    throw new UnsupportedOperationException("CupertinoNavigationBar_readBack_automaticallyImplyLeading read-back requires FFM/java22");
  }
  default boolean CupertinoNavigationBar_readBack_automaticallyImplyMiddle(Object st) {
    throw new UnsupportedOperationException("CupertinoNavigationBar_readBack_automaticallyImplyMiddle read-back requires FFM/java22");
  }
  default String CupertinoNavigationBar_readBack_previousPageTitle(Object st) {
    throw new UnsupportedOperationException("CupertinoNavigationBar_readBack_previousPageTitle read-back requires FFM/java22");
  }
  default Widget CupertinoNavigationBar_readBack_middle(Object st) {
    throw new UnsupportedOperationException("CupertinoNavigationBar_readBack_middle read-back requires FFM/java22");
  }
  default Widget CupertinoNavigationBar_readBack_trailing(Object st) {
    throw new UnsupportedOperationException("CupertinoNavigationBar_readBack_trailing read-back requires FFM/java22");
  }
  default Color CupertinoNavigationBar_readBack_backgroundColor(Object st) {
    throw new UnsupportedOperationException("CupertinoNavigationBar_readBack_backgroundColor read-back requires FFM/java22");
  }
  default boolean CupertinoNavigationBar_readBack_automaticBackgroundVisibility(Object st) {
    throw new UnsupportedOperationException("CupertinoNavigationBar_readBack_automaticBackgroundVisibility read-back requires FFM/java22");
  }
  default Brightness CupertinoNavigationBar_readBack_brightness(Object st) {
    throw new UnsupportedOperationException("CupertinoNavigationBar_readBack_brightness read-back requires FFM/java22");
  }
  default Border CupertinoNavigationBar_readBack_border(Object st) {
    throw new UnsupportedOperationException("CupertinoNavigationBar_readBack_border read-back requires FFM/java22");
  }
  default boolean CupertinoNavigationBar_readBack_transitionBetweenRoutes(Object st) {
    throw new UnsupportedOperationException("CupertinoNavigationBar_readBack_transitionBetweenRoutes read-back requires FFM/java22");
  }
  default boolean CupertinoNavigationBar_readBack_enableBackgroundFilterBlur(Object st) {
    throw new UnsupportedOperationException("CupertinoNavigationBar_readBack_enableBackgroundFilterBlur read-back requires FFM/java22");
  }
  default PreferredSizeWidget CupertinoNavigationBar_readBack_bottom(Object st) {
    throw new UnsupportedOperationException("CupertinoNavigationBar_readBack_bottom read-back requires FFM/java22");
  }

  default int cupertinoSliverNavigationBarCupertinoSliverNavigationBar(Optional<Widget> largeTitle, Optional<Widget> leading, Optional<Boolean> automaticallyImplyLeading, Optional<Boolean> automaticallyImplyTitle, Optional<Boolean> alwaysShowMiddle, Optional<String> previousPageTitle, Optional<Widget> middle, Optional<Widget> trailing, Optional<Border> border, Optional<Color> backgroundColor, Optional<Boolean> automaticBackgroundVisibility, Optional<Boolean> enableBackgroundFilterBlur, Optional<Brightness> brightness, Optional<Boolean> transitionBetweenRoutes, Optional<Boolean> stretch, Optional<PreferredSizeWidget> bottom, Optional<NavigationBarBottomMode> bottomMode) {
    throw new UnsupportedOperationException("cupertinoSliverNavigationBarCupertinoSliverNavigationBar has no default (FFM/comm impl required)");
  }
  default int cupertinoSliverNavigationBarSearch(Widget searchField, Optional<Widget> largeTitle, Optional<Widget> leading, Optional<Boolean> automaticallyImplyLeading, Optional<Boolean> automaticallyImplyTitle, Optional<Boolean> alwaysShowMiddle, Optional<String> previousPageTitle, Optional<Widget> middle, Optional<Widget> trailing, Optional<Border> border, Optional<Color> backgroundColor, Optional<Boolean> automaticBackgroundVisibility, Optional<Boolean> enableBackgroundFilterBlur, Optional<Brightness> brightness, Optional<Boolean> transitionBetweenRoutes, Optional<Boolean> stretch, Optional<NavigationBarBottomMode> bottomMode, Optional<Consumer<Boolean>> onSearchableBottomTap) {
    throw new UnsupportedOperationException("cupertinoSliverNavigationBarSearch has no default (FFM/comm impl required)");
  }
  default Widget CupertinoSliverNavigationBar_readBack_largeTitle(Object st) {
    throw new UnsupportedOperationException("CupertinoSliverNavigationBar_readBack_largeTitle read-back requires FFM/java22");
  }
  default Widget CupertinoSliverNavigationBar_readBack_leading(Object st) {
    throw new UnsupportedOperationException("CupertinoSliverNavigationBar_readBack_leading read-back requires FFM/java22");
  }
  default boolean CupertinoSliverNavigationBar_readBack_automaticallyImplyLeading(Object st) {
    throw new UnsupportedOperationException("CupertinoSliverNavigationBar_readBack_automaticallyImplyLeading read-back requires FFM/java22");
  }
  default boolean CupertinoSliverNavigationBar_readBack_automaticallyImplyTitle(Object st) {
    throw new UnsupportedOperationException("CupertinoSliverNavigationBar_readBack_automaticallyImplyTitle read-back requires FFM/java22");
  }
  default boolean CupertinoSliverNavigationBar_readBack_alwaysShowMiddle(Object st) {
    throw new UnsupportedOperationException("CupertinoSliverNavigationBar_readBack_alwaysShowMiddle read-back requires FFM/java22");
  }
  default String CupertinoSliverNavigationBar_readBack_previousPageTitle(Object st) {
    throw new UnsupportedOperationException("CupertinoSliverNavigationBar_readBack_previousPageTitle read-back requires FFM/java22");
  }
  default Widget CupertinoSliverNavigationBar_readBack_middle(Object st) {
    throw new UnsupportedOperationException("CupertinoSliverNavigationBar_readBack_middle read-back requires FFM/java22");
  }
  default Widget CupertinoSliverNavigationBar_readBack_trailing(Object st) {
    throw new UnsupportedOperationException("CupertinoSliverNavigationBar_readBack_trailing read-back requires FFM/java22");
  }
  default Color CupertinoSliverNavigationBar_readBack_backgroundColor(Object st) {
    throw new UnsupportedOperationException("CupertinoSliverNavigationBar_readBack_backgroundColor read-back requires FFM/java22");
  }
  default boolean CupertinoSliverNavigationBar_readBack_automaticBackgroundVisibility(Object st) {
    throw new UnsupportedOperationException("CupertinoSliverNavigationBar_readBack_automaticBackgroundVisibility read-back requires FFM/java22");
  }
  default boolean CupertinoSliverNavigationBar_readBack_enableBackgroundFilterBlur(Object st) {
    throw new UnsupportedOperationException("CupertinoSliverNavigationBar_readBack_enableBackgroundFilterBlur read-back requires FFM/java22");
  }
  default Brightness CupertinoSliverNavigationBar_readBack_brightness(Object st) {
    throw new UnsupportedOperationException("CupertinoSliverNavigationBar_readBack_brightness read-back requires FFM/java22");
  }
  default Border CupertinoSliverNavigationBar_readBack_border(Object st) {
    throw new UnsupportedOperationException("CupertinoSliverNavigationBar_readBack_border read-back requires FFM/java22");
  }
  default boolean CupertinoSliverNavigationBar_readBack_transitionBetweenRoutes(Object st) {
    throw new UnsupportedOperationException("CupertinoSliverNavigationBar_readBack_transitionBetweenRoutes read-back requires FFM/java22");
  }
  default PreferredSizeWidget CupertinoSliverNavigationBar_readBack_bottom(Object st) {
    throw new UnsupportedOperationException("CupertinoSliverNavigationBar_readBack_bottom read-back requires FFM/java22");
  }
  default NavigationBarBottomMode CupertinoSliverNavigationBar_readBack_bottomMode(Object st) {
    throw new UnsupportedOperationException("CupertinoSliverNavigationBar_readBack_bottomMode read-back requires FFM/java22");
  }
  default boolean CupertinoSliverNavigationBar_readBack_stretch(Object st) {
    throw new UnsupportedOperationException("CupertinoSliverNavigationBar_readBack_stretch read-back requires FFM/java22");
  }
  default Widget CupertinoSliverNavigationBar_readBack_searchField(Object st) {
    throw new UnsupportedOperationException("CupertinoSliverNavigationBar_readBack_searchField read-back requires FFM/java22");
  }
  default boolean CupertinoSliverNavigationBar_readBack_opaque(Object st) {
    throw new UnsupportedOperationException("CupertinoSliverNavigationBar_readBack_opaque read-back requires FFM/java22");
  }

  default int cupertinoTabViewCupertinoTabView(Optional<Function<BuildContext, Widget>> builder, Optional<String> defaultTitle, Optional<String> restorationScopeId) {
    throw new UnsupportedOperationException("cupertinoTabViewCupertinoTabView has no default (FFM/comm impl required)");
  }
  default String CupertinoTabView_readBack_defaultTitle(Object st) {
    throw new UnsupportedOperationException("CupertinoTabView_readBack_defaultTitle read-back requires FFM/java22");
  }
  default String CupertinoTabView_readBack_restorationScopeId(Object st) {
    throw new UnsupportedOperationException("CupertinoTabView_readBack_restorationScopeId read-back requires FFM/java22");
  }

  default int cupertinoButtonCupertinoButton(Widget child, Optional<CupertinoButtonSize> sizeStyle, Optional<EdgeInsetsGeometry> padding, Optional<Color> color, Optional<Color> foregroundColor, Optional<Color> disabledColor, OptionalDouble minSize, OptionalDouble pressedOpacity, Optional<BorderRadius> borderRadius, Optional<AlignmentGeometry> alignment, Optional<Color> focusColor, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Runnable> onLongPress, Optional<Runnable> onPressed) {
    throw new UnsupportedOperationException("cupertinoButtonCupertinoButton has no default (FFM/comm impl required)");
  }
  default int cupertinoButtonTinted(Widget child, Optional<CupertinoButtonSize> sizeStyle, Optional<EdgeInsetsGeometry> padding, Optional<Color> color, Optional<Color> foregroundColor, Optional<Color> disabledColor, OptionalDouble minSize, OptionalDouble pressedOpacity, Optional<BorderRadius> borderRadius, Optional<AlignmentGeometry> alignment, Optional<Color> focusColor, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Runnable> onLongPress, Optional<Runnable> onPressed) {
    throw new UnsupportedOperationException("cupertinoButtonTinted has no default (FFM/comm impl required)");
  }
  default int cupertinoButtonFilled(Widget child, Optional<CupertinoButtonSize> sizeStyle, Optional<EdgeInsetsGeometry> padding, Optional<Color> color, Optional<Color> disabledColor, Optional<Color> foregroundColor, OptionalDouble minSize, OptionalDouble pressedOpacity, Optional<BorderRadius> borderRadius, Optional<AlignmentGeometry> alignment, Optional<Color> focusColor, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Runnable> onLongPress, Optional<Runnable> onPressed) {
    throw new UnsupportedOperationException("cupertinoButtonFilled has no default (FFM/comm impl required)");
  }
  default double cupertinoButtonTapMoveSlop() {
    throw new UnsupportedOperationException("cupertinoButtonTapMoveSlop has no default (FFM/comm impl required)");
  }
  default Widget CupertinoButton_readBack_child(Object st) {
    throw new UnsupportedOperationException("CupertinoButton_readBack_child read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry CupertinoButton_readBack_padding(Object st) {
    throw new UnsupportedOperationException("CupertinoButton_readBack_padding read-back requires FFM/java22");
  }
  default Color CupertinoButton_readBack_color(Object st) {
    throw new UnsupportedOperationException("CupertinoButton_readBack_color read-back requires FFM/java22");
  }
  default Color CupertinoButton_readBack_disabledColor(Object st) {
    throw new UnsupportedOperationException("CupertinoButton_readBack_disabledColor read-back requires FFM/java22");
  }
  default Color CupertinoButton_readBack_foregroundColor(Object st) {
    throw new UnsupportedOperationException("CupertinoButton_readBack_foregroundColor read-back requires FFM/java22");
  }
  default double CupertinoButton_readBack_minSize(Object st) {
    throw new UnsupportedOperationException("CupertinoButton_readBack_minSize read-back requires FFM/java22");
  }
  default double CupertinoButton_readBack_pressedOpacity(Object st) {
    throw new UnsupportedOperationException("CupertinoButton_readBack_pressedOpacity read-back requires FFM/java22");
  }
  default BorderRadius CupertinoButton_readBack_borderRadius(Object st) {
    throw new UnsupportedOperationException("CupertinoButton_readBack_borderRadius read-back requires FFM/java22");
  }
  default CupertinoButtonSize CupertinoButton_readBack_sizeStyle(Object st) {
    throw new UnsupportedOperationException("CupertinoButton_readBack_sizeStyle read-back requires FFM/java22");
  }
  default AlignmentGeometry CupertinoButton_readBack_alignment(Object st) {
    throw new UnsupportedOperationException("CupertinoButton_readBack_alignment read-back requires FFM/java22");
  }
  default Color CupertinoButton_readBack_focusColor(Object st) {
    throw new UnsupportedOperationException("CupertinoButton_readBack_focusColor read-back requires FFM/java22");
  }
  default boolean CupertinoButton_readBack_autofocus(Object st) {
    throw new UnsupportedOperationException("CupertinoButton_readBack_autofocus read-back requires FFM/java22");
  }
  default boolean CupertinoButton_readBack_enabled(Object st) {
    throw new UnsupportedOperationException("CupertinoButton_readBack_enabled read-back requires FFM/java22");
  }

  default int cupertinoSwitchCupertinoSwitch(boolean value, Optional<Consumer<Boolean>> onChanged, Optional<Color> activeColor, Optional<Color> trackColor, Optional<Color> activeTrackColor, Optional<Color> inactiveTrackColor, Optional<Color> thumbColor, Optional<Color> inactiveThumbColor, Optional<Boolean> applyTheme, Optional<Color> focusColor, Optional<Color> onLabelColor, Optional<Color> offLabelColor, Optional<Color> trackOutlineColor, OptionalDouble trackOutlineWidth, Optional<Icon> thumbIcon, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<DragStartBehavior> dragStartBehavior) {
    throw new UnsupportedOperationException("cupertinoSwitchCupertinoSwitch has no default (FFM/comm impl required)");
  }
  default boolean CupertinoSwitch_readBack_value(Object st) {
    throw new UnsupportedOperationException("CupertinoSwitch_readBack_value read-back requires FFM/java22");
  }
  default Color CupertinoSwitch_readBack_activeTrackColor(Object st) {
    throw new UnsupportedOperationException("CupertinoSwitch_readBack_activeTrackColor read-back requires FFM/java22");
  }
  default Color CupertinoSwitch_readBack_inactiveTrackColor(Object st) {
    throw new UnsupportedOperationException("CupertinoSwitch_readBack_inactiveTrackColor read-back requires FFM/java22");
  }
  default Color CupertinoSwitch_readBack_thumbColor(Object st) {
    throw new UnsupportedOperationException("CupertinoSwitch_readBack_thumbColor read-back requires FFM/java22");
  }
  default Color CupertinoSwitch_readBack_inactiveThumbColor(Object st) {
    throw new UnsupportedOperationException("CupertinoSwitch_readBack_inactiveThumbColor read-back requires FFM/java22");
  }
  default Color CupertinoSwitch_readBack_focusColor(Object st) {
    throw new UnsupportedOperationException("CupertinoSwitch_readBack_focusColor read-back requires FFM/java22");
  }
  default Color CupertinoSwitch_readBack_onLabelColor(Object st) {
    throw new UnsupportedOperationException("CupertinoSwitch_readBack_onLabelColor read-back requires FFM/java22");
  }
  default Color CupertinoSwitch_readBack_offLabelColor(Object st) {
    throw new UnsupportedOperationException("CupertinoSwitch_readBack_offLabelColor read-back requires FFM/java22");
  }
  default boolean CupertinoSwitch_readBack_autofocus(Object st) {
    throw new UnsupportedOperationException("CupertinoSwitch_readBack_autofocus read-back requires FFM/java22");
  }
  default boolean CupertinoSwitch_readBack_applyTheme(Object st) {
    throw new UnsupportedOperationException("CupertinoSwitch_readBack_applyTheme read-back requires FFM/java22");
  }
  default DragStartBehavior CupertinoSwitch_readBack_dragStartBehavior(Object st) {
    throw new UnsupportedOperationException("CupertinoSwitch_readBack_dragStartBehavior read-back requires FFM/java22");
  }
  default Color CupertinoSwitch_readBack_activeColor(Object st) {
    throw new UnsupportedOperationException("CupertinoSwitch_readBack_activeColor read-back requires FFM/java22");
  }
  default Color CupertinoSwitch_readBack_trackColor(Object st) {
    throw new UnsupportedOperationException("CupertinoSwitch_readBack_trackColor read-back requires FFM/java22");
  }

  default int cupertinoSliderCupertinoSlider(double value, Optional<Consumer<Double>> onChanged, Optional<Consumer<Double>> onChangeStart, Optional<Consumer<Double>> onChangeEnd, OptionalDouble min, OptionalDouble max, OptionalInt divisions, Optional<Color> activeColor, Optional<Color> thumbColor) {
    throw new UnsupportedOperationException("cupertinoSliderCupertinoSlider has no default (FFM/comm impl required)");
  }
  default double CupertinoSlider_readBack_value(Object st) {
    throw new UnsupportedOperationException("CupertinoSlider_readBack_value read-back requires FFM/java22");
  }
  default double CupertinoSlider_readBack_min(Object st) {
    throw new UnsupportedOperationException("CupertinoSlider_readBack_min read-back requires FFM/java22");
  }
  default double CupertinoSlider_readBack_max(Object st) {
    throw new UnsupportedOperationException("CupertinoSlider_readBack_max read-back requires FFM/java22");
  }
  default int CupertinoSlider_readBack_divisions(Object st) {
    throw new UnsupportedOperationException("CupertinoSlider_readBack_divisions read-back requires FFM/java22");
  }
  default Color CupertinoSlider_readBack_activeColor(Object st) {
    throw new UnsupportedOperationException("CupertinoSlider_readBack_activeColor read-back requires FFM/java22");
  }
  default Color CupertinoSlider_readBack_thumbColor(Object st) {
    throw new UnsupportedOperationException("CupertinoSlider_readBack_thumbColor read-back requires FFM/java22");
  }

  default int cupertinoSearchTextFieldCupertinoSearchTextField(Optional<Consumer<String>> onChanged, Optional<Consumer<String>> onSubmitted, Optional<TextStyle> style, Optional<String> placeholder, Optional<TextStyle> placeholderStyle, Optional<BoxDecoration> decoration, Optional<Color> backgroundColor, Optional<BorderRadius> borderRadius, Optional<EdgeInsetsGeometry> padding, Optional<Color> itemColor, OptionalDouble itemSize, Optional<EdgeInsetsGeometry> prefixInsets, Optional<Widget> prefixIcon, Optional<EdgeInsetsGeometry> suffixInsets, Optional<Icon> suffixIcon, Optional<OverlayVisibilityMode> suffixMode, Optional<Runnable> onSuffixTap, Optional<String> restorationId, Optional<SmartQuotesType> smartQuotesType, Optional<SmartDashesType> smartDashesType, Optional<Boolean> enableIMEPersonalizedLearning, Optional<Boolean> autofocus, Optional<Runnable> onTap, Optional<Boolean> autocorrect, Optional<Boolean> enabled, OptionalDouble cursorWidth, OptionalDouble cursorHeight, Optional<Radius> cursorRadius, Optional<Boolean> cursorOpacityAnimates, Optional<Color> cursorColor) {
    throw new UnsupportedOperationException("cupertinoSearchTextFieldCupertinoSearchTextField has no default (FFM/comm impl required)");
  }
  default TextStyle CupertinoSearchTextField_readBack_style(Object st) {
    throw new UnsupportedOperationException("CupertinoSearchTextField_readBack_style read-back requires FFM/java22");
  }
  default String CupertinoSearchTextField_readBack_placeholder(Object st) {
    throw new UnsupportedOperationException("CupertinoSearchTextField_readBack_placeholder read-back requires FFM/java22");
  }
  default TextStyle CupertinoSearchTextField_readBack_placeholderStyle(Object st) {
    throw new UnsupportedOperationException("CupertinoSearchTextField_readBack_placeholderStyle read-back requires FFM/java22");
  }
  default BoxDecoration CupertinoSearchTextField_readBack_decoration(Object st) {
    throw new UnsupportedOperationException("CupertinoSearchTextField_readBack_decoration read-back requires FFM/java22");
  }
  default Color CupertinoSearchTextField_readBack_backgroundColor(Object st) {
    throw new UnsupportedOperationException("CupertinoSearchTextField_readBack_backgroundColor read-back requires FFM/java22");
  }
  default BorderRadius CupertinoSearchTextField_readBack_borderRadius(Object st) {
    throw new UnsupportedOperationException("CupertinoSearchTextField_readBack_borderRadius read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry CupertinoSearchTextField_readBack_padding(Object st) {
    throw new UnsupportedOperationException("CupertinoSearchTextField_readBack_padding read-back requires FFM/java22");
  }
  default Color CupertinoSearchTextField_readBack_itemColor(Object st) {
    throw new UnsupportedOperationException("CupertinoSearchTextField_readBack_itemColor read-back requires FFM/java22");
  }
  default double CupertinoSearchTextField_readBack_itemSize(Object st) {
    throw new UnsupportedOperationException("CupertinoSearchTextField_readBack_itemSize read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry CupertinoSearchTextField_readBack_prefixInsets(Object st) {
    throw new UnsupportedOperationException("CupertinoSearchTextField_readBack_prefixInsets read-back requires FFM/java22");
  }
  default Widget CupertinoSearchTextField_readBack_prefixIcon(Object st) {
    throw new UnsupportedOperationException("CupertinoSearchTextField_readBack_prefixIcon read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry CupertinoSearchTextField_readBack_suffixInsets(Object st) {
    throw new UnsupportedOperationException("CupertinoSearchTextField_readBack_suffixInsets read-back requires FFM/java22");
  }
  default Icon CupertinoSearchTextField_readBack_suffixIcon(Object st) {
    throw new UnsupportedOperationException("CupertinoSearchTextField_readBack_suffixIcon read-back requires FFM/java22");
  }
  default OverlayVisibilityMode CupertinoSearchTextField_readBack_suffixMode(Object st) {
    throw new UnsupportedOperationException("CupertinoSearchTextField_readBack_suffixMode read-back requires FFM/java22");
  }
  default String CupertinoSearchTextField_readBack_restorationId(Object st) {
    throw new UnsupportedOperationException("CupertinoSearchTextField_readBack_restorationId read-back requires FFM/java22");
  }
  default boolean CupertinoSearchTextField_readBack_autofocus(Object st) {
    throw new UnsupportedOperationException("CupertinoSearchTextField_readBack_autofocus read-back requires FFM/java22");
  }
  default boolean CupertinoSearchTextField_readBack_autocorrect(Object st) {
    throw new UnsupportedOperationException("CupertinoSearchTextField_readBack_autocorrect read-back requires FFM/java22");
  }
  default SmartQuotesType CupertinoSearchTextField_readBack_smartQuotesType(Object st) {
    throw new UnsupportedOperationException("CupertinoSearchTextField_readBack_smartQuotesType read-back requires FFM/java22");
  }
  default SmartDashesType CupertinoSearchTextField_readBack_smartDashesType(Object st) {
    throw new UnsupportedOperationException("CupertinoSearchTextField_readBack_smartDashesType read-back requires FFM/java22");
  }
  default boolean CupertinoSearchTextField_readBack_enableIMEPersonalizedLearning(Object st) {
    throw new UnsupportedOperationException("CupertinoSearchTextField_readBack_enableIMEPersonalizedLearning read-back requires FFM/java22");
  }
  default boolean CupertinoSearchTextField_readBack_enabled(Object st) {
    throw new UnsupportedOperationException("CupertinoSearchTextField_readBack_enabled read-back requires FFM/java22");
  }
  default double CupertinoSearchTextField_readBack_cursorWidth(Object st) {
    throw new UnsupportedOperationException("CupertinoSearchTextField_readBack_cursorWidth read-back requires FFM/java22");
  }
  default double CupertinoSearchTextField_readBack_cursorHeight(Object st) {
    throw new UnsupportedOperationException("CupertinoSearchTextField_readBack_cursorHeight read-back requires FFM/java22");
  }
  default Radius CupertinoSearchTextField_readBack_cursorRadius(Object st) {
    throw new UnsupportedOperationException("CupertinoSearchTextField_readBack_cursorRadius read-back requires FFM/java22");
  }
  default boolean CupertinoSearchTextField_readBack_cursorOpacityAnimates(Object st) {
    throw new UnsupportedOperationException("CupertinoSearchTextField_readBack_cursorOpacityAnimates read-back requires FFM/java22");
  }
  default Color CupertinoSearchTextField_readBack_cursorColor(Object st) {
    throw new UnsupportedOperationException("CupertinoSearchTextField_readBack_cursorColor read-back requires FFM/java22");
  }

  default int cupertinoActivityIndicatorCupertinoActivityIndicator(Optional<Color> color, Optional<Boolean> animating, OptionalDouble radius) {
    throw new UnsupportedOperationException("cupertinoActivityIndicatorCupertinoActivityIndicator has no default (FFM/comm impl required)");
  }
  default int cupertinoActivityIndicatorPartiallyRevealed(Optional<Color> color, OptionalDouble radius, OptionalDouble progress) {
    throw new UnsupportedOperationException("cupertinoActivityIndicatorPartiallyRevealed has no default (FFM/comm impl required)");
  }
  default Color CupertinoActivityIndicator_readBack_color(Object st) {
    throw new UnsupportedOperationException("CupertinoActivityIndicator_readBack_color read-back requires FFM/java22");
  }
  default boolean CupertinoActivityIndicator_readBack_animating(Object st) {
    throw new UnsupportedOperationException("CupertinoActivityIndicator_readBack_animating read-back requires FFM/java22");
  }
  default double CupertinoActivityIndicator_readBack_radius(Object st) {
    throw new UnsupportedOperationException("CupertinoActivityIndicator_readBack_radius read-back requires FFM/java22");
  }
  default double CupertinoActivityIndicator_readBack_progress(Object st) {
    throw new UnsupportedOperationException("CupertinoActivityIndicator_readBack_progress read-back requires FFM/java22");
  }

  default int cupertinoListSectionCupertinoListSection(Optional<List<Widget>> children, Optional<Widget> header, Optional<Widget> footer, Optional<EdgeInsetsGeometry> margin, Optional<Color> backgroundColor, Optional<BoxDecoration> decoration, Optional<Clip> clipBehavior, OptionalDouble dividerMargin, OptionalDouble additionalDividerMargin, OptionalDouble topMargin, Optional<Boolean> hasLeading, Optional<Color> separatorColor) {
    throw new UnsupportedOperationException("cupertinoListSectionCupertinoListSection has no default (FFM/comm impl required)");
  }
  default int cupertinoListSectionInsetGrouped(Optional<List<Widget>> children, Optional<Widget> header, Optional<Widget> footer, Optional<EdgeInsetsGeometry> margin, Optional<Color> backgroundColor, Optional<BoxDecoration> decoration, Optional<Clip> clipBehavior, OptionalDouble dividerMargin, OptionalDouble additionalDividerMargin, OptionalDouble topMargin, Optional<Boolean> hasLeading, Optional<Color> separatorColor) {
    throw new UnsupportedOperationException("cupertinoListSectionInsetGrouped has no default (FFM/comm impl required)");
  }
  default CupertinoListSectionType CupertinoListSection_readBack_type(Object st) {
    throw new UnsupportedOperationException("CupertinoListSection_readBack_type read-back requires FFM/java22");
  }
  default Widget CupertinoListSection_readBack_header(Object st) {
    throw new UnsupportedOperationException("CupertinoListSection_readBack_header read-back requires FFM/java22");
  }
  default Widget CupertinoListSection_readBack_footer(Object st) {
    throw new UnsupportedOperationException("CupertinoListSection_readBack_footer read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry CupertinoListSection_readBack_margin(Object st) {
    throw new UnsupportedOperationException("CupertinoListSection_readBack_margin read-back requires FFM/java22");
  }
  default BoxDecoration CupertinoListSection_readBack_decoration(Object st) {
    throw new UnsupportedOperationException("CupertinoListSection_readBack_decoration read-back requires FFM/java22");
  }
  default Color CupertinoListSection_readBack_backgroundColor(Object st) {
    throw new UnsupportedOperationException("CupertinoListSection_readBack_backgroundColor read-back requires FFM/java22");
  }
  default Clip CupertinoListSection_readBack_clipBehavior(Object st) {
    throw new UnsupportedOperationException("CupertinoListSection_readBack_clipBehavior read-back requires FFM/java22");
  }
  default double CupertinoListSection_readBack_dividerMargin(Object st) {
    throw new UnsupportedOperationException("CupertinoListSection_readBack_dividerMargin read-back requires FFM/java22");
  }
  default double CupertinoListSection_readBack_additionalDividerMargin(Object st) {
    throw new UnsupportedOperationException("CupertinoListSection_readBack_additionalDividerMargin read-back requires FFM/java22");
  }
  default double CupertinoListSection_readBack_topMargin(Object st) {
    throw new UnsupportedOperationException("CupertinoListSection_readBack_topMargin read-back requires FFM/java22");
  }
  default Color CupertinoListSection_readBack_separatorColor(Object st) {
    throw new UnsupportedOperationException("CupertinoListSection_readBack_separatorColor read-back requires FFM/java22");
  }

  default int cupertinoListTileCupertinoListTile(Widget title, Optional<Widget> subtitle, Optional<Widget> additionalInfo, Optional<Widget> leading, Optional<Widget> trailing, Optional<Runnable> onTap, Optional<Color> backgroundColor, Optional<Color> backgroundColorActivated, Optional<EdgeInsetsGeometry> padding, OptionalDouble leadingSize, OptionalDouble leadingToTitle) {
    throw new UnsupportedOperationException("cupertinoListTileCupertinoListTile has no default (FFM/comm impl required)");
  }
  default int cupertinoListTileNotched(Widget title, Optional<Widget> subtitle, Optional<Widget> additionalInfo, Optional<Widget> leading, Optional<Widget> trailing, Optional<Runnable> onTap, Optional<Color> backgroundColor, Optional<Color> backgroundColorActivated, Optional<EdgeInsetsGeometry> padding, OptionalDouble leadingSize, OptionalDouble leadingToTitle) {
    throw new UnsupportedOperationException("cupertinoListTileNotched has no default (FFM/comm impl required)");
  }
  default Widget CupertinoListTile_readBack_title(Object st) {
    throw new UnsupportedOperationException("CupertinoListTile_readBack_title read-back requires FFM/java22");
  }
  default Widget CupertinoListTile_readBack_subtitle(Object st) {
    throw new UnsupportedOperationException("CupertinoListTile_readBack_subtitle read-back requires FFM/java22");
  }
  default Widget CupertinoListTile_readBack_additionalInfo(Object st) {
    throw new UnsupportedOperationException("CupertinoListTile_readBack_additionalInfo read-back requires FFM/java22");
  }
  default Widget CupertinoListTile_readBack_leading(Object st) {
    throw new UnsupportedOperationException("CupertinoListTile_readBack_leading read-back requires FFM/java22");
  }
  default Widget CupertinoListTile_readBack_trailing(Object st) {
    throw new UnsupportedOperationException("CupertinoListTile_readBack_trailing read-back requires FFM/java22");
  }
  default Color CupertinoListTile_readBack_backgroundColor(Object st) {
    throw new UnsupportedOperationException("CupertinoListTile_readBack_backgroundColor read-back requires FFM/java22");
  }
  default Color CupertinoListTile_readBack_backgroundColorActivated(Object st) {
    throw new UnsupportedOperationException("CupertinoListTile_readBack_backgroundColorActivated read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry CupertinoListTile_readBack_padding(Object st) {
    throw new UnsupportedOperationException("CupertinoListTile_readBack_padding read-back requires FFM/java22");
  }
  default double CupertinoListTile_readBack_leadingSize(Object st) {
    throw new UnsupportedOperationException("CupertinoListTile_readBack_leadingSize read-back requires FFM/java22");
  }
  default double CupertinoListTile_readBack_leadingToTitle(Object st) {
    throw new UnsupportedOperationException("CupertinoListTile_readBack_leadingToTitle read-back requires FFM/java22");
  }

  default int cupertinoListTileChevronCupertinoListTileChevron() {
    throw new UnsupportedOperationException("cupertinoListTileChevronCupertinoListTileChevron has no default (FFM/comm impl required)");
  }

  default int cupertinoFormSectionCupertinoFormSection(List<Widget> children, Optional<Widget> header, Optional<Widget> footer, Optional<EdgeInsetsGeometry> margin, Optional<Color> backgroundColor, Optional<BoxDecoration> decoration, Optional<Clip> clipBehavior) {
    throw new UnsupportedOperationException("cupertinoFormSectionCupertinoFormSection has no default (FFM/comm impl required)");
  }
  default int cupertinoFormSectionInsetGrouped(List<Widget> children, Optional<Widget> header, Optional<Widget> footer, Optional<EdgeInsetsGeometry> margin, Optional<Color> backgroundColor, Optional<BoxDecoration> decoration, Optional<Clip> clipBehavior) {
    throw new UnsupportedOperationException("cupertinoFormSectionInsetGrouped has no default (FFM/comm impl required)");
  }
  default Widget CupertinoFormSection_readBack_header(Object st) {
    throw new UnsupportedOperationException("CupertinoFormSection_readBack_header read-back requires FFM/java22");
  }
  default Widget CupertinoFormSection_readBack_footer(Object st) {
    throw new UnsupportedOperationException("CupertinoFormSection_readBack_footer read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry CupertinoFormSection_readBack_margin(Object st) {
    throw new UnsupportedOperationException("CupertinoFormSection_readBack_margin read-back requires FFM/java22");
  }
  default BoxDecoration CupertinoFormSection_readBack_decoration(Object st) {
    throw new UnsupportedOperationException("CupertinoFormSection_readBack_decoration read-back requires FFM/java22");
  }
  default Color CupertinoFormSection_readBack_backgroundColor(Object st) {
    throw new UnsupportedOperationException("CupertinoFormSection_readBack_backgroundColor read-back requires FFM/java22");
  }
  default Clip CupertinoFormSection_readBack_clipBehavior(Object st) {
    throw new UnsupportedOperationException("CupertinoFormSection_readBack_clipBehavior read-back requires FFM/java22");
  }

  default int cupertinoFormRowCupertinoFormRow(Widget child, Optional<Widget> prefix, Optional<EdgeInsetsGeometry> padding, Optional<Widget> helper, Optional<Widget> error) {
    throw new UnsupportedOperationException("cupertinoFormRowCupertinoFormRow has no default (FFM/comm impl required)");
  }
  default Widget CupertinoFormRow_readBack_prefix(Object st) {
    throw new UnsupportedOperationException("CupertinoFormRow_readBack_prefix read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry CupertinoFormRow_readBack_padding(Object st) {
    throw new UnsupportedOperationException("CupertinoFormRow_readBack_padding read-back requires FFM/java22");
  }
  default Widget CupertinoFormRow_readBack_helper(Object st) {
    throw new UnsupportedOperationException("CupertinoFormRow_readBack_helper read-back requires FFM/java22");
  }
  default Widget CupertinoFormRow_readBack_error(Object st) {
    throw new UnsupportedOperationException("CupertinoFormRow_readBack_error read-back requires FFM/java22");
  }
  default Widget CupertinoFormRow_readBack_child(Object st) {
    throw new UnsupportedOperationException("CupertinoFormRow_readBack_child read-back requires FFM/java22");
  }

  default int cupertinoPickerCupertinoPicker(OptionalDouble diameterRatio, Optional<Color> backgroundColor, OptionalDouble offAxisFraction, Optional<Boolean> useMagnifier, OptionalDouble magnification, OptionalDouble squeeze, Optional<ChangeReportingBehavior> changeReportingBehavior, double itemExtent, Optional<Consumer<Integer>> onSelectedItemChanged, List<Widget> children, Optional<Widget> selectionOverlay, Optional<Boolean> looping) {
    throw new UnsupportedOperationException("cupertinoPickerCupertinoPicker has no default (FFM/comm impl required)");
  }
  default int cupertinoPickerBuilder(OptionalDouble diameterRatio, Optional<Color> backgroundColor, OptionalDouble offAxisFraction, Optional<Boolean> useMagnifier, OptionalDouble magnification, OptionalDouble squeeze, Optional<ChangeReportingBehavior> changeReportingBehavior, double itemExtent, Optional<Consumer<Integer>> onSelectedItemChanged, BiFunction<BuildContext, Integer, Widget> itemBuilder, OptionalInt childCount, Optional<Widget> selectionOverlay) {
    throw new UnsupportedOperationException("cupertinoPickerBuilder has no default (FFM/comm impl required)");
  }
  default double CupertinoPicker_readBack_diameterRatio(Object st) {
    throw new UnsupportedOperationException("CupertinoPicker_readBack_diameterRatio read-back requires FFM/java22");
  }
  default Color CupertinoPicker_readBack_backgroundColor(Object st) {
    throw new UnsupportedOperationException("CupertinoPicker_readBack_backgroundColor read-back requires FFM/java22");
  }
  default double CupertinoPicker_readBack_offAxisFraction(Object st) {
    throw new UnsupportedOperationException("CupertinoPicker_readBack_offAxisFraction read-back requires FFM/java22");
  }
  default boolean CupertinoPicker_readBack_useMagnifier(Object st) {
    throw new UnsupportedOperationException("CupertinoPicker_readBack_useMagnifier read-back requires FFM/java22");
  }
  default double CupertinoPicker_readBack_magnification(Object st) {
    throw new UnsupportedOperationException("CupertinoPicker_readBack_magnification read-back requires FFM/java22");
  }
  default double CupertinoPicker_readBack_itemExtent(Object st) {
    throw new UnsupportedOperationException("CupertinoPicker_readBack_itemExtent read-back requires FFM/java22");
  }
  default double CupertinoPicker_readBack_squeeze(Object st) {
    throw new UnsupportedOperationException("CupertinoPicker_readBack_squeeze read-back requires FFM/java22");
  }
  default ChangeReportingBehavior CupertinoPicker_readBack_changeReportingBehavior(Object st) {
    throw new UnsupportedOperationException("CupertinoPicker_readBack_changeReportingBehavior read-back requires FFM/java22");
  }
  default Widget CupertinoPicker_readBack_selectionOverlay(Object st) {
    throw new UnsupportedOperationException("CupertinoPicker_readBack_selectionOverlay read-back requires FFM/java22");
  }

  default int cupertinoAlertDialogCupertinoAlertDialog(Optional<Widget> title, Optional<Widget> content, Optional<List<Widget>> actions, Optional<Duration> insetAnimationDuration, Optional<Curve> insetAnimationCurve) {
    throw new UnsupportedOperationException("cupertinoAlertDialogCupertinoAlertDialog has no default (FFM/comm impl required)");
  }
  default Widget CupertinoAlertDialog_readBack_title(Object st) {
    throw new UnsupportedOperationException("CupertinoAlertDialog_readBack_title read-back requires FFM/java22");
  }
  default Widget CupertinoAlertDialog_readBack_content(Object st) {
    throw new UnsupportedOperationException("CupertinoAlertDialog_readBack_content read-back requires FFM/java22");
  }
  default Duration CupertinoAlertDialog_readBack_insetAnimationDuration(Object st) {
    throw new UnsupportedOperationException("CupertinoAlertDialog_readBack_insetAnimationDuration read-back requires FFM/java22");
  }
  default Curve CupertinoAlertDialog_readBack_insetAnimationCurve(Object st) {
    throw new UnsupportedOperationException("CupertinoAlertDialog_readBack_insetAnimationCurve read-back requires FFM/java22");
  }

  default int cupertinoActionSheetCupertinoActionSheet(Optional<Widget> title, Optional<Widget> message, Optional<List<Widget>> actions, Optional<Widget> cancelButton) {
    throw new UnsupportedOperationException("cupertinoActionSheetCupertinoActionSheet has no default (FFM/comm impl required)");
  }
  default Widget CupertinoActionSheet_readBack_title(Object st) {
    throw new UnsupportedOperationException("CupertinoActionSheet_readBack_title read-back requires FFM/java22");
  }
  default Widget CupertinoActionSheet_readBack_message(Object st) {
    throw new UnsupportedOperationException("CupertinoActionSheet_readBack_message read-back requires FFM/java22");
  }
  default Widget CupertinoActionSheet_readBack_cancelButton(Object st) {
    throw new UnsupportedOperationException("CupertinoActionSheet_readBack_cancelButton read-back requires FFM/java22");
  }

  default int cupertinoDialogActionCupertinoDialogAction(Optional<Runnable> onPressed, Optional<Boolean> isDefaultAction, Optional<Boolean> isDestructiveAction, Optional<TextStyle> textStyle, Widget child) {
    throw new UnsupportedOperationException("cupertinoDialogActionCupertinoDialogAction has no default (FFM/comm impl required)");
  }
  default boolean CupertinoDialogAction_readBack_isDefaultAction(Object st) {
    throw new UnsupportedOperationException("CupertinoDialogAction_readBack_isDefaultAction read-back requires FFM/java22");
  }
  default boolean CupertinoDialogAction_readBack_isDestructiveAction(Object st) {
    throw new UnsupportedOperationException("CupertinoDialogAction_readBack_isDestructiveAction read-back requires FFM/java22");
  }
  default TextStyle CupertinoDialogAction_readBack_textStyle(Object st) {
    throw new UnsupportedOperationException("CupertinoDialogAction_readBack_textStyle read-back requires FFM/java22");
  }
  default Widget CupertinoDialogAction_readBack_child(Object st) {
    throw new UnsupportedOperationException("CupertinoDialogAction_readBack_child read-back requires FFM/java22");
  }

  default int cupertinoActionSheetActionCupertinoActionSheetAction(Runnable onPressed, Optional<Boolean> isDefaultAction, Optional<Boolean> isDestructiveAction, Optional<Color> focusColor, Widget child) {
    throw new UnsupportedOperationException("cupertinoActionSheetActionCupertinoActionSheetAction has no default (FFM/comm impl required)");
  }
  default boolean CupertinoActionSheetAction_readBack_isDefaultAction(Object st) {
    throw new UnsupportedOperationException("CupertinoActionSheetAction_readBack_isDefaultAction read-back requires FFM/java22");
  }
  default boolean CupertinoActionSheetAction_readBack_isDestructiveAction(Object st) {
    throw new UnsupportedOperationException("CupertinoActionSheetAction_readBack_isDestructiveAction read-back requires FFM/java22");
  }
  default Color CupertinoActionSheetAction_readBack_focusColor(Object st) {
    throw new UnsupportedOperationException("CupertinoActionSheetAction_readBack_focusColor read-back requires FFM/java22");
  }
  default Widget CupertinoActionSheetAction_readBack_child(Object st) {
    throw new UnsupportedOperationException("CupertinoActionSheetAction_readBack_child read-back requires FFM/java22");
  }

  default int cupertinoTextFieldCupertinoTextField(Optional<NativeObj> groupId, Optional<BoxDecoration> decoration, Optional<EdgeInsetsGeometry> padding, Optional<String> placeholder, Optional<TextStyle> placeholderStyle, Optional<Widget> prefix, Optional<OverlayVisibilityMode> prefixMode, Optional<Widget> suffix, Optional<OverlayVisibilityMode> suffixMode, Optional<CrossAxisAlignment> crossAxisAlignment, Optional<OverlayVisibilityMode> clearButtonMode, Optional<String> clearButtonSemanticLabel, Optional<TextInputAction> textInputAction, Optional<TextCapitalization> textCapitalization, Optional<TextStyle> style, Optional<TextAlign> textAlign, Optional<TextDirection> textDirection, Optional<Boolean> readOnly, Optional<Boolean> showCursor, Optional<Boolean> autofocus, Optional<String> obscuringCharacter, Optional<Boolean> obscureText, Optional<Boolean> autocorrect, Optional<SmartDashesType> smartDashesType, Optional<SmartQuotesType> smartQuotesType, Optional<Boolean> enableSuggestions, OptionalInt maxLines, OptionalInt minLines, Optional<Boolean> expands, OptionalInt maxLength, Optional<MaxLengthEnforcement> maxLengthEnforcement, Optional<Consumer<String>> onChanged, Optional<Runnable> onEditingComplete, Optional<Consumer<String>> onSubmitted, Optional<Consumer<PointerDownEvent>> onTapOutside, Optional<Consumer<PointerDownEvent>> onTapUpOutside, Optional<Boolean> enabled, OptionalDouble cursorWidth, OptionalDouble cursorHeight, Optional<Radius> cursorRadius, Optional<Boolean> cursorOpacityAnimates, Optional<Color> cursorColor, Optional<BoxHeightStyle> selectionHeightStyle, Optional<BoxWidthStyle> selectionWidthStyle, Optional<Brightness> keyboardAppearance, Optional<EdgeInsets> scrollPadding, Optional<DragStartBehavior> dragStartBehavior, Optional<Boolean> enableInteractiveSelection, Optional<Boolean> selectAllOnFocus, Optional<Runnable> onTap, Optional<List<String>> autofillHints, Optional<Clip> clipBehavior, Optional<String> restorationId, Optional<Boolean> scribbleEnabled, Optional<Boolean> stylusHandwritingEnabled, Optional<Boolean> enableIMEPersonalizedLearning, Optional<Boolean> enableInlinePrediction) {
    throw new UnsupportedOperationException("cupertinoTextFieldCupertinoTextField has no default (FFM/comm impl required)");
  }
  default int cupertinoTextFieldBorderless(Optional<NativeObj> groupId, Optional<BoxDecoration> decoration, Optional<EdgeInsetsGeometry> padding, Optional<String> placeholder, Optional<TextStyle> placeholderStyle, Optional<Widget> prefix, Optional<OverlayVisibilityMode> prefixMode, Optional<Widget> suffix, Optional<OverlayVisibilityMode> suffixMode, Optional<CrossAxisAlignment> crossAxisAlignment, Optional<OverlayVisibilityMode> clearButtonMode, Optional<String> clearButtonSemanticLabel, Optional<TextInputAction> textInputAction, Optional<TextCapitalization> textCapitalization, Optional<TextStyle> style, Optional<TextAlign> textAlign, Optional<TextDirection> textDirection, Optional<Boolean> readOnly, Optional<Boolean> showCursor, Optional<Boolean> autofocus, Optional<String> obscuringCharacter, Optional<Boolean> obscureText, Optional<Boolean> autocorrect, Optional<SmartDashesType> smartDashesType, Optional<SmartQuotesType> smartQuotesType, Optional<Boolean> enableSuggestions, OptionalInt maxLines, OptionalInt minLines, Optional<Boolean> expands, OptionalInt maxLength, Optional<MaxLengthEnforcement> maxLengthEnforcement, Optional<Consumer<String>> onChanged, Optional<Runnable> onEditingComplete, Optional<Consumer<String>> onSubmitted, Optional<Consumer<PointerDownEvent>> onTapOutside, Optional<Consumer<PointerDownEvent>> onTapUpOutside, Optional<Boolean> enabled, OptionalDouble cursorWidth, OptionalDouble cursorHeight, Optional<Radius> cursorRadius, Optional<Boolean> cursorOpacityAnimates, Optional<Color> cursorColor, Optional<BoxHeightStyle> selectionHeightStyle, Optional<BoxWidthStyle> selectionWidthStyle, Optional<Brightness> keyboardAppearance, Optional<EdgeInsets> scrollPadding, Optional<DragStartBehavior> dragStartBehavior, Optional<Boolean> enableInteractiveSelection, Optional<Boolean> selectAllOnFocus, Optional<Runnable> onTap, Optional<List<String>> autofillHints, Optional<Clip> clipBehavior, Optional<String> restorationId, Optional<Boolean> scribbleEnabled, Optional<Boolean> stylusHandwritingEnabled, Optional<Boolean> enableIMEPersonalizedLearning, Optional<Boolean> enableInlinePrediction) {
    throw new UnsupportedOperationException("cupertinoTextFieldBorderless has no default (FFM/comm impl required)");
  }
  default BoxDecoration CupertinoTextField_readBack_decoration(Object st) {
    throw new UnsupportedOperationException("CupertinoTextField_readBack_decoration read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry CupertinoTextField_readBack_padding(Object st) {
    throw new UnsupportedOperationException("CupertinoTextField_readBack_padding read-back requires FFM/java22");
  }
  default String CupertinoTextField_readBack_placeholder(Object st) {
    throw new UnsupportedOperationException("CupertinoTextField_readBack_placeholder read-back requires FFM/java22");
  }
  default TextStyle CupertinoTextField_readBack_placeholderStyle(Object st) {
    throw new UnsupportedOperationException("CupertinoTextField_readBack_placeholderStyle read-back requires FFM/java22");
  }
  default Widget CupertinoTextField_readBack_prefix(Object st) {
    throw new UnsupportedOperationException("CupertinoTextField_readBack_prefix read-back requires FFM/java22");
  }
  default OverlayVisibilityMode CupertinoTextField_readBack_prefixMode(Object st) {
    throw new UnsupportedOperationException("CupertinoTextField_readBack_prefixMode read-back requires FFM/java22");
  }
  default Widget CupertinoTextField_readBack_suffix(Object st) {
    throw new UnsupportedOperationException("CupertinoTextField_readBack_suffix read-back requires FFM/java22");
  }
  default OverlayVisibilityMode CupertinoTextField_readBack_suffixMode(Object st) {
    throw new UnsupportedOperationException("CupertinoTextField_readBack_suffixMode read-back requires FFM/java22");
  }
  default CrossAxisAlignment CupertinoTextField_readBack_crossAxisAlignment(Object st) {
    throw new UnsupportedOperationException("CupertinoTextField_readBack_crossAxisAlignment read-back requires FFM/java22");
  }
  default OverlayVisibilityMode CupertinoTextField_readBack_clearButtonMode(Object st) {
    throw new UnsupportedOperationException("CupertinoTextField_readBack_clearButtonMode read-back requires FFM/java22");
  }
  default String CupertinoTextField_readBack_clearButtonSemanticLabel(Object st) {
    throw new UnsupportedOperationException("CupertinoTextField_readBack_clearButtonSemanticLabel read-back requires FFM/java22");
  }
  default TextInputAction CupertinoTextField_readBack_textInputAction(Object st) {
    throw new UnsupportedOperationException("CupertinoTextField_readBack_textInputAction read-back requires FFM/java22");
  }
  default TextCapitalization CupertinoTextField_readBack_textCapitalization(Object st) {
    throw new UnsupportedOperationException("CupertinoTextField_readBack_textCapitalization read-back requires FFM/java22");
  }
  default TextStyle CupertinoTextField_readBack_style(Object st) {
    throw new UnsupportedOperationException("CupertinoTextField_readBack_style read-back requires FFM/java22");
  }
  default TextAlign CupertinoTextField_readBack_textAlign(Object st) {
    throw new UnsupportedOperationException("CupertinoTextField_readBack_textAlign read-back requires FFM/java22");
  }
  default TextDirection CupertinoTextField_readBack_textDirection(Object st) {
    throw new UnsupportedOperationException("CupertinoTextField_readBack_textDirection read-back requires FFM/java22");
  }
  default boolean CupertinoTextField_readBack_readOnly(Object st) {
    throw new UnsupportedOperationException("CupertinoTextField_readBack_readOnly read-back requires FFM/java22");
  }
  default boolean CupertinoTextField_readBack_showCursor(Object st) {
    throw new UnsupportedOperationException("CupertinoTextField_readBack_showCursor read-back requires FFM/java22");
  }
  default boolean CupertinoTextField_readBack_autofocus(Object st) {
    throw new UnsupportedOperationException("CupertinoTextField_readBack_autofocus read-back requires FFM/java22");
  }
  default String CupertinoTextField_readBack_obscuringCharacter(Object st) {
    throw new UnsupportedOperationException("CupertinoTextField_readBack_obscuringCharacter read-back requires FFM/java22");
  }
  default boolean CupertinoTextField_readBack_obscureText(Object st) {
    throw new UnsupportedOperationException("CupertinoTextField_readBack_obscureText read-back requires FFM/java22");
  }
  default boolean CupertinoTextField_readBack_autocorrect(Object st) {
    throw new UnsupportedOperationException("CupertinoTextField_readBack_autocorrect read-back requires FFM/java22");
  }
  default SmartDashesType CupertinoTextField_readBack_smartDashesType(Object st) {
    throw new UnsupportedOperationException("CupertinoTextField_readBack_smartDashesType read-back requires FFM/java22");
  }
  default SmartQuotesType CupertinoTextField_readBack_smartQuotesType(Object st) {
    throw new UnsupportedOperationException("CupertinoTextField_readBack_smartQuotesType read-back requires FFM/java22");
  }
  default boolean CupertinoTextField_readBack_enableSuggestions(Object st) {
    throw new UnsupportedOperationException("CupertinoTextField_readBack_enableSuggestions read-back requires FFM/java22");
  }
  default int CupertinoTextField_readBack_maxLines(Object st) {
    throw new UnsupportedOperationException("CupertinoTextField_readBack_maxLines read-back requires FFM/java22");
  }
  default int CupertinoTextField_readBack_minLines(Object st) {
    throw new UnsupportedOperationException("CupertinoTextField_readBack_minLines read-back requires FFM/java22");
  }
  default boolean CupertinoTextField_readBack_expands(Object st) {
    throw new UnsupportedOperationException("CupertinoTextField_readBack_expands read-back requires FFM/java22");
  }
  default int CupertinoTextField_readBack_maxLength(Object st) {
    throw new UnsupportedOperationException("CupertinoTextField_readBack_maxLength read-back requires FFM/java22");
  }
  default MaxLengthEnforcement CupertinoTextField_readBack_maxLengthEnforcement(Object st) {
    throw new UnsupportedOperationException("CupertinoTextField_readBack_maxLengthEnforcement read-back requires FFM/java22");
  }
  default boolean CupertinoTextField_readBack_enabled(Object st) {
    throw new UnsupportedOperationException("CupertinoTextField_readBack_enabled read-back requires FFM/java22");
  }
  default double CupertinoTextField_readBack_cursorWidth(Object st) {
    throw new UnsupportedOperationException("CupertinoTextField_readBack_cursorWidth read-back requires FFM/java22");
  }
  default double CupertinoTextField_readBack_cursorHeight(Object st) {
    throw new UnsupportedOperationException("CupertinoTextField_readBack_cursorHeight read-back requires FFM/java22");
  }
  default Radius CupertinoTextField_readBack_cursorRadius(Object st) {
    throw new UnsupportedOperationException("CupertinoTextField_readBack_cursorRadius read-back requires FFM/java22");
  }
  default boolean CupertinoTextField_readBack_cursorOpacityAnimates(Object st) {
    throw new UnsupportedOperationException("CupertinoTextField_readBack_cursorOpacityAnimates read-back requires FFM/java22");
  }
  default Color CupertinoTextField_readBack_cursorColor(Object st) {
    throw new UnsupportedOperationException("CupertinoTextField_readBack_cursorColor read-back requires FFM/java22");
  }
  default BoxHeightStyle CupertinoTextField_readBack_selectionHeightStyle(Object st) {
    throw new UnsupportedOperationException("CupertinoTextField_readBack_selectionHeightStyle read-back requires FFM/java22");
  }
  default BoxWidthStyle CupertinoTextField_readBack_selectionWidthStyle(Object st) {
    throw new UnsupportedOperationException("CupertinoTextField_readBack_selectionWidthStyle read-back requires FFM/java22");
  }
  default Brightness CupertinoTextField_readBack_keyboardAppearance(Object st) {
    throw new UnsupportedOperationException("CupertinoTextField_readBack_keyboardAppearance read-back requires FFM/java22");
  }
  default EdgeInsets CupertinoTextField_readBack_scrollPadding(Object st) {
    throw new UnsupportedOperationException("CupertinoTextField_readBack_scrollPadding read-back requires FFM/java22");
  }
  default boolean CupertinoTextField_readBack_enableInteractiveSelection(Object st) {
    throw new UnsupportedOperationException("CupertinoTextField_readBack_enableInteractiveSelection read-back requires FFM/java22");
  }
  default boolean CupertinoTextField_readBack_selectAllOnFocus(Object st) {
    throw new UnsupportedOperationException("CupertinoTextField_readBack_selectAllOnFocus read-back requires FFM/java22");
  }
  default DragStartBehavior CupertinoTextField_readBack_dragStartBehavior(Object st) {
    throw new UnsupportedOperationException("CupertinoTextField_readBack_dragStartBehavior read-back requires FFM/java22");
  }
  default Clip CupertinoTextField_readBack_clipBehavior(Object st) {
    throw new UnsupportedOperationException("CupertinoTextField_readBack_clipBehavior read-back requires FFM/java22");
  }
  default String CupertinoTextField_readBack_restorationId(Object st) {
    throw new UnsupportedOperationException("CupertinoTextField_readBack_restorationId read-back requires FFM/java22");
  }
  default boolean CupertinoTextField_readBack_scribbleEnabled(Object st) {
    throw new UnsupportedOperationException("CupertinoTextField_readBack_scribbleEnabled read-back requires FFM/java22");
  }
  default boolean CupertinoTextField_readBack_stylusHandwritingEnabled(Object st) {
    throw new UnsupportedOperationException("CupertinoTextField_readBack_stylusHandwritingEnabled read-back requires FFM/java22");
  }
  default boolean CupertinoTextField_readBack_enableIMEPersonalizedLearning(Object st) {
    throw new UnsupportedOperationException("CupertinoTextField_readBack_enableIMEPersonalizedLearning read-back requires FFM/java22");
  }
  default boolean CupertinoTextField_readBack_enableInlinePrediction(Object st) {
    throw new UnsupportedOperationException("CupertinoTextField_readBack_enableInlinePrediction read-back requires FFM/java22");
  }
  default boolean CupertinoTextField_readBack_selectionEnabled(Object st) {
    throw new UnsupportedOperationException("CupertinoTextField_readBack_selectionEnabled read-back requires FFM/java22");
  }

  default int cupertinoCheckboxCupertinoCheckbox(Optional<Boolean> value, Optional<Boolean> tristate, Optional<Consumer<Boolean>> onChanged, Optional<Color> activeColor, Optional<Color> inactiveColor, Optional<Color> fillColor, Optional<Color> checkColor, Optional<Color> focusColor, Optional<Boolean> autofocus, Optional<BorderSide> side, Optional<OutlinedBorder> shape, Optional<String> semanticLabel) {
    throw new UnsupportedOperationException("cupertinoCheckboxCupertinoCheckbox has no default (FFM/comm impl required)");
  }
  default boolean CupertinoCheckbox_readBack_value(Object st) {
    throw new UnsupportedOperationException("CupertinoCheckbox_readBack_value read-back requires FFM/java22");
  }
  default Color CupertinoCheckbox_readBack_activeColor(Object st) {
    throw new UnsupportedOperationException("CupertinoCheckbox_readBack_activeColor read-back requires FFM/java22");
  }
  default Color CupertinoCheckbox_readBack_inactiveColor(Object st) {
    throw new UnsupportedOperationException("CupertinoCheckbox_readBack_inactiveColor read-back requires FFM/java22");
  }
  default Color CupertinoCheckbox_readBack_checkColor(Object st) {
    throw new UnsupportedOperationException("CupertinoCheckbox_readBack_checkColor read-back requires FFM/java22");
  }
  default boolean CupertinoCheckbox_readBack_tristate(Object st) {
    throw new UnsupportedOperationException("CupertinoCheckbox_readBack_tristate read-back requires FFM/java22");
  }
  default Color CupertinoCheckbox_readBack_focusColor(Object st) {
    throw new UnsupportedOperationException("CupertinoCheckbox_readBack_focusColor read-back requires FFM/java22");
  }
  default boolean CupertinoCheckbox_readBack_autofocus(Object st) {
    throw new UnsupportedOperationException("CupertinoCheckbox_readBack_autofocus read-back requires FFM/java22");
  }
  default BorderSide CupertinoCheckbox_readBack_side(Object st) {
    throw new UnsupportedOperationException("CupertinoCheckbox_readBack_side read-back requires FFM/java22");
  }
  default OutlinedBorder CupertinoCheckbox_readBack_shape(Object st) {
    throw new UnsupportedOperationException("CupertinoCheckbox_readBack_shape read-back requires FFM/java22");
  }
  default String CupertinoCheckbox_readBack_semanticLabel(Object st) {
    throw new UnsupportedOperationException("CupertinoCheckbox_readBack_semanticLabel read-back requires FFM/java22");
  }

  default int cupertinoExpansionTileCupertinoExpansionTile(Widget title, Widget child, Optional<ExpansionTileTransitionMode> transitionMode) {
    throw new UnsupportedOperationException("cupertinoExpansionTileCupertinoExpansionTile has no default (FFM/comm impl required)");
  }
  default Widget CupertinoExpansionTile_readBack_title(Object st) {
    throw new UnsupportedOperationException("CupertinoExpansionTile_readBack_title read-back requires FFM/java22");
  }
  default Widget CupertinoExpansionTile_readBack_child(Object st) {
    throw new UnsupportedOperationException("CupertinoExpansionTile_readBack_child read-back requires FFM/java22");
  }
  default ExpansionTileTransitionMode CupertinoExpansionTile_readBack_transitionMode(Object st) {
    throw new UnsupportedOperationException("CupertinoExpansionTile_readBack_transitionMode read-back requires FFM/java22");
  }

  default int cupertinoTimerPickerCupertinoTimerPicker(Optional<CupertinoTimerPickerMode> mode, Optional<Duration> initialTimerDuration, OptionalInt minuteInterval, OptionalInt secondInterval, Optional<AlignmentGeometry> alignment, Optional<Color> backgroundColor, OptionalDouble itemExtent, Consumer<Duration> onTimerDurationChanged, Optional<ChangeReportingBehavior> changeReportingBehavior, Optional<TriFunction<BuildContext, Integer, Integer, Widget>> selectionOverlayBuilder) {
    throw new UnsupportedOperationException("cupertinoTimerPickerCupertinoTimerPicker has no default (FFM/comm impl required)");
  }
  default CupertinoTimerPickerMode CupertinoTimerPicker_readBack_mode(Object st) {
    throw new UnsupportedOperationException("CupertinoTimerPicker_readBack_mode read-back requires FFM/java22");
  }
  default Duration CupertinoTimerPicker_readBack_initialTimerDuration(Object st) {
    throw new UnsupportedOperationException("CupertinoTimerPicker_readBack_initialTimerDuration read-back requires FFM/java22");
  }
  default int CupertinoTimerPicker_readBack_minuteInterval(Object st) {
    throw new UnsupportedOperationException("CupertinoTimerPicker_readBack_minuteInterval read-back requires FFM/java22");
  }
  default int CupertinoTimerPicker_readBack_secondInterval(Object st) {
    throw new UnsupportedOperationException("CupertinoTimerPicker_readBack_secondInterval read-back requires FFM/java22");
  }
  default AlignmentGeometry CupertinoTimerPicker_readBack_alignment(Object st) {
    throw new UnsupportedOperationException("CupertinoTimerPicker_readBack_alignment read-back requires FFM/java22");
  }
  default Color CupertinoTimerPicker_readBack_backgroundColor(Object st) {
    throw new UnsupportedOperationException("CupertinoTimerPicker_readBack_backgroundColor read-back requires FFM/java22");
  }
  default double CupertinoTimerPicker_readBack_itemExtent(Object st) {
    throw new UnsupportedOperationException("CupertinoTimerPicker_readBack_itemExtent read-back requires FFM/java22");
  }
  default ChangeReportingBehavior CupertinoTimerPicker_readBack_changeReportingBehavior(Object st) {
    throw new UnsupportedOperationException("CupertinoTimerPicker_readBack_changeReportingBehavior read-back requires FFM/java22");
  }

  default int cupertinoNavigationBarBackButtonCupertinoNavigationBarBackButton(Optional<Color> color, Optional<String> previousPageTitle, Optional<Runnable> onPressed) {
    throw new UnsupportedOperationException("cupertinoNavigationBarBackButtonCupertinoNavigationBarBackButton has no default (FFM/comm impl required)");
  }
  default Color CupertinoNavigationBarBackButton_readBack_color(Object st) {
    throw new UnsupportedOperationException("CupertinoNavigationBarBackButton_readBack_color read-back requires FFM/java22");
  }
  default String CupertinoNavigationBarBackButton_readBack_previousPageTitle(Object st) {
    throw new UnsupportedOperationException("CupertinoNavigationBarBackButton_readBack_previousPageTitle read-back requires FFM/java22");
  }

  default int cupertinoTabBarCupertinoTabBar(List<BottomNavigationBarItem> items, Optional<Consumer<Integer>> onTap, OptionalInt currentIndex, Optional<Color> backgroundColor, Optional<Color> activeColor, Optional<Color> inactiveColor, OptionalDouble iconSize, OptionalDouble height, Optional<Border> border) {
    throw new UnsupportedOperationException("cupertinoTabBarCupertinoTabBar has no default (FFM/comm impl required)");
  }
  default int CupertinoTabBar_readBack_currentIndex(Object st) {
    throw new UnsupportedOperationException("CupertinoTabBar_readBack_currentIndex read-back requires FFM/java22");
  }
  default Color CupertinoTabBar_readBack_backgroundColor(Object st) {
    throw new UnsupportedOperationException("CupertinoTabBar_readBack_backgroundColor read-back requires FFM/java22");
  }
  default Color CupertinoTabBar_readBack_activeColor(Object st) {
    throw new UnsupportedOperationException("CupertinoTabBar_readBack_activeColor read-back requires FFM/java22");
  }
  default Color CupertinoTabBar_readBack_inactiveColor(Object st) {
    throw new UnsupportedOperationException("CupertinoTabBar_readBack_inactiveColor read-back requires FFM/java22");
  }
  default double CupertinoTabBar_readBack_iconSize(Object st) {
    throw new UnsupportedOperationException("CupertinoTabBar_readBack_iconSize read-back requires FFM/java22");
  }
  default double CupertinoTabBar_readBack_height(Object st) {
    throw new UnsupportedOperationException("CupertinoTabBar_readBack_height read-back requires FFM/java22");
  }
  default Border CupertinoTabBar_readBack_border(Object st) {
    throw new UnsupportedOperationException("CupertinoTabBar_readBack_border read-back requires FFM/java22");
  }

  default int bottomNavigationBarItemBottomNavigationBarItem(Widget icon, Optional<String> label, Optional<Widget> activeIcon, Optional<Color> backgroundColor, Optional<String> tooltip, Optional<String> semanticsLabel) {
    throw new UnsupportedOperationException("bottomNavigationBarItemBottomNavigationBarItem has no default (FFM/comm impl required)");
  }

  default int cupertinoTabScaffoldCupertinoTabScaffold(CupertinoTabBar tabBar, BiFunction<BuildContext, Integer, Widget> tabBuilder, Optional<Color> backgroundColor, Optional<Boolean> resizeToAvoidBottomInset, Optional<String> restorationId) {
    throw new UnsupportedOperationException("cupertinoTabScaffoldCupertinoTabScaffold has no default (FFM/comm impl required)");
  }
  default CupertinoTabBar CupertinoTabScaffold_readBack_tabBar(Object st) {
    throw new UnsupportedOperationException("CupertinoTabScaffold_readBack_tabBar read-back requires FFM/java22");
  }
  default Color CupertinoTabScaffold_readBack_backgroundColor(Object st) {
    throw new UnsupportedOperationException("CupertinoTabScaffold_readBack_backgroundColor read-back requires FFM/java22");
  }
  default boolean CupertinoTabScaffold_readBack_resizeToAvoidBottomInset(Object st) {
    throw new UnsupportedOperationException("CupertinoTabScaffold_readBack_resizeToAvoidBottomInset read-back requires FFM/java22");
  }
  default String CupertinoTabScaffold_readBack_restorationId(Object st) {
    throw new UnsupportedOperationException("CupertinoTabScaffold_readBack_restorationId read-back requires FFM/java22");
  }

  default int cupertinoContextMenuCupertinoContextMenu(List<Widget> actions, Widget child, Optional<Boolean> enableHapticFeedback) {
    throw new UnsupportedOperationException("cupertinoContextMenuCupertinoContextMenu has no default (FFM/comm impl required)");
  }
  default int cupertinoContextMenuBuilder(List<Widget> actions, BiFunction<BuildContext, Animation, Widget> builder, Optional<Boolean> enableHapticFeedback) {
    throw new UnsupportedOperationException("cupertinoContextMenuBuilder has no default (FFM/comm impl required)");
  }
  default Widget CupertinoContextMenu_readBack_child(Object st) {
    throw new UnsupportedOperationException("CupertinoContextMenu_readBack_child read-back requires FFM/java22");
  }
  default boolean CupertinoContextMenu_readBack_enableHapticFeedback(Object st) {
    throw new UnsupportedOperationException("CupertinoContextMenu_readBack_enableHapticFeedback read-back requires FFM/java22");
  }

  default int cupertinoContextMenuActionCupertinoContextMenuAction(Widget child, Optional<Boolean> isDefaultAction, Optional<Boolean> isDestructiveAction, Optional<Runnable> onPressed, Optional<IconData> trailingIcon) {
    throw new UnsupportedOperationException("cupertinoContextMenuActionCupertinoContextMenuAction has no default (FFM/comm impl required)");
  }
  default Widget CupertinoContextMenuAction_readBack_child(Object st) {
    throw new UnsupportedOperationException("CupertinoContextMenuAction_readBack_child read-back requires FFM/java22");
  }
  default boolean CupertinoContextMenuAction_readBack_isDefaultAction(Object st) {
    throw new UnsupportedOperationException("CupertinoContextMenuAction_readBack_isDefaultAction read-back requires FFM/java22");
  }
  default boolean CupertinoContextMenuAction_readBack_isDestructiveAction(Object st) {
    throw new UnsupportedOperationException("CupertinoContextMenuAction_readBack_isDestructiveAction read-back requires FFM/java22");
  }
  default IconData CupertinoContextMenuAction_readBack_trailingIcon(Object st) {
    throw new UnsupportedOperationException("CupertinoContextMenuAction_readBack_trailingIcon read-back requires FFM/java22");
  }

  default int layoutBuilderLayoutBuilder(BiFunction<BuildContext, BoxConstraints, Widget> builder) {
    throw new UnsupportedOperationException("layoutBuilderLayoutBuilder has no default (FFM/comm impl required)");
  }

  default int orientationBuilderOrientationBuilder(BiFunction<BuildContext, Orientation, Widget> builder) {
    throw new UnsupportedOperationException("orientationBuilderOrientationBuilder has no default (FFM/comm impl required)");
  }

  default Widget PreferredSize_readBack_child(Object st) {
    throw new UnsupportedOperationException("PreferredSize_readBack_child read-back requires FFM/java22");
  }

  default int iconThemeIconTheme(IconThemeData data, Widget child) {
    throw new UnsupportedOperationException("iconThemeIconTheme has no default (FFM/comm impl required)");
  }
  default int iconThemeMerge(IconThemeData data, Widget child) {
    throw new UnsupportedOperationException("iconThemeMerge has no default (FFM/comm impl required)");
  }
  default int iconThemeOf(BuildContext context) {
    throw new UnsupportedOperationException("iconThemeOf has no default (FFM/comm impl required)");
  }
  default IconThemeData IconTheme_readBack_data(Object st) {
    throw new UnsupportedOperationException("IconTheme_readBack_data read-back requires FFM/java22");
  }

  default int backButtonBackButton(Optional<Color> color, Optional<Runnable> onPressed) {
    throw new UnsupportedOperationException("backButtonBackButton has no default (FFM/comm impl required)");
  }

  default int closeButtonCloseButton(Optional<Color> color, Optional<Runnable> onPressed) {
    throw new UnsupportedOperationException("closeButtonCloseButton has no default (FFM/comm impl required)");
  }

  default int drawerButtonDrawerButton(Optional<Color> color, Optional<Runnable> onPressed) {
    throw new UnsupportedOperationException("drawerButtonDrawerButton has no default (FFM/comm impl required)");
  }

  default int endDrawerButtonEndDrawerButton(Optional<Color> color, Optional<Runnable> onPressed) {
    throw new UnsupportedOperationException("endDrawerButtonEndDrawerButton has no default (FFM/comm impl required)");
  }

  default int backButtonIconBackButtonIcon() {
    throw new UnsupportedOperationException("backButtonIconBackButtonIcon has no default (FFM/comm impl required)");
  }

  default int closeButtonIconCloseButtonIcon() {
    throw new UnsupportedOperationException("closeButtonIconCloseButtonIcon has no default (FFM/comm impl required)");
  }

  default int drawerButtonIconDrawerButtonIcon() {
    throw new UnsupportedOperationException("drawerButtonIconDrawerButtonIcon has no default (FFM/comm impl required)");
  }

  default int endDrawerButtonIconEndDrawerButtonIcon() {
    throw new UnsupportedOperationException("endDrawerButtonIconEndDrawerButtonIcon has no default (FFM/comm impl required)");
  }

  default int animatedThemeAnimatedTheme(ThemeData data, Optional<Curve> curve, Optional<Duration> duration, Optional<Runnable> onEnd, Widget child) {
    throw new UnsupportedOperationException("animatedThemeAnimatedTheme has no default (FFM/comm impl required)");
  }
  default ThemeData AnimatedTheme_readBack_data(Object st) {
    throw new UnsupportedOperationException("AnimatedTheme_readBack_data read-back requires FFM/java22");
  }
  default Widget AnimatedTheme_readBack_child(Object st) {
    throw new UnsupportedOperationException("AnimatedTheme_readBack_child read-back requires FFM/java22");
  }

  default int aboutDialogAboutDialog(Optional<String> applicationName, Optional<String> applicationVersion, Optional<Widget> applicationIcon, Optional<String> applicationLegalese, Optional<List<Widget>> children) {
    throw new UnsupportedOperationException("aboutDialogAboutDialog has no default (FFM/comm impl required)");
  }
  default int aboutDialogAdaptive(Optional<String> applicationName, Optional<String> applicationVersion, Optional<Widget> applicationIcon, Optional<String> applicationLegalese, Optional<List<Widget>> children) {
    throw new UnsupportedOperationException("aboutDialogAdaptive has no default (FFM/comm impl required)");
  }
  default String AboutDialog_readBack_applicationName(Object st) {
    throw new UnsupportedOperationException("AboutDialog_readBack_applicationName read-back requires FFM/java22");
  }
  default String AboutDialog_readBack_applicationVersion(Object st) {
    throw new UnsupportedOperationException("AboutDialog_readBack_applicationVersion read-back requires FFM/java22");
  }
  default Widget AboutDialog_readBack_applicationIcon(Object st) {
    throw new UnsupportedOperationException("AboutDialog_readBack_applicationIcon read-back requires FFM/java22");
  }
  default String AboutDialog_readBack_applicationLegalese(Object st) {
    throw new UnsupportedOperationException("AboutDialog_readBack_applicationLegalese read-back requires FFM/java22");
  }

  default int focusFocus(Widget child, Optional<Boolean> autofocus, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> canRequestFocus, Optional<Boolean> skipTraversal, Optional<Boolean> descendantsAreFocusable, Optional<Boolean> descendantsAreTraversable, Optional<Boolean> includeSemantics, Optional<String> debugLabel) {
    throw new UnsupportedOperationException("focusFocus has no default (FFM/comm impl required)");
  }
  default int focusIsAt(BuildContext context) {
    throw new UnsupportedOperationException("focusIsAt has no default (FFM/comm impl required)");
  }
  default Widget Focus_readBack_child(Object st) {
    throw new UnsupportedOperationException("Focus_readBack_child read-back requires FFM/java22");
  }
  default boolean Focus_readBack_autofocus(Object st) {
    throw new UnsupportedOperationException("Focus_readBack_autofocus read-back requires FFM/java22");
  }
  default boolean Focus_readBack_includeSemantics(Object st) {
    throw new UnsupportedOperationException("Focus_readBack_includeSemantics read-back requires FFM/java22");
  }
  default boolean Focus_readBack_canRequestFocus(Object st) {
    throw new UnsupportedOperationException("Focus_readBack_canRequestFocus read-back requires FFM/java22");
  }
  default boolean Focus_readBack_skipTraversal(Object st) {
    throw new UnsupportedOperationException("Focus_readBack_skipTraversal read-back requires FFM/java22");
  }
  default boolean Focus_readBack_descendantsAreFocusable(Object st) {
    throw new UnsupportedOperationException("Focus_readBack_descendantsAreFocusable read-back requires FFM/java22");
  }
  default boolean Focus_readBack_descendantsAreTraversable(Object st) {
    throw new UnsupportedOperationException("Focus_readBack_descendantsAreTraversable read-back requires FFM/java22");
  }
  default String Focus_readBack_debugLabel(Object st) {
    throw new UnsupportedOperationException("Focus_readBack_debugLabel read-back requires FFM/java22");
  }

  default int focusScopeFocusScope(Widget child, Optional<Boolean> autofocus, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> canRequestFocus, Optional<Boolean> skipTraversal, Optional<String> debugLabel, Optional<Boolean> includeSemantics, Optional<Boolean> descendantsAreFocusable, Optional<Boolean> descendantsAreTraversable) {
    throw new UnsupportedOperationException("focusScopeFocusScope has no default (FFM/comm impl required)");
  }

  default int formForm(Widget child, Optional<Boolean> canPop, Optional<Consumer<Boolean>> onPopInvoked, Optional<BiConsumer<Boolean, NativeObj>> onPopInvokedWithResult, Optional<Supplier<Future<Boolean>>> onWillPop, Optional<Runnable> onChanged, Optional<AutovalidateMode> autovalidateMode) {
    throw new UnsupportedOperationException("formForm has no default (FFM/comm impl required)");
  }
  default Widget Form_readBack_child(Object st) {
    throw new UnsupportedOperationException("Form_readBack_child read-back requires FFM/java22");
  }
  default boolean Form_readBack_canPop(Object st) {
    throw new UnsupportedOperationException("Form_readBack_canPop read-back requires FFM/java22");
  }
  default AutovalidateMode Form_readBack_autovalidateMode(Object st) {
    throw new UnsupportedOperationException("Form_readBack_autovalidateMode read-back requires FFM/java22");
  }

  default int primaryScrollControllerNone(Widget child) {
    throw new UnsupportedOperationException("primaryScrollControllerNone has no default (FFM/comm impl required)");
  }
  default int primaryScrollControllerShouldInherit(BuildContext context, Axis scrollDirection) {
    throw new UnsupportedOperationException("primaryScrollControllerShouldInherit has no default (FFM/comm impl required)");
  }
  default Axis PrimaryScrollController_readBack_scrollDirection(Object st) {
    throw new UnsupportedOperationException("PrimaryScrollController_readBack_scrollDirection read-back requires FFM/java22");
  }

  default int statefulBuilderStatefulBuilder(BiFunction<BuildContext, Consumer<Runnable>, Widget> builder) {
    throw new UnsupportedOperationException("statefulBuilderStatefulBuilder has no default (FFM/comm impl required)");
  }

  default int tableCellTableCell(Optional<TableCellVerticalAlignment> verticalAlignment, Widget child) {
    throw new UnsupportedOperationException("tableCellTableCell has no default (FFM/comm impl required)");
  }
  default TableCellVerticalAlignment TableCell_readBack_verticalAlignment(Object st) {
    throw new UnsupportedOperationException("TableCell_readBack_verticalAlignment read-back requires FFM/java22");
  }
  default Widget TableCell_readBack_child(Object st) {
    throw new UnsupportedOperationException("TableCell_readBack_child read-back requires FFM/java22");
  }

  default int imageNetwork(String src, OptionalDouble scale, Optional<QuadFunction<BuildContext, Widget, Integer, Boolean, Widget>> frameBuilder, Optional<String> semanticLabel, Optional<Boolean> excludeFromSemantics, OptionalDouble width, OptionalDouble height, Optional<Color> color, Optional<Animation> opacity, Optional<BlendMode> colorBlendMode, Optional<BoxFit> fit, Optional<AlignmentGeometry> alignment, Optional<ImageRepeat> repeat, Optional<Boolean> matchTextDirection, Optional<Boolean> gaplessPlayback, Optional<FilterQuality> filterQuality, Optional<Boolean> isAntiAlias, OptionalInt cacheWidth, OptionalInt cacheHeight, Optional<WebHtmlElementStrategy> webHtmlElementStrategy) {
    throw new UnsupportedOperationException("imageNetwork has no default (FFM/comm impl required)");
  }
  default int imageAsset(String name, Optional<QuadFunction<BuildContext, Widget, Integer, Boolean, Widget>> frameBuilder, Optional<String> semanticLabel, Optional<Boolean> excludeFromSemantics, OptionalDouble scale, OptionalDouble width, OptionalDouble height, Optional<Color> color, Optional<Animation> opacity, Optional<BlendMode> colorBlendMode, Optional<BoxFit> fit, Optional<AlignmentGeometry> alignment, Optional<ImageRepeat> repeat, Optional<Boolean> matchTextDirection, Optional<Boolean> gaplessPlayback, Optional<Boolean> isAntiAlias, Optional<String> _package, Optional<FilterQuality> filterQuality, OptionalInt cacheWidth, OptionalInt cacheHeight) {
    throw new UnsupportedOperationException("imageAsset has no default (FFM/comm impl required)");
  }
  default double Image_readBack_width(Object st) {
    throw new UnsupportedOperationException("Image_readBack_width read-back requires FFM/java22");
  }
  default double Image_readBack_height(Object st) {
    throw new UnsupportedOperationException("Image_readBack_height read-back requires FFM/java22");
  }
  default Color Image_readBack_color(Object st) {
    throw new UnsupportedOperationException("Image_readBack_color read-back requires FFM/java22");
  }
  default Animation Image_readBack_opacity(Object st) {
    throw new UnsupportedOperationException("Image_readBack_opacity read-back requires FFM/java22");
  }
  default FilterQuality Image_readBack_filterQuality(Object st) {
    throw new UnsupportedOperationException("Image_readBack_filterQuality read-back requires FFM/java22");
  }
  default BlendMode Image_readBack_colorBlendMode(Object st) {
    throw new UnsupportedOperationException("Image_readBack_colorBlendMode read-back requires FFM/java22");
  }
  default BoxFit Image_readBack_fit(Object st) {
    throw new UnsupportedOperationException("Image_readBack_fit read-back requires FFM/java22");
  }
  default AlignmentGeometry Image_readBack_alignment(Object st) {
    throw new UnsupportedOperationException("Image_readBack_alignment read-back requires FFM/java22");
  }
  default ImageRepeat Image_readBack_repeat(Object st) {
    throw new UnsupportedOperationException("Image_readBack_repeat read-back requires FFM/java22");
  }
  default boolean Image_readBack_matchTextDirection(Object st) {
    throw new UnsupportedOperationException("Image_readBack_matchTextDirection read-back requires FFM/java22");
  }
  default boolean Image_readBack_gaplessPlayback(Object st) {
    throw new UnsupportedOperationException("Image_readBack_gaplessPlayback read-back requires FFM/java22");
  }
  default String Image_readBack_semanticLabel(Object st) {
    throw new UnsupportedOperationException("Image_readBack_semanticLabel read-back requires FFM/java22");
  }
  default boolean Image_readBack_excludeFromSemantics(Object st) {
    throw new UnsupportedOperationException("Image_readBack_excludeFromSemantics read-back requires FFM/java22");
  }
  default boolean Image_readBack_isAntiAlias(Object st) {
    throw new UnsupportedOperationException("Image_readBack_isAntiAlias read-back requires FFM/java22");
  }

  default double ImageIcon_readBack_size(Object st) {
    throw new UnsupportedOperationException("ImageIcon_readBack_size read-back requires FFM/java22");
  }
  default Color ImageIcon_readBack_color(Object st) {
    throw new UnsupportedOperationException("ImageIcon_readBack_color read-back requires FFM/java22");
  }
  default String ImageIcon_readBack_semanticLabel(Object st) {
    throw new UnsupportedOperationException("ImageIcon_readBack_semanticLabel read-back requires FFM/java22");
  }
  default boolean ImageIcon_readBack_useOriginalColors(Object st) {
    throw new UnsupportedOperationException("ImageIcon_readBack_useOriginalColors read-back requires FFM/java22");
  }

  default int buttonBarButtonBar(Optional<MainAxisAlignment> alignment, Optional<MainAxisSize> mainAxisSize, Optional<ButtonTextTheme> buttonTextTheme, OptionalDouble buttonMinWidth, OptionalDouble buttonHeight, Optional<EdgeInsetsGeometry> buttonPadding, Optional<Boolean> buttonAlignedDropdown, Optional<ButtonBarLayoutBehavior> layoutBehavior, Optional<VerticalDirection> overflowDirection, OptionalDouble overflowButtonSpacing, Optional<List<Widget>> children) {
    throw new UnsupportedOperationException("buttonBarButtonBar has no default (FFM/comm impl required)");
  }
  default MainAxisAlignment ButtonBar_readBack_alignment(Object st) {
    throw new UnsupportedOperationException("ButtonBar_readBack_alignment read-back requires FFM/java22");
  }
  default MainAxisSize ButtonBar_readBack_mainAxisSize(Object st) {
    throw new UnsupportedOperationException("ButtonBar_readBack_mainAxisSize read-back requires FFM/java22");
  }
  default ButtonTextTheme ButtonBar_readBack_buttonTextTheme(Object st) {
    throw new UnsupportedOperationException("ButtonBar_readBack_buttonTextTheme read-back requires FFM/java22");
  }
  default double ButtonBar_readBack_buttonMinWidth(Object st) {
    throw new UnsupportedOperationException("ButtonBar_readBack_buttonMinWidth read-back requires FFM/java22");
  }
  default double ButtonBar_readBack_buttonHeight(Object st) {
    throw new UnsupportedOperationException("ButtonBar_readBack_buttonHeight read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry ButtonBar_readBack_buttonPadding(Object st) {
    throw new UnsupportedOperationException("ButtonBar_readBack_buttonPadding read-back requires FFM/java22");
  }
  default boolean ButtonBar_readBack_buttonAlignedDropdown(Object st) {
    throw new UnsupportedOperationException("ButtonBar_readBack_buttonAlignedDropdown read-back requires FFM/java22");
  }
  default ButtonBarLayoutBehavior ButtonBar_readBack_layoutBehavior(Object st) {
    throw new UnsupportedOperationException("ButtonBar_readBack_layoutBehavior read-back requires FFM/java22");
  }
  default VerticalDirection ButtonBar_readBack_overflowDirection(Object st) {
    throw new UnsupportedOperationException("ButtonBar_readBack_overflowDirection read-back requires FFM/java22");
  }
  default double ButtonBar_readBack_overflowButtonSpacing(Object st) {
    throw new UnsupportedOperationException("ButtonBar_readBack_overflowButtonSpacing read-back requires FFM/java22");
  }

  default int bottomSheetBottomSheet(Optional<AnimationController> animationController, Optional<Boolean> enableDrag, Optional<Boolean> showDragHandle, Optional<Color> dragHandleColor, Optional<Consumer<DragStartDetails>> onDragStart, Optional<BiConsumer<DragEndDetails, Boolean>> onDragEnd, Optional<Color> backgroundColor, Optional<Color> shadowColor, OptionalDouble elevation, Optional<ShapeBorder> shape, Optional<Clip> clipBehavior, Optional<BoxConstraints> constraints, Runnable onClosing, Function<BuildContext, Widget> builder) {
    throw new UnsupportedOperationException("bottomSheetBottomSheet has no default (FFM/comm impl required)");
  }
  default int bottomSheetCreateAnimationController(TickerProvider vsync) {
    throw new UnsupportedOperationException("bottomSheetCreateAnimationController has no default (FFM/comm impl required)");
  }
  default AnimationController BottomSheet_readBack_animationController(Object st) {
    throw new UnsupportedOperationException("BottomSheet_readBack_animationController read-back requires FFM/java22");
  }
  default boolean BottomSheet_readBack_enableDrag(Object st) {
    throw new UnsupportedOperationException("BottomSheet_readBack_enableDrag read-back requires FFM/java22");
  }
  default boolean BottomSheet_readBack_showDragHandle(Object st) {
    throw new UnsupportedOperationException("BottomSheet_readBack_showDragHandle read-back requires FFM/java22");
  }
  default Color BottomSheet_readBack_dragHandleColor(Object st) {
    throw new UnsupportedOperationException("BottomSheet_readBack_dragHandleColor read-back requires FFM/java22");
  }
  default Color BottomSheet_readBack_backgroundColor(Object st) {
    throw new UnsupportedOperationException("BottomSheet_readBack_backgroundColor read-back requires FFM/java22");
  }
  default Color BottomSheet_readBack_shadowColor(Object st) {
    throw new UnsupportedOperationException("BottomSheet_readBack_shadowColor read-back requires FFM/java22");
  }
  default double BottomSheet_readBack_elevation(Object st) {
    throw new UnsupportedOperationException("BottomSheet_readBack_elevation read-back requires FFM/java22");
  }
  default ShapeBorder BottomSheet_readBack_shape(Object st) {
    throw new UnsupportedOperationException("BottomSheet_readBack_shape read-back requires FFM/java22");
  }
  default Clip BottomSheet_readBack_clipBehavior(Object st) {
    throw new UnsupportedOperationException("BottomSheet_readBack_clipBehavior read-back requires FFM/java22");
  }
  default BoxConstraints BottomSheet_readBack_constraints(Object st) {
    throw new UnsupportedOperationException("BottomSheet_readBack_constraints read-back requires FFM/java22");
  }

  default int rangeValuesRangeValues(double start, double end) {
    throw new UnsupportedOperationException("rangeValuesRangeValues has no default (FFM/comm impl required)");
  }
  default double RangeValues_readBack_start(Object st) {
    throw new UnsupportedOperationException("RangeValues_readBack_start read-back requires FFM/java22");
  }
  default double RangeValues_readBack_end(Object st) {
    throw new UnsupportedOperationException("RangeValues_readBack_end read-back requires FFM/java22");
  }

  default int dropdownMenuThemeDropdownMenuTheme(DropdownMenuThemeData data, Widget child) {
    throw new UnsupportedOperationException("dropdownMenuThemeDropdownMenuTheme has no default (FFM/comm impl required)");
  }
  default int dropdownMenuThemeOf(BuildContext context) {
    throw new UnsupportedOperationException("dropdownMenuThemeOf has no default (FFM/comm impl required)");
  }
  default int dropdownMenuThemeMaybeOf(BuildContext context) {
    throw new UnsupportedOperationException("dropdownMenuThemeMaybeOf has no default (FFM/comm impl required)");
  }
  default DropdownMenuThemeData DropdownMenuTheme_readBack_data(Object st) {
    throw new UnsupportedOperationException("DropdownMenuTheme_readBack_data read-back requires FFM/java22");
  }

  default int drawerControllerDrawerController(Widget child, DrawerAlignment alignment, Optional<Boolean> isDrawerOpen, Optional<Consumer<Boolean>> drawerCallback, Optional<DragStartBehavior> dragStartBehavior, Optional<Color> scrimColor, OptionalDouble edgeDragWidth, Optional<Boolean> enableOpenDragGesture, Optional<Boolean> drawerBarrierDismissible) {
    throw new UnsupportedOperationException("drawerControllerDrawerController has no default (FFM/comm impl required)");
  }
  default int drawerControllerMaybeOf(BuildContext context) {
    throw new UnsupportedOperationException("drawerControllerMaybeOf has no default (FFM/comm impl required)");
  }
  default int drawerControllerOf(BuildContext context) {
    throw new UnsupportedOperationException("drawerControllerOf has no default (FFM/comm impl required)");
  }
  default Widget DrawerController_readBack_child(Object st) {
    throw new UnsupportedOperationException("DrawerController_readBack_child read-back requires FFM/java22");
  }
  default DrawerAlignment DrawerController_readBack_alignment(Object st) {
    throw new UnsupportedOperationException("DrawerController_readBack_alignment read-back requires FFM/java22");
  }
  default boolean DrawerController_readBack_drawerBarrierDismissible(Object st) {
    throw new UnsupportedOperationException("DrawerController_readBack_drawerBarrierDismissible read-back requires FFM/java22");
  }
  default DragStartBehavior DrawerController_readBack_dragStartBehavior(Object st) {
    throw new UnsupportedOperationException("DrawerController_readBack_dragStartBehavior read-back requires FFM/java22");
  }
  default Color DrawerController_readBack_scrimColor(Object st) {
    throw new UnsupportedOperationException("DrawerController_readBack_scrimColor read-back requires FFM/java22");
  }
  default boolean DrawerController_readBack_enableOpenDragGesture(Object st) {
    throw new UnsupportedOperationException("DrawerController_readBack_enableOpenDragGesture read-back requires FFM/java22");
  }
  default double DrawerController_readBack_edgeDragWidth(Object st) {
    throw new UnsupportedOperationException("DrawerController_readBack_edgeDragWidth read-back requires FFM/java22");
  }
  default boolean DrawerController_readBack_isDrawerOpen(Object st) {
    throw new UnsupportedOperationException("DrawerController_readBack_isDrawerOpen read-back requires FFM/java22");
  }

  default int appBarThemeAppBarTheme(Optional<Color> color, Optional<Color> backgroundColor, Optional<Color> foregroundColor, OptionalDouble elevation, OptionalDouble scrolledUnderElevation, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, Optional<ShapeBorder> shape, Optional<IconThemeData> iconTheme, Optional<IconThemeData> actionsIconTheme, Optional<Boolean> centerTitle, OptionalDouble titleSpacing, OptionalDouble leadingWidth, OptionalDouble toolbarHeight, Optional<TextStyle> toolbarTextStyle, Optional<TextStyle> titleTextStyle, Optional<EdgeInsetsGeometry> actionsPadding, Optional<AppBarThemeData> data, Optional<Widget> child) {
    throw new UnsupportedOperationException("appBarThemeAppBarTheme has no default (FFM/comm impl required)");
  }
  default int appBarThemeOf(BuildContext context) {
    throw new UnsupportedOperationException("appBarThemeOf has no default (FFM/comm impl required)");
  }
  default int appBarThemeLerp(AppBarTheme a, AppBarTheme b, double t) {
    throw new UnsupportedOperationException("appBarThemeLerp has no default (FFM/comm impl required)");
  }
  default Color AppBarTheme_readBack_backgroundColor(Object st) {
    throw new UnsupportedOperationException("AppBarTheme_readBack_backgroundColor read-back requires FFM/java22");
  }
  default Color AppBarTheme_readBack_foregroundColor(Object st) {
    throw new UnsupportedOperationException("AppBarTheme_readBack_foregroundColor read-back requires FFM/java22");
  }
  default double AppBarTheme_readBack_elevation(Object st) {
    throw new UnsupportedOperationException("AppBarTheme_readBack_elevation read-back requires FFM/java22");
  }
  default double AppBarTheme_readBack_scrolledUnderElevation(Object st) {
    throw new UnsupportedOperationException("AppBarTheme_readBack_scrolledUnderElevation read-back requires FFM/java22");
  }
  default Color AppBarTheme_readBack_shadowColor(Object st) {
    throw new UnsupportedOperationException("AppBarTheme_readBack_shadowColor read-back requires FFM/java22");
  }
  default Color AppBarTheme_readBack_surfaceTintColor(Object st) {
    throw new UnsupportedOperationException("AppBarTheme_readBack_surfaceTintColor read-back requires FFM/java22");
  }
  default ShapeBorder AppBarTheme_readBack_shape(Object st) {
    throw new UnsupportedOperationException("AppBarTheme_readBack_shape read-back requires FFM/java22");
  }
  default IconThemeData AppBarTheme_readBack_iconTheme(Object st) {
    throw new UnsupportedOperationException("AppBarTheme_readBack_iconTheme read-back requires FFM/java22");
  }
  default IconThemeData AppBarTheme_readBack_actionsIconTheme(Object st) {
    throw new UnsupportedOperationException("AppBarTheme_readBack_actionsIconTheme read-back requires FFM/java22");
  }
  default boolean AppBarTheme_readBack_centerTitle(Object st) {
    throw new UnsupportedOperationException("AppBarTheme_readBack_centerTitle read-back requires FFM/java22");
  }
  default double AppBarTheme_readBack_titleSpacing(Object st) {
    throw new UnsupportedOperationException("AppBarTheme_readBack_titleSpacing read-back requires FFM/java22");
  }
  default double AppBarTheme_readBack_leadingWidth(Object st) {
    throw new UnsupportedOperationException("AppBarTheme_readBack_leadingWidth read-back requires FFM/java22");
  }
  default double AppBarTheme_readBack_toolbarHeight(Object st) {
    throw new UnsupportedOperationException("AppBarTheme_readBack_toolbarHeight read-back requires FFM/java22");
  }
  default TextStyle AppBarTheme_readBack_toolbarTextStyle(Object st) {
    throw new UnsupportedOperationException("AppBarTheme_readBack_toolbarTextStyle read-back requires FFM/java22");
  }
  default TextStyle AppBarTheme_readBack_titleTextStyle(Object st) {
    throw new UnsupportedOperationException("AppBarTheme_readBack_titleTextStyle read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry AppBarTheme_readBack_actionsPadding(Object st) {
    throw new UnsupportedOperationException("AppBarTheme_readBack_actionsPadding read-back requires FFM/java22");
  }
  default AppBarThemeData AppBarTheme_readBack_data(Object st) {
    throw new UnsupportedOperationException("AppBarTheme_readBack_data read-back requires FFM/java22");
  }

  default int cardThemeCardTheme(Optional<Clip> clipBehavior, Optional<Color> color, Optional<Color> surfaceTintColor, Optional<Color> shadowColor, OptionalDouble elevation, Optional<EdgeInsetsGeometry> margin, Optional<ShapeBorder> shape, Optional<CardThemeData> data, Optional<Widget> child) {
    throw new UnsupportedOperationException("cardThemeCardTheme has no default (FFM/comm impl required)");
  }
  default int cardThemeOf(BuildContext context) {
    throw new UnsupportedOperationException("cardThemeOf has no default (FFM/comm impl required)");
  }
  default int cardThemeLerp(CardTheme a, CardTheme b, double t) {
    throw new UnsupportedOperationException("cardThemeLerp has no default (FFM/comm impl required)");
  }
  default Clip CardTheme_readBack_clipBehavior(Object st) {
    throw new UnsupportedOperationException("CardTheme_readBack_clipBehavior read-back requires FFM/java22");
  }
  default Color CardTheme_readBack_color(Object st) {
    throw new UnsupportedOperationException("CardTheme_readBack_color read-back requires FFM/java22");
  }
  default Color CardTheme_readBack_surfaceTintColor(Object st) {
    throw new UnsupportedOperationException("CardTheme_readBack_surfaceTintColor read-back requires FFM/java22");
  }
  default Color CardTheme_readBack_shadowColor(Object st) {
    throw new UnsupportedOperationException("CardTheme_readBack_shadowColor read-back requires FFM/java22");
  }
  default double CardTheme_readBack_elevation(Object st) {
    throw new UnsupportedOperationException("CardTheme_readBack_elevation read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry CardTheme_readBack_margin(Object st) {
    throw new UnsupportedOperationException("CardTheme_readBack_margin read-back requires FFM/java22");
  }
  default ShapeBorder CardTheme_readBack_shape(Object st) {
    throw new UnsupportedOperationException("CardTheme_readBack_shape read-back requires FFM/java22");
  }
  default CardThemeData CardTheme_readBack_data(Object st) {
    throw new UnsupportedOperationException("CardTheme_readBack_data read-back requires FFM/java22");
  }

  default int dialogThemeDialogTheme(Optional<Color> backgroundColor, OptionalDouble elevation, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, Optional<ShapeBorder> shape, Optional<AlignmentGeometry> alignment, Optional<Color> iconColor, Optional<TextStyle> titleTextStyle, Optional<TextStyle> contentTextStyle, Optional<EdgeInsetsGeometry> actionsPadding, Optional<Color> barrierColor, Optional<EdgeInsets> insetPadding, Optional<Clip> clipBehavior, Optional<DialogThemeData> data, Optional<Widget> child) {
    throw new UnsupportedOperationException("dialogThemeDialogTheme has no default (FFM/comm impl required)");
  }
  default int dialogThemeOf(BuildContext context) {
    throw new UnsupportedOperationException("dialogThemeOf has no default (FFM/comm impl required)");
  }
  default int dialogThemeLerp(DialogTheme a, DialogTheme b, double t) {
    throw new UnsupportedOperationException("dialogThemeLerp has no default (FFM/comm impl required)");
  }
  default Color DialogTheme_readBack_backgroundColor(Object st) {
    throw new UnsupportedOperationException("DialogTheme_readBack_backgroundColor read-back requires FFM/java22");
  }
  default double DialogTheme_readBack_elevation(Object st) {
    throw new UnsupportedOperationException("DialogTheme_readBack_elevation read-back requires FFM/java22");
  }
  default Color DialogTheme_readBack_shadowColor(Object st) {
    throw new UnsupportedOperationException("DialogTheme_readBack_shadowColor read-back requires FFM/java22");
  }
  default Color DialogTheme_readBack_surfaceTintColor(Object st) {
    throw new UnsupportedOperationException("DialogTheme_readBack_surfaceTintColor read-back requires FFM/java22");
  }
  default ShapeBorder DialogTheme_readBack_shape(Object st) {
    throw new UnsupportedOperationException("DialogTheme_readBack_shape read-back requires FFM/java22");
  }
  default AlignmentGeometry DialogTheme_readBack_alignment(Object st) {
    throw new UnsupportedOperationException("DialogTheme_readBack_alignment read-back requires FFM/java22");
  }
  default TextStyle DialogTheme_readBack_titleTextStyle(Object st) {
    throw new UnsupportedOperationException("DialogTheme_readBack_titleTextStyle read-back requires FFM/java22");
  }
  default TextStyle DialogTheme_readBack_contentTextStyle(Object st) {
    throw new UnsupportedOperationException("DialogTheme_readBack_contentTextStyle read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry DialogTheme_readBack_actionsPadding(Object st) {
    throw new UnsupportedOperationException("DialogTheme_readBack_actionsPadding read-back requires FFM/java22");
  }
  default Color DialogTheme_readBack_iconColor(Object st) {
    throw new UnsupportedOperationException("DialogTheme_readBack_iconColor read-back requires FFM/java22");
  }
  default Color DialogTheme_readBack_barrierColor(Object st) {
    throw new UnsupportedOperationException("DialogTheme_readBack_barrierColor read-back requires FFM/java22");
  }
  default EdgeInsets DialogTheme_readBack_insetPadding(Object st) {
    throw new UnsupportedOperationException("DialogTheme_readBack_insetPadding read-back requires FFM/java22");
  }
  default Clip DialogTheme_readBack_clipBehavior(Object st) {
    throw new UnsupportedOperationException("DialogTheme_readBack_clipBehavior read-back requires FFM/java22");
  }
  default DialogThemeData DialogTheme_readBack_data(Object st) {
    throw new UnsupportedOperationException("DialogTheme_readBack_data read-back requires FFM/java22");
  }

  default int dividerThemeDividerTheme(DividerThemeData data, Widget child) {
    throw new UnsupportedOperationException("dividerThemeDividerTheme has no default (FFM/comm impl required)");
  }
  default int dividerThemeOf(BuildContext context) {
    throw new UnsupportedOperationException("dividerThemeOf has no default (FFM/comm impl required)");
  }
  default DividerThemeData DividerTheme_readBack_data(Object st) {
    throw new UnsupportedOperationException("DividerTheme_readBack_data read-back requires FFM/java22");
  }

  default int chipThemeChipTheme(ChipThemeData data, Widget child) {
    throw new UnsupportedOperationException("chipThemeChipTheme has no default (FFM/comm impl required)");
  }
  default int chipThemeOf(BuildContext context) {
    throw new UnsupportedOperationException("chipThemeOf has no default (FFM/comm impl required)");
  }
  default ChipThemeData ChipTheme_readBack_data(Object st) {
    throw new UnsupportedOperationException("ChipTheme_readBack_data read-back requires FFM/java22");
  }

  default int checkboxThemeCheckboxTheme(CheckboxThemeData data, Widget child) {
    throw new UnsupportedOperationException("checkboxThemeCheckboxTheme has no default (FFM/comm impl required)");
  }
  default int checkboxThemeOf(BuildContext context) {
    throw new UnsupportedOperationException("checkboxThemeOf has no default (FFM/comm impl required)");
  }
  default CheckboxThemeData CheckboxTheme_readBack_data(Object st) {
    throw new UnsupportedOperationException("CheckboxTheme_readBack_data read-back requires FFM/java22");
  }

  default int radioThemeRadioTheme(RadioThemeData data, Widget child) {
    throw new UnsupportedOperationException("radioThemeRadioTheme has no default (FFM/comm impl required)");
  }
  default int radioThemeOf(BuildContext context) {
    throw new UnsupportedOperationException("radioThemeOf has no default (FFM/comm impl required)");
  }
  default RadioThemeData RadioTheme_readBack_data(Object st) {
    throw new UnsupportedOperationException("RadioTheme_readBack_data read-back requires FFM/java22");
  }

  default int switchThemeSwitchTheme(SwitchThemeData data, Widget child) {
    throw new UnsupportedOperationException("switchThemeSwitchTheme has no default (FFM/comm impl required)");
  }
  default int switchThemeOf(BuildContext context) {
    throw new UnsupportedOperationException("switchThemeOf has no default (FFM/comm impl required)");
  }
  default SwitchThemeData SwitchTheme_readBack_data(Object st) {
    throw new UnsupportedOperationException("SwitchTheme_readBack_data read-back requires FFM/java22");
  }

  default int sliderThemeSliderTheme(SliderThemeData data, Widget child) {
    throw new UnsupportedOperationException("sliderThemeSliderTheme has no default (FFM/comm impl required)");
  }
  default int sliderThemeOf(BuildContext context) {
    throw new UnsupportedOperationException("sliderThemeOf has no default (FFM/comm impl required)");
  }
  default SliderThemeData SliderTheme_readBack_data(Object st) {
    throw new UnsupportedOperationException("SliderTheme_readBack_data read-back requires FFM/java22");
  }

  default int tabBarThemeTabBarTheme(Optional<Decoration> indicator, Optional<Color> indicatorColor, Optional<TabBarIndicatorSize> indicatorSize, Optional<Color> dividerColor, OptionalDouble dividerHeight, Optional<Color> labelColor, Optional<EdgeInsetsGeometry> labelPadding, Optional<TextStyle> labelStyle, Optional<Color> unselectedLabelColor, Optional<TextStyle> unselectedLabelStyle, Optional<Color> overlayColor, Optional<TabAlignment> tabAlignment, Optional<TabIndicatorAnimation> indicatorAnimation, Optional<TabBarThemeData> data, Optional<Widget> child) {
    throw new UnsupportedOperationException("tabBarThemeTabBarTheme has no default (FFM/comm impl required)");
  }
  default int tabBarThemeOf(BuildContext context) {
    throw new UnsupportedOperationException("tabBarThemeOf has no default (FFM/comm impl required)");
  }
  default int tabBarThemeLerp(TabBarTheme a, TabBarTheme b, double t) {
    throw new UnsupportedOperationException("tabBarThemeLerp has no default (FFM/comm impl required)");
  }
  default Decoration TabBarTheme_readBack_indicator(Object st) {
    throw new UnsupportedOperationException("TabBarTheme_readBack_indicator read-back requires FFM/java22");
  }
  default Color TabBarTheme_readBack_indicatorColor(Object st) {
    throw new UnsupportedOperationException("TabBarTheme_readBack_indicatorColor read-back requires FFM/java22");
  }
  default TabBarIndicatorSize TabBarTheme_readBack_indicatorSize(Object st) {
    throw new UnsupportedOperationException("TabBarTheme_readBack_indicatorSize read-back requires FFM/java22");
  }
  default Color TabBarTheme_readBack_dividerColor(Object st) {
    throw new UnsupportedOperationException("TabBarTheme_readBack_dividerColor read-back requires FFM/java22");
  }
  default double TabBarTheme_readBack_dividerHeight(Object st) {
    throw new UnsupportedOperationException("TabBarTheme_readBack_dividerHeight read-back requires FFM/java22");
  }
  default Color TabBarTheme_readBack_labelColor(Object st) {
    throw new UnsupportedOperationException("TabBarTheme_readBack_labelColor read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry TabBarTheme_readBack_labelPadding(Object st) {
    throw new UnsupportedOperationException("TabBarTheme_readBack_labelPadding read-back requires FFM/java22");
  }
  default TextStyle TabBarTheme_readBack_labelStyle(Object st) {
    throw new UnsupportedOperationException("TabBarTheme_readBack_labelStyle read-back requires FFM/java22");
  }
  default Color TabBarTheme_readBack_unselectedLabelColor(Object st) {
    throw new UnsupportedOperationException("TabBarTheme_readBack_unselectedLabelColor read-back requires FFM/java22");
  }
  default TextStyle TabBarTheme_readBack_unselectedLabelStyle(Object st) {
    throw new UnsupportedOperationException("TabBarTheme_readBack_unselectedLabelStyle read-back requires FFM/java22");
  }
  default TabAlignment TabBarTheme_readBack_tabAlignment(Object st) {
    throw new UnsupportedOperationException("TabBarTheme_readBack_tabAlignment read-back requires FFM/java22");
  }
  default TabIndicatorAnimation TabBarTheme_readBack_indicatorAnimation(Object st) {
    throw new UnsupportedOperationException("TabBarTheme_readBack_indicatorAnimation read-back requires FFM/java22");
  }
  default TabBarThemeData TabBarTheme_readBack_data(Object st) {
    throw new UnsupportedOperationException("TabBarTheme_readBack_data read-back requires FFM/java22");
  }

  default int tooltipThemeTooltipTheme(TooltipThemeData data, Widget child) {
    throw new UnsupportedOperationException("tooltipThemeTooltipTheme has no default (FFM/comm impl required)");
  }
  default int tooltipThemeOf(BuildContext context) {
    throw new UnsupportedOperationException("tooltipThemeOf has no default (FFM/comm impl required)");
  }
  default TooltipThemeData TooltipTheme_readBack_data(Object st) {
    throw new UnsupportedOperationException("TooltipTheme_readBack_data read-back requires FFM/java22");
  }

  default int snackBarThemeSnackBarTheme(SnackBarThemeData data, Widget child) {
    throw new UnsupportedOperationException("snackBarThemeSnackBarTheme has no default (FFM/comm impl required)");
  }
  default int snackBarThemeOf(BuildContext context) {
    throw new UnsupportedOperationException("snackBarThemeOf has no default (FFM/comm impl required)");
  }
  default SnackBarThemeData SnackBarTheme_readBack_data(Object st) {
    throw new UnsupportedOperationException("SnackBarTheme_readBack_data read-back requires FFM/java22");
  }

  default int badgeThemeBadgeTheme(BadgeThemeData data, Widget child) {
    throw new UnsupportedOperationException("badgeThemeBadgeTheme has no default (FFM/comm impl required)");
  }
  default int badgeThemeOf(BuildContext context) {
    throw new UnsupportedOperationException("badgeThemeOf has no default (FFM/comm impl required)");
  }
  default BadgeThemeData BadgeTheme_readBack_data(Object st) {
    throw new UnsupportedOperationException("BadgeTheme_readBack_data read-back requires FFM/java22");
  }

  default int progressIndicatorThemeProgressIndicatorTheme(ProgressIndicatorThemeData data, Widget child) {
    throw new UnsupportedOperationException("progressIndicatorThemeProgressIndicatorTheme has no default (FFM/comm impl required)");
  }
  default int progressIndicatorThemeOf(BuildContext context) {
    throw new UnsupportedOperationException("progressIndicatorThemeOf has no default (FFM/comm impl required)");
  }
  default ProgressIndicatorThemeData ProgressIndicatorTheme_readBack_data(Object st) {
    throw new UnsupportedOperationException("ProgressIndicatorTheme_readBack_data read-back requires FFM/java22");
  }

  default int popupMenuThemePopupMenuTheme(PopupMenuThemeData data, Widget child) {
    throw new UnsupportedOperationException("popupMenuThemePopupMenuTheme has no default (FFM/comm impl required)");
  }
  default int popupMenuThemeOf(BuildContext context) {
    throw new UnsupportedOperationException("popupMenuThemeOf has no default (FFM/comm impl required)");
  }
  default PopupMenuThemeData PopupMenuTheme_readBack_data(Object st) {
    throw new UnsupportedOperationException("PopupMenuTheme_readBack_data read-back requires FFM/java22");
  }

  default int bottomNavigationBarThemeBottomNavigationBarTheme(BottomNavigationBarThemeData data, Widget child) {
    throw new UnsupportedOperationException("bottomNavigationBarThemeBottomNavigationBarTheme has no default (FFM/comm impl required)");
  }
  default int bottomNavigationBarThemeOf(BuildContext context) {
    throw new UnsupportedOperationException("bottomNavigationBarThemeOf has no default (FFM/comm impl required)");
  }
  default BottomNavigationBarThemeData BottomNavigationBarTheme_readBack_data(Object st) {
    throw new UnsupportedOperationException("BottomNavigationBarTheme_readBack_data read-back requires FFM/java22");
  }

  default int drawerThemeDrawerTheme(DrawerThemeData data, Widget child) {
    throw new UnsupportedOperationException("drawerThemeDrawerTheme has no default (FFM/comm impl required)");
  }
  default int drawerThemeOf(BuildContext context) {
    throw new UnsupportedOperationException("drawerThemeOf has no default (FFM/comm impl required)");
  }
  default DrawerThemeData DrawerTheme_readBack_data(Object st) {
    throw new UnsupportedOperationException("DrawerTheme_readBack_data read-back requires FFM/java22");
  }

  default int navigationBarThemeNavigationBarTheme(NavigationBarThemeData data, Widget child) {
    throw new UnsupportedOperationException("navigationBarThemeNavigationBarTheme has no default (FFM/comm impl required)");
  }
  default int navigationBarThemeOf(BuildContext context) {
    throw new UnsupportedOperationException("navigationBarThemeOf has no default (FFM/comm impl required)");
  }
  default NavigationBarThemeData NavigationBarTheme_readBack_data(Object st) {
    throw new UnsupportedOperationException("NavigationBarTheme_readBack_data read-back requires FFM/java22");
  }

  default int navigationDrawerThemeNavigationDrawerTheme(NavigationDrawerThemeData data, Widget child) {
    throw new UnsupportedOperationException("navigationDrawerThemeNavigationDrawerTheme has no default (FFM/comm impl required)");
  }
  default int navigationDrawerThemeOf(BuildContext context) {
    throw new UnsupportedOperationException("navigationDrawerThemeOf has no default (FFM/comm impl required)");
  }
  default NavigationDrawerThemeData NavigationDrawerTheme_readBack_data(Object st) {
    throw new UnsupportedOperationException("NavigationDrawerTheme_readBack_data read-back requires FFM/java22");
  }

  default int navigationRailThemeNavigationRailTheme(NavigationRailThemeData data, Widget child) {
    throw new UnsupportedOperationException("navigationRailThemeNavigationRailTheme has no default (FFM/comm impl required)");
  }
  default int navigationRailThemeOf(BuildContext context) {
    throw new UnsupportedOperationException("navigationRailThemeOf has no default (FFM/comm impl required)");
  }
  default NavigationRailThemeData NavigationRailTheme_readBack_data(Object st) {
    throw new UnsupportedOperationException("NavigationRailTheme_readBack_data read-back requires FFM/java22");
  }

  default int menuThemeMenuTheme(MenuThemeData data, Widget child) {
    throw new UnsupportedOperationException("menuThemeMenuTheme has no default (FFM/comm impl required)");
  }
  default int menuThemeOf(BuildContext context) {
    throw new UnsupportedOperationException("menuThemeOf has no default (FFM/comm impl required)");
  }
  default MenuThemeData MenuTheme_readBack_data(Object st) {
    throw new UnsupportedOperationException("MenuTheme_readBack_data read-back requires FFM/java22");
  }

  default int menuBarThemeMenuBarTheme(MenuBarThemeData data, Widget child) {
    throw new UnsupportedOperationException("menuBarThemeMenuBarTheme has no default (FFM/comm impl required)");
  }
  default int menuBarThemeOf(BuildContext context) {
    throw new UnsupportedOperationException("menuBarThemeOf has no default (FFM/comm impl required)");
  }
  default MenuBarThemeData MenuBarTheme_readBack_data(Object st) {
    throw new UnsupportedOperationException("MenuBarTheme_readBack_data read-back requires FFM/java22");
  }

  default int menuButtonThemeMenuButtonTheme(MenuButtonThemeData data, Widget child) {
    throw new UnsupportedOperationException("menuButtonThemeMenuButtonTheme has no default (FFM/comm impl required)");
  }
  default int menuButtonThemeOf(BuildContext context) {
    throw new UnsupportedOperationException("menuButtonThemeOf has no default (FFM/comm impl required)");
  }
  default MenuButtonThemeData MenuButtonTheme_readBack_data(Object st) {
    throw new UnsupportedOperationException("MenuButtonTheme_readBack_data read-back requires FFM/java22");
  }

  default int searchBarThemeSearchBarTheme(SearchBarThemeData data, Widget child) {
    throw new UnsupportedOperationException("searchBarThemeSearchBarTheme has no default (FFM/comm impl required)");
  }
  default int searchBarThemeOf(BuildContext context) {
    throw new UnsupportedOperationException("searchBarThemeOf has no default (FFM/comm impl required)");
  }
  default SearchBarThemeData SearchBarTheme_readBack_data(Object st) {
    throw new UnsupportedOperationException("SearchBarTheme_readBack_data read-back requires FFM/java22");
  }

  default int searchViewThemeSearchViewTheme(SearchViewThemeData data, Widget child) {
    throw new UnsupportedOperationException("searchViewThemeSearchViewTheme has no default (FFM/comm impl required)");
  }
  default int searchViewThemeOf(BuildContext context) {
    throw new UnsupportedOperationException("searchViewThemeOf has no default (FFM/comm impl required)");
  }
  default SearchViewThemeData SearchViewTheme_readBack_data(Object st) {
    throw new UnsupportedOperationException("SearchViewTheme_readBack_data read-back requires FFM/java22");
  }

  default int expansionTileThemeExpansionTileTheme(ExpansionTileThemeData data, Widget child) {
    throw new UnsupportedOperationException("expansionTileThemeExpansionTileTheme has no default (FFM/comm impl required)");
  }
  default int expansionTileThemeOf(BuildContext context) {
    throw new UnsupportedOperationException("expansionTileThemeOf has no default (FFM/comm impl required)");
  }
  default ExpansionTileThemeData ExpansionTileTheme_readBack_data(Object st) {
    throw new UnsupportedOperationException("ExpansionTileTheme_readBack_data read-back requires FFM/java22");
  }

  default int textSelectionThemeTextSelectionTheme(TextSelectionThemeData data, Widget child) {
    throw new UnsupportedOperationException("textSelectionThemeTextSelectionTheme has no default (FFM/comm impl required)");
  }
  default int textSelectionThemeOf(BuildContext context) {
    throw new UnsupportedOperationException("textSelectionThemeOf has no default (FFM/comm impl required)");
  }
  default TextSelectionThemeData TextSelectionTheme_readBack_data(Object st) {
    throw new UnsupportedOperationException("TextSelectionTheme_readBack_data read-back requires FFM/java22");
  }

  default int datePickerThemeDatePickerTheme(DatePickerThemeData data, Widget child) {
    throw new UnsupportedOperationException("datePickerThemeDatePickerTheme has no default (FFM/comm impl required)");
  }
  default int datePickerThemeOf(BuildContext context) {
    throw new UnsupportedOperationException("datePickerThemeOf has no default (FFM/comm impl required)");
  }
  default int datePickerThemeMaybeOf(BuildContext context) {
    throw new UnsupportedOperationException("datePickerThemeMaybeOf has no default (FFM/comm impl required)");
  }
  default int datePickerThemeDefaults(BuildContext context) {
    throw new UnsupportedOperationException("datePickerThemeDefaults has no default (FFM/comm impl required)");
  }
  default DatePickerThemeData DatePickerTheme_readBack_data(Object st) {
    throw new UnsupportedOperationException("DatePickerTheme_readBack_data read-back requires FFM/java22");
  }

  default int timePickerThemeTimePickerTheme(TimePickerThemeData data, Widget child) {
    throw new UnsupportedOperationException("timePickerThemeTimePickerTheme has no default (FFM/comm impl required)");
  }
  default int timePickerThemeOf(BuildContext context) {
    throw new UnsupportedOperationException("timePickerThemeOf has no default (FFM/comm impl required)");
  }
  default TimePickerThemeData TimePickerTheme_readBack_data(Object st) {
    throw new UnsupportedOperationException("TimePickerTheme_readBack_data read-back requires FFM/java22");
  }

  default int elevatedButtonThemeElevatedButtonTheme(ElevatedButtonThemeData data, Widget child) {
    throw new UnsupportedOperationException("elevatedButtonThemeElevatedButtonTheme has no default (FFM/comm impl required)");
  }
  default int elevatedButtonThemeOf(BuildContext context) {
    throw new UnsupportedOperationException("elevatedButtonThemeOf has no default (FFM/comm impl required)");
  }
  default ElevatedButtonThemeData ElevatedButtonTheme_readBack_data(Object st) {
    throw new UnsupportedOperationException("ElevatedButtonTheme_readBack_data read-back requires FFM/java22");
  }

  default int textButtonThemeTextButtonTheme(TextButtonThemeData data, Widget child) {
    throw new UnsupportedOperationException("textButtonThemeTextButtonTheme has no default (FFM/comm impl required)");
  }
  default int textButtonThemeOf(BuildContext context) {
    throw new UnsupportedOperationException("textButtonThemeOf has no default (FFM/comm impl required)");
  }
  default TextButtonThemeData TextButtonTheme_readBack_data(Object st) {
    throw new UnsupportedOperationException("TextButtonTheme_readBack_data read-back requires FFM/java22");
  }

  default int outlinedButtonThemeOutlinedButtonTheme(OutlinedButtonThemeData data, Widget child) {
    throw new UnsupportedOperationException("outlinedButtonThemeOutlinedButtonTheme has no default (FFM/comm impl required)");
  }
  default int outlinedButtonThemeOf(BuildContext context) {
    throw new UnsupportedOperationException("outlinedButtonThemeOf has no default (FFM/comm impl required)");
  }
  default OutlinedButtonThemeData OutlinedButtonTheme_readBack_data(Object st) {
    throw new UnsupportedOperationException("OutlinedButtonTheme_readBack_data read-back requires FFM/java22");
  }

  default int filledButtonThemeFilledButtonTheme(FilledButtonThemeData data, Widget child) {
    throw new UnsupportedOperationException("filledButtonThemeFilledButtonTheme has no default (FFM/comm impl required)");
  }
  default int filledButtonThemeOf(BuildContext context) {
    throw new UnsupportedOperationException("filledButtonThemeOf has no default (FFM/comm impl required)");
  }
  default FilledButtonThemeData FilledButtonTheme_readBack_data(Object st) {
    throw new UnsupportedOperationException("FilledButtonTheme_readBack_data read-back requires FFM/java22");
  }

  default int iconButtonThemeIconButtonTheme(IconButtonThemeData data, Widget child) {
    throw new UnsupportedOperationException("iconButtonThemeIconButtonTheme has no default (FFM/comm impl required)");
  }
  default int iconButtonThemeOf(BuildContext context) {
    throw new UnsupportedOperationException("iconButtonThemeOf has no default (FFM/comm impl required)");
  }
  default IconButtonThemeData IconButtonTheme_readBack_data(Object st) {
    throw new UnsupportedOperationException("IconButtonTheme_readBack_data read-back requires FFM/java22");
  }

  default int floatingActionButtonThemeFloatingActionButtonTheme(FloatingActionButtonThemeData data, Widget child) {
    throw new UnsupportedOperationException("floatingActionButtonThemeFloatingActionButtonTheme has no default (FFM/comm impl required)");
  }
  default int floatingActionButtonThemeOf(BuildContext context) {
    throw new UnsupportedOperationException("floatingActionButtonThemeOf has no default (FFM/comm impl required)");
  }
  default FloatingActionButtonThemeData FloatingActionButtonTheme_readBack_data(Object st) {
    throw new UnsupportedOperationException("FloatingActionButtonTheme_readBack_data read-back requires FFM/java22");
  }

  default int segmentedButtonThemeSegmentedButtonTheme(SegmentedButtonThemeData data, Widget child) {
    throw new UnsupportedOperationException("segmentedButtonThemeSegmentedButtonTheme has no default (FFM/comm impl required)");
  }
  default int segmentedButtonThemeOf(BuildContext context) {
    throw new UnsupportedOperationException("segmentedButtonThemeOf has no default (FFM/comm impl required)");
  }
  default int segmentedButtonThemeMaybeOf(BuildContext context) {
    throw new UnsupportedOperationException("segmentedButtonThemeMaybeOf has no default (FFM/comm impl required)");
  }
  default SegmentedButtonThemeData SegmentedButtonTheme_readBack_data(Object st) {
    throw new UnsupportedOperationException("SegmentedButtonTheme_readBack_data read-back requires FFM/java22");
  }

  default int dataTableThemeDataTableTheme(DataTableThemeData data, Widget child) {
    throw new UnsupportedOperationException("dataTableThemeDataTableTheme has no default (FFM/comm impl required)");
  }
  default int dataTableThemeOf(BuildContext context) {
    throw new UnsupportedOperationException("dataTableThemeOf has no default (FFM/comm impl required)");
  }
  default DataTableThemeData DataTableTheme_readBack_data(Object st) {
    throw new UnsupportedOperationException("DataTableTheme_readBack_data read-back requires FFM/java22");
  }

  default int toggleButtonsThemeToggleButtonsTheme(ToggleButtonsThemeData data, Widget child) {
    throw new UnsupportedOperationException("toggleButtonsThemeToggleButtonsTheme has no default (FFM/comm impl required)");
  }
  default int toggleButtonsThemeOf(BuildContext context) {
    throw new UnsupportedOperationException("toggleButtonsThemeOf has no default (FFM/comm impl required)");
  }
  default ToggleButtonsThemeData ToggleButtonsTheme_readBack_data(Object st) {
    throw new UnsupportedOperationException("ToggleButtonsTheme_readBack_data read-back requires FFM/java22");
  }

  default int actionIconThemeActionIconTheme(ActionIconThemeData data, Widget child) {
    throw new UnsupportedOperationException("actionIconThemeActionIconTheme has no default (FFM/comm impl required)");
  }
  default int actionIconThemeOf(BuildContext context) {
    throw new UnsupportedOperationException("actionIconThemeOf has no default (FFM/comm impl required)");
  }
  default ActionIconThemeData ActionIconTheme_readBack_data(Object st) {
    throw new UnsupportedOperationException("ActionIconTheme_readBack_data read-back requires FFM/java22");
  }

  default int carouselViewThemeCarouselViewTheme(CarouselViewThemeData data, Widget child) {
    throw new UnsupportedOperationException("carouselViewThemeCarouselViewTheme has no default (FFM/comm impl required)");
  }
  default int carouselViewThemeOf(BuildContext context) {
    throw new UnsupportedOperationException("carouselViewThemeOf has no default (FFM/comm impl required)");
  }
  default CarouselViewThemeData CarouselViewTheme_readBack_data(Object st) {
    throw new UnsupportedOperationException("CarouselViewTheme_readBack_data read-back requires FFM/java22");
  }

  default int bottomAppBarThemeBottomAppBarTheme(Optional<Color> color, OptionalDouble elevation, OptionalDouble height, Optional<Color> surfaceTintColor, Optional<Color> shadowColor, Optional<EdgeInsetsGeometry> padding, Optional<BottomAppBarThemeData> data, Optional<Widget> child) {
    throw new UnsupportedOperationException("bottomAppBarThemeBottomAppBarTheme has no default (FFM/comm impl required)");
  }
  default int bottomAppBarThemeOf(BuildContext context) {
    throw new UnsupportedOperationException("bottomAppBarThemeOf has no default (FFM/comm impl required)");
  }
  default int bottomAppBarThemeLerp(BottomAppBarTheme a, BottomAppBarTheme b, double t) {
    throw new UnsupportedOperationException("bottomAppBarThemeLerp has no default (FFM/comm impl required)");
  }
  default Color BottomAppBarTheme_readBack_color(Object st) {
    throw new UnsupportedOperationException("BottomAppBarTheme_readBack_color read-back requires FFM/java22");
  }
  default double BottomAppBarTheme_readBack_elevation(Object st) {
    throw new UnsupportedOperationException("BottomAppBarTheme_readBack_elevation read-back requires FFM/java22");
  }
  default double BottomAppBarTheme_readBack_height(Object st) {
    throw new UnsupportedOperationException("BottomAppBarTheme_readBack_height read-back requires FFM/java22");
  }
  default Color BottomAppBarTheme_readBack_surfaceTintColor(Object st) {
    throw new UnsupportedOperationException("BottomAppBarTheme_readBack_surfaceTintColor read-back requires FFM/java22");
  }
  default Color BottomAppBarTheme_readBack_shadowColor(Object st) {
    throw new UnsupportedOperationException("BottomAppBarTheme_readBack_shadowColor read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry BottomAppBarTheme_readBack_padding(Object st) {
    throw new UnsupportedOperationException("BottomAppBarTheme_readBack_padding read-back requires FFM/java22");
  }
  default BottomAppBarThemeData BottomAppBarTheme_readBack_data(Object st) {
    throw new UnsupportedOperationException("BottomAppBarTheme_readBack_data read-back requires FFM/java22");
  }

  default int buttonThemeButtonTheme(Optional<ButtonTextTheme> textTheme, Optional<ButtonBarLayoutBehavior> layoutBehavior, OptionalDouble minWidth, OptionalDouble height, Optional<EdgeInsetsGeometry> padding, Optional<ShapeBorder> shape, Optional<Boolean> alignedDropdown, Optional<Color> buttonColor, Optional<Color> disabledColor, Optional<Color> focusColor, Optional<Color> hoverColor, Optional<Color> highlightColor, Optional<Color> splashColor, Optional<ColorScheme> colorScheme, Optional<MaterialTapTargetSize> materialTapTargetSize, Widget child) {
    throw new UnsupportedOperationException("buttonThemeButtonTheme has no default (FFM/comm impl required)");
  }
  default int buttonThemeFromButtonThemeData(ButtonThemeData data, Widget child) {
    throw new UnsupportedOperationException("buttonThemeFromButtonThemeData has no default (FFM/comm impl required)");
  }
  default int buttonThemeOf(BuildContext context) {
    throw new UnsupportedOperationException("buttonThemeOf has no default (FFM/comm impl required)");
  }
  default ButtonThemeData ButtonTheme_readBack_data(Object st) {
    throw new UnsupportedOperationException("ButtonTheme_readBack_data read-back requires FFM/java22");
  }

  default int materialButtonMaterialButton(Optional<Runnable> onPressed, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onHighlightChanged, Optional<ButtonTextTheme> textTheme, Optional<Color> textColor, Optional<Color> disabledTextColor, Optional<Color> color, Optional<Color> disabledColor, Optional<Color> focusColor, Optional<Color> hoverColor, Optional<Color> highlightColor, Optional<Color> splashColor, Optional<Brightness> colorBrightness, OptionalDouble elevation, OptionalDouble focusElevation, OptionalDouble hoverElevation, OptionalDouble highlightElevation, OptionalDouble disabledElevation, Optional<EdgeInsetsGeometry> padding, Optional<VisualDensity> visualDensity, Optional<ShapeBorder> shape, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<Duration> animationDuration, OptionalDouble minWidth, OptionalDouble height, Optional<Boolean> enableFeedback, Optional<Widget> child) {
    throw new UnsupportedOperationException("materialButtonMaterialButton has no default (FFM/comm impl required)");
  }
  default ButtonTextTheme MaterialButton_readBack_textTheme(Object st) {
    throw new UnsupportedOperationException("MaterialButton_readBack_textTheme read-back requires FFM/java22");
  }
  default Color MaterialButton_readBack_textColor(Object st) {
    throw new UnsupportedOperationException("MaterialButton_readBack_textColor read-back requires FFM/java22");
  }
  default Color MaterialButton_readBack_disabledTextColor(Object st) {
    throw new UnsupportedOperationException("MaterialButton_readBack_disabledTextColor read-back requires FFM/java22");
  }
  default Color MaterialButton_readBack_color(Object st) {
    throw new UnsupportedOperationException("MaterialButton_readBack_color read-back requires FFM/java22");
  }
  default Color MaterialButton_readBack_disabledColor(Object st) {
    throw new UnsupportedOperationException("MaterialButton_readBack_disabledColor read-back requires FFM/java22");
  }
  default Color MaterialButton_readBack_splashColor(Object st) {
    throw new UnsupportedOperationException("MaterialButton_readBack_splashColor read-back requires FFM/java22");
  }
  default Color MaterialButton_readBack_focusColor(Object st) {
    throw new UnsupportedOperationException("MaterialButton_readBack_focusColor read-back requires FFM/java22");
  }
  default Color MaterialButton_readBack_hoverColor(Object st) {
    throw new UnsupportedOperationException("MaterialButton_readBack_hoverColor read-back requires FFM/java22");
  }
  default Color MaterialButton_readBack_highlightColor(Object st) {
    throw new UnsupportedOperationException("MaterialButton_readBack_highlightColor read-back requires FFM/java22");
  }
  default double MaterialButton_readBack_elevation(Object st) {
    throw new UnsupportedOperationException("MaterialButton_readBack_elevation read-back requires FFM/java22");
  }
  default double MaterialButton_readBack_hoverElevation(Object st) {
    throw new UnsupportedOperationException("MaterialButton_readBack_hoverElevation read-back requires FFM/java22");
  }
  default double MaterialButton_readBack_focusElevation(Object st) {
    throw new UnsupportedOperationException("MaterialButton_readBack_focusElevation read-back requires FFM/java22");
  }
  default double MaterialButton_readBack_highlightElevation(Object st) {
    throw new UnsupportedOperationException("MaterialButton_readBack_highlightElevation read-back requires FFM/java22");
  }
  default double MaterialButton_readBack_disabledElevation(Object st) {
    throw new UnsupportedOperationException("MaterialButton_readBack_disabledElevation read-back requires FFM/java22");
  }
  default Brightness MaterialButton_readBack_colorBrightness(Object st) {
    throw new UnsupportedOperationException("MaterialButton_readBack_colorBrightness read-back requires FFM/java22");
  }
  default Widget MaterialButton_readBack_child(Object st) {
    throw new UnsupportedOperationException("MaterialButton_readBack_child read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry MaterialButton_readBack_padding(Object st) {
    throw new UnsupportedOperationException("MaterialButton_readBack_padding read-back requires FFM/java22");
  }
  default VisualDensity MaterialButton_readBack_visualDensity(Object st) {
    throw new UnsupportedOperationException("MaterialButton_readBack_visualDensity read-back requires FFM/java22");
  }
  default ShapeBorder MaterialButton_readBack_shape(Object st) {
    throw new UnsupportedOperationException("MaterialButton_readBack_shape read-back requires FFM/java22");
  }
  default Clip MaterialButton_readBack_clipBehavior(Object st) {
    throw new UnsupportedOperationException("MaterialButton_readBack_clipBehavior read-back requires FFM/java22");
  }
  default boolean MaterialButton_readBack_autofocus(Object st) {
    throw new UnsupportedOperationException("MaterialButton_readBack_autofocus read-back requires FFM/java22");
  }
  default Duration MaterialButton_readBack_animationDuration(Object st) {
    throw new UnsupportedOperationException("MaterialButton_readBack_animationDuration read-back requires FFM/java22");
  }
  default MaterialTapTargetSize MaterialButton_readBack_materialTapTargetSize(Object st) {
    throw new UnsupportedOperationException("MaterialButton_readBack_materialTapTargetSize read-back requires FFM/java22");
  }
  default double MaterialButton_readBack_minWidth(Object st) {
    throw new UnsupportedOperationException("MaterialButton_readBack_minWidth read-back requires FFM/java22");
  }
  default double MaterialButton_readBack_height(Object st) {
    throw new UnsupportedOperationException("MaterialButton_readBack_height read-back requires FFM/java22");
  }
  default boolean MaterialButton_readBack_enableFeedback(Object st) {
    throw new UnsupportedOperationException("MaterialButton_readBack_enableFeedback read-back requires FFM/java22");
  }
  default boolean MaterialButton_readBack_enabled(Object st) {
    throw new UnsupportedOperationException("MaterialButton_readBack_enabled read-back requires FFM/java22");
  }

  default int rawMaterialButtonRawMaterialButton(Optional<Runnable> onPressed, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onHighlightChanged, Optional<TextStyle> textStyle, Optional<Color> fillColor, Optional<Color> focusColor, Optional<Color> hoverColor, Optional<Color> highlightColor, Optional<Color> splashColor, OptionalDouble elevation, OptionalDouble focusElevation, OptionalDouble hoverElevation, OptionalDouble highlightElevation, OptionalDouble disabledElevation, Optional<EdgeInsetsGeometry> padding, Optional<VisualDensity> visualDensity, Optional<BoxConstraints> constraints, Optional<ShapeBorder> shape, Optional<Duration> animationDuration, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<Widget> child, Optional<Boolean> enableFeedback) {
    throw new UnsupportedOperationException("rawMaterialButtonRawMaterialButton has no default (FFM/comm impl required)");
  }
  default TextStyle RawMaterialButton_readBack_textStyle(Object st) {
    throw new UnsupportedOperationException("RawMaterialButton_readBack_textStyle read-back requires FFM/java22");
  }
  default Color RawMaterialButton_readBack_fillColor(Object st) {
    throw new UnsupportedOperationException("RawMaterialButton_readBack_fillColor read-back requires FFM/java22");
  }
  default Color RawMaterialButton_readBack_focusColor(Object st) {
    throw new UnsupportedOperationException("RawMaterialButton_readBack_focusColor read-back requires FFM/java22");
  }
  default Color RawMaterialButton_readBack_hoverColor(Object st) {
    throw new UnsupportedOperationException("RawMaterialButton_readBack_hoverColor read-back requires FFM/java22");
  }
  default Color RawMaterialButton_readBack_highlightColor(Object st) {
    throw new UnsupportedOperationException("RawMaterialButton_readBack_highlightColor read-back requires FFM/java22");
  }
  default Color RawMaterialButton_readBack_splashColor(Object st) {
    throw new UnsupportedOperationException("RawMaterialButton_readBack_splashColor read-back requires FFM/java22");
  }
  default double RawMaterialButton_readBack_elevation(Object st) {
    throw new UnsupportedOperationException("RawMaterialButton_readBack_elevation read-back requires FFM/java22");
  }
  default double RawMaterialButton_readBack_hoverElevation(Object st) {
    throw new UnsupportedOperationException("RawMaterialButton_readBack_hoverElevation read-back requires FFM/java22");
  }
  default double RawMaterialButton_readBack_focusElevation(Object st) {
    throw new UnsupportedOperationException("RawMaterialButton_readBack_focusElevation read-back requires FFM/java22");
  }
  default double RawMaterialButton_readBack_highlightElevation(Object st) {
    throw new UnsupportedOperationException("RawMaterialButton_readBack_highlightElevation read-back requires FFM/java22");
  }
  default double RawMaterialButton_readBack_disabledElevation(Object st) {
    throw new UnsupportedOperationException("RawMaterialButton_readBack_disabledElevation read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry RawMaterialButton_readBack_padding(Object st) {
    throw new UnsupportedOperationException("RawMaterialButton_readBack_padding read-back requires FFM/java22");
  }
  default VisualDensity RawMaterialButton_readBack_visualDensity(Object st) {
    throw new UnsupportedOperationException("RawMaterialButton_readBack_visualDensity read-back requires FFM/java22");
  }
  default BoxConstraints RawMaterialButton_readBack_constraints(Object st) {
    throw new UnsupportedOperationException("RawMaterialButton_readBack_constraints read-back requires FFM/java22");
  }
  default ShapeBorder RawMaterialButton_readBack_shape(Object st) {
    throw new UnsupportedOperationException("RawMaterialButton_readBack_shape read-back requires FFM/java22");
  }
  default Duration RawMaterialButton_readBack_animationDuration(Object st) {
    throw new UnsupportedOperationException("RawMaterialButton_readBack_animationDuration read-back requires FFM/java22");
  }
  default Widget RawMaterialButton_readBack_child(Object st) {
    throw new UnsupportedOperationException("RawMaterialButton_readBack_child read-back requires FFM/java22");
  }
  default MaterialTapTargetSize RawMaterialButton_readBack_materialTapTargetSize(Object st) {
    throw new UnsupportedOperationException("RawMaterialButton_readBack_materialTapTargetSize read-back requires FFM/java22");
  }
  default boolean RawMaterialButton_readBack_autofocus(Object st) {
    throw new UnsupportedOperationException("RawMaterialButton_readBack_autofocus read-back requires FFM/java22");
  }
  default Clip RawMaterialButton_readBack_clipBehavior(Object st) {
    throw new UnsupportedOperationException("RawMaterialButton_readBack_clipBehavior read-back requires FFM/java22");
  }
  default boolean RawMaterialButton_readBack_enableFeedback(Object st) {
    throw new UnsupportedOperationException("RawMaterialButton_readBack_enableFeedback read-back requires FFM/java22");
  }
  default boolean RawMaterialButton_readBack_enabled(Object st) {
    throw new UnsupportedOperationException("RawMaterialButton_readBack_enabled read-back requires FFM/java22");
  }

  default int pageStoragePageStorage(PageStorageBucket bucket, Widget child) {
    throw new UnsupportedOperationException("pageStoragePageStorage has no default (FFM/comm impl required)");
  }
  default int pageStorageMaybeOf(BuildContext context) {
    throw new UnsupportedOperationException("pageStorageMaybeOf has no default (FFM/comm impl required)");
  }
  default int pageStorageOf(BuildContext context) {
    throw new UnsupportedOperationException("pageStorageOf has no default (FFM/comm impl required)");
  }
  default Widget PageStorage_readBack_child(Object st) {
    throw new UnsupportedOperationException("PageStorage_readBack_child read-back requires FFM/java22");
  }
  default PageStorageBucket PageStorage_readBack_bucket(Object st) {
    throw new UnsupportedOperationException("PageStorage_readBack_bucket read-back requires FFM/java22");
  }

  default int pageStorageBucketPageStorageBucket() {
    throw new UnsupportedOperationException("pageStorageBucketPageStorageBucket has no default (FFM/comm impl required)");
  }

  default int positionedTransitionPositionedTransition(Animation rect, Widget child) {
    throw new UnsupportedOperationException("positionedTransitionPositionedTransition has no default (FFM/comm impl required)");
  }
  default Widget PositionedTransition_readBack_child(Object st) {
    throw new UnsupportedOperationException("PositionedTransition_readBack_child read-back requires FFM/java22");
  }
  default Animation PositionedTransition_readBack_rect(Object st) {
    throw new UnsupportedOperationException("PositionedTransition_readBack_rect read-back requires FFM/java22");
  }

  default int decoratedBoxTransitionDecoratedBoxTransition(Animation decoration, Optional<DecorationPosition> position, Widget child) {
    throw new UnsupportedOperationException("decoratedBoxTransitionDecoratedBoxTransition has no default (FFM/comm impl required)");
  }
  default Animation DecoratedBoxTransition_readBack_decoration(Object st) {
    throw new UnsupportedOperationException("DecoratedBoxTransition_readBack_decoration read-back requires FFM/java22");
  }
  default DecorationPosition DecoratedBoxTransition_readBack_position(Object st) {
    throw new UnsupportedOperationException("DecoratedBoxTransition_readBack_position read-back requires FFM/java22");
  }
  default Widget DecoratedBoxTransition_readBack_child(Object st) {
    throw new UnsupportedOperationException("DecoratedBoxTransition_readBack_child read-back requires FFM/java22");
  }

  default Widget RelativePositionedTransition_readBack_child(Object st) {
    throw new UnsupportedOperationException("RelativePositionedTransition_readBack_child read-back requires FFM/java22");
  }
  default Animation RelativePositionedTransition_readBack_rect(Object st) {
    throw new UnsupportedOperationException("RelativePositionedTransition_readBack_rect read-back requires FFM/java22");
  }

  default int decoratedSliverDecoratedSliver(Decoration decoration, Optional<DecorationPosition> position, Optional<Widget> sliver) {
    throw new UnsupportedOperationException("decoratedSliverDecoratedSliver has no default (FFM/comm impl required)");
  }
  default Decoration DecoratedSliver_readBack_decoration(Object st) {
    throw new UnsupportedOperationException("DecoratedSliver_readBack_decoration read-back requires FFM/java22");
  }
  default DecorationPosition DecoratedSliver_readBack_position(Object st) {
    throw new UnsupportedOperationException("DecoratedSliver_readBack_position read-back requires FFM/java22");
  }

  default int sliverListBuilder(BiFunction<BuildContext, Integer, Widget> itemBuilder, OptionalInt itemCount, Optional<Boolean> addAutomaticKeepAlives, Optional<Boolean> addRepaintBoundaries, Optional<Boolean> addSemanticIndexes, OptionalInt semanticIndexOffset) {
    throw new UnsupportedOperationException("sliverListBuilder has no default (FFM/comm impl required)");
  }
  default int sliverListSeparated(BiFunction<BuildContext, Integer, Widget> itemBuilder, BiFunction<BuildContext, Integer, Widget> separatorBuilder, OptionalInt itemCount, Optional<Boolean> addAutomaticKeepAlives, Optional<Boolean> addRepaintBoundaries, Optional<Boolean> addSemanticIndexes) {
    throw new UnsupportedOperationException("sliverListSeparated has no default (FFM/comm impl required)");
  }
  default int sliverListList(List<Widget> children, Optional<Boolean> addAutomaticKeepAlives, Optional<Boolean> addRepaintBoundaries, Optional<Boolean> addSemanticIndexes) {
    throw new UnsupportedOperationException("sliverListList has no default (FFM/comm impl required)");
  }

  default int sliverGridCount(int crossAxisCount, OptionalDouble mainAxisSpacing, OptionalDouble crossAxisSpacing, OptionalDouble childAspectRatio, Optional<List<Widget>> children) {
    throw new UnsupportedOperationException("sliverGridCount has no default (FFM/comm impl required)");
  }
  default int sliverGridExtent(double maxCrossAxisExtent, OptionalDouble mainAxisSpacing, OptionalDouble crossAxisSpacing, OptionalDouble childAspectRatio, Optional<List<Widget>> children) {
    throw new UnsupportedOperationException("sliverGridExtent has no default (FFM/comm impl required)");
  }

  default double SliverFillViewport_readBack_viewportFraction(Object st) {
    throw new UnsupportedOperationException("SliverFillViewport_readBack_viewportFraction read-back requires FFM/java22");
  }
  default boolean SliverFillViewport_readBack_padEnds(Object st) {
    throw new UnsupportedOperationException("SliverFillViewport_readBack_padEnds read-back requires FFM/java22");
  }
  default boolean SliverFillViewport_readBack_allowImplicitScrolling(Object st) {
    throw new UnsupportedOperationException("SliverFillViewport_readBack_allowImplicitScrolling read-back requires FFM/java22");
  }

  default int sliverAnimatedOpacitySliverAnimatedOpacity(Optional<Widget> sliver, double opacity, Optional<Curve> curve, Duration duration, Optional<Runnable> onEnd, Optional<Boolean> alwaysIncludeSemantics) {
    throw new UnsupportedOperationException("sliverAnimatedOpacitySliverAnimatedOpacity has no default (FFM/comm impl required)");
  }
  default Widget SliverAnimatedOpacity_readBack_sliver(Object st) {
    throw new UnsupportedOperationException("SliverAnimatedOpacity_readBack_sliver read-back requires FFM/java22");
  }
  default double SliverAnimatedOpacity_readBack_opacity(Object st) {
    throw new UnsupportedOperationException("SliverAnimatedOpacity_readBack_opacity read-back requires FFM/java22");
  }
  default boolean SliverAnimatedOpacity_readBack_alwaysIncludeSemantics(Object st) {
    throw new UnsupportedOperationException("SliverAnimatedOpacity_readBack_alwaysIncludeSemantics read-back requires FFM/java22");
  }

  default int pinnedHeaderSliverPinnedHeaderSliver(Optional<Widget> child) {
    throw new UnsupportedOperationException("pinnedHeaderSliverPinnedHeaderSliver has no default (FFM/comm impl required)");
  }
  default Widget PinnedHeaderSliver_readBack_child(Object st) {
    throw new UnsupportedOperationException("PinnedHeaderSliver_readBack_child read-back requires FFM/java22");
  }

  default int focusTraversalGroupFocusTraversalGroup(Optional<Boolean> descendantsAreFocusable, Optional<Boolean> descendantsAreTraversable, Widget child) {
    throw new UnsupportedOperationException("focusTraversalGroupFocusTraversalGroup has no default (FFM/comm impl required)");
  }
  default boolean FocusTraversalGroup_readBack_descendantsAreFocusable(Object st) {
    throw new UnsupportedOperationException("FocusTraversalGroup_readBack_descendantsAreFocusable read-back requires FFM/java22");
  }
  default boolean FocusTraversalGroup_readBack_descendantsAreTraversable(Object st) {
    throw new UnsupportedOperationException("FocusTraversalGroup_readBack_descendantsAreTraversable read-back requires FFM/java22");
  }
  default Widget FocusTraversalGroup_readBack_child(Object st) {
    throw new UnsupportedOperationException("FocusTraversalGroup_readBack_child read-back requires FFM/java22");
  }

  default int sliverFadeTransitionSliverFadeTransition(Animation opacity, Optional<Boolean> alwaysIncludeSemantics, Optional<Widget> sliver) {
    throw new UnsupportedOperationException("sliverFadeTransitionSliverFadeTransition has no default (FFM/comm impl required)");
  }
  default Animation SliverFadeTransition_readBack_opacity(Object st) {
    throw new UnsupportedOperationException("SliverFadeTransition_readBack_opacity read-back requires FFM/java22");
  }
  default boolean SliverFadeTransition_readBack_alwaysIncludeSemantics(Object st) {
    throw new UnsupportedOperationException("SliverFadeTransition_readBack_alwaysIncludeSemantics read-back requires FFM/java22");
  }

  default int sliverFixedExtentListBuilder(BiFunction<BuildContext, Integer, Widget> itemBuilder, double itemExtent, OptionalInt itemCount, Optional<Boolean> addAutomaticKeepAlives, Optional<Boolean> addRepaintBoundaries, Optional<Boolean> addSemanticIndexes, OptionalInt semanticIndexOffset) {
    throw new UnsupportedOperationException("sliverFixedExtentListBuilder has no default (FFM/comm impl required)");
  }
  default int sliverFixedExtentListList(List<Widget> children, double itemExtent, Optional<Boolean> addAutomaticKeepAlives, Optional<Boolean> addRepaintBoundaries, Optional<Boolean> addSemanticIndexes) {
    throw new UnsupportedOperationException("sliverFixedExtentListList has no default (FFM/comm impl required)");
  }
  default double SliverFixedExtentList_readBack_itemExtent(Object st) {
    throw new UnsupportedOperationException("SliverFixedExtentList_readBack_itemExtent read-back requires FFM/java22");
  }

  default int sliverPrototypeExtentListBuilder(BiFunction<BuildContext, Integer, Widget> itemBuilder, Widget prototypeItem, OptionalInt itemCount, Optional<Boolean> addAutomaticKeepAlives, Optional<Boolean> addRepaintBoundaries, Optional<Boolean> addSemanticIndexes) {
    throw new UnsupportedOperationException("sliverPrototypeExtentListBuilder has no default (FFM/comm impl required)");
  }
  default int sliverPrototypeExtentListList(List<Widget> children, Widget prototypeItem, Optional<Boolean> addAutomaticKeepAlives, Optional<Boolean> addRepaintBoundaries, Optional<Boolean> addSemanticIndexes) {
    throw new UnsupportedOperationException("sliverPrototypeExtentListList has no default (FFM/comm impl required)");
  }
  default Widget SliverPrototypeExtentList_readBack_prototypeItem(Object st) {
    throw new UnsupportedOperationException("SliverPrototypeExtentList_readBack_prototypeItem read-back requires FFM/java22");
  }

  default int sliverResizingHeaderSliverResizingHeader(Optional<Widget> minExtentPrototype, Optional<Widget> maxExtentPrototype, Optional<Widget> child) {
    throw new UnsupportedOperationException("sliverResizingHeaderSliverResizingHeader has no default (FFM/comm impl required)");
  }
  default Widget SliverResizingHeader_readBack_minExtentPrototype(Object st) {
    throw new UnsupportedOperationException("SliverResizingHeader_readBack_minExtentPrototype read-back requires FFM/java22");
  }
  default Widget SliverResizingHeader_readBack_maxExtentPrototype(Object st) {
    throw new UnsupportedOperationException("SliverResizingHeader_readBack_maxExtentPrototype read-back requires FFM/java22");
  }
  default Widget SliverResizingHeader_readBack_child(Object st) {
    throw new UnsupportedOperationException("SliverResizingHeader_readBack_child read-back requires FFM/java22");
  }

  default int sliverFloatingHeaderSliverFloatingHeader(Optional<FloatingHeaderSnapMode> snapMode, Widget child) {
    throw new UnsupportedOperationException("sliverFloatingHeaderSliverFloatingHeader has no default (FFM/comm impl required)");
  }
  default FloatingHeaderSnapMode SliverFloatingHeader_readBack_snapMode(Object st) {
    throw new UnsupportedOperationException("SliverFloatingHeader_readBack_snapMode read-back requires FFM/java22");
  }
  default Widget SliverFloatingHeader_readBack_child(Object st) {
    throw new UnsupportedOperationException("SliverFloatingHeader_readBack_child read-back requires FFM/java22");
  }

  default int sliverSemanticsSliverSemantics(Widget sliver, Optional<Boolean> container, Optional<Boolean> explicitChildNodes, Optional<Boolean> excludeSemantics, Optional<Boolean> blockUserActions, Optional<Boolean> enabled, Optional<Boolean> checked, Optional<Boolean> mixed, Optional<Boolean> selected, Optional<Boolean> toggled, Optional<Boolean> button, Optional<Boolean> slider, Optional<Boolean> keyboardKey, Optional<Boolean> link, Optional<Boolean> header, OptionalInt headingLevel, Optional<Boolean> textField, Optional<Boolean> readOnly, Optional<Boolean> focusable, Optional<Boolean> focused, Optional<AccessibilityFocusBlockType> accessibilityFocusBlockType, Optional<Boolean> inMutuallyExclusiveGroup, Optional<Boolean> obscured, Optional<Boolean> multiline, Optional<Boolean> scopesRoute, Optional<Boolean> namesRoute, Optional<Boolean> hidden, Optional<Boolean> image, Optional<Boolean> liveRegion, Optional<Boolean> expanded, Optional<Boolean> isRequired, OptionalInt maxValueLength, OptionalInt currentValueLength, Optional<String> identifier, Optional<NativeObj> traversalParentIdentifier, Optional<NativeObj> traversalChildIdentifier, Optional<String> label, Optional<String> value, Optional<String> increasedValue, Optional<String> decreasedValue, Optional<String> hint, Optional<String> tooltip, Optional<String> onTapHint, Optional<String> onLongPressHint, Optional<TextDirection> textDirection, Optional<Runnable> onTap, Optional<Runnable> onLongPress, Optional<Runnable> onScrollLeft, Optional<Runnable> onScrollRight, Optional<Runnable> onScrollUp, Optional<Runnable> onScrollDown, Optional<Runnable> onIncrease, Optional<Runnable> onDecrease, Optional<Runnable> onCopy, Optional<Runnable> onCut, Optional<Runnable> onPaste, Optional<Runnable> onDismiss, Optional<Consumer<Boolean>> onMoveCursorForwardByCharacter, Optional<Consumer<Boolean>> onMoveCursorBackwardByCharacter, Optional<Consumer<String>> onSetText, Optional<Runnable> onDidGainAccessibilityFocus, Optional<Runnable> onDidLoseAccessibilityFocus, Optional<Runnable> onFocus, Optional<Runnable> onExpand, Optional<Runnable> onCollapse, Optional<SemanticsRole> role, Optional<SemanticsValidationResult> validationResult, Optional<SemanticsHitTestBehavior> hitTestBehavior, Optional<SemanticsInputType> inputType, Optional<String> minValue, Optional<String> maxValue) {
    throw new UnsupportedOperationException("sliverSemanticsSliverSemantics has no default (FFM/comm impl required)");
  }

  default int sliverAppBarSliverAppBar(Optional<Widget> leading, Optional<Boolean> automaticallyImplyLeading, Optional<Widget> title, Optional<List<Widget>> actions, Optional<Boolean> automaticallyImplyActions, Optional<Widget> flexibleSpace, Optional<PreferredSizeWidget> bottom, OptionalDouble elevation, OptionalDouble scrolledUnderElevation, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, Optional<Boolean> forceElevated, Optional<Color> backgroundColor, Optional<Color> foregroundColor, Optional<IconThemeData> iconTheme, Optional<IconThemeData> actionsIconTheme, Optional<Boolean> primary, Optional<Boolean> centerTitle, Optional<Boolean> excludeHeaderSemantics, OptionalDouble titleSpacing, OptionalDouble collapsedHeight, OptionalDouble expandedHeight, Optional<Boolean> floating, Optional<Boolean> pinned, Optional<Boolean> snap, Optional<Boolean> stretch, OptionalDouble stretchTriggerOffset, Optional<Supplier<Future<Void>>> onStretchTrigger, Optional<ShapeBorder> shape, OptionalDouble toolbarHeight, OptionalDouble leadingWidth, Optional<TextStyle> toolbarTextStyle, Optional<TextStyle> titleTextStyle, Optional<Boolean> forceMaterialTransparency, Optional<Boolean> useDefaultSemanticsOrder, Optional<Clip> clipBehavior, Optional<EdgeInsetsGeometry> actionsPadding) {
    throw new UnsupportedOperationException("sliverAppBarSliverAppBar has no default (FFM/comm impl required)");
  }
  default int sliverAppBarMedium(Optional<Widget> leading, Optional<Boolean> automaticallyImplyLeading, Optional<Widget> title, Optional<List<Widget>> actions, Optional<Boolean> automaticallyImplyActions, Optional<Widget> flexibleSpace, Optional<PreferredSizeWidget> bottom, OptionalDouble elevation, OptionalDouble scrolledUnderElevation, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, Optional<Boolean> forceElevated, Optional<Color> backgroundColor, Optional<Color> foregroundColor, Optional<IconThemeData> iconTheme, Optional<IconThemeData> actionsIconTheme, Optional<Boolean> primary, Optional<Boolean> centerTitle, Optional<Boolean> excludeHeaderSemantics, OptionalDouble titleSpacing, OptionalDouble collapsedHeight, OptionalDouble expandedHeight, Optional<Boolean> floating, Optional<Boolean> pinned, Optional<Boolean> snap, Optional<Boolean> stretch, OptionalDouble stretchTriggerOffset, Optional<Supplier<Future<Void>>> onStretchTrigger, Optional<ShapeBorder> shape, OptionalDouble leadingWidth, Optional<TextStyle> toolbarTextStyle, Optional<TextStyle> titleTextStyle, Optional<Boolean> forceMaterialTransparency, Optional<Boolean> useDefaultSemanticsOrder, Optional<Clip> clipBehavior, Optional<EdgeInsetsGeometry> actionsPadding) {
    throw new UnsupportedOperationException("sliverAppBarMedium has no default (FFM/comm impl required)");
  }
  default int sliverAppBarLarge(Optional<Widget> leading, Optional<Boolean> automaticallyImplyLeading, Optional<Widget> title, Optional<List<Widget>> actions, Optional<Boolean> automaticallyImplyActions, Optional<Widget> flexibleSpace, Optional<PreferredSizeWidget> bottom, OptionalDouble elevation, OptionalDouble scrolledUnderElevation, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, Optional<Boolean> forceElevated, Optional<Color> backgroundColor, Optional<Color> foregroundColor, Optional<IconThemeData> iconTheme, Optional<IconThemeData> actionsIconTheme, Optional<Boolean> primary, Optional<Boolean> centerTitle, Optional<Boolean> excludeHeaderSemantics, OptionalDouble titleSpacing, OptionalDouble collapsedHeight, OptionalDouble expandedHeight, Optional<Boolean> floating, Optional<Boolean> pinned, Optional<Boolean> snap, Optional<Boolean> stretch, OptionalDouble stretchTriggerOffset, Optional<Supplier<Future<Void>>> onStretchTrigger, Optional<ShapeBorder> shape, OptionalDouble leadingWidth, Optional<TextStyle> toolbarTextStyle, Optional<TextStyle> titleTextStyle, Optional<Boolean> forceMaterialTransparency, Optional<Boolean> useDefaultSemanticsOrder, Optional<Clip> clipBehavior, Optional<EdgeInsetsGeometry> actionsPadding) {
    throw new UnsupportedOperationException("sliverAppBarLarge has no default (FFM/comm impl required)");
  }
  default Widget SliverAppBar_readBack_leading(Object st) {
    throw new UnsupportedOperationException("SliverAppBar_readBack_leading read-back requires FFM/java22");
  }
  default boolean SliverAppBar_readBack_automaticallyImplyLeading(Object st) {
    throw new UnsupportedOperationException("SliverAppBar_readBack_automaticallyImplyLeading read-back requires FFM/java22");
  }
  default Widget SliverAppBar_readBack_title(Object st) {
    throw new UnsupportedOperationException("SliverAppBar_readBack_title read-back requires FFM/java22");
  }
  default boolean SliverAppBar_readBack_automaticallyImplyActions(Object st) {
    throw new UnsupportedOperationException("SliverAppBar_readBack_automaticallyImplyActions read-back requires FFM/java22");
  }
  default Widget SliverAppBar_readBack_flexibleSpace(Object st) {
    throw new UnsupportedOperationException("SliverAppBar_readBack_flexibleSpace read-back requires FFM/java22");
  }
  default PreferredSizeWidget SliverAppBar_readBack_bottom(Object st) {
    throw new UnsupportedOperationException("SliverAppBar_readBack_bottom read-back requires FFM/java22");
  }
  default double SliverAppBar_readBack_elevation(Object st) {
    throw new UnsupportedOperationException("SliverAppBar_readBack_elevation read-back requires FFM/java22");
  }
  default double SliverAppBar_readBack_scrolledUnderElevation(Object st) {
    throw new UnsupportedOperationException("SliverAppBar_readBack_scrolledUnderElevation read-back requires FFM/java22");
  }
  default Color SliverAppBar_readBack_shadowColor(Object st) {
    throw new UnsupportedOperationException("SliverAppBar_readBack_shadowColor read-back requires FFM/java22");
  }
  default Color SliverAppBar_readBack_surfaceTintColor(Object st) {
    throw new UnsupportedOperationException("SliverAppBar_readBack_surfaceTintColor read-back requires FFM/java22");
  }
  default boolean SliverAppBar_readBack_forceElevated(Object st) {
    throw new UnsupportedOperationException("SliverAppBar_readBack_forceElevated read-back requires FFM/java22");
  }
  default Color SliverAppBar_readBack_backgroundColor(Object st) {
    throw new UnsupportedOperationException("SliverAppBar_readBack_backgroundColor read-back requires FFM/java22");
  }
  default Color SliverAppBar_readBack_foregroundColor(Object st) {
    throw new UnsupportedOperationException("SliverAppBar_readBack_foregroundColor read-back requires FFM/java22");
  }
  default IconThemeData SliverAppBar_readBack_iconTheme(Object st) {
    throw new UnsupportedOperationException("SliverAppBar_readBack_iconTheme read-back requires FFM/java22");
  }
  default IconThemeData SliverAppBar_readBack_actionsIconTheme(Object st) {
    throw new UnsupportedOperationException("SliverAppBar_readBack_actionsIconTheme read-back requires FFM/java22");
  }
  default boolean SliverAppBar_readBack_primary(Object st) {
    throw new UnsupportedOperationException("SliverAppBar_readBack_primary read-back requires FFM/java22");
  }
  default boolean SliverAppBar_readBack_centerTitle(Object st) {
    throw new UnsupportedOperationException("SliverAppBar_readBack_centerTitle read-back requires FFM/java22");
  }
  default boolean SliverAppBar_readBack_excludeHeaderSemantics(Object st) {
    throw new UnsupportedOperationException("SliverAppBar_readBack_excludeHeaderSemantics read-back requires FFM/java22");
  }
  default double SliverAppBar_readBack_titleSpacing(Object st) {
    throw new UnsupportedOperationException("SliverAppBar_readBack_titleSpacing read-back requires FFM/java22");
  }
  default double SliverAppBar_readBack_collapsedHeight(Object st) {
    throw new UnsupportedOperationException("SliverAppBar_readBack_collapsedHeight read-back requires FFM/java22");
  }
  default double SliverAppBar_readBack_expandedHeight(Object st) {
    throw new UnsupportedOperationException("SliverAppBar_readBack_expandedHeight read-back requires FFM/java22");
  }
  default boolean SliverAppBar_readBack_floating(Object st) {
    throw new UnsupportedOperationException("SliverAppBar_readBack_floating read-back requires FFM/java22");
  }
  default boolean SliverAppBar_readBack_pinned(Object st) {
    throw new UnsupportedOperationException("SliverAppBar_readBack_pinned read-back requires FFM/java22");
  }
  default ShapeBorder SliverAppBar_readBack_shape(Object st) {
    throw new UnsupportedOperationException("SliverAppBar_readBack_shape read-back requires FFM/java22");
  }
  default boolean SliverAppBar_readBack_snap(Object st) {
    throw new UnsupportedOperationException("SliverAppBar_readBack_snap read-back requires FFM/java22");
  }
  default boolean SliverAppBar_readBack_stretch(Object st) {
    throw new UnsupportedOperationException("SliverAppBar_readBack_stretch read-back requires FFM/java22");
  }
  default double SliverAppBar_readBack_stretchTriggerOffset(Object st) {
    throw new UnsupportedOperationException("SliverAppBar_readBack_stretchTriggerOffset read-back requires FFM/java22");
  }
  default double SliverAppBar_readBack_toolbarHeight(Object st) {
    throw new UnsupportedOperationException("SliverAppBar_readBack_toolbarHeight read-back requires FFM/java22");
  }
  default double SliverAppBar_readBack_leadingWidth(Object st) {
    throw new UnsupportedOperationException("SliverAppBar_readBack_leadingWidth read-back requires FFM/java22");
  }
  default TextStyle SliverAppBar_readBack_toolbarTextStyle(Object st) {
    throw new UnsupportedOperationException("SliverAppBar_readBack_toolbarTextStyle read-back requires FFM/java22");
  }
  default TextStyle SliverAppBar_readBack_titleTextStyle(Object st) {
    throw new UnsupportedOperationException("SliverAppBar_readBack_titleTextStyle read-back requires FFM/java22");
  }
  default boolean SliverAppBar_readBack_forceMaterialTransparency(Object st) {
    throw new UnsupportedOperationException("SliverAppBar_readBack_forceMaterialTransparency read-back requires FFM/java22");
  }
  default boolean SliverAppBar_readBack_useDefaultSemanticsOrder(Object st) {
    throw new UnsupportedOperationException("SliverAppBar_readBack_useDefaultSemanticsOrder read-back requires FFM/java22");
  }
  default Clip SliverAppBar_readBack_clipBehavior(Object st) {
    throw new UnsupportedOperationException("SliverAppBar_readBack_clipBehavior read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry SliverAppBar_readBack_actionsPadding(Object st) {
    throw new UnsupportedOperationException("SliverAppBar_readBack_actionsPadding read-back requires FFM/java22");
  }

  default int fadeInImageAssetNetwork(String placeholder, String image, OptionalDouble placeholderScale, OptionalDouble imageScale, Optional<Boolean> excludeFromSemantics, Optional<String> imageSemanticLabel, Optional<Duration> fadeOutDuration, Optional<Curve> fadeOutCurve, Optional<Duration> fadeInDuration, Optional<Curve> fadeInCurve, OptionalDouble width, OptionalDouble height, Optional<BoxFit> fit, Optional<Color> color, Optional<BlendMode> colorBlendMode, Optional<Color> placeholderColor, Optional<BlendMode> placeholderColorBlendMode, Optional<BoxFit> placeholderFit, Optional<FilterQuality> filterQuality, Optional<FilterQuality> placeholderFilterQuality, Optional<AlignmentGeometry> alignment, Optional<ImageRepeat> repeat, Optional<Boolean> matchTextDirection, OptionalInt placeholderCacheWidth, OptionalInt placeholderCacheHeight, OptionalInt imageCacheWidth, OptionalInt imageCacheHeight) {
    throw new UnsupportedOperationException("fadeInImageAssetNetwork has no default (FFM/comm impl required)");
  }
  default Duration FadeInImage_readBack_fadeOutDuration(Object st) {
    throw new UnsupportedOperationException("FadeInImage_readBack_fadeOutDuration read-back requires FFM/java22");
  }
  default Curve FadeInImage_readBack_fadeOutCurve(Object st) {
    throw new UnsupportedOperationException("FadeInImage_readBack_fadeOutCurve read-back requires FFM/java22");
  }
  default Duration FadeInImage_readBack_fadeInDuration(Object st) {
    throw new UnsupportedOperationException("FadeInImage_readBack_fadeInDuration read-back requires FFM/java22");
  }
  default Curve FadeInImage_readBack_fadeInCurve(Object st) {
    throw new UnsupportedOperationException("FadeInImage_readBack_fadeInCurve read-back requires FFM/java22");
  }
  default double FadeInImage_readBack_width(Object st) {
    throw new UnsupportedOperationException("FadeInImage_readBack_width read-back requires FFM/java22");
  }
  default Color FadeInImage_readBack_color(Object st) {
    throw new UnsupportedOperationException("FadeInImage_readBack_color read-back requires FFM/java22");
  }
  default BlendMode FadeInImage_readBack_colorBlendMode(Object st) {
    throw new UnsupportedOperationException("FadeInImage_readBack_colorBlendMode read-back requires FFM/java22");
  }
  default Color FadeInImage_readBack_placeholderColor(Object st) {
    throw new UnsupportedOperationException("FadeInImage_readBack_placeholderColor read-back requires FFM/java22");
  }
  default BlendMode FadeInImage_readBack_placeholderColorBlendMode(Object st) {
    throw new UnsupportedOperationException("FadeInImage_readBack_placeholderColorBlendMode read-back requires FFM/java22");
  }
  default double FadeInImage_readBack_height(Object st) {
    throw new UnsupportedOperationException("FadeInImage_readBack_height read-back requires FFM/java22");
  }
  default BoxFit FadeInImage_readBack_fit(Object st) {
    throw new UnsupportedOperationException("FadeInImage_readBack_fit read-back requires FFM/java22");
  }
  default BoxFit FadeInImage_readBack_placeholderFit(Object st) {
    throw new UnsupportedOperationException("FadeInImage_readBack_placeholderFit read-back requires FFM/java22");
  }
  default FilterQuality FadeInImage_readBack_filterQuality(Object st) {
    throw new UnsupportedOperationException("FadeInImage_readBack_filterQuality read-back requires FFM/java22");
  }
  default FilterQuality FadeInImage_readBack_placeholderFilterQuality(Object st) {
    throw new UnsupportedOperationException("FadeInImage_readBack_placeholderFilterQuality read-back requires FFM/java22");
  }
  default AlignmentGeometry FadeInImage_readBack_alignment(Object st) {
    throw new UnsupportedOperationException("FadeInImage_readBack_alignment read-back requires FFM/java22");
  }
  default ImageRepeat FadeInImage_readBack_repeat(Object st) {
    throw new UnsupportedOperationException("FadeInImage_readBack_repeat read-back requires FFM/java22");
  }
  default boolean FadeInImage_readBack_matchTextDirection(Object st) {
    throw new UnsupportedOperationException("FadeInImage_readBack_matchTextDirection read-back requires FFM/java22");
  }
  default boolean FadeInImage_readBack_excludeFromSemantics(Object st) {
    throw new UnsupportedOperationException("FadeInImage_readBack_excludeFromSemantics read-back requires FFM/java22");
  }
  default String FadeInImage_readBack_imageSemanticLabel(Object st) {
    throw new UnsupportedOperationException("FadeInImage_readBack_imageSemanticLabel read-back requires FFM/java22");
  }

  default <T> int navigatorPopHandlerNavigatorPopHandler(Optional<Runnable> onPop, Optional<Consumer<NativeObj>> onPopWithResult, Optional<Boolean> enabled, Widget child) {
    throw new UnsupportedOperationException("navigatorPopHandlerNavigatorPopHandler has no default (FFM/comm impl required)");
  }
  default Widget NavigatorPopHandler_readBack_child(Object st) {
    throw new UnsupportedOperationException("NavigatorPopHandler_readBack_child read-back requires FFM/java22");
  }
  default boolean NavigatorPopHandler_readBack_enabled(Object st) {
    throw new UnsupportedOperationException("NavigatorPopHandler_readBack_enabled read-back requires FFM/java22");
  }

  default int rawImageRawImage(Optional<String> debugImageLabel, OptionalDouble width, OptionalDouble height, OptionalDouble scale, Optional<Color> color, Optional<Animation> opacity, Optional<BlendMode> colorBlendMode, Optional<BoxFit> fit, Optional<AlignmentGeometry> alignment, Optional<ImageRepeat> repeat, Optional<Boolean> matchTextDirection, Optional<Boolean> invertColors, Optional<FilterQuality> filterQuality, Optional<Boolean> isAntiAlias) {
    throw new UnsupportedOperationException("rawImageRawImage has no default (FFM/comm impl required)");
  }
  default String RawImage_readBack_debugImageLabel(Object st) {
    throw new UnsupportedOperationException("RawImage_readBack_debugImageLabel read-back requires FFM/java22");
  }
  default double RawImage_readBack_width(Object st) {
    throw new UnsupportedOperationException("RawImage_readBack_width read-back requires FFM/java22");
  }
  default double RawImage_readBack_height(Object st) {
    throw new UnsupportedOperationException("RawImage_readBack_height read-back requires FFM/java22");
  }
  default double RawImage_readBack_scale(Object st) {
    throw new UnsupportedOperationException("RawImage_readBack_scale read-back requires FFM/java22");
  }
  default Color RawImage_readBack_color(Object st) {
    throw new UnsupportedOperationException("RawImage_readBack_color read-back requires FFM/java22");
  }
  default Animation RawImage_readBack_opacity(Object st) {
    throw new UnsupportedOperationException("RawImage_readBack_opacity read-back requires FFM/java22");
  }
  default FilterQuality RawImage_readBack_filterQuality(Object st) {
    throw new UnsupportedOperationException("RawImage_readBack_filterQuality read-back requires FFM/java22");
  }
  default BlendMode RawImage_readBack_colorBlendMode(Object st) {
    throw new UnsupportedOperationException("RawImage_readBack_colorBlendMode read-back requires FFM/java22");
  }
  default BoxFit RawImage_readBack_fit(Object st) {
    throw new UnsupportedOperationException("RawImage_readBack_fit read-back requires FFM/java22");
  }
  default AlignmentGeometry RawImage_readBack_alignment(Object st) {
    throw new UnsupportedOperationException("RawImage_readBack_alignment read-back requires FFM/java22");
  }
  default ImageRepeat RawImage_readBack_repeat(Object st) {
    throw new UnsupportedOperationException("RawImage_readBack_repeat read-back requires FFM/java22");
  }
  default boolean RawImage_readBack_matchTextDirection(Object st) {
    throw new UnsupportedOperationException("RawImage_readBack_matchTextDirection read-back requires FFM/java22");
  }
  default boolean RawImage_readBack_invertColors(Object st) {
    throw new UnsupportedOperationException("RawImage_readBack_invertColors read-back requires FFM/java22");
  }
  default boolean RawImage_readBack_isAntiAlias(Object st) {
    throw new UnsupportedOperationException("RawImage_readBack_isAntiAlias read-back requires FFM/java22");
  }

  default int stepperStepper(List<Step> steps, Optional<StepperType> type, OptionalInt currentStep, Optional<Consumer<Integer>> onStepTapped, Optional<Runnable> onStepContinue, Optional<Runnable> onStepCancel, OptionalDouble elevation, Optional<EdgeInsetsGeometry> margin, Optional<Color> connectorColor, OptionalDouble connectorThickness, Optional<BiFunction<Integer, StepState, Widget>> stepIconBuilder, OptionalDouble stepIconHeight, OptionalDouble stepIconWidth, Optional<EdgeInsets> stepIconMargin, Optional<Clip> clipBehavior, Optional<EdgeInsetsGeometry> headerPadding, Optional<EdgeInsetsGeometry> contentPadding) {
    throw new UnsupportedOperationException("stepperStepper has no default (FFM/comm impl required)");
  }
  default StepperType Stepper_readBack_type(Object st) {
    throw new UnsupportedOperationException("Stepper_readBack_type read-back requires FFM/java22");
  }
  default int Stepper_readBack_currentStep(Object st) {
    throw new UnsupportedOperationException("Stepper_readBack_currentStep read-back requires FFM/java22");
  }
  default double Stepper_readBack_elevation(Object st) {
    throw new UnsupportedOperationException("Stepper_readBack_elevation read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry Stepper_readBack_margin(Object st) {
    throw new UnsupportedOperationException("Stepper_readBack_margin read-back requires FFM/java22");
  }
  default double Stepper_readBack_connectorThickness(Object st) {
    throw new UnsupportedOperationException("Stepper_readBack_connectorThickness read-back requires FFM/java22");
  }
  default double Stepper_readBack_stepIconHeight(Object st) {
    throw new UnsupportedOperationException("Stepper_readBack_stepIconHeight read-back requires FFM/java22");
  }
  default double Stepper_readBack_stepIconWidth(Object st) {
    throw new UnsupportedOperationException("Stepper_readBack_stepIconWidth read-back requires FFM/java22");
  }
  default EdgeInsets Stepper_readBack_stepIconMargin(Object st) {
    throw new UnsupportedOperationException("Stepper_readBack_stepIconMargin read-back requires FFM/java22");
  }
  default Clip Stepper_readBack_clipBehavior(Object st) {
    throw new UnsupportedOperationException("Stepper_readBack_clipBehavior read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry Stepper_readBack_headerPadding(Object st) {
    throw new UnsupportedOperationException("Stepper_readBack_headerPadding read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry Stepper_readBack_contentPadding(Object st) {
    throw new UnsupportedOperationException("Stepper_readBack_contentPadding read-back requires FFM/java22");
  }

  default int stepStep(Widget title, Optional<Widget> subtitle, Widget content, Optional<StepState> state, Optional<Boolean> isActive, Optional<Widget> label) {
    throw new UnsupportedOperationException("stepStep has no default (FFM/comm impl required)");
  }
  default Widget Step_readBack_title(Object st) {
    throw new UnsupportedOperationException("Step_readBack_title read-back requires FFM/java22");
  }
  default Widget Step_readBack_subtitle(Object st) {
    throw new UnsupportedOperationException("Step_readBack_subtitle read-back requires FFM/java22");
  }
  default Widget Step_readBack_content(Object st) {
    throw new UnsupportedOperationException("Step_readBack_content read-back requires FFM/java22");
  }
  default StepState Step_readBack_state(Object st) {
    throw new UnsupportedOperationException("Step_readBack_state read-back requires FFM/java22");
  }
  default boolean Step_readBack_isActive(Object st) {
    throw new UnsupportedOperationException("Step_readBack_isActive read-back requires FFM/java22");
  }
  default Widget Step_readBack_label(Object st) {
    throw new UnsupportedOperationException("Step_readBack_label read-back requires FFM/java22");
  }

  default int tabPageSelectorTabPageSelector(OptionalDouble indicatorSize, Optional<Color> color, Optional<Color> selectedColor, Optional<BorderStyle> borderStyle) {
    throw new UnsupportedOperationException("tabPageSelectorTabPageSelector has no default (FFM/comm impl required)");
  }
  default double TabPageSelector_readBack_indicatorSize(Object st) {
    throw new UnsupportedOperationException("TabPageSelector_readBack_indicatorSize read-back requires FFM/java22");
  }
  default Color TabPageSelector_readBack_color(Object st) {
    throw new UnsupportedOperationException("TabPageSelector_readBack_color read-back requires FFM/java22");
  }
  default Color TabPageSelector_readBack_selectedColor(Object st) {
    throw new UnsupportedOperationException("TabPageSelector_readBack_selectedColor read-back requires FFM/java22");
  }
  default BorderStyle TabPageSelector_readBack_borderStyle(Object st) {
    throw new UnsupportedOperationException("TabPageSelector_readBack_borderStyle read-back requires FFM/java22");
  }

  default int carouselViewCarouselView(Optional<EdgeInsets> padding, Optional<Color> backgroundColor, OptionalDouble elevation, Optional<ShapeBorder> shape, Optional<Clip> itemClipBehavior, Optional<Color> overlayColor, Optional<Boolean> itemSnapping, OptionalDouble shrinkExtent, Optional<Axis> scrollDirection, Optional<Boolean> reverse, Optional<Consumer<Integer>> onTap, Optional<Boolean> enableSplash, Optional<Boolean> infinite, double itemExtent, List<Widget> children, Optional<Consumer<Integer>> onIndexChanged) {
    throw new UnsupportedOperationException("carouselViewCarouselView has no default (FFM/comm impl required)");
  }
  default int carouselViewBuilder(Optional<EdgeInsets> padding, Optional<Color> backgroundColor, OptionalDouble elevation, Optional<ShapeBorder> shape, Optional<Clip> itemClipBehavior, Optional<Color> overlayColor, Optional<Boolean> itemSnapping, OptionalDouble shrinkExtent, Optional<Axis> scrollDirection, Optional<Boolean> reverse, Optional<Consumer<Integer>> onTap, Optional<Boolean> enableSplash, double itemExtent, Optional<BiFunction<BuildContext, Integer, Widget>> itemBuilder, OptionalInt itemCount, Optional<Consumer<Integer>> onIndexChanged, Optional<Boolean> infinite) {
    throw new UnsupportedOperationException("carouselViewBuilder has no default (FFM/comm impl required)");
  }
  default EdgeInsets CarouselView_readBack_padding(Object st) {
    throw new UnsupportedOperationException("CarouselView_readBack_padding read-back requires FFM/java22");
  }
  default Color CarouselView_readBack_backgroundColor(Object st) {
    throw new UnsupportedOperationException("CarouselView_readBack_backgroundColor read-back requires FFM/java22");
  }
  default double CarouselView_readBack_elevation(Object st) {
    throw new UnsupportedOperationException("CarouselView_readBack_elevation read-back requires FFM/java22");
  }
  default ShapeBorder CarouselView_readBack_shape(Object st) {
    throw new UnsupportedOperationException("CarouselView_readBack_shape read-back requires FFM/java22");
  }
  default Clip CarouselView_readBack_itemClipBehavior(Object st) {
    throw new UnsupportedOperationException("CarouselView_readBack_itemClipBehavior read-back requires FFM/java22");
  }
  default double CarouselView_readBack_shrinkExtent(Object st) {
    throw new UnsupportedOperationException("CarouselView_readBack_shrinkExtent read-back requires FFM/java22");
  }
  default boolean CarouselView_readBack_itemSnapping(Object st) {
    throw new UnsupportedOperationException("CarouselView_readBack_itemSnapping read-back requires FFM/java22");
  }
  default Axis CarouselView_readBack_scrollDirection(Object st) {
    throw new UnsupportedOperationException("CarouselView_readBack_scrollDirection read-back requires FFM/java22");
  }
  default boolean CarouselView_readBack_reverse(Object st) {
    throw new UnsupportedOperationException("CarouselView_readBack_reverse read-back requires FFM/java22");
  }
  default boolean CarouselView_readBack_consumeMaxWeight(Object st) {
    throw new UnsupportedOperationException("CarouselView_readBack_consumeMaxWeight read-back requires FFM/java22");
  }
  default boolean CarouselView_readBack_enableSplash(Object st) {
    throw new UnsupportedOperationException("CarouselView_readBack_enableSplash read-back requires FFM/java22");
  }
  default double CarouselView_readBack_itemExtent(Object st) {
    throw new UnsupportedOperationException("CarouselView_readBack_itemExtent read-back requires FFM/java22");
  }
  default int CarouselView_readBack_itemCount(Object st) {
    throw new UnsupportedOperationException("CarouselView_readBack_itemCount read-back requires FFM/java22");
  }
  default boolean CarouselView_readBack_infinite(Object st) {
    throw new UnsupportedOperationException("CarouselView_readBack_infinite read-back requires FFM/java22");
  }

  default int mergeableMaterialMergeableMaterial(Optional<Axis> mainAxis, OptionalDouble elevation, Optional<Boolean> hasDividers, Optional<List<MergeableMaterialItem>> children, Optional<Color> dividerColor) {
    throw new UnsupportedOperationException("mergeableMaterialMergeableMaterial has no default (FFM/comm impl required)");
  }
  default Axis MergeableMaterial_readBack_mainAxis(Object st) {
    throw new UnsupportedOperationException("MergeableMaterial_readBack_mainAxis read-back requires FFM/java22");
  }
  default double MergeableMaterial_readBack_elevation(Object st) {
    throw new UnsupportedOperationException("MergeableMaterial_readBack_elevation read-back requires FFM/java22");
  }
  default boolean MergeableMaterial_readBack_hasDividers(Object st) {
    throw new UnsupportedOperationException("MergeableMaterial_readBack_hasDividers read-back requires FFM/java22");
  }
  default Color MergeableMaterial_readBack_dividerColor(Object st) {
    throw new UnsupportedOperationException("MergeableMaterial_readBack_dividerColor read-back requires FFM/java22");
  }

  default Widget MaterialSlice_readBack_child(Object st) {
    throw new UnsupportedOperationException("MaterialSlice_readBack_child read-back requires FFM/java22");
  }
  default Color MaterialSlice_readBack_color(Object st) {
    throw new UnsupportedOperationException("MaterialSlice_readBack_color read-back requires FFM/java22");
  }

  default double MaterialGap_readBack_size(Object st) {
    throw new UnsupportedOperationException("MaterialGap_readBack_size read-back requires FFM/java22");
  }

  default int desktopTextSelectionToolbarDesktopTextSelectionToolbar(Offset anchor, List<Widget> children) {
    throw new UnsupportedOperationException("desktopTextSelectionToolbarDesktopTextSelectionToolbar has no default (FFM/comm impl required)");
  }
  default Offset DesktopTextSelectionToolbar_readBack_anchor(Object st) {
    throw new UnsupportedOperationException("DesktopTextSelectionToolbar_readBack_anchor read-back requires FFM/java22");
  }

  default int desktopTextSelectionToolbarButtonDesktopTextSelectionToolbarButton(Optional<Runnable> onPressed, Widget child) {
    throw new UnsupportedOperationException("desktopTextSelectionToolbarButtonDesktopTextSelectionToolbarButton has no default (FFM/comm impl required)");
  }
  default int desktopTextSelectionToolbarButtonText(BuildContext context, Optional<Runnable> onPressed, String text) {
    throw new UnsupportedOperationException("desktopTextSelectionToolbarButtonText has no default (FFM/comm impl required)");
  }
  default Widget DesktopTextSelectionToolbarButton_readBack_child(Object st) {
    throw new UnsupportedOperationException("DesktopTextSelectionToolbarButton_readBack_child read-back requires FFM/java22");
  }

  default int textSelectionToolbarTextButtonTextSelectionToolbarTextButton(Widget child, EdgeInsetsGeometry padding, Optional<Runnable> onPressed, Optional<AlignmentGeometry> alignment) {
    throw new UnsupportedOperationException("textSelectionToolbarTextButtonTextSelectionToolbarTextButton has no default (FFM/comm impl required)");
  }
  default int textSelectionToolbarTextButtonGetPadding(int index, int total) {
    throw new UnsupportedOperationException("textSelectionToolbarTextButtonGetPadding has no default (FFM/comm impl required)");
  }
  default Widget TextSelectionToolbarTextButton_readBack_child(Object st) {
    throw new UnsupportedOperationException("TextSelectionToolbarTextButton_readBack_child read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry TextSelectionToolbarTextButton_readBack_padding(Object st) {
    throw new UnsupportedOperationException("TextSelectionToolbarTextButton_readBack_padding read-back requires FFM/java22");
  }
  default AlignmentGeometry TextSelectionToolbarTextButton_readBack_alignment(Object st) {
    throw new UnsupportedOperationException("TextSelectionToolbarTextButton_readBack_alignment read-back requires FFM/java22");
  }

  default int refreshIndicatorRefreshIndicator(OptionalDouble displacement, OptionalDouble edgeOffset, Supplier<Future<Void>> onRefresh, Optional<Color> color, Optional<Color> backgroundColor, Optional<String> semanticsLabel, Optional<String> semanticsValue, OptionalDouble strokeWidth, Optional<RefreshIndicatorTriggerMode> triggerMode, OptionalDouble elevation, Widget child) {
    throw new UnsupportedOperationException("refreshIndicatorRefreshIndicator has no default (FFM/comm impl required)");
  }
  default int refreshIndicatorAdaptive(OptionalDouble displacement, OptionalDouble edgeOffset, Supplier<Future<Void>> onRefresh, Optional<Color> color, Optional<Color> backgroundColor, Optional<String> semanticsLabel, Optional<String> semanticsValue, OptionalDouble strokeWidth, Optional<RefreshIndicatorTriggerMode> triggerMode, OptionalDouble elevation, Widget child) {
    throw new UnsupportedOperationException("refreshIndicatorAdaptive has no default (FFM/comm impl required)");
  }
  default int refreshIndicatorNoSpinner(Supplier<Future<Void>> onRefresh, Optional<Consumer<RefreshIndicatorStatus>> onStatusChange, Optional<String> semanticsLabel, Optional<String> semanticsValue, Optional<RefreshIndicatorTriggerMode> triggerMode, OptionalDouble elevation, Widget child) {
    throw new UnsupportedOperationException("refreshIndicatorNoSpinner has no default (FFM/comm impl required)");
  }
  default Widget RefreshIndicator_readBack_child(Object st) {
    throw new UnsupportedOperationException("RefreshIndicator_readBack_child read-back requires FFM/java22");
  }
  default double RefreshIndicator_readBack_displacement(Object st) {
    throw new UnsupportedOperationException("RefreshIndicator_readBack_displacement read-back requires FFM/java22");
  }
  default double RefreshIndicator_readBack_edgeOffset(Object st) {
    throw new UnsupportedOperationException("RefreshIndicator_readBack_edgeOffset read-back requires FFM/java22");
  }
  default Color RefreshIndicator_readBack_color(Object st) {
    throw new UnsupportedOperationException("RefreshIndicator_readBack_color read-back requires FFM/java22");
  }
  default Color RefreshIndicator_readBack_backgroundColor(Object st) {
    throw new UnsupportedOperationException("RefreshIndicator_readBack_backgroundColor read-back requires FFM/java22");
  }
  default String RefreshIndicator_readBack_semanticsLabel(Object st) {
    throw new UnsupportedOperationException("RefreshIndicator_readBack_semanticsLabel read-back requires FFM/java22");
  }
  default String RefreshIndicator_readBack_semanticsValue(Object st) {
    throw new UnsupportedOperationException("RefreshIndicator_readBack_semanticsValue read-back requires FFM/java22");
  }
  default double RefreshIndicator_readBack_strokeWidth(Object st) {
    throw new UnsupportedOperationException("RefreshIndicator_readBack_strokeWidth read-back requires FFM/java22");
  }
  default RefreshIndicatorTriggerMode RefreshIndicator_readBack_triggerMode(Object st) {
    throw new UnsupportedOperationException("RefreshIndicator_readBack_triggerMode read-back requires FFM/java22");
  }
  default double RefreshIndicator_readBack_elevation(Object st) {
    throw new UnsupportedOperationException("RefreshIndicator_readBack_elevation read-back requires FFM/java22");
  }

  default int backButtonListenerBackButtonListener(Widget child, Supplier<Future<Boolean>> onBackButtonPressed) {
    throw new UnsupportedOperationException("backButtonListenerBackButtonListener has no default (FFM/comm impl required)");
  }
  default Widget BackButtonListener_readBack_child(Object st) {
    throw new UnsupportedOperationException("BackButtonListener_readBack_child read-back requires FFM/java22");
  }

  default int focusableActionDetectorFocusableActionDetector(Optional<Boolean> enabled, Optional<Boolean> autofocus, Optional<Boolean> descendantsAreFocusable, Optional<Boolean> descendantsAreTraversable, Optional<Consumer<Boolean>> onShowFocusHighlight, Optional<Consumer<Boolean>> onShowHoverHighlight, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> includeFocusSemantics, Widget child) {
    throw new UnsupportedOperationException("focusableActionDetectorFocusableActionDetector has no default (FFM/comm impl required)");
  }
  default boolean FocusableActionDetector_readBack_enabled(Object st) {
    throw new UnsupportedOperationException("FocusableActionDetector_readBack_enabled read-back requires FFM/java22");
  }
  default boolean FocusableActionDetector_readBack_autofocus(Object st) {
    throw new UnsupportedOperationException("FocusableActionDetector_readBack_autofocus read-back requires FFM/java22");
  }
  default boolean FocusableActionDetector_readBack_descendantsAreFocusable(Object st) {
    throw new UnsupportedOperationException("FocusableActionDetector_readBack_descendantsAreFocusable read-back requires FFM/java22");
  }
  default boolean FocusableActionDetector_readBack_descendantsAreTraversable(Object st) {
    throw new UnsupportedOperationException("FocusableActionDetector_readBack_descendantsAreTraversable read-back requires FFM/java22");
  }
  default boolean FocusableActionDetector_readBack_includeFocusSemantics(Object st) {
    throw new UnsupportedOperationException("FocusableActionDetector_readBack_includeFocusSemantics read-back requires FFM/java22");
  }
  default Widget FocusableActionDetector_readBack_child(Object st) {
    throw new UnsupportedOperationException("FocusableActionDetector_readBack_child read-back requires FFM/java22");
  }

  default Widget OverlayPortal_readBack_child(Object st) {
    throw new UnsupportedOperationException("OverlayPortal_readBack_child read-back requires FFM/java22");
  }
  default OverlayChildLocation OverlayPortal_readBack_overlayLocation(Object st) {
    throw new UnsupportedOperationException("OverlayPortal_readBack_overlayLocation read-back requires FFM/java22");
  }

  default int heroControllerScopeNone(Widget child) {
    throw new UnsupportedOperationException("heroControllerScopeNone has no default (FFM/comm impl required)");
  }

  default boolean CompositedTransformFollower_readBack_showWhenUnlinked(Object st) {
    throw new UnsupportedOperationException("CompositedTransformFollower_readBack_showWhenUnlinked read-back requires FFM/java22");
  }
  default Alignment CompositedTransformFollower_readBack_targetAnchor(Object st) {
    throw new UnsupportedOperationException("CompositedTransformFollower_readBack_targetAnchor read-back requires FFM/java22");
  }
  default Alignment CompositedTransformFollower_readBack_followerAnchor(Object st) {
    throw new UnsupportedOperationException("CompositedTransformFollower_readBack_followerAnchor read-back requires FFM/java22");
  }
  default Offset CompositedTransformFollower_readBack_offset(Object st) {
    throw new UnsupportedOperationException("CompositedTransformFollower_readBack_offset read-back requires FFM/java22");
  }

  default Widget RawMagnifier_readBack_child(Object st) {
    throw new UnsupportedOperationException("RawMagnifier_readBack_child read-back requires FFM/java22");
  }
  default Clip RawMagnifier_readBack_clipBehavior(Object st) {
    throw new UnsupportedOperationException("RawMagnifier_readBack_clipBehavior read-back requires FFM/java22");
  }
  default Offset RawMagnifier_readBack_focalPointOffset(Object st) {
    throw new UnsupportedOperationException("RawMagnifier_readBack_focalPointOffset read-back requires FFM/java22");
  }
  default double RawMagnifier_readBack_magnificationScale(Object st) {
    throw new UnsupportedOperationException("RawMagnifier_readBack_magnificationScale read-back requires FFM/java22");
  }

  default boolean KeyboardListener_readBack_autofocus(Object st) {
    throw new UnsupportedOperationException("KeyboardListener_readBack_autofocus read-back requires FFM/java22");
  }
  default boolean KeyboardListener_readBack_includeSemantics(Object st) {
    throw new UnsupportedOperationException("KeyboardListener_readBack_includeSemantics read-back requires FFM/java22");
  }
  default Widget KeyboardListener_readBack_child(Object st) {
    throw new UnsupportedOperationException("KeyboardListener_readBack_child read-back requires FFM/java22");
  }

  default int rawScrollbarRawScrollbar(Widget child, Optional<Boolean> thumbVisibility, Optional<OutlinedBorder> shape, Optional<Radius> radius, OptionalDouble thickness, Optional<Color> thumbColor, OptionalDouble minThumbLength, OptionalDouble minOverscrollLength, Optional<Boolean> trackVisibility, Optional<Radius> trackRadius, Optional<Color> trackColor, Optional<Color> trackBorderColor, Optional<Duration> fadeDuration, Optional<Duration> timeToFade, Optional<Duration> pressDuration, Optional<Boolean> interactive, Optional<ScrollbarOrientation> scrollbarOrientation, OptionalDouble mainAxisMargin, OptionalDouble crossAxisMargin, Optional<EdgeInsetsGeometry> padding) {
    throw new UnsupportedOperationException("rawScrollbarRawScrollbar has no default (FFM/comm impl required)");
  }
  default Widget RawScrollbar_readBack_child(Object st) {
    throw new UnsupportedOperationException("RawScrollbar_readBack_child read-back requires FFM/java22");
  }
  default boolean RawScrollbar_readBack_thumbVisibility(Object st) {
    throw new UnsupportedOperationException("RawScrollbar_readBack_thumbVisibility read-back requires FFM/java22");
  }
  default OutlinedBorder RawScrollbar_readBack_shape(Object st) {
    throw new UnsupportedOperationException("RawScrollbar_readBack_shape read-back requires FFM/java22");
  }
  default Radius RawScrollbar_readBack_radius(Object st) {
    throw new UnsupportedOperationException("RawScrollbar_readBack_radius read-back requires FFM/java22");
  }
  default double RawScrollbar_readBack_thickness(Object st) {
    throw new UnsupportedOperationException("RawScrollbar_readBack_thickness read-back requires FFM/java22");
  }
  default Color RawScrollbar_readBack_thumbColor(Object st) {
    throw new UnsupportedOperationException("RawScrollbar_readBack_thumbColor read-back requires FFM/java22");
  }
  default double RawScrollbar_readBack_minThumbLength(Object st) {
    throw new UnsupportedOperationException("RawScrollbar_readBack_minThumbLength read-back requires FFM/java22");
  }
  default double RawScrollbar_readBack_minOverscrollLength(Object st) {
    throw new UnsupportedOperationException("RawScrollbar_readBack_minOverscrollLength read-back requires FFM/java22");
  }
  default boolean RawScrollbar_readBack_trackVisibility(Object st) {
    throw new UnsupportedOperationException("RawScrollbar_readBack_trackVisibility read-back requires FFM/java22");
  }
  default Radius RawScrollbar_readBack_trackRadius(Object st) {
    throw new UnsupportedOperationException("RawScrollbar_readBack_trackRadius read-back requires FFM/java22");
  }
  default Color RawScrollbar_readBack_trackColor(Object st) {
    throw new UnsupportedOperationException("RawScrollbar_readBack_trackColor read-back requires FFM/java22");
  }
  default Color RawScrollbar_readBack_trackBorderColor(Object st) {
    throw new UnsupportedOperationException("RawScrollbar_readBack_trackBorderColor read-back requires FFM/java22");
  }
  default Duration RawScrollbar_readBack_fadeDuration(Object st) {
    throw new UnsupportedOperationException("RawScrollbar_readBack_fadeDuration read-back requires FFM/java22");
  }
  default Duration RawScrollbar_readBack_timeToFade(Object st) {
    throw new UnsupportedOperationException("RawScrollbar_readBack_timeToFade read-back requires FFM/java22");
  }
  default Duration RawScrollbar_readBack_pressDuration(Object st) {
    throw new UnsupportedOperationException("RawScrollbar_readBack_pressDuration read-back requires FFM/java22");
  }
  default boolean RawScrollbar_readBack_interactive(Object st) {
    throw new UnsupportedOperationException("RawScrollbar_readBack_interactive read-back requires FFM/java22");
  }
  default ScrollbarOrientation RawScrollbar_readBack_scrollbarOrientation(Object st) {
    throw new UnsupportedOperationException("RawScrollbar_readBack_scrollbarOrientation read-back requires FFM/java22");
  }
  default double RawScrollbar_readBack_mainAxisMargin(Object st) {
    throw new UnsupportedOperationException("RawScrollbar_readBack_mainAxisMargin read-back requires FFM/java22");
  }
  default double RawScrollbar_readBack_crossAxisMargin(Object st) {
    throw new UnsupportedOperationException("RawScrollbar_readBack_crossAxisMargin read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry RawScrollbar_readBack_padding(Object st) {
    throw new UnsupportedOperationException("RawScrollbar_readBack_padding read-back requires FFM/java22");
  }

  default int rawChipRawChip(Optional<ChipThemeData> defaultProperties, Optional<Widget> avatar, Widget label, Optional<TextStyle> labelStyle, Optional<EdgeInsetsGeometry> padding, Optional<VisualDensity> visualDensity, Optional<EdgeInsetsGeometry> labelPadding, Optional<Widget> deleteIcon, Optional<Runnable> onDeleted, Optional<Color> deleteIconColor, Optional<String> deleteButtonTooltipMessage, Optional<Runnable> onPressed, Optional<Consumer<Boolean>> onSelected, OptionalDouble pressElevation, Optional<Boolean> tapEnabled, Optional<Boolean> selected, Optional<Boolean> isEnabled, Optional<Color> disabledColor, Optional<Color> selectedColor, Optional<String> tooltip, Optional<BorderSide> side, Optional<OutlinedBorder> shape, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, Optional<Color> color, Optional<Color> backgroundColor, Optional<MaterialTapTargetSize> materialTapTargetSize, OptionalDouble elevation, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, Optional<IconThemeData> iconTheme, Optional<Color> selectedShadowColor, Optional<Boolean> showCheckmark, Optional<Color> checkmarkColor, Optional<ShapeBorder> avatarBorder, Optional<BoxConstraints> avatarBoxConstraints, Optional<BoxConstraints> deleteIconBoxConstraints) {
    throw new UnsupportedOperationException("rawChipRawChip has no default (FFM/comm impl required)");
  }
  default ChipThemeData RawChip_readBack_defaultProperties(Object st) {
    throw new UnsupportedOperationException("RawChip_readBack_defaultProperties read-back requires FFM/java22");
  }
  default Widget RawChip_readBack_avatar(Object st) {
    throw new UnsupportedOperationException("RawChip_readBack_avatar read-back requires FFM/java22");
  }
  default Widget RawChip_readBack_label(Object st) {
    throw new UnsupportedOperationException("RawChip_readBack_label read-back requires FFM/java22");
  }
  default TextStyle RawChip_readBack_labelStyle(Object st) {
    throw new UnsupportedOperationException("RawChip_readBack_labelStyle read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry RawChip_readBack_labelPadding(Object st) {
    throw new UnsupportedOperationException("RawChip_readBack_labelPadding read-back requires FFM/java22");
  }
  default Widget RawChip_readBack_deleteIcon(Object st) {
    throw new UnsupportedOperationException("RawChip_readBack_deleteIcon read-back requires FFM/java22");
  }
  default Color RawChip_readBack_deleteIconColor(Object st) {
    throw new UnsupportedOperationException("RawChip_readBack_deleteIconColor read-back requires FFM/java22");
  }
  default String RawChip_readBack_deleteButtonTooltipMessage(Object st) {
    throw new UnsupportedOperationException("RawChip_readBack_deleteButtonTooltipMessage read-back requires FFM/java22");
  }
  default double RawChip_readBack_pressElevation(Object st) {
    throw new UnsupportedOperationException("RawChip_readBack_pressElevation read-back requires FFM/java22");
  }
  default boolean RawChip_readBack_selected(Object st) {
    throw new UnsupportedOperationException("RawChip_readBack_selected read-back requires FFM/java22");
  }
  default boolean RawChip_readBack_isEnabled(Object st) {
    throw new UnsupportedOperationException("RawChip_readBack_isEnabled read-back requires FFM/java22");
  }
  default Color RawChip_readBack_disabledColor(Object st) {
    throw new UnsupportedOperationException("RawChip_readBack_disabledColor read-back requires FFM/java22");
  }
  default Color RawChip_readBack_selectedColor(Object st) {
    throw new UnsupportedOperationException("RawChip_readBack_selectedColor read-back requires FFM/java22");
  }
  default String RawChip_readBack_tooltip(Object st) {
    throw new UnsupportedOperationException("RawChip_readBack_tooltip read-back requires FFM/java22");
  }
  default BorderSide RawChip_readBack_side(Object st) {
    throw new UnsupportedOperationException("RawChip_readBack_side read-back requires FFM/java22");
  }
  default OutlinedBorder RawChip_readBack_shape(Object st) {
    throw new UnsupportedOperationException("RawChip_readBack_shape read-back requires FFM/java22");
  }
  default Clip RawChip_readBack_clipBehavior(Object st) {
    throw new UnsupportedOperationException("RawChip_readBack_clipBehavior read-back requires FFM/java22");
  }
  default boolean RawChip_readBack_autofocus(Object st) {
    throw new UnsupportedOperationException("RawChip_readBack_autofocus read-back requires FFM/java22");
  }
  default Color RawChip_readBack_backgroundColor(Object st) {
    throw new UnsupportedOperationException("RawChip_readBack_backgroundColor read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry RawChip_readBack_padding(Object st) {
    throw new UnsupportedOperationException("RawChip_readBack_padding read-back requires FFM/java22");
  }
  default VisualDensity RawChip_readBack_visualDensity(Object st) {
    throw new UnsupportedOperationException("RawChip_readBack_visualDensity read-back requires FFM/java22");
  }
  default MaterialTapTargetSize RawChip_readBack_materialTapTargetSize(Object st) {
    throw new UnsupportedOperationException("RawChip_readBack_materialTapTargetSize read-back requires FFM/java22");
  }
  default double RawChip_readBack_elevation(Object st) {
    throw new UnsupportedOperationException("RawChip_readBack_elevation read-back requires FFM/java22");
  }
  default Color RawChip_readBack_shadowColor(Object st) {
    throw new UnsupportedOperationException("RawChip_readBack_shadowColor read-back requires FFM/java22");
  }
  default Color RawChip_readBack_surfaceTintColor(Object st) {
    throw new UnsupportedOperationException("RawChip_readBack_surfaceTintColor read-back requires FFM/java22");
  }
  default IconThemeData RawChip_readBack_iconTheme(Object st) {
    throw new UnsupportedOperationException("RawChip_readBack_iconTheme read-back requires FFM/java22");
  }
  default Color RawChip_readBack_selectedShadowColor(Object st) {
    throw new UnsupportedOperationException("RawChip_readBack_selectedShadowColor read-back requires FFM/java22");
  }
  default boolean RawChip_readBack_showCheckmark(Object st) {
    throw new UnsupportedOperationException("RawChip_readBack_showCheckmark read-back requires FFM/java22");
  }
  default Color RawChip_readBack_checkmarkColor(Object st) {
    throw new UnsupportedOperationException("RawChip_readBack_checkmarkColor read-back requires FFM/java22");
  }
  default ShapeBorder RawChip_readBack_avatarBorder(Object st) {
    throw new UnsupportedOperationException("RawChip_readBack_avatarBorder read-back requires FFM/java22");
  }
  default BoxConstraints RawChip_readBack_avatarBoxConstraints(Object st) {
    throw new UnsupportedOperationException("RawChip_readBack_avatarBoxConstraints read-back requires FFM/java22");
  }
  default BoxConstraints RawChip_readBack_deleteIconBoxConstraints(Object st) {
    throw new UnsupportedOperationException("RawChip_readBack_deleteIconBoxConstraints read-back requires FFM/java22");
  }
  default boolean RawChip_readBack_tapEnabled(Object st) {
    throw new UnsupportedOperationException("RawChip_readBack_tapEnabled read-back requires FFM/java22");
  }

  default Axis SegmentedButton_readBack_direction(Object st) {
    throw new UnsupportedOperationException("SegmentedButton_readBack_direction read-back requires FFM/java22");
  }
  default boolean SegmentedButton_readBack_multiSelectionEnabled(Object st) {
    throw new UnsupportedOperationException("SegmentedButton_readBack_multiSelectionEnabled read-back requires FFM/java22");
  }
  default boolean SegmentedButton_readBack_emptySelectionAllowed(Object st) {
    throw new UnsupportedOperationException("SegmentedButton_readBack_emptySelectionAllowed read-back requires FFM/java22");
  }
  default EdgeInsets SegmentedButton_readBack_expandedInsets(Object st) {
    throw new UnsupportedOperationException("SegmentedButton_readBack_expandedInsets read-back requires FFM/java22");
  }
  default boolean SegmentedButton_readBack_showSelectedIcon(Object st) {
    throw new UnsupportedOperationException("SegmentedButton_readBack_showSelectedIcon read-back requires FFM/java22");
  }
  default Widget SegmentedButton_readBack_selectedIcon(Object st) {
    throw new UnsupportedOperationException("SegmentedButton_readBack_selectedIcon read-back requires FFM/java22");
  }

  default <T> int cupertinoRadioCupertinoRadio(NativeObj value, Optional<NativeObj> groupValue, Optional<Consumer<NativeObj>> onChanged, Optional<Boolean> toggleable, Optional<Color> activeColor, Optional<Color> inactiveColor, Optional<Color> fillColor, Optional<Color> focusColor, Optional<Boolean> autofocus, Optional<Boolean> useCheckmarkStyle, Optional<Boolean> enabled) {
    throw new UnsupportedOperationException("cupertinoRadioCupertinoRadio has no default (FFM/comm impl required)");
  }
  default boolean CupertinoRadio_readBack_toggleable(Object st) {
    throw new UnsupportedOperationException("CupertinoRadio_readBack_toggleable read-back requires FFM/java22");
  }
  default boolean CupertinoRadio_readBack_useCheckmarkStyle(Object st) {
    throw new UnsupportedOperationException("CupertinoRadio_readBack_useCheckmarkStyle read-back requires FFM/java22");
  }
  default Color CupertinoRadio_readBack_activeColor(Object st) {
    throw new UnsupportedOperationException("CupertinoRadio_readBack_activeColor read-back requires FFM/java22");
  }
  default Color CupertinoRadio_readBack_inactiveColor(Object st) {
    throw new UnsupportedOperationException("CupertinoRadio_readBack_inactiveColor read-back requires FFM/java22");
  }
  default Color CupertinoRadio_readBack_fillColor(Object st) {
    throw new UnsupportedOperationException("CupertinoRadio_readBack_fillColor read-back requires FFM/java22");
  }
  default Color CupertinoRadio_readBack_focusColor(Object st) {
    throw new UnsupportedOperationException("CupertinoRadio_readBack_focusColor read-back requires FFM/java22");
  }
  default boolean CupertinoRadio_readBack_autofocus(Object st) {
    throw new UnsupportedOperationException("CupertinoRadio_readBack_autofocus read-back requires FFM/java22");
  }
  default boolean CupertinoRadio_readBack_enabled(Object st) {
    throw new UnsupportedOperationException("CupertinoRadio_readBack_enabled read-back requires FFM/java22");
  }

  default int cupertinoTextFormFieldRowCupertinoTextFormFieldRow(Optional<Widget> prefix, Optional<EdgeInsetsGeometry> padding, Optional<String> initialValue, Optional<BoxDecoration> decoration, Optional<TextCapitalization> textCapitalization, Optional<TextInputAction> textInputAction, Optional<TextStyle> style, Optional<TextDirection> textDirection, Optional<TextAlign> textAlign, Optional<Boolean> autofocus, Optional<Boolean> readOnly, Optional<Boolean> showCursor, Optional<String> obscuringCharacter, Optional<Boolean> obscureText, Optional<Boolean> autocorrect, Optional<SmartDashesType> smartDashesType, Optional<SmartQuotesType> smartQuotesType, Optional<Boolean> enableSuggestions, OptionalInt maxLines, OptionalInt minLines, Optional<Boolean> expands, OptionalInt maxLength, Optional<Consumer<String>> onChanged, Optional<Runnable> onTap, Optional<Runnable> onEditingComplete, Optional<Consumer<String>> onFieldSubmitted, Optional<Consumer<String>> onSaved, Optional<Function<String, String>> validator, Optional<Boolean> enabled, OptionalDouble cursorWidth, OptionalDouble cursorHeight, Optional<Color> cursorColor, Optional<Brightness> keyboardAppearance, Optional<EdgeInsets> scrollPadding, Optional<Boolean> enableInteractiveSelection, Optional<List<String>> autofillHints, Optional<AutovalidateMode> autovalidateMode, Optional<String> placeholder, Optional<TextStyle> placeholderStyle, Optional<BoxHeightStyle> selectionHeightStyle, Optional<BoxWidthStyle> selectionWidthStyle, Optional<String> restorationId) {
    throw new UnsupportedOperationException("cupertinoTextFormFieldRowCupertinoTextFormFieldRow has no default (FFM/comm impl required)");
  }
  default Widget CupertinoTextFormFieldRow_readBack_prefix(Object st) {
    throw new UnsupportedOperationException("CupertinoTextFormFieldRow_readBack_prefix read-back requires FFM/java22");
  }
  default EdgeInsetsGeometry CupertinoTextFormFieldRow_readBack_padding(Object st) {
    throw new UnsupportedOperationException("CupertinoTextFormFieldRow_readBack_padding read-back requires FFM/java22");
  }

  default String FormField_readBack_forceErrorText(Object st) {
    throw new UnsupportedOperationException("FormField_readBack_forceErrorText read-back requires FFM/java22");
  }
  default boolean FormField_readBack_enabled(Object st) {
    throw new UnsupportedOperationException("FormField_readBack_enabled read-back requires FFM/java22");
  }
  default AutovalidateMode FormField_readBack_autovalidateMode(Object st) {
    throw new UnsupportedOperationException("FormField_readBack_autovalidateMode read-back requires FFM/java22");
  }
  default String FormField_readBack_restorationId(Object st) {
    throw new UnsupportedOperationException("FormField_readBack_restorationId read-back requires FFM/java22");
  }

  default SnapshotMode SnapshotWidget_readBack_mode(Object st) {
    throw new UnsupportedOperationException("SnapshotWidget_readBack_mode read-back requires FFM/java22");
  }
  default boolean SnapshotWidget_readBack_autoresize(Object st) {
    throw new UnsupportedOperationException("SnapshotWidget_readBack_autoresize read-back requires FFM/java22");
  }

  default AxisDirection ShrinkWrappingViewport_readBack_axisDirection(Object st) {
    throw new UnsupportedOperationException("ShrinkWrappingViewport_readBack_axisDirection read-back requires FFM/java22");
  }
  default AxisDirection ShrinkWrappingViewport_readBack_crossAxisDirection(Object st) {
    throw new UnsupportedOperationException("ShrinkWrappingViewport_readBack_crossAxisDirection read-back requires FFM/java22");
  }
  default SliverPaintOrder ShrinkWrappingViewport_readBack_paintOrder(Object st) {
    throw new UnsupportedOperationException("ShrinkWrappingViewport_readBack_paintOrder read-back requires FFM/java22");
  }
  default Clip ShrinkWrappingViewport_readBack_clipBehavior(Object st) {
    throw new UnsupportedOperationException("ShrinkWrappingViewport_readBack_clipBehavior read-back requires FFM/java22");
  }
  default double ShrinkWrappingViewport_readBack_cacheExtent(Object st) {
    throw new UnsupportedOperationException("ShrinkWrappingViewport_readBack_cacheExtent read-back requires FFM/java22");
  }
  default CacheExtentStyle ShrinkWrappingViewport_readBack_cacheExtentStyle(Object st) {
    throw new UnsupportedOperationException("ShrinkWrappingViewport_readBack_cacheExtentStyle read-back requires FFM/java22");
  }

  default AlignmentGeometry SizedOverflowBox_readBack_alignment(Object st) {
    throw new UnsupportedOperationException("SizedOverflowBox_readBack_alignment read-back requires FFM/java22");
  }

  default int cupertinoDynamicColorCupertinoDynamicColor(Optional<String> debugLabel, Color color, Color darkColor, Color highContrastColor, Color darkHighContrastColor, Color elevatedColor, Color darkElevatedColor, Color highContrastElevatedColor, Color darkHighContrastElevatedColor) {
    throw new UnsupportedOperationException("cupertinoDynamicColorCupertinoDynamicColor has no default (FFM/comm impl required)");
  }
  default int cupertinoDynamicColorWithBrightnessAndContrast(Optional<String> debugLabel, Color color, Color darkColor, Color highContrastColor, Color darkHighContrastColor) {
    throw new UnsupportedOperationException("cupertinoDynamicColorWithBrightnessAndContrast has no default (FFM/comm impl required)");
  }
  default int cupertinoDynamicColorWithBrightness(Optional<String> debugLabel, Color color, Color darkColor) {
    throw new UnsupportedOperationException("cupertinoDynamicColorWithBrightness has no default (FFM/comm impl required)");
  }
  default int cupertinoDynamicColorResolve(Color resolvable, BuildContext context) {
    throw new UnsupportedOperationException("cupertinoDynamicColorResolve has no default (FFM/comm impl required)");
  }
  default int cupertinoDynamicColorMaybeResolve(Color resolvable, BuildContext context) {
    throw new UnsupportedOperationException("cupertinoDynamicColorMaybeResolve has no default (FFM/comm impl required)");
  }
  default Color CupertinoDynamicColor_readBack_color(Object st) {
    throw new UnsupportedOperationException("CupertinoDynamicColor_readBack_color read-back requires FFM/java22");
  }
  default Color CupertinoDynamicColor_readBack_darkColor(Object st) {
    throw new UnsupportedOperationException("CupertinoDynamicColor_readBack_darkColor read-back requires FFM/java22");
  }
  default Color CupertinoDynamicColor_readBack_highContrastColor(Object st) {
    throw new UnsupportedOperationException("CupertinoDynamicColor_readBack_highContrastColor read-back requires FFM/java22");
  }
  default Color CupertinoDynamicColor_readBack_darkHighContrastColor(Object st) {
    throw new UnsupportedOperationException("CupertinoDynamicColor_readBack_darkHighContrastColor read-back requires FFM/java22");
  }
  default Color CupertinoDynamicColor_readBack_elevatedColor(Object st) {
    throw new UnsupportedOperationException("CupertinoDynamicColor_readBack_elevatedColor read-back requires FFM/java22");
  }
  default Color CupertinoDynamicColor_readBack_darkElevatedColor(Object st) {
    throw new UnsupportedOperationException("CupertinoDynamicColor_readBack_darkElevatedColor read-back requires FFM/java22");
  }
  default Color CupertinoDynamicColor_readBack_highContrastElevatedColor(Object st) {
    throw new UnsupportedOperationException("CupertinoDynamicColor_readBack_highContrastElevatedColor read-back requires FFM/java22");
  }
  default Color CupertinoDynamicColor_readBack_darkHighContrastElevatedColor(Object st) {
    throw new UnsupportedOperationException("CupertinoDynamicColor_readBack_darkHighContrastElevatedColor read-back requires FFM/java22");
  }

  default boolean RawKeyboardListener_readBack_autofocus(Object st) {
    throw new UnsupportedOperationException("RawKeyboardListener_readBack_autofocus read-back requires FFM/java22");
  }
  default boolean RawKeyboardListener_readBack_includeSemantics(Object st) {
    throw new UnsupportedOperationException("RawKeyboardListener_readBack_includeSemantics read-back requires FFM/java22");
  }
  default Widget RawKeyboardListener_readBack_child(Object st) {
    throw new UnsupportedOperationException("RawKeyboardListener_readBack_child read-back requires FFM/java22");
  }

  default int tableRowTableRow(Optional<Decoration> decoration, Optional<List<Widget>> children) {
    throw new UnsupportedOperationException("tableRowTableRow has no default (FFM/comm impl required)");
  }
  default Decoration TableRow_readBack_decoration(Object st) {
    throw new UnsupportedOperationException("TableRow_readBack_decoration read-back requires FFM/java22");
  }

  default Widget SelectionListener_readBack_child(Object st) {
    throw new UnsupportedOperationException("SelectionListener_readBack_child read-back requires FFM/java22");
  }

  default int cupertinoIconThemeDataCupertinoIconThemeData(OptionalDouble size, OptionalDouble fill, OptionalDouble weight, OptionalDouble grade, OptionalDouble opticalSize, Optional<Color> color, OptionalDouble opacity, Optional<List<Shadow>> shadows, Optional<Boolean> applyTextScaling) {
    throw new UnsupportedOperationException("cupertinoIconThemeDataCupertinoIconThemeData has no default (FFM/comm impl required)");
  }

  default int nestedScrollViewNestedScrollView(Optional<Axis> scrollDirection, Optional<Boolean> reverse, BiFunction<BuildContext, Boolean, List<Widget>> headerSliverBuilder, Widget body, Optional<DragStartBehavior> dragStartBehavior, Optional<Boolean> floatHeaderSlivers, Optional<Clip> clipBehavior, Optional<HitTestBehavior> hitTestBehavior, Optional<String> restorationId) {
    throw new UnsupportedOperationException("nestedScrollViewNestedScrollView has no default (FFM/comm impl required)");
  }
  default Axis NestedScrollView_readBack_scrollDirection(Object st) {
    throw new UnsupportedOperationException("NestedScrollView_readBack_scrollDirection read-back requires FFM/java22");
  }
  default boolean NestedScrollView_readBack_reverse(Object st) {
    throw new UnsupportedOperationException("NestedScrollView_readBack_reverse read-back requires FFM/java22");
  }
  default Widget NestedScrollView_readBack_body(Object st) {
    throw new UnsupportedOperationException("NestedScrollView_readBack_body read-back requires FFM/java22");
  }
  default DragStartBehavior NestedScrollView_readBack_dragStartBehavior(Object st) {
    throw new UnsupportedOperationException("NestedScrollView_readBack_dragStartBehavior read-back requires FFM/java22");
  }
  default boolean NestedScrollView_readBack_floatHeaderSlivers(Object st) {
    throw new UnsupportedOperationException("NestedScrollView_readBack_floatHeaderSlivers read-back requires FFM/java22");
  }
  default Clip NestedScrollView_readBack_clipBehavior(Object st) {
    throw new UnsupportedOperationException("NestedScrollView_readBack_clipBehavior read-back requires FFM/java22");
  }
  default HitTestBehavior NestedScrollView_readBack_hitTestBehavior(Object st) {
    throw new UnsupportedOperationException("NestedScrollView_readBack_hitTestBehavior read-back requires FFM/java22");
  }
  default String NestedScrollView_readBack_restorationId(Object st) {
    throw new UnsupportedOperationException("NestedScrollView_readBack_restorationId read-back requires FFM/java22");
  }

  default <T extends StatefulWidget> int subStateSubState(Runnable initStateFn, Consumer<NativeObj> didUpdateWidgetFn, Runnable reassembleFn, Runnable deactivateFn, Runnable activateFn, Runnable disposeFn, Function<BuildContext, Widget> buildFn, Runnable didChangeDependenciesFn) {
    throw new UnsupportedOperationException("subStateSubState has no default (FFM/comm impl required)");
  }
  default BuildContext SubState_readBack_context(Object st) {
    throw new UnsupportedOperationException("SubState_readBack_context read-back requires FFM/java22");
  }
  default boolean SubState_readBack_mounted(Object st) {
    throw new UnsupportedOperationException("SubState_readBack_mounted read-back requires FFM/java22");
  }

  default int subStatefulWidgetSubStatefulWidget(Supplier<State> createStateFn) {
    throw new UnsupportedOperationException("subStatefulWidgetSubStatefulWidget has no default (FFM/comm impl required)");
  }

  default int subStatelessWidgetSubStatelessWidget(Function<BuildContext, Widget> buildFn) {
    throw new UnsupportedOperationException("subStatelessWidgetSubStatelessWidget has no default (FFM/comm impl required)");
  }

  default <T extends StatefulWidget> int subAnimatedStateSubAnimatedState(Runnable initStateFn, Consumer<NativeObj> didUpdateWidgetFn, Runnable reassembleFn, Runnable deactivateFn, Runnable activateFn, Runnable disposeFn, Function<BuildContext, Widget> buildFn, Runnable didChangeDependenciesFn) {
    throw new UnsupportedOperationException("subAnimatedStateSubAnimatedState has no default (FFM/comm impl required)");
  }
  default int subAnimatedStateAnimationController(SubAnimatedState self, Duration duration) {
    throw new UnsupportedOperationException("subAnimatedStateAnimationController has no default (FFM/comm impl required)");
  }
  default BuildContext SubAnimatedState_readBack_context(Object st) {
    throw new UnsupportedOperationException("SubAnimatedState_readBack_context read-back requires FFM/java22");
  }
  default boolean SubAnimatedState_readBack_mounted(Object st) {
    throw new UnsupportedOperationException("SubAnimatedState_readBack_mounted read-back requires FFM/java22");
  }

  default int offsetTween(Offset begin, Offset end, Animation parent) {
    throw new UnsupportedOperationException("offsetTween has no default (FFM/comm impl required)");
  }
  default void subStateSetState(int id, Runnable fn) {
    throw new UnsupportedOperationException("state read-back requires FFM (java22)");
  }
  default int subStateWidget(int id) {
    throw new UnsupportedOperationException("state read-back requires FFM (java22)");
  }
  default void subAnimatedStateSetState(int id, Runnable fn) {
    throw new UnsupportedOperationException("state read-back requires FFM (java22)");
  }
  default int subAnimatedStateWidget(int id) {
    throw new UnsupportedOperationException("state read-back requires FFM (java22)");
  }
}
