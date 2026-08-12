part of 'factories.dart';
void _setupTopFunctions(WidgetFactories f) {
  f.showDialog = ffi.Pointer.fromFunction(dialogShowDialog, exception);
  f.showDatePicker = ffi.Pointer.fromFunction(date_pickerShowDatePicker, exception);
  f.showTimePicker = ffi.Pointer.fromFunction(time_pickerShowTimePicker, exception);
  f.showDateRangePicker = ffi.Pointer.fromFunction(date_pickerShowDateRangePicker, exception);
}
int dialogShowDialog(DartDartObj context, WidgetBuilderFFI builder, ffi.Pointer<ffi.Int> barrierDismissible, ffi.Pointer<DartObj> barrierColor, ffi.Pointer<ffi.Char> barrierLabel, ffi.Pointer<ffi.Int> useSafeArea, ffi.Pointer<ffi.Int> useRootNavigator, ffi.Pointer<DartObj> anchorPoint, ffi.Pointer<ffi.Int> traversalEdgeBehavior, ffi.Pointer<ffi.Int> fullscreenDialog, ffi.Pointer<ffi.Int> requestFocus) {
  final w = showDialog(context: _widgetsMap[context]! as BuildContext,
      builder: builder.toWidgetBuilderFn(),
      barrierDismissible: barrierDismissible.boolOr(true),
      barrierColor: barrierColor.objOrNul(),
      barrierLabel: barrierLabel.strOrNul(),
      useSafeArea: useSafeArea.boolOr(true),
      useRootNavigator: useRootNavigator.boolOr(true),
      anchorPoint: anchorPoint.objOrNul(),
      traversalEdgeBehavior: traversalEdgeBehavior.enumOrNul(TraversalEdgeBehavior.values),
      fullscreenDialog: fullscreenDialog.boolOr(false),
      requestFocus: requestFocus.boolOrNul());
  return _addWidget(w);
}
int date_pickerShowDatePicker(DartDartObj context, ffi.Pointer<DartObj> initialDate, DartDartObj firstDate, DartDartObj lastDate, ffi.Pointer<DartObj> currentDate, ffi.Pointer<ffi.Int> initialEntryMode, ffi.Pointer<SelectableDayPredicateFFI> selectableDayPredicate, ffi.Pointer<ffi.Char> helpText, ffi.Pointer<ffi.Char> cancelText, ffi.Pointer<ffi.Char> confirmText, ffi.Pointer<ffi.Int> barrierDismissible, ffi.Pointer<DartObj> barrierColor, ffi.Pointer<ffi.Char> barrierLabel, ffi.Pointer<ffi.Int> useRootNavigator, ffi.Pointer<ffi.Int> textDirection, ffi.Pointer<TransitionBuilderFFI> builder, ffi.Pointer<ffi.Int> initialDatePickerMode, ffi.Pointer<ffi.Char> errorFormatText, ffi.Pointer<ffi.Char> errorInvalidText, ffi.Pointer<ffi.Char> fieldHintText, ffi.Pointer<ffi.Char> fieldLabelText, ffi.Pointer<DartObj> anchorPoint, ffi.Pointer<ValueChangedForDatePickerEntryModeFFI> onDatePickerModeChange, ffi.Pointer<DartObj> switchToInputEntryModeIcon, ffi.Pointer<DartObj> switchToCalendarEntryModeIcon) {
  final w = showDatePicker(context: _widgetsMap[context]! as BuildContext,
      initialDate: initialDate.objOrNul(),
      firstDate: _widgetsMap[firstDate]! as DateTime,
      lastDate: _widgetsMap[lastDate]! as DateTime,
      currentDate: currentDate.objOrNul(),
      initialEntryMode: initialEntryMode.enumOr(DatePickerEntryMode.values, DatePickerEntryMode.calendar),
      selectableDayPredicate: selectableDayPredicate.toSelectableDayPredicateFn(),
      helpText: helpText.strOrNul(),
      cancelText: cancelText.strOrNul(),
      confirmText: confirmText.strOrNul(),
      barrierDismissible: barrierDismissible.boolOr(true),
      barrierColor: barrierColor.objOrNul(),
      barrierLabel: barrierLabel.strOrNul(),
      useRootNavigator: useRootNavigator.boolOr(true),
      textDirection: textDirection.enumOrNul(TextDirection.values),
      builder: builder.toTransitionBuilderFn(),
      initialDatePickerMode: initialDatePickerMode.enumOr(DatePickerMode.values, DatePickerMode.day),
      errorFormatText: errorFormatText.strOrNul(),
      errorInvalidText: errorInvalidText.strOrNul(),
      fieldHintText: fieldHintText.strOrNul(),
      fieldLabelText: fieldLabelText.strOrNul(),
      anchorPoint: anchorPoint.objOrNul(),
      onDatePickerModeChange: onDatePickerModeChange.toValueChangedForDatePickerEntryModeFn(),
      switchToInputEntryModeIcon: switchToInputEntryModeIcon.objOrNul(),
      switchToCalendarEntryModeIcon: switchToCalendarEntryModeIcon.objOrNul());
  return _addWidget(w);
}
int time_pickerShowTimePicker(DartDartObj context, DartDartObj initialTime, ffi.Pointer<TransitionBuilderFFI> builder, ffi.Pointer<ffi.Int> barrierDismissible, ffi.Pointer<DartObj> barrierColor, ffi.Pointer<ffi.Char> barrierLabel, ffi.Pointer<ffi.Int> useRootNavigator, ffi.Pointer<ffi.Int> initialEntryMode, ffi.Pointer<ffi.Char> cancelText, ffi.Pointer<ffi.Char> confirmText, ffi.Pointer<ffi.Char> helpText, ffi.Pointer<ffi.Char> errorInvalidText, ffi.Pointer<ffi.Char> hourLabelText, ffi.Pointer<ffi.Char> minuteLabelText, ffi.Pointer<EntryModeChangeCallbackFFI> onEntryModeChanged, ffi.Pointer<DartObj> anchorPoint, ffi.Pointer<ffi.Int> orientation, ffi.Pointer<DartObj> switchToInputEntryModeIcon, ffi.Pointer<DartObj> switchToTimerEntryModeIcon) {
  final w = showTimePicker(context: _widgetsMap[context]! as BuildContext,
      initialTime: _widgetsMap[initialTime]! as TimeOfDay,
      builder: builder.toTransitionBuilderFn(),
      barrierDismissible: barrierDismissible.boolOr(true),
      barrierColor: barrierColor.objOrNul(),
      barrierLabel: barrierLabel.strOrNul(),
      useRootNavigator: useRootNavigator.boolOr(true),
      initialEntryMode: initialEntryMode.enumOr(TimePickerEntryMode.values, TimePickerEntryMode.dial),
      cancelText: cancelText.strOrNul(),
      confirmText: confirmText.strOrNul(),
      helpText: helpText.strOrNul(),
      errorInvalidText: errorInvalidText.strOrNul(),
      hourLabelText: hourLabelText.strOrNul(),
      minuteLabelText: minuteLabelText.strOrNul(),
      onEntryModeChanged: onEntryModeChanged.toEntryModeChangeCallbackFn(),
      anchorPoint: anchorPoint.objOrNul(),
      orientation: orientation.enumOrNul(Orientation.values),
      switchToInputEntryModeIcon: switchToInputEntryModeIcon.objOrNul(),
      switchToTimerEntryModeIcon: switchToTimerEntryModeIcon.objOrNul());
  return _addWidget(w);
}
int date_pickerShowDateRangePicker(DartDartObj context, DartDartObj firstDate, DartDartObj lastDate, ffi.Pointer<DartObj> currentDate, ffi.Pointer<ffi.Int> initialEntryMode, ffi.Pointer<ffi.Char> helpText, ffi.Pointer<ffi.Char> cancelText, ffi.Pointer<ffi.Char> confirmText, ffi.Pointer<ffi.Char> saveText, ffi.Pointer<ffi.Char> errorFormatText, ffi.Pointer<ffi.Char> errorInvalidText, ffi.Pointer<ffi.Char> errorInvalidRangeText, ffi.Pointer<ffi.Char> fieldStartHintText, ffi.Pointer<ffi.Char> fieldEndHintText, ffi.Pointer<ffi.Char> fieldStartLabelText, ffi.Pointer<ffi.Char> fieldEndLabelText, ffi.Pointer<ffi.Int> barrierDismissible, ffi.Pointer<DartObj> barrierColor, ffi.Pointer<ffi.Char> barrierLabel, ffi.Pointer<ffi.Int> useRootNavigator, ffi.Pointer<ffi.Int> textDirection, ffi.Pointer<TransitionBuilderFFI> builder, ffi.Pointer<DartObj> anchorPoint, ffi.Pointer<DartObj> switchToInputEntryModeIcon, ffi.Pointer<DartObj> switchToCalendarEntryModeIcon, ffi.Pointer<SelectableDayForRangePredicateFFI> selectableDayPredicate) {
  final w = showDateRangePicker(context: _widgetsMap[context]! as BuildContext,
      firstDate: _widgetsMap[firstDate]! as DateTime,
      lastDate: _widgetsMap[lastDate]! as DateTime,
      currentDate: currentDate.objOrNul(),
      initialEntryMode: initialEntryMode.enumOr(DatePickerEntryMode.values, DatePickerEntryMode.calendar),
      helpText: helpText.strOrNul(),
      cancelText: cancelText.strOrNul(),
      confirmText: confirmText.strOrNul(),
      saveText: saveText.strOrNul(),
      errorFormatText: errorFormatText.strOrNul(),
      errorInvalidText: errorInvalidText.strOrNul(),
      errorInvalidRangeText: errorInvalidRangeText.strOrNul(),
      fieldStartHintText: fieldStartHintText.strOrNul(),
      fieldEndHintText: fieldEndHintText.strOrNul(),
      fieldStartLabelText: fieldStartLabelText.strOrNul(),
      fieldEndLabelText: fieldEndLabelText.strOrNul(),
      barrierDismissible: barrierDismissible.boolOr(true),
      barrierColor: barrierColor.objOrNul(),
      barrierLabel: barrierLabel.strOrNul(),
      useRootNavigator: useRootNavigator.boolOr(true),
      textDirection: textDirection.enumOrNul(TextDirection.values),
      builder: builder.toTransitionBuilderFn(),
      anchorPoint: anchorPoint.objOrNul(),
      switchToInputEntryModeIcon: switchToInputEntryModeIcon.objOrNul(),
      switchToCalendarEntryModeIcon: switchToCalendarEntryModeIcon.objOrNul(),
      selectableDayPredicate: selectableDayPredicate.toSelectableDayForRangePredicateFn());
  return _addWidget(w);
}
void _setupTextStyle(WidgetFactories f) {
  f.textStyle.textStyle = ffi.Pointer.fromFunction(textStyleTextStyle);
  f.textStyle.lerp = ffi.Pointer.fromFunction(textStyleLerp);
}
TextStyleObjSt textStyleTextStyle(ffi.Pointer<ffi.Int> inherit, ffi.Pointer<DartObj> color, ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<ffi.Double> fontSize, ffi.Pointer<DartObj> fontWeight, ffi.Pointer<ffi.Int> fontStyle, ffi.Pointer<ffi.Double> letterSpacing, ffi.Pointer<ffi.Double> wordSpacing, ffi.Pointer<ffi.Int> textBaseline, ffi.Pointer<ffi.Double> height, ffi.Pointer<ffi.Int> leadingDistribution, ffi.Pointer<ArrayC> shadows, ffi.Pointer<DartObj> decoration, ffi.Pointer<DartObj> decorationColor, ffi.Pointer<ffi.Int> decorationStyle, ffi.Pointer<ffi.Double> decorationThickness, ffi.Pointer<ffi.Char> debugLabel, ffi.Pointer<ffi.Char> fontFamily, ffi.Pointer<ffi.Pointer<ffi.Pointer<ffi.Char>>> fontFamilyFallback, ffi.Pointer<ffi.Char> package, ffi.Pointer<ffi.Int> overflow) {
  final w = TextStyle(inherit: inherit.boolOr(true),
      color: color.objOrNul(),
      backgroundColor: backgroundColor.objOrNul(),
      fontSize: fontSize.doubleOrNul(),
      fontWeight: fontWeight.objOrNul(),
      fontStyle: fontStyle.enumOrNul(FontStyle.values),
      letterSpacing: letterSpacing.doubleOrNul(),
      wordSpacing: wordSpacing.doubleOrNul(),
      textBaseline: textBaseline.enumOrNul(TextBaseline.values),
      height: height.doubleOrNul(),
      leadingDistribution: leadingDistribution.enumOrNul(TextLeadingDistribution.values),
      shadows: shadows.listOrNul(),
      decoration: decoration.objOrNul(),
      decorationColor: decorationColor.objOrNul(),
      decorationStyle: decorationStyle.enumOrNul(TextDecorationStyle.values),
      decorationThickness: decorationThickness.doubleOrNul(),
      debugLabel: debugLabel.strOrNul(),
      fontFamily: fontFamily.strOrNul(),
      fontFamilyFallback: fontFamilyFallback.listOrNul(),
      package: package.strOrNul(),
      overflow: overflow.enumOrNul(TextOverflow.values));
  return _createTextStyleObjSt(w);
}
TextStyleObjSt textStyleLerp(DartDartObj a, DartDartObj b, double t) {
  final w = TextStyle.lerp(_widgetsMap[a]! as TextStyle?,
      _widgetsMap[b]! as TextStyle?,
      t);
  return _createTextStyleObjSt(w);
}
TextStyleObjSt _createTextStyleObjSt(TextStyle? w) {
  final TextStyleObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.inherit = w.inherit.toInt();
  stObj.color = _addWidget(w.color);
  stObj.backgroundColor = _addWidget(w.backgroundColor);
  stObj.fontFamily = (w.fontFamily != null) ? w.fontFamily!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.fontSize = (w.fontSize != null) ? w.fontSize! : 0;
  stObj.fontWeight = _addWidget(w.fontWeight);
  stObj.fontStyle = (w.fontStyle != null) ? w.fontStyle!.index : 0;
  stObj.letterSpacing = (w.letterSpacing != null) ? w.letterSpacing! : 0;
  stObj.wordSpacing = (w.wordSpacing != null) ? w.wordSpacing! : 0;
  stObj.textBaseline = (w.textBaseline != null) ? w.textBaseline!.index : 0;
  stObj.height = (w.height != null) ? w.height! : 0;
  stObj.leadingDistribution = (w.leadingDistribution != null) ? w.leadingDistribution!.index : 0;
  stObj.decoration = _addWidget(w.decoration);
  stObj.decorationColor = _addWidget(w.decorationColor);
  stObj.decorationStyle = (w.decorationStyle != null) ? w.decorationStyle!.index : 0;
  stObj.decorationThickness = (w.decorationThickness != null) ? w.decorationThickness! : 0;
  stObj.debugLabel = (w.debugLabel != null) ? w.debugLabel!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.overflow = (w.overflow != null) ? w.overflow!.index : 0;
  return stObj;
}

void _setupColor(WidgetFactories f) {
  f.color.color = ffi.Pointer.fromFunction(colorColor, exception);
  f.color.from = ffi.Pointer.fromFunction(colorFrom, exception);
  f.color.fromARGB = ffi.Pointer.fromFunction(colorFromARGB, exception);
  f.color.fromRGBO = ffi.Pointer.fromFunction(colorFromRGBO, exception);
  f.color.lerp = ffi.Pointer.fromFunction(colorLerp, exception);
  f.color.alphaBlend = ffi.Pointer.fromFunction(colorAlphaBlend, exception);
  f.color.getAlphaFromOpacity = ffi.Pointer.fromFunction(colorGetAlphaFromOpacity, exception);
}
int colorColor(int value) {
  final w = Color(value);
  return _addWidget(w);
}
int colorFrom(double alpha, double red, double green, double blue, ffi.Pointer<ffi.Int> colorSpace) {
  final w = Color.from(alpha: alpha,
      red: red,
      green: green,
      blue: blue,
      colorSpace: colorSpace.enumOr(ColorSpace.values, ColorSpace.sRGB));
  return _addWidget(w);
}
int colorFromARGB(int a, int r, int g, int b) {
  final w = Color.fromARGB(a,
      r,
      g,
      b);
  return _addWidget(w);
}
int colorFromRGBO(int r, int g, int b, double opacity) {
  final w = Color.fromRGBO(r,
      g,
      b,
      opacity);
  return _addWidget(w);
}
int colorLerp(DartDartObj x, DartDartObj y, double t) {
  final w = Color.lerp(_widgetsMap[x]! as Color?,
      _widgetsMap[y]! as Color?,
      t);
  return _addWidget(w);
}
int colorAlphaBlend(DartDartObj foreground, DartDartObj background) {
  final w = Color.alphaBlend(_widgetsMap[foreground]! as Color,
      _widgetsMap[background]! as Color);
  return _addWidget(w);
}
int colorGetAlphaFromOpacity(double opacity) {
  final w = Color.getAlphaFromOpacity(opacity);
  return w;
}

void _setupOffset(WidgetFactories f) {
  f.offset.offset = ffi.Pointer.fromFunction(offsetOffset, exception);
  f.offset.fromDirection = ffi.Pointer.fromFunction(offsetFromDirection, exception);
  f.offset.lerp = ffi.Pointer.fromFunction(offsetLerp, exception);
  f.offset.dx = ffi.Pointer.fromFunction(offsetDx, exceptionDouble);
  f.offset.dy = ffi.Pointer.fromFunction(offsetDy, exceptionDouble);
}
int offsetOffset(double dx, double dy) {
  final w = Offset(dx,
      dy);
  return _addWidget(w);
}
int offsetFromDirection(double direction, ffi.Pointer<ffi.Double> distance) {
  final w = Offset.fromDirection(direction,
      distance.doubleOr(1.0));
  return _addWidget(w);
}
int offsetLerp(DartDartObj a, DartDartObj b, double t) {
  final w = Offset.lerp(_widgetsMap[a]! as Offset?,
      _widgetsMap[b]! as Offset?,
      t);
  return _addWidget(w);
}
double offsetDx(DartDartObj self) {
  final w = OffsetMethods.dx(_widgetsMap[self]! as Offset);
  return w;
}
double offsetDy(DartDartObj self) {
  final w = OffsetMethods.dy(_widgetsMap[self]! as Offset);
  return w;
}

void _setupDateTime(WidgetFactories f) {
  f.dateTime.dateTime = ffi.Pointer.fromFunction(dateTimeDateTime, exception);
  f.dateTime.utc = ffi.Pointer.fromFunction(dateTimeUtc, exception);
  f.dateTime.now = ffi.Pointer.fromFunction(dateTimeNow, exception);
  f.dateTime.timestamp = ffi.Pointer.fromFunction(dateTimeTimestamp, exception);
  f.dateTime.fromMillisecondsSinceEpoch = ffi.Pointer.fromFunction(dateTimeFromMillisecondsSinceEpoch, exception);
  f.dateTime.fromMicrosecondsSinceEpoch = ffi.Pointer.fromFunction(dateTimeFromMicrosecondsSinceEpoch, exception);
  f.dateTime.parse = ffi.Pointer.fromFunction(dateTimeParse, exception);
  f.dateTime.tryParse = ffi.Pointer.fromFunction(dateTimeTryParse, exception);
}
int dateTimeDateTime(int year, ffi.Pointer<ffi.Int> month, ffi.Pointer<ffi.Int> day, ffi.Pointer<ffi.Int> hour, ffi.Pointer<ffi.Int> minute, ffi.Pointer<ffi.Int> second, ffi.Pointer<ffi.Int> millisecond, ffi.Pointer<ffi.Int> microsecond) {
  final w = DateTime(year,
      month.intOr(1),
      day.intOr(1),
      hour.intOr(0),
      minute.intOr(0),
      second.intOr(0),
      millisecond.intOr(0),
      microsecond.intOr(0));
  return _addWidget(w);
}
int dateTimeUtc(int year, ffi.Pointer<ffi.Int> month, ffi.Pointer<ffi.Int> day, ffi.Pointer<ffi.Int> hour, ffi.Pointer<ffi.Int> minute, ffi.Pointer<ffi.Int> second, ffi.Pointer<ffi.Int> millisecond, ffi.Pointer<ffi.Int> microsecond) {
  final w = DateTime.utc(year,
      month.intOr(1),
      day.intOr(1),
      hour.intOr(0),
      minute.intOr(0),
      second.intOr(0),
      millisecond.intOr(0),
      microsecond.intOr(0));
  return _addWidget(w);
}
int dateTimeNow() {
  final w = DateTime.now();
  return _addWidget(w);
}
int dateTimeTimestamp() {
  final w = DateTime.timestamp();
  return _addWidget(w);
}
int dateTimeFromMillisecondsSinceEpoch(int millisecondsSinceEpoch, ffi.Pointer<ffi.Int> isUtc) {
  final w = DateTime.fromMillisecondsSinceEpoch(millisecondsSinceEpoch,
      isUtc: isUtc.boolOr(false));
  return _addWidget(w);
}
int dateTimeFromMicrosecondsSinceEpoch(int microsecondsSinceEpoch, ffi.Pointer<ffi.Int> isUtc) {
  final w = DateTime.fromMicrosecondsSinceEpoch(microsecondsSinceEpoch,
      isUtc: isUtc.boolOr(false));
  return _addWidget(w);
}
int dateTimeParse(ffi.Pointer<ffi.Char> formattedString) {
  final w = DateTime.parse(formattedString.cast<Utf8>().toDartString());
  return _addWidget(w);
}
int dateTimeTryParse(ffi.Pointer<ffi.Char> formattedString) {
  final w = DateTime.tryParse(formattedString.cast<Utf8>().toDartString());
  return _addWidget(w);
}

void _setupIcon(WidgetFactories f) {
  f.icon.icon = ffi.Pointer.fromFunction(iconIcon);
}
IconObjSt iconIcon(DartDartObj icon, ffi.Pointer<ffi.Double> size, ffi.Pointer<ffi.Double> fill, ffi.Pointer<ffi.Double> weight, ffi.Pointer<ffi.Double> grade, ffi.Pointer<ffi.Double> opticalSize, ffi.Pointer<DartObj> color, ffi.Pointer<ArrayC> shadows, ffi.Pointer<ffi.Char> semanticLabel, ffi.Pointer<ffi.Int> textDirection, ffi.Pointer<ffi.Int> applyTextScaling, ffi.Pointer<ffi.Int> blendMode, ffi.Pointer<DartObj> fontWeight) {
  final w = Icon(_widgetsMap[icon]! as IconData?,
      size: size.doubleOrNul(),
      fill: fill.doubleOrNul(),
      weight: weight.doubleOrNul(),
      grade: grade.doubleOrNul(),
      opticalSize: opticalSize.doubleOrNul(),
      color: color.objOrNul(),
      shadows: shadows.listOrNul(),
      semanticLabel: semanticLabel.strOrNul(),
      textDirection: textDirection.enumOrNul(TextDirection.values),
      applyTextScaling: applyTextScaling.boolOrNul(),
      blendMode: blendMode.enumOrNul(BlendMode.values),
      fontWeight: fontWeight.objOrNul());
  return _createIconObjSt(w);
}
IconObjSt _createIconObjSt(Icon? w) {
  final IconObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.icon = _createIconDataObjSt(w.icon);
  stObj.size = (w.size != null) ? w.size! : 0;
  stObj.fill = (w.fill != null) ? w.fill! : 0;
  stObj.weight = (w.weight != null) ? w.weight! : 0;
  stObj.grade = (w.grade != null) ? w.grade! : 0;
  stObj.opticalSize = (w.opticalSize != null) ? w.opticalSize! : 0;
  stObj.color = _addWidget(w.color);
  stObj.semanticLabel = (w.semanticLabel != null) ? w.semanticLabel!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.textDirection = (w.textDirection != null) ? w.textDirection!.index : 0;
  stObj.applyTextScaling = (w.applyTextScaling != null) ? w.applyTextScaling!.toInt() : 0;
  stObj.blendMode = (w.blendMode != null) ? w.blendMode!.index : 0;
  stObj.fontWeight = _addWidget(w.fontWeight);
  return stObj;
}

void _setupTimeOfDay(WidgetFactories f) {
  f.timeOfDay.timeOfDay = ffi.Pointer.fromFunction(timeOfDayTimeOfDay);
  f.timeOfDay.fromDateTime = ffi.Pointer.fromFunction(timeOfDayFromDateTime);
  f.timeOfDay.now = ffi.Pointer.fromFunction(timeOfDayNow);
}
TimeOfDayObjSt timeOfDayTimeOfDay(int hour, int minute) {
  final w = TimeOfDay(hour: hour,
      minute: minute);
  return _createTimeOfDayObjSt(w);
}
TimeOfDayObjSt timeOfDayFromDateTime(DartDartObj time) {
  final w = TimeOfDay.fromDateTime(_widgetsMap[time]! as DateTime);
  return _createTimeOfDayObjSt(w);
}
TimeOfDayObjSt timeOfDayNow() {
  final w = TimeOfDay.now();
  return _createTimeOfDayObjSt(w);
}
TimeOfDayObjSt _createTimeOfDayObjSt(TimeOfDay? w) {
  final TimeOfDayObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.hour = w.hour;
  stObj.minute = w.minute;
  stObj.period = w.period.index;
  stObj.hourOfPeriod = w.hourOfPeriod;
  stObj.periodOffset = w.periodOffset;
  return stObj;
}

void _setupFontWeight(WidgetFactories f) {
  f.fontWeight.lerp = ffi.Pointer.fromFunction(fontWeightLerp, exception);
  f.fontWeight.w100 = _addWidget(FontWeight.w100);
  f.fontWeight.w200 = _addWidget(FontWeight.w200);
  f.fontWeight.w300 = _addWidget(FontWeight.w300);
  f.fontWeight.w400 = _addWidget(FontWeight.w400);
  f.fontWeight.w500 = _addWidget(FontWeight.w500);
  f.fontWeight.w600 = _addWidget(FontWeight.w600);
  f.fontWeight.w700 = _addWidget(FontWeight.w700);
  f.fontWeight.w800 = _addWidget(FontWeight.w800);
  f.fontWeight.w900 = _addWidget(FontWeight.w900);
}
int fontWeightLerp(DartDartObj a, DartDartObj b, double t) {
  final w = FontWeight.lerp(_widgetsMap[a]! as FontWeight?,
      _widgetsMap[b]! as FontWeight?,
      t);
  return _addWidget(w);
}

void _setupShadow(WidgetFactories f) {
  f.shadow.shadow = ffi.Pointer.fromFunction(shadowShadow, exception);
  f.shadow.convertRadiusToSigma = ffi.Pointer.fromFunction(shadowConvertRadiusToSigma, exceptionDouble);
  f.shadow.lerp = ffi.Pointer.fromFunction(shadowLerp, exception);
}
int shadowShadow(ffi.Pointer<DartObj> color, ffi.Pointer<DartObj> offset, ffi.Pointer<ffi.Double> blurRadius) {
  final w = Shadow(color: color.objOr(const Color(0xFF000000)),
      offset: offset.objOr(Offset.zero),
      blurRadius: blurRadius.doubleOr(0.0));
  return _addWidget(w);
}
double shadowConvertRadiusToSigma(double radius) {
  final w = Shadow.convertRadiusToSigma(radius);
  return w;
}
int shadowLerp(DartDartObj a, DartDartObj b, double t) {
  final w = Shadow.lerp(_widgetsMap[a]! as Shadow?,
      _widgetsMap[b]! as Shadow?,
      t);
  return _addWidget(w);
}

void _setupTextDecoration(WidgetFactories f) {
  f.textDecoration.combine = ffi.Pointer.fromFunction(textDecorationCombine, exception);
  f.textDecoration.none = _addWidget(TextDecoration.none);
  f.textDecoration.underline = _addWidget(TextDecoration.underline);
  f.textDecoration.overline = _addWidget(TextDecoration.overline);
  f.textDecoration.lineThrough = _addWidget(TextDecoration.lineThrough);
}
int textDecorationCombine(ArrayC decorations) {
  final w = TextDecoration.combine(decorations.listOrEmpty());
  return _addWidget(w);
}

void _setupIconData(WidgetFactories f) {
  f.iconData.iconData = ffi.Pointer.fromFunction(iconDataIconData);
}
IconDataObjSt iconDataIconData(int codePoint, ffi.Pointer<ffi.Char> fontFamily, ffi.Pointer<ffi.Char> fontPackage, ffi.Pointer<ffi.Int> matchTextDirection, ffi.Pointer<ffi.Pointer<ffi.Pointer<ffi.Char>>> fontFamilyFallback) {
  final w = IconData(codePoint,
      fontFamily: fontFamily.strOrNul(),
      fontPackage: fontPackage.strOrNul(),
      matchTextDirection: matchTextDirection.boolOr(false),
      fontFamilyFallback: fontFamilyFallback.listOrNul());
  return _createIconDataObjSt(w);
}
IconDataObjSt _createIconDataObjSt(IconData? w) {
  final IconDataObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.codePoint = w.codePoint;
  stObj.fontFamily = (w.fontFamily != null) ? w.fontFamily!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.fontPackage = (w.fontPackage != null) ? w.fontPackage!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.matchTextDirection = w.matchTextDirection.toInt();
  return stObj;
}

void _setupText(WidgetFactories f) {
  f.text.text = ffi.Pointer.fromFunction(textText);
  f.text.rich = ffi.Pointer.fromFunction(textRich);
}
TextObjSt textText(ffi.Pointer<ffi.Char> data, ffi.Pointer<DartObj> style, ffi.Pointer<ffi.Int> textAlign, ffi.Pointer<ffi.Int> textDirection, ffi.Pointer<ffi.Int> softWrap, ffi.Pointer<ffi.Int> overflow, ffi.Pointer<ffi.Double> textScaleFactor, ffi.Pointer<ffi.Int> maxLines, ffi.Pointer<ffi.Char> semanticsLabel, ffi.Pointer<ffi.Char> semanticsIdentifier, ffi.Pointer<ffi.Int> textWidthBasis, ffi.Pointer<DartObj> selectionColor) {
  final w = Text(data.cast<Utf8>().toDartString(),
      style: style.objOrNul(),
      textAlign: textAlign.enumOrNul(TextAlign.values),
      textDirection: textDirection.enumOrNul(TextDirection.values),
      softWrap: softWrap.boolOrNul(),
      overflow: overflow.enumOrNul(TextOverflow.values),
      textScaleFactor: textScaleFactor.doubleOrNul(),
      maxLines: maxLines.intOrNul(),
      semanticsLabel: semanticsLabel.strOrNul(),
      semanticsIdentifier: semanticsIdentifier.strOrNul(),
      textWidthBasis: textWidthBasis.enumOrNul(TextWidthBasis.values),
      selectionColor: selectionColor.objOrNul());
  return _createTextObjSt(w);
}
TextObjSt textRich(DartDartObj textSpan, ffi.Pointer<DartObj> style, ffi.Pointer<ffi.Int> textAlign, ffi.Pointer<ffi.Int> textDirection, ffi.Pointer<ffi.Int> softWrap, ffi.Pointer<ffi.Int> overflow, ffi.Pointer<ffi.Double> textScaleFactor, ffi.Pointer<ffi.Int> maxLines, ffi.Pointer<ffi.Char> semanticsLabel, ffi.Pointer<ffi.Char> semanticsIdentifier, ffi.Pointer<ffi.Int> textWidthBasis, ffi.Pointer<DartObj> selectionColor) {
  final w = Text.rich(_widgetsMap[textSpan]! as InlineSpan,
      style: style.objOrNul(),
      textAlign: textAlign.enumOrNul(TextAlign.values),
      textDirection: textDirection.enumOrNul(TextDirection.values),
      softWrap: softWrap.boolOrNul(),
      overflow: overflow.enumOrNul(TextOverflow.values),
      textScaleFactor: textScaleFactor.doubleOrNul(),
      maxLines: maxLines.intOrNul(),
      semanticsLabel: semanticsLabel.strOrNul(),
      semanticsIdentifier: semanticsIdentifier.strOrNul(),
      textWidthBasis: textWidthBasis.enumOrNul(TextWidthBasis.values),
      selectionColor: selectionColor.objOrNul());
  return _createTextObjSt(w);
}
TextObjSt _createTextObjSt(Text? w) {
  final TextObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.data = (w.data != null) ? w.data!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.textSpan = _addWidget(w.textSpan);
  stObj.style = _createTextStyleObjSt(w.style);
  stObj.textAlign = (w.textAlign != null) ? w.textAlign!.index : 0;
  stObj.textDirection = (w.textDirection != null) ? w.textDirection!.index : 0;
  stObj.softWrap = (w.softWrap != null) ? w.softWrap!.toInt() : 0;
  stObj.overflow = (w.overflow != null) ? w.overflow!.index : 0;
  stObj.textScaleFactor = (w.textScaleFactor != null) ? w.textScaleFactor! : 0;
  stObj.maxLines = (w.maxLines != null) ? w.maxLines! : 0;
  stObj.semanticsLabel = (w.semanticsLabel != null) ? w.semanticsLabel!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.semanticsIdentifier = (w.semanticsIdentifier != null) ? w.semanticsIdentifier!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.textWidthBasis = (w.textWidthBasis != null) ? w.textWidthBasis!.index : 0;
  stObj.selectionColor = _addWidget(w.selectionColor);
  return stObj;
}

void _setupTextSpan(WidgetFactories f) {
  f.textSpan.textSpan = ffi.Pointer.fromFunction(textSpanTextSpan);
}
TextSpanObjSt textSpanTextSpan(ffi.Pointer<ffi.Char> text, ffi.Pointer<ArrayC> children, ffi.Pointer<DartObj> style, ffi.Pointer<PointerEnterEventListenerFFI> onEnter, ffi.Pointer<PointerExitEventListenerFFI> onExit, ffi.Pointer<ffi.Char> semanticsLabel, ffi.Pointer<ffi.Char> semanticsIdentifier, ffi.Pointer<ffi.Int> spellOut) {
  final w = TextSpan(text: text.strOrNul(),
      children: children.listOrNul(),
      style: style.objOrNul(),
      onEnter: onEnter.toPointerEnterEventListenerFn(),
      onExit: onExit.toPointerExitEventListenerFn(),
      semanticsLabel: semanticsLabel.strOrNul(),
      semanticsIdentifier: semanticsIdentifier.strOrNul(),
      spellOut: spellOut.boolOrNul());
  return _createTextSpanObjSt(w);
}
TextSpanObjSt _createTextSpanObjSt(TextSpan? w) {
  final TextSpanObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.text = (w.text != null) ? w.text!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.semanticsLabel = (w.semanticsLabel != null) ? w.semanticsLabel!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.semanticsIdentifier = (w.semanticsIdentifier != null) ? w.semanticsIdentifier!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.spellOut = (w.spellOut != null) ? w.spellOut!.toInt() : 0;
  return stObj;
}

void _setupPointerEnterEvent(WidgetFactories f) {
  f.pointerEnterEvent.pointerEnterEvent = ffi.Pointer.fromFunction(pointerEnterEventPointerEnterEvent);
  f.pointerEnterEvent.fromMouseEvent = ffi.Pointer.fromFunction(pointerEnterEventFromMouseEvent);
}
PointerEnterEventObjSt pointerEnterEventPointerEnterEvent(ffi.Pointer<ffi.Int> viewId, ffi.Pointer<DartObj> timeStamp, ffi.Pointer<ffi.Int> pointer, ffi.Pointer<ffi.Int> kind, ffi.Pointer<ffi.Int> device, ffi.Pointer<DartObj> position, ffi.Pointer<DartObj> delta, ffi.Pointer<ffi.Int> buttons, ffi.Pointer<ffi.Int> obscured, ffi.Pointer<ffi.Double> pressureMin, ffi.Pointer<ffi.Double> pressureMax, ffi.Pointer<ffi.Double> distance, ffi.Pointer<ffi.Double> distanceMax, ffi.Pointer<ffi.Double> size, ffi.Pointer<ffi.Double> radiusMajor, ffi.Pointer<ffi.Double> radiusMinor, ffi.Pointer<ffi.Double> radiusMin, ffi.Pointer<ffi.Double> radiusMax, ffi.Pointer<ffi.Double> orientation, ffi.Pointer<ffi.Double> tilt, ffi.Pointer<ffi.Int> down, ffi.Pointer<ffi.Int> synthesized, ffi.Pointer<ffi.Int> embedderId) {
  final w = PointerEnterEvent(viewId: viewId.intOr(0),
      timeStamp: timeStamp.objOr(Duration.zero),
      pointer: pointer.intOr(0),
      kind: kind.enumOr(PointerDeviceKind.values, PointerDeviceKind.touch),
      device: device.intOr(0),
      position: position.objOr(Offset.zero),
      delta: delta.objOr(Offset.zero),
      buttons: buttons.intOr(0),
      obscured: obscured.boolOr(false),
      pressureMin: pressureMin.doubleOr(1.0),
      pressureMax: pressureMax.doubleOr(1.0),
      distance: distance.doubleOr(0.0),
      distanceMax: distanceMax.doubleOr(0.0),
      size: size.doubleOr(0.0),
      radiusMajor: radiusMajor.doubleOr(0.0),
      radiusMinor: radiusMinor.doubleOr(0.0),
      radiusMin: radiusMin.doubleOr(0.0),
      radiusMax: radiusMax.doubleOr(0.0),
      orientation: orientation.doubleOr(0.0),
      tilt: tilt.doubleOr(0.0),
      down: down.boolOr(false),
      synthesized: synthesized.boolOr(false),
      embedderId: embedderId.intOr(0));
  return _createPointerEnterEventObjSt(w);
}
PointerEnterEventObjSt pointerEnterEventFromMouseEvent(DartDartObj event) {
  final w = PointerEnterEvent.fromMouseEvent(_widgetsMap[event]! as PointerEvent);
  return _createPointerEnterEventObjSt(w);
}
PointerEnterEventObjSt _createPointerEnterEventObjSt(PointerEnterEvent? w) {
  final PointerEnterEventObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  return stObj;
}

void _setupPointerExitEvent(WidgetFactories f) {
  f.pointerExitEvent.pointerExitEvent = ffi.Pointer.fromFunction(pointerExitEventPointerExitEvent);
  f.pointerExitEvent.fromMouseEvent = ffi.Pointer.fromFunction(pointerExitEventFromMouseEvent);
}
PointerExitEventObjSt pointerExitEventPointerExitEvent(ffi.Pointer<ffi.Int> viewId, ffi.Pointer<DartObj> timeStamp, ffi.Pointer<ffi.Int> kind, ffi.Pointer<ffi.Int> pointer, ffi.Pointer<ffi.Int> device, ffi.Pointer<DartObj> position, ffi.Pointer<DartObj> delta, ffi.Pointer<ffi.Int> buttons, ffi.Pointer<ffi.Int> obscured, ffi.Pointer<ffi.Double> pressureMin, ffi.Pointer<ffi.Double> pressureMax, ffi.Pointer<ffi.Double> distance, ffi.Pointer<ffi.Double> distanceMax, ffi.Pointer<ffi.Double> size, ffi.Pointer<ffi.Double> radiusMajor, ffi.Pointer<ffi.Double> radiusMinor, ffi.Pointer<ffi.Double> radiusMin, ffi.Pointer<ffi.Double> radiusMax, ffi.Pointer<ffi.Double> orientation, ffi.Pointer<ffi.Double> tilt, ffi.Pointer<ffi.Int> down, ffi.Pointer<ffi.Int> synthesized, ffi.Pointer<ffi.Int> embedderId) {
  final w = PointerExitEvent(viewId: viewId.intOr(0),
      timeStamp: timeStamp.objOr(Duration.zero),
      kind: kind.enumOr(PointerDeviceKind.values, PointerDeviceKind.touch),
      pointer: pointer.intOr(0),
      device: device.intOr(0),
      position: position.objOr(Offset.zero),
      delta: delta.objOr(Offset.zero),
      buttons: buttons.intOr(0),
      obscured: obscured.boolOr(false),
      pressureMin: pressureMin.doubleOr(1.0),
      pressureMax: pressureMax.doubleOr(1.0),
      distance: distance.doubleOr(0.0),
      distanceMax: distanceMax.doubleOr(0.0),
      size: size.doubleOr(0.0),
      radiusMajor: radiusMajor.doubleOr(0.0),
      radiusMinor: radiusMinor.doubleOr(0.0),
      radiusMin: radiusMin.doubleOr(0.0),
      radiusMax: radiusMax.doubleOr(0.0),
      orientation: orientation.doubleOr(0.0),
      tilt: tilt.doubleOr(0.0),
      down: down.boolOr(false),
      synthesized: synthesized.boolOr(false),
      embedderId: embedderId.intOr(0));
  return _createPointerExitEventObjSt(w);
}
PointerExitEventObjSt pointerExitEventFromMouseEvent(DartDartObj event) {
  final w = PointerExitEvent.fromMouseEvent(_widgetsMap[event]! as PointerEvent);
  return _createPointerExitEventObjSt(w);
}
PointerExitEventObjSt _createPointerExitEventObjSt(PointerExitEvent? w) {
  final PointerExitEventObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  return stObj;
}

void _setupDuration(WidgetFactories f) {
  f.duration.duration = ffi.Pointer.fromFunction(durationDuration, exception);
}
int durationDuration(ffi.Pointer<ffi.Int> days, ffi.Pointer<ffi.Int> hours, ffi.Pointer<ffi.Int> minutes, ffi.Pointer<ffi.Int> seconds, ffi.Pointer<ffi.Int> milliseconds, ffi.Pointer<ffi.Int> microseconds) {
  final w = Duration(days: days.intOr(0),
      hours: hours.intOr(0),
      minutes: minutes.intOr(0),
      seconds: seconds.intOr(0),
      milliseconds: milliseconds.intOr(0),
      microseconds: microseconds.intOr(0));
  return _addWidget(w);
}

void _setupRichText(WidgetFactories f) {
  f.richText.richText = ffi.Pointer.fromFunction(richTextRichText);
}
RichTextObjSt richTextRichText(DartDartObj text, ffi.Pointer<ffi.Int> textAlign, ffi.Pointer<ffi.Int> textDirection, ffi.Pointer<ffi.Int> softWrap, ffi.Pointer<ffi.Int> overflow, ffi.Pointer<ffi.Double> textScaleFactor, ffi.Pointer<ffi.Int> maxLines, ffi.Pointer<ffi.Int> textWidthBasis, ffi.Pointer<DartObj> selectionColor) {
  final w = RichText(text: _widgetsMap[text]! as InlineSpan,
      textAlign: textAlign.enumOr(TextAlign.values, TextAlign.start),
      textDirection: textDirection.enumOrNul(TextDirection.values),
      softWrap: softWrap.boolOr(true),
      overflow: overflow.enumOr(TextOverflow.values, TextOverflow.clip),
      textScaleFactor: textScaleFactor.doubleOr(1.0),
      maxLines: maxLines.intOrNul(),
      textWidthBasis: textWidthBasis.enumOr(TextWidthBasis.values, TextWidthBasis.parent),
      selectionColor: selectionColor.objOrNul());
  return _createRichTextObjSt(w);
}
RichTextObjSt _createRichTextObjSt(RichText? w) {
  final RichTextObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.text = _addWidget(w.text);
  stObj.textAlign = w.textAlign.index;
  stObj.textDirection = (w.textDirection != null) ? w.textDirection!.index : 0;
  stObj.softWrap = w.softWrap.toInt();
  stObj.overflow = w.overflow.index;
  stObj.maxLines = (w.maxLines != null) ? w.maxLines! : 0;
  stObj.textWidthBasis = w.textWidthBasis.index;
  stObj.selectionColor = _addWidget(w.selectionColor);
  stObj.textScaleFactor = w.textScaleFactor;
  return stObj;
}

void _setupCenter(WidgetFactories f) {
  f.center.center = ffi.Pointer.fromFunction(centerCenter);
}
CenterObjSt centerCenter(ffi.Pointer<ffi.Double> widthFactor, ffi.Pointer<ffi.Double> heightFactor, ffi.Pointer<DartObj> child) {
  final w = Center(widthFactor: widthFactor.doubleOrNul(),
      heightFactor: heightFactor.doubleOrNul(),
      child: child.objOrNul());
  return _createCenterObjSt(w);
}
CenterObjSt _createCenterObjSt(Center? w) {
  final CenterObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  return stObj;
}

void _setupAlign(WidgetFactories f) {
  f.align.align = ffi.Pointer.fromFunction(alignAlign);
}
AlignObjSt alignAlign(ffi.Pointer<DartObj> alignment, ffi.Pointer<ffi.Double> widthFactor, ffi.Pointer<ffi.Double> heightFactor, ffi.Pointer<DartObj> child) {
  final w = Align(alignment: alignment.objOr(Alignment.center),
      widthFactor: widthFactor.doubleOrNul(),
      heightFactor: heightFactor.doubleOrNul(),
      child: child.objOrNul());
  return _createAlignObjSt(w);
}
AlignObjSt _createAlignObjSt(Align? w) {
  final AlignObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.alignment = _addWidget(w.alignment);
  stObj.widthFactor = (w.widthFactor != null) ? w.widthFactor! : 0;
  stObj.heightFactor = (w.heightFactor != null) ? w.heightFactor! : 0;
  return stObj;
}

void _setupColumn(WidgetFactories f) {
  f.column.column = ffi.Pointer.fromFunction(columnColumn);
}
ColumnObjSt columnColumn(ffi.Pointer<ffi.Int> mainAxisAlignment, ffi.Pointer<ffi.Int> mainAxisSize, ffi.Pointer<ffi.Int> crossAxisAlignment, ffi.Pointer<ffi.Int> textDirection, ffi.Pointer<ffi.Int> verticalDirection, ffi.Pointer<ffi.Int> textBaseline, ffi.Pointer<ffi.Double> spacing, ffi.Pointer<ArrayC> children) {
  final w = Column(mainAxisAlignment: mainAxisAlignment.enumOr(MainAxisAlignment.values, MainAxisAlignment.start),
      mainAxisSize: mainAxisSize.enumOr(MainAxisSize.values, MainAxisSize.max),
      crossAxisAlignment: crossAxisAlignment.enumOr(CrossAxisAlignment.values, CrossAxisAlignment.center),
      textDirection: textDirection.enumOrNul(TextDirection.values),
      verticalDirection: verticalDirection.enumOr(VerticalDirection.values, VerticalDirection.down),
      textBaseline: textBaseline.enumOrNul(TextBaseline.values),
      spacing: spacing.doubleOr(0.0),
      children: children.listOrEmpty());
  return _createColumnObjSt(w);
}
ColumnObjSt _createColumnObjSt(Column? w) {
  final ColumnObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  return stObj;
}

void _setupFlex(WidgetFactories f) {
  f.flex.flex = ffi.Pointer.fromFunction(flexFlex);
}
FlexObjSt flexFlex(int direction, ffi.Pointer<ffi.Int> mainAxisAlignment, ffi.Pointer<ffi.Int> mainAxisSize, ffi.Pointer<ffi.Int> crossAxisAlignment, ffi.Pointer<ffi.Int> textDirection, ffi.Pointer<ffi.Int> verticalDirection, ffi.Pointer<ffi.Int> textBaseline, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<ffi.Double> spacing, ffi.Pointer<ArrayC> children) {
  final w = Flex(direction: Axis.values[direction],
      mainAxisAlignment: mainAxisAlignment.enumOr(MainAxisAlignment.values, MainAxisAlignment.start),
      mainAxisSize: mainAxisSize.enumOr(MainAxisSize.values, MainAxisSize.max),
      crossAxisAlignment: crossAxisAlignment.enumOr(CrossAxisAlignment.values, CrossAxisAlignment.center),
      textDirection: textDirection.enumOrNul(TextDirection.values),
      verticalDirection: verticalDirection.enumOr(VerticalDirection.values, VerticalDirection.down),
      textBaseline: textBaseline.enumOrNul(TextBaseline.values),
      clipBehavior: clipBehavior.enumOr(Clip.values, Clip.none),
      spacing: spacing.doubleOr(0.0),
      children: children.listOrEmpty());
  return _createFlexObjSt(w);
}
FlexObjSt _createFlexObjSt(Flex? w) {
  final FlexObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.direction = w.direction.index;
  stObj.mainAxisAlignment = w.mainAxisAlignment.index;
  stObj.mainAxisSize = w.mainAxisSize.index;
  stObj.crossAxisAlignment = w.crossAxisAlignment.index;
  stObj.textDirection = (w.textDirection != null) ? w.textDirection!.index : 0;
  stObj.verticalDirection = w.verticalDirection.index;
  stObj.textBaseline = (w.textBaseline != null) ? w.textBaseline!.index : 0;
  stObj.clipBehavior = w.clipBehavior.index;
  stObj.spacing = w.spacing;
  return stObj;
}

void _setupRow(WidgetFactories f) {
  f.row.row = ffi.Pointer.fromFunction(rowRow);
}
RowObjSt rowRow(ffi.Pointer<ffi.Int> mainAxisAlignment, ffi.Pointer<ffi.Int> mainAxisSize, ffi.Pointer<ffi.Int> crossAxisAlignment, ffi.Pointer<ffi.Int> textDirection, ffi.Pointer<ffi.Int> verticalDirection, ffi.Pointer<ffi.Int> textBaseline, ffi.Pointer<ffi.Double> spacing, ffi.Pointer<ArrayC> children) {
  final w = Row(mainAxisAlignment: mainAxisAlignment.enumOr(MainAxisAlignment.values, MainAxisAlignment.start),
      mainAxisSize: mainAxisSize.enumOr(MainAxisSize.values, MainAxisSize.max),
      crossAxisAlignment: crossAxisAlignment.enumOr(CrossAxisAlignment.values, CrossAxisAlignment.center),
      textDirection: textDirection.enumOrNul(TextDirection.values),
      verticalDirection: verticalDirection.enumOr(VerticalDirection.values, VerticalDirection.down),
      textBaseline: textBaseline.enumOrNul(TextBaseline.values),
      spacing: spacing.doubleOr(0.0),
      children: children.listOrEmpty());
  return _createRowObjSt(w);
}
RowObjSt _createRowObjSt(Row? w) {
  final RowObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  return stObj;
}

void _setupTransform(WidgetFactories f) {
  f.transform.rotate = ffi.Pointer.fromFunction(transformRotate);
  f.transform.translate = ffi.Pointer.fromFunction(transformTranslate);
  f.transform.scale = ffi.Pointer.fromFunction(transformScale);
  f.transform.flip = ffi.Pointer.fromFunction(transformFlip);
}
TransformObjSt transformRotate(double angle, ffi.Pointer<DartObj> origin, ffi.Pointer<DartObj> alignment, ffi.Pointer<ffi.Int> transformHitTests, ffi.Pointer<ffi.Int> filterQuality, ffi.Pointer<DartObj> child) {
  final w = Transform.rotate(angle: angle,
      origin: origin.objOrNul(),
      alignment: alignment.objOrNul(),
      transformHitTests: transformHitTests.boolOr(true),
      filterQuality: filterQuality.enumOrNul(FilterQuality.values),
      child: child.objOrNul());
  return _createTransformObjSt(w);
}
TransformObjSt transformTranslate(DartDartObj offset, ffi.Pointer<ffi.Int> transformHitTests, ffi.Pointer<ffi.Int> filterQuality, ffi.Pointer<DartObj> child) {
  final w = Transform.translate(offset: _widgetsMap[offset]! as Offset,
      transformHitTests: transformHitTests.boolOr(true),
      filterQuality: filterQuality.enumOrNul(FilterQuality.values),
      child: child.objOrNul());
  return _createTransformObjSt(w);
}
TransformObjSt transformScale(ffi.Pointer<ffi.Double> scale, ffi.Pointer<ffi.Double> scaleX, ffi.Pointer<ffi.Double> scaleY, ffi.Pointer<DartObj> origin, ffi.Pointer<DartObj> alignment, ffi.Pointer<ffi.Int> transformHitTests, ffi.Pointer<ffi.Int> filterQuality, ffi.Pointer<DartObj> child) {
  final w = Transform.scale(scale: scale.doubleOrNul(),
      scaleX: scaleX.doubleOrNul(),
      scaleY: scaleY.doubleOrNul(),
      origin: origin.objOrNul(),
      alignment: alignment.objOrNul(),
      transformHitTests: transformHitTests.boolOr(true),
      filterQuality: filterQuality.enumOrNul(FilterQuality.values),
      child: child.objOrNul());
  return _createTransformObjSt(w);
}
TransformObjSt transformFlip(ffi.Pointer<ffi.Int> flipX, ffi.Pointer<ffi.Int> flipY, ffi.Pointer<DartObj> origin, ffi.Pointer<ffi.Int> transformHitTests, ffi.Pointer<ffi.Int> filterQuality, ffi.Pointer<DartObj> child) {
  final w = Transform.flip(flipX: flipX.boolOr(false),
      flipY: flipY.boolOr(false),
      origin: origin.objOrNul(),
      transformHitTests: transformHitTests.boolOr(true),
      filterQuality: filterQuality.enumOrNul(FilterQuality.values),
      child: child.objOrNul());
  return _createTransformObjSt(w);
}
TransformObjSt _createTransformObjSt(Transform? w) {
  final TransformObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.origin = _addWidget(w.origin);
  stObj.alignment = _addWidget(w.alignment);
  stObj.transformHitTests = w.transformHitTests.toInt();
  stObj.filterQuality = (w.filterQuality != null) ? w.filterQuality!.index : 0;
  return stObj;
}

void _setupOpacity(WidgetFactories f) {
  f.opacity.opacity = ffi.Pointer.fromFunction(opacityOpacity);
}
OpacityObjSt opacityOpacity(double opacity, ffi.Pointer<ffi.Int> alwaysIncludeSemantics, ffi.Pointer<DartObj> child) {
  final w = Opacity(opacity: opacity,
      alwaysIncludeSemantics: alwaysIncludeSemantics.boolOr(false),
      child: child.objOrNul());
  return _createOpacityObjSt(w);
}
OpacityObjSt _createOpacityObjSt(Opacity? w) {
  final OpacityObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.opacity = w.opacity;
  stObj.alwaysIncludeSemantics = w.alwaysIncludeSemantics.toInt();
  return stObj;
}

void _setupStack(WidgetFactories f) {
  f.stack.stack = ffi.Pointer.fromFunction(stackStack);
}
StackObjSt stackStack(ffi.Pointer<DartObj> alignment, ffi.Pointer<ffi.Int> textDirection, ffi.Pointer<ffi.Int> fit, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<ArrayC> children) {
  final w = Stack(alignment: alignment.objOr(AlignmentDirectional.topStart),
      textDirection: textDirection.enumOrNul(TextDirection.values),
      fit: fit.enumOr(StackFit.values, StackFit.loose),
      clipBehavior: clipBehavior.enumOr(Clip.values, Clip.hardEdge),
      children: children.listOrEmpty());
  return _createStackObjSt(w);
}
StackObjSt _createStackObjSt(Stack? w) {
  final StackObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.alignment = _addWidget(w.alignment);
  stObj.textDirection = (w.textDirection != null) ? w.textDirection!.index : 0;
  stObj.fit = w.fit.index;
  stObj.clipBehavior = w.clipBehavior.index;
  return stObj;
}

void _setupBoxConstraints(WidgetFactories f) {
  f.boxConstraints.boxConstraints = ffi.Pointer.fromFunction(boxConstraintsBoxConstraints);
  f.boxConstraints.tightFor = ffi.Pointer.fromFunction(boxConstraintsTightFor);
  f.boxConstraints.tightForFinite = ffi.Pointer.fromFunction(boxConstraintsTightForFinite);
  f.boxConstraints.expand = ffi.Pointer.fromFunction(boxConstraintsExpand);
  f.boxConstraints.lerp = ffi.Pointer.fromFunction(boxConstraintsLerp);
}
BoxConstraintsObjSt boxConstraintsBoxConstraints(ffi.Pointer<ffi.Double> minWidth, ffi.Pointer<ffi.Double> maxWidth, ffi.Pointer<ffi.Double> minHeight, ffi.Pointer<ffi.Double> maxHeight) {
  final w = BoxConstraints(minWidth: minWidth.doubleOr(0.0),
      maxWidth: maxWidth.doubleOr(double.infinity),
      minHeight: minHeight.doubleOr(0.0),
      maxHeight: maxHeight.doubleOr(double.infinity));
  return _createBoxConstraintsObjSt(w);
}
BoxConstraintsObjSt boxConstraintsTightFor(ffi.Pointer<ffi.Double> width, ffi.Pointer<ffi.Double> height) {
  final w = BoxConstraints.tightFor(width: width.doubleOrNul(),
      height: height.doubleOrNul());
  return _createBoxConstraintsObjSt(w);
}
BoxConstraintsObjSt boxConstraintsTightForFinite(ffi.Pointer<ffi.Double> width, ffi.Pointer<ffi.Double> height) {
  final w = BoxConstraints.tightForFinite(width: width.doubleOr(double.infinity),
      height: height.doubleOr(double.infinity));
  return _createBoxConstraintsObjSt(w);
}
BoxConstraintsObjSt boxConstraintsExpand(ffi.Pointer<ffi.Double> width, ffi.Pointer<ffi.Double> height) {
  final w = BoxConstraints.expand(width: width.doubleOrNul(),
      height: height.doubleOrNul());
  return _createBoxConstraintsObjSt(w);
}
BoxConstraintsObjSt boxConstraintsLerp(DartDartObj a, DartDartObj b, double t) {
  final w = BoxConstraints.lerp(_widgetsMap[a]! as BoxConstraints?,
      _widgetsMap[b]! as BoxConstraints?,
      t);
  return _createBoxConstraintsObjSt(w);
}
BoxConstraintsObjSt _createBoxConstraintsObjSt(BoxConstraints? w) {
  final BoxConstraintsObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.minWidth = w.minWidth;
  stObj.maxWidth = w.maxWidth;
  stObj.minHeight = w.minHeight;
  stObj.maxHeight = w.maxHeight;
  stObj.hasTightWidth = w.hasTightWidth.toInt();
  stObj.hasTightHeight = w.hasTightHeight.toInt();
  stObj.hasBoundedWidth = w.hasBoundedWidth.toInt();
  stObj.hasBoundedHeight = w.hasBoundedHeight.toInt();
  stObj.hasInfiniteWidth = w.hasInfiniteWidth.toInt();
  stObj.hasInfiniteHeight = w.hasInfiniteHeight.toInt();
  return stObj;
}

void _setupContainer(WidgetFactories f) {
  f.container.container = ffi.Pointer.fromFunction(containerContainer);
}
ContainerObjSt containerContainer(ffi.Pointer<DartObj> alignment, ffi.Pointer<DartObj> padding, ffi.Pointer<DartObj> color, ffi.Pointer<DartObj> decoration, ffi.Pointer<DartObj> foregroundDecoration, ffi.Pointer<ffi.Double> width, ffi.Pointer<ffi.Double> height, ffi.Pointer<DartObj> constraints, ffi.Pointer<DartObj> margin, ffi.Pointer<DartObj> transformAlignment, ffi.Pointer<DartObj> child, ffi.Pointer<ffi.Int> clipBehavior) {
  final w = Container(alignment: alignment.objOrNul(),
      padding: padding.objOrNul(),
      color: color.objOrNul(),
      decoration: decoration.objOrNul(),
      foregroundDecoration: foregroundDecoration.objOrNul(),
      width: width.doubleOrNul(),
      height: height.doubleOrNul(),
      constraints: constraints.objOrNul(),
      margin: margin.objOrNul(),
      transformAlignment: transformAlignment.objOrNul(),
      child: child.objOrNul(),
      clipBehavior: clipBehavior.enumOr(Clip.values, Clip.none));
  return _createContainerObjSt(w);
}
ContainerObjSt _createContainerObjSt(Container? w) {
  final ContainerObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.child = _addWidget(w.child);
  stObj.alignment = _addWidget(w.alignment);
  stObj.padding = _addWidget(w.padding);
  stObj.color = _addWidget(w.color);
  stObj.decoration = _addWidget(w.decoration);
  stObj.foregroundDecoration = _addWidget(w.foregroundDecoration);
  stObj.constraints = _createBoxConstraintsObjSt(w.constraints);
  stObj.margin = _addWidget(w.margin);
  stObj.transformAlignment = _addWidget(w.transformAlignment);
  stObj.clipBehavior = w.clipBehavior.index;
  return stObj;
}

void _setupEdgeInsetsGeometry(WidgetFactories f) {
  f.edgeInsetsGeometry.infinity = _addWidget(EdgeInsetsGeometry.infinity);
}

void _setupStackParentData(WidgetFactories f) {
  f.stackParentData.stackParentData = ffi.Pointer.fromFunction(stackParentDataStackParentData, exception);
}
int stackParentDataStackParentData() {
  final w = StackParentData();
  return _addWidget(w);
}

void _setupBoxParentData(WidgetFactories f) {
  f.boxParentData.boxParentData = ffi.Pointer.fromFunction(boxParentDataBoxParentData, exception);
}
int boxParentDataBoxParentData() {
  final w = BoxParentData();
  return _addWidget(w);
}

void _setupParentData(WidgetFactories f) {
  f.parentData.parentData = ffi.Pointer.fromFunction(parentDataParentData, exception);
}
int parentDataParentData() {
  final w = ParentData();
  return _addWidget(w);
}

void _setupFlexParentData(WidgetFactories f) {
  f.flexParentData.flexParentData = ffi.Pointer.fromFunction(flexParentDataFlexParentData, exception);
}
int flexParentDataFlexParentData() {
  final w = FlexParentData();
  return _addWidget(w);
}

void _setupPositioned(WidgetFactories f) {
  f.positioned.positioned = ffi.Pointer.fromFunction(positionedPositioned);
  f.positioned.fill = ffi.Pointer.fromFunction(positionedFill);
  f.positioned.directional = ffi.Pointer.fromFunction(positionedDirectional);
}
PositionedObjSt positionedPositioned(ffi.Pointer<ffi.Double> left, ffi.Pointer<ffi.Double> top, ffi.Pointer<ffi.Double> right, ffi.Pointer<ffi.Double> bottom, ffi.Pointer<ffi.Double> width, ffi.Pointer<ffi.Double> height, DartDartObj child) {
  final w = Positioned(left: left.doubleOrNul(),
      top: top.doubleOrNul(),
      right: right.doubleOrNul(),
      bottom: bottom.doubleOrNul(),
      width: width.doubleOrNul(),
      height: height.doubleOrNul(),
      child: _widgetsMap[child]! as Widget);
  return _createPositionedObjSt(w);
}
PositionedObjSt positionedFill(ffi.Pointer<ffi.Double> left, ffi.Pointer<ffi.Double> top, ffi.Pointer<ffi.Double> right, ffi.Pointer<ffi.Double> bottom, DartDartObj child) {
  final w = Positioned.fill(left: left.doubleOrNul(),
      top: top.doubleOrNul(),
      right: right.doubleOrNul(),
      bottom: bottom.doubleOrNul(),
      child: _widgetsMap[child]! as Widget);
  return _createPositionedObjSt(w);
}
PositionedObjSt positionedDirectional(int textDirection, ffi.Pointer<ffi.Double> start, ffi.Pointer<ffi.Double> top, ffi.Pointer<ffi.Double> end, ffi.Pointer<ffi.Double> bottom, ffi.Pointer<ffi.Double> width, ffi.Pointer<ffi.Double> height, DartDartObj child) {
  final w = Positioned.directional(textDirection: TextDirection.values[textDirection],
      start: start.doubleOrNul(),
      top: top.doubleOrNul(),
      end: end.doubleOrNul(),
      bottom: bottom.doubleOrNul(),
      width: width.doubleOrNul(),
      height: height.doubleOrNul(),
      child: _widgetsMap[child]! as Widget);
  return _createPositionedObjSt(w);
}
PositionedObjSt _createPositionedObjSt(Positioned? w) {
  final PositionedObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.left = (w.left != null) ? w.left! : 0;
  stObj.top = (w.top != null) ? w.top! : 0;
  stObj.right = (w.right != null) ? w.right! : 0;
  stObj.bottom = (w.bottom != null) ? w.bottom! : 0;
  stObj.width = (w.width != null) ? w.width! : 0;
  stObj.height = (w.height != null) ? w.height! : 0;
  return stObj;
}

void _setupBoxDecoration(WidgetFactories f) {
  f.boxDecoration.boxDecoration = ffi.Pointer.fromFunction(boxDecorationBoxDecoration);
  f.boxDecoration.lerp = ffi.Pointer.fromFunction(boxDecorationLerp);
}
BoxDecorationObjSt boxDecorationBoxDecoration(ffi.Pointer<DartObj> color, ffi.Pointer<DartObj> border, ffi.Pointer<DartObj> borderRadius, ffi.Pointer<ArrayC> boxShadow, ffi.Pointer<ffi.Int> backgroundBlendMode, ffi.Pointer<ffi.Int> shape) {
  final w = BoxDecoration(color: color.objOrNul(),
      border: border.objOrNul(),
      borderRadius: borderRadius.objOrNul(),
      boxShadow: boxShadow.listOrNul(),
      backgroundBlendMode: backgroundBlendMode.enumOrNul(BlendMode.values),
      shape: shape.enumOr(BoxShape.values, BoxShape.rectangle));
  return _createBoxDecorationObjSt(w);
}
BoxDecorationObjSt boxDecorationLerp(DartDartObj a, DartDartObj b, double t) {
  final w = BoxDecoration.lerp(_widgetsMap[a]! as BoxDecoration?,
      _widgetsMap[b]! as BoxDecoration?,
      t);
  return _createBoxDecorationObjSt(w);
}
BoxDecorationObjSt _createBoxDecorationObjSt(BoxDecoration? w) {
  final BoxDecorationObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.color = _addWidget(w.color);
  stObj.border = _addWidget(w.border);
  stObj.borderRadius = _addWidget(w.borderRadius);
  stObj.backgroundBlendMode = (w.backgroundBlendMode != null) ? w.backgroundBlendMode!.index : 0;
  stObj.shape = w.shape.index;
  return stObj;
}

void _setupBoxShadow(WidgetFactories f) {
  f.boxShadow.boxShadow = ffi.Pointer.fromFunction(boxShadowBoxShadow);
  f.boxShadow.lerp = ffi.Pointer.fromFunction(boxShadowLerp);
}
BoxShadowObjSt boxShadowBoxShadow(ffi.Pointer<DartObj> color, ffi.Pointer<DartObj> offset, ffi.Pointer<ffi.Double> blurRadius, ffi.Pointer<ffi.Double> spreadRadius, ffi.Pointer<ffi.Int> blurStyle) {
  final w = BoxShadow(color: color.objOr(const Color(0xFF000000)),
      offset: offset.objOr(Offset.zero),
      blurRadius: blurRadius.doubleOr(0.0),
      spreadRadius: spreadRadius.doubleOr(0.0),
      blurStyle: blurStyle.enumOr(BlurStyle.values, BlurStyle.normal));
  return _createBoxShadowObjSt(w);
}
BoxShadowObjSt boxShadowLerp(DartDartObj a, DartDartObj b, double t) {
  final w = BoxShadow.lerp(_widgetsMap[a]! as BoxShadow?,
      _widgetsMap[b]! as BoxShadow?,
      t);
  return _createBoxShadowObjSt(w);
}
BoxShadowObjSt _createBoxShadowObjSt(BoxShadow? w) {
  final BoxShadowObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.spreadRadius = w.spreadRadius;
  stObj.blurStyle = w.blurStyle.index;
  return stObj;
}

void _setupRadius(WidgetFactories f) {
  f.radius.circular = ffi.Pointer.fromFunction(radiusCircular, exception);
  f.radius.elliptical = ffi.Pointer.fromFunction(radiusElliptical, exception);
  f.radius.lerp = ffi.Pointer.fromFunction(radiusLerp, exception);
}
int radiusCircular(double radius) {
  final w = Radius.circular(radius);
  return _addWidget(w);
}
int radiusElliptical(double x, double y) {
  final w = Radius.elliptical(x,
      y);
  return _addWidget(w);
}
int radiusLerp(DartDartObj a, DartDartObj b, double t) {
  final w = Radius.lerp(_widgetsMap[a]! as Radius?,
      _widgetsMap[b]! as Radius?,
      t);
  return _addWidget(w);
}

void _setupBorderRadius(WidgetFactories f) {
  f.borderRadius.all = ffi.Pointer.fromFunction(borderRadiusAll);
  f.borderRadius.circular = ffi.Pointer.fromFunction(borderRadiusCircular);
  f.borderRadius.vertical = ffi.Pointer.fromFunction(borderRadiusVertical);
  f.borderRadius.horizontal = ffi.Pointer.fromFunction(borderRadiusHorizontal);
  f.borderRadius.only = ffi.Pointer.fromFunction(borderRadiusOnly);
  f.borderRadius.lerp = ffi.Pointer.fromFunction(borderRadiusLerp);
}
BorderRadiusObjSt borderRadiusAll(DartDartObj radius) {
  final w = BorderRadius.all(_widgetsMap[radius]! as Radius);
  return _createBorderRadiusObjSt(w);
}
BorderRadiusObjSt borderRadiusCircular(double radius) {
  final w = BorderRadius.circular(radius);
  return _createBorderRadiusObjSt(w);
}
BorderRadiusObjSt borderRadiusVertical(ffi.Pointer<DartObj> top, ffi.Pointer<DartObj> bottom) {
  final w = BorderRadius.vertical(top: top.objOr(Radius.zero),
      bottom: bottom.objOr(Radius.zero));
  return _createBorderRadiusObjSt(w);
}
BorderRadiusObjSt borderRadiusHorizontal(ffi.Pointer<DartObj> left, ffi.Pointer<DartObj> right) {
  final w = BorderRadius.horizontal(left: left.objOr(Radius.zero),
      right: right.objOr(Radius.zero));
  return _createBorderRadiusObjSt(w);
}
BorderRadiusObjSt borderRadiusOnly(ffi.Pointer<DartObj> topLeft, ffi.Pointer<DartObj> topRight, ffi.Pointer<DartObj> bottomLeft, ffi.Pointer<DartObj> bottomRight) {
  final w = BorderRadius.only(topLeft: topLeft.objOr(Radius.zero),
      topRight: topRight.objOr(Radius.zero),
      bottomLeft: bottomLeft.objOr(Radius.zero),
      bottomRight: bottomRight.objOr(Radius.zero));
  return _createBorderRadiusObjSt(w);
}
BorderRadiusObjSt borderRadiusLerp(DartDartObj a, DartDartObj b, double t) {
  final w = BorderRadius.lerp(_widgetsMap[a]! as BorderRadius?,
      _widgetsMap[b]! as BorderRadius?,
      t);
  return _createBorderRadiusObjSt(w);
}
BorderRadiusObjSt _createBorderRadiusObjSt(BorderRadius? w) {
  final BorderRadiusObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.topLeft = _addWidget(w.topLeft);
  stObj.topRight = _addWidget(w.topRight);
  stObj.bottomLeft = _addWidget(w.bottomLeft);
  stObj.bottomRight = _addWidget(w.bottomRight);
  return stObj;
}

void _setupPadding(WidgetFactories f) {
  f.padding.padding = ffi.Pointer.fromFunction(paddingPadding);
}
PaddingObjSt paddingPadding(DartDartObj padding, ffi.Pointer<DartObj> child) {
  final w = Padding(padding: _widgetsMap[padding]! as EdgeInsetsGeometry,
      child: child.objOrNul());
  return _createPaddingObjSt(w);
}
PaddingObjSt _createPaddingObjSt(Padding? w) {
  final PaddingObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.padding = _addWidget(w.padding);
  return stObj;
}

void _setupEdgeInsets(WidgetFactories f) {
  f.edgeInsets.fromLTRB = ffi.Pointer.fromFunction(edgeInsetsFromLTRB);
  f.edgeInsets.all = ffi.Pointer.fromFunction(edgeInsetsAll);
  f.edgeInsets.only = ffi.Pointer.fromFunction(edgeInsetsOnly);
  f.edgeInsets.symmetric = ffi.Pointer.fromFunction(edgeInsetsSymmetric);
  f.edgeInsets.lerp = ffi.Pointer.fromFunction(edgeInsetsLerp);
}
EdgeInsetsObjSt edgeInsetsFromLTRB(double left, double top, double right, double bottom) {
  final w = EdgeInsets.fromLTRB(left,
      top,
      right,
      bottom);
  return _createEdgeInsetsObjSt(w);
}
EdgeInsetsObjSt edgeInsetsAll(double value) {
  final w = EdgeInsets.all(value);
  return _createEdgeInsetsObjSt(w);
}
EdgeInsetsObjSt edgeInsetsOnly(ffi.Pointer<ffi.Double> left, ffi.Pointer<ffi.Double> top, ffi.Pointer<ffi.Double> right, ffi.Pointer<ffi.Double> bottom) {
  final w = EdgeInsets.only(left: left.doubleOr(0.0),
      top: top.doubleOr(0.0),
      right: right.doubleOr(0.0),
      bottom: bottom.doubleOr(0.0));
  return _createEdgeInsetsObjSt(w);
}
EdgeInsetsObjSt edgeInsetsSymmetric(ffi.Pointer<ffi.Double> vertical, ffi.Pointer<ffi.Double> horizontal) {
  final w = EdgeInsets.symmetric(vertical: vertical.doubleOr(0.0),
      horizontal: horizontal.doubleOr(0.0));
  return _createEdgeInsetsObjSt(w);
}
EdgeInsetsObjSt edgeInsetsLerp(DartDartObj a, DartDartObj b, double t) {
  final w = EdgeInsets.lerp(_widgetsMap[a]! as EdgeInsets?,
      _widgetsMap[b]! as EdgeInsets?,
      t);
  return _createEdgeInsetsObjSt(w);
}
EdgeInsetsObjSt _createEdgeInsetsObjSt(EdgeInsets? w) {
  final EdgeInsetsObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.left = w.left;
  stObj.top = w.top;
  stObj.right = w.right;
  stObj.bottom = w.bottom;
  stObj.topLeft = _addWidget(w.topLeft);
  stObj.topRight = _addWidget(w.topRight);
  stObj.bottomLeft = _addWidget(w.bottomLeft);
  stObj.bottomRight = _addWidget(w.bottomRight);
  return stObj;
}

void _setupBorderSide(WidgetFactories f) {
  f.borderSide.borderSide = ffi.Pointer.fromFunction(borderSideBorderSide);
  f.borderSide.merge = ffi.Pointer.fromFunction(borderSideMerge);
  f.borderSide.canMerge = ffi.Pointer.fromFunction(borderSideCanMerge, exception);
  f.borderSide.lerp = ffi.Pointer.fromFunction(borderSideLerp);
}
BorderSideObjSt borderSideBorderSide(ffi.Pointer<DartObj> color, ffi.Pointer<ffi.Double> width, ffi.Pointer<ffi.Int> style, ffi.Pointer<ffi.Double> strokeAlign) {
  final w = BorderSide(color: color.objOr(const Color(0xFF000000)),
      width: width.doubleOr(1.0),
      style: style.enumOr(BorderStyle.values, BorderStyle.solid),
      strokeAlign: strokeAlign.doubleOr(-1.0));
  return _createBorderSideObjSt(w);
}
BorderSideObjSt borderSideMerge(DartDartObj a, DartDartObj b) {
  final w = BorderSide.merge(_widgetsMap[a]! as BorderSide,
      _widgetsMap[b]! as BorderSide);
  return _createBorderSideObjSt(w);
}
int borderSideCanMerge(DartDartObj a, DartDartObj b) {
  final w = BorderSide.canMerge(_widgetsMap[a]! as BorderSide,
      _widgetsMap[b]! as BorderSide);
  return w.toInt();
}
BorderSideObjSt borderSideLerp(DartDartObj a, DartDartObj b, double t) {
  final w = BorderSide.lerp(_widgetsMap[a]! as BorderSide,
      _widgetsMap[b]! as BorderSide,
      t);
  return _createBorderSideObjSt(w);
}
BorderSideObjSt _createBorderSideObjSt(BorderSide? w) {
  final BorderSideObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.color = _addWidget(w.color);
  stObj.width = w.width;
  stObj.style = w.style.index;
  stObj.strokeAlign = w.strokeAlign;
  stObj.strokeInset = w.strokeInset;
  stObj.strokeOutset = w.strokeOutset;
  stObj.strokeOffset = w.strokeOffset;
  return stObj;
}

void _setupBorder(WidgetFactories f) {
  f.border.border = ffi.Pointer.fromFunction(borderBorder);
  f.border.fromBorderSide = ffi.Pointer.fromFunction(borderFromBorderSide);
  f.border.symmetric = ffi.Pointer.fromFunction(borderSymmetric);
  f.border.all = ffi.Pointer.fromFunction(borderAll);
  f.border.merge = ffi.Pointer.fromFunction(borderMerge);
  f.border.lerp = ffi.Pointer.fromFunction(borderLerp);
}
BorderObjSt borderBorder(ffi.Pointer<DartObj> top, ffi.Pointer<DartObj> right, ffi.Pointer<DartObj> bottom, ffi.Pointer<DartObj> left) {
  final w = Border(top: top.objOr(BorderSide.none),
      right: right.objOr(BorderSide.none),
      bottom: bottom.objOr(BorderSide.none),
      left: left.objOr(BorderSide.none));
  return _createBorderObjSt(w);
}
BorderObjSt borderFromBorderSide(DartDartObj side) {
  final w = Border.fromBorderSide(_widgetsMap[side]! as BorderSide);
  return _createBorderObjSt(w);
}
BorderObjSt borderSymmetric(ffi.Pointer<DartObj> vertical, ffi.Pointer<DartObj> horizontal) {
  final w = Border.symmetric(vertical: vertical.objOr(BorderSide.none),
      horizontal: horizontal.objOr(BorderSide.none));
  return _createBorderObjSt(w);
}
BorderObjSt borderAll(ffi.Pointer<DartObj> color, ffi.Pointer<ffi.Double> width, ffi.Pointer<ffi.Int> style, ffi.Pointer<ffi.Double> strokeAlign) {
  final w = Border.all(color: color.objOr(const Color(0xFF000000)),
      width: width.doubleOr(1.0),
      style: style.enumOr(BorderStyle.values, BorderStyle.solid),
      strokeAlign: strokeAlign.doubleOr(BorderSide.strokeAlignInside));
  return _createBorderObjSt(w);
}
BorderObjSt borderMerge(DartDartObj a, DartDartObj b) {
  final w = Border.merge(_widgetsMap[a]! as Border,
      _widgetsMap[b]! as Border);
  return _createBorderObjSt(w);
}
BorderObjSt borderLerp(DartDartObj a, DartDartObj b, double t) {
  final w = Border.lerp(_widgetsMap[a]! as Border?,
      _widgetsMap[b]! as Border?,
      t);
  return _createBorderObjSt(w);
}
BorderObjSt _createBorderObjSt(Border? w) {
  final BorderObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.top = _createBorderSideObjSt(w.top);
  stObj.right = _createBorderSideObjSt(w.right);
  stObj.bottom = _createBorderSideObjSt(w.bottom);
  stObj.left = _createBorderSideObjSt(w.left);
  return stObj;
}

void _setupRoundedRectangleBorder(WidgetFactories f) {
  f.roundedRectangleBorder.roundedRectangleBorder = ffi.Pointer.fromFunction(roundedRectangleBorderRoundedRectangleBorder);
}
RoundedRectangleBorderObjSt roundedRectangleBorderRoundedRectangleBorder(ffi.Pointer<DartObj> side, ffi.Pointer<DartObj> borderRadius) {
  final w = RoundedRectangleBorder(side: side.objOr(BorderSide.none),
      borderRadius: borderRadius.objOr(BorderRadius.zero));
  return _createRoundedRectangleBorderObjSt(w);
}
RoundedRectangleBorderObjSt _createRoundedRectangleBorderObjSt(RoundedRectangleBorder? w) {
  final RoundedRectangleBorderObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.borderRadius = _addWidget(w.borderRadius);
  return stObj;
}

void _setupAnimationController(WidgetFactories f) {
  f.animationController.animationController = ffi.Pointer.fromFunction(animationControllerAnimationController, exception);
  f.animationController.unbounded = ffi.Pointer.fromFunction(animationControllerUnbounded, exception);
  f.animationController.forward = ffi.Pointer.fromFunction(animationControllerForward);
  f.animationController.reverse = ffi.Pointer.fromFunction(animationControllerReverse);
  f.animationController.stop = ffi.Pointer.fromFunction(animationControllerStop);
  f.animationController.repeat = ffi.Pointer.fromFunction(animationControllerRepeat);
  f.animationController.reset = ffi.Pointer.fromFunction(animationControllerReset);
  f.animationController.setDuration = ffi.Pointer.fromFunction(animationControllerSetDuration);
  f.animationController.setReverseDuration = ffi.Pointer.fromFunction(animationControllerSetReverseDuration);
}
int animationControllerAnimationController(ffi.Pointer<ffi.Double> value, ffi.Pointer<DartObj> duration, ffi.Pointer<DartObj> reverseDuration, ffi.Pointer<ffi.Char> debugLabel, ffi.Pointer<ffi.Double> lowerBound, ffi.Pointer<ffi.Double> upperBound, ffi.Pointer<ffi.Int> animationBehavior, DartDartObj vsync) {
  final w = AnimationController(value: value.doubleOrNul(),
      duration: duration.objOrNul(),
      reverseDuration: reverseDuration.objOrNul(),
      debugLabel: debugLabel.strOrNul(),
      lowerBound: lowerBound.doubleOr(0.0),
      upperBound: upperBound.doubleOr(1.0),
      animationBehavior: animationBehavior.enumOr(AnimationBehavior.values, AnimationBehavior.normal),
      vsync: _widgetsMap[vsync]! as TickerProvider);
  return _addWidget(w);
}
int animationControllerUnbounded(ffi.Pointer<ffi.Double> value, ffi.Pointer<DartObj> duration, ffi.Pointer<DartObj> reverseDuration, ffi.Pointer<ffi.Char> debugLabel, DartDartObj vsync, ffi.Pointer<ffi.Int> animationBehavior) {
  final w = AnimationController.unbounded(value: value.doubleOr(0.0),
      duration: duration.objOrNul(),
      reverseDuration: reverseDuration.objOrNul(),
      debugLabel: debugLabel.strOrNul(),
      vsync: _widgetsMap[vsync]! as TickerProvider,
      animationBehavior: animationBehavior.enumOr(AnimationBehavior.values, AnimationBehavior.preserve));
  return _addWidget(w);
}
void animationControllerForward(DartDartObj self) {
  AnimationControllerMethods.forward(_widgetsMap[self]! as AnimationController);
}
void animationControllerReverse(DartDartObj self) {
  AnimationControllerMethods.reverse(_widgetsMap[self]! as AnimationController);
}
void animationControllerStop(DartDartObj self) {
  AnimationControllerMethods.stop(_widgetsMap[self]! as AnimationController);
}
void animationControllerRepeat(DartDartObj self) {
  AnimationControllerMethods.repeat(_widgetsMap[self]! as AnimationController);
}
void animationControllerReset(DartDartObj self) {
  AnimationControllerMethods.reset(_widgetsMap[self]! as AnimationController);
}
void animationControllerSetDuration(DartDartObj self, DartDartObj d) {
  AnimationControllerMethods.setDuration(_widgetsMap[self]! as AnimationController,
      _widgetsMap[d]! as Duration);
}
void animationControllerSetReverseDuration(DartDartObj self, DartDartObj d) {
  AnimationControllerMethods.setReverseDuration(_widgetsMap[self]! as AnimationController,
      _widgetsMap[d]! as Duration);
}

void _setupAnimatedBuilder(WidgetFactories f) {
  f.animatedBuilder.animatedBuilder = ffi.Pointer.fromFunction(animatedBuilderAnimatedBuilder);
}
AnimatedBuilderObjSt animatedBuilderAnimatedBuilder(DartDartObj animation, TransitionBuilderFFI builder, ffi.Pointer<DartObj> child) {
  final w = AnimatedBuilder(animation: _widgetsMap[animation]! as Listenable,
      builder: builder.toTransitionBuilderFn(),
      child: child.objOrNul());
  return _createAnimatedBuilderObjSt(w);
}
AnimatedBuilderObjSt _createAnimatedBuilderObjSt(AnimatedBuilder? w) {
  final AnimatedBuilderObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.animation = _addWidget(w.animation);
  return stObj;
}

void _setupListenableBuilder(WidgetFactories f) {
  f.listenableBuilder.listenableBuilder = ffi.Pointer.fromFunction(listenableBuilderListenableBuilder);
}
ListenableBuilderObjSt listenableBuilderListenableBuilder(DartDartObj listenable, TransitionBuilderFFI builder, ffi.Pointer<DartObj> child) {
  final w = ListenableBuilder(listenable: _widgetsMap[listenable]! as Listenable,
      builder: builder.toTransitionBuilderFn(),
      child: child.objOrNul());
  return _createListenableBuilderObjSt(w);
}
ListenableBuilderObjSt _createListenableBuilderObjSt(ListenableBuilder? w) {
  final ListenableBuilderObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.child = _addWidget(w.child);
  return stObj;
}

void _setupVelocity(WidgetFactories f) {
  f.velocity.velocity = ffi.Pointer.fromFunction(velocityVelocity);
}
VelocityObjSt velocityVelocity(DartDartObj pixelsPerSecond) {
  final w = Velocity(pixelsPerSecond: _widgetsMap[pixelsPerSecond]! as Offset);
  return _createVelocityObjSt(w);
}
VelocityObjSt _createVelocityObjSt(Velocity? w) {
  final VelocityObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.pixelsPerSecond = _addWidget(w.pixelsPerSecond);
  return stObj;
}

void _setupTapDownDetails(WidgetFactories f) {
  f.tapDownDetails.tapDownDetails = ffi.Pointer.fromFunction(tapDownDetailsTapDownDetails, exception);
  f.tapDownDetails.globalPosition = ffi.Pointer.fromFunction(tapDownDetailsGlobalPosition, exception);
  f.tapDownDetails.localPosition = ffi.Pointer.fromFunction(tapDownDetailsLocalPosition, exception);
}
int tapDownDetailsTapDownDetails(ffi.Pointer<DartObj> globalPosition, ffi.Pointer<DartObj> localPosition, ffi.Pointer<ffi.Int> kind) {
  final w = TapDownDetails(globalPosition: globalPosition.objOr(Offset.zero),
      localPosition: localPosition.objOrNul(),
      kind: kind.enumOrNul(PointerDeviceKind.values));
  return _addWidget(w);
}
int tapDownDetailsGlobalPosition(DartDartObj self) {
  final w = TapDownDetailsMethods.globalPosition(_widgetsMap[self]! as TapDownDetails);
  return _addWidget(w);
}
int tapDownDetailsLocalPosition(DartDartObj self) {
  final w = TapDownDetailsMethods.localPosition(_widgetsMap[self]! as TapDownDetails);
  return _addWidget(w);
}

void _setupTapUpDetails(WidgetFactories f) {
  f.tapUpDetails.tapUpDetails = ffi.Pointer.fromFunction(tapUpDetailsTapUpDetails, exception);
}
int tapUpDetailsTapUpDetails(ffi.Pointer<DartObj> globalPosition, ffi.Pointer<DartObj> localPosition, int kind) {
  final w = TapUpDetails(globalPosition: globalPosition.objOr(Offset.zero),
      localPosition: localPosition.objOrNul(),
      kind: PointerDeviceKind.values[kind]);
  return _addWidget(w);
}

void _setupTapMoveDetails(WidgetFactories f) {
  f.tapMoveDetails.tapMoveDetails = ffi.Pointer.fromFunction(tapMoveDetailsTapMoveDetails, exception);
}
int tapMoveDetailsTapMoveDetails(int kind, ffi.Pointer<DartObj> globalPosition, ffi.Pointer<DartObj> delta, ffi.Pointer<DartObj> localPosition) {
  final w = TapMoveDetails(kind: PointerDeviceKind.values[kind],
      globalPosition: globalPosition.objOr(Offset.zero),
      delta: delta.objOr(Offset.zero),
      localPosition: localPosition.objOrNul());
  return _addWidget(w);
}

void _setupLongPressDownDetails(WidgetFactories f) {
  f.longPressDownDetails.longPressDownDetails = ffi.Pointer.fromFunction(longPressDownDetailsLongPressDownDetails, exception);
}
int longPressDownDetailsLongPressDownDetails(ffi.Pointer<DartObj> globalPosition, ffi.Pointer<DartObj> localPosition, ffi.Pointer<ffi.Int> kind) {
  final w = LongPressDownDetails(globalPosition: globalPosition.objOr(Offset.zero),
      localPosition: localPosition.objOrNul(),
      kind: kind.enumOrNul(PointerDeviceKind.values));
  return _addWidget(w);
}

void _setupLongPressStartDetails(WidgetFactories f) {
  f.longPressStartDetails.longPressStartDetails = ffi.Pointer.fromFunction(longPressStartDetailsLongPressStartDetails, exception);
}
int longPressStartDetailsLongPressStartDetails(ffi.Pointer<DartObj> globalPosition, ffi.Pointer<DartObj> localPosition) {
  final w = LongPressStartDetails(globalPosition: globalPosition.objOr(Offset.zero),
      localPosition: localPosition.objOrNul());
  return _addWidget(w);
}

void _setupLongPressMoveUpdateDetails(WidgetFactories f) {
  f.longPressMoveUpdateDetails.longPressMoveUpdateDetails = ffi.Pointer.fromFunction(longPressMoveUpdateDetailsLongPressMoveUpdateDetails, exception);
}
int longPressMoveUpdateDetailsLongPressMoveUpdateDetails(ffi.Pointer<DartObj> globalPosition, ffi.Pointer<DartObj> localPosition, ffi.Pointer<DartObj> offsetFromOrigin, ffi.Pointer<DartObj> localOffsetFromOrigin) {
  final w = LongPressMoveUpdateDetails(globalPosition: globalPosition.objOr(Offset.zero),
      localPosition: localPosition.objOrNul(),
      offsetFromOrigin: offsetFromOrigin.objOr(Offset.zero),
      localOffsetFromOrigin: localOffsetFromOrigin.objOrNul());
  return _addWidget(w);
}

void _setupLongPressEndDetails(WidgetFactories f) {
  f.longPressEndDetails.longPressEndDetails = ffi.Pointer.fromFunction(longPressEndDetailsLongPressEndDetails, exception);
}
int longPressEndDetailsLongPressEndDetails(ffi.Pointer<DartObj> globalPosition, ffi.Pointer<DartObj> localPosition, ffi.Pointer<DartObj> velocity) {
  final w = LongPressEndDetails(globalPosition: globalPosition.objOr(Offset.zero),
      localPosition: localPosition.objOrNul(),
      velocity: velocity.objOr(Velocity.zero));
  return _addWidget(w);
}

void _setupDragDownDetails(WidgetFactories f) {
  f.dragDownDetails.dragDownDetails = ffi.Pointer.fromFunction(dragDownDetailsDragDownDetails, exception);
}
int dragDownDetailsDragDownDetails(ffi.Pointer<DartObj> globalPosition, ffi.Pointer<DartObj> localPosition) {
  final w = DragDownDetails(globalPosition: globalPosition.objOr(Offset.zero),
      localPosition: localPosition.objOrNul());
  return _addWidget(w);
}

void _setupDragStartDetails(WidgetFactories f) {
  f.dragStartDetails.dragStartDetails = ffi.Pointer.fromFunction(dragStartDetailsDragStartDetails, exception);
}
int dragStartDetailsDragStartDetails(ffi.Pointer<DartObj> globalPosition, ffi.Pointer<DartObj> localPosition, ffi.Pointer<DartObj> sourceTimeStamp, ffi.Pointer<ffi.Int> kind) {
  final w = DragStartDetails(globalPosition: globalPosition.objOr(Offset.zero),
      localPosition: localPosition.objOrNul(),
      sourceTimeStamp: sourceTimeStamp.objOrNul(),
      kind: kind.enumOrNul(PointerDeviceKind.values));
  return _addWidget(w);
}

void _setupDragUpdateDetails(WidgetFactories f) {
  f.dragUpdateDetails.dragUpdateDetails = ffi.Pointer.fromFunction(dragUpdateDetailsDragUpdateDetails, exception);
}
int dragUpdateDetailsDragUpdateDetails(DartDartObj globalPosition, ffi.Pointer<DartObj> localPosition, ffi.Pointer<DartObj> sourceTimeStamp, ffi.Pointer<DartObj> delta, ffi.Pointer<ffi.Double> primaryDelta, ffi.Pointer<ffi.Int> kind) {
  final w = DragUpdateDetails(globalPosition: _widgetsMap[globalPosition]! as Offset,
      localPosition: localPosition.objOrNul(),
      sourceTimeStamp: sourceTimeStamp.objOrNul(),
      delta: delta.objOr(Offset.zero),
      primaryDelta: primaryDelta.doubleOrNul(),
      kind: kind.enumOrNul(PointerDeviceKind.values));
  return _addWidget(w);
}

void _setupDragEndDetails(WidgetFactories f) {
  f.dragEndDetails.dragEndDetails = ffi.Pointer.fromFunction(dragEndDetailsDragEndDetails, exception);
}
int dragEndDetailsDragEndDetails(ffi.Pointer<DartObj> globalPosition, ffi.Pointer<DartObj> localPosition, ffi.Pointer<DartObj> velocity, ffi.Pointer<ffi.Double> primaryVelocity) {
  final w = DragEndDetails(globalPosition: globalPosition.objOr(Offset.zero),
      localPosition: localPosition.objOrNul(),
      velocity: velocity.objOr(Velocity.zero),
      primaryVelocity: primaryVelocity.doubleOrNul());
  return _addWidget(w);
}

void _setupScaleStartDetails(WidgetFactories f) {
  f.scaleStartDetails.scaleStartDetails = ffi.Pointer.fromFunction(scaleStartDetailsScaleStartDetails, exception);
}
int scaleStartDetailsScaleStartDetails(ffi.Pointer<DartObj> focalPoint, ffi.Pointer<DartObj> localFocalPoint, ffi.Pointer<ffi.Int> pointerCount, ffi.Pointer<DartObj> sourceTimeStamp, ffi.Pointer<ffi.Int> kind) {
  final w = ScaleStartDetails(focalPoint: focalPoint.objOr(Offset.zero),
      localFocalPoint: localFocalPoint.objOrNul(),
      pointerCount: pointerCount.intOr(0),
      sourceTimeStamp: sourceTimeStamp.objOrNul(),
      kind: kind.enumOrNul(PointerDeviceKind.values));
  return _addWidget(w);
}

void _setupScaleUpdateDetails(WidgetFactories f) {
  f.scaleUpdateDetails.scaleUpdateDetails = ffi.Pointer.fromFunction(scaleUpdateDetailsScaleUpdateDetails, exception);
}
int scaleUpdateDetailsScaleUpdateDetails(ffi.Pointer<DartObj> focalPoint, ffi.Pointer<DartObj> localFocalPoint, ffi.Pointer<ffi.Double> scale, ffi.Pointer<ffi.Double> horizontalScale, ffi.Pointer<ffi.Double> verticalScale, ffi.Pointer<ffi.Double> rotation, ffi.Pointer<ffi.Int> pointerCount, ffi.Pointer<DartObj> focalPointDelta, ffi.Pointer<DartObj> sourceTimeStamp) {
  final w = ScaleUpdateDetails(focalPoint: focalPoint.objOr(Offset.zero),
      localFocalPoint: localFocalPoint.objOrNul(),
      scale: scale.doubleOr(1.0),
      horizontalScale: horizontalScale.doubleOr(1.0),
      verticalScale: verticalScale.doubleOr(1.0),
      rotation: rotation.doubleOr(0.0),
      pointerCount: pointerCount.intOr(0),
      focalPointDelta: focalPointDelta.objOr(Offset.zero),
      sourceTimeStamp: sourceTimeStamp.objOrNul());
  return _addWidget(w);
}

void _setupScaleEndDetails(WidgetFactories f) {
  f.scaleEndDetails.scaleEndDetails = ffi.Pointer.fromFunction(scaleEndDetailsScaleEndDetails, exception);
}
int scaleEndDetailsScaleEndDetails(ffi.Pointer<DartObj> velocity, ffi.Pointer<ffi.Double> scaleVelocity, ffi.Pointer<ffi.Int> pointerCount) {
  final w = ScaleEndDetails(velocity: velocity.objOr(Velocity.zero),
      scaleVelocity: scaleVelocity.doubleOr(0),
      pointerCount: pointerCount.intOr(0));
  return _addWidget(w);
}

void _setupForcePressDetails(WidgetFactories f) {
  f.forcePressDetails.forcePressDetails = ffi.Pointer.fromFunction(forcePressDetailsForcePressDetails, exception);
}
int forcePressDetailsForcePressDetails(DartDartObj globalPosition, ffi.Pointer<DartObj> localPosition, double pressure) {
  final w = ForcePressDetails(globalPosition: _widgetsMap[globalPosition]! as Offset,
      localPosition: localPosition.objOrNul(),
      pressure: pressure);
  return _addWidget(w);
}

void _setupDraggableDetails(WidgetFactories f) {
  f.draggableDetails.draggableDetails = ffi.Pointer.fromFunction(draggableDetailsDraggableDetails, exception);
}
int draggableDetailsDraggableDetails(ffi.Pointer<ffi.Int> wasAccepted, DartDartObj velocity, DartDartObj offset) {
  final w = DraggableDetails(wasAccepted: wasAccepted.boolOr(false),
      velocity: _widgetsMap[velocity]! as Velocity,
      offset: _widgetsMap[offset]! as Offset);
  return _addWidget(w);
}

void _setupDragTargetDetails(WidgetFactories f) {
  f.dragTargetDetails.dragTargetDetails = ffi.Pointer.fromFunction(dragTargetDetailsDragTargetDetails, exception);
}
int dragTargetDetailsDragTargetDetails(DartDartObj data, DartDartObj offset) {
  final w = DragTargetDetails(data: data,
      offset: _widgetsMap[offset]! as Offset);
  return _addWidget(w);
}

void _setupPointerDownEvent(WidgetFactories f) {
  f.pointerDownEvent.pointerDownEvent = ffi.Pointer.fromFunction(pointerDownEventPointerDownEvent);
}
PointerDownEventObjSt pointerDownEventPointerDownEvent(ffi.Pointer<ffi.Int> viewId, ffi.Pointer<DartObj> timeStamp, ffi.Pointer<ffi.Int> pointer, ffi.Pointer<ffi.Int> kind, ffi.Pointer<ffi.Int> device, ffi.Pointer<DartObj> position, ffi.Pointer<ffi.Int> buttons, ffi.Pointer<ffi.Int> obscured, ffi.Pointer<ffi.Double> pressure, ffi.Pointer<ffi.Double> pressureMin, ffi.Pointer<ffi.Double> pressureMax, ffi.Pointer<ffi.Double> distanceMax, ffi.Pointer<ffi.Double> size, ffi.Pointer<ffi.Double> radiusMajor, ffi.Pointer<ffi.Double> radiusMinor, ffi.Pointer<ffi.Double> radiusMin, ffi.Pointer<ffi.Double> radiusMax, ffi.Pointer<ffi.Double> orientation, ffi.Pointer<ffi.Double> tilt, ffi.Pointer<ffi.Int> embedderId) {
  final w = PointerDownEvent(viewId: viewId.intOr(0),
      timeStamp: timeStamp.objOr(Duration.zero),
      pointer: pointer.intOr(0),
      kind: kind.enumOr(PointerDeviceKind.values, PointerDeviceKind.touch),
      device: device.intOr(0),
      position: position.objOr(Offset.zero),
      buttons: buttons.intOr(kPrimaryButton),
      obscured: obscured.boolOr(false),
      pressure: pressure.doubleOr(1.0),
      pressureMin: pressureMin.doubleOr(1.0),
      pressureMax: pressureMax.doubleOr(1.0),
      distanceMax: distanceMax.doubleOr(0.0),
      size: size.doubleOr(0.0),
      radiusMajor: radiusMajor.doubleOr(0.0),
      radiusMinor: radiusMinor.doubleOr(0.0),
      radiusMin: radiusMin.doubleOr(0.0),
      radiusMax: radiusMax.doubleOr(0.0),
      orientation: orientation.doubleOr(0.0),
      tilt: tilt.doubleOr(0.0),
      embedderId: embedderId.intOr(0));
  return _createPointerDownEventObjSt(w);
}
PointerDownEventObjSt _createPointerDownEventObjSt(PointerDownEvent? w) {
  final PointerDownEventObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  return stObj;
}

void _setupPointerUpEvent(WidgetFactories f) {
  f.pointerUpEvent.pointerUpEvent = ffi.Pointer.fromFunction(pointerUpEventPointerUpEvent);
}
PointerUpEventObjSt pointerUpEventPointerUpEvent(ffi.Pointer<ffi.Int> viewId, ffi.Pointer<DartObj> timeStamp, ffi.Pointer<ffi.Int> pointer, ffi.Pointer<ffi.Int> kind, ffi.Pointer<ffi.Int> device, ffi.Pointer<DartObj> position, ffi.Pointer<ffi.Int> buttons, ffi.Pointer<ffi.Int> obscured, ffi.Pointer<ffi.Double> pressure, ffi.Pointer<ffi.Double> pressureMin, ffi.Pointer<ffi.Double> pressureMax, ffi.Pointer<ffi.Double> distance, ffi.Pointer<ffi.Double> distanceMax, ffi.Pointer<ffi.Double> size, ffi.Pointer<ffi.Double> radiusMajor, ffi.Pointer<ffi.Double> radiusMinor, ffi.Pointer<ffi.Double> radiusMin, ffi.Pointer<ffi.Double> radiusMax, ffi.Pointer<ffi.Double> orientation, ffi.Pointer<ffi.Double> tilt, ffi.Pointer<ffi.Int> embedderId) {
  final w = PointerUpEvent(viewId: viewId.intOr(0),
      timeStamp: timeStamp.objOr(Duration.zero),
      pointer: pointer.intOr(0),
      kind: kind.enumOr(PointerDeviceKind.values, PointerDeviceKind.touch),
      device: device.intOr(0),
      position: position.objOr(Offset.zero),
      buttons: buttons.intOr(0),
      obscured: obscured.boolOr(false),
      pressure: pressure.doubleOr(0.0),
      pressureMin: pressureMin.doubleOr(1.0),
      pressureMax: pressureMax.doubleOr(1.0),
      distance: distance.doubleOr(0.0),
      distanceMax: distanceMax.doubleOr(0.0),
      size: size.doubleOr(0.0),
      radiusMajor: radiusMajor.doubleOr(0.0),
      radiusMinor: radiusMinor.doubleOr(0.0),
      radiusMin: radiusMin.doubleOr(0.0),
      radiusMax: radiusMax.doubleOr(0.0),
      orientation: orientation.doubleOr(0.0),
      tilt: tilt.doubleOr(0.0),
      embedderId: embedderId.intOr(0));
  return _createPointerUpEventObjSt(w);
}
PointerUpEventObjSt _createPointerUpEventObjSt(PointerUpEvent? w) {
  final PointerUpEventObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  return stObj;
}

void _setupPointerHoverEvent(WidgetFactories f) {
  f.pointerHoverEvent.pointerHoverEvent = ffi.Pointer.fromFunction(pointerHoverEventPointerHoverEvent);
}
PointerHoverEventObjSt pointerHoverEventPointerHoverEvent(ffi.Pointer<ffi.Int> viewId, ffi.Pointer<DartObj> timeStamp, ffi.Pointer<ffi.Int> kind, ffi.Pointer<ffi.Int> pointer, ffi.Pointer<ffi.Int> device, ffi.Pointer<DartObj> position, ffi.Pointer<DartObj> delta, ffi.Pointer<ffi.Int> buttons, ffi.Pointer<ffi.Int> obscured, ffi.Pointer<ffi.Double> pressureMin, ffi.Pointer<ffi.Double> pressureMax, ffi.Pointer<ffi.Double> distance, ffi.Pointer<ffi.Double> distanceMax, ffi.Pointer<ffi.Double> size, ffi.Pointer<ffi.Double> radiusMajor, ffi.Pointer<ffi.Double> radiusMinor, ffi.Pointer<ffi.Double> radiusMin, ffi.Pointer<ffi.Double> radiusMax, ffi.Pointer<ffi.Double> orientation, ffi.Pointer<ffi.Double> tilt, ffi.Pointer<ffi.Int> synthesized, ffi.Pointer<ffi.Int> embedderId) {
  final w = PointerHoverEvent(viewId: viewId.intOr(0),
      timeStamp: timeStamp.objOr(Duration.zero),
      kind: kind.enumOr(PointerDeviceKind.values, PointerDeviceKind.touch),
      pointer: pointer.intOr(0),
      device: device.intOr(0),
      position: position.objOr(Offset.zero),
      delta: delta.objOr(Offset.zero),
      buttons: buttons.intOr(0),
      obscured: obscured.boolOr(false),
      pressureMin: pressureMin.doubleOr(1.0),
      pressureMax: pressureMax.doubleOr(1.0),
      distance: distance.doubleOr(0.0),
      distanceMax: distanceMax.doubleOr(0.0),
      size: size.doubleOr(0.0),
      radiusMajor: radiusMajor.doubleOr(0.0),
      radiusMinor: radiusMinor.doubleOr(0.0),
      radiusMin: radiusMin.doubleOr(0.0),
      radiusMax: radiusMax.doubleOr(0.0),
      orientation: orientation.doubleOr(0.0),
      tilt: tilt.doubleOr(0.0),
      synthesized: synthesized.boolOr(false),
      embedderId: embedderId.intOr(0));
  return _createPointerHoverEventObjSt(w);
}
PointerHoverEventObjSt _createPointerHoverEventObjSt(PointerHoverEvent? w) {
  final PointerHoverEventObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  return stObj;
}

void _setupCubic(WidgetFactories f) {
  f.cubic.cubic = ffi.Pointer.fromFunction(cubicCubic);
}
CubicObjSt cubicCubic(double a, double b, double c, double d) {
  final w = Cubic(a,
      b,
      c,
      d);
  return _createCubicObjSt(w);
}
CubicObjSt _createCubicObjSt(Cubic? w) {
  final CubicObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.a = w.a;
  stObj.b = w.b;
  stObj.c = w.c;
  stObj.d = w.d;
  return stObj;
}

void _setupThreePointCubic(WidgetFactories f) {
  f.threePointCubic.threePointCubic = ffi.Pointer.fromFunction(threePointCubicThreePointCubic);
}
ThreePointCubicObjSt threePointCubicThreePointCubic(DartDartObj a1, DartDartObj b1, DartDartObj midpoint, DartDartObj a2, DartDartObj b2) {
  final w = ThreePointCubic(_widgetsMap[a1]! as Offset,
      _widgetsMap[b1]! as Offset,
      _widgetsMap[midpoint]! as Offset,
      _widgetsMap[a2]! as Offset,
      _widgetsMap[b2]! as Offset);
  return _createThreePointCubicObjSt(w);
}
ThreePointCubicObjSt _createThreePointCubicObjSt(ThreePointCubic? w) {
  final ThreePointCubicObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.a1 = _addWidget(w.a1);
  stObj.b1 = _addWidget(w.b1);
  stObj.midpoint = _addWidget(w.midpoint);
  stObj.a2 = _addWidget(w.a2);
  stObj.b2 = _addWidget(w.b2);
  return stObj;
}

void _setupElasticOutCurve(WidgetFactories f) {
  f.elasticOutCurve.elasticOutCurve = ffi.Pointer.fromFunction(elasticOutCurveElasticOutCurve);
}
ElasticOutCurveObjSt elasticOutCurveElasticOutCurve(ffi.Pointer<ffi.Double> period) {
  final w = ElasticOutCurve(period.doubleOr(0.4));
  return _createElasticOutCurveObjSt(w);
}
ElasticOutCurveObjSt _createElasticOutCurveObjSt(ElasticOutCurve? w) {
  final ElasticOutCurveObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.period = w.period;
  return stObj;
}

void _setupElasticInCurve(WidgetFactories f) {
  f.elasticInCurve.elasticInCurve = ffi.Pointer.fromFunction(elasticInCurveElasticInCurve);
}
ElasticInCurveObjSt elasticInCurveElasticInCurve(ffi.Pointer<ffi.Double> period) {
  final w = ElasticInCurve(period.doubleOr(0.4));
  return _createElasticInCurveObjSt(w);
}
ElasticInCurveObjSt _createElasticInCurveObjSt(ElasticInCurve? w) {
  final ElasticInCurveObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.period = w.period;
  return stObj;
}

void _setupElasticInOutCurve(WidgetFactories f) {
  f.elasticInOutCurve.elasticInOutCurve = ffi.Pointer.fromFunction(elasticInOutCurveElasticInOutCurve);
}
ElasticInOutCurveObjSt elasticInOutCurveElasticInOutCurve(ffi.Pointer<ffi.Double> period) {
  final w = ElasticInOutCurve(period.doubleOr(0.4));
  return _createElasticInOutCurveObjSt(w);
}
ElasticInOutCurveObjSt _createElasticInOutCurveObjSt(ElasticInOutCurve? w) {
  final ElasticInOutCurveObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.period = w.period;
  return stObj;
}

void _setupCurves(WidgetFactories f) {
  f.curves.linear = _addWidget(Curves.linear);
  f.curves.decelerate = _addWidget(Curves.decelerate);
  f.curves.bounceIn = _addWidget(Curves.bounceIn);
  f.curves.bounceOut = _addWidget(Curves.bounceOut);
  f.curves.bounceInOut = _addWidget(Curves.bounceInOut);
}

void _setupCurvedAnimation(WidgetFactories f) {
  f.curvedAnimation.curvedAnimation = ffi.Pointer.fromFunction(curvedAnimationCurvedAnimation, exception);
}
int curvedAnimationCurvedAnimation(DartDartObj parent, DartDartObj curve, ffi.Pointer<DartObj> reverseCurve) {
  final w = CurvedAnimation(parent: _widgetsMap[parent]! as Animation<double>,
      curve: _widgetsMap[curve]! as Curve,
      reverseCurve: reverseCurve.objOrNul());
  return _addWidget(w);
}

void _setupSizedBox(WidgetFactories f) {
  f.sizedBox.sizedBox = ffi.Pointer.fromFunction(sizedBoxSizedBox);
  f.sizedBox.expand = ffi.Pointer.fromFunction(sizedBoxExpand);
  f.sizedBox.shrink = ffi.Pointer.fromFunction(sizedBoxShrink);
  f.sizedBox.fromSize = ffi.Pointer.fromFunction(sizedBoxFromSize);
  f.sizedBox.square = ffi.Pointer.fromFunction(sizedBoxSquare);
}
SizedBoxObjSt sizedBoxSizedBox(ffi.Pointer<ffi.Double> width, ffi.Pointer<ffi.Double> height, ffi.Pointer<DartObj> child) {
  final w = SizedBox(width: width.doubleOrNul(),
      height: height.doubleOrNul(),
      child: child.objOrNul());
  return _createSizedBoxObjSt(w);
}
SizedBoxObjSt sizedBoxExpand(ffi.Pointer<DartObj> child) {
  final w = SizedBox.expand(child: child.objOrNul());
  return _createSizedBoxObjSt(w);
}
SizedBoxObjSt sizedBoxShrink(ffi.Pointer<DartObj> child) {
  final w = SizedBox.shrink(child: child.objOrNul());
  return _createSizedBoxObjSt(w);
}
SizedBoxObjSt sizedBoxFromSize(ffi.Pointer<DartObj> child) {
  final w = SizedBox.fromSize(child: child.objOrNul());
  return _createSizedBoxObjSt(w);
}
SizedBoxObjSt sizedBoxSquare(ffi.Pointer<DartObj> child, ffi.Pointer<ffi.Double> dimension) {
  final w = SizedBox.square(child: child.objOrNul(),
      dimension: dimension.doubleOrNul());
  return _createSizedBoxObjSt(w);
}
SizedBoxObjSt _createSizedBoxObjSt(SizedBox? w) {
  final SizedBoxObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.width = (w.width != null) ? w.width! : 0;
  stObj.height = (w.height != null) ? w.height! : 0;
  return stObj;
}

void _setupAlignment(WidgetFactories f) {
  f.alignment.alignment = ffi.Pointer.fromFunction(alignmentAlignment);
  f.alignment.lerp = ffi.Pointer.fromFunction(alignmentLerp);
}
AlignmentObjSt alignmentAlignment(double x, double y) {
  final w = Alignment(x,
      y);
  return _createAlignmentObjSt(w);
}
AlignmentObjSt alignmentLerp(DartDartObj a, DartDartObj b, double t) {
  final w = Alignment.lerp(_widgetsMap[a]! as Alignment?,
      _widgetsMap[b]! as Alignment?,
      t);
  return _createAlignmentObjSt(w);
}
AlignmentObjSt _createAlignmentObjSt(Alignment? w) {
  final AlignmentObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.x = w.x;
  stObj.y = w.y;
  return stObj;
}

void _setupAlignmentDirectional(WidgetFactories f) {
  f.alignmentDirectional.alignmentDirectional = ffi.Pointer.fromFunction(alignmentDirectionalAlignmentDirectional);
  f.alignmentDirectional.lerp = ffi.Pointer.fromFunction(alignmentDirectionalLerp);
}
AlignmentDirectionalObjSt alignmentDirectionalAlignmentDirectional(double start, double y) {
  final w = AlignmentDirectional(start,
      y);
  return _createAlignmentDirectionalObjSt(w);
}
AlignmentDirectionalObjSt alignmentDirectionalLerp(DartDartObj a, DartDartObj b, double t) {
  final w = AlignmentDirectional.lerp(_widgetsMap[a]! as AlignmentDirectional?,
      _widgetsMap[b]! as AlignmentDirectional?,
      t);
  return _createAlignmentDirectionalObjSt(w);
}
AlignmentDirectionalObjSt _createAlignmentDirectionalObjSt(AlignmentDirectional? w) {
  final AlignmentDirectionalObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.start = w.start;
  stObj.y = w.y;
  return stObj;
}

void _setupMouseRegion(WidgetFactories f) {
  f.mouseRegion.mouseRegion = ffi.Pointer.fromFunction(mouseRegionMouseRegion);
}
MouseRegionObjSt mouseRegionMouseRegion(ffi.Pointer<PointerEnterEventListenerFFI> onEnter, ffi.Pointer<PointerExitEventListenerFFI> onExit, ffi.Pointer<PointerHoverEventListenerFFI> onHover, ffi.Pointer<ffi.Int> opaque, ffi.Pointer<ffi.Int> hitTestBehavior, ffi.Pointer<DartObj> child) {
  final w = MouseRegion(onEnter: onEnter.toPointerEnterEventListenerFn(),
      onExit: onExit.toPointerExitEventListenerFn(),
      onHover: onHover.toPointerHoverEventListenerFn(),
      opaque: opaque.boolOr(true),
      hitTestBehavior: hitTestBehavior.enumOrNul(HitTestBehavior.values),
      child: child.objOrNul());
  return _createMouseRegionObjSt(w);
}
MouseRegionObjSt _createMouseRegionObjSt(MouseRegion? w) {
  final MouseRegionObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.opaque = w.opaque.toInt();
  stObj.hitTestBehavior = (w.hitTestBehavior != null) ? w.hitTestBehavior!.index : 0;
  return stObj;
}

void _setupExpanded(WidgetFactories f) {
  f.expanded.expanded = ffi.Pointer.fromFunction(expandedExpanded);
}
ExpandedObjSt expandedExpanded(ffi.Pointer<ffi.Int> flex, DartDartObj child) {
  final w = Expanded(flex: flex.intOr(1),
      child: _widgetsMap[child]! as Widget);
  return _createExpandedObjSt(w);
}
ExpandedObjSt _createExpandedObjSt(Expanded? w) {
  final ExpandedObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  return stObj;
}

void _setupFlexible(WidgetFactories f) {
  f.flexible.flexible = ffi.Pointer.fromFunction(flexibleFlexible);
}
FlexibleObjSt flexibleFlexible(ffi.Pointer<ffi.Int> flex, ffi.Pointer<ffi.Int> fit, DartDartObj child) {
  final w = Flexible(flex: flex.intOr(1),
      fit: fit.enumOr(FlexFit.values, FlexFit.loose),
      child: _widgetsMap[child]! as Widget);
  return _createFlexibleObjSt(w);
}
FlexibleObjSt _createFlexibleObjSt(Flexible? w) {
  final FlexibleObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.flex = w.flex;
  stObj.fit = w.fit.index;
  return stObj;
}

void _setupSafeArea(WidgetFactories f) {
  f.safeArea.safeArea = ffi.Pointer.fromFunction(safeAreaSafeArea);
}
SafeAreaObjSt safeAreaSafeArea(ffi.Pointer<ffi.Int> left, ffi.Pointer<ffi.Int> top, ffi.Pointer<ffi.Int> right, ffi.Pointer<ffi.Int> bottom, ffi.Pointer<DartObj> minimum, ffi.Pointer<ffi.Int> maintainBottomViewPadding, DartDartObj child) {
  final w = SafeArea(left: left.boolOr(true),
      top: top.boolOr(true),
      right: right.boolOr(true),
      bottom: bottom.boolOr(true),
      minimum: minimum.objOr(EdgeInsets.zero),
      maintainBottomViewPadding: maintainBottomViewPadding.boolOr(false),
      child: _widgetsMap[child]! as Widget);
  return _createSafeAreaObjSt(w);
}
SafeAreaObjSt _createSafeAreaObjSt(SafeArea? w) {
  final SafeAreaObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.left = w.left.toInt();
  stObj.top = w.top.toInt();
  stObj.right = w.right.toInt();
  stObj.bottom = w.bottom.toInt();
  stObj.minimum = _createEdgeInsetsObjSt(w.minimum);
  stObj.maintainBottomViewPadding = w.maintainBottomViewPadding.toInt();
  stObj.child = _addWidget(w.child);
  return stObj;
}

void _setupRotationTransition(WidgetFactories f) {
  f.rotationTransition.rotationTransition = ffi.Pointer.fromFunction(rotationTransitionRotationTransition);
}
RotationTransitionObjSt rotationTransitionRotationTransition(DartDartObj turns, ffi.Pointer<DartObj> alignment, ffi.Pointer<ffi.Int> filterQuality, ffi.Pointer<DartObj> child) {
  final w = RotationTransition(turns: _widgetsMap[turns]! as Animation<double>,
      alignment: alignment.objOr(Alignment.center),
      filterQuality: filterQuality.enumOrNul(FilterQuality.values),
      child: child.objOrNul());
  return _createRotationTransitionObjSt(w);
}
RotationTransitionObjSt _createRotationTransitionObjSt(RotationTransition? w) {
  final RotationTransitionObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.turns = _addWidget(w.turns);
  return stObj;
}

void _setupFadeTransition(WidgetFactories f) {
  f.fadeTransition.fadeTransition = ffi.Pointer.fromFunction(fadeTransitionFadeTransition);
}
FadeTransitionObjSt fadeTransitionFadeTransition(DartDartObj opacity, ffi.Pointer<ffi.Int> alwaysIncludeSemantics, ffi.Pointer<DartObj> child) {
  final w = FadeTransition(opacity: _widgetsMap[opacity]! as Animation<double>,
      alwaysIncludeSemantics: alwaysIncludeSemantics.boolOr(false),
      child: child.objOrNul());
  return _createFadeTransitionObjSt(w);
}
FadeTransitionObjSt _createFadeTransitionObjSt(FadeTransition? w) {
  final FadeTransitionObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.opacity = _addWidget(w.opacity);
  stObj.alwaysIncludeSemantics = w.alwaysIncludeSemantics.toInt();
  return stObj;
}

void _setupScaleTransition(WidgetFactories f) {
  f.scaleTransition.scaleTransition = ffi.Pointer.fromFunction(scaleTransitionScaleTransition);
}
ScaleTransitionObjSt scaleTransitionScaleTransition(DartDartObj scale, ffi.Pointer<DartObj> alignment, ffi.Pointer<ffi.Int> filterQuality, ffi.Pointer<DartObj> child) {
  final w = ScaleTransition(scale: _widgetsMap[scale]! as Animation<double>,
      alignment: alignment.objOr(Alignment.center),
      filterQuality: filterQuality.enumOrNul(FilterQuality.values),
      child: child.objOrNul());
  return _createScaleTransitionObjSt(w);
}
ScaleTransitionObjSt _createScaleTransitionObjSt(ScaleTransition? w) {
  final ScaleTransitionObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.scale = _addWidget(w.scale);
  return stObj;
}

void _setupAspectRatio(WidgetFactories f) {
  f.aspectRatio.aspectRatio = ffi.Pointer.fromFunction(aspectRatioAspectRatio);
}
AspectRatioObjSt aspectRatioAspectRatio(double aspectRatio, ffi.Pointer<DartObj> child) {
  final w = AspectRatio(aspectRatio: aspectRatio,
      child: child.objOrNul());
  return _createAspectRatioObjSt(w);
}
AspectRatioObjSt _createAspectRatioObjSt(AspectRatio? w) {
  final AspectRatioObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.aspectRatio = w.aspectRatio;
  return stObj;
}

void _setupClipOval(WidgetFactories f) {
  f.clipOval.clipOval = ffi.Pointer.fromFunction(clipOvalClipOval);
}
ClipOvalObjSt clipOvalClipOval(ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<DartObj> child) {
  final w = ClipOval(clipBehavior: clipBehavior.enumOr(Clip.values, Clip.antiAlias),
      child: child.objOrNul());
  return _createClipOvalObjSt(w);
}
ClipOvalObjSt _createClipOvalObjSt(ClipOval? w) {
  final ClipOvalObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.clipBehavior = w.clipBehavior.index;
  return stObj;
}

void _setupClipRRect(WidgetFactories f) {
  f.clipRRect.clipRRect = ffi.Pointer.fromFunction(clipRRectClipRRect);
}
ClipRRectObjSt clipRRectClipRRect(ffi.Pointer<DartObj> borderRadius, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<DartObj> child) {
  final w = ClipRRect(borderRadius: borderRadius.objOr(BorderRadius.zero),
      clipBehavior: clipBehavior.enumOr(Clip.values, Clip.antiAlias),
      child: child.objOrNul());
  return _createClipRRectObjSt(w);
}
ClipRRectObjSt _createClipRRectObjSt(ClipRRect? w) {
  final ClipRRectObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.borderRadius = _addWidget(w.borderRadius);
  stObj.clipBehavior = w.clipBehavior.index;
  return stObj;
}

void _setupClipRect(WidgetFactories f) {
  f.clipRect.clipRect = ffi.Pointer.fromFunction(clipRectClipRect);
}
ClipRectObjSt clipRectClipRect(ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<DartObj> child) {
  final w = ClipRect(clipBehavior: clipBehavior.enumOr(Clip.values, Clip.hardEdge),
      child: child.objOrNul());
  return _createClipRectObjSt(w);
}
ClipRectObjSt _createClipRectObjSt(ClipRect? w) {
  final ClipRectObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.clipBehavior = w.clipBehavior.index;
  return stObj;
}

void _setupClipRSuperellipse(WidgetFactories f) {
  f.clipRSuperellipse.clipRSuperellipse = ffi.Pointer.fromFunction(clipRSuperellipseClipRSuperellipse);
}
ClipRSuperellipseObjSt clipRSuperellipseClipRSuperellipse(ffi.Pointer<DartObj> borderRadius, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<DartObj> child) {
  final w = ClipRSuperellipse(borderRadius: borderRadius.objOr(BorderRadius.zero),
      clipBehavior: clipBehavior.enumOr(Clip.values, Clip.antiAlias),
      child: child.objOrNul());
  return _createClipRSuperellipseObjSt(w);
}
ClipRSuperellipseObjSt _createClipRSuperellipseObjSt(ClipRSuperellipse? w) {
  final ClipRSuperellipseObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.borderRadius = _addWidget(w.borderRadius);
  stObj.clipBehavior = w.clipBehavior.index;
  return stObj;
}

void _setupColoredBox(WidgetFactories f) {
  f.coloredBox.coloredBox = ffi.Pointer.fromFunction(coloredBoxColoredBox);
}
ColoredBoxObjSt coloredBoxColoredBox(DartDartObj color, ffi.Pointer<DartObj> child) {
  final w = ColoredBox(color: _widgetsMap[color]! as Color,
      child: child.objOrNul());
  return _createColoredBoxObjSt(w);
}
ColoredBoxObjSt _createColoredBoxObjSt(ColoredBox? w) {
  final ColoredBoxObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.color = _addWidget(w.color);
  return stObj;
}

void _setupConstrainedBox(WidgetFactories f) {
  f.constrainedBox.constrainedBox = ffi.Pointer.fromFunction(constrainedBoxConstrainedBox);
}
ConstrainedBoxObjSt constrainedBoxConstrainedBox(DartDartObj constraints, ffi.Pointer<DartObj> child) {
  final w = ConstrainedBox(constraints: _widgetsMap[constraints]! as BoxConstraints,
      child: child.objOrNul());
  return _createConstrainedBoxObjSt(w);
}
ConstrainedBoxObjSt _createConstrainedBoxObjSt(ConstrainedBox? w) {
  final ConstrainedBoxObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.constraints = _createBoxConstraintsObjSt(w.constraints);
  return stObj;
}

void _setupDecoratedBox(WidgetFactories f) {
  f.decoratedBox.decoratedBox = ffi.Pointer.fromFunction(decoratedBoxDecoratedBox);
}
DecoratedBoxObjSt decoratedBoxDecoratedBox(DartDartObj decoration, ffi.Pointer<ffi.Int> position, ffi.Pointer<DartObj> child) {
  final w = DecoratedBox(decoration: _widgetsMap[decoration]! as Decoration,
      position: position.enumOr(DecorationPosition.values, DecorationPosition.background),
      child: child.objOrNul());
  return _createDecoratedBoxObjSt(w);
}
DecoratedBoxObjSt _createDecoratedBoxObjSt(DecoratedBox? w) {
  final DecoratedBoxObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.decoration = _addWidget(w.decoration);
  stObj.position = w.position.index;
  return stObj;
}

void _setupFittedBox(WidgetFactories f) {
  f.fittedBox.fittedBox = ffi.Pointer.fromFunction(fittedBoxFittedBox);
}
FittedBoxObjSt fittedBoxFittedBox(ffi.Pointer<ffi.Int> fit, ffi.Pointer<DartObj> alignment, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<DartObj> child) {
  final w = FittedBox(fit: fit.enumOr(BoxFit.values, BoxFit.contain),
      alignment: alignment.objOr(Alignment.center),
      clipBehavior: clipBehavior.enumOr(Clip.values, Clip.none),
      child: child.objOrNul());
  return _createFittedBoxObjSt(w);
}
FittedBoxObjSt _createFittedBoxObjSt(FittedBox? w) {
  final FittedBoxObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.fit = w.fit.index;
  stObj.alignment = _addWidget(w.alignment);
  stObj.clipBehavior = w.clipBehavior.index;
  return stObj;
}

void _setupFractionallySizedBox(WidgetFactories f) {
  f.fractionallySizedBox.fractionallySizedBox = ffi.Pointer.fromFunction(fractionallySizedBoxFractionallySizedBox);
}
FractionallySizedBoxObjSt fractionallySizedBoxFractionallySizedBox(ffi.Pointer<DartObj> alignment, ffi.Pointer<ffi.Double> widthFactor, ffi.Pointer<ffi.Double> heightFactor, ffi.Pointer<DartObj> child) {
  final w = FractionallySizedBox(alignment: alignment.objOr(Alignment.center),
      widthFactor: widthFactor.doubleOrNul(),
      heightFactor: heightFactor.doubleOrNul(),
      child: child.objOrNul());
  return _createFractionallySizedBoxObjSt(w);
}
FractionallySizedBoxObjSt _createFractionallySizedBoxObjSt(FractionallySizedBox? w) {
  final FractionallySizedBoxObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.widthFactor = (w.widthFactor != null) ? w.widthFactor! : 0;
  stObj.heightFactor = (w.heightFactor != null) ? w.heightFactor! : 0;
  stObj.alignment = _addWidget(w.alignment);
  return stObj;
}

void _setupIntrinsicHeight(WidgetFactories f) {
  f.intrinsicHeight.intrinsicHeight = ffi.Pointer.fromFunction(intrinsicHeightIntrinsicHeight);
}
IntrinsicHeightObjSt intrinsicHeightIntrinsicHeight(ffi.Pointer<DartObj> child) {
  final w = IntrinsicHeight(child: child.objOrNul());
  return _createIntrinsicHeightObjSt(w);
}
IntrinsicHeightObjSt _createIntrinsicHeightObjSt(IntrinsicHeight? w) {
  final IntrinsicHeightObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  return stObj;
}

void _setupIntrinsicWidth(WidgetFactories f) {
  f.intrinsicWidth.intrinsicWidth = ffi.Pointer.fromFunction(intrinsicWidthIntrinsicWidth);
}
IntrinsicWidthObjSt intrinsicWidthIntrinsicWidth(ffi.Pointer<ffi.Double> stepWidth, ffi.Pointer<ffi.Double> stepHeight, ffi.Pointer<DartObj> child) {
  final w = IntrinsicWidth(stepWidth: stepWidth.doubleOrNul(),
      stepHeight: stepHeight.doubleOrNul(),
      child: child.objOrNul());
  return _createIntrinsicWidthObjSt(w);
}
IntrinsicWidthObjSt _createIntrinsicWidthObjSt(IntrinsicWidth? w) {
  final IntrinsicWidthObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.stepWidth = (w.stepWidth != null) ? w.stepWidth! : 0;
  stObj.stepHeight = (w.stepHeight != null) ? w.stepHeight! : 0;
  return stObj;
}

void _setupLimitedBox(WidgetFactories f) {
  f.limitedBox.limitedBox = ffi.Pointer.fromFunction(limitedBoxLimitedBox);
}
LimitedBoxObjSt limitedBoxLimitedBox(ffi.Pointer<ffi.Double> maxWidth, ffi.Pointer<ffi.Double> maxHeight, ffi.Pointer<DartObj> child) {
  final w = LimitedBox(maxWidth: maxWidth.doubleOr(double.infinity),
      maxHeight: maxHeight.doubleOr(double.infinity),
      child: child.objOrNul());
  return _createLimitedBoxObjSt(w);
}
LimitedBoxObjSt _createLimitedBoxObjSt(LimitedBox? w) {
  final LimitedBoxObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.maxWidth = w.maxWidth;
  stObj.maxHeight = w.maxHeight;
  return stObj;
}

void _setupPlaceholder(WidgetFactories f) {
  f.placeholder.placeholder = ffi.Pointer.fromFunction(placeholderPlaceholder);
}
PlaceholderObjSt placeholderPlaceholder(ffi.Pointer<DartObj> color, ffi.Pointer<ffi.Double> strokeWidth, ffi.Pointer<ffi.Double> fallbackWidth, ffi.Pointer<ffi.Double> fallbackHeight, ffi.Pointer<DartObj> child) {
  final w = Placeholder(color: color.objOr(const Color(0xFF455A64)),
      strokeWidth: strokeWidth.doubleOr(2.0),
      fallbackWidth: fallbackWidth.doubleOr(400.0),
      fallbackHeight: fallbackHeight.doubleOr(400.0),
      child: child.objOrNul());
  return _createPlaceholderObjSt(w);
}
PlaceholderObjSt _createPlaceholderObjSt(Placeholder? w) {
  final PlaceholderObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.color = _addWidget(w.color);
  stObj.strokeWidth = w.strokeWidth;
  stObj.fallbackWidth = w.fallbackWidth;
  stObj.fallbackHeight = w.fallbackHeight;
  stObj.child = _addWidget(w.child);
  return stObj;
}

void _setupSpacer(WidgetFactories f) {
  f.spacer.spacer = ffi.Pointer.fromFunction(spacerSpacer);
}
SpacerObjSt spacerSpacer(ffi.Pointer<ffi.Int> flex) {
  final w = Spacer(flex: flex.intOr(1));
  return _createSpacerObjSt(w);
}
SpacerObjSt _createSpacerObjSt(Spacer? w) {
  final SpacerObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.flex = w.flex;
  return stObj;
}

void _setupVisibility(WidgetFactories f) {
  f.visibility.visibility = ffi.Pointer.fromFunction(visibilityVisibility);
  f.visibility.maintain = ffi.Pointer.fromFunction(visibilityMaintain);
  f.visibility.of = ffi.Pointer.fromFunction(visibilityOf, exception);
}
VisibilityObjSt visibilityVisibility(DartDartObj child, ffi.Pointer<DartObj> replacement, ffi.Pointer<ffi.Int> visible, ffi.Pointer<ffi.Int> maintainState, ffi.Pointer<ffi.Int> maintainAnimation, ffi.Pointer<ffi.Int> maintainSize, ffi.Pointer<ffi.Int> maintainSemantics, ffi.Pointer<ffi.Int> maintainInteractivity, ffi.Pointer<ffi.Int> maintainFocusability) {
  final w = Visibility(child: _widgetsMap[child]! as Widget,
      replacement: replacement.objOr(const SizedBox.shrink()),
      visible: visible.boolOr(true),
      maintainState: maintainState.boolOr(false),
      maintainAnimation: maintainAnimation.boolOr(false),
      maintainSize: maintainSize.boolOr(false),
      maintainSemantics: maintainSemantics.boolOr(false),
      maintainInteractivity: maintainInteractivity.boolOr(false),
      maintainFocusability: maintainFocusability.boolOr(false));
  return _createVisibilityObjSt(w);
}
VisibilityObjSt visibilityMaintain(DartDartObj child, ffi.Pointer<ffi.Int> visible) {
  final w = Visibility.maintain(child: _widgetsMap[child]! as Widget,
      visible: visible.boolOr(true));
  return _createVisibilityObjSt(w);
}
int visibilityOf(DartDartObj context) {
  final w = Visibility.of(_widgetsMap[context]! as BuildContext);
  return w.toInt();
}
VisibilityObjSt _createVisibilityObjSt(Visibility? w) {
  final VisibilityObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.child = _addWidget(w.child);
  stObj.replacement = _addWidget(w.replacement);
  stObj.visible = w.visible.toInt();
  stObj.maintainState = w.maintainState.toInt();
  stObj.maintainAnimation = w.maintainAnimation.toInt();
  stObj.maintainSize = w.maintainSize.toInt();
  stObj.maintainSemantics = w.maintainSemantics.toInt();
  stObj.maintainInteractivity = w.maintainInteractivity.toInt();
  stObj.maintainFocusability = w.maintainFocusability.toInt();
  return stObj;
}

void _setupRotatedBox(WidgetFactories f) {
  f.rotatedBox.rotatedBox = ffi.Pointer.fromFunction(rotatedBoxRotatedBox);
}
RotatedBoxObjSt rotatedBoxRotatedBox(int quarterTurns, ffi.Pointer<DartObj> child) {
  final w = RotatedBox(quarterTurns: quarterTurns,
      child: child.objOrNul());
  return _createRotatedBoxObjSt(w);
}
RotatedBoxObjSt _createRotatedBoxObjSt(RotatedBox? w) {
  final RotatedBoxObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.quarterTurns = w.quarterTurns;
  return stObj;
}

void _setupBaseline(WidgetFactories f) {
  f.baseline.baseline = ffi.Pointer.fromFunction(baselineBaseline);
}
BaselineObjSt baselineBaseline(double baseline, int baselineType, ffi.Pointer<DartObj> child) {
  final w = Baseline(baseline: baseline,
      baselineType: TextBaseline.values[baselineType],
      child: child.objOrNul());
  return _createBaselineObjSt(w);
}
BaselineObjSt _createBaselineObjSt(Baseline? w) {
  final BaselineObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.baseline = w.baseline;
  stObj.baselineType = w.baselineType.index;
  return stObj;
}

void _setupDefaultTextStyle(WidgetFactories f) {
  f.defaultTextStyle.defaultTextStyle = ffi.Pointer.fromFunction(defaultTextStyleDefaultTextStyle);
  f.defaultTextStyle.fallback = ffi.Pointer.fromFunction(defaultTextStyleFallback);
  f.defaultTextStyle.merge = ffi.Pointer.fromFunction(defaultTextStyleMerge, exception);
  f.defaultTextStyle.of = ffi.Pointer.fromFunction(defaultTextStyleOf);
}
DefaultTextStyleObjSt defaultTextStyleDefaultTextStyle(DartDartObj style, ffi.Pointer<ffi.Int> textAlign, ffi.Pointer<ffi.Int> softWrap, ffi.Pointer<ffi.Int> overflow, ffi.Pointer<ffi.Int> maxLines, ffi.Pointer<ffi.Int> textWidthBasis, DartDartObj child) {
  final w = DefaultTextStyle(style: _widgetsMap[style]! as TextStyle,
      textAlign: textAlign.enumOrNul(TextAlign.values),
      softWrap: softWrap.boolOr(true),
      overflow: overflow.enumOr(TextOverflow.values, TextOverflow.clip),
      maxLines: maxLines.intOrNul(),
      textWidthBasis: textWidthBasis.enumOr(TextWidthBasis.values, TextWidthBasis.parent),
      child: _widgetsMap[child]! as Widget);
  return _createDefaultTextStyleObjSt(w);
}
DefaultTextStyleObjSt defaultTextStyleFallback() {
  final w = DefaultTextStyle.fallback();
  return _createDefaultTextStyleObjSt(w);
}
int defaultTextStyleMerge(ffi.Pointer<DartObj> style, ffi.Pointer<ffi.Int> textAlign, ffi.Pointer<ffi.Int> softWrap, ffi.Pointer<ffi.Int> overflow, ffi.Pointer<ffi.Int> maxLines, ffi.Pointer<ffi.Int> textWidthBasis, DartDartObj child) {
  final w = DefaultTextStyle.merge(style: style.objOrNul(),
      textAlign: textAlign.enumOrNul(TextAlign.values),
      softWrap: softWrap.boolOrNul(),
      overflow: overflow.enumOrNul(TextOverflow.values),
      maxLines: maxLines.intOrNul(),
      textWidthBasis: textWidthBasis.enumOrNul(TextWidthBasis.values),
      child: _widgetsMap[child]! as Widget);
  return _addWidget(w);
}
DefaultTextStyleObjSt defaultTextStyleOf(DartDartObj context) {
  final w = DefaultTextStyle.of(_widgetsMap[context]! as BuildContext);
  return _createDefaultTextStyleObjSt(w);
}
DefaultTextStyleObjSt _createDefaultTextStyleObjSt(DefaultTextStyle? w) {
  final DefaultTextStyleObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.style = _createTextStyleObjSt(w.style);
  stObj.textAlign = (w.textAlign != null) ? w.textAlign!.index : 0;
  stObj.softWrap = w.softWrap.toInt();
  stObj.overflow = w.overflow.index;
  stObj.maxLines = (w.maxLines != null) ? w.maxLines! : 0;
  stObj.textWidthBasis = w.textWidthBasis.index;
  return stObj;
}

void _setupDirectionality(WidgetFactories f) {
  f.directionality.directionality = ffi.Pointer.fromFunction(directionalityDirectionality);
  f.directionality.of = ffi.Pointer.fromFunction(directionalityOf, exception);
  f.directionality.maybeOf = ffi.Pointer.fromFunction(directionalityMaybeOf, exception);
}
DirectionalityObjSt directionalityDirectionality(int textDirection, DartDartObj child) {
  final w = Directionality(textDirection: TextDirection.values[textDirection],
      child: _widgetsMap[child]! as Widget);
  return _createDirectionalityObjSt(w);
}
int directionalityOf(DartDartObj context) {
  final w = Directionality.of(_widgetsMap[context]! as BuildContext);
  return w.index;
}
int directionalityMaybeOf(DartDartObj context) {
  final w = Directionality.maybeOf(_widgetsMap[context]! as BuildContext);
  return (w != null) ? w!.index : 0;
}
DirectionalityObjSt _createDirectionalityObjSt(Directionality? w) {
  final DirectionalityObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.textDirection = w.textDirection.index;
  return stObj;
}

void _setupOverflowBox(WidgetFactories f) {
  f.overflowBox.overflowBox = ffi.Pointer.fromFunction(overflowBoxOverflowBox);
}
OverflowBoxObjSt overflowBoxOverflowBox(ffi.Pointer<DartObj> alignment, ffi.Pointer<ffi.Double> minWidth, ffi.Pointer<ffi.Double> maxWidth, ffi.Pointer<ffi.Double> minHeight, ffi.Pointer<ffi.Double> maxHeight, ffi.Pointer<ffi.Int> fit, ffi.Pointer<DartObj> child) {
  final w = OverflowBox(alignment: alignment.objOr(Alignment.center),
      minWidth: minWidth.doubleOrNul(),
      maxWidth: maxWidth.doubleOrNul(),
      minHeight: minHeight.doubleOrNul(),
      maxHeight: maxHeight.doubleOrNul(),
      fit: fit.enumOr(OverflowBoxFit.values, OverflowBoxFit.max),
      child: child.objOrNul());
  return _createOverflowBoxObjSt(w);
}
OverflowBoxObjSt _createOverflowBoxObjSt(OverflowBox? w) {
  final OverflowBoxObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.alignment = _addWidget(w.alignment);
  stObj.minWidth = (w.minWidth != null) ? w.minWidth! : 0;
  stObj.maxWidth = (w.maxWidth != null) ? w.maxWidth! : 0;
  stObj.minHeight = (w.minHeight != null) ? w.minHeight! : 0;
  stObj.maxHeight = (w.maxHeight != null) ? w.maxHeight! : 0;
  stObj.fit = w.fit.index;
  return stObj;
}

void _setupAbsorbPointer(WidgetFactories f) {
  f.absorbPointer.absorbPointer = ffi.Pointer.fromFunction(absorbPointerAbsorbPointer);
}
AbsorbPointerObjSt absorbPointerAbsorbPointer(ffi.Pointer<ffi.Int> absorbing, ffi.Pointer<ffi.Int> ignoringSemantics, ffi.Pointer<DartObj> child) {
  final w = AbsorbPointer(absorbing: absorbing.boolOr(true),
      ignoringSemantics: ignoringSemantics.boolOrNul(),
      child: child.objOrNul());
  return _createAbsorbPointerObjSt(w);
}
AbsorbPointerObjSt _createAbsorbPointerObjSt(AbsorbPointer? w) {
  final AbsorbPointerObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.absorbing = w.absorbing.toInt();
  stObj.ignoringSemantics = (w.ignoringSemantics != null) ? w.ignoringSemantics!.toInt() : 0;
  return stObj;
}

void _setupIgnorePointer(WidgetFactories f) {
  f.ignorePointer.ignorePointer = ffi.Pointer.fromFunction(ignorePointerIgnorePointer);
}
IgnorePointerObjSt ignorePointerIgnorePointer(ffi.Pointer<ffi.Int> ignoring, ffi.Pointer<ffi.Int> ignoringSemantics, ffi.Pointer<DartObj> child) {
  final w = IgnorePointer(ignoring: ignoring.boolOr(true),
      ignoringSemantics: ignoringSemantics.boolOrNul(),
      child: child.objOrNul());
  return _createIgnorePointerObjSt(w);
}
IgnorePointerObjSt _createIgnorePointerObjSt(IgnorePointer? w) {
  final IgnorePointerObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.ignoring = w.ignoring.toInt();
  stObj.ignoringSemantics = (w.ignoringSemantics != null) ? w.ignoringSemantics!.toInt() : 0;
  return stObj;
}

void _setupRepaintBoundary(WidgetFactories f) {
  f.repaintBoundary.repaintBoundary = ffi.Pointer.fromFunction(repaintBoundaryRepaintBoundary);
  f.repaintBoundary.wrap = ffi.Pointer.fromFunction(repaintBoundaryWrap);
}
RepaintBoundaryObjSt repaintBoundaryRepaintBoundary(ffi.Pointer<DartObj> child) {
  final w = RepaintBoundary(child: child.objOrNul());
  return _createRepaintBoundaryObjSt(w);
}
RepaintBoundaryObjSt repaintBoundaryWrap(DartDartObj child, int childIndex) {
  final w = RepaintBoundary.wrap(_widgetsMap[child]! as Widget,
      childIndex);
  return _createRepaintBoundaryObjSt(w);
}
RepaintBoundaryObjSt _createRepaintBoundaryObjSt(RepaintBoundary? w) {
  final RepaintBoundaryObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  return stObj;
}

void _setupFractionalTranslation(WidgetFactories f) {
  f.fractionalTranslation.fractionalTranslation = ffi.Pointer.fromFunction(fractionalTranslationFractionalTranslation);
}
FractionalTranslationObjSt fractionalTranslationFractionalTranslation(DartDartObj translation, ffi.Pointer<ffi.Int> transformHitTests, ffi.Pointer<DartObj> child) {
  final w = FractionalTranslation(translation: _widgetsMap[translation]! as Offset,
      transformHitTests: transformHitTests.boolOr(true),
      child: child.objOrNul());
  return _createFractionalTranslationObjSt(w);
}
FractionalTranslationObjSt _createFractionalTranslationObjSt(FractionalTranslation? w) {
  final FractionalTranslationObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.translation = _addWidget(w.translation);
  stObj.transformHitTests = w.transformHitTests.toInt();
  return stObj;
}

void _setupUnconstrainedBox(WidgetFactories f) {
  f.unconstrainedBox.unconstrainedBox = ffi.Pointer.fromFunction(unconstrainedBoxUnconstrainedBox);
}
UnconstrainedBoxObjSt unconstrainedBoxUnconstrainedBox(ffi.Pointer<DartObj> child, ffi.Pointer<ffi.Int> textDirection, ffi.Pointer<DartObj> alignment, ffi.Pointer<ffi.Int> constrainedAxis, ffi.Pointer<ffi.Int> clipBehavior) {
  final w = UnconstrainedBox(child: child.objOrNul(),
      textDirection: textDirection.enumOrNul(TextDirection.values),
      alignment: alignment.objOr(Alignment.center),
      constrainedAxis: constrainedAxis.enumOrNul(Axis.values),
      clipBehavior: clipBehavior.enumOr(Clip.values, Clip.none));
  return _createUnconstrainedBoxObjSt(w);
}
UnconstrainedBoxObjSt _createUnconstrainedBoxObjSt(UnconstrainedBox? w) {
  final UnconstrainedBoxObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.textDirection = (w.textDirection != null) ? w.textDirection!.index : 0;
  stObj.alignment = _addWidget(w.alignment);
  stObj.constrainedAxis = (w.constrainedAxis != null) ? w.constrainedAxis!.index : 0;
  stObj.clipBehavior = w.clipBehavior.index;
  stObj.child = _addWidget(w.child);
  return stObj;
}

void _setupFlutterLogo(WidgetFactories f) {
  f.flutterLogo.flutterLogo = ffi.Pointer.fromFunction(flutterLogoFlutterLogo);
}
FlutterLogoObjSt flutterLogoFlutterLogo(ffi.Pointer<ffi.Double> size, ffi.Pointer<DartObj> textColor, ffi.Pointer<ffi.Int> style, ffi.Pointer<DartObj> duration, ffi.Pointer<DartObj> curve) {
  final w = FlutterLogo(size: size.doubleOrNul(),
      textColor: textColor.objOr(const Color(0xFF757575)),
      style: style.enumOr(FlutterLogoStyle.values, FlutterLogoStyle.markOnly),
      duration: duration.objOr(const Duration(milliseconds: 750)),
      curve: curve.objOr(Curves.fastOutSlowIn));
  return _createFlutterLogoObjSt(w);
}
FlutterLogoObjSt _createFlutterLogoObjSt(FlutterLogo? w) {
  final FlutterLogoObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.size = (w.size != null) ? w.size! : 0;
  stObj.textColor = _addWidget(w.textColor);
  stObj.style = w.style.index;
  stObj.duration = _addWidget(w.duration);
  stObj.curve = _addWidget(w.curve);
  return stObj;
}

void _setupPhysicalModel(WidgetFactories f) {
  f.physicalModel.physicalModel = ffi.Pointer.fromFunction(physicalModelPhysicalModel);
}
PhysicalModelObjSt physicalModelPhysicalModel(ffi.Pointer<ffi.Int> shape, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<DartObj> borderRadius, ffi.Pointer<ffi.Double> elevation, DartDartObj color, ffi.Pointer<DartObj> shadowColor, ffi.Pointer<DartObj> child) {
  final w = PhysicalModel(shape: shape.enumOr(BoxShape.values, BoxShape.rectangle),
      clipBehavior: clipBehavior.enumOr(Clip.values, Clip.none),
      borderRadius: borderRadius.objOrNul(),
      elevation: elevation.doubleOr(0.0),
      color: _widgetsMap[color]! as Color,
      shadowColor: shadowColor.objOr(const Color(0xFF000000)),
      child: child.objOrNul());
  return _createPhysicalModelObjSt(w);
}
PhysicalModelObjSt _createPhysicalModelObjSt(PhysicalModel? w) {
  final PhysicalModelObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.shape = w.shape.index;
  stObj.clipBehavior = w.clipBehavior.index;
  stObj.borderRadius = _createBorderRadiusObjSt(w.borderRadius);
  stObj.elevation = w.elevation;
  stObj.color = _addWidget(w.color);
  stObj.shadowColor = _addWidget(w.shadowColor);
  return stObj;
}

void _setupBanner(WidgetFactories f) {
  f.banner.banner = ffi.Pointer.fromFunction(bannerBanner);
}
BannerObjSt bannerBanner(ffi.Pointer<DartObj> child, ffi.Pointer<ffi.Char> message, ffi.Pointer<ffi.Int> textDirection, int location, ffi.Pointer<ffi.Int> layoutDirection, ffi.Pointer<DartObj> color, ffi.Pointer<DartObj> shadow) {
  final w = Banner(child: child.objOrNul(),
      message: message.cast<Utf8>().toDartString(),
      textDirection: textDirection.enumOrNul(TextDirection.values),
      location: BannerLocation.values[location],
      layoutDirection: layoutDirection.enumOrNul(TextDirection.values),
      color: color.objOr(Color(0xA0B71C1C)),
      shadow: shadow.objOr(BoxShadow(color: Color(0x7F000000), blurRadius: 6.0)));
  return _createBannerObjSt(w);
}
BannerObjSt _createBannerObjSt(Banner? w) {
  final BannerObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.child = _addWidget(w.child);
  stObj.message = w.message.toNativeUtf8().cast<ffi.Char>();
  stObj.textDirection = (w.textDirection != null) ? w.textDirection!.index : 0;
  stObj.location = w.location.index;
  stObj.layoutDirection = (w.layoutDirection != null) ? w.layoutDirection!.index : 0;
  stObj.color = _addWidget(w.color);
  stObj.textStyle = _createTextStyleObjSt(w.textStyle);
  stObj.shadow = _createBoxShadowObjSt(w.shadow);
  return stObj;
}

void _setupAnimatedContainer(WidgetFactories f) {
  f.animatedContainer.animatedContainer = ffi.Pointer.fromFunction(animatedContainerAnimatedContainer);
}
AnimatedContainerObjSt animatedContainerAnimatedContainer(ffi.Pointer<DartObj> alignment, ffi.Pointer<DartObj> padding, ffi.Pointer<DartObj> color, ffi.Pointer<DartObj> decoration, ffi.Pointer<DartObj> foregroundDecoration, ffi.Pointer<ffi.Double> width, ffi.Pointer<ffi.Double> height, ffi.Pointer<DartObj> constraints, ffi.Pointer<DartObj> margin, ffi.Pointer<DartObj> transformAlignment, ffi.Pointer<DartObj> child, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<DartObj> curve, DartDartObj duration, ffi.Pointer<VoidCallbackFFI> onEnd) {
  final w = AnimatedContainer(alignment: alignment.objOrNul(),
      padding: padding.objOrNul(),
      color: color.objOrNul(),
      decoration: decoration.objOrNul(),
      foregroundDecoration: foregroundDecoration.objOrNul(),
      width: width.doubleOrNul(),
      height: height.doubleOrNul(),
      constraints: constraints.objOrNul(),
      margin: margin.objOrNul(),
      transformAlignment: transformAlignment.objOrNul(),
      child: child.objOrNul(),
      clipBehavior: clipBehavior.enumOr(Clip.values, Clip.none),
      curve: curve.objOr(Curves.linear),
      duration: _widgetsMap[duration]! as Duration,
      onEnd: onEnd.toVoidCallbackFn());
  return _createAnimatedContainerObjSt(w);
}
AnimatedContainerObjSt _createAnimatedContainerObjSt(AnimatedContainer? w) {
  final AnimatedContainerObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.child = _addWidget(w.child);
  stObj.alignment = _addWidget(w.alignment);
  stObj.padding = _addWidget(w.padding);
  stObj.decoration = _addWidget(w.decoration);
  stObj.foregroundDecoration = _addWidget(w.foregroundDecoration);
  stObj.constraints = _createBoxConstraintsObjSt(w.constraints);
  stObj.margin = _addWidget(w.margin);
  stObj.transformAlignment = _addWidget(w.transformAlignment);
  stObj.clipBehavior = w.clipBehavior.index;
  return stObj;
}

void _setupAnimatedOpacity(WidgetFactories f) {
  f.animatedOpacity.animatedOpacity = ffi.Pointer.fromFunction(animatedOpacityAnimatedOpacity);
}
AnimatedOpacityObjSt animatedOpacityAnimatedOpacity(ffi.Pointer<DartObj> child, double opacity, ffi.Pointer<DartObj> curve, DartDartObj duration, ffi.Pointer<VoidCallbackFFI> onEnd, ffi.Pointer<ffi.Int> alwaysIncludeSemantics) {
  final w = AnimatedOpacity(child: child.objOrNul(),
      opacity: opacity,
      curve: curve.objOr(Curves.linear),
      duration: _widgetsMap[duration]! as Duration,
      onEnd: onEnd.toVoidCallbackFn(),
      alwaysIncludeSemantics: alwaysIncludeSemantics.boolOr(false));
  return _createAnimatedOpacityObjSt(w);
}
AnimatedOpacityObjSt _createAnimatedOpacityObjSt(AnimatedOpacity? w) {
  final AnimatedOpacityObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.child = _addWidget(w.child);
  stObj.opacity = w.opacity;
  stObj.alwaysIncludeSemantics = w.alwaysIncludeSemantics.toInt();
  return stObj;
}

void _setupAnimatedPadding(WidgetFactories f) {
  f.animatedPadding.animatedPadding = ffi.Pointer.fromFunction(animatedPaddingAnimatedPadding);
}
AnimatedPaddingObjSt animatedPaddingAnimatedPadding(DartDartObj padding, ffi.Pointer<DartObj> child, ffi.Pointer<DartObj> curve, DartDartObj duration, ffi.Pointer<VoidCallbackFFI> onEnd) {
  final w = AnimatedPadding(padding: _widgetsMap[padding]! as EdgeInsetsGeometry,
      child: child.objOrNul(),
      curve: curve.objOr(Curves.linear),
      duration: _widgetsMap[duration]! as Duration,
      onEnd: onEnd.toVoidCallbackFn());
  return _createAnimatedPaddingObjSt(w);
}
AnimatedPaddingObjSt _createAnimatedPaddingObjSt(AnimatedPadding? w) {
  final AnimatedPaddingObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.padding = _addWidget(w.padding);
  stObj.child = _addWidget(w.child);
  return stObj;
}

void _setupAnimatedAlign(WidgetFactories f) {
  f.animatedAlign.animatedAlign = ffi.Pointer.fromFunction(animatedAlignAnimatedAlign);
}
AnimatedAlignObjSt animatedAlignAnimatedAlign(DartDartObj alignment, ffi.Pointer<DartObj> child, ffi.Pointer<ffi.Double> heightFactor, ffi.Pointer<ffi.Double> widthFactor, ffi.Pointer<DartObj> curve, DartDartObj duration, ffi.Pointer<VoidCallbackFFI> onEnd) {
  final w = AnimatedAlign(alignment: _widgetsMap[alignment]! as AlignmentGeometry,
      child: child.objOrNul(),
      heightFactor: heightFactor.doubleOrNul(),
      widthFactor: widthFactor.doubleOrNul(),
      curve: curve.objOr(Curves.linear),
      duration: _widgetsMap[duration]! as Duration,
      onEnd: onEnd.toVoidCallbackFn());
  return _createAnimatedAlignObjSt(w);
}
AnimatedAlignObjSt _createAnimatedAlignObjSt(AnimatedAlign? w) {
  final AnimatedAlignObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.alignment = _addWidget(w.alignment);
  stObj.child = _addWidget(w.child);
  stObj.heightFactor = (w.heightFactor != null) ? w.heightFactor! : 0;
  stObj.widthFactor = (w.widthFactor != null) ? w.widthFactor! : 0;
  return stObj;
}

void _setupListView(WidgetFactories f) {
  f.listView.listView = ffi.Pointer.fromFunction(listViewListView);
  f.listView.builder = ffi.Pointer.fromFunction(listViewBuilder);
  f.listView.separated = ffi.Pointer.fromFunction(listViewSeparated);
}
ListViewObjSt listViewListView(ffi.Pointer<ffi.Int> scrollDirection, ffi.Pointer<ffi.Int> reverse, ffi.Pointer<ffi.Int> primary, ffi.Pointer<ffi.Int> shrinkWrap, ffi.Pointer<DartObj> padding, ffi.Pointer<ffi.Double> itemExtent, ffi.Pointer<DartObj> prototypeItem, ffi.Pointer<ffi.Int> addAutomaticKeepAlives, ffi.Pointer<ffi.Int> addRepaintBoundaries, ffi.Pointer<ffi.Int> addSemanticIndexes, ffi.Pointer<ffi.Double> cacheExtent, ffi.Pointer<ArrayC> children, ffi.Pointer<ffi.Int> semanticChildCount, ffi.Pointer<ffi.Int> dragStartBehavior, ffi.Pointer<ffi.Int> keyboardDismissBehavior, ffi.Pointer<ffi.Char> restorationId, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<ffi.Int> hitTestBehavior) {
  final w = ListView(scrollDirection: scrollDirection.enumOr(Axis.values, Axis.vertical),
      reverse: reverse.boolOr(false),
      primary: primary.boolOrNul(),
      shrinkWrap: shrinkWrap.boolOr(false),
      padding: padding.objOrNul(),
      itemExtent: itemExtent.doubleOrNul(),
      prototypeItem: prototypeItem.objOrNul(),
      addAutomaticKeepAlives: addAutomaticKeepAlives.boolOr(true),
      addRepaintBoundaries: addRepaintBoundaries.boolOr(true),
      addSemanticIndexes: addSemanticIndexes.boolOr(true),
      cacheExtent: cacheExtent.doubleOrNul(),
      children: children.listOrEmpty(),
      semanticChildCount: semanticChildCount.intOrNul(),
      dragStartBehavior: dragStartBehavior.enumOr(DragStartBehavior.values, DragStartBehavior.start),
      keyboardDismissBehavior: keyboardDismissBehavior.enumOrNul(ScrollViewKeyboardDismissBehavior.values),
      restorationId: restorationId.strOrNul(),
      clipBehavior: clipBehavior.enumOr(Clip.values, Clip.hardEdge),
      hitTestBehavior: hitTestBehavior.enumOr(HitTestBehavior.values, HitTestBehavior.opaque));
  return _createListViewObjSt(w);
}
ListViewObjSt listViewBuilder(ffi.Pointer<ffi.Int> scrollDirection, ffi.Pointer<ffi.Int> reverse, ffi.Pointer<ffi.Int> primary, ffi.Pointer<ffi.Int> shrinkWrap, ffi.Pointer<DartObj> padding, ffi.Pointer<ffi.Double> itemExtent, ffi.Pointer<DartObj> prototypeItem, NullableIndexedWidgetBuilderFFI itemBuilder, ffi.Pointer<ffi.Int> itemCount, ffi.Pointer<ffi.Int> addAutomaticKeepAlives, ffi.Pointer<ffi.Int> addRepaintBoundaries, ffi.Pointer<ffi.Int> addSemanticIndexes, ffi.Pointer<ffi.Double> cacheExtent, ffi.Pointer<ffi.Int> semanticChildCount, ffi.Pointer<ffi.Int> dragStartBehavior, ffi.Pointer<ffi.Int> keyboardDismissBehavior, ffi.Pointer<ffi.Char> restorationId, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<ffi.Int> hitTestBehavior) {
  final w = ListView.builder(scrollDirection: scrollDirection.enumOr(Axis.values, Axis.vertical),
      reverse: reverse.boolOr(false),
      primary: primary.boolOrNul(),
      shrinkWrap: shrinkWrap.boolOr(false),
      padding: padding.objOrNul(),
      itemExtent: itemExtent.doubleOrNul(),
      prototypeItem: prototypeItem.objOrNul(),
      itemBuilder: itemBuilder.toNullableIndexedWidgetBuilderFn(),
      itemCount: itemCount.intOrNul(),
      addAutomaticKeepAlives: addAutomaticKeepAlives.boolOr(true),
      addRepaintBoundaries: addRepaintBoundaries.boolOr(true),
      addSemanticIndexes: addSemanticIndexes.boolOr(true),
      cacheExtent: cacheExtent.doubleOrNul(),
      semanticChildCount: semanticChildCount.intOrNul(),
      dragStartBehavior: dragStartBehavior.enumOr(DragStartBehavior.values, DragStartBehavior.start),
      keyboardDismissBehavior: keyboardDismissBehavior.enumOrNul(ScrollViewKeyboardDismissBehavior.values),
      restorationId: restorationId.strOrNul(),
      clipBehavior: clipBehavior.enumOr(Clip.values, Clip.hardEdge),
      hitTestBehavior: hitTestBehavior.enumOr(HitTestBehavior.values, HitTestBehavior.opaque));
  return _createListViewObjSt(w);
}
ListViewObjSt listViewSeparated(ffi.Pointer<ffi.Int> scrollDirection, ffi.Pointer<ffi.Int> reverse, ffi.Pointer<ffi.Int> primary, ffi.Pointer<ffi.Int> shrinkWrap, ffi.Pointer<DartObj> padding, NullableIndexedWidgetBuilderFFI itemBuilder, IndexedWidgetBuilderFFI separatorBuilder, int itemCount, ffi.Pointer<ffi.Int> addAutomaticKeepAlives, ffi.Pointer<ffi.Int> addRepaintBoundaries, ffi.Pointer<ffi.Int> addSemanticIndexes, ffi.Pointer<ffi.Double> cacheExtent, ffi.Pointer<ffi.Int> dragStartBehavior, ffi.Pointer<ffi.Int> keyboardDismissBehavior, ffi.Pointer<ffi.Char> restorationId, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<ffi.Int> hitTestBehavior) {
  final w = ListView.separated(scrollDirection: scrollDirection.enumOr(Axis.values, Axis.vertical),
      reverse: reverse.boolOr(false),
      primary: primary.boolOrNul(),
      shrinkWrap: shrinkWrap.boolOr(false),
      padding: padding.objOrNul(),
      itemBuilder: itemBuilder.toNullableIndexedWidgetBuilderFn(),
      separatorBuilder: separatorBuilder.toIndexedWidgetBuilderFn(),
      itemCount: itemCount,
      addAutomaticKeepAlives: addAutomaticKeepAlives.boolOr(true),
      addRepaintBoundaries: addRepaintBoundaries.boolOr(true),
      addSemanticIndexes: addSemanticIndexes.boolOr(true),
      cacheExtent: cacheExtent.doubleOrNul(),
      dragStartBehavior: dragStartBehavior.enumOr(DragStartBehavior.values, DragStartBehavior.start),
      keyboardDismissBehavior: keyboardDismissBehavior.enumOrNul(ScrollViewKeyboardDismissBehavior.values),
      restorationId: restorationId.strOrNul(),
      clipBehavior: clipBehavior.enumOr(Clip.values, Clip.hardEdge),
      hitTestBehavior: hitTestBehavior.enumOr(HitTestBehavior.values, HitTestBehavior.opaque));
  return _createListViewObjSt(w);
}
ListViewObjSt _createListViewObjSt(ListView? w) {
  final ListViewObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.itemExtent = (w.itemExtent != null) ? w.itemExtent! : 0;
  stObj.prototypeItem = _addWidget(w.prototypeItem);
  return stObj;
}

void _setupGridView(WidgetFactories f) {
  f.gridView.count = ffi.Pointer.fromFunction(gridViewCount);
  f.gridView.extent = ffi.Pointer.fromFunction(gridViewExtent);
}
GridViewObjSt gridViewCount(ffi.Pointer<ffi.Int> scrollDirection, ffi.Pointer<ffi.Int> reverse, ffi.Pointer<ffi.Int> primary, ffi.Pointer<ffi.Int> shrinkWrap, ffi.Pointer<DartObj> padding, int crossAxisCount, ffi.Pointer<ffi.Double> mainAxisSpacing, ffi.Pointer<ffi.Double> crossAxisSpacing, ffi.Pointer<ffi.Double> childAspectRatio, ffi.Pointer<ffi.Int> addAutomaticKeepAlives, ffi.Pointer<ffi.Int> addRepaintBoundaries, ffi.Pointer<ffi.Int> addSemanticIndexes, ffi.Pointer<ffi.Double> cacheExtent, ffi.Pointer<ArrayC> children, ffi.Pointer<ffi.Int> semanticChildCount, ffi.Pointer<ffi.Int> dragStartBehavior, ffi.Pointer<ffi.Int> keyboardDismissBehavior, ffi.Pointer<ffi.Char> restorationId, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<ffi.Int> hitTestBehavior) {
  final w = GridView.count(scrollDirection: scrollDirection.enumOr(Axis.values, Axis.vertical),
      reverse: reverse.boolOr(false),
      primary: primary.boolOrNul(),
      shrinkWrap: shrinkWrap.boolOr(false),
      padding: padding.objOrNul(),
      crossAxisCount: crossAxisCount,
      mainAxisSpacing: mainAxisSpacing.doubleOr(0.0),
      crossAxisSpacing: crossAxisSpacing.doubleOr(0.0),
      childAspectRatio: childAspectRatio.doubleOr(1.0),
      addAutomaticKeepAlives: addAutomaticKeepAlives.boolOr(true),
      addRepaintBoundaries: addRepaintBoundaries.boolOr(true),
      addSemanticIndexes: addSemanticIndexes.boolOr(true),
      cacheExtent: cacheExtent.doubleOrNul(),
      children: children.listOrEmpty(),
      semanticChildCount: semanticChildCount.intOrNul(),
      dragStartBehavior: dragStartBehavior.enumOr(DragStartBehavior.values, DragStartBehavior.start),
      keyboardDismissBehavior: keyboardDismissBehavior.enumOrNul(ScrollViewKeyboardDismissBehavior.values),
      restorationId: restorationId.strOrNul(),
      clipBehavior: clipBehavior.enumOr(Clip.values, Clip.hardEdge),
      hitTestBehavior: hitTestBehavior.enumOr(HitTestBehavior.values, HitTestBehavior.opaque));
  return _createGridViewObjSt(w);
}
GridViewObjSt gridViewExtent(ffi.Pointer<ffi.Int> scrollDirection, ffi.Pointer<ffi.Int> reverse, ffi.Pointer<ffi.Int> primary, ffi.Pointer<ffi.Int> shrinkWrap, ffi.Pointer<DartObj> padding, double maxCrossAxisExtent, ffi.Pointer<ffi.Double> mainAxisSpacing, ffi.Pointer<ffi.Double> crossAxisSpacing, ffi.Pointer<ffi.Double> childAspectRatio, ffi.Pointer<ffi.Int> addAutomaticKeepAlives, ffi.Pointer<ffi.Int> addRepaintBoundaries, ffi.Pointer<ffi.Int> addSemanticIndexes, ffi.Pointer<ffi.Double> cacheExtent, ffi.Pointer<ArrayC> children, ffi.Pointer<ffi.Int> semanticChildCount, ffi.Pointer<ffi.Int> dragStartBehavior, ffi.Pointer<ffi.Int> keyboardDismissBehavior, ffi.Pointer<ffi.Char> restorationId, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<ffi.Int> hitTestBehavior) {
  final w = GridView.extent(scrollDirection: scrollDirection.enumOr(Axis.values, Axis.vertical),
      reverse: reverse.boolOr(false),
      primary: primary.boolOrNul(),
      shrinkWrap: shrinkWrap.boolOr(false),
      padding: padding.objOrNul(),
      maxCrossAxisExtent: maxCrossAxisExtent,
      mainAxisSpacing: mainAxisSpacing.doubleOr(0.0),
      crossAxisSpacing: crossAxisSpacing.doubleOr(0.0),
      childAspectRatio: childAspectRatio.doubleOr(1.0),
      addAutomaticKeepAlives: addAutomaticKeepAlives.boolOr(true),
      addRepaintBoundaries: addRepaintBoundaries.boolOr(true),
      addSemanticIndexes: addSemanticIndexes.boolOr(true),
      cacheExtent: cacheExtent.doubleOrNul(),
      children: children.listOrEmpty(),
      semanticChildCount: semanticChildCount.intOrNul(),
      dragStartBehavior: dragStartBehavior.enumOr(DragStartBehavior.values, DragStartBehavior.start),
      keyboardDismissBehavior: keyboardDismissBehavior.enumOrNul(ScrollViewKeyboardDismissBehavior.values),
      restorationId: restorationId.strOrNul(),
      clipBehavior: clipBehavior.enumOr(Clip.values, Clip.hardEdge),
      hitTestBehavior: hitTestBehavior.enumOr(HitTestBehavior.values, HitTestBehavior.opaque));
  return _createGridViewObjSt(w);
}
GridViewObjSt _createGridViewObjSt(GridView? w) {
  final GridViewObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  return stObj;
}

void _setupPageView(WidgetFactories f) {
  f.pageView.pageView = ffi.Pointer.fromFunction(pageViewPageView);
  f.pageView.builder = ffi.Pointer.fromFunction(pageViewBuilder);
}
PageViewObjSt pageViewPageView(ffi.Pointer<ffi.Int> scrollDirection, ffi.Pointer<ffi.Int> reverse, ffi.Pointer<ffi.Int> pageSnapping, ffi.Pointer<ValueChangedForIntFFI> onPageChanged, ffi.Pointer<ArrayC> children, ffi.Pointer<ffi.Int> dragStartBehavior, ffi.Pointer<ffi.Int> allowImplicitScrolling, ffi.Pointer<ffi.Char> restorationId, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<ffi.Int> hitTestBehavior, ffi.Pointer<ffi.Int> padEnds) {
  final w = PageView(scrollDirection: scrollDirection.enumOr(Axis.values, Axis.horizontal),
      reverse: reverse.boolOr(false),
      pageSnapping: pageSnapping.boolOr(true),
      onPageChanged: onPageChanged.toValueChangedForIntFn(),
      children: children.listOrEmpty(),
      dragStartBehavior: dragStartBehavior.enumOr(DragStartBehavior.values, DragStartBehavior.start),
      allowImplicitScrolling: allowImplicitScrolling.boolOr(false),
      restorationId: restorationId.strOrNul(),
      clipBehavior: clipBehavior.enumOr(Clip.values, Clip.hardEdge),
      hitTestBehavior: hitTestBehavior.enumOr(HitTestBehavior.values, HitTestBehavior.opaque),
      padEnds: padEnds.boolOr(true));
  return _createPageViewObjSt(w);
}
PageViewObjSt pageViewBuilder(ffi.Pointer<ffi.Int> scrollDirection, ffi.Pointer<ffi.Int> reverse, ffi.Pointer<ffi.Int> pageSnapping, ffi.Pointer<ValueChangedForIntFFI> onPageChanged, NullableIndexedWidgetBuilderFFI itemBuilder, ffi.Pointer<ffi.Int> itemCount, ffi.Pointer<ffi.Int> dragStartBehavior, ffi.Pointer<ffi.Int> allowImplicitScrolling, ffi.Pointer<ffi.Char> restorationId, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<ffi.Int> hitTestBehavior, ffi.Pointer<ffi.Int> padEnds) {
  final w = PageView.builder(scrollDirection: scrollDirection.enumOr(Axis.values, Axis.horizontal),
      reverse: reverse.boolOr(false),
      pageSnapping: pageSnapping.boolOr(true),
      onPageChanged: onPageChanged.toValueChangedForIntFn(),
      itemBuilder: itemBuilder.toNullableIndexedWidgetBuilderFn(),
      itemCount: itemCount.intOrNul(),
      dragStartBehavior: dragStartBehavior.enumOr(DragStartBehavior.values, DragStartBehavior.start),
      allowImplicitScrolling: allowImplicitScrolling.boolOr(false),
      restorationId: restorationId.strOrNul(),
      clipBehavior: clipBehavior.enumOr(Clip.values, Clip.hardEdge),
      hitTestBehavior: hitTestBehavior.enumOr(HitTestBehavior.values, HitTestBehavior.opaque),
      padEnds: padEnds.boolOr(true));
  return _createPageViewObjSt(w);
}
PageViewObjSt _createPageViewObjSt(PageView? w) {
  final PageViewObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.allowImplicitScrolling = w.allowImplicitScrolling.toInt();
  stObj.restorationId = (w.restorationId != null) ? w.restorationId!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.scrollDirection = w.scrollDirection.index;
  stObj.reverse = w.reverse.toInt();
  stObj.pageSnapping = w.pageSnapping.toInt();
  stObj.dragStartBehavior = w.dragStartBehavior.index;
  stObj.clipBehavior = w.clipBehavior.index;
  stObj.hitTestBehavior = w.hitTestBehavior.index;
  stObj.padEnds = w.padEnds.toInt();
  return stObj;
}

void _setupListWheelScrollView(WidgetFactories f) {
  f.listWheelScrollView.listWheelScrollView = ffi.Pointer.fromFunction(listWheelScrollViewListWheelScrollView);
}
ListWheelScrollViewObjSt listWheelScrollViewListWheelScrollView(ffi.Pointer<ffi.Double> diameterRatio, ffi.Pointer<ffi.Double> perspective, ffi.Pointer<ffi.Double> offAxisFraction, ffi.Pointer<ffi.Int> useMagnifier, ffi.Pointer<ffi.Double> magnification, ffi.Pointer<ffi.Double> overAndUnderCenterOpacity, double itemExtent, ffi.Pointer<ffi.Double> squeeze, ffi.Pointer<ValueChangedForIntFFI> onSelectedItemChanged, ffi.Pointer<ffi.Int> renderChildrenOutsideViewport, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<ffi.Int> hitTestBehavior, ffi.Pointer<ffi.Char> restorationId, ffi.Pointer<ffi.Int> dragStartBehavior, ffi.Pointer<ffi.Int> changeReportingBehavior, ArrayC children) {
  final w = ListWheelScrollView(diameterRatio: diameterRatio.doubleOr(RenderListWheelViewport.defaultDiameterRatio),
      perspective: perspective.doubleOr(RenderListWheelViewport.defaultPerspective),
      offAxisFraction: offAxisFraction.doubleOr(0.0),
      useMagnifier: useMagnifier.boolOr(false),
      magnification: magnification.doubleOr(1.0),
      overAndUnderCenterOpacity: overAndUnderCenterOpacity.doubleOr(1.0),
      itemExtent: itemExtent,
      squeeze: squeeze.doubleOr(1.0),
      onSelectedItemChanged: onSelectedItemChanged.toValueChangedForIntFn(),
      renderChildrenOutsideViewport: renderChildrenOutsideViewport.boolOr(false),
      clipBehavior: clipBehavior.enumOr(Clip.values, Clip.hardEdge),
      hitTestBehavior: hitTestBehavior.enumOr(HitTestBehavior.values, HitTestBehavior.opaque),
      restorationId: restorationId.strOrNul(),
      dragStartBehavior: dragStartBehavior.enumOr(DragStartBehavior.values, DragStartBehavior.start),
      changeReportingBehavior: changeReportingBehavior.enumOr(ChangeReportingBehavior.values, ChangeReportingBehavior.onScrollUpdate),
      children: children.listOrEmpty());
  return _createListWheelScrollViewObjSt(w);
}
ListWheelScrollViewObjSt _createListWheelScrollViewObjSt(ListWheelScrollView? w) {
  final ListWheelScrollViewObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.diameterRatio = w.diameterRatio;
  stObj.perspective = w.perspective;
  stObj.offAxisFraction = w.offAxisFraction;
  stObj.useMagnifier = w.useMagnifier.toInt();
  stObj.magnification = w.magnification;
  stObj.overAndUnderCenterOpacity = w.overAndUnderCenterOpacity;
  stObj.itemExtent = w.itemExtent;
  stObj.squeeze = w.squeeze;
  stObj.renderChildrenOutsideViewport = w.renderChildrenOutsideViewport.toInt();
  stObj.clipBehavior = w.clipBehavior.index;
  stObj.hitTestBehavior = w.hitTestBehavior.index;
  stObj.restorationId = (w.restorationId != null) ? w.restorationId!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.dragStartBehavior = w.dragStartBehavior.index;
  stObj.changeReportingBehavior = w.changeReportingBehavior.index;
  return stObj;
}

void _setupAnimatedSize(WidgetFactories f) {
  f.animatedSize.animatedSize = ffi.Pointer.fromFunction(animatedSizeAnimatedSize);
}
AnimatedSizeObjSt animatedSizeAnimatedSize(ffi.Pointer<DartObj> child, ffi.Pointer<DartObj> alignment, ffi.Pointer<DartObj> curve, DartDartObj duration, ffi.Pointer<DartObj> reverseDuration, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<VoidCallbackFFI> onEnd) {
  final w = AnimatedSize(child: child.objOrNul(),
      alignment: alignment.objOr(Alignment.center),
      curve: curve.objOr(Curves.linear),
      duration: _widgetsMap[duration]! as Duration,
      reverseDuration: reverseDuration.objOrNul(),
      clipBehavior: clipBehavior.enumOr(Clip.values, Clip.hardEdge),
      onEnd: onEnd.toVoidCallbackFn());
  return _createAnimatedSizeObjSt(w);
}
AnimatedSizeObjSt _createAnimatedSizeObjSt(AnimatedSize? w) {
  final AnimatedSizeObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.child = _addWidget(w.child);
  stObj.alignment = _addWidget(w.alignment);
  stObj.curve = _addWidget(w.curve);
  stObj.duration = _addWidget(w.duration);
  stObj.reverseDuration = _addWidget(w.reverseDuration);
  stObj.clipBehavior = w.clipBehavior.index;
  return stObj;
}

void _setupAnimatedScale(WidgetFactories f) {
  f.animatedScale.animatedScale = ffi.Pointer.fromFunction(animatedScaleAnimatedScale);
}
AnimatedScaleObjSt animatedScaleAnimatedScale(ffi.Pointer<DartObj> child, double scale, ffi.Pointer<DartObj> alignment, ffi.Pointer<ffi.Int> filterQuality, ffi.Pointer<DartObj> curve, DartDartObj duration, ffi.Pointer<VoidCallbackFFI> onEnd) {
  final w = AnimatedScale(child: child.objOrNul(),
      scale: scale,
      alignment: alignment.objOr(Alignment.center),
      filterQuality: filterQuality.enumOrNul(FilterQuality.values),
      curve: curve.objOr(Curves.linear),
      duration: _widgetsMap[duration]! as Duration,
      onEnd: onEnd.toVoidCallbackFn());
  return _createAnimatedScaleObjSt(w);
}
AnimatedScaleObjSt _createAnimatedScaleObjSt(AnimatedScale? w) {
  final AnimatedScaleObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.child = _addWidget(w.child);
  stObj.scale = w.scale;
  stObj.alignment = _createAlignmentObjSt(w.alignment);
  stObj.filterQuality = (w.filterQuality != null) ? w.filterQuality!.index : 0;
  return stObj;
}

void _setupAnimatedRotation(WidgetFactories f) {
  f.animatedRotation.animatedRotation = ffi.Pointer.fromFunction(animatedRotationAnimatedRotation);
}
AnimatedRotationObjSt animatedRotationAnimatedRotation(ffi.Pointer<DartObj> child, double turns, ffi.Pointer<DartObj> alignment, ffi.Pointer<ffi.Int> filterQuality, ffi.Pointer<DartObj> curve, DartDartObj duration, ffi.Pointer<VoidCallbackFFI> onEnd) {
  final w = AnimatedRotation(child: child.objOrNul(),
      turns: turns,
      alignment: alignment.objOr(Alignment.center),
      filterQuality: filterQuality.enumOrNul(FilterQuality.values),
      curve: curve.objOr(Curves.linear),
      duration: _widgetsMap[duration]! as Duration,
      onEnd: onEnd.toVoidCallbackFn());
  return _createAnimatedRotationObjSt(w);
}
AnimatedRotationObjSt _createAnimatedRotationObjSt(AnimatedRotation? w) {
  final AnimatedRotationObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.child = _addWidget(w.child);
  stObj.turns = w.turns;
  stObj.alignment = _createAlignmentObjSt(w.alignment);
  stObj.filterQuality = (w.filterQuality != null) ? w.filterQuality!.index : 0;
  return stObj;
}

void _setupAnimatedSlide(WidgetFactories f) {
  f.animatedSlide.animatedSlide = ffi.Pointer.fromFunction(animatedSlideAnimatedSlide);
}
AnimatedSlideObjSt animatedSlideAnimatedSlide(ffi.Pointer<DartObj> child, DartDartObj offset, ffi.Pointer<DartObj> curve, DartDartObj duration, ffi.Pointer<VoidCallbackFFI> onEnd) {
  final w = AnimatedSlide(child: child.objOrNul(),
      offset: _widgetsMap[offset]! as Offset,
      curve: curve.objOr(Curves.linear),
      duration: _widgetsMap[duration]! as Duration,
      onEnd: onEnd.toVoidCallbackFn());
  return _createAnimatedSlideObjSt(w);
}
AnimatedSlideObjSt _createAnimatedSlideObjSt(AnimatedSlide? w) {
  final AnimatedSlideObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.child = _addWidget(w.child);
  stObj.offset = _addWidget(w.offset);
  return stObj;
}

void _setupAnimatedCrossFade(WidgetFactories f) {
  f.animatedCrossFade.animatedCrossFade = ffi.Pointer.fromFunction(animatedCrossFadeAnimatedCrossFade);
}
AnimatedCrossFadeObjSt animatedCrossFadeAnimatedCrossFade(DartDartObj firstChild, DartDartObj secondChild, ffi.Pointer<DartObj> firstCurve, ffi.Pointer<DartObj> secondCurve, ffi.Pointer<DartObj> sizeCurve, ffi.Pointer<DartObj> alignment, int crossFadeState, DartDartObj duration, ffi.Pointer<DartObj> reverseDuration, ffi.Pointer<ffi.Int> excludeBottomFocus) {
  final w = AnimatedCrossFade(firstChild: _widgetsMap[firstChild]! as Widget,
      secondChild: _widgetsMap[secondChild]! as Widget,
      firstCurve: firstCurve.objOr(Curves.linear),
      secondCurve: secondCurve.objOr(Curves.linear),
      sizeCurve: sizeCurve.objOr(Curves.linear),
      alignment: alignment.objOr(Alignment.topCenter),
      crossFadeState: CrossFadeState.values[crossFadeState],
      duration: _widgetsMap[duration]! as Duration,
      reverseDuration: reverseDuration.objOrNul(),
      excludeBottomFocus: excludeBottomFocus.boolOr(true));
  return _createAnimatedCrossFadeObjSt(w);
}
AnimatedCrossFadeObjSt _createAnimatedCrossFadeObjSt(AnimatedCrossFade? w) {
  final AnimatedCrossFadeObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.firstChild = _addWidget(w.firstChild);
  stObj.secondChild = _addWidget(w.secondChild);
  stObj.crossFadeState = w.crossFadeState.index;
  stObj.duration = _addWidget(w.duration);
  stObj.reverseDuration = _addWidget(w.reverseDuration);
  stObj.firstCurve = _addWidget(w.firstCurve);
  stObj.secondCurve = _addWidget(w.secondCurve);
  stObj.sizeCurve = _addWidget(w.sizeCurve);
  stObj.alignment = _addWidget(w.alignment);
  stObj.excludeBottomFocus = w.excludeBottomFocus.toInt();
  return stObj;
}

void _setupSlideTransition(WidgetFactories f) {
  f.slideTransition.slideTransition = ffi.Pointer.fromFunction(slideTransitionSlideTransition);
}
SlideTransitionObjSt slideTransitionSlideTransition(DartDartObj position, ffi.Pointer<ffi.Int> transformHitTests, ffi.Pointer<ffi.Int> textDirection, ffi.Pointer<DartObj> child) {
  final w = SlideTransition(position: _widgetsMap[position]! as Animation<Offset>,
      transformHitTests: transformHitTests.boolOr(true),
      textDirection: textDirection.enumOrNul(TextDirection.values),
      child: child.objOrNul());
  return _createSlideTransitionObjSt(w);
}
SlideTransitionObjSt _createSlideTransitionObjSt(SlideTransition? w) {
  final SlideTransitionObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.textDirection = (w.textDirection != null) ? w.textDirection!.index : 0;
  stObj.transformHitTests = w.transformHitTests.toInt();
  stObj.child = _addWidget(w.child);
  stObj.position = _addWidget(w.position);
  return stObj;
}

void _setupSizeTransition(WidgetFactories f) {
  f.sizeTransition.sizeTransition = ffi.Pointer.fromFunction(sizeTransitionSizeTransition);
}
SizeTransitionObjSt sizeTransitionSizeTransition(ffi.Pointer<ffi.Int> axis, DartDartObj sizeFactor, ffi.Pointer<ffi.Double> axisAlignment, ffi.Pointer<ffi.Double> fixedCrossAxisSizeFactor, ffi.Pointer<DartObj> child) {
  final w = SizeTransition(axis: axis.enumOr(Axis.values, Axis.vertical),
      sizeFactor: _widgetsMap[sizeFactor]! as Animation<double>,
      axisAlignment: axisAlignment.doubleOr(0.0),
      fixedCrossAxisSizeFactor: fixedCrossAxisSizeFactor.doubleOrNul(),
      child: child.objOrNul());
  return _createSizeTransitionObjSt(w);
}
SizeTransitionObjSt _createSizeTransitionObjSt(SizeTransition? w) {
  final SizeTransitionObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.axis = w.axis.index;
  stObj.axisAlignment = w.axisAlignment;
  stObj.fixedCrossAxisSizeFactor = (w.fixedCrossAxisSizeFactor != null) ? w.fixedCrossAxisSizeFactor! : 0;
  stObj.child = _addWidget(w.child);
  stObj.sizeFactor = _addWidget(w.sizeFactor);
  return stObj;
}

void _setupIndexedStack(WidgetFactories f) {
  f.indexedStack.indexedStack = ffi.Pointer.fromFunction(indexedStackIndexedStack);
}
IndexedStackObjSt indexedStackIndexedStack(ffi.Pointer<DartObj> alignment, ffi.Pointer<ffi.Int> textDirection, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<ffi.Int> sizing, ffi.Pointer<ffi.Int> index, ffi.Pointer<ArrayC> children) {
  final w = IndexedStack(alignment: alignment.objOr(AlignmentDirectional.topStart),
      textDirection: textDirection.enumOrNul(TextDirection.values),
      clipBehavior: clipBehavior.enumOr(Clip.values, Clip.hardEdge),
      sizing: sizing.enumOr(StackFit.values, StackFit.loose),
      index: index.intOrNul(),
      children: children.listOrEmpty());
  return _createIndexedStackObjSt(w);
}
IndexedStackObjSt _createIndexedStackObjSt(IndexedStack? w) {
  final IndexedStackObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.alignment = _addWidget(w.alignment);
  stObj.textDirection = (w.textDirection != null) ? w.textDirection!.index : 0;
  stObj.clipBehavior = w.clipBehavior.index;
  stObj.sizing = w.sizing.index;
  stObj.index = (w.index != null) ? w.index! : 0;
  return stObj;
}

void _setupInteractiveViewer(WidgetFactories f) {
  f.interactiveViewer.interactiveViewer = ffi.Pointer.fromFunction(interactiveViewerInteractiveViewer);
}
InteractiveViewerObjSt interactiveViewerInteractiveViewer(ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<ffi.Int> panAxis, ffi.Pointer<DartObj> boundaryMargin, ffi.Pointer<ffi.Int> constrained, ffi.Pointer<ffi.Double> maxScale, ffi.Pointer<ffi.Double> minScale, ffi.Pointer<ffi.Double> interactionEndFrictionCoefficient, ffi.Pointer<GestureScaleEndCallbackFFI> onInteractionEnd, ffi.Pointer<GestureScaleStartCallbackFFI> onInteractionStart, ffi.Pointer<GestureScaleUpdateCallbackFFI> onInteractionUpdate, ffi.Pointer<ffi.Int> panEnabled, ffi.Pointer<ffi.Int> scaleEnabled, ffi.Pointer<ffi.Double> scaleFactor, ffi.Pointer<DartObj> alignment, ffi.Pointer<ffi.Int> trackpadScrollCausesScale, DartDartObj child) {
  final w = InteractiveViewer(clipBehavior: clipBehavior.enumOr(Clip.values, Clip.hardEdge),
      panAxis: panAxis.enumOr(PanAxis.values, PanAxis.free),
      boundaryMargin: boundaryMargin.objOr(EdgeInsets.zero),
      constrained: constrained.boolOr(true),
      maxScale: maxScale.doubleOr(2.5),
      minScale: minScale.doubleOr(0.8),
      interactionEndFrictionCoefficient: interactionEndFrictionCoefficient.doubleOr(0.0000135),
      onInteractionEnd: onInteractionEnd.toGestureScaleEndCallbackFn(),
      onInteractionStart: onInteractionStart.toGestureScaleStartCallbackFn(),
      onInteractionUpdate: onInteractionUpdate.toGestureScaleUpdateCallbackFn(),
      panEnabled: panEnabled.boolOr(true),
      scaleEnabled: scaleEnabled.boolOr(true),
      scaleFactor: scaleFactor.doubleOr(200.0),
      alignment: alignment.objOrNul(),
      trackpadScrollCausesScale: trackpadScrollCausesScale.boolOr(false),
      child: _widgetsMap[child]! as Widget);
  return _createInteractiveViewerObjSt(w);
}
InteractiveViewerObjSt _createInteractiveViewerObjSt(InteractiveViewer? w) {
  final InteractiveViewerObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.alignment = _createAlignmentObjSt(w.alignment);
  stObj.clipBehavior = w.clipBehavior.index;
  stObj.panAxis = w.panAxis.index;
  stObj.boundaryMargin = _createEdgeInsetsObjSt(w.boundaryMargin);
  stObj.child = _addWidget(w.child);
  stObj.constrained = w.constrained.toInt();
  stObj.panEnabled = w.panEnabled.toInt();
  stObj.scaleEnabled = w.scaleEnabled.toInt();
  stObj.trackpadScrollCausesScale = w.trackpadScrollCausesScale.toInt();
  stObj.scaleFactor = w.scaleFactor;
  stObj.maxScale = w.maxScale;
  stObj.minScale = w.minScale;
  stObj.interactionEndFrictionCoefficient = w.interactionEndFrictionCoefficient;
  return stObj;
}

void _setupDraggable(WidgetFactories f) {
  f.draggable.draggable = ffi.Pointer.fromFunction(draggableDraggable);
}
DraggableObjSt draggableDraggable(DartDartObj child, DartDartObj feedback, ffi.Pointer<DartObj> data, ffi.Pointer<ffi.Int> axis, ffi.Pointer<DartObj> childWhenDragging, ffi.Pointer<DartObj> feedbackOffset, ffi.Pointer<DragAnchorStrategyFFI> dragAnchorStrategy, ffi.Pointer<ffi.Int> affinity, ffi.Pointer<ffi.Int> maxSimultaneousDrags, ffi.Pointer<VoidCallbackFFI> onDragStarted, ffi.Pointer<DragUpdateCallbackFFI> onDragUpdate, ffi.Pointer<DraggableCanceledCallbackFFI> onDraggableCanceled, ffi.Pointer<DragEndCallbackFFI> onDragEnd, ffi.Pointer<VoidCallbackFFI> onDragCompleted, ffi.Pointer<ffi.Int> ignoringFeedbackSemantics, ffi.Pointer<ffi.Int> ignoringFeedbackPointer, ffi.Pointer<ffi.Int> rootOverlay, ffi.Pointer<ffi.Int> hitTestBehavior, ffi.Pointer<AllowedButtonsFilterFFI> allowedButtonsFilter) {
  final w = Draggable(child: _widgetsMap[child]! as Widget,
      feedback: _widgetsMap[feedback]! as Widget,
      data: data,
      axis: axis.enumOrNul(Axis.values),
      childWhenDragging: childWhenDragging.objOrNul(),
      feedbackOffset: feedbackOffset.objOr(Offset.zero),
      dragAnchorStrategy: (dragAnchorStrategy.toDragAnchorStrategyFn() ?? childDragAnchorStrategy),
      affinity: affinity.enumOrNul(Axis.values),
      maxSimultaneousDrags: maxSimultaneousDrags.intOrNul(),
      onDragStarted: onDragStarted.toVoidCallbackFn(),
      onDragUpdate: onDragUpdate.toDragUpdateCallbackFn(),
      onDraggableCanceled: onDraggableCanceled.toDraggableCanceledCallbackFn(),
      onDragEnd: onDragEnd.toDragEndCallbackFn(),
      onDragCompleted: onDragCompleted.toVoidCallbackFn(),
      ignoringFeedbackSemantics: ignoringFeedbackSemantics.boolOr(true),
      ignoringFeedbackPointer: ignoringFeedbackPointer.boolOr(true),
      rootOverlay: rootOverlay.boolOr(false),
      hitTestBehavior: hitTestBehavior.enumOr(HitTestBehavior.values, HitTestBehavior.deferToChild),
      allowedButtonsFilter: allowedButtonsFilter.toAllowedButtonsFilterFn());
  return _createDraggableObjSt(w);
}
DraggableObjSt _createDraggableObjSt(Draggable? w) {
  final DraggableObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.axis = (w.axis != null) ? w.axis!.index : 0;
  stObj.child = _addWidget(w.child);
  stObj.childWhenDragging = _addWidget(w.childWhenDragging);
  stObj.feedback = _addWidget(w.feedback);
  stObj.feedbackOffset = _addWidget(w.feedbackOffset);
  stObj.ignoringFeedbackSemantics = w.ignoringFeedbackSemantics.toInt();
  stObj.ignoringFeedbackPointer = w.ignoringFeedbackPointer.toInt();
  stObj.affinity = (w.affinity != null) ? w.affinity!.index : 0;
  stObj.maxSimultaneousDrags = (w.maxSimultaneousDrags != null) ? w.maxSimultaneousDrags! : 0;
  stObj.rootOverlay = w.rootOverlay.toInt();
  stObj.hitTestBehavior = w.hitTestBehavior.index;
  return stObj;
}

void _setupDragTarget(WidgetFactories f) {
  f.dragTarget.dragTarget = ffi.Pointer.fromFunction(dragTargetDragTarget);
}
DragTargetObjSt dragTargetDragTarget(DragTargetBuilderForTFFI builder, ffi.Pointer<DragTargetWillAcceptForTFFI> onWillAccept, ffi.Pointer<DragTargetWillAcceptWithDetailsForTFFI> onWillAcceptWithDetails, ffi.Pointer<DragTargetAcceptForTFFI> onAccept, ffi.Pointer<DragTargetAcceptWithDetailsForTFFI> onAcceptWithDetails, ffi.Pointer<DragTargetLeaveForTFFI> onLeave, ffi.Pointer<DragTargetMoveForTFFI> onMove, ffi.Pointer<ffi.Int> hitTestBehavior) {
  final w = DragTarget(builder: builder.toDragTargetBuilderForTFn(),
      onWillAccept: onWillAccept.toDragTargetWillAcceptForTFn(),
      onWillAcceptWithDetails: onWillAcceptWithDetails.toDragTargetWillAcceptWithDetailsForTFn(),
      onAccept: onAccept.toDragTargetAcceptForTFn(),
      onAcceptWithDetails: onAcceptWithDetails.toDragTargetAcceptWithDetailsForTFn(),
      onLeave: onLeave.toDragTargetLeaveForTFn(),
      onMove: onMove.toDragTargetMoveForTFn(),
      hitTestBehavior: hitTestBehavior.enumOr(HitTestBehavior.values, HitTestBehavior.translucent));
  return _createDragTargetObjSt(w);
}
DragTargetObjSt _createDragTargetObjSt(DragTarget? w) {
  final DragTargetObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.hitTestBehavior = w.hitTestBehavior.index;
  return stObj;
}

void _setupHero(WidgetFactories f) {
  f.hero.hero = ffi.Pointer.fromFunction(heroHero);
}
HeroObjSt heroHero(DartDartObj tag, ffi.Pointer<HeroFlightShuttleBuilderFFI> flightShuttleBuilder, ffi.Pointer<ffi.Int> transitionOnUserGestures, DartDartObj child) {
  final w = Hero(tag: _widgetsMap[tag]! as Object,
      flightShuttleBuilder: flightShuttleBuilder.toHeroFlightShuttleBuilderFn(),
      transitionOnUserGestures: transitionOnUserGestures.boolOr(false),
      child: _widgetsMap[child]! as Widget);
  return _createHeroObjSt(w);
}
HeroObjSt _createHeroObjSt(Hero? w) {
  final HeroObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.child = _addWidget(w.child);
  stObj.transitionOnUserGestures = w.transitionOnUserGestures.toInt();
  return stObj;
}

void _setupAnimatedSwitcher(WidgetFactories f) {
  f.animatedSwitcher.animatedSwitcher = ffi.Pointer.fromFunction(animatedSwitcherAnimatedSwitcher);
  f.animatedSwitcher.defaultTransitionBuilder = ffi.Pointer.fromFunction(animatedSwitcherDefaultTransitionBuilder, exception);
  f.animatedSwitcher.defaultLayoutBuilder = ffi.Pointer.fromFunction(animatedSwitcherDefaultLayoutBuilder, exception);
}
AnimatedSwitcherObjSt animatedSwitcherAnimatedSwitcher(ffi.Pointer<DartObj> child, DartDartObj duration, ffi.Pointer<DartObj> reverseDuration, ffi.Pointer<DartObj> switchInCurve, ffi.Pointer<DartObj> switchOutCurve, ffi.Pointer<AnimatedSwitcherTransitionBuilderFFI> transitionBuilder, ffi.Pointer<AnimatedSwitcherLayoutBuilderFFI> layoutBuilder) {
  final w = AnimatedSwitcher(child: child.objOrNul(),
      duration: _widgetsMap[duration]! as Duration,
      reverseDuration: reverseDuration.objOrNul(),
      switchInCurve: switchInCurve.objOr(Curves.linear),
      switchOutCurve: switchOutCurve.objOr(Curves.linear),
      transitionBuilder: (transitionBuilder.toAnimatedSwitcherTransitionBuilderFn() ?? AnimatedSwitcher.defaultTransitionBuilder),
      layoutBuilder: (layoutBuilder.toAnimatedSwitcherLayoutBuilderFn() ?? AnimatedSwitcher.defaultLayoutBuilder));
  return _createAnimatedSwitcherObjSt(w);
}
int animatedSwitcherDefaultTransitionBuilder(DartDartObj child, DartDartObj animation) {
  final w = AnimatedSwitcher.defaultTransitionBuilder(_widgetsMap[child]! as Widget,
      _widgetsMap[animation]! as Animation<double>);
  return _addWidget(w);
}
int animatedSwitcherDefaultLayoutBuilder(DartDartObj currentChild, ArrayC previousChildren) {
  final w = AnimatedSwitcher.defaultLayoutBuilder(_widgetsMap[currentChild]! as Widget?,
      previousChildren.listOrEmpty());
  return _addWidget(w);
}
AnimatedSwitcherObjSt _createAnimatedSwitcherObjSt(AnimatedSwitcher? w) {
  final AnimatedSwitcherObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.child = _addWidget(w.child);
  stObj.duration = _addWidget(w.duration);
  stObj.reverseDuration = _addWidget(w.reverseDuration);
  stObj.switchInCurve = _addWidget(w.switchInCurve);
  stObj.switchOutCurve = _addWidget(w.switchOutCurve);
  return stObj;
}

void _setupColorFilter(WidgetFactories f) {
  f.colorFilter.mode = ffi.Pointer.fromFunction(colorFilterMode, exception);
  f.colorFilter.linearToSrgbGamma = ffi.Pointer.fromFunction(colorFilterLinearToSrgbGamma, exception);
  f.colorFilter.srgbToLinearGamma = ffi.Pointer.fromFunction(colorFilterSrgbToLinearGamma, exception);
}
int colorFilterMode(DartDartObj color, int blendMode) {
  final w = ColorFilter.mode(_widgetsMap[color]! as Color,
      BlendMode.values[blendMode]);
  return _addWidget(w);
}
int colorFilterLinearToSrgbGamma() {
  final w = ColorFilter.linearToSrgbGamma();
  return _addWidget(w);
}
int colorFilterSrgbToLinearGamma() {
  final w = ColorFilter.srgbToLinearGamma();
  return _addWidget(w);
}

void _setupBackdropFilter(WidgetFactories f) {
  f.backdropFilter.backdropFilter = ffi.Pointer.fromFunction(backdropFilterBackdropFilter);
  f.backdropFilter.grouped = ffi.Pointer.fromFunction(backdropFilterGrouped);
}
BackdropFilterObjSt backdropFilterBackdropFilter(DartDartObj filter, ffi.Pointer<DartObj> child, ffi.Pointer<ffi.Int> blendMode, ffi.Pointer<ffi.Int> enabled) {
  final w = BackdropFilter(filter: _widgetsMap[filter]! as ImageFilter,
      child: child.objOrNul(),
      blendMode: blendMode.enumOr(BlendMode.values, BlendMode.srcOver),
      enabled: enabled.boolOr(true));
  return _createBackdropFilterObjSt(w);
}
BackdropFilterObjSt backdropFilterGrouped(DartDartObj filter, ffi.Pointer<DartObj> child, ffi.Pointer<ffi.Int> blendMode, ffi.Pointer<ffi.Int> enabled) {
  final w = BackdropFilter.grouped(filter: _widgetsMap[filter]! as ImageFilter,
      child: child.objOrNul(),
      blendMode: blendMode.enumOr(BlendMode.values, BlendMode.srcOver),
      enabled: enabled.boolOr(true));
  return _createBackdropFilterObjSt(w);
}
BackdropFilterObjSt _createBackdropFilterObjSt(BackdropFilter? w) {
  final BackdropFilterObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.filter = _addWidget(w.filter);
  stObj.blendMode = w.blendMode.index;
  stObj.enabled = w.enabled.toInt();
  return stObj;
}

void _setupImageFilter(WidgetFactories f) {
  f.imageFilter.blur = ffi.Pointer.fromFunction(imageFilterBlur, exception);
  f.imageFilter.dilate = ffi.Pointer.fromFunction(imageFilterDilate, exception);
  f.imageFilter.erode = ffi.Pointer.fromFunction(imageFilterErode, exception);
  f.imageFilter.compose = ffi.Pointer.fromFunction(imageFilterCompose, exception);
}
int imageFilterBlur(ffi.Pointer<ffi.Double> sigmaX, ffi.Pointer<ffi.Double> sigmaY, ffi.Pointer<ffi.Int> tileMode) {
  final w = ImageFilter.blur(sigmaX: sigmaX.doubleOr(0.0),
      sigmaY: sigmaY.doubleOr(0.0),
      tileMode: tileMode.enumOrNul(TileMode.values));
  return _addWidget(w);
}
int imageFilterDilate(ffi.Pointer<ffi.Double> radiusX, ffi.Pointer<ffi.Double> radiusY) {
  final w = ImageFilter.dilate(radiusX: radiusX.doubleOr(0.0),
      radiusY: radiusY.doubleOr(0.0));
  return _addWidget(w);
}
int imageFilterErode(ffi.Pointer<ffi.Double> radiusX, ffi.Pointer<ffi.Double> radiusY) {
  final w = ImageFilter.erode(radiusX: radiusX.doubleOr(0.0),
      radiusY: radiusY.doubleOr(0.0));
  return _addWidget(w);
}
int imageFilterCompose(DartDartObj outer, DartDartObj inner) {
  final w = ImageFilter.compose(outer: _widgetsMap[outer]! as ImageFilter,
      inner: _widgetsMap[inner]! as ImageFilter);
  return _addWidget(w);
}

void _setupColorFiltered(WidgetFactories f) {
  f.colorFiltered.colorFiltered = ffi.Pointer.fromFunction(colorFilteredColorFiltered);
}
ColorFilteredObjSt colorFilteredColorFiltered(DartDartObj colorFilter, ffi.Pointer<DartObj> child) {
  final w = ColorFiltered(colorFilter: _widgetsMap[colorFilter]! as ColorFilter,
      child: child.objOrNul());
  return _createColorFilteredObjSt(w);
}
ColorFilteredObjSt _createColorFilteredObjSt(ColorFiltered? w) {
  final ColorFilteredObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.colorFilter = _addWidget(w.colorFilter);
  return stObj;
}

void _setupImageFiltered(WidgetFactories f) {
  f.imageFiltered.imageFiltered = ffi.Pointer.fromFunction(imageFilteredImageFiltered);
}
ImageFilteredObjSt imageFilteredImageFiltered(DartDartObj imageFilter, ffi.Pointer<DartObj> child, ffi.Pointer<ffi.Int> enabled) {
  final w = ImageFiltered(imageFilter: _widgetsMap[imageFilter]! as ImageFilter,
      child: child.objOrNul(),
      enabled: enabled.boolOr(true));
  return _createImageFilteredObjSt(w);
}
ImageFilteredObjSt _createImageFilteredObjSt(ImageFiltered? w) {
  final ImageFilteredObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.imageFilter = _addWidget(w.imageFilter);
  stObj.enabled = w.enabled.toInt();
  return stObj;
}

void _setupColorScheme(WidgetFactories f) {
  f.colorScheme.colorScheme = ffi.Pointer.fromFunction(colorSchemeColorScheme);
  f.colorScheme.fromSeed = ffi.Pointer.fromFunction(colorSchemeFromSeed);
  f.colorScheme.light = ffi.Pointer.fromFunction(colorSchemeLight);
  f.colorScheme.dark = ffi.Pointer.fromFunction(colorSchemeDark);
  f.colorScheme.highContrastLight = ffi.Pointer.fromFunction(colorSchemeHighContrastLight);
  f.colorScheme.highContrastDark = ffi.Pointer.fromFunction(colorSchemeHighContrastDark);
  f.colorScheme.fromSwatch = ffi.Pointer.fromFunction(colorSchemeFromSwatch);
  f.colorScheme.lerp = ffi.Pointer.fromFunction(colorSchemeLerp);
  f.colorScheme.of = ffi.Pointer.fromFunction(colorSchemeOf);
}
ColorSchemeObjSt colorSchemeColorScheme(int brightness, DartDartObj primary, DartDartObj onPrimary, ffi.Pointer<DartObj> primaryContainer, ffi.Pointer<DartObj> onPrimaryContainer, ffi.Pointer<DartObj> primaryFixed, ffi.Pointer<DartObj> primaryFixedDim, ffi.Pointer<DartObj> onPrimaryFixed, ffi.Pointer<DartObj> onPrimaryFixedVariant, DartDartObj secondary, DartDartObj onSecondary, ffi.Pointer<DartObj> secondaryContainer, ffi.Pointer<DartObj> onSecondaryContainer, ffi.Pointer<DartObj> secondaryFixed, ffi.Pointer<DartObj> secondaryFixedDim, ffi.Pointer<DartObj> onSecondaryFixed, ffi.Pointer<DartObj> onSecondaryFixedVariant, ffi.Pointer<DartObj> tertiary, ffi.Pointer<DartObj> onTertiary, ffi.Pointer<DartObj> tertiaryContainer, ffi.Pointer<DartObj> onTertiaryContainer, ffi.Pointer<DartObj> tertiaryFixed, ffi.Pointer<DartObj> tertiaryFixedDim, ffi.Pointer<DartObj> onTertiaryFixed, ffi.Pointer<DartObj> onTertiaryFixedVariant, DartDartObj error, DartDartObj onError, ffi.Pointer<DartObj> errorContainer, ffi.Pointer<DartObj> onErrorContainer, DartDartObj surface, DartDartObj onSurface, ffi.Pointer<DartObj> surfaceDim, ffi.Pointer<DartObj> surfaceBright, ffi.Pointer<DartObj> surfaceContainerLowest, ffi.Pointer<DartObj> surfaceContainerLow, ffi.Pointer<DartObj> surfaceContainer, ffi.Pointer<DartObj> surfaceContainerHigh, ffi.Pointer<DartObj> surfaceContainerHighest, ffi.Pointer<DartObj> onSurfaceVariant, ffi.Pointer<DartObj> outline, ffi.Pointer<DartObj> outlineVariant, ffi.Pointer<DartObj> shadow, ffi.Pointer<DartObj> scrim, ffi.Pointer<DartObj> inverseSurface, ffi.Pointer<DartObj> onInverseSurface, ffi.Pointer<DartObj> inversePrimary, ffi.Pointer<DartObj> surfaceTint, ffi.Pointer<DartObj> background, ffi.Pointer<DartObj> onBackground, ffi.Pointer<DartObj> surfaceVariant) {
  final w = ColorScheme(brightness: Brightness.values[brightness],
      primary: _widgetsMap[primary]! as Color,
      onPrimary: _widgetsMap[onPrimary]! as Color,
      primaryContainer: primaryContainer.objOrNul(),
      onPrimaryContainer: onPrimaryContainer.objOrNul(),
      primaryFixed: primaryFixed.objOrNul(),
      primaryFixedDim: primaryFixedDim.objOrNul(),
      onPrimaryFixed: onPrimaryFixed.objOrNul(),
      onPrimaryFixedVariant: onPrimaryFixedVariant.objOrNul(),
      secondary: _widgetsMap[secondary]! as Color,
      onSecondary: _widgetsMap[onSecondary]! as Color,
      secondaryContainer: secondaryContainer.objOrNul(),
      onSecondaryContainer: onSecondaryContainer.objOrNul(),
      secondaryFixed: secondaryFixed.objOrNul(),
      secondaryFixedDim: secondaryFixedDim.objOrNul(),
      onSecondaryFixed: onSecondaryFixed.objOrNul(),
      onSecondaryFixedVariant: onSecondaryFixedVariant.objOrNul(),
      tertiary: tertiary.objOrNul(),
      onTertiary: onTertiary.objOrNul(),
      tertiaryContainer: tertiaryContainer.objOrNul(),
      onTertiaryContainer: onTertiaryContainer.objOrNul(),
      tertiaryFixed: tertiaryFixed.objOrNul(),
      tertiaryFixedDim: tertiaryFixedDim.objOrNul(),
      onTertiaryFixed: onTertiaryFixed.objOrNul(),
      onTertiaryFixedVariant: onTertiaryFixedVariant.objOrNul(),
      error: _widgetsMap[error]! as Color,
      onError: _widgetsMap[onError]! as Color,
      errorContainer: errorContainer.objOrNul(),
      onErrorContainer: onErrorContainer.objOrNul(),
      surface: _widgetsMap[surface]! as Color,
      onSurface: _widgetsMap[onSurface]! as Color,
      surfaceDim: surfaceDim.objOrNul(),
      surfaceBright: surfaceBright.objOrNul(),
      surfaceContainerLowest: surfaceContainerLowest.objOrNul(),
      surfaceContainerLow: surfaceContainerLow.objOrNul(),
      surfaceContainer: surfaceContainer.objOrNul(),
      surfaceContainerHigh: surfaceContainerHigh.objOrNul(),
      surfaceContainerHighest: surfaceContainerHighest.objOrNul(),
      onSurfaceVariant: onSurfaceVariant.objOrNul(),
      outline: outline.objOrNul(),
      outlineVariant: outlineVariant.objOrNul(),
      shadow: shadow.objOrNul(),
      scrim: scrim.objOrNul(),
      inverseSurface: inverseSurface.objOrNul(),
      onInverseSurface: onInverseSurface.objOrNul(),
      inversePrimary: inversePrimary.objOrNul(),
      surfaceTint: surfaceTint.objOrNul(),
      background: background.objOrNul(),
      onBackground: onBackground.objOrNul(),
      surfaceVariant: surfaceVariant.objOrNul());
  return _createColorSchemeObjSt(w);
}
ColorSchemeObjSt colorSchemeFromSeed(DartDartObj seedColor, ffi.Pointer<ffi.Int> brightness, ffi.Pointer<ffi.Int> dynamicSchemeVariant, ffi.Pointer<ffi.Double> contrastLevel, ffi.Pointer<DartObj> primary, ffi.Pointer<DartObj> onPrimary, ffi.Pointer<DartObj> primaryContainer, ffi.Pointer<DartObj> onPrimaryContainer, ffi.Pointer<DartObj> primaryFixed, ffi.Pointer<DartObj> primaryFixedDim, ffi.Pointer<DartObj> onPrimaryFixed, ffi.Pointer<DartObj> onPrimaryFixedVariant, ffi.Pointer<DartObj> secondary, ffi.Pointer<DartObj> onSecondary, ffi.Pointer<DartObj> secondaryContainer, ffi.Pointer<DartObj> onSecondaryContainer, ffi.Pointer<DartObj> secondaryFixed, ffi.Pointer<DartObj> secondaryFixedDim, ffi.Pointer<DartObj> onSecondaryFixed, ffi.Pointer<DartObj> onSecondaryFixedVariant, ffi.Pointer<DartObj> tertiary, ffi.Pointer<DartObj> onTertiary, ffi.Pointer<DartObj> tertiaryContainer, ffi.Pointer<DartObj> onTertiaryContainer, ffi.Pointer<DartObj> tertiaryFixed, ffi.Pointer<DartObj> tertiaryFixedDim, ffi.Pointer<DartObj> onTertiaryFixed, ffi.Pointer<DartObj> onTertiaryFixedVariant, ffi.Pointer<DartObj> error, ffi.Pointer<DartObj> onError, ffi.Pointer<DartObj> errorContainer, ffi.Pointer<DartObj> onErrorContainer, ffi.Pointer<DartObj> outline, ffi.Pointer<DartObj> outlineVariant, ffi.Pointer<DartObj> surface, ffi.Pointer<DartObj> onSurface, ffi.Pointer<DartObj> surfaceDim, ffi.Pointer<DartObj> surfaceBright, ffi.Pointer<DartObj> surfaceContainerLowest, ffi.Pointer<DartObj> surfaceContainerLow, ffi.Pointer<DartObj> surfaceContainer, ffi.Pointer<DartObj> surfaceContainerHigh, ffi.Pointer<DartObj> surfaceContainerHighest, ffi.Pointer<DartObj> onSurfaceVariant, ffi.Pointer<DartObj> inverseSurface, ffi.Pointer<DartObj> onInverseSurface, ffi.Pointer<DartObj> inversePrimary, ffi.Pointer<DartObj> shadow, ffi.Pointer<DartObj> scrim, ffi.Pointer<DartObj> surfaceTint, ffi.Pointer<DartObj> background, ffi.Pointer<DartObj> onBackground, ffi.Pointer<DartObj> surfaceVariant) {
  final w = ColorScheme.fromSeed(seedColor: _widgetsMap[seedColor]! as Color,
      brightness: brightness.enumOr(Brightness.values, Brightness.light),
      dynamicSchemeVariant: dynamicSchemeVariant.enumOr(DynamicSchemeVariant.values, DynamicSchemeVariant.tonalSpot),
      contrastLevel: contrastLevel.doubleOr(0.0),
      primary: primary.objOrNul(),
      onPrimary: onPrimary.objOrNul(),
      primaryContainer: primaryContainer.objOrNul(),
      onPrimaryContainer: onPrimaryContainer.objOrNul(),
      primaryFixed: primaryFixed.objOrNul(),
      primaryFixedDim: primaryFixedDim.objOrNul(),
      onPrimaryFixed: onPrimaryFixed.objOrNul(),
      onPrimaryFixedVariant: onPrimaryFixedVariant.objOrNul(),
      secondary: secondary.objOrNul(),
      onSecondary: onSecondary.objOrNul(),
      secondaryContainer: secondaryContainer.objOrNul(),
      onSecondaryContainer: onSecondaryContainer.objOrNul(),
      secondaryFixed: secondaryFixed.objOrNul(),
      secondaryFixedDim: secondaryFixedDim.objOrNul(),
      onSecondaryFixed: onSecondaryFixed.objOrNul(),
      onSecondaryFixedVariant: onSecondaryFixedVariant.objOrNul(),
      tertiary: tertiary.objOrNul(),
      onTertiary: onTertiary.objOrNul(),
      tertiaryContainer: tertiaryContainer.objOrNul(),
      onTertiaryContainer: onTertiaryContainer.objOrNul(),
      tertiaryFixed: tertiaryFixed.objOrNul(),
      tertiaryFixedDim: tertiaryFixedDim.objOrNul(),
      onTertiaryFixed: onTertiaryFixed.objOrNul(),
      onTertiaryFixedVariant: onTertiaryFixedVariant.objOrNul(),
      error: error.objOrNul(),
      onError: onError.objOrNul(),
      errorContainer: errorContainer.objOrNul(),
      onErrorContainer: onErrorContainer.objOrNul(),
      outline: outline.objOrNul(),
      outlineVariant: outlineVariant.objOrNul(),
      surface: surface.objOrNul(),
      onSurface: onSurface.objOrNul(),
      surfaceDim: surfaceDim.objOrNul(),
      surfaceBright: surfaceBright.objOrNul(),
      surfaceContainerLowest: surfaceContainerLowest.objOrNul(),
      surfaceContainerLow: surfaceContainerLow.objOrNul(),
      surfaceContainer: surfaceContainer.objOrNul(),
      surfaceContainerHigh: surfaceContainerHigh.objOrNul(),
      surfaceContainerHighest: surfaceContainerHighest.objOrNul(),
      onSurfaceVariant: onSurfaceVariant.objOrNul(),
      inverseSurface: inverseSurface.objOrNul(),
      onInverseSurface: onInverseSurface.objOrNul(),
      inversePrimary: inversePrimary.objOrNul(),
      shadow: shadow.objOrNul(),
      scrim: scrim.objOrNul(),
      surfaceTint: surfaceTint.objOrNul(),
      background: background.objOrNul(),
      onBackground: onBackground.objOrNul(),
      surfaceVariant: surfaceVariant.objOrNul());
  return _createColorSchemeObjSt(w);
}
ColorSchemeObjSt colorSchemeLight(ffi.Pointer<ffi.Int> brightness, ffi.Pointer<DartObj> primary, ffi.Pointer<DartObj> onPrimary, ffi.Pointer<DartObj> primaryContainer, ffi.Pointer<DartObj> onPrimaryContainer, ffi.Pointer<DartObj> primaryFixed, ffi.Pointer<DartObj> primaryFixedDim, ffi.Pointer<DartObj> onPrimaryFixed, ffi.Pointer<DartObj> onPrimaryFixedVariant, ffi.Pointer<DartObj> secondary, ffi.Pointer<DartObj> onSecondary, ffi.Pointer<DartObj> secondaryContainer, ffi.Pointer<DartObj> onSecondaryContainer, ffi.Pointer<DartObj> secondaryFixed, ffi.Pointer<DartObj> secondaryFixedDim, ffi.Pointer<DartObj> onSecondaryFixed, ffi.Pointer<DartObj> onSecondaryFixedVariant, ffi.Pointer<DartObj> tertiary, ffi.Pointer<DartObj> onTertiary, ffi.Pointer<DartObj> tertiaryContainer, ffi.Pointer<DartObj> onTertiaryContainer, ffi.Pointer<DartObj> tertiaryFixed, ffi.Pointer<DartObj> tertiaryFixedDim, ffi.Pointer<DartObj> onTertiaryFixed, ffi.Pointer<DartObj> onTertiaryFixedVariant, ffi.Pointer<DartObj> error, ffi.Pointer<DartObj> onError, ffi.Pointer<DartObj> errorContainer, ffi.Pointer<DartObj> onErrorContainer, ffi.Pointer<DartObj> surface, ffi.Pointer<DartObj> onSurface, ffi.Pointer<DartObj> surfaceDim, ffi.Pointer<DartObj> surfaceBright, ffi.Pointer<DartObj> surfaceContainerLowest, ffi.Pointer<DartObj> surfaceContainerLow, ffi.Pointer<DartObj> surfaceContainer, ffi.Pointer<DartObj> surfaceContainerHigh, ffi.Pointer<DartObj> surfaceContainerHighest, ffi.Pointer<DartObj> onSurfaceVariant, ffi.Pointer<DartObj> outline, ffi.Pointer<DartObj> outlineVariant, ffi.Pointer<DartObj> shadow, ffi.Pointer<DartObj> scrim, ffi.Pointer<DartObj> inverseSurface, ffi.Pointer<DartObj> onInverseSurface, ffi.Pointer<DartObj> inversePrimary, ffi.Pointer<DartObj> surfaceTint, ffi.Pointer<DartObj> background, ffi.Pointer<DartObj> onBackground, ffi.Pointer<DartObj> surfaceVariant) {
  final w = ColorScheme.light(brightness: brightness.enumOr(Brightness.values, Brightness.light),
      primary: primary.objOr(const Color(0xff6200ee)),
      onPrimary: onPrimary.objOr(Colors.white),
      primaryContainer: primaryContainer.objOrNul(),
      onPrimaryContainer: onPrimaryContainer.objOrNul(),
      primaryFixed: primaryFixed.objOrNul(),
      primaryFixedDim: primaryFixedDim.objOrNul(),
      onPrimaryFixed: onPrimaryFixed.objOrNul(),
      onPrimaryFixedVariant: onPrimaryFixedVariant.objOrNul(),
      secondary: secondary.objOr(const Color(0xff03dac6)),
      onSecondary: onSecondary.objOr(Colors.black),
      secondaryContainer: secondaryContainer.objOrNul(),
      onSecondaryContainer: onSecondaryContainer.objOrNul(),
      secondaryFixed: secondaryFixed.objOrNul(),
      secondaryFixedDim: secondaryFixedDim.objOrNul(),
      onSecondaryFixed: onSecondaryFixed.objOrNul(),
      onSecondaryFixedVariant: onSecondaryFixedVariant.objOrNul(),
      tertiary: tertiary.objOrNul(),
      onTertiary: onTertiary.objOrNul(),
      tertiaryContainer: tertiaryContainer.objOrNul(),
      onTertiaryContainer: onTertiaryContainer.objOrNul(),
      tertiaryFixed: tertiaryFixed.objOrNul(),
      tertiaryFixedDim: tertiaryFixedDim.objOrNul(),
      onTertiaryFixed: onTertiaryFixed.objOrNul(),
      onTertiaryFixedVariant: onTertiaryFixedVariant.objOrNul(),
      error: error.objOr(const Color(0xffb00020)),
      onError: onError.objOr(Colors.white),
      errorContainer: errorContainer.objOrNul(),
      onErrorContainer: onErrorContainer.objOrNul(),
      surface: surface.objOr(Colors.white),
      onSurface: onSurface.objOr(Colors.black),
      surfaceDim: surfaceDim.objOrNul(),
      surfaceBright: surfaceBright.objOrNul(),
      surfaceContainerLowest: surfaceContainerLowest.objOrNul(),
      surfaceContainerLow: surfaceContainerLow.objOrNul(),
      surfaceContainer: surfaceContainer.objOrNul(),
      surfaceContainerHigh: surfaceContainerHigh.objOrNul(),
      surfaceContainerHighest: surfaceContainerHighest.objOrNul(),
      onSurfaceVariant: onSurfaceVariant.objOrNul(),
      outline: outline.objOrNul(),
      outlineVariant: outlineVariant.objOrNul(),
      shadow: shadow.objOrNul(),
      scrim: scrim.objOrNul(),
      inverseSurface: inverseSurface.objOrNul(),
      onInverseSurface: onInverseSurface.objOrNul(),
      inversePrimary: inversePrimary.objOrNul(),
      surfaceTint: surfaceTint.objOrNul(),
      background: background.objOrNul(),
      onBackground: onBackground.objOrNul(),
      surfaceVariant: surfaceVariant.objOrNul());
  return _createColorSchemeObjSt(w);
}
ColorSchemeObjSt colorSchemeDark(ffi.Pointer<ffi.Int> brightness, ffi.Pointer<DartObj> primary, ffi.Pointer<DartObj> onPrimary, ffi.Pointer<DartObj> primaryContainer, ffi.Pointer<DartObj> onPrimaryContainer, ffi.Pointer<DartObj> primaryFixed, ffi.Pointer<DartObj> primaryFixedDim, ffi.Pointer<DartObj> onPrimaryFixed, ffi.Pointer<DartObj> onPrimaryFixedVariant, ffi.Pointer<DartObj> secondary, ffi.Pointer<DartObj> onSecondary, ffi.Pointer<DartObj> secondaryContainer, ffi.Pointer<DartObj> onSecondaryContainer, ffi.Pointer<DartObj> secondaryFixed, ffi.Pointer<DartObj> secondaryFixedDim, ffi.Pointer<DartObj> onSecondaryFixed, ffi.Pointer<DartObj> onSecondaryFixedVariant, ffi.Pointer<DartObj> tertiary, ffi.Pointer<DartObj> onTertiary, ffi.Pointer<DartObj> tertiaryContainer, ffi.Pointer<DartObj> onTertiaryContainer, ffi.Pointer<DartObj> tertiaryFixed, ffi.Pointer<DartObj> tertiaryFixedDim, ffi.Pointer<DartObj> onTertiaryFixed, ffi.Pointer<DartObj> onTertiaryFixedVariant, ffi.Pointer<DartObj> error, ffi.Pointer<DartObj> onError, ffi.Pointer<DartObj> errorContainer, ffi.Pointer<DartObj> onErrorContainer, ffi.Pointer<DartObj> surface, ffi.Pointer<DartObj> onSurface, ffi.Pointer<DartObj> surfaceDim, ffi.Pointer<DartObj> surfaceBright, ffi.Pointer<DartObj> surfaceContainerLowest, ffi.Pointer<DartObj> surfaceContainerLow, ffi.Pointer<DartObj> surfaceContainer, ffi.Pointer<DartObj> surfaceContainerHigh, ffi.Pointer<DartObj> surfaceContainerHighest, ffi.Pointer<DartObj> onSurfaceVariant, ffi.Pointer<DartObj> outline, ffi.Pointer<DartObj> outlineVariant, ffi.Pointer<DartObj> shadow, ffi.Pointer<DartObj> scrim, ffi.Pointer<DartObj> inverseSurface, ffi.Pointer<DartObj> onInverseSurface, ffi.Pointer<DartObj> inversePrimary, ffi.Pointer<DartObj> surfaceTint, ffi.Pointer<DartObj> background, ffi.Pointer<DartObj> onBackground, ffi.Pointer<DartObj> surfaceVariant) {
  final w = ColorScheme.dark(brightness: brightness.enumOr(Brightness.values, Brightness.dark),
      primary: primary.objOr(const Color(0xffbb86fc)),
      onPrimary: onPrimary.objOr(Colors.black),
      primaryContainer: primaryContainer.objOrNul(),
      onPrimaryContainer: onPrimaryContainer.objOrNul(),
      primaryFixed: primaryFixed.objOrNul(),
      primaryFixedDim: primaryFixedDim.objOrNul(),
      onPrimaryFixed: onPrimaryFixed.objOrNul(),
      onPrimaryFixedVariant: onPrimaryFixedVariant.objOrNul(),
      secondary: secondary.objOr(const Color(0xff03dac6)),
      onSecondary: onSecondary.objOr(Colors.black),
      secondaryContainer: secondaryContainer.objOrNul(),
      onSecondaryContainer: onSecondaryContainer.objOrNul(),
      secondaryFixed: secondaryFixed.objOrNul(),
      secondaryFixedDim: secondaryFixedDim.objOrNul(),
      onSecondaryFixed: onSecondaryFixed.objOrNul(),
      onSecondaryFixedVariant: onSecondaryFixedVariant.objOrNul(),
      tertiary: tertiary.objOrNul(),
      onTertiary: onTertiary.objOrNul(),
      tertiaryContainer: tertiaryContainer.objOrNul(),
      onTertiaryContainer: onTertiaryContainer.objOrNul(),
      tertiaryFixed: tertiaryFixed.objOrNul(),
      tertiaryFixedDim: tertiaryFixedDim.objOrNul(),
      onTertiaryFixed: onTertiaryFixed.objOrNul(),
      onTertiaryFixedVariant: onTertiaryFixedVariant.objOrNul(),
      error: error.objOr(const Color(0xffcf6679)),
      onError: onError.objOr(Colors.black),
      errorContainer: errorContainer.objOrNul(),
      onErrorContainer: onErrorContainer.objOrNul(),
      surface: surface.objOr(const Color(0xff121212)),
      onSurface: onSurface.objOr(Colors.white),
      surfaceDim: surfaceDim.objOrNul(),
      surfaceBright: surfaceBright.objOrNul(),
      surfaceContainerLowest: surfaceContainerLowest.objOrNul(),
      surfaceContainerLow: surfaceContainerLow.objOrNul(),
      surfaceContainer: surfaceContainer.objOrNul(),
      surfaceContainerHigh: surfaceContainerHigh.objOrNul(),
      surfaceContainerHighest: surfaceContainerHighest.objOrNul(),
      onSurfaceVariant: onSurfaceVariant.objOrNul(),
      outline: outline.objOrNul(),
      outlineVariant: outlineVariant.objOrNul(),
      shadow: shadow.objOrNul(),
      scrim: scrim.objOrNul(),
      inverseSurface: inverseSurface.objOrNul(),
      onInverseSurface: onInverseSurface.objOrNul(),
      inversePrimary: inversePrimary.objOrNul(),
      surfaceTint: surfaceTint.objOrNul(),
      background: background.objOrNul(),
      onBackground: onBackground.objOrNul(),
      surfaceVariant: surfaceVariant.objOrNul());
  return _createColorSchemeObjSt(w);
}
ColorSchemeObjSt colorSchemeHighContrastLight(ffi.Pointer<ffi.Int> brightness, ffi.Pointer<DartObj> primary, ffi.Pointer<DartObj> onPrimary, ffi.Pointer<DartObj> primaryContainer, ffi.Pointer<DartObj> onPrimaryContainer, ffi.Pointer<DartObj> primaryFixed, ffi.Pointer<DartObj> primaryFixedDim, ffi.Pointer<DartObj> onPrimaryFixed, ffi.Pointer<DartObj> onPrimaryFixedVariant, ffi.Pointer<DartObj> secondary, ffi.Pointer<DartObj> onSecondary, ffi.Pointer<DartObj> secondaryContainer, ffi.Pointer<DartObj> onSecondaryContainer, ffi.Pointer<DartObj> secondaryFixed, ffi.Pointer<DartObj> secondaryFixedDim, ffi.Pointer<DartObj> onSecondaryFixed, ffi.Pointer<DartObj> onSecondaryFixedVariant, ffi.Pointer<DartObj> tertiary, ffi.Pointer<DartObj> onTertiary, ffi.Pointer<DartObj> tertiaryContainer, ffi.Pointer<DartObj> onTertiaryContainer, ffi.Pointer<DartObj> tertiaryFixed, ffi.Pointer<DartObj> tertiaryFixedDim, ffi.Pointer<DartObj> onTertiaryFixed, ffi.Pointer<DartObj> onTertiaryFixedVariant, ffi.Pointer<DartObj> error, ffi.Pointer<DartObj> onError, ffi.Pointer<DartObj> errorContainer, ffi.Pointer<DartObj> onErrorContainer, ffi.Pointer<DartObj> surface, ffi.Pointer<DartObj> onSurface, ffi.Pointer<DartObj> surfaceDim, ffi.Pointer<DartObj> surfaceBright, ffi.Pointer<DartObj> surfaceContainerLowest, ffi.Pointer<DartObj> surfaceContainerLow, ffi.Pointer<DartObj> surfaceContainer, ffi.Pointer<DartObj> surfaceContainerHigh, ffi.Pointer<DartObj> surfaceContainerHighest, ffi.Pointer<DartObj> onSurfaceVariant, ffi.Pointer<DartObj> outline, ffi.Pointer<DartObj> outlineVariant, ffi.Pointer<DartObj> shadow, ffi.Pointer<DartObj> scrim, ffi.Pointer<DartObj> inverseSurface, ffi.Pointer<DartObj> onInverseSurface, ffi.Pointer<DartObj> inversePrimary, ffi.Pointer<DartObj> surfaceTint, ffi.Pointer<DartObj> background, ffi.Pointer<DartObj> onBackground, ffi.Pointer<DartObj> surfaceVariant) {
  final w = ColorScheme.highContrastLight(brightness: brightness.enumOr(Brightness.values, Brightness.light),
      primary: primary.objOr(const Color(0xff0000ba)),
      onPrimary: onPrimary.objOr(Colors.white),
      primaryContainer: primaryContainer.objOrNul(),
      onPrimaryContainer: onPrimaryContainer.objOrNul(),
      primaryFixed: primaryFixed.objOrNul(),
      primaryFixedDim: primaryFixedDim.objOrNul(),
      onPrimaryFixed: onPrimaryFixed.objOrNul(),
      onPrimaryFixedVariant: onPrimaryFixedVariant.objOrNul(),
      secondary: secondary.objOr(const Color(0xff66fff9)),
      onSecondary: onSecondary.objOr(Colors.black),
      secondaryContainer: secondaryContainer.objOrNul(),
      onSecondaryContainer: onSecondaryContainer.objOrNul(),
      secondaryFixed: secondaryFixed.objOrNul(),
      secondaryFixedDim: secondaryFixedDim.objOrNul(),
      onSecondaryFixed: onSecondaryFixed.objOrNul(),
      onSecondaryFixedVariant: onSecondaryFixedVariant.objOrNul(),
      tertiary: tertiary.objOrNul(),
      onTertiary: onTertiary.objOrNul(),
      tertiaryContainer: tertiaryContainer.objOrNul(),
      onTertiaryContainer: onTertiaryContainer.objOrNul(),
      tertiaryFixed: tertiaryFixed.objOrNul(),
      tertiaryFixedDim: tertiaryFixedDim.objOrNul(),
      onTertiaryFixed: onTertiaryFixed.objOrNul(),
      onTertiaryFixedVariant: onTertiaryFixedVariant.objOrNul(),
      error: error.objOr(const Color(0xff790000)),
      onError: onError.objOr(Colors.white),
      errorContainer: errorContainer.objOrNul(),
      onErrorContainer: onErrorContainer.objOrNul(),
      surface: surface.objOr(Colors.white),
      onSurface: onSurface.objOr(Colors.black),
      surfaceDim: surfaceDim.objOrNul(),
      surfaceBright: surfaceBright.objOrNul(),
      surfaceContainerLowest: surfaceContainerLowest.objOrNul(),
      surfaceContainerLow: surfaceContainerLow.objOrNul(),
      surfaceContainer: surfaceContainer.objOrNul(),
      surfaceContainerHigh: surfaceContainerHigh.objOrNul(),
      surfaceContainerHighest: surfaceContainerHighest.objOrNul(),
      onSurfaceVariant: onSurfaceVariant.objOrNul(),
      outline: outline.objOrNul(),
      outlineVariant: outlineVariant.objOrNul(),
      shadow: shadow.objOrNul(),
      scrim: scrim.objOrNul(),
      inverseSurface: inverseSurface.objOrNul(),
      onInverseSurface: onInverseSurface.objOrNul(),
      inversePrimary: inversePrimary.objOrNul(),
      surfaceTint: surfaceTint.objOrNul(),
      background: background.objOrNul(),
      onBackground: onBackground.objOrNul(),
      surfaceVariant: surfaceVariant.objOrNul());
  return _createColorSchemeObjSt(w);
}
ColorSchemeObjSt colorSchemeHighContrastDark(ffi.Pointer<ffi.Int> brightness, ffi.Pointer<DartObj> primary, ffi.Pointer<DartObj> onPrimary, ffi.Pointer<DartObj> primaryContainer, ffi.Pointer<DartObj> onPrimaryContainer, ffi.Pointer<DartObj> primaryFixed, ffi.Pointer<DartObj> primaryFixedDim, ffi.Pointer<DartObj> onPrimaryFixed, ffi.Pointer<DartObj> onPrimaryFixedVariant, ffi.Pointer<DartObj> secondary, ffi.Pointer<DartObj> onSecondary, ffi.Pointer<DartObj> secondaryContainer, ffi.Pointer<DartObj> onSecondaryContainer, ffi.Pointer<DartObj> secondaryFixed, ffi.Pointer<DartObj> secondaryFixedDim, ffi.Pointer<DartObj> onSecondaryFixed, ffi.Pointer<DartObj> onSecondaryFixedVariant, ffi.Pointer<DartObj> tertiary, ffi.Pointer<DartObj> onTertiary, ffi.Pointer<DartObj> tertiaryContainer, ffi.Pointer<DartObj> onTertiaryContainer, ffi.Pointer<DartObj> tertiaryFixed, ffi.Pointer<DartObj> tertiaryFixedDim, ffi.Pointer<DartObj> onTertiaryFixed, ffi.Pointer<DartObj> onTertiaryFixedVariant, ffi.Pointer<DartObj> error, ffi.Pointer<DartObj> onError, ffi.Pointer<DartObj> errorContainer, ffi.Pointer<DartObj> onErrorContainer, ffi.Pointer<DartObj> surface, ffi.Pointer<DartObj> onSurface, ffi.Pointer<DartObj> surfaceDim, ffi.Pointer<DartObj> surfaceBright, ffi.Pointer<DartObj> surfaceContainerLowest, ffi.Pointer<DartObj> surfaceContainerLow, ffi.Pointer<DartObj> surfaceContainer, ffi.Pointer<DartObj> surfaceContainerHigh, ffi.Pointer<DartObj> surfaceContainerHighest, ffi.Pointer<DartObj> onSurfaceVariant, ffi.Pointer<DartObj> outline, ffi.Pointer<DartObj> outlineVariant, ffi.Pointer<DartObj> shadow, ffi.Pointer<DartObj> scrim, ffi.Pointer<DartObj> inverseSurface, ffi.Pointer<DartObj> onInverseSurface, ffi.Pointer<DartObj> inversePrimary, ffi.Pointer<DartObj> surfaceTint, ffi.Pointer<DartObj> background, ffi.Pointer<DartObj> onBackground, ffi.Pointer<DartObj> surfaceVariant) {
  final w = ColorScheme.highContrastDark(brightness: brightness.enumOr(Brightness.values, Brightness.dark),
      primary: primary.objOr(const Color(0xffefb7ff)),
      onPrimary: onPrimary.objOr(Colors.black),
      primaryContainer: primaryContainer.objOrNul(),
      onPrimaryContainer: onPrimaryContainer.objOrNul(),
      primaryFixed: primaryFixed.objOrNul(),
      primaryFixedDim: primaryFixedDim.objOrNul(),
      onPrimaryFixed: onPrimaryFixed.objOrNul(),
      onPrimaryFixedVariant: onPrimaryFixedVariant.objOrNul(),
      secondary: secondary.objOr(const Color(0xff66fff9)),
      onSecondary: onSecondary.objOr(Colors.black),
      secondaryContainer: secondaryContainer.objOrNul(),
      onSecondaryContainer: onSecondaryContainer.objOrNul(),
      secondaryFixed: secondaryFixed.objOrNul(),
      secondaryFixedDim: secondaryFixedDim.objOrNul(),
      onSecondaryFixed: onSecondaryFixed.objOrNul(),
      onSecondaryFixedVariant: onSecondaryFixedVariant.objOrNul(),
      tertiary: tertiary.objOrNul(),
      onTertiary: onTertiary.objOrNul(),
      tertiaryContainer: tertiaryContainer.objOrNul(),
      onTertiaryContainer: onTertiaryContainer.objOrNul(),
      tertiaryFixed: tertiaryFixed.objOrNul(),
      tertiaryFixedDim: tertiaryFixedDim.objOrNul(),
      onTertiaryFixed: onTertiaryFixed.objOrNul(),
      onTertiaryFixedVariant: onTertiaryFixedVariant.objOrNul(),
      error: error.objOr(const Color(0xff9b374d)),
      onError: onError.objOr(Colors.black),
      errorContainer: errorContainer.objOrNul(),
      onErrorContainer: onErrorContainer.objOrNul(),
      surface: surface.objOr(const Color(0xff121212)),
      onSurface: onSurface.objOr(Colors.white),
      surfaceDim: surfaceDim.objOrNul(),
      surfaceBright: surfaceBright.objOrNul(),
      surfaceContainerLowest: surfaceContainerLowest.objOrNul(),
      surfaceContainerLow: surfaceContainerLow.objOrNul(),
      surfaceContainer: surfaceContainer.objOrNul(),
      surfaceContainerHigh: surfaceContainerHigh.objOrNul(),
      surfaceContainerHighest: surfaceContainerHighest.objOrNul(),
      onSurfaceVariant: onSurfaceVariant.objOrNul(),
      outline: outline.objOrNul(),
      outlineVariant: outlineVariant.objOrNul(),
      shadow: shadow.objOrNul(),
      scrim: scrim.objOrNul(),
      inverseSurface: inverseSurface.objOrNul(),
      onInverseSurface: onInverseSurface.objOrNul(),
      inversePrimary: inversePrimary.objOrNul(),
      surfaceTint: surfaceTint.objOrNul(),
      background: background.objOrNul(),
      onBackground: onBackground.objOrNul(),
      surfaceVariant: surfaceVariant.objOrNul());
  return _createColorSchemeObjSt(w);
}
ColorSchemeObjSt colorSchemeFromSwatch(ffi.Pointer<DartObj> primarySwatch, ffi.Pointer<DartObj> accentColor, ffi.Pointer<DartObj> cardColor, ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<DartObj> errorColor, ffi.Pointer<ffi.Int> brightness) {
  final w = ColorScheme.fromSwatch(primarySwatch: primarySwatch.objOr(Colors.blue),
      accentColor: accentColor.objOrNul(),
      cardColor: cardColor.objOrNul(),
      backgroundColor: backgroundColor.objOrNul(),
      errorColor: errorColor.objOrNul(),
      brightness: brightness.enumOr(Brightness.values, Brightness.light));
  return _createColorSchemeObjSt(w);
}
ColorSchemeObjSt colorSchemeLerp(DartDartObj a, DartDartObj b, double t) {
  final w = ColorScheme.lerp(_widgetsMap[a]! as ColorScheme,
      _widgetsMap[b]! as ColorScheme,
      t);
  return _createColorSchemeObjSt(w);
}
ColorSchemeObjSt colorSchemeOf(DartDartObj context) {
  final w = ColorScheme.of(_widgetsMap[context]! as BuildContext);
  return _createColorSchemeObjSt(w);
}
ColorSchemeObjSt _createColorSchemeObjSt(ColorScheme? w) {
  final ColorSchemeObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.brightness = w.brightness.index;
  stObj.primary = _addWidget(w.primary);
  stObj.onPrimary = _addWidget(w.onPrimary);
  stObj.secondary = _addWidget(w.secondary);
  stObj.onSecondary = _addWidget(w.onSecondary);
  stObj.error = _addWidget(w.error);
  stObj.onError = _addWidget(w.onError);
  stObj.surface = _addWidget(w.surface);
  stObj.onSurface = _addWidget(w.onSurface);
  stObj.primaryContainer = _addWidget(w.primaryContainer);
  stObj.onPrimaryContainer = _addWidget(w.onPrimaryContainer);
  stObj.primaryFixed = _addWidget(w.primaryFixed);
  stObj.primaryFixedDim = _addWidget(w.primaryFixedDim);
  stObj.onPrimaryFixed = _addWidget(w.onPrimaryFixed);
  stObj.onPrimaryFixedVariant = _addWidget(w.onPrimaryFixedVariant);
  stObj.secondaryContainer = _addWidget(w.secondaryContainer);
  stObj.onSecondaryContainer = _addWidget(w.onSecondaryContainer);
  stObj.secondaryFixed = _addWidget(w.secondaryFixed);
  stObj.secondaryFixedDim = _addWidget(w.secondaryFixedDim);
  stObj.onSecondaryFixed = _addWidget(w.onSecondaryFixed);
  stObj.onSecondaryFixedVariant = _addWidget(w.onSecondaryFixedVariant);
  stObj.tertiary = _addWidget(w.tertiary);
  stObj.onTertiary = _addWidget(w.onTertiary);
  stObj.tertiaryContainer = _addWidget(w.tertiaryContainer);
  stObj.onTertiaryContainer = _addWidget(w.onTertiaryContainer);
  stObj.tertiaryFixed = _addWidget(w.tertiaryFixed);
  stObj.tertiaryFixedDim = _addWidget(w.tertiaryFixedDim);
  stObj.onTertiaryFixed = _addWidget(w.onTertiaryFixed);
  stObj.onTertiaryFixedVariant = _addWidget(w.onTertiaryFixedVariant);
  stObj.errorContainer = _addWidget(w.errorContainer);
  stObj.onErrorContainer = _addWidget(w.onErrorContainer);
  stObj.surfaceVariant = _addWidget(w.surfaceVariant);
  stObj.surfaceDim = _addWidget(w.surfaceDim);
  stObj.surfaceBright = _addWidget(w.surfaceBright);
  stObj.surfaceContainerLowest = _addWidget(w.surfaceContainerLowest);
  stObj.surfaceContainerLow = _addWidget(w.surfaceContainerLow);
  stObj.surfaceContainer = _addWidget(w.surfaceContainer);
  stObj.surfaceContainerHigh = _addWidget(w.surfaceContainerHigh);
  stObj.surfaceContainerHighest = _addWidget(w.surfaceContainerHighest);
  stObj.onSurfaceVariant = _addWidget(w.onSurfaceVariant);
  stObj.outline = _addWidget(w.outline);
  stObj.outlineVariant = _addWidget(w.outlineVariant);
  stObj.shadow = _addWidget(w.shadow);
  stObj.scrim = _addWidget(w.scrim);
  stObj.inverseSurface = _addWidget(w.inverseSurface);
  stObj.onInverseSurface = _addWidget(w.onInverseSurface);
  stObj.inversePrimary = _addWidget(w.inversePrimary);
  stObj.surfaceTint = _addWidget(w.surfaceTint);
  stObj.background = _addWidget(w.background);
  stObj.onBackground = _addWidget(w.onBackground);
  return stObj;
}

void _setupMaterialColor(WidgetFactories f) {
  f.materialColor.materialColor = ffi.Pointer.fromFunction(materialColorMaterialColor);
}
MaterialColorObjSt materialColorMaterialColor(int primary, MapC swatch) {
  final w = MaterialColor(primary,
      swatch.toMap());
  return _createMaterialColorObjSt(w);
}
MaterialColorObjSt _createMaterialColorObjSt(MaterialColor? w) {
  final MaterialColorObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.shade50 = _addWidget(w.shade50);
  stObj.shade100 = _addWidget(w.shade100);
  stObj.shade200 = _addWidget(w.shade200);
  stObj.shade300 = _addWidget(w.shade300);
  stObj.shade400 = _addWidget(w.shade400);
  stObj.shade500 = _addWidget(w.shade500);
  stObj.shade600 = _addWidget(w.shade600);
  stObj.shade700 = _addWidget(w.shade700);
  stObj.shade800 = _addWidget(w.shade800);
  stObj.shade900 = _addWidget(w.shade900);
  return stObj;
}

void _setupColorSwatch(WidgetFactories f) {
  f.colorSwatch.lerp = ffi.Pointer.fromFunction(colorSwatchLerp);
}
ColorSwatchObjSt colorSwatchLerp(DartDartObj a, DartDartObj b, double t) {
  final w = ColorSwatch.lerp(_widgetsMap[a]! as ColorSwatch,
      _widgetsMap[b]! as ColorSwatch,
      t);
  return _createColorSwatchObjSt(w);
}
ColorSwatchObjSt _createColorSwatchObjSt(ColorSwatch? w) {
  final ColorSwatchObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  return stObj;
}

void _setupTextTheme(WidgetFactories f) {
  f.textTheme.textTheme = ffi.Pointer.fromFunction(textThemeTextTheme);
  f.textTheme.lerp = ffi.Pointer.fromFunction(textThemeLerp);
  f.textTheme.of = ffi.Pointer.fromFunction(textThemeOf);
  f.textTheme.primaryOf = ffi.Pointer.fromFunction(textThemePrimaryOf);
}
TextThemeObjSt textThemeTextTheme(ffi.Pointer<DartObj> displayLarge, ffi.Pointer<DartObj> displayMedium, ffi.Pointer<DartObj> displaySmall, ffi.Pointer<DartObj> headlineLarge, ffi.Pointer<DartObj> headlineMedium, ffi.Pointer<DartObj> headlineSmall, ffi.Pointer<DartObj> titleLarge, ffi.Pointer<DartObj> titleMedium, ffi.Pointer<DartObj> titleSmall, ffi.Pointer<DartObj> bodyLarge, ffi.Pointer<DartObj> bodyMedium, ffi.Pointer<DartObj> bodySmall, ffi.Pointer<DartObj> labelLarge, ffi.Pointer<DartObj> labelMedium, ffi.Pointer<DartObj> labelSmall) {
  final w = TextTheme(displayLarge: displayLarge.objOrNul(),
      displayMedium: displayMedium.objOrNul(),
      displaySmall: displaySmall.objOrNul(),
      headlineLarge: headlineLarge.objOrNul(),
      headlineMedium: headlineMedium.objOrNul(),
      headlineSmall: headlineSmall.objOrNul(),
      titleLarge: titleLarge.objOrNul(),
      titleMedium: titleMedium.objOrNul(),
      titleSmall: titleSmall.objOrNul(),
      bodyLarge: bodyLarge.objOrNul(),
      bodyMedium: bodyMedium.objOrNul(),
      bodySmall: bodySmall.objOrNul(),
      labelLarge: labelLarge.objOrNul(),
      labelMedium: labelMedium.objOrNul(),
      labelSmall: labelSmall.objOrNul());
  return _createTextThemeObjSt(w);
}
TextThemeObjSt textThemeLerp(DartDartObj a, DartDartObj b, double t) {
  final w = TextTheme.lerp(_widgetsMap[a]! as TextTheme?,
      _widgetsMap[b]! as TextTheme?,
      t);
  return _createTextThemeObjSt(w);
}
TextThemeObjSt textThemeOf(DartDartObj context) {
  final w = TextTheme.of(_widgetsMap[context]! as BuildContext);
  return _createTextThemeObjSt(w);
}
TextThemeObjSt textThemePrimaryOf(DartDartObj context) {
  final w = TextTheme.primaryOf(_widgetsMap[context]! as BuildContext);
  return _createTextThemeObjSt(w);
}
TextThemeObjSt _createTextThemeObjSt(TextTheme? w) {
  final TextThemeObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.displayLarge = _createTextStyleObjSt(w.displayLarge);
  stObj.displayMedium = _createTextStyleObjSt(w.displayMedium);
  stObj.displaySmall = _createTextStyleObjSt(w.displaySmall);
  stObj.headlineLarge = _createTextStyleObjSt(w.headlineLarge);
  stObj.headlineMedium = _createTextStyleObjSt(w.headlineMedium);
  stObj.headlineSmall = _createTextStyleObjSt(w.headlineSmall);
  stObj.titleLarge = _createTextStyleObjSt(w.titleLarge);
  stObj.titleMedium = _createTextStyleObjSt(w.titleMedium);
  stObj.titleSmall = _createTextStyleObjSt(w.titleSmall);
  stObj.bodyLarge = _createTextStyleObjSt(w.bodyLarge);
  stObj.bodyMedium = _createTextStyleObjSt(w.bodyMedium);
  stObj.bodySmall = _createTextStyleObjSt(w.bodySmall);
  stObj.labelLarge = _createTextStyleObjSt(w.labelLarge);
  stObj.labelMedium = _createTextStyleObjSt(w.labelMedium);
  stObj.labelSmall = _createTextStyleObjSt(w.labelSmall);
  return stObj;
}

void _setupVisualDensity(WidgetFactories f) {
  f.visualDensity.visualDensity = ffi.Pointer.fromFunction(visualDensityVisualDensity);
  f.visualDensity.defaultDensityForPlatform = ffi.Pointer.fromFunction(visualDensityDefaultDensityForPlatform);
  f.visualDensity.lerp = ffi.Pointer.fromFunction(visualDensityLerp);
}
VisualDensityObjSt visualDensityVisualDensity(ffi.Pointer<ffi.Double> horizontal, ffi.Pointer<ffi.Double> vertical) {
  final w = VisualDensity(horizontal: horizontal.doubleOr(0.0),
      vertical: vertical.doubleOr(0.0));
  return _createVisualDensityObjSt(w);
}
VisualDensityObjSt visualDensityDefaultDensityForPlatform(int platform) {
  final w = VisualDensity.defaultDensityForPlatform(TargetPlatform.values[platform]);
  return _createVisualDensityObjSt(w);
}
VisualDensityObjSt visualDensityLerp(DartDartObj a, DartDartObj b, double t) {
  final w = VisualDensity.lerp(_widgetsMap[a]! as VisualDensity,
      _widgetsMap[b]! as VisualDensity,
      t);
  return _createVisualDensityObjSt(w);
}
VisualDensityObjSt _createVisualDensityObjSt(VisualDensity? w) {
  final VisualDensityObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.horizontal = w.horizontal;
  stObj.vertical = w.vertical;
  stObj.baseSizeAdjustment = _addWidget(w.baseSizeAdjustment);
  return stObj;
}

void _setupThemeData(WidgetFactories f) {
  f.themeData.themeData = ffi.Pointer.fromFunction(themeDataThemeData);
  f.themeData.from = ffi.Pointer.fromFunction(themeDataFrom);
  f.themeData.light = ffi.Pointer.fromFunction(themeDataLight);
  f.themeData.dark = ffi.Pointer.fromFunction(themeDataDark);
  f.themeData.fallback = ffi.Pointer.fromFunction(themeDataFallback);
  f.themeData.localize = ffi.Pointer.fromFunction(themeDataLocalize);
  f.themeData.estimateBrightnessForColor = ffi.Pointer.fromFunction(themeDataEstimateBrightnessForColor, exception);
  f.themeData.lerp = ffi.Pointer.fromFunction(themeDataLerp);
}
ThemeDataObjSt themeDataThemeData(ffi.Pointer<ffi.Int> applyElevationOverlayColor, ffi.Pointer<DartObj> inputDecorationTheme, ffi.Pointer<ffi.Int> materialTapTargetSize, ffi.Pointer<ffi.Int> platform, ffi.Pointer<ffi.Int> useMaterial3, ffi.Pointer<ffi.Int> useSystemColors, ffi.Pointer<DartObj> visualDensity, ffi.Pointer<DartObj> colorScheme, ffi.Pointer<ffi.Int> brightness, ffi.Pointer<DartObj> colorSchemeSeed, ffi.Pointer<DartObj> canvasColor, ffi.Pointer<DartObj> cardColor, ffi.Pointer<DartObj> disabledColor, ffi.Pointer<DartObj> dividerColor, ffi.Pointer<DartObj> focusColor, ffi.Pointer<DartObj> highlightColor, ffi.Pointer<DartObj> hintColor, ffi.Pointer<DartObj> hoverColor, ffi.Pointer<DartObj> primaryColor, ffi.Pointer<DartObj> primaryColorDark, ffi.Pointer<DartObj> primaryColorLight, ffi.Pointer<DartObj> primarySwatch, ffi.Pointer<DartObj> scaffoldBackgroundColor, ffi.Pointer<DartObj> secondaryHeaderColor, ffi.Pointer<DartObj> shadowColor, ffi.Pointer<DartObj> splashColor, ffi.Pointer<DartObj> unselectedWidgetColor, ffi.Pointer<ffi.Char> fontFamily, ffi.Pointer<ffi.Pointer<ffi.Pointer<ffi.Char>>> fontFamilyFallback, ffi.Pointer<ffi.Char> package, ffi.Pointer<DartObj> primaryTextTheme, ffi.Pointer<DartObj> textTheme, ffi.Pointer<DartObj> appBarTheme, ffi.Pointer<DartObj> dialogBackgroundColor, ffi.Pointer<DartObj> indicatorColor) {
  final w = ThemeData(applyElevationOverlayColor: applyElevationOverlayColor.boolOrNul(),
      inputDecorationTheme: inputDecorationTheme.objOrNul(),
      materialTapTargetSize: materialTapTargetSize.enumOrNul(MaterialTapTargetSize.values),
      platform: platform.enumOrNul(TargetPlatform.values),
      useMaterial3: useMaterial3.boolOrNul(),
      useSystemColors: useSystemColors.boolOrNul(),
      visualDensity: visualDensity.objOrNul(),
      colorScheme: colorScheme.objOrNul(),
      brightness: brightness.enumOrNul(Brightness.values),
      colorSchemeSeed: colorSchemeSeed.objOrNul(),
      canvasColor: canvasColor.objOrNul(),
      cardColor: cardColor.objOrNul(),
      disabledColor: disabledColor.objOrNul(),
      dividerColor: dividerColor.objOrNul(),
      focusColor: focusColor.objOrNul(),
      highlightColor: highlightColor.objOrNul(),
      hintColor: hintColor.objOrNul(),
      hoverColor: hoverColor.objOrNul(),
      primaryColor: primaryColor.objOrNul(),
      primaryColorDark: primaryColorDark.objOrNul(),
      primaryColorLight: primaryColorLight.objOrNul(),
      primarySwatch: primarySwatch.objOrNul(),
      scaffoldBackgroundColor: scaffoldBackgroundColor.objOrNul(),
      secondaryHeaderColor: secondaryHeaderColor.objOrNul(),
      shadowColor: shadowColor.objOrNul(),
      splashColor: splashColor.objOrNul(),
      unselectedWidgetColor: unselectedWidgetColor.objOrNul(),
      fontFamily: fontFamily.strOrNul(),
      fontFamilyFallback: fontFamilyFallback.listOrNul(),
      package: package.strOrNul(),
      primaryTextTheme: primaryTextTheme.objOrNul(),
      textTheme: textTheme.objOrNul(),
      appBarTheme: appBarTheme.objOrNul(),
      dialogBackgroundColor: dialogBackgroundColor.objOrNul(),
      indicatorColor: indicatorColor.objOrNul());
  return _createThemeDataObjSt(w);
}
ThemeDataObjSt themeDataFrom(DartDartObj colorScheme, ffi.Pointer<DartObj> textTheme, ffi.Pointer<ffi.Int> useMaterial3) {
  final w = ThemeData.from(colorScheme: _widgetsMap[colorScheme]! as ColorScheme,
      textTheme: textTheme.objOrNul(),
      useMaterial3: useMaterial3.boolOrNul());
  return _createThemeDataObjSt(w);
}
ThemeDataObjSt themeDataLight(ffi.Pointer<ffi.Int> useMaterial3) {
  final w = ThemeData.light(useMaterial3: useMaterial3.boolOrNul());
  return _createThemeDataObjSt(w);
}
ThemeDataObjSt themeDataDark(ffi.Pointer<ffi.Int> useMaterial3) {
  final w = ThemeData.dark(useMaterial3: useMaterial3.boolOrNul());
  return _createThemeDataObjSt(w);
}
ThemeDataObjSt themeDataFallback(ffi.Pointer<ffi.Int> useMaterial3) {
  final w = ThemeData.fallback(useMaterial3: useMaterial3.boolOrNul());
  return _createThemeDataObjSt(w);
}
ThemeDataObjSt themeDataLocalize(DartDartObj baseTheme, DartDartObj localTextGeometry) {
  final w = ThemeData.localize(_widgetsMap[baseTheme]! as ThemeData,
      _widgetsMap[localTextGeometry]! as TextTheme);
  return _createThemeDataObjSt(w);
}
int themeDataEstimateBrightnessForColor(DartDartObj color) {
  final w = ThemeData.estimateBrightnessForColor(_widgetsMap[color]! as Color);
  return w.index;
}
ThemeDataObjSt themeDataLerp(DartDartObj a, DartDartObj b, double t) {
  final w = ThemeData.lerp(_widgetsMap[a]! as ThemeData,
      _widgetsMap[b]! as ThemeData,
      t);
  return _createThemeDataObjSt(w);
}
ThemeDataObjSt _createThemeDataObjSt(ThemeData? w) {
  final ThemeDataObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.applyElevationOverlayColor = w.applyElevationOverlayColor.toInt();
  stObj.materialTapTargetSize = w.materialTapTargetSize.index;
  stObj.platform = w.platform.index;
  stObj.useMaterial3 = w.useMaterial3.toInt();
  stObj.visualDensity = _createVisualDensityObjSt(w.visualDensity);
  stObj.canvasColor = _addWidget(w.canvasColor);
  stObj.cardColor = _addWidget(w.cardColor);
  stObj.colorScheme = _createColorSchemeObjSt(w.colorScheme);
  stObj.disabledColor = _addWidget(w.disabledColor);
  stObj.dividerColor = _addWidget(w.dividerColor);
  stObj.focusColor = _addWidget(w.focusColor);
  stObj.highlightColor = _addWidget(w.highlightColor);
  stObj.hintColor = _addWidget(w.hintColor);
  stObj.hoverColor = _addWidget(w.hoverColor);
  stObj.primaryColor = _addWidget(w.primaryColor);
  stObj.primaryColorDark = _addWidget(w.primaryColorDark);
  stObj.primaryColorLight = _addWidget(w.primaryColorLight);
  stObj.scaffoldBackgroundColor = _addWidget(w.scaffoldBackgroundColor);
  stObj.secondaryHeaderColor = _addWidget(w.secondaryHeaderColor);
  stObj.shadowColor = _addWidget(w.shadowColor);
  stObj.splashColor = _addWidget(w.splashColor);
  stObj.unselectedWidgetColor = _addWidget(w.unselectedWidgetColor);
  stObj.primaryTextTheme = _createTextThemeObjSt(w.primaryTextTheme);
  stObj.textTheme = _createTextThemeObjSt(w.textTheme);
  stObj.dialogBackgroundColor = _addWidget(w.dialogBackgroundColor);
  stObj.indicatorColor = _addWidget(w.indicatorColor);
  stObj.brightness = w.brightness.index;
  return stObj;
}

void _setupMaterialAccentColor(WidgetFactories f) {
  f.materialAccentColor.materialAccentColor = ffi.Pointer.fromFunction(materialAccentColorMaterialAccentColor);
}
MaterialAccentColorObjSt materialAccentColorMaterialAccentColor(int primary, MapC swatch) {
  final w = MaterialAccentColor(primary,
      swatch.toMap());
  return _createMaterialAccentColorObjSt(w);
}
MaterialAccentColorObjSt _createMaterialAccentColorObjSt(MaterialAccentColor? w) {
  final MaterialAccentColorObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.shade100 = _addWidget(w.shade100);
  stObj.shade200 = _addWidget(w.shade200);
  stObj.shade400 = _addWidget(w.shade400);
  stObj.shade700 = _addWidget(w.shade700);
  return stObj;
}

void _setupMaterial(WidgetFactories f) {
  f.material.material = ffi.Pointer.fromFunction(materialMaterial);
}
MaterialObjSt materialMaterial(ffi.Pointer<ffi.Int> type, ffi.Pointer<ffi.Double> elevation, ffi.Pointer<DartObj> color, ffi.Pointer<DartObj> shadowColor, ffi.Pointer<DartObj> surfaceTintColor, ffi.Pointer<DartObj> textStyle, ffi.Pointer<DartObj> borderRadius, ffi.Pointer<DartObj> shape, ffi.Pointer<ffi.Int> borderOnForeground, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<DartObj> animationDuration, ffi.Pointer<DartObj> child, ffi.Pointer<ffi.Int> animateColor) {
  final w = Material(type: type.enumOr(MaterialType.values, MaterialType.canvas),
      elevation: elevation.doubleOr(0.0),
      color: color.objOrNul(),
      shadowColor: shadowColor.objOrNul(),
      surfaceTintColor: surfaceTintColor.objOrNul(),
      textStyle: textStyle.objOrNul(),
      borderRadius: borderRadius.objOrNul(),
      shape: shape.objOrNul(),
      borderOnForeground: borderOnForeground.boolOr(true),
      clipBehavior: clipBehavior.enumOr(Clip.values, Clip.none),
      animationDuration: animationDuration.objOr(kThemeChangeDuration),
      child: child.objOrNul(),
      animateColor: animateColor.boolOr(false));
  return _createMaterialObjSt(w);
}
MaterialObjSt _createMaterialObjSt(Material? w) {
  final MaterialObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.child = _addWidget(w.child);
  stObj.type = w.type.index;
  stObj.animateColor = w.animateColor.toInt();
  stObj.elevation = w.elevation;
  stObj.color = _addWidget(w.color);
  stObj.shadowColor = _addWidget(w.shadowColor);
  stObj.surfaceTintColor = _addWidget(w.surfaceTintColor);
  stObj.textStyle = _createTextStyleObjSt(w.textStyle);
  stObj.shape = _addWidget(w.shape);
  stObj.borderOnForeground = w.borderOnForeground.toInt();
  stObj.clipBehavior = w.clipBehavior.index;
  stObj.animationDuration = _addWidget(w.animationDuration);
  stObj.borderRadius = _addWidget(w.borderRadius);
  return stObj;
}

void _setupIconButton(WidgetFactories f) {
  f.iconButton.iconButton = ffi.Pointer.fromFunction(iconButtonIconButton);
  f.iconButton.filled = ffi.Pointer.fromFunction(iconButtonFilled);
  f.iconButton.filledTonal = ffi.Pointer.fromFunction(iconButtonFilledTonal);
  f.iconButton.outlined = ffi.Pointer.fromFunction(iconButtonOutlined);
}
IconButtonObjSt iconButtonIconButton(ffi.Pointer<ffi.Double> iconSize, ffi.Pointer<DartObj> visualDensity, ffi.Pointer<DartObj> padding, ffi.Pointer<DartObj> alignment, ffi.Pointer<ffi.Double> splashRadius, ffi.Pointer<DartObj> color, ffi.Pointer<DartObj> focusColor, ffi.Pointer<DartObj> hoverColor, ffi.Pointer<DartObj> highlightColor, ffi.Pointer<DartObj> splashColor, ffi.Pointer<DartObj> disabledColor, VoidCallbackFFI onPressed, ffi.Pointer<ValueChangedForBoolFFI> onHover, ffi.Pointer<VoidCallbackFFI> onLongPress, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<ffi.Char> tooltip, ffi.Pointer<ffi.Int> enableFeedback, ffi.Pointer<DartObj> constraints, ffi.Pointer<ffi.Int> isSelected, ffi.Pointer<DartObj> selectedIcon, DartDartObj icon) {
  final w = IconButton(iconSize: iconSize.doubleOrNul(),
      visualDensity: visualDensity.objOrNul(),
      padding: padding.objOrNul(),
      alignment: alignment.objOrNul(),
      splashRadius: splashRadius.doubleOrNul(),
      color: color.objOrNul(),
      focusColor: focusColor.objOrNul(),
      hoverColor: hoverColor.objOrNul(),
      highlightColor: highlightColor.objOrNul(),
      splashColor: splashColor.objOrNul(),
      disabledColor: disabledColor.objOrNul(),
      onPressed: onPressed.toVoidCallbackFn(),
      onHover: onHover.toValueChangedForBoolFn(),
      onLongPress: onLongPress.toVoidCallbackFn(),
      autofocus: autofocus.boolOr(false),
      tooltip: tooltip.strOrNul(),
      enableFeedback: enableFeedback.boolOrNul(),
      constraints: constraints.objOrNul(),
      isSelected: isSelected.boolOrNul(),
      selectedIcon: selectedIcon.objOrNul(),
      icon: _widgetsMap[icon]! as Widget);
  return _createIconButtonObjSt(w);
}
IconButtonObjSt iconButtonFilled(ffi.Pointer<ffi.Double> iconSize, ffi.Pointer<DartObj> visualDensity, ffi.Pointer<DartObj> padding, ffi.Pointer<DartObj> alignment, ffi.Pointer<ffi.Double> splashRadius, ffi.Pointer<DartObj> color, ffi.Pointer<DartObj> focusColor, ffi.Pointer<DartObj> hoverColor, ffi.Pointer<DartObj> highlightColor, ffi.Pointer<DartObj> splashColor, ffi.Pointer<DartObj> disabledColor, VoidCallbackFFI onPressed, ffi.Pointer<ValueChangedForBoolFFI> onHover, ffi.Pointer<VoidCallbackFFI> onLongPress, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<ffi.Char> tooltip, ffi.Pointer<ffi.Int> enableFeedback, ffi.Pointer<DartObj> constraints, ffi.Pointer<ffi.Int> isSelected, ffi.Pointer<DartObj> selectedIcon, DartDartObj icon) {
  final w = IconButton.filled(iconSize: iconSize.doubleOrNul(),
      visualDensity: visualDensity.objOrNul(),
      padding: padding.objOrNul(),
      alignment: alignment.objOrNul(),
      splashRadius: splashRadius.doubleOrNul(),
      color: color.objOrNul(),
      focusColor: focusColor.objOrNul(),
      hoverColor: hoverColor.objOrNul(),
      highlightColor: highlightColor.objOrNul(),
      splashColor: splashColor.objOrNul(),
      disabledColor: disabledColor.objOrNul(),
      onPressed: onPressed.toVoidCallbackFn(),
      onHover: onHover.toValueChangedForBoolFn(),
      onLongPress: onLongPress.toVoidCallbackFn(),
      autofocus: autofocus.boolOr(false),
      tooltip: tooltip.strOrNul(),
      enableFeedback: enableFeedback.boolOrNul(),
      constraints: constraints.objOrNul(),
      isSelected: isSelected.boolOrNul(),
      selectedIcon: selectedIcon.objOrNul(),
      icon: _widgetsMap[icon]! as Widget);
  return _createIconButtonObjSt(w);
}
IconButtonObjSt iconButtonFilledTonal(ffi.Pointer<ffi.Double> iconSize, ffi.Pointer<DartObj> visualDensity, ffi.Pointer<DartObj> padding, ffi.Pointer<DartObj> alignment, ffi.Pointer<ffi.Double> splashRadius, ffi.Pointer<DartObj> color, ffi.Pointer<DartObj> focusColor, ffi.Pointer<DartObj> hoverColor, ffi.Pointer<DartObj> highlightColor, ffi.Pointer<DartObj> splashColor, ffi.Pointer<DartObj> disabledColor, VoidCallbackFFI onPressed, ffi.Pointer<ValueChangedForBoolFFI> onHover, ffi.Pointer<VoidCallbackFFI> onLongPress, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<ffi.Char> tooltip, ffi.Pointer<ffi.Int> enableFeedback, ffi.Pointer<DartObj> constraints, ffi.Pointer<ffi.Int> isSelected, ffi.Pointer<DartObj> selectedIcon, DartDartObj icon) {
  final w = IconButton.filledTonal(iconSize: iconSize.doubleOrNul(),
      visualDensity: visualDensity.objOrNul(),
      padding: padding.objOrNul(),
      alignment: alignment.objOrNul(),
      splashRadius: splashRadius.doubleOrNul(),
      color: color.objOrNul(),
      focusColor: focusColor.objOrNul(),
      hoverColor: hoverColor.objOrNul(),
      highlightColor: highlightColor.objOrNul(),
      splashColor: splashColor.objOrNul(),
      disabledColor: disabledColor.objOrNul(),
      onPressed: onPressed.toVoidCallbackFn(),
      onHover: onHover.toValueChangedForBoolFn(),
      onLongPress: onLongPress.toVoidCallbackFn(),
      autofocus: autofocus.boolOr(false),
      tooltip: tooltip.strOrNul(),
      enableFeedback: enableFeedback.boolOrNul(),
      constraints: constraints.objOrNul(),
      isSelected: isSelected.boolOrNul(),
      selectedIcon: selectedIcon.objOrNul(),
      icon: _widgetsMap[icon]! as Widget);
  return _createIconButtonObjSt(w);
}
IconButtonObjSt iconButtonOutlined(ffi.Pointer<ffi.Double> iconSize, ffi.Pointer<DartObj> visualDensity, ffi.Pointer<DartObj> padding, ffi.Pointer<DartObj> alignment, ffi.Pointer<ffi.Double> splashRadius, ffi.Pointer<DartObj> color, ffi.Pointer<DartObj> focusColor, ffi.Pointer<DartObj> hoverColor, ffi.Pointer<DartObj> highlightColor, ffi.Pointer<DartObj> splashColor, ffi.Pointer<DartObj> disabledColor, VoidCallbackFFI onPressed, ffi.Pointer<ValueChangedForBoolFFI> onHover, ffi.Pointer<VoidCallbackFFI> onLongPress, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<ffi.Char> tooltip, ffi.Pointer<ffi.Int> enableFeedback, ffi.Pointer<DartObj> constraints, ffi.Pointer<ffi.Int> isSelected, ffi.Pointer<DartObj> selectedIcon, DartDartObj icon) {
  final w = IconButton.outlined(iconSize: iconSize.doubleOrNul(),
      visualDensity: visualDensity.objOrNul(),
      padding: padding.objOrNul(),
      alignment: alignment.objOrNul(),
      splashRadius: splashRadius.doubleOrNul(),
      color: color.objOrNul(),
      focusColor: focusColor.objOrNul(),
      hoverColor: hoverColor.objOrNul(),
      highlightColor: highlightColor.objOrNul(),
      splashColor: splashColor.objOrNul(),
      disabledColor: disabledColor.objOrNul(),
      onPressed: onPressed.toVoidCallbackFn(),
      onHover: onHover.toValueChangedForBoolFn(),
      onLongPress: onLongPress.toVoidCallbackFn(),
      autofocus: autofocus.boolOr(false),
      tooltip: tooltip.strOrNul(),
      enableFeedback: enableFeedback.boolOrNul(),
      constraints: constraints.objOrNul(),
      isSelected: isSelected.boolOrNul(),
      selectedIcon: selectedIcon.objOrNul(),
      icon: _widgetsMap[icon]! as Widget);
  return _createIconButtonObjSt(w);
}
IconButtonObjSt _createIconButtonObjSt(IconButton? w) {
  final IconButtonObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.iconSize = (w.iconSize != null) ? w.iconSize! : 0;
  stObj.visualDensity = _createVisualDensityObjSt(w.visualDensity);
  stObj.padding = _addWidget(w.padding);
  stObj.alignment = _addWidget(w.alignment);
  stObj.splashRadius = (w.splashRadius != null) ? w.splashRadius! : 0;
  stObj.icon = _addWidget(w.icon);
  stObj.focusColor = _addWidget(w.focusColor);
  stObj.hoverColor = _addWidget(w.hoverColor);
  stObj.color = _addWidget(w.color);
  stObj.splashColor = _addWidget(w.splashColor);
  stObj.highlightColor = _addWidget(w.highlightColor);
  stObj.disabledColor = _addWidget(w.disabledColor);
  stObj.autofocus = w.autofocus.toInt();
  stObj.tooltip = (w.tooltip != null) ? w.tooltip!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.enableFeedback = (w.enableFeedback != null) ? w.enableFeedback!.toInt() : 0;
  stObj.constraints = _createBoxConstraintsObjSt(w.constraints);
  stObj.isSelected = (w.isSelected != null) ? w.isSelected!.toInt() : 0;
  stObj.selectedIcon = _addWidget(w.selectedIcon);
  return stObj;
}

void _setupAppBar(WidgetFactories f) {
  f.appBar.appBar = ffi.Pointer.fromFunction(appBarAppBar);
}
AppBarObjSt appBarAppBar(ffi.Pointer<DartObj> leading, ffi.Pointer<ffi.Int> automaticallyImplyLeading, ffi.Pointer<DartObj> title, ffi.Pointer<ArrayC> actions, ffi.Pointer<DartObj> flexibleSpace, ffi.Pointer<DartObj> bottom, ffi.Pointer<ffi.Double> elevation, ffi.Pointer<ffi.Double> scrolledUnderElevation, ffi.Pointer<DartObj> shadowColor, ffi.Pointer<DartObj> surfaceTintColor, ffi.Pointer<DartObj> shape, ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<DartObj> foregroundColor, ffi.Pointer<ffi.Int> primary, ffi.Pointer<ffi.Int> centerTitle, ffi.Pointer<ffi.Int> excludeHeaderSemantics, ffi.Pointer<ffi.Double> titleSpacing, ffi.Pointer<ffi.Double> toolbarOpacity, ffi.Pointer<ffi.Double> bottomOpacity, ffi.Pointer<ffi.Double> toolbarHeight, ffi.Pointer<ffi.Double> leadingWidth, ffi.Pointer<DartObj> toolbarTextStyle, ffi.Pointer<DartObj> titleTextStyle, ffi.Pointer<ffi.Int> forceMaterialTransparency, ffi.Pointer<ffi.Int> useDefaultSemanticsOrder, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<DartObj> actionsPadding, ffi.Pointer<ffi.Int> animateColor) {
  final w = AppBar(leading: leading.objOrNul(),
      automaticallyImplyLeading: automaticallyImplyLeading.boolOr(true),
      title: title.objOrNul(),
      actions: actions.listOrNul(),
      flexibleSpace: flexibleSpace.objOrNul(),
      bottom: bottom.objOrNul(),
      elevation: elevation.doubleOrNul(),
      scrolledUnderElevation: scrolledUnderElevation.doubleOrNul(),
      shadowColor: shadowColor.objOrNul(),
      surfaceTintColor: surfaceTintColor.objOrNul(),
      shape: shape.objOrNul(),
      backgroundColor: backgroundColor.objOrNul(),
      foregroundColor: foregroundColor.objOrNul(),
      primary: primary.boolOr(true),
      centerTitle: centerTitle.boolOrNul(),
      excludeHeaderSemantics: excludeHeaderSemantics.boolOr(false),
      titleSpacing: titleSpacing.doubleOrNul(),
      toolbarOpacity: toolbarOpacity.doubleOr(1.0),
      bottomOpacity: bottomOpacity.doubleOr(1.0),
      toolbarHeight: toolbarHeight.doubleOrNul(),
      leadingWidth: leadingWidth.doubleOrNul(),
      toolbarTextStyle: toolbarTextStyle.objOrNul(),
      titleTextStyle: titleTextStyle.objOrNul(),
      forceMaterialTransparency: forceMaterialTransparency.boolOr(false),
      useDefaultSemanticsOrder: useDefaultSemanticsOrder.boolOr(true),
      clipBehavior: clipBehavior.enumOrNul(Clip.values),
      actionsPadding: actionsPadding.objOrNul(),
      animateColor: animateColor.boolOr(false));
  return _createAppBarObjSt(w);
}
AppBarObjSt _createAppBarObjSt(AppBar? w) {
  final AppBarObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.leading = _addWidget(w.leading);
  stObj.automaticallyImplyLeading = w.automaticallyImplyLeading.toInt();
  stObj.title = _addWidget(w.title);
  stObj.flexibleSpace = _addWidget(w.flexibleSpace);
  stObj.bottom = _addWidget(w.bottom);
  stObj.elevation = (w.elevation != null) ? w.elevation! : 0;
  stObj.scrolledUnderElevation = (w.scrolledUnderElevation != null) ? w.scrolledUnderElevation! : 0;
  stObj.shadowColor = _addWidget(w.shadowColor);
  stObj.surfaceTintColor = _addWidget(w.surfaceTintColor);
  stObj.shape = _addWidget(w.shape);
  stObj.backgroundColor = _addWidget(w.backgroundColor);
  stObj.foregroundColor = _addWidget(w.foregroundColor);
  stObj.primary = w.primary.toInt();
  stObj.centerTitle = (w.centerTitle != null) ? w.centerTitle!.toInt() : 0;
  stObj.excludeHeaderSemantics = w.excludeHeaderSemantics.toInt();
  stObj.titleSpacing = (w.titleSpacing != null) ? w.titleSpacing! : 0;
  stObj.toolbarOpacity = w.toolbarOpacity;
  stObj.bottomOpacity = w.bottomOpacity;
  stObj.toolbarHeight = (w.toolbarHeight != null) ? w.toolbarHeight! : 0;
  stObj.leadingWidth = (w.leadingWidth != null) ? w.leadingWidth! : 0;
  stObj.toolbarTextStyle = _createTextStyleObjSt(w.toolbarTextStyle);
  stObj.titleTextStyle = _createTextStyleObjSt(w.titleTextStyle);
  stObj.forceMaterialTransparency = w.forceMaterialTransparency.toInt();
  stObj.useDefaultSemanticsOrder = w.useDefaultSemanticsOrder.toInt();
  stObj.clipBehavior = (w.clipBehavior != null) ? w.clipBehavior!.index : 0;
  stObj.actionsPadding = _addWidget(w.actionsPadding);
  stObj.animateColor = w.animateColor.toInt();
  return stObj;
}

void _setupScaffold(WidgetFactories f) {
  f.scaffold.scaffold = ffi.Pointer.fromFunction(scaffoldScaffold);
  f.scaffold.geometryOf = ffi.Pointer.fromFunction(scaffoldGeometryOf, exception);
  f.scaffold.hasDrawer = ffi.Pointer.fromFunction(scaffoldHasDrawer, exception);
}
ScaffoldObjSt scaffoldScaffold(ffi.Pointer<DartObj> appBar, ffi.Pointer<DartObj> body, ffi.Pointer<DartObj> floatingActionButton, ffi.Pointer<ArrayC> persistentFooterButtons, ffi.Pointer<DartObj> persistentFooterAlignment, ffi.Pointer<DartObj> persistentFooterDecoration, ffi.Pointer<DartObj> drawer, ffi.Pointer<DrawerCallbackFFI> onDrawerChanged, ffi.Pointer<DartObj> endDrawer, ffi.Pointer<DrawerCallbackFFI> onEndDrawerChanged, ffi.Pointer<DartObj> bottomNavigationBar, ffi.Pointer<DartObj> bottomSheet, ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<ffi.Int> resizeToAvoidBottomInset, ffi.Pointer<ffi.Int> primary, ffi.Pointer<ffi.Int> drawerDragStartBehavior, ffi.Pointer<ffi.Int> extendBody, ffi.Pointer<ffi.Int> drawerBarrierDismissible, ffi.Pointer<ffi.Int> extendBodyBehindAppBar, ffi.Pointer<DartObj> drawerScrimColor, ffi.Pointer<DartObjCallbackDartObjDartObjFFI> bottomSheetScrimBuilder, ffi.Pointer<ffi.Double> drawerEdgeDragWidth, ffi.Pointer<ffi.Int> drawerEnableOpenDragGesture, ffi.Pointer<ffi.Int> endDrawerEnableOpenDragGesture, ffi.Pointer<ffi.Char> restorationId) {
  final w = Scaffold(appBar: appBar.objOrNul(),
      body: body.objOrNul(),
      floatingActionButton: floatingActionButton.objOrNul(),
      persistentFooterButtons: persistentFooterButtons.listOrNul(),
      persistentFooterAlignment: persistentFooterAlignment.objOr(AlignmentDirectional.centerEnd),
      persistentFooterDecoration: persistentFooterDecoration.objOrNul(),
      drawer: drawer.objOrNul(),
      onDrawerChanged: onDrawerChanged.toDrawerCallbackFn(),
      endDrawer: endDrawer.objOrNul(),
      onEndDrawerChanged: onEndDrawerChanged.toDrawerCallbackFn(),
      bottomNavigationBar: bottomNavigationBar.objOrNul(),
      bottomSheet: bottomSheet.objOrNul(),
      backgroundColor: backgroundColor.objOrNul(),
      resizeToAvoidBottomInset: resizeToAvoidBottomInset.boolOrNul(),
      primary: primary.boolOr(true),
      drawerDragStartBehavior: drawerDragStartBehavior.enumOr(DragStartBehavior.values, DragStartBehavior.start),
      extendBody: extendBody.boolOr(false),
      drawerBarrierDismissible: drawerBarrierDismissible.boolOr(true),
      extendBodyBehindAppBar: extendBodyBehindAppBar.boolOr(false),
      drawerScrimColor: drawerScrimColor.objOrNul(),
      bottomSheetScrimBuilder: (bottomSheetScrimBuilder.toDartObjCallbackDartObjDartObjFn() ?? (p0, p1) => null),
      drawerEdgeDragWidth: drawerEdgeDragWidth.doubleOrNul(),
      drawerEnableOpenDragGesture: drawerEnableOpenDragGesture.boolOr(true),
      endDrawerEnableOpenDragGesture: endDrawerEnableOpenDragGesture.boolOr(true),
      restorationId: restorationId.strOrNul());
  return _createScaffoldObjSt(w);
}
int scaffoldGeometryOf(DartDartObj context) {
  final w = Scaffold.geometryOf(_widgetsMap[context]! as BuildContext);
  return _addWidget(w);
}
int scaffoldHasDrawer(DartDartObj context, ffi.Pointer<ffi.Int> registerForUpdates) {
  final w = Scaffold.hasDrawer(_widgetsMap[context]! as BuildContext,
      registerForUpdates: registerForUpdates.boolOr(true));
  return w.toInt();
}
ScaffoldObjSt _createScaffoldObjSt(Scaffold? w) {
  final ScaffoldObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.extendBody = w.extendBody.toInt();
  stObj.drawerBarrierDismissible = w.drawerBarrierDismissible.toInt();
  stObj.extendBodyBehindAppBar = w.extendBodyBehindAppBar.toInt();
  stObj.appBar = _addWidget(w.appBar);
  stObj.body = _addWidget(w.body);
  stObj.floatingActionButton = _addWidget(w.floatingActionButton);
  stObj.persistentFooterAlignment = _createAlignmentDirectionalObjSt(w.persistentFooterAlignment);
  stObj.persistentFooterDecoration = _createBoxDecorationObjSt(w.persistentFooterDecoration);
  stObj.drawer = _addWidget(w.drawer);
  stObj.endDrawer = _addWidget(w.endDrawer);
  stObj.drawerScrimColor = _addWidget(w.drawerScrimColor);
  stObj.backgroundColor = _addWidget(w.backgroundColor);
  stObj.bottomNavigationBar = _addWidget(w.bottomNavigationBar);
  stObj.bottomSheet = _addWidget(w.bottomSheet);
  stObj.resizeToAvoidBottomInset = (w.resizeToAvoidBottomInset != null) ? w.resizeToAvoidBottomInset!.toInt() : 0;
  stObj.primary = w.primary.toInt();
  stObj.drawerDragStartBehavior = w.drawerDragStartBehavior.index;
  stObj.drawerEdgeDragWidth = (w.drawerEdgeDragWidth != null) ? w.drawerEdgeDragWidth! : 0;
  stObj.drawerEnableOpenDragGesture = w.drawerEnableOpenDragGesture.toInt();
  stObj.endDrawerEnableOpenDragGesture = w.endDrawerEnableOpenDragGesture.toInt();
  stObj.restorationId = (w.restorationId != null) ? w.restorationId!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  return stObj;
}

void _setupMaterialApp(WidgetFactories f) {
  f.materialApp.materialApp = ffi.Pointer.fromFunction(materialAppMaterialApp);
  f.materialApp.router = ffi.Pointer.fromFunction(materialAppRouter);
}
MaterialAppObjSt materialAppMaterialApp(ffi.Pointer<DartObj> home, ffi.Pointer<ffi.Char> initialRoute, ffi.Pointer<TransitionBuilderFFI> builder, ffi.Pointer<ffi.Char> title, ffi.Pointer<GenerateAppTitleFFI> onGenerateTitle, ffi.Pointer<DartObj> color, ffi.Pointer<DartObj> theme, ffi.Pointer<DartObj> darkTheme, ffi.Pointer<DartObj> highContrastTheme, ffi.Pointer<DartObj> highContrastDarkTheme, ffi.Pointer<ffi.Int> themeMode, ffi.Pointer<DartObj> themeAnimationDuration, ffi.Pointer<DartObj> themeAnimationCurve, ffi.Pointer<ffi.Int> debugShowMaterialGrid, ffi.Pointer<ffi.Int> showPerformanceOverlay, ffi.Pointer<ffi.Int> checkerboardRasterCacheImages, ffi.Pointer<ffi.Int> checkerboardOffscreenLayers, ffi.Pointer<ffi.Int> showSemanticsDebugger, ffi.Pointer<ffi.Int> debugShowCheckedModeBanner, ffi.Pointer<ffi.Char> restorationScopeId, ffi.Pointer<ffi.Int> useInheritedMediaQuery) {
  final w = MaterialApp(home: home.objOrNul(),
      initialRoute: initialRoute.strOrNul(),
      builder: builder.toTransitionBuilderFn(),
      title: title.strOrNul(),
      onGenerateTitle: onGenerateTitle.toGenerateAppTitleFn(),
      color: color.objOrNul(),
      theme: theme.objOrNul(),
      darkTheme: darkTheme.objOrNul(),
      highContrastTheme: highContrastTheme.objOrNul(),
      highContrastDarkTheme: highContrastDarkTheme.objOrNul(),
      themeMode: themeMode.enumOrNul(ThemeMode.values),
      themeAnimationDuration: themeAnimationDuration.objOr(kThemeAnimationDuration),
      themeAnimationCurve: themeAnimationCurve.objOr(Curves.linear),
      debugShowMaterialGrid: debugShowMaterialGrid.boolOr(false),
      showPerformanceOverlay: showPerformanceOverlay.boolOr(false),
      checkerboardRasterCacheImages: checkerboardRasterCacheImages.boolOr(false),
      checkerboardOffscreenLayers: checkerboardOffscreenLayers.boolOr(false),
      showSemanticsDebugger: showSemanticsDebugger.boolOr(false),
      debugShowCheckedModeBanner: debugShowCheckedModeBanner.boolOr(true),
      restorationScopeId: restorationScopeId.strOrNul(),
      useInheritedMediaQuery: useInheritedMediaQuery.boolOr(false));
  return _createMaterialAppObjSt(w);
}
MaterialAppObjSt materialAppRouter(ffi.Pointer<TransitionBuilderFFI> builder, ffi.Pointer<ffi.Char> title, ffi.Pointer<GenerateAppTitleFFI> onGenerateTitle, ffi.Pointer<DartObj> color, ffi.Pointer<DartObj> theme, ffi.Pointer<DartObj> darkTheme, ffi.Pointer<DartObj> highContrastTheme, ffi.Pointer<DartObj> highContrastDarkTheme, ffi.Pointer<ffi.Int> themeMode, ffi.Pointer<DartObj> themeAnimationDuration, ffi.Pointer<DartObj> themeAnimationCurve, ffi.Pointer<ffi.Int> debugShowMaterialGrid, ffi.Pointer<ffi.Int> showPerformanceOverlay, ffi.Pointer<ffi.Int> checkerboardRasterCacheImages, ffi.Pointer<ffi.Int> checkerboardOffscreenLayers, ffi.Pointer<ffi.Int> showSemanticsDebugger, ffi.Pointer<ffi.Int> debugShowCheckedModeBanner, ffi.Pointer<ffi.Char> restorationScopeId, ffi.Pointer<ffi.Int> useInheritedMediaQuery) {
  final w = MaterialApp.router(builder: builder.toTransitionBuilderFn(),
      title: title.strOrNul(),
      onGenerateTitle: onGenerateTitle.toGenerateAppTitleFn(),
      color: color.objOrNul(),
      theme: theme.objOrNul(),
      darkTheme: darkTheme.objOrNul(),
      highContrastTheme: highContrastTheme.objOrNul(),
      highContrastDarkTheme: highContrastDarkTheme.objOrNul(),
      themeMode: themeMode.enumOrNul(ThemeMode.values),
      themeAnimationDuration: themeAnimationDuration.objOr(kThemeAnimationDuration),
      themeAnimationCurve: themeAnimationCurve.objOr(Curves.linear),
      debugShowMaterialGrid: debugShowMaterialGrid.boolOr(false),
      showPerformanceOverlay: showPerformanceOverlay.boolOr(false),
      checkerboardRasterCacheImages: checkerboardRasterCacheImages.boolOr(false),
      checkerboardOffscreenLayers: checkerboardOffscreenLayers.boolOr(false),
      showSemanticsDebugger: showSemanticsDebugger.boolOr(false),
      debugShowCheckedModeBanner: debugShowCheckedModeBanner.boolOr(true),
      restorationScopeId: restorationScopeId.strOrNul(),
      useInheritedMediaQuery: useInheritedMediaQuery.boolOr(false));
  return _createMaterialAppObjSt(w);
}
MaterialAppObjSt _createMaterialAppObjSt(MaterialApp? w) {
  final MaterialAppObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.home = _addWidget(w.home);
  stObj.initialRoute = (w.initialRoute != null) ? w.initialRoute!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.title = (w.title != null) ? w.title!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.theme = _createThemeDataObjSt(w.theme);
  stObj.darkTheme = _createThemeDataObjSt(w.darkTheme);
  stObj.highContrastTheme = _createThemeDataObjSt(w.highContrastTheme);
  stObj.highContrastDarkTheme = _createThemeDataObjSt(w.highContrastDarkTheme);
  stObj.themeMode = (w.themeMode != null) ? w.themeMode!.index : 0;
  stObj.themeAnimationDuration = _addWidget(w.themeAnimationDuration);
  stObj.themeAnimationCurve = _addWidget(w.themeAnimationCurve);
  stObj.color = _addWidget(w.color);
  stObj.showPerformanceOverlay = w.showPerformanceOverlay.toInt();
  stObj.checkerboardRasterCacheImages = w.checkerboardRasterCacheImages.toInt();
  stObj.checkerboardOffscreenLayers = w.checkerboardOffscreenLayers.toInt();
  stObj.showSemanticsDebugger = w.showSemanticsDebugger.toInt();
  stObj.debugShowCheckedModeBanner = w.debugShowCheckedModeBanner.toInt();
  stObj.restorationScopeId = (w.restorationScopeId != null) ? w.restorationScopeId!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.debugShowMaterialGrid = w.debugShowMaterialGrid.toInt();
  stObj.useInheritedMediaQuery = w.useInheritedMediaQuery.toInt();
  return stObj;
}

void _setupFloatingActionButton(WidgetFactories f) {
  f.floatingActionButton.floatingActionButton = ffi.Pointer.fromFunction(floatingActionButtonFloatingActionButton);
  f.floatingActionButton.small = ffi.Pointer.fromFunction(floatingActionButtonSmall);
  f.floatingActionButton.large = ffi.Pointer.fromFunction(floatingActionButtonLarge);
  f.floatingActionButton.extended = ffi.Pointer.fromFunction(floatingActionButtonExtended);
}
FloatingActionButtonObjSt floatingActionButtonFloatingActionButton(ffi.Pointer<DartObj> child, ffi.Pointer<ffi.Char> tooltip, ffi.Pointer<DartObj> foregroundColor, ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<DartObj> focusColor, ffi.Pointer<DartObj> hoverColor, ffi.Pointer<DartObj> splashColor, ffi.Pointer<DartObj> heroTag, ffi.Pointer<ffi.Double> elevation, ffi.Pointer<ffi.Double> focusElevation, ffi.Pointer<ffi.Double> hoverElevation, ffi.Pointer<ffi.Double> highlightElevation, ffi.Pointer<ffi.Double> disabledElevation, VoidCallbackFFI onPressed, ffi.Pointer<ffi.Int> mini, ffi.Pointer<DartObj> shape, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<ffi.Int> materialTapTargetSize, ffi.Pointer<ffi.Int> isExtended, ffi.Pointer<ffi.Int> enableFeedback) {
  final w = FloatingActionButton(child: child.objOrNul(),
      tooltip: tooltip.strOrNul(),
      foregroundColor: foregroundColor.objOrNul(),
      backgroundColor: backgroundColor.objOrNul(),
      focusColor: focusColor.objOrNul(),
      hoverColor: hoverColor.objOrNul(),
      splashColor: splashColor.objOrNul(),
      heroTag: heroTag.objOrNul(),
      elevation: elevation.doubleOrNul(),
      focusElevation: focusElevation.doubleOrNul(),
      hoverElevation: hoverElevation.doubleOrNul(),
      highlightElevation: highlightElevation.doubleOrNul(),
      disabledElevation: disabledElevation.doubleOrNul(),
      onPressed: onPressed.toVoidCallbackFn(),
      mini: mini.boolOr(false),
      shape: shape.objOrNul(),
      clipBehavior: clipBehavior.enumOr(Clip.values, Clip.none),
      autofocus: autofocus.boolOr(false),
      materialTapTargetSize: materialTapTargetSize.enumOrNul(MaterialTapTargetSize.values),
      isExtended: isExtended.boolOr(false),
      enableFeedback: enableFeedback.boolOrNul());
  return _createFloatingActionButtonObjSt(w);
}
FloatingActionButtonObjSt floatingActionButtonSmall(ffi.Pointer<DartObj> child, ffi.Pointer<ffi.Char> tooltip, ffi.Pointer<DartObj> foregroundColor, ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<DartObj> focusColor, ffi.Pointer<DartObj> hoverColor, ffi.Pointer<DartObj> splashColor, ffi.Pointer<DartObj> heroTag, ffi.Pointer<ffi.Double> elevation, ffi.Pointer<ffi.Double> focusElevation, ffi.Pointer<ffi.Double> hoverElevation, ffi.Pointer<ffi.Double> highlightElevation, ffi.Pointer<ffi.Double> disabledElevation, VoidCallbackFFI onPressed, ffi.Pointer<DartObj> shape, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<ffi.Int> materialTapTargetSize, ffi.Pointer<ffi.Int> enableFeedback) {
  final w = FloatingActionButton.small(child: child.objOrNul(),
      tooltip: tooltip.strOrNul(),
      foregroundColor: foregroundColor.objOrNul(),
      backgroundColor: backgroundColor.objOrNul(),
      focusColor: focusColor.objOrNul(),
      hoverColor: hoverColor.objOrNul(),
      splashColor: splashColor.objOrNul(),
      heroTag: heroTag.objOrNul(),
      elevation: elevation.doubleOrNul(),
      focusElevation: focusElevation.doubleOrNul(),
      hoverElevation: hoverElevation.doubleOrNul(),
      highlightElevation: highlightElevation.doubleOrNul(),
      disabledElevation: disabledElevation.doubleOrNul(),
      onPressed: onPressed.toVoidCallbackFn(),
      shape: shape.objOrNul(),
      clipBehavior: clipBehavior.enumOr(Clip.values, Clip.none),
      autofocus: autofocus.boolOr(false),
      materialTapTargetSize: materialTapTargetSize.enumOrNul(MaterialTapTargetSize.values),
      enableFeedback: enableFeedback.boolOrNul());
  return _createFloatingActionButtonObjSt(w);
}
FloatingActionButtonObjSt floatingActionButtonLarge(ffi.Pointer<DartObj> child, ffi.Pointer<ffi.Char> tooltip, ffi.Pointer<DartObj> foregroundColor, ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<DartObj> focusColor, ffi.Pointer<DartObj> hoverColor, ffi.Pointer<DartObj> splashColor, ffi.Pointer<DartObj> heroTag, ffi.Pointer<ffi.Double> elevation, ffi.Pointer<ffi.Double> focusElevation, ffi.Pointer<ffi.Double> hoverElevation, ffi.Pointer<ffi.Double> highlightElevation, ffi.Pointer<ffi.Double> disabledElevation, VoidCallbackFFI onPressed, ffi.Pointer<DartObj> shape, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<ffi.Int> materialTapTargetSize, ffi.Pointer<ffi.Int> enableFeedback) {
  final w = FloatingActionButton.large(child: child.objOrNul(),
      tooltip: tooltip.strOrNul(),
      foregroundColor: foregroundColor.objOrNul(),
      backgroundColor: backgroundColor.objOrNul(),
      focusColor: focusColor.objOrNul(),
      hoverColor: hoverColor.objOrNul(),
      splashColor: splashColor.objOrNul(),
      heroTag: heroTag.objOrNul(),
      elevation: elevation.doubleOrNul(),
      focusElevation: focusElevation.doubleOrNul(),
      hoverElevation: hoverElevation.doubleOrNul(),
      highlightElevation: highlightElevation.doubleOrNul(),
      disabledElevation: disabledElevation.doubleOrNul(),
      onPressed: onPressed.toVoidCallbackFn(),
      shape: shape.objOrNul(),
      clipBehavior: clipBehavior.enumOr(Clip.values, Clip.none),
      autofocus: autofocus.boolOr(false),
      materialTapTargetSize: materialTapTargetSize.enumOrNul(MaterialTapTargetSize.values),
      enableFeedback: enableFeedback.boolOrNul());
  return _createFloatingActionButtonObjSt(w);
}
FloatingActionButtonObjSt floatingActionButtonExtended(ffi.Pointer<ffi.Char> tooltip, ffi.Pointer<DartObj> foregroundColor, ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<DartObj> focusColor, ffi.Pointer<DartObj> hoverColor, ffi.Pointer<DartObj> heroTag, ffi.Pointer<ffi.Double> elevation, ffi.Pointer<ffi.Double> focusElevation, ffi.Pointer<ffi.Double> hoverElevation, ffi.Pointer<DartObj> splashColor, ffi.Pointer<ffi.Double> highlightElevation, ffi.Pointer<ffi.Double> disabledElevation, VoidCallbackFFI onPressed, ffi.Pointer<DartObj> shape, ffi.Pointer<ffi.Int> isExtended, ffi.Pointer<ffi.Int> materialTapTargetSize, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<ffi.Double> extendedIconLabelSpacing, ffi.Pointer<DartObj> extendedPadding, ffi.Pointer<DartObj> extendedTextStyle, ffi.Pointer<DartObj> icon, DartDartObj label, ffi.Pointer<ffi.Int> enableFeedback) {
  final w = FloatingActionButton.extended(tooltip: tooltip.strOrNul(),
      foregroundColor: foregroundColor.objOrNul(),
      backgroundColor: backgroundColor.objOrNul(),
      focusColor: focusColor.objOrNul(),
      hoverColor: hoverColor.objOrNul(),
      heroTag: heroTag.objOrNul(),
      elevation: elevation.doubleOrNul(),
      focusElevation: focusElevation.doubleOrNul(),
      hoverElevation: hoverElevation.doubleOrNul(),
      splashColor: splashColor.objOrNul(),
      highlightElevation: highlightElevation.doubleOrNul(),
      disabledElevation: disabledElevation.doubleOrNul(),
      onPressed: onPressed.toVoidCallbackFn(),
      shape: shape.objOrNul(),
      isExtended: isExtended.boolOr(true),
      materialTapTargetSize: materialTapTargetSize.enumOrNul(MaterialTapTargetSize.values),
      clipBehavior: clipBehavior.enumOr(Clip.values, Clip.none),
      autofocus: autofocus.boolOr(false),
      extendedIconLabelSpacing: extendedIconLabelSpacing.doubleOrNul(),
      extendedPadding: extendedPadding.objOrNul(),
      extendedTextStyle: extendedTextStyle.objOrNul(),
      icon: icon.objOrNul(),
      label: _widgetsMap[label]! as Widget,
      enableFeedback: enableFeedback.boolOrNul());
  return _createFloatingActionButtonObjSt(w);
}
FloatingActionButtonObjSt _createFloatingActionButtonObjSt(FloatingActionButton? w) {
  final FloatingActionButtonObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.child = _addWidget(w.child);
  stObj.tooltip = (w.tooltip != null) ? w.tooltip!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.foregroundColor = _addWidget(w.foregroundColor);
  stObj.backgroundColor = _addWidget(w.backgroundColor);
  stObj.focusColor = _addWidget(w.focusColor);
  stObj.hoverColor = _addWidget(w.hoverColor);
  stObj.splashColor = _addWidget(w.splashColor);
  stObj.elevation = (w.elevation != null) ? w.elevation! : 0;
  stObj.focusElevation = (w.focusElevation != null) ? w.focusElevation! : 0;
  stObj.hoverElevation = (w.hoverElevation != null) ? w.hoverElevation! : 0;
  stObj.highlightElevation = (w.highlightElevation != null) ? w.highlightElevation! : 0;
  stObj.disabledElevation = (w.disabledElevation != null) ? w.disabledElevation! : 0;
  stObj.mini = w.mini.toInt();
  stObj.shape = _addWidget(w.shape);
  stObj.clipBehavior = w.clipBehavior.index;
  stObj.isExtended = w.isExtended.toInt();
  stObj.autofocus = w.autofocus.toInt();
  stObj.materialTapTargetSize = (w.materialTapTargetSize != null) ? w.materialTapTargetSize!.index : 0;
  stObj.enableFeedback = (w.enableFeedback != null) ? w.enableFeedback!.toInt() : 0;
  stObj.extendedIconLabelSpacing = (w.extendedIconLabelSpacing != null) ? w.extendedIconLabelSpacing! : 0;
  stObj.extendedPadding = _addWidget(w.extendedPadding);
  stObj.extendedTextStyle = _createTextStyleObjSt(w.extendedTextStyle);
  return stObj;
}

void _setupTheme(WidgetFactories f) {
  f.theme.theme = ffi.Pointer.fromFunction(themeTheme);
  f.theme.of = ffi.Pointer.fromFunction(themeOf);
  f.theme.brightnessOf = ffi.Pointer.fromFunction(themeBrightnessOf, exception);
  f.theme.maybeBrightnessOf = ffi.Pointer.fromFunction(themeMaybeBrightnessOf, exception);
}
ThemeObjSt themeTheme(DartDartObj data, DartDartObj child) {
  final w = Theme(data: _widgetsMap[data]! as ThemeData,
      child: _widgetsMap[child]! as Widget);
  return _createThemeObjSt(w);
}
ThemeDataObjSt themeOf(DartDartObj context) {
  final w = Theme.of(_widgetsMap[context]! as BuildContext);
  return _createThemeDataObjSt(w);
}
int themeBrightnessOf(DartDartObj context) {
  final w = Theme.brightnessOf(_widgetsMap[context]! as BuildContext);
  return w.index;
}
int themeMaybeBrightnessOf(DartDartObj context) {
  final w = Theme.maybeBrightnessOf(_widgetsMap[context]! as BuildContext);
  return (w != null) ? w!.index : 0;
}
ThemeObjSt _createThemeObjSt(Theme? w) {
  final ThemeObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.data = _createThemeDataObjSt(w.data);
  stObj.child = _addWidget(w.child);
  return stObj;
}

void _setupElevatedButton(WidgetFactories f) {
  f.elevatedButton.elevatedButton = ffi.Pointer.fromFunction(elevatedButtonElevatedButton);
  f.elevatedButton.icon = ffi.Pointer.fromFunction(elevatedButtonIcon);
}
ElevatedButtonObjSt elevatedButtonElevatedButton(VoidCallbackFFI onPressed, ffi.Pointer<VoidCallbackFFI> onLongPress, ffi.Pointer<ValueChangedForBoolFFI> onHover, ffi.Pointer<ValueChangedForBoolFFI> onFocusChange, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<ffi.Int> clipBehavior, DartDartObj child) {
  final w = ElevatedButton(onPressed: onPressed.toVoidCallbackFn(),
      onLongPress: onLongPress.toVoidCallbackFn(),
      onHover: onHover.toValueChangedForBoolFn(),
      onFocusChange: onFocusChange.toValueChangedForBoolFn(),
      autofocus: autofocus.boolOr(false),
      clipBehavior: clipBehavior.enumOrNul(Clip.values),
      child: _widgetsMap[child]! as Widget?);
  return _createElevatedButtonObjSt(w);
}
ElevatedButtonObjSt elevatedButtonIcon(VoidCallbackFFI onPressed, ffi.Pointer<VoidCallbackFFI> onLongPress, ffi.Pointer<ValueChangedForBoolFFI> onHover, ffi.Pointer<ValueChangedForBoolFFI> onFocusChange, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<DartObj> icon, DartDartObj label, ffi.Pointer<ffi.Int> iconAlignment) {
  final w = ElevatedButton.icon(onPressed: onPressed.toVoidCallbackFn(),
      onLongPress: onLongPress.toVoidCallbackFn(),
      onHover: onHover.toValueChangedForBoolFn(),
      onFocusChange: onFocusChange.toValueChangedForBoolFn(),
      autofocus: autofocus.boolOrNul(),
      clipBehavior: clipBehavior.enumOrNul(Clip.values),
      icon: icon.objOrNul(),
      label: _widgetsMap[label]! as Widget,
      iconAlignment: iconAlignment.enumOrNul(IconAlignment.values));
  return _createElevatedButtonObjSt(w);
}
ElevatedButtonObjSt _createElevatedButtonObjSt(ElevatedButton? w) {
  final ElevatedButtonObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  return stObj;
}

void _setupOutlinedButton(WidgetFactories f) {
  f.outlinedButton.outlinedButton = ffi.Pointer.fromFunction(outlinedButtonOutlinedButton);
  f.outlinedButton.icon = ffi.Pointer.fromFunction(outlinedButtonIcon);
}
OutlinedButtonObjSt outlinedButtonOutlinedButton(VoidCallbackFFI onPressed, ffi.Pointer<VoidCallbackFFI> onLongPress, ffi.Pointer<ValueChangedForBoolFFI> onHover, ffi.Pointer<ValueChangedForBoolFFI> onFocusChange, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<ffi.Int> clipBehavior, DartDartObj child) {
  final w = OutlinedButton(onPressed: onPressed.toVoidCallbackFn(),
      onLongPress: onLongPress.toVoidCallbackFn(),
      onHover: onHover.toValueChangedForBoolFn(),
      onFocusChange: onFocusChange.toValueChangedForBoolFn(),
      autofocus: autofocus.boolOr(false),
      clipBehavior: clipBehavior.enumOrNul(Clip.values),
      child: _widgetsMap[child]! as Widget?);
  return _createOutlinedButtonObjSt(w);
}
OutlinedButtonObjSt outlinedButtonIcon(VoidCallbackFFI onPressed, ffi.Pointer<VoidCallbackFFI> onLongPress, ffi.Pointer<ValueChangedForBoolFFI> onHover, ffi.Pointer<ValueChangedForBoolFFI> onFocusChange, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<DartObj> icon, DartDartObj label, ffi.Pointer<ffi.Int> iconAlignment) {
  final w = OutlinedButton.icon(onPressed: onPressed.toVoidCallbackFn(),
      onLongPress: onLongPress.toVoidCallbackFn(),
      onHover: onHover.toValueChangedForBoolFn(),
      onFocusChange: onFocusChange.toValueChangedForBoolFn(),
      autofocus: autofocus.boolOrNul(),
      clipBehavior: clipBehavior.enumOrNul(Clip.values),
      icon: icon.objOrNul(),
      label: _widgetsMap[label]! as Widget,
      iconAlignment: iconAlignment.enumOrNul(IconAlignment.values));
  return _createOutlinedButtonObjSt(w);
}
OutlinedButtonObjSt _createOutlinedButtonObjSt(OutlinedButton? w) {
  final OutlinedButtonObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  return stObj;
}

void _setupTextButton(WidgetFactories f) {
  f.textButton.textButton = ffi.Pointer.fromFunction(textButtonTextButton);
  f.textButton.icon = ffi.Pointer.fromFunction(textButtonIcon);
}
TextButtonObjSt textButtonTextButton(VoidCallbackFFI onPressed, ffi.Pointer<VoidCallbackFFI> onLongPress, ffi.Pointer<ValueChangedForBoolFFI> onHover, ffi.Pointer<ValueChangedForBoolFFI> onFocusChange, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<ffi.Int> isSemanticButton, DartDartObj child) {
  final w = TextButton(onPressed: onPressed.toVoidCallbackFn(),
      onLongPress: onLongPress.toVoidCallbackFn(),
      onHover: onHover.toValueChangedForBoolFn(),
      onFocusChange: onFocusChange.toValueChangedForBoolFn(),
      autofocus: autofocus.boolOr(false),
      clipBehavior: clipBehavior.enumOrNul(Clip.values),
      isSemanticButton: isSemanticButton.boolOrNul(),
      child: _widgetsMap[child]! as Widget);
  return _createTextButtonObjSt(w);
}
TextButtonObjSt textButtonIcon(VoidCallbackFFI onPressed, ffi.Pointer<VoidCallbackFFI> onLongPress, ffi.Pointer<ValueChangedForBoolFFI> onHover, ffi.Pointer<ValueChangedForBoolFFI> onFocusChange, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<DartObj> icon, DartDartObj label, ffi.Pointer<ffi.Int> iconAlignment) {
  final w = TextButton.icon(onPressed: onPressed.toVoidCallbackFn(),
      onLongPress: onLongPress.toVoidCallbackFn(),
      onHover: onHover.toValueChangedForBoolFn(),
      onFocusChange: onFocusChange.toValueChangedForBoolFn(),
      autofocus: autofocus.boolOrNul(),
      clipBehavior: clipBehavior.enumOrNul(Clip.values),
      icon: icon.objOrNul(),
      label: _widgetsMap[label]! as Widget,
      iconAlignment: iconAlignment.enumOrNul(IconAlignment.values));
  return _createTextButtonObjSt(w);
}
TextButtonObjSt _createTextButtonObjSt(TextButton? w) {
  final TextButtonObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  return stObj;
}

void _setupNavigatorState(WidgetFactories f) {
  f.navigatorState.navigatorState = ffi.Pointer.fromFunction(navigatorStateNavigatorState, exception);
}
int navigatorStateNavigatorState() {
  final w = NavigatorState();
  return _addWidget(w);
}

void _setupNavigator(WidgetFactories f) {
  f.navigator.navigator = ffi.Pointer.fromFunction(navigatorNavigator);
  f.navigator.pushNamed = ffi.Pointer.fromFunction(navigatorPushNamed, exception);
  f.navigator.restorablePushNamed = ffi.Pointer.fromFunction(navigatorRestorablePushNamed);
  f.navigator.pushReplacementNamed = ffi.Pointer.fromFunction(navigatorPushReplacementNamed, exception);
  f.navigator.restorablePushReplacementNamed = ffi.Pointer.fromFunction(navigatorRestorablePushReplacementNamed);
  f.navigator.popAndPushNamed = ffi.Pointer.fromFunction(navigatorPopAndPushNamed, exception);
  f.navigator.restorablePopAndPushNamed = ffi.Pointer.fromFunction(navigatorRestorablePopAndPushNamed);
  f.navigator.canPop = ffi.Pointer.fromFunction(navigatorCanPop, exception);
  f.navigator.maybePop = ffi.Pointer.fromFunction(navigatorMaybePop, exception);
  f.navigator.pop = ffi.Pointer.fromFunction(navigatorPop);
  f.navigator.of = ffi.Pointer.fromFunction(navigatorOf, exception);
  f.navigator.maybeOf = ffi.Pointer.fromFunction(navigatorMaybeOf, exception);
}
NavigatorObjSt navigatorNavigator(ffi.Pointer<ffi.Char> initialRoute, ffi.Pointer<ffi.Int> reportsRouteUpdateToEngine, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<ffi.Int> requestFocus, ffi.Pointer<ffi.Char> restorationScopeId, ffi.Pointer<ffi.Int> routeTraversalEdgeBehavior, ffi.Pointer<ffi.Int> routeDirectionalTraversalEdgeBehavior) {
  final w = Navigator(initialRoute: initialRoute.strOrNul(),
      reportsRouteUpdateToEngine: reportsRouteUpdateToEngine.boolOr(false),
      clipBehavior: clipBehavior.enumOr(Clip.values, Clip.hardEdge),
      requestFocus: requestFocus.boolOr(true),
      restorationScopeId: restorationScopeId.strOrNul(),
      routeTraversalEdgeBehavior: routeTraversalEdgeBehavior.enumOr(TraversalEdgeBehavior.values, kDefaultRouteTraversalEdgeBehavior),
      routeDirectionalTraversalEdgeBehavior: routeDirectionalTraversalEdgeBehavior.enumOr(TraversalEdgeBehavior.values, kDefaultRouteDirectionalTraversalEdgeBehavior));
  return _createNavigatorObjSt(w);
}
int navigatorPushNamed(DartDartObj context, ffi.Pointer<ffi.Char> routeName, ffi.Pointer<DartObj> arguments) {
  final w = Navigator.pushNamed(_widgetsMap[context]! as BuildContext,
      routeName.cast<Utf8>().toDartString(),
      arguments: arguments.objOrNul());
  return _addWidget(w);
}
ffi.Pointer<ffi.Char> navigatorRestorablePushNamed(DartDartObj context, ffi.Pointer<ffi.Char> routeName, ffi.Pointer<DartObj> arguments) {
  final w = Navigator.restorablePushNamed(_widgetsMap[context]! as BuildContext,
      routeName.cast<Utf8>().toDartString(),
      arguments: arguments.objOrNul());
  return w.toNativeUtf8().cast<ffi.Char>();
}
int navigatorPushReplacementNamed(DartDartObj context, ffi.Pointer<ffi.Char> routeName, ffi.Pointer<DartObj> result, ffi.Pointer<DartObj> arguments) {
  final w = Navigator.pushReplacementNamed(_widgetsMap[context]! as BuildContext,
      routeName.cast<Utf8>().toDartString(),
      result: result,
      arguments: arguments.objOrNul());
  return _addWidget(w);
}
ffi.Pointer<ffi.Char> navigatorRestorablePushReplacementNamed(DartDartObj context, ffi.Pointer<ffi.Char> routeName, ffi.Pointer<DartObj> result, ffi.Pointer<DartObj> arguments) {
  final w = Navigator.restorablePushReplacementNamed(_widgetsMap[context]! as BuildContext,
      routeName.cast<Utf8>().toDartString(),
      result: result,
      arguments: arguments.objOrNul());
  return w.toNativeUtf8().cast<ffi.Char>();
}
int navigatorPopAndPushNamed(DartDartObj context, ffi.Pointer<ffi.Char> routeName, ffi.Pointer<DartObj> result, ffi.Pointer<DartObj> arguments) {
  final w = Navigator.popAndPushNamed(_widgetsMap[context]! as BuildContext,
      routeName.cast<Utf8>().toDartString(),
      result: result,
      arguments: arguments.objOrNul());
  return _addWidget(w);
}
ffi.Pointer<ffi.Char> navigatorRestorablePopAndPushNamed(DartDartObj context, ffi.Pointer<ffi.Char> routeName, ffi.Pointer<DartObj> result, ffi.Pointer<DartObj> arguments) {
  final w = Navigator.restorablePopAndPushNamed(_widgetsMap[context]! as BuildContext,
      routeName.cast<Utf8>().toDartString(),
      result: result,
      arguments: arguments.objOrNul());
  return w.toNativeUtf8().cast<ffi.Char>();
}
int navigatorCanPop(DartDartObj context) {
  final w = Navigator.canPop(_widgetsMap[context]! as BuildContext);
  return w.toInt();
}
int navigatorMaybePop(DartDartObj context, ffi.Pointer<DartObj> result) {
  final w = Navigator.maybePop(_widgetsMap[context]! as BuildContext,
      result);
  return _addWidget(w);
}
void navigatorPop(DartDartObj context, ffi.Pointer<DartObj> result) {
  Navigator.pop(_widgetsMap[context]! as BuildContext,
      result);
}
int navigatorOf(DartDartObj context, ffi.Pointer<ffi.Int> rootNavigator) {
  final w = Navigator.of(_widgetsMap[context]! as BuildContext,
      rootNavigator: rootNavigator.boolOr(false));
  return _addWidget(w);
}
int navigatorMaybeOf(DartDartObj context, ffi.Pointer<ffi.Int> rootNavigator) {
  final w = Navigator.maybeOf(_widgetsMap[context]! as BuildContext,
      rootNavigator: rootNavigator.boolOr(false));
  return _addWidget(w);
}
NavigatorObjSt _createNavigatorObjSt(Navigator? w) {
  final NavigatorObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.initialRoute = (w.initialRoute != null) ? w.initialRoute!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.restorationScopeId = (w.restorationScopeId != null) ? w.restorationScopeId!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.routeTraversalEdgeBehavior = w.routeTraversalEdgeBehavior.index;
  stObj.routeDirectionalTraversalEdgeBehavior = w.routeDirectionalTraversalEdgeBehavior.index;
  stObj.reportsRouteUpdateToEngine = w.reportsRouteUpdateToEngine.toInt();
  stObj.clipBehavior = w.clipBehavior.index;
  stObj.requestFocus = w.requestFocus.toInt();
  return stObj;
}

void _setupAlertDialog(WidgetFactories f) {
  f.alertDialog.alertDialog = ffi.Pointer.fromFunction(alertDialogAlertDialog);
  f.alertDialog.adaptive = ffi.Pointer.fromFunction(alertDialogAdaptive);
}
AlertDialogObjSt alertDialogAlertDialog(ffi.Pointer<DartObj> icon, ffi.Pointer<DartObj> iconPadding, ffi.Pointer<DartObj> iconColor, ffi.Pointer<DartObj> title, ffi.Pointer<DartObj> titlePadding, ffi.Pointer<DartObj> titleTextStyle, ffi.Pointer<DartObj> content, ffi.Pointer<DartObj> contentPadding, ffi.Pointer<DartObj> contentTextStyle, ffi.Pointer<ArrayC> actions, ffi.Pointer<DartObj> actionsPadding, ffi.Pointer<ffi.Int> actionsAlignment, ffi.Pointer<ffi.Int> actionsOverflowAlignment, ffi.Pointer<ffi.Int> actionsOverflowDirection, ffi.Pointer<ffi.Double> actionsOverflowButtonSpacing, ffi.Pointer<DartObj> buttonPadding, ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<ffi.Double> elevation, ffi.Pointer<DartObj> shadowColor, ffi.Pointer<DartObj> surfaceTintColor, ffi.Pointer<ffi.Char> semanticLabel, ffi.Pointer<DartObj> insetPadding, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<DartObj> shape, ffi.Pointer<DartObj> alignment, ffi.Pointer<DartObj> constraints, ffi.Pointer<ffi.Int> scrollable) {
  final w = AlertDialog(icon: icon.objOrNul(),
      iconPadding: iconPadding.objOrNul(),
      iconColor: iconColor.objOrNul(),
      title: title.objOrNul(),
      titlePadding: titlePadding.objOrNul(),
      titleTextStyle: titleTextStyle.objOrNul(),
      content: content.objOrNul(),
      contentPadding: contentPadding.objOrNul(),
      contentTextStyle: contentTextStyle.objOrNul(),
      actions: actions.listOrNul(),
      actionsPadding: actionsPadding.objOrNul(),
      actionsAlignment: actionsAlignment.enumOrNul(MainAxisAlignment.values),
      actionsOverflowAlignment: actionsOverflowAlignment.enumOrNul(OverflowBarAlignment.values),
      actionsOverflowDirection: actionsOverflowDirection.enumOrNul(VerticalDirection.values),
      actionsOverflowButtonSpacing: actionsOverflowButtonSpacing.doubleOrNul(),
      buttonPadding: buttonPadding.objOrNul(),
      backgroundColor: backgroundColor.objOrNul(),
      elevation: elevation.doubleOrNul(),
      shadowColor: shadowColor.objOrNul(),
      surfaceTintColor: surfaceTintColor.objOrNul(),
      semanticLabel: semanticLabel.strOrNul(),
      insetPadding: insetPadding.objOrNul(),
      clipBehavior: clipBehavior.enumOrNul(Clip.values),
      shape: shape.objOrNul(),
      alignment: alignment.objOrNul(),
      constraints: constraints.objOrNul(),
      scrollable: scrollable.boolOr(false));
  return _createAlertDialogObjSt(w);
}
AlertDialogObjSt alertDialogAdaptive(ffi.Pointer<DartObj> icon, ffi.Pointer<DartObj> iconPadding, ffi.Pointer<DartObj> iconColor, ffi.Pointer<DartObj> title, ffi.Pointer<DartObj> titlePadding, ffi.Pointer<DartObj> titleTextStyle, ffi.Pointer<DartObj> content, ffi.Pointer<DartObj> contentPadding, ffi.Pointer<DartObj> contentTextStyle, ffi.Pointer<ArrayC> actions, ffi.Pointer<DartObj> actionsPadding, ffi.Pointer<ffi.Int> actionsAlignment, ffi.Pointer<ffi.Int> actionsOverflowAlignment, ffi.Pointer<ffi.Int> actionsOverflowDirection, ffi.Pointer<ffi.Double> actionsOverflowButtonSpacing, ffi.Pointer<DartObj> buttonPadding, ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<ffi.Double> elevation, ffi.Pointer<DartObj> shadowColor, ffi.Pointer<DartObj> surfaceTintColor, ffi.Pointer<ffi.Char> semanticLabel, ffi.Pointer<DartObj> insetPadding, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<DartObj> shape, ffi.Pointer<DartObj> alignment, ffi.Pointer<DartObj> constraints, ffi.Pointer<ffi.Int> scrollable, ffi.Pointer<DartObj> insetAnimationDuration, ffi.Pointer<DartObj> insetAnimationCurve) {
  final w = AlertDialog.adaptive(icon: icon.objOrNul(),
      iconPadding: iconPadding.objOrNul(),
      iconColor: iconColor.objOrNul(),
      title: title.objOrNul(),
      titlePadding: titlePadding.objOrNul(),
      titleTextStyle: titleTextStyle.objOrNul(),
      content: content.objOrNul(),
      contentPadding: contentPadding.objOrNul(),
      contentTextStyle: contentTextStyle.objOrNul(),
      actions: actions.listOrNul(),
      actionsPadding: actionsPadding.objOrNul(),
      actionsAlignment: actionsAlignment.enumOrNul(MainAxisAlignment.values),
      actionsOverflowAlignment: actionsOverflowAlignment.enumOrNul(OverflowBarAlignment.values),
      actionsOverflowDirection: actionsOverflowDirection.enumOrNul(VerticalDirection.values),
      actionsOverflowButtonSpacing: actionsOverflowButtonSpacing.doubleOrNul(),
      buttonPadding: buttonPadding.objOrNul(),
      backgroundColor: backgroundColor.objOrNul(),
      elevation: elevation.doubleOrNul(),
      shadowColor: shadowColor.objOrNul(),
      surfaceTintColor: surfaceTintColor.objOrNul(),
      semanticLabel: semanticLabel.strOrNul(),
      insetPadding: insetPadding.objOr(null),
      clipBehavior: clipBehavior.enumOrNul(Clip.values),
      shape: shape.objOrNul(),
      alignment: alignment.objOrNul(),
      constraints: constraints.objOrNul(),
      scrollable: scrollable.boolOr(false),
      insetAnimationDuration: insetAnimationDuration.objOr(null),
      insetAnimationCurve: insetAnimationCurve.objOr(null));
  return _createAlertDialogObjSt(w);
}
AlertDialogObjSt _createAlertDialogObjSt(AlertDialog? w) {
  final AlertDialogObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.icon = _addWidget(w.icon);
  stObj.iconColor = _addWidget(w.iconColor);
  stObj.iconPadding = _addWidget(w.iconPadding);
  stObj.title = _addWidget(w.title);
  stObj.titlePadding = _addWidget(w.titlePadding);
  stObj.titleTextStyle = _createTextStyleObjSt(w.titleTextStyle);
  stObj.content = _addWidget(w.content);
  stObj.contentPadding = _addWidget(w.contentPadding);
  stObj.contentTextStyle = _createTextStyleObjSt(w.contentTextStyle);
  stObj.actionsPadding = _addWidget(w.actionsPadding);
  stObj.actionsAlignment = (w.actionsAlignment != null) ? w.actionsAlignment!.index : 0;
  stObj.actionsOverflowAlignment = (w.actionsOverflowAlignment != null) ? w.actionsOverflowAlignment!.index : 0;
  stObj.actionsOverflowDirection = (w.actionsOverflowDirection != null) ? w.actionsOverflowDirection!.index : 0;
  stObj.actionsOverflowButtonSpacing = (w.actionsOverflowButtonSpacing != null) ? w.actionsOverflowButtonSpacing! : 0;
  stObj.buttonPadding = _addWidget(w.buttonPadding);
  stObj.backgroundColor = _addWidget(w.backgroundColor);
  stObj.elevation = (w.elevation != null) ? w.elevation! : 0;
  stObj.shadowColor = _addWidget(w.shadowColor);
  stObj.surfaceTintColor = _addWidget(w.surfaceTintColor);
  stObj.semanticLabel = (w.semanticLabel != null) ? w.semanticLabel!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.insetPadding = _createEdgeInsetsObjSt(w.insetPadding);
  stObj.clipBehavior = (w.clipBehavior != null) ? w.clipBehavior!.index : 0;
  stObj.shape = _addWidget(w.shape);
  stObj.alignment = _addWidget(w.alignment);
  stObj.constraints = _createBoxConstraintsObjSt(w.constraints);
  stObj.scrollable = w.scrollable.toInt();
  return stObj;
}

void _setupInputDecoration(WidgetFactories f) {
  f.inputDecoration.inputDecoration = ffi.Pointer.fromFunction(inputDecorationInputDecoration);
  f.inputDecoration.collapsed = ffi.Pointer.fromFunction(inputDecorationCollapsed);
}
InputDecorationObjSt inputDecorationInputDecoration(ffi.Pointer<DartObj> icon, ffi.Pointer<DartObj> iconColor, ffi.Pointer<DartObj> label, ffi.Pointer<ffi.Char> labelText, ffi.Pointer<DartObj> labelStyle, ffi.Pointer<DartObj> floatingLabelStyle, ffi.Pointer<DartObj> helper, ffi.Pointer<ffi.Char> helperText, ffi.Pointer<DartObj> helperStyle, ffi.Pointer<ffi.Int> helperMaxLines, ffi.Pointer<ffi.Char> hintText, ffi.Pointer<DartObj> hint, ffi.Pointer<DartObj> hintStyle, ffi.Pointer<ffi.Int> hintTextDirection, ffi.Pointer<ffi.Int> hintMaxLines, ffi.Pointer<DartObj> hintFadeDuration, ffi.Pointer<ffi.Int> maintainHintHeight, ffi.Pointer<ffi.Int> maintainHintSize, ffi.Pointer<DartObj> error, ffi.Pointer<ffi.Char> errorText, ffi.Pointer<DartObj> errorStyle, ffi.Pointer<ffi.Int> errorMaxLines, ffi.Pointer<ffi.Int> floatingLabelBehavior, ffi.Pointer<ffi.Int> isCollapsed, ffi.Pointer<ffi.Int> isDense, ffi.Pointer<DartObj> contentPadding, ffi.Pointer<DartObj> prefixIcon, ffi.Pointer<DartObj> prefixIconConstraints, ffi.Pointer<DartObj> prefix, ffi.Pointer<ffi.Char> prefixText, ffi.Pointer<DartObj> prefixStyle, ffi.Pointer<DartObj> prefixIconColor, ffi.Pointer<DartObj> suffixIcon, ffi.Pointer<DartObj> suffix, ffi.Pointer<ffi.Char> suffixText, ffi.Pointer<DartObj> suffixStyle, ffi.Pointer<DartObj> suffixIconColor, ffi.Pointer<DartObj> suffixIconConstraints, ffi.Pointer<DartObj> counter, ffi.Pointer<ffi.Char> counterText, ffi.Pointer<DartObj> counterStyle, ffi.Pointer<ffi.Int> filled, ffi.Pointer<DartObj> fillColor, ffi.Pointer<DartObj> focusColor, ffi.Pointer<DartObj> hoverColor, ffi.Pointer<DartObj> errorBorder, ffi.Pointer<DartObj> focusedBorder, ffi.Pointer<DartObj> focusedErrorBorder, ffi.Pointer<DartObj> disabledBorder, ffi.Pointer<DartObj> enabledBorder, ffi.Pointer<DartObj> border, ffi.Pointer<ffi.Int> enabled, ffi.Pointer<ffi.Char> semanticCounterText, ffi.Pointer<ffi.Int> alignLabelWithHint, ffi.Pointer<DartObj> constraints, ffi.Pointer<DartObj> visualDensity) {
  final w = InputDecoration(icon: icon.objOrNul(),
      iconColor: iconColor.objOrNul(),
      label: label.objOrNul(),
      labelText: labelText.strOrNul(),
      labelStyle: labelStyle.objOrNul(),
      floatingLabelStyle: floatingLabelStyle.objOrNul(),
      helper: helper.objOrNul(),
      helperText: helperText.strOrNul(),
      helperStyle: helperStyle.objOrNul(),
      helperMaxLines: helperMaxLines.intOrNul(),
      hintText: hintText.strOrNul(),
      hint: hint.objOrNul(),
      hintStyle: hintStyle.objOrNul(),
      hintTextDirection: hintTextDirection.enumOrNul(TextDirection.values),
      hintMaxLines: hintMaxLines.intOrNul(),
      hintFadeDuration: hintFadeDuration.objOrNul(),
      maintainHintHeight: maintainHintHeight.boolOr(true),
      maintainHintSize: maintainHintSize.boolOr(true),
      error: error.objOrNul(),
      errorText: errorText.strOrNul(),
      errorStyle: errorStyle.objOrNul(),
      errorMaxLines: errorMaxLines.intOrNul(),
      floatingLabelBehavior: floatingLabelBehavior.enumOrNul(FloatingLabelBehavior.values),
      isCollapsed: isCollapsed.boolOrNul(),
      isDense: isDense.boolOrNul(),
      contentPadding: contentPadding.objOrNul(),
      prefixIcon: prefixIcon.objOrNul(),
      prefixIconConstraints: prefixIconConstraints.objOrNul(),
      prefix: prefix.objOrNul(),
      prefixText: prefixText.strOrNul(),
      prefixStyle: prefixStyle.objOrNul(),
      prefixIconColor: prefixIconColor.objOrNul(),
      suffixIcon: suffixIcon.objOrNul(),
      suffix: suffix.objOrNul(),
      suffixText: suffixText.strOrNul(),
      suffixStyle: suffixStyle.objOrNul(),
      suffixIconColor: suffixIconColor.objOrNul(),
      suffixIconConstraints: suffixIconConstraints.objOrNul(),
      counter: counter.objOrNul(),
      counterText: counterText.strOrNul(),
      counterStyle: counterStyle.objOrNul(),
      filled: filled.boolOrNul(),
      fillColor: fillColor.objOrNul(),
      focusColor: focusColor.objOrNul(),
      hoverColor: hoverColor.objOrNul(),
      errorBorder: errorBorder.objOrNul(),
      focusedBorder: focusedBorder.objOrNul(),
      focusedErrorBorder: focusedErrorBorder.objOrNul(),
      disabledBorder: disabledBorder.objOrNul(),
      enabledBorder: enabledBorder.objOrNul(),
      border: border.objOrNul(),
      enabled: enabled.boolOr(true),
      semanticCounterText: semanticCounterText.strOrNul(),
      alignLabelWithHint: alignLabelWithHint.boolOrNul(),
      constraints: constraints.objOrNul(),
      visualDensity: visualDensity.objOrNul());
  return _createInputDecorationObjSt(w);
}
InputDecorationObjSt inputDecorationCollapsed(ffi.Pointer<ffi.Char> hintText, ffi.Pointer<ffi.Int> floatingLabelBehavior, ffi.Pointer<DartObj> hintStyle, ffi.Pointer<DartObj> hint, ffi.Pointer<ffi.Int> hintTextDirection, ffi.Pointer<ffi.Int> hintMaxLines, ffi.Pointer<DartObj> hintFadeDuration, ffi.Pointer<ffi.Int> maintainHintHeight, ffi.Pointer<ffi.Int> maintainHintSize, ffi.Pointer<ffi.Int> filled, ffi.Pointer<DartObj> fillColor, ffi.Pointer<DartObj> focusColor, ffi.Pointer<DartObj> hoverColor, ffi.Pointer<DartObj> border, ffi.Pointer<ffi.Int> enabled, ffi.Pointer<DartObj> constraints) {
  final w = InputDecoration.collapsed(hintText: hintText.cast<Utf8>().toDartString(),
      floatingLabelBehavior: floatingLabelBehavior.enumOrNul(FloatingLabelBehavior.values),
      hintStyle: hintStyle.objOrNul(),
      hint: hint.objOrNul(),
      hintTextDirection: hintTextDirection.enumOrNul(TextDirection.values),
      hintMaxLines: hintMaxLines.intOrNul(),
      hintFadeDuration: hintFadeDuration.objOrNul(),
      maintainHintHeight: maintainHintHeight.boolOr(true),
      maintainHintSize: maintainHintSize.boolOr(true),
      filled: filled.boolOrNul(),
      fillColor: fillColor.objOrNul(),
      focusColor: focusColor.objOrNul(),
      hoverColor: hoverColor.objOrNul(),
      border: border.objOrNul(),
      enabled: enabled.boolOr(true),
      constraints: constraints.objOrNul());
  return _createInputDecorationObjSt(w);
}
InputDecorationObjSt _createInputDecorationObjSt(InputDecoration? w) {
  final InputDecorationObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.icon = _addWidget(w.icon);
  stObj.iconColor = _addWidget(w.iconColor);
  stObj.label = _addWidget(w.label);
  stObj.labelText = (w.labelText != null) ? w.labelText!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.labelStyle = _createTextStyleObjSt(w.labelStyle);
  stObj.floatingLabelStyle = _createTextStyleObjSt(w.floatingLabelStyle);
  stObj.helper = _addWidget(w.helper);
  stObj.helperText = (w.helperText != null) ? w.helperText!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.helperStyle = _createTextStyleObjSt(w.helperStyle);
  stObj.helperMaxLines = (w.helperMaxLines != null) ? w.helperMaxLines! : 0;
  stObj.hintText = (w.hintText != null) ? w.hintText!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.hint = _addWidget(w.hint);
  stObj.hintStyle = _createTextStyleObjSt(w.hintStyle);
  stObj.hintTextDirection = (w.hintTextDirection != null) ? w.hintTextDirection!.index : 0;
  stObj.hintMaxLines = (w.hintMaxLines != null) ? w.hintMaxLines! : 0;
  stObj.hintFadeDuration = _addWidget(w.hintFadeDuration);
  stObj.maintainHintHeight = w.maintainHintHeight.toInt();
  stObj.maintainHintSize = w.maintainHintSize.toInt();
  stObj.error = _addWidget(w.error);
  stObj.errorText = (w.errorText != null) ? w.errorText!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.errorStyle = _createTextStyleObjSt(w.errorStyle);
  stObj.errorMaxLines = (w.errorMaxLines != null) ? w.errorMaxLines! : 0;
  stObj.floatingLabelBehavior = (w.floatingLabelBehavior != null) ? w.floatingLabelBehavior!.index : 0;
  stObj.isDense = (w.isDense != null) ? w.isDense!.toInt() : 0;
  stObj.contentPadding = _addWidget(w.contentPadding);
  stObj.isCollapsed = (w.isCollapsed != null) ? w.isCollapsed!.toInt() : 0;
  stObj.prefixIcon = _addWidget(w.prefixIcon);
  stObj.prefixIconConstraints = _createBoxConstraintsObjSt(w.prefixIconConstraints);
  stObj.prefix = _addWidget(w.prefix);
  stObj.prefixText = (w.prefixText != null) ? w.prefixText!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.prefixStyle = _createTextStyleObjSt(w.prefixStyle);
  stObj.prefixIconColor = _addWidget(w.prefixIconColor);
  stObj.suffixIcon = _addWidget(w.suffixIcon);
  stObj.suffix = _addWidget(w.suffix);
  stObj.suffixText = (w.suffixText != null) ? w.suffixText!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.suffixStyle = _createTextStyleObjSt(w.suffixStyle);
  stObj.suffixIconColor = _addWidget(w.suffixIconColor);
  stObj.suffixIconConstraints = _createBoxConstraintsObjSt(w.suffixIconConstraints);
  stObj.counterText = (w.counterText != null) ? w.counterText!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.counter = _addWidget(w.counter);
  stObj.counterStyle = _createTextStyleObjSt(w.counterStyle);
  stObj.filled = (w.filled != null) ? w.filled!.toInt() : 0;
  stObj.fillColor = _addWidget(w.fillColor);
  stObj.focusColor = _addWidget(w.focusColor);
  stObj.hoverColor = _addWidget(w.hoverColor);
  stObj.errorBorder = _addWidget(w.errorBorder);
  stObj.focusedBorder = _addWidget(w.focusedBorder);
  stObj.focusedErrorBorder = _addWidget(w.focusedErrorBorder);
  stObj.disabledBorder = _addWidget(w.disabledBorder);
  stObj.enabledBorder = _addWidget(w.enabledBorder);
  stObj.border = _addWidget(w.border);
  stObj.enabled = w.enabled.toInt();
  stObj.semanticCounterText = (w.semanticCounterText != null) ? w.semanticCounterText!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.alignLabelWithHint = (w.alignLabelWithHint != null) ? w.alignLabelWithHint!.toInt() : 0;
  stObj.constraints = _createBoxConstraintsObjSt(w.constraints);
  stObj.visualDensity = _createVisualDensityObjSt(w.visualDensity);
  return stObj;
}

void _setupInputBorder(WidgetFactories f) {
  f.inputBorder.none = _addWidget(InputBorder.none);
}

void _setupTextField(WidgetFactories f) {
  f.textField.textField = ffi.Pointer.fromFunction(textFieldTextField);
}
TextFieldObjSt textFieldTextField(ffi.Pointer<DartObj> groupId, ffi.Pointer<DartObj> decoration, ffi.Pointer<ffi.Int> textInputAction, ffi.Pointer<ffi.Int> textCapitalization, ffi.Pointer<DartObj> style, ffi.Pointer<ffi.Int> textAlign, ffi.Pointer<ffi.Int> textDirection, ffi.Pointer<ffi.Int> readOnly, ffi.Pointer<ffi.Int> showCursor, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<ffi.Char> obscuringCharacter, ffi.Pointer<ffi.Int> obscureText, ffi.Pointer<ffi.Int> autocorrect, ffi.Pointer<ffi.Int> smartDashesType, ffi.Pointer<ffi.Int> smartQuotesType, ffi.Pointer<ffi.Int> enableSuggestions, ffi.Pointer<ffi.Int> maxLines, ffi.Pointer<ffi.Int> minLines, ffi.Pointer<ffi.Int> expands, ffi.Pointer<ffi.Int> maxLength, ffi.Pointer<ffi.Int> maxLengthEnforcement, ffi.Pointer<ValueChangedForStringFFI> onChanged, ffi.Pointer<VoidCallbackFFI> onEditingComplete, ffi.Pointer<ValueChangedForStringFFI> onSubmitted, ffi.Pointer<ffi.Int> enabled, ffi.Pointer<ffi.Int> ignorePointers, ffi.Pointer<ffi.Double> cursorWidth, ffi.Pointer<ffi.Double> cursorHeight, ffi.Pointer<DartObj> cursorRadius, ffi.Pointer<ffi.Int> cursorOpacityAnimates, ffi.Pointer<DartObj> cursorColor, ffi.Pointer<DartObj> cursorErrorColor, ffi.Pointer<ffi.Int> selectionHeightStyle, ffi.Pointer<ffi.Int> selectionWidthStyle, ffi.Pointer<ffi.Int> keyboardAppearance, ffi.Pointer<DartObj> scrollPadding, ffi.Pointer<ffi.Int> dragStartBehavior, ffi.Pointer<ffi.Int> enableInteractiveSelection, ffi.Pointer<ffi.Int> selectAllOnFocus, ffi.Pointer<GestureTapCallbackFFI> onTap, ffi.Pointer<ffi.Int> onTapAlwaysCalled, ffi.Pointer<TapRegionCallbackFFI> onTapOutside, ffi.Pointer<TapRegionUpCallbackFFI> onTapUpOutside, ffi.Pointer<InputCounterWidgetBuilderFFI> buildCounter, ffi.Pointer<ffi.Pointer<ffi.Pointer<ffi.Char>>> autofillHints, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<ffi.Char> restorationId, ffi.Pointer<ffi.Int> scribbleEnabled, ffi.Pointer<ffi.Int> stylusHandwritingEnabled, ffi.Pointer<ffi.Int> enableIMEPersonalizedLearning, ffi.Pointer<ffi.Int> canRequestFocus) {
  final w = TextField(groupId: groupId.objOr(EditableText),
      decoration: decoration.objOrNul(),
      textInputAction: textInputAction.enumOrNul(TextInputAction.values),
      textCapitalization: textCapitalization.enumOr(TextCapitalization.values, TextCapitalization.none),
      style: style.objOrNul(),
      textAlign: textAlign.enumOr(TextAlign.values, TextAlign.start),
      textDirection: textDirection.enumOrNul(TextDirection.values),
      readOnly: readOnly.boolOr(false),
      showCursor: showCursor.boolOrNul(),
      autofocus: autofocus.boolOr(false),
      obscuringCharacter: obscuringCharacter.strOr('•'),
      obscureText: obscureText.boolOr(false),
      autocorrect: autocorrect.boolOrNul(),
      smartDashesType: smartDashesType.enumOrNul(SmartDashesType.values),
      smartQuotesType: smartQuotesType.enumOrNul(SmartQuotesType.values),
      enableSuggestions: enableSuggestions.boolOr(true),
      maxLines: maxLines.intOrNul(),
      minLines: minLines.intOrNul(),
      expands: expands.boolOr(false),
      maxLength: maxLength.intOrNul(),
      maxLengthEnforcement: maxLengthEnforcement.enumOrNul(MaxLengthEnforcement.values),
      onChanged: onChanged.toValueChangedForStringFn(),
      onEditingComplete: onEditingComplete.toVoidCallbackFn(),
      onSubmitted: onSubmitted.toValueChangedForStringFn(),
      enabled: enabled.boolOrNul(),
      ignorePointers: ignorePointers.boolOrNul(),
      cursorWidth: cursorWidth.doubleOr(2.0),
      cursorHeight: cursorHeight.doubleOrNul(),
      cursorRadius: cursorRadius.objOrNul(),
      cursorOpacityAnimates: cursorOpacityAnimates.boolOrNul(),
      cursorColor: cursorColor.objOrNul(),
      cursorErrorColor: cursorErrorColor.objOrNul(),
      selectionHeightStyle: selectionHeightStyle.enumOrNul(BoxHeightStyle.values),
      selectionWidthStyle: selectionWidthStyle.enumOrNul(BoxWidthStyle.values),
      keyboardAppearance: keyboardAppearance.enumOrNul(Brightness.values),
      scrollPadding: scrollPadding.objOr(const EdgeInsets.all(20.0)),
      dragStartBehavior: dragStartBehavior.enumOr(DragStartBehavior.values, DragStartBehavior.start),
      enableInteractiveSelection: enableInteractiveSelection.boolOrNul(),
      selectAllOnFocus: selectAllOnFocus.boolOrNul(),
      onTap: onTap.toGestureTapCallbackFn(),
      onTapAlwaysCalled: onTapAlwaysCalled.boolOr(false),
      onTapOutside: onTapOutside.toTapRegionCallbackFn(),
      onTapUpOutside: onTapUpOutside.toTapRegionUpCallbackFn(),
      buildCounter: buildCounter.toInputCounterWidgetBuilderFn(),
      autofillHints: autofillHints.listOrNul(),
      clipBehavior: clipBehavior.enumOr(Clip.values, Clip.hardEdge),
      restorationId: restorationId.strOrNul(),
      scribbleEnabled: scribbleEnabled.boolOr(true),
      stylusHandwritingEnabled: stylusHandwritingEnabled.boolOr(EditableText.defaultStylusHandwritingEnabled),
      enableIMEPersonalizedLearning: enableIMEPersonalizedLearning.boolOr(true),
      canRequestFocus: canRequestFocus.boolOr(true));
  return _createTextFieldObjSt(w);
}
TextFieldObjSt _createTextFieldObjSt(TextField? w) {
  final TextFieldObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.decoration = _createInputDecorationObjSt(w.decoration);
  stObj.textInputAction = (w.textInputAction != null) ? w.textInputAction!.index : 0;
  stObj.textCapitalization = w.textCapitalization.index;
  stObj.style = _createTextStyleObjSt(w.style);
  stObj.textAlign = w.textAlign.index;
  stObj.textDirection = (w.textDirection != null) ? w.textDirection!.index : 0;
  stObj.autofocus = w.autofocus.toInt();
  stObj.obscuringCharacter = w.obscuringCharacter.toNativeUtf8().cast<ffi.Char>();
  stObj.obscureText = w.obscureText.toInt();
  stObj.autocorrect = (w.autocorrect != null) ? w.autocorrect!.toInt() : 0;
  stObj.smartDashesType = w.smartDashesType.index;
  stObj.smartQuotesType = w.smartQuotesType.index;
  stObj.enableSuggestions = w.enableSuggestions.toInt();
  stObj.maxLines = (w.maxLines != null) ? w.maxLines! : 0;
  stObj.minLines = (w.minLines != null) ? w.minLines! : 0;
  stObj.expands = w.expands.toInt();
  stObj.readOnly = w.readOnly.toInt();
  stObj.showCursor = (w.showCursor != null) ? w.showCursor!.toInt() : 0;
  stObj.maxLength = (w.maxLength != null) ? w.maxLength! : 0;
  stObj.maxLengthEnforcement = (w.maxLengthEnforcement != null) ? w.maxLengthEnforcement!.index : 0;
  stObj.enabled = (w.enabled != null) ? w.enabled!.toInt() : 0;
  stObj.ignorePointers = (w.ignorePointers != null) ? w.ignorePointers!.toInt() : 0;
  stObj.cursorWidth = w.cursorWidth;
  stObj.cursorHeight = (w.cursorHeight != null) ? w.cursorHeight! : 0;
  stObj.cursorRadius = _addWidget(w.cursorRadius);
  stObj.cursorOpacityAnimates = (w.cursorOpacityAnimates != null) ? w.cursorOpacityAnimates!.toInt() : 0;
  stObj.cursorColor = _addWidget(w.cursorColor);
  stObj.cursorErrorColor = _addWidget(w.cursorErrorColor);
  stObj.selectionHeightStyle = (w.selectionHeightStyle != null) ? w.selectionHeightStyle!.index : 0;
  stObj.selectionWidthStyle = (w.selectionWidthStyle != null) ? w.selectionWidthStyle!.index : 0;
  stObj.keyboardAppearance = (w.keyboardAppearance != null) ? w.keyboardAppearance!.index : 0;
  stObj.scrollPadding = _createEdgeInsetsObjSt(w.scrollPadding);
  stObj.enableInteractiveSelection = w.enableInteractiveSelection.toInt();
  stObj.selectAllOnFocus = (w.selectAllOnFocus != null) ? w.selectAllOnFocus!.toInt() : 0;
  stObj.dragStartBehavior = w.dragStartBehavior.index;
  stObj.onTapAlwaysCalled = w.onTapAlwaysCalled.toInt();
  stObj.clipBehavior = w.clipBehavior.index;
  stObj.restorationId = (w.restorationId != null) ? w.restorationId!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.scribbleEnabled = w.scribbleEnabled.toInt();
  stObj.stylusHandwritingEnabled = w.stylusHandwritingEnabled.toInt();
  stObj.enableIMEPersonalizedLearning = w.enableIMEPersonalizedLearning.toInt();
  stObj.canRequestFocus = w.canRequestFocus.toInt();
  stObj.selectionEnabled = w.selectionEnabled.toInt();
  return stObj;
}

void _setupDivider(WidgetFactories f) {
  f.divider.divider = ffi.Pointer.fromFunction(dividerDivider);
  f.divider.createBorderSide = ffi.Pointer.fromFunction(dividerCreateBorderSide);
}
DividerObjSt dividerDivider(ffi.Pointer<ffi.Double> height, ffi.Pointer<ffi.Double> thickness, ffi.Pointer<ffi.Double> indent, ffi.Pointer<ffi.Double> endIndent, ffi.Pointer<DartObj> color, ffi.Pointer<DartObj> radius) {
  final w = Divider(height: height.doubleOrNul(),
      thickness: thickness.doubleOrNul(),
      indent: indent.doubleOrNul(),
      endIndent: endIndent.doubleOrNul(),
      color: color.objOrNul(),
      radius: radius.objOrNul());
  return _createDividerObjSt(w);
}
BorderSideObjSt dividerCreateBorderSide(DartDartObj context, ffi.Pointer<DartObj> color, ffi.Pointer<ffi.Double> width) {
  final w = Divider.createBorderSide(_widgetsMap[context]! as BuildContext?,
      color: color.objOrNul(),
      width: width.doubleOrNul());
  return _createBorderSideObjSt(w);
}
DividerObjSt _createDividerObjSt(Divider? w) {
  final DividerObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.height = (w.height != null) ? w.height! : 0;
  stObj.thickness = (w.thickness != null) ? w.thickness! : 0;
  stObj.indent = (w.indent != null) ? w.indent! : 0;
  stObj.endIndent = (w.endIndent != null) ? w.endIndent! : 0;
  stObj.radius = _addWidget(w.radius);
  stObj.color = _addWidget(w.color);
  return stObj;
}

void _setupFilledButton(WidgetFactories f) {
  f.filledButton.filledButton = ffi.Pointer.fromFunction(filledButtonFilledButton);
  f.filledButton.icon = ffi.Pointer.fromFunction(filledButtonIcon);
  f.filledButton.tonal = ffi.Pointer.fromFunction(filledButtonTonal);
  f.filledButton.tonalIcon = ffi.Pointer.fromFunction(filledButtonTonalIcon);
}
FilledButtonObjSt filledButtonFilledButton(VoidCallbackFFI onPressed, ffi.Pointer<VoidCallbackFFI> onLongPress, ffi.Pointer<ValueChangedForBoolFFI> onHover, ffi.Pointer<ValueChangedForBoolFFI> onFocusChange, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<ffi.Int> clipBehavior, DartDartObj child) {
  final w = FilledButton(onPressed: onPressed.toVoidCallbackFn(),
      onLongPress: onLongPress.toVoidCallbackFn(),
      onHover: onHover.toValueChangedForBoolFn(),
      onFocusChange: onFocusChange.toValueChangedForBoolFn(),
      autofocus: autofocus.boolOr(false),
      clipBehavior: clipBehavior.enumOrNul(Clip.values),
      child: _widgetsMap[child]! as Widget?);
  return _createFilledButtonObjSt(w);
}
FilledButtonObjSt filledButtonIcon(VoidCallbackFFI onPressed, ffi.Pointer<VoidCallbackFFI> onLongPress, ffi.Pointer<ValueChangedForBoolFFI> onHover, ffi.Pointer<ValueChangedForBoolFFI> onFocusChange, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<DartObj> icon, DartDartObj label, ffi.Pointer<ffi.Int> iconAlignment) {
  final w = FilledButton.icon(onPressed: onPressed.toVoidCallbackFn(),
      onLongPress: onLongPress.toVoidCallbackFn(),
      onHover: onHover.toValueChangedForBoolFn(),
      onFocusChange: onFocusChange.toValueChangedForBoolFn(),
      autofocus: autofocus.boolOrNul(),
      clipBehavior: clipBehavior.enumOrNul(Clip.values),
      icon: icon.objOrNul(),
      label: _widgetsMap[label]! as Widget,
      iconAlignment: iconAlignment.enumOrNul(IconAlignment.values));
  return _createFilledButtonObjSt(w);
}
FilledButtonObjSt filledButtonTonal(VoidCallbackFFI onPressed, ffi.Pointer<VoidCallbackFFI> onLongPress, ffi.Pointer<ValueChangedForBoolFFI> onHover, ffi.Pointer<ValueChangedForBoolFFI> onFocusChange, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<ffi.Int> clipBehavior, DartDartObj child) {
  final w = FilledButton.tonal(onPressed: onPressed.toVoidCallbackFn(),
      onLongPress: onLongPress.toVoidCallbackFn(),
      onHover: onHover.toValueChangedForBoolFn(),
      onFocusChange: onFocusChange.toValueChangedForBoolFn(),
      autofocus: autofocus.boolOr(false),
      clipBehavior: clipBehavior.enumOrNul(Clip.values),
      child: _widgetsMap[child]! as Widget?);
  return _createFilledButtonObjSt(w);
}
FilledButtonObjSt filledButtonTonalIcon(VoidCallbackFFI onPressed, ffi.Pointer<VoidCallbackFFI> onLongPress, ffi.Pointer<ValueChangedForBoolFFI> onHover, ffi.Pointer<ValueChangedForBoolFFI> onFocusChange, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<DartObj> icon, DartDartObj label, ffi.Pointer<ffi.Int> iconAlignment) {
  final w = FilledButton.tonalIcon(onPressed: onPressed.toVoidCallbackFn(),
      onLongPress: onLongPress.toVoidCallbackFn(),
      onHover: onHover.toValueChangedForBoolFn(),
      onFocusChange: onFocusChange.toValueChangedForBoolFn(),
      autofocus: autofocus.boolOrNul(),
      clipBehavior: clipBehavior.enumOrNul(Clip.values),
      icon: icon.objOrNul(),
      label: _widgetsMap[label]! as Widget,
      iconAlignment: iconAlignment.enumOrNul(IconAlignment.values));
  return _createFilledButtonObjSt(w);
}
FilledButtonObjSt _createFilledButtonObjSt(FilledButton? w) {
  final FilledButtonObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  return stObj;
}

void _setupOutlineInputBorder(WidgetFactories f) {
  f.outlineInputBorder.outlineInputBorder = ffi.Pointer.fromFunction(outlineInputBorderOutlineInputBorder);
}
OutlineInputBorderObjSt outlineInputBorderOutlineInputBorder(ffi.Pointer<DartObj> borderSide, ffi.Pointer<DartObj> borderRadius, ffi.Pointer<ffi.Double> gapPadding) {
  final w = OutlineInputBorder(borderSide: borderSide.objOr(const BorderSide()),
      borderRadius: borderRadius.objOr(const BorderRadius.all(Radius.circular(4.0))),
      gapPadding: gapPadding.doubleOr(4.0));
  return _createOutlineInputBorderObjSt(w);
}
OutlineInputBorderObjSt _createOutlineInputBorderObjSt(OutlineInputBorder? w) {
  final OutlineInputBorderObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.gapPadding = w.gapPadding;
  stObj.borderRadius = _createBorderRadiusObjSt(w.borderRadius);
  return stObj;
}

void _setupSnackBarAction(WidgetFactories f) {
  f.snackBarAction.snackBarAction = ffi.Pointer.fromFunction(snackBarActionSnackBarAction);
}
SnackBarActionObjSt snackBarActionSnackBarAction(ffi.Pointer<DartObj> textColor, ffi.Pointer<DartObj> disabledTextColor, ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<DartObj> disabledBackgroundColor, ffi.Pointer<ffi.Char> label, VoidCallbackFFI onPressed) {
  final w = SnackBarAction(textColor: textColor.objOrNul(),
      disabledTextColor: disabledTextColor.objOrNul(),
      backgroundColor: backgroundColor.objOrNul(),
      disabledBackgroundColor: disabledBackgroundColor.objOrNul(),
      label: label.cast<Utf8>().toDartString(),
      onPressed: onPressed.toVoidCallbackFn());
  return _createSnackBarActionObjSt(w);
}
SnackBarActionObjSt _createSnackBarActionObjSt(SnackBarAction? w) {
  final SnackBarActionObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.textColor = _addWidget(w.textColor);
  stObj.backgroundColor = _addWidget(w.backgroundColor);
  stObj.disabledTextColor = _addWidget(w.disabledTextColor);
  stObj.disabledBackgroundColor = _addWidget(w.disabledBackgroundColor);
  stObj.label = w.label.toNativeUtf8().cast<ffi.Char>();
  return stObj;
}

void _setupSnackBar(WidgetFactories f) {
  f.snackBar.snackBar = ffi.Pointer.fromFunction(snackBarSnackBar);
  f.snackBar.createAnimationController = ffi.Pointer.fromFunction(snackBarCreateAnimationController, exception);
}
SnackBarObjSt snackBarSnackBar(DartDartObj content, ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<ffi.Double> elevation, ffi.Pointer<DartObj> margin, ffi.Pointer<DartObj> padding, ffi.Pointer<ffi.Double> width, ffi.Pointer<DartObj> shape, ffi.Pointer<ffi.Int> hitTestBehavior, ffi.Pointer<ffi.Int> behavior, ffi.Pointer<DartObj> action, ffi.Pointer<ffi.Double> actionOverflowThreshold, ffi.Pointer<ffi.Int> showCloseIcon, ffi.Pointer<DartObj> closeIconColor, ffi.Pointer<DartObj> duration, ffi.Pointer<DartObj> animation, ffi.Pointer<VoidCallbackFFI> onVisible, ffi.Pointer<ffi.Int> dismissDirection, ffi.Pointer<ffi.Int> clipBehavior) {
  final w = SnackBar(content: _widgetsMap[content]! as Widget,
      backgroundColor: backgroundColor.objOrNul(),
      elevation: elevation.doubleOrNul(),
      margin: margin.objOrNul(),
      padding: padding.objOrNul(),
      width: width.doubleOrNul(),
      shape: shape.objOrNul(),
      hitTestBehavior: hitTestBehavior.enumOrNul(HitTestBehavior.values),
      behavior: behavior.enumOrNul(SnackBarBehavior.values),
      action: action.objOrNul(),
      actionOverflowThreshold: actionOverflowThreshold.doubleOrNul(),
      showCloseIcon: showCloseIcon.boolOrNul(),
      closeIconColor: closeIconColor.objOrNul(),
      duration: duration.objOr(Duration(milliseconds: 4000)),
      animation: animation.objOrNul(),
      onVisible: onVisible.toVoidCallbackFn(),
      dismissDirection: dismissDirection.enumOrNul(DismissDirection.values),
      clipBehavior: clipBehavior.enumOr(Clip.values, Clip.hardEdge));
  return _createSnackBarObjSt(w);
}
int snackBarCreateAnimationController(DartDartObj vsync, ffi.Pointer<DartObj> duration, ffi.Pointer<DartObj> reverseDuration) {
  final w = SnackBar.createAnimationController(vsync: _widgetsMap[vsync]! as TickerProvider,
      duration: duration.objOrNul(),
      reverseDuration: reverseDuration.objOrNul());
  return _addWidget(w);
}
SnackBarObjSt _createSnackBarObjSt(SnackBar? w) {
  final SnackBarObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.content = _addWidget(w.content);
  stObj.backgroundColor = _addWidget(w.backgroundColor);
  stObj.elevation = (w.elevation != null) ? w.elevation! : 0;
  stObj.margin = _addWidget(w.margin);
  stObj.padding = _addWidget(w.padding);
  stObj.width = (w.width != null) ? w.width! : 0;
  stObj.shape = _addWidget(w.shape);
  stObj.hitTestBehavior = (w.hitTestBehavior != null) ? w.hitTestBehavior!.index : 0;
  stObj.behavior = (w.behavior != null) ? w.behavior!.index : 0;
  stObj.action = _createSnackBarActionObjSt(w.action);
  stObj.actionOverflowThreshold = (w.actionOverflowThreshold != null) ? w.actionOverflowThreshold! : 0;
  stObj.showCloseIcon = (w.showCloseIcon != null) ? w.showCloseIcon!.toInt() : 0;
  stObj.closeIconColor = _addWidget(w.closeIconColor);
  stObj.duration = _addWidget(w.duration);
  stObj.animation = _addWidget(w.animation);
  stObj.dismissDirection = (w.dismissDirection != null) ? w.dismissDirection!.index : 0;
  stObj.clipBehavior = w.clipBehavior.index;
  return stObj;
}

void _setupScaffoldMessenger(WidgetFactories f) {
  f.scaffoldMessenger.scaffoldMessenger = ffi.Pointer.fromFunction(scaffoldMessengerScaffoldMessenger);
}
ScaffoldMessengerObjSt scaffoldMessengerScaffoldMessenger(DartDartObj child) {
  final w = ScaffoldMessenger(child: _widgetsMap[child]! as Widget);
  return _createScaffoldMessengerObjSt(w);
}
ScaffoldMessengerObjSt _createScaffoldMessengerObjSt(ScaffoldMessenger? w) {
  final ScaffoldMessengerObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.child = _addWidget(w.child);
  return stObj;
}

void _setupCard(WidgetFactories f) {
  f.card.card = ffi.Pointer.fromFunction(cardCard);
  f.card.filled = ffi.Pointer.fromFunction(cardFilled);
  f.card.outlined = ffi.Pointer.fromFunction(cardOutlined);
}
CardObjSt cardCard(ffi.Pointer<DartObj> color, ffi.Pointer<DartObj> shadowColor, ffi.Pointer<DartObj> surfaceTintColor, ffi.Pointer<ffi.Double> elevation, ffi.Pointer<DartObj> shape, ffi.Pointer<ffi.Int> borderOnForeground, ffi.Pointer<DartObj> margin, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<DartObj> child, ffi.Pointer<ffi.Int> semanticContainer) {
  final w = Card(color: color.objOrNul(),
      shadowColor: shadowColor.objOrNul(),
      surfaceTintColor: surfaceTintColor.objOrNul(),
      elevation: elevation.doubleOrNul(),
      shape: shape.objOrNul(),
      borderOnForeground: borderOnForeground.boolOr(true),
      margin: margin.objOrNul(),
      clipBehavior: clipBehavior.enumOrNul(Clip.values),
      child: child.objOrNul(),
      semanticContainer: semanticContainer.boolOr(true));
  return _createCardObjSt(w);
}
CardObjSt cardFilled(ffi.Pointer<DartObj> color, ffi.Pointer<DartObj> shadowColor, ffi.Pointer<DartObj> surfaceTintColor, ffi.Pointer<ffi.Double> elevation, ffi.Pointer<DartObj> shape, ffi.Pointer<ffi.Int> borderOnForeground, ffi.Pointer<DartObj> margin, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<DartObj> child, ffi.Pointer<ffi.Int> semanticContainer) {
  final w = Card.filled(color: color.objOrNul(),
      shadowColor: shadowColor.objOrNul(),
      surfaceTintColor: surfaceTintColor.objOrNul(),
      elevation: elevation.doubleOrNul(),
      shape: shape.objOrNul(),
      borderOnForeground: borderOnForeground.boolOr(true),
      margin: margin.objOrNul(),
      clipBehavior: clipBehavior.enumOrNul(Clip.values),
      child: child.objOrNul(),
      semanticContainer: semanticContainer.boolOr(true));
  return _createCardObjSt(w);
}
CardObjSt cardOutlined(ffi.Pointer<DartObj> color, ffi.Pointer<DartObj> shadowColor, ffi.Pointer<DartObj> surfaceTintColor, ffi.Pointer<ffi.Double> elevation, ffi.Pointer<DartObj> shape, ffi.Pointer<ffi.Int> borderOnForeground, ffi.Pointer<DartObj> margin, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<DartObj> child, ffi.Pointer<ffi.Int> semanticContainer) {
  final w = Card.outlined(color: color.objOrNul(),
      shadowColor: shadowColor.objOrNul(),
      surfaceTintColor: surfaceTintColor.objOrNul(),
      elevation: elevation.doubleOrNul(),
      shape: shape.objOrNul(),
      borderOnForeground: borderOnForeground.boolOr(true),
      margin: margin.objOrNul(),
      clipBehavior: clipBehavior.enumOrNul(Clip.values),
      child: child.objOrNul(),
      semanticContainer: semanticContainer.boolOr(true));
  return _createCardObjSt(w);
}
CardObjSt _createCardObjSt(Card? w) {
  final CardObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.color = _addWidget(w.color);
  stObj.shadowColor = _addWidget(w.shadowColor);
  stObj.surfaceTintColor = _addWidget(w.surfaceTintColor);
  stObj.elevation = (w.elevation != null) ? w.elevation! : 0;
  stObj.shape = _addWidget(w.shape);
  stObj.borderOnForeground = w.borderOnForeground.toInt();
  stObj.clipBehavior = (w.clipBehavior != null) ? w.clipBehavior!.index : 0;
  stObj.margin = _addWidget(w.margin);
  stObj.semanticContainer = w.semanticContainer.toInt();
  stObj.child = _addWidget(w.child);
  return stObj;
}

void _setupChip(WidgetFactories f) {
  f.chip.chip = ffi.Pointer.fromFunction(chipChip);
}
ChipObjSt chipChip(ffi.Pointer<DartObj> avatar, DartDartObj label, ffi.Pointer<DartObj> labelStyle, ffi.Pointer<DartObj> labelPadding, ffi.Pointer<DartObj> deleteIcon, ffi.Pointer<VoidCallbackFFI> onDeleted, ffi.Pointer<DartObj> deleteIconColor, ffi.Pointer<ffi.Char> deleteButtonTooltipMessage, ffi.Pointer<DartObj> side, ffi.Pointer<DartObj> shape, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<DartObj> color, ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<DartObj> padding, ffi.Pointer<DartObj> visualDensity, ffi.Pointer<ffi.Int> materialTapTargetSize, ffi.Pointer<ffi.Double> elevation, ffi.Pointer<DartObj> shadowColor, ffi.Pointer<DartObj> surfaceTintColor, ffi.Pointer<DartObj> avatarBoxConstraints, ffi.Pointer<DartObj> deleteIconBoxConstraints) {
  final w = Chip(avatar: avatar.objOrNul(),
      label: _widgetsMap[label]! as Widget,
      labelStyle: labelStyle.objOrNul(),
      labelPadding: labelPadding.objOrNul(),
      deleteIcon: deleteIcon.objOrNul(),
      onDeleted: onDeleted.toVoidCallbackFn(),
      deleteIconColor: deleteIconColor.objOrNul(),
      deleteButtonTooltipMessage: deleteButtonTooltipMessage.strOrNul(),
      side: side.objOrNul(),
      shape: shape.objOrNul(),
      clipBehavior: clipBehavior.enumOr(Clip.values, Clip.none),
      autofocus: autofocus.boolOr(false),
      color: _wspNul<Color?>(color.objOrNul()),
      backgroundColor: backgroundColor.objOrNul(),
      padding: padding.objOrNul(),
      visualDensity: visualDensity.objOrNul(),
      materialTapTargetSize: materialTapTargetSize.enumOrNul(MaterialTapTargetSize.values),
      elevation: elevation.doubleOrNul(),
      shadowColor: shadowColor.objOrNul(),
      surfaceTintColor: surfaceTintColor.objOrNul(),
      avatarBoxConstraints: avatarBoxConstraints.objOrNul(),
      deleteIconBoxConstraints: deleteIconBoxConstraints.objOrNul());
  return _createChipObjSt(w);
}
ChipObjSt _createChipObjSt(Chip? w) {
  final ChipObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.avatar = _addWidget(w.avatar);
  stObj.label = _addWidget(w.label);
  stObj.labelStyle = _createTextStyleObjSt(w.labelStyle);
  stObj.labelPadding = _addWidget(w.labelPadding);
  stObj.side = _createBorderSideObjSt(w.side);
  stObj.shape = _addWidget(w.shape);
  stObj.clipBehavior = w.clipBehavior.index;
  stObj.autofocus = w.autofocus.toInt();
  stObj.backgroundColor = _addWidget(w.backgroundColor);
  stObj.padding = _addWidget(w.padding);
  stObj.visualDensity = _createVisualDensityObjSt(w.visualDensity);
  stObj.deleteIcon = _addWidget(w.deleteIcon);
  stObj.deleteIconColor = _addWidget(w.deleteIconColor);
  stObj.deleteButtonTooltipMessage = (w.deleteButtonTooltipMessage != null) ? w.deleteButtonTooltipMessage!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.materialTapTargetSize = (w.materialTapTargetSize != null) ? w.materialTapTargetSize!.index : 0;
  stObj.elevation = (w.elevation != null) ? w.elevation! : 0;
  stObj.shadowColor = _addWidget(w.shadowColor);
  stObj.surfaceTintColor = _addWidget(w.surfaceTintColor);
  stObj.avatarBoxConstraints = _createBoxConstraintsObjSt(w.avatarBoxConstraints);
  stObj.deleteIconBoxConstraints = _createBoxConstraintsObjSt(w.deleteIconBoxConstraints);
  return stObj;
}

void _setupGestureDetector(WidgetFactories f) {
  f.gestureDetector.gestureDetector = ffi.Pointer.fromFunction(gestureDetectorGestureDetector);
}
GestureDetectorObjSt gestureDetectorGestureDetector(ffi.Pointer<DartObj> child, ffi.Pointer<GestureTapDownCallbackFFI> onTapDown, ffi.Pointer<GestureTapUpCallbackFFI> onTapUp, ffi.Pointer<GestureTapCallbackFFI> onTap, ffi.Pointer<GestureTapMoveCallbackFFI> onTapMove, ffi.Pointer<GestureTapCancelCallbackFFI> onTapCancel, ffi.Pointer<GestureTapCallbackFFI> onSecondaryTap, ffi.Pointer<GestureTapDownCallbackFFI> onSecondaryTapDown, ffi.Pointer<GestureTapUpCallbackFFI> onSecondaryTapUp, ffi.Pointer<GestureTapCancelCallbackFFI> onSecondaryTapCancel, ffi.Pointer<GestureTapDownCallbackFFI> onTertiaryTapDown, ffi.Pointer<GestureTapUpCallbackFFI> onTertiaryTapUp, ffi.Pointer<GestureTapCancelCallbackFFI> onTertiaryTapCancel, ffi.Pointer<GestureTapDownCallbackFFI> onDoubleTapDown, ffi.Pointer<GestureTapCallbackFFI> onDoubleTap, ffi.Pointer<GestureTapCancelCallbackFFI> onDoubleTapCancel, ffi.Pointer<GestureLongPressDownCallbackFFI> onLongPressDown, ffi.Pointer<GestureLongPressCancelCallbackFFI> onLongPressCancel, ffi.Pointer<GestureLongPressCallbackFFI> onLongPress, ffi.Pointer<GestureLongPressStartCallbackFFI> onLongPressStart, ffi.Pointer<GestureLongPressMoveUpdateCallbackFFI> onLongPressMoveUpdate, ffi.Pointer<GestureLongPressUpCallbackFFI> onLongPressUp, ffi.Pointer<GestureLongPressEndCallbackFFI> onLongPressEnd, ffi.Pointer<GestureLongPressDownCallbackFFI> onSecondaryLongPressDown, ffi.Pointer<GestureLongPressCancelCallbackFFI> onSecondaryLongPressCancel, ffi.Pointer<GestureLongPressCallbackFFI> onSecondaryLongPress, ffi.Pointer<GestureLongPressStartCallbackFFI> onSecondaryLongPressStart, ffi.Pointer<GestureLongPressMoveUpdateCallbackFFI> onSecondaryLongPressMoveUpdate, ffi.Pointer<GestureLongPressUpCallbackFFI> onSecondaryLongPressUp, ffi.Pointer<GestureLongPressEndCallbackFFI> onSecondaryLongPressEnd, ffi.Pointer<GestureLongPressDownCallbackFFI> onTertiaryLongPressDown, ffi.Pointer<GestureLongPressCancelCallbackFFI> onTertiaryLongPressCancel, ffi.Pointer<GestureLongPressCallbackFFI> onTertiaryLongPress, ffi.Pointer<GestureLongPressStartCallbackFFI> onTertiaryLongPressStart, ffi.Pointer<GestureLongPressMoveUpdateCallbackFFI> onTertiaryLongPressMoveUpdate, ffi.Pointer<GestureLongPressUpCallbackFFI> onTertiaryLongPressUp, ffi.Pointer<GestureLongPressEndCallbackFFI> onTertiaryLongPressEnd, ffi.Pointer<GestureDragDownCallbackFFI> onVerticalDragDown, ffi.Pointer<GestureDragStartCallbackFFI> onVerticalDragStart, ffi.Pointer<GestureDragUpdateCallbackFFI> onVerticalDragUpdate, ffi.Pointer<GestureDragEndCallbackFFI> onVerticalDragEnd, ffi.Pointer<GestureDragCancelCallbackFFI> onVerticalDragCancel, ffi.Pointer<GestureDragDownCallbackFFI> onHorizontalDragDown, ffi.Pointer<GestureDragStartCallbackFFI> onHorizontalDragStart, ffi.Pointer<GestureDragUpdateCallbackFFI> onHorizontalDragUpdate, ffi.Pointer<GestureDragEndCallbackFFI> onHorizontalDragEnd, ffi.Pointer<GestureDragCancelCallbackFFI> onHorizontalDragCancel, ffi.Pointer<GestureForcePressStartCallbackFFI> onForcePressStart, ffi.Pointer<GestureForcePressPeakCallbackFFI> onForcePressPeak, ffi.Pointer<GestureForcePressUpdateCallbackFFI> onForcePressUpdate, ffi.Pointer<GestureForcePressEndCallbackFFI> onForcePressEnd, ffi.Pointer<GestureDragDownCallbackFFI> onPanDown, ffi.Pointer<GestureDragStartCallbackFFI> onPanStart, ffi.Pointer<GestureDragUpdateCallbackFFI> onPanUpdate, ffi.Pointer<GestureDragEndCallbackFFI> onPanEnd, ffi.Pointer<GestureDragCancelCallbackFFI> onPanCancel, ffi.Pointer<GestureScaleStartCallbackFFI> onScaleStart, ffi.Pointer<GestureScaleUpdateCallbackFFI> onScaleUpdate, ffi.Pointer<GestureScaleEndCallbackFFI> onScaleEnd, ffi.Pointer<ffi.Int> behavior, ffi.Pointer<ffi.Int> excludeFromSemantics, ffi.Pointer<ffi.Int> dragStartBehavior, ffi.Pointer<ffi.Int> trackpadScrollCausesScale, ffi.Pointer<DartObj> trackpadScrollToScaleFactor) {
  final w = GestureDetector(child: child.objOrNul(),
      onTapDown: onTapDown.toGestureTapDownCallbackFn(),
      onTapUp: onTapUp.toGestureTapUpCallbackFn(),
      onTap: onTap.toGestureTapCallbackFn(),
      onTapMove: onTapMove.toGestureTapMoveCallbackFn(),
      onTapCancel: onTapCancel.toGestureTapCancelCallbackFn(),
      onSecondaryTap: onSecondaryTap.toGestureTapCallbackFn(),
      onSecondaryTapDown: onSecondaryTapDown.toGestureTapDownCallbackFn(),
      onSecondaryTapUp: onSecondaryTapUp.toGestureTapUpCallbackFn(),
      onSecondaryTapCancel: onSecondaryTapCancel.toGestureTapCancelCallbackFn(),
      onTertiaryTapDown: onTertiaryTapDown.toGestureTapDownCallbackFn(),
      onTertiaryTapUp: onTertiaryTapUp.toGestureTapUpCallbackFn(),
      onTertiaryTapCancel: onTertiaryTapCancel.toGestureTapCancelCallbackFn(),
      onDoubleTapDown: onDoubleTapDown.toGestureTapDownCallbackFn(),
      onDoubleTap: onDoubleTap.toGestureTapCallbackFn(),
      onDoubleTapCancel: onDoubleTapCancel.toGestureTapCancelCallbackFn(),
      onLongPressDown: onLongPressDown.toGestureLongPressDownCallbackFn(),
      onLongPressCancel: onLongPressCancel.toGestureLongPressCancelCallbackFn(),
      onLongPress: onLongPress.toGestureLongPressCallbackFn(),
      onLongPressStart: onLongPressStart.toGestureLongPressStartCallbackFn(),
      onLongPressMoveUpdate: onLongPressMoveUpdate.toGestureLongPressMoveUpdateCallbackFn(),
      onLongPressUp: onLongPressUp.toGestureLongPressUpCallbackFn(),
      onLongPressEnd: onLongPressEnd.toGestureLongPressEndCallbackFn(),
      onSecondaryLongPressDown: onSecondaryLongPressDown.toGestureLongPressDownCallbackFn(),
      onSecondaryLongPressCancel: onSecondaryLongPressCancel.toGestureLongPressCancelCallbackFn(),
      onSecondaryLongPress: onSecondaryLongPress.toGestureLongPressCallbackFn(),
      onSecondaryLongPressStart: onSecondaryLongPressStart.toGestureLongPressStartCallbackFn(),
      onSecondaryLongPressMoveUpdate: onSecondaryLongPressMoveUpdate.toGestureLongPressMoveUpdateCallbackFn(),
      onSecondaryLongPressUp: onSecondaryLongPressUp.toGestureLongPressUpCallbackFn(),
      onSecondaryLongPressEnd: onSecondaryLongPressEnd.toGestureLongPressEndCallbackFn(),
      onTertiaryLongPressDown: onTertiaryLongPressDown.toGestureLongPressDownCallbackFn(),
      onTertiaryLongPressCancel: onTertiaryLongPressCancel.toGestureLongPressCancelCallbackFn(),
      onTertiaryLongPress: onTertiaryLongPress.toGestureLongPressCallbackFn(),
      onTertiaryLongPressStart: onTertiaryLongPressStart.toGestureLongPressStartCallbackFn(),
      onTertiaryLongPressMoveUpdate: onTertiaryLongPressMoveUpdate.toGestureLongPressMoveUpdateCallbackFn(),
      onTertiaryLongPressUp: onTertiaryLongPressUp.toGestureLongPressUpCallbackFn(),
      onTertiaryLongPressEnd: onTertiaryLongPressEnd.toGestureLongPressEndCallbackFn(),
      onVerticalDragDown: onVerticalDragDown.toGestureDragDownCallbackFn(),
      onVerticalDragStart: onVerticalDragStart.toGestureDragStartCallbackFn(),
      onVerticalDragUpdate: onVerticalDragUpdate.toGestureDragUpdateCallbackFn(),
      onVerticalDragEnd: onVerticalDragEnd.toGestureDragEndCallbackFn(),
      onVerticalDragCancel: onVerticalDragCancel.toGestureDragCancelCallbackFn(),
      onHorizontalDragDown: onHorizontalDragDown.toGestureDragDownCallbackFn(),
      onHorizontalDragStart: onHorizontalDragStart.toGestureDragStartCallbackFn(),
      onHorizontalDragUpdate: onHorizontalDragUpdate.toGestureDragUpdateCallbackFn(),
      onHorizontalDragEnd: onHorizontalDragEnd.toGestureDragEndCallbackFn(),
      onHorizontalDragCancel: onHorizontalDragCancel.toGestureDragCancelCallbackFn(),
      onForcePressStart: onForcePressStart.toGestureForcePressStartCallbackFn(),
      onForcePressPeak: onForcePressPeak.toGestureForcePressPeakCallbackFn(),
      onForcePressUpdate: onForcePressUpdate.toGestureForcePressUpdateCallbackFn(),
      onForcePressEnd: onForcePressEnd.toGestureForcePressEndCallbackFn(),
      onPanDown: onPanDown.toGestureDragDownCallbackFn(),
      onPanStart: onPanStart.toGestureDragStartCallbackFn(),
      onPanUpdate: onPanUpdate.toGestureDragUpdateCallbackFn(),
      onPanEnd: onPanEnd.toGestureDragEndCallbackFn(),
      onPanCancel: onPanCancel.toGestureDragCancelCallbackFn(),
      onScaleStart: onScaleStart.toGestureScaleStartCallbackFn(),
      onScaleUpdate: onScaleUpdate.toGestureScaleUpdateCallbackFn(),
      onScaleEnd: onScaleEnd.toGestureScaleEndCallbackFn(),
      behavior: behavior.enumOrNul(HitTestBehavior.values),
      excludeFromSemantics: excludeFromSemantics.boolOr(false),
      dragStartBehavior: dragStartBehavior.enumOr(DragStartBehavior.values, DragStartBehavior.start),
      trackpadScrollCausesScale: trackpadScrollCausesScale.boolOr(false),
      trackpadScrollToScaleFactor: trackpadScrollToScaleFactor.objOr(kDefaultTrackpadScrollToScaleFactor));
  return _createGestureDetectorObjSt(w);
}
GestureDetectorObjSt _createGestureDetectorObjSt(GestureDetector? w) {
  final GestureDetectorObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.child = _addWidget(w.child);
  stObj.behavior = (w.behavior != null) ? w.behavior!.index : 0;
  stObj.excludeFromSemantics = w.excludeFromSemantics.toInt();
  stObj.dragStartBehavior = w.dragStartBehavior.index;
  stObj.trackpadScrollCausesScale = w.trackpadScrollCausesScale.toInt();
  stObj.trackpadScrollToScaleFactor = _addWidget(w.trackpadScrollToScaleFactor);
  return stObj;
}

void _setupListTile(WidgetFactories f) {
  f.listTile.listTile = ffi.Pointer.fromFunction(listTileListTile);
}
ListTileObjSt listTileListTile(ffi.Pointer<DartObj> leading, ffi.Pointer<DartObj> title, ffi.Pointer<DartObj> subtitle, ffi.Pointer<DartObj> trailing, ffi.Pointer<ffi.Int> isThreeLine, ffi.Pointer<ffi.Int> dense, ffi.Pointer<DartObj> visualDensity, ffi.Pointer<DartObj> shape, ffi.Pointer<ffi.Int> style, ffi.Pointer<DartObj> selectedColor, ffi.Pointer<DartObj> iconColor, ffi.Pointer<DartObj> textColor, ffi.Pointer<DartObj> titleTextStyle, ffi.Pointer<DartObj> subtitleTextStyle, ffi.Pointer<DartObj> leadingAndTrailingTextStyle, ffi.Pointer<DartObj> contentPadding, ffi.Pointer<ffi.Int> enabled, ffi.Pointer<GestureTapCallbackFFI> onTap, ffi.Pointer<GestureLongPressCallbackFFI> onLongPress, ffi.Pointer<ValueChangedForBoolFFI> onFocusChange, ffi.Pointer<ffi.Int> selected, ffi.Pointer<DartObj> focusColor, ffi.Pointer<DartObj> hoverColor, ffi.Pointer<DartObj> splashColor, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<DartObj> tileColor, ffi.Pointer<DartObj> selectedTileColor, ffi.Pointer<ffi.Int> enableFeedback, ffi.Pointer<ffi.Double> horizontalTitleGap, ffi.Pointer<ffi.Double> minVerticalPadding, ffi.Pointer<ffi.Double> minLeadingWidth, ffi.Pointer<ffi.Double> minTileHeight, ffi.Pointer<ffi.Int> titleAlignment, ffi.Pointer<ffi.Int> internalAddSemanticForOnTap) {
  final w = ListTile(leading: leading.objOrNul(),
      title: title.objOrNul(),
      subtitle: subtitle.objOrNul(),
      trailing: trailing.objOrNul(),
      isThreeLine: isThreeLine.boolOrNul(),
      dense: dense.boolOrNul(),
      visualDensity: visualDensity.objOrNul(),
      shape: shape.objOrNul(),
      style: style.enumOrNul(ListTileStyle.values),
      selectedColor: selectedColor.objOrNul(),
      iconColor: iconColor.objOrNul(),
      textColor: textColor.objOrNul(),
      titleTextStyle: titleTextStyle.objOrNul(),
      subtitleTextStyle: subtitleTextStyle.objOrNul(),
      leadingAndTrailingTextStyle: leadingAndTrailingTextStyle.objOrNul(),
      contentPadding: contentPadding.objOrNul(),
      enabled: enabled.boolOr(true),
      onTap: onTap.toGestureTapCallbackFn(),
      onLongPress: onLongPress.toGestureLongPressCallbackFn(),
      onFocusChange: onFocusChange.toValueChangedForBoolFn(),
      selected: selected.boolOr(false),
      focusColor: focusColor.objOrNul(),
      hoverColor: hoverColor.objOrNul(),
      splashColor: splashColor.objOrNul(),
      autofocus: autofocus.boolOr(false),
      tileColor: tileColor.objOrNul(),
      selectedTileColor: selectedTileColor.objOrNul(),
      enableFeedback: enableFeedback.boolOrNul(),
      horizontalTitleGap: horizontalTitleGap.doubleOrNul(),
      minVerticalPadding: minVerticalPadding.doubleOrNul(),
      minLeadingWidth: minLeadingWidth.doubleOrNul(),
      minTileHeight: minTileHeight.doubleOrNul(),
      titleAlignment: titleAlignment.enumOrNul(ListTileTitleAlignment.values),
      internalAddSemanticForOnTap: internalAddSemanticForOnTap.boolOr(true));
  return _createListTileObjSt(w);
}
ListTileObjSt _createListTileObjSt(ListTile? w) {
  final ListTileObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.leading = _addWidget(w.leading);
  stObj.title = _addWidget(w.title);
  stObj.subtitle = _addWidget(w.subtitle);
  stObj.trailing = _addWidget(w.trailing);
  stObj.isThreeLine = (w.isThreeLine != null) ? w.isThreeLine!.toInt() : 0;
  stObj.dense = (w.dense != null) ? w.dense!.toInt() : 0;
  stObj.visualDensity = _createVisualDensityObjSt(w.visualDensity);
  stObj.shape = _addWidget(w.shape);
  stObj.selectedColor = _addWidget(w.selectedColor);
  stObj.iconColor = _addWidget(w.iconColor);
  stObj.textColor = _addWidget(w.textColor);
  stObj.titleTextStyle = _createTextStyleObjSt(w.titleTextStyle);
  stObj.subtitleTextStyle = _createTextStyleObjSt(w.subtitleTextStyle);
  stObj.leadingAndTrailingTextStyle = _createTextStyleObjSt(w.leadingAndTrailingTextStyle);
  stObj.style = (w.style != null) ? w.style!.index : 0;
  stObj.contentPadding = _addWidget(w.contentPadding);
  stObj.enabled = w.enabled.toInt();
  stObj.selected = w.selected.toInt();
  stObj.focusColor = _addWidget(w.focusColor);
  stObj.hoverColor = _addWidget(w.hoverColor);
  stObj.splashColor = _addWidget(w.splashColor);
  stObj.autofocus = w.autofocus.toInt();
  stObj.tileColor = _addWidget(w.tileColor);
  stObj.selectedTileColor = _addWidget(w.selectedTileColor);
  stObj.enableFeedback = (w.enableFeedback != null) ? w.enableFeedback!.toInt() : 0;
  stObj.horizontalTitleGap = (w.horizontalTitleGap != null) ? w.horizontalTitleGap! : 0;
  stObj.minVerticalPadding = (w.minVerticalPadding != null) ? w.minVerticalPadding! : 0;
  stObj.minLeadingWidth = (w.minLeadingWidth != null) ? w.minLeadingWidth! : 0;
  stObj.minTileHeight = (w.minTileHeight != null) ? w.minTileHeight! : 0;
  stObj.titleAlignment = (w.titleAlignment != null) ? w.titleAlignment!.index : 0;
  stObj.internalAddSemanticForOnTap = w.internalAddSemanticForOnTap.toInt();
  return stObj;
}

void _setupWrap(WidgetFactories f) {
  f.wrap.wrap = ffi.Pointer.fromFunction(wrapWrap);
}
WrapObjSt wrapWrap(ffi.Pointer<ffi.Int> direction, ffi.Pointer<ffi.Int> alignment, ffi.Pointer<ffi.Double> spacing, ffi.Pointer<ffi.Int> runAlignment, ffi.Pointer<ffi.Double> runSpacing, ffi.Pointer<ffi.Int> crossAxisAlignment, ffi.Pointer<ffi.Int> textDirection, ffi.Pointer<ffi.Int> verticalDirection, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<ArrayC> children) {
  final w = Wrap(direction: direction.enumOr(Axis.values, Axis.horizontal),
      alignment: alignment.enumOr(WrapAlignment.values, WrapAlignment.start),
      spacing: spacing.doubleOr(0.0),
      runAlignment: runAlignment.enumOr(WrapAlignment.values, WrapAlignment.start),
      runSpacing: runSpacing.doubleOr(0.0),
      crossAxisAlignment: crossAxisAlignment.enumOr(WrapCrossAlignment.values, WrapCrossAlignment.start),
      textDirection: textDirection.enumOrNul(TextDirection.values),
      verticalDirection: verticalDirection.enumOr(VerticalDirection.values, VerticalDirection.down),
      clipBehavior: clipBehavior.enumOr(Clip.values, Clip.none),
      children: children.listOrEmpty());
  return _createWrapObjSt(w);
}
WrapObjSt _createWrapObjSt(Wrap? w) {
  final WrapObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.direction = w.direction.index;
  stObj.alignment = w.alignment.index;
  stObj.spacing = w.spacing;
  stObj.runAlignment = w.runAlignment.index;
  stObj.runSpacing = w.runSpacing;
  stObj.crossAxisAlignment = w.crossAxisAlignment.index;
  stObj.textDirection = (w.textDirection != null) ? w.textDirection!.index : 0;
  stObj.verticalDirection = w.verticalDirection.index;
  stObj.clipBehavior = w.clipBehavior.index;
  return stObj;
}

void _setupSingleChildScrollView(WidgetFactories f) {
  f.singleChildScrollView.singleChildScrollView = ffi.Pointer.fromFunction(singleChildScrollViewSingleChildScrollView);
}
SingleChildScrollViewObjSt singleChildScrollViewSingleChildScrollView(ffi.Pointer<ffi.Int> scrollDirection, ffi.Pointer<ffi.Int> reverse, ffi.Pointer<DartObj> padding, ffi.Pointer<ffi.Int> primary, ffi.Pointer<DartObj> child, ffi.Pointer<ffi.Int> dragStartBehavior, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<ffi.Int> hitTestBehavior, ffi.Pointer<ffi.Char> restorationId, ffi.Pointer<ffi.Int> keyboardDismissBehavior) {
  final w = SingleChildScrollView(scrollDirection: scrollDirection.enumOr(Axis.values, Axis.vertical),
      reverse: reverse.boolOr(false),
      padding: padding.objOrNul(),
      primary: primary.boolOrNul(),
      child: child.objOrNul(),
      dragStartBehavior: dragStartBehavior.enumOr(DragStartBehavior.values, DragStartBehavior.start),
      clipBehavior: clipBehavior.enumOr(Clip.values, Clip.hardEdge),
      hitTestBehavior: hitTestBehavior.enumOr(HitTestBehavior.values, HitTestBehavior.opaque),
      restorationId: restorationId.strOrNul(),
      keyboardDismissBehavior: keyboardDismissBehavior.enumOrNul(ScrollViewKeyboardDismissBehavior.values));
  return _createSingleChildScrollViewObjSt(w);
}
SingleChildScrollViewObjSt _createSingleChildScrollViewObjSt(SingleChildScrollView? w) {
  final SingleChildScrollViewObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.scrollDirection = w.scrollDirection.index;
  stObj.reverse = w.reverse.toInt();
  stObj.padding = _addWidget(w.padding);
  stObj.primary = (w.primary != null) ? w.primary!.toInt() : 0;
  stObj.child = _addWidget(w.child);
  stObj.dragStartBehavior = w.dragStartBehavior.index;
  stObj.clipBehavior = w.clipBehavior.index;
  stObj.hitTestBehavior = w.hitTestBehavior.index;
  stObj.restorationId = (w.restorationId != null) ? w.restorationId!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.keyboardDismissBehavior = (w.keyboardDismissBehavior != null) ? w.keyboardDismissBehavior!.index : 0;
  return stObj;
}

void _setupCircularProgressIndicator(WidgetFactories f) {
  f.circularProgressIndicator.circularProgressIndicator = ffi.Pointer.fromFunction(circularProgressIndicatorCircularProgressIndicator);
  f.circularProgressIndicator.adaptive = ffi.Pointer.fromFunction(circularProgressIndicatorAdaptive);
}
CircularProgressIndicatorObjSt circularProgressIndicatorCircularProgressIndicator(ffi.Pointer<ffi.Double> value, ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<DartObj> color, ffi.Pointer<DartObj> valueColor, ffi.Pointer<ffi.Double> strokeWidth, ffi.Pointer<ffi.Double> strokeAlign, ffi.Pointer<ffi.Char> semanticsLabel, ffi.Pointer<ffi.Char> semanticsValue, ffi.Pointer<ffi.Int> strokeCap, ffi.Pointer<DartObj> constraints, ffi.Pointer<ffi.Double> trackGap, ffi.Pointer<ffi.Int> year2023, ffi.Pointer<DartObj> padding) {
  final w = CircularProgressIndicator(value: value.doubleOrNul(),
      backgroundColor: backgroundColor.objOrNul(),
      color: color.objOrNul(),
      valueColor: valueColor.objOrNul(),
      strokeWidth: strokeWidth.doubleOrNul(),
      strokeAlign: strokeAlign.doubleOrNul(),
      semanticsLabel: semanticsLabel.strOrNul(),
      semanticsValue: semanticsValue.strOrNul(),
      strokeCap: strokeCap.enumOrNul(StrokeCap.values),
      constraints: constraints.objOrNul(),
      trackGap: trackGap.doubleOrNul(),
      year2023: year2023.boolOrNul(),
      padding: padding.objOrNul());
  return _createCircularProgressIndicatorObjSt(w);
}
CircularProgressIndicatorObjSt circularProgressIndicatorAdaptive(ffi.Pointer<ffi.Double> value, ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<DartObj> valueColor, ffi.Pointer<ffi.Double> strokeWidth, ffi.Pointer<ffi.Char> semanticsLabel, ffi.Pointer<ffi.Char> semanticsValue, ffi.Pointer<ffi.Int> strokeCap, ffi.Pointer<ffi.Double> strokeAlign, ffi.Pointer<DartObj> constraints, ffi.Pointer<ffi.Double> trackGap, ffi.Pointer<ffi.Int> year2023, ffi.Pointer<DartObj> padding) {
  final w = CircularProgressIndicator.adaptive(value: value.doubleOrNul(),
      backgroundColor: backgroundColor.objOrNul(),
      valueColor: valueColor.objOrNul(),
      strokeWidth: strokeWidth.doubleOrNul(),
      semanticsLabel: semanticsLabel.strOrNul(),
      semanticsValue: semanticsValue.strOrNul(),
      strokeCap: strokeCap.enumOrNul(StrokeCap.values),
      strokeAlign: strokeAlign.doubleOrNul(),
      constraints: constraints.objOrNul(),
      trackGap: trackGap.doubleOrNul(),
      year2023: year2023.boolOrNul(),
      padding: padding.objOrNul());
  return _createCircularProgressIndicatorObjSt(w);
}
CircularProgressIndicatorObjSt _createCircularProgressIndicatorObjSt(CircularProgressIndicator? w) {
  final CircularProgressIndicatorObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.strokeWidth = (w.strokeWidth != null) ? w.strokeWidth! : 0;
  stObj.strokeAlign = (w.strokeAlign != null) ? w.strokeAlign! : 0;
  stObj.strokeCap = (w.strokeCap != null) ? w.strokeCap!.index : 0;
  stObj.constraints = _createBoxConstraintsObjSt(w.constraints);
  stObj.trackGap = (w.trackGap != null) ? w.trackGap! : 0;
  stObj.year2023 = (w.year2023 != null) ? w.year2023!.toInt() : 0;
  stObj.padding = _addWidget(w.padding);
  return stObj;
}

void _setupLinearProgressIndicator(WidgetFactories f) {
  f.linearProgressIndicator.linearProgressIndicator = ffi.Pointer.fromFunction(linearProgressIndicatorLinearProgressIndicator);
}
LinearProgressIndicatorObjSt linearProgressIndicatorLinearProgressIndicator(ffi.Pointer<ffi.Double> value, ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<DartObj> color, ffi.Pointer<DartObj> valueColor, ffi.Pointer<ffi.Double> minHeight, ffi.Pointer<ffi.Char> semanticsLabel, ffi.Pointer<ffi.Char> semanticsValue, ffi.Pointer<DartObj> borderRadius, ffi.Pointer<DartObj> stopIndicatorColor, ffi.Pointer<ffi.Double> stopIndicatorRadius, ffi.Pointer<ffi.Double> trackGap, ffi.Pointer<ffi.Int> year2023) {
  final w = LinearProgressIndicator(value: value.doubleOrNul(),
      backgroundColor: backgroundColor.objOrNul(),
      color: color.objOrNul(),
      valueColor: valueColor.objOrNul(),
      minHeight: minHeight.doubleOrNul(),
      semanticsLabel: semanticsLabel.strOrNul(),
      semanticsValue: semanticsValue.strOrNul(),
      borderRadius: borderRadius.objOrNul(),
      stopIndicatorColor: stopIndicatorColor.objOrNul(),
      stopIndicatorRadius: stopIndicatorRadius.doubleOrNul(),
      trackGap: trackGap.doubleOrNul(),
      year2023: year2023.boolOrNul());
  return _createLinearProgressIndicatorObjSt(w);
}
LinearProgressIndicatorObjSt _createLinearProgressIndicatorObjSt(LinearProgressIndicator? w) {
  final LinearProgressIndicatorObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.minHeight = (w.minHeight != null) ? w.minHeight! : 0;
  stObj.borderRadius = _addWidget(w.borderRadius);
  stObj.stopIndicatorColor = _addWidget(w.stopIndicatorColor);
  stObj.stopIndicatorRadius = (w.stopIndicatorRadius != null) ? w.stopIndicatorRadius! : 0;
  stObj.trackGap = (w.trackGap != null) ? w.trackGap! : 0;
  stObj.year2023 = (w.year2023 != null) ? w.year2023!.toInt() : 0;
  return stObj;
}

void _setupCheckbox(WidgetFactories f) {
  f.checkbox.checkbox = ffi.Pointer.fromFunction(checkboxCheckbox);
  f.checkbox.adaptive = ffi.Pointer.fromFunction(checkboxAdaptive);
}
CheckboxObjSt checkboxCheckbox(int value, ffi.Pointer<ffi.Int> tristate, ValueChangedForBoolOptFFI onChanged, ffi.Pointer<DartObj> activeColor, ffi.Pointer<DartObj> fillColor, ffi.Pointer<DartObj> checkColor, ffi.Pointer<DartObj> focusColor, ffi.Pointer<DartObj> hoverColor, ffi.Pointer<DartObj> overlayColor, ffi.Pointer<ffi.Double> splashRadius, ffi.Pointer<ffi.Int> materialTapTargetSize, ffi.Pointer<DartObj> visualDensity, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<DartObj> shape, ffi.Pointer<DartObj> side, ffi.Pointer<ffi.Int> isError, ffi.Pointer<ffi.Char> semanticLabel) {
  final w = Checkbox(value: value.toBool(),
      tristate: tristate.boolOr(false),
      onChanged: onChanged.toValueChangedForBoolOptFn(),
      activeColor: activeColor.objOrNul(),
      fillColor: _wspNul<Color?>(fillColor.objOrNul()),
      checkColor: checkColor.objOrNul(),
      focusColor: focusColor.objOrNul(),
      hoverColor: hoverColor.objOrNul(),
      overlayColor: _wspNul<Color?>(overlayColor.objOrNul()),
      splashRadius: splashRadius.doubleOrNul(),
      materialTapTargetSize: materialTapTargetSize.enumOrNul(MaterialTapTargetSize.values),
      visualDensity: visualDensity.objOrNul(),
      autofocus: autofocus.boolOr(false),
      shape: shape.objOrNul(),
      side: side.objOrNul(),
      isError: isError.boolOr(false),
      semanticLabel: semanticLabel.strOrNul());
  return _createCheckboxObjSt(w);
}
CheckboxObjSt checkboxAdaptive(int value, ffi.Pointer<ffi.Int> tristate, ValueChangedForBoolOptFFI onChanged, ffi.Pointer<DartObj> activeColor, ffi.Pointer<DartObj> fillColor, ffi.Pointer<DartObj> checkColor, ffi.Pointer<DartObj> focusColor, ffi.Pointer<DartObj> hoverColor, ffi.Pointer<DartObj> overlayColor, ffi.Pointer<ffi.Double> splashRadius, ffi.Pointer<ffi.Int> materialTapTargetSize, ffi.Pointer<DartObj> visualDensity, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<DartObj> shape, ffi.Pointer<DartObj> side, ffi.Pointer<ffi.Int> isError, ffi.Pointer<ffi.Char> semanticLabel) {
  final w = Checkbox.adaptive(value: value.toBool(),
      tristate: tristate.boolOr(false),
      onChanged: onChanged.toValueChangedForBoolOptFn(),
      activeColor: activeColor.objOrNul(),
      fillColor: _wspNul<Color?>(fillColor.objOrNul()),
      checkColor: checkColor.objOrNul(),
      focusColor: focusColor.objOrNul(),
      hoverColor: hoverColor.objOrNul(),
      overlayColor: _wspNul<Color?>(overlayColor.objOrNul()),
      splashRadius: splashRadius.doubleOrNul(),
      materialTapTargetSize: materialTapTargetSize.enumOrNul(MaterialTapTargetSize.values),
      visualDensity: visualDensity.objOrNul(),
      autofocus: autofocus.boolOr(false),
      shape: shape.objOrNul(),
      side: side.objOrNul(),
      isError: isError.boolOr(false),
      semanticLabel: semanticLabel.strOrNul());
  return _createCheckboxObjSt(w);
}
CheckboxObjSt _createCheckboxObjSt(Checkbox? w) {
  final CheckboxObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.value = (w.value != null) ? w.value!.toInt() : 0;
  stObj.activeColor = _addWidget(w.activeColor);
  stObj.checkColor = _addWidget(w.checkColor);
  stObj.tristate = w.tristate.toInt();
  stObj.materialTapTargetSize = (w.materialTapTargetSize != null) ? w.materialTapTargetSize!.index : 0;
  stObj.visualDensity = _createVisualDensityObjSt(w.visualDensity);
  stObj.focusColor = _addWidget(w.focusColor);
  stObj.hoverColor = _addWidget(w.hoverColor);
  stObj.splashRadius = (w.splashRadius != null) ? w.splashRadius! : 0;
  stObj.autofocus = w.autofocus.toInt();
  stObj.shape = _addWidget(w.shape);
  stObj.side = _createBorderSideObjSt(w.side);
  stObj.isError = w.isError.toInt();
  stObj.semanticLabel = (w.semanticLabel != null) ? w.semanticLabel!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  return stObj;
}

void _setupSwitch(WidgetFactories f) {
  f.switch_.switch_ = ffi.Pointer.fromFunction(switch_Switch_);
  f.switch_.adaptive = ffi.Pointer.fromFunction(switch_Adaptive);
}
SwitchObjSt switch_Switch_(int value, ValueChangedForBoolFFI onChanged, ffi.Pointer<DartObj> activeColor, ffi.Pointer<DartObj> activeThumbColor, ffi.Pointer<DartObj> activeTrackColor, ffi.Pointer<DartObj> inactiveThumbColor, ffi.Pointer<DartObj> inactiveTrackColor, ffi.Pointer<DartObj> thumbColor, ffi.Pointer<DartObj> trackColor, ffi.Pointer<DartObj> trackOutlineColor, ffi.Pointer<ffi.Double> trackOutlineWidth, ffi.Pointer<DartObj> thumbIcon, ffi.Pointer<ffi.Int> materialTapTargetSize, ffi.Pointer<ffi.Int> dragStartBehavior, ffi.Pointer<DartObj> focusColor, ffi.Pointer<DartObj> hoverColor, ffi.Pointer<DartObj> overlayColor, ffi.Pointer<ffi.Double> splashRadius, ffi.Pointer<ValueChangedForBoolFFI> onFocusChange, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<DartObj> padding) {
  final w = Switch(value: value.toBool(),
      onChanged: onChanged.toValueChangedForBoolFn(),
      activeColor: activeColor.objOrNul(),
      activeThumbColor: activeThumbColor.objOrNul(),
      activeTrackColor: activeTrackColor.objOrNul(),
      inactiveThumbColor: inactiveThumbColor.objOrNul(),
      inactiveTrackColor: inactiveTrackColor.objOrNul(),
      thumbColor: _wspNul<Color?>(thumbColor.objOrNul()),
      trackColor: _wspNul<Color?>(trackColor.objOrNul()),
      trackOutlineColor: _wspNul<Color?>(trackOutlineColor.objOrNul()),
      trackOutlineWidth: _wspNul<double?>(trackOutlineWidth.doubleOrNul()),
      thumbIcon: _wspNul<Icon?>(thumbIcon.objOrNul()),
      materialTapTargetSize: materialTapTargetSize.enumOrNul(MaterialTapTargetSize.values),
      dragStartBehavior: dragStartBehavior.enumOr(DragStartBehavior.values, DragStartBehavior.start),
      focusColor: focusColor.objOrNul(),
      hoverColor: hoverColor.objOrNul(),
      overlayColor: _wspNul<Color?>(overlayColor.objOrNul()),
      splashRadius: splashRadius.doubleOrNul(),
      onFocusChange: onFocusChange.toValueChangedForBoolFn(),
      autofocus: autofocus.boolOr(false),
      padding: padding.objOrNul());
  return _createSwitchObjSt(w);
}
SwitchObjSt switch_Adaptive(int value, ValueChangedForBoolFFI onChanged, ffi.Pointer<DartObj> activeColor, ffi.Pointer<DartObj> activeThumbColor, ffi.Pointer<DartObj> activeTrackColor, ffi.Pointer<DartObj> inactiveThumbColor, ffi.Pointer<DartObj> inactiveTrackColor, ffi.Pointer<ffi.Int> materialTapTargetSize, ffi.Pointer<DartObj> thumbColor, ffi.Pointer<DartObj> trackColor, ffi.Pointer<DartObj> trackOutlineColor, ffi.Pointer<ffi.Double> trackOutlineWidth, ffi.Pointer<DartObj> thumbIcon, ffi.Pointer<ffi.Int> dragStartBehavior, ffi.Pointer<DartObj> focusColor, ffi.Pointer<DartObj> hoverColor, ffi.Pointer<DartObj> overlayColor, ffi.Pointer<ffi.Double> splashRadius, ffi.Pointer<ValueChangedForBoolFFI> onFocusChange, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<DartObj> padding, ffi.Pointer<ffi.Int> applyCupertinoTheme) {
  final w = Switch.adaptive(value: value.toBool(),
      onChanged: onChanged.toValueChangedForBoolFn(),
      activeColor: activeColor.objOrNul(),
      activeThumbColor: activeThumbColor.objOrNul(),
      activeTrackColor: activeTrackColor.objOrNul(),
      inactiveThumbColor: inactiveThumbColor.objOrNul(),
      inactiveTrackColor: inactiveTrackColor.objOrNul(),
      materialTapTargetSize: materialTapTargetSize.enumOrNul(MaterialTapTargetSize.values),
      thumbColor: _wspNul<Color?>(thumbColor.objOrNul()),
      trackColor: _wspNul<Color?>(trackColor.objOrNul()),
      trackOutlineColor: _wspNul<Color?>(trackOutlineColor.objOrNul()),
      trackOutlineWidth: _wspNul<double?>(trackOutlineWidth.doubleOrNul()),
      thumbIcon: _wspNul<Icon?>(thumbIcon.objOrNul()),
      dragStartBehavior: dragStartBehavior.enumOr(DragStartBehavior.values, DragStartBehavior.start),
      focusColor: focusColor.objOrNul(),
      hoverColor: hoverColor.objOrNul(),
      overlayColor: _wspNul<Color?>(overlayColor.objOrNul()),
      splashRadius: splashRadius.doubleOrNul(),
      onFocusChange: onFocusChange.toValueChangedForBoolFn(),
      autofocus: autofocus.boolOr(false),
      padding: padding.objOrNul(),
      applyCupertinoTheme: applyCupertinoTheme.boolOrNul());
  return _createSwitchObjSt(w);
}
SwitchObjSt _createSwitchObjSt(Switch? w) {
  final SwitchObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.value = w.value.toInt();
  stObj.activeColor = _addWidget(w.activeColor);
  stObj.activeThumbColor = _addWidget(w.activeThumbColor);
  stObj.activeTrackColor = _addWidget(w.activeTrackColor);
  stObj.inactiveThumbColor = _addWidget(w.inactiveThumbColor);
  stObj.inactiveTrackColor = _addWidget(w.inactiveTrackColor);
  stObj.materialTapTargetSize = (w.materialTapTargetSize != null) ? w.materialTapTargetSize!.index : 0;
  stObj.applyCupertinoTheme = (w.applyCupertinoTheme != null) ? w.applyCupertinoTheme!.toInt() : 0;
  stObj.dragStartBehavior = w.dragStartBehavior.index;
  stObj.focusColor = _addWidget(w.focusColor);
  stObj.hoverColor = _addWidget(w.hoverColor);
  stObj.splashRadius = (w.splashRadius != null) ? w.splashRadius! : 0;
  stObj.autofocus = w.autofocus.toInt();
  stObj.padding = _addWidget(w.padding);
  return stObj;
}

void _setupSlider(WidgetFactories f) {
  f.slider.slider = ffi.Pointer.fromFunction(sliderSlider);
  f.slider.adaptive = ffi.Pointer.fromFunction(sliderAdaptive);
}
SliderObjSt sliderSlider(double value, ffi.Pointer<ffi.Double> secondaryTrackValue, ValueChangedForDoubleFFI onChanged, ffi.Pointer<ValueChangedForDoubleFFI> onChangeStart, ffi.Pointer<ValueChangedForDoubleFFI> onChangeEnd, ffi.Pointer<ffi.Double> min, ffi.Pointer<ffi.Double> max, ffi.Pointer<ffi.Int> divisions, ffi.Pointer<ffi.Char> label, ffi.Pointer<DartObj> activeColor, ffi.Pointer<DartObj> inactiveColor, ffi.Pointer<DartObj> secondaryActiveColor, ffi.Pointer<DartObj> thumbColor, ffi.Pointer<DartObj> overlayColor, ffi.Pointer<SemanticFormatterCallbackFFI> semanticFormatterCallback, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<ffi.Int> allowedInteraction, ffi.Pointer<DartObj> padding, ffi.Pointer<ffi.Int> year2023) {
  final w = Slider(value: value,
      secondaryTrackValue: secondaryTrackValue.doubleOrNul(),
      onChanged: onChanged.toValueChangedForDoubleFn(),
      onChangeStart: onChangeStart.toValueChangedForDoubleFn(),
      onChangeEnd: onChangeEnd.toValueChangedForDoubleFn(),
      min: min.doubleOr(0.0),
      max: max.doubleOr(1.0),
      divisions: divisions.intOrNul(),
      label: label.strOrNul(),
      activeColor: activeColor.objOrNul(),
      inactiveColor: inactiveColor.objOrNul(),
      secondaryActiveColor: secondaryActiveColor.objOrNul(),
      thumbColor: thumbColor.objOrNul(),
      overlayColor: _wspNul<Color?>(overlayColor.objOrNul()),
      semanticFormatterCallback: semanticFormatterCallback.toSemanticFormatterCallbackFn(),
      autofocus: autofocus.boolOr(false),
      allowedInteraction: allowedInteraction.enumOrNul(SliderInteraction.values),
      padding: padding.objOrNul(),
      year2023: year2023.boolOrNul());
  return _createSliderObjSt(w);
}
SliderObjSt sliderAdaptive(double value, ffi.Pointer<ffi.Double> secondaryTrackValue, ValueChangedForDoubleFFI onChanged, ffi.Pointer<ValueChangedForDoubleFFI> onChangeStart, ffi.Pointer<ValueChangedForDoubleFFI> onChangeEnd, ffi.Pointer<ffi.Double> min, ffi.Pointer<ffi.Double> max, ffi.Pointer<ffi.Int> divisions, ffi.Pointer<ffi.Char> label, ffi.Pointer<DartObj> activeColor, ffi.Pointer<DartObj> inactiveColor, ffi.Pointer<DartObj> secondaryActiveColor, ffi.Pointer<DartObj> thumbColor, ffi.Pointer<DartObj> overlayColor, ffi.Pointer<SemanticFormatterCallbackFFI> semanticFormatterCallback, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<ffi.Int> allowedInteraction, ffi.Pointer<ffi.Int> year2023) {
  final w = Slider.adaptive(value: value,
      secondaryTrackValue: secondaryTrackValue.doubleOrNul(),
      onChanged: onChanged.toValueChangedForDoubleFn(),
      onChangeStart: onChangeStart.toValueChangedForDoubleFn(),
      onChangeEnd: onChangeEnd.toValueChangedForDoubleFn(),
      min: min.doubleOr(0.0),
      max: max.doubleOr(1.0),
      divisions: divisions.intOrNul(),
      label: label.strOrNul(),
      activeColor: activeColor.objOrNul(),
      inactiveColor: inactiveColor.objOrNul(),
      secondaryActiveColor: secondaryActiveColor.objOrNul(),
      thumbColor: thumbColor.objOrNul(),
      overlayColor: _wspNul<Color?>(overlayColor.objOrNul()),
      semanticFormatterCallback: semanticFormatterCallback.toSemanticFormatterCallbackFn(),
      autofocus: autofocus.boolOr(false),
      allowedInteraction: allowedInteraction.enumOrNul(SliderInteraction.values),
      year2023: year2023.boolOrNul());
  return _createSliderObjSt(w);
}
SliderObjSt _createSliderObjSt(Slider? w) {
  final SliderObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.value = w.value;
  stObj.secondaryTrackValue = (w.secondaryTrackValue != null) ? w.secondaryTrackValue! : 0;
  stObj.min = w.min;
  stObj.max = w.max;
  stObj.divisions = (w.divisions != null) ? w.divisions! : 0;
  stObj.label = (w.label != null) ? w.label!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.activeColor = _addWidget(w.activeColor);
  stObj.inactiveColor = _addWidget(w.inactiveColor);
  stObj.secondaryActiveColor = _addWidget(w.secondaryActiveColor);
  stObj.thumbColor = _addWidget(w.thumbColor);
  stObj.autofocus = w.autofocus.toInt();
  stObj.allowedInteraction = (w.allowedInteraction != null) ? w.allowedInteraction!.index : 0;
  stObj.padding = _addWidget(w.padding);
  stObj.year2023 = (w.year2023 != null) ? w.year2023!.toInt() : 0;
  return stObj;
}

void _setupDrawer(WidgetFactories f) {
  f.drawer.drawer = ffi.Pointer.fromFunction(drawerDrawer);
}
DrawerObjSt drawerDrawer(ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<ffi.Double> elevation, ffi.Pointer<DartObj> shadowColor, ffi.Pointer<DartObj> surfaceTintColor, ffi.Pointer<DartObj> shape, ffi.Pointer<ffi.Double> width, ffi.Pointer<DartObj> child, ffi.Pointer<ffi.Char> semanticLabel, ffi.Pointer<ffi.Int> clipBehavior) {
  final w = Drawer(backgroundColor: backgroundColor.objOrNul(),
      elevation: elevation.doubleOrNul(),
      shadowColor: shadowColor.objOrNul(),
      surfaceTintColor: surfaceTintColor.objOrNul(),
      shape: shape.objOrNul(),
      width: width.doubleOrNul(),
      child: child.objOrNul(),
      semanticLabel: semanticLabel.strOrNul(),
      clipBehavior: clipBehavior.enumOrNul(Clip.values));
  return _createDrawerObjSt(w);
}
DrawerObjSt _createDrawerObjSt(Drawer? w) {
  final DrawerObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.backgroundColor = _addWidget(w.backgroundColor);
  stObj.elevation = (w.elevation != null) ? w.elevation! : 0;
  stObj.shadowColor = _addWidget(w.shadowColor);
  stObj.surfaceTintColor = _addWidget(w.surfaceTintColor);
  stObj.shape = _addWidget(w.shape);
  stObj.width = (w.width != null) ? w.width! : 0;
  stObj.child = _addWidget(w.child);
  stObj.semanticLabel = (w.semanticLabel != null) ? w.semanticLabel!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.clipBehavior = (w.clipBehavior != null) ? w.clipBehavior!.index : 0;
  return stObj;
}

void _setupTooltip(WidgetFactories f) {
  f.tooltip.tooltip = ffi.Pointer.fromFunction(tooltipTooltip);
  f.tooltip.dismissAllToolTips = ffi.Pointer.fromFunction(tooltipDismissAllToolTips, exception);
}
TooltipObjSt tooltipTooltip(ffi.Pointer<ffi.Char> message, ffi.Pointer<DartObj> richMessage, ffi.Pointer<ffi.Double> height, ffi.Pointer<DartObj> constraints, ffi.Pointer<DartObj> padding, ffi.Pointer<DartObj> margin, ffi.Pointer<ffi.Double> verticalOffset, ffi.Pointer<ffi.Int> preferBelow, ffi.Pointer<ffi.Int> excludeFromSemantics, ffi.Pointer<DartObj> decoration, ffi.Pointer<DartObj> textStyle, ffi.Pointer<ffi.Int> textAlign, ffi.Pointer<DartObj> waitDuration, ffi.Pointer<DartObj> showDuration, ffi.Pointer<DartObj> exitDuration, ffi.Pointer<ffi.Int> enableTapToDismiss, ffi.Pointer<ffi.Int> triggerMode, ffi.Pointer<ffi.Int> enableFeedback, ffi.Pointer<TooltipTriggeredCallbackFFI> onTriggered, ffi.Pointer<ffi.Int> ignorePointer, ffi.Pointer<DartObj> child) {
  final w = Tooltip(message: message.strOrNul(),
      richMessage: richMessage.objOrNul(),
      height: height.doubleOrNul(),
      constraints: constraints.objOrNul(),
      padding: padding.objOrNul(),
      margin: margin.objOrNul(),
      verticalOffset: verticalOffset.doubleOrNul(),
      preferBelow: preferBelow.boolOrNul(),
      excludeFromSemantics: excludeFromSemantics.boolOrNul(),
      decoration: decoration.objOrNul(),
      textStyle: textStyle.objOrNul(),
      textAlign: textAlign.enumOrNul(TextAlign.values),
      waitDuration: waitDuration.objOrNul(),
      showDuration: showDuration.objOrNul(),
      exitDuration: exitDuration.objOrNul(),
      enableTapToDismiss: enableTapToDismiss.boolOr(true),
      triggerMode: triggerMode.enumOrNul(TooltipTriggerMode.values),
      enableFeedback: enableFeedback.boolOrNul(),
      onTriggered: onTriggered.toTooltipTriggeredCallbackFn(),
      ignorePointer: ignorePointer.boolOrNul(),
      child: child.objOrNul());
  return _createTooltipObjSt(w);
}
int tooltipDismissAllToolTips() {
  final w = Tooltip.dismissAllToolTips();
  return w.toInt();
}
TooltipObjSt _createTooltipObjSt(Tooltip? w) {
  final TooltipObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.message = (w.message != null) ? w.message!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.richMessage = _addWidget(w.richMessage);
  stObj.height = (w.height != null) ? w.height! : 0;
  stObj.constraints = _createBoxConstraintsObjSt(w.constraints);
  stObj.padding = _addWidget(w.padding);
  stObj.margin = _addWidget(w.margin);
  stObj.verticalOffset = (w.verticalOffset != null) ? w.verticalOffset! : 0;
  stObj.preferBelow = (w.preferBelow != null) ? w.preferBelow!.toInt() : 0;
  stObj.excludeFromSemantics = (w.excludeFromSemantics != null) ? w.excludeFromSemantics!.toInt() : 0;
  stObj.child = _addWidget(w.child);
  stObj.decoration = _addWidget(w.decoration);
  stObj.textStyle = _createTextStyleObjSt(w.textStyle);
  stObj.textAlign = (w.textAlign != null) ? w.textAlign!.index : 0;
  stObj.waitDuration = _addWidget(w.waitDuration);
  stObj.showDuration = _addWidget(w.showDuration);
  stObj.exitDuration = _addWidget(w.exitDuration);
  stObj.enableTapToDismiss = w.enableTapToDismiss.toInt();
  stObj.triggerMode = (w.triggerMode != null) ? w.triggerMode!.index : 0;
  stObj.enableFeedback = (w.enableFeedback != null) ? w.enableFeedback!.toInt() : 0;
  stObj.ignorePointer = (w.ignorePointer != null) ? w.ignorePointer!.toInt() : 0;
  return stObj;
}

void _setupTab(WidgetFactories f) {
  f.tab.tab = ffi.Pointer.fromFunction(tabTab);
}
TabObjSt tabTab(ffi.Pointer<ffi.Char> text, ffi.Pointer<DartObj> icon, ffi.Pointer<DartObj> iconMargin, ffi.Pointer<ffi.Double> height, ffi.Pointer<DartObj> child) {
  final w = Tab(text: text.strOrNul(),
      icon: icon.objOrNul(),
      iconMargin: iconMargin.objOrNul(),
      height: height.doubleOrNul(),
      child: child.objOrNul());
  return _createTabObjSt(w);
}
TabObjSt _createTabObjSt(Tab? w) {
  final TabObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.text = (w.text != null) ? w.text!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.child = _addWidget(w.child);
  stObj.icon = _addWidget(w.icon);
  stObj.iconMargin = _addWidget(w.iconMargin);
  stObj.height = (w.height != null) ? w.height! : 0;
  return stObj;
}

void _setupTabBar(WidgetFactories f) {
  f.tabBar.tabBar = ffi.Pointer.fromFunction(tabBarTabBar);
  f.tabBar.secondary = ffi.Pointer.fromFunction(tabBarSecondary);
}
TabBarObjSt tabBarTabBar(ArrayC tabs, ffi.Pointer<ffi.Int> isScrollable, ffi.Pointer<DartObj> padding, ffi.Pointer<DartObj> indicatorColor, ffi.Pointer<ffi.Int> automaticIndicatorColorAdjustment, ffi.Pointer<ffi.Double> indicatorWeight, ffi.Pointer<DartObj> indicatorPadding, ffi.Pointer<DartObj> indicator, ffi.Pointer<ffi.Int> indicatorSize, ffi.Pointer<DartObj> dividerColor, ffi.Pointer<ffi.Double> dividerHeight, ffi.Pointer<DartObj> labelColor, ffi.Pointer<DartObj> labelStyle, ffi.Pointer<DartObj> labelPadding, ffi.Pointer<DartObj> unselectedLabelColor, ffi.Pointer<DartObj> unselectedLabelStyle, ffi.Pointer<ffi.Int> dragStartBehavior, ffi.Pointer<DartObj> overlayColor, ffi.Pointer<ffi.Int> enableFeedback, ffi.Pointer<ValueChangedForIntFFI> onTap, ffi.Pointer<TabValueChangedForBoolFFI> onHover, ffi.Pointer<TabValueChangedForBoolFFI> onFocusChange, ffi.Pointer<DartObj> splashBorderRadius, ffi.Pointer<ffi.Int> tabAlignment, ffi.Pointer<ffi.Int> indicatorAnimation) {
  final w = TabBar(tabs: tabs.listOrEmpty(),
      isScrollable: isScrollable.boolOr(false),
      padding: padding.objOrNul(),
      indicatorColor: indicatorColor.objOrNul(),
      automaticIndicatorColorAdjustment: automaticIndicatorColorAdjustment.boolOr(true),
      indicatorWeight: indicatorWeight.doubleOr(2.0),
      indicatorPadding: indicatorPadding.objOr(EdgeInsets.zero),
      indicator: indicator.objOrNul(),
      indicatorSize: indicatorSize.enumOrNul(TabBarIndicatorSize.values),
      dividerColor: dividerColor.objOrNul(),
      dividerHeight: dividerHeight.doubleOrNul(),
      labelColor: labelColor.objOrNul(),
      labelStyle: labelStyle.objOrNul(),
      labelPadding: labelPadding.objOrNul(),
      unselectedLabelColor: unselectedLabelColor.objOrNul(),
      unselectedLabelStyle: unselectedLabelStyle.objOrNul(),
      dragStartBehavior: dragStartBehavior.enumOr(DragStartBehavior.values, DragStartBehavior.start),
      overlayColor: _wspNul<Color?>(overlayColor.objOrNul()),
      enableFeedback: enableFeedback.boolOrNul(),
      onTap: onTap.toValueChangedForIntFn(),
      onHover: onHover.toTabValueChangedForBoolFn(),
      onFocusChange: onFocusChange.toTabValueChangedForBoolFn(),
      splashBorderRadius: splashBorderRadius.objOrNul(),
      tabAlignment: tabAlignment.enumOrNul(TabAlignment.values),
      indicatorAnimation: indicatorAnimation.enumOrNul(TabIndicatorAnimation.values));
  return _createTabBarObjSt(w);
}
TabBarObjSt tabBarSecondary(ArrayC tabs, ffi.Pointer<ffi.Int> isScrollable, ffi.Pointer<DartObj> padding, ffi.Pointer<DartObj> indicatorColor, ffi.Pointer<ffi.Int> automaticIndicatorColorAdjustment, ffi.Pointer<ffi.Double> indicatorWeight, ffi.Pointer<DartObj> indicatorPadding, ffi.Pointer<DartObj> indicator, ffi.Pointer<ffi.Int> indicatorSize, ffi.Pointer<DartObj> dividerColor, ffi.Pointer<ffi.Double> dividerHeight, ffi.Pointer<DartObj> labelColor, ffi.Pointer<DartObj> labelStyle, ffi.Pointer<DartObj> labelPadding, ffi.Pointer<DartObj> unselectedLabelColor, ffi.Pointer<DartObj> unselectedLabelStyle, ffi.Pointer<ffi.Int> dragStartBehavior, ffi.Pointer<DartObj> overlayColor, ffi.Pointer<ffi.Int> enableFeedback, ffi.Pointer<ValueChangedForIntFFI> onTap, ffi.Pointer<TabValueChangedForBoolFFI> onHover, ffi.Pointer<TabValueChangedForBoolFFI> onFocusChange, ffi.Pointer<DartObj> splashBorderRadius, ffi.Pointer<ffi.Int> tabAlignment, ffi.Pointer<ffi.Int> indicatorAnimation) {
  final w = TabBar.secondary(tabs: tabs.listOrEmpty(),
      isScrollable: isScrollable.boolOr(false),
      padding: padding.objOrNul(),
      indicatorColor: indicatorColor.objOrNul(),
      automaticIndicatorColorAdjustment: automaticIndicatorColorAdjustment.boolOr(true),
      indicatorWeight: indicatorWeight.doubleOr(2.0),
      indicatorPadding: indicatorPadding.objOr(EdgeInsets.zero),
      indicator: indicator.objOrNul(),
      indicatorSize: indicatorSize.enumOrNul(TabBarIndicatorSize.values),
      dividerColor: dividerColor.objOrNul(),
      dividerHeight: dividerHeight.doubleOrNul(),
      labelColor: labelColor.objOrNul(),
      labelStyle: labelStyle.objOrNul(),
      labelPadding: labelPadding.objOrNul(),
      unselectedLabelColor: unselectedLabelColor.objOrNul(),
      unselectedLabelStyle: unselectedLabelStyle.objOrNul(),
      dragStartBehavior: dragStartBehavior.enumOr(DragStartBehavior.values, DragStartBehavior.start),
      overlayColor: _wspNul<Color?>(overlayColor.objOrNul()),
      enableFeedback: enableFeedback.boolOrNul(),
      onTap: onTap.toValueChangedForIntFn(),
      onHover: onHover.toTabValueChangedForBoolFn(),
      onFocusChange: onFocusChange.toTabValueChangedForBoolFn(),
      splashBorderRadius: splashBorderRadius.objOrNul(),
      tabAlignment: tabAlignment.enumOrNul(TabAlignment.values),
      indicatorAnimation: indicatorAnimation.enumOrNul(TabIndicatorAnimation.values));
  return _createTabBarObjSt(w);
}
TabBarObjSt _createTabBarObjSt(TabBar? w) {
  final TabBarObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.isScrollable = w.isScrollable.toInt();
  stObj.padding = _addWidget(w.padding);
  stObj.indicatorColor = _addWidget(w.indicatorColor);
  stObj.indicatorWeight = w.indicatorWeight;
  stObj.indicatorPadding = _addWidget(w.indicatorPadding);
  stObj.indicator = _addWidget(w.indicator);
  stObj.automaticIndicatorColorAdjustment = w.automaticIndicatorColorAdjustment.toInt();
  stObj.indicatorSize = (w.indicatorSize != null) ? w.indicatorSize!.index : 0;
  stObj.dividerColor = _addWidget(w.dividerColor);
  stObj.dividerHeight = (w.dividerHeight != null) ? w.dividerHeight! : 0;
  stObj.labelColor = _addWidget(w.labelColor);
  stObj.unselectedLabelColor = _addWidget(w.unselectedLabelColor);
  stObj.labelStyle = _createTextStyleObjSt(w.labelStyle);
  stObj.unselectedLabelStyle = _createTextStyleObjSt(w.unselectedLabelStyle);
  stObj.labelPadding = _addWidget(w.labelPadding);
  stObj.dragStartBehavior = w.dragStartBehavior.index;
  stObj.enableFeedback = (w.enableFeedback != null) ? w.enableFeedback!.toInt() : 0;
  stObj.splashBorderRadius = _createBorderRadiusObjSt(w.splashBorderRadius);
  stObj.tabAlignment = (w.tabAlignment != null) ? w.tabAlignment!.index : 0;
  stObj.indicatorAnimation = (w.indicatorAnimation != null) ? w.indicatorAnimation!.index : 0;
  stObj.tabHasTextAndIcon = w.tabHasTextAndIcon.toInt();
  return stObj;
}

void _setupTabBarView(WidgetFactories f) {
  f.tabBarView.tabBarView = ffi.Pointer.fromFunction(tabBarViewTabBarView);
}
TabBarViewObjSt tabBarViewTabBarView(ArrayC children, ffi.Pointer<ffi.Int> dragStartBehavior, ffi.Pointer<ffi.Double> viewportFraction, ffi.Pointer<ffi.Int> clipBehavior) {
  final w = TabBarView(children: children.listOrEmpty(),
      dragStartBehavior: dragStartBehavior.enumOr(DragStartBehavior.values, DragStartBehavior.start),
      viewportFraction: viewportFraction.doubleOr(1.0),
      clipBehavior: clipBehavior.enumOr(Clip.values, Clip.hardEdge));
  return _createTabBarViewObjSt(w);
}
TabBarViewObjSt _createTabBarViewObjSt(TabBarView? w) {
  final TabBarViewObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.dragStartBehavior = w.dragStartBehavior.index;
  stObj.viewportFraction = w.viewportFraction;
  stObj.clipBehavior = w.clipBehavior.index;
  return stObj;
}

void _setupDefaultTabController(WidgetFactories f) {
  f.defaultTabController.defaultTabController = ffi.Pointer.fromFunction(defaultTabControllerDefaultTabController);
}
DefaultTabControllerObjSt defaultTabControllerDefaultTabController(int length, ffi.Pointer<ffi.Int> initialIndex, DartDartObj child, ffi.Pointer<DartObj> animationDuration) {
  final w = DefaultTabController(length: length,
      initialIndex: initialIndex.intOr(0),
      child: _widgetsMap[child]! as Widget,
      animationDuration: animationDuration.objOrNul());
  return _createDefaultTabControllerObjSt(w);
}
DefaultTabControllerObjSt _createDefaultTabControllerObjSt(DefaultTabController? w) {
  final DefaultTabControllerObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.length = w.length;
  stObj.initialIndex = w.initialIndex;
  stObj.animationDuration = _addWidget(w.animationDuration);
  stObj.child = _addWidget(w.child);
  return stObj;
}

void _setupCheckboxListTile(WidgetFactories f) {
  f.checkboxListTile.checkboxListTile = ffi.Pointer.fromFunction(checkboxListTileCheckboxListTile);
  f.checkboxListTile.adaptive = ffi.Pointer.fromFunction(checkboxListTileAdaptive);
}
CheckboxListTileObjSt checkboxListTileCheckboxListTile(int value, ValueChangedForBoolOptFFI onChanged, ffi.Pointer<DartObj> activeColor, ffi.Pointer<DartObj> fillColor, ffi.Pointer<DartObj> checkColor, ffi.Pointer<DartObj> hoverColor, ffi.Pointer<DartObj> overlayColor, ffi.Pointer<ffi.Double> splashRadius, ffi.Pointer<ffi.Int> materialTapTargetSize, ffi.Pointer<DartObj> visualDensity, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<DartObj> shape, ffi.Pointer<DartObj> side, ffi.Pointer<ffi.Int> isError, ffi.Pointer<ffi.Int> enabled, ffi.Pointer<DartObj> tileColor, ffi.Pointer<DartObj> title, ffi.Pointer<DartObj> subtitle, ffi.Pointer<ffi.Int> isThreeLine, ffi.Pointer<ffi.Int> dense, ffi.Pointer<DartObj> secondary, ffi.Pointer<ffi.Int> selected, ffi.Pointer<ffi.Int> controlAffinity, ffi.Pointer<DartObj> contentPadding, ffi.Pointer<ffi.Int> tristate, ffi.Pointer<DartObj> checkboxShape, ffi.Pointer<DartObj> selectedTileColor, ffi.Pointer<ValueChangedForBoolFFI> onFocusChange, ffi.Pointer<ffi.Int> enableFeedback, ffi.Pointer<ffi.Char> checkboxSemanticLabel, ffi.Pointer<ffi.Double> checkboxScaleFactor, ffi.Pointer<ffi.Int> titleAlignment, ffi.Pointer<ffi.Int> internalAddSemanticForOnTap) {
  final w = CheckboxListTile(value: value.toBool(),
      onChanged: onChanged.toValueChangedForBoolOptFn(),
      activeColor: activeColor.objOrNul(),
      fillColor: _wspNul<Color?>(fillColor.objOrNul()),
      checkColor: checkColor.objOrNul(),
      hoverColor: hoverColor.objOrNul(),
      overlayColor: _wspNul<Color?>(overlayColor.objOrNul()),
      splashRadius: splashRadius.doubleOrNul(),
      materialTapTargetSize: materialTapTargetSize.enumOrNul(MaterialTapTargetSize.values),
      visualDensity: visualDensity.objOrNul(),
      autofocus: autofocus.boolOr(false),
      shape: shape.objOrNul(),
      side: side.objOrNul(),
      isError: isError.boolOr(false),
      enabled: enabled.boolOrNul(),
      tileColor: tileColor.objOrNul(),
      title: title.objOrNul(),
      subtitle: subtitle.objOrNul(),
      isThreeLine: isThreeLine.boolOrNul(),
      dense: dense.boolOrNul(),
      secondary: secondary.objOrNul(),
      selected: selected.boolOr(false),
      controlAffinity: controlAffinity.enumOrNul(ListTileControlAffinity.values),
      contentPadding: contentPadding.objOrNul(),
      tristate: tristate.boolOr(false),
      checkboxShape: checkboxShape.objOrNul(),
      selectedTileColor: selectedTileColor.objOrNul(),
      onFocusChange: onFocusChange.toValueChangedForBoolFn(),
      enableFeedback: enableFeedback.boolOrNul(),
      checkboxSemanticLabel: checkboxSemanticLabel.strOrNul(),
      checkboxScaleFactor: checkboxScaleFactor.doubleOr(1.0),
      titleAlignment: titleAlignment.enumOrNul(ListTileTitleAlignment.values),
      internalAddSemanticForOnTap: internalAddSemanticForOnTap.boolOr(false));
  return _createCheckboxListTileObjSt(w);
}
CheckboxListTileObjSt checkboxListTileAdaptive(int value, ValueChangedForBoolOptFFI onChanged, ffi.Pointer<DartObj> activeColor, ffi.Pointer<DartObj> fillColor, ffi.Pointer<DartObj> checkColor, ffi.Pointer<DartObj> hoverColor, ffi.Pointer<DartObj> overlayColor, ffi.Pointer<ffi.Double> splashRadius, ffi.Pointer<ffi.Int> materialTapTargetSize, ffi.Pointer<DartObj> visualDensity, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<DartObj> shape, ffi.Pointer<DartObj> side, ffi.Pointer<ffi.Int> isError, ffi.Pointer<ffi.Int> enabled, ffi.Pointer<DartObj> tileColor, ffi.Pointer<DartObj> title, ffi.Pointer<DartObj> subtitle, ffi.Pointer<ffi.Int> isThreeLine, ffi.Pointer<ffi.Int> dense, ffi.Pointer<DartObj> secondary, ffi.Pointer<ffi.Int> selected, ffi.Pointer<ffi.Int> controlAffinity, ffi.Pointer<DartObj> contentPadding, ffi.Pointer<ffi.Int> tristate, ffi.Pointer<DartObj> checkboxShape, ffi.Pointer<DartObj> selectedTileColor, ffi.Pointer<ValueChangedForBoolFFI> onFocusChange, ffi.Pointer<ffi.Int> enableFeedback, ffi.Pointer<ffi.Char> checkboxSemanticLabel, ffi.Pointer<ffi.Double> checkboxScaleFactor, ffi.Pointer<ffi.Int> titleAlignment, ffi.Pointer<ffi.Int> internalAddSemanticForOnTap) {
  final w = CheckboxListTile.adaptive(value: value.toBool(),
      onChanged: onChanged.toValueChangedForBoolOptFn(),
      activeColor: activeColor.objOrNul(),
      fillColor: _wspNul<Color?>(fillColor.objOrNul()),
      checkColor: checkColor.objOrNul(),
      hoverColor: hoverColor.objOrNul(),
      overlayColor: _wspNul<Color?>(overlayColor.objOrNul()),
      splashRadius: splashRadius.doubleOrNul(),
      materialTapTargetSize: materialTapTargetSize.enumOrNul(MaterialTapTargetSize.values),
      visualDensity: visualDensity.objOrNul(),
      autofocus: autofocus.boolOr(false),
      shape: shape.objOrNul(),
      side: side.objOrNul(),
      isError: isError.boolOr(false),
      enabled: enabled.boolOrNul(),
      tileColor: tileColor.objOrNul(),
      title: title.objOrNul(),
      subtitle: subtitle.objOrNul(),
      isThreeLine: isThreeLine.boolOrNul(),
      dense: dense.boolOrNul(),
      secondary: secondary.objOrNul(),
      selected: selected.boolOr(false),
      controlAffinity: controlAffinity.enumOrNul(ListTileControlAffinity.values),
      contentPadding: contentPadding.objOrNul(),
      tristate: tristate.boolOr(false),
      checkboxShape: checkboxShape.objOrNul(),
      selectedTileColor: selectedTileColor.objOrNul(),
      onFocusChange: onFocusChange.toValueChangedForBoolFn(),
      enableFeedback: enableFeedback.boolOrNul(),
      checkboxSemanticLabel: checkboxSemanticLabel.strOrNul(),
      checkboxScaleFactor: checkboxScaleFactor.doubleOr(1.0),
      titleAlignment: titleAlignment.enumOrNul(ListTileTitleAlignment.values),
      internalAddSemanticForOnTap: internalAddSemanticForOnTap.boolOr(false));
  return _createCheckboxListTileObjSt(w);
}
CheckboxListTileObjSt _createCheckboxListTileObjSt(CheckboxListTile? w) {
  final CheckboxListTileObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.value = (w.value != null) ? w.value!.toInt() : 0;
  stObj.activeColor = _addWidget(w.activeColor);
  stObj.checkColor = _addWidget(w.checkColor);
  stObj.hoverColor = _addWidget(w.hoverColor);
  stObj.splashRadius = (w.splashRadius != null) ? w.splashRadius! : 0;
  stObj.materialTapTargetSize = (w.materialTapTargetSize != null) ? w.materialTapTargetSize!.index : 0;
  stObj.visualDensity = _createVisualDensityObjSt(w.visualDensity);
  stObj.autofocus = w.autofocus.toInt();
  stObj.shape = _addWidget(w.shape);
  stObj.side = _createBorderSideObjSt(w.side);
  stObj.isError = w.isError.toInt();
  stObj.tileColor = _addWidget(w.tileColor);
  stObj.title = _addWidget(w.title);
  stObj.subtitle = _addWidget(w.subtitle);
  stObj.secondary = _addWidget(w.secondary);
  stObj.isThreeLine = (w.isThreeLine != null) ? w.isThreeLine!.toInt() : 0;
  stObj.dense = (w.dense != null) ? w.dense!.toInt() : 0;
  stObj.selected = w.selected.toInt();
  stObj.controlAffinity = (w.controlAffinity != null) ? w.controlAffinity!.index : 0;
  stObj.contentPadding = _addWidget(w.contentPadding);
  stObj.tristate = w.tristate.toInt();
  stObj.checkboxShape = _addWidget(w.checkboxShape);
  stObj.selectedTileColor = _addWidget(w.selectedTileColor);
  stObj.enableFeedback = (w.enableFeedback != null) ? w.enableFeedback!.toInt() : 0;
  stObj.enabled = (w.enabled != null) ? w.enabled!.toInt() : 0;
  stObj.titleAlignment = (w.titleAlignment != null) ? w.titleAlignment!.index : 0;
  stObj.internalAddSemanticForOnTap = w.internalAddSemanticForOnTap.toInt();
  stObj.checkboxScaleFactor = w.checkboxScaleFactor;
  stObj.checkboxSemanticLabel = (w.checkboxSemanticLabel != null) ? w.checkboxSemanticLabel!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  return stObj;
}

void _setupSwitchListTile(WidgetFactories f) {
  f.switchListTile.switchListTile = ffi.Pointer.fromFunction(switchListTileSwitchListTile);
  f.switchListTile.adaptive = ffi.Pointer.fromFunction(switchListTileAdaptive);
}
SwitchListTileObjSt switchListTileSwitchListTile(int value, ValueChangedForBoolFFI onChanged, ffi.Pointer<DartObj> activeColor, ffi.Pointer<DartObj> activeThumbColor, ffi.Pointer<DartObj> activeTrackColor, ffi.Pointer<DartObj> inactiveThumbColor, ffi.Pointer<DartObj> inactiveTrackColor, ffi.Pointer<DartObj> thumbColor, ffi.Pointer<DartObj> trackColor, ffi.Pointer<DartObj> trackOutlineColor, ffi.Pointer<DartObj> thumbIcon, ffi.Pointer<ffi.Int> materialTapTargetSize, ffi.Pointer<ffi.Int> dragStartBehavior, ffi.Pointer<DartObj> overlayColor, ffi.Pointer<ffi.Double> splashRadius, ffi.Pointer<ValueChangedForBoolFFI> onFocusChange, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<DartObj> tileColor, ffi.Pointer<DartObj> title, ffi.Pointer<DartObj> subtitle, ffi.Pointer<ffi.Int> isThreeLine, ffi.Pointer<ffi.Int> dense, ffi.Pointer<DartObj> contentPadding, ffi.Pointer<DartObj> secondary, ffi.Pointer<ffi.Int> selected, ffi.Pointer<ffi.Int> controlAffinity, ffi.Pointer<DartObj> shape, ffi.Pointer<DartObj> selectedTileColor, ffi.Pointer<DartObj> visualDensity, ffi.Pointer<ffi.Int> enableFeedback, ffi.Pointer<DartObj> hoverColor, ffi.Pointer<ffi.Int> internalAddSemanticForOnTap) {
  final w = SwitchListTile(value: value.toBool(),
      onChanged: onChanged.toValueChangedForBoolFn(),
      activeColor: activeColor.objOrNul(),
      activeThumbColor: activeThumbColor.objOrNul(),
      activeTrackColor: activeTrackColor.objOrNul(),
      inactiveThumbColor: inactiveThumbColor.objOrNul(),
      inactiveTrackColor: inactiveTrackColor.objOrNul(),
      thumbColor: _wspNul<Color?>(thumbColor.objOrNul()),
      trackColor: _wspNul<Color?>(trackColor.objOrNul()),
      trackOutlineColor: _wspNul<Color?>(trackOutlineColor.objOrNul()),
      thumbIcon: _wspNul<Icon?>(thumbIcon.objOrNul()),
      materialTapTargetSize: materialTapTargetSize.enumOrNul(MaterialTapTargetSize.values),
      dragStartBehavior: dragStartBehavior.enumOr(DragStartBehavior.values, DragStartBehavior.start),
      overlayColor: _wspNul<Color?>(overlayColor.objOrNul()),
      splashRadius: splashRadius.doubleOrNul(),
      onFocusChange: onFocusChange.toValueChangedForBoolFn(),
      autofocus: autofocus.boolOr(false),
      tileColor: tileColor.objOrNul(),
      title: title.objOrNul(),
      subtitle: subtitle.objOrNul(),
      isThreeLine: isThreeLine.boolOrNul(),
      dense: dense.boolOrNul(),
      contentPadding: contentPadding.objOrNul(),
      secondary: secondary.objOrNul(),
      selected: selected.boolOr(false),
      controlAffinity: controlAffinity.enumOrNul(ListTileControlAffinity.values),
      shape: shape.objOrNul(),
      selectedTileColor: selectedTileColor.objOrNul(),
      visualDensity: visualDensity.objOrNul(),
      enableFeedback: enableFeedback.boolOrNul(),
      hoverColor: hoverColor.objOrNul(),
      internalAddSemanticForOnTap: internalAddSemanticForOnTap.boolOr(false));
  return _createSwitchListTileObjSt(w);
}
SwitchListTileObjSt switchListTileAdaptive(int value, ValueChangedForBoolFFI onChanged, ffi.Pointer<DartObj> activeColor, ffi.Pointer<DartObj> activeThumbColor, ffi.Pointer<DartObj> activeTrackColor, ffi.Pointer<DartObj> inactiveThumbColor, ffi.Pointer<DartObj> inactiveTrackColor, ffi.Pointer<DartObj> thumbColor, ffi.Pointer<DartObj> trackColor, ffi.Pointer<DartObj> trackOutlineColor, ffi.Pointer<DartObj> thumbIcon, ffi.Pointer<ffi.Int> materialTapTargetSize, ffi.Pointer<ffi.Int> dragStartBehavior, ffi.Pointer<DartObj> overlayColor, ffi.Pointer<ffi.Double> splashRadius, ffi.Pointer<ValueChangedForBoolFFI> onFocusChange, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<ffi.Int> applyCupertinoTheme, ffi.Pointer<DartObj> tileColor, ffi.Pointer<DartObj> title, ffi.Pointer<DartObj> subtitle, ffi.Pointer<ffi.Int> isThreeLine, ffi.Pointer<ffi.Int> dense, ffi.Pointer<DartObj> contentPadding, ffi.Pointer<DartObj> secondary, ffi.Pointer<ffi.Int> selected, ffi.Pointer<ffi.Int> controlAffinity, ffi.Pointer<DartObj> shape, ffi.Pointer<DartObj> selectedTileColor, ffi.Pointer<DartObj> visualDensity, ffi.Pointer<ffi.Int> enableFeedback, ffi.Pointer<DartObj> hoverColor, ffi.Pointer<ffi.Int> internalAddSemanticForOnTap) {
  final w = SwitchListTile.adaptive(value: value.toBool(),
      onChanged: onChanged.toValueChangedForBoolFn(),
      activeColor: activeColor.objOrNul(),
      activeThumbColor: activeThumbColor.objOrNul(),
      activeTrackColor: activeTrackColor.objOrNul(),
      inactiveThumbColor: inactiveThumbColor.objOrNul(),
      inactiveTrackColor: inactiveTrackColor.objOrNul(),
      thumbColor: _wspNul<Color?>(thumbColor.objOrNul()),
      trackColor: _wspNul<Color?>(trackColor.objOrNul()),
      trackOutlineColor: _wspNul<Color?>(trackOutlineColor.objOrNul()),
      thumbIcon: _wspNul<Icon?>(thumbIcon.objOrNul()),
      materialTapTargetSize: materialTapTargetSize.enumOrNul(MaterialTapTargetSize.values),
      dragStartBehavior: dragStartBehavior.enumOr(DragStartBehavior.values, DragStartBehavior.start),
      overlayColor: _wspNul<Color?>(overlayColor.objOrNul()),
      splashRadius: splashRadius.doubleOrNul(),
      onFocusChange: onFocusChange.toValueChangedForBoolFn(),
      autofocus: autofocus.boolOr(false),
      applyCupertinoTheme: applyCupertinoTheme.boolOrNul(),
      tileColor: tileColor.objOrNul(),
      title: title.objOrNul(),
      subtitle: subtitle.objOrNul(),
      isThreeLine: isThreeLine.boolOrNul(),
      dense: dense.boolOrNul(),
      contentPadding: contentPadding.objOrNul(),
      secondary: secondary.objOrNul(),
      selected: selected.boolOr(false),
      controlAffinity: controlAffinity.enumOrNul(ListTileControlAffinity.values),
      shape: shape.objOrNul(),
      selectedTileColor: selectedTileColor.objOrNul(),
      visualDensity: visualDensity.objOrNul(),
      enableFeedback: enableFeedback.boolOrNul(),
      hoverColor: hoverColor.objOrNul(),
      internalAddSemanticForOnTap: internalAddSemanticForOnTap.boolOr(false));
  return _createSwitchListTileObjSt(w);
}
SwitchListTileObjSt _createSwitchListTileObjSt(SwitchListTile? w) {
  final SwitchListTileObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.value = w.value.toInt();
  stObj.activeColor = _addWidget(w.activeColor);
  stObj.activeThumbColor = _addWidget(w.activeThumbColor);
  stObj.activeTrackColor = _addWidget(w.activeTrackColor);
  stObj.inactiveThumbColor = _addWidget(w.inactiveThumbColor);
  stObj.inactiveTrackColor = _addWidget(w.inactiveTrackColor);
  stObj.materialTapTargetSize = (w.materialTapTargetSize != null) ? w.materialTapTargetSize!.index : 0;
  stObj.dragStartBehavior = w.dragStartBehavior.index;
  stObj.splashRadius = (w.splashRadius != null) ? w.splashRadius! : 0;
  stObj.autofocus = w.autofocus.toInt();
  stObj.tileColor = _addWidget(w.tileColor);
  stObj.title = _addWidget(w.title);
  stObj.subtitle = _addWidget(w.subtitle);
  stObj.secondary = _addWidget(w.secondary);
  stObj.isThreeLine = (w.isThreeLine != null) ? w.isThreeLine!.toInt() : 0;
  stObj.dense = (w.dense != null) ? w.dense!.toInt() : 0;
  stObj.contentPadding = _addWidget(w.contentPadding);
  stObj.selected = w.selected.toInt();
  stObj.controlAffinity = (w.controlAffinity != null) ? w.controlAffinity!.index : 0;
  stObj.shape = _addWidget(w.shape);
  stObj.selectedTileColor = _addWidget(w.selectedTileColor);
  stObj.visualDensity = _createVisualDensityObjSt(w.visualDensity);
  stObj.enableFeedback = (w.enableFeedback != null) ? w.enableFeedback!.toInt() : 0;
  stObj.hoverColor = _addWidget(w.hoverColor);
  stObj.applyCupertinoTheme = (w.applyCupertinoTheme != null) ? w.applyCupertinoTheme!.toInt() : 0;
  stObj.internalAddSemanticForOnTap = w.internalAddSemanticForOnTap.toInt();
  return stObj;
}

void _setupBadge(WidgetFactories f) {
  f.badge.badge = ffi.Pointer.fromFunction(badgeBadge);
  f.badge.count = ffi.Pointer.fromFunction(badgeCount);
}
BadgeObjSt badgeBadge(ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<DartObj> textColor, ffi.Pointer<ffi.Double> smallSize, ffi.Pointer<ffi.Double> largeSize, ffi.Pointer<DartObj> textStyle, ffi.Pointer<DartObj> padding, ffi.Pointer<DartObj> alignment, ffi.Pointer<DartObj> offset, ffi.Pointer<DartObj> label, ffi.Pointer<ffi.Int> isLabelVisible, ffi.Pointer<DartObj> child) {
  final w = Badge(backgroundColor: backgroundColor.objOrNul(),
      textColor: textColor.objOrNul(),
      smallSize: smallSize.doubleOrNul(),
      largeSize: largeSize.doubleOrNul(),
      textStyle: textStyle.objOrNul(),
      padding: padding.objOrNul(),
      alignment: alignment.objOrNul(),
      offset: offset.objOrNul(),
      label: label.objOrNul(),
      isLabelVisible: isLabelVisible.boolOr(true),
      child: child.objOrNul());
  return _createBadgeObjSt(w);
}
BadgeObjSt badgeCount(ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<DartObj> textColor, ffi.Pointer<ffi.Double> smallSize, ffi.Pointer<ffi.Double> largeSize, ffi.Pointer<DartObj> textStyle, ffi.Pointer<DartObj> padding, ffi.Pointer<DartObj> alignment, ffi.Pointer<DartObj> offset, int count, ffi.Pointer<ffi.Int> isLabelVisible, ffi.Pointer<DartObj> child) {
  final w = Badge.count(backgroundColor: backgroundColor.objOrNul(),
      textColor: textColor.objOrNul(),
      smallSize: smallSize.doubleOrNul(),
      largeSize: largeSize.doubleOrNul(),
      textStyle: textStyle.objOrNul(),
      padding: padding.objOrNul(),
      alignment: alignment.objOrNul(),
      offset: offset.objOrNul(),
      count: count,
      isLabelVisible: isLabelVisible.boolOr(true),
      child: child.objOrNul());
  return _createBadgeObjSt(w);
}
BadgeObjSt _createBadgeObjSt(Badge? w) {
  final BadgeObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.backgroundColor = _addWidget(w.backgroundColor);
  stObj.textColor = _addWidget(w.textColor);
  stObj.smallSize = (w.smallSize != null) ? w.smallSize! : 0;
  stObj.largeSize = (w.largeSize != null) ? w.largeSize! : 0;
  stObj.textStyle = _createTextStyleObjSt(w.textStyle);
  stObj.padding = _addWidget(w.padding);
  stObj.alignment = _addWidget(w.alignment);
  stObj.offset = _addWidget(w.offset);
  stObj.label = _addWidget(w.label);
  stObj.isLabelVisible = w.isLabelVisible.toInt();
  stObj.child = _addWidget(w.child);
  return stObj;
}

void _setupSelectableText(WidgetFactories f) {
  f.selectableText.selectableText = ffi.Pointer.fromFunction(selectableTextSelectableText);
  f.selectableText.rich = ffi.Pointer.fromFunction(selectableTextRich);
}
SelectableTextObjSt selectableTextSelectableText(ffi.Pointer<ffi.Char> data, ffi.Pointer<DartObj> style, ffi.Pointer<ffi.Int> textAlign, ffi.Pointer<ffi.Int> textDirection, ffi.Pointer<ffi.Double> textScaleFactor, ffi.Pointer<ffi.Int> showCursor, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<ffi.Int> minLines, ffi.Pointer<ffi.Int> maxLines, ffi.Pointer<ffi.Double> cursorWidth, ffi.Pointer<ffi.Double> cursorHeight, ffi.Pointer<DartObj> cursorRadius, ffi.Pointer<DartObj> cursorColor, ffi.Pointer<DartObj> selectionColor, ffi.Pointer<ffi.Int> selectionHeightStyle, ffi.Pointer<ffi.Int> selectionWidthStyle, ffi.Pointer<ffi.Int> dragStartBehavior, ffi.Pointer<ffi.Int> enableInteractiveSelection, ffi.Pointer<GestureTapCallbackFFI> onTap, ffi.Pointer<ffi.Char> semanticsLabel, ffi.Pointer<ffi.Int> textWidthBasis) {
  final w = SelectableText(data.cast<Utf8>().toDartString(),
      style: style.objOrNul(),
      textAlign: textAlign.enumOrNul(TextAlign.values),
      textDirection: textDirection.enumOrNul(TextDirection.values),
      textScaleFactor: textScaleFactor.doubleOrNul(),
      showCursor: showCursor.boolOr(false),
      autofocus: autofocus.boolOr(false),
      minLines: minLines.intOrNul(),
      maxLines: maxLines.intOrNul(),
      cursorWidth: cursorWidth.doubleOr(2.0),
      cursorHeight: cursorHeight.doubleOrNul(),
      cursorRadius: cursorRadius.objOrNul(),
      cursorColor: cursorColor.objOrNul(),
      selectionColor: selectionColor.objOrNul(),
      selectionHeightStyle: selectionHeightStyle.enumOrNul(BoxHeightStyle.values),
      selectionWidthStyle: selectionWidthStyle.enumOrNul(BoxWidthStyle.values),
      dragStartBehavior: dragStartBehavior.enumOr(DragStartBehavior.values, DragStartBehavior.start),
      enableInteractiveSelection: enableInteractiveSelection.boolOr(true),
      onTap: onTap.toGestureTapCallbackFn(),
      semanticsLabel: semanticsLabel.strOrNul(),
      textWidthBasis: textWidthBasis.enumOrNul(TextWidthBasis.values));
  return _createSelectableTextObjSt(w);
}
SelectableTextObjSt selectableTextRich(DartDartObj textSpan, ffi.Pointer<DartObj> style, ffi.Pointer<ffi.Int> textAlign, ffi.Pointer<ffi.Int> textDirection, ffi.Pointer<ffi.Double> textScaleFactor, ffi.Pointer<ffi.Int> showCursor, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<ffi.Int> minLines, ffi.Pointer<ffi.Int> maxLines, ffi.Pointer<ffi.Double> cursorWidth, ffi.Pointer<ffi.Double> cursorHeight, ffi.Pointer<DartObj> cursorRadius, ffi.Pointer<DartObj> cursorColor, ffi.Pointer<DartObj> selectionColor, ffi.Pointer<ffi.Int> selectionHeightStyle, ffi.Pointer<ffi.Int> selectionWidthStyle, ffi.Pointer<ffi.Int> dragStartBehavior, ffi.Pointer<ffi.Int> enableInteractiveSelection, ffi.Pointer<GestureTapCallbackFFI> onTap, ffi.Pointer<ffi.Char> semanticsLabel, ffi.Pointer<ffi.Int> textWidthBasis) {
  final w = SelectableText.rich(_widgetsMap[textSpan]! as TextSpan,
      style: style.objOrNul(),
      textAlign: textAlign.enumOrNul(TextAlign.values),
      textDirection: textDirection.enumOrNul(TextDirection.values),
      textScaleFactor: textScaleFactor.doubleOrNul(),
      showCursor: showCursor.boolOr(false),
      autofocus: autofocus.boolOr(false),
      minLines: minLines.intOrNul(),
      maxLines: maxLines.intOrNul(),
      cursorWidth: cursorWidth.doubleOr(2.0),
      cursorHeight: cursorHeight.doubleOrNul(),
      cursorRadius: cursorRadius.objOrNul(),
      cursorColor: cursorColor.objOrNul(),
      selectionColor: selectionColor.objOrNul(),
      selectionHeightStyle: selectionHeightStyle.enumOrNul(BoxHeightStyle.values),
      selectionWidthStyle: selectionWidthStyle.enumOrNul(BoxWidthStyle.values),
      dragStartBehavior: dragStartBehavior.enumOr(DragStartBehavior.values, DragStartBehavior.start),
      enableInteractiveSelection: enableInteractiveSelection.boolOr(true),
      onTap: onTap.toGestureTapCallbackFn(),
      semanticsLabel: semanticsLabel.strOrNul(),
      textWidthBasis: textWidthBasis.enumOrNul(TextWidthBasis.values));
  return _createSelectableTextObjSt(w);
}
SelectableTextObjSt _createSelectableTextObjSt(SelectableText? w) {
  final SelectableTextObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.data = (w.data != null) ? w.data!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.textSpan = _createTextSpanObjSt(w.textSpan);
  stObj.style = _createTextStyleObjSt(w.style);
  stObj.textAlign = (w.textAlign != null) ? w.textAlign!.index : 0;
  stObj.textDirection = (w.textDirection != null) ? w.textDirection!.index : 0;
  stObj.textScaleFactor = (w.textScaleFactor != null) ? w.textScaleFactor! : 0;
  stObj.autofocus = w.autofocus.toInt();
  stObj.minLines = (w.minLines != null) ? w.minLines! : 0;
  stObj.maxLines = (w.maxLines != null) ? w.maxLines! : 0;
  stObj.showCursor = w.showCursor.toInt();
  stObj.cursorWidth = w.cursorWidth;
  stObj.cursorHeight = (w.cursorHeight != null) ? w.cursorHeight! : 0;
  stObj.cursorRadius = _addWidget(w.cursorRadius);
  stObj.cursorColor = _addWidget(w.cursorColor);
  stObj.selectionColor = _addWidget(w.selectionColor);
  stObj.selectionHeightStyle = (w.selectionHeightStyle != null) ? w.selectionHeightStyle!.index : 0;
  stObj.selectionWidthStyle = (w.selectionWidthStyle != null) ? w.selectionWidthStyle!.index : 0;
  stObj.enableInteractiveSelection = w.enableInteractiveSelection.toInt();
  stObj.dragStartBehavior = w.dragStartBehavior.index;
  stObj.semanticsLabel = (w.semanticsLabel != null) ? w.semanticsLabel!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.textWidthBasis = (w.textWidthBasis != null) ? w.textWidthBasis!.index : 0;
  stObj.selectionEnabled = w.selectionEnabled.toInt();
  return stObj;
}

void _setupInkWell(WidgetFactories f) {
  f.inkWell.inkWell = ffi.Pointer.fromFunction(inkWellInkWell);
}
InkWellObjSt inkWellInkWell(ffi.Pointer<DartObj> child, ffi.Pointer<GestureTapCallbackFFI> onTap, ffi.Pointer<GestureTapCallbackFFI> onDoubleTap, ffi.Pointer<GestureLongPressCallbackFFI> onLongPress, ffi.Pointer<GestureTapDownCallbackFFI> onTapDown, ffi.Pointer<GestureTapUpCallbackFFI> onTapUp, ffi.Pointer<GestureTapCallbackFFI> onTapCancel, ffi.Pointer<GestureTapCallbackFFI> onSecondaryTap, ffi.Pointer<GestureTapUpCallbackFFI> onSecondaryTapUp, ffi.Pointer<GestureTapDownCallbackFFI> onSecondaryTapDown, ffi.Pointer<GestureTapCallbackFFI> onSecondaryTapCancel, ffi.Pointer<ValueChangedForBoolFFI> onHighlightChanged, ffi.Pointer<ValueChangedForBoolFFI> onHover, ffi.Pointer<DartObj> focusColor, ffi.Pointer<DartObj> hoverColor, ffi.Pointer<DartObj> highlightColor, ffi.Pointer<DartObj> overlayColor, ffi.Pointer<DartObj> splashColor, ffi.Pointer<ffi.Double> radius, ffi.Pointer<DartObj> borderRadius, ffi.Pointer<DartObj> customBorder, ffi.Pointer<ffi.Int> enableFeedback, ffi.Pointer<ffi.Int> excludeFromSemantics, ffi.Pointer<ffi.Int> canRequestFocus, ffi.Pointer<ValueChangedForBoolFFI> onFocusChange, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<DartObj> hoverDuration) {
  final w = InkWell(child: child.objOrNul(),
      onTap: onTap.toGestureTapCallbackFn(),
      onDoubleTap: onDoubleTap.toGestureTapCallbackFn(),
      onLongPress: onLongPress.toGestureLongPressCallbackFn(),
      onTapDown: onTapDown.toGestureTapDownCallbackFn(),
      onTapUp: onTapUp.toGestureTapUpCallbackFn(),
      onTapCancel: onTapCancel.toGestureTapCallbackFn(),
      onSecondaryTap: onSecondaryTap.toGestureTapCallbackFn(),
      onSecondaryTapUp: onSecondaryTapUp.toGestureTapUpCallbackFn(),
      onSecondaryTapDown: onSecondaryTapDown.toGestureTapDownCallbackFn(),
      onSecondaryTapCancel: onSecondaryTapCancel.toGestureTapCallbackFn(),
      onHighlightChanged: onHighlightChanged.toValueChangedForBoolFn(),
      onHover: onHover.toValueChangedForBoolFn(),
      focusColor: focusColor.objOrNul(),
      hoverColor: hoverColor.objOrNul(),
      highlightColor: highlightColor.objOrNul(),
      overlayColor: _wspNul<Color?>(overlayColor.objOrNul()),
      splashColor: splashColor.objOrNul(),
      radius: radius.doubleOrNul(),
      borderRadius: borderRadius.objOrNul(),
      customBorder: customBorder.objOrNul(),
      enableFeedback: enableFeedback.boolOr(true),
      excludeFromSemantics: excludeFromSemantics.boolOr(false),
      canRequestFocus: canRequestFocus.boolOr(true),
      onFocusChange: onFocusChange.toValueChangedForBoolFn(),
      autofocus: autofocus.boolOr(false),
      hoverDuration: hoverDuration.objOrNul());
  return _createInkWellObjSt(w);
}
InkWellObjSt _createInkWellObjSt(InkWell? w) {
  final InkWellObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  return stObj;
}

void _setupInkResponse(WidgetFactories f) {
  f.inkResponse.inkResponse = ffi.Pointer.fromFunction(inkResponseInkResponse);
}
InkResponseObjSt inkResponseInkResponse(ffi.Pointer<DartObj> child, ffi.Pointer<GestureTapCallbackFFI> onTap, ffi.Pointer<GestureTapDownCallbackFFI> onTapDown, ffi.Pointer<GestureTapUpCallbackFFI> onTapUp, ffi.Pointer<GestureTapCallbackFFI> onTapCancel, ffi.Pointer<GestureTapCallbackFFI> onDoubleTap, ffi.Pointer<GestureLongPressCallbackFFI> onLongPress, ffi.Pointer<GestureTapCallbackFFI> onSecondaryTap, ffi.Pointer<GestureTapUpCallbackFFI> onSecondaryTapUp, ffi.Pointer<GestureTapDownCallbackFFI> onSecondaryTapDown, ffi.Pointer<GestureTapCallbackFFI> onSecondaryTapCancel, ffi.Pointer<ValueChangedForBoolFFI> onHighlightChanged, ffi.Pointer<ValueChangedForBoolFFI> onHover, ffi.Pointer<ffi.Int> containedInkWell, ffi.Pointer<ffi.Int> highlightShape, ffi.Pointer<ffi.Double> radius, ffi.Pointer<DartObj> borderRadius, ffi.Pointer<DartObj> customBorder, ffi.Pointer<DartObj> focusColor, ffi.Pointer<DartObj> hoverColor, ffi.Pointer<DartObj> highlightColor, ffi.Pointer<DartObj> overlayColor, ffi.Pointer<DartObj> splashColor, ffi.Pointer<ffi.Int> enableFeedback, ffi.Pointer<ffi.Int> excludeFromSemantics, ffi.Pointer<ffi.Int> canRequestFocus, ffi.Pointer<ValueChangedForBoolFFI> onFocusChange, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<DartObj> hoverDuration) {
  final w = InkResponse(child: child.objOrNul(),
      onTap: onTap.toGestureTapCallbackFn(),
      onTapDown: onTapDown.toGestureTapDownCallbackFn(),
      onTapUp: onTapUp.toGestureTapUpCallbackFn(),
      onTapCancel: onTapCancel.toGestureTapCallbackFn(),
      onDoubleTap: onDoubleTap.toGestureTapCallbackFn(),
      onLongPress: onLongPress.toGestureLongPressCallbackFn(),
      onSecondaryTap: onSecondaryTap.toGestureTapCallbackFn(),
      onSecondaryTapUp: onSecondaryTapUp.toGestureTapUpCallbackFn(),
      onSecondaryTapDown: onSecondaryTapDown.toGestureTapDownCallbackFn(),
      onSecondaryTapCancel: onSecondaryTapCancel.toGestureTapCallbackFn(),
      onHighlightChanged: onHighlightChanged.toValueChangedForBoolFn(),
      onHover: onHover.toValueChangedForBoolFn(),
      containedInkWell: containedInkWell.boolOr(false),
      highlightShape: highlightShape.enumOr(BoxShape.values, BoxShape.circle),
      radius: radius.doubleOrNul(),
      borderRadius: borderRadius.objOrNul(),
      customBorder: customBorder.objOrNul(),
      focusColor: focusColor.objOrNul(),
      hoverColor: hoverColor.objOrNul(),
      highlightColor: highlightColor.objOrNul(),
      overlayColor: _wspNul<Color?>(overlayColor.objOrNul()),
      splashColor: splashColor.objOrNul(),
      enableFeedback: enableFeedback.boolOr(true),
      excludeFromSemantics: excludeFromSemantics.boolOr(false),
      canRequestFocus: canRequestFocus.boolOr(true),
      onFocusChange: onFocusChange.toValueChangedForBoolFn(),
      autofocus: autofocus.boolOr(false),
      hoverDuration: hoverDuration.objOrNul());
  return _createInkResponseObjSt(w);
}
InkResponseObjSt _createInkResponseObjSt(InkResponse? w) {
  final InkResponseObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.child = _addWidget(w.child);
  stObj.containedInkWell = w.containedInkWell.toInt();
  stObj.highlightShape = w.highlightShape.index;
  stObj.radius = (w.radius != null) ? w.radius! : 0;
  stObj.borderRadius = _createBorderRadiusObjSt(w.borderRadius);
  stObj.customBorder = _addWidget(w.customBorder);
  stObj.focusColor = _addWidget(w.focusColor);
  stObj.hoverColor = _addWidget(w.hoverColor);
  stObj.highlightColor = _addWidget(w.highlightColor);
  stObj.splashColor = _addWidget(w.splashColor);
  stObj.enableFeedback = w.enableFeedback.toInt();
  stObj.excludeFromSemantics = w.excludeFromSemantics.toInt();
  stObj.autofocus = w.autofocus.toInt();
  stObj.canRequestFocus = w.canRequestFocus.toInt();
  stObj.hoverDuration = _addWidget(w.hoverDuration);
  return stObj;
}

void _setupDataTable(WidgetFactories f) {
  f.dataTable.dataTable = ffi.Pointer.fromFunction(dataTableDataTable);
}
DataTableObjSt dataTableDataTable(ArrayC columns, ffi.Pointer<ffi.Int> sortColumnIndex, ffi.Pointer<ffi.Int> sortAscending, ffi.Pointer<ValueSetterForBoolOptFFI> onSelectAll, ffi.Pointer<DartObj> decoration, ffi.Pointer<DartObj> dataRowColor, ffi.Pointer<ffi.Double> dataRowHeight, ffi.Pointer<ffi.Double> dataRowMinHeight, ffi.Pointer<ffi.Double> dataRowMaxHeight, ffi.Pointer<DartObj> dataTextStyle, ffi.Pointer<DartObj> headingRowColor, ffi.Pointer<ffi.Double> headingRowHeight, ffi.Pointer<DartObj> headingTextStyle, ffi.Pointer<ffi.Double> horizontalMargin, ffi.Pointer<ffi.Double> columnSpacing, ffi.Pointer<ffi.Int> showCheckboxColumn, ffi.Pointer<ffi.Int> showBottomBorder, ffi.Pointer<ffi.Double> dividerThickness, ArrayC rows, ffi.Pointer<ffi.Double> checkboxHorizontalMargin, ffi.Pointer<ffi.Int> clipBehavior) {
  final w = DataTable(columns: columns.listOrEmpty(),
      sortColumnIndex: sortColumnIndex.intOrNul(),
      sortAscending: sortAscending.boolOr(true),
      onSelectAll: onSelectAll.toValueSetterForBoolOptFn(),
      decoration: decoration.objOrNul(),
      dataRowColor: _wspNul<Color?>(dataRowColor.objOrNul()),
      dataRowHeight: dataRowHeight.doubleOrNul(),
      dataRowMinHeight: dataRowMinHeight.doubleOrNul(),
      dataRowMaxHeight: dataRowMaxHeight.doubleOrNul(),
      dataTextStyle: dataTextStyle.objOrNul(),
      headingRowColor: _wspNul<Color?>(headingRowColor.objOrNul()),
      headingRowHeight: headingRowHeight.doubleOrNul(),
      headingTextStyle: headingTextStyle.objOrNul(),
      horizontalMargin: horizontalMargin.doubleOrNul(),
      columnSpacing: columnSpacing.doubleOrNul(),
      showCheckboxColumn: showCheckboxColumn.boolOr(true),
      showBottomBorder: showBottomBorder.boolOr(false),
      dividerThickness: dividerThickness.doubleOrNul(),
      rows: rows.listOrEmpty(),
      checkboxHorizontalMargin: checkboxHorizontalMargin.doubleOrNul(),
      clipBehavior: clipBehavior.enumOr(Clip.values, Clip.none));
  return _createDataTableObjSt(w);
}
DataTableObjSt _createDataTableObjSt(DataTable? w) {
  final DataTableObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.sortColumnIndex = (w.sortColumnIndex != null) ? w.sortColumnIndex! : 0;
  stObj.sortAscending = w.sortAscending.toInt();
  stObj.decoration = _addWidget(w.decoration);
  stObj.dataRowMinHeight = (w.dataRowMinHeight != null) ? w.dataRowMinHeight! : 0;
  stObj.dataRowMaxHeight = (w.dataRowMaxHeight != null) ? w.dataRowMaxHeight! : 0;
  stObj.dataTextStyle = _createTextStyleObjSt(w.dataTextStyle);
  stObj.headingRowHeight = (w.headingRowHeight != null) ? w.headingRowHeight! : 0;
  stObj.headingTextStyle = _createTextStyleObjSt(w.headingTextStyle);
  stObj.horizontalMargin = (w.horizontalMargin != null) ? w.horizontalMargin! : 0;
  stObj.columnSpacing = (w.columnSpacing != null) ? w.columnSpacing! : 0;
  stObj.showCheckboxColumn = w.showCheckboxColumn.toInt();
  stObj.dividerThickness = (w.dividerThickness != null) ? w.dividerThickness! : 0;
  stObj.showBottomBorder = w.showBottomBorder.toInt();
  stObj.checkboxHorizontalMargin = (w.checkboxHorizontalMargin != null) ? w.checkboxHorizontalMargin! : 0;
  stObj.clipBehavior = w.clipBehavior.index;
  stObj.dataRowHeight = (w.dataRowHeight != null) ? w.dataRowHeight! : 0;
  return stObj;
}

void _setupDataColumn(WidgetFactories f) {
  f.dataColumn.dataColumn = ffi.Pointer.fromFunction(dataColumnDataColumn);
}
DataColumnObjSt dataColumnDataColumn(DartDartObj label, ffi.Pointer<ffi.Char> tooltip, ffi.Pointer<ffi.Int> numeric, ffi.Pointer<DataColumnSortCallbackFFI> onSort, ffi.Pointer<ffi.Int> headingRowAlignment) {
  final w = DataColumn(label: _widgetsMap[label]! as Widget,
      tooltip: tooltip.strOrNul(),
      numeric: numeric.boolOr(false),
      onSort: onSort.toDataColumnSortCallbackFn(),
      headingRowAlignment: headingRowAlignment.enumOrNul(MainAxisAlignment.values));
  return _createDataColumnObjSt(w);
}
DataColumnObjSt _createDataColumnObjSt(DataColumn? w) {
  final DataColumnObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.label = _addWidget(w.label);
  stObj.tooltip = (w.tooltip != null) ? w.tooltip!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.numeric = w.numeric.toInt();
  stObj.headingRowAlignment = (w.headingRowAlignment != null) ? w.headingRowAlignment!.index : 0;
  return stObj;
}

void _setupDataRow(WidgetFactories f) {
  f.dataRow.dataRow = ffi.Pointer.fromFunction(dataRowDataRow);
  f.dataRow.byIndex = ffi.Pointer.fromFunction(dataRowByIndex);
}
DataRowObjSt dataRowDataRow(ffi.Pointer<ffi.Int> selected, ffi.Pointer<ValueChangedForBoolOptFFI> onSelectChanged, ffi.Pointer<GestureLongPressCallbackFFI> onLongPress, ffi.Pointer<DartObj> color, ArrayC cells) {
  final w = DataRow(selected: selected.boolOr(false),
      onSelectChanged: onSelectChanged.toValueChangedForBoolOptFn(),
      onLongPress: onLongPress.toGestureLongPressCallbackFn(),
      color: _wspNul<Color?>(color.objOrNul()),
      cells: cells.listOrEmpty());
  return _createDataRowObjSt(w);
}
DataRowObjSt dataRowByIndex(ffi.Pointer<ffi.Int> index, ffi.Pointer<ffi.Int> selected, ffi.Pointer<ValueChangedForBoolOptFFI> onSelectChanged, ffi.Pointer<GestureLongPressCallbackFFI> onLongPress, ffi.Pointer<DartObj> color, ArrayC cells) {
  final w = DataRow.byIndex(index: index.intOrNul(),
      selected: selected.boolOr(false),
      onSelectChanged: onSelectChanged.toValueChangedForBoolOptFn(),
      onLongPress: onLongPress.toGestureLongPressCallbackFn(),
      color: _wspNul<Color?>(color.objOrNul()),
      cells: cells.listOrEmpty());
  return _createDataRowObjSt(w);
}
DataRowObjSt _createDataRowObjSt(DataRow? w) {
  final DataRowObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.selected = w.selected.toInt();
  return stObj;
}

void _setupDataCell(WidgetFactories f) {
  f.dataCell.dataCell = ffi.Pointer.fromFunction(dataCellDataCell);
}
DataCellObjSt dataCellDataCell(DartDartObj child, ffi.Pointer<ffi.Int> placeholder, ffi.Pointer<ffi.Int> showEditIcon, ffi.Pointer<GestureTapCallbackFFI> onTap, ffi.Pointer<GestureLongPressCallbackFFI> onLongPress, ffi.Pointer<GestureTapDownCallbackFFI> onTapDown, ffi.Pointer<GestureTapCallbackFFI> onDoubleTap, ffi.Pointer<GestureTapCancelCallbackFFI> onTapCancel) {
  final w = DataCell(_widgetsMap[child]! as Widget,
      placeholder: placeholder.boolOr(false),
      showEditIcon: showEditIcon.boolOr(false),
      onTap: onTap.toGestureTapCallbackFn(),
      onLongPress: onLongPress.toGestureLongPressCallbackFn(),
      onTapDown: onTapDown.toGestureTapDownCallbackFn(),
      onDoubleTap: onDoubleTap.toGestureTapCallbackFn(),
      onTapCancel: onTapCancel.toGestureTapCancelCallbackFn());
  return _createDataCellObjSt(w);
}
DataCellObjSt _createDataCellObjSt(DataCell? w) {
  final DataCellObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.child = _addWidget(w.child);
  stObj.placeholder = w.placeholder.toInt();
  stObj.showEditIcon = w.showEditIcon.toInt();
  return stObj;
}

void _setupDropdownMenuEntry(WidgetFactories f) {
  f.dropdownMenuEntry.dropdownMenuEntry = ffi.Pointer.fromFunction(dropdownMenuEntryDropdownMenuEntry, exception);
}
int dropdownMenuEntryDropdownMenuEntry(DartDartObj value, ffi.Pointer<ffi.Char> label, ffi.Pointer<DartObj> labelWidget, ffi.Pointer<DartObj> leadingIcon, ffi.Pointer<DartObj> trailingIcon, ffi.Pointer<ffi.Int> enabled) {
  final w = DropdownMenuEntry(value: value,
      label: label.cast<Utf8>().toDartString(),
      labelWidget: labelWidget.objOrNul(),
      leadingIcon: leadingIcon.objOrNul(),
      trailingIcon: trailingIcon.objOrNul(),
      enabled: enabled.boolOr(true));
  return _addWidget(w);
}

void _setupRadio(WidgetFactories f) {
  f.radio.radio = ffi.Pointer.fromFunction(radioRadio);
  f.radio.adaptive = ffi.Pointer.fromFunction(radioAdaptive);
}
RadioObjSt radioRadio(DartDartObj value, ffi.Pointer<DartObj> groupValue, ffi.Pointer<ValueChangedForTOptFFI> onChanged, ffi.Pointer<ffi.Int> toggleable, ffi.Pointer<DartObj> activeColor, ffi.Pointer<DartObj> fillColor, ffi.Pointer<DartObj> focusColor, ffi.Pointer<DartObj> hoverColor, ffi.Pointer<DartObj> overlayColor, ffi.Pointer<ffi.Double> splashRadius, ffi.Pointer<ffi.Int> materialTapTargetSize, ffi.Pointer<DartObj> visualDensity, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<ffi.Int> enabled, ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<DartObj> side, ffi.Pointer<ffi.Double> innerRadius) {
  final w = Radio(value: value,
      groupValue: groupValue,
      onChanged: onChanged.toValueChangedForTOptFn(),
      toggleable: toggleable.boolOr(false),
      activeColor: activeColor.objOrNul(),
      fillColor: _wspNul<Color?>(fillColor.objOrNul()),
      focusColor: focusColor.objOrNul(),
      hoverColor: hoverColor.objOrNul(),
      overlayColor: _wspNul<Color?>(overlayColor.objOrNul()),
      splashRadius: splashRadius.doubleOrNul(),
      materialTapTargetSize: materialTapTargetSize.enumOrNul(MaterialTapTargetSize.values),
      visualDensity: visualDensity.objOrNul(),
      autofocus: autofocus.boolOr(false),
      enabled: enabled.boolOrNul(),
      backgroundColor: _wspNul<Color?>(backgroundColor.objOrNul()),
      side: side.objOrNul(),
      innerRadius: _wspNul<double?>(innerRadius.doubleOrNul()));
  return _createRadioObjSt(w);
}
RadioObjSt radioAdaptive(DartDartObj value, ffi.Pointer<DartObj> groupValue, ffi.Pointer<ValueChangedForTOptFFI> onChanged, ffi.Pointer<ffi.Int> toggleable, ffi.Pointer<DartObj> activeColor, ffi.Pointer<DartObj> fillColor, ffi.Pointer<DartObj> focusColor, ffi.Pointer<DartObj> hoverColor, ffi.Pointer<DartObj> overlayColor, ffi.Pointer<ffi.Double> splashRadius, ffi.Pointer<ffi.Int> materialTapTargetSize, ffi.Pointer<DartObj> visualDensity, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<ffi.Int> useCupertinoCheckmarkStyle, ffi.Pointer<ffi.Int> enabled, ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<DartObj> side, ffi.Pointer<ffi.Double> innerRadius) {
  final w = Radio.adaptive(value: value,
      groupValue: groupValue,
      onChanged: onChanged.toValueChangedForTOptFn(),
      toggleable: toggleable.boolOr(false),
      activeColor: activeColor.objOrNul(),
      fillColor: _wspNul<Color?>(fillColor.objOrNul()),
      focusColor: focusColor.objOrNul(),
      hoverColor: hoverColor.objOrNul(),
      overlayColor: _wspNul<Color?>(overlayColor.objOrNul()),
      splashRadius: splashRadius.doubleOrNul(),
      materialTapTargetSize: materialTapTargetSize.enumOrNul(MaterialTapTargetSize.values),
      visualDensity: visualDensity.objOrNul(),
      autofocus: autofocus.boolOr(false),
      useCupertinoCheckmarkStyle: useCupertinoCheckmarkStyle.boolOr(false),
      enabled: enabled.boolOrNul(),
      backgroundColor: _wspNul<Color?>(backgroundColor.objOrNul()),
      side: side.objOrNul(),
      innerRadius: _wspNul<double?>(innerRadius.doubleOrNul()));
  return _createRadioObjSt(w);
}
RadioObjSt _createRadioObjSt(Radio? w) {
  final RadioObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.toggleable = w.toggleable.toInt();
  stObj.activeColor = _addWidget(w.activeColor);
  stObj.materialTapTargetSize = (w.materialTapTargetSize != null) ? w.materialTapTargetSize!.index : 0;
  stObj.visualDensity = _createVisualDensityObjSt(w.visualDensity);
  stObj.focusColor = _addWidget(w.focusColor);
  stObj.hoverColor = _addWidget(w.hoverColor);
  stObj.splashRadius = (w.splashRadius != null) ? w.splashRadius! : 0;
  stObj.autofocus = w.autofocus.toInt();
  stObj.useCupertinoCheckmarkStyle = w.useCupertinoCheckmarkStyle.toInt();
  stObj.enabled = (w.enabled != null) ? w.enabled!.toInt() : 0;
  stObj.side = _createBorderSideObjSt(w.side);
  return stObj;
}

void _setupRadioListTile(WidgetFactories f) {
  f.radioListTile.radioListTile = ffi.Pointer.fromFunction(radioListTileRadioListTile);
  f.radioListTile.adaptive = ffi.Pointer.fromFunction(radioListTileAdaptive);
}
RadioListTileObjSt radioListTileRadioListTile(DartDartObj value, ffi.Pointer<DartObj> groupValue, ffi.Pointer<ValueChangedForTOptFFI> onChanged, ffi.Pointer<ffi.Int> toggleable, ffi.Pointer<DartObj> activeColor, ffi.Pointer<DartObj> fillColor, ffi.Pointer<DartObj> hoverColor, ffi.Pointer<DartObj> overlayColor, ffi.Pointer<ffi.Double> splashRadius, ffi.Pointer<ffi.Int> materialTapTargetSize, ffi.Pointer<DartObj> title, ffi.Pointer<DartObj> subtitle, ffi.Pointer<ffi.Int> isThreeLine, ffi.Pointer<ffi.Int> dense, ffi.Pointer<DartObj> secondary, ffi.Pointer<ffi.Int> selected, ffi.Pointer<ffi.Int> controlAffinity, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<DartObj> contentPadding, ffi.Pointer<DartObj> shape, ffi.Pointer<DartObj> tileColor, ffi.Pointer<DartObj> selectedTileColor, ffi.Pointer<DartObj> visualDensity, ffi.Pointer<ValueChangedForBoolFFI> onFocusChange, ffi.Pointer<ffi.Int> enableFeedback, ffi.Pointer<ffi.Double> radioScaleFactor, ffi.Pointer<ffi.Int> titleAlignment, ffi.Pointer<ffi.Int> enabled, ffi.Pointer<ffi.Int> internalAddSemanticForOnTap, ffi.Pointer<DartObj> radioBackgroundColor, ffi.Pointer<DartObj> radioSide) {
  final w = RadioListTile(value: value,
      groupValue: groupValue,
      onChanged: onChanged.toValueChangedForTOptFn(),
      toggleable: toggleable.boolOr(false),
      activeColor: activeColor.objOrNul(),
      fillColor: _wspNul<Color?>(fillColor.objOrNul()),
      hoverColor: hoverColor.objOrNul(),
      overlayColor: _wspNul<Color?>(overlayColor.objOrNul()),
      splashRadius: splashRadius.doubleOrNul(),
      materialTapTargetSize: materialTapTargetSize.enumOrNul(MaterialTapTargetSize.values),
      title: title.objOrNul(),
      subtitle: subtitle.objOrNul(),
      isThreeLine: isThreeLine.boolOrNul(),
      dense: dense.boolOrNul(),
      secondary: secondary.objOrNul(),
      selected: selected.boolOr(false),
      controlAffinity: controlAffinity.enumOrNul(ListTileControlAffinity.values),
      autofocus: autofocus.boolOr(false),
      contentPadding: contentPadding.objOrNul(),
      shape: shape.objOrNul(),
      tileColor: tileColor.objOrNul(),
      selectedTileColor: selectedTileColor.objOrNul(),
      visualDensity: visualDensity.objOrNul(),
      onFocusChange: onFocusChange.toValueChangedForBoolFn(),
      enableFeedback: enableFeedback.boolOrNul(),
      radioScaleFactor: radioScaleFactor.doubleOr(1.0),
      titleAlignment: titleAlignment.enumOrNul(ListTileTitleAlignment.values),
      enabled: enabled.boolOrNul(),
      internalAddSemanticForOnTap: internalAddSemanticForOnTap.boolOr(false),
      radioBackgroundColor: _wspNul<Color?>(radioBackgroundColor.objOrNul()),
      radioSide: radioSide.objOrNul());
  return _createRadioListTileObjSt(w);
}
RadioListTileObjSt radioListTileAdaptive(DartDartObj value, ffi.Pointer<DartObj> groupValue, ffi.Pointer<ValueChangedForTOptFFI> onChanged, ffi.Pointer<ffi.Int> toggleable, ffi.Pointer<DartObj> activeColor, ffi.Pointer<DartObj> fillColor, ffi.Pointer<DartObj> hoverColor, ffi.Pointer<DartObj> overlayColor, ffi.Pointer<ffi.Double> splashRadius, ffi.Pointer<ffi.Int> materialTapTargetSize, ffi.Pointer<DartObj> title, ffi.Pointer<DartObj> subtitle, ffi.Pointer<ffi.Int> isThreeLine, ffi.Pointer<ffi.Int> dense, ffi.Pointer<DartObj> secondary, ffi.Pointer<ffi.Int> selected, ffi.Pointer<ffi.Int> controlAffinity, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<DartObj> contentPadding, ffi.Pointer<DartObj> shape, ffi.Pointer<DartObj> tileColor, ffi.Pointer<DartObj> selectedTileColor, ffi.Pointer<DartObj> visualDensity, ffi.Pointer<ValueChangedForBoolFFI> onFocusChange, ffi.Pointer<ffi.Int> enableFeedback, ffi.Pointer<ffi.Double> radioScaleFactor, ffi.Pointer<ffi.Int> enabled, ffi.Pointer<ffi.Int> useCupertinoCheckmarkStyle, ffi.Pointer<ffi.Int> titleAlignment, ffi.Pointer<ffi.Int> internalAddSemanticForOnTap, ffi.Pointer<DartObj> radioBackgroundColor, ffi.Pointer<DartObj> radioSide) {
  final w = RadioListTile.adaptive(value: value,
      groupValue: groupValue,
      onChanged: onChanged.toValueChangedForTOptFn(),
      toggleable: toggleable.boolOr(false),
      activeColor: activeColor.objOrNul(),
      fillColor: _wspNul<Color?>(fillColor.objOrNul()),
      hoverColor: hoverColor.objOrNul(),
      overlayColor: _wspNul<Color?>(overlayColor.objOrNul()),
      splashRadius: splashRadius.doubleOrNul(),
      materialTapTargetSize: materialTapTargetSize.enumOrNul(MaterialTapTargetSize.values),
      title: title.objOrNul(),
      subtitle: subtitle.objOrNul(),
      isThreeLine: isThreeLine.boolOrNul(),
      dense: dense.boolOrNul(),
      secondary: secondary.objOrNul(),
      selected: selected.boolOr(false),
      controlAffinity: controlAffinity.enumOrNul(ListTileControlAffinity.values),
      autofocus: autofocus.boolOr(false),
      contentPadding: contentPadding.objOrNul(),
      shape: shape.objOrNul(),
      tileColor: tileColor.objOrNul(),
      selectedTileColor: selectedTileColor.objOrNul(),
      visualDensity: visualDensity.objOrNul(),
      onFocusChange: onFocusChange.toValueChangedForBoolFn(),
      enableFeedback: enableFeedback.boolOrNul(),
      radioScaleFactor: radioScaleFactor.doubleOr(1.0),
      enabled: enabled.boolOrNul(),
      useCupertinoCheckmarkStyle: useCupertinoCheckmarkStyle.boolOr(false),
      titleAlignment: titleAlignment.enumOrNul(ListTileTitleAlignment.values),
      internalAddSemanticForOnTap: internalAddSemanticForOnTap.boolOr(false),
      radioBackgroundColor: _wspNul<Color?>(radioBackgroundColor.objOrNul()),
      radioSide: radioSide.objOrNul());
  return _createRadioListTileObjSt(w);
}
RadioListTileObjSt _createRadioListTileObjSt(RadioListTile? w) {
  final RadioListTileObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.toggleable = w.toggleable.toInt();
  stObj.activeColor = _addWidget(w.activeColor);
  stObj.materialTapTargetSize = (w.materialTapTargetSize != null) ? w.materialTapTargetSize!.index : 0;
  stObj.hoverColor = _addWidget(w.hoverColor);
  stObj.splashRadius = (w.splashRadius != null) ? w.splashRadius! : 0;
  stObj.title = _addWidget(w.title);
  stObj.subtitle = _addWidget(w.subtitle);
  stObj.secondary = _addWidget(w.secondary);
  stObj.isThreeLine = (w.isThreeLine != null) ? w.isThreeLine!.toInt() : 0;
  stObj.dense = (w.dense != null) ? w.dense!.toInt() : 0;
  stObj.selected = w.selected.toInt();
  stObj.controlAffinity = (w.controlAffinity != null) ? w.controlAffinity!.index : 0;
  stObj.autofocus = w.autofocus.toInt();
  stObj.contentPadding = _addWidget(w.contentPadding);
  stObj.shape = _addWidget(w.shape);
  stObj.tileColor = _addWidget(w.tileColor);
  stObj.selectedTileColor = _addWidget(w.selectedTileColor);
  stObj.visualDensity = _createVisualDensityObjSt(w.visualDensity);
  stObj.enableFeedback = (w.enableFeedback != null) ? w.enableFeedback!.toInt() : 0;
  stObj.titleAlignment = (w.titleAlignment != null) ? w.titleAlignment!.index : 0;
  stObj.internalAddSemanticForOnTap = w.internalAddSemanticForOnTap.toInt();
  stObj.useCupertinoCheckmarkStyle = w.useCupertinoCheckmarkStyle.toInt();
  stObj.radioScaleFactor = w.radioScaleFactor;
  stObj.enabled = (w.enabled != null) ? w.enabled!.toInt() : 0;
  stObj.radioSide = _createBorderSideObjSt(w.radioSide);
  stObj.checked = w.checked.toInt();
  return stObj;
}

void _setupExpansionTile(WidgetFactories f) {
  f.expansionTile.expansionTile = ffi.Pointer.fromFunction(expansionTileExpansionTile);
}
ExpansionTileObjSt expansionTileExpansionTile(ffi.Pointer<DartObj> leading, DartDartObj title, ffi.Pointer<DartObj> subtitle, ffi.Pointer<ValueChangedForBoolFFI> onExpansionChanged, ffi.Pointer<ArrayC> children, ffi.Pointer<DartObj> trailing, ffi.Pointer<ffi.Int> showTrailingIcon, ffi.Pointer<ffi.Int> initiallyExpanded, ffi.Pointer<ffi.Int> maintainState, ffi.Pointer<DartObj> tilePadding, ffi.Pointer<ffi.Int> expandedCrossAxisAlignment, ffi.Pointer<DartObj> expandedAlignment, ffi.Pointer<DartObj> childrenPadding, ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<DartObj> collapsedBackgroundColor, ffi.Pointer<DartObj> textColor, ffi.Pointer<DartObj> collapsedTextColor, ffi.Pointer<DartObj> iconColor, ffi.Pointer<DartObj> collapsedIconColor, ffi.Pointer<DartObj> shape, ffi.Pointer<DartObj> collapsedShape, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<ffi.Int> controlAffinity, ffi.Pointer<ffi.Int> dense, ffi.Pointer<DartObj> visualDensity, ffi.Pointer<ffi.Double> minTileHeight, ffi.Pointer<ffi.Int> enableFeedback, ffi.Pointer<ffi.Int> enabled, ffi.Pointer<ffi.Int> internalAddSemanticForOnTap) {
  final w = ExpansionTile(leading: leading.objOrNul(),
      title: _widgetsMap[title]! as Widget,
      subtitle: subtitle.objOrNul(),
      onExpansionChanged: onExpansionChanged.toValueChangedForBoolFn(),
      children: children.listOrEmpty(),
      trailing: trailing.objOrNul(),
      showTrailingIcon: showTrailingIcon.boolOr(true),
      initiallyExpanded: initiallyExpanded.boolOr(false),
      maintainState: maintainState.boolOr(false),
      tilePadding: tilePadding.objOrNul(),
      expandedCrossAxisAlignment: expandedCrossAxisAlignment.enumOrNul(CrossAxisAlignment.values),
      expandedAlignment: expandedAlignment.objOrNul(),
      childrenPadding: childrenPadding.objOrNul(),
      backgroundColor: backgroundColor.objOrNul(),
      collapsedBackgroundColor: collapsedBackgroundColor.objOrNul(),
      textColor: textColor.objOrNul(),
      collapsedTextColor: collapsedTextColor.objOrNul(),
      iconColor: iconColor.objOrNul(),
      collapsedIconColor: collapsedIconColor.objOrNul(),
      shape: shape.objOrNul(),
      collapsedShape: collapsedShape.objOrNul(),
      clipBehavior: clipBehavior.enumOrNul(Clip.values),
      controlAffinity: controlAffinity.enumOrNul(ListTileControlAffinity.values),
      dense: dense.boolOrNul(),
      visualDensity: visualDensity.objOrNul(),
      minTileHeight: minTileHeight.doubleOrNul(),
      enableFeedback: enableFeedback.boolOrNul(),
      enabled: enabled.boolOr(true),
      internalAddSemanticForOnTap: internalAddSemanticForOnTap.boolOr(false));
  return _createExpansionTileObjSt(w);
}
ExpansionTileObjSt _createExpansionTileObjSt(ExpansionTile? w) {
  final ExpansionTileObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.leading = _addWidget(w.leading);
  stObj.title = _addWidget(w.title);
  stObj.subtitle = _addWidget(w.subtitle);
  stObj.backgroundColor = _addWidget(w.backgroundColor);
  stObj.collapsedBackgroundColor = _addWidget(w.collapsedBackgroundColor);
  stObj.trailing = _addWidget(w.trailing);
  stObj.showTrailingIcon = w.showTrailingIcon.toInt();
  stObj.initiallyExpanded = w.initiallyExpanded.toInt();
  stObj.maintainState = w.maintainState.toInt();
  stObj.tilePadding = _addWidget(w.tilePadding);
  stObj.expandedAlignment = _createAlignmentObjSt(w.expandedAlignment);
  stObj.expandedCrossAxisAlignment = (w.expandedCrossAxisAlignment != null) ? w.expandedCrossAxisAlignment!.index : 0;
  stObj.childrenPadding = _addWidget(w.childrenPadding);
  stObj.iconColor = _addWidget(w.iconColor);
  stObj.collapsedIconColor = _addWidget(w.collapsedIconColor);
  stObj.textColor = _addWidget(w.textColor);
  stObj.collapsedTextColor = _addWidget(w.collapsedTextColor);
  stObj.shape = _addWidget(w.shape);
  stObj.collapsedShape = _addWidget(w.collapsedShape);
  stObj.clipBehavior = (w.clipBehavior != null) ? w.clipBehavior!.index : 0;
  stObj.controlAffinity = (w.controlAffinity != null) ? w.controlAffinity!.index : 0;
  stObj.dense = (w.dense != null) ? w.dense!.toInt() : 0;
  stObj.visualDensity = _createVisualDensityObjSt(w.visualDensity);
  stObj.minTileHeight = (w.minTileHeight != null) ? w.minTileHeight! : 0;
  stObj.enableFeedback = (w.enableFeedback != null) ? w.enableFeedback!.toInt() : 0;
  stObj.enabled = w.enabled.toInt();
  stObj.internalAddSemanticForOnTap = w.internalAddSemanticForOnTap.toInt();
  return stObj;
}

void _setupExpansionPanel(WidgetFactories f) {
  f.expansionPanel.expansionPanel = ffi.Pointer.fromFunction(expansionPanelExpansionPanel, exception);
}
int expansionPanelExpansionPanel(ExpansionPanelHeaderBuilderFFI headerBuilder, DartDartObj body, ffi.Pointer<ffi.Int> isExpanded, ffi.Pointer<ffi.Int> canTapOnHeader, ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<DartObj> splashColor, ffi.Pointer<DartObj> highlightColor) {
  final w = ExpansionPanel(headerBuilder: headerBuilder.toExpansionPanelHeaderBuilderFn(),
      body: _widgetsMap[body]! as Widget,
      isExpanded: isExpanded.boolOr(false),
      canTapOnHeader: canTapOnHeader.boolOr(false),
      backgroundColor: backgroundColor.objOrNul(),
      splashColor: splashColor.objOrNul(),
      highlightColor: highlightColor.objOrNul());
  return _addWidget(w);
}

void _setupExpansionPanelList(WidgetFactories f) {
  f.expansionPanelList.expansionPanelList = ffi.Pointer.fromFunction(expansionPanelListExpansionPanelList);
  f.expansionPanelList.radio = ffi.Pointer.fromFunction(expansionPanelListRadio);
}
ExpansionPanelListObjSt expansionPanelListExpansionPanelList(ffi.Pointer<ArrayC> children, ffi.Pointer<ExpansionPanelCallbackFFI> expansionCallback, ffi.Pointer<DartObj> animationDuration, ffi.Pointer<DartObj> dividerColor, ffi.Pointer<ffi.Double> elevation, ffi.Pointer<DartObj> expandIconColor, ffi.Pointer<ffi.Double> materialGapSize) {
  final w = ExpansionPanelList(children: children.listOrEmpty(),
      expansionCallback: expansionCallback.toExpansionPanelCallbackFn(),
      animationDuration: animationDuration.objOr(kThemeAnimationDuration),
      dividerColor: dividerColor.objOrNul(),
      elevation: elevation.doubleOr(2),
      expandIconColor: expandIconColor.objOrNul(),
      materialGapSize: materialGapSize.doubleOr(16.0));
  return _createExpansionPanelListObjSt(w);
}
ExpansionPanelListObjSt expansionPanelListRadio(ffi.Pointer<ArrayC> children, ffi.Pointer<ExpansionPanelCallbackFFI> expansionCallback, ffi.Pointer<DartObj> animationDuration, ffi.Pointer<DartObj> initialOpenPanelValue, ffi.Pointer<DartObj> dividerColor, ffi.Pointer<ffi.Double> elevation, ffi.Pointer<DartObj> expandIconColor, ffi.Pointer<ffi.Double> materialGapSize) {
  final w = ExpansionPanelList.radio(children: children.listOrEmpty(),
      expansionCallback: expansionCallback.toExpansionPanelCallbackFn(),
      animationDuration: animationDuration.objOr(kThemeAnimationDuration),
      initialOpenPanelValue: initialOpenPanelValue.objOrNul(),
      dividerColor: dividerColor.objOrNul(),
      elevation: elevation.doubleOr(2),
      expandIconColor: expandIconColor.objOrNul(),
      materialGapSize: materialGapSize.doubleOr(16.0));
  return _createExpansionPanelListObjSt(w);
}
ExpansionPanelListObjSt _createExpansionPanelListObjSt(ExpansionPanelList? w) {
  final ExpansionPanelListObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.animationDuration = _addWidget(w.animationDuration);
  stObj.expandedHeaderPadding = _createEdgeInsetsObjSt(w.expandedHeaderPadding);
  stObj.dividerColor = _addWidget(w.dividerColor);
  stObj.elevation = w.elevation;
  stObj.expandIconColor = _addWidget(w.expandIconColor);
  stObj.materialGapSize = w.materialGapSize;
  return stObj;
}

void _setupExpansionPanelRadio(WidgetFactories f) {
  f.expansionPanelRadio.expansionPanelRadio = ffi.Pointer.fromFunction(expansionPanelRadioExpansionPanelRadio, exception);
}
int expansionPanelRadioExpansionPanelRadio(DartDartObj value, ExpansionPanelHeaderBuilderFFI headerBuilder, DartDartObj body, ffi.Pointer<ffi.Int> canTapOnHeader, ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<DartObj> splashColor, ffi.Pointer<DartObj> highlightColor) {
  final w = ExpansionPanelRadio(value: _widgetsMap[value]! as Object,
      headerBuilder: headerBuilder.toExpansionPanelHeaderBuilderFn(),
      body: _widgetsMap[body]! as Widget,
      canTapOnHeader: canTapOnHeader.boolOr(false),
      backgroundColor: backgroundColor.objOrNul(),
      splashColor: splashColor.objOrNul(),
      highlightColor: highlightColor.objOrNul());
  return _addWidget(w);
}

void _setupNavigationRail(WidgetFactories f) {
  f.navigationRail.navigationRail = ffi.Pointer.fromFunction(navigationRailNavigationRail);
  f.navigationRail.extendedAnimation = ffi.Pointer.fromFunction(navigationRailExtendedAnimation, exception);
}
NavigationRailObjSt navigationRailNavigationRail(ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<ffi.Int> extended, ffi.Pointer<DartObj> leading, ffi.Pointer<DartObj> trailing, ArrayC destinations, int selectedIndex, ffi.Pointer<ValueChangedForIntFFI> onDestinationSelected, ffi.Pointer<ffi.Double> elevation, ffi.Pointer<ffi.Double> groupAlignment, ffi.Pointer<ffi.Int> labelType, ffi.Pointer<DartObj> unselectedLabelTextStyle, ffi.Pointer<DartObj> selectedLabelTextStyle, ffi.Pointer<ffi.Double> minWidth, ffi.Pointer<ffi.Double> minExtendedWidth, ffi.Pointer<ffi.Int> useIndicator, ffi.Pointer<DartObj> indicatorColor, ffi.Pointer<DartObj> indicatorShape, ffi.Pointer<ffi.Int> leadingAtTop, ffi.Pointer<ffi.Int> trailingAtBottom, ffi.Pointer<ffi.Int> scrollable) {
  final w = NavigationRail(backgroundColor: backgroundColor.objOrNul(),
      extended: extended.boolOr(false),
      leading: leading.objOrNul(),
      trailing: trailing.objOrNul(),
      destinations: destinations.listOrEmpty(),
      selectedIndex: selectedIndex,
      onDestinationSelected: onDestinationSelected.toValueChangedForIntFn(),
      elevation: elevation.doubleOrNul(),
      groupAlignment: groupAlignment.doubleOrNul(),
      labelType: labelType.enumOrNul(NavigationRailLabelType.values),
      unselectedLabelTextStyle: unselectedLabelTextStyle.objOrNul(),
      selectedLabelTextStyle: selectedLabelTextStyle.objOrNul(),
      minWidth: minWidth.doubleOrNul(),
      minExtendedWidth: minExtendedWidth.doubleOrNul(),
      useIndicator: useIndicator.boolOrNul(),
      indicatorColor: indicatorColor.objOrNul(),
      indicatorShape: indicatorShape.objOrNul(),
      leadingAtTop: leadingAtTop.boolOr(true),
      trailingAtBottom: trailingAtBottom.boolOr(false),
      scrollable: scrollable.boolOr(false));
  return _createNavigationRailObjSt(w);
}
int navigationRailExtendedAnimation(DartDartObj context) {
  final w = NavigationRail.extendedAnimation(_widgetsMap[context]! as BuildContext);
  return _addWidget(w);
}
NavigationRailObjSt _createNavigationRailObjSt(NavigationRail? w) {
  final NavigationRailObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.backgroundColor = _addWidget(w.backgroundColor);
  stObj.extended = w.extended.toInt();
  stObj.leading = _addWidget(w.leading);
  stObj.trailing = _addWidget(w.trailing);
  stObj.selectedIndex = (w.selectedIndex != null) ? w.selectedIndex! : 0;
  stObj.elevation = (w.elevation != null) ? w.elevation! : 0;
  stObj.groupAlignment = (w.groupAlignment != null) ? w.groupAlignment! : 0;
  stObj.labelType = (w.labelType != null) ? w.labelType!.index : 0;
  stObj.unselectedLabelTextStyle = _createTextStyleObjSt(w.unselectedLabelTextStyle);
  stObj.selectedLabelTextStyle = _createTextStyleObjSt(w.selectedLabelTextStyle);
  stObj.minWidth = (w.minWidth != null) ? w.minWidth! : 0;
  stObj.minExtendedWidth = (w.minExtendedWidth != null) ? w.minExtendedWidth! : 0;
  stObj.useIndicator = (w.useIndicator != null) ? w.useIndicator!.toInt() : 0;
  stObj.indicatorColor = _addWidget(w.indicatorColor);
  stObj.indicatorShape = _addWidget(w.indicatorShape);
  stObj.leadingAtTop = w.leadingAtTop.toInt();
  stObj.trailingAtBottom = w.trailingAtBottom.toInt();
  stObj.scrollable = w.scrollable.toInt();
  return stObj;
}

void _setupNavigationRailDestination(WidgetFactories f) {
  f.navigationRailDestination.navigationRailDestination = ffi.Pointer.fromFunction(navigationRailDestinationNavigationRailDestination, exception);
}
int navigationRailDestinationNavigationRailDestination(DartDartObj icon, ffi.Pointer<DartObj> selectedIcon, ffi.Pointer<DartObj> indicatorColor, ffi.Pointer<DartObj> indicatorShape, DartDartObj label, ffi.Pointer<DartObj> padding, ffi.Pointer<ffi.Int> disabled) {
  final w = NavigationRailDestination(icon: _widgetsMap[icon]! as Widget,
      selectedIcon: selectedIcon.objOrNul(),
      indicatorColor: indicatorColor.objOrNul(),
      indicatorShape: indicatorShape.objOrNul(),
      label: _widgetsMap[label]! as Widget,
      padding: padding.objOrNul(),
      disabled: disabled.boolOr(false));
  return _addWidget(w);
}

void _setupNavigationBar(WidgetFactories f) {
  f.navigationBar.navigationBar = ffi.Pointer.fromFunction(navigationBarNavigationBar);
}
NavigationBarObjSt navigationBarNavigationBar(ffi.Pointer<DartObj> animationDuration, ffi.Pointer<ffi.Int> selectedIndex, ArrayC destinations, ffi.Pointer<ValueChangedForIntFFI> onDestinationSelected, ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<ffi.Double> elevation, ffi.Pointer<DartObj> shadowColor, ffi.Pointer<DartObj> surfaceTintColor, ffi.Pointer<DartObj> indicatorColor, ffi.Pointer<DartObj> indicatorShape, ffi.Pointer<ffi.Double> height, ffi.Pointer<ffi.Int> labelBehavior, ffi.Pointer<DartObj> overlayColor, ffi.Pointer<DartObj> labelTextStyle, ffi.Pointer<DartObj> labelPadding, ffi.Pointer<ffi.Int> maintainBottomViewPadding) {
  final w = NavigationBar(animationDuration: animationDuration.objOrNul(),
      selectedIndex: selectedIndex.intOr(0),
      destinations: destinations.listOrEmpty(),
      onDestinationSelected: onDestinationSelected.toValueChangedForIntFn(),
      backgroundColor: backgroundColor.objOrNul(),
      elevation: elevation.doubleOrNul(),
      shadowColor: shadowColor.objOrNul(),
      surfaceTintColor: surfaceTintColor.objOrNul(),
      indicatorColor: indicatorColor.objOrNul(),
      indicatorShape: indicatorShape.objOrNul(),
      height: height.doubleOrNul(),
      labelBehavior: labelBehavior.enumOrNul(NavigationDestinationLabelBehavior.values),
      overlayColor: _wspNul<Color?>(overlayColor.objOrNul()),
      labelTextStyle: _wspNul<TextStyle?>(labelTextStyle.objOrNul()),
      labelPadding: labelPadding.objOrNul(),
      maintainBottomViewPadding: maintainBottomViewPadding.boolOr(false));
  return _createNavigationBarObjSt(w);
}
NavigationBarObjSt _createNavigationBarObjSt(NavigationBar? w) {
  final NavigationBarObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.animationDuration = _addWidget(w.animationDuration);
  stObj.selectedIndex = w.selectedIndex;
  stObj.backgroundColor = _addWidget(w.backgroundColor);
  stObj.elevation = (w.elevation != null) ? w.elevation! : 0;
  stObj.shadowColor = _addWidget(w.shadowColor);
  stObj.surfaceTintColor = _addWidget(w.surfaceTintColor);
  stObj.indicatorColor = _addWidget(w.indicatorColor);
  stObj.indicatorShape = _addWidget(w.indicatorShape);
  stObj.height = (w.height != null) ? w.height! : 0;
  stObj.labelBehavior = (w.labelBehavior != null) ? w.labelBehavior!.index : 0;
  stObj.labelPadding = _addWidget(w.labelPadding);
  stObj.maintainBottomViewPadding = w.maintainBottomViewPadding.toInt();
  return stObj;
}

void _setupNavigationDestination(WidgetFactories f) {
  f.navigationDestination.navigationDestination = ffi.Pointer.fromFunction(navigationDestinationNavigationDestination);
}
NavigationDestinationObjSt navigationDestinationNavigationDestination(DartDartObj icon, ffi.Pointer<DartObj> selectedIcon, ffi.Pointer<ffi.Char> label, ffi.Pointer<ffi.Char> tooltip, ffi.Pointer<ffi.Int> enabled) {
  final w = NavigationDestination(icon: _widgetsMap[icon]! as Widget,
      selectedIcon: selectedIcon.objOrNul(),
      label: label.cast<Utf8>().toDartString(),
      tooltip: tooltip.strOrNul(),
      enabled: enabled.boolOr(true));
  return _createNavigationDestinationObjSt(w);
}
NavigationDestinationObjSt _createNavigationDestinationObjSt(NavigationDestination? w) {
  final NavigationDestinationObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.icon = _addWidget(w.icon);
  stObj.selectedIcon = _addWidget(w.selectedIcon);
  stObj.label = w.label.toNativeUtf8().cast<ffi.Char>();
  stObj.tooltip = (w.tooltip != null) ? w.tooltip!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.enabled = w.enabled.toInt();
  return stObj;
}

void _setupNavigationDrawer(WidgetFactories f) {
  f.navigationDrawer.navigationDrawer = ffi.Pointer.fromFunction(navigationDrawerNavigationDrawer);
}
NavigationDrawerObjSt navigationDrawerNavigationDrawer(ArrayC children, ffi.Pointer<DartObj> header, ffi.Pointer<DartObj> footer, ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<DartObj> shadowColor, ffi.Pointer<DartObj> surfaceTintColor, ffi.Pointer<ffi.Double> elevation, ffi.Pointer<DartObj> indicatorColor, ffi.Pointer<DartObj> indicatorShape, ffi.Pointer<ValueChangedForIntFFI> onDestinationSelected, ffi.Pointer<ffi.Int> selectedIndex, ffi.Pointer<DartObj> tilePadding) {
  final w = NavigationDrawer(children: children.listOrEmpty(),
      header: header.objOrNul(),
      footer: footer.objOrNul(),
      backgroundColor: backgroundColor.objOrNul(),
      shadowColor: shadowColor.objOrNul(),
      surfaceTintColor: surfaceTintColor.objOrNul(),
      elevation: elevation.doubleOrNul(),
      indicatorColor: indicatorColor.objOrNul(),
      indicatorShape: indicatorShape.objOrNul(),
      onDestinationSelected: onDestinationSelected.toValueChangedForIntFn(),
      selectedIndex: selectedIndex.intOrNul(),
      tilePadding: tilePadding.objOr(const EdgeInsets.symmetric(horizontal: 12.0)));
  return _createNavigationDrawerObjSt(w);
}
NavigationDrawerObjSt _createNavigationDrawerObjSt(NavigationDrawer? w) {
  final NavigationDrawerObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.backgroundColor = _addWidget(w.backgroundColor);
  stObj.shadowColor = _addWidget(w.shadowColor);
  stObj.surfaceTintColor = _addWidget(w.surfaceTintColor);
  stObj.elevation = (w.elevation != null) ? w.elevation! : 0;
  stObj.indicatorColor = _addWidget(w.indicatorColor);
  stObj.indicatorShape = _addWidget(w.indicatorShape);
  stObj.header = _addWidget(w.header);
  stObj.footer = _addWidget(w.footer);
  stObj.selectedIndex = (w.selectedIndex != null) ? w.selectedIndex! : 0;
  stObj.tilePadding = _addWidget(w.tilePadding);
  return stObj;
}

void _setupNavigationDrawerDestination(WidgetFactories f) {
  f.navigationDrawerDestination.navigationDrawerDestination = ffi.Pointer.fromFunction(navigationDrawerDestinationNavigationDrawerDestination);
}
NavigationDrawerDestinationObjSt navigationDrawerDestinationNavigationDrawerDestination(ffi.Pointer<DartObj> backgroundColor, DartDartObj icon, ffi.Pointer<DartObj> selectedIcon, DartDartObj label, ffi.Pointer<ffi.Int> enabled) {
  final w = NavigationDrawerDestination(backgroundColor: backgroundColor.objOrNul(),
      icon: _widgetsMap[icon]! as Widget,
      selectedIcon: selectedIcon.objOrNul(),
      label: _widgetsMap[label]! as Widget,
      enabled: enabled.boolOr(true));
  return _createNavigationDrawerDestinationObjSt(w);
}
NavigationDrawerDestinationObjSt _createNavigationDrawerDestinationObjSt(NavigationDrawerDestination? w) {
  final NavigationDrawerDestinationObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.backgroundColor = _addWidget(w.backgroundColor);
  stObj.icon = _addWidget(w.icon);
  stObj.selectedIcon = _addWidget(w.selectedIcon);
  stObj.label = _addWidget(w.label);
  stObj.enabled = w.enabled.toInt();
  return stObj;
}

void _setupPopupMenuButton(WidgetFactories f) {
  f.popupMenuButton.popupMenuButton = ffi.Pointer.fromFunction(popupMenuButtonPopupMenuButton);
}
PopupMenuButtonObjSt popupMenuButtonPopupMenuButton(PopupMenuItemBuilderForTFFI itemBuilder, ffi.Pointer<DartObj> initialValue, ffi.Pointer<VoidCallbackFFI> onOpened, ffi.Pointer<PopupMenuItemSelectedForTFFI> onSelected, ffi.Pointer<PopupMenuCanceledFFI> onCanceled, ffi.Pointer<ffi.Char> tooltip, ffi.Pointer<ffi.Double> elevation, ffi.Pointer<DartObj> shadowColor, ffi.Pointer<DartObj> surfaceTintColor, ffi.Pointer<DartObj> padding, ffi.Pointer<DartObj> menuPadding, ffi.Pointer<DartObj> child, ffi.Pointer<DartObj> borderRadius, ffi.Pointer<ffi.Double> splashRadius, ffi.Pointer<DartObj> icon, ffi.Pointer<ffi.Double> iconSize, ffi.Pointer<DartObj> offset, ffi.Pointer<ffi.Int> enabled, ffi.Pointer<DartObj> shape, ffi.Pointer<DartObj> color, ffi.Pointer<DartObj> iconColor, ffi.Pointer<ffi.Int> enableFeedback, ffi.Pointer<DartObj> constraints, ffi.Pointer<ffi.Int> position, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<ffi.Int> useRootNavigator, ffi.Pointer<ffi.Int> requestFocus) {
  final w = PopupMenuButton(itemBuilder: itemBuilder.toPopupMenuItemBuilderForTFn(),
      initialValue: initialValue,
      onOpened: onOpened.toVoidCallbackFn(),
      onSelected: onSelected.toPopupMenuItemSelectedForTFn(),
      onCanceled: onCanceled.toPopupMenuCanceledFn(),
      tooltip: tooltip.strOrNul(),
      elevation: elevation.doubleOrNul(),
      shadowColor: shadowColor.objOrNul(),
      surfaceTintColor: surfaceTintColor.objOrNul(),
      padding: padding.objOr(const EdgeInsets.all(8.0)),
      menuPadding: menuPadding.objOrNul(),
      child: child.objOrNul(),
      borderRadius: borderRadius.objOrNul(),
      splashRadius: splashRadius.doubleOrNul(),
      icon: icon.objOrNul(),
      iconSize: iconSize.doubleOrNul(),
      offset: offset.objOr(Offset.zero),
      enabled: enabled.boolOr(true),
      shape: shape.objOrNul(),
      color: color.objOrNul(),
      iconColor: iconColor.objOrNul(),
      enableFeedback: enableFeedback.boolOrNul(),
      constraints: constraints.objOrNul(),
      position: position.enumOrNul(PopupMenuPosition.values),
      clipBehavior: clipBehavior.enumOr(Clip.values, Clip.none),
      useRootNavigator: useRootNavigator.boolOr(false),
      requestFocus: requestFocus.boolOrNul());
  return _createPopupMenuButtonObjSt(w);
}
PopupMenuButtonObjSt _createPopupMenuButtonObjSt(PopupMenuButton? w) {
  final PopupMenuButtonObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.tooltip = (w.tooltip != null) ? w.tooltip!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.elevation = (w.elevation != null) ? w.elevation! : 0;
  stObj.shadowColor = _addWidget(w.shadowColor);
  stObj.surfaceTintColor = _addWidget(w.surfaceTintColor);
  stObj.padding = _addWidget(w.padding);
  stObj.menuPadding = _addWidget(w.menuPadding);
  stObj.splashRadius = (w.splashRadius != null) ? w.splashRadius! : 0;
  stObj.child = _addWidget(w.child);
  stObj.borderRadius = _createBorderRadiusObjSt(w.borderRadius);
  stObj.icon = _addWidget(w.icon);
  stObj.offset = _addWidget(w.offset);
  stObj.enabled = w.enabled.toInt();
  stObj.shape = _addWidget(w.shape);
  stObj.color = _addWidget(w.color);
  stObj.iconColor = _addWidget(w.iconColor);
  stObj.enableFeedback = (w.enableFeedback != null) ? w.enableFeedback!.toInt() : 0;
  stObj.iconSize = (w.iconSize != null) ? w.iconSize! : 0;
  stObj.constraints = _createBoxConstraintsObjSt(w.constraints);
  stObj.position = (w.position != null) ? w.position!.index : 0;
  stObj.clipBehavior = w.clipBehavior.index;
  stObj.useRootNavigator = w.useRootNavigator.toInt();
  stObj.requestFocus = (w.requestFocus != null) ? w.requestFocus!.toInt() : 0;
  return stObj;
}

void _setupPopupMenuItem(WidgetFactories f) {
  f.popupMenuItem.popupMenuItem = ffi.Pointer.fromFunction(popupMenuItemPopupMenuItem);
}
PopupMenuItemObjSt popupMenuItemPopupMenuItem(ffi.Pointer<DartObj> value, ffi.Pointer<VoidCallbackFFI> onTap, ffi.Pointer<ffi.Int> enabled, ffi.Pointer<ffi.Double> height, ffi.Pointer<DartObj> padding, ffi.Pointer<DartObj> textStyle, ffi.Pointer<DartObj> labelTextStyle, DartDartObj child) {
  final w = PopupMenuItem(value: value,
      onTap: onTap.toVoidCallbackFn(),
      enabled: enabled.boolOr(true),
      height: height.doubleOr(48.0),
      padding: padding.objOrNul(),
      textStyle: textStyle.objOrNul(),
      labelTextStyle: _wspNul<TextStyle?>(labelTextStyle.objOrNul()),
      child: _widgetsMap[child]! as Widget?);
  return _createPopupMenuItemObjSt(w);
}
PopupMenuItemObjSt _createPopupMenuItemObjSt(PopupMenuItem? w) {
  final PopupMenuItemObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.enabled = w.enabled.toInt();
  stObj.height = w.height;
  stObj.padding = _createEdgeInsetsObjSt(w.padding);
  stObj.textStyle = _createTextStyleObjSt(w.textStyle);
  stObj.child = _addWidget(w.child);
  return stObj;
}

void _setupPopupMenuDivider(WidgetFactories f) {
  f.popupMenuDivider.popupMenuDivider = ffi.Pointer.fromFunction(popupMenuDividerPopupMenuDivider);
}
PopupMenuDividerObjSt popupMenuDividerPopupMenuDivider(ffi.Pointer<ffi.Double> height, ffi.Pointer<ffi.Double> thickness, ffi.Pointer<ffi.Double> indent, ffi.Pointer<ffi.Double> endIndent, ffi.Pointer<DartObj> radius, ffi.Pointer<DartObj> color) {
  final w = PopupMenuDivider(height: height.doubleOr(16.0),
      thickness: thickness.doubleOrNul(),
      indent: indent.doubleOrNul(),
      endIndent: endIndent.doubleOrNul(),
      radius: radius.objOrNul(),
      color: color.objOrNul());
  return _createPopupMenuDividerObjSt(w);
}
PopupMenuDividerObjSt _createPopupMenuDividerObjSt(PopupMenuDivider? w) {
  final PopupMenuDividerObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.height = w.height;
  stObj.thickness = (w.thickness != null) ? w.thickness! : 0;
  stObj.indent = (w.indent != null) ? w.indent! : 0;
  stObj.endIndent = (w.endIndent != null) ? w.endIndent! : 0;
  stObj.radius = _addWidget(w.radius);
  stObj.color = _addWidget(w.color);
  return stObj;
}

void _setupCheckedPopupMenuItem(WidgetFactories f) {
  f.checkedPopupMenuItem.checkedPopupMenuItem = ffi.Pointer.fromFunction(checkedPopupMenuItemCheckedPopupMenuItem);
}
CheckedPopupMenuItemObjSt checkedPopupMenuItemCheckedPopupMenuItem(ffi.Pointer<DartObj> value, ffi.Pointer<ffi.Int> checked, ffi.Pointer<ffi.Int> enabled, ffi.Pointer<DartObj> padding, ffi.Pointer<ffi.Double> height, ffi.Pointer<DartObj> labelTextStyle, ffi.Pointer<DartObj> child, ffi.Pointer<VoidCallbackFFI> onTap) {
  final w = CheckedPopupMenuItem(value: value,
      checked: checked.boolOr(false),
      enabled: enabled.boolOr(true),
      padding: padding.objOrNul(),
      height: height.doubleOr(48.0),
      labelTextStyle: _wspNul<TextStyle?>(labelTextStyle.objOrNul()),
      child: child.objOrNul(),
      onTap: onTap.toVoidCallbackFn());
  return _createCheckedPopupMenuItemObjSt(w);
}
CheckedPopupMenuItemObjSt _createCheckedPopupMenuItemObjSt(CheckedPopupMenuItem? w) {
  final CheckedPopupMenuItemObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.checked = w.checked.toInt();
  return stObj;
}

void _setupCircleAvatar(WidgetFactories f) {
  f.circleAvatar.circleAvatar = ffi.Pointer.fromFunction(circleAvatarCircleAvatar);
}
CircleAvatarObjSt circleAvatarCircleAvatar(ffi.Pointer<DartObj> child, ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<DartObj> foregroundColor, ffi.Pointer<ffi.Double> radius, ffi.Pointer<ffi.Double> minRadius, ffi.Pointer<ffi.Double> maxRadius) {
  final w = CircleAvatar(child: child.objOrNul(),
      backgroundColor: backgroundColor.objOrNul(),
      foregroundColor: foregroundColor.objOrNul(),
      radius: radius.doubleOrNul(),
      minRadius: minRadius.doubleOrNul(),
      maxRadius: maxRadius.doubleOrNul());
  return _createCircleAvatarObjSt(w);
}
CircleAvatarObjSt _createCircleAvatarObjSt(CircleAvatar? w) {
  final CircleAvatarObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.child = _addWidget(w.child);
  stObj.backgroundColor = _addWidget(w.backgroundColor);
  stObj.foregroundColor = _addWidget(w.foregroundColor);
  stObj.radius = (w.radius != null) ? w.radius! : 0;
  stObj.minRadius = (w.minRadius != null) ? w.minRadius! : 0;
  stObj.maxRadius = (w.maxRadius != null) ? w.maxRadius! : 0;
  return stObj;
}

void _setupScrollbar(WidgetFactories f) {
  f.scrollbar.scrollbar = ffi.Pointer.fromFunction(scrollbarScrollbar);
}
ScrollbarObjSt scrollbarScrollbar(DartDartObj child, ffi.Pointer<ffi.Int> thumbVisibility, ffi.Pointer<ffi.Int> trackVisibility, ffi.Pointer<ffi.Double> thickness, ffi.Pointer<DartObj> radius, ffi.Pointer<ffi.Int> interactive, ffi.Pointer<ffi.Int> scrollbarOrientation) {
  final w = Scrollbar(child: _widgetsMap[child]! as Widget,
      thumbVisibility: thumbVisibility.boolOrNul(),
      trackVisibility: trackVisibility.boolOrNul(),
      thickness: thickness.doubleOrNul(),
      radius: radius.objOrNul(),
      interactive: interactive.boolOrNul(),
      scrollbarOrientation: scrollbarOrientation.enumOrNul(ScrollbarOrientation.values));
  return _createScrollbarObjSt(w);
}
ScrollbarObjSt _createScrollbarObjSt(Scrollbar? w) {
  final ScrollbarObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.child = _addWidget(w.child);
  stObj.thumbVisibility = (w.thumbVisibility != null) ? w.thumbVisibility!.toInt() : 0;
  stObj.trackVisibility = (w.trackVisibility != null) ? w.trackVisibility!.toInt() : 0;
  stObj.thickness = (w.thickness != null) ? w.thickness! : 0;
  stObj.radius = _addWidget(w.radius);
  stObj.interactive = (w.interactive != null) ? w.interactive!.toInt() : 0;
  stObj.scrollbarOrientation = (w.scrollbarOrientation != null) ? w.scrollbarOrientation!.index : 0;
  return stObj;
}

void _setupMenuBar(WidgetFactories f) {
  f.menuBar.menuBar = ffi.Pointer.fromFunction(menuBarMenuBar);
}
MenuBarObjSt menuBarMenuBar(ffi.Pointer<ffi.Int> clipBehavior, ArrayC children) {
  final w = MenuBar(clipBehavior: clipBehavior.enumOr(Clip.values, Clip.none),
      children: children.listOrEmpty());
  return _createMenuBarObjSt(w);
}
MenuBarObjSt _createMenuBarObjSt(MenuBar? w) {
  final MenuBarObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.clipBehavior = w.clipBehavior.index;
  return stObj;
}

void _setupMenuAnchor(WidgetFactories f) {
  f.menuAnchor.menuAnchor = ffi.Pointer.fromFunction(menuAnchorMenuAnchor);
}
MenuAnchorObjSt menuAnchorMenuAnchor(ffi.Pointer<DartObj> alignmentOffset, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<ffi.Int> anchorTapClosesMenu, ffi.Pointer<ffi.Int> consumeOutsideTap, ffi.Pointer<VoidCallbackFFI> onOpen, ffi.Pointer<VoidCallbackFFI> onClose, ffi.Pointer<ffi.Int> crossAxisUnconstrained, ffi.Pointer<ffi.Int> useRootOverlay, ArrayC menuChildren, ffi.Pointer<DartObj> child) {
  final w = MenuAnchor(alignmentOffset: alignmentOffset.objOrNul(),
      clipBehavior: clipBehavior.enumOr(Clip.values, Clip.hardEdge),
      anchorTapClosesMenu: anchorTapClosesMenu.boolOr(false),
      consumeOutsideTap: consumeOutsideTap.boolOr(false),
      onOpen: onOpen.toVoidCallbackFn(),
      onClose: onClose.toVoidCallbackFn(),
      crossAxisUnconstrained: crossAxisUnconstrained.boolOr(true),
      useRootOverlay: useRootOverlay.boolOr(false),
      menuChildren: menuChildren.listOrEmpty(),
      child: child.objOrNul());
  return _createMenuAnchorObjSt(w);
}
MenuAnchorObjSt _createMenuAnchorObjSt(MenuAnchor? w) {
  final MenuAnchorObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.alignmentOffset = _addWidget(w.alignmentOffset);
  stObj.clipBehavior = w.clipBehavior.index;
  stObj.anchorTapClosesMenu = w.anchorTapClosesMenu.toInt();
  stObj.consumeOutsideTap = w.consumeOutsideTap.toInt();
  stObj.crossAxisUnconstrained = w.crossAxisUnconstrained.toInt();
  stObj.useRootOverlay = w.useRootOverlay.toInt();
  stObj.child = _addWidget(w.child);
  return stObj;
}

void _setupSubmenuButton(WidgetFactories f) {
  f.submenuButton.submenuButton = ffi.Pointer.fromFunction(submenuButtonSubmenuButton);
}
SubmenuButtonObjSt submenuButtonSubmenuButton(ffi.Pointer<ValueChangedForBoolFFI> onHover, ffi.Pointer<ValueChangedForBoolFFI> onFocusChange, ffi.Pointer<VoidCallbackFFI> onOpen, ffi.Pointer<VoidCallbackFFI> onClose, ffi.Pointer<DartObj> alignmentOffset, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<DartObj> leadingIcon, ffi.Pointer<DartObj> trailingIcon, ffi.Pointer<DartObj> submenuIcon, ffi.Pointer<ffi.Int> useRootOverlay, ArrayC menuChildren, DartDartObj child) {
  final w = SubmenuButton(onHover: onHover.toValueChangedForBoolFn(),
      onFocusChange: onFocusChange.toValueChangedForBoolFn(),
      onOpen: onOpen.toVoidCallbackFn(),
      onClose: onClose.toVoidCallbackFn(),
      alignmentOffset: alignmentOffset.objOrNul(),
      clipBehavior: clipBehavior.enumOr(Clip.values, Clip.hardEdge),
      leadingIcon: leadingIcon.objOrNul(),
      trailingIcon: trailingIcon.objOrNul(),
      submenuIcon: _wspNul<Widget?>(submenuIcon.objOrNul()),
      useRootOverlay: useRootOverlay.boolOr(false),
      menuChildren: menuChildren.listOrEmpty(),
      child: _widgetsMap[child]! as Widget?);
  return _createSubmenuButtonObjSt(w);
}
SubmenuButtonObjSt _createSubmenuButtonObjSt(SubmenuButton? w) {
  final SubmenuButtonObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.alignmentOffset = _addWidget(w.alignmentOffset);
  stObj.clipBehavior = w.clipBehavior.index;
  stObj.leadingIcon = _addWidget(w.leadingIcon);
  stObj.trailingIcon = _addWidget(w.trailingIcon);
  stObj.useRootOverlay = w.useRootOverlay.toInt();
  stObj.child = _addWidget(w.child);
  return stObj;
}

void _setupMenuItemButton(WidgetFactories f) {
  f.menuItemButton.menuItemButton = ffi.Pointer.fromFunction(menuItemButtonMenuItemButton);
}
MenuItemButtonObjSt menuItemButtonMenuItemButton(ffi.Pointer<VoidCallbackFFI> onPressed, ffi.Pointer<ValueChangedForBoolFFI> onHover, ffi.Pointer<ffi.Int> requestFocusOnHover, ffi.Pointer<ValueChangedForBoolFFI> onFocusChange, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<ffi.Char> semanticsLabel, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<DartObj> leadingIcon, ffi.Pointer<DartObj> trailingIcon, ffi.Pointer<ffi.Int> closeOnActivate, ffi.Pointer<ffi.Int> overflowAxis, ffi.Pointer<DartObj> child) {
  final w = MenuItemButton(onPressed: onPressed.toVoidCallbackFn(),
      onHover: onHover.toValueChangedForBoolFn(),
      requestFocusOnHover: requestFocusOnHover.boolOr(true),
      onFocusChange: onFocusChange.toValueChangedForBoolFn(),
      autofocus: autofocus.boolOr(false),
      semanticsLabel: semanticsLabel.strOrNul(),
      clipBehavior: clipBehavior.enumOr(Clip.values, Clip.none),
      leadingIcon: leadingIcon.objOrNul(),
      trailingIcon: trailingIcon.objOrNul(),
      closeOnActivate: closeOnActivate.boolOr(true),
      overflowAxis: overflowAxis.enumOr(Axis.values, Axis.horizontal),
      child: child.objOrNul());
  return _createMenuItemButtonObjSt(w);
}
MenuItemButtonObjSt _createMenuItemButtonObjSt(MenuItemButton? w) {
  final MenuItemButtonObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.requestFocusOnHover = w.requestFocusOnHover.toInt();
  stObj.autofocus = w.autofocus.toInt();
  stObj.semanticsLabel = (w.semanticsLabel != null) ? w.semanticsLabel!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.clipBehavior = w.clipBehavior.index;
  stObj.leadingIcon = _addWidget(w.leadingIcon);
  stObj.trailingIcon = _addWidget(w.trailingIcon);
  stObj.closeOnActivate = w.closeOnActivate.toInt();
  stObj.overflowAxis = w.overflowAxis.index;
  stObj.child = _addWidget(w.child);
  stObj.enabled = w.enabled.toInt();
  return stObj;
}

void _setupCheckboxMenuButton(WidgetFactories f) {
  f.checkboxMenuButton.checkboxMenuButton = ffi.Pointer.fromFunction(checkboxMenuButtonCheckboxMenuButton);
}
CheckboxMenuButtonObjSt checkboxMenuButtonCheckboxMenuButton(int value, ffi.Pointer<ffi.Int> tristate, ffi.Pointer<ffi.Int> isError, ValueChangedForBoolOptFFI onChanged, ffi.Pointer<ValueChangedForBoolFFI> onHover, ffi.Pointer<ValueChangedForBoolFFI> onFocusChange, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<DartObj> trailingIcon, ffi.Pointer<ffi.Int> closeOnActivate, DartDartObj child) {
  final w = CheckboxMenuButton(value: value.toBool(),
      tristate: tristate.boolOr(false),
      isError: isError.boolOr(false),
      onChanged: onChanged.toValueChangedForBoolOptFn(),
      onHover: onHover.toValueChangedForBoolFn(),
      onFocusChange: onFocusChange.toValueChangedForBoolFn(),
      clipBehavior: clipBehavior.enumOr(Clip.values, Clip.none),
      trailingIcon: trailingIcon.objOrNul(),
      closeOnActivate: closeOnActivate.boolOr(true),
      child: _widgetsMap[child]! as Widget?);
  return _createCheckboxMenuButtonObjSt(w);
}
CheckboxMenuButtonObjSt _createCheckboxMenuButtonObjSt(CheckboxMenuButton? w) {
  final CheckboxMenuButtonObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.value = (w.value != null) ? w.value!.toInt() : 0;
  stObj.tristate = w.tristate.toInt();
  stObj.isError = w.isError.toInt();
  stObj.clipBehavior = w.clipBehavior.index;
  stObj.trailingIcon = _addWidget(w.trailingIcon);
  stObj.closeOnActivate = w.closeOnActivate.toInt();
  stObj.child = _addWidget(w.child);
  stObj.enabled = w.enabled.toInt();
  return stObj;
}

void _setupRadioMenuButton(WidgetFactories f) {
  f.radioMenuButton.radioMenuButton = ffi.Pointer.fromFunction(radioMenuButtonRadioMenuButton);
}
RadioMenuButtonObjSt radioMenuButtonRadioMenuButton(DartDartObj value, DartDartObj groupValue, ValueChangedForTOptFFI onChanged, ffi.Pointer<ffi.Int> toggleable, ffi.Pointer<ValueChangedForBoolFFI> onHover, ffi.Pointer<ValueChangedForBoolFFI> onFocusChange, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<DartObj> trailingIcon, ffi.Pointer<ffi.Int> closeOnActivate, DartDartObj child) {
  final w = RadioMenuButton(value: value,
      groupValue: groupValue,
      onChanged: onChanged.toValueChangedForTOptFn(),
      toggleable: toggleable.boolOr(false),
      onHover: onHover.toValueChangedForBoolFn(),
      onFocusChange: onFocusChange.toValueChangedForBoolFn(),
      clipBehavior: clipBehavior.enumOr(Clip.values, Clip.none),
      trailingIcon: trailingIcon.objOrNul(),
      closeOnActivate: closeOnActivate.boolOr(true),
      child: _widgetsMap[child]! as Widget?);
  return _createRadioMenuButtonObjSt(w);
}
RadioMenuButtonObjSt _createRadioMenuButtonObjSt(RadioMenuButton? w) {
  final RadioMenuButtonObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.toggleable = w.toggleable.toInt();
  stObj.clipBehavior = w.clipBehavior.index;
  stObj.trailingIcon = _addWidget(w.trailingIcon);
  stObj.closeOnActivate = w.closeOnActivate.toInt();
  stObj.child = _addWidget(w.child);
  stObj.enabled = w.enabled.toInt();
  return stObj;
}

void _setupDatePickerDialog(WidgetFactories f) {
  f.datePickerDialog.datePickerDialog = ffi.Pointer.fromFunction(datePickerDialogDatePickerDialog);
}
DatePickerDialogObjSt datePickerDialogDatePickerDialog(ffi.Pointer<DartObj> initialDate, DartDartObj firstDate, DartDartObj lastDate, ffi.Pointer<DartObj> currentDate, ffi.Pointer<ffi.Int> initialEntryMode, ffi.Pointer<SelectableDayPredicateFFI> selectableDayPredicate, ffi.Pointer<ffi.Char> cancelText, ffi.Pointer<ffi.Char> confirmText, ffi.Pointer<ffi.Char> helpText, ffi.Pointer<ffi.Int> initialCalendarMode, ffi.Pointer<ffi.Char> errorFormatText, ffi.Pointer<ffi.Char> errorInvalidText, ffi.Pointer<ffi.Char> fieldHintText, ffi.Pointer<ffi.Char> fieldLabelText, ffi.Pointer<ffi.Char> restorationId, ffi.Pointer<ValueChangedForDatePickerEntryModeFFI> onDatePickerModeChange, ffi.Pointer<DartObj> switchToInputEntryModeIcon, ffi.Pointer<DartObj> switchToCalendarEntryModeIcon, ffi.Pointer<DartObj> insetPadding) {
  final w = DatePickerDialog(initialDate: initialDate.objOrNul(),
      firstDate: _widgetsMap[firstDate]! as DateTime,
      lastDate: _widgetsMap[lastDate]! as DateTime,
      currentDate: currentDate.objOrNul(),
      initialEntryMode: initialEntryMode.enumOr(DatePickerEntryMode.values, DatePickerEntryMode.calendar),
      selectableDayPredicate: selectableDayPredicate.toSelectableDayPredicateFn(),
      cancelText: cancelText.strOrNul(),
      confirmText: confirmText.strOrNul(),
      helpText: helpText.strOrNul(),
      initialCalendarMode: initialCalendarMode.enumOr(DatePickerMode.values, DatePickerMode.day),
      errorFormatText: errorFormatText.strOrNul(),
      errorInvalidText: errorInvalidText.strOrNul(),
      fieldHintText: fieldHintText.strOrNul(),
      fieldLabelText: fieldLabelText.strOrNul(),
      restorationId: restorationId.strOrNul(),
      onDatePickerModeChange: onDatePickerModeChange.toValueChangedForDatePickerEntryModeFn(),
      switchToInputEntryModeIcon: switchToInputEntryModeIcon.objOrNul(),
      switchToCalendarEntryModeIcon: switchToCalendarEntryModeIcon.objOrNul(),
      insetPadding: insetPadding.objOr(const EdgeInsets.symmetric(horizontal: 16.0, vertical: 24.0)));
  return _createDatePickerDialogObjSt(w);
}
DatePickerDialogObjSt _createDatePickerDialogObjSt(DatePickerDialog? w) {
  final DatePickerDialogObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.initialDate = _addWidget(w.initialDate);
  stObj.firstDate = _addWidget(w.firstDate);
  stObj.lastDate = _addWidget(w.lastDate);
  stObj.currentDate = _addWidget(w.currentDate);
  stObj.initialEntryMode = w.initialEntryMode.index;
  stObj.cancelText = (w.cancelText != null) ? w.cancelText!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.confirmText = (w.confirmText != null) ? w.confirmText!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.helpText = (w.helpText != null) ? w.helpText!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.initialCalendarMode = w.initialCalendarMode.index;
  stObj.errorFormatText = (w.errorFormatText != null) ? w.errorFormatText!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.errorInvalidText = (w.errorInvalidText != null) ? w.errorInvalidText!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.fieldHintText = (w.fieldHintText != null) ? w.fieldHintText!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.fieldLabelText = (w.fieldLabelText != null) ? w.fieldLabelText!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.restorationId = (w.restorationId != null) ? w.restorationId!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.switchToInputEntryModeIcon = _createIconObjSt(w.switchToInputEntryModeIcon);
  stObj.switchToCalendarEntryModeIcon = _createIconObjSt(w.switchToCalendarEntryModeIcon);
  stObj.insetPadding = _createEdgeInsetsObjSt(w.insetPadding);
  return stObj;
}

void _setupCalendarDatePicker(WidgetFactories f) {
  f.calendarDatePicker.calendarDatePicker = ffi.Pointer.fromFunction(calendarDatePickerCalendarDatePicker);
}
CalendarDatePickerObjSt calendarDatePickerCalendarDatePicker(DartDartObj initialDate, DartDartObj firstDate, DartDartObj lastDate, ffi.Pointer<DartObj> currentDate, ValueChangedForDateTimeFFI onDateChanged, ffi.Pointer<ValueChangedForDateTimeFFI> onDisplayedMonthChanged, ffi.Pointer<ffi.Int> initialCalendarMode, ffi.Pointer<SelectableDayPredicateFFI> selectableDayPredicate) {
  final w = CalendarDatePicker(initialDate: _widgetsMap[initialDate]! as DateTime?,
      firstDate: _widgetsMap[firstDate]! as DateTime,
      lastDate: _widgetsMap[lastDate]! as DateTime,
      currentDate: currentDate.objOrNul(),
      onDateChanged: onDateChanged.toValueChangedForDateTimeFn(),
      onDisplayedMonthChanged: onDisplayedMonthChanged.toValueChangedForDateTimeFn(),
      initialCalendarMode: initialCalendarMode.enumOr(DatePickerMode.values, DatePickerMode.day),
      selectableDayPredicate: selectableDayPredicate.toSelectableDayPredicateFn());
  return _createCalendarDatePickerObjSt(w);
}
CalendarDatePickerObjSt _createCalendarDatePickerObjSt(CalendarDatePicker? w) {
  final CalendarDatePickerObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.initialDate = _addWidget(w.initialDate);
  stObj.firstDate = _addWidget(w.firstDate);
  stObj.lastDate = _addWidget(w.lastDate);
  stObj.currentDate = _addWidget(w.currentDate);
  stObj.initialCalendarMode = w.initialCalendarMode.index;
  return stObj;
}

void _setupTimePickerDialog(WidgetFactories f) {
  f.timePickerDialog.timePickerDialog = ffi.Pointer.fromFunction(timePickerDialogTimePickerDialog);
}
TimePickerDialogObjSt timePickerDialogTimePickerDialog(DartDartObj initialTime, ffi.Pointer<ffi.Char> cancelText, ffi.Pointer<ffi.Char> confirmText, ffi.Pointer<ffi.Char> helpText, ffi.Pointer<ffi.Char> errorInvalidText, ffi.Pointer<ffi.Char> hourLabelText, ffi.Pointer<ffi.Char> minuteLabelText, ffi.Pointer<ffi.Char> restorationId, ffi.Pointer<ffi.Int> initialEntryMode, ffi.Pointer<ffi.Int> orientation, ffi.Pointer<EntryModeChangeCallbackFFI> onEntryModeChanged, ffi.Pointer<DartObj> switchToInputEntryModeIcon, ffi.Pointer<DartObj> switchToTimerEntryModeIcon) {
  final w = TimePickerDialog(initialTime: _widgetsMap[initialTime]! as TimeOfDay,
      cancelText: cancelText.strOrNul(),
      confirmText: confirmText.strOrNul(),
      helpText: helpText.strOrNul(),
      errorInvalidText: errorInvalidText.strOrNul(),
      hourLabelText: hourLabelText.strOrNul(),
      minuteLabelText: minuteLabelText.strOrNul(),
      restorationId: restorationId.strOrNul(),
      initialEntryMode: initialEntryMode.enumOr(TimePickerEntryMode.values, TimePickerEntryMode.dial),
      orientation: orientation.enumOrNul(Orientation.values),
      onEntryModeChanged: onEntryModeChanged.toEntryModeChangeCallbackFn(),
      switchToInputEntryModeIcon: switchToInputEntryModeIcon.objOrNul(),
      switchToTimerEntryModeIcon: switchToTimerEntryModeIcon.objOrNul());
  return _createTimePickerDialogObjSt(w);
}
TimePickerDialogObjSt _createTimePickerDialogObjSt(TimePickerDialog? w) {
  final TimePickerDialogObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.initialTime = _createTimeOfDayObjSt(w.initialTime);
  stObj.cancelText = (w.cancelText != null) ? w.cancelText!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.confirmText = (w.confirmText != null) ? w.confirmText!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.helpText = (w.helpText != null) ? w.helpText!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.errorInvalidText = (w.errorInvalidText != null) ? w.errorInvalidText!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.hourLabelText = (w.hourLabelText != null) ? w.hourLabelText!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.minuteLabelText = (w.minuteLabelText != null) ? w.minuteLabelText!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.restorationId = (w.restorationId != null) ? w.restorationId!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.initialEntryMode = w.initialEntryMode.index;
  stObj.orientation = (w.orientation != null) ? w.orientation!.index : 0;
  stObj.switchToInputEntryModeIcon = _createIconObjSt(w.switchToInputEntryModeIcon);
  stObj.switchToTimerEntryModeIcon = _createIconObjSt(w.switchToTimerEntryModeIcon);
  return stObj;
}

void _setupDateRangePickerDialog(WidgetFactories f) {
  f.dateRangePickerDialog.dateRangePickerDialog = ffi.Pointer.fromFunction(dateRangePickerDialogDateRangePickerDialog);
}
DateRangePickerDialogObjSt dateRangePickerDialogDateRangePickerDialog(DartDartObj firstDate, DartDartObj lastDate, ffi.Pointer<DartObj> currentDate, ffi.Pointer<ffi.Int> initialEntryMode, ffi.Pointer<ffi.Char> helpText, ffi.Pointer<ffi.Char> cancelText, ffi.Pointer<ffi.Char> confirmText, ffi.Pointer<ffi.Char> saveText, ffi.Pointer<ffi.Char> errorInvalidRangeText, ffi.Pointer<ffi.Char> errorFormatText, ffi.Pointer<ffi.Char> errorInvalidText, ffi.Pointer<ffi.Char> fieldStartHintText, ffi.Pointer<ffi.Char> fieldEndHintText, ffi.Pointer<ffi.Char> fieldStartLabelText, ffi.Pointer<ffi.Char> fieldEndLabelText, ffi.Pointer<ffi.Char> restorationId, ffi.Pointer<DartObj> switchToInputEntryModeIcon, ffi.Pointer<DartObj> switchToCalendarEntryModeIcon, ffi.Pointer<SelectableDayForRangePredicateFFI> selectableDayPredicate) {
  final w = DateRangePickerDialog(firstDate: _widgetsMap[firstDate]! as DateTime,
      lastDate: _widgetsMap[lastDate]! as DateTime,
      currentDate: currentDate.objOrNul(),
      initialEntryMode: initialEntryMode.enumOr(DatePickerEntryMode.values, DatePickerEntryMode.calendar),
      helpText: helpText.strOrNul(),
      cancelText: cancelText.strOrNul(),
      confirmText: confirmText.strOrNul(),
      saveText: saveText.strOrNul(),
      errorInvalidRangeText: errorInvalidRangeText.strOrNul(),
      errorFormatText: errorFormatText.strOrNul(),
      errorInvalidText: errorInvalidText.strOrNul(),
      fieldStartHintText: fieldStartHintText.strOrNul(),
      fieldEndHintText: fieldEndHintText.strOrNul(),
      fieldStartLabelText: fieldStartLabelText.strOrNul(),
      fieldEndLabelText: fieldEndLabelText.strOrNul(),
      restorationId: restorationId.strOrNul(),
      switchToInputEntryModeIcon: switchToInputEntryModeIcon.objOrNul(),
      switchToCalendarEntryModeIcon: switchToCalendarEntryModeIcon.objOrNul(),
      selectableDayPredicate: selectableDayPredicate.toSelectableDayForRangePredicateFn());
  return _createDateRangePickerDialogObjSt(w);
}
DateRangePickerDialogObjSt _createDateRangePickerDialogObjSt(DateRangePickerDialog? w) {
  final DateRangePickerDialogObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.firstDate = _addWidget(w.firstDate);
  stObj.lastDate = _addWidget(w.lastDate);
  stObj.currentDate = _addWidget(w.currentDate);
  stObj.initialEntryMode = w.initialEntryMode.index;
  stObj.cancelText = (w.cancelText != null) ? w.cancelText!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.confirmText = (w.confirmText != null) ? w.confirmText!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.saveText = (w.saveText != null) ? w.saveText!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.helpText = (w.helpText != null) ? w.helpText!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.errorInvalidRangeText = (w.errorInvalidRangeText != null) ? w.errorInvalidRangeText!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.errorFormatText = (w.errorFormatText != null) ? w.errorFormatText!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.errorInvalidText = (w.errorInvalidText != null) ? w.errorInvalidText!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.fieldStartHintText = (w.fieldStartHintText != null) ? w.fieldStartHintText!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.fieldEndHintText = (w.fieldEndHintText != null) ? w.fieldEndHintText!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.fieldStartLabelText = (w.fieldStartLabelText != null) ? w.fieldStartLabelText!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.fieldEndLabelText = (w.fieldEndLabelText != null) ? w.fieldEndLabelText!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.restorationId = (w.restorationId != null) ? w.restorationId!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.switchToInputEntryModeIcon = _createIconObjSt(w.switchToInputEntryModeIcon);
  stObj.switchToCalendarEntryModeIcon = _createIconObjSt(w.switchToCalendarEntryModeIcon);
  return stObj;
}

void _setupYearPicker(WidgetFactories f) {
  f.yearPicker.yearPicker = ffi.Pointer.fromFunction(yearPickerYearPicker);
}
YearPickerObjSt yearPickerYearPicker(ffi.Pointer<DartObj> currentDate, DartDartObj firstDate, DartDartObj lastDate, ffi.Pointer<DartObj> initialDate, DartDartObj selectedDate, ValueChangedForDateTimeFFI onChanged, ffi.Pointer<ffi.Int> dragStartBehavior) {
  final w = YearPicker(currentDate: currentDate.objOrNul(),
      firstDate: _widgetsMap[firstDate]! as DateTime,
      lastDate: _widgetsMap[lastDate]! as DateTime,
      initialDate: initialDate.objOrNul(),
      selectedDate: _widgetsMap[selectedDate]! as DateTime?,
      onChanged: onChanged.toValueChangedForDateTimeFn(),
      dragStartBehavior: dragStartBehavior.enumOr(DragStartBehavior.values, DragStartBehavior.start));
  return _createYearPickerObjSt(w);
}
YearPickerObjSt _createYearPickerObjSt(YearPicker? w) {
  final YearPickerObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.currentDate = _addWidget(w.currentDate);
  stObj.firstDate = _addWidget(w.firstDate);
  stObj.lastDate = _addWidget(w.lastDate);
  stObj.selectedDate = _addWidget(w.selectedDate);
  stObj.dragStartBehavior = w.dragStartBehavior.index;
  return stObj;
}

void _setupInputDatePickerFormField(WidgetFactories f) {
  f.inputDatePickerFormField.inputDatePickerFormField = ffi.Pointer.fromFunction(inputDatePickerFormFieldInputDatePickerFormField);
}
InputDatePickerFormFieldObjSt inputDatePickerFormFieldInputDatePickerFormField(ffi.Pointer<DartObj> initialDate, DartDartObj firstDate, DartDartObj lastDate, ffi.Pointer<ValueChangedForDateTimeFFI> onDateSubmitted, ffi.Pointer<ValueChangedForDateTimeFFI> onDateSaved, ffi.Pointer<SelectableDayPredicateFFI> selectableDayPredicate, ffi.Pointer<ffi.Char> errorFormatText, ffi.Pointer<ffi.Char> errorInvalidText, ffi.Pointer<ffi.Char> fieldHintText, ffi.Pointer<ffi.Char> fieldLabelText, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<ffi.Int> acceptEmptyDate) {
  final w = InputDatePickerFormField(initialDate: initialDate.objOrNul(),
      firstDate: _widgetsMap[firstDate]! as DateTime,
      lastDate: _widgetsMap[lastDate]! as DateTime,
      onDateSubmitted: onDateSubmitted.toValueChangedForDateTimeFn(),
      onDateSaved: onDateSaved.toValueChangedForDateTimeFn(),
      selectableDayPredicate: selectableDayPredicate.toSelectableDayPredicateFn(),
      errorFormatText: errorFormatText.strOrNul(),
      errorInvalidText: errorInvalidText.strOrNul(),
      fieldHintText: fieldHintText.strOrNul(),
      fieldLabelText: fieldLabelText.strOrNul(),
      autofocus: autofocus.boolOr(false),
      acceptEmptyDate: acceptEmptyDate.boolOr(false));
  return _createInputDatePickerFormFieldObjSt(w);
}
InputDatePickerFormFieldObjSt _createInputDatePickerFormFieldObjSt(InputDatePickerFormField? w) {
  final InputDatePickerFormFieldObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.initialDate = _addWidget(w.initialDate);
  stObj.firstDate = _addWidget(w.firstDate);
  stObj.lastDate = _addWidget(w.lastDate);
  stObj.errorFormatText = (w.errorFormatText != null) ? w.errorFormatText!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.errorInvalidText = (w.errorInvalidText != null) ? w.errorInvalidText!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.fieldHintText = (w.fieldHintText != null) ? w.fieldHintText!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.fieldLabelText = (w.fieldLabelText != null) ? w.fieldLabelText!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.autofocus = w.autofocus.toInt();
  stObj.acceptEmptyDate = w.acceptEmptyDate.toInt();
  return stObj;
}

void _setupSearchBar(WidgetFactories f) {
  f.searchBar.searchBar = ffi.Pointer.fromFunction(searchBarSearchBar);
}
SearchBarObjSt searchBarSearchBar(ffi.Pointer<ffi.Char> hintText, ffi.Pointer<DartObj> leading, ffi.Pointer<ArrayC> trailing, ffi.Pointer<GestureTapCallbackFFI> onTap, ffi.Pointer<TapRegionCallbackFFI> onTapOutside, ffi.Pointer<ValueChangedForStringFFI> onChanged, ffi.Pointer<ValueChangedForStringFFI> onSubmitted, ffi.Pointer<DartObj> constraints, ffi.Pointer<ffi.Double> elevation, ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<DartObj> shadowColor, ffi.Pointer<DartObj> surfaceTintColor, ffi.Pointer<DartObj> overlayColor, ffi.Pointer<DartObj> side, ffi.Pointer<DartObj> shape, ffi.Pointer<DartObj> padding, ffi.Pointer<DartObj> textStyle, ffi.Pointer<DartObj> hintStyle, ffi.Pointer<ffi.Int> textCapitalization, ffi.Pointer<ffi.Int> enabled, ffi.Pointer<ffi.Int> autoFocus, ffi.Pointer<ffi.Int> textInputAction, ffi.Pointer<DartObj> scrollPadding) {
  final w = SearchBar(hintText: hintText.strOrNul(),
      leading: leading.objOrNul(),
      trailing: trailing.listOrNul(),
      onTap: onTap.toGestureTapCallbackFn(),
      onTapOutside: onTapOutside.toTapRegionCallbackFn(),
      onChanged: onChanged.toValueChangedForStringFn(),
      onSubmitted: onSubmitted.toValueChangedForStringFn(),
      constraints: constraints.objOrNul(),
      elevation: _wspNul<double?>(elevation.doubleOrNul()),
      backgroundColor: _wspNul<Color?>(backgroundColor.objOrNul()),
      shadowColor: _wspNul<Color?>(shadowColor.objOrNul()),
      surfaceTintColor: _wspNul<Color?>(surfaceTintColor.objOrNul()),
      overlayColor: _wspNul<Color?>(overlayColor.objOrNul()),
      side: _wspNul<BorderSide?>(side.objOrNul()),
      shape: _wspNul<OutlinedBorder?>(shape.objOrNul()),
      padding: _wspNul<EdgeInsetsGeometry?>(padding.objOrNul()),
      textStyle: _wspNul<TextStyle?>(textStyle.objOrNul()),
      hintStyle: _wspNul<TextStyle?>(hintStyle.objOrNul()),
      textCapitalization: textCapitalization.enumOrNul(TextCapitalization.values),
      enabled: enabled.boolOr(true),
      autoFocus: autoFocus.boolOr(false),
      textInputAction: textInputAction.enumOrNul(TextInputAction.values),
      scrollPadding: scrollPadding.objOr(const EdgeInsets.all(20.0)));
  return _createSearchBarObjSt(w);
}
SearchBarObjSt _createSearchBarObjSt(SearchBar? w) {
  final SearchBarObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.hintText = (w.hintText != null) ? w.hintText!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.leading = _addWidget(w.leading);
  stObj.constraints = _createBoxConstraintsObjSt(w.constraints);
  stObj.textCapitalization = (w.textCapitalization != null) ? w.textCapitalization!.index : 0;
  stObj.enabled = w.enabled.toInt();
  stObj.autoFocus = w.autoFocus.toInt();
  stObj.textInputAction = (w.textInputAction != null) ? w.textInputAction!.index : 0;
  stObj.scrollPadding = _createEdgeInsetsObjSt(w.scrollPadding);
  return stObj;
}

void _setupCupertinoApp(WidgetFactories f) {
  f.cupertinoApp.cupertinoApp = ffi.Pointer.fromFunction(cupertinoAppCupertinoApp);
  f.cupertinoApp.router = ffi.Pointer.fromFunction(cupertinoAppRouter);
}
CupertinoAppObjSt cupertinoAppCupertinoApp(ffi.Pointer<DartObj> home, ffi.Pointer<ffi.Char> initialRoute, ffi.Pointer<TransitionBuilderFFI> builder, ffi.Pointer<ffi.Char> title, ffi.Pointer<GenerateAppTitleFFI> onGenerateTitle, ffi.Pointer<DartObj> color, ffi.Pointer<ffi.Int> showPerformanceOverlay, ffi.Pointer<ffi.Int> checkerboardRasterCacheImages, ffi.Pointer<ffi.Int> checkerboardOffscreenLayers, ffi.Pointer<ffi.Int> showSemanticsDebugger, ffi.Pointer<ffi.Int> debugShowCheckedModeBanner, ffi.Pointer<ffi.Char> restorationScopeId, ffi.Pointer<ffi.Int> useInheritedMediaQuery) {
  final w = CupertinoApp(home: home.objOrNul(),
      initialRoute: initialRoute.strOrNul(),
      builder: builder.toTransitionBuilderFn(),
      title: title.strOrNul(),
      onGenerateTitle: onGenerateTitle.toGenerateAppTitleFn(),
      color: color.objOrNul(),
      showPerformanceOverlay: showPerformanceOverlay.boolOr(false),
      checkerboardRasterCacheImages: checkerboardRasterCacheImages.boolOr(false),
      checkerboardOffscreenLayers: checkerboardOffscreenLayers.boolOr(false),
      showSemanticsDebugger: showSemanticsDebugger.boolOr(false),
      debugShowCheckedModeBanner: debugShowCheckedModeBanner.boolOr(true),
      restorationScopeId: restorationScopeId.strOrNul(),
      useInheritedMediaQuery: useInheritedMediaQuery.boolOr(false));
  return _createCupertinoAppObjSt(w);
}
CupertinoAppObjSt cupertinoAppRouter(ffi.Pointer<TransitionBuilderFFI> builder, ffi.Pointer<ffi.Char> title, ffi.Pointer<GenerateAppTitleFFI> onGenerateTitle, ffi.Pointer<DartObj> color, ffi.Pointer<ffi.Int> showPerformanceOverlay, ffi.Pointer<ffi.Int> checkerboardRasterCacheImages, ffi.Pointer<ffi.Int> checkerboardOffscreenLayers, ffi.Pointer<ffi.Int> showSemanticsDebugger, ffi.Pointer<ffi.Int> debugShowCheckedModeBanner, ffi.Pointer<ffi.Char> restorationScopeId, ffi.Pointer<ffi.Int> useInheritedMediaQuery) {
  final w = CupertinoApp.router(builder: builder.toTransitionBuilderFn(),
      title: title.strOrNul(),
      onGenerateTitle: onGenerateTitle.toGenerateAppTitleFn(),
      color: color.objOrNul(),
      showPerformanceOverlay: showPerformanceOverlay.boolOr(false),
      checkerboardRasterCacheImages: checkerboardRasterCacheImages.boolOr(false),
      checkerboardOffscreenLayers: checkerboardOffscreenLayers.boolOr(false),
      showSemanticsDebugger: showSemanticsDebugger.boolOr(false),
      debugShowCheckedModeBanner: debugShowCheckedModeBanner.boolOr(true),
      restorationScopeId: restorationScopeId.strOrNul(),
      useInheritedMediaQuery: useInheritedMediaQuery.boolOr(false));
  return _createCupertinoAppObjSt(w);
}
CupertinoAppObjSt _createCupertinoAppObjSt(CupertinoApp? w) {
  final CupertinoAppObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.home = _addWidget(w.home);
  stObj.initialRoute = (w.initialRoute != null) ? w.initialRoute!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.title = (w.title != null) ? w.title!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.color = _addWidget(w.color);
  stObj.showPerformanceOverlay = w.showPerformanceOverlay.toInt();
  stObj.checkerboardRasterCacheImages = w.checkerboardRasterCacheImages.toInt();
  stObj.checkerboardOffscreenLayers = w.checkerboardOffscreenLayers.toInt();
  stObj.showSemanticsDebugger = w.showSemanticsDebugger.toInt();
  stObj.debugShowCheckedModeBanner = w.debugShowCheckedModeBanner.toInt();
  stObj.restorationScopeId = (w.restorationScopeId != null) ? w.restorationScopeId!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.useInheritedMediaQuery = w.useInheritedMediaQuery.toInt();
  return stObj;
}

void _setupCupertinoPageScaffold(WidgetFactories f) {
  f.cupertinoPageScaffold.cupertinoPageScaffold = ffi.Pointer.fromFunction(cupertinoPageScaffoldCupertinoPageScaffold);
}
CupertinoPageScaffoldObjSt cupertinoPageScaffoldCupertinoPageScaffold(ffi.Pointer<DartObj> navigationBar, ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<ffi.Int> resizeToAvoidBottomInset, DartDartObj child) {
  final w = CupertinoPageScaffold(navigationBar: navigationBar.objOrNul(),
      backgroundColor: backgroundColor.objOrNul(),
      resizeToAvoidBottomInset: resizeToAvoidBottomInset.boolOr(true),
      child: _widgetsMap[child]! as Widget);
  return _createCupertinoPageScaffoldObjSt(w);
}
CupertinoPageScaffoldObjSt _createCupertinoPageScaffoldObjSt(CupertinoPageScaffold? w) {
  final CupertinoPageScaffoldObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.navigationBar = _addWidget(w.navigationBar);
  stObj.child = _addWidget(w.child);
  stObj.backgroundColor = _addWidget(w.backgroundColor);
  stObj.resizeToAvoidBottomInset = w.resizeToAvoidBottomInset.toInt();
  return stObj;
}

void _setupCupertinoNavigationBar(WidgetFactories f) {
  f.cupertinoNavigationBar.cupertinoNavigationBar = ffi.Pointer.fromFunction(cupertinoNavigationBarCupertinoNavigationBar);
  f.cupertinoNavigationBar.large = ffi.Pointer.fromFunction(cupertinoNavigationBarLarge);
}
CupertinoNavigationBarObjSt cupertinoNavigationBarCupertinoNavigationBar(ffi.Pointer<DartObj> leading, ffi.Pointer<ffi.Int> automaticallyImplyLeading, ffi.Pointer<ffi.Int> automaticallyImplyMiddle, ffi.Pointer<ffi.Char> previousPageTitle, ffi.Pointer<DartObj> middle, ffi.Pointer<DartObj> trailing, ffi.Pointer<DartObj> border, ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<ffi.Int> automaticBackgroundVisibility, ffi.Pointer<ffi.Int> enableBackgroundFilterBlur, ffi.Pointer<ffi.Int> brightness, ffi.Pointer<ffi.Int> transitionBetweenRoutes, ffi.Pointer<DartObj> bottom) {
  final w = CupertinoNavigationBar(leading: leading.objOrNul(),
      automaticallyImplyLeading: automaticallyImplyLeading.boolOr(true),
      automaticallyImplyMiddle: automaticallyImplyMiddle.boolOr(true),
      previousPageTitle: previousPageTitle.strOrNul(),
      middle: middle.objOrNul(),
      trailing: trailing.objOrNul(),
      border: border.objOrNul(),
      backgroundColor: backgroundColor.objOrNul(),
      automaticBackgroundVisibility: automaticBackgroundVisibility.boolOr(true),
      enableBackgroundFilterBlur: enableBackgroundFilterBlur.boolOr(true),
      brightness: brightness.enumOrNul(Brightness.values),
      transitionBetweenRoutes: transitionBetweenRoutes.boolOr(true),
      bottom: bottom.objOrNul());
  return _createCupertinoNavigationBarObjSt(w);
}
CupertinoNavigationBarObjSt cupertinoNavigationBarLarge(ffi.Pointer<DartObj> largeTitle, ffi.Pointer<DartObj> leading, ffi.Pointer<ffi.Int> automaticallyImplyLeading, ffi.Pointer<ffi.Int> automaticallyImplyTitle, ffi.Pointer<ffi.Char> previousPageTitle, ffi.Pointer<DartObj> trailing, ffi.Pointer<DartObj> border, ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<ffi.Int> automaticBackgroundVisibility, ffi.Pointer<ffi.Int> enableBackgroundFilterBlur, ffi.Pointer<ffi.Int> brightness, ffi.Pointer<ffi.Int> transitionBetweenRoutes, ffi.Pointer<DartObj> bottom) {
  final w = CupertinoNavigationBar.large(largeTitle: largeTitle.objOrNul(),
      leading: leading.objOrNul(),
      automaticallyImplyLeading: automaticallyImplyLeading.boolOr(true),
      automaticallyImplyTitle: automaticallyImplyTitle.boolOr(true),
      previousPageTitle: previousPageTitle.strOrNul(),
      trailing: trailing.objOrNul(),
      border: border.objOrNul(),
      backgroundColor: backgroundColor.objOrNul(),
      automaticBackgroundVisibility: automaticBackgroundVisibility.boolOr(true),
      enableBackgroundFilterBlur: enableBackgroundFilterBlur.boolOr(true),
      brightness: brightness.enumOrNul(Brightness.values),
      transitionBetweenRoutes: transitionBetweenRoutes.boolOr(true),
      bottom: bottom.objOrNul());
  return _createCupertinoNavigationBarObjSt(w);
}
CupertinoNavigationBarObjSt _createCupertinoNavigationBarObjSt(CupertinoNavigationBar? w) {
  final CupertinoNavigationBarObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.largeTitle = _addWidget(w.largeTitle);
  stObj.leading = _addWidget(w.leading);
  stObj.automaticallyImplyLeading = w.automaticallyImplyLeading.toInt();
  stObj.automaticallyImplyMiddle = w.automaticallyImplyMiddle.toInt();
  stObj.previousPageTitle = (w.previousPageTitle != null) ? w.previousPageTitle!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.middle = _addWidget(w.middle);
  stObj.trailing = _addWidget(w.trailing);
  stObj.backgroundColor = _addWidget(w.backgroundColor);
  stObj.automaticBackgroundVisibility = w.automaticBackgroundVisibility.toInt();
  stObj.brightness = (w.brightness != null) ? w.brightness!.index : 0;
  stObj.border = _createBorderObjSt(w.border);
  stObj.transitionBetweenRoutes = w.transitionBetweenRoutes.toInt();
  stObj.enableBackgroundFilterBlur = w.enableBackgroundFilterBlur.toInt();
  stObj.bottom = _addWidget(w.bottom);
  return stObj;
}

void _setupCupertinoSliverNavigationBar(WidgetFactories f) {
  f.cupertinoSliverNavigationBar.cupertinoSliverNavigationBar = ffi.Pointer.fromFunction(cupertinoSliverNavigationBarCupertinoSliverNavigationBar);
  f.cupertinoSliverNavigationBar.search = ffi.Pointer.fromFunction(cupertinoSliverNavigationBarSearch);
}
CupertinoSliverNavigationBarObjSt cupertinoSliverNavigationBarCupertinoSliverNavigationBar(ffi.Pointer<DartObj> largeTitle, ffi.Pointer<DartObj> leading, ffi.Pointer<ffi.Int> automaticallyImplyLeading, ffi.Pointer<ffi.Int> automaticallyImplyTitle, ffi.Pointer<ffi.Int> alwaysShowMiddle, ffi.Pointer<ffi.Char> previousPageTitle, ffi.Pointer<DartObj> middle, ffi.Pointer<DartObj> trailing, ffi.Pointer<DartObj> border, ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<ffi.Int> automaticBackgroundVisibility, ffi.Pointer<ffi.Int> enableBackgroundFilterBlur, ffi.Pointer<ffi.Int> brightness, ffi.Pointer<ffi.Int> transitionBetweenRoutes, ffi.Pointer<ffi.Int> stretch, ffi.Pointer<DartObj> bottom, ffi.Pointer<ffi.Int> bottomMode) {
  final w = CupertinoSliverNavigationBar(largeTitle: largeTitle.objOrNul(),
      leading: leading.objOrNul(),
      automaticallyImplyLeading: automaticallyImplyLeading.boolOr(true),
      automaticallyImplyTitle: automaticallyImplyTitle.boolOr(true),
      alwaysShowMiddle: alwaysShowMiddle.boolOr(true),
      previousPageTitle: previousPageTitle.strOrNul(),
      middle: middle.objOrNul(),
      trailing: trailing.objOrNul(),
      border: border.objOrNul(),
      backgroundColor: backgroundColor.objOrNul(),
      automaticBackgroundVisibility: automaticBackgroundVisibility.boolOr(true),
      enableBackgroundFilterBlur: enableBackgroundFilterBlur.boolOr(true),
      brightness: brightness.enumOrNul(Brightness.values),
      transitionBetweenRoutes: transitionBetweenRoutes.boolOr(true),
      stretch: stretch.boolOr(false),
      bottom: bottom.objOrNul(),
      bottomMode: bottomMode.enumOrNul(NavigationBarBottomMode.values));
  return _createCupertinoSliverNavigationBarObjSt(w);
}
CupertinoSliverNavigationBarObjSt cupertinoSliverNavigationBarSearch(DartDartObj searchField, ffi.Pointer<DartObj> largeTitle, ffi.Pointer<DartObj> leading, ffi.Pointer<ffi.Int> automaticallyImplyLeading, ffi.Pointer<ffi.Int> automaticallyImplyTitle, ffi.Pointer<ffi.Int> alwaysShowMiddle, ffi.Pointer<ffi.Char> previousPageTitle, ffi.Pointer<DartObj> middle, ffi.Pointer<DartObj> trailing, ffi.Pointer<DartObj> border, ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<ffi.Int> automaticBackgroundVisibility, ffi.Pointer<ffi.Int> enableBackgroundFilterBlur, ffi.Pointer<ffi.Int> brightness, ffi.Pointer<ffi.Int> transitionBetweenRoutes, ffi.Pointer<ffi.Int> stretch, ffi.Pointer<ffi.Int> bottomMode, ffi.Pointer<ValueChangedForBoolFFI> onSearchableBottomTap) {
  final w = CupertinoSliverNavigationBar.search(searchField: _widgetsMap[searchField]! as Widget,
      largeTitle: largeTitle.objOrNul(),
      leading: leading.objOrNul(),
      automaticallyImplyLeading: automaticallyImplyLeading.boolOr(true),
      automaticallyImplyTitle: automaticallyImplyTitle.boolOr(true),
      alwaysShowMiddle: alwaysShowMiddle.boolOr(true),
      previousPageTitle: previousPageTitle.strOrNul(),
      middle: middle.objOrNul(),
      trailing: trailing.objOrNul(),
      border: border.objOrNul(),
      backgroundColor: backgroundColor.objOrNul(),
      automaticBackgroundVisibility: automaticBackgroundVisibility.boolOr(true),
      enableBackgroundFilterBlur: enableBackgroundFilterBlur.boolOr(true),
      brightness: brightness.enumOrNul(Brightness.values),
      transitionBetweenRoutes: transitionBetweenRoutes.boolOr(true),
      stretch: stretch.boolOr(false),
      bottomMode: bottomMode.enumOrNul(NavigationBarBottomMode.values),
      onSearchableBottomTap: onSearchableBottomTap.toValueChangedForBoolFn());
  return _createCupertinoSliverNavigationBarObjSt(w);
}
CupertinoSliverNavigationBarObjSt _createCupertinoSliverNavigationBarObjSt(CupertinoSliverNavigationBar? w) {
  final CupertinoSliverNavigationBarObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.largeTitle = _addWidget(w.largeTitle);
  stObj.leading = _addWidget(w.leading);
  stObj.automaticallyImplyLeading = w.automaticallyImplyLeading.toInt();
  stObj.automaticallyImplyTitle = w.automaticallyImplyTitle.toInt();
  stObj.alwaysShowMiddle = w.alwaysShowMiddle.toInt();
  stObj.previousPageTitle = (w.previousPageTitle != null) ? w.previousPageTitle!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.middle = _addWidget(w.middle);
  stObj.trailing = _addWidget(w.trailing);
  stObj.backgroundColor = _addWidget(w.backgroundColor);
  stObj.automaticBackgroundVisibility = w.automaticBackgroundVisibility.toInt();
  stObj.enableBackgroundFilterBlur = w.enableBackgroundFilterBlur.toInt();
  stObj.brightness = (w.brightness != null) ? w.brightness!.index : 0;
  stObj.border = _createBorderObjSt(w.border);
  stObj.transitionBetweenRoutes = w.transitionBetweenRoutes.toInt();
  stObj.bottom = _addWidget(w.bottom);
  stObj.bottomMode = (w.bottomMode != null) ? w.bottomMode!.index : 0;
  stObj.stretch = w.stretch.toInt();
  stObj.searchField = _addWidget(w.searchField);
  stObj.opaque = w.opaque.toInt();
  return stObj;
}

void _setupCupertinoTabView(WidgetFactories f) {
  f.cupertinoTabView.cupertinoTabView = ffi.Pointer.fromFunction(cupertinoTabViewCupertinoTabView);
}
CupertinoTabViewObjSt cupertinoTabViewCupertinoTabView(ffi.Pointer<WidgetBuilderFFI> builder, ffi.Pointer<ffi.Char> defaultTitle, ffi.Pointer<ffi.Char> restorationScopeId) {
  final w = CupertinoTabView(builder: builder.toWidgetBuilderFn(),
      defaultTitle: defaultTitle.strOrNul(),
      restorationScopeId: restorationScopeId.strOrNul());
  return _createCupertinoTabViewObjSt(w);
}
CupertinoTabViewObjSt _createCupertinoTabViewObjSt(CupertinoTabView? w) {
  final CupertinoTabViewObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.defaultTitle = (w.defaultTitle != null) ? w.defaultTitle!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.restorationScopeId = (w.restorationScopeId != null) ? w.restorationScopeId!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  return stObj;
}

void _setupCupertinoButton(WidgetFactories f) {
  f.cupertinoButton.cupertinoButton = ffi.Pointer.fromFunction(cupertinoButtonCupertinoButton);
  f.cupertinoButton.tinted = ffi.Pointer.fromFunction(cupertinoButtonTinted);
  f.cupertinoButton.filled = ffi.Pointer.fromFunction(cupertinoButtonFilled);
  f.cupertinoButton.tapMoveSlop = ffi.Pointer.fromFunction(cupertinoButtonTapMoveSlop, exceptionDouble);
}
CupertinoButtonObjSt cupertinoButtonCupertinoButton(DartDartObj child, ffi.Pointer<ffi.Int> sizeStyle, ffi.Pointer<DartObj> padding, ffi.Pointer<DartObj> color, ffi.Pointer<DartObj> foregroundColor, ffi.Pointer<DartObj> disabledColor, ffi.Pointer<ffi.Double> minSize, ffi.Pointer<ffi.Double> pressedOpacity, ffi.Pointer<DartObj> borderRadius, ffi.Pointer<DartObj> alignment, ffi.Pointer<DartObj> focusColor, ffi.Pointer<ValueChangedForBoolFFI> onFocusChange, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<VoidCallbackFFI> onLongPress, VoidCallbackFFI onPressed) {
  final w = CupertinoButton(child: _widgetsMap[child]! as Widget,
      sizeStyle: sizeStyle.enumOr(CupertinoButtonSize.values, CupertinoButtonSize.large),
      padding: padding.objOrNul(),
      color: color.objOrNul(),
      foregroundColor: foregroundColor.objOrNul(),
      disabledColor: disabledColor.objOr(CupertinoColors.quaternarySystemFill),
      minSize: minSize.doubleOrNul(),
      pressedOpacity: pressedOpacity.doubleOrNul(),
      borderRadius: borderRadius.objOrNul(),
      alignment: alignment.objOr(Alignment.center),
      focusColor: focusColor.objOrNul(),
      onFocusChange: onFocusChange.toValueChangedForBoolFn(),
      autofocus: autofocus.boolOr(false),
      onLongPress: onLongPress.toVoidCallbackFn(),
      onPressed: onPressed.toVoidCallbackFn());
  return _createCupertinoButtonObjSt(w);
}
CupertinoButtonObjSt cupertinoButtonTinted(DartDartObj child, ffi.Pointer<ffi.Int> sizeStyle, ffi.Pointer<DartObj> padding, ffi.Pointer<DartObj> color, ffi.Pointer<DartObj> foregroundColor, ffi.Pointer<DartObj> disabledColor, ffi.Pointer<ffi.Double> minSize, ffi.Pointer<ffi.Double> pressedOpacity, ffi.Pointer<DartObj> borderRadius, ffi.Pointer<DartObj> alignment, ffi.Pointer<DartObj> focusColor, ffi.Pointer<ValueChangedForBoolFFI> onFocusChange, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<VoidCallbackFFI> onLongPress, VoidCallbackFFI onPressed) {
  final w = CupertinoButton.tinted(child: _widgetsMap[child]! as Widget,
      sizeStyle: sizeStyle.enumOr(CupertinoButtonSize.values, CupertinoButtonSize.large),
      padding: padding.objOrNul(),
      color: color.objOrNul(),
      foregroundColor: foregroundColor.objOrNul(),
      disabledColor: disabledColor.objOr(CupertinoColors.tertiarySystemFill),
      minSize: minSize.doubleOrNul(),
      pressedOpacity: pressedOpacity.doubleOrNul(),
      borderRadius: borderRadius.objOrNul(),
      alignment: alignment.objOr(Alignment.center),
      focusColor: focusColor.objOrNul(),
      onFocusChange: onFocusChange.toValueChangedForBoolFn(),
      autofocus: autofocus.boolOr(false),
      onLongPress: onLongPress.toVoidCallbackFn(),
      onPressed: onPressed.toVoidCallbackFn());
  return _createCupertinoButtonObjSt(w);
}
CupertinoButtonObjSt cupertinoButtonFilled(DartDartObj child, ffi.Pointer<ffi.Int> sizeStyle, ffi.Pointer<DartObj> padding, ffi.Pointer<DartObj> color, ffi.Pointer<DartObj> disabledColor, ffi.Pointer<DartObj> foregroundColor, ffi.Pointer<ffi.Double> minSize, ffi.Pointer<ffi.Double> pressedOpacity, ffi.Pointer<DartObj> borderRadius, ffi.Pointer<DartObj> alignment, ffi.Pointer<DartObj> focusColor, ffi.Pointer<ValueChangedForBoolFFI> onFocusChange, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<VoidCallbackFFI> onLongPress, VoidCallbackFFI onPressed) {
  final w = CupertinoButton.filled(child: _widgetsMap[child]! as Widget,
      sizeStyle: sizeStyle.enumOr(CupertinoButtonSize.values, CupertinoButtonSize.large),
      padding: padding.objOrNul(),
      color: color.objOrNul(),
      disabledColor: disabledColor.objOr(CupertinoColors.tertiarySystemFill),
      foregroundColor: foregroundColor.objOrNul(),
      minSize: minSize.doubleOrNul(),
      pressedOpacity: pressedOpacity.doubleOrNul(),
      borderRadius: borderRadius.objOrNul(),
      alignment: alignment.objOr(Alignment.center),
      focusColor: focusColor.objOrNul(),
      onFocusChange: onFocusChange.toValueChangedForBoolFn(),
      autofocus: autofocus.boolOr(false),
      onLongPress: onLongPress.toVoidCallbackFn(),
      onPressed: onPressed.toVoidCallbackFn());
  return _createCupertinoButtonObjSt(w);
}
double cupertinoButtonTapMoveSlop() {
  final w = CupertinoButton.tapMoveSlop();
  return w;
}
CupertinoButtonObjSt _createCupertinoButtonObjSt(CupertinoButton? w) {
  final CupertinoButtonObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.child = _addWidget(w.child);
  stObj.padding = _addWidget(w.padding);
  stObj.color = _addWidget(w.color);
  stObj.disabledColor = _addWidget(w.disabledColor);
  stObj.foregroundColor = _addWidget(w.foregroundColor);
  stObj.minSize = (w.minSize != null) ? w.minSize! : 0;
  stObj.pressedOpacity = (w.pressedOpacity != null) ? w.pressedOpacity! : 0;
  stObj.borderRadius = _createBorderRadiusObjSt(w.borderRadius);
  stObj.sizeStyle = w.sizeStyle.index;
  stObj.alignment = _addWidget(w.alignment);
  stObj.focusColor = _addWidget(w.focusColor);
  stObj.autofocus = w.autofocus.toInt();
  stObj.enabled = w.enabled.toInt();
  return stObj;
}

void _setupCupertinoSwitch(WidgetFactories f) {
  f.cupertinoSwitch.cupertinoSwitch = ffi.Pointer.fromFunction(cupertinoSwitchCupertinoSwitch);
}
CupertinoSwitchObjSt cupertinoSwitchCupertinoSwitch(int value, ValueChangedForBoolFFI onChanged, ffi.Pointer<DartObj> activeColor, ffi.Pointer<DartObj> trackColor, ffi.Pointer<DartObj> activeTrackColor, ffi.Pointer<DartObj> inactiveTrackColor, ffi.Pointer<DartObj> thumbColor, ffi.Pointer<DartObj> inactiveThumbColor, ffi.Pointer<ffi.Int> applyTheme, ffi.Pointer<DartObj> focusColor, ffi.Pointer<DartObj> onLabelColor, ffi.Pointer<DartObj> offLabelColor, ffi.Pointer<DartObj> trackOutlineColor, ffi.Pointer<ffi.Double> trackOutlineWidth, ffi.Pointer<DartObj> thumbIcon, ffi.Pointer<ValueChangedForBoolFFI> onFocusChange, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<ffi.Int> dragStartBehavior) {
  final w = CupertinoSwitch(value: value.toBool(),
      onChanged: onChanged.toValueChangedForBoolFn(),
      activeColor: activeColor.objOrNul(),
      trackColor: trackColor.objOrNul(),
      activeTrackColor: activeTrackColor.objOrNul(),
      inactiveTrackColor: inactiveTrackColor.objOrNul(),
      thumbColor: thumbColor.objOrNul(),
      inactiveThumbColor: inactiveThumbColor.objOrNul(),
      applyTheme: applyTheme.boolOrNul(),
      focusColor: focusColor.objOrNul(),
      onLabelColor: onLabelColor.objOrNul(),
      offLabelColor: offLabelColor.objOrNul(),
      trackOutlineColor: _wspNul<Color?>(trackOutlineColor.objOrNul()),
      trackOutlineWidth: _wspNul<double?>(trackOutlineWidth.doubleOrNul()),
      thumbIcon: _wspNul<Icon?>(thumbIcon.objOrNul()),
      onFocusChange: onFocusChange.toValueChangedForBoolFn(),
      autofocus: autofocus.boolOr(false),
      dragStartBehavior: dragStartBehavior.enumOr(DragStartBehavior.values, DragStartBehavior.start));
  return _createCupertinoSwitchObjSt(w);
}
CupertinoSwitchObjSt _createCupertinoSwitchObjSt(CupertinoSwitch? w) {
  final CupertinoSwitchObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.value = w.value.toInt();
  stObj.activeTrackColor = _addWidget(w.activeTrackColor);
  stObj.inactiveTrackColor = _addWidget(w.inactiveTrackColor);
  stObj.thumbColor = _addWidget(w.thumbColor);
  stObj.inactiveThumbColor = _addWidget(w.inactiveThumbColor);
  stObj.focusColor = _addWidget(w.focusColor);
  stObj.onLabelColor = _addWidget(w.onLabelColor);
  stObj.offLabelColor = _addWidget(w.offLabelColor);
  stObj.autofocus = w.autofocus.toInt();
  stObj.applyTheme = (w.applyTheme != null) ? w.applyTheme!.toInt() : 0;
  stObj.dragStartBehavior = w.dragStartBehavior.index;
  stObj.activeColor = _addWidget(w.activeColor);
  stObj.trackColor = _addWidget(w.trackColor);
  return stObj;
}

void _setupCupertinoSlider(WidgetFactories f) {
  f.cupertinoSlider.cupertinoSlider = ffi.Pointer.fromFunction(cupertinoSliderCupertinoSlider);
}
CupertinoSliderObjSt cupertinoSliderCupertinoSlider(double value, ValueChangedForDoubleFFI onChanged, ffi.Pointer<ValueChangedForDoubleFFI> onChangeStart, ffi.Pointer<ValueChangedForDoubleFFI> onChangeEnd, ffi.Pointer<ffi.Double> min, ffi.Pointer<ffi.Double> max, ffi.Pointer<ffi.Int> divisions, ffi.Pointer<DartObj> activeColor, ffi.Pointer<DartObj> thumbColor) {
  final w = CupertinoSlider(value: value,
      onChanged: onChanged.toValueChangedForDoubleFn(),
      onChangeStart: onChangeStart.toValueChangedForDoubleFn(),
      onChangeEnd: onChangeEnd.toValueChangedForDoubleFn(),
      min: min.doubleOr(0.0),
      max: max.doubleOr(1.0),
      divisions: divisions.intOrNul(),
      activeColor: activeColor.objOrNul(),
      thumbColor: thumbColor.objOr(CupertinoColors.white));
  return _createCupertinoSliderObjSt(w);
}
CupertinoSliderObjSt _createCupertinoSliderObjSt(CupertinoSlider? w) {
  final CupertinoSliderObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.value = w.value;
  stObj.min = w.min;
  stObj.max = w.max;
  stObj.divisions = (w.divisions != null) ? w.divisions! : 0;
  stObj.activeColor = _addWidget(w.activeColor);
  stObj.thumbColor = _addWidget(w.thumbColor);
  return stObj;
}

void _setupCupertinoSearchTextField(WidgetFactories f) {
  f.cupertinoSearchTextField.cupertinoSearchTextField = ffi.Pointer.fromFunction(cupertinoSearchTextFieldCupertinoSearchTextField);
}
CupertinoSearchTextFieldObjSt cupertinoSearchTextFieldCupertinoSearchTextField(ffi.Pointer<ValueChangedForStringFFI> onChanged, ffi.Pointer<ValueChangedForStringFFI> onSubmitted, ffi.Pointer<DartObj> style, ffi.Pointer<ffi.Char> placeholder, ffi.Pointer<DartObj> placeholderStyle, ffi.Pointer<DartObj> decoration, ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<DartObj> borderRadius, ffi.Pointer<DartObj> padding, ffi.Pointer<DartObj> itemColor, ffi.Pointer<ffi.Double> itemSize, ffi.Pointer<DartObj> prefixInsets, ffi.Pointer<DartObj> prefixIcon, ffi.Pointer<DartObj> suffixInsets, ffi.Pointer<DartObj> suffixIcon, ffi.Pointer<ffi.Int> suffixMode, ffi.Pointer<VoidCallbackFFI> onSuffixTap, ffi.Pointer<ffi.Char> restorationId, ffi.Pointer<ffi.Int> smartQuotesType, ffi.Pointer<ffi.Int> smartDashesType, ffi.Pointer<ffi.Int> enableIMEPersonalizedLearning, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<VoidCallbackFFI> onTap, ffi.Pointer<ffi.Int> autocorrect, ffi.Pointer<ffi.Int> enabled, ffi.Pointer<ffi.Double> cursorWidth, ffi.Pointer<ffi.Double> cursorHeight, ffi.Pointer<DartObj> cursorRadius, ffi.Pointer<ffi.Int> cursorOpacityAnimates, ffi.Pointer<DartObj> cursorColor) {
  final w = CupertinoSearchTextField(onChanged: onChanged.toValueChangedForStringFn(),
      onSubmitted: onSubmitted.toValueChangedForStringFn(),
      style: style.objOrNul(),
      placeholder: placeholder.strOrNul(),
      placeholderStyle: placeholderStyle.objOrNul(),
      decoration: decoration.objOrNul(),
      backgroundColor: backgroundColor.objOrNul(),
      borderRadius: borderRadius.objOrNul(),
      padding: padding.objOr(const EdgeInsetsDirectional.fromSTEB(5.5, 8, 5.5, 8)),
      itemColor: itemColor.objOr(CupertinoColors.secondaryLabel),
      itemSize: itemSize.doubleOr(20.0),
      prefixInsets: prefixInsets.objOr(const EdgeInsetsDirectional.fromSTEB(6, 8, 0, 8)),
      prefixIcon: prefixIcon.objOr(const Icon(CupertinoIcons.search)),
      suffixInsets: suffixInsets.objOr(const EdgeInsetsDirectional.fromSTEB(0, 8, 5, 8)),
      suffixIcon: suffixIcon.objOr(const Icon(CupertinoIcons.xmark_circle_fill)),
      suffixMode: suffixMode.enumOr(OverlayVisibilityMode.values, OverlayVisibilityMode.editing),
      onSuffixTap: onSuffixTap.toVoidCallbackFn(),
      restorationId: restorationId.strOrNul(),
      smartQuotesType: smartQuotesType.enumOrNul(SmartQuotesType.values),
      smartDashesType: smartDashesType.enumOrNul(SmartDashesType.values),
      enableIMEPersonalizedLearning: enableIMEPersonalizedLearning.boolOr(true),
      autofocus: autofocus.boolOr(false),
      onTap: onTap.toVoidCallbackFn(),
      autocorrect: autocorrect.boolOr(true),
      enabled: enabled.boolOrNul(),
      cursorWidth: cursorWidth.doubleOr(2.0),
      cursorHeight: cursorHeight.doubleOrNul(),
      cursorRadius: cursorRadius.objOr(const Radius.circular(2.0)),
      cursorOpacityAnimates: cursorOpacityAnimates.boolOr(true),
      cursorColor: cursorColor.objOrNul());
  return _createCupertinoSearchTextFieldObjSt(w);
}
CupertinoSearchTextFieldObjSt _createCupertinoSearchTextFieldObjSt(CupertinoSearchTextField? w) {
  final CupertinoSearchTextFieldObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.style = _createTextStyleObjSt(w.style);
  stObj.placeholder = (w.placeholder != null) ? w.placeholder!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.placeholderStyle = _createTextStyleObjSt(w.placeholderStyle);
  stObj.decoration = _createBoxDecorationObjSt(w.decoration);
  stObj.backgroundColor = _addWidget(w.backgroundColor);
  stObj.borderRadius = _createBorderRadiusObjSt(w.borderRadius);
  stObj.padding = _addWidget(w.padding);
  stObj.itemColor = _addWidget(w.itemColor);
  stObj.itemSize = w.itemSize;
  stObj.prefixInsets = _addWidget(w.prefixInsets);
  stObj.prefixIcon = _addWidget(w.prefixIcon);
  stObj.suffixInsets = _addWidget(w.suffixInsets);
  stObj.suffixIcon = _createIconObjSt(w.suffixIcon);
  stObj.suffixMode = w.suffixMode.index;
  stObj.restorationId = (w.restorationId != null) ? w.restorationId!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.autofocus = w.autofocus.toInt();
  stObj.autocorrect = w.autocorrect.toInt();
  stObj.smartQuotesType = (w.smartQuotesType != null) ? w.smartQuotesType!.index : 0;
  stObj.smartDashesType = (w.smartDashesType != null) ? w.smartDashesType!.index : 0;
  stObj.enableIMEPersonalizedLearning = w.enableIMEPersonalizedLearning.toInt();
  stObj.enabled = (w.enabled != null) ? w.enabled!.toInt() : 0;
  stObj.cursorWidth = w.cursorWidth;
  stObj.cursorHeight = (w.cursorHeight != null) ? w.cursorHeight! : 0;
  stObj.cursorRadius = _addWidget(w.cursorRadius);
  stObj.cursorOpacityAnimates = w.cursorOpacityAnimates.toInt();
  stObj.cursorColor = _addWidget(w.cursorColor);
  return stObj;
}

void _setupCupertinoActivityIndicator(WidgetFactories f) {
  f.cupertinoActivityIndicator.cupertinoActivityIndicator = ffi.Pointer.fromFunction(cupertinoActivityIndicatorCupertinoActivityIndicator);
  f.cupertinoActivityIndicator.partiallyRevealed = ffi.Pointer.fromFunction(cupertinoActivityIndicatorPartiallyRevealed);
}
CupertinoActivityIndicatorObjSt cupertinoActivityIndicatorCupertinoActivityIndicator(ffi.Pointer<DartObj> color, ffi.Pointer<ffi.Int> animating, ffi.Pointer<ffi.Double> radius) {
  final w = CupertinoActivityIndicator(color: color.objOrNul(),
      animating: animating.boolOr(true),
      radius: radius.doubleOr(10.0));
  return _createCupertinoActivityIndicatorObjSt(w);
}
CupertinoActivityIndicatorObjSt cupertinoActivityIndicatorPartiallyRevealed(ffi.Pointer<DartObj> color, ffi.Pointer<ffi.Double> radius, ffi.Pointer<ffi.Double> progress) {
  final w = CupertinoActivityIndicator.partiallyRevealed(color: color.objOrNul(),
      radius: radius.doubleOr(10.0),
      progress: progress.doubleOr(1.0));
  return _createCupertinoActivityIndicatorObjSt(w);
}
CupertinoActivityIndicatorObjSt _createCupertinoActivityIndicatorObjSt(CupertinoActivityIndicator? w) {
  final CupertinoActivityIndicatorObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.color = _addWidget(w.color);
  stObj.animating = w.animating.toInt();
  stObj.radius = w.radius;
  stObj.progress = w.progress;
  return stObj;
}

void _setupCupertinoListSection(WidgetFactories f) {
  f.cupertinoListSection.cupertinoListSection = ffi.Pointer.fromFunction(cupertinoListSectionCupertinoListSection);
  f.cupertinoListSection.insetGrouped = ffi.Pointer.fromFunction(cupertinoListSectionInsetGrouped);
}
CupertinoListSectionObjSt cupertinoListSectionCupertinoListSection(ffi.Pointer<ArrayC> children, ffi.Pointer<DartObj> header, ffi.Pointer<DartObj> footer, ffi.Pointer<DartObj> margin, ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<DartObj> decoration, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<ffi.Double> dividerMargin, ffi.Pointer<ffi.Double> additionalDividerMargin, ffi.Pointer<ffi.Double> topMargin, ffi.Pointer<ffi.Int> hasLeading, ffi.Pointer<DartObj> separatorColor) {
  final w = CupertinoListSection(children: children.listOrNul(),
      header: header.objOrNul(),
      footer: footer.objOrNul(),
      margin: margin.objOr(EdgeInsets.only(bottom: 8.0)),
      backgroundColor: backgroundColor.objOr(CupertinoColors.systemGroupedBackground),
      decoration: decoration.objOrNul(),
      clipBehavior: clipBehavior.enumOr(Clip.values, Clip.none),
      dividerMargin: dividerMargin.doubleOr(20.0),
      additionalDividerMargin: additionalDividerMargin.doubleOrNul(),
      topMargin: topMargin.doubleOrNul(),
      hasLeading: hasLeading.boolOr(true),
      separatorColor: separatorColor.objOrNul());
  return _createCupertinoListSectionObjSt(w);
}
CupertinoListSectionObjSt cupertinoListSectionInsetGrouped(ffi.Pointer<ArrayC> children, ffi.Pointer<DartObj> header, ffi.Pointer<DartObj> footer, ffi.Pointer<DartObj> margin, ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<DartObj> decoration, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<ffi.Double> dividerMargin, ffi.Pointer<ffi.Double> additionalDividerMargin, ffi.Pointer<ffi.Double> topMargin, ffi.Pointer<ffi.Int> hasLeading, ffi.Pointer<DartObj> separatorColor) {
  final w = CupertinoListSection.insetGrouped(children: children.listOrNul(),
      header: header.objOrNul(),
      footer: footer.objOrNul(),
      margin: margin.objOrNul(),
      backgroundColor: backgroundColor.objOr(CupertinoColors.systemGroupedBackground),
      decoration: decoration.objOrNul(),
      clipBehavior: clipBehavior.enumOr(Clip.values, Clip.hardEdge),
      dividerMargin: dividerMargin.doubleOr(14.0),
      additionalDividerMargin: additionalDividerMargin.doubleOrNul(),
      topMargin: topMargin.doubleOrNul(),
      hasLeading: hasLeading.boolOr(true),
      separatorColor: separatorColor.objOrNul());
  return _createCupertinoListSectionObjSt(w);
}
CupertinoListSectionObjSt _createCupertinoListSectionObjSt(CupertinoListSection? w) {
  final CupertinoListSectionObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.type = w.type.index;
  stObj.header = _addWidget(w.header);
  stObj.footer = _addWidget(w.footer);
  stObj.margin = _addWidget(w.margin);
  stObj.decoration = _createBoxDecorationObjSt(w.decoration);
  stObj.backgroundColor = _addWidget(w.backgroundColor);
  stObj.clipBehavior = w.clipBehavior.index;
  stObj.dividerMargin = w.dividerMargin;
  stObj.additionalDividerMargin = w.additionalDividerMargin;
  stObj.topMargin = (w.topMargin != null) ? w.topMargin! : 0;
  stObj.separatorColor = _addWidget(w.separatorColor);
  return stObj;
}

void _setupCupertinoListTile(WidgetFactories f) {
  f.cupertinoListTile.cupertinoListTile = ffi.Pointer.fromFunction(cupertinoListTileCupertinoListTile);
  f.cupertinoListTile.notched = ffi.Pointer.fromFunction(cupertinoListTileNotched);
}
CupertinoListTileObjSt cupertinoListTileCupertinoListTile(DartDartObj title, ffi.Pointer<DartObj> subtitle, ffi.Pointer<DartObj> additionalInfo, ffi.Pointer<DartObj> leading, ffi.Pointer<DartObj> trailing, ffi.Pointer<VoidCallbackFFI> onTap, ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<DartObj> backgroundColorActivated, ffi.Pointer<DartObj> padding, ffi.Pointer<ffi.Double> leadingSize, ffi.Pointer<ffi.Double> leadingToTitle) {
  final w = CupertinoListTile(title: _widgetsMap[title]! as Widget,
      subtitle: subtitle.objOrNul(),
      additionalInfo: additionalInfo.objOrNul(),
      leading: leading.objOrNul(),
      trailing: trailing.objOrNul(),
      onTap: onTap.toVoidCallbackFn(),
      backgroundColor: backgroundColor.objOrNul(),
      backgroundColorActivated: backgroundColorActivated.objOrNul(),
      padding: padding.objOrNul(),
      leadingSize: leadingSize.doubleOr(28.0),
      leadingToTitle: leadingToTitle.doubleOr(16.0));
  return _createCupertinoListTileObjSt(w);
}
CupertinoListTileObjSt cupertinoListTileNotched(DartDartObj title, ffi.Pointer<DartObj> subtitle, ffi.Pointer<DartObj> additionalInfo, ffi.Pointer<DartObj> leading, ffi.Pointer<DartObj> trailing, ffi.Pointer<VoidCallbackFFI> onTap, ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<DartObj> backgroundColorActivated, ffi.Pointer<DartObj> padding, ffi.Pointer<ffi.Double> leadingSize, ffi.Pointer<ffi.Double> leadingToTitle) {
  final w = CupertinoListTile.notched(title: _widgetsMap[title]! as Widget,
      subtitle: subtitle.objOrNul(),
      additionalInfo: additionalInfo.objOrNul(),
      leading: leading.objOrNul(),
      trailing: trailing.objOrNul(),
      onTap: onTap.toVoidCallbackFn(),
      backgroundColor: backgroundColor.objOrNul(),
      backgroundColorActivated: backgroundColorActivated.objOrNul(),
      padding: padding.objOrNul(),
      leadingSize: leadingSize.doubleOr(30.0),
      leadingToTitle: leadingToTitle.doubleOr(12.0));
  return _createCupertinoListTileObjSt(w);
}
CupertinoListTileObjSt _createCupertinoListTileObjSt(CupertinoListTile? w) {
  final CupertinoListTileObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.title = _addWidget(w.title);
  stObj.subtitle = _addWidget(w.subtitle);
  stObj.additionalInfo = _addWidget(w.additionalInfo);
  stObj.leading = _addWidget(w.leading);
  stObj.trailing = _addWidget(w.trailing);
  stObj.backgroundColor = _addWidget(w.backgroundColor);
  stObj.backgroundColorActivated = _addWidget(w.backgroundColorActivated);
  stObj.padding = _addWidget(w.padding);
  stObj.leadingSize = w.leadingSize;
  stObj.leadingToTitle = w.leadingToTitle;
  return stObj;
}

void _setupCupertinoListTileChevron(WidgetFactories f) {
  f.cupertinoListTileChevron.cupertinoListTileChevron = ffi.Pointer.fromFunction(cupertinoListTileChevronCupertinoListTileChevron);
}
CupertinoListTileChevronObjSt cupertinoListTileChevronCupertinoListTileChevron() {
  final w = CupertinoListTileChevron();
  return _createCupertinoListTileChevronObjSt(w);
}
CupertinoListTileChevronObjSt _createCupertinoListTileChevronObjSt(CupertinoListTileChevron? w) {
  final CupertinoListTileChevronObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  return stObj;
}

void _setupCupertinoFormSection(WidgetFactories f) {
  f.cupertinoFormSection.cupertinoFormSection = ffi.Pointer.fromFunction(cupertinoFormSectionCupertinoFormSection);
  f.cupertinoFormSection.insetGrouped = ffi.Pointer.fromFunction(cupertinoFormSectionInsetGrouped);
}
CupertinoFormSectionObjSt cupertinoFormSectionCupertinoFormSection(ArrayC children, ffi.Pointer<DartObj> header, ffi.Pointer<DartObj> footer, ffi.Pointer<DartObj> margin, ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<DartObj> decoration, ffi.Pointer<ffi.Int> clipBehavior) {
  final w = CupertinoFormSection(children: children.listOrEmpty(),
      header: header.objOrNul(),
      footer: footer.objOrNul(),
      margin: margin.objOr(EdgeInsets.zero),
      backgroundColor: backgroundColor.objOr(CupertinoColors.systemGroupedBackground),
      decoration: decoration.objOrNul(),
      clipBehavior: clipBehavior.enumOr(Clip.values, Clip.none));
  return _createCupertinoFormSectionObjSt(w);
}
CupertinoFormSectionObjSt cupertinoFormSectionInsetGrouped(ArrayC children, ffi.Pointer<DartObj> header, ffi.Pointer<DartObj> footer, ffi.Pointer<DartObj> margin, ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<DartObj> decoration, ffi.Pointer<ffi.Int> clipBehavior) {
  final w = CupertinoFormSection.insetGrouped(children: children.listOrEmpty(),
      header: header.objOrNul(),
      footer: footer.objOrNul(),
      margin: margin.objOr(EdgeInsetsDirectional.fromSTEB(20.0, 0.0, 20.0, 10.0)),
      backgroundColor: backgroundColor.objOr(CupertinoColors.systemGroupedBackground),
      decoration: decoration.objOrNul(),
      clipBehavior: clipBehavior.enumOr(Clip.values, Clip.none));
  return _createCupertinoFormSectionObjSt(w);
}
CupertinoFormSectionObjSt _createCupertinoFormSectionObjSt(CupertinoFormSection? w) {
  final CupertinoFormSectionObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.header = _addWidget(w.header);
  stObj.footer = _addWidget(w.footer);
  stObj.margin = _addWidget(w.margin);
  stObj.decoration = _createBoxDecorationObjSt(w.decoration);
  stObj.backgroundColor = _addWidget(w.backgroundColor);
  stObj.clipBehavior = w.clipBehavior.index;
  return stObj;
}

void _setupCupertinoFormRow(WidgetFactories f) {
  f.cupertinoFormRow.cupertinoFormRow = ffi.Pointer.fromFunction(cupertinoFormRowCupertinoFormRow);
}
CupertinoFormRowObjSt cupertinoFormRowCupertinoFormRow(DartDartObj child, ffi.Pointer<DartObj> prefix, ffi.Pointer<DartObj> padding, ffi.Pointer<DartObj> helper, ffi.Pointer<DartObj> error) {
  final w = CupertinoFormRow(child: _widgetsMap[child]! as Widget,
      prefix: prefix.objOrNul(),
      padding: padding.objOrNul(),
      helper: helper.objOrNul(),
      error: error.objOrNul());
  return _createCupertinoFormRowObjSt(w);
}
CupertinoFormRowObjSt _createCupertinoFormRowObjSt(CupertinoFormRow? w) {
  final CupertinoFormRowObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.prefix = _addWidget(w.prefix);
  stObj.padding = _addWidget(w.padding);
  stObj.helper = _addWidget(w.helper);
  stObj.error = _addWidget(w.error);
  stObj.child = _addWidget(w.child);
  return stObj;
}

void _setupCupertinoPicker(WidgetFactories f) {
  f.cupertinoPicker.cupertinoPicker = ffi.Pointer.fromFunction(cupertinoPickerCupertinoPicker);
  f.cupertinoPicker.builder = ffi.Pointer.fromFunction(cupertinoPickerBuilder);
}
CupertinoPickerObjSt cupertinoPickerCupertinoPicker(ffi.Pointer<ffi.Double> diameterRatio, ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<ffi.Double> offAxisFraction, ffi.Pointer<ffi.Int> useMagnifier, ffi.Pointer<ffi.Double> magnification, ffi.Pointer<ffi.Double> squeeze, ffi.Pointer<ffi.Int> changeReportingBehavior, double itemExtent, ValueChangedForIntFFI onSelectedItemChanged, ArrayC children, ffi.Pointer<DartObj> selectionOverlay, ffi.Pointer<ffi.Int> looping) {
  final w = CupertinoPicker(diameterRatio: diameterRatio.doubleOr(1.07),
      backgroundColor: backgroundColor.objOrNul(),
      offAxisFraction: offAxisFraction.doubleOr(0.0),
      useMagnifier: useMagnifier.boolOr(false),
      magnification: magnification.doubleOr(1.0),
      squeeze: squeeze.doubleOr(1.45),
      changeReportingBehavior: changeReportingBehavior.enumOr(ChangeReportingBehavior.values, ChangeReportingBehavior.onScrollUpdate),
      itemExtent: itemExtent,
      onSelectedItemChanged: onSelectedItemChanged.toValueChangedForIntFn(),
      children: children.listOrEmpty(),
      selectionOverlay: selectionOverlay.objOrNul(),
      looping: looping.boolOr(false));
  return _createCupertinoPickerObjSt(w);
}
CupertinoPickerObjSt cupertinoPickerBuilder(ffi.Pointer<ffi.Double> diameterRatio, ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<ffi.Double> offAxisFraction, ffi.Pointer<ffi.Int> useMagnifier, ffi.Pointer<ffi.Double> magnification, ffi.Pointer<ffi.Double> squeeze, ffi.Pointer<ffi.Int> changeReportingBehavior, double itemExtent, ValueChangedForIntFFI onSelectedItemChanged, NullableIndexedWidgetBuilderFFI itemBuilder, ffi.Pointer<ffi.Int> childCount, ffi.Pointer<DartObj> selectionOverlay) {
  final w = CupertinoPicker.builder(diameterRatio: diameterRatio.doubleOr(1.07),
      backgroundColor: backgroundColor.objOrNul(),
      offAxisFraction: offAxisFraction.doubleOr(0.0),
      useMagnifier: useMagnifier.boolOr(false),
      magnification: magnification.doubleOr(1.0),
      squeeze: squeeze.doubleOr(1.45),
      changeReportingBehavior: changeReportingBehavior.enumOr(ChangeReportingBehavior.values, ChangeReportingBehavior.onScrollUpdate),
      itemExtent: itemExtent,
      onSelectedItemChanged: onSelectedItemChanged.toValueChangedForIntFn(),
      itemBuilder: itemBuilder.toNullableIndexedWidgetBuilderFn(),
      childCount: childCount.intOrNul(),
      selectionOverlay: selectionOverlay.objOrNul());
  return _createCupertinoPickerObjSt(w);
}
CupertinoPickerObjSt _createCupertinoPickerObjSt(CupertinoPicker? w) {
  final CupertinoPickerObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.diameterRatio = w.diameterRatio;
  stObj.backgroundColor = _addWidget(w.backgroundColor);
  stObj.offAxisFraction = w.offAxisFraction;
  stObj.useMagnifier = w.useMagnifier.toInt();
  stObj.magnification = w.magnification;
  stObj.itemExtent = w.itemExtent;
  stObj.squeeze = w.squeeze;
  stObj.changeReportingBehavior = w.changeReportingBehavior.index;
  stObj.selectionOverlay = _addWidget(w.selectionOverlay);
  return stObj;
}

void _setupCupertinoAlertDialog(WidgetFactories f) {
  f.cupertinoAlertDialog.cupertinoAlertDialog = ffi.Pointer.fromFunction(cupertinoAlertDialogCupertinoAlertDialog);
}
CupertinoAlertDialogObjSt cupertinoAlertDialogCupertinoAlertDialog(ffi.Pointer<DartObj> title, ffi.Pointer<DartObj> content, ffi.Pointer<ArrayC> actions, ffi.Pointer<DartObj> insetAnimationDuration, ffi.Pointer<DartObj> insetAnimationCurve) {
  final w = CupertinoAlertDialog(title: title.objOrNul(),
      content: content.objOrNul(),
      actions: actions.listOrEmpty(),
      insetAnimationDuration: insetAnimationDuration.objOr(const Duration(milliseconds: 100)),
      insetAnimationCurve: insetAnimationCurve.objOr(Curves.decelerate));
  return _createCupertinoAlertDialogObjSt(w);
}
CupertinoAlertDialogObjSt _createCupertinoAlertDialogObjSt(CupertinoAlertDialog? w) {
  final CupertinoAlertDialogObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.title = _addWidget(w.title);
  stObj.content = _addWidget(w.content);
  stObj.insetAnimationDuration = _addWidget(w.insetAnimationDuration);
  stObj.insetAnimationCurve = _addWidget(w.insetAnimationCurve);
  return stObj;
}

void _setupCupertinoActionSheet(WidgetFactories f) {
  f.cupertinoActionSheet.cupertinoActionSheet = ffi.Pointer.fromFunction(cupertinoActionSheetCupertinoActionSheet);
}
CupertinoActionSheetObjSt cupertinoActionSheetCupertinoActionSheet(ffi.Pointer<DartObj> title, ffi.Pointer<DartObj> message, ffi.Pointer<ArrayC> actions, ffi.Pointer<DartObj> cancelButton) {
  final w = CupertinoActionSheet(title: title.objOrNul(),
      message: message.objOrNul(),
      actions: actions.listOrNul(),
      cancelButton: cancelButton.objOrNul());
  return _createCupertinoActionSheetObjSt(w);
}
CupertinoActionSheetObjSt _createCupertinoActionSheetObjSt(CupertinoActionSheet? w) {
  final CupertinoActionSheetObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.title = _addWidget(w.title);
  stObj.message = _addWidget(w.message);
  stObj.cancelButton = _addWidget(w.cancelButton);
  return stObj;
}

void _setupCupertinoDialogAction(WidgetFactories f) {
  f.cupertinoDialogAction.cupertinoDialogAction = ffi.Pointer.fromFunction(cupertinoDialogActionCupertinoDialogAction);
}
CupertinoDialogActionObjSt cupertinoDialogActionCupertinoDialogAction(ffi.Pointer<VoidCallbackFFI> onPressed, ffi.Pointer<ffi.Int> isDefaultAction, ffi.Pointer<ffi.Int> isDestructiveAction, ffi.Pointer<DartObj> textStyle, DartDartObj child) {
  final w = CupertinoDialogAction(onPressed: onPressed.toVoidCallbackFn(),
      isDefaultAction: isDefaultAction.boolOr(false),
      isDestructiveAction: isDestructiveAction.boolOr(false),
      textStyle: textStyle.objOrNul(),
      child: _widgetsMap[child]! as Widget);
  return _createCupertinoDialogActionObjSt(w);
}
CupertinoDialogActionObjSt _createCupertinoDialogActionObjSt(CupertinoDialogAction? w) {
  final CupertinoDialogActionObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.isDefaultAction = w.isDefaultAction.toInt();
  stObj.isDestructiveAction = w.isDestructiveAction.toInt();
  stObj.textStyle = _createTextStyleObjSt(w.textStyle);
  stObj.child = _addWidget(w.child);
  return stObj;
}

void _setupCupertinoActionSheetAction(WidgetFactories f) {
  f.cupertinoActionSheetAction.cupertinoActionSheetAction = ffi.Pointer.fromFunction(cupertinoActionSheetActionCupertinoActionSheetAction);
}
CupertinoActionSheetActionObjSt cupertinoActionSheetActionCupertinoActionSheetAction(VoidCallbackFFI onPressed, ffi.Pointer<ffi.Int> isDefaultAction, ffi.Pointer<ffi.Int> isDestructiveAction, DartDartObj child) {
  final w = CupertinoActionSheetAction(onPressed: onPressed.toVoidCallbackFn(),
      isDefaultAction: isDefaultAction.boolOr(false),
      isDestructiveAction: isDestructiveAction.boolOr(false),
      child: _widgetsMap[child]! as Widget);
  return _createCupertinoActionSheetActionObjSt(w);
}
CupertinoActionSheetActionObjSt _createCupertinoActionSheetActionObjSt(CupertinoActionSheetAction? w) {
  final CupertinoActionSheetActionObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.isDefaultAction = w.isDefaultAction.toInt();
  stObj.isDestructiveAction = w.isDestructiveAction.toInt();
  stObj.child = _addWidget(w.child);
  return stObj;
}

void _setupCupertinoTextField(WidgetFactories f) {
  f.cupertinoTextField.cupertinoTextField = ffi.Pointer.fromFunction(cupertinoTextFieldCupertinoTextField);
  f.cupertinoTextField.borderless = ffi.Pointer.fromFunction(cupertinoTextFieldBorderless);
}
CupertinoTextFieldObjSt cupertinoTextFieldCupertinoTextField(ffi.Pointer<DartObj> groupId, ffi.Pointer<DartObj> decoration, ffi.Pointer<DartObj> padding, ffi.Pointer<ffi.Char> placeholder, ffi.Pointer<DartObj> placeholderStyle, ffi.Pointer<DartObj> prefix, ffi.Pointer<ffi.Int> prefixMode, ffi.Pointer<DartObj> suffix, ffi.Pointer<ffi.Int> suffixMode, ffi.Pointer<ffi.Int> crossAxisAlignment, ffi.Pointer<ffi.Int> clearButtonMode, ffi.Pointer<ffi.Char> clearButtonSemanticLabel, ffi.Pointer<ffi.Int> textInputAction, ffi.Pointer<ffi.Int> textCapitalization, ffi.Pointer<DartObj> style, ffi.Pointer<ffi.Int> textAlign, ffi.Pointer<ffi.Int> textDirection, ffi.Pointer<ffi.Int> readOnly, ffi.Pointer<ffi.Int> showCursor, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<ffi.Char> obscuringCharacter, ffi.Pointer<ffi.Int> obscureText, ffi.Pointer<ffi.Int> autocorrect, ffi.Pointer<ffi.Int> smartDashesType, ffi.Pointer<ffi.Int> smartQuotesType, ffi.Pointer<ffi.Int> enableSuggestions, ffi.Pointer<ffi.Int> maxLines, ffi.Pointer<ffi.Int> minLines, ffi.Pointer<ffi.Int> expands, ffi.Pointer<ffi.Int> maxLength, ffi.Pointer<ffi.Int> maxLengthEnforcement, ffi.Pointer<ValueChangedForStringFFI> onChanged, ffi.Pointer<VoidCallbackFFI> onEditingComplete, ffi.Pointer<ValueChangedForStringFFI> onSubmitted, ffi.Pointer<TapRegionCallbackFFI> onTapOutside, ffi.Pointer<TapRegionCallbackFFI> onTapUpOutside, ffi.Pointer<ffi.Int> enabled, ffi.Pointer<ffi.Double> cursorWidth, ffi.Pointer<ffi.Double> cursorHeight, ffi.Pointer<DartObj> cursorRadius, ffi.Pointer<ffi.Int> cursorOpacityAnimates, ffi.Pointer<DartObj> cursorColor, ffi.Pointer<ffi.Int> selectionHeightStyle, ffi.Pointer<ffi.Int> selectionWidthStyle, ffi.Pointer<ffi.Int> keyboardAppearance, ffi.Pointer<DartObj> scrollPadding, ffi.Pointer<ffi.Int> dragStartBehavior, ffi.Pointer<ffi.Int> enableInteractiveSelection, ffi.Pointer<ffi.Int> selectAllOnFocus, ffi.Pointer<GestureTapCallbackFFI> onTap, ffi.Pointer<ffi.Pointer<ffi.Pointer<ffi.Char>>> autofillHints, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<ffi.Char> restorationId, ffi.Pointer<ffi.Int> scribbleEnabled, ffi.Pointer<ffi.Int> stylusHandwritingEnabled, ffi.Pointer<ffi.Int> enableIMEPersonalizedLearning) {
  final w = CupertinoTextField(groupId: groupId.objOr(EditableText),
      decoration: decoration.objOrNul(),
      padding: padding.objOr(const EdgeInsets.all(7.0)),
      placeholder: placeholder.strOrNul(),
      placeholderStyle: placeholderStyle.objOrNul(),
      prefix: prefix.objOrNul(),
      prefixMode: prefixMode.enumOr(OverlayVisibilityMode.values, OverlayVisibilityMode.always),
      suffix: suffix.objOrNul(),
      suffixMode: suffixMode.enumOr(OverlayVisibilityMode.values, OverlayVisibilityMode.always),
      crossAxisAlignment: crossAxisAlignment.enumOr(CrossAxisAlignment.values, CrossAxisAlignment.center),
      clearButtonMode: clearButtonMode.enumOr(OverlayVisibilityMode.values, OverlayVisibilityMode.never),
      clearButtonSemanticLabel: clearButtonSemanticLabel.strOrNul(),
      textInputAction: textInputAction.enumOrNul(TextInputAction.values),
      textCapitalization: textCapitalization.enumOr(TextCapitalization.values, TextCapitalization.none),
      style: style.objOrNul(),
      textAlign: textAlign.enumOr(TextAlign.values, TextAlign.start),
      textDirection: textDirection.enumOrNul(TextDirection.values),
      readOnly: readOnly.boolOr(false),
      showCursor: showCursor.boolOrNul(),
      autofocus: autofocus.boolOr(false),
      obscuringCharacter: obscuringCharacter.strOr('•'),
      obscureText: obscureText.boolOr(false),
      autocorrect: autocorrect.boolOrNul(),
      smartDashesType: smartDashesType.enumOrNul(SmartDashesType.values),
      smartQuotesType: smartQuotesType.enumOrNul(SmartQuotesType.values),
      enableSuggestions: enableSuggestions.boolOr(true),
      maxLines: maxLines.intOrNul(),
      minLines: minLines.intOrNul(),
      expands: expands.boolOr(false),
      maxLength: maxLength.intOrNul(),
      maxLengthEnforcement: maxLengthEnforcement.enumOrNul(MaxLengthEnforcement.values),
      onChanged: onChanged.toValueChangedForStringFn(),
      onEditingComplete: onEditingComplete.toVoidCallbackFn(),
      onSubmitted: onSubmitted.toValueChangedForStringFn(),
      onTapOutside: onTapOutside.toTapRegionCallbackFn(),
      onTapUpOutside: onTapUpOutside.toTapRegionCallbackFn(),
      enabled: enabled.boolOr(true),
      cursorWidth: cursorWidth.doubleOr(2.0),
      cursorHeight: cursorHeight.doubleOrNul(),
      cursorRadius: cursorRadius.objOr(const Radius.circular(2.0)),
      cursorOpacityAnimates: cursorOpacityAnimates.boolOr(true),
      cursorColor: cursorColor.objOrNul(),
      selectionHeightStyle: selectionHeightStyle.enumOrNul(BoxHeightStyle.values),
      selectionWidthStyle: selectionWidthStyle.enumOrNul(BoxWidthStyle.values),
      keyboardAppearance: keyboardAppearance.enumOrNul(Brightness.values),
      scrollPadding: scrollPadding.objOr(const EdgeInsets.all(20.0)),
      dragStartBehavior: dragStartBehavior.enumOr(DragStartBehavior.values, DragStartBehavior.start),
      enableInteractiveSelection: enableInteractiveSelection.boolOrNul(),
      selectAllOnFocus: selectAllOnFocus.boolOrNul(),
      onTap: onTap.toGestureTapCallbackFn(),
      autofillHints: autofillHints.listOrNul(),
      clipBehavior: clipBehavior.enumOr(Clip.values, Clip.hardEdge),
      restorationId: restorationId.strOrNul(),
      scribbleEnabled: scribbleEnabled.boolOr(true),
      stylusHandwritingEnabled: stylusHandwritingEnabled.boolOr(EditableText.defaultStylusHandwritingEnabled),
      enableIMEPersonalizedLearning: enableIMEPersonalizedLearning.boolOr(true));
  return _createCupertinoTextFieldObjSt(w);
}
CupertinoTextFieldObjSt cupertinoTextFieldBorderless(ffi.Pointer<DartObj> groupId, ffi.Pointer<DartObj> decoration, ffi.Pointer<DartObj> padding, ffi.Pointer<ffi.Char> placeholder, ffi.Pointer<DartObj> placeholderStyle, ffi.Pointer<DartObj> prefix, ffi.Pointer<ffi.Int> prefixMode, ffi.Pointer<DartObj> suffix, ffi.Pointer<ffi.Int> suffixMode, ffi.Pointer<ffi.Int> crossAxisAlignment, ffi.Pointer<ffi.Int> clearButtonMode, ffi.Pointer<ffi.Char> clearButtonSemanticLabel, ffi.Pointer<ffi.Int> textInputAction, ffi.Pointer<ffi.Int> textCapitalization, ffi.Pointer<DartObj> style, ffi.Pointer<ffi.Int> textAlign, ffi.Pointer<ffi.Int> textDirection, ffi.Pointer<ffi.Int> readOnly, ffi.Pointer<ffi.Int> showCursor, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<ffi.Char> obscuringCharacter, ffi.Pointer<ffi.Int> obscureText, ffi.Pointer<ffi.Int> autocorrect, ffi.Pointer<ffi.Int> smartDashesType, ffi.Pointer<ffi.Int> smartQuotesType, ffi.Pointer<ffi.Int> enableSuggestions, ffi.Pointer<ffi.Int> maxLines, ffi.Pointer<ffi.Int> minLines, ffi.Pointer<ffi.Int> expands, ffi.Pointer<ffi.Int> maxLength, ffi.Pointer<ffi.Int> maxLengthEnforcement, ffi.Pointer<ValueChangedForStringFFI> onChanged, ffi.Pointer<VoidCallbackFFI> onEditingComplete, ffi.Pointer<ValueChangedForStringFFI> onSubmitted, ffi.Pointer<TapRegionCallbackFFI> onTapOutside, ffi.Pointer<TapRegionCallbackFFI> onTapUpOutside, ffi.Pointer<ffi.Int> enabled, ffi.Pointer<ffi.Double> cursorWidth, ffi.Pointer<ffi.Double> cursorHeight, ffi.Pointer<DartObj> cursorRadius, ffi.Pointer<ffi.Int> cursorOpacityAnimates, ffi.Pointer<DartObj> cursorColor, ffi.Pointer<ffi.Int> selectionHeightStyle, ffi.Pointer<ffi.Int> selectionWidthStyle, ffi.Pointer<ffi.Int> keyboardAppearance, ffi.Pointer<DartObj> scrollPadding, ffi.Pointer<ffi.Int> dragStartBehavior, ffi.Pointer<ffi.Int> enableInteractiveSelection, ffi.Pointer<ffi.Int> selectAllOnFocus, ffi.Pointer<GestureTapCallbackFFI> onTap, ffi.Pointer<ffi.Pointer<ffi.Pointer<ffi.Char>>> autofillHints, ffi.Pointer<ffi.Int> clipBehavior, ffi.Pointer<ffi.Char> restorationId, ffi.Pointer<ffi.Int> scribbleEnabled, ffi.Pointer<ffi.Int> stylusHandwritingEnabled, ffi.Pointer<ffi.Int> enableIMEPersonalizedLearning) {
  final w = CupertinoTextField.borderless(groupId: groupId.objOr(EditableText),
      decoration: decoration.objOrNul(),
      padding: padding.objOr(const EdgeInsets.all(7.0)),
      placeholder: placeholder.strOrNul(),
      placeholderStyle: placeholderStyle.objOrNul(),
      prefix: prefix.objOrNul(),
      prefixMode: prefixMode.enumOr(OverlayVisibilityMode.values, OverlayVisibilityMode.always),
      suffix: suffix.objOrNul(),
      suffixMode: suffixMode.enumOr(OverlayVisibilityMode.values, OverlayVisibilityMode.always),
      crossAxisAlignment: crossAxisAlignment.enumOr(CrossAxisAlignment.values, CrossAxisAlignment.center),
      clearButtonMode: clearButtonMode.enumOr(OverlayVisibilityMode.values, OverlayVisibilityMode.never),
      clearButtonSemanticLabel: clearButtonSemanticLabel.strOrNul(),
      textInputAction: textInputAction.enumOrNul(TextInputAction.values),
      textCapitalization: textCapitalization.enumOr(TextCapitalization.values, TextCapitalization.none),
      style: style.objOrNul(),
      textAlign: textAlign.enumOr(TextAlign.values, TextAlign.start),
      textDirection: textDirection.enumOrNul(TextDirection.values),
      readOnly: readOnly.boolOr(false),
      showCursor: showCursor.boolOrNul(),
      autofocus: autofocus.boolOr(false),
      obscuringCharacter: obscuringCharacter.strOr('•'),
      obscureText: obscureText.boolOr(false),
      autocorrect: autocorrect.boolOrNul(),
      smartDashesType: smartDashesType.enumOrNul(SmartDashesType.values),
      smartQuotesType: smartQuotesType.enumOrNul(SmartQuotesType.values),
      enableSuggestions: enableSuggestions.boolOr(true),
      maxLines: maxLines.intOrNul(),
      minLines: minLines.intOrNul(),
      expands: expands.boolOr(false),
      maxLength: maxLength.intOrNul(),
      maxLengthEnforcement: maxLengthEnforcement.enumOrNul(MaxLengthEnforcement.values),
      onChanged: onChanged.toValueChangedForStringFn(),
      onEditingComplete: onEditingComplete.toVoidCallbackFn(),
      onSubmitted: onSubmitted.toValueChangedForStringFn(),
      onTapOutside: onTapOutside.toTapRegionCallbackFn(),
      onTapUpOutside: onTapUpOutside.toTapRegionCallbackFn(),
      enabled: enabled.boolOr(true),
      cursorWidth: cursorWidth.doubleOr(2.0),
      cursorHeight: cursorHeight.doubleOrNul(),
      cursorRadius: cursorRadius.objOr(const Radius.circular(2.0)),
      cursorOpacityAnimates: cursorOpacityAnimates.boolOr(true),
      cursorColor: cursorColor.objOrNul(),
      selectionHeightStyle: selectionHeightStyle.enumOrNul(BoxHeightStyle.values),
      selectionWidthStyle: selectionWidthStyle.enumOrNul(BoxWidthStyle.values),
      keyboardAppearance: keyboardAppearance.enumOrNul(Brightness.values),
      scrollPadding: scrollPadding.objOr(const EdgeInsets.all(20.0)),
      dragStartBehavior: dragStartBehavior.enumOr(DragStartBehavior.values, DragStartBehavior.start),
      enableInteractiveSelection: enableInteractiveSelection.boolOrNul(),
      selectAllOnFocus: selectAllOnFocus.boolOrNul(),
      onTap: onTap.toGestureTapCallbackFn(),
      autofillHints: autofillHints.listOrNul(),
      clipBehavior: clipBehavior.enumOr(Clip.values, Clip.hardEdge),
      restorationId: restorationId.strOrNul(),
      scribbleEnabled: scribbleEnabled.boolOr(true),
      stylusHandwritingEnabled: stylusHandwritingEnabled.boolOr(true),
      enableIMEPersonalizedLearning: enableIMEPersonalizedLearning.boolOr(true));
  return _createCupertinoTextFieldObjSt(w);
}
CupertinoTextFieldObjSt _createCupertinoTextFieldObjSt(CupertinoTextField? w) {
  final CupertinoTextFieldObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.decoration = _createBoxDecorationObjSt(w.decoration);
  stObj.padding = _addWidget(w.padding);
  stObj.placeholder = (w.placeholder != null) ? w.placeholder!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.placeholderStyle = _createTextStyleObjSt(w.placeholderStyle);
  stObj.prefix = _addWidget(w.prefix);
  stObj.prefixMode = w.prefixMode.index;
  stObj.suffix = _addWidget(w.suffix);
  stObj.suffixMode = w.suffixMode.index;
  stObj.crossAxisAlignment = w.crossAxisAlignment.index;
  stObj.clearButtonMode = w.clearButtonMode.index;
  stObj.clearButtonSemanticLabel = (w.clearButtonSemanticLabel != null) ? w.clearButtonSemanticLabel!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.textInputAction = (w.textInputAction != null) ? w.textInputAction!.index : 0;
  stObj.textCapitalization = w.textCapitalization.index;
  stObj.style = _createTextStyleObjSt(w.style);
  stObj.textAlign = w.textAlign.index;
  stObj.textDirection = (w.textDirection != null) ? w.textDirection!.index : 0;
  stObj.readOnly = w.readOnly.toInt();
  stObj.showCursor = (w.showCursor != null) ? w.showCursor!.toInt() : 0;
  stObj.autofocus = w.autofocus.toInt();
  stObj.obscuringCharacter = w.obscuringCharacter.toNativeUtf8().cast<ffi.Char>();
  stObj.obscureText = w.obscureText.toInt();
  stObj.autocorrect = (w.autocorrect != null) ? w.autocorrect!.toInt() : 0;
  stObj.smartDashesType = w.smartDashesType.index;
  stObj.smartQuotesType = w.smartQuotesType.index;
  stObj.enableSuggestions = w.enableSuggestions.toInt();
  stObj.maxLines = (w.maxLines != null) ? w.maxLines! : 0;
  stObj.minLines = (w.minLines != null) ? w.minLines! : 0;
  stObj.expands = w.expands.toInt();
  stObj.maxLength = (w.maxLength != null) ? w.maxLength! : 0;
  stObj.maxLengthEnforcement = (w.maxLengthEnforcement != null) ? w.maxLengthEnforcement!.index : 0;
  stObj.enabled = w.enabled.toInt();
  stObj.cursorWidth = w.cursorWidth;
  stObj.cursorHeight = (w.cursorHeight != null) ? w.cursorHeight! : 0;
  stObj.cursorRadius = _addWidget(w.cursorRadius);
  stObj.cursorOpacityAnimates = w.cursorOpacityAnimates.toInt();
  stObj.cursorColor = _addWidget(w.cursorColor);
  stObj.selectionHeightStyle = (w.selectionHeightStyle != null) ? w.selectionHeightStyle!.index : 0;
  stObj.selectionWidthStyle = (w.selectionWidthStyle != null) ? w.selectionWidthStyle!.index : 0;
  stObj.keyboardAppearance = (w.keyboardAppearance != null) ? w.keyboardAppearance!.index : 0;
  stObj.scrollPadding = _createEdgeInsetsObjSt(w.scrollPadding);
  stObj.enableInteractiveSelection = w.enableInteractiveSelection.toInt();
  stObj.selectAllOnFocus = (w.selectAllOnFocus != null) ? w.selectAllOnFocus!.toInt() : 0;
  stObj.dragStartBehavior = w.dragStartBehavior.index;
  stObj.clipBehavior = w.clipBehavior.index;
  stObj.restorationId = (w.restorationId != null) ? w.restorationId!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  stObj.scribbleEnabled = w.scribbleEnabled.toInt();
  stObj.stylusHandwritingEnabled = w.stylusHandwritingEnabled.toInt();
  stObj.enableIMEPersonalizedLearning = w.enableIMEPersonalizedLearning.toInt();
  stObj.selectionEnabled = w.selectionEnabled.toInt();
  return stObj;
}

void _setupCupertinoCheckbox(WidgetFactories f) {
  f.cupertinoCheckbox.cupertinoCheckbox = ffi.Pointer.fromFunction(cupertinoCheckboxCupertinoCheckbox);
}
CupertinoCheckboxObjSt cupertinoCheckboxCupertinoCheckbox(int value, ffi.Pointer<ffi.Int> tristate, ValueChangedForBoolOptFFI onChanged, ffi.Pointer<DartObj> activeColor, ffi.Pointer<DartObj> inactiveColor, ffi.Pointer<DartObj> fillColor, ffi.Pointer<DartObj> checkColor, ffi.Pointer<DartObj> focusColor, ffi.Pointer<ffi.Int> autofocus, ffi.Pointer<DartObj> side, ffi.Pointer<DartObj> shape, ffi.Pointer<ffi.Char> semanticLabel) {
  final w = CupertinoCheckbox(value: value.toBool(),
      tristate: tristate.boolOr(false),
      onChanged: onChanged.toValueChangedForBoolOptFn(),
      activeColor: activeColor.objOrNul(),
      inactiveColor: inactiveColor.objOrNul(),
      fillColor: _wspNul<Color?>(fillColor.objOrNul()),
      checkColor: checkColor.objOrNul(),
      focusColor: focusColor.objOrNul(),
      autofocus: autofocus.boolOr(false),
      side: side.objOrNul(),
      shape: shape.objOrNul(),
      semanticLabel: semanticLabel.strOrNul());
  return _createCupertinoCheckboxObjSt(w);
}
CupertinoCheckboxObjSt _createCupertinoCheckboxObjSt(CupertinoCheckbox? w) {
  final CupertinoCheckboxObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.value = (w.value != null) ? w.value!.toInt() : 0;
  stObj.activeColor = _addWidget(w.activeColor);
  stObj.inactiveColor = _addWidget(w.inactiveColor);
  stObj.checkColor = _addWidget(w.checkColor);
  stObj.tristate = w.tristate.toInt();
  stObj.focusColor = _addWidget(w.focusColor);
  stObj.autofocus = w.autofocus.toInt();
  stObj.side = _createBorderSideObjSt(w.side);
  stObj.shape = _addWidget(w.shape);
  stObj.semanticLabel = (w.semanticLabel != null) ? w.semanticLabel!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  return stObj;
}

void _setupCupertinoExpansionTile(WidgetFactories f) {
  f.cupertinoExpansionTile.cupertinoExpansionTile = ffi.Pointer.fromFunction(cupertinoExpansionTileCupertinoExpansionTile);
}
CupertinoExpansionTileObjSt cupertinoExpansionTileCupertinoExpansionTile(DartDartObj title, DartDartObj child, ffi.Pointer<ffi.Int> transitionMode) {
  final w = CupertinoExpansionTile(title: _widgetsMap[title]! as Widget,
      child: _widgetsMap[child]! as Widget,
      transitionMode: transitionMode.enumOr(ExpansionTileTransitionMode.values, ExpansionTileTransitionMode.fade));
  return _createCupertinoExpansionTileObjSt(w);
}
CupertinoExpansionTileObjSt _createCupertinoExpansionTileObjSt(CupertinoExpansionTile? w) {
  final CupertinoExpansionTileObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.title = _addWidget(w.title);
  stObj.child = _addWidget(w.child);
  stObj.transitionMode = w.transitionMode.index;
  return stObj;
}

void _setupCupertinoTimerPicker(WidgetFactories f) {
  f.cupertinoTimerPicker.cupertinoTimerPicker = ffi.Pointer.fromFunction(cupertinoTimerPickerCupertinoTimerPicker);
}
CupertinoTimerPickerObjSt cupertinoTimerPickerCupertinoTimerPicker(ffi.Pointer<ffi.Int> mode, ffi.Pointer<DartObj> initialTimerDuration, ffi.Pointer<ffi.Int> minuteInterval, ffi.Pointer<ffi.Int> secondInterval, ffi.Pointer<DartObj> alignment, ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<ffi.Double> itemExtent, ValueChangedForDurationFFI onTimerDurationChanged, ffi.Pointer<ffi.Int> changeReportingBehavior, ffi.Pointer<SelectionOverlayBuilderFFI> selectionOverlayBuilder) {
  final w = CupertinoTimerPicker(mode: mode.enumOr(CupertinoTimerPickerMode.values, CupertinoTimerPickerMode.hms),
      initialTimerDuration: initialTimerDuration.objOr(Duration.zero),
      minuteInterval: minuteInterval.intOr(1),
      secondInterval: secondInterval.intOr(1),
      alignment: alignment.objOr(Alignment.center),
      backgroundColor: backgroundColor.objOrNul(),
      itemExtent: itemExtent.doubleOr(32.0),
      onTimerDurationChanged: onTimerDurationChanged.toValueChangedForDurationFn(),
      changeReportingBehavior: changeReportingBehavior.enumOr(ChangeReportingBehavior.values, ChangeReportingBehavior.onScrollUpdate),
      selectionOverlayBuilder: selectionOverlayBuilder.toSelectionOverlayBuilderFn());
  return _createCupertinoTimerPickerObjSt(w);
}
CupertinoTimerPickerObjSt _createCupertinoTimerPickerObjSt(CupertinoTimerPicker? w) {
  final CupertinoTimerPickerObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.mode = w.mode.index;
  stObj.initialTimerDuration = _addWidget(w.initialTimerDuration);
  stObj.minuteInterval = w.minuteInterval;
  stObj.secondInterval = w.secondInterval;
  stObj.alignment = _addWidget(w.alignment);
  stObj.backgroundColor = _addWidget(w.backgroundColor);
  stObj.itemExtent = w.itemExtent;
  stObj.changeReportingBehavior = w.changeReportingBehavior.index;
  return stObj;
}

void _setupCupertinoNavigationBarBackButton(WidgetFactories f) {
  f.cupertinoNavigationBarBackButton.cupertinoNavigationBarBackButton = ffi.Pointer.fromFunction(cupertinoNavigationBarBackButtonCupertinoNavigationBarBackButton);
}
CupertinoNavigationBarBackButtonObjSt cupertinoNavigationBarBackButtonCupertinoNavigationBarBackButton(ffi.Pointer<DartObj> color, ffi.Pointer<ffi.Char> previousPageTitle, ffi.Pointer<VoidCallbackFFI> onPressed) {
  final w = CupertinoNavigationBarBackButton(color: color.objOrNul(),
      previousPageTitle: previousPageTitle.strOrNul(),
      onPressed: onPressed.toVoidCallbackFn());
  return _createCupertinoNavigationBarBackButtonObjSt(w);
}
CupertinoNavigationBarBackButtonObjSt _createCupertinoNavigationBarBackButtonObjSt(CupertinoNavigationBarBackButton? w) {
  final CupertinoNavigationBarBackButtonObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.color = _addWidget(w.color);
  stObj.previousPageTitle = (w.previousPageTitle != null) ? w.previousPageTitle!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  return stObj;
}

void _setupCupertinoTabBar(WidgetFactories f) {
  f.cupertinoTabBar.cupertinoTabBar = ffi.Pointer.fromFunction(cupertinoTabBarCupertinoTabBar);
}
CupertinoTabBarObjSt cupertinoTabBarCupertinoTabBar(ArrayC items, ffi.Pointer<ValueChangedForIntFFI> onTap, ffi.Pointer<ffi.Int> currentIndex, ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<DartObj> activeColor, ffi.Pointer<DartObj> inactiveColor, ffi.Pointer<ffi.Double> iconSize, ffi.Pointer<ffi.Double> height, ffi.Pointer<DartObj> border) {
  final w = CupertinoTabBar(items: items.listOrEmpty(),
      onTap: onTap.toValueChangedForIntFn(),
      currentIndex: currentIndex.intOr(0),
      backgroundColor: backgroundColor.objOrNul(),
      activeColor: activeColor.objOrNul(),
      inactiveColor: inactiveColor.objOr(CupertinoColors.inactiveGray),
      iconSize: iconSize.doubleOr(30.0),
      height: height.doubleOr(50.0),
      border: border.objOrNul());
  return _createCupertinoTabBarObjSt(w);
}
CupertinoTabBarObjSt _createCupertinoTabBarObjSt(CupertinoTabBar? w) {
  final CupertinoTabBarObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.currentIndex = w.currentIndex;
  stObj.backgroundColor = _addWidget(w.backgroundColor);
  stObj.activeColor = _addWidget(w.activeColor);
  stObj.inactiveColor = _addWidget(w.inactiveColor);
  stObj.iconSize = w.iconSize;
  stObj.height = w.height;
  stObj.border = _createBorderObjSt(w.border);
  return stObj;
}

void _setupBottomNavigationBarItem(WidgetFactories f) {
  f.bottomNavigationBarItem.bottomNavigationBarItem = ffi.Pointer.fromFunction(bottomNavigationBarItemBottomNavigationBarItem, exception);
}
int bottomNavigationBarItemBottomNavigationBarItem(DartDartObj icon, ffi.Pointer<ffi.Char> label, ffi.Pointer<DartObj> activeIcon, ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<ffi.Char> tooltip) {
  final w = BottomNavigationBarItem(icon: _widgetsMap[icon]! as Widget,
      label: label.strOrNul(),
      activeIcon: activeIcon.objOrNul(),
      backgroundColor: backgroundColor.objOrNul(),
      tooltip: tooltip.strOrNul());
  return _addWidget(w);
}

void _setupCupertinoTabScaffold(WidgetFactories f) {
  f.cupertinoTabScaffold.cupertinoTabScaffold = ffi.Pointer.fromFunction(cupertinoTabScaffoldCupertinoTabScaffold);
}
CupertinoTabScaffoldObjSt cupertinoTabScaffoldCupertinoTabScaffold(DartDartObj tabBar, IndexedWidgetBuilderFFI tabBuilder, ffi.Pointer<DartObj> backgroundColor, ffi.Pointer<ffi.Int> resizeToAvoidBottomInset, ffi.Pointer<ffi.Char> restorationId) {
  final w = CupertinoTabScaffold(tabBar: _widgetsMap[tabBar]! as CupertinoTabBar,
      tabBuilder: tabBuilder.toIndexedWidgetBuilderFn(),
      backgroundColor: backgroundColor.objOrNul(),
      resizeToAvoidBottomInset: resizeToAvoidBottomInset.boolOr(true),
      restorationId: restorationId.strOrNul());
  return _createCupertinoTabScaffoldObjSt(w);
}
CupertinoTabScaffoldObjSt _createCupertinoTabScaffoldObjSt(CupertinoTabScaffold? w) {
  final CupertinoTabScaffoldObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.tabBar = _createCupertinoTabBarObjSt(w.tabBar);
  stObj.backgroundColor = _addWidget(w.backgroundColor);
  stObj.resizeToAvoidBottomInset = w.resizeToAvoidBottomInset.toInt();
  stObj.restorationId = (w.restorationId != null) ? w.restorationId!.toNativeUtf8().cast<ffi.Char>() : ffi.nullptr;
  return stObj;
}

void _setupCupertinoContextMenu(WidgetFactories f) {
  f.cupertinoContextMenu.cupertinoContextMenu = ffi.Pointer.fromFunction(cupertinoContextMenuCupertinoContextMenu);
  f.cupertinoContextMenu.builder = ffi.Pointer.fromFunction(cupertinoContextMenuBuilder);
}
CupertinoContextMenuObjSt cupertinoContextMenuCupertinoContextMenu(ArrayC actions, DartDartObj child, ffi.Pointer<ffi.Int> enableHapticFeedback) {
  final w = CupertinoContextMenu(actions: actions.listOrEmpty(),
      child: _widgetsMap[child]! as Widget,
      enableHapticFeedback: enableHapticFeedback.boolOr(false));
  return _createCupertinoContextMenuObjSt(w);
}
CupertinoContextMenuObjSt cupertinoContextMenuBuilder(ArrayC actions, CupertinoContextMenuBuilderFFI builder, ffi.Pointer<ffi.Int> enableHapticFeedback) {
  final w = CupertinoContextMenu.builder(actions: actions.listOrEmpty(),
      builder: builder.toCupertinoContextMenuBuilderFn(),
      enableHapticFeedback: enableHapticFeedback.boolOr(false));
  return _createCupertinoContextMenuObjSt(w);
}
CupertinoContextMenuObjSt _createCupertinoContextMenuObjSt(CupertinoContextMenu? w) {
  final CupertinoContextMenuObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.child = _addWidget(w.child);
  stObj.enableHapticFeedback = w.enableHapticFeedback.toInt();
  return stObj;
}

void _setupCupertinoContextMenuAction(WidgetFactories f) {
  f.cupertinoContextMenuAction.cupertinoContextMenuAction = ffi.Pointer.fromFunction(cupertinoContextMenuActionCupertinoContextMenuAction);
}
CupertinoContextMenuActionObjSt cupertinoContextMenuActionCupertinoContextMenuAction(DartDartObj child, ffi.Pointer<ffi.Int> isDefaultAction, ffi.Pointer<ffi.Int> isDestructiveAction, ffi.Pointer<VoidCallbackFFI> onPressed, ffi.Pointer<DartObj> trailingIcon) {
  final w = CupertinoContextMenuAction(child: _widgetsMap[child]! as Widget,
      isDefaultAction: isDefaultAction.boolOr(false),
      isDestructiveAction: isDestructiveAction.boolOr(false),
      onPressed: onPressed.toVoidCallbackFn(),
      trailingIcon: trailingIcon.objOrNul());
  return _createCupertinoContextMenuActionObjSt(w);
}
CupertinoContextMenuActionObjSt _createCupertinoContextMenuActionObjSt(CupertinoContextMenuAction? w) {
  final CupertinoContextMenuActionObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  if (w == null) return stObj;
  stObj.child = _addWidget(w.child);
  stObj.isDefaultAction = w.isDefaultAction.toInt();
  stObj.isDestructiveAction = w.isDestructiveAction.toInt();
  stObj.trailingIcon = _createIconDataObjSt(w.trailingIcon);
  return stObj;
}

void _setupSubState(WidgetFactories f) {
  f.subState.subState = ffi.Pointer.fromFunction(subStateSubState);
}
SubStateObjSt subStateSubState(VoidCallbackFFI initStateFn, VoidCallbackDartObjFFI didUpdateWidgetFn, VoidCallbackFFI reassembleFn, VoidCallbackFFI deactivateFn, VoidCallbackFFI activateFn, VoidCallbackFFI disposeFn, DartObjCallbackDartObjFFI buildFn, VoidCallbackFFI didChangeDependenciesFn) {
  final w = SubState(initStateFn: initStateFn.toVoidCallbackFn(),
      didUpdateWidgetFn: didUpdateWidgetFn.toVoidCallbackDartObjFn(),
      reassembleFn: reassembleFn.toVoidCallbackFn(),
      deactivateFn: deactivateFn.toVoidCallbackFn(),
      activateFn: activateFn.toVoidCallbackFn(),
      disposeFn: disposeFn.toVoidCallbackFn(),
      buildFn: buildFn.toDartObjCallbackDartObjFn(),
      didChangeDependenciesFn: didChangeDependenciesFn.toVoidCallbackFn());
  final SubStateObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  final setStateFn = ffi.NativeCallable<ffi.Void Function(ffi.Pointer<ffi.NativeFunction<ffi.Void Function()>>)>.listener((ffi.Pointer<ffi.NativeFunction<ffi.Void Function()>> cb) => w.setState(cb.asFunction()));
  stObj.setState = setStateFn.nativeFunction;
  final contextFn = ffi.NativeCallable<DartObj Function()>.isolateLocal(() => _addWidget(w.context), exceptionalReturn: exception);
  stObj.context = contextFn.nativeFunction;
  final mountedFn = ffi.NativeCallable<ffi.Int Function()>.isolateLocal(() => w.mounted.toInt(), exceptionalReturn: exception);
  stObj.mounted = mountedFn.nativeFunction;
  return stObj;
}

void _setupSubStatefulWidget(WidgetFactories f) {
  f.subStatefulWidget.subStatefulWidget = ffi.Pointer.fromFunction(subStatefulWidgetSubStatefulWidget);
}
SubStatefulWidgetObjSt subStatefulWidgetSubStatefulWidget(DartObjCallbackFFI createStateFn) {
  final w = _TrackedSubStatefulWidget(createStateFn: createStateFn.toDartObjCallbackFn());
  final SubStatefulWidgetObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  return stObj;
}

void _setupSubStatelessWidget(WidgetFactories f) {
  f.subStatelessWidget.subStatelessWidget = ffi.Pointer.fromFunction(subStatelessWidgetSubStatelessWidget);
}
SubStatelessWidgetObjSt subStatelessWidgetSubStatelessWidget(DartObjCallbackDartObjFFI buildFn) {
  final w = _TrackedSubStatelessWidget(buildFn: buildFn.toDartObjCallbackDartObjFn());
  final SubStatelessWidgetObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  return stObj;
}

void _setupSubAnimatedState(WidgetFactories f) {
  f.subAnimatedState.subAnimatedState = ffi.Pointer.fromFunction(subAnimatedStateSubAnimatedState);
  f.subAnimatedState.animationController = ffi.Pointer.fromFunction(subAnimatedStateAnimationController, exception);
}
SubAnimatedStateObjSt subAnimatedStateSubAnimatedState(VoidCallbackFFI initStateFn, VoidCallbackDartObjFFI didUpdateWidgetFn, VoidCallbackFFI reassembleFn, VoidCallbackFFI deactivateFn, VoidCallbackFFI activateFn, VoidCallbackFFI disposeFn, DartObjCallbackDartObjFFI buildFn, VoidCallbackFFI didChangeDependenciesFn) {
  final w = SubAnimatedState(initStateFn: initStateFn.toVoidCallbackFn(),
      didUpdateWidgetFn: didUpdateWidgetFn.toVoidCallbackDartObjFn(),
      reassembleFn: reassembleFn.toVoidCallbackFn(),
      deactivateFn: deactivateFn.toVoidCallbackFn(),
      activateFn: activateFn.toVoidCallbackFn(),
      disposeFn: disposeFn.toVoidCallbackFn(),
      buildFn: buildFn.toDartObjCallbackDartObjFn(),
      didChangeDependenciesFn: didChangeDependenciesFn.toVoidCallbackFn());
  final SubAnimatedStateObjSt stObj = ffi.Struct.create();
  stObj.id = _addWidget(w);
  final setStateFn = ffi.NativeCallable<ffi.Void Function(ffi.Pointer<ffi.NativeFunction<ffi.Void Function()>>)>.listener((ffi.Pointer<ffi.NativeFunction<ffi.Void Function()>> cb) => w.setState(cb.asFunction()));
  stObj.setState = setStateFn.nativeFunction;
  final contextFn = ffi.NativeCallable<DartObj Function()>.isolateLocal(() => _addWidget(w.context), exceptionalReturn: exception);
  stObj.context = contextFn.nativeFunction;
  final mountedFn = ffi.NativeCallable<ffi.Int Function()>.isolateLocal(() => w.mounted.toInt(), exceptionalReturn: exception);
  stObj.mounted = mountedFn.nativeFunction;
  return stObj;
}
int subAnimatedStateAnimationController(DartDartObj self, DartDartObj duration) {
  final w = SubAnimatedStateMethods.animationController(_widgetsMap[self]! as SubAnimatedState<StatefulWidget>,
      _widgetsMap[duration]! as Duration);
  return _addWidget(w);
}

ffi.Pointer<WidgetFactories> _setupFactories() {
  final ffi.Pointer<WidgetFactories> fp = calloc<WidgetFactories>();
  final f = fp.ref;
  _setupTopFunctions(f);
  _setupTextStyle(f);
  _setupText(f);
  _setupTextSpan(f);
  _setupRichText(f);
  _setupCenter(f);
  _setupColumn(f);
  _setupRow(f);
  _setupIconData(f);
  _setupIcon(f);
  _setupColor(f);
  _setupTransform(f);
  _setupOpacity(f);
  _setupStack(f);
  _setupBoxConstraints(f);
  _setupContainer(f);
  _setupStackParentData(f);
  _setupFlexParentData(f);
  _setupPositioned(f);
  _setupBoxDecoration(f);
  _setupRadius(f);
  _setupBorderRadius(f);
  _setupBoxShadow(f);
  _setupPadding(f);
  _setupEdgeInsets(f);
  _setupBorderSide(f);
  _setupBorder(f);
  _setupRoundedRectangleBorder(f);
  _setupAnimationController(f);
  _setupAnimatedBuilder(f);
  _setupOffset(f);
  _setupVelocity(f);
  _setupTapDownDetails(f);
  _setupTapUpDetails(f);
  _setupTapMoveDetails(f);
  _setupLongPressDownDetails(f);
  _setupLongPressStartDetails(f);
  _setupLongPressMoveUpdateDetails(f);
  _setupLongPressEndDetails(f);
  _setupDragDownDetails(f);
  _setupDragStartDetails(f);
  _setupDragUpdateDetails(f);
  _setupDragEndDetails(f);
  _setupScaleStartDetails(f);
  _setupScaleUpdateDetails(f);
  _setupScaleEndDetails(f);
  _setupForcePressDetails(f);
  _setupDraggableDetails(f);
  _setupDragTargetDetails(f);
  _setupPointerDownEvent(f);
  _setupPointerUpEvent(f);
  _setupPointerEnterEvent(f);
  _setupPointerExitEvent(f);
  _setupPointerHoverEvent(f);
  _setupCubic(f);
  _setupThreePointCubic(f);
  _setupElasticOutCurve(f);
  _setupElasticInCurve(f);
  _setupElasticInOutCurve(f);
  _setupCurves(f);
  _setupCurvedAnimation(f);
  _setupSizedBox(f);
  _setupAlignment(f);
  _setupAlignmentDirectional(f);
  _setupMouseRegion(f);
  _setupFontWeight(f);
  _setupDuration(f);
  _setupExpanded(f);
  _setupSafeArea(f);
  _setupRotationTransition(f);
  _setupFadeTransition(f);
  _setupScaleTransition(f);
  _setupAlign(f);
  _setupAspectRatio(f);
  _setupClipOval(f);
  _setupClipRRect(f);
  _setupClipRect(f);
  _setupClipRSuperellipse(f);
  _setupColoredBox(f);
  _setupConstrainedBox(f);
  _setupDecoratedBox(f);
  _setupFittedBox(f);
  _setupFractionallySizedBox(f);
  _setupIntrinsicHeight(f);
  _setupIntrinsicWidth(f);
  _setupLimitedBox(f);
  _setupPlaceholder(f);
  _setupSpacer(f);
  _setupVisibility(f);
  _setupRotatedBox(f);
  _setupBaseline(f);
  _setupDefaultTextStyle(f);
  _setupDirectionality(f);
  _setupOverflowBox(f);
  _setupAbsorbPointer(f);
  _setupIgnorePointer(f);
  _setupRepaintBoundary(f);
  _setupFractionalTranslation(f);
  _setupUnconstrainedBox(f);
  _setupFlutterLogo(f);
  _setupPhysicalModel(f);
  _setupBanner(f);
  _setupAnimatedContainer(f);
  _setupAnimatedOpacity(f);
  _setupAnimatedPadding(f);
  _setupAnimatedAlign(f);
  _setupListView(f);
  _setupGridView(f);
  _setupPageView(f);
  _setupListWheelScrollView(f);
  _setupFlex(f);
  _setupAnimatedSize(f);
  _setupAnimatedScale(f);
  _setupAnimatedRotation(f);
  _setupAnimatedSlide(f);
  _setupAnimatedCrossFade(f);
  _setupSlideTransition(f);
  _setupSizeTransition(f);
  _setupIndexedStack(f);
  _setupFlexible(f);
  _setupInteractiveViewer(f);
  _setupDraggable(f);
  _setupDragTarget(f);
  _setupHero(f);
  _setupAnimatedSwitcher(f);
  _setupColorFilter(f);
  _setupBackdropFilter(f);
  _setupColorFiltered(f);
  _setupImageFiltered(f);
  _setupColorScheme(f);
  _setupTextTheme(f);
  _setupVisualDensity(f);
  _setupThemeData(f);
  _setupMaterialAccentColor(f);
  _setupMaterialColor(f);
  _setupMaterial(f);
  _setupIconButton(f);
  _setupAppBar(f);
  _setupScaffold(f);
  _setupMaterialApp(f);
  _setupFloatingActionButton(f);
  _setupTheme(f);
  _setupElevatedButton(f);
  _setupOutlinedButton(f);
  _setupTextButton(f);
  _setupNavigatorState(f);
  _setupNavigator(f);
  _setupAlertDialog(f);
  _setupInputDecoration(f);
  _setupTextField(f);
  _setupTextDecoration(f);
  _setupDivider(f);
  _setupFilledButton(f);
  _setupOutlineInputBorder(f);
  _setupSnackBarAction(f);
  _setupSnackBar(f);
  _setupScaffoldMessenger(f);
  _setupCard(f);
  _setupChip(f);
  _setupGestureDetector(f);
  _setupListTile(f);
  _setupWrap(f);
  _setupSingleChildScrollView(f);
  _setupCircularProgressIndicator(f);
  _setupLinearProgressIndicator(f);
  _setupCheckbox(f);
  _setupSwitch(f);
  _setupSlider(f);
  _setupDrawer(f);
  _setupTooltip(f);
  _setupTab(f);
  _setupTabBar(f);
  _setupTabBarView(f);
  _setupDefaultTabController(f);
  _setupCheckboxListTile(f);
  _setupSwitchListTile(f);
  _setupBadge(f);
  _setupSelectableText(f);
  _setupInkWell(f);
  _setupDataTable(f);
  _setupDataColumn(f);
  _setupDataRow(f);
  _setupDataCell(f);
  _setupDropdownMenuEntry(f);
  _setupRadio(f);
  _setupRadioListTile(f);
  _setupExpansionTile(f);
  _setupExpansionPanel(f);
  _setupExpansionPanelList(f);
  _setupExpansionPanelRadio(f);
  _setupNavigationRail(f);
  _setupNavigationRailDestination(f);
  _setupNavigationBar(f);
  _setupNavigationDestination(f);
  _setupNavigationDrawer(f);
  _setupNavigationDrawerDestination(f);
  _setupPopupMenuButton(f);
  _setupPopupMenuItem(f);
  _setupPopupMenuDivider(f);
  _setupCheckedPopupMenuItem(f);
  _setupCircleAvatar(f);
  _setupScrollbar(f);
  _setupMenuBar(f);
  _setupMenuAnchor(f);
  _setupSubmenuButton(f);
  _setupMenuItemButton(f);
  _setupCheckboxMenuButton(f);
  _setupRadioMenuButton(f);
  _setupDateTime(f);
  _setupTimeOfDay(f);
  _setupDatePickerDialog(f);
  _setupCalendarDatePicker(f);
  _setupTimePickerDialog(f);
  _setupDateRangePickerDialog(f);
  _setupYearPicker(f);
  _setupInputDatePickerFormField(f);
  _setupSearchBar(f);
  _setupCupertinoApp(f);
  _setupCupertinoPageScaffold(f);
  _setupCupertinoNavigationBar(f);
  _setupCupertinoSliverNavigationBar(f);
  _setupCupertinoTabView(f);
  _setupCupertinoButton(f);
  _setupCupertinoSwitch(f);
  _setupCupertinoSlider(f);
  _setupCupertinoSearchTextField(f);
  _setupCupertinoActivityIndicator(f);
  _setupCupertinoListSection(f);
  _setupCupertinoListTile(f);
  _setupCupertinoListTileChevron(f);
  _setupCupertinoFormSection(f);
  _setupCupertinoFormRow(f);
  _setupCupertinoPicker(f);
  _setupCupertinoAlertDialog(f);
  _setupCupertinoActionSheet(f);
  _setupCupertinoDialogAction(f);
  _setupCupertinoActionSheetAction(f);
  _setupCupertinoTextField(f);
  _setupCupertinoCheckbox(f);
  _setupCupertinoExpansionTile(f);
  _setupCupertinoTimerPicker(f);
  _setupCupertinoNavigationBarBackButton(f);
  _setupCupertinoTabBar(f);
  _setupCupertinoTabScaffold(f);
  _setupCupertinoContextMenu(f);
  _setupCupertinoContextMenuAction(f);
  _setupBottomNavigationBarItem(f);
  _setupSubState(f);
  _setupSubStatefulWidget(f);
  _setupSubStatelessWidget(f);
  _setupSubAnimatedState(f);
  _setupShadow(f);
  _setupShadow(f);
  _setupEdgeInsetsGeometry(f);
  _setupBoxParentData(f);
  _setupParentData(f);
  _setupEdgeInsetsGeometry(f);
  _setupListenableBuilder(f);
  _setupImageFilter(f);
  _setupColorSwatch(f);
  _setupColorSwatch(f);
  _setupInputBorder(f);
  _setupInputBorder(f);
  _setupInkResponse(f);
  return fp;
}
extension on WidgetBuilderFFI {
  WidgetBuilder toWidgetBuilderFn() {
    return (BuildContext context) => _runBuildScope(() {
      DartWidgetBuilderFFIFunction dFn = asFunction();
      final dFnRet = dFn(_addWidget(context));
      return _widgetsMap[dFnRet]! as Widget;
    });
  }
}
extension on ffi.Pointer<WidgetBuilderFFI> {
  WidgetBuilder? toWidgetBuilderFn() => (this != ffi.nullptr) ? this.value.toWidgetBuilderFn() : null;
}

extension on SelectableDayPredicateFFI {
  SelectableDayPredicate toSelectableDayPredicateFn() {
    return (DateTime day) {
      DartSelectableDayPredicateFFIFunction dFn = asFunction();
      final dFnRet = dFn(_addWidget(day));
      return dFnRet.toBool();
    };
  }
}
extension on ffi.Pointer<SelectableDayPredicateFFI> {
  SelectableDayPredicate? toSelectableDayPredicateFn() => (this != ffi.nullptr) ? this.value.toSelectableDayPredicateFn() : null;
}

extension on TransitionBuilderFFI {
  TransitionBuilder toTransitionBuilderFn() {
    return (BuildContext context, Widget? child) => _runBuildScope(() {
      DartTransitionBuilderFFIFunction dFn = asFunction();
      final dFnRet = dFn(_addWidget(context), _addWidget(child));
      return _widgetsMap[dFnRet]! as Widget;
    });
  }
}
extension on ffi.Pointer<TransitionBuilderFFI> {
  TransitionBuilder? toTransitionBuilderFn() => (this != ffi.nullptr) ? this.value.toTransitionBuilderFn() : null;
}

extension on ValueChangedForDatePickerEntryModeFFI {
  ValueChanged<DatePickerEntryMode> toValueChangedForDatePickerEntryModeFn() {
    return (DatePickerEntryMode value) {
      DartValueChangedForDatePickerEntryModeFFIFunction dFn = asFunction();
      dFn(value.index);
    };
  }
}
extension on ffi.Pointer<ValueChangedForDatePickerEntryModeFFI> {
  ValueChanged<DatePickerEntryMode>? toValueChangedForDatePickerEntryModeFn() => (this != ffi.nullptr) ? this.value.toValueChangedForDatePickerEntryModeFn() : null;
}

extension on EntryModeChangeCallbackFFI {
  EntryModeChangeCallback toEntryModeChangeCallbackFn() {
    return (TimePickerEntryMode mode) {
      DartEntryModeChangeCallbackFFIFunction dFn = asFunction();
      dFn(mode.index);
    };
  }
}
extension on ffi.Pointer<EntryModeChangeCallbackFFI> {
  EntryModeChangeCallback? toEntryModeChangeCallbackFn() => (this != ffi.nullptr) ? this.value.toEntryModeChangeCallbackFn() : null;
}

extension on SelectableDayForRangePredicateFFI {
  SelectableDayForRangePredicate toSelectableDayForRangePredicateFn() {
    return (DateTime day, DateTime? selectedStartDay, DateTime? selectedEndDay) {
      DartSelectableDayForRangePredicateFFIFunction dFn = asFunction();
      final dFnRet = dFn(_addWidget(day), _addWidget(selectedStartDay), _addWidget(selectedEndDay));
      return dFnRet.toBool();
    };
  }
}
extension on ffi.Pointer<SelectableDayForRangePredicateFFI> {
  SelectableDayForRangePredicate? toSelectableDayForRangePredicateFn() => (this != ffi.nullptr) ? this.value.toSelectableDayForRangePredicateFn() : null;
}

extension on PointerEnterEventListenerFFI {
  PointerEnterEventListener toPointerEnterEventListenerFn() {
    return (PointerEnterEvent event) {
      DartPointerEnterEventListenerFFIFunction dFn = asFunction();
      dFn(_addWidget(event));
    };
  }
}
extension on ffi.Pointer<PointerEnterEventListenerFFI> {
  PointerEnterEventListener? toPointerEnterEventListenerFn() => (this != ffi.nullptr) ? this.value.toPointerEnterEventListenerFn() : null;
}

extension on PointerExitEventListenerFFI {
  PointerExitEventListener toPointerExitEventListenerFn() {
    return (PointerExitEvent event) {
      DartPointerExitEventListenerFFIFunction dFn = asFunction();
      dFn(_addWidget(event));
    };
  }
}
extension on ffi.Pointer<PointerExitEventListenerFFI> {
  PointerExitEventListener? toPointerExitEventListenerFn() => (this != ffi.nullptr) ? this.value.toPointerExitEventListenerFn() : null;
}

extension on PointerHoverEventListenerFFI {
  PointerHoverEventListener toPointerHoverEventListenerFn() {
    return (PointerHoverEvent event) {
      DartPointerHoverEventListenerFFIFunction dFn = asFunction();
      dFn(_addWidget(event));
    };
  }
}
extension on ffi.Pointer<PointerHoverEventListenerFFI> {
  PointerHoverEventListener? toPointerHoverEventListenerFn() => (this != ffi.nullptr) ? this.value.toPointerHoverEventListenerFn() : null;
}

extension on VoidCallbackFFI {
  VoidCallback toVoidCallbackFn() {
    return () {
      DartVoidCallbackFFIFunction dFn = asFunction();
      dFn();
    };
  }
}
extension on ffi.Pointer<VoidCallbackFFI> {
  VoidCallback? toVoidCallbackFn() => (this != ffi.nullptr) ? this.value.toVoidCallbackFn() : null;
}

extension on NullableIndexedWidgetBuilderFFI {
  NullableIndexedWidgetBuilder toNullableIndexedWidgetBuilderFn() {
    return (BuildContext context, int index) => _runBuildScope(() {
      DartNullableIndexedWidgetBuilderFFIFunction dFn = asFunction();
      final dFnRet = dFn(_addWidget(context), index);
      return dFnRet.objOrNul();
    });
  }
}
extension on ffi.Pointer<NullableIndexedWidgetBuilderFFI> {
  NullableIndexedWidgetBuilder? toNullableIndexedWidgetBuilderFn() => (this != ffi.nullptr) ? this.value.toNullableIndexedWidgetBuilderFn() : null;
}

extension on IndexedWidgetBuilderFFI {
  IndexedWidgetBuilder toIndexedWidgetBuilderFn() {
    return (BuildContext context, int index) => _runBuildScope(() {
      DartIndexedWidgetBuilderFFIFunction dFn = asFunction();
      final dFnRet = dFn(_addWidget(context), index);
      return _widgetsMap[dFnRet]! as Widget;
    });
  }
}
extension on ffi.Pointer<IndexedWidgetBuilderFFI> {
  IndexedWidgetBuilder? toIndexedWidgetBuilderFn() => (this != ffi.nullptr) ? this.value.toIndexedWidgetBuilderFn() : null;
}

extension on ValueChangedForIntFFI {
  ValueChanged<int> toValueChangedForIntFn() {
    return (int value) {
      DartValueChangedForIntFFIFunction dFn = asFunction();
      dFn(value);
    };
  }
}
extension on ffi.Pointer<ValueChangedForIntFFI> {
  ValueChanged<int>? toValueChangedForIntFn() => (this != ffi.nullptr) ? this.value.toValueChangedForIntFn() : null;
}

extension on GestureScaleEndCallbackFFI {
  GestureScaleEndCallback toGestureScaleEndCallbackFn() {
    return (ScaleEndDetails details) {
      DartGestureScaleEndCallbackFFIFunction dFn = asFunction();
      dFn(_addWidget(details));
    };
  }
}
extension on ffi.Pointer<GestureScaleEndCallbackFFI> {
  GestureScaleEndCallback? toGestureScaleEndCallbackFn() => (this != ffi.nullptr) ? this.value.toGestureScaleEndCallbackFn() : null;
}

extension on GestureScaleStartCallbackFFI {
  GestureScaleStartCallback toGestureScaleStartCallbackFn() {
    return (ScaleStartDetails details) {
      DartGestureScaleStartCallbackFFIFunction dFn = asFunction();
      dFn(_addWidget(details));
    };
  }
}
extension on ffi.Pointer<GestureScaleStartCallbackFFI> {
  GestureScaleStartCallback? toGestureScaleStartCallbackFn() => (this != ffi.nullptr) ? this.value.toGestureScaleStartCallbackFn() : null;
}

extension on GestureScaleUpdateCallbackFFI {
  GestureScaleUpdateCallback toGestureScaleUpdateCallbackFn() {
    return (ScaleUpdateDetails details) {
      DartGestureScaleUpdateCallbackFFIFunction dFn = asFunction();
      dFn(_addWidget(details));
    };
  }
}
extension on ffi.Pointer<GestureScaleUpdateCallbackFFI> {
  GestureScaleUpdateCallback? toGestureScaleUpdateCallbackFn() => (this != ffi.nullptr) ? this.value.toGestureScaleUpdateCallbackFn() : null;
}

extension on DragAnchorStrategyFFI {
  DragAnchorStrategy toDragAnchorStrategyFn() {
    return (Draggable<Object> draggable, BuildContext context, Offset position) => _runBuildScope(() {
      DartDragAnchorStrategyFFIFunction dFn = asFunction();
      final dFnRet = dFn(_addWidget(draggable), _addWidget(context), _addWidget(position));
      return _widgetsMap[dFnRet]! as Offset;
    });
  }
}
extension on ffi.Pointer<DragAnchorStrategyFFI> {
  DragAnchorStrategy? toDragAnchorStrategyFn() => (this != ffi.nullptr) ? this.value.toDragAnchorStrategyFn() : null;
}

extension on DragUpdateCallbackFFI {
  DragUpdateCallback toDragUpdateCallbackFn() {
    return (DragUpdateDetails details) {
      DartDragUpdateCallbackFFIFunction dFn = asFunction();
      dFn(_addWidget(details));
    };
  }
}
extension on ffi.Pointer<DragUpdateCallbackFFI> {
  DragUpdateCallback? toDragUpdateCallbackFn() => (this != ffi.nullptr) ? this.value.toDragUpdateCallbackFn() : null;
}

extension on DraggableCanceledCallbackFFI {
  DraggableCanceledCallback toDraggableCanceledCallbackFn() {
    return (Velocity velocity, Offset offset) {
      DartDraggableCanceledCallbackFFIFunction dFn = asFunction();
      dFn(_addWidget(velocity), _addWidget(offset));
    };
  }
}
extension on ffi.Pointer<DraggableCanceledCallbackFFI> {
  DraggableCanceledCallback? toDraggableCanceledCallbackFn() => (this != ffi.nullptr) ? this.value.toDraggableCanceledCallbackFn() : null;
}

extension on DragEndCallbackFFI {
  DragEndCallback toDragEndCallbackFn() {
    return (DraggableDetails details) {
      DartDragEndCallbackFFIFunction dFn = asFunction();
      dFn(_addWidget(details));
    };
  }
}
extension on ffi.Pointer<DragEndCallbackFFI> {
  DragEndCallback? toDragEndCallbackFn() => (this != ffi.nullptr) ? this.value.toDragEndCallbackFn() : null;
}

extension on AllowedButtonsFilterFFI {
  AllowedButtonsFilter toAllowedButtonsFilterFn() {
    return (int buttons) {
      DartAllowedButtonsFilterFFIFunction dFn = asFunction();
      final dFnRet = dFn(buttons);
      return dFnRet.toBool();
    };
  }
}
extension on ffi.Pointer<AllowedButtonsFilterFFI> {
  AllowedButtonsFilter? toAllowedButtonsFilterFn() => (this != ffi.nullptr) ? this.value.toAllowedButtonsFilterFn() : null;
}

extension on DragTargetBuilderForTFFI {
  DragTargetBuilder<T> toDragTargetBuilderForTFn<T>() {
    return (BuildContext context, List<T?> candidateData, List<dynamic> rejectedData) => _runBuildScope(() {
      DartDragTargetBuilderForTFFIFunction dFn = asFunction();
      final dFnRet = dFn(_addWidget(context), candidateData.toArrayC(), rejectedData.toArrayC());
      return _widgetsMap[dFnRet]! as Widget;
    });
  }
}
extension on ffi.Pointer<DragTargetBuilderForTFFI> {
  DragTargetBuilder<T>? toDragTargetBuilderForTFn<T>() => (this != ffi.nullptr) ? this.value.toDragTargetBuilderForTFn() : null;
}

extension on DragTargetWillAcceptForTFFI {
  DragTargetWillAccept<T> toDragTargetWillAcceptForTFn<T>() {
    return (T? data) {
      DartDragTargetWillAcceptForTFFIFunction dFn = asFunction();
      final dFnRet = dFn(_addWidget(data));
      return dFnRet.toBool();
    };
  }
}
extension on ffi.Pointer<DragTargetWillAcceptForTFFI> {
  DragTargetWillAccept<T>? toDragTargetWillAcceptForTFn<T>() => (this != ffi.nullptr) ? this.value.toDragTargetWillAcceptForTFn() : null;
}

extension on DragTargetWillAcceptWithDetailsForTFFI {
  DragTargetWillAcceptWithDetails<T> toDragTargetWillAcceptWithDetailsForTFn<T>() {
    return (DragTargetDetails<T> details) {
      DartDragTargetWillAcceptWithDetailsForTFFIFunction dFn = asFunction();
      final dFnRet = dFn(_addWidget(details));
      return dFnRet.toBool();
    };
  }
}
extension on ffi.Pointer<DragTargetWillAcceptWithDetailsForTFFI> {
  DragTargetWillAcceptWithDetails<T>? toDragTargetWillAcceptWithDetailsForTFn<T>() => (this != ffi.nullptr) ? this.value.toDragTargetWillAcceptWithDetailsForTFn() : null;
}

extension on DragTargetAcceptForTFFI {
  DragTargetAccept<T> toDragTargetAcceptForTFn<T>() {
    return (T? data) {
      DartDragTargetAcceptForTFFIFunction dFn = asFunction();
      dFn(_addWidget(data));
    };
  }
}
extension on ffi.Pointer<DragTargetAcceptForTFFI> {
  DragTargetAccept<T>? toDragTargetAcceptForTFn<T>() => (this != ffi.nullptr) ? this.value.toDragTargetAcceptForTFn() : null;
}

extension on DragTargetAcceptWithDetailsForTFFI {
  DragTargetAcceptWithDetails<T> toDragTargetAcceptWithDetailsForTFn<T>() {
    return (DragTargetDetails<T> details) {
      DartDragTargetAcceptWithDetailsForTFFIFunction dFn = asFunction();
      dFn(_addWidget(details));
    };
  }
}
extension on ffi.Pointer<DragTargetAcceptWithDetailsForTFFI> {
  DragTargetAcceptWithDetails<T>? toDragTargetAcceptWithDetailsForTFn<T>() => (this != ffi.nullptr) ? this.value.toDragTargetAcceptWithDetailsForTFn() : null;
}

extension on DragTargetLeaveForTFFI {
  DragTargetLeave<T> toDragTargetLeaveForTFn<T>() {
    return (T? data) {
      DartDragTargetLeaveForTFFIFunction dFn = asFunction();
      dFn(_addWidget(data));
    };
  }
}
extension on ffi.Pointer<DragTargetLeaveForTFFI> {
  DragTargetLeave<T>? toDragTargetLeaveForTFn<T>() => (this != ffi.nullptr) ? this.value.toDragTargetLeaveForTFn() : null;
}

extension on DragTargetMoveForTFFI {
  DragTargetMove<T> toDragTargetMoveForTFn<T>() {
    return (DragTargetDetails<T> details) {
      DartDragTargetMoveForTFFIFunction dFn = asFunction();
      dFn(_addWidget(details));
    };
  }
}
extension on ffi.Pointer<DragTargetMoveForTFFI> {
  DragTargetMove<T>? toDragTargetMoveForTFn<T>() => (this != ffi.nullptr) ? this.value.toDragTargetMoveForTFn() : null;
}

extension on HeroFlightShuttleBuilderFFI {
  HeroFlightShuttleBuilder toHeroFlightShuttleBuilderFn() {
    return (BuildContext flightContext, Animation<double> animation, HeroFlightDirection flightDirection, BuildContext fromHeroContext, BuildContext toHeroContext) => _runBuildScope(() {
      DartHeroFlightShuttleBuilderFFIFunction dFn = asFunction();
      final dFnRet = dFn(_addWidget(flightContext), _addWidget(animation), flightDirection.index, _addWidget(fromHeroContext), _addWidget(toHeroContext));
      return _widgetsMap[dFnRet]! as Widget;
    });
  }
}
extension on ffi.Pointer<HeroFlightShuttleBuilderFFI> {
  HeroFlightShuttleBuilder? toHeroFlightShuttleBuilderFn() => (this != ffi.nullptr) ? this.value.toHeroFlightShuttleBuilderFn() : null;
}

extension on AnimatedSwitcherTransitionBuilderFFI {
  AnimatedSwitcherTransitionBuilder toAnimatedSwitcherTransitionBuilderFn() {
    return (Widget child, Animation<double> animation) => _runBuildScope(() {
      DartAnimatedSwitcherTransitionBuilderFFIFunction dFn = asFunction();
      final dFnRet = dFn(_addWidget(child), _addWidget(animation));
      return _widgetsMap[dFnRet]! as Widget;
    });
  }
}
extension on ffi.Pointer<AnimatedSwitcherTransitionBuilderFFI> {
  AnimatedSwitcherTransitionBuilder? toAnimatedSwitcherTransitionBuilderFn() => (this != ffi.nullptr) ? this.value.toAnimatedSwitcherTransitionBuilderFn() : null;
}

extension on AnimatedSwitcherLayoutBuilderFFI {
  AnimatedSwitcherLayoutBuilder toAnimatedSwitcherLayoutBuilderFn() {
    return (Widget? currentChild, List<Widget> previousChildren) => _runBuildScope(() {
      DartAnimatedSwitcherLayoutBuilderFFIFunction dFn = asFunction();
      final dFnRet = dFn(_addWidget(currentChild), previousChildren.toArrayC());
      return _widgetsMap[dFnRet]! as Widget;
    });
  }
}
extension on ffi.Pointer<AnimatedSwitcherLayoutBuilderFFI> {
  AnimatedSwitcherLayoutBuilder? toAnimatedSwitcherLayoutBuilderFn() => (this != ffi.nullptr) ? this.value.toAnimatedSwitcherLayoutBuilderFn() : null;
}

extension on ValueChangedForBoolFFI {
  ValueChanged<bool> toValueChangedForBoolFn() {
    return (bool value) {
      DartValueChangedForBoolFFIFunction dFn = asFunction();
      dFn(value.toInt());
    };
  }
}
extension on ffi.Pointer<ValueChangedForBoolFFI> {
  ValueChanged<bool>? toValueChangedForBoolFn() => (this != ffi.nullptr) ? this.value.toValueChangedForBoolFn() : null;
}

extension on DrawerCallbackFFI {
  DrawerCallback toDrawerCallbackFn() {
    return (bool isOpened) {
      DartDrawerCallbackFFIFunction dFn = asFunction();
      dFn(isOpened.toInt());
    };
  }
}
extension on ffi.Pointer<DrawerCallbackFFI> {
  DrawerCallback? toDrawerCallbackFn() => (this != ffi.nullptr) ? this.value.toDrawerCallbackFn() : null;
}

extension on DartObjCallbackDartObjDartObjFFI {
  Widget? Function(BuildContext, Animation<double>) toDartObjCallbackDartObjDartObjFn() {
    return (BuildContext b, Animation<double> a) => _runBuildScope(() {
      DartDartObjCallbackDartObjDartObjFFIFunction dFn = asFunction();
      final dFnRet = dFn(_addWidget(b), _addWidget(a));
      return dFnRet.objOrNul();
    });
  }
}
extension on ffi.Pointer<DartObjCallbackDartObjDartObjFFI> {
  Widget? Function(BuildContext, Animation<double>)? toDartObjCallbackDartObjDartObjFn() => (this != ffi.nullptr) ? this.value.toDartObjCallbackDartObjDartObjFn() : null;
}

extension on GenerateAppTitleFFI {
  GenerateAppTitle toGenerateAppTitleFn() {
    return (BuildContext context) {
      DartGenerateAppTitleFFIFunction dFn = asFunction();
      final dFnRet = dFn(_addWidget(context));
      return dFnRet.cast<Utf8>().toDartString();
    };
  }
}
extension on ffi.Pointer<GenerateAppTitleFFI> {
  GenerateAppTitle? toGenerateAppTitleFn() => (this != ffi.nullptr) ? this.value.toGenerateAppTitleFn() : null;
}

extension on ValueChangedForStringFFI {
  ValueChanged<String> toValueChangedForStringFn() {
    return (String value) {
      DartValueChangedForStringFFIFunction dFn = asFunction();
      dFn(value.toNativeUtf8().cast<ffi.Char>());
    };
  }
}
extension on ffi.Pointer<ValueChangedForStringFFI> {
  ValueChanged<String>? toValueChangedForStringFn() => (this != ffi.nullptr) ? this.value.toValueChangedForStringFn() : null;
}

extension on GestureTapCallbackFFI {
  GestureTapCallback toGestureTapCallbackFn() {
    return () {
      DartGestureTapCallbackFFIFunction dFn = asFunction();
      dFn();
    };
  }
}
extension on ffi.Pointer<GestureTapCallbackFFI> {
  GestureTapCallback? toGestureTapCallbackFn() => (this != ffi.nullptr) ? this.value.toGestureTapCallbackFn() : null;
}

extension on TapRegionCallbackFFI {
  TapRegionCallback toTapRegionCallbackFn() {
    return (PointerDownEvent event) {
      DartTapRegionCallbackFFIFunction dFn = asFunction();
      dFn(_addWidget(event));
    };
  }
}
extension on ffi.Pointer<TapRegionCallbackFFI> {
  TapRegionCallback? toTapRegionCallbackFn() => (this != ffi.nullptr) ? this.value.toTapRegionCallbackFn() : null;
}

extension on TapRegionUpCallbackFFI {
  TapRegionUpCallback toTapRegionUpCallbackFn() {
    return (PointerUpEvent event) {
      DartTapRegionUpCallbackFFIFunction dFn = asFunction();
      dFn(_addWidget(event));
    };
  }
}
extension on ffi.Pointer<TapRegionUpCallbackFFI> {
  TapRegionUpCallback? toTapRegionUpCallbackFn() => (this != ffi.nullptr) ? this.value.toTapRegionUpCallbackFn() : null;
}

extension on InputCounterWidgetBuilderFFI {
  InputCounterWidgetBuilder toInputCounterWidgetBuilderFn() {
    return (BuildContext context, {required int currentLength, required bool isFocused, required int? maxLength}) => _runBuildScope(() {
      DartInputCounterWidgetBuilderFFIFunction dFn = asFunction();
      final dFnRet = dFn(_addWidget(context), currentLength, isFocused.toInt(), maxLength!);
      return dFnRet.objOrNul();
    });
  }
}
extension on ffi.Pointer<InputCounterWidgetBuilderFFI> {
  InputCounterWidgetBuilder? toInputCounterWidgetBuilderFn() => (this != ffi.nullptr) ? this.value.toInputCounterWidgetBuilderFn() : null;
}

extension on GestureTapDownCallbackFFI {
  GestureTapDownCallback toGestureTapDownCallbackFn() {
    return (TapDownDetails details) {
      DartGestureTapDownCallbackFFIFunction dFn = asFunction();
      dFn(_addWidget(details));
    };
  }
}
extension on ffi.Pointer<GestureTapDownCallbackFFI> {
  GestureTapDownCallback? toGestureTapDownCallbackFn() => (this != ffi.nullptr) ? this.value.toGestureTapDownCallbackFn() : null;
}

extension on GestureTapUpCallbackFFI {
  GestureTapUpCallback toGestureTapUpCallbackFn() {
    return (TapUpDetails details) {
      DartGestureTapUpCallbackFFIFunction dFn = asFunction();
      dFn(_addWidget(details));
    };
  }
}
extension on ffi.Pointer<GestureTapUpCallbackFFI> {
  GestureTapUpCallback? toGestureTapUpCallbackFn() => (this != ffi.nullptr) ? this.value.toGestureTapUpCallbackFn() : null;
}

extension on GestureTapMoveCallbackFFI {
  GestureTapMoveCallback toGestureTapMoveCallbackFn() {
    return (TapMoveDetails details) {
      DartGestureTapMoveCallbackFFIFunction dFn = asFunction();
      dFn(_addWidget(details));
    };
  }
}
extension on ffi.Pointer<GestureTapMoveCallbackFFI> {
  GestureTapMoveCallback? toGestureTapMoveCallbackFn() => (this != ffi.nullptr) ? this.value.toGestureTapMoveCallbackFn() : null;
}

extension on GestureTapCancelCallbackFFI {
  GestureTapCancelCallback toGestureTapCancelCallbackFn() {
    return () {
      DartGestureTapCancelCallbackFFIFunction dFn = asFunction();
      dFn();
    };
  }
}
extension on ffi.Pointer<GestureTapCancelCallbackFFI> {
  GestureTapCancelCallback? toGestureTapCancelCallbackFn() => (this != ffi.nullptr) ? this.value.toGestureTapCancelCallbackFn() : null;
}

extension on GestureLongPressDownCallbackFFI {
  GestureLongPressDownCallback toGestureLongPressDownCallbackFn() {
    return (LongPressDownDetails details) {
      DartGestureLongPressDownCallbackFFIFunction dFn = asFunction();
      dFn(_addWidget(details));
    };
  }
}
extension on ffi.Pointer<GestureLongPressDownCallbackFFI> {
  GestureLongPressDownCallback? toGestureLongPressDownCallbackFn() => (this != ffi.nullptr) ? this.value.toGestureLongPressDownCallbackFn() : null;
}

extension on GestureLongPressCancelCallbackFFI {
  GestureLongPressCancelCallback toGestureLongPressCancelCallbackFn() {
    return () {
      DartGestureLongPressCancelCallbackFFIFunction dFn = asFunction();
      dFn();
    };
  }
}
extension on ffi.Pointer<GestureLongPressCancelCallbackFFI> {
  GestureLongPressCancelCallback? toGestureLongPressCancelCallbackFn() => (this != ffi.nullptr) ? this.value.toGestureLongPressCancelCallbackFn() : null;
}

extension on GestureLongPressCallbackFFI {
  GestureLongPressCallback toGestureLongPressCallbackFn() {
    return () {
      DartGestureLongPressCallbackFFIFunction dFn = asFunction();
      dFn();
    };
  }
}
extension on ffi.Pointer<GestureLongPressCallbackFFI> {
  GestureLongPressCallback? toGestureLongPressCallbackFn() => (this != ffi.nullptr) ? this.value.toGestureLongPressCallbackFn() : null;
}

extension on GestureLongPressStartCallbackFFI {
  GestureLongPressStartCallback toGestureLongPressStartCallbackFn() {
    return (LongPressStartDetails details) {
      DartGestureLongPressStartCallbackFFIFunction dFn = asFunction();
      dFn(_addWidget(details));
    };
  }
}
extension on ffi.Pointer<GestureLongPressStartCallbackFFI> {
  GestureLongPressStartCallback? toGestureLongPressStartCallbackFn() => (this != ffi.nullptr) ? this.value.toGestureLongPressStartCallbackFn() : null;
}

extension on GestureLongPressMoveUpdateCallbackFFI {
  GestureLongPressMoveUpdateCallback toGestureLongPressMoveUpdateCallbackFn() {
    return (LongPressMoveUpdateDetails details) {
      DartGestureLongPressMoveUpdateCallbackFFIFunction dFn = asFunction();
      dFn(_addWidget(details));
    };
  }
}
extension on ffi.Pointer<GestureLongPressMoveUpdateCallbackFFI> {
  GestureLongPressMoveUpdateCallback? toGestureLongPressMoveUpdateCallbackFn() => (this != ffi.nullptr) ? this.value.toGestureLongPressMoveUpdateCallbackFn() : null;
}

extension on GestureLongPressUpCallbackFFI {
  GestureLongPressUpCallback toGestureLongPressUpCallbackFn() {
    return () {
      DartGestureLongPressUpCallbackFFIFunction dFn = asFunction();
      dFn();
    };
  }
}
extension on ffi.Pointer<GestureLongPressUpCallbackFFI> {
  GestureLongPressUpCallback? toGestureLongPressUpCallbackFn() => (this != ffi.nullptr) ? this.value.toGestureLongPressUpCallbackFn() : null;
}

extension on GestureLongPressEndCallbackFFI {
  GestureLongPressEndCallback toGestureLongPressEndCallbackFn() {
    return (LongPressEndDetails details) {
      DartGestureLongPressEndCallbackFFIFunction dFn = asFunction();
      dFn(_addWidget(details));
    };
  }
}
extension on ffi.Pointer<GestureLongPressEndCallbackFFI> {
  GestureLongPressEndCallback? toGestureLongPressEndCallbackFn() => (this != ffi.nullptr) ? this.value.toGestureLongPressEndCallbackFn() : null;
}

extension on GestureDragDownCallbackFFI {
  GestureDragDownCallback toGestureDragDownCallbackFn() {
    return (DragDownDetails details) {
      DartGestureDragDownCallbackFFIFunction dFn = asFunction();
      dFn(_addWidget(details));
    };
  }
}
extension on ffi.Pointer<GestureDragDownCallbackFFI> {
  GestureDragDownCallback? toGestureDragDownCallbackFn() => (this != ffi.nullptr) ? this.value.toGestureDragDownCallbackFn() : null;
}

extension on GestureDragStartCallbackFFI {
  GestureDragStartCallback toGestureDragStartCallbackFn() {
    return (DragStartDetails details) {
      DartGestureDragStartCallbackFFIFunction dFn = asFunction();
      dFn(_addWidget(details));
    };
  }
}
extension on ffi.Pointer<GestureDragStartCallbackFFI> {
  GestureDragStartCallback? toGestureDragStartCallbackFn() => (this != ffi.nullptr) ? this.value.toGestureDragStartCallbackFn() : null;
}

extension on GestureDragUpdateCallbackFFI {
  GestureDragUpdateCallback toGestureDragUpdateCallbackFn() {
    return (DragUpdateDetails details) {
      DartGestureDragUpdateCallbackFFIFunction dFn = asFunction();
      dFn(_addWidget(details));
    };
  }
}
extension on ffi.Pointer<GestureDragUpdateCallbackFFI> {
  GestureDragUpdateCallback? toGestureDragUpdateCallbackFn() => (this != ffi.nullptr) ? this.value.toGestureDragUpdateCallbackFn() : null;
}

extension on GestureDragEndCallbackFFI {
  GestureDragEndCallback toGestureDragEndCallbackFn() {
    return (DragEndDetails details) {
      DartGestureDragEndCallbackFFIFunction dFn = asFunction();
      dFn(_addWidget(details));
    };
  }
}
extension on ffi.Pointer<GestureDragEndCallbackFFI> {
  GestureDragEndCallback? toGestureDragEndCallbackFn() => (this != ffi.nullptr) ? this.value.toGestureDragEndCallbackFn() : null;
}

extension on GestureDragCancelCallbackFFI {
  GestureDragCancelCallback toGestureDragCancelCallbackFn() {
    return () {
      DartGestureDragCancelCallbackFFIFunction dFn = asFunction();
      dFn();
    };
  }
}
extension on ffi.Pointer<GestureDragCancelCallbackFFI> {
  GestureDragCancelCallback? toGestureDragCancelCallbackFn() => (this != ffi.nullptr) ? this.value.toGestureDragCancelCallbackFn() : null;
}

extension on GestureForcePressStartCallbackFFI {
  GestureForcePressStartCallback toGestureForcePressStartCallbackFn() {
    return (ForcePressDetails details) {
      DartGestureForcePressStartCallbackFFIFunction dFn = asFunction();
      dFn(_addWidget(details));
    };
  }
}
extension on ffi.Pointer<GestureForcePressStartCallbackFFI> {
  GestureForcePressStartCallback? toGestureForcePressStartCallbackFn() => (this != ffi.nullptr) ? this.value.toGestureForcePressStartCallbackFn() : null;
}

extension on GestureForcePressPeakCallbackFFI {
  GestureForcePressPeakCallback toGestureForcePressPeakCallbackFn() {
    return (ForcePressDetails details) {
      DartGestureForcePressPeakCallbackFFIFunction dFn = asFunction();
      dFn(_addWidget(details));
    };
  }
}
extension on ffi.Pointer<GestureForcePressPeakCallbackFFI> {
  GestureForcePressPeakCallback? toGestureForcePressPeakCallbackFn() => (this != ffi.nullptr) ? this.value.toGestureForcePressPeakCallbackFn() : null;
}

extension on GestureForcePressUpdateCallbackFFI {
  GestureForcePressUpdateCallback toGestureForcePressUpdateCallbackFn() {
    return (ForcePressDetails details) {
      DartGestureForcePressUpdateCallbackFFIFunction dFn = asFunction();
      dFn(_addWidget(details));
    };
  }
}
extension on ffi.Pointer<GestureForcePressUpdateCallbackFFI> {
  GestureForcePressUpdateCallback? toGestureForcePressUpdateCallbackFn() => (this != ffi.nullptr) ? this.value.toGestureForcePressUpdateCallbackFn() : null;
}

extension on GestureForcePressEndCallbackFFI {
  GestureForcePressEndCallback toGestureForcePressEndCallbackFn() {
    return (ForcePressDetails details) {
      DartGestureForcePressEndCallbackFFIFunction dFn = asFunction();
      dFn(_addWidget(details));
    };
  }
}
extension on ffi.Pointer<GestureForcePressEndCallbackFFI> {
  GestureForcePressEndCallback? toGestureForcePressEndCallbackFn() => (this != ffi.nullptr) ? this.value.toGestureForcePressEndCallbackFn() : null;
}

extension on ValueChangedForBoolOptFFI {
  ValueChanged<bool?> toValueChangedForBoolOptFn() {
    return (bool? value) {
      DartValueChangedForBoolOptFFIFunction dFn = asFunction();
      dFn((value != null) ? (calloc<ffi.Int>()..value = (value! ? 1 : 0)) : ffi.nullptr);
    };
  }
}
extension on ffi.Pointer<ValueChangedForBoolOptFFI> {
  ValueChanged<bool?>? toValueChangedForBoolOptFn() => (this != ffi.nullptr) ? this.value.toValueChangedForBoolOptFn() : null;
}

extension on ValueChangedForDoubleFFI {
  ValueChanged<double> toValueChangedForDoubleFn() {
    return (double value) {
      DartValueChangedForDoubleFFIFunction dFn = asFunction();
      dFn(value);
    };
  }
}
extension on ffi.Pointer<ValueChangedForDoubleFFI> {
  ValueChanged<double>? toValueChangedForDoubleFn() => (this != ffi.nullptr) ? this.value.toValueChangedForDoubleFn() : null;
}

extension on SemanticFormatterCallbackFFI {
  SemanticFormatterCallback toSemanticFormatterCallbackFn() {
    return (double value) {
      DartSemanticFormatterCallbackFFIFunction dFn = asFunction();
      final dFnRet = dFn(value);
      return dFnRet.cast<Utf8>().toDartString();
    };
  }
}
extension on ffi.Pointer<SemanticFormatterCallbackFFI> {
  SemanticFormatterCallback? toSemanticFormatterCallbackFn() => (this != ffi.nullptr) ? this.value.toSemanticFormatterCallbackFn() : null;
}

extension on TooltipTriggeredCallbackFFI {
  TooltipTriggeredCallback toTooltipTriggeredCallbackFn() {
    return () {
      DartTooltipTriggeredCallbackFFIFunction dFn = asFunction();
      dFn();
    };
  }
}
extension on ffi.Pointer<TooltipTriggeredCallbackFFI> {
  TooltipTriggeredCallback? toTooltipTriggeredCallbackFn() => (this != ffi.nullptr) ? this.value.toTooltipTriggeredCallbackFn() : null;
}

extension on TabValueChangedForBoolFFI {
  TabValueChanged<bool> toTabValueChangedForBoolFn() {
    return (bool value, int index) {
      DartTabValueChangedForBoolFFIFunction dFn = asFunction();
      dFn(value.toInt(), index);
    };
  }
}
extension on ffi.Pointer<TabValueChangedForBoolFFI> {
  TabValueChanged<bool>? toTabValueChangedForBoolFn() => (this != ffi.nullptr) ? this.value.toTabValueChangedForBoolFn() : null;
}

extension on ValueSetterForBoolOptFFI {
  ValueSetter<bool?> toValueSetterForBoolOptFn() {
    return (bool? value) {
      DartValueSetterForBoolOptFFIFunction dFn = asFunction();
      dFn((value != null) ? (calloc<ffi.Int>()..value = (value! ? 1 : 0)) : ffi.nullptr);
    };
  }
}
extension on ffi.Pointer<ValueSetterForBoolOptFFI> {
  ValueSetter<bool?>? toValueSetterForBoolOptFn() => (this != ffi.nullptr) ? this.value.toValueSetterForBoolOptFn() : null;
}

extension on DataColumnSortCallbackFFI {
  DataColumnSortCallback toDataColumnSortCallbackFn() {
    return (int columnIndex, bool ascending) {
      DartDataColumnSortCallbackFFIFunction dFn = asFunction();
      dFn(columnIndex, ascending.toInt());
    };
  }
}
extension on ffi.Pointer<DataColumnSortCallbackFFI> {
  DataColumnSortCallback? toDataColumnSortCallbackFn() => (this != ffi.nullptr) ? this.value.toDataColumnSortCallbackFn() : null;
}

extension on ValueChangedForTOptFFI {
  ValueChanged<T?> toValueChangedForTOptFn<T>() {
    return (T? value) {
      DartValueChangedForTOptFFIFunction dFn = asFunction();
      dFn((value != null) ? (calloc<ffi.Int>()..value = _addWidget(value)) : ffi.nullptr);
    };
  }
}
extension on ffi.Pointer<ValueChangedForTOptFFI> {
  ValueChanged<T?>? toValueChangedForTOptFn<T>() => (this != ffi.nullptr) ? this.value.toValueChangedForTOptFn() : null;
}

extension on ExpansionPanelHeaderBuilderFFI {
  ExpansionPanelHeaderBuilder toExpansionPanelHeaderBuilderFn() {
    return (BuildContext context, bool isExpanded) => _runBuildScope(() {
      DartExpansionPanelHeaderBuilderFFIFunction dFn = asFunction();
      final dFnRet = dFn(_addWidget(context), isExpanded.toInt());
      return _widgetsMap[dFnRet]! as Widget;
    });
  }
}
extension on ffi.Pointer<ExpansionPanelHeaderBuilderFFI> {
  ExpansionPanelHeaderBuilder? toExpansionPanelHeaderBuilderFn() => (this != ffi.nullptr) ? this.value.toExpansionPanelHeaderBuilderFn() : null;
}

extension on ExpansionPanelCallbackFFI {
  ExpansionPanelCallback toExpansionPanelCallbackFn() {
    return (int panelIndex, bool isExpanded) {
      DartExpansionPanelCallbackFFIFunction dFn = asFunction();
      dFn(panelIndex, isExpanded.toInt());
    };
  }
}
extension on ffi.Pointer<ExpansionPanelCallbackFFI> {
  ExpansionPanelCallback? toExpansionPanelCallbackFn() => (this != ffi.nullptr) ? this.value.toExpansionPanelCallbackFn() : null;
}

extension on PopupMenuItemBuilderForTFFI {
  PopupMenuItemBuilder<T> toPopupMenuItemBuilderForTFn<T>() {
    return (BuildContext context) => _runBuildScope(() {
      DartPopupMenuItemBuilderForTFFIFunction dFn = asFunction();
      final dFnRet = dFn(_addWidget(context));
      return dFnRet.listOrEmpty();
    });
  }
}
extension on ffi.Pointer<PopupMenuItemBuilderForTFFI> {
  PopupMenuItemBuilder<T>? toPopupMenuItemBuilderForTFn<T>() => (this != ffi.nullptr) ? this.value.toPopupMenuItemBuilderForTFn() : null;
}

extension on PopupMenuItemSelectedForTFFI {
  PopupMenuItemSelected<T> toPopupMenuItemSelectedForTFn<T>() {
    return (T? value) {
      DartPopupMenuItemSelectedForTFFIFunction dFn = asFunction();
      dFn(_addWidget(value));
    };
  }
}
extension on ffi.Pointer<PopupMenuItemSelectedForTFFI> {
  PopupMenuItemSelected<T>? toPopupMenuItemSelectedForTFn<T>() => (this != ffi.nullptr) ? this.value.toPopupMenuItemSelectedForTFn() : null;
}

extension on PopupMenuCanceledFFI {
  PopupMenuCanceled toPopupMenuCanceledFn() {
    return () {
      DartPopupMenuCanceledFFIFunction dFn = asFunction();
      dFn();
    };
  }
}
extension on ffi.Pointer<PopupMenuCanceledFFI> {
  PopupMenuCanceled? toPopupMenuCanceledFn() => (this != ffi.nullptr) ? this.value.toPopupMenuCanceledFn() : null;
}

extension on ValueChangedForDateTimeFFI {
  ValueChanged<DateTime> toValueChangedForDateTimeFn() {
    return (DateTime value) {
      DartValueChangedForDateTimeFFIFunction dFn = asFunction();
      dFn(_addWidget(value));
    };
  }
}
extension on ffi.Pointer<ValueChangedForDateTimeFFI> {
  ValueChanged<DateTime>? toValueChangedForDateTimeFn() => (this != ffi.nullptr) ? this.value.toValueChangedForDateTimeFn() : null;
}

extension on ValueChangedForDurationFFI {
  ValueChanged<Duration> toValueChangedForDurationFn() {
    return (Duration value) {
      DartValueChangedForDurationFFIFunction dFn = asFunction();
      dFn(_addWidget(value));
    };
  }
}
extension on ffi.Pointer<ValueChangedForDurationFFI> {
  ValueChanged<Duration>? toValueChangedForDurationFn() => (this != ffi.nullptr) ? this.value.toValueChangedForDurationFn() : null;
}

extension on SelectionOverlayBuilderFFI {
  SelectionOverlayBuilder toSelectionOverlayBuilderFn() {
    return (BuildContext context, {required int columnCount, required int selectedIndex}) => _runBuildScope(() {
      DartSelectionOverlayBuilderFFIFunction dFn = asFunction();
      final dFnRet = dFn(_addWidget(context), columnCount, selectedIndex);
      return dFnRet.objOrNul();
    });
  }
}
extension on ffi.Pointer<SelectionOverlayBuilderFFI> {
  SelectionOverlayBuilder? toSelectionOverlayBuilderFn() => (this != ffi.nullptr) ? this.value.toSelectionOverlayBuilderFn() : null;
}

extension on CupertinoContextMenuBuilderFFI {
  CupertinoContextMenuBuilder toCupertinoContextMenuBuilderFn() {
    return (BuildContext context, Animation<double> animation) => _runBuildScope(() {
      DartCupertinoContextMenuBuilderFFIFunction dFn = asFunction();
      final dFnRet = dFn(_addWidget(context), _addWidget(animation));
      return _widgetsMap[dFnRet]! as Widget;
    });
  }
}
extension on ffi.Pointer<CupertinoContextMenuBuilderFFI> {
  CupertinoContextMenuBuilder? toCupertinoContextMenuBuilderFn() => (this != ffi.nullptr) ? this.value.toCupertinoContextMenuBuilderFn() : null;
}

extension on VoidCallbackDartObjFFI {
  void Function(T) toVoidCallbackDartObjFn<T>() {
    return (T? t) {
      DartVoidCallbackDartObjFFIFunction dFn = asFunction();
      dFn(_addWidget(t));
    };
  }
}
extension on ffi.Pointer<VoidCallbackDartObjFFI> {
  void Function(T)? toVoidCallbackDartObjFn<T>() => (this != ffi.nullptr) ? this.value.toVoidCallbackDartObjFn() : null;
}

extension on DartObjCallbackDartObjFFI {
  Widget Function(BuildContext) toDartObjCallbackDartObjFn() {
    return (BuildContext b) => _runBuildScope(() {
      DartDartObjCallbackDartObjFFIFunction dFn = asFunction();
      final dFnRet = dFn(_addWidget(b));
      return _widgetsMap[dFnRet]! as Widget;
    });
  }
}
extension on ffi.Pointer<DartObjCallbackDartObjFFI> {
  Widget Function(BuildContext)? toDartObjCallbackDartObjFn() => (this != ffi.nullptr) ? this.value.toDartObjCallbackDartObjFn() : null;
}

extension on DartObjCallbackFFI {
  State<StatefulWidget> Function() toDartObjCallbackFn() {
    return () => _runBuildScope(() {
      DartDartObjCallbackFFIFunction dFn = asFunction();
      final dFnRet = dFn();
      return _widgetsMap[dFnRet]! as State<StatefulWidget>;
    });
  }
}
extension on ffi.Pointer<DartObjCallbackFFI> {
  State<StatefulWidget> Function()? toDartObjCallbackFn() => (this != ffi.nullptr) ? this.value.toDartObjCallbackFn() : null;
}

