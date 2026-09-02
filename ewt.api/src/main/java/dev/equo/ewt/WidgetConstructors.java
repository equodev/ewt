package dev.equo.ewt;
import dev.equo.ewt.ffm.*;
import dev.equo.ewt.util.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.OptionalDouble;
import java.lang.foreign.*;
import java.util.function.*;
class WidgetConstructors extends WidgetConstructorsBase {
  <T> int dialogShowDialog(BuildContext context, Function<BuildContext, Widget> builder, Optional<Boolean> barrierDismissible, Optional<Color> barrierColor, Optional<String> barrierLabel, Optional<Boolean> useSafeArea, Optional<Boolean> useRootNavigator, Optional<Offset> anchorPoint, Optional<TraversalEdgeBehavior> traversalEdgeBehavior, Optional<Boolean> fullscreenDialog, Optional<Boolean> requestFocus) {
    var fn = WidgetFactories.showDialog(factories);
    return WidgetFactories.showDialog.invoke(fn, context.build().getId(),
      ptrWidgetBuilderFn(builder),
      ptrBool(barrierDismissible),
      ptrObj(barrierColor),
      ptrStr(barrierLabel),
      ptrBool(useSafeArea),
      ptrBool(useRootNavigator),
      ptrObj(anchorPoint),
      ptrEnum(traversalEdgeBehavior),
      ptrBool(fullscreenDialog),
      ptrBool(requestFocus));
  }
  int date_pickerShowDatePicker(BuildContext context, Optional<DateTime> initialDate, DateTime firstDate, DateTime lastDate, Optional<DateTime> currentDate, Optional<DatePickerEntryMode> initialEntryMode, Optional<Function<DateTime, Boolean>> selectableDayPredicate, Optional<String> helpText, Optional<String> cancelText, Optional<String> confirmText, Optional<Boolean> barrierDismissible, Optional<Color> barrierColor, Optional<String> barrierLabel, Optional<Boolean> useRootNavigator, Optional<TextDirection> textDirection, Optional<BiFunction<BuildContext, Widget, Widget>> builder, Optional<DatePickerMode> initialDatePickerMode, Optional<String> errorFormatText, Optional<String> errorInvalidText, Optional<String> fieldHintText, Optional<String> fieldLabelText, Optional<Offset> anchorPoint, Optional<Consumer<DatePickerEntryMode>> onDatePickerModeChange, Optional<Icon> switchToInputEntryModeIcon, Optional<Icon> switchToCalendarEntryModeIcon) {
    var fn = WidgetFactories.showDatePicker(factories);
    return WidgetFactories.showDatePicker.invoke(fn, context.build().getId(),
      ptrObj(initialDate),
      firstDate.build().getId(),
      lastDate.build().getId(),
      ptrObj(currentDate),
      ptrEnum(initialEntryMode),
      selectableDayPredicate.isPresent() ? ptrHolder(ptrSelectableDayPredicateFn(selectableDayPredicate.get())) : MemorySegment.NULL,
      ptrStr(helpText),
      ptrStr(cancelText),
      ptrStr(confirmText),
      ptrBool(barrierDismissible),
      ptrObj(barrierColor),
      ptrStr(barrierLabel),
      ptrBool(useRootNavigator),
      ptrEnum(textDirection),
      builder.isPresent() ? ptrHolder(ptrTransitionBuilderFn(builder.get())) : MemorySegment.NULL,
      ptrEnum(initialDatePickerMode),
      ptrStr(errorFormatText),
      ptrStr(errorInvalidText),
      ptrStr(fieldHintText),
      ptrStr(fieldLabelText),
      ptrObj(anchorPoint),
      onDatePickerModeChange.isPresent() ? ptrHolder(ptrValueChangedForDatePickerEntryModeFn(onDatePickerModeChange.get())) : MemorySegment.NULL,
      ptrObj(switchToInputEntryModeIcon),
      ptrObj(switchToCalendarEntryModeIcon));
  }
  int time_pickerShowTimePicker(BuildContext context, TimeOfDay initialTime, Optional<BiFunction<BuildContext, Widget, Widget>> builder, Optional<Boolean> barrierDismissible, Optional<Color> barrierColor, Optional<String> barrierLabel, Optional<Boolean> useRootNavigator, Optional<TimePickerEntryMode> initialEntryMode, Optional<String> cancelText, Optional<String> confirmText, Optional<String> helpText, Optional<String> errorInvalidText, Optional<String> hourLabelText, Optional<String> minuteLabelText, Optional<Consumer<TimePickerEntryMode>> onEntryModeChanged, Optional<Offset> anchorPoint, Optional<Orientation> orientation, Optional<Icon> switchToInputEntryModeIcon, Optional<Icon> switchToTimerEntryModeIcon) {
    var fn = WidgetFactories.showTimePicker(factories);
    return WidgetFactories.showTimePicker.invoke(fn, context.build().getId(),
      initialTime.build().getId(),
      builder.isPresent() ? ptrHolder(ptrTransitionBuilderFn(builder.get())) : MemorySegment.NULL,
      ptrBool(barrierDismissible),
      ptrObj(barrierColor),
      ptrStr(barrierLabel),
      ptrBool(useRootNavigator),
      ptrEnum(initialEntryMode),
      ptrStr(cancelText),
      ptrStr(confirmText),
      ptrStr(helpText),
      ptrStr(errorInvalidText),
      ptrStr(hourLabelText),
      ptrStr(minuteLabelText),
      onEntryModeChanged.isPresent() ? ptrHolder(ptrEntryModeChangeCallbackFn(onEntryModeChanged.get())) : MemorySegment.NULL,
      ptrObj(anchorPoint),
      ptrEnum(orientation),
      ptrObj(switchToInputEntryModeIcon),
      ptrObj(switchToTimerEntryModeIcon));
  }
  int date_pickerShowDateRangePicker(BuildContext context, DateTime firstDate, DateTime lastDate, Optional<DateTime> currentDate, Optional<DatePickerEntryMode> initialEntryMode, Optional<String> helpText, Optional<String> cancelText, Optional<String> confirmText, Optional<String> saveText, Optional<String> errorFormatText, Optional<String> errorInvalidText, Optional<String> errorInvalidRangeText, Optional<String> fieldStartHintText, Optional<String> fieldEndHintText, Optional<String> fieldStartLabelText, Optional<String> fieldEndLabelText, Optional<Boolean> barrierDismissible, Optional<Color> barrierColor, Optional<String> barrierLabel, Optional<Boolean> useRootNavigator, Optional<TextDirection> textDirection, Optional<BiFunction<BuildContext, Widget, Widget>> builder, Optional<Offset> anchorPoint, Optional<Icon> switchToInputEntryModeIcon, Optional<Icon> switchToCalendarEntryModeIcon, Optional<TriFunction<DateTime, DateTime, DateTime, Boolean>> selectableDayPredicate) {
    var fn = WidgetFactories.showDateRangePicker(factories);
    return WidgetFactories.showDateRangePicker.invoke(fn, context.build().getId(),
      firstDate.build().getId(),
      lastDate.build().getId(),
      ptrObj(currentDate),
      ptrEnum(initialEntryMode),
      ptrStr(helpText),
      ptrStr(cancelText),
      ptrStr(confirmText),
      ptrStr(saveText),
      ptrStr(errorFormatText),
      ptrStr(errorInvalidText),
      ptrStr(errorInvalidRangeText),
      ptrStr(fieldStartHintText),
      ptrStr(fieldEndHintText),
      ptrStr(fieldStartLabelText),
      ptrStr(fieldEndLabelText),
      ptrBool(barrierDismissible),
      ptrObj(barrierColor),
      ptrStr(barrierLabel),
      ptrBool(useRootNavigator),
      ptrEnum(textDirection),
      builder.isPresent() ? ptrHolder(ptrTransitionBuilderFn(builder.get())) : MemorySegment.NULL,
      ptrObj(anchorPoint),
      ptrObj(switchToInputEntryModeIcon),
      ptrObj(switchToCalendarEntryModeIcon),
      selectableDayPredicate.isPresent() ? ptrHolder(ptrSelectableDayForRangePredicateFn(selectableDayPredicate.get())) : MemorySegment.NULL);
  }
  MemorySegment textStyleTextStyle(Optional<Boolean> inherit, Optional<Color> color, Optional<Color> backgroundColor, OptionalDouble fontSize, Optional<FontWeight> fontWeight, Optional<FontStyle> fontStyle, OptionalDouble letterSpacing, OptionalDouble wordSpacing, Optional<TextBaseline> textBaseline, OptionalDouble height, Optional<TextLeadingDistribution> leadingDistribution, Optional<List<Shadow>> shadows, Optional<TextDecoration> decoration, Optional<Color> decorationColor, Optional<TextDecorationStyle> decorationStyle, OptionalDouble decorationThickness, Optional<String> debugLabel, Optional<String> fontFamily, Optional<List<String>> fontFamilyFallback, Optional<String> _package, Optional<TextOverflow> overflow) {
    var st = WidgetFactories.textStyle(factories);
    var fn = WidgetFactories.TextStyleSt.textStyle(st);
    return WidgetFactories.TextStyleSt.textStyle.invoke(fn, arena, ptrBool(inherit),
      ptrObj(color),
      ptrObj(backgroundColor),
      ptr(fontSize),
      ptrObj(fontWeight),
      ptrEnum(fontStyle),
      ptr(letterSpacing),
      ptr(wordSpacing),
      ptrEnum(textBaseline),
      ptr(height),
      ptrEnum(leadingDistribution),
      ptrList(shadows),
      ptrObj(decoration),
      ptrObj(decorationColor),
      ptrEnum(decorationStyle),
      ptr(decorationThickness),
      ptrStr(debugLabel),
      ptrStr(fontFamily),
      ptrStrList(fontFamilyFallback),
      ptrStr(_package),
      ptrEnum(overflow));
  }
  MemorySegment textStyleLerp(TextStyle a, TextStyle b, double t) {
    var st = WidgetFactories.textStyle(factories);
    var fn = WidgetFactories.TextStyleSt.lerp(st);
    return WidgetFactories.TextStyleSt.lerp.invoke(fn, arena, a != null ? a.build().getId() : null,
      b != null ? b.build().getId() : null,
      t);
  }

  int colorColor(int value) {
    var st = WidgetFactories.color(factories);
    var fn = WidgetFactories.ColorSt.color(st);
    return WidgetFactories.ColorSt.color.invoke(fn, value);
  }
  int colorFrom(double alpha, double red, double green, double blue, Optional<ColorSpace> colorSpace) {
    var st = WidgetFactories.color(factories);
    var fn = WidgetFactories.ColorSt.from(st);
    return WidgetFactories.ColorSt.from.invoke(fn, alpha,
      red,
      green,
      blue,
      ptrEnum(colorSpace));
  }
  int colorFromARGB(int a, int r, int g, int b) {
    var st = WidgetFactories.color(factories);
    var fn = WidgetFactories.ColorSt.fromARGB(st);
    return WidgetFactories.ColorSt.fromARGB.invoke(fn, a,
      r,
      g,
      b);
  }
  int colorFromRGBO(int r, int g, int b, double opacity) {
    var st = WidgetFactories.color(factories);
    var fn = WidgetFactories.ColorSt.fromRGBO(st);
    return WidgetFactories.ColorSt.fromRGBO.invoke(fn, r,
      g,
      b,
      opacity);
  }
  int colorLerp(Color x, Color y, double t) {
    var st = WidgetFactories.color(factories);
    var fn = WidgetFactories.ColorSt.lerp(st);
    return WidgetFactories.ColorSt.lerp.invoke(fn, x != null ? x.build().getId() : null,
      y != null ? y.build().getId() : null,
      t);
  }
  int colorAlphaBlend(Color foreground, Color background) {
    var st = WidgetFactories.color(factories);
    var fn = WidgetFactories.ColorSt.alphaBlend(st);
    return WidgetFactories.ColorSt.alphaBlend.invoke(fn, foreground.build().getId(),
      background.build().getId());
  }
  int colorGetAlphaFromOpacity(double opacity) {
    var st = WidgetFactories.color(factories);
    var fn = WidgetFactories.ColorSt.getAlphaFromOpacity(st);
    return WidgetFactories.ColorSt.getAlphaFromOpacity.invoke(fn, opacity);
  }

  int offsetOffset(double dx, double dy) {
    var st = WidgetFactories.offset(factories);
    var fn = WidgetFactories.OffsetSt.offset(st);
    return WidgetFactories.OffsetSt.offset.invoke(fn, dx,
      dy);
  }
  int offsetFromDirection(double direction, OptionalDouble distance) {
    var st = WidgetFactories.offset(factories);
    var fn = WidgetFactories.OffsetSt.fromDirection(st);
    return WidgetFactories.OffsetSt.fromDirection.invoke(fn, direction,
      ptr(distance));
  }
  int offsetLerp(Offset a, Offset b, double t) {
    var st = WidgetFactories.offset(factories);
    var fn = WidgetFactories.OffsetSt.lerp(st);
    return WidgetFactories.OffsetSt.lerp.invoke(fn, a != null ? a.build().getId() : null,
      b != null ? b.build().getId() : null,
      t);
  }
  double offsetDx(Offset self) {
    var st = WidgetFactories.offset(factories);
    var fn = WidgetFactories.OffsetSt.dx(st);
    return WidgetFactories.OffsetSt.dx.invoke(fn, self.build().getId());
  }
  double offsetDy(Offset self) {
    var st = WidgetFactories.offset(factories);
    var fn = WidgetFactories.OffsetSt.dy(st);
    return WidgetFactories.OffsetSt.dy.invoke(fn, self.build().getId());
  }

  int dateTimeDateTime(int year, OptionalInt month, OptionalInt day, OptionalInt hour, OptionalInt minute, OptionalInt second, OptionalInt millisecond, OptionalInt microsecond) {
    var st = WidgetFactories.dateTime(factories);
    var fn = WidgetFactories.DateTimeSt.dateTime(st);
    return WidgetFactories.DateTimeSt.dateTime.invoke(fn, year,
      ptr(month),
      ptr(day),
      ptr(hour),
      ptr(minute),
      ptr(second),
      ptr(millisecond),
      ptr(microsecond));
  }
  int dateTimeUtc(int year, OptionalInt month, OptionalInt day, OptionalInt hour, OptionalInt minute, OptionalInt second, OptionalInt millisecond, OptionalInt microsecond) {
    var st = WidgetFactories.dateTime(factories);
    var fn = WidgetFactories.DateTimeSt.utc(st);
    return WidgetFactories.DateTimeSt.utc.invoke(fn, year,
      ptr(month),
      ptr(day),
      ptr(hour),
      ptr(minute),
      ptr(second),
      ptr(millisecond),
      ptr(microsecond));
  }
  int dateTimeNow() {
    var st = WidgetFactories.dateTime(factories);
    var fn = WidgetFactories.DateTimeSt.now(st);
    return WidgetFactories.DateTimeSt.now.invoke(fn);
  }
  int dateTimeTimestamp() {
    var st = WidgetFactories.dateTime(factories);
    var fn = WidgetFactories.DateTimeSt.timestamp(st);
    return WidgetFactories.DateTimeSt.timestamp.invoke(fn);
  }
  int dateTimeFromMillisecondsSinceEpoch(int millisecondsSinceEpoch, Optional<Boolean> isUtc) {
    var st = WidgetFactories.dateTime(factories);
    var fn = WidgetFactories.DateTimeSt.fromMillisecondsSinceEpoch(st);
    return WidgetFactories.DateTimeSt.fromMillisecondsSinceEpoch.invoke(fn, millisecondsSinceEpoch,
      ptrBool(isUtc));
  }
  int dateTimeFromMicrosecondsSinceEpoch(int microsecondsSinceEpoch, Optional<Boolean> isUtc) {
    var st = WidgetFactories.dateTime(factories);
    var fn = WidgetFactories.DateTimeSt.fromMicrosecondsSinceEpoch(st);
    return WidgetFactories.DateTimeSt.fromMicrosecondsSinceEpoch.invoke(fn, microsecondsSinceEpoch,
      ptrBool(isUtc));
  }
  int dateTimeParse(String formattedString) {
    var st = WidgetFactories.dateTime(factories);
    var fn = WidgetFactories.DateTimeSt.parse(st);
    return WidgetFactories.DateTimeSt.parse.invoke(fn, arena.allocateFrom(formattedString));
  }
  int dateTimeTryParse(String formattedString) {
    var st = WidgetFactories.dateTime(factories);
    var fn = WidgetFactories.DateTimeSt.tryParse(st);
    return WidgetFactories.DateTimeSt.tryParse.invoke(fn, arena.allocateFrom(formattedString));
  }

  MemorySegment iconIcon(IconData icon, OptionalDouble size, OptionalDouble fill, OptionalDouble weight, OptionalDouble grade, OptionalDouble opticalSize, Optional<Color> color, Optional<List<Shadow>> shadows, Optional<String> semanticLabel, Optional<TextDirection> textDirection, Optional<Boolean> applyTextScaling, Optional<BlendMode> blendMode, Optional<FontWeight> fontWeight) {
    var st = WidgetFactories.icon(factories);
    var fn = WidgetFactories.IconSt.icon(st);
    return WidgetFactories.IconSt.icon.invoke(fn, arena, icon != null ? icon.build().getId() : null,
      ptr(size),
      ptr(fill),
      ptr(weight),
      ptr(grade),
      ptr(opticalSize),
      ptrObj(color),
      ptrList(shadows),
      ptrStr(semanticLabel),
      ptrEnum(textDirection),
      ptrBool(applyTextScaling),
      ptrEnum(blendMode),
      ptrObj(fontWeight));
  }

  MemorySegment timeOfDayTimeOfDay(int hour, int minute) {
    var st = WidgetFactories.timeOfDay(factories);
    var fn = WidgetFactories.TimeOfDaySt.timeOfDay(st);
    return WidgetFactories.TimeOfDaySt.timeOfDay.invoke(fn, arena, hour,
      minute);
  }
  MemorySegment timeOfDayFromDateTime(DateTime time) {
    var st = WidgetFactories.timeOfDay(factories);
    var fn = WidgetFactories.TimeOfDaySt.fromDateTime(st);
    return WidgetFactories.TimeOfDaySt.fromDateTime.invoke(fn, arena, time.build().getId());
  }
  MemorySegment timeOfDayNow() {
    var st = WidgetFactories.timeOfDay(factories);
    var fn = WidgetFactories.TimeOfDaySt.now(st);
    return WidgetFactories.TimeOfDaySt.now.invoke(fn, arena);
  }

  int fontWeightLerp(FontWeight a, FontWeight b, double t) {
    var st = WidgetFactories.fontWeight(factories);
    var fn = WidgetFactories.FontWeightSt.lerp(st);
    return WidgetFactories.FontWeightSt.lerp.invoke(fn, a != null ? a.build().getId() : null,
      b != null ? b.build().getId() : null,
      t);
  }
  int fontWeightW100() {
    var st = WidgetFactories.fontWeight(factories);
    return WidgetFactories.FontWeightSt.w100(st);
  }
  int fontWeightW200() {
    var st = WidgetFactories.fontWeight(factories);
    return WidgetFactories.FontWeightSt.w200(st);
  }
  int fontWeightW300() {
    var st = WidgetFactories.fontWeight(factories);
    return WidgetFactories.FontWeightSt.w300(st);
  }
  int fontWeightW400() {
    var st = WidgetFactories.fontWeight(factories);
    return WidgetFactories.FontWeightSt.w400(st);
  }
  int fontWeightW500() {
    var st = WidgetFactories.fontWeight(factories);
    return WidgetFactories.FontWeightSt.w500(st);
  }
  int fontWeightW600() {
    var st = WidgetFactories.fontWeight(factories);
    return WidgetFactories.FontWeightSt.w600(st);
  }
  int fontWeightW700() {
    var st = WidgetFactories.fontWeight(factories);
    return WidgetFactories.FontWeightSt.w700(st);
  }
  int fontWeightW800() {
    var st = WidgetFactories.fontWeight(factories);
    return WidgetFactories.FontWeightSt.w800(st);
  }
  int fontWeightW900() {
    var st = WidgetFactories.fontWeight(factories);
    return WidgetFactories.FontWeightSt.w900(st);
  }

  int shadowShadow(Optional<Color> color, Optional<Offset> offset, OptionalDouble blurRadius) {
    var st = WidgetFactories.shadow(factories);
    var fn = WidgetFactories.ShadowSt.shadow(st);
    return WidgetFactories.ShadowSt.shadow.invoke(fn, ptrObj(color),
      ptrObj(offset),
      ptr(blurRadius));
  }
  double shadowConvertRadiusToSigma(double radius) {
    var st = WidgetFactories.shadow(factories);
    var fn = WidgetFactories.ShadowSt.convertRadiusToSigma(st);
    return WidgetFactories.ShadowSt.convertRadiusToSigma.invoke(fn, radius);
  }
  int shadowLerp(Shadow a, Shadow b, double t) {
    var st = WidgetFactories.shadow(factories);
    var fn = WidgetFactories.ShadowSt.lerp(st);
    return WidgetFactories.ShadowSt.lerp.invoke(fn, a != null ? a.build().getId() : null,
      b != null ? b.build().getId() : null,
      t);
  }

  int textDecorationCombine(List<TextDecoration> decorations) {
    var st = WidgetFactories.textDecoration(factories);
    var fn = WidgetFactories.TextDecorationSt.combine(st);
    return WidgetFactories.TextDecorationSt.combine.invoke(fn, ptrList(decorations));
  }
  int textDecorationNone() {
    var st = WidgetFactories.textDecoration(factories);
    return WidgetFactories.TextDecorationSt.none(st);
  }
  int textDecorationUnderline() {
    var st = WidgetFactories.textDecoration(factories);
    return WidgetFactories.TextDecorationSt.underline(st);
  }
  int textDecorationOverline() {
    var st = WidgetFactories.textDecoration(factories);
    return WidgetFactories.TextDecorationSt.overline(st);
  }
  int textDecorationLineThrough() {
    var st = WidgetFactories.textDecoration(factories);
    return WidgetFactories.TextDecorationSt.lineThrough(st);
  }

  MemorySegment iconDataIconData(int codePoint, Optional<String> fontFamily, Optional<String> fontPackage, Optional<Boolean> matchTextDirection, Optional<List<String>> fontFamilyFallback) {
    var st = WidgetFactories.iconData(factories);
    var fn = WidgetFactories.IconDataSt.iconData(st);
    return WidgetFactories.IconDataSt.iconData.invoke(fn, arena, codePoint,
      ptrStr(fontFamily),
      ptrStr(fontPackage),
      ptrBool(matchTextDirection),
      ptrStrList(fontFamilyFallback));
  }

  MemorySegment textText(String data, Optional<TextStyle> style, Optional<TextAlign> textAlign, Optional<TextDirection> textDirection, Optional<Boolean> softWrap, Optional<TextOverflow> overflow, OptionalDouble textScaleFactor, OptionalInt maxLines, Optional<String> semanticsLabel, Optional<String> semanticsIdentifier, Optional<TextWidthBasis> textWidthBasis, Optional<Color> selectionColor) {
    var st = WidgetFactories.text(factories);
    var fn = WidgetFactories.TextSt.text(st);
    return WidgetFactories.TextSt.text.invoke(fn, arena, arena.allocateFrom(data),
      ptrObj(style),
      ptrEnum(textAlign),
      ptrEnum(textDirection),
      ptrBool(softWrap),
      ptrEnum(overflow),
      ptr(textScaleFactor),
      ptr(maxLines),
      ptrStr(semanticsLabel),
      ptrStr(semanticsIdentifier),
      ptrEnum(textWidthBasis),
      ptrObj(selectionColor));
  }
  MemorySegment textRich(InlineSpan textSpan, Optional<TextStyle> style, Optional<TextAlign> textAlign, Optional<TextDirection> textDirection, Optional<Boolean> softWrap, Optional<TextOverflow> overflow, OptionalDouble textScaleFactor, OptionalInt maxLines, Optional<String> semanticsLabel, Optional<String> semanticsIdentifier, Optional<TextWidthBasis> textWidthBasis, Optional<Color> selectionColor) {
    var st = WidgetFactories.text(factories);
    var fn = WidgetFactories.TextSt.rich(st);
    return WidgetFactories.TextSt.rich.invoke(fn, arena, textSpan.build().getId(),
      ptrObj(style),
      ptrEnum(textAlign),
      ptrEnum(textDirection),
      ptrBool(softWrap),
      ptrEnum(overflow),
      ptr(textScaleFactor),
      ptr(maxLines),
      ptrStr(semanticsLabel),
      ptrStr(semanticsIdentifier),
      ptrEnum(textWidthBasis),
      ptrObj(selectionColor));
  }

  MemorySegment textSpanTextSpan(Optional<String> text, Optional<List<InlineSpan>> children, Optional<TextStyle> style, Optional<Consumer<PointerEnterEvent>> onEnter, Optional<Consumer<PointerExitEvent>> onExit, Optional<String> semanticsLabel, Optional<String> semanticsIdentifier, Optional<Boolean> spellOut) {
    var st = WidgetFactories.textSpan(factories);
    var fn = WidgetFactories.TextSpanSt.textSpan(st);
    return WidgetFactories.TextSpanSt.textSpan.invoke(fn, arena, ptrStr(text),
      ptrList(children),
      ptrObj(style),
      onEnter.isPresent() ? ptrHolder(ptrPointerEnterEventListenerFn(onEnter.get())) : MemorySegment.NULL,
      onExit.isPresent() ? ptrHolder(ptrPointerExitEventListenerFn(onExit.get())) : MemorySegment.NULL,
      ptrStr(semanticsLabel),
      ptrStr(semanticsIdentifier),
      ptrBool(spellOut));
  }

  MemorySegment pointerEnterEventPointerEnterEvent(OptionalInt viewId, Optional<Duration> timeStamp, OptionalInt pointer, Optional<PointerDeviceKind> kind, OptionalInt device, Optional<Offset> position, Optional<Offset> delta, OptionalInt buttons, Optional<Boolean> obscured, OptionalDouble pressureMin, OptionalDouble pressureMax, OptionalDouble distance, OptionalDouble distanceMax, OptionalDouble size, OptionalDouble radiusMajor, OptionalDouble radiusMinor, OptionalDouble radiusMin, OptionalDouble radiusMax, OptionalDouble orientation, OptionalDouble tilt, Optional<Boolean> down, Optional<Boolean> synthesized, OptionalInt embedderId) {
    var st = WidgetFactories.pointerEnterEvent(factories);
    var fn = WidgetFactories.PointerEnterEventSt.pointerEnterEvent(st);
    return WidgetFactories.PointerEnterEventSt.pointerEnterEvent.invoke(fn, arena, ptr(viewId),
      ptrObj(timeStamp),
      ptr(pointer),
      ptrEnum(kind),
      ptr(device),
      ptrObj(position),
      ptrObj(delta),
      ptr(buttons),
      ptrBool(obscured),
      ptr(pressureMin),
      ptr(pressureMax),
      ptr(distance),
      ptr(distanceMax),
      ptr(size),
      ptr(radiusMajor),
      ptr(radiusMinor),
      ptr(radiusMin),
      ptr(radiusMax),
      ptr(orientation),
      ptr(tilt),
      ptrBool(down),
      ptrBool(synthesized),
      ptr(embedderId));
  }
  MemorySegment pointerEnterEventFromMouseEvent(PointerEvent event) {
    var st = WidgetFactories.pointerEnterEvent(factories);
    var fn = WidgetFactories.PointerEnterEventSt.fromMouseEvent(st);
    return WidgetFactories.PointerEnterEventSt.fromMouseEvent.invoke(fn, arena, event.build().getId());
  }

  MemorySegment pointerExitEventPointerExitEvent(OptionalInt viewId, Optional<Duration> timeStamp, Optional<PointerDeviceKind> kind, OptionalInt pointer, OptionalInt device, Optional<Offset> position, Optional<Offset> delta, OptionalInt buttons, Optional<Boolean> obscured, OptionalDouble pressureMin, OptionalDouble pressureMax, OptionalDouble distance, OptionalDouble distanceMax, OptionalDouble size, OptionalDouble radiusMajor, OptionalDouble radiusMinor, OptionalDouble radiusMin, OptionalDouble radiusMax, OptionalDouble orientation, OptionalDouble tilt, Optional<Boolean> down, Optional<Boolean> synthesized, OptionalInt embedderId) {
    var st = WidgetFactories.pointerExitEvent(factories);
    var fn = WidgetFactories.PointerExitEventSt.pointerExitEvent(st);
    return WidgetFactories.PointerExitEventSt.pointerExitEvent.invoke(fn, arena, ptr(viewId),
      ptrObj(timeStamp),
      ptrEnum(kind),
      ptr(pointer),
      ptr(device),
      ptrObj(position),
      ptrObj(delta),
      ptr(buttons),
      ptrBool(obscured),
      ptr(pressureMin),
      ptr(pressureMax),
      ptr(distance),
      ptr(distanceMax),
      ptr(size),
      ptr(radiusMajor),
      ptr(radiusMinor),
      ptr(radiusMin),
      ptr(radiusMax),
      ptr(orientation),
      ptr(tilt),
      ptrBool(down),
      ptrBool(synthesized),
      ptr(embedderId));
  }
  MemorySegment pointerExitEventFromMouseEvent(PointerEvent event) {
    var st = WidgetFactories.pointerExitEvent(factories);
    var fn = WidgetFactories.PointerExitEventSt.fromMouseEvent(st);
    return WidgetFactories.PointerExitEventSt.fromMouseEvent.invoke(fn, arena, event.build().getId());
  }

  int durationDuration(OptionalInt days, OptionalInt hours, OptionalInt minutes, OptionalInt seconds, OptionalInt milliseconds, OptionalInt microseconds) {
    var st = WidgetFactories.duration(factories);
    var fn = WidgetFactories.DurationSt.duration(st);
    return WidgetFactories.DurationSt.duration.invoke(fn, ptr(days),
      ptr(hours),
      ptr(minutes),
      ptr(seconds),
      ptr(milliseconds),
      ptr(microseconds));
  }

  int pointerEventPosition(PointerEvent self) {
    var st = WidgetFactories.pointerEvent(factories);
    var fn = WidgetFactories.PointerEventSt.position(st);
    return WidgetFactories.PointerEventSt.position.invoke(fn, self.build().getId());
  }
  int pointerEventDelta(PointerEvent self) {
    var st = WidgetFactories.pointerEvent(factories);
    var fn = WidgetFactories.PointerEventSt.delta(st);
    return WidgetFactories.PointerEventSt.delta.invoke(fn, self.build().getId());
  }
  int pointerEventPointer(PointerEvent self) {
    var st = WidgetFactories.pointerEvent(factories);
    var fn = WidgetFactories.PointerEventSt.pointer(st);
    return WidgetFactories.PointerEventSt.pointer.invoke(fn, self.build().getId());
  }
  int pointerEventButtons(PointerEvent self) {
    var st = WidgetFactories.pointerEvent(factories);
    var fn = WidgetFactories.PointerEventSt.buttons(st);
    return WidgetFactories.PointerEventSt.buttons.invoke(fn, self.build().getId());
  }
  int pointerEventDown(PointerEvent self) {
    var st = WidgetFactories.pointerEvent(factories);
    var fn = WidgetFactories.PointerEventSt.down(st);
    return WidgetFactories.PointerEventSt.down.invoke(fn, self.build().getId());
  }
  double pointerEventPressure(PointerEvent self) {
    var st = WidgetFactories.pointerEvent(factories);
    var fn = WidgetFactories.PointerEventSt.pressure(st);
    return WidgetFactories.PointerEventSt.pressure.invoke(fn, self.build().getId());
  }
  double pointerEventDistance(PointerEvent self) {
    var st = WidgetFactories.pointerEvent(factories);
    var fn = WidgetFactories.PointerEventSt.distance(st);
    return WidgetFactories.PointerEventSt.distance.invoke(fn, self.build().getId());
  }
  double pointerEventSize(PointerEvent self) {
    var st = WidgetFactories.pointerEvent(factories);
    var fn = WidgetFactories.PointerEventSt.size(st);
    return WidgetFactories.PointerEventSt.size.invoke(fn, self.build().getId());
  }

  MemorySegment richTextRichText(InlineSpan text, Optional<TextAlign> textAlign, Optional<TextDirection> textDirection, Optional<Boolean> softWrap, Optional<TextOverflow> overflow, OptionalDouble textScaleFactor, OptionalInt maxLines, Optional<TextWidthBasis> textWidthBasis, Optional<Color> selectionColor) {
    var st = WidgetFactories.richText(factories);
    var fn = WidgetFactories.RichTextSt.richText(st);
    return WidgetFactories.RichTextSt.richText.invoke(fn, arena, text.build().getId(),
      ptrEnum(textAlign),
      ptrEnum(textDirection),
      ptrBool(softWrap),
      ptrEnum(overflow),
      ptr(textScaleFactor),
      ptr(maxLines),
      ptrEnum(textWidthBasis),
      ptrObj(selectionColor));
  }

  MemorySegment centerCenter(OptionalDouble widthFactor, OptionalDouble heightFactor, Optional<Widget> child) {
    var st = WidgetFactories.center(factories);
    var fn = WidgetFactories.CenterSt.center(st);
    return WidgetFactories.CenterSt.center.invoke(fn, arena, ptr(widthFactor),
      ptr(heightFactor),
      ptrObj(child));
  }

  MemorySegment alignAlign(Optional<AlignmentGeometry> alignment, OptionalDouble widthFactor, OptionalDouble heightFactor, Optional<Widget> child) {
    var st = WidgetFactories.align(factories);
    var fn = WidgetFactories.AlignSt.align(st);
    return WidgetFactories.AlignSt.align.invoke(fn, arena, ptrObj(alignment),
      ptr(widthFactor),
      ptr(heightFactor),
      ptrObj(child));
  }

  MemorySegment columnColumn(Optional<MainAxisAlignment> mainAxisAlignment, Optional<MainAxisSize> mainAxisSize, Optional<CrossAxisAlignment> crossAxisAlignment, Optional<TextDirection> textDirection, Optional<VerticalDirection> verticalDirection, Optional<TextBaseline> textBaseline, OptionalDouble spacing, Optional<List<Widget>> children) {
    var st = WidgetFactories.column(factories);
    var fn = WidgetFactories.ColumnSt.column(st);
    return WidgetFactories.ColumnSt.column.invoke(fn, arena, ptrEnum(mainAxisAlignment),
      ptrEnum(mainAxisSize),
      ptrEnum(crossAxisAlignment),
      ptrEnum(textDirection),
      ptrEnum(verticalDirection),
      ptrEnum(textBaseline),
      ptr(spacing),
      ptrList(children));
  }

  MemorySegment flexFlex(Axis direction, Optional<MainAxisAlignment> mainAxisAlignment, Optional<MainAxisSize> mainAxisSize, Optional<CrossAxisAlignment> crossAxisAlignment, Optional<TextDirection> textDirection, Optional<VerticalDirection> verticalDirection, Optional<TextBaseline> textBaseline, Optional<Clip> clipBehavior, OptionalDouble spacing, Optional<List<Widget>> children) {
    var st = WidgetFactories.flex(factories);
    var fn = WidgetFactories.FlexSt.flex(st);
    return WidgetFactories.FlexSt.flex.invoke(fn, arena, direction.ordinal(),
      ptrEnum(mainAxisAlignment),
      ptrEnum(mainAxisSize),
      ptrEnum(crossAxisAlignment),
      ptrEnum(textDirection),
      ptrEnum(verticalDirection),
      ptrEnum(textBaseline),
      ptrEnum(clipBehavior),
      ptr(spacing),
      ptrList(children));
  }

  MemorySegment rowRow(Optional<MainAxisAlignment> mainAxisAlignment, Optional<MainAxisSize> mainAxisSize, Optional<CrossAxisAlignment> crossAxisAlignment, Optional<TextDirection> textDirection, Optional<VerticalDirection> verticalDirection, Optional<TextBaseline> textBaseline, OptionalDouble spacing, Optional<List<Widget>> children) {
    var st = WidgetFactories.row(factories);
    var fn = WidgetFactories.RowSt.row(st);
    return WidgetFactories.RowSt.row.invoke(fn, arena, ptrEnum(mainAxisAlignment),
      ptrEnum(mainAxisSize),
      ptrEnum(crossAxisAlignment),
      ptrEnum(textDirection),
      ptrEnum(verticalDirection),
      ptrEnum(textBaseline),
      ptr(spacing),
      ptrList(children));
  }

  MemorySegment transformRotate(double angle, Optional<Offset> origin, Optional<AlignmentGeometry> alignment, Optional<Boolean> transformHitTests, Optional<FilterQuality> filterQuality, Optional<Widget> child) {
    var st = WidgetFactories.transform(factories);
    var fn = WidgetFactories.TransformSt.rotate(st);
    return WidgetFactories.TransformSt.rotate.invoke(fn, arena, angle,
      ptrObj(origin),
      ptrObj(alignment),
      ptrBool(transformHitTests),
      ptrEnum(filterQuality),
      ptrObj(child));
  }
  MemorySegment transformTranslate(Offset offset, Optional<Boolean> transformHitTests, Optional<FilterQuality> filterQuality, Optional<Widget> child) {
    var st = WidgetFactories.transform(factories);
    var fn = WidgetFactories.TransformSt.translate(st);
    return WidgetFactories.TransformSt.translate.invoke(fn, arena, offset.build().getId(),
      ptrBool(transformHitTests),
      ptrEnum(filterQuality),
      ptrObj(child));
  }
  MemorySegment transformScale(OptionalDouble scale, OptionalDouble scaleX, OptionalDouble scaleY, Optional<Offset> origin, Optional<AlignmentGeometry> alignment, Optional<Boolean> transformHitTests, Optional<FilterQuality> filterQuality, Optional<Widget> child) {
    var st = WidgetFactories.transform(factories);
    var fn = WidgetFactories.TransformSt.scale(st);
    return WidgetFactories.TransformSt.scale.invoke(fn, arena, ptr(scale),
      ptr(scaleX),
      ptr(scaleY),
      ptrObj(origin),
      ptrObj(alignment),
      ptrBool(transformHitTests),
      ptrEnum(filterQuality),
      ptrObj(child));
  }
  MemorySegment transformFlip(Optional<Boolean> flipX, Optional<Boolean> flipY, Optional<Offset> origin, Optional<Boolean> transformHitTests, Optional<FilterQuality> filterQuality, Optional<Widget> child) {
    var st = WidgetFactories.transform(factories);
    var fn = WidgetFactories.TransformSt.flip(st);
    return WidgetFactories.TransformSt.flip.invoke(fn, arena, ptrBool(flipX),
      ptrBool(flipY),
      ptrObj(origin),
      ptrBool(transformHitTests),
      ptrEnum(filterQuality),
      ptrObj(child));
  }

  MemorySegment opacityOpacity(double opacity, Optional<Boolean> alwaysIncludeSemantics, Optional<Widget> child) {
    var st = WidgetFactories.opacity(factories);
    var fn = WidgetFactories.OpacitySt.opacity(st);
    return WidgetFactories.OpacitySt.opacity.invoke(fn, arena, opacity,
      ptrBool(alwaysIncludeSemantics),
      ptrObj(child));
  }

  MemorySegment stackStack(Optional<AlignmentGeometry> alignment, Optional<TextDirection> textDirection, Optional<StackFit> fit, Optional<Clip> clipBehavior, Optional<List<Widget>> children) {
    var st = WidgetFactories.stack(factories);
    var fn = WidgetFactories.StackSt.stack(st);
    return WidgetFactories.StackSt.stack.invoke(fn, arena, ptrObj(alignment),
      ptrEnum(textDirection),
      ptrEnum(fit),
      ptrEnum(clipBehavior),
      ptrList(children));
  }

  MemorySegment boxConstraintsBoxConstraints(OptionalDouble minWidth, OptionalDouble maxWidth, OptionalDouble minHeight, OptionalDouble maxHeight) {
    var st = WidgetFactories.boxConstraints(factories);
    var fn = WidgetFactories.BoxConstraintsSt.boxConstraints(st);
    return WidgetFactories.BoxConstraintsSt.boxConstraints.invoke(fn, arena, ptr(minWidth),
      ptr(maxWidth),
      ptr(minHeight),
      ptr(maxHeight));
  }
  MemorySegment boxConstraintsTightFor(OptionalDouble width, OptionalDouble height) {
    var st = WidgetFactories.boxConstraints(factories);
    var fn = WidgetFactories.BoxConstraintsSt.tightFor(st);
    return WidgetFactories.BoxConstraintsSt.tightFor.invoke(fn, arena, ptr(width),
      ptr(height));
  }
  MemorySegment boxConstraintsTightForFinite(OptionalDouble width, OptionalDouble height) {
    var st = WidgetFactories.boxConstraints(factories);
    var fn = WidgetFactories.BoxConstraintsSt.tightForFinite(st);
    return WidgetFactories.BoxConstraintsSt.tightForFinite.invoke(fn, arena, ptr(width),
      ptr(height));
  }
  MemorySegment boxConstraintsExpand(OptionalDouble width, OptionalDouble height) {
    var st = WidgetFactories.boxConstraints(factories);
    var fn = WidgetFactories.BoxConstraintsSt.expand(st);
    return WidgetFactories.BoxConstraintsSt.expand.invoke(fn, arena, ptr(width),
      ptr(height));
  }
  MemorySegment boxConstraintsLerp(BoxConstraints a, BoxConstraints b, double t) {
    var st = WidgetFactories.boxConstraints(factories);
    var fn = WidgetFactories.BoxConstraintsSt.lerp(st);
    return WidgetFactories.BoxConstraintsSt.lerp.invoke(fn, arena, a != null ? a.build().getId() : null,
      b != null ? b.build().getId() : null,
      t);
  }

  MemorySegment containerContainer(Optional<AlignmentGeometry> alignment, Optional<EdgeInsetsGeometry> padding, Optional<Color> color, Optional<Decoration> decoration, Optional<Decoration> foregroundDecoration, OptionalDouble width, OptionalDouble height, Optional<BoxConstraints> constraints, Optional<EdgeInsetsGeometry> margin, Optional<AlignmentGeometry> transformAlignment, Optional<Widget> child, Optional<Clip> clipBehavior) {
    var st = WidgetFactories.container(factories);
    var fn = WidgetFactories.ContainerSt.container(st);
    return WidgetFactories.ContainerSt.container.invoke(fn, arena, ptrObj(alignment),
      ptrObj(padding),
      ptrObj(color),
      ptrObj(decoration),
      ptrObj(foregroundDecoration),
      ptr(width),
      ptr(height),
      ptrObj(constraints),
      ptrObj(margin),
      ptrObj(transformAlignment),
      ptrObj(child),
      ptrEnum(clipBehavior));
  }

  int edgeInsetsGeometryInfinity() {
    var st = WidgetFactories.edgeInsetsGeometry(factories);
    return WidgetFactories.EdgeInsetsGeometrySt.infinity(st);
  }

  int stackParentDataStackParentData() {
    var st = WidgetFactories.stackParentData(factories);
    var fn = WidgetFactories.StackParentDataSt.stackParentData(st);
    return WidgetFactories.StackParentDataSt.stackParentData.invoke(fn);
  }

  int boxParentDataBoxParentData() {
    var st = WidgetFactories.boxParentData(factories);
    var fn = WidgetFactories.BoxParentDataSt.boxParentData(st);
    return WidgetFactories.BoxParentDataSt.boxParentData.invoke(fn);
  }

  int parentDataParentData() {
    var st = WidgetFactories.parentData(factories);
    var fn = WidgetFactories.ParentDataSt.parentData(st);
    return WidgetFactories.ParentDataSt.parentData.invoke(fn);
  }

  int flexParentDataFlexParentData() {
    var st = WidgetFactories.flexParentData(factories);
    var fn = WidgetFactories.FlexParentDataSt.flexParentData(st);
    return WidgetFactories.FlexParentDataSt.flexParentData.invoke(fn);
  }

  MemorySegment positionedPositioned(OptionalDouble left, OptionalDouble top, OptionalDouble right, OptionalDouble bottom, OptionalDouble width, OptionalDouble height, Widget child) {
    var st = WidgetFactories.positioned(factories);
    var fn = WidgetFactories.PositionedSt.positioned(st);
    return WidgetFactories.PositionedSt.positioned.invoke(fn, arena, ptr(left),
      ptr(top),
      ptr(right),
      ptr(bottom),
      ptr(width),
      ptr(height),
      child.build().getId());
  }
  MemorySegment positionedFill(OptionalDouble left, OptionalDouble top, OptionalDouble right, OptionalDouble bottom, Widget child) {
    var st = WidgetFactories.positioned(factories);
    var fn = WidgetFactories.PositionedSt.fill(st);
    return WidgetFactories.PositionedSt.fill.invoke(fn, arena, ptr(left),
      ptr(top),
      ptr(right),
      ptr(bottom),
      child.build().getId());
  }
  MemorySegment positionedDirectional(TextDirection textDirection, OptionalDouble start, OptionalDouble top, OptionalDouble end, OptionalDouble bottom, OptionalDouble width, OptionalDouble height, Widget child) {
    var st = WidgetFactories.positioned(factories);
    var fn = WidgetFactories.PositionedSt.directional(st);
    return WidgetFactories.PositionedSt.directional.invoke(fn, arena, textDirection.ordinal(),
      ptr(start),
      ptr(top),
      ptr(end),
      ptr(bottom),
      ptr(width),
      ptr(height),
      child.build().getId());
  }

  MemorySegment boxDecorationBoxDecoration(Optional<Color> color, Optional<BoxBorder> border, Optional<BorderRadiusGeometry> borderRadius, Optional<List<BoxShadow>> boxShadow, Optional<BlendMode> backgroundBlendMode, Optional<BoxShape> shape) {
    var st = WidgetFactories.boxDecoration(factories);
    var fn = WidgetFactories.BoxDecorationSt.boxDecoration(st);
    return WidgetFactories.BoxDecorationSt.boxDecoration.invoke(fn, arena, ptrObj(color),
      ptrObj(border),
      ptrObj(borderRadius),
      ptrList(boxShadow),
      ptrEnum(backgroundBlendMode),
      ptrEnum(shape));
  }
  MemorySegment boxDecorationLerp(BoxDecoration a, BoxDecoration b, double t) {
    var st = WidgetFactories.boxDecoration(factories);
    var fn = WidgetFactories.BoxDecorationSt.lerp(st);
    return WidgetFactories.BoxDecorationSt.lerp.invoke(fn, arena, a != null ? a.build().getId() : null,
      b != null ? b.build().getId() : null,
      t);
  }

  MemorySegment boxShadowBoxShadow(Optional<Color> color, Optional<Offset> offset, OptionalDouble blurRadius, OptionalDouble spreadRadius, Optional<BlurStyle> blurStyle) {
    var st = WidgetFactories.boxShadow(factories);
    var fn = WidgetFactories.BoxShadowSt.boxShadow(st);
    return WidgetFactories.BoxShadowSt.boxShadow.invoke(fn, arena, ptrObj(color),
      ptrObj(offset),
      ptr(blurRadius),
      ptr(spreadRadius),
      ptrEnum(blurStyle));
  }
  MemorySegment boxShadowLerp(BoxShadow a, BoxShadow b, double t) {
    var st = WidgetFactories.boxShadow(factories);
    var fn = WidgetFactories.BoxShadowSt.lerp(st);
    return WidgetFactories.BoxShadowSt.lerp.invoke(fn, arena, a != null ? a.build().getId() : null,
      b != null ? b.build().getId() : null,
      t);
  }

  int radiusCircular(double radius) {
    var st = WidgetFactories.radius(factories);
    var fn = WidgetFactories.RadiusSt.circular(st);
    return WidgetFactories.RadiusSt.circular.invoke(fn, radius);
  }
  int radiusElliptical(double x, double y) {
    var st = WidgetFactories.radius(factories);
    var fn = WidgetFactories.RadiusSt.elliptical(st);
    return WidgetFactories.RadiusSt.elliptical.invoke(fn, x,
      y);
  }
  int radiusLerp(Radius a, Radius b, double t) {
    var st = WidgetFactories.radius(factories);
    var fn = WidgetFactories.RadiusSt.lerp(st);
    return WidgetFactories.RadiusSt.lerp.invoke(fn, a != null ? a.build().getId() : null,
      b != null ? b.build().getId() : null,
      t);
  }

  MemorySegment borderRadiusAll(Radius radius) {
    var st = WidgetFactories.borderRadius(factories);
    var fn = WidgetFactories.BorderRadiusSt.all(st);
    return WidgetFactories.BorderRadiusSt.all.invoke(fn, arena, radius.build().getId());
  }
  MemorySegment borderRadiusCircular(double radius) {
    var st = WidgetFactories.borderRadius(factories);
    var fn = WidgetFactories.BorderRadiusSt.circular(st);
    return WidgetFactories.BorderRadiusSt.circular.invoke(fn, arena, radius);
  }
  MemorySegment borderRadiusVertical(Optional<Radius> top, Optional<Radius> bottom) {
    var st = WidgetFactories.borderRadius(factories);
    var fn = WidgetFactories.BorderRadiusSt.vertical(st);
    return WidgetFactories.BorderRadiusSt.vertical.invoke(fn, arena, ptrObj(top),
      ptrObj(bottom));
  }
  MemorySegment borderRadiusHorizontal(Optional<Radius> left, Optional<Radius> right) {
    var st = WidgetFactories.borderRadius(factories);
    var fn = WidgetFactories.BorderRadiusSt.horizontal(st);
    return WidgetFactories.BorderRadiusSt.horizontal.invoke(fn, arena, ptrObj(left),
      ptrObj(right));
  }
  MemorySegment borderRadiusOnly(Optional<Radius> topLeft, Optional<Radius> topRight, Optional<Radius> bottomLeft, Optional<Radius> bottomRight) {
    var st = WidgetFactories.borderRadius(factories);
    var fn = WidgetFactories.BorderRadiusSt.only(st);
    return WidgetFactories.BorderRadiusSt.only.invoke(fn, arena, ptrObj(topLeft),
      ptrObj(topRight),
      ptrObj(bottomLeft),
      ptrObj(bottomRight));
  }
  MemorySegment borderRadiusLerp(BorderRadius a, BorderRadius b, double t) {
    var st = WidgetFactories.borderRadius(factories);
    var fn = WidgetFactories.BorderRadiusSt.lerp(st);
    return WidgetFactories.BorderRadiusSt.lerp.invoke(fn, arena, a != null ? a.build().getId() : null,
      b != null ? b.build().getId() : null,
      t);
  }

  MemorySegment paddingPadding(EdgeInsetsGeometry padding, Optional<Widget> child) {
    var st = WidgetFactories.padding(factories);
    var fn = WidgetFactories.PaddingSt.padding(st);
    return WidgetFactories.PaddingSt.padding.invoke(fn, arena, padding.build().getId(),
      ptrObj(child));
  }

  MemorySegment edgeInsetsFromLTRB(double left, double top, double right, double bottom) {
    var st = WidgetFactories.edgeInsets(factories);
    var fn = WidgetFactories.EdgeInsetsSt.fromLTRB(st);
    return WidgetFactories.EdgeInsetsSt.fromLTRB.invoke(fn, arena, left,
      top,
      right,
      bottom);
  }
  MemorySegment edgeInsetsAll(double value) {
    var st = WidgetFactories.edgeInsets(factories);
    var fn = WidgetFactories.EdgeInsetsSt.all(st);
    return WidgetFactories.EdgeInsetsSt.all.invoke(fn, arena, value);
  }
  MemorySegment edgeInsetsOnly(OptionalDouble left, OptionalDouble top, OptionalDouble right, OptionalDouble bottom) {
    var st = WidgetFactories.edgeInsets(factories);
    var fn = WidgetFactories.EdgeInsetsSt.only(st);
    return WidgetFactories.EdgeInsetsSt.only.invoke(fn, arena, ptr(left),
      ptr(top),
      ptr(right),
      ptr(bottom));
  }
  MemorySegment edgeInsetsSymmetric(OptionalDouble vertical, OptionalDouble horizontal) {
    var st = WidgetFactories.edgeInsets(factories);
    var fn = WidgetFactories.EdgeInsetsSt.symmetric(st);
    return WidgetFactories.EdgeInsetsSt.symmetric.invoke(fn, arena, ptr(vertical),
      ptr(horizontal));
  }
  MemorySegment edgeInsetsLerp(EdgeInsets a, EdgeInsets b, double t) {
    var st = WidgetFactories.edgeInsets(factories);
    var fn = WidgetFactories.EdgeInsetsSt.lerp(st);
    return WidgetFactories.EdgeInsetsSt.lerp.invoke(fn, arena, a != null ? a.build().getId() : null,
      b != null ? b.build().getId() : null,
      t);
  }

  MemorySegment borderSideBorderSide(Optional<Color> color, OptionalDouble width, Optional<BorderStyle> style, OptionalDouble strokeAlign) {
    var st = WidgetFactories.borderSide(factories);
    var fn = WidgetFactories.BorderSideSt.borderSide(st);
    return WidgetFactories.BorderSideSt.borderSide.invoke(fn, arena, ptrObj(color),
      ptr(width),
      ptrEnum(style),
      ptr(strokeAlign));
  }
  MemorySegment borderSideMerge(BorderSide a, BorderSide b) {
    var st = WidgetFactories.borderSide(factories);
    var fn = WidgetFactories.BorderSideSt.merge(st);
    return WidgetFactories.BorderSideSt.merge.invoke(fn, arena, a.build().getId(),
      b.build().getId());
  }
  int borderSideCanMerge(BorderSide a, BorderSide b) {
    var st = WidgetFactories.borderSide(factories);
    var fn = WidgetFactories.BorderSideSt.canMerge(st);
    return WidgetFactories.BorderSideSt.canMerge.invoke(fn, a.build().getId(),
      b.build().getId());
  }
  MemorySegment borderSideLerp(BorderSide a, BorderSide b, double t) {
    var st = WidgetFactories.borderSide(factories);
    var fn = WidgetFactories.BorderSideSt.lerp(st);
    return WidgetFactories.BorderSideSt.lerp.invoke(fn, arena, a.build().getId(),
      b.build().getId(),
      t);
  }

  MemorySegment borderBorder(Optional<BorderSide> top, Optional<BorderSide> right, Optional<BorderSide> bottom, Optional<BorderSide> left) {
    var st = WidgetFactories.border(factories);
    var fn = WidgetFactories.BorderSt.border(st);
    return WidgetFactories.BorderSt.border.invoke(fn, arena, ptrObj(top),
      ptrObj(right),
      ptrObj(bottom),
      ptrObj(left));
  }
  MemorySegment borderFromBorderSide(BorderSide side) {
    var st = WidgetFactories.border(factories);
    var fn = WidgetFactories.BorderSt.fromBorderSide(st);
    return WidgetFactories.BorderSt.fromBorderSide.invoke(fn, arena, side.build().getId());
  }
  MemorySegment borderSymmetric(Optional<BorderSide> vertical, Optional<BorderSide> horizontal) {
    var st = WidgetFactories.border(factories);
    var fn = WidgetFactories.BorderSt.symmetric(st);
    return WidgetFactories.BorderSt.symmetric.invoke(fn, arena, ptrObj(vertical),
      ptrObj(horizontal));
  }
  MemorySegment borderAll(Optional<Color> color, OptionalDouble width, Optional<BorderStyle> style, OptionalDouble strokeAlign) {
    var st = WidgetFactories.border(factories);
    var fn = WidgetFactories.BorderSt.all(st);
    return WidgetFactories.BorderSt.all.invoke(fn, arena, ptrObj(color),
      ptr(width),
      ptrEnum(style),
      ptr(strokeAlign));
  }
  MemorySegment borderMerge(Border a, Border b) {
    var st = WidgetFactories.border(factories);
    var fn = WidgetFactories.BorderSt.merge(st);
    return WidgetFactories.BorderSt.merge.invoke(fn, arena, a.build().getId(),
      b.build().getId());
  }
  MemorySegment borderLerp(Border a, Border b, double t) {
    var st = WidgetFactories.border(factories);
    var fn = WidgetFactories.BorderSt.lerp(st);
    return WidgetFactories.BorderSt.lerp.invoke(fn, arena, a != null ? a.build().getId() : null,
      b != null ? b.build().getId() : null,
      t);
  }

  MemorySegment roundedRectangleBorderRoundedRectangleBorder(Optional<BorderSide> side, Optional<BorderRadiusGeometry> borderRadius) {
    var st = WidgetFactories.roundedRectangleBorder(factories);
    var fn = WidgetFactories.RoundedRectangleBorderSt.roundedRectangleBorder(st);
    return WidgetFactories.RoundedRectangleBorderSt.roundedRectangleBorder.invoke(fn, arena, ptrObj(side),
      ptrObj(borderRadius));
  }

  int animationControllerAnimationController(OptionalDouble value, Optional<Duration> duration, Optional<Duration> reverseDuration, Optional<String> debugLabel, OptionalDouble lowerBound, OptionalDouble upperBound, Optional<AnimationBehavior> animationBehavior, TickerProvider vsync) {
    var st = WidgetFactories.animationController(factories);
    var fn = WidgetFactories.AnimationControllerSt.animationController(st);
    return WidgetFactories.AnimationControllerSt.animationController.invoke(fn, ptr(value),
      ptrObj(duration),
      ptrObj(reverseDuration),
      ptrStr(debugLabel),
      ptr(lowerBound),
      ptr(upperBound),
      ptrEnum(animationBehavior),
      vsync.build().getId());
  }
  int animationControllerUnbounded(OptionalDouble value, Optional<Duration> duration, Optional<Duration> reverseDuration, Optional<String> debugLabel, TickerProvider vsync, Optional<AnimationBehavior> animationBehavior) {
    var st = WidgetFactories.animationController(factories);
    var fn = WidgetFactories.AnimationControllerSt.unbounded(st);
    return WidgetFactories.AnimationControllerSt.unbounded.invoke(fn, ptr(value),
      ptrObj(duration),
      ptrObj(reverseDuration),
      ptrStr(debugLabel),
      vsync.build().getId(),
      ptrEnum(animationBehavior));
  }
  void animationControllerForward(AnimationController self) {
    var st = WidgetFactories.animationController(factories);
    var fn = WidgetFactories.AnimationControllerSt.forward(st);
    WidgetFactories.AnimationControllerSt.forward.invoke(fn, self.build().getId());
  }
  void animationControllerReverse(AnimationController self) {
    var st = WidgetFactories.animationController(factories);
    var fn = WidgetFactories.AnimationControllerSt.reverse(st);
    WidgetFactories.AnimationControllerSt.reverse.invoke(fn, self.build().getId());
  }
  void animationControllerStop(AnimationController self) {
    var st = WidgetFactories.animationController(factories);
    var fn = WidgetFactories.AnimationControllerSt.stop(st);
    WidgetFactories.AnimationControllerSt.stop.invoke(fn, self.build().getId());
  }
  void animationControllerRepeat(AnimationController self) {
    var st = WidgetFactories.animationController(factories);
    var fn = WidgetFactories.AnimationControllerSt.repeat(st);
    WidgetFactories.AnimationControllerSt.repeat.invoke(fn, self.build().getId());
  }
  void animationControllerReset(AnimationController self) {
    var st = WidgetFactories.animationController(factories);
    var fn = WidgetFactories.AnimationControllerSt.reset(st);
    WidgetFactories.AnimationControllerSt.reset.invoke(fn, self.build().getId());
  }
  void animationControllerSetDuration(AnimationController self, Duration d) {
    var st = WidgetFactories.animationController(factories);
    var fn = WidgetFactories.AnimationControllerSt.setDuration(st);
    WidgetFactories.AnimationControllerSt.setDuration.invoke(fn, self.build().getId(),
      d.build().getId());
  }
  void animationControllerSetReverseDuration(AnimationController self, Duration d) {
    var st = WidgetFactories.animationController(factories);
    var fn = WidgetFactories.AnimationControllerSt.setReverseDuration(st);
    WidgetFactories.AnimationControllerSt.setReverseDuration.invoke(fn, self.build().getId(),
      d.build().getId());
  }

  MemorySegment animatedBuilderAnimatedBuilder(Listenable animation, BiFunction<BuildContext, Widget, Widget> builder, Optional<Widget> child) {
    var st = WidgetFactories.animatedBuilder(factories);
    var fn = WidgetFactories.AnimatedBuilderSt.animatedBuilder(st);
    return WidgetFactories.AnimatedBuilderSt.animatedBuilder.invoke(fn, arena, animation.build().getId(),
      ptrTransitionBuilderFn(builder),
      ptrObj(child));
  }

  MemorySegment listenableBuilderListenableBuilder(Listenable listenable, BiFunction<BuildContext, Widget, Widget> builder, Optional<Widget> child) {
    var st = WidgetFactories.listenableBuilder(factories);
    var fn = WidgetFactories.ListenableBuilderSt.listenableBuilder(st);
    return WidgetFactories.ListenableBuilderSt.listenableBuilder.invoke(fn, arena, listenable.build().getId(),
      ptrTransitionBuilderFn(builder),
      ptrObj(child));
  }

  MemorySegment velocityVelocity(Offset pixelsPerSecond) {
    var st = WidgetFactories.velocity(factories);
    var fn = WidgetFactories.VelocitySt.velocity(st);
    return WidgetFactories.VelocitySt.velocity.invoke(fn, arena, pixelsPerSecond.build().getId());
  }

  int tapDownDetailsTapDownDetails(Optional<Offset> globalPosition, Optional<Offset> localPosition, Optional<PointerDeviceKind> kind) {
    var st = WidgetFactories.tapDownDetails(factories);
    var fn = WidgetFactories.TapDownDetailsSt.tapDownDetails(st);
    return WidgetFactories.TapDownDetailsSt.tapDownDetails.invoke(fn, ptrObj(globalPosition),
      ptrObj(localPosition),
      ptrEnum(kind));
  }
  int tapDownDetailsGlobalPosition(TapDownDetails self) {
    var st = WidgetFactories.tapDownDetails(factories);
    var fn = WidgetFactories.TapDownDetailsSt.globalPosition(st);
    return WidgetFactories.TapDownDetailsSt.globalPosition.invoke(fn, self.build().getId());
  }
  int tapDownDetailsLocalPosition(TapDownDetails self) {
    var st = WidgetFactories.tapDownDetails(factories);
    var fn = WidgetFactories.TapDownDetailsSt.localPosition(st);
    return WidgetFactories.TapDownDetailsSt.localPosition.invoke(fn, self.build().getId());
  }

  int tapUpDetailsTapUpDetails(Optional<Offset> globalPosition, Optional<Offset> localPosition, PointerDeviceKind kind) {
    var st = WidgetFactories.tapUpDetails(factories);
    var fn = WidgetFactories.TapUpDetailsSt.tapUpDetails(st);
    return WidgetFactories.TapUpDetailsSt.tapUpDetails.invoke(fn, ptrObj(globalPosition),
      ptrObj(localPosition),
      kind.ordinal());
  }
  int tapUpDetailsGlobalPosition(TapUpDetails self) {
    var st = WidgetFactories.tapUpDetails(factories);
    var fn = WidgetFactories.TapUpDetailsSt.globalPosition(st);
    return WidgetFactories.TapUpDetailsSt.globalPosition.invoke(fn, self.build().getId());
  }
  int tapUpDetailsLocalPosition(TapUpDetails self) {
    var st = WidgetFactories.tapUpDetails(factories);
    var fn = WidgetFactories.TapUpDetailsSt.localPosition(st);
    return WidgetFactories.TapUpDetailsSt.localPosition.invoke(fn, self.build().getId());
  }

  int tapMoveDetailsTapMoveDetails(PointerDeviceKind kind, Optional<Offset> globalPosition, Optional<Offset> delta, Optional<Offset> localPosition) {
    var st = WidgetFactories.tapMoveDetails(factories);
    var fn = WidgetFactories.TapMoveDetailsSt.tapMoveDetails(st);
    return WidgetFactories.TapMoveDetailsSt.tapMoveDetails.invoke(fn, kind.ordinal(),
      ptrObj(globalPosition),
      ptrObj(delta),
      ptrObj(localPosition));
  }
  int tapMoveDetailsGlobalPosition(TapMoveDetails self) {
    var st = WidgetFactories.tapMoveDetails(factories);
    var fn = WidgetFactories.TapMoveDetailsSt.globalPosition(st);
    return WidgetFactories.TapMoveDetailsSt.globalPosition.invoke(fn, self.build().getId());
  }
  int tapMoveDetailsLocalPosition(TapMoveDetails self) {
    var st = WidgetFactories.tapMoveDetails(factories);
    var fn = WidgetFactories.TapMoveDetailsSt.localPosition(st);
    return WidgetFactories.TapMoveDetailsSt.localPosition.invoke(fn, self.build().getId());
  }
  int tapMoveDetailsDelta(TapMoveDetails self) {
    var st = WidgetFactories.tapMoveDetails(factories);
    var fn = WidgetFactories.TapMoveDetailsSt.delta(st);
    return WidgetFactories.TapMoveDetailsSt.delta.invoke(fn, self.build().getId());
  }

  int longPressDownDetailsLongPressDownDetails(Optional<Offset> globalPosition, Optional<Offset> localPosition, Optional<PointerDeviceKind> kind) {
    var st = WidgetFactories.longPressDownDetails(factories);
    var fn = WidgetFactories.LongPressDownDetailsSt.longPressDownDetails(st);
    return WidgetFactories.LongPressDownDetailsSt.longPressDownDetails.invoke(fn, ptrObj(globalPosition),
      ptrObj(localPosition),
      ptrEnum(kind));
  }
  int longPressDownDetailsGlobalPosition(LongPressDownDetails self) {
    var st = WidgetFactories.longPressDownDetails(factories);
    var fn = WidgetFactories.LongPressDownDetailsSt.globalPosition(st);
    return WidgetFactories.LongPressDownDetailsSt.globalPosition.invoke(fn, self.build().getId());
  }
  int longPressDownDetailsLocalPosition(LongPressDownDetails self) {
    var st = WidgetFactories.longPressDownDetails(factories);
    var fn = WidgetFactories.LongPressDownDetailsSt.localPosition(st);
    return WidgetFactories.LongPressDownDetailsSt.localPosition.invoke(fn, self.build().getId());
  }

  int longPressStartDetailsLongPressStartDetails(Optional<Offset> globalPosition, Optional<Offset> localPosition) {
    var st = WidgetFactories.longPressStartDetails(factories);
    var fn = WidgetFactories.LongPressStartDetailsSt.longPressStartDetails(st);
    return WidgetFactories.LongPressStartDetailsSt.longPressStartDetails.invoke(fn, ptrObj(globalPosition),
      ptrObj(localPosition));
  }
  int longPressStartDetailsGlobalPosition(LongPressStartDetails self) {
    var st = WidgetFactories.longPressStartDetails(factories);
    var fn = WidgetFactories.LongPressStartDetailsSt.globalPosition(st);
    return WidgetFactories.LongPressStartDetailsSt.globalPosition.invoke(fn, self.build().getId());
  }
  int longPressStartDetailsLocalPosition(LongPressStartDetails self) {
    var st = WidgetFactories.longPressStartDetails(factories);
    var fn = WidgetFactories.LongPressStartDetailsSt.localPosition(st);
    return WidgetFactories.LongPressStartDetailsSt.localPosition.invoke(fn, self.build().getId());
  }

  int longPressMoveUpdateDetailsLongPressMoveUpdateDetails(Optional<Offset> globalPosition, Optional<Offset> localPosition, Optional<Offset> offsetFromOrigin, Optional<Offset> localOffsetFromOrigin) {
    var st = WidgetFactories.longPressMoveUpdateDetails(factories);
    var fn = WidgetFactories.LongPressMoveUpdateDetailsSt.longPressMoveUpdateDetails(st);
    return WidgetFactories.LongPressMoveUpdateDetailsSt.longPressMoveUpdateDetails.invoke(fn, ptrObj(globalPosition),
      ptrObj(localPosition),
      ptrObj(offsetFromOrigin),
      ptrObj(localOffsetFromOrigin));
  }
  int longPressMoveUpdateDetailsGlobalPosition(LongPressMoveUpdateDetails self) {
    var st = WidgetFactories.longPressMoveUpdateDetails(factories);
    var fn = WidgetFactories.LongPressMoveUpdateDetailsSt.globalPosition(st);
    return WidgetFactories.LongPressMoveUpdateDetailsSt.globalPosition.invoke(fn, self.build().getId());
  }
  int longPressMoveUpdateDetailsLocalPosition(LongPressMoveUpdateDetails self) {
    var st = WidgetFactories.longPressMoveUpdateDetails(factories);
    var fn = WidgetFactories.LongPressMoveUpdateDetailsSt.localPosition(st);
    return WidgetFactories.LongPressMoveUpdateDetailsSt.localPosition.invoke(fn, self.build().getId());
  }
  int longPressMoveUpdateDetailsOffsetFromOrigin(LongPressMoveUpdateDetails self) {
    var st = WidgetFactories.longPressMoveUpdateDetails(factories);
    var fn = WidgetFactories.LongPressMoveUpdateDetailsSt.offsetFromOrigin(st);
    return WidgetFactories.LongPressMoveUpdateDetailsSt.offsetFromOrigin.invoke(fn, self.build().getId());
  }
  int longPressMoveUpdateDetailsLocalOffsetFromOrigin(LongPressMoveUpdateDetails self) {
    var st = WidgetFactories.longPressMoveUpdateDetails(factories);
    var fn = WidgetFactories.LongPressMoveUpdateDetailsSt.localOffsetFromOrigin(st);
    return WidgetFactories.LongPressMoveUpdateDetailsSt.localOffsetFromOrigin.invoke(fn, self.build().getId());
  }

  int longPressEndDetailsLongPressEndDetails(Optional<Offset> globalPosition, Optional<Offset> localPosition, Optional<Velocity> velocity) {
    var st = WidgetFactories.longPressEndDetails(factories);
    var fn = WidgetFactories.LongPressEndDetailsSt.longPressEndDetails(st);
    return WidgetFactories.LongPressEndDetailsSt.longPressEndDetails.invoke(fn, ptrObj(globalPosition),
      ptrObj(localPosition),
      ptrObj(velocity));
  }
  int longPressEndDetailsGlobalPosition(LongPressEndDetails self) {
    var st = WidgetFactories.longPressEndDetails(factories);
    var fn = WidgetFactories.LongPressEndDetailsSt.globalPosition(st);
    return WidgetFactories.LongPressEndDetailsSt.globalPosition.invoke(fn, self.build().getId());
  }
  int longPressEndDetailsLocalPosition(LongPressEndDetails self) {
    var st = WidgetFactories.longPressEndDetails(factories);
    var fn = WidgetFactories.LongPressEndDetailsSt.localPosition(st);
    return WidgetFactories.LongPressEndDetailsSt.localPosition.invoke(fn, self.build().getId());
  }
  MemorySegment longPressEndDetailsVelocity(LongPressEndDetails self) {
    var st = WidgetFactories.longPressEndDetails(factories);
    var fn = WidgetFactories.LongPressEndDetailsSt.velocity(st);
    return WidgetFactories.LongPressEndDetailsSt.velocity.invoke(fn, arena, self.build().getId());
  }

  int dragDownDetailsDragDownDetails(Optional<Offset> globalPosition, Optional<Offset> localPosition) {
    var st = WidgetFactories.dragDownDetails(factories);
    var fn = WidgetFactories.DragDownDetailsSt.dragDownDetails(st);
    return WidgetFactories.DragDownDetailsSt.dragDownDetails.invoke(fn, ptrObj(globalPosition),
      ptrObj(localPosition));
  }
  int dragDownDetailsGlobalPosition(DragDownDetails self) {
    var st = WidgetFactories.dragDownDetails(factories);
    var fn = WidgetFactories.DragDownDetailsSt.globalPosition(st);
    return WidgetFactories.DragDownDetailsSt.globalPosition.invoke(fn, self.build().getId());
  }
  int dragDownDetailsLocalPosition(DragDownDetails self) {
    var st = WidgetFactories.dragDownDetails(factories);
    var fn = WidgetFactories.DragDownDetailsSt.localPosition(st);
    return WidgetFactories.DragDownDetailsSt.localPosition.invoke(fn, self.build().getId());
  }

  int dragStartDetailsDragStartDetails(Optional<Offset> globalPosition, Optional<Offset> localPosition, Optional<Duration> sourceTimeStamp, Optional<PointerDeviceKind> kind) {
    var st = WidgetFactories.dragStartDetails(factories);
    var fn = WidgetFactories.DragStartDetailsSt.dragStartDetails(st);
    return WidgetFactories.DragStartDetailsSt.dragStartDetails.invoke(fn, ptrObj(globalPosition),
      ptrObj(localPosition),
      ptrObj(sourceTimeStamp),
      ptrEnum(kind));
  }
  int dragStartDetailsGlobalPosition(DragStartDetails self) {
    var st = WidgetFactories.dragStartDetails(factories);
    var fn = WidgetFactories.DragStartDetailsSt.globalPosition(st);
    return WidgetFactories.DragStartDetailsSt.globalPosition.invoke(fn, self.build().getId());
  }
  int dragStartDetailsLocalPosition(DragStartDetails self) {
    var st = WidgetFactories.dragStartDetails(factories);
    var fn = WidgetFactories.DragStartDetailsSt.localPosition(st);
    return WidgetFactories.DragStartDetailsSt.localPosition.invoke(fn, self.build().getId());
  }

  int dragUpdateDetailsDragUpdateDetails(Offset globalPosition, Optional<Offset> localPosition, Optional<Duration> sourceTimeStamp, Optional<Offset> delta, OptionalDouble primaryDelta, Optional<PointerDeviceKind> kind) {
    var st = WidgetFactories.dragUpdateDetails(factories);
    var fn = WidgetFactories.DragUpdateDetailsSt.dragUpdateDetails(st);
    return WidgetFactories.DragUpdateDetailsSt.dragUpdateDetails.invoke(fn, globalPosition.build().getId(),
      ptrObj(localPosition),
      ptrObj(sourceTimeStamp),
      ptrObj(delta),
      ptr(primaryDelta),
      ptrEnum(kind));
  }
  int dragUpdateDetailsGlobalPosition(DragUpdateDetails self) {
    var st = WidgetFactories.dragUpdateDetails(factories);
    var fn = WidgetFactories.DragUpdateDetailsSt.globalPosition(st);
    return WidgetFactories.DragUpdateDetailsSt.globalPosition.invoke(fn, self.build().getId());
  }
  int dragUpdateDetailsLocalPosition(DragUpdateDetails self) {
    var st = WidgetFactories.dragUpdateDetails(factories);
    var fn = WidgetFactories.DragUpdateDetailsSt.localPosition(st);
    return WidgetFactories.DragUpdateDetailsSt.localPosition.invoke(fn, self.build().getId());
  }
  int dragUpdateDetailsDelta(DragUpdateDetails self) {
    var st = WidgetFactories.dragUpdateDetails(factories);
    var fn = WidgetFactories.DragUpdateDetailsSt.delta(st);
    return WidgetFactories.DragUpdateDetailsSt.delta.invoke(fn, self.build().getId());
  }

  int dragEndDetailsDragEndDetails(Optional<Offset> globalPosition, Optional<Offset> localPosition, Optional<Velocity> velocity, OptionalDouble primaryVelocity) {
    var st = WidgetFactories.dragEndDetails(factories);
    var fn = WidgetFactories.DragEndDetailsSt.dragEndDetails(st);
    return WidgetFactories.DragEndDetailsSt.dragEndDetails.invoke(fn, ptrObj(globalPosition),
      ptrObj(localPosition),
      ptrObj(velocity),
      ptr(primaryVelocity));
  }
  int dragEndDetailsGlobalPosition(DragEndDetails self) {
    var st = WidgetFactories.dragEndDetails(factories);
    var fn = WidgetFactories.DragEndDetailsSt.globalPosition(st);
    return WidgetFactories.DragEndDetailsSt.globalPosition.invoke(fn, self.build().getId());
  }
  int dragEndDetailsLocalPosition(DragEndDetails self) {
    var st = WidgetFactories.dragEndDetails(factories);
    var fn = WidgetFactories.DragEndDetailsSt.localPosition(st);
    return WidgetFactories.DragEndDetailsSt.localPosition.invoke(fn, self.build().getId());
  }
  MemorySegment dragEndDetailsVelocity(DragEndDetails self) {
    var st = WidgetFactories.dragEndDetails(factories);
    var fn = WidgetFactories.DragEndDetailsSt.velocity(st);
    return WidgetFactories.DragEndDetailsSt.velocity.invoke(fn, arena, self.build().getId());
  }

  int scaleStartDetailsScaleStartDetails(Optional<Offset> focalPoint, Optional<Offset> localFocalPoint, OptionalInt pointerCount, Optional<Duration> sourceTimeStamp, Optional<PointerDeviceKind> kind) {
    var st = WidgetFactories.scaleStartDetails(factories);
    var fn = WidgetFactories.ScaleStartDetailsSt.scaleStartDetails(st);
    return WidgetFactories.ScaleStartDetailsSt.scaleStartDetails.invoke(fn, ptrObj(focalPoint),
      ptrObj(localFocalPoint),
      ptr(pointerCount),
      ptrObj(sourceTimeStamp),
      ptrEnum(kind));
  }
  int scaleStartDetailsFocalPoint(ScaleStartDetails self) {
    var st = WidgetFactories.scaleStartDetails(factories);
    var fn = WidgetFactories.ScaleStartDetailsSt.focalPoint(st);
    return WidgetFactories.ScaleStartDetailsSt.focalPoint.invoke(fn, self.build().getId());
  }
  int scaleStartDetailsLocalFocalPoint(ScaleStartDetails self) {
    var st = WidgetFactories.scaleStartDetails(factories);
    var fn = WidgetFactories.ScaleStartDetailsSt.localFocalPoint(st);
    return WidgetFactories.ScaleStartDetailsSt.localFocalPoint.invoke(fn, self.build().getId());
  }
  int scaleStartDetailsPointerCount(ScaleStartDetails self) {
    var st = WidgetFactories.scaleStartDetails(factories);
    var fn = WidgetFactories.ScaleStartDetailsSt.pointerCount(st);
    return WidgetFactories.ScaleStartDetailsSt.pointerCount.invoke(fn, self.build().getId());
  }

  int scaleUpdateDetailsScaleUpdateDetails(Optional<Offset> focalPoint, Optional<Offset> localFocalPoint, OptionalDouble scale, OptionalDouble horizontalScale, OptionalDouble verticalScale, OptionalDouble rotation, OptionalInt pointerCount, Optional<Offset> focalPointDelta, Optional<Duration> sourceTimeStamp) {
    var st = WidgetFactories.scaleUpdateDetails(factories);
    var fn = WidgetFactories.ScaleUpdateDetailsSt.scaleUpdateDetails(st);
    return WidgetFactories.ScaleUpdateDetailsSt.scaleUpdateDetails.invoke(fn, ptrObj(focalPoint),
      ptrObj(localFocalPoint),
      ptr(scale),
      ptr(horizontalScale),
      ptr(verticalScale),
      ptr(rotation),
      ptr(pointerCount),
      ptrObj(focalPointDelta),
      ptrObj(sourceTimeStamp));
  }
  int scaleUpdateDetailsFocalPoint(ScaleUpdateDetails self) {
    var st = WidgetFactories.scaleUpdateDetails(factories);
    var fn = WidgetFactories.ScaleUpdateDetailsSt.focalPoint(st);
    return WidgetFactories.ScaleUpdateDetailsSt.focalPoint.invoke(fn, self.build().getId());
  }
  int scaleUpdateDetailsLocalFocalPoint(ScaleUpdateDetails self) {
    var st = WidgetFactories.scaleUpdateDetails(factories);
    var fn = WidgetFactories.ScaleUpdateDetailsSt.localFocalPoint(st);
    return WidgetFactories.ScaleUpdateDetailsSt.localFocalPoint.invoke(fn, self.build().getId());
  }
  int scaleUpdateDetailsFocalPointDelta(ScaleUpdateDetails self) {
    var st = WidgetFactories.scaleUpdateDetails(factories);
    var fn = WidgetFactories.ScaleUpdateDetailsSt.focalPointDelta(st);
    return WidgetFactories.ScaleUpdateDetailsSt.focalPointDelta.invoke(fn, self.build().getId());
  }
  double scaleUpdateDetailsScale(ScaleUpdateDetails self) {
    var st = WidgetFactories.scaleUpdateDetails(factories);
    var fn = WidgetFactories.ScaleUpdateDetailsSt.scale(st);
    return WidgetFactories.ScaleUpdateDetailsSt.scale.invoke(fn, self.build().getId());
  }
  double scaleUpdateDetailsHorizontalScale(ScaleUpdateDetails self) {
    var st = WidgetFactories.scaleUpdateDetails(factories);
    var fn = WidgetFactories.ScaleUpdateDetailsSt.horizontalScale(st);
    return WidgetFactories.ScaleUpdateDetailsSt.horizontalScale.invoke(fn, self.build().getId());
  }
  double scaleUpdateDetailsVerticalScale(ScaleUpdateDetails self) {
    var st = WidgetFactories.scaleUpdateDetails(factories);
    var fn = WidgetFactories.ScaleUpdateDetailsSt.verticalScale(st);
    return WidgetFactories.ScaleUpdateDetailsSt.verticalScale.invoke(fn, self.build().getId());
  }
  double scaleUpdateDetailsRotation(ScaleUpdateDetails self) {
    var st = WidgetFactories.scaleUpdateDetails(factories);
    var fn = WidgetFactories.ScaleUpdateDetailsSt.rotation(st);
    return WidgetFactories.ScaleUpdateDetailsSt.rotation.invoke(fn, self.build().getId());
  }
  int scaleUpdateDetailsPointerCount(ScaleUpdateDetails self) {
    var st = WidgetFactories.scaleUpdateDetails(factories);
    var fn = WidgetFactories.ScaleUpdateDetailsSt.pointerCount(st);
    return WidgetFactories.ScaleUpdateDetailsSt.pointerCount.invoke(fn, self.build().getId());
  }

  int scaleEndDetailsScaleEndDetails(Optional<Velocity> velocity, OptionalDouble scaleVelocity, OptionalInt pointerCount) {
    var st = WidgetFactories.scaleEndDetails(factories);
    var fn = WidgetFactories.ScaleEndDetailsSt.scaleEndDetails(st);
    return WidgetFactories.ScaleEndDetailsSt.scaleEndDetails.invoke(fn, ptrObj(velocity),
      ptr(scaleVelocity),
      ptr(pointerCount));
  }
  MemorySegment scaleEndDetailsVelocity(ScaleEndDetails self) {
    var st = WidgetFactories.scaleEndDetails(factories);
    var fn = WidgetFactories.ScaleEndDetailsSt.velocity(st);
    return WidgetFactories.ScaleEndDetailsSt.velocity.invoke(fn, arena, self.build().getId());
  }
  double scaleEndDetailsScaleVelocity(ScaleEndDetails self) {
    var st = WidgetFactories.scaleEndDetails(factories);
    var fn = WidgetFactories.ScaleEndDetailsSt.scaleVelocity(st);
    return WidgetFactories.ScaleEndDetailsSt.scaleVelocity.invoke(fn, self.build().getId());
  }
  int scaleEndDetailsPointerCount(ScaleEndDetails self) {
    var st = WidgetFactories.scaleEndDetails(factories);
    var fn = WidgetFactories.ScaleEndDetailsSt.pointerCount(st);
    return WidgetFactories.ScaleEndDetailsSt.pointerCount.invoke(fn, self.build().getId());
  }

  int forcePressDetailsForcePressDetails(Offset globalPosition, Optional<Offset> localPosition, double pressure) {
    var st = WidgetFactories.forcePressDetails(factories);
    var fn = WidgetFactories.ForcePressDetailsSt.forcePressDetails(st);
    return WidgetFactories.ForcePressDetailsSt.forcePressDetails.invoke(fn, globalPosition.build().getId(),
      ptrObj(localPosition),
      pressure);
  }
  int forcePressDetailsGlobalPosition(ForcePressDetails self) {
    var st = WidgetFactories.forcePressDetails(factories);
    var fn = WidgetFactories.ForcePressDetailsSt.globalPosition(st);
    return WidgetFactories.ForcePressDetailsSt.globalPosition.invoke(fn, self.build().getId());
  }
  int forcePressDetailsLocalPosition(ForcePressDetails self) {
    var st = WidgetFactories.forcePressDetails(factories);
    var fn = WidgetFactories.ForcePressDetailsSt.localPosition(st);
    return WidgetFactories.ForcePressDetailsSt.localPosition.invoke(fn, self.build().getId());
  }
  double forcePressDetailsPressure(ForcePressDetails self) {
    var st = WidgetFactories.forcePressDetails(factories);
    var fn = WidgetFactories.ForcePressDetailsSt.pressure(st);
    return WidgetFactories.ForcePressDetailsSt.pressure.invoke(fn, self.build().getId());
  }

  int draggableDetailsDraggableDetails(Optional<Boolean> wasAccepted, Velocity velocity, Offset offset) {
    var st = WidgetFactories.draggableDetails(factories);
    var fn = WidgetFactories.DraggableDetailsSt.draggableDetails(st);
    return WidgetFactories.DraggableDetailsSt.draggableDetails.invoke(fn, ptrBool(wasAccepted),
      velocity.build().getId(),
      offset.build().getId());
  }
  int draggableDetailsWasAccepted(DraggableDetails self) {
    var st = WidgetFactories.draggableDetails(factories);
    var fn = WidgetFactories.DraggableDetailsSt.wasAccepted(st);
    return WidgetFactories.DraggableDetailsSt.wasAccepted.invoke(fn, self.build().getId());
  }
  MemorySegment draggableDetailsVelocity(DraggableDetails self) {
    var st = WidgetFactories.draggableDetails(factories);
    var fn = WidgetFactories.DraggableDetailsSt.velocity(st);
    return WidgetFactories.DraggableDetailsSt.velocity.invoke(fn, arena, self.build().getId());
  }
  int draggableDetailsOffset(DraggableDetails self) {
    var st = WidgetFactories.draggableDetails(factories);
    var fn = WidgetFactories.DraggableDetailsSt.offset(st);
    return WidgetFactories.DraggableDetailsSt.offset.invoke(fn, self.build().getId());
  }

  <T> int dragTargetDetailsDragTargetDetails(NativeObj data, Offset offset) {
    var st = WidgetFactories.dragTargetDetails(factories);
    var fn = WidgetFactories.DragTargetDetailsSt.dragTargetDetails(st);
    return WidgetFactories.DragTargetDetailsSt.dragTargetDetails.invoke(fn, data.build().getId(),
      offset.build().getId());
  }

  MemorySegment pointerDownEventPointerDownEvent(OptionalInt viewId, Optional<Duration> timeStamp, OptionalInt pointer, Optional<PointerDeviceKind> kind, OptionalInt device, Optional<Offset> position, OptionalInt buttons, Optional<Boolean> obscured, OptionalDouble pressure, OptionalDouble pressureMin, OptionalDouble pressureMax, OptionalDouble distanceMax, OptionalDouble size, OptionalDouble radiusMajor, OptionalDouble radiusMinor, OptionalDouble radiusMin, OptionalDouble radiusMax, OptionalDouble orientation, OptionalDouble tilt, OptionalInt embedderId) {
    var st = WidgetFactories.pointerDownEvent(factories);
    var fn = WidgetFactories.PointerDownEventSt.pointerDownEvent(st);
    return WidgetFactories.PointerDownEventSt.pointerDownEvent.invoke(fn, arena, ptr(viewId),
      ptrObj(timeStamp),
      ptr(pointer),
      ptrEnum(kind),
      ptr(device),
      ptrObj(position),
      ptr(buttons),
      ptrBool(obscured),
      ptr(pressure),
      ptr(pressureMin),
      ptr(pressureMax),
      ptr(distanceMax),
      ptr(size),
      ptr(radiusMajor),
      ptr(radiusMinor),
      ptr(radiusMin),
      ptr(radiusMax),
      ptr(orientation),
      ptr(tilt),
      ptr(embedderId));
  }

  MemorySegment pointerUpEventPointerUpEvent(OptionalInt viewId, Optional<Duration> timeStamp, OptionalInt pointer, Optional<PointerDeviceKind> kind, OptionalInt device, Optional<Offset> position, OptionalInt buttons, Optional<Boolean> obscured, OptionalDouble pressure, OptionalDouble pressureMin, OptionalDouble pressureMax, OptionalDouble distance, OptionalDouble distanceMax, OptionalDouble size, OptionalDouble radiusMajor, OptionalDouble radiusMinor, OptionalDouble radiusMin, OptionalDouble radiusMax, OptionalDouble orientation, OptionalDouble tilt, OptionalInt embedderId) {
    var st = WidgetFactories.pointerUpEvent(factories);
    var fn = WidgetFactories.PointerUpEventSt.pointerUpEvent(st);
    return WidgetFactories.PointerUpEventSt.pointerUpEvent.invoke(fn, arena, ptr(viewId),
      ptrObj(timeStamp),
      ptr(pointer),
      ptrEnum(kind),
      ptr(device),
      ptrObj(position),
      ptr(buttons),
      ptrBool(obscured),
      ptr(pressure),
      ptr(pressureMin),
      ptr(pressureMax),
      ptr(distance),
      ptr(distanceMax),
      ptr(size),
      ptr(radiusMajor),
      ptr(radiusMinor),
      ptr(radiusMin),
      ptr(radiusMax),
      ptr(orientation),
      ptr(tilt),
      ptr(embedderId));
  }

  MemorySegment pointerHoverEventPointerHoverEvent(OptionalInt viewId, Optional<Duration> timeStamp, Optional<PointerDeviceKind> kind, OptionalInt pointer, OptionalInt device, Optional<Offset> position, Optional<Offset> delta, OptionalInt buttons, Optional<Boolean> obscured, OptionalDouble pressureMin, OptionalDouble pressureMax, OptionalDouble distance, OptionalDouble distanceMax, OptionalDouble size, OptionalDouble radiusMajor, OptionalDouble radiusMinor, OptionalDouble radiusMin, OptionalDouble radiusMax, OptionalDouble orientation, OptionalDouble tilt, Optional<Boolean> synthesized, OptionalInt embedderId) {
    var st = WidgetFactories.pointerHoverEvent(factories);
    var fn = WidgetFactories.PointerHoverEventSt.pointerHoverEvent(st);
    return WidgetFactories.PointerHoverEventSt.pointerHoverEvent.invoke(fn, arena, ptr(viewId),
      ptrObj(timeStamp),
      ptrEnum(kind),
      ptr(pointer),
      ptr(device),
      ptrObj(position),
      ptrObj(delta),
      ptr(buttons),
      ptrBool(obscured),
      ptr(pressureMin),
      ptr(pressureMax),
      ptr(distance),
      ptr(distanceMax),
      ptr(size),
      ptr(radiusMajor),
      ptr(radiusMinor),
      ptr(radiusMin),
      ptr(radiusMax),
      ptr(orientation),
      ptr(tilt),
      ptrBool(synthesized),
      ptr(embedderId));
  }

  MemorySegment cubicCubic(double a, double b, double c, double d) {
    var st = WidgetFactories.cubic(factories);
    var fn = WidgetFactories.CubicSt.cubic(st);
    return WidgetFactories.CubicSt.cubic.invoke(fn, arena, a,
      b,
      c,
      d);
  }

  MemorySegment threePointCubicThreePointCubic(Offset a1, Offset b1, Offset midpoint, Offset a2, Offset b2) {
    var st = WidgetFactories.threePointCubic(factories);
    var fn = WidgetFactories.ThreePointCubicSt.threePointCubic(st);
    return WidgetFactories.ThreePointCubicSt.threePointCubic.invoke(fn, arena, a1.build().getId(),
      b1.build().getId(),
      midpoint.build().getId(),
      a2.build().getId(),
      b2.build().getId());
  }

  MemorySegment elasticOutCurveElasticOutCurve(OptionalDouble period) {
    var st = WidgetFactories.elasticOutCurve(factories);
    var fn = WidgetFactories.ElasticOutCurveSt.elasticOutCurve(st);
    return WidgetFactories.ElasticOutCurveSt.elasticOutCurve.invoke(fn, arena, ptr(period));
  }

  MemorySegment elasticInCurveElasticInCurve(OptionalDouble period) {
    var st = WidgetFactories.elasticInCurve(factories);
    var fn = WidgetFactories.ElasticInCurveSt.elasticInCurve(st);
    return WidgetFactories.ElasticInCurveSt.elasticInCurve.invoke(fn, arena, ptr(period));
  }

  MemorySegment elasticInOutCurveElasticInOutCurve(OptionalDouble period) {
    var st = WidgetFactories.elasticInOutCurve(factories);
    var fn = WidgetFactories.ElasticInOutCurveSt.elasticInOutCurve(st);
    return WidgetFactories.ElasticInOutCurveSt.elasticInOutCurve.invoke(fn, arena, ptr(period));
  }

  int curvesLinear() {
    var st = WidgetFactories.curves(factories);
    return WidgetFactories.CurvesSt.linear(st);
  }
  int curvesDecelerate() {
    var st = WidgetFactories.curves(factories);
    return WidgetFactories.CurvesSt.decelerate(st);
  }
  int curvesBounceIn() {
    var st = WidgetFactories.curves(factories);
    return WidgetFactories.CurvesSt.bounceIn(st);
  }
  int curvesBounceOut() {
    var st = WidgetFactories.curves(factories);
    return WidgetFactories.CurvesSt.bounceOut(st);
  }
  int curvesBounceInOut() {
    var st = WidgetFactories.curves(factories);
    return WidgetFactories.CurvesSt.bounceInOut(st);
  }

  int curvedAnimationCurvedAnimation(Animation parent, Curve curve, Optional<Curve> reverseCurve) {
    var st = WidgetFactories.curvedAnimation(factories);
    var fn = WidgetFactories.CurvedAnimationSt.curvedAnimation(st);
    return WidgetFactories.CurvedAnimationSt.curvedAnimation.invoke(fn, parent.build().getId(),
      curve.build().getId(),
      ptrObj(reverseCurve));
  }

  MemorySegment sizedBoxSizedBox(OptionalDouble width, OptionalDouble height, Optional<Widget> child) {
    var st = WidgetFactories.sizedBox(factories);
    var fn = WidgetFactories.SizedBoxSt.sizedBox(st);
    return WidgetFactories.SizedBoxSt.sizedBox.invoke(fn, arena, ptr(width),
      ptr(height),
      ptrObj(child));
  }
  MemorySegment sizedBoxExpand(Optional<Widget> child) {
    var st = WidgetFactories.sizedBox(factories);
    var fn = WidgetFactories.SizedBoxSt.expand(st);
    return WidgetFactories.SizedBoxSt.expand.invoke(fn, arena, ptrObj(child));
  }
  MemorySegment sizedBoxShrink(Optional<Widget> child) {
    var st = WidgetFactories.sizedBox(factories);
    var fn = WidgetFactories.SizedBoxSt.shrink(st);
    return WidgetFactories.SizedBoxSt.shrink.invoke(fn, arena, ptrObj(child));
  }
  MemorySegment sizedBoxFromSize(Optional<Widget> child) {
    var st = WidgetFactories.sizedBox(factories);
    var fn = WidgetFactories.SizedBoxSt.fromSize(st);
    return WidgetFactories.SizedBoxSt.fromSize.invoke(fn, arena, ptrObj(child));
  }
  MemorySegment sizedBoxSquare(Optional<Widget> child, OptionalDouble dimension) {
    var st = WidgetFactories.sizedBox(factories);
    var fn = WidgetFactories.SizedBoxSt.square(st);
    return WidgetFactories.SizedBoxSt.square.invoke(fn, arena, ptrObj(child),
      ptr(dimension));
  }

  MemorySegment alignmentAlignment(double x, double y) {
    var st = WidgetFactories.alignment(factories);
    var fn = WidgetFactories.AlignmentSt.alignment(st);
    return WidgetFactories.AlignmentSt.alignment.invoke(fn, arena, x,
      y);
  }
  MemorySegment alignmentLerp(Alignment a, Alignment b, double t) {
    var st = WidgetFactories.alignment(factories);
    var fn = WidgetFactories.AlignmentSt.lerp(st);
    return WidgetFactories.AlignmentSt.lerp.invoke(fn, arena, a != null ? a.build().getId() : null,
      b != null ? b.build().getId() : null,
      t);
  }

  MemorySegment alignmentDirectionalAlignmentDirectional(double start, double y) {
    var st = WidgetFactories.alignmentDirectional(factories);
    var fn = WidgetFactories.AlignmentDirectionalSt.alignmentDirectional(st);
    return WidgetFactories.AlignmentDirectionalSt.alignmentDirectional.invoke(fn, arena, start,
      y);
  }
  MemorySegment alignmentDirectionalLerp(AlignmentDirectional a, AlignmentDirectional b, double t) {
    var st = WidgetFactories.alignmentDirectional(factories);
    var fn = WidgetFactories.AlignmentDirectionalSt.lerp(st);
    return WidgetFactories.AlignmentDirectionalSt.lerp.invoke(fn, arena, a != null ? a.build().getId() : null,
      b != null ? b.build().getId() : null,
      t);
  }

  MemorySegment mouseRegionMouseRegion(Optional<Consumer<PointerEnterEvent>> onEnter, Optional<Consumer<PointerExitEvent>> onExit, Optional<Consumer<PointerHoverEvent>> onHover, Optional<Boolean> opaque, Optional<HitTestBehavior> hitTestBehavior, Optional<Widget> child) {
    var st = WidgetFactories.mouseRegion(factories);
    var fn = WidgetFactories.MouseRegionSt.mouseRegion(st);
    return WidgetFactories.MouseRegionSt.mouseRegion.invoke(fn, arena, onEnter.isPresent() ? ptrHolder(ptrPointerEnterEventListenerFn(onEnter.get())) : MemorySegment.NULL,
      onExit.isPresent() ? ptrHolder(ptrPointerExitEventListenerFn(onExit.get())) : MemorySegment.NULL,
      onHover.isPresent() ? ptrHolder(ptrPointerHoverEventListenerFn(onHover.get())) : MemorySegment.NULL,
      ptrBool(opaque),
      ptrEnum(hitTestBehavior),
      ptrObj(child));
  }

  MemorySegment expandedExpanded(OptionalInt flex, Widget child) {
    var st = WidgetFactories.expanded(factories);
    var fn = WidgetFactories.ExpandedSt.expanded(st);
    return WidgetFactories.ExpandedSt.expanded.invoke(fn, arena, ptr(flex),
      child.build().getId());
  }

  MemorySegment flexibleFlexible(OptionalInt flex, Optional<FlexFit> fit, Widget child) {
    var st = WidgetFactories.flexible(factories);
    var fn = WidgetFactories.FlexibleSt.flexible(st);
    return WidgetFactories.FlexibleSt.flexible.invoke(fn, arena, ptr(flex),
      ptrEnum(fit),
      child.build().getId());
  }

  MemorySegment safeAreaSafeArea(Optional<Boolean> left, Optional<Boolean> top, Optional<Boolean> right, Optional<Boolean> bottom, Optional<EdgeInsets> minimum, Optional<Boolean> maintainBottomViewPadding, Widget child) {
    var st = WidgetFactories.safeArea(factories);
    var fn = WidgetFactories.SafeAreaSt.safeArea(st);
    return WidgetFactories.SafeAreaSt.safeArea.invoke(fn, arena, ptrBool(left),
      ptrBool(top),
      ptrBool(right),
      ptrBool(bottom),
      ptrObj(minimum),
      ptrBool(maintainBottomViewPadding),
      child.build().getId());
  }

  MemorySegment rotationTransitionRotationTransition(Animation turns, Optional<Alignment> alignment, Optional<FilterQuality> filterQuality, Optional<Widget> child) {
    var st = WidgetFactories.rotationTransition(factories);
    var fn = WidgetFactories.RotationTransitionSt.rotationTransition(st);
    return WidgetFactories.RotationTransitionSt.rotationTransition.invoke(fn, arena, turns.build().getId(),
      ptrObj(alignment),
      ptrEnum(filterQuality),
      ptrObj(child));
  }

  MemorySegment fadeTransitionFadeTransition(Animation opacity, Optional<Boolean> alwaysIncludeSemantics, Optional<Widget> child) {
    var st = WidgetFactories.fadeTransition(factories);
    var fn = WidgetFactories.FadeTransitionSt.fadeTransition(st);
    return WidgetFactories.FadeTransitionSt.fadeTransition.invoke(fn, arena, opacity.build().getId(),
      ptrBool(alwaysIncludeSemantics),
      ptrObj(child));
  }

  MemorySegment scaleTransitionScaleTransition(Animation scale, Optional<Alignment> alignment, Optional<FilterQuality> filterQuality, Optional<Widget> child) {
    var st = WidgetFactories.scaleTransition(factories);
    var fn = WidgetFactories.ScaleTransitionSt.scaleTransition(st);
    return WidgetFactories.ScaleTransitionSt.scaleTransition.invoke(fn, arena, scale.build().getId(),
      ptrObj(alignment),
      ptrEnum(filterQuality),
      ptrObj(child));
  }

  MemorySegment aspectRatioAspectRatio(double aspectRatio, Optional<Widget> child) {
    var st = WidgetFactories.aspectRatio(factories);
    var fn = WidgetFactories.AspectRatioSt.aspectRatio(st);
    return WidgetFactories.AspectRatioSt.aspectRatio.invoke(fn, arena, aspectRatio,
      ptrObj(child));
  }

  MemorySegment clipOvalClipOval(Optional<Clip> clipBehavior, Optional<Widget> child) {
    var st = WidgetFactories.clipOval(factories);
    var fn = WidgetFactories.ClipOvalSt.clipOval(st);
    return WidgetFactories.ClipOvalSt.clipOval.invoke(fn, arena, ptrEnum(clipBehavior),
      ptrObj(child));
  }

  MemorySegment clipRRectClipRRect(Optional<BorderRadiusGeometry> borderRadius, Optional<Clip> clipBehavior, Optional<Widget> child) {
    var st = WidgetFactories.clipRRect(factories);
    var fn = WidgetFactories.ClipRRectSt.clipRRect(st);
    return WidgetFactories.ClipRRectSt.clipRRect.invoke(fn, arena, ptrObj(borderRadius),
      ptrEnum(clipBehavior),
      ptrObj(child));
  }

  MemorySegment clipRectClipRect(Optional<Clip> clipBehavior, Optional<Widget> child) {
    var st = WidgetFactories.clipRect(factories);
    var fn = WidgetFactories.ClipRectSt.clipRect(st);
    return WidgetFactories.ClipRectSt.clipRect.invoke(fn, arena, ptrEnum(clipBehavior),
      ptrObj(child));
  }

  MemorySegment clipRSuperellipseClipRSuperellipse(Optional<BorderRadiusGeometry> borderRadius, Optional<Clip> clipBehavior, Optional<Widget> child) {
    var st = WidgetFactories.clipRSuperellipse(factories);
    var fn = WidgetFactories.ClipRSuperellipseSt.clipRSuperellipse(st);
    return WidgetFactories.ClipRSuperellipseSt.clipRSuperellipse.invoke(fn, arena, ptrObj(borderRadius),
      ptrEnum(clipBehavior),
      ptrObj(child));
  }

  MemorySegment coloredBoxColoredBox(Color color, Optional<Widget> child) {
    var st = WidgetFactories.coloredBox(factories);
    var fn = WidgetFactories.ColoredBoxSt.coloredBox(st);
    return WidgetFactories.ColoredBoxSt.coloredBox.invoke(fn, arena, color.build().getId(),
      ptrObj(child));
  }

  MemorySegment constrainedBoxConstrainedBox(BoxConstraints constraints, Optional<Widget> child) {
    var st = WidgetFactories.constrainedBox(factories);
    var fn = WidgetFactories.ConstrainedBoxSt.constrainedBox(st);
    return WidgetFactories.ConstrainedBoxSt.constrainedBox.invoke(fn, arena, constraints.build().getId(),
      ptrObj(child));
  }

  MemorySegment decoratedBoxDecoratedBox(Decoration decoration, Optional<DecorationPosition> position, Optional<Widget> child) {
    var st = WidgetFactories.decoratedBox(factories);
    var fn = WidgetFactories.DecoratedBoxSt.decoratedBox(st);
    return WidgetFactories.DecoratedBoxSt.decoratedBox.invoke(fn, arena, decoration.build().getId(),
      ptrEnum(position),
      ptrObj(child));
  }

  MemorySegment fittedBoxFittedBox(Optional<BoxFit> fit, Optional<AlignmentGeometry> alignment, Optional<Clip> clipBehavior, Optional<Widget> child) {
    var st = WidgetFactories.fittedBox(factories);
    var fn = WidgetFactories.FittedBoxSt.fittedBox(st);
    return WidgetFactories.FittedBoxSt.fittedBox.invoke(fn, arena, ptrEnum(fit),
      ptrObj(alignment),
      ptrEnum(clipBehavior),
      ptrObj(child));
  }

  MemorySegment fractionallySizedBoxFractionallySizedBox(Optional<AlignmentGeometry> alignment, OptionalDouble widthFactor, OptionalDouble heightFactor, Optional<Widget> child) {
    var st = WidgetFactories.fractionallySizedBox(factories);
    var fn = WidgetFactories.FractionallySizedBoxSt.fractionallySizedBox(st);
    return WidgetFactories.FractionallySizedBoxSt.fractionallySizedBox.invoke(fn, arena, ptrObj(alignment),
      ptr(widthFactor),
      ptr(heightFactor),
      ptrObj(child));
  }

  MemorySegment intrinsicHeightIntrinsicHeight(Optional<Widget> child) {
    var st = WidgetFactories.intrinsicHeight(factories);
    var fn = WidgetFactories.IntrinsicHeightSt.intrinsicHeight(st);
    return WidgetFactories.IntrinsicHeightSt.intrinsicHeight.invoke(fn, arena, ptrObj(child));
  }

  MemorySegment intrinsicWidthIntrinsicWidth(OptionalDouble stepWidth, OptionalDouble stepHeight, Optional<Widget> child) {
    var st = WidgetFactories.intrinsicWidth(factories);
    var fn = WidgetFactories.IntrinsicWidthSt.intrinsicWidth(st);
    return WidgetFactories.IntrinsicWidthSt.intrinsicWidth.invoke(fn, arena, ptr(stepWidth),
      ptr(stepHeight),
      ptrObj(child));
  }

  MemorySegment limitedBoxLimitedBox(OptionalDouble maxWidth, OptionalDouble maxHeight, Optional<Widget> child) {
    var st = WidgetFactories.limitedBox(factories);
    var fn = WidgetFactories.LimitedBoxSt.limitedBox(st);
    return WidgetFactories.LimitedBoxSt.limitedBox.invoke(fn, arena, ptr(maxWidth),
      ptr(maxHeight),
      ptrObj(child));
  }

  MemorySegment placeholderPlaceholder(Optional<Color> color, OptionalDouble strokeWidth, OptionalDouble fallbackWidth, OptionalDouble fallbackHeight, Optional<Widget> child) {
    var st = WidgetFactories.placeholder(factories);
    var fn = WidgetFactories.PlaceholderSt.placeholder(st);
    return WidgetFactories.PlaceholderSt.placeholder.invoke(fn, arena, ptrObj(color),
      ptr(strokeWidth),
      ptr(fallbackWidth),
      ptr(fallbackHeight),
      ptrObj(child));
  }

  MemorySegment spacerSpacer(OptionalInt flex) {
    var st = WidgetFactories.spacer(factories);
    var fn = WidgetFactories.SpacerSt.spacer(st);
    return WidgetFactories.SpacerSt.spacer.invoke(fn, arena, ptr(flex));
  }

  MemorySegment visibilityVisibility(Widget child, Optional<Widget> replacement, Optional<Boolean> visible, Optional<Boolean> maintainState, Optional<Boolean> maintainAnimation, Optional<Boolean> maintainSize, Optional<Boolean> maintainSemantics, Optional<Boolean> maintainInteractivity, Optional<Boolean> maintainFocusability) {
    var st = WidgetFactories.visibility(factories);
    var fn = WidgetFactories.VisibilitySt.visibility(st);
    return WidgetFactories.VisibilitySt.visibility.invoke(fn, arena, child.build().getId(),
      ptrObj(replacement),
      ptrBool(visible),
      ptrBool(maintainState),
      ptrBool(maintainAnimation),
      ptrBool(maintainSize),
      ptrBool(maintainSemantics),
      ptrBool(maintainInteractivity),
      ptrBool(maintainFocusability));
  }
  MemorySegment visibilityMaintain(Widget child, Optional<Boolean> visible) {
    var st = WidgetFactories.visibility(factories);
    var fn = WidgetFactories.VisibilitySt.maintain(st);
    return WidgetFactories.VisibilitySt.maintain.invoke(fn, arena, child.build().getId(),
      ptrBool(visible));
  }
  int visibilityOf(BuildContext context) {
    var st = WidgetFactories.visibility(factories);
    var fn = WidgetFactories.VisibilitySt.of(st);
    return WidgetFactories.VisibilitySt.of.invoke(fn, context.build().getId());
  }

  MemorySegment rotatedBoxRotatedBox(int quarterTurns, Optional<Widget> child) {
    var st = WidgetFactories.rotatedBox(factories);
    var fn = WidgetFactories.RotatedBoxSt.rotatedBox(st);
    return WidgetFactories.RotatedBoxSt.rotatedBox.invoke(fn, arena, quarterTurns,
      ptrObj(child));
  }

  MemorySegment baselineBaseline(double baseline, TextBaseline baselineType, Optional<Widget> child) {
    var st = WidgetFactories.baseline(factories);
    var fn = WidgetFactories.BaselineSt.baseline(st);
    return WidgetFactories.BaselineSt.baseline.invoke(fn, arena, baseline,
      baselineType.ordinal(),
      ptrObj(child));
  }

  MemorySegment defaultTextStyleDefaultTextStyle(TextStyle style, Optional<TextAlign> textAlign, Optional<Boolean> softWrap, Optional<TextOverflow> overflow, OptionalInt maxLines, Optional<TextWidthBasis> textWidthBasis, Widget child) {
    var st = WidgetFactories.defaultTextStyle(factories);
    var fn = WidgetFactories.DefaultTextStyleSt.defaultTextStyle(st);
    return WidgetFactories.DefaultTextStyleSt.defaultTextStyle.invoke(fn, arena, style.build().getId(),
      ptrEnum(textAlign),
      ptrBool(softWrap),
      ptrEnum(overflow),
      ptr(maxLines),
      ptrEnum(textWidthBasis),
      child.build().getId());
  }
  MemorySegment defaultTextStyleFallback() {
    var st = WidgetFactories.defaultTextStyle(factories);
    var fn = WidgetFactories.DefaultTextStyleSt.fallback(st);
    return WidgetFactories.DefaultTextStyleSt.fallback.invoke(fn, arena);
  }
  int defaultTextStyleMerge(Optional<TextStyle> style, Optional<TextAlign> textAlign, Optional<Boolean> softWrap, Optional<TextOverflow> overflow, OptionalInt maxLines, Optional<TextWidthBasis> textWidthBasis, Widget child) {
    var st = WidgetFactories.defaultTextStyle(factories);
    var fn = WidgetFactories.DefaultTextStyleSt.merge(st);
    return WidgetFactories.DefaultTextStyleSt.merge.invoke(fn, ptrObj(style),
      ptrEnum(textAlign),
      ptrBool(softWrap),
      ptrEnum(overflow),
      ptr(maxLines),
      ptrEnum(textWidthBasis),
      child.build().getId());
  }
  MemorySegment defaultTextStyleOf(BuildContext context) {
    var st = WidgetFactories.defaultTextStyle(factories);
    var fn = WidgetFactories.DefaultTextStyleSt.of(st);
    return WidgetFactories.DefaultTextStyleSt.of.invoke(fn, arena, context.build().getId());
  }

  MemorySegment directionalityDirectionality(TextDirection textDirection, Widget child) {
    var st = WidgetFactories.directionality(factories);
    var fn = WidgetFactories.DirectionalitySt.directionality(st);
    return WidgetFactories.DirectionalitySt.directionality.invoke(fn, arena, textDirection.ordinal(),
      child.build().getId());
  }
  int directionalityOf(BuildContext context) {
    var st = WidgetFactories.directionality(factories);
    var fn = WidgetFactories.DirectionalitySt.of(st);
    return WidgetFactories.DirectionalitySt.of.invoke(fn, context.build().getId());
  }
  int directionalityMaybeOf(BuildContext context) {
    var st = WidgetFactories.directionality(factories);
    var fn = WidgetFactories.DirectionalitySt.maybeOf(st);
    return WidgetFactories.DirectionalitySt.maybeOf.invoke(fn, context.build().getId());
  }

  MemorySegment overflowBoxOverflowBox(Optional<AlignmentGeometry> alignment, OptionalDouble minWidth, OptionalDouble maxWidth, OptionalDouble minHeight, OptionalDouble maxHeight, Optional<OverflowBoxFit> fit, Optional<Widget> child) {
    var st = WidgetFactories.overflowBox(factories);
    var fn = WidgetFactories.OverflowBoxSt.overflowBox(st);
    return WidgetFactories.OverflowBoxSt.overflowBox.invoke(fn, arena, ptrObj(alignment),
      ptr(minWidth),
      ptr(maxWidth),
      ptr(minHeight),
      ptr(maxHeight),
      ptrEnum(fit),
      ptrObj(child));
  }

  MemorySegment absorbPointerAbsorbPointer(Optional<Boolean> absorbing, Optional<Boolean> ignoringSemantics, Optional<Widget> child) {
    var st = WidgetFactories.absorbPointer(factories);
    var fn = WidgetFactories.AbsorbPointerSt.absorbPointer(st);
    return WidgetFactories.AbsorbPointerSt.absorbPointer.invoke(fn, arena, ptrBool(absorbing),
      ptrBool(ignoringSemantics),
      ptrObj(child));
  }

  MemorySegment ignorePointerIgnorePointer(Optional<Boolean> ignoring, Optional<Boolean> ignoringSemantics, Optional<Widget> child) {
    var st = WidgetFactories.ignorePointer(factories);
    var fn = WidgetFactories.IgnorePointerSt.ignorePointer(st);
    return WidgetFactories.IgnorePointerSt.ignorePointer.invoke(fn, arena, ptrBool(ignoring),
      ptrBool(ignoringSemantics),
      ptrObj(child));
  }

  MemorySegment repaintBoundaryRepaintBoundary(Optional<Widget> child) {
    var st = WidgetFactories.repaintBoundary(factories);
    var fn = WidgetFactories.RepaintBoundarySt.repaintBoundary(st);
    return WidgetFactories.RepaintBoundarySt.repaintBoundary.invoke(fn, arena, ptrObj(child));
  }
  MemorySegment repaintBoundaryWrap(Widget child, int childIndex) {
    var st = WidgetFactories.repaintBoundary(factories);
    var fn = WidgetFactories.RepaintBoundarySt.wrap(st);
    return WidgetFactories.RepaintBoundarySt.wrap.invoke(fn, arena, child.build().getId(),
      childIndex);
  }

  MemorySegment fractionalTranslationFractionalTranslation(Offset translation, Optional<Boolean> transformHitTests, Optional<Widget> child) {
    var st = WidgetFactories.fractionalTranslation(factories);
    var fn = WidgetFactories.FractionalTranslationSt.fractionalTranslation(st);
    return WidgetFactories.FractionalTranslationSt.fractionalTranslation.invoke(fn, arena, translation.build().getId(),
      ptrBool(transformHitTests),
      ptrObj(child));
  }

  MemorySegment unconstrainedBoxUnconstrainedBox(Optional<Widget> child, Optional<TextDirection> textDirection, Optional<AlignmentGeometry> alignment, Optional<Axis> constrainedAxis, Optional<Clip> clipBehavior) {
    var st = WidgetFactories.unconstrainedBox(factories);
    var fn = WidgetFactories.UnconstrainedBoxSt.unconstrainedBox(st);
    return WidgetFactories.UnconstrainedBoxSt.unconstrainedBox.invoke(fn, arena, ptrObj(child),
      ptrEnum(textDirection),
      ptrObj(alignment),
      ptrEnum(constrainedAxis),
      ptrEnum(clipBehavior));
  }

  MemorySegment flutterLogoFlutterLogo(OptionalDouble size, Optional<Color> textColor, Optional<FlutterLogoStyle> style, Optional<Duration> duration, Optional<Curve> curve) {
    var st = WidgetFactories.flutterLogo(factories);
    var fn = WidgetFactories.FlutterLogoSt.flutterLogo(st);
    return WidgetFactories.FlutterLogoSt.flutterLogo.invoke(fn, arena, ptr(size),
      ptrObj(textColor),
      ptrEnum(style),
      ptrObj(duration),
      ptrObj(curve));
  }

  MemorySegment physicalModelPhysicalModel(Optional<BoxShape> shape, Optional<Clip> clipBehavior, Optional<BorderRadius> borderRadius, OptionalDouble elevation, Color color, Optional<Color> shadowColor, Optional<Widget> child) {
    var st = WidgetFactories.physicalModel(factories);
    var fn = WidgetFactories.PhysicalModelSt.physicalModel(st);
    return WidgetFactories.PhysicalModelSt.physicalModel.invoke(fn, arena, ptrEnum(shape),
      ptrEnum(clipBehavior),
      ptrObj(borderRadius),
      ptr(elevation),
      color.build().getId(),
      ptrObj(shadowColor),
      ptrObj(child));
  }

  MemorySegment bannerBanner(Optional<Widget> child, String message, Optional<TextDirection> textDirection, BannerLocation location, Optional<TextDirection> layoutDirection, Optional<Color> color, Optional<BoxShadow> shadow) {
    var st = WidgetFactories.banner(factories);
    var fn = WidgetFactories.BannerSt.banner(st);
    return WidgetFactories.BannerSt.banner.invoke(fn, arena, ptrObj(child),
      arena.allocateFrom(message),
      ptrEnum(textDirection),
      location.ordinal(),
      ptrEnum(layoutDirection),
      ptrObj(color),
      ptrObj(shadow));
  }

  MemorySegment animatedContainerAnimatedContainer(Optional<AlignmentGeometry> alignment, Optional<EdgeInsetsGeometry> padding, Optional<Color> color, Optional<Decoration> decoration, Optional<Decoration> foregroundDecoration, OptionalDouble width, OptionalDouble height, Optional<BoxConstraints> constraints, Optional<EdgeInsetsGeometry> margin, Optional<AlignmentGeometry> transformAlignment, Optional<Widget> child, Optional<Clip> clipBehavior, Optional<Curve> curve, Duration duration, Optional<Runnable> onEnd) {
    var st = WidgetFactories.animatedContainer(factories);
    var fn = WidgetFactories.AnimatedContainerSt.animatedContainer(st);
    return WidgetFactories.AnimatedContainerSt.animatedContainer.invoke(fn, arena, ptrObj(alignment),
      ptrObj(padding),
      ptrObj(color),
      ptrObj(decoration),
      ptrObj(foregroundDecoration),
      ptr(width),
      ptr(height),
      ptrObj(constraints),
      ptrObj(margin),
      ptrObj(transformAlignment),
      ptrObj(child),
      ptrEnum(clipBehavior),
      ptrObj(curve),
      duration.build().getId(),
      onEnd.isPresent() ? ptrHolder(ptrVoidCallbackFn(onEnd.get())) : MemorySegment.NULL);
  }

  MemorySegment animatedOpacityAnimatedOpacity(Optional<Widget> child, double opacity, Optional<Curve> curve, Duration duration, Optional<Runnable> onEnd, Optional<Boolean> alwaysIncludeSemantics) {
    var st = WidgetFactories.animatedOpacity(factories);
    var fn = WidgetFactories.AnimatedOpacitySt.animatedOpacity(st);
    return WidgetFactories.AnimatedOpacitySt.animatedOpacity.invoke(fn, arena, ptrObj(child),
      opacity,
      ptrObj(curve),
      duration.build().getId(),
      onEnd.isPresent() ? ptrHolder(ptrVoidCallbackFn(onEnd.get())) : MemorySegment.NULL,
      ptrBool(alwaysIncludeSemantics));
  }

  MemorySegment animatedPaddingAnimatedPadding(EdgeInsetsGeometry padding, Optional<Widget> child, Optional<Curve> curve, Duration duration, Optional<Runnable> onEnd) {
    var st = WidgetFactories.animatedPadding(factories);
    var fn = WidgetFactories.AnimatedPaddingSt.animatedPadding(st);
    return WidgetFactories.AnimatedPaddingSt.animatedPadding.invoke(fn, arena, padding.build().getId(),
      ptrObj(child),
      ptrObj(curve),
      duration.build().getId(),
      onEnd.isPresent() ? ptrHolder(ptrVoidCallbackFn(onEnd.get())) : MemorySegment.NULL);
  }

  MemorySegment animatedAlignAnimatedAlign(AlignmentGeometry alignment, Optional<Widget> child, OptionalDouble heightFactor, OptionalDouble widthFactor, Optional<Curve> curve, Duration duration, Optional<Runnable> onEnd) {
    var st = WidgetFactories.animatedAlign(factories);
    var fn = WidgetFactories.AnimatedAlignSt.animatedAlign(st);
    return WidgetFactories.AnimatedAlignSt.animatedAlign.invoke(fn, arena, alignment.build().getId(),
      ptrObj(child),
      ptr(heightFactor),
      ptr(widthFactor),
      ptrObj(curve),
      duration.build().getId(),
      onEnd.isPresent() ? ptrHolder(ptrVoidCallbackFn(onEnd.get())) : MemorySegment.NULL);
  }

  MemorySegment listViewListView(Optional<Axis> scrollDirection, Optional<Boolean> reverse, Optional<Boolean> primary, Optional<Boolean> shrinkWrap, Optional<EdgeInsetsGeometry> padding, OptionalDouble itemExtent, Optional<Widget> prototypeItem, Optional<Boolean> addAutomaticKeepAlives, Optional<Boolean> addRepaintBoundaries, Optional<Boolean> addSemanticIndexes, OptionalDouble cacheExtent, Optional<List<Widget>> children, OptionalInt semanticChildCount, Optional<DragStartBehavior> dragStartBehavior, Optional<ScrollViewKeyboardDismissBehavior> keyboardDismissBehavior, Optional<String> restorationId, Optional<Clip> clipBehavior, Optional<HitTestBehavior> hitTestBehavior) {
    var st = WidgetFactories.listView(factories);
    var fn = WidgetFactories.ListViewSt.listView(st);
    return WidgetFactories.ListViewSt.listView.invoke(fn, arena, ptrEnum(scrollDirection),
      ptrBool(reverse),
      ptrBool(primary),
      ptrBool(shrinkWrap),
      ptrObj(padding),
      ptr(itemExtent),
      ptrObj(prototypeItem),
      ptrBool(addAutomaticKeepAlives),
      ptrBool(addRepaintBoundaries),
      ptrBool(addSemanticIndexes),
      ptr(cacheExtent),
      ptrList(children),
      ptr(semanticChildCount),
      ptrEnum(dragStartBehavior),
      ptrEnum(keyboardDismissBehavior),
      ptrStr(restorationId),
      ptrEnum(clipBehavior),
      ptrEnum(hitTestBehavior));
  }
  MemorySegment listViewBuilder(Optional<Axis> scrollDirection, Optional<Boolean> reverse, Optional<Boolean> primary, Optional<Boolean> shrinkWrap, Optional<EdgeInsetsGeometry> padding, OptionalDouble itemExtent, Optional<Widget> prototypeItem, BiFunction<BuildContext, Integer, Widget> itemBuilder, OptionalInt itemCount, Optional<Boolean> addAutomaticKeepAlives, Optional<Boolean> addRepaintBoundaries, Optional<Boolean> addSemanticIndexes, OptionalDouble cacheExtent, OptionalInt semanticChildCount, Optional<DragStartBehavior> dragStartBehavior, Optional<ScrollViewKeyboardDismissBehavior> keyboardDismissBehavior, Optional<String> restorationId, Optional<Clip> clipBehavior, Optional<HitTestBehavior> hitTestBehavior) {
    var st = WidgetFactories.listView(factories);
    var fn = WidgetFactories.ListViewSt.builder(st);
    return WidgetFactories.ListViewSt.builder.invoke(fn, arena, ptrEnum(scrollDirection),
      ptrBool(reverse),
      ptrBool(primary),
      ptrBool(shrinkWrap),
      ptrObj(padding),
      ptr(itemExtent),
      ptrObj(prototypeItem),
      ptrNullableIndexedWidgetBuilderFn(itemBuilder),
      ptr(itemCount),
      ptrBool(addAutomaticKeepAlives),
      ptrBool(addRepaintBoundaries),
      ptrBool(addSemanticIndexes),
      ptr(cacheExtent),
      ptr(semanticChildCount),
      ptrEnum(dragStartBehavior),
      ptrEnum(keyboardDismissBehavior),
      ptrStr(restorationId),
      ptrEnum(clipBehavior),
      ptrEnum(hitTestBehavior));
  }
  MemorySegment listViewSeparated(Optional<Axis> scrollDirection, Optional<Boolean> reverse, Optional<Boolean> primary, Optional<Boolean> shrinkWrap, Optional<EdgeInsetsGeometry> padding, BiFunction<BuildContext, Integer, Widget> itemBuilder, BiFunction<BuildContext, Integer, Widget> separatorBuilder, int itemCount, Optional<Boolean> addAutomaticKeepAlives, Optional<Boolean> addRepaintBoundaries, Optional<Boolean> addSemanticIndexes, OptionalDouble cacheExtent, Optional<DragStartBehavior> dragStartBehavior, Optional<ScrollViewKeyboardDismissBehavior> keyboardDismissBehavior, Optional<String> restorationId, Optional<Clip> clipBehavior, Optional<HitTestBehavior> hitTestBehavior) {
    var st = WidgetFactories.listView(factories);
    var fn = WidgetFactories.ListViewSt.separated(st);
    return WidgetFactories.ListViewSt.separated.invoke(fn, arena, ptrEnum(scrollDirection),
      ptrBool(reverse),
      ptrBool(primary),
      ptrBool(shrinkWrap),
      ptrObj(padding),
      ptrNullableIndexedWidgetBuilderFn(itemBuilder),
      ptrIndexedWidgetBuilderFn(separatorBuilder),
      itemCount,
      ptrBool(addAutomaticKeepAlives),
      ptrBool(addRepaintBoundaries),
      ptrBool(addSemanticIndexes),
      ptr(cacheExtent),
      ptrEnum(dragStartBehavior),
      ptrEnum(keyboardDismissBehavior),
      ptrStr(restorationId),
      ptrEnum(clipBehavior),
      ptrEnum(hitTestBehavior));
  }

  MemorySegment gridViewCount(Optional<Axis> scrollDirection, Optional<Boolean> reverse, Optional<Boolean> primary, Optional<Boolean> shrinkWrap, Optional<EdgeInsetsGeometry> padding, int crossAxisCount, OptionalDouble mainAxisSpacing, OptionalDouble crossAxisSpacing, OptionalDouble childAspectRatio, Optional<Boolean> addAutomaticKeepAlives, Optional<Boolean> addRepaintBoundaries, Optional<Boolean> addSemanticIndexes, OptionalDouble cacheExtent, Optional<List<Widget>> children, OptionalInt semanticChildCount, Optional<DragStartBehavior> dragStartBehavior, Optional<ScrollViewKeyboardDismissBehavior> keyboardDismissBehavior, Optional<String> restorationId, Optional<Clip> clipBehavior, Optional<HitTestBehavior> hitTestBehavior) {
    var st = WidgetFactories.gridView(factories);
    var fn = WidgetFactories.GridViewSt.count(st);
    return WidgetFactories.GridViewSt.count.invoke(fn, arena, ptrEnum(scrollDirection),
      ptrBool(reverse),
      ptrBool(primary),
      ptrBool(shrinkWrap),
      ptrObj(padding),
      crossAxisCount,
      ptr(mainAxisSpacing),
      ptr(crossAxisSpacing),
      ptr(childAspectRatio),
      ptrBool(addAutomaticKeepAlives),
      ptrBool(addRepaintBoundaries),
      ptrBool(addSemanticIndexes),
      ptr(cacheExtent),
      ptrList(children),
      ptr(semanticChildCount),
      ptrEnum(dragStartBehavior),
      ptrEnum(keyboardDismissBehavior),
      ptrStr(restorationId),
      ptrEnum(clipBehavior),
      ptrEnum(hitTestBehavior));
  }
  MemorySegment gridViewExtent(Optional<Axis> scrollDirection, Optional<Boolean> reverse, Optional<Boolean> primary, Optional<Boolean> shrinkWrap, Optional<EdgeInsetsGeometry> padding, double maxCrossAxisExtent, OptionalDouble mainAxisSpacing, OptionalDouble crossAxisSpacing, OptionalDouble childAspectRatio, Optional<Boolean> addAutomaticKeepAlives, Optional<Boolean> addRepaintBoundaries, Optional<Boolean> addSemanticIndexes, OptionalDouble cacheExtent, Optional<List<Widget>> children, OptionalInt semanticChildCount, Optional<DragStartBehavior> dragStartBehavior, Optional<ScrollViewKeyboardDismissBehavior> keyboardDismissBehavior, Optional<String> restorationId, Optional<Clip> clipBehavior, Optional<HitTestBehavior> hitTestBehavior) {
    var st = WidgetFactories.gridView(factories);
    var fn = WidgetFactories.GridViewSt.extent(st);
    return WidgetFactories.GridViewSt.extent.invoke(fn, arena, ptrEnum(scrollDirection),
      ptrBool(reverse),
      ptrBool(primary),
      ptrBool(shrinkWrap),
      ptrObj(padding),
      maxCrossAxisExtent,
      ptr(mainAxisSpacing),
      ptr(crossAxisSpacing),
      ptr(childAspectRatio),
      ptrBool(addAutomaticKeepAlives),
      ptrBool(addRepaintBoundaries),
      ptrBool(addSemanticIndexes),
      ptr(cacheExtent),
      ptrList(children),
      ptr(semanticChildCount),
      ptrEnum(dragStartBehavior),
      ptrEnum(keyboardDismissBehavior),
      ptrStr(restorationId),
      ptrEnum(clipBehavior),
      ptrEnum(hitTestBehavior));
  }

  MemorySegment pageViewPageView(Optional<Axis> scrollDirection, Optional<Boolean> reverse, Optional<Boolean> pageSnapping, Optional<Consumer<Integer>> onPageChanged, Optional<List<Widget>> children, Optional<DragStartBehavior> dragStartBehavior, Optional<Boolean> allowImplicitScrolling, Optional<String> restorationId, Optional<Clip> clipBehavior, Optional<HitTestBehavior> hitTestBehavior, Optional<Boolean> padEnds) {
    var st = WidgetFactories.pageView(factories);
    var fn = WidgetFactories.PageViewSt.pageView(st);
    return WidgetFactories.PageViewSt.pageView.invoke(fn, arena, ptrEnum(scrollDirection),
      ptrBool(reverse),
      ptrBool(pageSnapping),
      onPageChanged.isPresent() ? ptrHolder(ptrValueChangedForIntFn(onPageChanged.get())) : MemorySegment.NULL,
      ptrList(children),
      ptrEnum(dragStartBehavior),
      ptrBool(allowImplicitScrolling),
      ptrStr(restorationId),
      ptrEnum(clipBehavior),
      ptrEnum(hitTestBehavior),
      ptrBool(padEnds));
  }
  MemorySegment pageViewBuilder(Optional<Axis> scrollDirection, Optional<Boolean> reverse, Optional<Boolean> pageSnapping, Optional<Consumer<Integer>> onPageChanged, BiFunction<BuildContext, Integer, Widget> itemBuilder, OptionalInt itemCount, Optional<DragStartBehavior> dragStartBehavior, Optional<Boolean> allowImplicitScrolling, Optional<String> restorationId, Optional<Clip> clipBehavior, Optional<HitTestBehavior> hitTestBehavior, Optional<Boolean> padEnds) {
    var st = WidgetFactories.pageView(factories);
    var fn = WidgetFactories.PageViewSt.builder(st);
    return WidgetFactories.PageViewSt.builder.invoke(fn, arena, ptrEnum(scrollDirection),
      ptrBool(reverse),
      ptrBool(pageSnapping),
      onPageChanged.isPresent() ? ptrHolder(ptrValueChangedForIntFn(onPageChanged.get())) : MemorySegment.NULL,
      ptrNullableIndexedWidgetBuilderFn(itemBuilder),
      ptr(itemCount),
      ptrEnum(dragStartBehavior),
      ptrBool(allowImplicitScrolling),
      ptrStr(restorationId),
      ptrEnum(clipBehavior),
      ptrEnum(hitTestBehavior),
      ptrBool(padEnds));
  }

  MemorySegment listWheelScrollViewListWheelScrollView(OptionalDouble diameterRatio, OptionalDouble perspective, OptionalDouble offAxisFraction, Optional<Boolean> useMagnifier, OptionalDouble magnification, OptionalDouble overAndUnderCenterOpacity, double itemExtent, OptionalDouble squeeze, Optional<Consumer<Integer>> onSelectedItemChanged, Optional<Boolean> renderChildrenOutsideViewport, Optional<Clip> clipBehavior, Optional<HitTestBehavior> hitTestBehavior, Optional<String> restorationId, Optional<DragStartBehavior> dragStartBehavior, Optional<ChangeReportingBehavior> changeReportingBehavior, List<Widget> children) {
    var st = WidgetFactories.listWheelScrollView(factories);
    var fn = WidgetFactories.ListWheelScrollViewSt.listWheelScrollView(st);
    return WidgetFactories.ListWheelScrollViewSt.listWheelScrollView.invoke(fn, arena, ptr(diameterRatio),
      ptr(perspective),
      ptr(offAxisFraction),
      ptrBool(useMagnifier),
      ptr(magnification),
      ptr(overAndUnderCenterOpacity),
      itemExtent,
      ptr(squeeze),
      onSelectedItemChanged.isPresent() ? ptrHolder(ptrValueChangedForIntFn(onSelectedItemChanged.get())) : MemorySegment.NULL,
      ptrBool(renderChildrenOutsideViewport),
      ptrEnum(clipBehavior),
      ptrEnum(hitTestBehavior),
      ptrStr(restorationId),
      ptrEnum(dragStartBehavior),
      ptrEnum(changeReportingBehavior),
      ptrList(children));
  }

  MemorySegment animatedSizeAnimatedSize(Optional<Widget> child, Optional<AlignmentGeometry> alignment, Optional<Curve> curve, Duration duration, Optional<Duration> reverseDuration, Optional<Clip> clipBehavior, Optional<Runnable> onEnd) {
    var st = WidgetFactories.animatedSize(factories);
    var fn = WidgetFactories.AnimatedSizeSt.animatedSize(st);
    return WidgetFactories.AnimatedSizeSt.animatedSize.invoke(fn, arena, ptrObj(child),
      ptrObj(alignment),
      ptrObj(curve),
      duration.build().getId(),
      ptrObj(reverseDuration),
      ptrEnum(clipBehavior),
      onEnd.isPresent() ? ptrHolder(ptrVoidCallbackFn(onEnd.get())) : MemorySegment.NULL);
  }

  MemorySegment animatedScaleAnimatedScale(Optional<Widget> child, double scale, Optional<Alignment> alignment, Optional<FilterQuality> filterQuality, Optional<Curve> curve, Duration duration, Optional<Runnable> onEnd) {
    var st = WidgetFactories.animatedScale(factories);
    var fn = WidgetFactories.AnimatedScaleSt.animatedScale(st);
    return WidgetFactories.AnimatedScaleSt.animatedScale.invoke(fn, arena, ptrObj(child),
      scale,
      ptrObj(alignment),
      ptrEnum(filterQuality),
      ptrObj(curve),
      duration.build().getId(),
      onEnd.isPresent() ? ptrHolder(ptrVoidCallbackFn(onEnd.get())) : MemorySegment.NULL);
  }

  MemorySegment animatedRotationAnimatedRotation(Optional<Widget> child, double turns, Optional<Alignment> alignment, Optional<FilterQuality> filterQuality, Optional<Curve> curve, Duration duration, Optional<Runnable> onEnd) {
    var st = WidgetFactories.animatedRotation(factories);
    var fn = WidgetFactories.AnimatedRotationSt.animatedRotation(st);
    return WidgetFactories.AnimatedRotationSt.animatedRotation.invoke(fn, arena, ptrObj(child),
      turns,
      ptrObj(alignment),
      ptrEnum(filterQuality),
      ptrObj(curve),
      duration.build().getId(),
      onEnd.isPresent() ? ptrHolder(ptrVoidCallbackFn(onEnd.get())) : MemorySegment.NULL);
  }

  MemorySegment animatedSlideAnimatedSlide(Optional<Widget> child, Offset offset, Optional<Curve> curve, Duration duration, Optional<Runnable> onEnd) {
    var st = WidgetFactories.animatedSlide(factories);
    var fn = WidgetFactories.AnimatedSlideSt.animatedSlide(st);
    return WidgetFactories.AnimatedSlideSt.animatedSlide.invoke(fn, arena, ptrObj(child),
      offset.build().getId(),
      ptrObj(curve),
      duration.build().getId(),
      onEnd.isPresent() ? ptrHolder(ptrVoidCallbackFn(onEnd.get())) : MemorySegment.NULL);
  }

  MemorySegment animatedCrossFadeAnimatedCrossFade(Widget firstChild, Widget secondChild, Optional<Curve> firstCurve, Optional<Curve> secondCurve, Optional<Curve> sizeCurve, Optional<AlignmentGeometry> alignment, CrossFadeState crossFadeState, Duration duration, Optional<Duration> reverseDuration, Optional<Boolean> excludeBottomFocus) {
    var st = WidgetFactories.animatedCrossFade(factories);
    var fn = WidgetFactories.AnimatedCrossFadeSt.animatedCrossFade(st);
    return WidgetFactories.AnimatedCrossFadeSt.animatedCrossFade.invoke(fn, arena, firstChild.build().getId(),
      secondChild.build().getId(),
      ptrObj(firstCurve),
      ptrObj(secondCurve),
      ptrObj(sizeCurve),
      ptrObj(alignment),
      crossFadeState.ordinal(),
      duration.build().getId(),
      ptrObj(reverseDuration),
      ptrBool(excludeBottomFocus));
  }

  MemorySegment slideTransitionSlideTransition(Animation position, Optional<Boolean> transformHitTests, Optional<TextDirection> textDirection, Optional<Widget> child) {
    var st = WidgetFactories.slideTransition(factories);
    var fn = WidgetFactories.SlideTransitionSt.slideTransition(st);
    return WidgetFactories.SlideTransitionSt.slideTransition.invoke(fn, arena, position.build().getId(),
      ptrBool(transformHitTests),
      ptrEnum(textDirection),
      ptrObj(child));
  }

  MemorySegment sizeTransitionSizeTransition(Optional<Axis> axis, Animation sizeFactor, OptionalDouble axisAlignment, OptionalDouble fixedCrossAxisSizeFactor, Optional<Widget> child) {
    var st = WidgetFactories.sizeTransition(factories);
    var fn = WidgetFactories.SizeTransitionSt.sizeTransition(st);
    return WidgetFactories.SizeTransitionSt.sizeTransition.invoke(fn, arena, ptrEnum(axis),
      sizeFactor.build().getId(),
      ptr(axisAlignment),
      ptr(fixedCrossAxisSizeFactor),
      ptrObj(child));
  }

  MemorySegment indexedStackIndexedStack(Optional<AlignmentGeometry> alignment, Optional<TextDirection> textDirection, Optional<Clip> clipBehavior, Optional<StackFit> sizing, OptionalInt index, Optional<List<Widget>> children) {
    var st = WidgetFactories.indexedStack(factories);
    var fn = WidgetFactories.IndexedStackSt.indexedStack(st);
    return WidgetFactories.IndexedStackSt.indexedStack.invoke(fn, arena, ptrObj(alignment),
      ptrEnum(textDirection),
      ptrEnum(clipBehavior),
      ptrEnum(sizing),
      ptr(index),
      ptrList(children));
  }

  MemorySegment interactiveViewerInteractiveViewer(Optional<Clip> clipBehavior, Optional<PanAxis> panAxis, Optional<EdgeInsets> boundaryMargin, Optional<Boolean> constrained, OptionalDouble maxScale, OptionalDouble minScale, OptionalDouble interactionEndFrictionCoefficient, Optional<Consumer<ScaleEndDetails>> onInteractionEnd, Optional<Consumer<ScaleStartDetails>> onInteractionStart, Optional<Consumer<ScaleUpdateDetails>> onInteractionUpdate, Optional<Boolean> panEnabled, Optional<Boolean> scaleEnabled, OptionalDouble scaleFactor, Optional<Alignment> alignment, Optional<Boolean> trackpadScrollCausesScale, Widget child) {
    var st = WidgetFactories.interactiveViewer(factories);
    var fn = WidgetFactories.InteractiveViewerSt.interactiveViewer(st);
    return WidgetFactories.InteractiveViewerSt.interactiveViewer.invoke(fn, arena, ptrEnum(clipBehavior),
      ptrEnum(panAxis),
      ptrObj(boundaryMargin),
      ptrBool(constrained),
      ptr(maxScale),
      ptr(minScale),
      ptr(interactionEndFrictionCoefficient),
      onInteractionEnd.isPresent() ? ptrHolder(ptrGestureScaleEndCallbackFn(onInteractionEnd.get())) : MemorySegment.NULL,
      onInteractionStart.isPresent() ? ptrHolder(ptrGestureScaleStartCallbackFn(onInteractionStart.get())) : MemorySegment.NULL,
      onInteractionUpdate.isPresent() ? ptrHolder(ptrGestureScaleUpdateCallbackFn(onInteractionUpdate.get())) : MemorySegment.NULL,
      ptrBool(panEnabled),
      ptrBool(scaleEnabled),
      ptr(scaleFactor),
      ptrObj(alignment),
      ptrBool(trackpadScrollCausesScale),
      child.build().getId());
  }

  <T extends NativeObj> MemorySegment draggableDraggable(Widget child, Widget feedback, Optional<NativeObj> data, Optional<Axis> axis, Optional<Widget> childWhenDragging, Optional<Offset> feedbackOffset, Optional<TriFunction<Draggable, BuildContext, Offset, Offset>> dragAnchorStrategy, Optional<Axis> affinity, OptionalInt maxSimultaneousDrags, Optional<Runnable> onDragStarted, Optional<Consumer<DragUpdateDetails>> onDragUpdate, Optional<BiConsumer<Velocity, Offset>> onDraggableCanceled, Optional<Consumer<DraggableDetails>> onDragEnd, Optional<Runnable> onDragCompleted, Optional<Boolean> ignoringFeedbackSemantics, Optional<Boolean> ignoringFeedbackPointer, Optional<Boolean> rootOverlay, Optional<HitTestBehavior> hitTestBehavior, Optional<Function<Integer, Boolean>> allowedButtonsFilter) {
    var st = WidgetFactories.draggable(factories);
    var fn = WidgetFactories.DraggableSt.draggable(st);
    return WidgetFactories.DraggableSt.draggable.invoke(fn, arena, child.build().getId(),
      feedback.build().getId(),
      ptrObj(data),
      ptrEnum(axis),
      ptrObj(childWhenDragging),
      ptrObj(feedbackOffset),
      dragAnchorStrategy.isPresent() ? ptrHolder(ptrDragAnchorStrategyFn(dragAnchorStrategy.get())) : MemorySegment.NULL,
      ptrEnum(affinity),
      ptr(maxSimultaneousDrags),
      onDragStarted.isPresent() ? ptrHolder(ptrVoidCallbackFn(onDragStarted.get())) : MemorySegment.NULL,
      onDragUpdate.isPresent() ? ptrHolder(ptrDragUpdateCallbackFn(onDragUpdate.get())) : MemorySegment.NULL,
      onDraggableCanceled.isPresent() ? ptrHolder(ptrDraggableCanceledCallbackFn(onDraggableCanceled.get())) : MemorySegment.NULL,
      onDragEnd.isPresent() ? ptrHolder(ptrDragEndCallbackFn(onDragEnd.get())) : MemorySegment.NULL,
      onDragCompleted.isPresent() ? ptrHolder(ptrVoidCallbackFn(onDragCompleted.get())) : MemorySegment.NULL,
      ptrBool(ignoringFeedbackSemantics),
      ptrBool(ignoringFeedbackPointer),
      ptrBool(rootOverlay),
      ptrEnum(hitTestBehavior),
      allowedButtonsFilter.isPresent() ? ptrHolder(ptrAllowedButtonsFilterFn(allowedButtonsFilter.get())) : MemorySegment.NULL);
  }

  <T extends NativeObj> MemorySegment dragTargetDragTarget(TriFunction<BuildContext, List<NativeObj>, List<NativeObj>, Widget> builder, Optional<Function<NativeObj, Boolean>> onWillAccept, Optional<Function<DragTargetDetails, Boolean>> onWillAcceptWithDetails, Optional<Consumer<NativeObj>> onAccept, Optional<Consumer<DragTargetDetails>> onAcceptWithDetails, Optional<Consumer<NativeObj>> onLeave, Optional<Consumer<DragTargetDetails>> onMove, Optional<HitTestBehavior> hitTestBehavior) {
    var st = WidgetFactories.dragTarget(factories);
    var fn = WidgetFactories.DragTargetSt.dragTarget(st);
    return WidgetFactories.DragTargetSt.dragTarget.invoke(fn, arena, ptrDragTargetBuilderForTFn(builder),
      onWillAccept.isPresent() ? ptrHolder(ptrDragTargetWillAcceptForTFn(onWillAccept.get())) : MemorySegment.NULL,
      onWillAcceptWithDetails.isPresent() ? ptrHolder(ptrDragTargetWillAcceptWithDetailsForTFn(onWillAcceptWithDetails.get())) : MemorySegment.NULL,
      onAccept.isPresent() ? ptrHolder(ptrDragTargetAcceptForTFn(onAccept.get())) : MemorySegment.NULL,
      onAcceptWithDetails.isPresent() ? ptrHolder(ptrDragTargetAcceptWithDetailsForTFn(onAcceptWithDetails.get())) : MemorySegment.NULL,
      onLeave.isPresent() ? ptrHolder(ptrDragTargetLeaveForTFn(onLeave.get())) : MemorySegment.NULL,
      onMove.isPresent() ? ptrHolder(ptrDragTargetMoveForTFn(onMove.get())) : MemorySegment.NULL,
      ptrEnum(hitTestBehavior));
  }

  MemorySegment heroHero(NativeObj tag, Optional<PentaFunction<BuildContext, Animation, HeroFlightDirection, BuildContext, BuildContext, Widget>> flightShuttleBuilder, Optional<Boolean> transitionOnUserGestures, Widget child) {
    var st = WidgetFactories.hero(factories);
    var fn = WidgetFactories.HeroSt.hero(st);
    return WidgetFactories.HeroSt.hero.invoke(fn, arena, tag.build().getId(),
      flightShuttleBuilder.isPresent() ? ptrHolder(ptrHeroFlightShuttleBuilderFn(flightShuttleBuilder.get())) : MemorySegment.NULL,
      ptrBool(transitionOnUserGestures),
      child.build().getId());
  }

  MemorySegment animatedSwitcherAnimatedSwitcher(Optional<Widget> child, Duration duration, Optional<Duration> reverseDuration, Optional<Curve> switchInCurve, Optional<Curve> switchOutCurve, Optional<BiFunction<Widget, Animation, Widget>> transitionBuilder, Optional<BiFunction<Widget, List<Widget>, Widget>> layoutBuilder) {
    var st = WidgetFactories.animatedSwitcher(factories);
    var fn = WidgetFactories.AnimatedSwitcherSt.animatedSwitcher(st);
    return WidgetFactories.AnimatedSwitcherSt.animatedSwitcher.invoke(fn, arena, ptrObj(child),
      duration.build().getId(),
      ptrObj(reverseDuration),
      ptrObj(switchInCurve),
      ptrObj(switchOutCurve),
      transitionBuilder.isPresent() ? ptrHolder(ptrAnimatedSwitcherTransitionBuilderFn(transitionBuilder.get())) : MemorySegment.NULL,
      layoutBuilder.isPresent() ? ptrHolder(ptrAnimatedSwitcherLayoutBuilderFn(layoutBuilder.get())) : MemorySegment.NULL);
  }
  int animatedSwitcherDefaultTransitionBuilder(Widget child, Animation animation) {
    var st = WidgetFactories.animatedSwitcher(factories);
    var fn = WidgetFactories.AnimatedSwitcherSt.defaultTransitionBuilder(st);
    return WidgetFactories.AnimatedSwitcherSt.defaultTransitionBuilder.invoke(fn, child.build().getId(),
      animation.build().getId());
  }
  int animatedSwitcherDefaultLayoutBuilder(Widget currentChild, List<Widget> previousChildren) {
    var st = WidgetFactories.animatedSwitcher(factories);
    var fn = WidgetFactories.AnimatedSwitcherSt.defaultLayoutBuilder(st);
    return WidgetFactories.AnimatedSwitcherSt.defaultLayoutBuilder.invoke(fn, currentChild != null ? currentChild.build().getId() : null,
      ptrList(previousChildren));
  }

  int colorFilterMode(Color color, BlendMode blendMode) {
    var st = WidgetFactories.colorFilter(factories);
    var fn = WidgetFactories.ColorFilterSt.mode(st);
    return WidgetFactories.ColorFilterSt.mode.invoke(fn, color.build().getId(),
      blendMode.ordinal());
  }
  int colorFilterLinearToSrgbGamma() {
    var st = WidgetFactories.colorFilter(factories);
    var fn = WidgetFactories.ColorFilterSt.linearToSrgbGamma(st);
    return WidgetFactories.ColorFilterSt.linearToSrgbGamma.invoke(fn);
  }
  int colorFilterSrgbToLinearGamma() {
    var st = WidgetFactories.colorFilter(factories);
    var fn = WidgetFactories.ColorFilterSt.srgbToLinearGamma(st);
    return WidgetFactories.ColorFilterSt.srgbToLinearGamma.invoke(fn);
  }

  MemorySegment backdropFilterBackdropFilter(ImageFilter filter, Optional<Widget> child, Optional<BlendMode> blendMode, Optional<Boolean> enabled) {
    var st = WidgetFactories.backdropFilter(factories);
    var fn = WidgetFactories.BackdropFilterSt.backdropFilter(st);
    return WidgetFactories.BackdropFilterSt.backdropFilter.invoke(fn, arena, filter.build().getId(),
      ptrObj(child),
      ptrEnum(blendMode),
      ptrBool(enabled));
  }
  MemorySegment backdropFilterGrouped(ImageFilter filter, Optional<Widget> child, Optional<BlendMode> blendMode, Optional<Boolean> enabled) {
    var st = WidgetFactories.backdropFilter(factories);
    var fn = WidgetFactories.BackdropFilterSt.grouped(st);
    return WidgetFactories.BackdropFilterSt.grouped.invoke(fn, arena, filter.build().getId(),
      ptrObj(child),
      ptrEnum(blendMode),
      ptrBool(enabled));
  }

  int imageFilterBlur(OptionalDouble sigmaX, OptionalDouble sigmaY, Optional<TileMode> tileMode) {
    var st = WidgetFactories.imageFilter(factories);
    var fn = WidgetFactories.ImageFilterSt.blur(st);
    return WidgetFactories.ImageFilterSt.blur.invoke(fn, ptr(sigmaX),
      ptr(sigmaY),
      ptrEnum(tileMode));
  }
  int imageFilterDilate(OptionalDouble radiusX, OptionalDouble radiusY) {
    var st = WidgetFactories.imageFilter(factories);
    var fn = WidgetFactories.ImageFilterSt.dilate(st);
    return WidgetFactories.ImageFilterSt.dilate.invoke(fn, ptr(radiusX),
      ptr(radiusY));
  }
  int imageFilterErode(OptionalDouble radiusX, OptionalDouble radiusY) {
    var st = WidgetFactories.imageFilter(factories);
    var fn = WidgetFactories.ImageFilterSt.erode(st);
    return WidgetFactories.ImageFilterSt.erode.invoke(fn, ptr(radiusX),
      ptr(radiusY));
  }
  int imageFilterCompose(ImageFilter outer, ImageFilter inner) {
    var st = WidgetFactories.imageFilter(factories);
    var fn = WidgetFactories.ImageFilterSt.compose(st);
    return WidgetFactories.ImageFilterSt.compose.invoke(fn, outer.build().getId(),
      inner.build().getId());
  }

  MemorySegment colorFilteredColorFiltered(ColorFilter colorFilter, Optional<Widget> child) {
    var st = WidgetFactories.colorFiltered(factories);
    var fn = WidgetFactories.ColorFilteredSt.colorFiltered(st);
    return WidgetFactories.ColorFilteredSt.colorFiltered.invoke(fn, arena, colorFilter.build().getId(),
      ptrObj(child));
  }

  MemorySegment imageFilteredImageFiltered(ImageFilter imageFilter, Optional<Widget> child, Optional<Boolean> enabled) {
    var st = WidgetFactories.imageFiltered(factories);
    var fn = WidgetFactories.ImageFilteredSt.imageFiltered(st);
    return WidgetFactories.ImageFilteredSt.imageFiltered.invoke(fn, arena, imageFilter.build().getId(),
      ptrObj(child),
      ptrBool(enabled));
  }

  MemorySegment heroModeHeroMode(Widget child, Optional<Boolean> enabled) {
    var st = WidgetFactories.heroMode(factories);
    var fn = WidgetFactories.HeroModeSt.heroMode(st);
    return WidgetFactories.HeroModeSt.heroMode.invoke(fn, arena, child.build().getId(),
      ptrBool(enabled));
  }

  MemorySegment blockSemanticsBlockSemantics(Optional<Boolean> blocking, Optional<Widget> child) {
    var st = WidgetFactories.blockSemantics(factories);
    var fn = WidgetFactories.BlockSemanticsSt.blockSemantics(st);
    return WidgetFactories.BlockSemanticsSt.blockSemantics.invoke(fn, arena, ptrBool(blocking),
      ptrObj(child));
  }

  MemorySegment mergeSemanticsMergeSemantics(Optional<Widget> child) {
    var st = WidgetFactories.mergeSemantics(factories);
    var fn = WidgetFactories.MergeSemanticsSt.mergeSemantics(st);
    return WidgetFactories.MergeSemanticsSt.mergeSemantics.invoke(fn, arena, ptrObj(child));
  }

  MemorySegment excludeSemanticsExcludeSemantics(Optional<Boolean> excluding, Optional<Widget> child) {
    var st = WidgetFactories.excludeSemantics(factories);
    var fn = WidgetFactories.ExcludeSemanticsSt.excludeSemantics(st);
    return WidgetFactories.ExcludeSemanticsSt.excludeSemantics.invoke(fn, arena, ptrBool(excluding),
      ptrObj(child));
  }

  MemorySegment indexedSemanticsIndexedSemantics(int index, Optional<Widget> child) {
    var st = WidgetFactories.indexedSemantics(factories);
    var fn = WidgetFactories.IndexedSemanticsSt.indexedSemantics(st);
    return WidgetFactories.IndexedSemanticsSt.indexedSemantics.invoke(fn, arena, index,
      ptrObj(child));
  }

  MemorySegment automaticKeepAliveAutomaticKeepAlive(Widget child) {
    var st = WidgetFactories.automaticKeepAlive(factories);
    var fn = WidgetFactories.AutomaticKeepAliveSt.automaticKeepAlive(st);
    return WidgetFactories.AutomaticKeepAliveSt.automaticKeepAlive.invoke(fn, arena, child.build().getId());
  }

  MemorySegment sliverToBoxAdapterSliverToBoxAdapter(Optional<Widget> child) {
    var st = WidgetFactories.sliverToBoxAdapter(factories);
    var fn = WidgetFactories.SliverToBoxAdapterSt.sliverToBoxAdapter(st);
    return WidgetFactories.SliverToBoxAdapterSt.sliverToBoxAdapter.invoke(fn, arena, ptrObj(child));
  }

  MemorySegment listBodyListBody(Optional<Axis> mainAxis, Optional<Boolean> reverse, Optional<List<Widget>> children) {
    var st = WidgetFactories.listBody(factories);
    var fn = WidgetFactories.ListBodySt.listBody(st);
    return WidgetFactories.ListBodySt.listBody.invoke(fn, arena, ptrEnum(mainAxis),
      ptrBool(reverse),
      ptrList(children));
  }

  MemorySegment gridPaperGridPaper(Optional<Color> color, OptionalDouble interval, OptionalInt divisions, OptionalInt subdivisions, Optional<Widget> child) {
    var st = WidgetFactories.gridPaper(factories);
    var fn = WidgetFactories.GridPaperSt.gridPaper(st);
    return WidgetFactories.GridPaperSt.gridPaper.invoke(fn, arena, ptrObj(color),
      ptr(interval),
      ptr(divisions),
      ptr(subdivisions),
      ptrObj(child));
  }

  MemorySegment navigationToolbarNavigationToolbar(Optional<Widget> leading, Optional<Widget> middle, Optional<Widget> trailing, Optional<Boolean> centerMiddle, OptionalDouble middleSpacing) {
    var st = WidgetFactories.navigationToolbar(factories);
    var fn = WidgetFactories.NavigationToolbarSt.navigationToolbar(st);
    return WidgetFactories.NavigationToolbarSt.navigationToolbar.invoke(fn, arena, ptrObj(leading),
      ptrObj(middle),
      ptrObj(trailing),
      ptrBool(centerMiddle),
      ptr(middleSpacing));
  }

  MemorySegment checkedModeBannerCheckedModeBanner(Widget child) {
    var st = WidgetFactories.checkedModeBanner(factories);
    var fn = WidgetFactories.CheckedModeBannerSt.checkedModeBanner(st);
    return WidgetFactories.CheckedModeBannerSt.checkedModeBanner.invoke(fn, arena, child.build().getId());
  }

  MemorySegment ignoreBaselineIgnoreBaseline(Optional<Widget> child) {
    var st = WidgetFactories.ignoreBaseline(factories);
    var fn = WidgetFactories.IgnoreBaselineSt.ignoreBaseline(st);
    return WidgetFactories.IgnoreBaselineSt.ignoreBaseline.invoke(fn, arena, ptrObj(child));
  }

  MemorySegment tickerModeTickerMode(boolean enabled, Widget child) {
    var st = WidgetFactories.tickerMode(factories);
    var fn = WidgetFactories.TickerModeSt.tickerMode(st);
    return WidgetFactories.TickerModeSt.tickerMode.invoke(fn, arena, (enabled ? 1 : 0),
      child.build().getId());
  }
  int tickerModeOf(BuildContext context) {
    var st = WidgetFactories.tickerMode(factories);
    var fn = WidgetFactories.TickerModeSt.of(st);
    return WidgetFactories.TickerModeSt.of.invoke(fn, context.build().getId());
  }
  int tickerModeGetNotifier(BuildContext context) {
    var st = WidgetFactories.tickerMode(factories);
    var fn = WidgetFactories.TickerModeSt.getNotifier(st);
    return WidgetFactories.TickerModeSt.getNotifier.invoke(fn, context.build().getId());
  }

  MemorySegment tapRegionSurfaceTapRegionSurface(Widget child) {
    var st = WidgetFactories.tapRegionSurface(factories);
    var fn = WidgetFactories.TapRegionSurfaceSt.tapRegionSurface(st);
    return WidgetFactories.TapRegionSurfaceSt.tapRegionSurface.invoke(fn, arena, child.build().getId());
  }

  MemorySegment lookupBoundaryLookupBoundary(Widget child) {
    var st = WidgetFactories.lookupBoundary(factories);
    var fn = WidgetFactories.LookupBoundarySt.lookupBoundary(st);
    return WidgetFactories.LookupBoundarySt.lookupBoundary.invoke(fn, arena, child.build().getId());
  }
  <T extends InheritedWidget> int lookupBoundaryDependOnInheritedWidgetOfExactType(BuildContext context, Optional<NativeObj> aspect) {
    var st = WidgetFactories.lookupBoundary(factories);
    var fn = WidgetFactories.LookupBoundarySt.dependOnInheritedWidgetOfExactType(st);
    return WidgetFactories.LookupBoundarySt.dependOnInheritedWidgetOfExactType.invoke(fn, context.build().getId(),
      ptrObj(aspect));
  }
  <T extends Widget> int lookupBoundaryFindAncestorWidgetOfExactType(BuildContext context) {
    var st = WidgetFactories.lookupBoundary(factories);
    var fn = WidgetFactories.LookupBoundarySt.findAncestorWidgetOfExactType(st);
    return WidgetFactories.LookupBoundarySt.findAncestorWidgetOfExactType.invoke(fn, context.build().getId());
  }
  <T extends State<StatefulWidget>> int lookupBoundaryFindAncestorStateOfType(BuildContext context) {
    var st = WidgetFactories.lookupBoundary(factories);
    var fn = WidgetFactories.LookupBoundarySt.findAncestorStateOfType(st);
    return WidgetFactories.LookupBoundarySt.findAncestorStateOfType.invoke(fn, context.build().getId());
  }
  <T extends State<StatefulWidget>> int lookupBoundaryFindRootAncestorStateOfType(BuildContext context) {
    var st = WidgetFactories.lookupBoundary(factories);
    var fn = WidgetFactories.LookupBoundarySt.findRootAncestorStateOfType(st);
    return WidgetFactories.LookupBoundarySt.findRootAncestorStateOfType.invoke(fn, context.build().getId());
  }
  <T extends RenderObject> int lookupBoundaryFindAncestorRenderObjectOfType(BuildContext context) {
    var st = WidgetFactories.lookupBoundary(factories);
    var fn = WidgetFactories.LookupBoundarySt.findAncestorRenderObjectOfType(st);
    return WidgetFactories.LookupBoundarySt.findAncestorRenderObjectOfType.invoke(fn, context.build().getId());
  }
  int lookupBoundaryDebugIsHidingAncestorWidgetOfExactType(BuildContext context) {
    var st = WidgetFactories.lookupBoundary(factories);
    var fn = WidgetFactories.LookupBoundarySt.debugIsHidingAncestorWidgetOfExactType(st);
    return WidgetFactories.LookupBoundarySt.debugIsHidingAncestorWidgetOfExactType.invoke(fn, context.build().getId());
  }
  int lookupBoundaryDebugIsHidingAncestorStateOfType(BuildContext context) {
    var st = WidgetFactories.lookupBoundary(factories);
    var fn = WidgetFactories.LookupBoundarySt.debugIsHidingAncestorStateOfType(st);
    return WidgetFactories.LookupBoundarySt.debugIsHidingAncestorStateOfType.invoke(fn, context.build().getId());
  }
  int lookupBoundaryDebugIsHidingAncestorRenderObjectOfType(BuildContext context) {
    var st = WidgetFactories.lookupBoundary(factories);
    var fn = WidgetFactories.LookupBoundarySt.debugIsHidingAncestorRenderObjectOfType(st);
    return WidgetFactories.LookupBoundarySt.debugIsHidingAncestorRenderObjectOfType.invoke(fn, context.build().getId());
  }

  MemorySegment semanticsDebuggerSemanticsDebugger(Widget child, Optional<TextStyle> labelStyle) {
    var st = WidgetFactories.semanticsDebugger(factories);
    var fn = WidgetFactories.SemanticsDebuggerSt.semanticsDebugger(st);
    return WidgetFactories.SemanticsDebuggerSt.semanticsDebugger.invoke(fn, arena, child.build().getId(),
      ptrObj(labelStyle));
  }

  MemorySegment excludeFocusExcludeFocus(Optional<Boolean> excluding, Widget child) {
    var st = WidgetFactories.excludeFocus(factories);
    var fn = WidgetFactories.ExcludeFocusSt.excludeFocus(st);
    return WidgetFactories.ExcludeFocusSt.excludeFocus.invoke(fn, arena, ptrBool(excluding),
      child.build().getId());
  }

  MemorySegment excludeFocusTraversalExcludeFocusTraversal(Optional<Boolean> excluding, Widget child) {
    var st = WidgetFactories.excludeFocusTraversal(factories);
    var fn = WidgetFactories.ExcludeFocusTraversalSt.excludeFocusTraversal(st);
    return WidgetFactories.ExcludeFocusTraversalSt.excludeFocusTraversal.invoke(fn, arena, ptrBool(excluding),
      child.build().getId());
  }

  MemorySegment autofillGroupAutofillGroup(Widget child, Optional<AutofillContextAction> onDisposeAction) {
    var st = WidgetFactories.autofillGroup(factories);
    var fn = WidgetFactories.AutofillGroupSt.autofillGroup(st);
    return WidgetFactories.AutofillGroupSt.autofillGroup.invoke(fn, arena, child.build().getId(),
      ptrEnum(onDisposeAction));
  }

  MemorySegment positionedDirectionalPositionedDirectional(OptionalDouble start, OptionalDouble top, OptionalDouble end, OptionalDouble bottom, OptionalDouble width, OptionalDouble height, Widget child) {
    var st = WidgetFactories.positionedDirectional(factories);
    var fn = WidgetFactories.PositionedDirectionalSt.positionedDirectional(st);
    return WidgetFactories.PositionedDirectionalSt.positionedDirectional.invoke(fn, arena, ptr(start),
      ptr(top),
      ptr(end),
      ptr(bottom),
      ptr(width),
      ptr(height),
      child.build().getId());
  }

  MemorySegment verticalDividerVerticalDivider(OptionalDouble width, OptionalDouble thickness, OptionalDouble indent, OptionalDouble endIndent, Optional<Color> color, Optional<BorderRadiusGeometry> radius) {
    var st = WidgetFactories.verticalDivider(factories);
    var fn = WidgetFactories.VerticalDividerSt.verticalDivider(st);
    return WidgetFactories.VerticalDividerSt.verticalDivider.invoke(fn, arena, ptr(width),
      ptr(thickness),
      ptr(indent),
      ptr(endIndent),
      ptrObj(color),
      ptrObj(radius));
  }

  MemorySegment expandIconExpandIcon(Optional<Boolean> isExpanded, OptionalDouble size, Optional<Consumer<Boolean>> onPressed, Optional<EdgeInsetsGeometry> padding, Optional<Color> color, Optional<Color> disabledColor, Optional<Color> expandedColor, Optional<Color> splashColor, Optional<Color> highlightColor) {
    var st = WidgetFactories.expandIcon(factories);
    var fn = WidgetFactories.ExpandIconSt.expandIcon(st);
    return WidgetFactories.ExpandIconSt.expandIcon.invoke(fn, arena, ptrBool(isExpanded),
      ptr(size),
      onPressed.isPresent() ? ptrHolder(ptrValueChangedForBoolFn(onPressed.get())) : MemorySegment.NULL,
      ptrObj(padding),
      ptrObj(color),
      ptrObj(disabledColor),
      ptrObj(expandedColor),
      ptrObj(splashColor),
      ptrObj(highlightColor));
  }

  MemorySegment sliverPaddingSliverPadding(EdgeInsetsGeometry padding, Optional<Widget> sliver) {
    var st = WidgetFactories.sliverPadding(factories);
    var fn = WidgetFactories.SliverPaddingSt.sliverPadding(st);
    return WidgetFactories.SliverPaddingSt.sliverPadding.invoke(fn, arena, padding.build().getId(),
      ptrObj(sliver));
  }

  MemorySegment sliverOpacitySliverOpacity(double opacity, Optional<Boolean> alwaysIncludeSemantics, Optional<Widget> sliver) {
    var st = WidgetFactories.sliverOpacity(factories);
    var fn = WidgetFactories.SliverOpacitySt.sliverOpacity(st);
    return WidgetFactories.SliverOpacitySt.sliverOpacity.invoke(fn, arena, opacity,
      ptrBool(alwaysIncludeSemantics),
      ptrObj(sliver));
  }

  MemorySegment sliverIgnorePointerSliverIgnorePointer(Optional<Boolean> ignoring, Optional<Boolean> ignoringSemantics, Optional<Widget> sliver) {
    var st = WidgetFactories.sliverIgnorePointer(factories);
    var fn = WidgetFactories.SliverIgnorePointerSt.sliverIgnorePointer(st);
    return WidgetFactories.SliverIgnorePointerSt.sliverIgnorePointer.invoke(fn, arena, ptrBool(ignoring),
      ptrBool(ignoringSemantics),
      ptrObj(sliver));
  }

  MemorySegment sliverOffstageSliverOffstage(Optional<Boolean> offstage, Optional<Widget> sliver) {
    var st = WidgetFactories.sliverOffstage(factories);
    var fn = WidgetFactories.SliverOffstageSt.sliverOffstage(st);
    return WidgetFactories.SliverOffstageSt.sliverOffstage.invoke(fn, arena, ptrBool(offstage),
      ptrObj(sliver));
  }

  MemorySegment sliverSafeAreaSliverSafeArea(Optional<Boolean> left, Optional<Boolean> top, Optional<Boolean> right, Optional<Boolean> bottom, Optional<EdgeInsets> minimum, Widget sliver) {
    var st = WidgetFactories.sliverSafeArea(factories);
    var fn = WidgetFactories.SliverSafeAreaSt.sliverSafeArea(st);
    return WidgetFactories.SliverSafeAreaSt.sliverSafeArea.invoke(fn, arena, ptrBool(left),
      ptrBool(top),
      ptrBool(right),
      ptrBool(bottom),
      ptrObj(minimum),
      sliver.build().getId());
  }

  MemorySegment sliverVisibilitySliverVisibility(Widget sliver, Optional<Widget> replacementSliver, Optional<Boolean> visible, Optional<Boolean> maintainState, Optional<Boolean> maintainAnimation, Optional<Boolean> maintainSize, Optional<Boolean> maintainSemantics, Optional<Boolean> maintainInteractivity) {
    var st = WidgetFactories.sliverVisibility(factories);
    var fn = WidgetFactories.SliverVisibilitySt.sliverVisibility(st);
    return WidgetFactories.SliverVisibilitySt.sliverVisibility.invoke(fn, arena, sliver.build().getId(),
      ptrObj(replacementSliver),
      ptrBool(visible),
      ptrBool(maintainState),
      ptrBool(maintainAnimation),
      ptrBool(maintainSize),
      ptrBool(maintainSemantics),
      ptrBool(maintainInteractivity));
  }
  MemorySegment sliverVisibilityMaintain(Widget sliver, Optional<Widget> replacementSliver, Optional<Boolean> visible) {
    var st = WidgetFactories.sliverVisibility(factories);
    var fn = WidgetFactories.SliverVisibilitySt.maintain(st);
    return WidgetFactories.SliverVisibilitySt.maintain.invoke(fn, arena, sliver.build().getId(),
      ptrObj(replacementSliver),
      ptrBool(visible));
  }

  MemorySegment sliverMainAxisGroupSliverMainAxisGroup(List<Widget> slivers) {
    var st = WidgetFactories.sliverMainAxisGroup(factories);
    var fn = WidgetFactories.SliverMainAxisGroupSt.sliverMainAxisGroup(st);
    return WidgetFactories.SliverMainAxisGroupSt.sliverMainAxisGroup.invoke(fn, arena, ptrList(slivers));
  }

  MemorySegment sliverCrossAxisGroupSliverCrossAxisGroup(List<Widget> slivers) {
    var st = WidgetFactories.sliverCrossAxisGroup(factories);
    var fn = WidgetFactories.SliverCrossAxisGroupSt.sliverCrossAxisGroup(st);
    return WidgetFactories.SliverCrossAxisGroupSt.sliverCrossAxisGroup.invoke(fn, arena, ptrList(slivers));
  }

  MemorySegment sliverFillRemainingSliverFillRemaining(Optional<Widget> child, Optional<Boolean> hasScrollBody, Optional<Boolean> fillOverscroll) {
    var st = WidgetFactories.sliverFillRemaining(factories);
    var fn = WidgetFactories.SliverFillRemainingSt.sliverFillRemaining(st);
    return WidgetFactories.SliverFillRemainingSt.sliverFillRemaining.invoke(fn, arena, ptrObj(child),
      ptrBool(hasScrollBody),
      ptrBool(fillOverscroll));
  }

  MemorySegment sliverEnsureSemanticsSliverEnsureSemantics(Widget sliver) {
    var st = WidgetFactories.sliverEnsureSemantics(factories);
    var fn = WidgetFactories.SliverEnsureSemanticsSt.sliverEnsureSemantics(st);
    return WidgetFactories.SliverEnsureSemanticsSt.sliverEnsureSemantics.invoke(fn, arena, sliver.build().getId());
  }

  MemorySegment sliverConstrainedCrossAxisSliverConstrainedCrossAxis(double maxExtent, Widget sliver) {
    var st = WidgetFactories.sliverConstrainedCrossAxis(factories);
    var fn = WidgetFactories.SliverConstrainedCrossAxisSt.sliverConstrainedCrossAxis(st);
    return WidgetFactories.SliverConstrainedCrossAxisSt.sliverConstrainedCrossAxis.invoke(fn, arena, maxExtent,
      sliver.build().getId());
  }

  MemorySegment customScrollViewCustomScrollView(Optional<Axis> scrollDirection, Optional<Boolean> reverse, Optional<Boolean> primary, Optional<Boolean> shrinkWrap, OptionalDouble anchor, OptionalDouble cacheExtent, Optional<SliverPaintOrder> paintOrder, Optional<List<Widget>> slivers, OptionalInt semanticChildCount, Optional<DragStartBehavior> dragStartBehavior, Optional<ScrollViewKeyboardDismissBehavior> keyboardDismissBehavior, Optional<String> restorationId, Optional<Clip> clipBehavior, Optional<HitTestBehavior> hitTestBehavior) {
    var st = WidgetFactories.customScrollView(factories);
    var fn = WidgetFactories.CustomScrollViewSt.customScrollView(st);
    return WidgetFactories.CustomScrollViewSt.customScrollView.invoke(fn, arena, ptrEnum(scrollDirection),
      ptrBool(reverse),
      ptrBool(primary),
      ptrBool(shrinkWrap),
      ptr(anchor),
      ptr(cacheExtent),
      ptrEnum(paintOrder),
      ptrList(slivers),
      ptr(semanticChildCount),
      ptrEnum(dragStartBehavior),
      ptrEnum(keyboardDismissBehavior),
      ptrStr(restorationId),
      ptrEnum(clipBehavior),
      ptrEnum(hitTestBehavior));
  }

  MemorySegment drawerHeaderDrawerHeader(Optional<Decoration> decoration, Optional<EdgeInsetsGeometry> margin, Optional<EdgeInsetsGeometry> padding, Optional<Duration> duration, Optional<Curve> curve, Optional<Widget> child) {
    var st = WidgetFactories.drawerHeader(factories);
    var fn = WidgetFactories.DrawerHeaderSt.drawerHeader(st);
    return WidgetFactories.DrawerHeaderSt.drawerHeader.invoke(fn, arena, ptrObj(decoration),
      ptrObj(margin),
      ptrObj(padding),
      ptrObj(duration),
      ptrObj(curve),
      ptrObj(child));
  }

  MemorySegment selectionAreaSelectionArea(Widget child) {
    var st = WidgetFactories.selectionArea(factories);
    var fn = WidgetFactories.SelectionAreaSt.selectionArea(st);
    return WidgetFactories.SelectionAreaSt.selectionArea.invoke(fn, arena, child.build().getId());
  }

  MemorySegment sizeChangedLayoutNotifierSizeChangedLayoutNotifier(Optional<Widget> child) {
    var st = WidgetFactories.sizeChangedLayoutNotifier(factories);
    var fn = WidgetFactories.SizeChangedLayoutNotifierSt.sizeChangedLayoutNotifier(st);
    return WidgetFactories.SizeChangedLayoutNotifierSt.sizeChangedLayoutNotifier.invoke(fn, arena, ptrObj(child));
  }

  MemorySegment draggableScrollableActuatorDraggableScrollableActuator(Widget child) {
    var st = WidgetFactories.draggableScrollableActuator(factories);
    var fn = WidgetFactories.DraggableScrollableActuatorSt.draggableScrollableActuator(st);
    return WidgetFactories.DraggableScrollableActuatorSt.draggableScrollableActuator.invoke(fn, arena, child.build().getId());
  }
  int draggableScrollableActuatorReset(BuildContext context) {
    var st = WidgetFactories.draggableScrollableActuator(factories);
    var fn = WidgetFactories.DraggableScrollableActuatorSt.reset(st);
    return WidgetFactories.DraggableScrollableActuatorSt.reset.invoke(fn, context.build().getId());
  }

  MemorySegment scrollNotificationObserverScrollNotificationObserver(Widget child) {
    var st = WidgetFactories.scrollNotificationObserver(factories);
    var fn = WidgetFactories.ScrollNotificationObserverSt.scrollNotificationObserver(st);
    return WidgetFactories.ScrollNotificationObserverSt.scrollNotificationObserver.invoke(fn, arena, child.build().getId());
  }

  MemorySegment modalBarrierModalBarrier(Optional<Color> color, Optional<Boolean> dismissible, Optional<Runnable> onDismiss, Optional<String> semanticsLabel, Optional<Boolean> barrierSemanticsDismissible, Optional<String> semanticsOnTapHint) {
    var st = WidgetFactories.modalBarrier(factories);
    var fn = WidgetFactories.ModalBarrierSt.modalBarrier(st);
    return WidgetFactories.ModalBarrierSt.modalBarrier.invoke(fn, arena, ptrObj(color),
      ptrBool(dismissible),
      onDismiss.isPresent() ? ptrHolder(ptrVoidCallbackFn(onDismiss.get())) : MemorySegment.NULL,
      ptrStr(semanticsLabel),
      ptrBool(barrierSemanticsDismissible),
      ptrStr(semanticsOnTapHint));
  }

  MemorySegment listenerListener(Optional<Consumer<PointerDownEvent>> onPointerDown, Optional<Consumer<PointerUpEvent>> onPointerUp, Optional<Consumer<PointerHoverEvent>> onPointerHover, Optional<HitTestBehavior> behavior, Optional<Widget> child) {
    var st = WidgetFactories.listener(factories);
    var fn = WidgetFactories.ListenerSt.listener(st);
    return WidgetFactories.ListenerSt.listener.invoke(fn, arena, onPointerDown.isPresent() ? ptrHolder(ptrPointerDownEventListenerFn(onPointerDown.get())) : MemorySegment.NULL,
      onPointerUp.isPresent() ? ptrHolder(ptrPointerUpEventListenerFn(onPointerUp.get())) : MemorySegment.NULL,
      onPointerHover.isPresent() ? ptrHolder(ptrPointerHoverEventListenerFn(onPointerHover.get())) : MemorySegment.NULL,
      ptrEnum(behavior),
      ptrObj(child));
  }

  MemorySegment overflowBarOverflowBar(OptionalDouble spacing, Optional<MainAxisAlignment> alignment, OptionalDouble overflowSpacing, Optional<OverflowBarAlignment> overflowAlignment, Optional<VerticalDirection> overflowDirection, Optional<TextDirection> textDirection, Optional<List<Widget>> children) {
    var st = WidgetFactories.overflowBar(factories);
    var fn = WidgetFactories.OverflowBarSt.overflowBar(st);
    return WidgetFactories.OverflowBarSt.overflowBar.invoke(fn, arena, ptr(spacing),
      ptrEnum(alignment),
      ptr(overflowSpacing),
      ptrEnum(overflowAlignment),
      ptrEnum(overflowDirection),
      ptrEnum(textDirection),
      ptrList(children));
  }

  MemorySegment defaultSelectionStyleDefaultSelectionStyle(Optional<Color> cursorColor, Optional<Color> selectionColor, Widget child) {
    var st = WidgetFactories.defaultSelectionStyle(factories);
    var fn = WidgetFactories.DefaultSelectionStyleSt.defaultSelectionStyle(st);
    return WidgetFactories.DefaultSelectionStyleSt.defaultSelectionStyle.invoke(fn, arena, ptrObj(cursorColor),
      ptrObj(selectionColor),
      child.build().getId());
  }
  MemorySegment defaultSelectionStyleFallback() {
    var st = WidgetFactories.defaultSelectionStyle(factories);
    var fn = WidgetFactories.DefaultSelectionStyleSt.fallback(st);
    return WidgetFactories.DefaultSelectionStyleSt.fallback.invoke(fn, arena);
  }
  int defaultSelectionStyleMerge(Optional<Color> cursorColor, Optional<Color> selectionColor, Widget child) {
    var st = WidgetFactories.defaultSelectionStyle(factories);
    var fn = WidgetFactories.DefaultSelectionStyleSt.merge(st);
    return WidgetFactories.DefaultSelectionStyleSt.merge.invoke(fn, ptrObj(cursorColor),
      ptrObj(selectionColor),
      child.build().getId());
  }
  MemorySegment defaultSelectionStyleOf(BuildContext context) {
    var st = WidgetFactories.defaultSelectionStyle(factories);
    var fn = WidgetFactories.DefaultSelectionStyleSt.of(st);
    return WidgetFactories.DefaultSelectionStyleSt.of.invoke(fn, arena, context.build().getId());
  }

  MemorySegment inkInk(Optional<EdgeInsetsGeometry> padding, Optional<Color> color, Optional<Decoration> decoration, OptionalDouble width, OptionalDouble height, Optional<Widget> child) {
    var st = WidgetFactories.ink(factories);
    var fn = WidgetFactories.InkSt.ink(st);
    return WidgetFactories.InkSt.ink.invoke(fn, arena, ptrObj(padding),
      ptrObj(color),
      ptrObj(decoration),
      ptr(width),
      ptr(height),
      ptrObj(child));
  }

  MemorySegment bottomAppBarBottomAppBar(Optional<Color> color, OptionalDouble elevation, Optional<Clip> clipBehavior, OptionalDouble notchMargin, Optional<Widget> child, Optional<EdgeInsetsGeometry> padding, Optional<Color> surfaceTintColor, Optional<Color> shadowColor, OptionalDouble height) {
    var st = WidgetFactories.bottomAppBar(factories);
    var fn = WidgetFactories.BottomAppBarSt.bottomAppBar(st);
    return WidgetFactories.BottomAppBarSt.bottomAppBar.invoke(fn, arena, ptrObj(color),
      ptr(elevation),
      ptrEnum(clipBehavior),
      ptr(notchMargin),
      ptrObj(child),
      ptrObj(padding),
      ptrObj(surfaceTintColor),
      ptrObj(shadowColor),
      ptr(height));
  }

  MemorySegment choiceChipChoiceChip(Optional<Widget> avatar, Widget label, Optional<TextStyle> labelStyle, Optional<EdgeInsetsGeometry> labelPadding, Optional<Consumer<Boolean>> onSelected, OptionalDouble pressElevation, boolean selected, Optional<Color> selectedColor, Optional<Color> disabledColor, Optional<String> tooltip, Optional<BorderSide> side, Optional<OutlinedBorder> shape, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, Optional<Color> color, Optional<Color> backgroundColor, Optional<EdgeInsetsGeometry> padding, Optional<VisualDensity> visualDensity, Optional<MaterialTapTargetSize> materialTapTargetSize, OptionalDouble elevation, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, Optional<Color> selectedShadowColor, Optional<Boolean> showCheckmark, Optional<Color> checkmarkColor, Optional<ShapeBorder> avatarBorder, Optional<BoxConstraints> avatarBoxConstraints) {
    var st = WidgetFactories.choiceChip(factories);
    var fn = WidgetFactories.ChoiceChipSt.choiceChip(st);
    return WidgetFactories.ChoiceChipSt.choiceChip.invoke(fn, arena, ptrObj(avatar),
      label.build().getId(),
      ptrObj(labelStyle),
      ptrObj(labelPadding),
      onSelected.isPresent() ? ptrHolder(ptrValueChangedForBoolFn(onSelected.get())) : MemorySegment.NULL,
      ptr(pressElevation),
      (selected ? 1 : 0),
      ptrObj(selectedColor),
      ptrObj(disabledColor),
      ptrStr(tooltip),
      ptrObj(side),
      ptrObj(shape),
      ptrEnum(clipBehavior),
      ptrBool(autofocus),
      ptrObj(color),
      ptrObj(backgroundColor),
      ptrObj(padding),
      ptrObj(visualDensity),
      ptrEnum(materialTapTargetSize),
      ptr(elevation),
      ptrObj(shadowColor),
      ptrObj(surfaceTintColor),
      ptrObj(selectedShadowColor),
      ptrBool(showCheckmark),
      ptrObj(checkmarkColor),
      ptrObj(avatarBorder),
      ptrObj(avatarBoxConstraints));
  }
  MemorySegment choiceChipElevated(Optional<Widget> avatar, Widget label, Optional<TextStyle> labelStyle, Optional<EdgeInsetsGeometry> labelPadding, Optional<Consumer<Boolean>> onSelected, OptionalDouble pressElevation, boolean selected, Optional<Color> selectedColor, Optional<Color> disabledColor, Optional<String> tooltip, Optional<BorderSide> side, Optional<OutlinedBorder> shape, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, Optional<Color> color, Optional<Color> backgroundColor, Optional<EdgeInsetsGeometry> padding, Optional<VisualDensity> visualDensity, Optional<MaterialTapTargetSize> materialTapTargetSize, OptionalDouble elevation, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, Optional<Color> selectedShadowColor, Optional<Boolean> showCheckmark, Optional<Color> checkmarkColor, Optional<ShapeBorder> avatarBorder, Optional<BoxConstraints> avatarBoxConstraints) {
    var st = WidgetFactories.choiceChip(factories);
    var fn = WidgetFactories.ChoiceChipSt.elevated(st);
    return WidgetFactories.ChoiceChipSt.elevated.invoke(fn, arena, ptrObj(avatar),
      label.build().getId(),
      ptrObj(labelStyle),
      ptrObj(labelPadding),
      onSelected.isPresent() ? ptrHolder(ptrValueChangedForBoolFn(onSelected.get())) : MemorySegment.NULL,
      ptr(pressElevation),
      (selected ? 1 : 0),
      ptrObj(selectedColor),
      ptrObj(disabledColor),
      ptrStr(tooltip),
      ptrObj(side),
      ptrObj(shape),
      ptrEnum(clipBehavior),
      ptrBool(autofocus),
      ptrObj(color),
      ptrObj(backgroundColor),
      ptrObj(padding),
      ptrObj(visualDensity),
      ptrEnum(materialTapTargetSize),
      ptr(elevation),
      ptrObj(shadowColor),
      ptrObj(surfaceTintColor),
      ptrObj(selectedShadowColor),
      ptrBool(showCheckmark),
      ptrObj(checkmarkColor),
      ptrObj(avatarBorder),
      ptrObj(avatarBoxConstraints));
  }

  MemorySegment visualDensityVisualDensity(OptionalDouble horizontal, OptionalDouble vertical) {
    var st = WidgetFactories.visualDensity(factories);
    var fn = WidgetFactories.VisualDensitySt.visualDensity(st);
    return WidgetFactories.VisualDensitySt.visualDensity.invoke(fn, arena, ptr(horizontal),
      ptr(vertical));
  }
  MemorySegment visualDensityDefaultDensityForPlatform(TargetPlatform platform) {
    var st = WidgetFactories.visualDensity(factories);
    var fn = WidgetFactories.VisualDensitySt.defaultDensityForPlatform(st);
    return WidgetFactories.VisualDensitySt.defaultDensityForPlatform.invoke(fn, arena, platform.ordinal());
  }
  MemorySegment visualDensityLerp(VisualDensity a, VisualDensity b, double t) {
    var st = WidgetFactories.visualDensity(factories);
    var fn = WidgetFactories.VisualDensitySt.lerp(st);
    return WidgetFactories.VisualDensitySt.lerp.invoke(fn, arena, a.build().getId(),
      b.build().getId(),
      t);
  }

  MemorySegment filterChipFilterChip(Optional<Widget> avatar, Widget label, Optional<TextStyle> labelStyle, Optional<EdgeInsetsGeometry> labelPadding, Optional<Boolean> selected, Optional<Consumer<Boolean>> onSelected, Optional<Widget> deleteIcon, Optional<Runnable> onDeleted, Optional<Color> deleteIconColor, Optional<String> deleteButtonTooltipMessage, OptionalDouble pressElevation, Optional<Color> disabledColor, Optional<Color> selectedColor, Optional<String> tooltip, Optional<BorderSide> side, Optional<OutlinedBorder> shape, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, Optional<Color> color, Optional<Color> backgroundColor, Optional<EdgeInsetsGeometry> padding, Optional<VisualDensity> visualDensity, Optional<MaterialTapTargetSize> materialTapTargetSize, OptionalDouble elevation, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, Optional<Color> selectedShadowColor, Optional<Boolean> showCheckmark, Optional<Color> checkmarkColor, Optional<ShapeBorder> avatarBorder, Optional<BoxConstraints> avatarBoxConstraints, Optional<BoxConstraints> deleteIconBoxConstraints) {
    var st = WidgetFactories.filterChip(factories);
    var fn = WidgetFactories.FilterChipSt.filterChip(st);
    return WidgetFactories.FilterChipSt.filterChip.invoke(fn, arena, ptrObj(avatar),
      label.build().getId(),
      ptrObj(labelStyle),
      ptrObj(labelPadding),
      ptrBool(selected),
      onSelected.isPresent() ? ptrHolder(ptrValueChangedForBoolFn(onSelected.get())) : MemorySegment.NULL,
      ptrObj(deleteIcon),
      onDeleted.isPresent() ? ptrHolder(ptrVoidCallbackFn(onDeleted.get())) : MemorySegment.NULL,
      ptrObj(deleteIconColor),
      ptrStr(deleteButtonTooltipMessage),
      ptr(pressElevation),
      ptrObj(disabledColor),
      ptrObj(selectedColor),
      ptrStr(tooltip),
      ptrObj(side),
      ptrObj(shape),
      ptrEnum(clipBehavior),
      ptrBool(autofocus),
      ptrObj(color),
      ptrObj(backgroundColor),
      ptrObj(padding),
      ptrObj(visualDensity),
      ptrEnum(materialTapTargetSize),
      ptr(elevation),
      ptrObj(shadowColor),
      ptrObj(surfaceTintColor),
      ptrObj(selectedShadowColor),
      ptrBool(showCheckmark),
      ptrObj(checkmarkColor),
      ptrObj(avatarBorder),
      ptrObj(avatarBoxConstraints),
      ptrObj(deleteIconBoxConstraints));
  }
  MemorySegment filterChipElevated(Optional<Widget> avatar, Widget label, Optional<TextStyle> labelStyle, Optional<EdgeInsetsGeometry> labelPadding, Optional<Boolean> selected, Optional<Consumer<Boolean>> onSelected, Optional<Widget> deleteIcon, Optional<Runnable> onDeleted, Optional<Color> deleteIconColor, Optional<String> deleteButtonTooltipMessage, OptionalDouble pressElevation, Optional<Color> disabledColor, Optional<Color> selectedColor, Optional<String> tooltip, Optional<BorderSide> side, Optional<OutlinedBorder> shape, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, Optional<Color> color, Optional<Color> backgroundColor, Optional<EdgeInsetsGeometry> padding, Optional<VisualDensity> visualDensity, Optional<MaterialTapTargetSize> materialTapTargetSize, OptionalDouble elevation, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, Optional<Color> selectedShadowColor, Optional<Boolean> showCheckmark, Optional<Color> checkmarkColor, Optional<ShapeBorder> avatarBorder, Optional<BoxConstraints> avatarBoxConstraints, Optional<BoxConstraints> deleteIconBoxConstraints) {
    var st = WidgetFactories.filterChip(factories);
    var fn = WidgetFactories.FilterChipSt.elevated(st);
    return WidgetFactories.FilterChipSt.elevated.invoke(fn, arena, ptrObj(avatar),
      label.build().getId(),
      ptrObj(labelStyle),
      ptrObj(labelPadding),
      ptrBool(selected),
      onSelected.isPresent() ? ptrHolder(ptrValueChangedForBoolFn(onSelected.get())) : MemorySegment.NULL,
      ptrObj(deleteIcon),
      onDeleted.isPresent() ? ptrHolder(ptrVoidCallbackFn(onDeleted.get())) : MemorySegment.NULL,
      ptrObj(deleteIconColor),
      ptrStr(deleteButtonTooltipMessage),
      ptr(pressElevation),
      ptrObj(disabledColor),
      ptrObj(selectedColor),
      ptrStr(tooltip),
      ptrObj(side),
      ptrObj(shape),
      ptrEnum(clipBehavior),
      ptrBool(autofocus),
      ptrObj(color),
      ptrObj(backgroundColor),
      ptrObj(padding),
      ptrObj(visualDensity),
      ptrEnum(materialTapTargetSize),
      ptr(elevation),
      ptrObj(shadowColor),
      ptrObj(surfaceTintColor),
      ptrObj(selectedShadowColor),
      ptrBool(showCheckmark),
      ptrObj(checkmarkColor),
      ptrObj(avatarBorder),
      ptrObj(avatarBoxConstraints),
      ptrObj(deleteIconBoxConstraints));
  }

  MemorySegment actionChipActionChip(Optional<Widget> avatar, Widget label, Optional<TextStyle> labelStyle, Optional<EdgeInsetsGeometry> labelPadding, Optional<Runnable> onPressed, OptionalDouble pressElevation, Optional<String> tooltip, Optional<BorderSide> side, Optional<OutlinedBorder> shape, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, Optional<Color> color, Optional<Color> backgroundColor, Optional<Color> disabledColor, Optional<EdgeInsetsGeometry> padding, Optional<VisualDensity> visualDensity, Optional<MaterialTapTargetSize> materialTapTargetSize, OptionalDouble elevation, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, Optional<BoxConstraints> avatarBoxConstraints) {
    var st = WidgetFactories.actionChip(factories);
    var fn = WidgetFactories.ActionChipSt.actionChip(st);
    return WidgetFactories.ActionChipSt.actionChip.invoke(fn, arena, ptrObj(avatar),
      label.build().getId(),
      ptrObj(labelStyle),
      ptrObj(labelPadding),
      onPressed.isPresent() ? ptrHolder(ptrVoidCallbackFn(onPressed.get())) : MemorySegment.NULL,
      ptr(pressElevation),
      ptrStr(tooltip),
      ptrObj(side),
      ptrObj(shape),
      ptrEnum(clipBehavior),
      ptrBool(autofocus),
      ptrObj(color),
      ptrObj(backgroundColor),
      ptrObj(disabledColor),
      ptrObj(padding),
      ptrObj(visualDensity),
      ptrEnum(materialTapTargetSize),
      ptr(elevation),
      ptrObj(shadowColor),
      ptrObj(surfaceTintColor),
      ptrObj(avatarBoxConstraints));
  }
  MemorySegment actionChipElevated(Optional<Widget> avatar, Widget label, Optional<TextStyle> labelStyle, Optional<EdgeInsetsGeometry> labelPadding, Optional<Runnable> onPressed, OptionalDouble pressElevation, Optional<String> tooltip, Optional<BorderSide> side, Optional<OutlinedBorder> shape, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, Optional<Color> color, Optional<Color> backgroundColor, Optional<Color> disabledColor, Optional<EdgeInsetsGeometry> padding, Optional<VisualDensity> visualDensity, Optional<MaterialTapTargetSize> materialTapTargetSize, OptionalDouble elevation, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, Optional<BoxConstraints> avatarBoxConstraints) {
    var st = WidgetFactories.actionChip(factories);
    var fn = WidgetFactories.ActionChipSt.elevated(st);
    return WidgetFactories.ActionChipSt.elevated.invoke(fn, arena, ptrObj(avatar),
      label.build().getId(),
      ptrObj(labelStyle),
      ptrObj(labelPadding),
      onPressed.isPresent() ? ptrHolder(ptrVoidCallbackFn(onPressed.get())) : MemorySegment.NULL,
      ptr(pressElevation),
      ptrStr(tooltip),
      ptrObj(side),
      ptrObj(shape),
      ptrEnum(clipBehavior),
      ptrBool(autofocus),
      ptrObj(color),
      ptrObj(backgroundColor),
      ptrObj(disabledColor),
      ptrObj(padding),
      ptrObj(visualDensity),
      ptrEnum(materialTapTargetSize),
      ptr(elevation),
      ptrObj(shadowColor),
      ptrObj(surfaceTintColor),
      ptrObj(avatarBoxConstraints));
  }

  MemorySegment simpleDialogSimpleDialog(Optional<Widget> title, Optional<EdgeInsetsGeometry> titlePadding, Optional<TextStyle> titleTextStyle, Optional<List<Widget>> children, Optional<EdgeInsetsGeometry> contentPadding, Optional<Color> backgroundColor, OptionalDouble elevation, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, Optional<String> semanticLabel, Optional<EdgeInsets> insetPadding, Optional<Clip> clipBehavior, Optional<ShapeBorder> shape, Optional<AlignmentGeometry> alignment, Optional<BoxConstraints> constraints) {
    var st = WidgetFactories.simpleDialog(factories);
    var fn = WidgetFactories.SimpleDialogSt.simpleDialog(st);
    return WidgetFactories.SimpleDialogSt.simpleDialog.invoke(fn, arena, ptrObj(title),
      ptrObj(titlePadding),
      ptrObj(titleTextStyle),
      ptrList(children),
      ptrObj(contentPadding),
      ptrObj(backgroundColor),
      ptr(elevation),
      ptrObj(shadowColor),
      ptrObj(surfaceTintColor),
      ptrStr(semanticLabel),
      ptrObj(insetPadding),
      ptrEnum(clipBehavior),
      ptrObj(shape),
      ptrObj(alignment),
      ptrObj(constraints));
  }

  MemorySegment simpleDialogOptionSimpleDialogOption(Optional<Runnable> onPressed, Optional<EdgeInsets> padding, Optional<Widget> child) {
    var st = WidgetFactories.simpleDialogOption(factories);
    var fn = WidgetFactories.SimpleDialogOptionSt.simpleDialogOption(st);
    return WidgetFactories.SimpleDialogOptionSt.simpleDialogOption.invoke(fn, arena, onPressed.isPresent() ? ptrHolder(ptrVoidCallbackFn(onPressed.get())) : MemorySegment.NULL,
      ptrObj(padding),
      ptrObj(child));
  }

  MemorySegment circleBorderCircleBorder(Optional<BorderSide> side, OptionalDouble eccentricity) {
    var st = WidgetFactories.circleBorder(factories);
    var fn = WidgetFactories.CircleBorderSt.circleBorder(st);
    return WidgetFactories.CircleBorderSt.circleBorder.invoke(fn, arena, ptrObj(side),
      ptr(eccentricity));
  }

  MemorySegment stadiumBorderStadiumBorder(Optional<BorderSide> side) {
    var st = WidgetFactories.stadiumBorder(factories);
    var fn = WidgetFactories.StadiumBorderSt.stadiumBorder(st);
    return WidgetFactories.StadiumBorderSt.stadiumBorder.invoke(fn, arena, ptrObj(side));
  }

  MemorySegment beveledRectangleBorderBeveledRectangleBorder(Optional<BorderSide> side, Optional<BorderRadiusGeometry> borderRadius) {
    var st = WidgetFactories.beveledRectangleBorder(factories);
    var fn = WidgetFactories.BeveledRectangleBorderSt.beveledRectangleBorder(st);
    return WidgetFactories.BeveledRectangleBorderSt.beveledRectangleBorder.invoke(fn, arena, ptrObj(side),
      ptrObj(borderRadius));
  }

  MemorySegment continuousRectangleBorderContinuousRectangleBorder(Optional<BorderSide> side, Optional<BorderRadiusGeometry> borderRadius) {
    var st = WidgetFactories.continuousRectangleBorder(factories);
    var fn = WidgetFactories.ContinuousRectangleBorderSt.continuousRectangleBorder(st);
    return WidgetFactories.ContinuousRectangleBorderSt.continuousRectangleBorder.invoke(fn, arena, ptrObj(side),
      ptrObj(borderRadius));
  }

  MemorySegment linearBorderLinearBorder(Optional<BorderSide> side) {
    var st = WidgetFactories.linearBorder(factories);
    var fn = WidgetFactories.LinearBorderSt.linearBorder(st);
    return WidgetFactories.LinearBorderSt.linearBorder.invoke(fn, arena, ptrObj(side));
  }
  MemorySegment linearBorderStart(Optional<BorderSide> side, OptionalDouble alignment, OptionalDouble size) {
    var st = WidgetFactories.linearBorder(factories);
    var fn = WidgetFactories.LinearBorderSt.start(st);
    return WidgetFactories.LinearBorderSt.start.invoke(fn, arena, ptrObj(side),
      ptr(alignment),
      ptr(size));
  }
  MemorySegment linearBorderEnd(Optional<BorderSide> side, OptionalDouble alignment, OptionalDouble size) {
    var st = WidgetFactories.linearBorder(factories);
    var fn = WidgetFactories.LinearBorderSt.end(st);
    return WidgetFactories.LinearBorderSt.end.invoke(fn, arena, ptrObj(side),
      ptr(alignment),
      ptr(size));
  }
  MemorySegment linearBorderTop(Optional<BorderSide> side, OptionalDouble alignment, OptionalDouble size) {
    var st = WidgetFactories.linearBorder(factories);
    var fn = WidgetFactories.LinearBorderSt.top(st);
    return WidgetFactories.LinearBorderSt.top.invoke(fn, arena, ptrObj(side),
      ptr(alignment),
      ptr(size));
  }
  MemorySegment linearBorderBottom(Optional<BorderSide> side, OptionalDouble alignment, OptionalDouble size) {
    var st = WidgetFactories.linearBorder(factories);
    var fn = WidgetFactories.LinearBorderSt.bottom(st);
    return WidgetFactories.LinearBorderSt.bottom.invoke(fn, arena, ptrObj(side),
      ptr(alignment),
      ptr(size));
  }

  MemorySegment starBorderStarBorder(Optional<BorderSide> side, OptionalDouble points, OptionalDouble innerRadiusRatio, OptionalDouble pointRounding, OptionalDouble valleyRounding, OptionalDouble rotation, OptionalDouble squash) {
    var st = WidgetFactories.starBorder(factories);
    var fn = WidgetFactories.StarBorderSt.starBorder(st);
    return WidgetFactories.StarBorderSt.starBorder.invoke(fn, arena, ptrObj(side),
      ptr(points),
      ptr(innerRadiusRatio),
      ptr(pointRounding),
      ptr(valleyRounding),
      ptr(rotation),
      ptr(squash));
  }
  MemorySegment starBorderPolygon(Optional<BorderSide> side, OptionalDouble sides, OptionalDouble pointRounding, OptionalDouble rotation, OptionalDouble squash) {
    var st = WidgetFactories.starBorder(factories);
    var fn = WidgetFactories.StarBorderSt.polygon(st);
    return WidgetFactories.StarBorderSt.polygon.invoke(fn, arena, ptrObj(side),
      ptr(sides),
      ptr(pointRounding),
      ptr(rotation),
      ptr(squash));
  }

  MemorySegment materialBannerMaterialBanner(Widget content, Optional<TextStyle> contentTextStyle, List<Widget> actions, OptionalDouble elevation, Optional<Widget> leading, Optional<Color> backgroundColor, Optional<Color> surfaceTintColor, Optional<Color> shadowColor, Optional<Color> dividerColor, Optional<EdgeInsetsGeometry> padding, Optional<EdgeInsetsGeometry> margin, Optional<EdgeInsetsGeometry> leadingPadding, Optional<Boolean> forceActionsBelow, Optional<OverflowBarAlignment> overflowAlignment, Optional<Animation> animation, Optional<Runnable> onVisible, OptionalDouble minActionBarHeight) {
    var st = WidgetFactories.materialBanner(factories);
    var fn = WidgetFactories.MaterialBannerSt.materialBanner(st);
    return WidgetFactories.MaterialBannerSt.materialBanner.invoke(fn, arena, content.build().getId(),
      ptrObj(contentTextStyle),
      ptrList(actions),
      ptr(elevation),
      ptrObj(leading),
      ptrObj(backgroundColor),
      ptrObj(surfaceTintColor),
      ptrObj(shadowColor),
      ptrObj(dividerColor),
      ptrObj(padding),
      ptrObj(margin),
      ptrObj(leadingPadding),
      ptrBool(forceActionsBelow),
      ptrEnum(overflowAlignment),
      ptrObj(animation),
      onVisible.isPresent() ? ptrHolder(ptrVoidCallbackFn(onVisible.get())) : MemorySegment.NULL,
      ptr(minActionBarHeight));
  }
  int materialBannerCreateAnimationController(TickerProvider vsync) {
    var st = WidgetFactories.materialBanner(factories);
    var fn = WidgetFactories.MaterialBannerSt.createAnimationController(st);
    return WidgetFactories.MaterialBannerSt.createAnimationController.invoke(fn, vsync.build().getId());
  }

  MemorySegment tabPageSelectorIndicatorTabPageSelectorIndicator(Color backgroundColor, Color borderColor, double size, Optional<BorderStyle> borderStyle) {
    var st = WidgetFactories.tabPageSelectorIndicator(factories);
    var fn = WidgetFactories.TabPageSelectorIndicatorSt.tabPageSelectorIndicator(st);
    return WidgetFactories.TabPageSelectorIndicatorSt.tabPageSelectorIndicator.invoke(fn, arena, backgroundColor.build().getId(),
      borderColor.build().getId(),
      size,
      ptrEnum(borderStyle));
  }

  MemorySegment reorderableDragStartListenerReorderableDragStartListener(Widget child, int index, Optional<Boolean> enabled) {
    var st = WidgetFactories.reorderableDragStartListener(factories);
    var fn = WidgetFactories.ReorderableDragStartListenerSt.reorderableDragStartListener(st);
    return WidgetFactories.ReorderableDragStartListenerSt.reorderableDragStartListener.invoke(fn, arena, child.build().getId(),
      index,
      ptrBool(enabled));
  }

  MemorySegment reorderableDelayedDragStartListenerReorderableDelayedDragStartListener(Widget child, int index, Optional<Boolean> enabled) {
    var st = WidgetFactories.reorderableDelayedDragStartListener(factories);
    var fn = WidgetFactories.ReorderableDelayedDragStartListenerSt.reorderableDelayedDragStartListener(st);
    return WidgetFactories.ReorderableDelayedDragStartListenerSt.reorderableDelayedDragStartListener.invoke(fn, arena, child.build().getId(),
      index,
      ptrBool(enabled));
  }

  MemorySegment aboutListTileAboutListTile(Optional<Widget> icon, Optional<Widget> child, Optional<String> applicationName, Optional<String> applicationVersion, Optional<Widget> applicationIcon, Optional<String> applicationLegalese, Optional<List<Widget>> aboutBoxChildren, Optional<Boolean> dense) {
    var st = WidgetFactories.aboutListTile(factories);
    var fn = WidgetFactories.AboutListTileSt.aboutListTile(st);
    return WidgetFactories.AboutListTileSt.aboutListTile.invoke(fn, arena, ptrObj(icon),
      ptrObj(child),
      ptrStr(applicationName),
      ptrStr(applicationVersion),
      ptrObj(applicationIcon),
      ptrStr(applicationLegalese),
      ptrList(aboutBoxChildren),
      ptrBool(dense));
  }

  MemorySegment dialogDialog(Optional<Color> backgroundColor, OptionalDouble elevation, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, Optional<Duration> insetAnimationDuration, Optional<Curve> insetAnimationCurve, Optional<EdgeInsets> insetPadding, Optional<Clip> clipBehavior, Optional<ShapeBorder> shape, Optional<AlignmentGeometry> alignment, Optional<Widget> child, Optional<SemanticsRole> semanticsRole, Optional<BoxConstraints> constraints) {
    var st = WidgetFactories.dialog(factories);
    var fn = WidgetFactories.DialogSt.dialog(st);
    return WidgetFactories.DialogSt.dialog.invoke(fn, arena, ptrObj(backgroundColor),
      ptr(elevation),
      ptrObj(shadowColor),
      ptrObj(surfaceTintColor),
      ptrObj(insetAnimationDuration),
      ptrObj(insetAnimationCurve),
      ptrObj(insetPadding),
      ptrEnum(clipBehavior),
      ptrObj(shape),
      ptrObj(alignment),
      ptrObj(child),
      ptrEnum(semanticsRole),
      ptrObj(constraints));
  }
  MemorySegment dialogFullscreen(Optional<Color> backgroundColor, Optional<Duration> insetAnimationDuration, Optional<Curve> insetAnimationCurve, Optional<Widget> child, Optional<SemanticsRole> semanticsRole) {
    var st = WidgetFactories.dialog(factories);
    var fn = WidgetFactories.DialogSt.fullscreen(st);
    return WidgetFactories.DialogSt.fullscreen.invoke(fn, arena, ptrObj(backgroundColor),
      ptrObj(insetAnimationDuration),
      ptrObj(insetAnimationCurve),
      ptrObj(child),
      ptrEnum(semanticsRole));
  }

  MemorySegment gridTileGridTile(Optional<Widget> header, Optional<Widget> footer, Widget child) {
    var st = WidgetFactories.gridTile(factories);
    var fn = WidgetFactories.GridTileSt.gridTile(st);
    return WidgetFactories.GridTileSt.gridTile.invoke(fn, arena, ptrObj(header),
      ptrObj(footer),
      child.build().getId());
  }

  MemorySegment gridTileBarGridTileBar(Optional<Color> backgroundColor, Optional<Widget> leading, Optional<Widget> title, Optional<Widget> subtitle, Optional<Widget> trailing) {
    var st = WidgetFactories.gridTileBar(factories);
    var fn = WidgetFactories.GridTileBarSt.gridTileBar(st);
    return WidgetFactories.GridTileBarSt.gridTileBar.invoke(fn, arena, ptrObj(backgroundColor),
      ptrObj(leading),
      ptrObj(title),
      ptrObj(subtitle),
      ptrObj(trailing));
  }

  MemorySegment refreshProgressIndicatorRefreshProgressIndicator(OptionalDouble value, Optional<Color> backgroundColor, Optional<Color> color, Optional<Animation> valueColor, OptionalDouble strokeWidth, OptionalDouble strokeAlign, Optional<String> semanticsLabel, Optional<String> semanticsValue, Optional<StrokeCap> strokeCap, OptionalDouble elevation, Optional<EdgeInsetsGeometry> indicatorMargin, Optional<EdgeInsetsGeometry> indicatorPadding) {
    var st = WidgetFactories.refreshProgressIndicator(factories);
    var fn = WidgetFactories.RefreshProgressIndicatorSt.refreshProgressIndicator(st);
    return WidgetFactories.RefreshProgressIndicatorSt.refreshProgressIndicator.invoke(fn, arena, ptr(value),
      ptrObj(backgroundColor),
      ptrObj(color),
      ptrObj(valueColor),
      ptr(strokeWidth),
      ptr(strokeAlign),
      ptrStr(semanticsLabel),
      ptrStr(semanticsValue),
      ptrEnum(strokeCap),
      ptr(elevation),
      ptrObj(indicatorMargin),
      ptrObj(indicatorPadding));
  }

  MemorySegment circularProgressIndicatorCircularProgressIndicator(OptionalDouble value, Optional<Color> backgroundColor, Optional<Color> color, Optional<Animation> valueColor, OptionalDouble strokeWidth, OptionalDouble strokeAlign, Optional<String> semanticsLabel, Optional<String> semanticsValue, Optional<StrokeCap> strokeCap, Optional<BoxConstraints> constraints, OptionalDouble trackGap, Optional<Boolean> year2023, Optional<EdgeInsetsGeometry> padding) {
    var st = WidgetFactories.circularProgressIndicator(factories);
    var fn = WidgetFactories.CircularProgressIndicatorSt.circularProgressIndicator(st);
    return WidgetFactories.CircularProgressIndicatorSt.circularProgressIndicator.invoke(fn, arena, ptr(value),
      ptrObj(backgroundColor),
      ptrObj(color),
      ptrObj(valueColor),
      ptr(strokeWidth),
      ptr(strokeAlign),
      ptrStr(semanticsLabel),
      ptrStr(semanticsValue),
      ptrEnum(strokeCap),
      ptrObj(constraints),
      ptr(trackGap),
      ptrBool(year2023),
      ptrObj(padding));
  }
  MemorySegment circularProgressIndicatorAdaptive(OptionalDouble value, Optional<Color> backgroundColor, Optional<Animation> valueColor, OptionalDouble strokeWidth, Optional<String> semanticsLabel, Optional<String> semanticsValue, Optional<StrokeCap> strokeCap, OptionalDouble strokeAlign, Optional<BoxConstraints> constraints, OptionalDouble trackGap, Optional<Boolean> year2023, Optional<EdgeInsetsGeometry> padding) {
    var st = WidgetFactories.circularProgressIndicator(factories);
    var fn = WidgetFactories.CircularProgressIndicatorSt.adaptive(st);
    return WidgetFactories.CircularProgressIndicatorSt.adaptive.invoke(fn, arena, ptr(value),
      ptrObj(backgroundColor),
      ptrObj(valueColor),
      ptr(strokeWidth),
      ptrStr(semanticsLabel),
      ptrStr(semanticsValue),
      ptrEnum(strokeCap),
      ptr(strokeAlign),
      ptrObj(constraints),
      ptr(trackGap),
      ptrBool(year2023),
      ptrObj(padding));
  }

  MemorySegment inputDecoratorInputDecorator(InputDecoration decoration, Optional<TextStyle> baseStyle, Optional<TextAlign> textAlign, Optional<Boolean> isFocused, Optional<Boolean> isHovering, Optional<Boolean> expands, Optional<Boolean> isEmpty, Optional<Widget> child) {
    var st = WidgetFactories.inputDecorator(factories);
    var fn = WidgetFactories.InputDecoratorSt.inputDecorator(st);
    return WidgetFactories.InputDecoratorSt.inputDecorator.invoke(fn, arena, decoration.build().getId(),
      ptrObj(baseStyle),
      ptrEnum(textAlign),
      ptrBool(isFocused),
      ptrBool(isHovering),
      ptrBool(expands),
      ptrBool(isEmpty),
      ptrObj(child));
  }
  int inputDecoratorContainerOf(BuildContext context) {
    var st = WidgetFactories.inputDecorator(factories);
    var fn = WidgetFactories.InputDecoratorSt.containerOf(st);
    return WidgetFactories.InputDecoratorSt.containerOf.invoke(fn, context.build().getId());
  }

  MemorySegment inputDecorationInputDecoration(Optional<Widget> icon, Optional<Color> iconColor, Optional<Widget> label, Optional<String> labelText, Optional<TextStyle> labelStyle, Optional<TextStyle> floatingLabelStyle, Optional<Widget> helper, Optional<String> helperText, Optional<TextStyle> helperStyle, OptionalInt helperMaxLines, Optional<String> hintText, Optional<Widget> hint, Optional<TextStyle> hintStyle, Optional<TextDirection> hintTextDirection, OptionalInt hintMaxLines, Optional<Duration> hintFadeDuration, Optional<Boolean> maintainHintHeight, Optional<Boolean> maintainHintSize, Optional<Widget> error, Optional<String> errorText, Optional<TextStyle> errorStyle, OptionalInt errorMaxLines, Optional<FloatingLabelBehavior> floatingLabelBehavior, Optional<Boolean> isCollapsed, Optional<Boolean> isDense, Optional<EdgeInsetsGeometry> contentPadding, Optional<Widget> prefixIcon, Optional<BoxConstraints> prefixIconConstraints, Optional<Widget> prefix, Optional<String> prefixText, Optional<TextStyle> prefixStyle, Optional<Color> prefixIconColor, Optional<Widget> suffixIcon, Optional<Widget> suffix, Optional<String> suffixText, Optional<TextStyle> suffixStyle, Optional<Color> suffixIconColor, Optional<BoxConstraints> suffixIconConstraints, Optional<Widget> counter, Optional<String> counterText, Optional<TextStyle> counterStyle, Optional<Boolean> filled, Optional<Color> fillColor, Optional<Color> focusColor, Optional<Color> hoverColor, Optional<InputBorder> errorBorder, Optional<InputBorder> focusedBorder, Optional<InputBorder> focusedErrorBorder, Optional<InputBorder> disabledBorder, Optional<InputBorder> enabledBorder, Optional<InputBorder> border, Optional<Boolean> enabled, Optional<String> semanticCounterText, Optional<Boolean> alignLabelWithHint, Optional<BoxConstraints> constraints, Optional<VisualDensity> visualDensity) {
    var st = WidgetFactories.inputDecoration(factories);
    var fn = WidgetFactories.InputDecorationSt.inputDecoration(st);
    return WidgetFactories.InputDecorationSt.inputDecoration.invoke(fn, arena, ptrObj(icon),
      ptrObj(iconColor),
      ptrObj(label),
      ptrStr(labelText),
      ptrObj(labelStyle),
      ptrObj(floatingLabelStyle),
      ptrObj(helper),
      ptrStr(helperText),
      ptrObj(helperStyle),
      ptr(helperMaxLines),
      ptrStr(hintText),
      ptrObj(hint),
      ptrObj(hintStyle),
      ptrEnum(hintTextDirection),
      ptr(hintMaxLines),
      ptrObj(hintFadeDuration),
      ptrBool(maintainHintHeight),
      ptrBool(maintainHintSize),
      ptrObj(error),
      ptrStr(errorText),
      ptrObj(errorStyle),
      ptr(errorMaxLines),
      ptrEnum(floatingLabelBehavior),
      ptrBool(isCollapsed),
      ptrBool(isDense),
      ptrObj(contentPadding),
      ptrObj(prefixIcon),
      ptrObj(prefixIconConstraints),
      ptrObj(prefix),
      ptrStr(prefixText),
      ptrObj(prefixStyle),
      ptrObj(prefixIconColor),
      ptrObj(suffixIcon),
      ptrObj(suffix),
      ptrStr(suffixText),
      ptrObj(suffixStyle),
      ptrObj(suffixIconColor),
      ptrObj(suffixIconConstraints),
      ptrObj(counter),
      ptrStr(counterText),
      ptrObj(counterStyle),
      ptrBool(filled),
      ptrObj(fillColor),
      ptrObj(focusColor),
      ptrObj(hoverColor),
      ptrObj(errorBorder),
      ptrObj(focusedBorder),
      ptrObj(focusedErrorBorder),
      ptrObj(disabledBorder),
      ptrObj(enabledBorder),
      ptrObj(border),
      ptrBool(enabled),
      ptrStr(semanticCounterText),
      ptrBool(alignLabelWithHint),
      ptrObj(constraints),
      ptrObj(visualDensity));
  }
  MemorySegment inputDecorationCollapsed(Optional<String> hintText, Optional<FloatingLabelBehavior> floatingLabelBehavior, Optional<TextStyle> hintStyle, Optional<Widget> hint, Optional<TextDirection> hintTextDirection, OptionalInt hintMaxLines, Optional<Duration> hintFadeDuration, Optional<Boolean> maintainHintHeight, Optional<Boolean> maintainHintSize, Optional<Boolean> filled, Optional<Color> fillColor, Optional<Color> focusColor, Optional<Color> hoverColor, Optional<InputBorder> border, Optional<Boolean> enabled, Optional<BoxConstraints> constraints) {
    var st = WidgetFactories.inputDecoration(factories);
    var fn = WidgetFactories.InputDecorationSt.collapsed(st);
    return WidgetFactories.InputDecorationSt.collapsed.invoke(fn, arena, ptrStr(hintText),
      ptrEnum(floatingLabelBehavior),
      ptrObj(hintStyle),
      ptrObj(hint),
      ptrEnum(hintTextDirection),
      ptr(hintMaxLines),
      ptrObj(hintFadeDuration),
      ptrBool(maintainHintHeight),
      ptrBool(maintainHintSize),
      ptrBool(filled),
      ptrObj(fillColor),
      ptrObj(focusColor),
      ptrObj(hoverColor),
      ptrObj(border),
      ptrBool(enabled),
      ptrObj(constraints));
  }

  int inputBorderNone() {
    var st = WidgetFactories.inputBorder(factories);
    return WidgetFactories.InputBorderSt.none(st);
  }

  MemorySegment userAccountsDrawerHeaderUserAccountsDrawerHeader(Optional<Decoration> decoration, Optional<EdgeInsetsGeometry> margin, Optional<Widget> currentAccountPicture, Optional<List<Widget>> otherAccountsPictures, Optional<Widget> accountName, Optional<Widget> accountEmail, Optional<Runnable> onDetailsPressed, Optional<Color> arrowColor) {
    var st = WidgetFactories.userAccountsDrawerHeader(factories);
    var fn = WidgetFactories.UserAccountsDrawerHeaderSt.userAccountsDrawerHeader(st);
    return WidgetFactories.UserAccountsDrawerHeaderSt.userAccountsDrawerHeader.invoke(fn, arena, ptrObj(decoration),
      ptrObj(margin),
      ptrObj(currentAccountPicture),
      ptrList(otherAccountsPictures),
      ptrObj(accountName),
      ptrObj(accountEmail),
      onDetailsPressed.isPresent() ? ptrHolder(ptrVoidCallbackFn(onDetailsPressed.get())) : MemorySegment.NULL,
      ptrObj(arrowColor));
  }

  MemorySegment inputChipInputChip(Optional<Widget> avatar, Widget label, Optional<TextStyle> labelStyle, Optional<EdgeInsetsGeometry> labelPadding, Optional<Boolean> selected, Optional<Boolean> isEnabled, Optional<Consumer<Boolean>> onSelected, Optional<Widget> deleteIcon, Optional<Runnable> onDeleted, Optional<Color> deleteIconColor, Optional<String> deleteButtonTooltipMessage, Optional<Runnable> onPressed, OptionalDouble pressElevation, Optional<Color> disabledColor, Optional<Color> selectedColor, Optional<String> tooltip, Optional<BorderSide> side, Optional<OutlinedBorder> shape, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, Optional<Color> color, Optional<Color> backgroundColor, Optional<EdgeInsetsGeometry> padding, Optional<VisualDensity> visualDensity, Optional<MaterialTapTargetSize> materialTapTargetSize, OptionalDouble elevation, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, Optional<Color> selectedShadowColor, Optional<Boolean> showCheckmark, Optional<Color> checkmarkColor, Optional<ShapeBorder> avatarBorder, Optional<BoxConstraints> avatarBoxConstraints, Optional<BoxConstraints> deleteIconBoxConstraints) {
    var st = WidgetFactories.inputChip(factories);
    var fn = WidgetFactories.InputChipSt.inputChip(st);
    return WidgetFactories.InputChipSt.inputChip.invoke(fn, arena, ptrObj(avatar),
      label.build().getId(),
      ptrObj(labelStyle),
      ptrObj(labelPadding),
      ptrBool(selected),
      ptrBool(isEnabled),
      onSelected.isPresent() ? ptrHolder(ptrValueChangedForBoolFn(onSelected.get())) : MemorySegment.NULL,
      ptrObj(deleteIcon),
      onDeleted.isPresent() ? ptrHolder(ptrVoidCallbackFn(onDeleted.get())) : MemorySegment.NULL,
      ptrObj(deleteIconColor),
      ptrStr(deleteButtonTooltipMessage),
      onPressed.isPresent() ? ptrHolder(ptrVoidCallbackFn(onPressed.get())) : MemorySegment.NULL,
      ptr(pressElevation),
      ptrObj(disabledColor),
      ptrObj(selectedColor),
      ptrStr(tooltip),
      ptrObj(side),
      ptrObj(shape),
      ptrEnum(clipBehavior),
      ptrBool(autofocus),
      ptrObj(color),
      ptrObj(backgroundColor),
      ptrObj(padding),
      ptrObj(visualDensity),
      ptrEnum(materialTapTargetSize),
      ptr(elevation),
      ptrObj(shadowColor),
      ptrObj(surfaceTintColor),
      ptrObj(selectedShadowColor),
      ptrBool(showCheckmark),
      ptrObj(checkmarkColor),
      ptrObj(avatarBorder),
      ptrObj(avatarBoxConstraints),
      ptrObj(deleteIconBoxConstraints));
  }

  MemorySegment alignTransitionAlignTransition(Animation alignment, Widget child, OptionalDouble widthFactor, OptionalDouble heightFactor) {
    var st = WidgetFactories.alignTransition(factories);
    var fn = WidgetFactories.AlignTransitionSt.alignTransition(st);
    return WidgetFactories.AlignTransitionSt.alignTransition.invoke(fn, arena, alignment.build().getId(),
      child.build().getId(),
      ptr(widthFactor),
      ptr(heightFactor));
  }

  MemorySegment animatedDefaultTextStyleAnimatedDefaultTextStyle(Widget child, TextStyle style, Optional<TextAlign> textAlign, Optional<Boolean> softWrap, Optional<TextOverflow> overflow, OptionalInt maxLines, Optional<TextWidthBasis> textWidthBasis, Optional<Curve> curve, Duration duration, Optional<Runnable> onEnd) {
    var st = WidgetFactories.animatedDefaultTextStyle(factories);
    var fn = WidgetFactories.AnimatedDefaultTextStyleSt.animatedDefaultTextStyle(st);
    return WidgetFactories.AnimatedDefaultTextStyleSt.animatedDefaultTextStyle.invoke(fn, arena, child.build().getId(),
      style.build().getId(),
      ptrEnum(textAlign),
      ptrBool(softWrap),
      ptrEnum(overflow),
      ptr(maxLines),
      ptrEnum(textWidthBasis),
      ptrObj(curve),
      duration.build().getId(),
      onEnd.isPresent() ? ptrHolder(ptrVoidCallbackFn(onEnd.get())) : MemorySegment.NULL);
  }

  MemorySegment animatedFractionallySizedBoxAnimatedFractionallySizedBox(Optional<AlignmentGeometry> alignment, Optional<Widget> child, OptionalDouble heightFactor, OptionalDouble widthFactor, Optional<Curve> curve, Duration duration, Optional<Runnable> onEnd) {
    var st = WidgetFactories.animatedFractionallySizedBox(factories);
    var fn = WidgetFactories.AnimatedFractionallySizedBoxSt.animatedFractionallySizedBox(st);
    return WidgetFactories.AnimatedFractionallySizedBoxSt.animatedFractionallySizedBox.invoke(fn, arena, ptrObj(alignment),
      ptrObj(child),
      ptr(heightFactor),
      ptr(widthFactor),
      ptrObj(curve),
      duration.build().getId(),
      onEnd.isPresent() ? ptrHolder(ptrVoidCallbackFn(onEnd.get())) : MemorySegment.NULL);
  }

  MemorySegment animatedPositionedAnimatedPositioned(Widget child, OptionalDouble left, OptionalDouble top, OptionalDouble right, OptionalDouble bottom, OptionalDouble width, OptionalDouble height, Optional<Curve> curve, Duration duration, Optional<Runnable> onEnd) {
    var st = WidgetFactories.animatedPositioned(factories);
    var fn = WidgetFactories.AnimatedPositionedSt.animatedPositioned(st);
    return WidgetFactories.AnimatedPositionedSt.animatedPositioned.invoke(fn, arena, child.build().getId(),
      ptr(left),
      ptr(top),
      ptr(right),
      ptr(bottom),
      ptr(width),
      ptr(height),
      ptrObj(curve),
      duration.build().getId(),
      onEnd.isPresent() ? ptrHolder(ptrVoidCallbackFn(onEnd.get())) : MemorySegment.NULL);
  }

  MemorySegment animatedPositionedDirectionalAnimatedPositionedDirectional(Widget child, OptionalDouble start, OptionalDouble top, OptionalDouble end, OptionalDouble bottom, OptionalDouble width, OptionalDouble height, Optional<Curve> curve, Duration duration, Optional<Runnable> onEnd) {
    var st = WidgetFactories.animatedPositionedDirectional(factories);
    var fn = WidgetFactories.AnimatedPositionedDirectionalSt.animatedPositionedDirectional(st);
    return WidgetFactories.AnimatedPositionedDirectionalSt.animatedPositionedDirectional.invoke(fn, arena, child.build().getId(),
      ptr(start),
      ptr(top),
      ptr(end),
      ptr(bottom),
      ptr(width),
      ptr(height),
      ptrObj(curve),
      duration.build().getId(),
      onEnd.isPresent() ? ptrHolder(ptrVoidCallbackFn(onEnd.get())) : MemorySegment.NULL);
  }

  MemorySegment displayFeatureSubScreenDisplayFeatureSubScreen(Optional<Offset> anchorPoint, Widget child) {
    var st = WidgetFactories.displayFeatureSubScreen(factories);
    var fn = WidgetFactories.DisplayFeatureSubScreenSt.displayFeatureSubScreen(st);
    return WidgetFactories.DisplayFeatureSubScreenSt.displayFeatureSubScreen.invoke(fn, arena, ptrObj(anchorPoint),
      child.build().getId());
  }

  MemorySegment errorWidgetErrorWidget(NativeObj exception) {
    var st = WidgetFactories.errorWidget(factories);
    var fn = WidgetFactories.ErrorWidgetSt.errorWidget(st);
    return WidgetFactories.ErrorWidgetSt.errorWidget.invoke(fn, arena, exception.build().getId());
  }
  MemorySegment errorWidgetWithDetails(Optional<String> message) {
    var st = WidgetFactories.errorWidget(factories);
    var fn = WidgetFactories.ErrorWidgetSt.withDetails(st);
    return WidgetFactories.ErrorWidgetSt.withDetails.invoke(fn, arena, ptrStr(message));
  }

  MemorySegment restorationScopeRestorationScope(Optional<String> restorationId, Widget child) {
    var st = WidgetFactories.restorationScope(factories);
    var fn = WidgetFactories.RestorationScopeSt.restorationScope(st);
    return WidgetFactories.RestorationScopeSt.restorationScope.invoke(fn, arena, ptrStr(restorationId),
      child.build().getId());
  }

  MemorySegment rootRestorationScopeRootRestorationScope(Optional<String> restorationId, Widget child) {
    var st = WidgetFactories.rootRestorationScope(factories);
    var fn = WidgetFactories.RootRestorationScopeSt.rootRestorationScope(st);
    return WidgetFactories.RootRestorationScopeSt.rootRestorationScope.invoke(fn, arena, ptrStr(restorationId),
      child.build().getId());
  }

  MemorySegment stretchingOverscrollIndicatorStretchingOverscrollIndicator(AxisDirection axisDirection, Optional<Clip> clipBehavior, Optional<Widget> child) {
    var st = WidgetFactories.stretchingOverscrollIndicator(factories);
    var fn = WidgetFactories.StretchingOverscrollIndicatorSt.stretchingOverscrollIndicator(st);
    return WidgetFactories.StretchingOverscrollIndicatorSt.stretchingOverscrollIndicator.invoke(fn, arena, axisDirection.ordinal(),
      ptrEnum(clipBehavior),
      ptrObj(child));
  }

  MemorySegment tapRegionTapRegion(Optional<Widget> child, Optional<Boolean> enabled, Optional<HitTestBehavior> behavior, Optional<Consumer<PointerDownEvent>> onTapOutside, Optional<Consumer<PointerDownEvent>> onTapInside, Optional<Consumer<PointerUpEvent>> onTapUpOutside, Optional<Consumer<PointerUpEvent>> onTapUpInside, Optional<NativeObj> groupId, Optional<Boolean> consumeOutsideTaps, Optional<String> debugLabel) {
    var st = WidgetFactories.tapRegion(factories);
    var fn = WidgetFactories.TapRegionSt.tapRegion(st);
    return WidgetFactories.TapRegionSt.tapRegion.invoke(fn, arena, ptrObj(child),
      ptrBool(enabled),
      ptrEnum(behavior),
      onTapOutside.isPresent() ? ptrHolder(ptrTapRegionCallbackFn(onTapOutside.get())) : MemorySegment.NULL,
      onTapInside.isPresent() ? ptrHolder(ptrTapRegionCallbackFn(onTapInside.get())) : MemorySegment.NULL,
      onTapUpOutside.isPresent() ? ptrHolder(ptrTapRegionUpCallbackFn(onTapUpOutside.get())) : MemorySegment.NULL,
      onTapUpInside.isPresent() ? ptrHolder(ptrTapRegionUpCallbackFn(onTapUpInside.get())) : MemorySegment.NULL,
      ptrObj(groupId),
      ptrBool(consumeOutsideTaps),
      ptrStr(debugLabel));
  }

  MemorySegment textFieldTapRegionTextFieldTapRegion(Optional<Widget> child, Optional<Boolean> enabled, Optional<Consumer<PointerDownEvent>> onTapOutside, Optional<Consumer<PointerDownEvent>> onTapInside, Optional<Consumer<PointerUpEvent>> onTapUpOutside, Optional<Consumer<PointerUpEvent>> onTapUpInside, Optional<Boolean> consumeOutsideTaps, Optional<String> debugLabel, Optional<NativeObj> groupId) {
    var st = WidgetFactories.textFieldTapRegion(factories);
    var fn = WidgetFactories.TextFieldTapRegionSt.textFieldTapRegion(st);
    return WidgetFactories.TextFieldTapRegionSt.textFieldTapRegion.invoke(fn, arena, ptrObj(child),
      ptrBool(enabled),
      onTapOutside.isPresent() ? ptrHolder(ptrTapRegionCallbackFn(onTapOutside.get())) : MemorySegment.NULL,
      onTapInside.isPresent() ? ptrHolder(ptrTapRegionCallbackFn(onTapInside.get())) : MemorySegment.NULL,
      onTapUpOutside.isPresent() ? ptrHolder(ptrTapRegionUpCallbackFn(onTapUpOutside.get())) : MemorySegment.NULL,
      onTapUpInside.isPresent() ? ptrHolder(ptrTapRegionUpCallbackFn(onTapUpInside.get())) : MemorySegment.NULL,
      ptrBool(consumeOutsideTaps),
      ptrStr(debugLabel),
      ptrObj(groupId));
  }

  MemorySegment colorSchemeColorScheme(Brightness brightness, Color primary, Color onPrimary, Optional<Color> primaryContainer, Optional<Color> onPrimaryContainer, Optional<Color> primaryFixed, Optional<Color> primaryFixedDim, Optional<Color> onPrimaryFixed, Optional<Color> onPrimaryFixedVariant, Color secondary, Color onSecondary, Optional<Color> secondaryContainer, Optional<Color> onSecondaryContainer, Optional<Color> secondaryFixed, Optional<Color> secondaryFixedDim, Optional<Color> onSecondaryFixed, Optional<Color> onSecondaryFixedVariant, Optional<Color> tertiary, Optional<Color> onTertiary, Optional<Color> tertiaryContainer, Optional<Color> onTertiaryContainer, Optional<Color> tertiaryFixed, Optional<Color> tertiaryFixedDim, Optional<Color> onTertiaryFixed, Optional<Color> onTertiaryFixedVariant, Color error, Color onError, Optional<Color> errorContainer, Optional<Color> onErrorContainer, Color surface, Color onSurface, Optional<Color> surfaceDim, Optional<Color> surfaceBright, Optional<Color> surfaceContainerLowest, Optional<Color> surfaceContainerLow, Optional<Color> surfaceContainer, Optional<Color> surfaceContainerHigh, Optional<Color> surfaceContainerHighest, Optional<Color> onSurfaceVariant, Optional<Color> outline, Optional<Color> outlineVariant, Optional<Color> shadow, Optional<Color> scrim, Optional<Color> inverseSurface, Optional<Color> onInverseSurface, Optional<Color> inversePrimary, Optional<Color> surfaceTint, Optional<Color> background, Optional<Color> onBackground, Optional<Color> surfaceVariant) {
    var st = WidgetFactories.colorScheme(factories);
    var fn = WidgetFactories.ColorSchemeSt.colorScheme(st);
    return WidgetFactories.ColorSchemeSt.colorScheme.invoke(fn, arena, brightness.ordinal(),
      primary.build().getId(),
      onPrimary.build().getId(),
      ptrObj(primaryContainer),
      ptrObj(onPrimaryContainer),
      ptrObj(primaryFixed),
      ptrObj(primaryFixedDim),
      ptrObj(onPrimaryFixed),
      ptrObj(onPrimaryFixedVariant),
      secondary.build().getId(),
      onSecondary.build().getId(),
      ptrObj(secondaryContainer),
      ptrObj(onSecondaryContainer),
      ptrObj(secondaryFixed),
      ptrObj(secondaryFixedDim),
      ptrObj(onSecondaryFixed),
      ptrObj(onSecondaryFixedVariant),
      ptrObj(tertiary),
      ptrObj(onTertiary),
      ptrObj(tertiaryContainer),
      ptrObj(onTertiaryContainer),
      ptrObj(tertiaryFixed),
      ptrObj(tertiaryFixedDim),
      ptrObj(onTertiaryFixed),
      ptrObj(onTertiaryFixedVariant),
      error.build().getId(),
      onError.build().getId(),
      ptrObj(errorContainer),
      ptrObj(onErrorContainer),
      surface.build().getId(),
      onSurface.build().getId(),
      ptrObj(surfaceDim),
      ptrObj(surfaceBright),
      ptrObj(surfaceContainerLowest),
      ptrObj(surfaceContainerLow),
      ptrObj(surfaceContainer),
      ptrObj(surfaceContainerHigh),
      ptrObj(surfaceContainerHighest),
      ptrObj(onSurfaceVariant),
      ptrObj(outline),
      ptrObj(outlineVariant),
      ptrObj(shadow),
      ptrObj(scrim),
      ptrObj(inverseSurface),
      ptrObj(onInverseSurface),
      ptrObj(inversePrimary),
      ptrObj(surfaceTint),
      ptrObj(background),
      ptrObj(onBackground),
      ptrObj(surfaceVariant));
  }
  MemorySegment colorSchemeFromSeed(Color seedColor, Optional<Brightness> brightness, Optional<DynamicSchemeVariant> dynamicSchemeVariant, OptionalDouble contrastLevel, Optional<Color> primary, Optional<Color> onPrimary, Optional<Color> primaryContainer, Optional<Color> onPrimaryContainer, Optional<Color> primaryFixed, Optional<Color> primaryFixedDim, Optional<Color> onPrimaryFixed, Optional<Color> onPrimaryFixedVariant, Optional<Color> secondary, Optional<Color> onSecondary, Optional<Color> secondaryContainer, Optional<Color> onSecondaryContainer, Optional<Color> secondaryFixed, Optional<Color> secondaryFixedDim, Optional<Color> onSecondaryFixed, Optional<Color> onSecondaryFixedVariant, Optional<Color> tertiary, Optional<Color> onTertiary, Optional<Color> tertiaryContainer, Optional<Color> onTertiaryContainer, Optional<Color> tertiaryFixed, Optional<Color> tertiaryFixedDim, Optional<Color> onTertiaryFixed, Optional<Color> onTertiaryFixedVariant, Optional<Color> error, Optional<Color> onError, Optional<Color> errorContainer, Optional<Color> onErrorContainer, Optional<Color> outline, Optional<Color> outlineVariant, Optional<Color> surface, Optional<Color> onSurface, Optional<Color> surfaceDim, Optional<Color> surfaceBright, Optional<Color> surfaceContainerLowest, Optional<Color> surfaceContainerLow, Optional<Color> surfaceContainer, Optional<Color> surfaceContainerHigh, Optional<Color> surfaceContainerHighest, Optional<Color> onSurfaceVariant, Optional<Color> inverseSurface, Optional<Color> onInverseSurface, Optional<Color> inversePrimary, Optional<Color> shadow, Optional<Color> scrim, Optional<Color> surfaceTint, Optional<Color> background, Optional<Color> onBackground, Optional<Color> surfaceVariant) {
    var st = WidgetFactories.colorScheme(factories);
    var fn = WidgetFactories.ColorSchemeSt.fromSeed(st);
    return WidgetFactories.ColorSchemeSt.fromSeed.invoke(fn, arena, seedColor.build().getId(),
      ptrEnum(brightness),
      ptrEnum(dynamicSchemeVariant),
      ptr(contrastLevel),
      ptrObj(primary),
      ptrObj(onPrimary),
      ptrObj(primaryContainer),
      ptrObj(onPrimaryContainer),
      ptrObj(primaryFixed),
      ptrObj(primaryFixedDim),
      ptrObj(onPrimaryFixed),
      ptrObj(onPrimaryFixedVariant),
      ptrObj(secondary),
      ptrObj(onSecondary),
      ptrObj(secondaryContainer),
      ptrObj(onSecondaryContainer),
      ptrObj(secondaryFixed),
      ptrObj(secondaryFixedDim),
      ptrObj(onSecondaryFixed),
      ptrObj(onSecondaryFixedVariant),
      ptrObj(tertiary),
      ptrObj(onTertiary),
      ptrObj(tertiaryContainer),
      ptrObj(onTertiaryContainer),
      ptrObj(tertiaryFixed),
      ptrObj(tertiaryFixedDim),
      ptrObj(onTertiaryFixed),
      ptrObj(onTertiaryFixedVariant),
      ptrObj(error),
      ptrObj(onError),
      ptrObj(errorContainer),
      ptrObj(onErrorContainer),
      ptrObj(outline),
      ptrObj(outlineVariant),
      ptrObj(surface),
      ptrObj(onSurface),
      ptrObj(surfaceDim),
      ptrObj(surfaceBright),
      ptrObj(surfaceContainerLowest),
      ptrObj(surfaceContainerLow),
      ptrObj(surfaceContainer),
      ptrObj(surfaceContainerHigh),
      ptrObj(surfaceContainerHighest),
      ptrObj(onSurfaceVariant),
      ptrObj(inverseSurface),
      ptrObj(onInverseSurface),
      ptrObj(inversePrimary),
      ptrObj(shadow),
      ptrObj(scrim),
      ptrObj(surfaceTint),
      ptrObj(background),
      ptrObj(onBackground),
      ptrObj(surfaceVariant));
  }
  MemorySegment colorSchemeLight(Optional<Brightness> brightness, Optional<Color> primary, Optional<Color> onPrimary, Optional<Color> primaryContainer, Optional<Color> onPrimaryContainer, Optional<Color> primaryFixed, Optional<Color> primaryFixedDim, Optional<Color> onPrimaryFixed, Optional<Color> onPrimaryFixedVariant, Optional<Color> secondary, Optional<Color> onSecondary, Optional<Color> secondaryContainer, Optional<Color> onSecondaryContainer, Optional<Color> secondaryFixed, Optional<Color> secondaryFixedDim, Optional<Color> onSecondaryFixed, Optional<Color> onSecondaryFixedVariant, Optional<Color> tertiary, Optional<Color> onTertiary, Optional<Color> tertiaryContainer, Optional<Color> onTertiaryContainer, Optional<Color> tertiaryFixed, Optional<Color> tertiaryFixedDim, Optional<Color> onTertiaryFixed, Optional<Color> onTertiaryFixedVariant, Optional<Color> error, Optional<Color> onError, Optional<Color> errorContainer, Optional<Color> onErrorContainer, Optional<Color> surface, Optional<Color> onSurface, Optional<Color> surfaceDim, Optional<Color> surfaceBright, Optional<Color> surfaceContainerLowest, Optional<Color> surfaceContainerLow, Optional<Color> surfaceContainer, Optional<Color> surfaceContainerHigh, Optional<Color> surfaceContainerHighest, Optional<Color> onSurfaceVariant, Optional<Color> outline, Optional<Color> outlineVariant, Optional<Color> shadow, Optional<Color> scrim, Optional<Color> inverseSurface, Optional<Color> onInverseSurface, Optional<Color> inversePrimary, Optional<Color> surfaceTint, Optional<Color> background, Optional<Color> onBackground, Optional<Color> surfaceVariant) {
    var st = WidgetFactories.colorScheme(factories);
    var fn = WidgetFactories.ColorSchemeSt.light(st);
    return WidgetFactories.ColorSchemeSt.light.invoke(fn, arena, ptrEnum(brightness),
      ptrObj(primary),
      ptrObj(onPrimary),
      ptrObj(primaryContainer),
      ptrObj(onPrimaryContainer),
      ptrObj(primaryFixed),
      ptrObj(primaryFixedDim),
      ptrObj(onPrimaryFixed),
      ptrObj(onPrimaryFixedVariant),
      ptrObj(secondary),
      ptrObj(onSecondary),
      ptrObj(secondaryContainer),
      ptrObj(onSecondaryContainer),
      ptrObj(secondaryFixed),
      ptrObj(secondaryFixedDim),
      ptrObj(onSecondaryFixed),
      ptrObj(onSecondaryFixedVariant),
      ptrObj(tertiary),
      ptrObj(onTertiary),
      ptrObj(tertiaryContainer),
      ptrObj(onTertiaryContainer),
      ptrObj(tertiaryFixed),
      ptrObj(tertiaryFixedDim),
      ptrObj(onTertiaryFixed),
      ptrObj(onTertiaryFixedVariant),
      ptrObj(error),
      ptrObj(onError),
      ptrObj(errorContainer),
      ptrObj(onErrorContainer),
      ptrObj(surface),
      ptrObj(onSurface),
      ptrObj(surfaceDim),
      ptrObj(surfaceBright),
      ptrObj(surfaceContainerLowest),
      ptrObj(surfaceContainerLow),
      ptrObj(surfaceContainer),
      ptrObj(surfaceContainerHigh),
      ptrObj(surfaceContainerHighest),
      ptrObj(onSurfaceVariant),
      ptrObj(outline),
      ptrObj(outlineVariant),
      ptrObj(shadow),
      ptrObj(scrim),
      ptrObj(inverseSurface),
      ptrObj(onInverseSurface),
      ptrObj(inversePrimary),
      ptrObj(surfaceTint),
      ptrObj(background),
      ptrObj(onBackground),
      ptrObj(surfaceVariant));
  }
  MemorySegment colorSchemeDark(Optional<Brightness> brightness, Optional<Color> primary, Optional<Color> onPrimary, Optional<Color> primaryContainer, Optional<Color> onPrimaryContainer, Optional<Color> primaryFixed, Optional<Color> primaryFixedDim, Optional<Color> onPrimaryFixed, Optional<Color> onPrimaryFixedVariant, Optional<Color> secondary, Optional<Color> onSecondary, Optional<Color> secondaryContainer, Optional<Color> onSecondaryContainer, Optional<Color> secondaryFixed, Optional<Color> secondaryFixedDim, Optional<Color> onSecondaryFixed, Optional<Color> onSecondaryFixedVariant, Optional<Color> tertiary, Optional<Color> onTertiary, Optional<Color> tertiaryContainer, Optional<Color> onTertiaryContainer, Optional<Color> tertiaryFixed, Optional<Color> tertiaryFixedDim, Optional<Color> onTertiaryFixed, Optional<Color> onTertiaryFixedVariant, Optional<Color> error, Optional<Color> onError, Optional<Color> errorContainer, Optional<Color> onErrorContainer, Optional<Color> surface, Optional<Color> onSurface, Optional<Color> surfaceDim, Optional<Color> surfaceBright, Optional<Color> surfaceContainerLowest, Optional<Color> surfaceContainerLow, Optional<Color> surfaceContainer, Optional<Color> surfaceContainerHigh, Optional<Color> surfaceContainerHighest, Optional<Color> onSurfaceVariant, Optional<Color> outline, Optional<Color> outlineVariant, Optional<Color> shadow, Optional<Color> scrim, Optional<Color> inverseSurface, Optional<Color> onInverseSurface, Optional<Color> inversePrimary, Optional<Color> surfaceTint, Optional<Color> background, Optional<Color> onBackground, Optional<Color> surfaceVariant) {
    var st = WidgetFactories.colorScheme(factories);
    var fn = WidgetFactories.ColorSchemeSt.dark(st);
    return WidgetFactories.ColorSchemeSt.dark.invoke(fn, arena, ptrEnum(brightness),
      ptrObj(primary),
      ptrObj(onPrimary),
      ptrObj(primaryContainer),
      ptrObj(onPrimaryContainer),
      ptrObj(primaryFixed),
      ptrObj(primaryFixedDim),
      ptrObj(onPrimaryFixed),
      ptrObj(onPrimaryFixedVariant),
      ptrObj(secondary),
      ptrObj(onSecondary),
      ptrObj(secondaryContainer),
      ptrObj(onSecondaryContainer),
      ptrObj(secondaryFixed),
      ptrObj(secondaryFixedDim),
      ptrObj(onSecondaryFixed),
      ptrObj(onSecondaryFixedVariant),
      ptrObj(tertiary),
      ptrObj(onTertiary),
      ptrObj(tertiaryContainer),
      ptrObj(onTertiaryContainer),
      ptrObj(tertiaryFixed),
      ptrObj(tertiaryFixedDim),
      ptrObj(onTertiaryFixed),
      ptrObj(onTertiaryFixedVariant),
      ptrObj(error),
      ptrObj(onError),
      ptrObj(errorContainer),
      ptrObj(onErrorContainer),
      ptrObj(surface),
      ptrObj(onSurface),
      ptrObj(surfaceDim),
      ptrObj(surfaceBright),
      ptrObj(surfaceContainerLowest),
      ptrObj(surfaceContainerLow),
      ptrObj(surfaceContainer),
      ptrObj(surfaceContainerHigh),
      ptrObj(surfaceContainerHighest),
      ptrObj(onSurfaceVariant),
      ptrObj(outline),
      ptrObj(outlineVariant),
      ptrObj(shadow),
      ptrObj(scrim),
      ptrObj(inverseSurface),
      ptrObj(onInverseSurface),
      ptrObj(inversePrimary),
      ptrObj(surfaceTint),
      ptrObj(background),
      ptrObj(onBackground),
      ptrObj(surfaceVariant));
  }
  MemorySegment colorSchemeHighContrastLight(Optional<Brightness> brightness, Optional<Color> primary, Optional<Color> onPrimary, Optional<Color> primaryContainer, Optional<Color> onPrimaryContainer, Optional<Color> primaryFixed, Optional<Color> primaryFixedDim, Optional<Color> onPrimaryFixed, Optional<Color> onPrimaryFixedVariant, Optional<Color> secondary, Optional<Color> onSecondary, Optional<Color> secondaryContainer, Optional<Color> onSecondaryContainer, Optional<Color> secondaryFixed, Optional<Color> secondaryFixedDim, Optional<Color> onSecondaryFixed, Optional<Color> onSecondaryFixedVariant, Optional<Color> tertiary, Optional<Color> onTertiary, Optional<Color> tertiaryContainer, Optional<Color> onTertiaryContainer, Optional<Color> tertiaryFixed, Optional<Color> tertiaryFixedDim, Optional<Color> onTertiaryFixed, Optional<Color> onTertiaryFixedVariant, Optional<Color> error, Optional<Color> onError, Optional<Color> errorContainer, Optional<Color> onErrorContainer, Optional<Color> surface, Optional<Color> onSurface, Optional<Color> surfaceDim, Optional<Color> surfaceBright, Optional<Color> surfaceContainerLowest, Optional<Color> surfaceContainerLow, Optional<Color> surfaceContainer, Optional<Color> surfaceContainerHigh, Optional<Color> surfaceContainerHighest, Optional<Color> onSurfaceVariant, Optional<Color> outline, Optional<Color> outlineVariant, Optional<Color> shadow, Optional<Color> scrim, Optional<Color> inverseSurface, Optional<Color> onInverseSurface, Optional<Color> inversePrimary, Optional<Color> surfaceTint, Optional<Color> background, Optional<Color> onBackground, Optional<Color> surfaceVariant) {
    var st = WidgetFactories.colorScheme(factories);
    var fn = WidgetFactories.ColorSchemeSt.highContrastLight(st);
    return WidgetFactories.ColorSchemeSt.highContrastLight.invoke(fn, arena, ptrEnum(brightness),
      ptrObj(primary),
      ptrObj(onPrimary),
      ptrObj(primaryContainer),
      ptrObj(onPrimaryContainer),
      ptrObj(primaryFixed),
      ptrObj(primaryFixedDim),
      ptrObj(onPrimaryFixed),
      ptrObj(onPrimaryFixedVariant),
      ptrObj(secondary),
      ptrObj(onSecondary),
      ptrObj(secondaryContainer),
      ptrObj(onSecondaryContainer),
      ptrObj(secondaryFixed),
      ptrObj(secondaryFixedDim),
      ptrObj(onSecondaryFixed),
      ptrObj(onSecondaryFixedVariant),
      ptrObj(tertiary),
      ptrObj(onTertiary),
      ptrObj(tertiaryContainer),
      ptrObj(onTertiaryContainer),
      ptrObj(tertiaryFixed),
      ptrObj(tertiaryFixedDim),
      ptrObj(onTertiaryFixed),
      ptrObj(onTertiaryFixedVariant),
      ptrObj(error),
      ptrObj(onError),
      ptrObj(errorContainer),
      ptrObj(onErrorContainer),
      ptrObj(surface),
      ptrObj(onSurface),
      ptrObj(surfaceDim),
      ptrObj(surfaceBright),
      ptrObj(surfaceContainerLowest),
      ptrObj(surfaceContainerLow),
      ptrObj(surfaceContainer),
      ptrObj(surfaceContainerHigh),
      ptrObj(surfaceContainerHighest),
      ptrObj(onSurfaceVariant),
      ptrObj(outline),
      ptrObj(outlineVariant),
      ptrObj(shadow),
      ptrObj(scrim),
      ptrObj(inverseSurface),
      ptrObj(onInverseSurface),
      ptrObj(inversePrimary),
      ptrObj(surfaceTint),
      ptrObj(background),
      ptrObj(onBackground),
      ptrObj(surfaceVariant));
  }
  MemorySegment colorSchemeHighContrastDark(Optional<Brightness> brightness, Optional<Color> primary, Optional<Color> onPrimary, Optional<Color> primaryContainer, Optional<Color> onPrimaryContainer, Optional<Color> primaryFixed, Optional<Color> primaryFixedDim, Optional<Color> onPrimaryFixed, Optional<Color> onPrimaryFixedVariant, Optional<Color> secondary, Optional<Color> onSecondary, Optional<Color> secondaryContainer, Optional<Color> onSecondaryContainer, Optional<Color> secondaryFixed, Optional<Color> secondaryFixedDim, Optional<Color> onSecondaryFixed, Optional<Color> onSecondaryFixedVariant, Optional<Color> tertiary, Optional<Color> onTertiary, Optional<Color> tertiaryContainer, Optional<Color> onTertiaryContainer, Optional<Color> tertiaryFixed, Optional<Color> tertiaryFixedDim, Optional<Color> onTertiaryFixed, Optional<Color> onTertiaryFixedVariant, Optional<Color> error, Optional<Color> onError, Optional<Color> errorContainer, Optional<Color> onErrorContainer, Optional<Color> surface, Optional<Color> onSurface, Optional<Color> surfaceDim, Optional<Color> surfaceBright, Optional<Color> surfaceContainerLowest, Optional<Color> surfaceContainerLow, Optional<Color> surfaceContainer, Optional<Color> surfaceContainerHigh, Optional<Color> surfaceContainerHighest, Optional<Color> onSurfaceVariant, Optional<Color> outline, Optional<Color> outlineVariant, Optional<Color> shadow, Optional<Color> scrim, Optional<Color> inverseSurface, Optional<Color> onInverseSurface, Optional<Color> inversePrimary, Optional<Color> surfaceTint, Optional<Color> background, Optional<Color> onBackground, Optional<Color> surfaceVariant) {
    var st = WidgetFactories.colorScheme(factories);
    var fn = WidgetFactories.ColorSchemeSt.highContrastDark(st);
    return WidgetFactories.ColorSchemeSt.highContrastDark.invoke(fn, arena, ptrEnum(brightness),
      ptrObj(primary),
      ptrObj(onPrimary),
      ptrObj(primaryContainer),
      ptrObj(onPrimaryContainer),
      ptrObj(primaryFixed),
      ptrObj(primaryFixedDim),
      ptrObj(onPrimaryFixed),
      ptrObj(onPrimaryFixedVariant),
      ptrObj(secondary),
      ptrObj(onSecondary),
      ptrObj(secondaryContainer),
      ptrObj(onSecondaryContainer),
      ptrObj(secondaryFixed),
      ptrObj(secondaryFixedDim),
      ptrObj(onSecondaryFixed),
      ptrObj(onSecondaryFixedVariant),
      ptrObj(tertiary),
      ptrObj(onTertiary),
      ptrObj(tertiaryContainer),
      ptrObj(onTertiaryContainer),
      ptrObj(tertiaryFixed),
      ptrObj(tertiaryFixedDim),
      ptrObj(onTertiaryFixed),
      ptrObj(onTertiaryFixedVariant),
      ptrObj(error),
      ptrObj(onError),
      ptrObj(errorContainer),
      ptrObj(onErrorContainer),
      ptrObj(surface),
      ptrObj(onSurface),
      ptrObj(surfaceDim),
      ptrObj(surfaceBright),
      ptrObj(surfaceContainerLowest),
      ptrObj(surfaceContainerLow),
      ptrObj(surfaceContainer),
      ptrObj(surfaceContainerHigh),
      ptrObj(surfaceContainerHighest),
      ptrObj(onSurfaceVariant),
      ptrObj(outline),
      ptrObj(outlineVariant),
      ptrObj(shadow),
      ptrObj(scrim),
      ptrObj(inverseSurface),
      ptrObj(onInverseSurface),
      ptrObj(inversePrimary),
      ptrObj(surfaceTint),
      ptrObj(background),
      ptrObj(onBackground),
      ptrObj(surfaceVariant));
  }
  MemorySegment colorSchemeFromSwatch(Optional<MaterialColor> primarySwatch, Optional<Color> accentColor, Optional<Color> cardColor, Optional<Color> backgroundColor, Optional<Color> errorColor, Optional<Brightness> brightness) {
    var st = WidgetFactories.colorScheme(factories);
    var fn = WidgetFactories.ColorSchemeSt.fromSwatch(st);
    return WidgetFactories.ColorSchemeSt.fromSwatch.invoke(fn, arena, ptrObj(primarySwatch),
      ptrObj(accentColor),
      ptrObj(cardColor),
      ptrObj(backgroundColor),
      ptrObj(errorColor),
      ptrEnum(brightness));
  }
  MemorySegment colorSchemeLerp(ColorScheme a, ColorScheme b, double t) {
    var st = WidgetFactories.colorScheme(factories);
    var fn = WidgetFactories.ColorSchemeSt.lerp(st);
    return WidgetFactories.ColorSchemeSt.lerp.invoke(fn, arena, a.build().getId(),
      b.build().getId(),
      t);
  }
  MemorySegment colorSchemeOf(BuildContext context) {
    var st = WidgetFactories.colorScheme(factories);
    var fn = WidgetFactories.ColorSchemeSt.of(st);
    return WidgetFactories.ColorSchemeSt.of.invoke(fn, arena, context.build().getId());
  }

  MemorySegment materialColorMaterialColor(int primary, Map<Integer, Color> swatch) {
    var st = WidgetFactories.materialColor(factories);
    var fn = WidgetFactories.MaterialColorSt.materialColor(st);
    return WidgetFactories.MaterialColorSt.materialColor.invoke(fn, arena, primary,
      ptrMap(swatch));
  }

  <T> MemorySegment colorSwatchLerp(ColorSwatch a, ColorSwatch b, double t) {
    var st = WidgetFactories.colorSwatch(factories);
    var fn = WidgetFactories.ColorSwatchSt.lerp(st);
    return WidgetFactories.ColorSwatchSt.lerp.invoke(fn, arena, a != null ? a.build().getId() : null,
      b != null ? b.build().getId() : null,
      t);
  }

  MemorySegment textThemeTextTheme(Optional<TextStyle> displayLarge, Optional<TextStyle> displayMedium, Optional<TextStyle> displaySmall, Optional<TextStyle> headlineLarge, Optional<TextStyle> headlineMedium, Optional<TextStyle> headlineSmall, Optional<TextStyle> titleLarge, Optional<TextStyle> titleMedium, Optional<TextStyle> titleSmall, Optional<TextStyle> bodyLarge, Optional<TextStyle> bodyMedium, Optional<TextStyle> bodySmall, Optional<TextStyle> labelLarge, Optional<TextStyle> labelMedium, Optional<TextStyle> labelSmall) {
    var st = WidgetFactories.textTheme(factories);
    var fn = WidgetFactories.TextThemeSt.textTheme(st);
    return WidgetFactories.TextThemeSt.textTheme.invoke(fn, arena, ptrObj(displayLarge),
      ptrObj(displayMedium),
      ptrObj(displaySmall),
      ptrObj(headlineLarge),
      ptrObj(headlineMedium),
      ptrObj(headlineSmall),
      ptrObj(titleLarge),
      ptrObj(titleMedium),
      ptrObj(titleSmall),
      ptrObj(bodyLarge),
      ptrObj(bodyMedium),
      ptrObj(bodySmall),
      ptrObj(labelLarge),
      ptrObj(labelMedium),
      ptrObj(labelSmall));
  }
  MemorySegment textThemeLerp(TextTheme a, TextTheme b, double t) {
    var st = WidgetFactories.textTheme(factories);
    var fn = WidgetFactories.TextThemeSt.lerp(st);
    return WidgetFactories.TextThemeSt.lerp.invoke(fn, arena, a != null ? a.build().getId() : null,
      b != null ? b.build().getId() : null,
      t);
  }
  MemorySegment textThemeOf(BuildContext context) {
    var st = WidgetFactories.textTheme(factories);
    var fn = WidgetFactories.TextThemeSt.of(st);
    return WidgetFactories.TextThemeSt.of.invoke(fn, arena, context.build().getId());
  }
  MemorySegment textThemePrimaryOf(BuildContext context) {
    var st = WidgetFactories.textTheme(factories);
    var fn = WidgetFactories.TextThemeSt.primaryOf(st);
    return WidgetFactories.TextThemeSt.primaryOf.invoke(fn, arena, context.build().getId());
  }

  MemorySegment themeDataThemeData(Optional<Boolean> applyElevationOverlayColor, Optional<NativeObj> inputDecorationTheme, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<TargetPlatform> platform, Optional<Boolean> useMaterial3, Optional<Boolean> useSystemColors, Optional<VisualDensity> visualDensity, Optional<ColorScheme> colorScheme, Optional<Brightness> brightness, Optional<Color> colorSchemeSeed, Optional<Color> canvasColor, Optional<Color> cardColor, Optional<Color> disabledColor, Optional<Color> dividerColor, Optional<Color> focusColor, Optional<Color> highlightColor, Optional<Color> hintColor, Optional<Color> hoverColor, Optional<Color> primaryColor, Optional<Color> primaryColorDark, Optional<Color> primaryColorLight, Optional<MaterialColor> primarySwatch, Optional<Color> scaffoldBackgroundColor, Optional<Color> secondaryHeaderColor, Optional<Color> shadowColor, Optional<Color> splashColor, Optional<Color> unselectedWidgetColor, Optional<String> fontFamily, Optional<List<String>> fontFamilyFallback, Optional<String> _package, Optional<TextTheme> primaryTextTheme, Optional<TextTheme> textTheme, Optional<NativeObj> appBarTheme, Optional<Color> dialogBackgroundColor, Optional<Color> indicatorColor) {
    var st = WidgetFactories.themeData(factories);
    var fn = WidgetFactories.ThemeDataSt.themeData(st);
    return WidgetFactories.ThemeDataSt.themeData.invoke(fn, arena, ptrBool(applyElevationOverlayColor),
      ptrObj(inputDecorationTheme),
      ptrEnum(materialTapTargetSize),
      ptrEnum(platform),
      ptrBool(useMaterial3),
      ptrBool(useSystemColors),
      ptrObj(visualDensity),
      ptrObj(colorScheme),
      ptrEnum(brightness),
      ptrObj(colorSchemeSeed),
      ptrObj(canvasColor),
      ptrObj(cardColor),
      ptrObj(disabledColor),
      ptrObj(dividerColor),
      ptrObj(focusColor),
      ptrObj(highlightColor),
      ptrObj(hintColor),
      ptrObj(hoverColor),
      ptrObj(primaryColor),
      ptrObj(primaryColorDark),
      ptrObj(primaryColorLight),
      ptrObj(primarySwatch),
      ptrObj(scaffoldBackgroundColor),
      ptrObj(secondaryHeaderColor),
      ptrObj(shadowColor),
      ptrObj(splashColor),
      ptrObj(unselectedWidgetColor),
      ptrStr(fontFamily),
      ptrStrList(fontFamilyFallback),
      ptrStr(_package),
      ptrObj(primaryTextTheme),
      ptrObj(textTheme),
      ptrObj(appBarTheme),
      ptrObj(dialogBackgroundColor),
      ptrObj(indicatorColor));
  }
  MemorySegment themeDataFrom(ColorScheme colorScheme, Optional<TextTheme> textTheme, Optional<Boolean> useMaterial3) {
    var st = WidgetFactories.themeData(factories);
    var fn = WidgetFactories.ThemeDataSt.from(st);
    return WidgetFactories.ThemeDataSt.from.invoke(fn, arena, colorScheme.build().getId(),
      ptrObj(textTheme),
      ptrBool(useMaterial3));
  }
  MemorySegment themeDataLight(Optional<Boolean> useMaterial3) {
    var st = WidgetFactories.themeData(factories);
    var fn = WidgetFactories.ThemeDataSt.light(st);
    return WidgetFactories.ThemeDataSt.light.invoke(fn, arena, ptrBool(useMaterial3));
  }
  MemorySegment themeDataDark(Optional<Boolean> useMaterial3) {
    var st = WidgetFactories.themeData(factories);
    var fn = WidgetFactories.ThemeDataSt.dark(st);
    return WidgetFactories.ThemeDataSt.dark.invoke(fn, arena, ptrBool(useMaterial3));
  }
  MemorySegment themeDataFallback(Optional<Boolean> useMaterial3) {
    var st = WidgetFactories.themeData(factories);
    var fn = WidgetFactories.ThemeDataSt.fallback(st);
    return WidgetFactories.ThemeDataSt.fallback.invoke(fn, arena, ptrBool(useMaterial3));
  }
  MemorySegment themeDataLocalize(ThemeData baseTheme, TextTheme localTextGeometry) {
    var st = WidgetFactories.themeData(factories);
    var fn = WidgetFactories.ThemeDataSt.localize(st);
    return WidgetFactories.ThemeDataSt.localize.invoke(fn, arena, baseTheme.build().getId(),
      localTextGeometry.build().getId());
  }
  int themeDataEstimateBrightnessForColor(Color color) {
    var st = WidgetFactories.themeData(factories);
    var fn = WidgetFactories.ThemeDataSt.estimateBrightnessForColor(st);
    return WidgetFactories.ThemeDataSt.estimateBrightnessForColor.invoke(fn, color.build().getId());
  }
  MemorySegment themeDataLerp(ThemeData a, ThemeData b, double t) {
    var st = WidgetFactories.themeData(factories);
    var fn = WidgetFactories.ThemeDataSt.lerp(st);
    return WidgetFactories.ThemeDataSt.lerp.invoke(fn, arena, a.build().getId(),
      b.build().getId(),
      t);
  }

  MemorySegment materialAccentColorMaterialAccentColor(int primary, Map<Integer, Color> swatch) {
    var st = WidgetFactories.materialAccentColor(factories);
    var fn = WidgetFactories.MaterialAccentColorSt.materialAccentColor(st);
    return WidgetFactories.MaterialAccentColorSt.materialAccentColor.invoke(fn, arena, primary,
      ptrMap(swatch));
  }

  MemorySegment materialMaterial(Optional<MaterialType> type, OptionalDouble elevation, Optional<Color> color, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, Optional<TextStyle> textStyle, Optional<BorderRadiusGeometry> borderRadius, Optional<ShapeBorder> shape, Optional<Boolean> borderOnForeground, Optional<Clip> clipBehavior, Optional<Duration> animationDuration, Optional<Widget> child, Optional<Boolean> animateColor) {
    var st = WidgetFactories.material(factories);
    var fn = WidgetFactories.MaterialSt.material(st);
    return WidgetFactories.MaterialSt.material.invoke(fn, arena, ptrEnum(type),
      ptr(elevation),
      ptrObj(color),
      ptrObj(shadowColor),
      ptrObj(surfaceTintColor),
      ptrObj(textStyle),
      ptrObj(borderRadius),
      ptrObj(shape),
      ptrBool(borderOnForeground),
      ptrEnum(clipBehavior),
      ptrObj(animationDuration),
      ptrObj(child),
      ptrBool(animateColor));
  }

  MemorySegment iconButtonIconButton(OptionalDouble iconSize, Optional<VisualDensity> visualDensity, Optional<EdgeInsetsGeometry> padding, Optional<AlignmentGeometry> alignment, OptionalDouble splashRadius, Optional<Color> color, Optional<Color> focusColor, Optional<Color> hoverColor, Optional<Color> highlightColor, Optional<Color> splashColor, Optional<Color> disabledColor, Optional<Runnable> onPressed, Optional<Consumer<Boolean>> onHover, Optional<Runnable> onLongPress, Optional<Boolean> autofocus, Optional<String> tooltip, Optional<Boolean> enableFeedback, Optional<BoxConstraints> constraints, Optional<Boolean> isSelected, Optional<Widget> selectedIcon, Widget icon) {
    var st = WidgetFactories.iconButton(factories);
    var fn = WidgetFactories.IconButtonSt.iconButton(st);
    return WidgetFactories.IconButtonSt.iconButton.invoke(fn, arena, ptr(iconSize),
      ptrObj(visualDensity),
      ptrObj(padding),
      ptrObj(alignment),
      ptr(splashRadius),
      ptrObj(color),
      ptrObj(focusColor),
      ptrObj(hoverColor),
      ptrObj(highlightColor),
      ptrObj(splashColor),
      ptrObj(disabledColor),
      onPressed.isPresent() ? ptrHolder(ptrVoidCallbackFn(onPressed.get())) : MemorySegment.NULL,
      onHover.isPresent() ? ptrHolder(ptrValueChangedForBoolFn(onHover.get())) : MemorySegment.NULL,
      onLongPress.isPresent() ? ptrHolder(ptrVoidCallbackFn(onLongPress.get())) : MemorySegment.NULL,
      ptrBool(autofocus),
      ptrStr(tooltip),
      ptrBool(enableFeedback),
      ptrObj(constraints),
      ptrBool(isSelected),
      ptrObj(selectedIcon),
      icon.build().getId());
  }
  MemorySegment iconButtonFilled(OptionalDouble iconSize, Optional<VisualDensity> visualDensity, Optional<EdgeInsetsGeometry> padding, Optional<AlignmentGeometry> alignment, OptionalDouble splashRadius, Optional<Color> color, Optional<Color> focusColor, Optional<Color> hoverColor, Optional<Color> highlightColor, Optional<Color> splashColor, Optional<Color> disabledColor, Optional<Runnable> onPressed, Optional<Consumer<Boolean>> onHover, Optional<Runnable> onLongPress, Optional<Boolean> autofocus, Optional<String> tooltip, Optional<Boolean> enableFeedback, Optional<BoxConstraints> constraints, Optional<Boolean> isSelected, Optional<Widget> selectedIcon, Widget icon) {
    var st = WidgetFactories.iconButton(factories);
    var fn = WidgetFactories.IconButtonSt.filled(st);
    return WidgetFactories.IconButtonSt.filled.invoke(fn, arena, ptr(iconSize),
      ptrObj(visualDensity),
      ptrObj(padding),
      ptrObj(alignment),
      ptr(splashRadius),
      ptrObj(color),
      ptrObj(focusColor),
      ptrObj(hoverColor),
      ptrObj(highlightColor),
      ptrObj(splashColor),
      ptrObj(disabledColor),
      onPressed.isPresent() ? ptrHolder(ptrVoidCallbackFn(onPressed.get())) : MemorySegment.NULL,
      onHover.isPresent() ? ptrHolder(ptrValueChangedForBoolFn(onHover.get())) : MemorySegment.NULL,
      onLongPress.isPresent() ? ptrHolder(ptrVoidCallbackFn(onLongPress.get())) : MemorySegment.NULL,
      ptrBool(autofocus),
      ptrStr(tooltip),
      ptrBool(enableFeedback),
      ptrObj(constraints),
      ptrBool(isSelected),
      ptrObj(selectedIcon),
      icon.build().getId());
  }
  MemorySegment iconButtonFilledTonal(OptionalDouble iconSize, Optional<VisualDensity> visualDensity, Optional<EdgeInsetsGeometry> padding, Optional<AlignmentGeometry> alignment, OptionalDouble splashRadius, Optional<Color> color, Optional<Color> focusColor, Optional<Color> hoverColor, Optional<Color> highlightColor, Optional<Color> splashColor, Optional<Color> disabledColor, Optional<Runnable> onPressed, Optional<Consumer<Boolean>> onHover, Optional<Runnable> onLongPress, Optional<Boolean> autofocus, Optional<String> tooltip, Optional<Boolean> enableFeedback, Optional<BoxConstraints> constraints, Optional<Boolean> isSelected, Optional<Widget> selectedIcon, Widget icon) {
    var st = WidgetFactories.iconButton(factories);
    var fn = WidgetFactories.IconButtonSt.filledTonal(st);
    return WidgetFactories.IconButtonSt.filledTonal.invoke(fn, arena, ptr(iconSize),
      ptrObj(visualDensity),
      ptrObj(padding),
      ptrObj(alignment),
      ptr(splashRadius),
      ptrObj(color),
      ptrObj(focusColor),
      ptrObj(hoverColor),
      ptrObj(highlightColor),
      ptrObj(splashColor),
      ptrObj(disabledColor),
      onPressed.isPresent() ? ptrHolder(ptrVoidCallbackFn(onPressed.get())) : MemorySegment.NULL,
      onHover.isPresent() ? ptrHolder(ptrValueChangedForBoolFn(onHover.get())) : MemorySegment.NULL,
      onLongPress.isPresent() ? ptrHolder(ptrVoidCallbackFn(onLongPress.get())) : MemorySegment.NULL,
      ptrBool(autofocus),
      ptrStr(tooltip),
      ptrBool(enableFeedback),
      ptrObj(constraints),
      ptrBool(isSelected),
      ptrObj(selectedIcon),
      icon.build().getId());
  }
  MemorySegment iconButtonOutlined(OptionalDouble iconSize, Optional<VisualDensity> visualDensity, Optional<EdgeInsetsGeometry> padding, Optional<AlignmentGeometry> alignment, OptionalDouble splashRadius, Optional<Color> color, Optional<Color> focusColor, Optional<Color> hoverColor, Optional<Color> highlightColor, Optional<Color> splashColor, Optional<Color> disabledColor, Optional<Runnable> onPressed, Optional<Consumer<Boolean>> onHover, Optional<Runnable> onLongPress, Optional<Boolean> autofocus, Optional<String> tooltip, Optional<Boolean> enableFeedback, Optional<BoxConstraints> constraints, Optional<Boolean> isSelected, Optional<Widget> selectedIcon, Widget icon) {
    var st = WidgetFactories.iconButton(factories);
    var fn = WidgetFactories.IconButtonSt.outlined(st);
    return WidgetFactories.IconButtonSt.outlined.invoke(fn, arena, ptr(iconSize),
      ptrObj(visualDensity),
      ptrObj(padding),
      ptrObj(alignment),
      ptr(splashRadius),
      ptrObj(color),
      ptrObj(focusColor),
      ptrObj(hoverColor),
      ptrObj(highlightColor),
      ptrObj(splashColor),
      ptrObj(disabledColor),
      onPressed.isPresent() ? ptrHolder(ptrVoidCallbackFn(onPressed.get())) : MemorySegment.NULL,
      onHover.isPresent() ? ptrHolder(ptrValueChangedForBoolFn(onHover.get())) : MemorySegment.NULL,
      onLongPress.isPresent() ? ptrHolder(ptrVoidCallbackFn(onLongPress.get())) : MemorySegment.NULL,
      ptrBool(autofocus),
      ptrStr(tooltip),
      ptrBool(enableFeedback),
      ptrObj(constraints),
      ptrBool(isSelected),
      ptrObj(selectedIcon),
      icon.build().getId());
  }

  MemorySegment appBarAppBar(Optional<Widget> leading, Optional<Boolean> automaticallyImplyLeading, Optional<Widget> title, Optional<List<Widget>> actions, Optional<Widget> flexibleSpace, Optional<PreferredSizeWidget> bottom, OptionalDouble elevation, OptionalDouble scrolledUnderElevation, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, Optional<ShapeBorder> shape, Optional<Color> backgroundColor, Optional<Color> foregroundColor, Optional<Boolean> primary, Optional<Boolean> centerTitle, Optional<Boolean> excludeHeaderSemantics, OptionalDouble titleSpacing, OptionalDouble toolbarOpacity, OptionalDouble bottomOpacity, OptionalDouble toolbarHeight, OptionalDouble leadingWidth, Optional<TextStyle> toolbarTextStyle, Optional<TextStyle> titleTextStyle, Optional<Boolean> forceMaterialTransparency, Optional<Boolean> useDefaultSemanticsOrder, Optional<Clip> clipBehavior, Optional<EdgeInsetsGeometry> actionsPadding, Optional<Boolean> animateColor) {
    var st = WidgetFactories.appBar(factories);
    var fn = WidgetFactories.AppBarSt.appBar(st);
    return WidgetFactories.AppBarSt.appBar.invoke(fn, arena, ptrObj(leading),
      ptrBool(automaticallyImplyLeading),
      ptrObj(title),
      ptrList(actions),
      ptrObj(flexibleSpace),
      ptrObj(bottom),
      ptr(elevation),
      ptr(scrolledUnderElevation),
      ptrObj(shadowColor),
      ptrObj(surfaceTintColor),
      ptrObj(shape),
      ptrObj(backgroundColor),
      ptrObj(foregroundColor),
      ptrBool(primary),
      ptrBool(centerTitle),
      ptrBool(excludeHeaderSemantics),
      ptr(titleSpacing),
      ptr(toolbarOpacity),
      ptr(bottomOpacity),
      ptr(toolbarHeight),
      ptr(leadingWidth),
      ptrObj(toolbarTextStyle),
      ptrObj(titleTextStyle),
      ptrBool(forceMaterialTransparency),
      ptrBool(useDefaultSemanticsOrder),
      ptrEnum(clipBehavior),
      ptrObj(actionsPadding),
      ptrBool(animateColor));
  }

  MemorySegment scaffoldScaffold(Optional<PreferredSizeWidget> appBar, Optional<Widget> body, Optional<Widget> floatingActionButton, Optional<List<Widget>> persistentFooterButtons, Optional<AlignmentDirectional> persistentFooterAlignment, Optional<BoxDecoration> persistentFooterDecoration, Optional<Widget> drawer, Optional<Consumer<Boolean>> onDrawerChanged, Optional<Widget> endDrawer, Optional<Consumer<Boolean>> onEndDrawerChanged, Optional<Widget> bottomNavigationBar, Optional<Widget> bottomSheet, Optional<Color> backgroundColor, Optional<Boolean> resizeToAvoidBottomInset, Optional<Boolean> primary, Optional<DragStartBehavior> drawerDragStartBehavior, Optional<Boolean> extendBody, Optional<Boolean> drawerBarrierDismissible, Optional<Boolean> extendBodyBehindAppBar, Optional<Color> drawerScrimColor, Optional<BiFunction<BuildContext, Animation, Widget>> bottomSheetScrimBuilder, OptionalDouble drawerEdgeDragWidth, Optional<Boolean> drawerEnableOpenDragGesture, Optional<Boolean> endDrawerEnableOpenDragGesture, Optional<String> restorationId) {
    var st = WidgetFactories.scaffold(factories);
    var fn = WidgetFactories.ScaffoldSt.scaffold(st);
    return WidgetFactories.ScaffoldSt.scaffold.invoke(fn, arena, ptrObj(appBar),
      ptrObj(body),
      ptrObj(floatingActionButton),
      ptrList(persistentFooterButtons),
      ptrObj(persistentFooterAlignment),
      ptrObj(persistentFooterDecoration),
      ptrObj(drawer),
      onDrawerChanged.isPresent() ? ptrHolder(ptrDrawerCallbackFn(onDrawerChanged.get())) : MemorySegment.NULL,
      ptrObj(endDrawer),
      onEndDrawerChanged.isPresent() ? ptrHolder(ptrDrawerCallbackFn(onEndDrawerChanged.get())) : MemorySegment.NULL,
      ptrObj(bottomNavigationBar),
      ptrObj(bottomSheet),
      ptrObj(backgroundColor),
      ptrBool(resizeToAvoidBottomInset),
      ptrBool(primary),
      ptrEnum(drawerDragStartBehavior),
      ptrBool(extendBody),
      ptrBool(drawerBarrierDismissible),
      ptrBool(extendBodyBehindAppBar),
      ptrObj(drawerScrimColor),
      bottomSheetScrimBuilder.isPresent() ? ptrHolder(ptrDartObjCallbackDartObjDartObjFn(bottomSheetScrimBuilder.get())) : MemorySegment.NULL,
      ptr(drawerEdgeDragWidth),
      ptrBool(drawerEnableOpenDragGesture),
      ptrBool(endDrawerEnableOpenDragGesture),
      ptrStr(restorationId));
  }
  int scaffoldGeometryOf(BuildContext context) {
    var st = WidgetFactories.scaffold(factories);
    var fn = WidgetFactories.ScaffoldSt.geometryOf(st);
    return WidgetFactories.ScaffoldSt.geometryOf.invoke(fn, context.build().getId());
  }
  int scaffoldHasDrawer(BuildContext context, Optional<Boolean> registerForUpdates) {
    var st = WidgetFactories.scaffold(factories);
    var fn = WidgetFactories.ScaffoldSt.hasDrawer(st);
    return WidgetFactories.ScaffoldSt.hasDrawer.invoke(fn, context.build().getId(),
      ptrBool(registerForUpdates));
  }

  MemorySegment materialAppMaterialApp(Optional<Widget> home, Optional<String> initialRoute, Optional<BiFunction<BuildContext, Widget, Widget>> builder, Optional<String> title, Optional<Function<BuildContext, String>> onGenerateTitle, Optional<Color> color, Optional<ThemeData> theme, Optional<ThemeData> darkTheme, Optional<ThemeData> highContrastTheme, Optional<ThemeData> highContrastDarkTheme, Optional<ThemeMode> themeMode, Optional<Duration> themeAnimationDuration, Optional<Curve> themeAnimationCurve, Optional<Boolean> debugShowMaterialGrid, Optional<Boolean> showPerformanceOverlay, Optional<Boolean> checkerboardRasterCacheImages, Optional<Boolean> checkerboardOffscreenLayers, Optional<Boolean> showSemanticsDebugger, Optional<Boolean> debugShowCheckedModeBanner, Optional<String> restorationScopeId, Optional<Boolean> useInheritedMediaQuery) {
    var st = WidgetFactories.materialApp(factories);
    var fn = WidgetFactories.MaterialAppSt.materialApp(st);
    return WidgetFactories.MaterialAppSt.materialApp.invoke(fn, arena, ptrObj(home),
      ptrStr(initialRoute),
      builder.isPresent() ? ptrHolder(ptrTransitionBuilderFn(builder.get())) : MemorySegment.NULL,
      ptrStr(title),
      onGenerateTitle.isPresent() ? ptrHolder(ptrGenerateAppTitleFn(onGenerateTitle.get())) : MemorySegment.NULL,
      ptrObj(color),
      ptrObj(theme),
      ptrObj(darkTheme),
      ptrObj(highContrastTheme),
      ptrObj(highContrastDarkTheme),
      ptrEnum(themeMode),
      ptrObj(themeAnimationDuration),
      ptrObj(themeAnimationCurve),
      ptrBool(debugShowMaterialGrid),
      ptrBool(showPerformanceOverlay),
      ptrBool(checkerboardRasterCacheImages),
      ptrBool(checkerboardOffscreenLayers),
      ptrBool(showSemanticsDebugger),
      ptrBool(debugShowCheckedModeBanner),
      ptrStr(restorationScopeId),
      ptrBool(useInheritedMediaQuery));
  }
  MemorySegment materialAppRouter(Optional<BiFunction<BuildContext, Widget, Widget>> builder, Optional<String> title, Optional<Function<BuildContext, String>> onGenerateTitle, Optional<Color> color, Optional<ThemeData> theme, Optional<ThemeData> darkTheme, Optional<ThemeData> highContrastTheme, Optional<ThemeData> highContrastDarkTheme, Optional<ThemeMode> themeMode, Optional<Duration> themeAnimationDuration, Optional<Curve> themeAnimationCurve, Optional<Boolean> debugShowMaterialGrid, Optional<Boolean> showPerformanceOverlay, Optional<Boolean> checkerboardRasterCacheImages, Optional<Boolean> checkerboardOffscreenLayers, Optional<Boolean> showSemanticsDebugger, Optional<Boolean> debugShowCheckedModeBanner, Optional<String> restorationScopeId, Optional<Boolean> useInheritedMediaQuery) {
    var st = WidgetFactories.materialApp(factories);
    var fn = WidgetFactories.MaterialAppSt.router(st);
    return WidgetFactories.MaterialAppSt.router.invoke(fn, arena, builder.isPresent() ? ptrHolder(ptrTransitionBuilderFn(builder.get())) : MemorySegment.NULL,
      ptrStr(title),
      onGenerateTitle.isPresent() ? ptrHolder(ptrGenerateAppTitleFn(onGenerateTitle.get())) : MemorySegment.NULL,
      ptrObj(color),
      ptrObj(theme),
      ptrObj(darkTheme),
      ptrObj(highContrastTheme),
      ptrObj(highContrastDarkTheme),
      ptrEnum(themeMode),
      ptrObj(themeAnimationDuration),
      ptrObj(themeAnimationCurve),
      ptrBool(debugShowMaterialGrid),
      ptrBool(showPerformanceOverlay),
      ptrBool(checkerboardRasterCacheImages),
      ptrBool(checkerboardOffscreenLayers),
      ptrBool(showSemanticsDebugger),
      ptrBool(debugShowCheckedModeBanner),
      ptrStr(restorationScopeId),
      ptrBool(useInheritedMediaQuery));
  }

  MemorySegment floatingActionButtonFloatingActionButton(Optional<Widget> child, Optional<String> tooltip, Optional<Color> foregroundColor, Optional<Color> backgroundColor, Optional<Color> focusColor, Optional<Color> hoverColor, Optional<Color> splashColor, Optional<NativeObj> heroTag, OptionalDouble elevation, OptionalDouble focusElevation, OptionalDouble hoverElevation, OptionalDouble highlightElevation, OptionalDouble disabledElevation, Optional<Runnable> onPressed, Optional<Boolean> mini, Optional<ShapeBorder> shape, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<Boolean> isExtended, Optional<Boolean> enableFeedback) {
    var st = WidgetFactories.floatingActionButton(factories);
    var fn = WidgetFactories.FloatingActionButtonSt.floatingActionButton(st);
    return WidgetFactories.FloatingActionButtonSt.floatingActionButton.invoke(fn, arena, ptrObj(child),
      ptrStr(tooltip),
      ptrObj(foregroundColor),
      ptrObj(backgroundColor),
      ptrObj(focusColor),
      ptrObj(hoverColor),
      ptrObj(splashColor),
      ptrObj(heroTag),
      ptr(elevation),
      ptr(focusElevation),
      ptr(hoverElevation),
      ptr(highlightElevation),
      ptr(disabledElevation),
      onPressed.isPresent() ? ptrHolder(ptrVoidCallbackFn(onPressed.get())) : MemorySegment.NULL,
      ptrBool(mini),
      ptrObj(shape),
      ptrEnum(clipBehavior),
      ptrBool(autofocus),
      ptrEnum(materialTapTargetSize),
      ptrBool(isExtended),
      ptrBool(enableFeedback));
  }
  MemorySegment floatingActionButtonSmall(Optional<Widget> child, Optional<String> tooltip, Optional<Color> foregroundColor, Optional<Color> backgroundColor, Optional<Color> focusColor, Optional<Color> hoverColor, Optional<Color> splashColor, Optional<NativeObj> heroTag, OptionalDouble elevation, OptionalDouble focusElevation, OptionalDouble hoverElevation, OptionalDouble highlightElevation, OptionalDouble disabledElevation, Optional<Runnable> onPressed, Optional<ShapeBorder> shape, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<Boolean> enableFeedback) {
    var st = WidgetFactories.floatingActionButton(factories);
    var fn = WidgetFactories.FloatingActionButtonSt.small(st);
    return WidgetFactories.FloatingActionButtonSt.small.invoke(fn, arena, ptrObj(child),
      ptrStr(tooltip),
      ptrObj(foregroundColor),
      ptrObj(backgroundColor),
      ptrObj(focusColor),
      ptrObj(hoverColor),
      ptrObj(splashColor),
      ptrObj(heroTag),
      ptr(elevation),
      ptr(focusElevation),
      ptr(hoverElevation),
      ptr(highlightElevation),
      ptr(disabledElevation),
      onPressed.isPresent() ? ptrHolder(ptrVoidCallbackFn(onPressed.get())) : MemorySegment.NULL,
      ptrObj(shape),
      ptrEnum(clipBehavior),
      ptrBool(autofocus),
      ptrEnum(materialTapTargetSize),
      ptrBool(enableFeedback));
  }
  MemorySegment floatingActionButtonLarge(Optional<Widget> child, Optional<String> tooltip, Optional<Color> foregroundColor, Optional<Color> backgroundColor, Optional<Color> focusColor, Optional<Color> hoverColor, Optional<Color> splashColor, Optional<NativeObj> heroTag, OptionalDouble elevation, OptionalDouble focusElevation, OptionalDouble hoverElevation, OptionalDouble highlightElevation, OptionalDouble disabledElevation, Optional<Runnable> onPressed, Optional<ShapeBorder> shape, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<Boolean> enableFeedback) {
    var st = WidgetFactories.floatingActionButton(factories);
    var fn = WidgetFactories.FloatingActionButtonSt.large(st);
    return WidgetFactories.FloatingActionButtonSt.large.invoke(fn, arena, ptrObj(child),
      ptrStr(tooltip),
      ptrObj(foregroundColor),
      ptrObj(backgroundColor),
      ptrObj(focusColor),
      ptrObj(hoverColor),
      ptrObj(splashColor),
      ptrObj(heroTag),
      ptr(elevation),
      ptr(focusElevation),
      ptr(hoverElevation),
      ptr(highlightElevation),
      ptr(disabledElevation),
      onPressed.isPresent() ? ptrHolder(ptrVoidCallbackFn(onPressed.get())) : MemorySegment.NULL,
      ptrObj(shape),
      ptrEnum(clipBehavior),
      ptrBool(autofocus),
      ptrEnum(materialTapTargetSize),
      ptrBool(enableFeedback));
  }
  MemorySegment floatingActionButtonExtended(Optional<String> tooltip, Optional<Color> foregroundColor, Optional<Color> backgroundColor, Optional<Color> focusColor, Optional<Color> hoverColor, Optional<NativeObj> heroTag, OptionalDouble elevation, OptionalDouble focusElevation, OptionalDouble hoverElevation, Optional<Color> splashColor, OptionalDouble highlightElevation, OptionalDouble disabledElevation, Optional<Runnable> onPressed, Optional<ShapeBorder> shape, Optional<Boolean> isExtended, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, OptionalDouble extendedIconLabelSpacing, Optional<EdgeInsetsGeometry> extendedPadding, Optional<TextStyle> extendedTextStyle, Optional<Widget> icon, Widget label, Optional<Boolean> enableFeedback) {
    var st = WidgetFactories.floatingActionButton(factories);
    var fn = WidgetFactories.FloatingActionButtonSt.extended(st);
    return WidgetFactories.FloatingActionButtonSt.extended.invoke(fn, arena, ptrStr(tooltip),
      ptrObj(foregroundColor),
      ptrObj(backgroundColor),
      ptrObj(focusColor),
      ptrObj(hoverColor),
      ptrObj(heroTag),
      ptr(elevation),
      ptr(focusElevation),
      ptr(hoverElevation),
      ptrObj(splashColor),
      ptr(highlightElevation),
      ptr(disabledElevation),
      onPressed.isPresent() ? ptrHolder(ptrVoidCallbackFn(onPressed.get())) : MemorySegment.NULL,
      ptrObj(shape),
      ptrBool(isExtended),
      ptrEnum(materialTapTargetSize),
      ptrEnum(clipBehavior),
      ptrBool(autofocus),
      ptr(extendedIconLabelSpacing),
      ptrObj(extendedPadding),
      ptrObj(extendedTextStyle),
      ptrObj(icon),
      label.build().getId(),
      ptrBool(enableFeedback));
  }

  MemorySegment themeTheme(ThemeData data, Widget child) {
    var st = WidgetFactories.theme(factories);
    var fn = WidgetFactories.ThemeSt.theme(st);
    return WidgetFactories.ThemeSt.theme.invoke(fn, arena, data.build().getId(),
      child.build().getId());
  }
  MemorySegment themeOf(BuildContext context) {
    var st = WidgetFactories.theme(factories);
    var fn = WidgetFactories.ThemeSt.of(st);
    return WidgetFactories.ThemeSt.of.invoke(fn, arena, context.build().getId());
  }
  int themeBrightnessOf(BuildContext context) {
    var st = WidgetFactories.theme(factories);
    var fn = WidgetFactories.ThemeSt.brightnessOf(st);
    return WidgetFactories.ThemeSt.brightnessOf.invoke(fn, context.build().getId());
  }
  int themeMaybeBrightnessOf(BuildContext context) {
    var st = WidgetFactories.theme(factories);
    var fn = WidgetFactories.ThemeSt.maybeBrightnessOf(st);
    return WidgetFactories.ThemeSt.maybeBrightnessOf.invoke(fn, context.build().getId());
  }

  MemorySegment elevatedButtonElevatedButton(Optional<Runnable> onPressed, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Clip> clipBehavior, Optional<Widget> child) {
    var st = WidgetFactories.elevatedButton(factories);
    var fn = WidgetFactories.ElevatedButtonSt.elevatedButton(st);
    return WidgetFactories.ElevatedButtonSt.elevatedButton.invoke(fn, arena, onPressed.isPresent() ? ptrHolder(ptrVoidCallbackFn(onPressed.get())) : MemorySegment.NULL,
      onLongPress.isPresent() ? ptrHolder(ptrVoidCallbackFn(onLongPress.get())) : MemorySegment.NULL,
      onHover.isPresent() ? ptrHolder(ptrValueChangedForBoolFn(onHover.get())) : MemorySegment.NULL,
      onFocusChange.isPresent() ? ptrHolder(ptrValueChangedForBoolFn(onFocusChange.get())) : MemorySegment.NULL,
      ptrBool(autofocus),
      ptrEnum(clipBehavior),
      ptrObj(child));
  }
  MemorySegment elevatedButtonIcon(Optional<Runnable> onPressed, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Clip> clipBehavior, Optional<Widget> icon, Widget label, Optional<IconAlignment> iconAlignment) {
    var st = WidgetFactories.elevatedButton(factories);
    var fn = WidgetFactories.ElevatedButtonSt.icon(st);
    return WidgetFactories.ElevatedButtonSt.icon.invoke(fn, arena, onPressed.isPresent() ? ptrHolder(ptrVoidCallbackFn(onPressed.get())) : MemorySegment.NULL,
      onLongPress.isPresent() ? ptrHolder(ptrVoidCallbackFn(onLongPress.get())) : MemorySegment.NULL,
      onHover.isPresent() ? ptrHolder(ptrValueChangedForBoolFn(onHover.get())) : MemorySegment.NULL,
      onFocusChange.isPresent() ? ptrHolder(ptrValueChangedForBoolFn(onFocusChange.get())) : MemorySegment.NULL,
      ptrBool(autofocus),
      ptrEnum(clipBehavior),
      ptrObj(icon),
      label.build().getId(),
      ptrEnum(iconAlignment));
  }

  MemorySegment outlinedButtonOutlinedButton(Optional<Runnable> onPressed, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Clip> clipBehavior, Optional<Widget> child) {
    var st = WidgetFactories.outlinedButton(factories);
    var fn = WidgetFactories.OutlinedButtonSt.outlinedButton(st);
    return WidgetFactories.OutlinedButtonSt.outlinedButton.invoke(fn, arena, onPressed.isPresent() ? ptrHolder(ptrVoidCallbackFn(onPressed.get())) : MemorySegment.NULL,
      onLongPress.isPresent() ? ptrHolder(ptrVoidCallbackFn(onLongPress.get())) : MemorySegment.NULL,
      onHover.isPresent() ? ptrHolder(ptrValueChangedForBoolFn(onHover.get())) : MemorySegment.NULL,
      onFocusChange.isPresent() ? ptrHolder(ptrValueChangedForBoolFn(onFocusChange.get())) : MemorySegment.NULL,
      ptrBool(autofocus),
      ptrEnum(clipBehavior),
      ptrObj(child));
  }
  MemorySegment outlinedButtonIcon(Optional<Runnable> onPressed, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Clip> clipBehavior, Optional<Widget> icon, Widget label, Optional<IconAlignment> iconAlignment) {
    var st = WidgetFactories.outlinedButton(factories);
    var fn = WidgetFactories.OutlinedButtonSt.icon(st);
    return WidgetFactories.OutlinedButtonSt.icon.invoke(fn, arena, onPressed.isPresent() ? ptrHolder(ptrVoidCallbackFn(onPressed.get())) : MemorySegment.NULL,
      onLongPress.isPresent() ? ptrHolder(ptrVoidCallbackFn(onLongPress.get())) : MemorySegment.NULL,
      onHover.isPresent() ? ptrHolder(ptrValueChangedForBoolFn(onHover.get())) : MemorySegment.NULL,
      onFocusChange.isPresent() ? ptrHolder(ptrValueChangedForBoolFn(onFocusChange.get())) : MemorySegment.NULL,
      ptrBool(autofocus),
      ptrEnum(clipBehavior),
      ptrObj(icon),
      label.build().getId(),
      ptrEnum(iconAlignment));
  }

  MemorySegment textButtonTextButton(Optional<Runnable> onPressed, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Clip> clipBehavior, Optional<Boolean> isSemanticButton, Widget child) {
    var st = WidgetFactories.textButton(factories);
    var fn = WidgetFactories.TextButtonSt.textButton(st);
    return WidgetFactories.TextButtonSt.textButton.invoke(fn, arena, onPressed.isPresent() ? ptrHolder(ptrVoidCallbackFn(onPressed.get())) : MemorySegment.NULL,
      onLongPress.isPresent() ? ptrHolder(ptrVoidCallbackFn(onLongPress.get())) : MemorySegment.NULL,
      onHover.isPresent() ? ptrHolder(ptrValueChangedForBoolFn(onHover.get())) : MemorySegment.NULL,
      onFocusChange.isPresent() ? ptrHolder(ptrValueChangedForBoolFn(onFocusChange.get())) : MemorySegment.NULL,
      ptrBool(autofocus),
      ptrEnum(clipBehavior),
      ptrBool(isSemanticButton),
      child.build().getId());
  }
  MemorySegment textButtonIcon(Optional<Runnable> onPressed, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Clip> clipBehavior, Optional<Widget> icon, Widget label, Optional<IconAlignment> iconAlignment) {
    var st = WidgetFactories.textButton(factories);
    var fn = WidgetFactories.TextButtonSt.icon(st);
    return WidgetFactories.TextButtonSt.icon.invoke(fn, arena, onPressed.isPresent() ? ptrHolder(ptrVoidCallbackFn(onPressed.get())) : MemorySegment.NULL,
      onLongPress.isPresent() ? ptrHolder(ptrVoidCallbackFn(onLongPress.get())) : MemorySegment.NULL,
      onHover.isPresent() ? ptrHolder(ptrValueChangedForBoolFn(onHover.get())) : MemorySegment.NULL,
      onFocusChange.isPresent() ? ptrHolder(ptrValueChangedForBoolFn(onFocusChange.get())) : MemorySegment.NULL,
      ptrBool(autofocus),
      ptrEnum(clipBehavior),
      ptrObj(icon),
      label.build().getId(),
      ptrEnum(iconAlignment));
  }

  int navigatorStateNavigatorState() {
    var st = WidgetFactories.navigatorState(factories);
    var fn = WidgetFactories.NavigatorStateSt.navigatorState(st);
    return WidgetFactories.NavigatorStateSt.navigatorState.invoke(fn);
  }

  MemorySegment navigatorNavigator(Optional<String> initialRoute, Optional<Boolean> reportsRouteUpdateToEngine, Optional<Clip> clipBehavior, Optional<Boolean> requestFocus, Optional<String> restorationScopeId, Optional<TraversalEdgeBehavior> routeTraversalEdgeBehavior, Optional<TraversalEdgeBehavior> routeDirectionalTraversalEdgeBehavior) {
    var st = WidgetFactories.navigator(factories);
    var fn = WidgetFactories.NavigatorSt.navigator(st);
    return WidgetFactories.NavigatorSt.navigator.invoke(fn, arena, ptrStr(initialRoute),
      ptrBool(reportsRouteUpdateToEngine),
      ptrEnum(clipBehavior),
      ptrBool(requestFocus),
      ptrStr(restorationScopeId),
      ptrEnum(routeTraversalEdgeBehavior),
      ptrEnum(routeDirectionalTraversalEdgeBehavior));
  }
  <T extends NativeObj> int navigatorPushNamed(BuildContext context, String routeName, Optional<NativeObj> arguments) {
    var st = WidgetFactories.navigator(factories);
    var fn = WidgetFactories.NavigatorSt.pushNamed(st);
    return WidgetFactories.NavigatorSt.pushNamed.invoke(fn, context.build().getId(),
      arena.allocateFrom(routeName),
      ptrObj(arguments));
  }
  MemorySegment navigatorRestorablePushNamed(BuildContext context, String routeName, Optional<NativeObj> arguments) {
    var st = WidgetFactories.navigator(factories);
    var fn = WidgetFactories.NavigatorSt.restorablePushNamed(st);
    return WidgetFactories.NavigatorSt.restorablePushNamed.invoke(fn, context.build().getId(),
      arena.allocateFrom(routeName),
      ptrObj(arguments));
  }
  <TO extends NativeObj, T extends NativeObj> int navigatorPushReplacementNamed(BuildContext context, String routeName, Optional<NativeObj> result, Optional<NativeObj> arguments) {
    var st = WidgetFactories.navigator(factories);
    var fn = WidgetFactories.NavigatorSt.pushReplacementNamed(st);
    return WidgetFactories.NavigatorSt.pushReplacementNamed.invoke(fn, context.build().getId(),
      arena.allocateFrom(routeName),
      ptrObj(result),
      ptrObj(arguments));
  }
  <TO extends NativeObj> MemorySegment navigatorRestorablePushReplacementNamed(BuildContext context, String routeName, Optional<NativeObj> result, Optional<NativeObj> arguments) {
    var st = WidgetFactories.navigator(factories);
    var fn = WidgetFactories.NavigatorSt.restorablePushReplacementNamed(st);
    return WidgetFactories.NavigatorSt.restorablePushReplacementNamed.invoke(fn, context.build().getId(),
      arena.allocateFrom(routeName),
      ptrObj(result),
      ptrObj(arguments));
  }
  <TO extends NativeObj, T extends NativeObj> int navigatorPopAndPushNamed(BuildContext context, String routeName, Optional<NativeObj> result, Optional<NativeObj> arguments) {
    var st = WidgetFactories.navigator(factories);
    var fn = WidgetFactories.NavigatorSt.popAndPushNamed(st);
    return WidgetFactories.NavigatorSt.popAndPushNamed.invoke(fn, context.build().getId(),
      arena.allocateFrom(routeName),
      ptrObj(result),
      ptrObj(arguments));
  }
  <TO extends NativeObj> MemorySegment navigatorRestorablePopAndPushNamed(BuildContext context, String routeName, Optional<NativeObj> result, Optional<NativeObj> arguments) {
    var st = WidgetFactories.navigator(factories);
    var fn = WidgetFactories.NavigatorSt.restorablePopAndPushNamed(st);
    return WidgetFactories.NavigatorSt.restorablePopAndPushNamed.invoke(fn, context.build().getId(),
      arena.allocateFrom(routeName),
      ptrObj(result),
      ptrObj(arguments));
  }
  int navigatorCanPop(BuildContext context) {
    var st = WidgetFactories.navigator(factories);
    var fn = WidgetFactories.NavigatorSt.canPop(st);
    return WidgetFactories.NavigatorSt.canPop.invoke(fn, context.build().getId());
  }
  <T extends NativeObj> int navigatorMaybePop(BuildContext context, Optional<NativeObj> result) {
    var st = WidgetFactories.navigator(factories);
    var fn = WidgetFactories.NavigatorSt.maybePop(st);
    return WidgetFactories.NavigatorSt.maybePop.invoke(fn, context.build().getId(),
      ptrObj(result));
  }
  <T extends NativeObj> void navigatorPop(BuildContext context, Optional<NativeObj> result) {
    var st = WidgetFactories.navigator(factories);
    var fn = WidgetFactories.NavigatorSt.pop(st);
    WidgetFactories.NavigatorSt.pop.invoke(fn, context.build().getId(),
      ptrObj(result));
  }
  int navigatorOf(BuildContext context, Optional<Boolean> rootNavigator) {
    var st = WidgetFactories.navigator(factories);
    var fn = WidgetFactories.NavigatorSt.of(st);
    return WidgetFactories.NavigatorSt.of.invoke(fn, context.build().getId(),
      ptrBool(rootNavigator));
  }
  int navigatorMaybeOf(BuildContext context, Optional<Boolean> rootNavigator) {
    var st = WidgetFactories.navigator(factories);
    var fn = WidgetFactories.NavigatorSt.maybeOf(st);
    return WidgetFactories.NavigatorSt.maybeOf.invoke(fn, context.build().getId(),
      ptrBool(rootNavigator));
  }

  MemorySegment alertDialogAlertDialog(Optional<Widget> icon, Optional<EdgeInsetsGeometry> iconPadding, Optional<Color> iconColor, Optional<Widget> title, Optional<EdgeInsetsGeometry> titlePadding, Optional<TextStyle> titleTextStyle, Optional<Widget> content, Optional<EdgeInsetsGeometry> contentPadding, Optional<TextStyle> contentTextStyle, Optional<List<Widget>> actions, Optional<EdgeInsetsGeometry> actionsPadding, Optional<MainAxisAlignment> actionsAlignment, Optional<OverflowBarAlignment> actionsOverflowAlignment, Optional<VerticalDirection> actionsOverflowDirection, OptionalDouble actionsOverflowButtonSpacing, Optional<EdgeInsetsGeometry> buttonPadding, Optional<Color> backgroundColor, OptionalDouble elevation, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, Optional<String> semanticLabel, Optional<EdgeInsets> insetPadding, Optional<Clip> clipBehavior, Optional<ShapeBorder> shape, Optional<AlignmentGeometry> alignment, Optional<BoxConstraints> constraints, Optional<Boolean> scrollable) {
    var st = WidgetFactories.alertDialog(factories);
    var fn = WidgetFactories.AlertDialogSt.alertDialog(st);
    return WidgetFactories.AlertDialogSt.alertDialog.invoke(fn, arena, ptrObj(icon),
      ptrObj(iconPadding),
      ptrObj(iconColor),
      ptrObj(title),
      ptrObj(titlePadding),
      ptrObj(titleTextStyle),
      ptrObj(content),
      ptrObj(contentPadding),
      ptrObj(contentTextStyle),
      ptrList(actions),
      ptrObj(actionsPadding),
      ptrEnum(actionsAlignment),
      ptrEnum(actionsOverflowAlignment),
      ptrEnum(actionsOverflowDirection),
      ptr(actionsOverflowButtonSpacing),
      ptrObj(buttonPadding),
      ptrObj(backgroundColor),
      ptr(elevation),
      ptrObj(shadowColor),
      ptrObj(surfaceTintColor),
      ptrStr(semanticLabel),
      ptrObj(insetPadding),
      ptrEnum(clipBehavior),
      ptrObj(shape),
      ptrObj(alignment),
      ptrObj(constraints),
      ptrBool(scrollable));
  }
  MemorySegment alertDialogAdaptive(Optional<Widget> icon, Optional<EdgeInsetsGeometry> iconPadding, Optional<Color> iconColor, Optional<Widget> title, Optional<EdgeInsetsGeometry> titlePadding, Optional<TextStyle> titleTextStyle, Optional<Widget> content, Optional<EdgeInsetsGeometry> contentPadding, Optional<TextStyle> contentTextStyle, Optional<List<Widget>> actions, Optional<EdgeInsetsGeometry> actionsPadding, Optional<MainAxisAlignment> actionsAlignment, Optional<OverflowBarAlignment> actionsOverflowAlignment, Optional<VerticalDirection> actionsOverflowDirection, OptionalDouble actionsOverflowButtonSpacing, Optional<EdgeInsetsGeometry> buttonPadding, Optional<Color> backgroundColor, OptionalDouble elevation, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, Optional<String> semanticLabel, Optional<EdgeInsets> insetPadding, Optional<Clip> clipBehavior, Optional<ShapeBorder> shape, Optional<AlignmentGeometry> alignment, Optional<BoxConstraints> constraints, Optional<Boolean> scrollable, Optional<Duration> insetAnimationDuration, Optional<Curve> insetAnimationCurve) {
    var st = WidgetFactories.alertDialog(factories);
    var fn = WidgetFactories.AlertDialogSt.adaptive(st);
    return WidgetFactories.AlertDialogSt.adaptive.invoke(fn, arena, ptrObj(icon),
      ptrObj(iconPadding),
      ptrObj(iconColor),
      ptrObj(title),
      ptrObj(titlePadding),
      ptrObj(titleTextStyle),
      ptrObj(content),
      ptrObj(contentPadding),
      ptrObj(contentTextStyle),
      ptrList(actions),
      ptrObj(actionsPadding),
      ptrEnum(actionsAlignment),
      ptrEnum(actionsOverflowAlignment),
      ptrEnum(actionsOverflowDirection),
      ptr(actionsOverflowButtonSpacing),
      ptrObj(buttonPadding),
      ptrObj(backgroundColor),
      ptr(elevation),
      ptrObj(shadowColor),
      ptrObj(surfaceTintColor),
      ptrStr(semanticLabel),
      ptrObj(insetPadding),
      ptrEnum(clipBehavior),
      ptrObj(shape),
      ptrObj(alignment),
      ptrObj(constraints),
      ptrBool(scrollable),
      ptrObj(insetAnimationDuration),
      ptrObj(insetAnimationCurve));
  }

  MemorySegment textFieldTextField(Optional<NativeObj> groupId, Optional<InputDecoration> decoration, Optional<TextInputAction> textInputAction, Optional<TextCapitalization> textCapitalization, Optional<TextStyle> style, Optional<TextAlign> textAlign, Optional<TextDirection> textDirection, Optional<Boolean> readOnly, Optional<Boolean> showCursor, Optional<Boolean> autofocus, Optional<String> obscuringCharacter, Optional<Boolean> obscureText, Optional<Boolean> autocorrect, Optional<SmartDashesType> smartDashesType, Optional<SmartQuotesType> smartQuotesType, Optional<Boolean> enableSuggestions, OptionalInt maxLines, OptionalInt minLines, Optional<Boolean> expands, OptionalInt maxLength, Optional<MaxLengthEnforcement> maxLengthEnforcement, Optional<Consumer<String>> onChanged, Optional<Runnable> onEditingComplete, Optional<Consumer<String>> onSubmitted, Optional<Boolean> enabled, Optional<Boolean> ignorePointers, OptionalDouble cursorWidth, OptionalDouble cursorHeight, Optional<Radius> cursorRadius, Optional<Boolean> cursorOpacityAnimates, Optional<Color> cursorColor, Optional<Color> cursorErrorColor, Optional<BoxHeightStyle> selectionHeightStyle, Optional<BoxWidthStyle> selectionWidthStyle, Optional<Brightness> keyboardAppearance, Optional<EdgeInsets> scrollPadding, Optional<DragStartBehavior> dragStartBehavior, Optional<Boolean> enableInteractiveSelection, Optional<Boolean> selectAllOnFocus, Optional<Runnable> onTap, Optional<Boolean> onTapAlwaysCalled, Optional<Consumer<PointerDownEvent>> onTapOutside, Optional<Consumer<PointerUpEvent>> onTapUpOutside, Optional<QuadFunction<BuildContext, Integer, Boolean, Integer, Widget>> buildCounter, Optional<List<String>> autofillHints, Optional<Clip> clipBehavior, Optional<String> restorationId, Optional<Boolean> scribbleEnabled, Optional<Boolean> stylusHandwritingEnabled, Optional<Boolean> enableIMEPersonalizedLearning, Optional<Boolean> canRequestFocus) {
    var st = WidgetFactories.textField(factories);
    var fn = WidgetFactories.TextFieldSt.textField(st);
    return WidgetFactories.TextFieldSt.textField.invoke(fn, arena, ptrObj(groupId),
      ptrObj(decoration),
      ptrEnum(textInputAction),
      ptrEnum(textCapitalization),
      ptrObj(style),
      ptrEnum(textAlign),
      ptrEnum(textDirection),
      ptrBool(readOnly),
      ptrBool(showCursor),
      ptrBool(autofocus),
      ptrStr(obscuringCharacter),
      ptrBool(obscureText),
      ptrBool(autocorrect),
      ptrEnum(smartDashesType),
      ptrEnum(smartQuotesType),
      ptrBool(enableSuggestions),
      ptr(maxLines),
      ptr(minLines),
      ptrBool(expands),
      ptr(maxLength),
      ptrEnum(maxLengthEnforcement),
      onChanged.isPresent() ? ptrHolder(ptrValueChangedForStringFn(onChanged.get())) : MemorySegment.NULL,
      onEditingComplete.isPresent() ? ptrHolder(ptrVoidCallbackFn(onEditingComplete.get())) : MemorySegment.NULL,
      onSubmitted.isPresent() ? ptrHolder(ptrValueChangedForStringFn(onSubmitted.get())) : MemorySegment.NULL,
      ptrBool(enabled),
      ptrBool(ignorePointers),
      ptr(cursorWidth),
      ptr(cursorHeight),
      ptrObj(cursorRadius),
      ptrBool(cursorOpacityAnimates),
      ptrObj(cursorColor),
      ptrObj(cursorErrorColor),
      ptrEnum(selectionHeightStyle),
      ptrEnum(selectionWidthStyle),
      ptrEnum(keyboardAppearance),
      ptrObj(scrollPadding),
      ptrEnum(dragStartBehavior),
      ptrBool(enableInteractiveSelection),
      ptrBool(selectAllOnFocus),
      onTap.isPresent() ? ptrHolder(ptrGestureTapCallbackFn(onTap.get())) : MemorySegment.NULL,
      ptrBool(onTapAlwaysCalled),
      onTapOutside.isPresent() ? ptrHolder(ptrTapRegionCallbackFn(onTapOutside.get())) : MemorySegment.NULL,
      onTapUpOutside.isPresent() ? ptrHolder(ptrTapRegionUpCallbackFn(onTapUpOutside.get())) : MemorySegment.NULL,
      buildCounter.isPresent() ? ptrHolder(ptrInputCounterWidgetBuilderFn(buildCounter.get())) : MemorySegment.NULL,
      ptrStrList(autofillHints),
      ptrEnum(clipBehavior),
      ptrStr(restorationId),
      ptrBool(scribbleEnabled),
      ptrBool(stylusHandwritingEnabled),
      ptrBool(enableIMEPersonalizedLearning),
      ptrBool(canRequestFocus));
  }

  MemorySegment dividerDivider(OptionalDouble height, OptionalDouble thickness, OptionalDouble indent, OptionalDouble endIndent, Optional<Color> color, Optional<BorderRadiusGeometry> radius) {
    var st = WidgetFactories.divider(factories);
    var fn = WidgetFactories.DividerSt.divider(st);
    return WidgetFactories.DividerSt.divider.invoke(fn, arena, ptr(height),
      ptr(thickness),
      ptr(indent),
      ptr(endIndent),
      ptrObj(color),
      ptrObj(radius));
  }
  MemorySegment dividerCreateBorderSide(BuildContext context, Optional<Color> color, OptionalDouble width) {
    var st = WidgetFactories.divider(factories);
    var fn = WidgetFactories.DividerSt.createBorderSide(st);
    return WidgetFactories.DividerSt.createBorderSide.invoke(fn, arena, context != null ? context.build().getId() : null,
      ptrObj(color),
      ptr(width));
  }

  MemorySegment filledButtonFilledButton(Optional<Runnable> onPressed, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Clip> clipBehavior, Optional<Widget> child) {
    var st = WidgetFactories.filledButton(factories);
    var fn = WidgetFactories.FilledButtonSt.filledButton(st);
    return WidgetFactories.FilledButtonSt.filledButton.invoke(fn, arena, onPressed.isPresent() ? ptrHolder(ptrVoidCallbackFn(onPressed.get())) : MemorySegment.NULL,
      onLongPress.isPresent() ? ptrHolder(ptrVoidCallbackFn(onLongPress.get())) : MemorySegment.NULL,
      onHover.isPresent() ? ptrHolder(ptrValueChangedForBoolFn(onHover.get())) : MemorySegment.NULL,
      onFocusChange.isPresent() ? ptrHolder(ptrValueChangedForBoolFn(onFocusChange.get())) : MemorySegment.NULL,
      ptrBool(autofocus),
      ptrEnum(clipBehavior),
      ptrObj(child));
  }
  MemorySegment filledButtonIcon(Optional<Runnable> onPressed, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Clip> clipBehavior, Optional<Widget> icon, Widget label, Optional<IconAlignment> iconAlignment) {
    var st = WidgetFactories.filledButton(factories);
    var fn = WidgetFactories.FilledButtonSt.icon(st);
    return WidgetFactories.FilledButtonSt.icon.invoke(fn, arena, onPressed.isPresent() ? ptrHolder(ptrVoidCallbackFn(onPressed.get())) : MemorySegment.NULL,
      onLongPress.isPresent() ? ptrHolder(ptrVoidCallbackFn(onLongPress.get())) : MemorySegment.NULL,
      onHover.isPresent() ? ptrHolder(ptrValueChangedForBoolFn(onHover.get())) : MemorySegment.NULL,
      onFocusChange.isPresent() ? ptrHolder(ptrValueChangedForBoolFn(onFocusChange.get())) : MemorySegment.NULL,
      ptrBool(autofocus),
      ptrEnum(clipBehavior),
      ptrObj(icon),
      label.build().getId(),
      ptrEnum(iconAlignment));
  }
  MemorySegment filledButtonTonal(Optional<Runnable> onPressed, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Clip> clipBehavior, Optional<Widget> child) {
    var st = WidgetFactories.filledButton(factories);
    var fn = WidgetFactories.FilledButtonSt.tonal(st);
    return WidgetFactories.FilledButtonSt.tonal.invoke(fn, arena, onPressed.isPresent() ? ptrHolder(ptrVoidCallbackFn(onPressed.get())) : MemorySegment.NULL,
      onLongPress.isPresent() ? ptrHolder(ptrVoidCallbackFn(onLongPress.get())) : MemorySegment.NULL,
      onHover.isPresent() ? ptrHolder(ptrValueChangedForBoolFn(onHover.get())) : MemorySegment.NULL,
      onFocusChange.isPresent() ? ptrHolder(ptrValueChangedForBoolFn(onFocusChange.get())) : MemorySegment.NULL,
      ptrBool(autofocus),
      ptrEnum(clipBehavior),
      ptrObj(child));
  }
  MemorySegment filledButtonTonalIcon(Optional<Runnable> onPressed, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Clip> clipBehavior, Optional<Widget> icon, Widget label, Optional<IconAlignment> iconAlignment) {
    var st = WidgetFactories.filledButton(factories);
    var fn = WidgetFactories.FilledButtonSt.tonalIcon(st);
    return WidgetFactories.FilledButtonSt.tonalIcon.invoke(fn, arena, onPressed.isPresent() ? ptrHolder(ptrVoidCallbackFn(onPressed.get())) : MemorySegment.NULL,
      onLongPress.isPresent() ? ptrHolder(ptrVoidCallbackFn(onLongPress.get())) : MemorySegment.NULL,
      onHover.isPresent() ? ptrHolder(ptrValueChangedForBoolFn(onHover.get())) : MemorySegment.NULL,
      onFocusChange.isPresent() ? ptrHolder(ptrValueChangedForBoolFn(onFocusChange.get())) : MemorySegment.NULL,
      ptrBool(autofocus),
      ptrEnum(clipBehavior),
      ptrObj(icon),
      label.build().getId(),
      ptrEnum(iconAlignment));
  }

  MemorySegment outlineInputBorderOutlineInputBorder(Optional<BorderSide> borderSide, Optional<BorderRadius> borderRadius, OptionalDouble gapPadding) {
    var st = WidgetFactories.outlineInputBorder(factories);
    var fn = WidgetFactories.OutlineInputBorderSt.outlineInputBorder(st);
    return WidgetFactories.OutlineInputBorderSt.outlineInputBorder.invoke(fn, arena, ptrObj(borderSide),
      ptrObj(borderRadius),
      ptr(gapPadding));
  }

  MemorySegment snackBarActionSnackBarAction(Optional<Color> textColor, Optional<Color> disabledTextColor, Optional<Color> backgroundColor, Optional<Color> disabledBackgroundColor, String label, Runnable onPressed) {
    var st = WidgetFactories.snackBarAction(factories);
    var fn = WidgetFactories.SnackBarActionSt.snackBarAction(st);
    return WidgetFactories.SnackBarActionSt.snackBarAction.invoke(fn, arena, ptrObj(textColor),
      ptrObj(disabledTextColor),
      ptrObj(backgroundColor),
      ptrObj(disabledBackgroundColor),
      arena.allocateFrom(label),
      ptrVoidCallbackFn(onPressed));
  }

  MemorySegment snackBarSnackBar(Widget content, Optional<Color> backgroundColor, OptionalDouble elevation, Optional<EdgeInsetsGeometry> margin, Optional<EdgeInsetsGeometry> padding, OptionalDouble width, Optional<ShapeBorder> shape, Optional<HitTestBehavior> hitTestBehavior, Optional<SnackBarBehavior> behavior, Optional<SnackBarAction> action, OptionalDouble actionOverflowThreshold, Optional<Boolean> showCloseIcon, Optional<Color> closeIconColor, Optional<Duration> duration, Optional<Animation> animation, Optional<Runnable> onVisible, Optional<DismissDirection> dismissDirection, Optional<Clip> clipBehavior) {
    var st = WidgetFactories.snackBar(factories);
    var fn = WidgetFactories.SnackBarSt.snackBar(st);
    return WidgetFactories.SnackBarSt.snackBar.invoke(fn, arena, content.build().getId(),
      ptrObj(backgroundColor),
      ptr(elevation),
      ptrObj(margin),
      ptrObj(padding),
      ptr(width),
      ptrObj(shape),
      ptrEnum(hitTestBehavior),
      ptrEnum(behavior),
      ptrObj(action),
      ptr(actionOverflowThreshold),
      ptrBool(showCloseIcon),
      ptrObj(closeIconColor),
      ptrObj(duration),
      ptrObj(animation),
      onVisible.isPresent() ? ptrHolder(ptrVoidCallbackFn(onVisible.get())) : MemorySegment.NULL,
      ptrEnum(dismissDirection),
      ptrEnum(clipBehavior));
  }
  int snackBarCreateAnimationController(TickerProvider vsync, Optional<Duration> duration, Optional<Duration> reverseDuration) {
    var st = WidgetFactories.snackBar(factories);
    var fn = WidgetFactories.SnackBarSt.createAnimationController(st);
    return WidgetFactories.SnackBarSt.createAnimationController.invoke(fn, vsync.build().getId(),
      ptrObj(duration),
      ptrObj(reverseDuration));
  }

  MemorySegment scaffoldMessengerScaffoldMessenger(Widget child) {
    var st = WidgetFactories.scaffoldMessenger(factories);
    var fn = WidgetFactories.ScaffoldMessengerSt.scaffoldMessenger(st);
    return WidgetFactories.ScaffoldMessengerSt.scaffoldMessenger.invoke(fn, arena, child.build().getId());
  }
  void scaffoldMessengerShowSnackBar(BuildContext context, SnackBar snackBar) {
    var st = WidgetFactories.scaffoldMessenger(factories);
    var fn = WidgetFactories.ScaffoldMessengerSt.showSnackBar(st);
    WidgetFactories.ScaffoldMessengerSt.showSnackBar.invoke(fn, context.build().getId(),
      snackBar.build().getId());
  }
  void scaffoldMessengerRemoveCurrentSnackBar(BuildContext context, Optional<SnackBarClosedReason> reason) {
    var st = WidgetFactories.scaffoldMessenger(factories);
    var fn = WidgetFactories.ScaffoldMessengerSt.removeCurrentSnackBar(st);
    WidgetFactories.ScaffoldMessengerSt.removeCurrentSnackBar.invoke(fn, context.build().getId(),
      ptrEnum(reason));
  }
  void scaffoldMessengerHideCurrentSnackBar(BuildContext context, Optional<SnackBarClosedReason> reason) {
    var st = WidgetFactories.scaffoldMessenger(factories);
    var fn = WidgetFactories.ScaffoldMessengerSt.hideCurrentSnackBar(st);
    WidgetFactories.ScaffoldMessengerSt.hideCurrentSnackBar.invoke(fn, context.build().getId(),
      ptrEnum(reason));
  }
  void scaffoldMessengerClearSnackBars(BuildContext context) {
    var st = WidgetFactories.scaffoldMessenger(factories);
    var fn = WidgetFactories.ScaffoldMessengerSt.clearSnackBars(st);
    WidgetFactories.ScaffoldMessengerSt.clearSnackBars.invoke(fn, context.build().getId());
  }
  void scaffoldMessengerShowMaterialBanner(BuildContext context, MaterialBanner materialBanner) {
    var st = WidgetFactories.scaffoldMessenger(factories);
    var fn = WidgetFactories.ScaffoldMessengerSt.showMaterialBanner(st);
    WidgetFactories.ScaffoldMessengerSt.showMaterialBanner.invoke(fn, context.build().getId(),
      materialBanner.build().getId());
  }
  void scaffoldMessengerRemoveCurrentMaterialBanner(BuildContext context, Optional<MaterialBannerClosedReason> reason) {
    var st = WidgetFactories.scaffoldMessenger(factories);
    var fn = WidgetFactories.ScaffoldMessengerSt.removeCurrentMaterialBanner(st);
    WidgetFactories.ScaffoldMessengerSt.removeCurrentMaterialBanner.invoke(fn, context.build().getId(),
      ptrEnum(reason));
  }
  void scaffoldMessengerHideCurrentMaterialBanner(BuildContext context, Optional<MaterialBannerClosedReason> reason) {
    var st = WidgetFactories.scaffoldMessenger(factories);
    var fn = WidgetFactories.ScaffoldMessengerSt.hideCurrentMaterialBanner(st);
    WidgetFactories.ScaffoldMessengerSt.hideCurrentMaterialBanner.invoke(fn, context.build().getId(),
      ptrEnum(reason));
  }
  void scaffoldMessengerClearMaterialBanners(BuildContext context) {
    var st = WidgetFactories.scaffoldMessenger(factories);
    var fn = WidgetFactories.ScaffoldMessengerSt.clearMaterialBanners(st);
    WidgetFactories.ScaffoldMessengerSt.clearMaterialBanners.invoke(fn, context.build().getId());
  }

  MemorySegment cardCard(Optional<Color> color, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, OptionalDouble elevation, Optional<ShapeBorder> shape, Optional<Boolean> borderOnForeground, Optional<EdgeInsetsGeometry> margin, Optional<Clip> clipBehavior, Optional<Widget> child, Optional<Boolean> semanticContainer) {
    var st = WidgetFactories.card(factories);
    var fn = WidgetFactories.CardSt.card(st);
    return WidgetFactories.CardSt.card.invoke(fn, arena, ptrObj(color),
      ptrObj(shadowColor),
      ptrObj(surfaceTintColor),
      ptr(elevation),
      ptrObj(shape),
      ptrBool(borderOnForeground),
      ptrObj(margin),
      ptrEnum(clipBehavior),
      ptrObj(child),
      ptrBool(semanticContainer));
  }
  MemorySegment cardFilled(Optional<Color> color, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, OptionalDouble elevation, Optional<ShapeBorder> shape, Optional<Boolean> borderOnForeground, Optional<EdgeInsetsGeometry> margin, Optional<Clip> clipBehavior, Optional<Widget> child, Optional<Boolean> semanticContainer) {
    var st = WidgetFactories.card(factories);
    var fn = WidgetFactories.CardSt.filled(st);
    return WidgetFactories.CardSt.filled.invoke(fn, arena, ptrObj(color),
      ptrObj(shadowColor),
      ptrObj(surfaceTintColor),
      ptr(elevation),
      ptrObj(shape),
      ptrBool(borderOnForeground),
      ptrObj(margin),
      ptrEnum(clipBehavior),
      ptrObj(child),
      ptrBool(semanticContainer));
  }
  MemorySegment cardOutlined(Optional<Color> color, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, OptionalDouble elevation, Optional<ShapeBorder> shape, Optional<Boolean> borderOnForeground, Optional<EdgeInsetsGeometry> margin, Optional<Clip> clipBehavior, Optional<Widget> child, Optional<Boolean> semanticContainer) {
    var st = WidgetFactories.card(factories);
    var fn = WidgetFactories.CardSt.outlined(st);
    return WidgetFactories.CardSt.outlined.invoke(fn, arena, ptrObj(color),
      ptrObj(shadowColor),
      ptrObj(surfaceTintColor),
      ptr(elevation),
      ptrObj(shape),
      ptrBool(borderOnForeground),
      ptrObj(margin),
      ptrEnum(clipBehavior),
      ptrObj(child),
      ptrBool(semanticContainer));
  }

  MemorySegment chipChip(Optional<Widget> avatar, Widget label, Optional<TextStyle> labelStyle, Optional<EdgeInsetsGeometry> labelPadding, Optional<Widget> deleteIcon, Optional<Runnable> onDeleted, Optional<Color> deleteIconColor, Optional<String> deleteButtonTooltipMessage, Optional<BorderSide> side, Optional<OutlinedBorder> shape, Optional<Clip> clipBehavior, Optional<Boolean> autofocus, Optional<Color> color, Optional<Color> backgroundColor, Optional<EdgeInsetsGeometry> padding, Optional<VisualDensity> visualDensity, Optional<MaterialTapTargetSize> materialTapTargetSize, OptionalDouble elevation, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, Optional<BoxConstraints> avatarBoxConstraints, Optional<BoxConstraints> deleteIconBoxConstraints) {
    var st = WidgetFactories.chip(factories);
    var fn = WidgetFactories.ChipSt.chip(st);
    return WidgetFactories.ChipSt.chip.invoke(fn, arena, ptrObj(avatar),
      label.build().getId(),
      ptrObj(labelStyle),
      ptrObj(labelPadding),
      ptrObj(deleteIcon),
      onDeleted.isPresent() ? ptrHolder(ptrVoidCallbackFn(onDeleted.get())) : MemorySegment.NULL,
      ptrObj(deleteIconColor),
      ptrStr(deleteButtonTooltipMessage),
      ptrObj(side),
      ptrObj(shape),
      ptrEnum(clipBehavior),
      ptrBool(autofocus),
      ptrObj(color),
      ptrObj(backgroundColor),
      ptrObj(padding),
      ptrObj(visualDensity),
      ptrEnum(materialTapTargetSize),
      ptr(elevation),
      ptrObj(shadowColor),
      ptrObj(surfaceTintColor),
      ptrObj(avatarBoxConstraints),
      ptrObj(deleteIconBoxConstraints));
  }

  MemorySegment gestureDetectorGestureDetector(Optional<Widget> child, Optional<Consumer<TapDownDetails>> onTapDown, Optional<Consumer<TapUpDetails>> onTapUp, Optional<Runnable> onTap, Optional<Consumer<TapMoveDetails>> onTapMove, Optional<Runnable> onTapCancel, Optional<Runnable> onSecondaryTap, Optional<Consumer<TapDownDetails>> onSecondaryTapDown, Optional<Consumer<TapUpDetails>> onSecondaryTapUp, Optional<Runnable> onSecondaryTapCancel, Optional<Consumer<TapDownDetails>> onTertiaryTapDown, Optional<Consumer<TapUpDetails>> onTertiaryTapUp, Optional<Runnable> onTertiaryTapCancel, Optional<Consumer<TapDownDetails>> onDoubleTapDown, Optional<Runnable> onDoubleTap, Optional<Runnable> onDoubleTapCancel, Optional<Consumer<LongPressDownDetails>> onLongPressDown, Optional<Runnable> onLongPressCancel, Optional<Runnable> onLongPress, Optional<Consumer<LongPressStartDetails>> onLongPressStart, Optional<Consumer<LongPressMoveUpdateDetails>> onLongPressMoveUpdate, Optional<Runnable> onLongPressUp, Optional<Consumer<LongPressEndDetails>> onLongPressEnd, Optional<Consumer<LongPressDownDetails>> onSecondaryLongPressDown, Optional<Runnable> onSecondaryLongPressCancel, Optional<Runnable> onSecondaryLongPress, Optional<Consumer<LongPressStartDetails>> onSecondaryLongPressStart, Optional<Consumer<LongPressMoveUpdateDetails>> onSecondaryLongPressMoveUpdate, Optional<Runnable> onSecondaryLongPressUp, Optional<Consumer<LongPressEndDetails>> onSecondaryLongPressEnd, Optional<Consumer<LongPressDownDetails>> onTertiaryLongPressDown, Optional<Runnable> onTertiaryLongPressCancel, Optional<Runnable> onTertiaryLongPress, Optional<Consumer<LongPressStartDetails>> onTertiaryLongPressStart, Optional<Consumer<LongPressMoveUpdateDetails>> onTertiaryLongPressMoveUpdate, Optional<Runnable> onTertiaryLongPressUp, Optional<Consumer<LongPressEndDetails>> onTertiaryLongPressEnd, Optional<Consumer<DragDownDetails>> onVerticalDragDown, Optional<Consumer<DragStartDetails>> onVerticalDragStart, Optional<Consumer<DragUpdateDetails>> onVerticalDragUpdate, Optional<Consumer<DragEndDetails>> onVerticalDragEnd, Optional<Runnable> onVerticalDragCancel, Optional<Consumer<DragDownDetails>> onHorizontalDragDown, Optional<Consumer<DragStartDetails>> onHorizontalDragStart, Optional<Consumer<DragUpdateDetails>> onHorizontalDragUpdate, Optional<Consumer<DragEndDetails>> onHorizontalDragEnd, Optional<Runnable> onHorizontalDragCancel, Optional<Consumer<ForcePressDetails>> onForcePressStart, Optional<Consumer<ForcePressDetails>> onForcePressPeak, Optional<Consumer<ForcePressDetails>> onForcePressUpdate, Optional<Consumer<ForcePressDetails>> onForcePressEnd, Optional<Consumer<DragDownDetails>> onPanDown, Optional<Consumer<DragStartDetails>> onPanStart, Optional<Consumer<DragUpdateDetails>> onPanUpdate, Optional<Consumer<DragEndDetails>> onPanEnd, Optional<Runnable> onPanCancel, Optional<Consumer<ScaleStartDetails>> onScaleStart, Optional<Consumer<ScaleUpdateDetails>> onScaleUpdate, Optional<Consumer<ScaleEndDetails>> onScaleEnd, Optional<HitTestBehavior> behavior, Optional<Boolean> excludeFromSemantics, Optional<DragStartBehavior> dragStartBehavior, Optional<Boolean> trackpadScrollCausesScale, Optional<Offset> trackpadScrollToScaleFactor) {
    var st = WidgetFactories.gestureDetector(factories);
    var fn = WidgetFactories.GestureDetectorSt.gestureDetector(st);
    return WidgetFactories.GestureDetectorSt.gestureDetector.invoke(fn, arena, ptrObj(child),
      onTapDown.isPresent() ? ptrHolder(ptrGestureTapDownCallbackFn(onTapDown.get())) : MemorySegment.NULL,
      onTapUp.isPresent() ? ptrHolder(ptrGestureTapUpCallbackFn(onTapUp.get())) : MemorySegment.NULL,
      onTap.isPresent() ? ptrHolder(ptrGestureTapCallbackFn(onTap.get())) : MemorySegment.NULL,
      onTapMove.isPresent() ? ptrHolder(ptrGestureTapMoveCallbackFn(onTapMove.get())) : MemorySegment.NULL,
      onTapCancel.isPresent() ? ptrHolder(ptrGestureTapCancelCallbackFn(onTapCancel.get())) : MemorySegment.NULL,
      onSecondaryTap.isPresent() ? ptrHolder(ptrGestureTapCallbackFn(onSecondaryTap.get())) : MemorySegment.NULL,
      onSecondaryTapDown.isPresent() ? ptrHolder(ptrGestureTapDownCallbackFn(onSecondaryTapDown.get())) : MemorySegment.NULL,
      onSecondaryTapUp.isPresent() ? ptrHolder(ptrGestureTapUpCallbackFn(onSecondaryTapUp.get())) : MemorySegment.NULL,
      onSecondaryTapCancel.isPresent() ? ptrHolder(ptrGestureTapCancelCallbackFn(onSecondaryTapCancel.get())) : MemorySegment.NULL,
      onTertiaryTapDown.isPresent() ? ptrHolder(ptrGestureTapDownCallbackFn(onTertiaryTapDown.get())) : MemorySegment.NULL,
      onTertiaryTapUp.isPresent() ? ptrHolder(ptrGestureTapUpCallbackFn(onTertiaryTapUp.get())) : MemorySegment.NULL,
      onTertiaryTapCancel.isPresent() ? ptrHolder(ptrGestureTapCancelCallbackFn(onTertiaryTapCancel.get())) : MemorySegment.NULL,
      onDoubleTapDown.isPresent() ? ptrHolder(ptrGestureTapDownCallbackFn(onDoubleTapDown.get())) : MemorySegment.NULL,
      onDoubleTap.isPresent() ? ptrHolder(ptrGestureTapCallbackFn(onDoubleTap.get())) : MemorySegment.NULL,
      onDoubleTapCancel.isPresent() ? ptrHolder(ptrGestureTapCancelCallbackFn(onDoubleTapCancel.get())) : MemorySegment.NULL,
      onLongPressDown.isPresent() ? ptrHolder(ptrGestureLongPressDownCallbackFn(onLongPressDown.get())) : MemorySegment.NULL,
      onLongPressCancel.isPresent() ? ptrHolder(ptrGestureLongPressCancelCallbackFn(onLongPressCancel.get())) : MemorySegment.NULL,
      onLongPress.isPresent() ? ptrHolder(ptrGestureLongPressCallbackFn(onLongPress.get())) : MemorySegment.NULL,
      onLongPressStart.isPresent() ? ptrHolder(ptrGestureLongPressStartCallbackFn(onLongPressStart.get())) : MemorySegment.NULL,
      onLongPressMoveUpdate.isPresent() ? ptrHolder(ptrGestureLongPressMoveUpdateCallbackFn(onLongPressMoveUpdate.get())) : MemorySegment.NULL,
      onLongPressUp.isPresent() ? ptrHolder(ptrGestureLongPressUpCallbackFn(onLongPressUp.get())) : MemorySegment.NULL,
      onLongPressEnd.isPresent() ? ptrHolder(ptrGestureLongPressEndCallbackFn(onLongPressEnd.get())) : MemorySegment.NULL,
      onSecondaryLongPressDown.isPresent() ? ptrHolder(ptrGestureLongPressDownCallbackFn(onSecondaryLongPressDown.get())) : MemorySegment.NULL,
      onSecondaryLongPressCancel.isPresent() ? ptrHolder(ptrGestureLongPressCancelCallbackFn(onSecondaryLongPressCancel.get())) : MemorySegment.NULL,
      onSecondaryLongPress.isPresent() ? ptrHolder(ptrGestureLongPressCallbackFn(onSecondaryLongPress.get())) : MemorySegment.NULL,
      onSecondaryLongPressStart.isPresent() ? ptrHolder(ptrGestureLongPressStartCallbackFn(onSecondaryLongPressStart.get())) : MemorySegment.NULL,
      onSecondaryLongPressMoveUpdate.isPresent() ? ptrHolder(ptrGestureLongPressMoveUpdateCallbackFn(onSecondaryLongPressMoveUpdate.get())) : MemorySegment.NULL,
      onSecondaryLongPressUp.isPresent() ? ptrHolder(ptrGestureLongPressUpCallbackFn(onSecondaryLongPressUp.get())) : MemorySegment.NULL,
      onSecondaryLongPressEnd.isPresent() ? ptrHolder(ptrGestureLongPressEndCallbackFn(onSecondaryLongPressEnd.get())) : MemorySegment.NULL,
      onTertiaryLongPressDown.isPresent() ? ptrHolder(ptrGestureLongPressDownCallbackFn(onTertiaryLongPressDown.get())) : MemorySegment.NULL,
      onTertiaryLongPressCancel.isPresent() ? ptrHolder(ptrGestureLongPressCancelCallbackFn(onTertiaryLongPressCancel.get())) : MemorySegment.NULL,
      onTertiaryLongPress.isPresent() ? ptrHolder(ptrGestureLongPressCallbackFn(onTertiaryLongPress.get())) : MemorySegment.NULL,
      onTertiaryLongPressStart.isPresent() ? ptrHolder(ptrGestureLongPressStartCallbackFn(onTertiaryLongPressStart.get())) : MemorySegment.NULL,
      onTertiaryLongPressMoveUpdate.isPresent() ? ptrHolder(ptrGestureLongPressMoveUpdateCallbackFn(onTertiaryLongPressMoveUpdate.get())) : MemorySegment.NULL,
      onTertiaryLongPressUp.isPresent() ? ptrHolder(ptrGestureLongPressUpCallbackFn(onTertiaryLongPressUp.get())) : MemorySegment.NULL,
      onTertiaryLongPressEnd.isPresent() ? ptrHolder(ptrGestureLongPressEndCallbackFn(onTertiaryLongPressEnd.get())) : MemorySegment.NULL,
      onVerticalDragDown.isPresent() ? ptrHolder(ptrGestureDragDownCallbackFn(onVerticalDragDown.get())) : MemorySegment.NULL,
      onVerticalDragStart.isPresent() ? ptrHolder(ptrGestureDragStartCallbackFn(onVerticalDragStart.get())) : MemorySegment.NULL,
      onVerticalDragUpdate.isPresent() ? ptrHolder(ptrGestureDragUpdateCallbackFn(onVerticalDragUpdate.get())) : MemorySegment.NULL,
      onVerticalDragEnd.isPresent() ? ptrHolder(ptrGestureDragEndCallbackFn(onVerticalDragEnd.get())) : MemorySegment.NULL,
      onVerticalDragCancel.isPresent() ? ptrHolder(ptrGestureDragCancelCallbackFn(onVerticalDragCancel.get())) : MemorySegment.NULL,
      onHorizontalDragDown.isPresent() ? ptrHolder(ptrGestureDragDownCallbackFn(onHorizontalDragDown.get())) : MemorySegment.NULL,
      onHorizontalDragStart.isPresent() ? ptrHolder(ptrGestureDragStartCallbackFn(onHorizontalDragStart.get())) : MemorySegment.NULL,
      onHorizontalDragUpdate.isPresent() ? ptrHolder(ptrGestureDragUpdateCallbackFn(onHorizontalDragUpdate.get())) : MemorySegment.NULL,
      onHorizontalDragEnd.isPresent() ? ptrHolder(ptrGestureDragEndCallbackFn(onHorizontalDragEnd.get())) : MemorySegment.NULL,
      onHorizontalDragCancel.isPresent() ? ptrHolder(ptrGestureDragCancelCallbackFn(onHorizontalDragCancel.get())) : MemorySegment.NULL,
      onForcePressStart.isPresent() ? ptrHolder(ptrGestureForcePressStartCallbackFn(onForcePressStart.get())) : MemorySegment.NULL,
      onForcePressPeak.isPresent() ? ptrHolder(ptrGestureForcePressPeakCallbackFn(onForcePressPeak.get())) : MemorySegment.NULL,
      onForcePressUpdate.isPresent() ? ptrHolder(ptrGestureForcePressUpdateCallbackFn(onForcePressUpdate.get())) : MemorySegment.NULL,
      onForcePressEnd.isPresent() ? ptrHolder(ptrGestureForcePressEndCallbackFn(onForcePressEnd.get())) : MemorySegment.NULL,
      onPanDown.isPresent() ? ptrHolder(ptrGestureDragDownCallbackFn(onPanDown.get())) : MemorySegment.NULL,
      onPanStart.isPresent() ? ptrHolder(ptrGestureDragStartCallbackFn(onPanStart.get())) : MemorySegment.NULL,
      onPanUpdate.isPresent() ? ptrHolder(ptrGestureDragUpdateCallbackFn(onPanUpdate.get())) : MemorySegment.NULL,
      onPanEnd.isPresent() ? ptrHolder(ptrGestureDragEndCallbackFn(onPanEnd.get())) : MemorySegment.NULL,
      onPanCancel.isPresent() ? ptrHolder(ptrGestureDragCancelCallbackFn(onPanCancel.get())) : MemorySegment.NULL,
      onScaleStart.isPresent() ? ptrHolder(ptrGestureScaleStartCallbackFn(onScaleStart.get())) : MemorySegment.NULL,
      onScaleUpdate.isPresent() ? ptrHolder(ptrGestureScaleUpdateCallbackFn(onScaleUpdate.get())) : MemorySegment.NULL,
      onScaleEnd.isPresent() ? ptrHolder(ptrGestureScaleEndCallbackFn(onScaleEnd.get())) : MemorySegment.NULL,
      ptrEnum(behavior),
      ptrBool(excludeFromSemantics),
      ptrEnum(dragStartBehavior),
      ptrBool(trackpadScrollCausesScale),
      ptrObj(trackpadScrollToScaleFactor));
  }

  MemorySegment listTileListTile(Optional<Widget> leading, Optional<Widget> title, Optional<Widget> subtitle, Optional<Widget> trailing, Optional<Boolean> isThreeLine, Optional<Boolean> dense, Optional<VisualDensity> visualDensity, Optional<ShapeBorder> shape, Optional<ListTileStyle> style, Optional<Color> selectedColor, Optional<Color> iconColor, Optional<Color> textColor, Optional<TextStyle> titleTextStyle, Optional<TextStyle> subtitleTextStyle, Optional<TextStyle> leadingAndTrailingTextStyle, Optional<EdgeInsetsGeometry> contentPadding, Optional<Boolean> enabled, Optional<Runnable> onTap, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> selected, Optional<Color> focusColor, Optional<Color> hoverColor, Optional<Color> splashColor, Optional<Boolean> autofocus, Optional<Color> tileColor, Optional<Color> selectedTileColor, Optional<Boolean> enableFeedback, OptionalDouble horizontalTitleGap, OptionalDouble minVerticalPadding, OptionalDouble minLeadingWidth, OptionalDouble minTileHeight, Optional<ListTileTitleAlignment> titleAlignment, Optional<Boolean> internalAddSemanticForOnTap) {
    var st = WidgetFactories.listTile(factories);
    var fn = WidgetFactories.ListTileSt.listTile(st);
    return WidgetFactories.ListTileSt.listTile.invoke(fn, arena, ptrObj(leading),
      ptrObj(title),
      ptrObj(subtitle),
      ptrObj(trailing),
      ptrBool(isThreeLine),
      ptrBool(dense),
      ptrObj(visualDensity),
      ptrObj(shape),
      ptrEnum(style),
      ptrObj(selectedColor),
      ptrObj(iconColor),
      ptrObj(textColor),
      ptrObj(titleTextStyle),
      ptrObj(subtitleTextStyle),
      ptrObj(leadingAndTrailingTextStyle),
      ptrObj(contentPadding),
      ptrBool(enabled),
      onTap.isPresent() ? ptrHolder(ptrGestureTapCallbackFn(onTap.get())) : MemorySegment.NULL,
      onLongPress.isPresent() ? ptrHolder(ptrGestureLongPressCallbackFn(onLongPress.get())) : MemorySegment.NULL,
      onFocusChange.isPresent() ? ptrHolder(ptrValueChangedForBoolFn(onFocusChange.get())) : MemorySegment.NULL,
      ptrBool(selected),
      ptrObj(focusColor),
      ptrObj(hoverColor),
      ptrObj(splashColor),
      ptrBool(autofocus),
      ptrObj(tileColor),
      ptrObj(selectedTileColor),
      ptrBool(enableFeedback),
      ptr(horizontalTitleGap),
      ptr(minVerticalPadding),
      ptr(minLeadingWidth),
      ptr(minTileHeight),
      ptrEnum(titleAlignment),
      ptrBool(internalAddSemanticForOnTap));
  }

  MemorySegment wrapWrap(Optional<Axis> direction, Optional<WrapAlignment> alignment, OptionalDouble spacing, Optional<WrapAlignment> runAlignment, OptionalDouble runSpacing, Optional<WrapCrossAlignment> crossAxisAlignment, Optional<TextDirection> textDirection, Optional<VerticalDirection> verticalDirection, Optional<Clip> clipBehavior, Optional<List<Widget>> children) {
    var st = WidgetFactories.wrap(factories);
    var fn = WidgetFactories.WrapSt.wrap(st);
    return WidgetFactories.WrapSt.wrap.invoke(fn, arena, ptrEnum(direction),
      ptrEnum(alignment),
      ptr(spacing),
      ptrEnum(runAlignment),
      ptr(runSpacing),
      ptrEnum(crossAxisAlignment),
      ptrEnum(textDirection),
      ptrEnum(verticalDirection),
      ptrEnum(clipBehavior),
      ptrList(children));
  }

  MemorySegment singleChildScrollViewSingleChildScrollView(Optional<Axis> scrollDirection, Optional<Boolean> reverse, Optional<EdgeInsetsGeometry> padding, Optional<Boolean> primary, Optional<Widget> child, Optional<DragStartBehavior> dragStartBehavior, Optional<Clip> clipBehavior, Optional<HitTestBehavior> hitTestBehavior, Optional<String> restorationId, Optional<ScrollViewKeyboardDismissBehavior> keyboardDismissBehavior) {
    var st = WidgetFactories.singleChildScrollView(factories);
    var fn = WidgetFactories.SingleChildScrollViewSt.singleChildScrollView(st);
    return WidgetFactories.SingleChildScrollViewSt.singleChildScrollView.invoke(fn, arena, ptrEnum(scrollDirection),
      ptrBool(reverse),
      ptrObj(padding),
      ptrBool(primary),
      ptrObj(child),
      ptrEnum(dragStartBehavior),
      ptrEnum(clipBehavior),
      ptrEnum(hitTestBehavior),
      ptrStr(restorationId),
      ptrEnum(keyboardDismissBehavior));
  }

  MemorySegment linearProgressIndicatorLinearProgressIndicator(OptionalDouble value, Optional<Color> backgroundColor, Optional<Color> color, Optional<Animation> valueColor, OptionalDouble minHeight, Optional<String> semanticsLabel, Optional<String> semanticsValue, Optional<BorderRadiusGeometry> borderRadius, Optional<Color> stopIndicatorColor, OptionalDouble stopIndicatorRadius, OptionalDouble trackGap, Optional<Boolean> year2023) {
    var st = WidgetFactories.linearProgressIndicator(factories);
    var fn = WidgetFactories.LinearProgressIndicatorSt.linearProgressIndicator(st);
    return WidgetFactories.LinearProgressIndicatorSt.linearProgressIndicator.invoke(fn, arena, ptr(value),
      ptrObj(backgroundColor),
      ptrObj(color),
      ptrObj(valueColor),
      ptr(minHeight),
      ptrStr(semanticsLabel),
      ptrStr(semanticsValue),
      ptrObj(borderRadius),
      ptrObj(stopIndicatorColor),
      ptr(stopIndicatorRadius),
      ptr(trackGap),
      ptrBool(year2023));
  }

  MemorySegment checkboxCheckbox(Optional<Boolean> value, Optional<Boolean> tristate, Optional<Consumer<Boolean>> onChanged, Optional<Color> activeColor, Optional<Color> fillColor, Optional<Color> checkColor, Optional<Color> focusColor, Optional<Color> hoverColor, Optional<Color> overlayColor, OptionalDouble splashRadius, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<VisualDensity> visualDensity, Optional<Boolean> autofocus, Optional<OutlinedBorder> shape, Optional<BorderSide> side, Optional<Boolean> isError, Optional<String> semanticLabel) {
    var st = WidgetFactories.checkbox(factories);
    var fn = WidgetFactories.CheckboxSt.checkbox(st);
    return WidgetFactories.CheckboxSt.checkbox.invoke(fn, arena, ptrBool(value),
      ptrBool(tristate),
      onChanged.isPresent() ? ptrHolder(ptrValueChangedForBoolOptFn(onChanged.get())) : MemorySegment.NULL,
      ptrObj(activeColor),
      ptrObj(fillColor),
      ptrObj(checkColor),
      ptrObj(focusColor),
      ptrObj(hoverColor),
      ptrObj(overlayColor),
      ptr(splashRadius),
      ptrEnum(materialTapTargetSize),
      ptrObj(visualDensity),
      ptrBool(autofocus),
      ptrObj(shape),
      ptrObj(side),
      ptrBool(isError),
      ptrStr(semanticLabel));
  }
  MemorySegment checkboxAdaptive(Optional<Boolean> value, Optional<Boolean> tristate, Optional<Consumer<Boolean>> onChanged, Optional<Color> activeColor, Optional<Color> fillColor, Optional<Color> checkColor, Optional<Color> focusColor, Optional<Color> hoverColor, Optional<Color> overlayColor, OptionalDouble splashRadius, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<VisualDensity> visualDensity, Optional<Boolean> autofocus, Optional<OutlinedBorder> shape, Optional<BorderSide> side, Optional<Boolean> isError, Optional<String> semanticLabel) {
    var st = WidgetFactories.checkbox(factories);
    var fn = WidgetFactories.CheckboxSt.adaptive(st);
    return WidgetFactories.CheckboxSt.adaptive.invoke(fn, arena, ptrBool(value),
      ptrBool(tristate),
      onChanged.isPresent() ? ptrHolder(ptrValueChangedForBoolOptFn(onChanged.get())) : MemorySegment.NULL,
      ptrObj(activeColor),
      ptrObj(fillColor),
      ptrObj(checkColor),
      ptrObj(focusColor),
      ptrObj(hoverColor),
      ptrObj(overlayColor),
      ptr(splashRadius),
      ptrEnum(materialTapTargetSize),
      ptrObj(visualDensity),
      ptrBool(autofocus),
      ptrObj(shape),
      ptrObj(side),
      ptrBool(isError),
      ptrStr(semanticLabel));
  }

  MemorySegment switch_Switch_(boolean value, Optional<Consumer<Boolean>> onChanged, Optional<Color> activeColor, Optional<Color> activeThumbColor, Optional<Color> activeTrackColor, Optional<Color> inactiveThumbColor, Optional<Color> inactiveTrackColor, Optional<Color> thumbColor, Optional<Color> trackColor, Optional<Color> trackOutlineColor, OptionalDouble trackOutlineWidth, Optional<Icon> thumbIcon, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<DragStartBehavior> dragStartBehavior, Optional<Color> focusColor, Optional<Color> hoverColor, Optional<Color> overlayColor, OptionalDouble splashRadius, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<EdgeInsetsGeometry> padding) {
    var st = WidgetFactories.switch_(factories);
    var fn = WidgetFactories.SwitchSt.switch_(st);
    return WidgetFactories.SwitchSt.switch_.invoke(fn, arena, (value ? 1 : 0),
      onChanged.isPresent() ? ptrHolder(ptrValueChangedForBoolFn(onChanged.get())) : MemorySegment.NULL,
      ptrObj(activeColor),
      ptrObj(activeThumbColor),
      ptrObj(activeTrackColor),
      ptrObj(inactiveThumbColor),
      ptrObj(inactiveTrackColor),
      ptrObj(thumbColor),
      ptrObj(trackColor),
      ptrObj(trackOutlineColor),
      ptr(trackOutlineWidth),
      ptrObj(thumbIcon),
      ptrEnum(materialTapTargetSize),
      ptrEnum(dragStartBehavior),
      ptrObj(focusColor),
      ptrObj(hoverColor),
      ptrObj(overlayColor),
      ptr(splashRadius),
      onFocusChange.isPresent() ? ptrHolder(ptrValueChangedForBoolFn(onFocusChange.get())) : MemorySegment.NULL,
      ptrBool(autofocus),
      ptrObj(padding));
  }
  MemorySegment switch_Adaptive(boolean value, Optional<Consumer<Boolean>> onChanged, Optional<Color> activeColor, Optional<Color> activeThumbColor, Optional<Color> activeTrackColor, Optional<Color> inactiveThumbColor, Optional<Color> inactiveTrackColor, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<Color> thumbColor, Optional<Color> trackColor, Optional<Color> trackOutlineColor, OptionalDouble trackOutlineWidth, Optional<Icon> thumbIcon, Optional<DragStartBehavior> dragStartBehavior, Optional<Color> focusColor, Optional<Color> hoverColor, Optional<Color> overlayColor, OptionalDouble splashRadius, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<EdgeInsetsGeometry> padding, Optional<Boolean> applyCupertinoTheme) {
    var st = WidgetFactories.switch_(factories);
    var fn = WidgetFactories.SwitchSt.adaptive(st);
    return WidgetFactories.SwitchSt.adaptive.invoke(fn, arena, (value ? 1 : 0),
      onChanged.isPresent() ? ptrHolder(ptrValueChangedForBoolFn(onChanged.get())) : MemorySegment.NULL,
      ptrObj(activeColor),
      ptrObj(activeThumbColor),
      ptrObj(activeTrackColor),
      ptrObj(inactiveThumbColor),
      ptrObj(inactiveTrackColor),
      ptrEnum(materialTapTargetSize),
      ptrObj(thumbColor),
      ptrObj(trackColor),
      ptrObj(trackOutlineColor),
      ptr(trackOutlineWidth),
      ptrObj(thumbIcon),
      ptrEnum(dragStartBehavior),
      ptrObj(focusColor),
      ptrObj(hoverColor),
      ptrObj(overlayColor),
      ptr(splashRadius),
      onFocusChange.isPresent() ? ptrHolder(ptrValueChangedForBoolFn(onFocusChange.get())) : MemorySegment.NULL,
      ptrBool(autofocus),
      ptrObj(padding),
      ptrBool(applyCupertinoTheme));
  }

  MemorySegment sliderSlider(double value, OptionalDouble secondaryTrackValue, Optional<Consumer<Double>> onChanged, Optional<Consumer<Double>> onChangeStart, Optional<Consumer<Double>> onChangeEnd, OptionalDouble min, OptionalDouble max, OptionalInt divisions, Optional<String> label, Optional<Color> activeColor, Optional<Color> inactiveColor, Optional<Color> secondaryActiveColor, Optional<Color> thumbColor, Optional<Color> overlayColor, Optional<Function<Double, String>> semanticFormatterCallback, Optional<Boolean> autofocus, Optional<SliderInteraction> allowedInteraction, Optional<EdgeInsetsGeometry> padding, Optional<Boolean> year2023) {
    var st = WidgetFactories.slider(factories);
    var fn = WidgetFactories.SliderSt.slider(st);
    return WidgetFactories.SliderSt.slider.invoke(fn, arena, value,
      ptr(secondaryTrackValue),
      onChanged.isPresent() ? ptrHolder(ptrValueChangedForDoubleFn(onChanged.get())) : MemorySegment.NULL,
      onChangeStart.isPresent() ? ptrHolder(ptrValueChangedForDoubleFn(onChangeStart.get())) : MemorySegment.NULL,
      onChangeEnd.isPresent() ? ptrHolder(ptrValueChangedForDoubleFn(onChangeEnd.get())) : MemorySegment.NULL,
      ptr(min),
      ptr(max),
      ptr(divisions),
      ptrStr(label),
      ptrObj(activeColor),
      ptrObj(inactiveColor),
      ptrObj(secondaryActiveColor),
      ptrObj(thumbColor),
      ptrObj(overlayColor),
      semanticFormatterCallback.isPresent() ? ptrHolder(ptrSemanticFormatterCallbackFn(semanticFormatterCallback.get())) : MemorySegment.NULL,
      ptrBool(autofocus),
      ptrEnum(allowedInteraction),
      ptrObj(padding),
      ptrBool(year2023));
  }
  MemorySegment sliderAdaptive(double value, OptionalDouble secondaryTrackValue, Optional<Consumer<Double>> onChanged, Optional<Consumer<Double>> onChangeStart, Optional<Consumer<Double>> onChangeEnd, OptionalDouble min, OptionalDouble max, OptionalInt divisions, Optional<String> label, Optional<Color> activeColor, Optional<Color> inactiveColor, Optional<Color> secondaryActiveColor, Optional<Color> thumbColor, Optional<Color> overlayColor, Optional<Function<Double, String>> semanticFormatterCallback, Optional<Boolean> autofocus, Optional<SliderInteraction> allowedInteraction, Optional<Boolean> year2023) {
    var st = WidgetFactories.slider(factories);
    var fn = WidgetFactories.SliderSt.adaptive(st);
    return WidgetFactories.SliderSt.adaptive.invoke(fn, arena, value,
      ptr(secondaryTrackValue),
      onChanged.isPresent() ? ptrHolder(ptrValueChangedForDoubleFn(onChanged.get())) : MemorySegment.NULL,
      onChangeStart.isPresent() ? ptrHolder(ptrValueChangedForDoubleFn(onChangeStart.get())) : MemorySegment.NULL,
      onChangeEnd.isPresent() ? ptrHolder(ptrValueChangedForDoubleFn(onChangeEnd.get())) : MemorySegment.NULL,
      ptr(min),
      ptr(max),
      ptr(divisions),
      ptrStr(label),
      ptrObj(activeColor),
      ptrObj(inactiveColor),
      ptrObj(secondaryActiveColor),
      ptrObj(thumbColor),
      ptrObj(overlayColor),
      semanticFormatterCallback.isPresent() ? ptrHolder(ptrSemanticFormatterCallbackFn(semanticFormatterCallback.get())) : MemorySegment.NULL,
      ptrBool(autofocus),
      ptrEnum(allowedInteraction),
      ptrBool(year2023));
  }

  MemorySegment drawerDrawer(Optional<Color> backgroundColor, OptionalDouble elevation, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, Optional<ShapeBorder> shape, OptionalDouble width, Optional<Widget> child, Optional<String> semanticLabel, Optional<Clip> clipBehavior) {
    var st = WidgetFactories.drawer(factories);
    var fn = WidgetFactories.DrawerSt.drawer(st);
    return WidgetFactories.DrawerSt.drawer.invoke(fn, arena, ptrObj(backgroundColor),
      ptr(elevation),
      ptrObj(shadowColor),
      ptrObj(surfaceTintColor),
      ptrObj(shape),
      ptr(width),
      ptrObj(child),
      ptrStr(semanticLabel),
      ptrEnum(clipBehavior));
  }

  MemorySegment tooltipTooltip(Optional<String> message, Optional<InlineSpan> richMessage, OptionalDouble height, Optional<BoxConstraints> constraints, Optional<EdgeInsetsGeometry> padding, Optional<EdgeInsetsGeometry> margin, OptionalDouble verticalOffset, Optional<Boolean> preferBelow, Optional<Boolean> excludeFromSemantics, Optional<Decoration> decoration, Optional<TextStyle> textStyle, Optional<TextAlign> textAlign, Optional<Duration> waitDuration, Optional<Duration> showDuration, Optional<Duration> exitDuration, Optional<Boolean> enableTapToDismiss, Optional<TooltipTriggerMode> triggerMode, Optional<Boolean> enableFeedback, Optional<Runnable> onTriggered, Optional<Boolean> ignorePointer, Optional<Widget> child) {
    var st = WidgetFactories.tooltip(factories);
    var fn = WidgetFactories.TooltipSt.tooltip(st);
    return WidgetFactories.TooltipSt.tooltip.invoke(fn, arena, ptrStr(message),
      ptrObj(richMessage),
      ptr(height),
      ptrObj(constraints),
      ptrObj(padding),
      ptrObj(margin),
      ptr(verticalOffset),
      ptrBool(preferBelow),
      ptrBool(excludeFromSemantics),
      ptrObj(decoration),
      ptrObj(textStyle),
      ptrEnum(textAlign),
      ptrObj(waitDuration),
      ptrObj(showDuration),
      ptrObj(exitDuration),
      ptrBool(enableTapToDismiss),
      ptrEnum(triggerMode),
      ptrBool(enableFeedback),
      onTriggered.isPresent() ? ptrHolder(ptrTooltipTriggeredCallbackFn(onTriggered.get())) : MemorySegment.NULL,
      ptrBool(ignorePointer),
      ptrObj(child));
  }
  int tooltipDismissAllToolTips() {
    var st = WidgetFactories.tooltip(factories);
    var fn = WidgetFactories.TooltipSt.dismissAllToolTips(st);
    return WidgetFactories.TooltipSt.dismissAllToolTips.invoke(fn);
  }

  MemorySegment tabTab(Optional<String> text, Optional<Widget> icon, Optional<EdgeInsetsGeometry> iconMargin, OptionalDouble height, Optional<Widget> child) {
    var st = WidgetFactories.tab(factories);
    var fn = WidgetFactories.TabSt.tab(st);
    return WidgetFactories.TabSt.tab.invoke(fn, arena, ptrStr(text),
      ptrObj(icon),
      ptrObj(iconMargin),
      ptr(height),
      ptrObj(child));
  }

  MemorySegment tabBarTabBar(List<Widget> tabs, Optional<Boolean> isScrollable, Optional<EdgeInsetsGeometry> padding, Optional<Color> indicatorColor, Optional<Boolean> automaticIndicatorColorAdjustment, OptionalDouble indicatorWeight, Optional<EdgeInsetsGeometry> indicatorPadding, Optional<Decoration> indicator, Optional<TabBarIndicatorSize> indicatorSize, Optional<Color> dividerColor, OptionalDouble dividerHeight, Optional<Color> labelColor, Optional<TextStyle> labelStyle, Optional<EdgeInsetsGeometry> labelPadding, Optional<Color> unselectedLabelColor, Optional<TextStyle> unselectedLabelStyle, Optional<DragStartBehavior> dragStartBehavior, Optional<Color> overlayColor, Optional<Boolean> enableFeedback, Optional<Consumer<Integer>> onTap, Optional<BiConsumer<Boolean, Integer>> onHover, Optional<BiConsumer<Boolean, Integer>> onFocusChange, Optional<BorderRadius> splashBorderRadius, Optional<TabAlignment> tabAlignment, Optional<TabIndicatorAnimation> indicatorAnimation) {
    var st = WidgetFactories.tabBar(factories);
    var fn = WidgetFactories.TabBarSt.tabBar(st);
    return WidgetFactories.TabBarSt.tabBar.invoke(fn, arena, ptrList(tabs),
      ptrBool(isScrollable),
      ptrObj(padding),
      ptrObj(indicatorColor),
      ptrBool(automaticIndicatorColorAdjustment),
      ptr(indicatorWeight),
      ptrObj(indicatorPadding),
      ptrObj(indicator),
      ptrEnum(indicatorSize),
      ptrObj(dividerColor),
      ptr(dividerHeight),
      ptrObj(labelColor),
      ptrObj(labelStyle),
      ptrObj(labelPadding),
      ptrObj(unselectedLabelColor),
      ptrObj(unselectedLabelStyle),
      ptrEnum(dragStartBehavior),
      ptrObj(overlayColor),
      ptrBool(enableFeedback),
      onTap.isPresent() ? ptrHolder(ptrValueChangedForIntFn(onTap.get())) : MemorySegment.NULL,
      onHover.isPresent() ? ptrHolder(ptrTabValueChangedForBoolFn(onHover.get())) : MemorySegment.NULL,
      onFocusChange.isPresent() ? ptrHolder(ptrTabValueChangedForBoolFn(onFocusChange.get())) : MemorySegment.NULL,
      ptrObj(splashBorderRadius),
      ptrEnum(tabAlignment),
      ptrEnum(indicatorAnimation));
  }
  MemorySegment tabBarSecondary(List<Widget> tabs, Optional<Boolean> isScrollable, Optional<EdgeInsetsGeometry> padding, Optional<Color> indicatorColor, Optional<Boolean> automaticIndicatorColorAdjustment, OptionalDouble indicatorWeight, Optional<EdgeInsetsGeometry> indicatorPadding, Optional<Decoration> indicator, Optional<TabBarIndicatorSize> indicatorSize, Optional<Color> dividerColor, OptionalDouble dividerHeight, Optional<Color> labelColor, Optional<TextStyle> labelStyle, Optional<EdgeInsetsGeometry> labelPadding, Optional<Color> unselectedLabelColor, Optional<TextStyle> unselectedLabelStyle, Optional<DragStartBehavior> dragStartBehavior, Optional<Color> overlayColor, Optional<Boolean> enableFeedback, Optional<Consumer<Integer>> onTap, Optional<BiConsumer<Boolean, Integer>> onHover, Optional<BiConsumer<Boolean, Integer>> onFocusChange, Optional<BorderRadius> splashBorderRadius, Optional<TabAlignment> tabAlignment, Optional<TabIndicatorAnimation> indicatorAnimation) {
    var st = WidgetFactories.tabBar(factories);
    var fn = WidgetFactories.TabBarSt.secondary(st);
    return WidgetFactories.TabBarSt.secondary.invoke(fn, arena, ptrList(tabs),
      ptrBool(isScrollable),
      ptrObj(padding),
      ptrObj(indicatorColor),
      ptrBool(automaticIndicatorColorAdjustment),
      ptr(indicatorWeight),
      ptrObj(indicatorPadding),
      ptrObj(indicator),
      ptrEnum(indicatorSize),
      ptrObj(dividerColor),
      ptr(dividerHeight),
      ptrObj(labelColor),
      ptrObj(labelStyle),
      ptrObj(labelPadding),
      ptrObj(unselectedLabelColor),
      ptrObj(unselectedLabelStyle),
      ptrEnum(dragStartBehavior),
      ptrObj(overlayColor),
      ptrBool(enableFeedback),
      onTap.isPresent() ? ptrHolder(ptrValueChangedForIntFn(onTap.get())) : MemorySegment.NULL,
      onHover.isPresent() ? ptrHolder(ptrTabValueChangedForBoolFn(onHover.get())) : MemorySegment.NULL,
      onFocusChange.isPresent() ? ptrHolder(ptrTabValueChangedForBoolFn(onFocusChange.get())) : MemorySegment.NULL,
      ptrObj(splashBorderRadius),
      ptrEnum(tabAlignment),
      ptrEnum(indicatorAnimation));
  }

  MemorySegment tabBarViewTabBarView(List<Widget> children, Optional<DragStartBehavior> dragStartBehavior, OptionalDouble viewportFraction, Optional<Clip> clipBehavior) {
    var st = WidgetFactories.tabBarView(factories);
    var fn = WidgetFactories.TabBarViewSt.tabBarView(st);
    return WidgetFactories.TabBarViewSt.tabBarView.invoke(fn, arena, ptrList(children),
      ptrEnum(dragStartBehavior),
      ptr(viewportFraction),
      ptrEnum(clipBehavior));
  }

  MemorySegment defaultTabControllerDefaultTabController(int length, OptionalInt initialIndex, Widget child, Optional<Duration> animationDuration) {
    var st = WidgetFactories.defaultTabController(factories);
    var fn = WidgetFactories.DefaultTabControllerSt.defaultTabController(st);
    return WidgetFactories.DefaultTabControllerSt.defaultTabController.invoke(fn, arena, length,
      ptr(initialIndex),
      child.build().getId(),
      ptrObj(animationDuration));
  }

  MemorySegment checkboxListTileCheckboxListTile(Optional<Boolean> value, Optional<Consumer<Boolean>> onChanged, Optional<Color> activeColor, Optional<Color> fillColor, Optional<Color> checkColor, Optional<Color> hoverColor, Optional<Color> overlayColor, OptionalDouble splashRadius, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<VisualDensity> visualDensity, Optional<Boolean> autofocus, Optional<ShapeBorder> shape, Optional<BorderSide> side, Optional<Boolean> isError, Optional<Boolean> enabled, Optional<Color> tileColor, Optional<Widget> title, Optional<Widget> subtitle, Optional<Boolean> isThreeLine, Optional<Boolean> dense, Optional<Widget> secondary, Optional<Boolean> selected, Optional<ListTileControlAffinity> controlAffinity, Optional<EdgeInsetsGeometry> contentPadding, Optional<Boolean> tristate, Optional<OutlinedBorder> checkboxShape, Optional<Color> selectedTileColor, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> enableFeedback, Optional<String> checkboxSemanticLabel, OptionalDouble checkboxScaleFactor, Optional<ListTileTitleAlignment> titleAlignment, Optional<Boolean> internalAddSemanticForOnTap) {
    var st = WidgetFactories.checkboxListTile(factories);
    var fn = WidgetFactories.CheckboxListTileSt.checkboxListTile(st);
    return WidgetFactories.CheckboxListTileSt.checkboxListTile.invoke(fn, arena, ptrBool(value),
      onChanged.isPresent() ? ptrHolder(ptrValueChangedForBoolOptFn(onChanged.get())) : MemorySegment.NULL,
      ptrObj(activeColor),
      ptrObj(fillColor),
      ptrObj(checkColor),
      ptrObj(hoverColor),
      ptrObj(overlayColor),
      ptr(splashRadius),
      ptrEnum(materialTapTargetSize),
      ptrObj(visualDensity),
      ptrBool(autofocus),
      ptrObj(shape),
      ptrObj(side),
      ptrBool(isError),
      ptrBool(enabled),
      ptrObj(tileColor),
      ptrObj(title),
      ptrObj(subtitle),
      ptrBool(isThreeLine),
      ptrBool(dense),
      ptrObj(secondary),
      ptrBool(selected),
      ptrEnum(controlAffinity),
      ptrObj(contentPadding),
      ptrBool(tristate),
      ptrObj(checkboxShape),
      ptrObj(selectedTileColor),
      onFocusChange.isPresent() ? ptrHolder(ptrValueChangedForBoolFn(onFocusChange.get())) : MemorySegment.NULL,
      ptrBool(enableFeedback),
      ptrStr(checkboxSemanticLabel),
      ptr(checkboxScaleFactor),
      ptrEnum(titleAlignment),
      ptrBool(internalAddSemanticForOnTap));
  }
  MemorySegment checkboxListTileAdaptive(Optional<Boolean> value, Optional<Consumer<Boolean>> onChanged, Optional<Color> activeColor, Optional<Color> fillColor, Optional<Color> checkColor, Optional<Color> hoverColor, Optional<Color> overlayColor, OptionalDouble splashRadius, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<VisualDensity> visualDensity, Optional<Boolean> autofocus, Optional<ShapeBorder> shape, Optional<BorderSide> side, Optional<Boolean> isError, Optional<Boolean> enabled, Optional<Color> tileColor, Optional<Widget> title, Optional<Widget> subtitle, Optional<Boolean> isThreeLine, Optional<Boolean> dense, Optional<Widget> secondary, Optional<Boolean> selected, Optional<ListTileControlAffinity> controlAffinity, Optional<EdgeInsetsGeometry> contentPadding, Optional<Boolean> tristate, Optional<OutlinedBorder> checkboxShape, Optional<Color> selectedTileColor, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> enableFeedback, Optional<String> checkboxSemanticLabel, OptionalDouble checkboxScaleFactor, Optional<ListTileTitleAlignment> titleAlignment, Optional<Boolean> internalAddSemanticForOnTap) {
    var st = WidgetFactories.checkboxListTile(factories);
    var fn = WidgetFactories.CheckboxListTileSt.adaptive(st);
    return WidgetFactories.CheckboxListTileSt.adaptive.invoke(fn, arena, ptrBool(value),
      onChanged.isPresent() ? ptrHolder(ptrValueChangedForBoolOptFn(onChanged.get())) : MemorySegment.NULL,
      ptrObj(activeColor),
      ptrObj(fillColor),
      ptrObj(checkColor),
      ptrObj(hoverColor),
      ptrObj(overlayColor),
      ptr(splashRadius),
      ptrEnum(materialTapTargetSize),
      ptrObj(visualDensity),
      ptrBool(autofocus),
      ptrObj(shape),
      ptrObj(side),
      ptrBool(isError),
      ptrBool(enabled),
      ptrObj(tileColor),
      ptrObj(title),
      ptrObj(subtitle),
      ptrBool(isThreeLine),
      ptrBool(dense),
      ptrObj(secondary),
      ptrBool(selected),
      ptrEnum(controlAffinity),
      ptrObj(contentPadding),
      ptrBool(tristate),
      ptrObj(checkboxShape),
      ptrObj(selectedTileColor),
      onFocusChange.isPresent() ? ptrHolder(ptrValueChangedForBoolFn(onFocusChange.get())) : MemorySegment.NULL,
      ptrBool(enableFeedback),
      ptrStr(checkboxSemanticLabel),
      ptr(checkboxScaleFactor),
      ptrEnum(titleAlignment),
      ptrBool(internalAddSemanticForOnTap));
  }

  MemorySegment switchListTileSwitchListTile(boolean value, Optional<Consumer<Boolean>> onChanged, Optional<Color> activeColor, Optional<Color> activeThumbColor, Optional<Color> activeTrackColor, Optional<Color> inactiveThumbColor, Optional<Color> inactiveTrackColor, Optional<Color> thumbColor, Optional<Color> trackColor, Optional<Color> trackOutlineColor, Optional<Icon> thumbIcon, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<DragStartBehavior> dragStartBehavior, Optional<Color> overlayColor, OptionalDouble splashRadius, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Color> tileColor, Optional<Widget> title, Optional<Widget> subtitle, Optional<Boolean> isThreeLine, Optional<Boolean> dense, Optional<EdgeInsetsGeometry> contentPadding, Optional<Widget> secondary, Optional<Boolean> selected, Optional<ListTileControlAffinity> controlAffinity, Optional<ShapeBorder> shape, Optional<Color> selectedTileColor, Optional<VisualDensity> visualDensity, Optional<Boolean> enableFeedback, Optional<Color> hoverColor, Optional<Boolean> internalAddSemanticForOnTap) {
    var st = WidgetFactories.switchListTile(factories);
    var fn = WidgetFactories.SwitchListTileSt.switchListTile(st);
    return WidgetFactories.SwitchListTileSt.switchListTile.invoke(fn, arena, (value ? 1 : 0),
      onChanged.isPresent() ? ptrHolder(ptrValueChangedForBoolFn(onChanged.get())) : MemorySegment.NULL,
      ptrObj(activeColor),
      ptrObj(activeThumbColor),
      ptrObj(activeTrackColor),
      ptrObj(inactiveThumbColor),
      ptrObj(inactiveTrackColor),
      ptrObj(thumbColor),
      ptrObj(trackColor),
      ptrObj(trackOutlineColor),
      ptrObj(thumbIcon),
      ptrEnum(materialTapTargetSize),
      ptrEnum(dragStartBehavior),
      ptrObj(overlayColor),
      ptr(splashRadius),
      onFocusChange.isPresent() ? ptrHolder(ptrValueChangedForBoolFn(onFocusChange.get())) : MemorySegment.NULL,
      ptrBool(autofocus),
      ptrObj(tileColor),
      ptrObj(title),
      ptrObj(subtitle),
      ptrBool(isThreeLine),
      ptrBool(dense),
      ptrObj(contentPadding),
      ptrObj(secondary),
      ptrBool(selected),
      ptrEnum(controlAffinity),
      ptrObj(shape),
      ptrObj(selectedTileColor),
      ptrObj(visualDensity),
      ptrBool(enableFeedback),
      ptrObj(hoverColor),
      ptrBool(internalAddSemanticForOnTap));
  }
  MemorySegment switchListTileAdaptive(boolean value, Optional<Consumer<Boolean>> onChanged, Optional<Color> activeColor, Optional<Color> activeThumbColor, Optional<Color> activeTrackColor, Optional<Color> inactiveThumbColor, Optional<Color> inactiveTrackColor, Optional<Color> thumbColor, Optional<Color> trackColor, Optional<Color> trackOutlineColor, Optional<Icon> thumbIcon, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<DragStartBehavior> dragStartBehavior, Optional<Color> overlayColor, OptionalDouble splashRadius, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Boolean> applyCupertinoTheme, Optional<Color> tileColor, Optional<Widget> title, Optional<Widget> subtitle, Optional<Boolean> isThreeLine, Optional<Boolean> dense, Optional<EdgeInsetsGeometry> contentPadding, Optional<Widget> secondary, Optional<Boolean> selected, Optional<ListTileControlAffinity> controlAffinity, Optional<ShapeBorder> shape, Optional<Color> selectedTileColor, Optional<VisualDensity> visualDensity, Optional<Boolean> enableFeedback, Optional<Color> hoverColor, Optional<Boolean> internalAddSemanticForOnTap) {
    var st = WidgetFactories.switchListTile(factories);
    var fn = WidgetFactories.SwitchListTileSt.adaptive(st);
    return WidgetFactories.SwitchListTileSt.adaptive.invoke(fn, arena, (value ? 1 : 0),
      onChanged.isPresent() ? ptrHolder(ptrValueChangedForBoolFn(onChanged.get())) : MemorySegment.NULL,
      ptrObj(activeColor),
      ptrObj(activeThumbColor),
      ptrObj(activeTrackColor),
      ptrObj(inactiveThumbColor),
      ptrObj(inactiveTrackColor),
      ptrObj(thumbColor),
      ptrObj(trackColor),
      ptrObj(trackOutlineColor),
      ptrObj(thumbIcon),
      ptrEnum(materialTapTargetSize),
      ptrEnum(dragStartBehavior),
      ptrObj(overlayColor),
      ptr(splashRadius),
      onFocusChange.isPresent() ? ptrHolder(ptrValueChangedForBoolFn(onFocusChange.get())) : MemorySegment.NULL,
      ptrBool(autofocus),
      ptrBool(applyCupertinoTheme),
      ptrObj(tileColor),
      ptrObj(title),
      ptrObj(subtitle),
      ptrBool(isThreeLine),
      ptrBool(dense),
      ptrObj(contentPadding),
      ptrObj(secondary),
      ptrBool(selected),
      ptrEnum(controlAffinity),
      ptrObj(shape),
      ptrObj(selectedTileColor),
      ptrObj(visualDensity),
      ptrBool(enableFeedback),
      ptrObj(hoverColor),
      ptrBool(internalAddSemanticForOnTap));
  }

  MemorySegment badgeBadge(Optional<Color> backgroundColor, Optional<Color> textColor, OptionalDouble smallSize, OptionalDouble largeSize, Optional<TextStyle> textStyle, Optional<EdgeInsetsGeometry> padding, Optional<AlignmentGeometry> alignment, Optional<Offset> offset, Optional<Widget> label, Optional<Boolean> isLabelVisible, Optional<Widget> child) {
    var st = WidgetFactories.badge(factories);
    var fn = WidgetFactories.BadgeSt.badge(st);
    return WidgetFactories.BadgeSt.badge.invoke(fn, arena, ptrObj(backgroundColor),
      ptrObj(textColor),
      ptr(smallSize),
      ptr(largeSize),
      ptrObj(textStyle),
      ptrObj(padding),
      ptrObj(alignment),
      ptrObj(offset),
      ptrObj(label),
      ptrBool(isLabelVisible),
      ptrObj(child));
  }
  MemorySegment badgeCount(Optional<Color> backgroundColor, Optional<Color> textColor, OptionalDouble smallSize, OptionalDouble largeSize, Optional<TextStyle> textStyle, Optional<EdgeInsetsGeometry> padding, Optional<AlignmentGeometry> alignment, Optional<Offset> offset, int count, Optional<Boolean> isLabelVisible, Optional<Widget> child) {
    var st = WidgetFactories.badge(factories);
    var fn = WidgetFactories.BadgeSt.count(st);
    return WidgetFactories.BadgeSt.count.invoke(fn, arena, ptrObj(backgroundColor),
      ptrObj(textColor),
      ptr(smallSize),
      ptr(largeSize),
      ptrObj(textStyle),
      ptrObj(padding),
      ptrObj(alignment),
      ptrObj(offset),
      count,
      ptrBool(isLabelVisible),
      ptrObj(child));
  }

  MemorySegment selectableTextSelectableText(String data, Optional<TextStyle> style, Optional<TextAlign> textAlign, Optional<TextDirection> textDirection, OptionalDouble textScaleFactor, Optional<Boolean> showCursor, Optional<Boolean> autofocus, OptionalInt minLines, OptionalInt maxLines, OptionalDouble cursorWidth, OptionalDouble cursorHeight, Optional<Radius> cursorRadius, Optional<Color> cursorColor, Optional<Color> selectionColor, Optional<BoxHeightStyle> selectionHeightStyle, Optional<BoxWidthStyle> selectionWidthStyle, Optional<DragStartBehavior> dragStartBehavior, Optional<Boolean> enableInteractiveSelection, Optional<Runnable> onTap, Optional<String> semanticsLabel, Optional<TextWidthBasis> textWidthBasis) {
    var st = WidgetFactories.selectableText(factories);
    var fn = WidgetFactories.SelectableTextSt.selectableText(st);
    return WidgetFactories.SelectableTextSt.selectableText.invoke(fn, arena, arena.allocateFrom(data),
      ptrObj(style),
      ptrEnum(textAlign),
      ptrEnum(textDirection),
      ptr(textScaleFactor),
      ptrBool(showCursor),
      ptrBool(autofocus),
      ptr(minLines),
      ptr(maxLines),
      ptr(cursorWidth),
      ptr(cursorHeight),
      ptrObj(cursorRadius),
      ptrObj(cursorColor),
      ptrObj(selectionColor),
      ptrEnum(selectionHeightStyle),
      ptrEnum(selectionWidthStyle),
      ptrEnum(dragStartBehavior),
      ptrBool(enableInteractiveSelection),
      onTap.isPresent() ? ptrHolder(ptrGestureTapCallbackFn(onTap.get())) : MemorySegment.NULL,
      ptrStr(semanticsLabel),
      ptrEnum(textWidthBasis));
  }
  MemorySegment selectableTextRich(TextSpan textSpan, Optional<TextStyle> style, Optional<TextAlign> textAlign, Optional<TextDirection> textDirection, OptionalDouble textScaleFactor, Optional<Boolean> showCursor, Optional<Boolean> autofocus, OptionalInt minLines, OptionalInt maxLines, OptionalDouble cursorWidth, OptionalDouble cursorHeight, Optional<Radius> cursorRadius, Optional<Color> cursorColor, Optional<Color> selectionColor, Optional<BoxHeightStyle> selectionHeightStyle, Optional<BoxWidthStyle> selectionWidthStyle, Optional<DragStartBehavior> dragStartBehavior, Optional<Boolean> enableInteractiveSelection, Optional<Runnable> onTap, Optional<String> semanticsLabel, Optional<TextWidthBasis> textWidthBasis) {
    var st = WidgetFactories.selectableText(factories);
    var fn = WidgetFactories.SelectableTextSt.rich(st);
    return WidgetFactories.SelectableTextSt.rich.invoke(fn, arena, textSpan.build().getId(),
      ptrObj(style),
      ptrEnum(textAlign),
      ptrEnum(textDirection),
      ptr(textScaleFactor),
      ptrBool(showCursor),
      ptrBool(autofocus),
      ptr(minLines),
      ptr(maxLines),
      ptr(cursorWidth),
      ptr(cursorHeight),
      ptrObj(cursorRadius),
      ptrObj(cursorColor),
      ptrObj(selectionColor),
      ptrEnum(selectionHeightStyle),
      ptrEnum(selectionWidthStyle),
      ptrEnum(dragStartBehavior),
      ptrBool(enableInteractiveSelection),
      onTap.isPresent() ? ptrHolder(ptrGestureTapCallbackFn(onTap.get())) : MemorySegment.NULL,
      ptrStr(semanticsLabel),
      ptrEnum(textWidthBasis));
  }

  MemorySegment inkWellInkWell(Optional<Widget> child, Optional<Runnable> onTap, Optional<Runnable> onDoubleTap, Optional<Runnable> onLongPress, Optional<Consumer<TapDownDetails>> onTapDown, Optional<Consumer<TapUpDetails>> onTapUp, Optional<Runnable> onTapCancel, Optional<Runnable> onSecondaryTap, Optional<Consumer<TapUpDetails>> onSecondaryTapUp, Optional<Consumer<TapDownDetails>> onSecondaryTapDown, Optional<Runnable> onSecondaryTapCancel, Optional<Consumer<Boolean>> onHighlightChanged, Optional<Consumer<Boolean>> onHover, Optional<Color> focusColor, Optional<Color> hoverColor, Optional<Color> highlightColor, Optional<Color> overlayColor, Optional<Color> splashColor, OptionalDouble radius, Optional<BorderRadius> borderRadius, Optional<ShapeBorder> customBorder, Optional<Boolean> enableFeedback, Optional<Boolean> excludeFromSemantics, Optional<Boolean> canRequestFocus, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Duration> hoverDuration) {
    var st = WidgetFactories.inkWell(factories);
    var fn = WidgetFactories.InkWellSt.inkWell(st);
    return WidgetFactories.InkWellSt.inkWell.invoke(fn, arena, ptrObj(child),
      onTap.isPresent() ? ptrHolder(ptrGestureTapCallbackFn(onTap.get())) : MemorySegment.NULL,
      onDoubleTap.isPresent() ? ptrHolder(ptrGestureTapCallbackFn(onDoubleTap.get())) : MemorySegment.NULL,
      onLongPress.isPresent() ? ptrHolder(ptrGestureLongPressCallbackFn(onLongPress.get())) : MemorySegment.NULL,
      onTapDown.isPresent() ? ptrHolder(ptrGestureTapDownCallbackFn(onTapDown.get())) : MemorySegment.NULL,
      onTapUp.isPresent() ? ptrHolder(ptrGestureTapUpCallbackFn(onTapUp.get())) : MemorySegment.NULL,
      onTapCancel.isPresent() ? ptrHolder(ptrGestureTapCallbackFn(onTapCancel.get())) : MemorySegment.NULL,
      onSecondaryTap.isPresent() ? ptrHolder(ptrGestureTapCallbackFn(onSecondaryTap.get())) : MemorySegment.NULL,
      onSecondaryTapUp.isPresent() ? ptrHolder(ptrGestureTapUpCallbackFn(onSecondaryTapUp.get())) : MemorySegment.NULL,
      onSecondaryTapDown.isPresent() ? ptrHolder(ptrGestureTapDownCallbackFn(onSecondaryTapDown.get())) : MemorySegment.NULL,
      onSecondaryTapCancel.isPresent() ? ptrHolder(ptrGestureTapCallbackFn(onSecondaryTapCancel.get())) : MemorySegment.NULL,
      onHighlightChanged.isPresent() ? ptrHolder(ptrValueChangedForBoolFn(onHighlightChanged.get())) : MemorySegment.NULL,
      onHover.isPresent() ? ptrHolder(ptrValueChangedForBoolFn(onHover.get())) : MemorySegment.NULL,
      ptrObj(focusColor),
      ptrObj(hoverColor),
      ptrObj(highlightColor),
      ptrObj(overlayColor),
      ptrObj(splashColor),
      ptr(radius),
      ptrObj(borderRadius),
      ptrObj(customBorder),
      ptrBool(enableFeedback),
      ptrBool(excludeFromSemantics),
      ptrBool(canRequestFocus),
      onFocusChange.isPresent() ? ptrHolder(ptrValueChangedForBoolFn(onFocusChange.get())) : MemorySegment.NULL,
      ptrBool(autofocus),
      ptrObj(hoverDuration));
  }

  MemorySegment inkResponseInkResponse(Optional<Widget> child, Optional<Runnable> onTap, Optional<Consumer<TapDownDetails>> onTapDown, Optional<Consumer<TapUpDetails>> onTapUp, Optional<Runnable> onTapCancel, Optional<Runnable> onDoubleTap, Optional<Runnable> onLongPress, Optional<Runnable> onSecondaryTap, Optional<Consumer<TapUpDetails>> onSecondaryTapUp, Optional<Consumer<TapDownDetails>> onSecondaryTapDown, Optional<Runnable> onSecondaryTapCancel, Optional<Consumer<Boolean>> onHighlightChanged, Optional<Consumer<Boolean>> onHover, Optional<Boolean> containedInkWell, Optional<BoxShape> highlightShape, OptionalDouble radius, Optional<BorderRadius> borderRadius, Optional<ShapeBorder> customBorder, Optional<Color> focusColor, Optional<Color> hoverColor, Optional<Color> highlightColor, Optional<Color> overlayColor, Optional<Color> splashColor, Optional<Boolean> enableFeedback, Optional<Boolean> excludeFromSemantics, Optional<Boolean> canRequestFocus, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Duration> hoverDuration) {
    var st = WidgetFactories.inkResponse(factories);
    var fn = WidgetFactories.InkResponseSt.inkResponse(st);
    return WidgetFactories.InkResponseSt.inkResponse.invoke(fn, arena, ptrObj(child),
      onTap.isPresent() ? ptrHolder(ptrGestureTapCallbackFn(onTap.get())) : MemorySegment.NULL,
      onTapDown.isPresent() ? ptrHolder(ptrGestureTapDownCallbackFn(onTapDown.get())) : MemorySegment.NULL,
      onTapUp.isPresent() ? ptrHolder(ptrGestureTapUpCallbackFn(onTapUp.get())) : MemorySegment.NULL,
      onTapCancel.isPresent() ? ptrHolder(ptrGestureTapCallbackFn(onTapCancel.get())) : MemorySegment.NULL,
      onDoubleTap.isPresent() ? ptrHolder(ptrGestureTapCallbackFn(onDoubleTap.get())) : MemorySegment.NULL,
      onLongPress.isPresent() ? ptrHolder(ptrGestureLongPressCallbackFn(onLongPress.get())) : MemorySegment.NULL,
      onSecondaryTap.isPresent() ? ptrHolder(ptrGestureTapCallbackFn(onSecondaryTap.get())) : MemorySegment.NULL,
      onSecondaryTapUp.isPresent() ? ptrHolder(ptrGestureTapUpCallbackFn(onSecondaryTapUp.get())) : MemorySegment.NULL,
      onSecondaryTapDown.isPresent() ? ptrHolder(ptrGestureTapDownCallbackFn(onSecondaryTapDown.get())) : MemorySegment.NULL,
      onSecondaryTapCancel.isPresent() ? ptrHolder(ptrGestureTapCallbackFn(onSecondaryTapCancel.get())) : MemorySegment.NULL,
      onHighlightChanged.isPresent() ? ptrHolder(ptrValueChangedForBoolFn(onHighlightChanged.get())) : MemorySegment.NULL,
      onHover.isPresent() ? ptrHolder(ptrValueChangedForBoolFn(onHover.get())) : MemorySegment.NULL,
      ptrBool(containedInkWell),
      ptrEnum(highlightShape),
      ptr(radius),
      ptrObj(borderRadius),
      ptrObj(customBorder),
      ptrObj(focusColor),
      ptrObj(hoverColor),
      ptrObj(highlightColor),
      ptrObj(overlayColor),
      ptrObj(splashColor),
      ptrBool(enableFeedback),
      ptrBool(excludeFromSemantics),
      ptrBool(canRequestFocus),
      onFocusChange.isPresent() ? ptrHolder(ptrValueChangedForBoolFn(onFocusChange.get())) : MemorySegment.NULL,
      ptrBool(autofocus),
      ptrObj(hoverDuration));
  }

  MemorySegment dataTableDataTable(List<DataColumn> columns, OptionalInt sortColumnIndex, Optional<Boolean> sortAscending, Optional<Consumer<Boolean>> onSelectAll, Optional<Decoration> decoration, Optional<Color> dataRowColor, OptionalDouble dataRowHeight, OptionalDouble dataRowMinHeight, OptionalDouble dataRowMaxHeight, Optional<TextStyle> dataTextStyle, Optional<Color> headingRowColor, OptionalDouble headingRowHeight, Optional<TextStyle> headingTextStyle, OptionalDouble horizontalMargin, OptionalDouble columnSpacing, Optional<Boolean> showCheckboxColumn, Optional<Boolean> showBottomBorder, OptionalDouble dividerThickness, List<DataRow> rows, OptionalDouble checkboxHorizontalMargin, Optional<Clip> clipBehavior) {
    var st = WidgetFactories.dataTable(factories);
    var fn = WidgetFactories.DataTableSt.dataTable(st);
    return WidgetFactories.DataTableSt.dataTable.invoke(fn, arena, ptrList(columns),
      ptr(sortColumnIndex),
      ptrBool(sortAscending),
      onSelectAll.isPresent() ? ptrHolder(ptrValueSetterForBoolOptFn(onSelectAll.get())) : MemorySegment.NULL,
      ptrObj(decoration),
      ptrObj(dataRowColor),
      ptr(dataRowHeight),
      ptr(dataRowMinHeight),
      ptr(dataRowMaxHeight),
      ptrObj(dataTextStyle),
      ptrObj(headingRowColor),
      ptr(headingRowHeight),
      ptrObj(headingTextStyle),
      ptr(horizontalMargin),
      ptr(columnSpacing),
      ptrBool(showCheckboxColumn),
      ptrBool(showBottomBorder),
      ptr(dividerThickness),
      ptrList(rows),
      ptr(checkboxHorizontalMargin),
      ptrEnum(clipBehavior));
  }

  MemorySegment dataColumnDataColumn(Widget label, Optional<String> tooltip, Optional<Boolean> numeric, Optional<BiConsumer<Integer, Boolean>> onSort, Optional<MainAxisAlignment> headingRowAlignment) {
    var st = WidgetFactories.dataColumn(factories);
    var fn = WidgetFactories.DataColumnSt.dataColumn(st);
    return WidgetFactories.DataColumnSt.dataColumn.invoke(fn, arena, label.build().getId(),
      ptrStr(tooltip),
      ptrBool(numeric),
      onSort.isPresent() ? ptrHolder(ptrDataColumnSortCallbackFn(onSort.get())) : MemorySegment.NULL,
      ptrEnum(headingRowAlignment));
  }

  MemorySegment dataRowDataRow(Optional<Boolean> selected, Optional<Consumer<Boolean>> onSelectChanged, Optional<Runnable> onLongPress, Optional<Color> color, List<DataCell> cells) {
    var st = WidgetFactories.dataRow(factories);
    var fn = WidgetFactories.DataRowSt.dataRow(st);
    return WidgetFactories.DataRowSt.dataRow.invoke(fn, arena, ptrBool(selected),
      onSelectChanged.isPresent() ? ptrHolder(ptrValueChangedForBoolOptFn(onSelectChanged.get())) : MemorySegment.NULL,
      onLongPress.isPresent() ? ptrHolder(ptrGestureLongPressCallbackFn(onLongPress.get())) : MemorySegment.NULL,
      ptrObj(color),
      ptrList(cells));
  }
  MemorySegment dataRowByIndex(OptionalInt index, Optional<Boolean> selected, Optional<Consumer<Boolean>> onSelectChanged, Optional<Runnable> onLongPress, Optional<Color> color, List<DataCell> cells) {
    var st = WidgetFactories.dataRow(factories);
    var fn = WidgetFactories.DataRowSt.byIndex(st);
    return WidgetFactories.DataRowSt.byIndex.invoke(fn, arena, ptr(index),
      ptrBool(selected),
      onSelectChanged.isPresent() ? ptrHolder(ptrValueChangedForBoolOptFn(onSelectChanged.get())) : MemorySegment.NULL,
      onLongPress.isPresent() ? ptrHolder(ptrGestureLongPressCallbackFn(onLongPress.get())) : MemorySegment.NULL,
      ptrObj(color),
      ptrList(cells));
  }

  MemorySegment dataCellDataCell(Widget child, Optional<Boolean> placeholder, Optional<Boolean> showEditIcon, Optional<Runnable> onTap, Optional<Runnable> onLongPress, Optional<Consumer<TapDownDetails>> onTapDown, Optional<Runnable> onDoubleTap, Optional<Runnable> onTapCancel) {
    var st = WidgetFactories.dataCell(factories);
    var fn = WidgetFactories.DataCellSt.dataCell(st);
    return WidgetFactories.DataCellSt.dataCell.invoke(fn, arena, child.build().getId(),
      ptrBool(placeholder),
      ptrBool(showEditIcon),
      onTap.isPresent() ? ptrHolder(ptrGestureTapCallbackFn(onTap.get())) : MemorySegment.NULL,
      onLongPress.isPresent() ? ptrHolder(ptrGestureLongPressCallbackFn(onLongPress.get())) : MemorySegment.NULL,
      onTapDown.isPresent() ? ptrHolder(ptrGestureTapDownCallbackFn(onTapDown.get())) : MemorySegment.NULL,
      onDoubleTap.isPresent() ? ptrHolder(ptrGestureTapCallbackFn(onDoubleTap.get())) : MemorySegment.NULL,
      onTapCancel.isPresent() ? ptrHolder(ptrGestureTapCancelCallbackFn(onTapCancel.get())) : MemorySegment.NULL);
  }

  <T> int dropdownMenuEntryDropdownMenuEntry(NativeObj value, String label, Optional<Widget> labelWidget, Optional<Widget> leadingIcon, Optional<Widget> trailingIcon, Optional<Boolean> enabled) {
    var st = WidgetFactories.dropdownMenuEntry(factories);
    var fn = WidgetFactories.DropdownMenuEntrySt.dropdownMenuEntry(st);
    return WidgetFactories.DropdownMenuEntrySt.dropdownMenuEntry.invoke(fn, value.build().getId(),
      arena.allocateFrom(label),
      ptrObj(labelWidget),
      ptrObj(leadingIcon),
      ptrObj(trailingIcon),
      ptrBool(enabled));
  }

  <T> MemorySegment radioRadio(NativeObj value, Optional<NativeObj> groupValue, Optional<Consumer<NativeObj>> onChanged, Optional<Boolean> toggleable, Optional<Color> activeColor, Optional<Color> fillColor, Optional<Color> focusColor, Optional<Color> hoverColor, Optional<Color> overlayColor, OptionalDouble splashRadius, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<VisualDensity> visualDensity, Optional<Boolean> autofocus, Optional<Boolean> enabled, Optional<Color> backgroundColor, Optional<BorderSide> side, OptionalDouble innerRadius) {
    var st = WidgetFactories.radio(factories);
    var fn = WidgetFactories.RadioSt.radio(st);
    return WidgetFactories.RadioSt.radio.invoke(fn, arena, value.build().getId(),
      ptrObj(groupValue),
      onChanged.isPresent() ? ptrHolder(ptrValueChangedForTOptFn(onChanged.get())) : MemorySegment.NULL,
      ptrBool(toggleable),
      ptrObj(activeColor),
      ptrObj(fillColor),
      ptrObj(focusColor),
      ptrObj(hoverColor),
      ptrObj(overlayColor),
      ptr(splashRadius),
      ptrEnum(materialTapTargetSize),
      ptrObj(visualDensity),
      ptrBool(autofocus),
      ptrBool(enabled),
      ptrObj(backgroundColor),
      ptrObj(side),
      ptr(innerRadius));
  }
  <T> MemorySegment radioAdaptive(NativeObj value, Optional<NativeObj> groupValue, Optional<Consumer<NativeObj>> onChanged, Optional<Boolean> toggleable, Optional<Color> activeColor, Optional<Color> fillColor, Optional<Color> focusColor, Optional<Color> hoverColor, Optional<Color> overlayColor, OptionalDouble splashRadius, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<VisualDensity> visualDensity, Optional<Boolean> autofocus, Optional<Boolean> useCupertinoCheckmarkStyle, Optional<Boolean> enabled, Optional<Color> backgroundColor, Optional<BorderSide> side, OptionalDouble innerRadius) {
    var st = WidgetFactories.radio(factories);
    var fn = WidgetFactories.RadioSt.adaptive(st);
    return WidgetFactories.RadioSt.adaptive.invoke(fn, arena, value.build().getId(),
      ptrObj(groupValue),
      onChanged.isPresent() ? ptrHolder(ptrValueChangedForTOptFn(onChanged.get())) : MemorySegment.NULL,
      ptrBool(toggleable),
      ptrObj(activeColor),
      ptrObj(fillColor),
      ptrObj(focusColor),
      ptrObj(hoverColor),
      ptrObj(overlayColor),
      ptr(splashRadius),
      ptrEnum(materialTapTargetSize),
      ptrObj(visualDensity),
      ptrBool(autofocus),
      ptrBool(useCupertinoCheckmarkStyle),
      ptrBool(enabled),
      ptrObj(backgroundColor),
      ptrObj(side),
      ptr(innerRadius));
  }

  <T> MemorySegment radioListTileRadioListTile(NativeObj value, Optional<NativeObj> groupValue, Optional<Consumer<NativeObj>> onChanged, Optional<Boolean> toggleable, Optional<Color> activeColor, Optional<Color> fillColor, Optional<Color> hoverColor, Optional<Color> overlayColor, OptionalDouble splashRadius, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<Widget> title, Optional<Widget> subtitle, Optional<Boolean> isThreeLine, Optional<Boolean> dense, Optional<Widget> secondary, Optional<Boolean> selected, Optional<ListTileControlAffinity> controlAffinity, Optional<Boolean> autofocus, Optional<EdgeInsetsGeometry> contentPadding, Optional<ShapeBorder> shape, Optional<Color> tileColor, Optional<Color> selectedTileColor, Optional<VisualDensity> visualDensity, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> enableFeedback, OptionalDouble radioScaleFactor, Optional<ListTileTitleAlignment> titleAlignment, Optional<Boolean> enabled, Optional<Boolean> internalAddSemanticForOnTap, Optional<Color> radioBackgroundColor, Optional<BorderSide> radioSide) {
    var st = WidgetFactories.radioListTile(factories);
    var fn = WidgetFactories.RadioListTileSt.radioListTile(st);
    return WidgetFactories.RadioListTileSt.radioListTile.invoke(fn, arena, value.build().getId(),
      ptrObj(groupValue),
      onChanged.isPresent() ? ptrHolder(ptrValueChangedForTOptFn(onChanged.get())) : MemorySegment.NULL,
      ptrBool(toggleable),
      ptrObj(activeColor),
      ptrObj(fillColor),
      ptrObj(hoverColor),
      ptrObj(overlayColor),
      ptr(splashRadius),
      ptrEnum(materialTapTargetSize),
      ptrObj(title),
      ptrObj(subtitle),
      ptrBool(isThreeLine),
      ptrBool(dense),
      ptrObj(secondary),
      ptrBool(selected),
      ptrEnum(controlAffinity),
      ptrBool(autofocus),
      ptrObj(contentPadding),
      ptrObj(shape),
      ptrObj(tileColor),
      ptrObj(selectedTileColor),
      ptrObj(visualDensity),
      onFocusChange.isPresent() ? ptrHolder(ptrValueChangedForBoolFn(onFocusChange.get())) : MemorySegment.NULL,
      ptrBool(enableFeedback),
      ptr(radioScaleFactor),
      ptrEnum(titleAlignment),
      ptrBool(enabled),
      ptrBool(internalAddSemanticForOnTap),
      ptrObj(radioBackgroundColor),
      ptrObj(radioSide));
  }
  <T> MemorySegment radioListTileAdaptive(NativeObj value, Optional<NativeObj> groupValue, Optional<Consumer<NativeObj>> onChanged, Optional<Boolean> toggleable, Optional<Color> activeColor, Optional<Color> fillColor, Optional<Color> hoverColor, Optional<Color> overlayColor, OptionalDouble splashRadius, Optional<MaterialTapTargetSize> materialTapTargetSize, Optional<Widget> title, Optional<Widget> subtitle, Optional<Boolean> isThreeLine, Optional<Boolean> dense, Optional<Widget> secondary, Optional<Boolean> selected, Optional<ListTileControlAffinity> controlAffinity, Optional<Boolean> autofocus, Optional<EdgeInsetsGeometry> contentPadding, Optional<ShapeBorder> shape, Optional<Color> tileColor, Optional<Color> selectedTileColor, Optional<VisualDensity> visualDensity, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> enableFeedback, OptionalDouble radioScaleFactor, Optional<Boolean> enabled, Optional<Boolean> useCupertinoCheckmarkStyle, Optional<ListTileTitleAlignment> titleAlignment, Optional<Boolean> internalAddSemanticForOnTap, Optional<Color> radioBackgroundColor, Optional<BorderSide> radioSide) {
    var st = WidgetFactories.radioListTile(factories);
    var fn = WidgetFactories.RadioListTileSt.adaptive(st);
    return WidgetFactories.RadioListTileSt.adaptive.invoke(fn, arena, value.build().getId(),
      ptrObj(groupValue),
      onChanged.isPresent() ? ptrHolder(ptrValueChangedForTOptFn(onChanged.get())) : MemorySegment.NULL,
      ptrBool(toggleable),
      ptrObj(activeColor),
      ptrObj(fillColor),
      ptrObj(hoverColor),
      ptrObj(overlayColor),
      ptr(splashRadius),
      ptrEnum(materialTapTargetSize),
      ptrObj(title),
      ptrObj(subtitle),
      ptrBool(isThreeLine),
      ptrBool(dense),
      ptrObj(secondary),
      ptrBool(selected),
      ptrEnum(controlAffinity),
      ptrBool(autofocus),
      ptrObj(contentPadding),
      ptrObj(shape),
      ptrObj(tileColor),
      ptrObj(selectedTileColor),
      ptrObj(visualDensity),
      onFocusChange.isPresent() ? ptrHolder(ptrValueChangedForBoolFn(onFocusChange.get())) : MemorySegment.NULL,
      ptrBool(enableFeedback),
      ptr(radioScaleFactor),
      ptrBool(enabled),
      ptrBool(useCupertinoCheckmarkStyle),
      ptrEnum(titleAlignment),
      ptrBool(internalAddSemanticForOnTap),
      ptrObj(radioBackgroundColor),
      ptrObj(radioSide));
  }

  MemorySegment expansionTileExpansionTile(Optional<Widget> leading, Widget title, Optional<Widget> subtitle, Optional<Consumer<Boolean>> onExpansionChanged, Optional<List<Widget>> children, Optional<Widget> trailing, Optional<Boolean> showTrailingIcon, Optional<Boolean> initiallyExpanded, Optional<Boolean> maintainState, Optional<EdgeInsetsGeometry> tilePadding, Optional<CrossAxisAlignment> expandedCrossAxisAlignment, Optional<Alignment> expandedAlignment, Optional<EdgeInsetsGeometry> childrenPadding, Optional<Color> backgroundColor, Optional<Color> collapsedBackgroundColor, Optional<Color> textColor, Optional<Color> collapsedTextColor, Optional<Color> iconColor, Optional<Color> collapsedIconColor, Optional<ShapeBorder> shape, Optional<ShapeBorder> collapsedShape, Optional<Clip> clipBehavior, Optional<ListTileControlAffinity> controlAffinity, Optional<Boolean> dense, Optional<VisualDensity> visualDensity, OptionalDouble minTileHeight, Optional<Boolean> enableFeedback, Optional<Boolean> enabled, Optional<Boolean> internalAddSemanticForOnTap) {
    var st = WidgetFactories.expansionTile(factories);
    var fn = WidgetFactories.ExpansionTileSt.expansionTile(st);
    return WidgetFactories.ExpansionTileSt.expansionTile.invoke(fn, arena, ptrObj(leading),
      title.build().getId(),
      ptrObj(subtitle),
      onExpansionChanged.isPresent() ? ptrHolder(ptrValueChangedForBoolFn(onExpansionChanged.get())) : MemorySegment.NULL,
      ptrList(children),
      ptrObj(trailing),
      ptrBool(showTrailingIcon),
      ptrBool(initiallyExpanded),
      ptrBool(maintainState),
      ptrObj(tilePadding),
      ptrEnum(expandedCrossAxisAlignment),
      ptrObj(expandedAlignment),
      ptrObj(childrenPadding),
      ptrObj(backgroundColor),
      ptrObj(collapsedBackgroundColor),
      ptrObj(textColor),
      ptrObj(collapsedTextColor),
      ptrObj(iconColor),
      ptrObj(collapsedIconColor),
      ptrObj(shape),
      ptrObj(collapsedShape),
      ptrEnum(clipBehavior),
      ptrEnum(controlAffinity),
      ptrBool(dense),
      ptrObj(visualDensity),
      ptr(minTileHeight),
      ptrBool(enableFeedback),
      ptrBool(enabled),
      ptrBool(internalAddSemanticForOnTap));
  }

  int expansionPanelExpansionPanel(BiFunction<BuildContext, Boolean, Widget> headerBuilder, Widget body, Optional<Boolean> isExpanded, Optional<Boolean> canTapOnHeader, Optional<Color> backgroundColor, Optional<Color> splashColor, Optional<Color> highlightColor) {
    var st = WidgetFactories.expansionPanel(factories);
    var fn = WidgetFactories.ExpansionPanelSt.expansionPanel(st);
    return WidgetFactories.ExpansionPanelSt.expansionPanel.invoke(fn, ptrExpansionPanelHeaderBuilderFn(headerBuilder),
      body.build().getId(),
      ptrBool(isExpanded),
      ptrBool(canTapOnHeader),
      ptrObj(backgroundColor),
      ptrObj(splashColor),
      ptrObj(highlightColor));
  }

  MemorySegment expansionPanelListExpansionPanelList(Optional<List<ExpansionPanel>> children, Optional<BiConsumer<Integer, Boolean>> expansionCallback, Optional<Duration> animationDuration, Optional<Color> dividerColor, OptionalDouble elevation, Optional<Color> expandIconColor, OptionalDouble materialGapSize) {
    var st = WidgetFactories.expansionPanelList(factories);
    var fn = WidgetFactories.ExpansionPanelListSt.expansionPanelList(st);
    return WidgetFactories.ExpansionPanelListSt.expansionPanelList.invoke(fn, arena, ptrList(children),
      expansionCallback.isPresent() ? ptrHolder(ptrExpansionPanelCallbackFn(expansionCallback.get())) : MemorySegment.NULL,
      ptrObj(animationDuration),
      ptrObj(dividerColor),
      ptr(elevation),
      ptrObj(expandIconColor),
      ptr(materialGapSize));
  }
  MemorySegment expansionPanelListRadio(Optional<List<ExpansionPanel>> children, Optional<BiConsumer<Integer, Boolean>> expansionCallback, Optional<Duration> animationDuration, Optional<NativeObj> initialOpenPanelValue, Optional<Color> dividerColor, OptionalDouble elevation, Optional<Color> expandIconColor, OptionalDouble materialGapSize) {
    var st = WidgetFactories.expansionPanelList(factories);
    var fn = WidgetFactories.ExpansionPanelListSt.radio(st);
    return WidgetFactories.ExpansionPanelListSt.radio.invoke(fn, arena, ptrList(children),
      expansionCallback.isPresent() ? ptrHolder(ptrExpansionPanelCallbackFn(expansionCallback.get())) : MemorySegment.NULL,
      ptrObj(animationDuration),
      ptrObj(initialOpenPanelValue),
      ptrObj(dividerColor),
      ptr(elevation),
      ptrObj(expandIconColor),
      ptr(materialGapSize));
  }

  int expansionPanelRadioExpansionPanelRadio(NativeObj value, BiFunction<BuildContext, Boolean, Widget> headerBuilder, Widget body, Optional<Boolean> canTapOnHeader, Optional<Color> backgroundColor, Optional<Color> splashColor, Optional<Color> highlightColor) {
    var st = WidgetFactories.expansionPanelRadio(factories);
    var fn = WidgetFactories.ExpansionPanelRadioSt.expansionPanelRadio(st);
    return WidgetFactories.ExpansionPanelRadioSt.expansionPanelRadio.invoke(fn, value.build().getId(),
      ptrExpansionPanelHeaderBuilderFn(headerBuilder),
      body.build().getId(),
      ptrBool(canTapOnHeader),
      ptrObj(backgroundColor),
      ptrObj(splashColor),
      ptrObj(highlightColor));
  }

  MemorySegment navigationRailNavigationRail(Optional<Color> backgroundColor, Optional<Boolean> extended, Optional<Widget> leading, Optional<Widget> trailing, List<NavigationRailDestination> destinations, OptionalInt selectedIndex, Optional<Consumer<Integer>> onDestinationSelected, OptionalDouble elevation, OptionalDouble groupAlignment, Optional<NavigationRailLabelType> labelType, Optional<TextStyle> unselectedLabelTextStyle, Optional<TextStyle> selectedLabelTextStyle, OptionalDouble minWidth, OptionalDouble minExtendedWidth, Optional<Boolean> useIndicator, Optional<Color> indicatorColor, Optional<ShapeBorder> indicatorShape, Optional<Boolean> leadingAtTop, Optional<Boolean> trailingAtBottom, Optional<Boolean> scrollable) {
    var st = WidgetFactories.navigationRail(factories);
    var fn = WidgetFactories.NavigationRailSt.navigationRail(st);
    return WidgetFactories.NavigationRailSt.navigationRail.invoke(fn, arena, ptrObj(backgroundColor),
      ptrBool(extended),
      ptrObj(leading),
      ptrObj(trailing),
      ptrList(destinations),
      ptr(selectedIndex),
      onDestinationSelected.isPresent() ? ptrHolder(ptrValueChangedForIntFn(onDestinationSelected.get())) : MemorySegment.NULL,
      ptr(elevation),
      ptr(groupAlignment),
      ptrEnum(labelType),
      ptrObj(unselectedLabelTextStyle),
      ptrObj(selectedLabelTextStyle),
      ptr(minWidth),
      ptr(minExtendedWidth),
      ptrBool(useIndicator),
      ptrObj(indicatorColor),
      ptrObj(indicatorShape),
      ptrBool(leadingAtTop),
      ptrBool(trailingAtBottom),
      ptrBool(scrollable));
  }
  int navigationRailExtendedAnimation(BuildContext context) {
    var st = WidgetFactories.navigationRail(factories);
    var fn = WidgetFactories.NavigationRailSt.extendedAnimation(st);
    return WidgetFactories.NavigationRailSt.extendedAnimation.invoke(fn, context.build().getId());
  }

  int navigationRailDestinationNavigationRailDestination(Widget icon, Optional<Widget> selectedIcon, Optional<Color> indicatorColor, Optional<ShapeBorder> indicatorShape, Widget label, Optional<EdgeInsetsGeometry> padding, Optional<Boolean> disabled) {
    var st = WidgetFactories.navigationRailDestination(factories);
    var fn = WidgetFactories.NavigationRailDestinationSt.navigationRailDestination(st);
    return WidgetFactories.NavigationRailDestinationSt.navigationRailDestination.invoke(fn, icon.build().getId(),
      ptrObj(selectedIcon),
      ptrObj(indicatorColor),
      ptrObj(indicatorShape),
      label.build().getId(),
      ptrObj(padding),
      ptrBool(disabled));
  }

  MemorySegment navigationBarNavigationBar(Optional<Duration> animationDuration, OptionalInt selectedIndex, List<Widget> destinations, Optional<Consumer<Integer>> onDestinationSelected, Optional<Color> backgroundColor, OptionalDouble elevation, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, Optional<Color> indicatorColor, Optional<ShapeBorder> indicatorShape, OptionalDouble height, Optional<NavigationDestinationLabelBehavior> labelBehavior, Optional<Color> overlayColor, Optional<TextStyle> labelTextStyle, Optional<EdgeInsetsGeometry> labelPadding, Optional<Boolean> maintainBottomViewPadding) {
    var st = WidgetFactories.navigationBar(factories);
    var fn = WidgetFactories.NavigationBarSt.navigationBar(st);
    return WidgetFactories.NavigationBarSt.navigationBar.invoke(fn, arena, ptrObj(animationDuration),
      ptr(selectedIndex),
      ptrList(destinations),
      onDestinationSelected.isPresent() ? ptrHolder(ptrValueChangedForIntFn(onDestinationSelected.get())) : MemorySegment.NULL,
      ptrObj(backgroundColor),
      ptr(elevation),
      ptrObj(shadowColor),
      ptrObj(surfaceTintColor),
      ptrObj(indicatorColor),
      ptrObj(indicatorShape),
      ptr(height),
      ptrEnum(labelBehavior),
      ptrObj(overlayColor),
      ptrObj(labelTextStyle),
      ptrObj(labelPadding),
      ptrBool(maintainBottomViewPadding));
  }

  MemorySegment navigationDestinationNavigationDestination(Widget icon, Optional<Widget> selectedIcon, String label, Optional<String> tooltip, Optional<Boolean> enabled) {
    var st = WidgetFactories.navigationDestination(factories);
    var fn = WidgetFactories.NavigationDestinationSt.navigationDestination(st);
    return WidgetFactories.NavigationDestinationSt.navigationDestination.invoke(fn, arena, icon.build().getId(),
      ptrObj(selectedIcon),
      arena.allocateFrom(label),
      ptrStr(tooltip),
      ptrBool(enabled));
  }

  MemorySegment navigationDrawerNavigationDrawer(List<Widget> children, Optional<Widget> header, Optional<Widget> footer, Optional<Color> backgroundColor, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, OptionalDouble elevation, Optional<Color> indicatorColor, Optional<ShapeBorder> indicatorShape, Optional<Consumer<Integer>> onDestinationSelected, OptionalInt selectedIndex, Optional<EdgeInsetsGeometry> tilePadding) {
    var st = WidgetFactories.navigationDrawer(factories);
    var fn = WidgetFactories.NavigationDrawerSt.navigationDrawer(st);
    return WidgetFactories.NavigationDrawerSt.navigationDrawer.invoke(fn, arena, ptrList(children),
      ptrObj(header),
      ptrObj(footer),
      ptrObj(backgroundColor),
      ptrObj(shadowColor),
      ptrObj(surfaceTintColor),
      ptr(elevation),
      ptrObj(indicatorColor),
      ptrObj(indicatorShape),
      onDestinationSelected.isPresent() ? ptrHolder(ptrValueChangedForIntFn(onDestinationSelected.get())) : MemorySegment.NULL,
      ptr(selectedIndex),
      ptrObj(tilePadding));
  }

  MemorySegment navigationDrawerDestinationNavigationDrawerDestination(Optional<Color> backgroundColor, Widget icon, Optional<Widget> selectedIcon, Widget label, Optional<Boolean> enabled) {
    var st = WidgetFactories.navigationDrawerDestination(factories);
    var fn = WidgetFactories.NavigationDrawerDestinationSt.navigationDrawerDestination(st);
    return WidgetFactories.NavigationDrawerDestinationSt.navigationDrawerDestination.invoke(fn, arena, ptrObj(backgroundColor),
      icon.build().getId(),
      ptrObj(selectedIcon),
      label.build().getId(),
      ptrBool(enabled));
  }

  <T> MemorySegment popupMenuButtonPopupMenuButton(Function<BuildContext, List<PopupMenuEntry>> itemBuilder, Optional<NativeObj> initialValue, Optional<Runnable> onOpened, Optional<Consumer<NativeObj>> onSelected, Optional<Runnable> onCanceled, Optional<String> tooltip, OptionalDouble elevation, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, Optional<EdgeInsetsGeometry> padding, Optional<EdgeInsetsGeometry> menuPadding, Optional<Widget> child, Optional<BorderRadius> borderRadius, OptionalDouble splashRadius, Optional<Widget> icon, OptionalDouble iconSize, Optional<Offset> offset, Optional<Boolean> enabled, Optional<ShapeBorder> shape, Optional<Color> color, Optional<Color> iconColor, Optional<Boolean> enableFeedback, Optional<BoxConstraints> constraints, Optional<PopupMenuPosition> position, Optional<Clip> clipBehavior, Optional<Boolean> useRootNavigator, Optional<Boolean> requestFocus) {
    var st = WidgetFactories.popupMenuButton(factories);
    var fn = WidgetFactories.PopupMenuButtonSt.popupMenuButton(st);
    return WidgetFactories.PopupMenuButtonSt.popupMenuButton.invoke(fn, arena, ptrPopupMenuItemBuilderForTFn(itemBuilder),
      ptrObj(initialValue),
      onOpened.isPresent() ? ptrHolder(ptrVoidCallbackFn(onOpened.get())) : MemorySegment.NULL,
      onSelected.isPresent() ? ptrHolder(ptrPopupMenuItemSelectedForTFn(onSelected.get())) : MemorySegment.NULL,
      onCanceled.isPresent() ? ptrHolder(ptrPopupMenuCanceledFn(onCanceled.get())) : MemorySegment.NULL,
      ptrStr(tooltip),
      ptr(elevation),
      ptrObj(shadowColor),
      ptrObj(surfaceTintColor),
      ptrObj(padding),
      ptrObj(menuPadding),
      ptrObj(child),
      ptrObj(borderRadius),
      ptr(splashRadius),
      ptrObj(icon),
      ptr(iconSize),
      ptrObj(offset),
      ptrBool(enabled),
      ptrObj(shape),
      ptrObj(color),
      ptrObj(iconColor),
      ptrBool(enableFeedback),
      ptrObj(constraints),
      ptrEnum(position),
      ptrEnum(clipBehavior),
      ptrBool(useRootNavigator),
      ptrBool(requestFocus));
  }

  <T> MemorySegment popupMenuItemPopupMenuItem(Optional<NativeObj> value, Optional<Runnable> onTap, Optional<Boolean> enabled, OptionalDouble height, Optional<EdgeInsets> padding, Optional<TextStyle> textStyle, Optional<TextStyle> labelTextStyle, Optional<Widget> child) {
    var st = WidgetFactories.popupMenuItem(factories);
    var fn = WidgetFactories.PopupMenuItemSt.popupMenuItem(st);
    return WidgetFactories.PopupMenuItemSt.popupMenuItem.invoke(fn, arena, ptrObj(value),
      onTap.isPresent() ? ptrHolder(ptrVoidCallbackFn(onTap.get())) : MemorySegment.NULL,
      ptrBool(enabled),
      ptr(height),
      ptrObj(padding),
      ptrObj(textStyle),
      ptrObj(labelTextStyle),
      ptrObj(child));
  }

  MemorySegment popupMenuDividerPopupMenuDivider(OptionalDouble height, OptionalDouble thickness, OptionalDouble indent, OptionalDouble endIndent, Optional<BorderRadiusGeometry> radius, Optional<Color> color) {
    var st = WidgetFactories.popupMenuDivider(factories);
    var fn = WidgetFactories.PopupMenuDividerSt.popupMenuDivider(st);
    return WidgetFactories.PopupMenuDividerSt.popupMenuDivider.invoke(fn, arena, ptr(height),
      ptr(thickness),
      ptr(indent),
      ptr(endIndent),
      ptrObj(radius),
      ptrObj(color));
  }

  <T> MemorySegment checkedPopupMenuItemCheckedPopupMenuItem(Optional<NativeObj> value, Optional<Boolean> checked, Optional<Boolean> enabled, Optional<EdgeInsets> padding, OptionalDouble height, Optional<TextStyle> labelTextStyle, Optional<Widget> child, Optional<Runnable> onTap) {
    var st = WidgetFactories.checkedPopupMenuItem(factories);
    var fn = WidgetFactories.CheckedPopupMenuItemSt.checkedPopupMenuItem(st);
    return WidgetFactories.CheckedPopupMenuItemSt.checkedPopupMenuItem.invoke(fn, arena, ptrObj(value),
      ptrBool(checked),
      ptrBool(enabled),
      ptrObj(padding),
      ptr(height),
      ptrObj(labelTextStyle),
      ptrObj(child),
      onTap.isPresent() ? ptrHolder(ptrVoidCallbackFn(onTap.get())) : MemorySegment.NULL);
  }

  MemorySegment circleAvatarCircleAvatar(Optional<Widget> child, Optional<Color> backgroundColor, Optional<Color> foregroundColor, OptionalDouble radius, OptionalDouble minRadius, OptionalDouble maxRadius) {
    var st = WidgetFactories.circleAvatar(factories);
    var fn = WidgetFactories.CircleAvatarSt.circleAvatar(st);
    return WidgetFactories.CircleAvatarSt.circleAvatar.invoke(fn, arena, ptrObj(child),
      ptrObj(backgroundColor),
      ptrObj(foregroundColor),
      ptr(radius),
      ptr(minRadius),
      ptr(maxRadius));
  }

  MemorySegment scrollbarScrollbar(Widget child, Optional<Boolean> thumbVisibility, Optional<Boolean> trackVisibility, OptionalDouble thickness, Optional<Radius> radius, Optional<Boolean> interactive, Optional<ScrollbarOrientation> scrollbarOrientation) {
    var st = WidgetFactories.scrollbar(factories);
    var fn = WidgetFactories.ScrollbarSt.scrollbar(st);
    return WidgetFactories.ScrollbarSt.scrollbar.invoke(fn, arena, child.build().getId(),
      ptrBool(thumbVisibility),
      ptrBool(trackVisibility),
      ptr(thickness),
      ptrObj(radius),
      ptrBool(interactive),
      ptrEnum(scrollbarOrientation));
  }

  MemorySegment menuBarMenuBar(Optional<Clip> clipBehavior, List<Widget> children) {
    var st = WidgetFactories.menuBar(factories);
    var fn = WidgetFactories.MenuBarSt.menuBar(st);
    return WidgetFactories.MenuBarSt.menuBar.invoke(fn, arena, ptrEnum(clipBehavior),
      ptrList(children));
  }

  MemorySegment menuAnchorMenuAnchor(Optional<Offset> alignmentOffset, Optional<Clip> clipBehavior, Optional<Boolean> anchorTapClosesMenu, Optional<Boolean> consumeOutsideTap, Optional<Runnable> onOpen, Optional<Runnable> onClose, Optional<Boolean> crossAxisUnconstrained, Optional<Boolean> useRootOverlay, List<Widget> menuChildren, Optional<Widget> child) {
    var st = WidgetFactories.menuAnchor(factories);
    var fn = WidgetFactories.MenuAnchorSt.menuAnchor(st);
    return WidgetFactories.MenuAnchorSt.menuAnchor.invoke(fn, arena, ptrObj(alignmentOffset),
      ptrEnum(clipBehavior),
      ptrBool(anchorTapClosesMenu),
      ptrBool(consumeOutsideTap),
      onOpen.isPresent() ? ptrHolder(ptrVoidCallbackFn(onOpen.get())) : MemorySegment.NULL,
      onClose.isPresent() ? ptrHolder(ptrVoidCallbackFn(onClose.get())) : MemorySegment.NULL,
      ptrBool(crossAxisUnconstrained),
      ptrBool(useRootOverlay),
      ptrList(menuChildren),
      ptrObj(child));
  }

  MemorySegment submenuButtonSubmenuButton(Optional<Consumer<Boolean>> onHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Runnable> onOpen, Optional<Runnable> onClose, Optional<Offset> alignmentOffset, Optional<Clip> clipBehavior, Optional<Widget> leadingIcon, Optional<Widget> trailingIcon, Optional<Widget> submenuIcon, Optional<Boolean> useRootOverlay, List<Widget> menuChildren, Optional<Widget> child) {
    var st = WidgetFactories.submenuButton(factories);
    var fn = WidgetFactories.SubmenuButtonSt.submenuButton(st);
    return WidgetFactories.SubmenuButtonSt.submenuButton.invoke(fn, arena, onHover.isPresent() ? ptrHolder(ptrValueChangedForBoolFn(onHover.get())) : MemorySegment.NULL,
      onFocusChange.isPresent() ? ptrHolder(ptrValueChangedForBoolFn(onFocusChange.get())) : MemorySegment.NULL,
      onOpen.isPresent() ? ptrHolder(ptrVoidCallbackFn(onOpen.get())) : MemorySegment.NULL,
      onClose.isPresent() ? ptrHolder(ptrVoidCallbackFn(onClose.get())) : MemorySegment.NULL,
      ptrObj(alignmentOffset),
      ptrEnum(clipBehavior),
      ptrObj(leadingIcon),
      ptrObj(trailingIcon),
      ptrObj(submenuIcon),
      ptrBool(useRootOverlay),
      ptrList(menuChildren),
      ptrObj(child));
  }

  MemorySegment menuItemButtonMenuItemButton(Optional<Runnable> onPressed, Optional<Consumer<Boolean>> onHover, Optional<Boolean> requestFocusOnHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<String> semanticsLabel, Optional<Clip> clipBehavior, Optional<Widget> leadingIcon, Optional<Widget> trailingIcon, Optional<Boolean> closeOnActivate, Optional<Axis> overflowAxis, Optional<Widget> child) {
    var st = WidgetFactories.menuItemButton(factories);
    var fn = WidgetFactories.MenuItemButtonSt.menuItemButton(st);
    return WidgetFactories.MenuItemButtonSt.menuItemButton.invoke(fn, arena, onPressed.isPresent() ? ptrHolder(ptrVoidCallbackFn(onPressed.get())) : MemorySegment.NULL,
      onHover.isPresent() ? ptrHolder(ptrValueChangedForBoolFn(onHover.get())) : MemorySegment.NULL,
      ptrBool(requestFocusOnHover),
      onFocusChange.isPresent() ? ptrHolder(ptrValueChangedForBoolFn(onFocusChange.get())) : MemorySegment.NULL,
      ptrBool(autofocus),
      ptrStr(semanticsLabel),
      ptrEnum(clipBehavior),
      ptrObj(leadingIcon),
      ptrObj(trailingIcon),
      ptrBool(closeOnActivate),
      ptrEnum(overflowAxis),
      ptrObj(child));
  }

  MemorySegment checkboxMenuButtonCheckboxMenuButton(Optional<Boolean> value, Optional<Boolean> tristate, Optional<Boolean> isError, Optional<Consumer<Boolean>> onChanged, Optional<Consumer<Boolean>> onHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Clip> clipBehavior, Optional<Widget> trailingIcon, Optional<Boolean> closeOnActivate, Optional<Widget> child) {
    var st = WidgetFactories.checkboxMenuButton(factories);
    var fn = WidgetFactories.CheckboxMenuButtonSt.checkboxMenuButton(st);
    return WidgetFactories.CheckboxMenuButtonSt.checkboxMenuButton.invoke(fn, arena, ptrBool(value),
      ptrBool(tristate),
      ptrBool(isError),
      onChanged.isPresent() ? ptrHolder(ptrValueChangedForBoolOptFn(onChanged.get())) : MemorySegment.NULL,
      onHover.isPresent() ? ptrHolder(ptrValueChangedForBoolFn(onHover.get())) : MemorySegment.NULL,
      onFocusChange.isPresent() ? ptrHolder(ptrValueChangedForBoolFn(onFocusChange.get())) : MemorySegment.NULL,
      ptrEnum(clipBehavior),
      ptrObj(trailingIcon),
      ptrBool(closeOnActivate),
      ptrObj(child));
  }

  <T> MemorySegment radioMenuButtonRadioMenuButton(NativeObj value, Optional<NativeObj> groupValue, Optional<Consumer<NativeObj>> onChanged, Optional<Boolean> toggleable, Optional<Consumer<Boolean>> onHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Clip> clipBehavior, Optional<Widget> trailingIcon, Optional<Boolean> closeOnActivate, Optional<Widget> child) {
    var st = WidgetFactories.radioMenuButton(factories);
    var fn = WidgetFactories.RadioMenuButtonSt.radioMenuButton(st);
    return WidgetFactories.RadioMenuButtonSt.radioMenuButton.invoke(fn, arena, value.build().getId(),
      ptrObj(groupValue),
      onChanged.isPresent() ? ptrHolder(ptrValueChangedForTOptFn(onChanged.get())) : MemorySegment.NULL,
      ptrBool(toggleable),
      onHover.isPresent() ? ptrHolder(ptrValueChangedForBoolFn(onHover.get())) : MemorySegment.NULL,
      onFocusChange.isPresent() ? ptrHolder(ptrValueChangedForBoolFn(onFocusChange.get())) : MemorySegment.NULL,
      ptrEnum(clipBehavior),
      ptrObj(trailingIcon),
      ptrBool(closeOnActivate),
      ptrObj(child));
  }

  MemorySegment datePickerDialogDatePickerDialog(Optional<DateTime> initialDate, DateTime firstDate, DateTime lastDate, Optional<DateTime> currentDate, Optional<DatePickerEntryMode> initialEntryMode, Optional<Function<DateTime, Boolean>> selectableDayPredicate, Optional<String> cancelText, Optional<String> confirmText, Optional<String> helpText, Optional<DatePickerMode> initialCalendarMode, Optional<String> errorFormatText, Optional<String> errorInvalidText, Optional<String> fieldHintText, Optional<String> fieldLabelText, Optional<String> restorationId, Optional<Consumer<DatePickerEntryMode>> onDatePickerModeChange, Optional<Icon> switchToInputEntryModeIcon, Optional<Icon> switchToCalendarEntryModeIcon, Optional<EdgeInsets> insetPadding) {
    var st = WidgetFactories.datePickerDialog(factories);
    var fn = WidgetFactories.DatePickerDialogSt.datePickerDialog(st);
    return WidgetFactories.DatePickerDialogSt.datePickerDialog.invoke(fn, arena, ptrObj(initialDate),
      firstDate.build().getId(),
      lastDate.build().getId(),
      ptrObj(currentDate),
      ptrEnum(initialEntryMode),
      selectableDayPredicate.isPresent() ? ptrHolder(ptrSelectableDayPredicateFn(selectableDayPredicate.get())) : MemorySegment.NULL,
      ptrStr(cancelText),
      ptrStr(confirmText),
      ptrStr(helpText),
      ptrEnum(initialCalendarMode),
      ptrStr(errorFormatText),
      ptrStr(errorInvalidText),
      ptrStr(fieldHintText),
      ptrStr(fieldLabelText),
      ptrStr(restorationId),
      onDatePickerModeChange.isPresent() ? ptrHolder(ptrValueChangedForDatePickerEntryModeFn(onDatePickerModeChange.get())) : MemorySegment.NULL,
      ptrObj(switchToInputEntryModeIcon),
      ptrObj(switchToCalendarEntryModeIcon),
      ptrObj(insetPadding));
  }

  MemorySegment calendarDatePickerCalendarDatePicker(Optional<DateTime> initialDate, DateTime firstDate, DateTime lastDate, Optional<DateTime> currentDate, Consumer<DateTime> onDateChanged, Optional<Consumer<DateTime>> onDisplayedMonthChanged, Optional<DatePickerMode> initialCalendarMode, Optional<Function<DateTime, Boolean>> selectableDayPredicate) {
    var st = WidgetFactories.calendarDatePicker(factories);
    var fn = WidgetFactories.CalendarDatePickerSt.calendarDatePicker(st);
    return WidgetFactories.CalendarDatePickerSt.calendarDatePicker.invoke(fn, arena, ptrObj(initialDate),
      firstDate.build().getId(),
      lastDate.build().getId(),
      ptrObj(currentDate),
      ptrValueChangedForDateTimeFn(onDateChanged),
      onDisplayedMonthChanged.isPresent() ? ptrHolder(ptrValueChangedForDateTimeFn(onDisplayedMonthChanged.get())) : MemorySegment.NULL,
      ptrEnum(initialCalendarMode),
      selectableDayPredicate.isPresent() ? ptrHolder(ptrSelectableDayPredicateFn(selectableDayPredicate.get())) : MemorySegment.NULL);
  }

  MemorySegment timePickerDialogTimePickerDialog(TimeOfDay initialTime, Optional<String> cancelText, Optional<String> confirmText, Optional<String> helpText, Optional<String> errorInvalidText, Optional<String> hourLabelText, Optional<String> minuteLabelText, Optional<String> restorationId, Optional<TimePickerEntryMode> initialEntryMode, Optional<Orientation> orientation, Optional<Consumer<TimePickerEntryMode>> onEntryModeChanged, Optional<Icon> switchToInputEntryModeIcon, Optional<Icon> switchToTimerEntryModeIcon) {
    var st = WidgetFactories.timePickerDialog(factories);
    var fn = WidgetFactories.TimePickerDialogSt.timePickerDialog(st);
    return WidgetFactories.TimePickerDialogSt.timePickerDialog.invoke(fn, arena, initialTime.build().getId(),
      ptrStr(cancelText),
      ptrStr(confirmText),
      ptrStr(helpText),
      ptrStr(errorInvalidText),
      ptrStr(hourLabelText),
      ptrStr(minuteLabelText),
      ptrStr(restorationId),
      ptrEnum(initialEntryMode),
      ptrEnum(orientation),
      onEntryModeChanged.isPresent() ? ptrHolder(ptrEntryModeChangeCallbackFn(onEntryModeChanged.get())) : MemorySegment.NULL,
      ptrObj(switchToInputEntryModeIcon),
      ptrObj(switchToTimerEntryModeIcon));
  }

  MemorySegment dateRangePickerDialogDateRangePickerDialog(DateTime firstDate, DateTime lastDate, Optional<DateTime> currentDate, Optional<DatePickerEntryMode> initialEntryMode, Optional<String> helpText, Optional<String> cancelText, Optional<String> confirmText, Optional<String> saveText, Optional<String> errorInvalidRangeText, Optional<String> errorFormatText, Optional<String> errorInvalidText, Optional<String> fieldStartHintText, Optional<String> fieldEndHintText, Optional<String> fieldStartLabelText, Optional<String> fieldEndLabelText, Optional<String> restorationId, Optional<Icon> switchToInputEntryModeIcon, Optional<Icon> switchToCalendarEntryModeIcon, Optional<TriFunction<DateTime, DateTime, DateTime, Boolean>> selectableDayPredicate) {
    var st = WidgetFactories.dateRangePickerDialog(factories);
    var fn = WidgetFactories.DateRangePickerDialogSt.dateRangePickerDialog(st);
    return WidgetFactories.DateRangePickerDialogSt.dateRangePickerDialog.invoke(fn, arena, firstDate.build().getId(),
      lastDate.build().getId(),
      ptrObj(currentDate),
      ptrEnum(initialEntryMode),
      ptrStr(helpText),
      ptrStr(cancelText),
      ptrStr(confirmText),
      ptrStr(saveText),
      ptrStr(errorInvalidRangeText),
      ptrStr(errorFormatText),
      ptrStr(errorInvalidText),
      ptrStr(fieldStartHintText),
      ptrStr(fieldEndHintText),
      ptrStr(fieldStartLabelText),
      ptrStr(fieldEndLabelText),
      ptrStr(restorationId),
      ptrObj(switchToInputEntryModeIcon),
      ptrObj(switchToCalendarEntryModeIcon),
      selectableDayPredicate.isPresent() ? ptrHolder(ptrSelectableDayForRangePredicateFn(selectableDayPredicate.get())) : MemorySegment.NULL);
  }

  MemorySegment yearPickerYearPicker(Optional<DateTime> currentDate, DateTime firstDate, DateTime lastDate, Optional<DateTime> initialDate, Optional<DateTime> selectedDate, Consumer<DateTime> onChanged, Optional<DragStartBehavior> dragStartBehavior) {
    var st = WidgetFactories.yearPicker(factories);
    var fn = WidgetFactories.YearPickerSt.yearPicker(st);
    return WidgetFactories.YearPickerSt.yearPicker.invoke(fn, arena, ptrObj(currentDate),
      firstDate.build().getId(),
      lastDate.build().getId(),
      ptrObj(initialDate),
      ptrObj(selectedDate),
      ptrValueChangedForDateTimeFn(onChanged),
      ptrEnum(dragStartBehavior));
  }

  MemorySegment inputDatePickerFormFieldInputDatePickerFormField(Optional<DateTime> initialDate, DateTime firstDate, DateTime lastDate, Optional<Consumer<DateTime>> onDateSubmitted, Optional<Consumer<DateTime>> onDateSaved, Optional<Function<DateTime, Boolean>> selectableDayPredicate, Optional<String> errorFormatText, Optional<String> errorInvalidText, Optional<String> fieldHintText, Optional<String> fieldLabelText, Optional<Boolean> autofocus, Optional<Boolean> acceptEmptyDate) {
    var st = WidgetFactories.inputDatePickerFormField(factories);
    var fn = WidgetFactories.InputDatePickerFormFieldSt.inputDatePickerFormField(st);
    return WidgetFactories.InputDatePickerFormFieldSt.inputDatePickerFormField.invoke(fn, arena, ptrObj(initialDate),
      firstDate.build().getId(),
      lastDate.build().getId(),
      onDateSubmitted.isPresent() ? ptrHolder(ptrValueChangedForDateTimeFn(onDateSubmitted.get())) : MemorySegment.NULL,
      onDateSaved.isPresent() ? ptrHolder(ptrValueChangedForDateTimeFn(onDateSaved.get())) : MemorySegment.NULL,
      selectableDayPredicate.isPresent() ? ptrHolder(ptrSelectableDayPredicateFn(selectableDayPredicate.get())) : MemorySegment.NULL,
      ptrStr(errorFormatText),
      ptrStr(errorInvalidText),
      ptrStr(fieldHintText),
      ptrStr(fieldLabelText),
      ptrBool(autofocus),
      ptrBool(acceptEmptyDate));
  }

  MemorySegment searchBarSearchBar(Optional<String> hintText, Optional<Widget> leading, Optional<List<Widget>> trailing, Optional<Runnable> onTap, Optional<Consumer<PointerDownEvent>> onTapOutside, Optional<Consumer<String>> onChanged, Optional<Consumer<String>> onSubmitted, Optional<BoxConstraints> constraints, OptionalDouble elevation, Optional<Color> backgroundColor, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, Optional<Color> overlayColor, Optional<BorderSide> side, Optional<OutlinedBorder> shape, Optional<EdgeInsetsGeometry> padding, Optional<TextStyle> textStyle, Optional<TextStyle> hintStyle, Optional<TextCapitalization> textCapitalization, Optional<Boolean> enabled, Optional<Boolean> autoFocus, Optional<TextInputAction> textInputAction, Optional<EdgeInsets> scrollPadding) {
    var st = WidgetFactories.searchBar(factories);
    var fn = WidgetFactories.SearchBarSt.searchBar(st);
    return WidgetFactories.SearchBarSt.searchBar.invoke(fn, arena, ptrStr(hintText),
      ptrObj(leading),
      ptrList(trailing),
      onTap.isPresent() ? ptrHolder(ptrGestureTapCallbackFn(onTap.get())) : MemorySegment.NULL,
      onTapOutside.isPresent() ? ptrHolder(ptrTapRegionCallbackFn(onTapOutside.get())) : MemorySegment.NULL,
      onChanged.isPresent() ? ptrHolder(ptrValueChangedForStringFn(onChanged.get())) : MemorySegment.NULL,
      onSubmitted.isPresent() ? ptrHolder(ptrValueChangedForStringFn(onSubmitted.get())) : MemorySegment.NULL,
      ptrObj(constraints),
      ptr(elevation),
      ptrObj(backgroundColor),
      ptrObj(shadowColor),
      ptrObj(surfaceTintColor),
      ptrObj(overlayColor),
      ptrObj(side),
      ptrObj(shape),
      ptrObj(padding),
      ptrObj(textStyle),
      ptrObj(hintStyle),
      ptrEnum(textCapitalization),
      ptrBool(enabled),
      ptrBool(autoFocus),
      ptrEnum(textInputAction),
      ptrObj(scrollPadding));
  }

  MemorySegment cupertinoAppCupertinoApp(Optional<Widget> home, Optional<String> initialRoute, Optional<BiFunction<BuildContext, Widget, Widget>> builder, Optional<String> title, Optional<Function<BuildContext, String>> onGenerateTitle, Optional<Color> color, Optional<Boolean> showPerformanceOverlay, Optional<Boolean> checkerboardRasterCacheImages, Optional<Boolean> checkerboardOffscreenLayers, Optional<Boolean> showSemanticsDebugger, Optional<Boolean> debugShowCheckedModeBanner, Optional<String> restorationScopeId, Optional<Boolean> useInheritedMediaQuery) {
    var st = WidgetFactories.cupertinoApp(factories);
    var fn = WidgetFactories.CupertinoAppSt.cupertinoApp(st);
    return WidgetFactories.CupertinoAppSt.cupertinoApp.invoke(fn, arena, ptrObj(home),
      ptrStr(initialRoute),
      builder.isPresent() ? ptrHolder(ptrTransitionBuilderFn(builder.get())) : MemorySegment.NULL,
      ptrStr(title),
      onGenerateTitle.isPresent() ? ptrHolder(ptrGenerateAppTitleFn(onGenerateTitle.get())) : MemorySegment.NULL,
      ptrObj(color),
      ptrBool(showPerformanceOverlay),
      ptrBool(checkerboardRasterCacheImages),
      ptrBool(checkerboardOffscreenLayers),
      ptrBool(showSemanticsDebugger),
      ptrBool(debugShowCheckedModeBanner),
      ptrStr(restorationScopeId),
      ptrBool(useInheritedMediaQuery));
  }
  MemorySegment cupertinoAppRouter(Optional<BiFunction<BuildContext, Widget, Widget>> builder, Optional<String> title, Optional<Function<BuildContext, String>> onGenerateTitle, Optional<Color> color, Optional<Boolean> showPerformanceOverlay, Optional<Boolean> checkerboardRasterCacheImages, Optional<Boolean> checkerboardOffscreenLayers, Optional<Boolean> showSemanticsDebugger, Optional<Boolean> debugShowCheckedModeBanner, Optional<String> restorationScopeId, Optional<Boolean> useInheritedMediaQuery) {
    var st = WidgetFactories.cupertinoApp(factories);
    var fn = WidgetFactories.CupertinoAppSt.router(st);
    return WidgetFactories.CupertinoAppSt.router.invoke(fn, arena, builder.isPresent() ? ptrHolder(ptrTransitionBuilderFn(builder.get())) : MemorySegment.NULL,
      ptrStr(title),
      onGenerateTitle.isPresent() ? ptrHolder(ptrGenerateAppTitleFn(onGenerateTitle.get())) : MemorySegment.NULL,
      ptrObj(color),
      ptrBool(showPerformanceOverlay),
      ptrBool(checkerboardRasterCacheImages),
      ptrBool(checkerboardOffscreenLayers),
      ptrBool(showSemanticsDebugger),
      ptrBool(debugShowCheckedModeBanner),
      ptrStr(restorationScopeId),
      ptrBool(useInheritedMediaQuery));
  }

  MemorySegment cupertinoPageScaffoldCupertinoPageScaffold(Optional<ObstructingPreferredSizeWidget> navigationBar, Optional<Color> backgroundColor, Optional<Boolean> resizeToAvoidBottomInset, Widget child) {
    var st = WidgetFactories.cupertinoPageScaffold(factories);
    var fn = WidgetFactories.CupertinoPageScaffoldSt.cupertinoPageScaffold(st);
    return WidgetFactories.CupertinoPageScaffoldSt.cupertinoPageScaffold.invoke(fn, arena, ptrObj(navigationBar),
      ptrObj(backgroundColor),
      ptrBool(resizeToAvoidBottomInset),
      child.build().getId());
  }

  MemorySegment cupertinoNavigationBarCupertinoNavigationBar(Optional<Widget> leading, Optional<Boolean> automaticallyImplyLeading, Optional<Boolean> automaticallyImplyMiddle, Optional<String> previousPageTitle, Optional<Widget> middle, Optional<Widget> trailing, Optional<Border> border, Optional<Color> backgroundColor, Optional<Boolean> automaticBackgroundVisibility, Optional<Boolean> enableBackgroundFilterBlur, Optional<Brightness> brightness, Optional<Boolean> transitionBetweenRoutes, Optional<PreferredSizeWidget> bottom) {
    var st = WidgetFactories.cupertinoNavigationBar(factories);
    var fn = WidgetFactories.CupertinoNavigationBarSt.cupertinoNavigationBar(st);
    return WidgetFactories.CupertinoNavigationBarSt.cupertinoNavigationBar.invoke(fn, arena, ptrObj(leading),
      ptrBool(automaticallyImplyLeading),
      ptrBool(automaticallyImplyMiddle),
      ptrStr(previousPageTitle),
      ptrObj(middle),
      ptrObj(trailing),
      ptrObj(border),
      ptrObj(backgroundColor),
      ptrBool(automaticBackgroundVisibility),
      ptrBool(enableBackgroundFilterBlur),
      ptrEnum(brightness),
      ptrBool(transitionBetweenRoutes),
      ptrObj(bottom));
  }
  MemorySegment cupertinoNavigationBarLarge(Optional<Widget> largeTitle, Optional<Widget> leading, Optional<Boolean> automaticallyImplyLeading, Optional<Boolean> automaticallyImplyTitle, Optional<String> previousPageTitle, Optional<Widget> trailing, Optional<Border> border, Optional<Color> backgroundColor, Optional<Boolean> automaticBackgroundVisibility, Optional<Boolean> enableBackgroundFilterBlur, Optional<Brightness> brightness, Optional<Boolean> transitionBetweenRoutes, Optional<PreferredSizeWidget> bottom) {
    var st = WidgetFactories.cupertinoNavigationBar(factories);
    var fn = WidgetFactories.CupertinoNavigationBarSt.large(st);
    return WidgetFactories.CupertinoNavigationBarSt.large.invoke(fn, arena, ptrObj(largeTitle),
      ptrObj(leading),
      ptrBool(automaticallyImplyLeading),
      ptrBool(automaticallyImplyTitle),
      ptrStr(previousPageTitle),
      ptrObj(trailing),
      ptrObj(border),
      ptrObj(backgroundColor),
      ptrBool(automaticBackgroundVisibility),
      ptrBool(enableBackgroundFilterBlur),
      ptrEnum(brightness),
      ptrBool(transitionBetweenRoutes),
      ptrObj(bottom));
  }

  MemorySegment cupertinoSliverNavigationBarCupertinoSliverNavigationBar(Optional<Widget> largeTitle, Optional<Widget> leading, Optional<Boolean> automaticallyImplyLeading, Optional<Boolean> automaticallyImplyTitle, Optional<Boolean> alwaysShowMiddle, Optional<String> previousPageTitle, Optional<Widget> middle, Optional<Widget> trailing, Optional<Border> border, Optional<Color> backgroundColor, Optional<Boolean> automaticBackgroundVisibility, Optional<Boolean> enableBackgroundFilterBlur, Optional<Brightness> brightness, Optional<Boolean> transitionBetweenRoutes, Optional<Boolean> stretch, Optional<PreferredSizeWidget> bottom, Optional<NavigationBarBottomMode> bottomMode) {
    var st = WidgetFactories.cupertinoSliverNavigationBar(factories);
    var fn = WidgetFactories.CupertinoSliverNavigationBarSt.cupertinoSliverNavigationBar(st);
    return WidgetFactories.CupertinoSliverNavigationBarSt.cupertinoSliverNavigationBar.invoke(fn, arena, ptrObj(largeTitle),
      ptrObj(leading),
      ptrBool(automaticallyImplyLeading),
      ptrBool(automaticallyImplyTitle),
      ptrBool(alwaysShowMiddle),
      ptrStr(previousPageTitle),
      ptrObj(middle),
      ptrObj(trailing),
      ptrObj(border),
      ptrObj(backgroundColor),
      ptrBool(automaticBackgroundVisibility),
      ptrBool(enableBackgroundFilterBlur),
      ptrEnum(brightness),
      ptrBool(transitionBetweenRoutes),
      ptrBool(stretch),
      ptrObj(bottom),
      ptrEnum(bottomMode));
  }
  MemorySegment cupertinoSliverNavigationBarSearch(Widget searchField, Optional<Widget> largeTitle, Optional<Widget> leading, Optional<Boolean> automaticallyImplyLeading, Optional<Boolean> automaticallyImplyTitle, Optional<Boolean> alwaysShowMiddle, Optional<String> previousPageTitle, Optional<Widget> middle, Optional<Widget> trailing, Optional<Border> border, Optional<Color> backgroundColor, Optional<Boolean> automaticBackgroundVisibility, Optional<Boolean> enableBackgroundFilterBlur, Optional<Brightness> brightness, Optional<Boolean> transitionBetweenRoutes, Optional<Boolean> stretch, Optional<NavigationBarBottomMode> bottomMode, Optional<Consumer<Boolean>> onSearchableBottomTap) {
    var st = WidgetFactories.cupertinoSliverNavigationBar(factories);
    var fn = WidgetFactories.CupertinoSliverNavigationBarSt.search(st);
    return WidgetFactories.CupertinoSliverNavigationBarSt.search.invoke(fn, arena, searchField.build().getId(),
      ptrObj(largeTitle),
      ptrObj(leading),
      ptrBool(automaticallyImplyLeading),
      ptrBool(automaticallyImplyTitle),
      ptrBool(alwaysShowMiddle),
      ptrStr(previousPageTitle),
      ptrObj(middle),
      ptrObj(trailing),
      ptrObj(border),
      ptrObj(backgroundColor),
      ptrBool(automaticBackgroundVisibility),
      ptrBool(enableBackgroundFilterBlur),
      ptrEnum(brightness),
      ptrBool(transitionBetweenRoutes),
      ptrBool(stretch),
      ptrEnum(bottomMode),
      onSearchableBottomTap.isPresent() ? ptrHolder(ptrValueChangedForBoolFn(onSearchableBottomTap.get())) : MemorySegment.NULL);
  }

  MemorySegment cupertinoTabViewCupertinoTabView(Optional<Function<BuildContext, Widget>> builder, Optional<String> defaultTitle, Optional<String> restorationScopeId) {
    var st = WidgetFactories.cupertinoTabView(factories);
    var fn = WidgetFactories.CupertinoTabViewSt.cupertinoTabView(st);
    return WidgetFactories.CupertinoTabViewSt.cupertinoTabView.invoke(fn, arena, builder.isPresent() ? ptrHolder(ptrWidgetBuilderFn(builder.get())) : MemorySegment.NULL,
      ptrStr(defaultTitle),
      ptrStr(restorationScopeId));
  }

  MemorySegment cupertinoButtonCupertinoButton(Widget child, Optional<CupertinoButtonSize> sizeStyle, Optional<EdgeInsetsGeometry> padding, Optional<Color> color, Optional<Color> foregroundColor, Optional<Color> disabledColor, OptionalDouble minSize, OptionalDouble pressedOpacity, Optional<BorderRadius> borderRadius, Optional<AlignmentGeometry> alignment, Optional<Color> focusColor, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Runnable> onLongPress, Optional<Runnable> onPressed) {
    var st = WidgetFactories.cupertinoButton(factories);
    var fn = WidgetFactories.CupertinoButtonSt.cupertinoButton(st);
    return WidgetFactories.CupertinoButtonSt.cupertinoButton.invoke(fn, arena, child.build().getId(),
      ptrEnum(sizeStyle),
      ptrObj(padding),
      ptrObj(color),
      ptrObj(foregroundColor),
      ptrObj(disabledColor),
      ptr(minSize),
      ptr(pressedOpacity),
      ptrObj(borderRadius),
      ptrObj(alignment),
      ptrObj(focusColor),
      onFocusChange.isPresent() ? ptrHolder(ptrValueChangedForBoolFn(onFocusChange.get())) : MemorySegment.NULL,
      ptrBool(autofocus),
      onLongPress.isPresent() ? ptrHolder(ptrVoidCallbackFn(onLongPress.get())) : MemorySegment.NULL,
      onPressed.isPresent() ? ptrHolder(ptrVoidCallbackFn(onPressed.get())) : MemorySegment.NULL);
  }
  MemorySegment cupertinoButtonTinted(Widget child, Optional<CupertinoButtonSize> sizeStyle, Optional<EdgeInsetsGeometry> padding, Optional<Color> color, Optional<Color> foregroundColor, Optional<Color> disabledColor, OptionalDouble minSize, OptionalDouble pressedOpacity, Optional<BorderRadius> borderRadius, Optional<AlignmentGeometry> alignment, Optional<Color> focusColor, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Runnable> onLongPress, Optional<Runnable> onPressed) {
    var st = WidgetFactories.cupertinoButton(factories);
    var fn = WidgetFactories.CupertinoButtonSt.tinted(st);
    return WidgetFactories.CupertinoButtonSt.tinted.invoke(fn, arena, child.build().getId(),
      ptrEnum(sizeStyle),
      ptrObj(padding),
      ptrObj(color),
      ptrObj(foregroundColor),
      ptrObj(disabledColor),
      ptr(minSize),
      ptr(pressedOpacity),
      ptrObj(borderRadius),
      ptrObj(alignment),
      ptrObj(focusColor),
      onFocusChange.isPresent() ? ptrHolder(ptrValueChangedForBoolFn(onFocusChange.get())) : MemorySegment.NULL,
      ptrBool(autofocus),
      onLongPress.isPresent() ? ptrHolder(ptrVoidCallbackFn(onLongPress.get())) : MemorySegment.NULL,
      onPressed.isPresent() ? ptrHolder(ptrVoidCallbackFn(onPressed.get())) : MemorySegment.NULL);
  }
  MemorySegment cupertinoButtonFilled(Widget child, Optional<CupertinoButtonSize> sizeStyle, Optional<EdgeInsetsGeometry> padding, Optional<Color> color, Optional<Color> disabledColor, Optional<Color> foregroundColor, OptionalDouble minSize, OptionalDouble pressedOpacity, Optional<BorderRadius> borderRadius, Optional<AlignmentGeometry> alignment, Optional<Color> focusColor, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Runnable> onLongPress, Optional<Runnable> onPressed) {
    var st = WidgetFactories.cupertinoButton(factories);
    var fn = WidgetFactories.CupertinoButtonSt.filled(st);
    return WidgetFactories.CupertinoButtonSt.filled.invoke(fn, arena, child.build().getId(),
      ptrEnum(sizeStyle),
      ptrObj(padding),
      ptrObj(color),
      ptrObj(disabledColor),
      ptrObj(foregroundColor),
      ptr(minSize),
      ptr(pressedOpacity),
      ptrObj(borderRadius),
      ptrObj(alignment),
      ptrObj(focusColor),
      onFocusChange.isPresent() ? ptrHolder(ptrValueChangedForBoolFn(onFocusChange.get())) : MemorySegment.NULL,
      ptrBool(autofocus),
      onLongPress.isPresent() ? ptrHolder(ptrVoidCallbackFn(onLongPress.get())) : MemorySegment.NULL,
      onPressed.isPresent() ? ptrHolder(ptrVoidCallbackFn(onPressed.get())) : MemorySegment.NULL);
  }
  double cupertinoButtonTapMoveSlop() {
    var st = WidgetFactories.cupertinoButton(factories);
    var fn = WidgetFactories.CupertinoButtonSt.tapMoveSlop(st);
    return WidgetFactories.CupertinoButtonSt.tapMoveSlop.invoke(fn);
  }

  MemorySegment cupertinoSwitchCupertinoSwitch(boolean value, Optional<Consumer<Boolean>> onChanged, Optional<Color> activeColor, Optional<Color> trackColor, Optional<Color> activeTrackColor, Optional<Color> inactiveTrackColor, Optional<Color> thumbColor, Optional<Color> inactiveThumbColor, Optional<Boolean> applyTheme, Optional<Color> focusColor, Optional<Color> onLabelColor, Optional<Color> offLabelColor, Optional<Color> trackOutlineColor, OptionalDouble trackOutlineWidth, Optional<Icon> thumbIcon, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<DragStartBehavior> dragStartBehavior) {
    var st = WidgetFactories.cupertinoSwitch(factories);
    var fn = WidgetFactories.CupertinoSwitchSt.cupertinoSwitch(st);
    return WidgetFactories.CupertinoSwitchSt.cupertinoSwitch.invoke(fn, arena, (value ? 1 : 0),
      onChanged.isPresent() ? ptrHolder(ptrValueChangedForBoolFn(onChanged.get())) : MemorySegment.NULL,
      ptrObj(activeColor),
      ptrObj(trackColor),
      ptrObj(activeTrackColor),
      ptrObj(inactiveTrackColor),
      ptrObj(thumbColor),
      ptrObj(inactiveThumbColor),
      ptrBool(applyTheme),
      ptrObj(focusColor),
      ptrObj(onLabelColor),
      ptrObj(offLabelColor),
      ptrObj(trackOutlineColor),
      ptr(trackOutlineWidth),
      ptrObj(thumbIcon),
      onFocusChange.isPresent() ? ptrHolder(ptrValueChangedForBoolFn(onFocusChange.get())) : MemorySegment.NULL,
      ptrBool(autofocus),
      ptrEnum(dragStartBehavior));
  }

  MemorySegment cupertinoSliderCupertinoSlider(double value, Optional<Consumer<Double>> onChanged, Optional<Consumer<Double>> onChangeStart, Optional<Consumer<Double>> onChangeEnd, OptionalDouble min, OptionalDouble max, OptionalInt divisions, Optional<Color> activeColor, Optional<Color> thumbColor) {
    var st = WidgetFactories.cupertinoSlider(factories);
    var fn = WidgetFactories.CupertinoSliderSt.cupertinoSlider(st);
    return WidgetFactories.CupertinoSliderSt.cupertinoSlider.invoke(fn, arena, value,
      onChanged.isPresent() ? ptrHolder(ptrValueChangedForDoubleFn(onChanged.get())) : MemorySegment.NULL,
      onChangeStart.isPresent() ? ptrHolder(ptrValueChangedForDoubleFn(onChangeStart.get())) : MemorySegment.NULL,
      onChangeEnd.isPresent() ? ptrHolder(ptrValueChangedForDoubleFn(onChangeEnd.get())) : MemorySegment.NULL,
      ptr(min),
      ptr(max),
      ptr(divisions),
      ptrObj(activeColor),
      ptrObj(thumbColor));
  }

  MemorySegment cupertinoSearchTextFieldCupertinoSearchTextField(Optional<Consumer<String>> onChanged, Optional<Consumer<String>> onSubmitted, Optional<TextStyle> style, Optional<String> placeholder, Optional<TextStyle> placeholderStyle, Optional<BoxDecoration> decoration, Optional<Color> backgroundColor, Optional<BorderRadius> borderRadius, Optional<EdgeInsetsGeometry> padding, Optional<Color> itemColor, OptionalDouble itemSize, Optional<EdgeInsetsGeometry> prefixInsets, Optional<Widget> prefixIcon, Optional<EdgeInsetsGeometry> suffixInsets, Optional<Icon> suffixIcon, Optional<OverlayVisibilityMode> suffixMode, Optional<Runnable> onSuffixTap, Optional<String> restorationId, Optional<SmartQuotesType> smartQuotesType, Optional<SmartDashesType> smartDashesType, Optional<Boolean> enableIMEPersonalizedLearning, Optional<Boolean> autofocus, Optional<Runnable> onTap, Optional<Boolean> autocorrect, Optional<Boolean> enabled, OptionalDouble cursorWidth, OptionalDouble cursorHeight, Optional<Radius> cursorRadius, Optional<Boolean> cursorOpacityAnimates, Optional<Color> cursorColor) {
    var st = WidgetFactories.cupertinoSearchTextField(factories);
    var fn = WidgetFactories.CupertinoSearchTextFieldSt.cupertinoSearchTextField(st);
    return WidgetFactories.CupertinoSearchTextFieldSt.cupertinoSearchTextField.invoke(fn, arena, onChanged.isPresent() ? ptrHolder(ptrValueChangedForStringFn(onChanged.get())) : MemorySegment.NULL,
      onSubmitted.isPresent() ? ptrHolder(ptrValueChangedForStringFn(onSubmitted.get())) : MemorySegment.NULL,
      ptrObj(style),
      ptrStr(placeholder),
      ptrObj(placeholderStyle),
      ptrObj(decoration),
      ptrObj(backgroundColor),
      ptrObj(borderRadius),
      ptrObj(padding),
      ptrObj(itemColor),
      ptr(itemSize),
      ptrObj(prefixInsets),
      ptrObj(prefixIcon),
      ptrObj(suffixInsets),
      ptrObj(suffixIcon),
      ptrEnum(suffixMode),
      onSuffixTap.isPresent() ? ptrHolder(ptrVoidCallbackFn(onSuffixTap.get())) : MemorySegment.NULL,
      ptrStr(restorationId),
      ptrEnum(smartQuotesType),
      ptrEnum(smartDashesType),
      ptrBool(enableIMEPersonalizedLearning),
      ptrBool(autofocus),
      onTap.isPresent() ? ptrHolder(ptrVoidCallbackFn(onTap.get())) : MemorySegment.NULL,
      ptrBool(autocorrect),
      ptrBool(enabled),
      ptr(cursorWidth),
      ptr(cursorHeight),
      ptrObj(cursorRadius),
      ptrBool(cursorOpacityAnimates),
      ptrObj(cursorColor));
  }

  MemorySegment cupertinoActivityIndicatorCupertinoActivityIndicator(Optional<Color> color, Optional<Boolean> animating, OptionalDouble radius) {
    var st = WidgetFactories.cupertinoActivityIndicator(factories);
    var fn = WidgetFactories.CupertinoActivityIndicatorSt.cupertinoActivityIndicator(st);
    return WidgetFactories.CupertinoActivityIndicatorSt.cupertinoActivityIndicator.invoke(fn, arena, ptrObj(color),
      ptrBool(animating),
      ptr(radius));
  }
  MemorySegment cupertinoActivityIndicatorPartiallyRevealed(Optional<Color> color, OptionalDouble radius, OptionalDouble progress) {
    var st = WidgetFactories.cupertinoActivityIndicator(factories);
    var fn = WidgetFactories.CupertinoActivityIndicatorSt.partiallyRevealed(st);
    return WidgetFactories.CupertinoActivityIndicatorSt.partiallyRevealed.invoke(fn, arena, ptrObj(color),
      ptr(radius),
      ptr(progress));
  }

  MemorySegment cupertinoListSectionCupertinoListSection(Optional<List<Widget>> children, Optional<Widget> header, Optional<Widget> footer, Optional<EdgeInsetsGeometry> margin, Optional<Color> backgroundColor, Optional<BoxDecoration> decoration, Optional<Clip> clipBehavior, OptionalDouble dividerMargin, OptionalDouble additionalDividerMargin, OptionalDouble topMargin, Optional<Boolean> hasLeading, Optional<Color> separatorColor) {
    var st = WidgetFactories.cupertinoListSection(factories);
    var fn = WidgetFactories.CupertinoListSectionSt.cupertinoListSection(st);
    return WidgetFactories.CupertinoListSectionSt.cupertinoListSection.invoke(fn, arena, ptrList(children),
      ptrObj(header),
      ptrObj(footer),
      ptrObj(margin),
      ptrObj(backgroundColor),
      ptrObj(decoration),
      ptrEnum(clipBehavior),
      ptr(dividerMargin),
      ptr(additionalDividerMargin),
      ptr(topMargin),
      ptrBool(hasLeading),
      ptrObj(separatorColor));
  }
  MemorySegment cupertinoListSectionInsetGrouped(Optional<List<Widget>> children, Optional<Widget> header, Optional<Widget> footer, Optional<EdgeInsetsGeometry> margin, Optional<Color> backgroundColor, Optional<BoxDecoration> decoration, Optional<Clip> clipBehavior, OptionalDouble dividerMargin, OptionalDouble additionalDividerMargin, OptionalDouble topMargin, Optional<Boolean> hasLeading, Optional<Color> separatorColor) {
    var st = WidgetFactories.cupertinoListSection(factories);
    var fn = WidgetFactories.CupertinoListSectionSt.insetGrouped(st);
    return WidgetFactories.CupertinoListSectionSt.insetGrouped.invoke(fn, arena, ptrList(children),
      ptrObj(header),
      ptrObj(footer),
      ptrObj(margin),
      ptrObj(backgroundColor),
      ptrObj(decoration),
      ptrEnum(clipBehavior),
      ptr(dividerMargin),
      ptr(additionalDividerMargin),
      ptr(topMargin),
      ptrBool(hasLeading),
      ptrObj(separatorColor));
  }

  MemorySegment cupertinoListTileCupertinoListTile(Widget title, Optional<Widget> subtitle, Optional<Widget> additionalInfo, Optional<Widget> leading, Optional<Widget> trailing, Optional<Runnable> onTap, Optional<Color> backgroundColor, Optional<Color> backgroundColorActivated, Optional<EdgeInsetsGeometry> padding, OptionalDouble leadingSize, OptionalDouble leadingToTitle) {
    var st = WidgetFactories.cupertinoListTile(factories);
    var fn = WidgetFactories.CupertinoListTileSt.cupertinoListTile(st);
    return WidgetFactories.CupertinoListTileSt.cupertinoListTile.invoke(fn, arena, title.build().getId(),
      ptrObj(subtitle),
      ptrObj(additionalInfo),
      ptrObj(leading),
      ptrObj(trailing),
      onTap.isPresent() ? ptrHolder(ptrVoidCallbackFn(onTap.get())) : MemorySegment.NULL,
      ptrObj(backgroundColor),
      ptrObj(backgroundColorActivated),
      ptrObj(padding),
      ptr(leadingSize),
      ptr(leadingToTitle));
  }
  MemorySegment cupertinoListTileNotched(Widget title, Optional<Widget> subtitle, Optional<Widget> additionalInfo, Optional<Widget> leading, Optional<Widget> trailing, Optional<Runnable> onTap, Optional<Color> backgroundColor, Optional<Color> backgroundColorActivated, Optional<EdgeInsetsGeometry> padding, OptionalDouble leadingSize, OptionalDouble leadingToTitle) {
    var st = WidgetFactories.cupertinoListTile(factories);
    var fn = WidgetFactories.CupertinoListTileSt.notched(st);
    return WidgetFactories.CupertinoListTileSt.notched.invoke(fn, arena, title.build().getId(),
      ptrObj(subtitle),
      ptrObj(additionalInfo),
      ptrObj(leading),
      ptrObj(trailing),
      onTap.isPresent() ? ptrHolder(ptrVoidCallbackFn(onTap.get())) : MemorySegment.NULL,
      ptrObj(backgroundColor),
      ptrObj(backgroundColorActivated),
      ptrObj(padding),
      ptr(leadingSize),
      ptr(leadingToTitle));
  }

  MemorySegment cupertinoListTileChevronCupertinoListTileChevron() {
    var st = WidgetFactories.cupertinoListTileChevron(factories);
    var fn = WidgetFactories.CupertinoListTileChevronSt.cupertinoListTileChevron(st);
    return WidgetFactories.CupertinoListTileChevronSt.cupertinoListTileChevron.invoke(fn, arena);
  }

  MemorySegment cupertinoFormSectionCupertinoFormSection(List<Widget> children, Optional<Widget> header, Optional<Widget> footer, Optional<EdgeInsetsGeometry> margin, Optional<Color> backgroundColor, Optional<BoxDecoration> decoration, Optional<Clip> clipBehavior) {
    var st = WidgetFactories.cupertinoFormSection(factories);
    var fn = WidgetFactories.CupertinoFormSectionSt.cupertinoFormSection(st);
    return WidgetFactories.CupertinoFormSectionSt.cupertinoFormSection.invoke(fn, arena, ptrList(children),
      ptrObj(header),
      ptrObj(footer),
      ptrObj(margin),
      ptrObj(backgroundColor),
      ptrObj(decoration),
      ptrEnum(clipBehavior));
  }
  MemorySegment cupertinoFormSectionInsetGrouped(List<Widget> children, Optional<Widget> header, Optional<Widget> footer, Optional<EdgeInsetsGeometry> margin, Optional<Color> backgroundColor, Optional<BoxDecoration> decoration, Optional<Clip> clipBehavior) {
    var st = WidgetFactories.cupertinoFormSection(factories);
    var fn = WidgetFactories.CupertinoFormSectionSt.insetGrouped(st);
    return WidgetFactories.CupertinoFormSectionSt.insetGrouped.invoke(fn, arena, ptrList(children),
      ptrObj(header),
      ptrObj(footer),
      ptrObj(margin),
      ptrObj(backgroundColor),
      ptrObj(decoration),
      ptrEnum(clipBehavior));
  }

  MemorySegment cupertinoFormRowCupertinoFormRow(Widget child, Optional<Widget> prefix, Optional<EdgeInsetsGeometry> padding, Optional<Widget> helper, Optional<Widget> error) {
    var st = WidgetFactories.cupertinoFormRow(factories);
    var fn = WidgetFactories.CupertinoFormRowSt.cupertinoFormRow(st);
    return WidgetFactories.CupertinoFormRowSt.cupertinoFormRow.invoke(fn, arena, child.build().getId(),
      ptrObj(prefix),
      ptrObj(padding),
      ptrObj(helper),
      ptrObj(error));
  }

  MemorySegment cupertinoPickerCupertinoPicker(OptionalDouble diameterRatio, Optional<Color> backgroundColor, OptionalDouble offAxisFraction, Optional<Boolean> useMagnifier, OptionalDouble magnification, OptionalDouble squeeze, Optional<ChangeReportingBehavior> changeReportingBehavior, double itemExtent, Optional<Consumer<Integer>> onSelectedItemChanged, List<Widget> children, Optional<Widget> selectionOverlay, Optional<Boolean> looping) {
    var st = WidgetFactories.cupertinoPicker(factories);
    var fn = WidgetFactories.CupertinoPickerSt.cupertinoPicker(st);
    return WidgetFactories.CupertinoPickerSt.cupertinoPicker.invoke(fn, arena, ptr(diameterRatio),
      ptrObj(backgroundColor),
      ptr(offAxisFraction),
      ptrBool(useMagnifier),
      ptr(magnification),
      ptr(squeeze),
      ptrEnum(changeReportingBehavior),
      itemExtent,
      onSelectedItemChanged.isPresent() ? ptrHolder(ptrValueChangedForIntFn(onSelectedItemChanged.get())) : MemorySegment.NULL,
      ptrList(children),
      ptrObj(selectionOverlay),
      ptrBool(looping));
  }
  MemorySegment cupertinoPickerBuilder(OptionalDouble diameterRatio, Optional<Color> backgroundColor, OptionalDouble offAxisFraction, Optional<Boolean> useMagnifier, OptionalDouble magnification, OptionalDouble squeeze, Optional<ChangeReportingBehavior> changeReportingBehavior, double itemExtent, Optional<Consumer<Integer>> onSelectedItemChanged, BiFunction<BuildContext, Integer, Widget> itemBuilder, OptionalInt childCount, Optional<Widget> selectionOverlay) {
    var st = WidgetFactories.cupertinoPicker(factories);
    var fn = WidgetFactories.CupertinoPickerSt.builder(st);
    return WidgetFactories.CupertinoPickerSt.builder.invoke(fn, arena, ptr(diameterRatio),
      ptrObj(backgroundColor),
      ptr(offAxisFraction),
      ptrBool(useMagnifier),
      ptr(magnification),
      ptr(squeeze),
      ptrEnum(changeReportingBehavior),
      itemExtent,
      onSelectedItemChanged.isPresent() ? ptrHolder(ptrValueChangedForIntFn(onSelectedItemChanged.get())) : MemorySegment.NULL,
      ptrNullableIndexedWidgetBuilderFn(itemBuilder),
      ptr(childCount),
      ptrObj(selectionOverlay));
  }

  MemorySegment cupertinoAlertDialogCupertinoAlertDialog(Optional<Widget> title, Optional<Widget> content, Optional<List<Widget>> actions, Optional<Duration> insetAnimationDuration, Optional<Curve> insetAnimationCurve) {
    var st = WidgetFactories.cupertinoAlertDialog(factories);
    var fn = WidgetFactories.CupertinoAlertDialogSt.cupertinoAlertDialog(st);
    return WidgetFactories.CupertinoAlertDialogSt.cupertinoAlertDialog.invoke(fn, arena, ptrObj(title),
      ptrObj(content),
      ptrList(actions),
      ptrObj(insetAnimationDuration),
      ptrObj(insetAnimationCurve));
  }

  MemorySegment cupertinoActionSheetCupertinoActionSheet(Optional<Widget> title, Optional<Widget> message, Optional<List<Widget>> actions, Optional<Widget> cancelButton) {
    var st = WidgetFactories.cupertinoActionSheet(factories);
    var fn = WidgetFactories.CupertinoActionSheetSt.cupertinoActionSheet(st);
    return WidgetFactories.CupertinoActionSheetSt.cupertinoActionSheet.invoke(fn, arena, ptrObj(title),
      ptrObj(message),
      ptrList(actions),
      ptrObj(cancelButton));
  }

  MemorySegment cupertinoDialogActionCupertinoDialogAction(Optional<Runnable> onPressed, Optional<Boolean> isDefaultAction, Optional<Boolean> isDestructiveAction, Optional<TextStyle> textStyle, Widget child) {
    var st = WidgetFactories.cupertinoDialogAction(factories);
    var fn = WidgetFactories.CupertinoDialogActionSt.cupertinoDialogAction(st);
    return WidgetFactories.CupertinoDialogActionSt.cupertinoDialogAction.invoke(fn, arena, onPressed.isPresent() ? ptrHolder(ptrVoidCallbackFn(onPressed.get())) : MemorySegment.NULL,
      ptrBool(isDefaultAction),
      ptrBool(isDestructiveAction),
      ptrObj(textStyle),
      child.build().getId());
  }

  MemorySegment cupertinoActionSheetActionCupertinoActionSheetAction(Runnable onPressed, Optional<Boolean> isDefaultAction, Optional<Boolean> isDestructiveAction, Widget child) {
    var st = WidgetFactories.cupertinoActionSheetAction(factories);
    var fn = WidgetFactories.CupertinoActionSheetActionSt.cupertinoActionSheetAction(st);
    return WidgetFactories.CupertinoActionSheetActionSt.cupertinoActionSheetAction.invoke(fn, arena, ptrVoidCallbackFn(onPressed),
      ptrBool(isDefaultAction),
      ptrBool(isDestructiveAction),
      child.build().getId());
  }

  MemorySegment cupertinoTextFieldCupertinoTextField(Optional<NativeObj> groupId, Optional<BoxDecoration> decoration, Optional<EdgeInsetsGeometry> padding, Optional<String> placeholder, Optional<TextStyle> placeholderStyle, Optional<Widget> prefix, Optional<OverlayVisibilityMode> prefixMode, Optional<Widget> suffix, Optional<OverlayVisibilityMode> suffixMode, Optional<CrossAxisAlignment> crossAxisAlignment, Optional<OverlayVisibilityMode> clearButtonMode, Optional<String> clearButtonSemanticLabel, Optional<TextInputAction> textInputAction, Optional<TextCapitalization> textCapitalization, Optional<TextStyle> style, Optional<TextAlign> textAlign, Optional<TextDirection> textDirection, Optional<Boolean> readOnly, Optional<Boolean> showCursor, Optional<Boolean> autofocus, Optional<String> obscuringCharacter, Optional<Boolean> obscureText, Optional<Boolean> autocorrect, Optional<SmartDashesType> smartDashesType, Optional<SmartQuotesType> smartQuotesType, Optional<Boolean> enableSuggestions, OptionalInt maxLines, OptionalInt minLines, Optional<Boolean> expands, OptionalInt maxLength, Optional<MaxLengthEnforcement> maxLengthEnforcement, Optional<Consumer<String>> onChanged, Optional<Runnable> onEditingComplete, Optional<Consumer<String>> onSubmitted, Optional<Consumer<PointerDownEvent>> onTapOutside, Optional<Consumer<PointerDownEvent>> onTapUpOutside, Optional<Boolean> enabled, OptionalDouble cursorWidth, OptionalDouble cursorHeight, Optional<Radius> cursorRadius, Optional<Boolean> cursorOpacityAnimates, Optional<Color> cursorColor, Optional<BoxHeightStyle> selectionHeightStyle, Optional<BoxWidthStyle> selectionWidthStyle, Optional<Brightness> keyboardAppearance, Optional<EdgeInsets> scrollPadding, Optional<DragStartBehavior> dragStartBehavior, Optional<Boolean> enableInteractiveSelection, Optional<Boolean> selectAllOnFocus, Optional<Runnable> onTap, Optional<List<String>> autofillHints, Optional<Clip> clipBehavior, Optional<String> restorationId, Optional<Boolean> scribbleEnabled, Optional<Boolean> stylusHandwritingEnabled, Optional<Boolean> enableIMEPersonalizedLearning) {
    var st = WidgetFactories.cupertinoTextField(factories);
    var fn = WidgetFactories.CupertinoTextFieldSt.cupertinoTextField(st);
    return WidgetFactories.CupertinoTextFieldSt.cupertinoTextField.invoke(fn, arena, ptrObj(groupId),
      ptrObj(decoration),
      ptrObj(padding),
      ptrStr(placeholder),
      ptrObj(placeholderStyle),
      ptrObj(prefix),
      ptrEnum(prefixMode),
      ptrObj(suffix),
      ptrEnum(suffixMode),
      ptrEnum(crossAxisAlignment),
      ptrEnum(clearButtonMode),
      ptrStr(clearButtonSemanticLabel),
      ptrEnum(textInputAction),
      ptrEnum(textCapitalization),
      ptrObj(style),
      ptrEnum(textAlign),
      ptrEnum(textDirection),
      ptrBool(readOnly),
      ptrBool(showCursor),
      ptrBool(autofocus),
      ptrStr(obscuringCharacter),
      ptrBool(obscureText),
      ptrBool(autocorrect),
      ptrEnum(smartDashesType),
      ptrEnum(smartQuotesType),
      ptrBool(enableSuggestions),
      ptr(maxLines),
      ptr(minLines),
      ptrBool(expands),
      ptr(maxLength),
      ptrEnum(maxLengthEnforcement),
      onChanged.isPresent() ? ptrHolder(ptrValueChangedForStringFn(onChanged.get())) : MemorySegment.NULL,
      onEditingComplete.isPresent() ? ptrHolder(ptrVoidCallbackFn(onEditingComplete.get())) : MemorySegment.NULL,
      onSubmitted.isPresent() ? ptrHolder(ptrValueChangedForStringFn(onSubmitted.get())) : MemorySegment.NULL,
      onTapOutside.isPresent() ? ptrHolder(ptrTapRegionCallbackFn(onTapOutside.get())) : MemorySegment.NULL,
      onTapUpOutside.isPresent() ? ptrHolder(ptrTapRegionCallbackFn(onTapUpOutside.get())) : MemorySegment.NULL,
      ptrBool(enabled),
      ptr(cursorWidth),
      ptr(cursorHeight),
      ptrObj(cursorRadius),
      ptrBool(cursorOpacityAnimates),
      ptrObj(cursorColor),
      ptrEnum(selectionHeightStyle),
      ptrEnum(selectionWidthStyle),
      ptrEnum(keyboardAppearance),
      ptrObj(scrollPadding),
      ptrEnum(dragStartBehavior),
      ptrBool(enableInteractiveSelection),
      ptrBool(selectAllOnFocus),
      onTap.isPresent() ? ptrHolder(ptrGestureTapCallbackFn(onTap.get())) : MemorySegment.NULL,
      ptrStrList(autofillHints),
      ptrEnum(clipBehavior),
      ptrStr(restorationId),
      ptrBool(scribbleEnabled),
      ptrBool(stylusHandwritingEnabled),
      ptrBool(enableIMEPersonalizedLearning));
  }
  MemorySegment cupertinoTextFieldBorderless(Optional<NativeObj> groupId, Optional<BoxDecoration> decoration, Optional<EdgeInsetsGeometry> padding, Optional<String> placeholder, Optional<TextStyle> placeholderStyle, Optional<Widget> prefix, Optional<OverlayVisibilityMode> prefixMode, Optional<Widget> suffix, Optional<OverlayVisibilityMode> suffixMode, Optional<CrossAxisAlignment> crossAxisAlignment, Optional<OverlayVisibilityMode> clearButtonMode, Optional<String> clearButtonSemanticLabel, Optional<TextInputAction> textInputAction, Optional<TextCapitalization> textCapitalization, Optional<TextStyle> style, Optional<TextAlign> textAlign, Optional<TextDirection> textDirection, Optional<Boolean> readOnly, Optional<Boolean> showCursor, Optional<Boolean> autofocus, Optional<String> obscuringCharacter, Optional<Boolean> obscureText, Optional<Boolean> autocorrect, Optional<SmartDashesType> smartDashesType, Optional<SmartQuotesType> smartQuotesType, Optional<Boolean> enableSuggestions, OptionalInt maxLines, OptionalInt minLines, Optional<Boolean> expands, OptionalInt maxLength, Optional<MaxLengthEnforcement> maxLengthEnforcement, Optional<Consumer<String>> onChanged, Optional<Runnable> onEditingComplete, Optional<Consumer<String>> onSubmitted, Optional<Consumer<PointerDownEvent>> onTapOutside, Optional<Consumer<PointerDownEvent>> onTapUpOutside, Optional<Boolean> enabled, OptionalDouble cursorWidth, OptionalDouble cursorHeight, Optional<Radius> cursorRadius, Optional<Boolean> cursorOpacityAnimates, Optional<Color> cursorColor, Optional<BoxHeightStyle> selectionHeightStyle, Optional<BoxWidthStyle> selectionWidthStyle, Optional<Brightness> keyboardAppearance, Optional<EdgeInsets> scrollPadding, Optional<DragStartBehavior> dragStartBehavior, Optional<Boolean> enableInteractiveSelection, Optional<Boolean> selectAllOnFocus, Optional<Runnable> onTap, Optional<List<String>> autofillHints, Optional<Clip> clipBehavior, Optional<String> restorationId, Optional<Boolean> scribbleEnabled, Optional<Boolean> stylusHandwritingEnabled, Optional<Boolean> enableIMEPersonalizedLearning) {
    var st = WidgetFactories.cupertinoTextField(factories);
    var fn = WidgetFactories.CupertinoTextFieldSt.borderless(st);
    return WidgetFactories.CupertinoTextFieldSt.borderless.invoke(fn, arena, ptrObj(groupId),
      ptrObj(decoration),
      ptrObj(padding),
      ptrStr(placeholder),
      ptrObj(placeholderStyle),
      ptrObj(prefix),
      ptrEnum(prefixMode),
      ptrObj(suffix),
      ptrEnum(suffixMode),
      ptrEnum(crossAxisAlignment),
      ptrEnum(clearButtonMode),
      ptrStr(clearButtonSemanticLabel),
      ptrEnum(textInputAction),
      ptrEnum(textCapitalization),
      ptrObj(style),
      ptrEnum(textAlign),
      ptrEnum(textDirection),
      ptrBool(readOnly),
      ptrBool(showCursor),
      ptrBool(autofocus),
      ptrStr(obscuringCharacter),
      ptrBool(obscureText),
      ptrBool(autocorrect),
      ptrEnum(smartDashesType),
      ptrEnum(smartQuotesType),
      ptrBool(enableSuggestions),
      ptr(maxLines),
      ptr(minLines),
      ptrBool(expands),
      ptr(maxLength),
      ptrEnum(maxLengthEnforcement),
      onChanged.isPresent() ? ptrHolder(ptrValueChangedForStringFn(onChanged.get())) : MemorySegment.NULL,
      onEditingComplete.isPresent() ? ptrHolder(ptrVoidCallbackFn(onEditingComplete.get())) : MemorySegment.NULL,
      onSubmitted.isPresent() ? ptrHolder(ptrValueChangedForStringFn(onSubmitted.get())) : MemorySegment.NULL,
      onTapOutside.isPresent() ? ptrHolder(ptrTapRegionCallbackFn(onTapOutside.get())) : MemorySegment.NULL,
      onTapUpOutside.isPresent() ? ptrHolder(ptrTapRegionCallbackFn(onTapUpOutside.get())) : MemorySegment.NULL,
      ptrBool(enabled),
      ptr(cursorWidth),
      ptr(cursorHeight),
      ptrObj(cursorRadius),
      ptrBool(cursorOpacityAnimates),
      ptrObj(cursorColor),
      ptrEnum(selectionHeightStyle),
      ptrEnum(selectionWidthStyle),
      ptrEnum(keyboardAppearance),
      ptrObj(scrollPadding),
      ptrEnum(dragStartBehavior),
      ptrBool(enableInteractiveSelection),
      ptrBool(selectAllOnFocus),
      onTap.isPresent() ? ptrHolder(ptrGestureTapCallbackFn(onTap.get())) : MemorySegment.NULL,
      ptrStrList(autofillHints),
      ptrEnum(clipBehavior),
      ptrStr(restorationId),
      ptrBool(scribbleEnabled),
      ptrBool(stylusHandwritingEnabled),
      ptrBool(enableIMEPersonalizedLearning));
  }

  MemorySegment cupertinoCheckboxCupertinoCheckbox(Optional<Boolean> value, Optional<Boolean> tristate, Optional<Consumer<Boolean>> onChanged, Optional<Color> activeColor, Optional<Color> inactiveColor, Optional<Color> fillColor, Optional<Color> checkColor, Optional<Color> focusColor, Optional<Boolean> autofocus, Optional<BorderSide> side, Optional<OutlinedBorder> shape, Optional<String> semanticLabel) {
    var st = WidgetFactories.cupertinoCheckbox(factories);
    var fn = WidgetFactories.CupertinoCheckboxSt.cupertinoCheckbox(st);
    return WidgetFactories.CupertinoCheckboxSt.cupertinoCheckbox.invoke(fn, arena, ptrBool(value),
      ptrBool(tristate),
      onChanged.isPresent() ? ptrHolder(ptrValueChangedForBoolOptFn(onChanged.get())) : MemorySegment.NULL,
      ptrObj(activeColor),
      ptrObj(inactiveColor),
      ptrObj(fillColor),
      ptrObj(checkColor),
      ptrObj(focusColor),
      ptrBool(autofocus),
      ptrObj(side),
      ptrObj(shape),
      ptrStr(semanticLabel));
  }

  MemorySegment cupertinoExpansionTileCupertinoExpansionTile(Widget title, Widget child, Optional<ExpansionTileTransitionMode> transitionMode) {
    var st = WidgetFactories.cupertinoExpansionTile(factories);
    var fn = WidgetFactories.CupertinoExpansionTileSt.cupertinoExpansionTile(st);
    return WidgetFactories.CupertinoExpansionTileSt.cupertinoExpansionTile.invoke(fn, arena, title.build().getId(),
      child.build().getId(),
      ptrEnum(transitionMode));
  }

  MemorySegment cupertinoTimerPickerCupertinoTimerPicker(Optional<CupertinoTimerPickerMode> mode, Optional<Duration> initialTimerDuration, OptionalInt minuteInterval, OptionalInt secondInterval, Optional<AlignmentGeometry> alignment, Optional<Color> backgroundColor, OptionalDouble itemExtent, Consumer<Duration> onTimerDurationChanged, Optional<ChangeReportingBehavior> changeReportingBehavior, Optional<TriFunction<BuildContext, Integer, Integer, Widget>> selectionOverlayBuilder) {
    var st = WidgetFactories.cupertinoTimerPicker(factories);
    var fn = WidgetFactories.CupertinoTimerPickerSt.cupertinoTimerPicker(st);
    return WidgetFactories.CupertinoTimerPickerSt.cupertinoTimerPicker.invoke(fn, arena, ptrEnum(mode),
      ptrObj(initialTimerDuration),
      ptr(minuteInterval),
      ptr(secondInterval),
      ptrObj(alignment),
      ptrObj(backgroundColor),
      ptr(itemExtent),
      ptrValueChangedForDurationFn(onTimerDurationChanged),
      ptrEnum(changeReportingBehavior),
      selectionOverlayBuilder.isPresent() ? ptrHolder(ptrSelectionOverlayBuilderFn(selectionOverlayBuilder.get())) : MemorySegment.NULL);
  }

  MemorySegment cupertinoNavigationBarBackButtonCupertinoNavigationBarBackButton(Optional<Color> color, Optional<String> previousPageTitle, Optional<Runnable> onPressed) {
    var st = WidgetFactories.cupertinoNavigationBarBackButton(factories);
    var fn = WidgetFactories.CupertinoNavigationBarBackButtonSt.cupertinoNavigationBarBackButton(st);
    return WidgetFactories.CupertinoNavigationBarBackButtonSt.cupertinoNavigationBarBackButton.invoke(fn, arena, ptrObj(color),
      ptrStr(previousPageTitle),
      onPressed.isPresent() ? ptrHolder(ptrVoidCallbackFn(onPressed.get())) : MemorySegment.NULL);
  }

  MemorySegment cupertinoTabBarCupertinoTabBar(List<BottomNavigationBarItem> items, Optional<Consumer<Integer>> onTap, OptionalInt currentIndex, Optional<Color> backgroundColor, Optional<Color> activeColor, Optional<Color> inactiveColor, OptionalDouble iconSize, OptionalDouble height, Optional<Border> border) {
    var st = WidgetFactories.cupertinoTabBar(factories);
    var fn = WidgetFactories.CupertinoTabBarSt.cupertinoTabBar(st);
    return WidgetFactories.CupertinoTabBarSt.cupertinoTabBar.invoke(fn, arena, ptrList(items),
      onTap.isPresent() ? ptrHolder(ptrValueChangedForIntFn(onTap.get())) : MemorySegment.NULL,
      ptr(currentIndex),
      ptrObj(backgroundColor),
      ptrObj(activeColor),
      ptrObj(inactiveColor),
      ptr(iconSize),
      ptr(height),
      ptrObj(border));
  }

  int bottomNavigationBarItemBottomNavigationBarItem(Widget icon, Optional<String> label, Optional<Widget> activeIcon, Optional<Color> backgroundColor, Optional<String> tooltip) {
    var st = WidgetFactories.bottomNavigationBarItem(factories);
    var fn = WidgetFactories.BottomNavigationBarItemSt.bottomNavigationBarItem(st);
    return WidgetFactories.BottomNavigationBarItemSt.bottomNavigationBarItem.invoke(fn, icon.build().getId(),
      ptrStr(label),
      ptrObj(activeIcon),
      ptrObj(backgroundColor),
      ptrStr(tooltip));
  }

  MemorySegment cupertinoTabScaffoldCupertinoTabScaffold(CupertinoTabBar tabBar, BiFunction<BuildContext, Integer, Widget> tabBuilder, Optional<Color> backgroundColor, Optional<Boolean> resizeToAvoidBottomInset, Optional<String> restorationId) {
    var st = WidgetFactories.cupertinoTabScaffold(factories);
    var fn = WidgetFactories.CupertinoTabScaffoldSt.cupertinoTabScaffold(st);
    return WidgetFactories.CupertinoTabScaffoldSt.cupertinoTabScaffold.invoke(fn, arena, tabBar.build().getId(),
      ptrIndexedWidgetBuilderFn(tabBuilder),
      ptrObj(backgroundColor),
      ptrBool(resizeToAvoidBottomInset),
      ptrStr(restorationId));
  }

  MemorySegment cupertinoContextMenuCupertinoContextMenu(List<Widget> actions, Widget child, Optional<Boolean> enableHapticFeedback) {
    var st = WidgetFactories.cupertinoContextMenu(factories);
    var fn = WidgetFactories.CupertinoContextMenuSt.cupertinoContextMenu(st);
    return WidgetFactories.CupertinoContextMenuSt.cupertinoContextMenu.invoke(fn, arena, ptrList(actions),
      child.build().getId(),
      ptrBool(enableHapticFeedback));
  }
  MemorySegment cupertinoContextMenuBuilder(List<Widget> actions, BiFunction<BuildContext, Animation, Widget> builder, Optional<Boolean> enableHapticFeedback) {
    var st = WidgetFactories.cupertinoContextMenu(factories);
    var fn = WidgetFactories.CupertinoContextMenuSt.builder(st);
    return WidgetFactories.CupertinoContextMenuSt.builder.invoke(fn, arena, ptrList(actions),
      ptrCupertinoContextMenuBuilderFn(builder),
      ptrBool(enableHapticFeedback));
  }

  MemorySegment cupertinoContextMenuActionCupertinoContextMenuAction(Widget child, Optional<Boolean> isDefaultAction, Optional<Boolean> isDestructiveAction, Optional<Runnable> onPressed, Optional<IconData> trailingIcon) {
    var st = WidgetFactories.cupertinoContextMenuAction(factories);
    var fn = WidgetFactories.CupertinoContextMenuActionSt.cupertinoContextMenuAction(st);
    return WidgetFactories.CupertinoContextMenuActionSt.cupertinoContextMenuAction.invoke(fn, arena, child.build().getId(),
      ptrBool(isDefaultAction),
      ptrBool(isDestructiveAction),
      onPressed.isPresent() ? ptrHolder(ptrVoidCallbackFn(onPressed.get())) : MemorySegment.NULL,
      ptrObj(trailingIcon));
  }

  <T extends StatefulWidget> MemorySegment subStateSubState(Runnable initStateFn, Consumer<NativeObj> didUpdateWidgetFn, Runnable reassembleFn, Runnable deactivateFn, Runnable activateFn, Runnable disposeFn, Function<BuildContext, Widget> buildFn, Runnable didChangeDependenciesFn) {
    var st = WidgetFactories.subState(factories);
    var fn = WidgetFactories.SubStateSt.subState(st);
    return WidgetFactories.SubStateSt.subState.invoke(fn, arena, ptrVoidCallbackFn(initStateFn),
      ptrVoidCallbackDartObjFn(didUpdateWidgetFn),
      ptrVoidCallbackFn(reassembleFn),
      ptrVoidCallbackFn(deactivateFn),
      ptrVoidCallbackFn(activateFn),
      ptrVoidCallbackFn(disposeFn),
      ptrDartObjCallbackDartObjFn(buildFn),
      ptrVoidCallbackFn(didChangeDependenciesFn));
  }

  MemorySegment subStatefulWidgetSubStatefulWidget(Supplier<State> createStateFn) {
    var st = WidgetFactories.subStatefulWidget(factories);
    var fn = WidgetFactories.SubStatefulWidgetSt.subStatefulWidget(st);
    return WidgetFactories.SubStatefulWidgetSt.subStatefulWidget.invoke(fn, arena, ptrDartObjCallbackFn(createStateFn));
  }

  MemorySegment subStatelessWidgetSubStatelessWidget(Function<BuildContext, Widget> buildFn) {
    var st = WidgetFactories.subStatelessWidget(factories);
    var fn = WidgetFactories.SubStatelessWidgetSt.subStatelessWidget(st);
    return WidgetFactories.SubStatelessWidgetSt.subStatelessWidget.invoke(fn, arena, ptrDartObjCallbackDartObjFn(buildFn));
  }

  <T extends StatefulWidget> MemorySegment subAnimatedStateSubAnimatedState(Runnable initStateFn, Consumer<NativeObj> didUpdateWidgetFn, Runnable reassembleFn, Runnable deactivateFn, Runnable activateFn, Runnable disposeFn, Function<BuildContext, Widget> buildFn, Runnable didChangeDependenciesFn) {
    var st = WidgetFactories.subAnimatedState(factories);
    var fn = WidgetFactories.SubAnimatedStateSt.subAnimatedState(st);
    return WidgetFactories.SubAnimatedStateSt.subAnimatedState.invoke(fn, arena, ptrVoidCallbackFn(initStateFn),
      ptrVoidCallbackDartObjFn(didUpdateWidgetFn),
      ptrVoidCallbackFn(reassembleFn),
      ptrVoidCallbackFn(deactivateFn),
      ptrVoidCallbackFn(activateFn),
      ptrVoidCallbackFn(disposeFn),
      ptrDartObjCallbackDartObjFn(buildFn),
      ptrVoidCallbackFn(didChangeDependenciesFn));
  }
  int subAnimatedStateAnimationController(SubAnimatedState self, Duration duration) {
    var st = WidgetFactories.subAnimatedState(factories);
    var fn = WidgetFactories.SubAnimatedStateSt.animationController(st);
    return WidgetFactories.SubAnimatedStateSt.animationController.invoke(fn, self.build().getId(),
      duration.build().getId());
  }

  int offsetTween(Offset begin, Offset end, Animation parent) {
    throw new UnsupportedOperationException("offsetTween is web-only; use OffsetAnimation.create() or EWT.OffsetTween() in web mode");
  }
MemorySegment ptrWidgetBuilderFn(Function<BuildContext, Widget> jFn) {
  return WidgetBuilderFFI.allocate((context) -> {
    final var jFnRet = jFn.apply(new BuildContext() { public int getId() { return context; } });
    return jFnRet.build().getId();
  }, arena);
}
MemorySegment ptrSelectableDayPredicateFn(Function<DateTime, Boolean> jFn) {
  return SelectableDayPredicateFFI.allocate((day) -> {
    final var jFnRet = jFn.apply(new DateTime(day));
    return (jFnRet ? 1 : 0);
  }, arena);
}
MemorySegment ptrTransitionBuilderFn(BiFunction<BuildContext, Widget, Widget> jFn) {
  return TransitionBuilderFFI.allocate((context, child) -> {
    final var jFnRet = jFn.apply(new BuildContext() { public int getId() { return context; } }, new Widget(child) {});
    return jFnRet.build().getId();
  }, arena);
}
<T> MemorySegment ptrValueChangedForDatePickerEntryModeFn(Consumer<DatePickerEntryMode> jFn) {
  return ValueChangedForDatePickerEntryModeFFI.allocate((value) -> {
    jFn.accept(DatePickerEntryMode.values()[value]);
  }, arena);
}
MemorySegment ptrEntryModeChangeCallbackFn(Consumer<TimePickerEntryMode> jFn) {
  return EntryModeChangeCallbackFFI.allocate((mode) -> {
    jFn.accept(TimePickerEntryMode.values()[mode]);
  }, arena);
}
MemorySegment ptrSelectableDayForRangePredicateFn(TriFunction<DateTime, DateTime, DateTime, Boolean> jFn) {
  return SelectableDayForRangePredicateFFI.allocate((day, selectedStartDay, selectedEndDay) -> {
    final var jFnRet = jFn.apply(new DateTime(day), new DateTime(selectedStartDay), new DateTime(selectedEndDay));
    return (jFnRet ? 1 : 0);
  }, arena);
}
MemorySegment ptrPointerEnterEventListenerFn(Consumer<PointerEnterEvent> jFn) {
  return PointerEnterEventListenerFFI.allocate((event) -> {
    jFn.accept(new PointerEnterEvent(event));
  }, arena);
}
MemorySegment ptrPointerExitEventListenerFn(Consumer<PointerExitEvent> jFn) {
  return PointerExitEventListenerFFI.allocate((event) -> {
    jFn.accept(new PointerExitEvent(event));
  }, arena);
}
MemorySegment ptrPointerHoverEventListenerFn(Consumer<PointerHoverEvent> jFn) {
  return PointerHoverEventListenerFFI.allocate((event) -> {
    jFn.accept(new PointerHoverEvent(event));
  }, arena);
}
MemorySegment ptrVoidCallbackFn(Runnable jFn) {
  return VoidCallbackFFI.allocate(() -> {
    jFn.run();
  }, arena);
}
MemorySegment ptrNullableIndexedWidgetBuilderFn(BiFunction<BuildContext, Integer, Widget> jFn) {
  return NullableIndexedWidgetBuilderFFI.allocate((context, index) -> {
    final var jFnRet = jFn.apply(new BuildContext() { public int getId() { return context; } }, index);
    return jFnRet != null ? jFnRet.build().getId() : null;
  }, arena);
}
MemorySegment ptrIndexedWidgetBuilderFn(BiFunction<BuildContext, Integer, Widget> jFn) {
  return IndexedWidgetBuilderFFI.allocate((context, index) -> {
    final var jFnRet = jFn.apply(new BuildContext() { public int getId() { return context; } }, index);
    return jFnRet.build().getId();
  }, arena);
}
<T> MemorySegment ptrValueChangedForIntFn(Consumer<Integer> jFn) {
  return ValueChangedForIntFFI.allocate((value) -> {
    jFn.accept(value);
  }, arena);
}
MemorySegment ptrGestureScaleEndCallbackFn(Consumer<ScaleEndDetails> jFn) {
  return GestureScaleEndCallbackFFI.allocate((details) -> {
    jFn.accept(new ScaleEndDetails(details));
  }, arena);
}
MemorySegment ptrGestureScaleStartCallbackFn(Consumer<ScaleStartDetails> jFn) {
  return GestureScaleStartCallbackFFI.allocate((details) -> {
    jFn.accept(new ScaleStartDetails(details));
  }, arena);
}
MemorySegment ptrGestureScaleUpdateCallbackFn(Consumer<ScaleUpdateDetails> jFn) {
  return GestureScaleUpdateCallbackFFI.allocate((details) -> {
    jFn.accept(new ScaleUpdateDetails(details));
  }, arena);
}
MemorySegment ptrDragAnchorStrategyFn(TriFunction<Draggable, BuildContext, Offset, Offset> jFn) {
  return DragAnchorStrategyFFI.allocate((draggable, context, position) -> {
    final var jFnRet = jFn.apply(new Draggable(draggable), new BuildContext() { public int getId() { return context; } }, new Offset(position));
    return jFnRet.build().getId();
  }, arena);
}
MemorySegment ptrDragUpdateCallbackFn(Consumer<DragUpdateDetails> jFn) {
  return DragUpdateCallbackFFI.allocate((details) -> {
    jFn.accept(new DragUpdateDetails(details));
  }, arena);
}
MemorySegment ptrDraggableCanceledCallbackFn(BiConsumer<Velocity, Offset> jFn) {
  return DraggableCanceledCallbackFFI.allocate((velocity, offset) -> {
    jFn.accept(new Velocity(velocity), new Offset(offset));
  }, arena);
}
MemorySegment ptrDragEndCallbackFn(Consumer<DraggableDetails> jFn) {
  return DragEndCallbackFFI.allocate((details) -> {
    jFn.accept(new DraggableDetails(details));
  }, arena);
}
MemorySegment ptrAllowedButtonsFilterFn(Function<Integer, Boolean> jFn) {
  return AllowedButtonsFilterFFI.allocate((buttons) -> {
    final var jFnRet = jFn.apply(buttons);
    return (jFnRet ? 1 : 0);
  }, arena);
}
<T> MemorySegment ptrDragTargetBuilderForTFn(TriFunction<BuildContext, List<NativeObj>, List<NativeObj>, Widget> jFn) {
  return DragTargetBuilderForTFFI.allocate((context, candidateData, rejectedData) -> {
    final var jFnRet = jFn.apply(new BuildContext() { public int getId() { return context; } }, ((List<NativeObj>) (List) memToWidgetList(candidateData)), ((List<NativeObj>) (List) memToWidgetList(rejectedData)));
    return jFnRet.build().getId();
  }, arena);
}
<T> MemorySegment ptrDragTargetWillAcceptForTFn(Function<NativeObj, Boolean> jFn) {
  return DragTargetWillAcceptForTFFI.allocate((data) -> {
    final var jFnRet = jFn.apply((NativeObj) new NativeObj.Base() {{ this.id = data; }});
    return (jFnRet ? 1 : 0);
  }, arena);
}
<T> MemorySegment ptrDragTargetWillAcceptWithDetailsForTFn(Function<DragTargetDetails, Boolean> jFn) {
  return DragTargetWillAcceptWithDetailsForTFFI.allocate((details) -> {
    final var jFnRet = jFn.apply(new DragTargetDetails(details));
    return (jFnRet ? 1 : 0);
  }, arena);
}
<T> MemorySegment ptrDragTargetAcceptForTFn(Consumer<NativeObj> jFn) {
  return DragTargetAcceptForTFFI.allocate((data) -> {
    jFn.accept((NativeObj) new NativeObj.Base() {{ this.id = data; }});
  }, arena);
}
<T> MemorySegment ptrDragTargetAcceptWithDetailsForTFn(Consumer<DragTargetDetails> jFn) {
  return DragTargetAcceptWithDetailsForTFFI.allocate((details) -> {
    jFn.accept(new DragTargetDetails(details));
  }, arena);
}
<T> MemorySegment ptrDragTargetLeaveForTFn(Consumer<NativeObj> jFn) {
  return DragTargetLeaveForTFFI.allocate((data) -> {
    jFn.accept((NativeObj) new NativeObj.Base() {{ this.id = data; }});
  }, arena);
}
<T> MemorySegment ptrDragTargetMoveForTFn(Consumer<DragTargetDetails> jFn) {
  return DragTargetMoveForTFFI.allocate((details) -> {
    jFn.accept(new DragTargetDetails(details));
  }, arena);
}
MemorySegment ptrHeroFlightShuttleBuilderFn(PentaFunction<BuildContext, Animation, HeroFlightDirection, BuildContext, BuildContext, Widget> jFn) {
  return HeroFlightShuttleBuilderFFI.allocate((flightContext, animation, flightDirection, fromHeroContext, toHeroContext) -> {
    final var jFnRet = jFn.apply(new BuildContext() { public int getId() { return flightContext; } }, new Animation() { public int getId() { return animation; } }, HeroFlightDirection.values()[flightDirection], new BuildContext() { public int getId() { return fromHeroContext; } }, new BuildContext() { public int getId() { return toHeroContext; } });
    return jFnRet.build().getId();
  }, arena);
}
MemorySegment ptrAnimatedSwitcherTransitionBuilderFn(BiFunction<Widget, Animation, Widget> jFn) {
  return AnimatedSwitcherTransitionBuilderFFI.allocate((child, animation) -> {
    final var jFnRet = jFn.apply(new Widget(child) {}, new Animation() { public int getId() { return animation; } });
    return jFnRet.build().getId();
  }, arena);
}
MemorySegment ptrAnimatedSwitcherLayoutBuilderFn(BiFunction<Widget, List<Widget>, Widget> jFn) {
  return AnimatedSwitcherLayoutBuilderFFI.allocate((currentChild, previousChildren) -> {
    final var jFnRet = jFn.apply(new Widget(currentChild) {}, memToWidgetList(previousChildren));
    return jFnRet.build().getId();
  }, arena);
}
<T> MemorySegment ptrValueChangedForBoolFn(Consumer<Boolean> jFn) {
  return ValueChangedForBoolFFI.allocate((value) -> {
    jFn.accept(intToBool(value));
  }, arena);
}
MemorySegment ptrPointerDownEventListenerFn(Consumer<PointerDownEvent> jFn) {
  return PointerDownEventListenerFFI.allocate((event) -> {
    jFn.accept(new PointerDownEvent(event));
  }, arena);
}
MemorySegment ptrPointerUpEventListenerFn(Consumer<PointerUpEvent> jFn) {
  return PointerUpEventListenerFFI.allocate((event) -> {
    jFn.accept(new PointerUpEvent(event));
  }, arena);
}
MemorySegment ptrTapRegionCallbackFn(Consumer<PointerDownEvent> jFn) {
  return TapRegionCallbackFFI.allocate((event) -> {
    jFn.accept(new PointerDownEvent(event));
  }, arena);
}
MemorySegment ptrTapRegionUpCallbackFn(Consumer<PointerUpEvent> jFn) {
  return TapRegionUpCallbackFFI.allocate((event) -> {
    jFn.accept(new PointerUpEvent(event));
  }, arena);
}
MemorySegment ptrDrawerCallbackFn(Consumer<Boolean> jFn) {
  return DrawerCallbackFFI.allocate((isOpened) -> {
    jFn.accept(intToBool(isOpened));
  }, arena);
}
MemorySegment ptrDartObjCallbackDartObjDartObjFn(BiFunction<BuildContext, Animation, Widget> jFn) {
  return DartObjCallbackDartObjDartObjFFI.allocate((b, a) -> {
    final var jFnRet = jFn.apply(new BuildContext() { public int getId() { return b; } }, new Animation() { public int getId() { return a; } });
    return jFnRet != null ? jFnRet.build().getId() : null;
  }, arena);
}
MemorySegment ptrGenerateAppTitleFn(Function<BuildContext, String> jFn) {
  return GenerateAppTitleFFI.allocate((context) -> {
    final var jFnRet = jFn.apply(new BuildContext() { public int getId() { return context; } });
    return arena.allocateFrom(jFnRet);
  }, arena);
}
<T> MemorySegment ptrValueChangedForStringFn(Consumer<String> jFn) {
  return ValueChangedForStringFFI.allocate((value) -> {
    jFn.accept(value.getString(0));
  }, arena);
}
MemorySegment ptrGestureTapCallbackFn(Runnable jFn) {
  return GestureTapCallbackFFI.allocate(() -> {
    jFn.run();
  }, arena);
}
MemorySegment ptrInputCounterWidgetBuilderFn(QuadFunction<BuildContext, Integer, Boolean, Integer, Widget> jFn) {
  return InputCounterWidgetBuilderFFI.allocate((context, currentLength, isFocused, maxLength) -> {
    final var jFnRet = jFn.apply(new BuildContext() { public int getId() { return context; } }, currentLength, intToBool(isFocused), maxLength);
    return jFnRet != null ? jFnRet.build().getId() : null;
  }, arena);
}
MemorySegment ptrGestureTapDownCallbackFn(Consumer<TapDownDetails> jFn) {
  return GestureTapDownCallbackFFI.allocate((details) -> {
    jFn.accept(new TapDownDetails(details));
  }, arena);
}
MemorySegment ptrGestureTapUpCallbackFn(Consumer<TapUpDetails> jFn) {
  return GestureTapUpCallbackFFI.allocate((details) -> {
    jFn.accept(new TapUpDetails(details));
  }, arena);
}
MemorySegment ptrGestureTapMoveCallbackFn(Consumer<TapMoveDetails> jFn) {
  return GestureTapMoveCallbackFFI.allocate((details) -> {
    jFn.accept(new TapMoveDetails(details));
  }, arena);
}
MemorySegment ptrGestureTapCancelCallbackFn(Runnable jFn) {
  return GestureTapCancelCallbackFFI.allocate(() -> {
    jFn.run();
  }, arena);
}
MemorySegment ptrGestureLongPressDownCallbackFn(Consumer<LongPressDownDetails> jFn) {
  return GestureLongPressDownCallbackFFI.allocate((details) -> {
    jFn.accept(new LongPressDownDetails(details));
  }, arena);
}
MemorySegment ptrGestureLongPressCancelCallbackFn(Runnable jFn) {
  return GestureLongPressCancelCallbackFFI.allocate(() -> {
    jFn.run();
  }, arena);
}
MemorySegment ptrGestureLongPressCallbackFn(Runnable jFn) {
  return GestureLongPressCallbackFFI.allocate(() -> {
    jFn.run();
  }, arena);
}
MemorySegment ptrGestureLongPressStartCallbackFn(Consumer<LongPressStartDetails> jFn) {
  return GestureLongPressStartCallbackFFI.allocate((details) -> {
    jFn.accept(new LongPressStartDetails(details));
  }, arena);
}
MemorySegment ptrGestureLongPressMoveUpdateCallbackFn(Consumer<LongPressMoveUpdateDetails> jFn) {
  return GestureLongPressMoveUpdateCallbackFFI.allocate((details) -> {
    jFn.accept(new LongPressMoveUpdateDetails(details));
  }, arena);
}
MemorySegment ptrGestureLongPressUpCallbackFn(Runnable jFn) {
  return GestureLongPressUpCallbackFFI.allocate(() -> {
    jFn.run();
  }, arena);
}
MemorySegment ptrGestureLongPressEndCallbackFn(Consumer<LongPressEndDetails> jFn) {
  return GestureLongPressEndCallbackFFI.allocate((details) -> {
    jFn.accept(new LongPressEndDetails(details));
  }, arena);
}
MemorySegment ptrGestureDragDownCallbackFn(Consumer<DragDownDetails> jFn) {
  return GestureDragDownCallbackFFI.allocate((details) -> {
    jFn.accept(new DragDownDetails(details));
  }, arena);
}
MemorySegment ptrGestureDragStartCallbackFn(Consumer<DragStartDetails> jFn) {
  return GestureDragStartCallbackFFI.allocate((details) -> {
    jFn.accept(new DragStartDetails(details));
  }, arena);
}
MemorySegment ptrGestureDragUpdateCallbackFn(Consumer<DragUpdateDetails> jFn) {
  return GestureDragUpdateCallbackFFI.allocate((details) -> {
    jFn.accept(new DragUpdateDetails(details));
  }, arena);
}
MemorySegment ptrGestureDragEndCallbackFn(Consumer<DragEndDetails> jFn) {
  return GestureDragEndCallbackFFI.allocate((details) -> {
    jFn.accept(new DragEndDetails(details));
  }, arena);
}
MemorySegment ptrGestureDragCancelCallbackFn(Runnable jFn) {
  return GestureDragCancelCallbackFFI.allocate(() -> {
    jFn.run();
  }, arena);
}
MemorySegment ptrGestureForcePressStartCallbackFn(Consumer<ForcePressDetails> jFn) {
  return GestureForcePressStartCallbackFFI.allocate((details) -> {
    jFn.accept(new ForcePressDetails(details));
  }, arena);
}
MemorySegment ptrGestureForcePressPeakCallbackFn(Consumer<ForcePressDetails> jFn) {
  return GestureForcePressPeakCallbackFFI.allocate((details) -> {
    jFn.accept(new ForcePressDetails(details));
  }, arena);
}
MemorySegment ptrGestureForcePressUpdateCallbackFn(Consumer<ForcePressDetails> jFn) {
  return GestureForcePressUpdateCallbackFFI.allocate((details) -> {
    jFn.accept(new ForcePressDetails(details));
  }, arena);
}
MemorySegment ptrGestureForcePressEndCallbackFn(Consumer<ForcePressDetails> jFn) {
  return GestureForcePressEndCallbackFFI.allocate((details) -> {
    jFn.accept(new ForcePressDetails(details));
  }, arena);
}
<T> MemorySegment ptrValueChangedForBoolOptFn(Consumer<Boolean> jFn) {
  return ValueChangedForBoolOptFFI.allocate((value) -> {
    jFn.accept(memToBool(value));
  }, arena);
}
<T> MemorySegment ptrValueChangedForDoubleFn(Consumer<Double> jFn) {
  return ValueChangedForDoubleFFI.allocate((value) -> {
    jFn.accept(value);
  }, arena);
}
MemorySegment ptrSemanticFormatterCallbackFn(Function<Double, String> jFn) {
  return SemanticFormatterCallbackFFI.allocate((value) -> {
    final var jFnRet = jFn.apply(value);
    return arena.allocateFrom(jFnRet);
  }, arena);
}
MemorySegment ptrTooltipTriggeredCallbackFn(Runnable jFn) {
  return TooltipTriggeredCallbackFFI.allocate(() -> {
    jFn.run();
  }, arena);
}
<T> MemorySegment ptrTabValueChangedForBoolFn(BiConsumer<Boolean, Integer> jFn) {
  return TabValueChangedForBoolFFI.allocate((value, index) -> {
    jFn.accept(intToBool(value), index);
  }, arena);
}
<T> MemorySegment ptrValueSetterForBoolOptFn(Consumer<Boolean> jFn) {
  return ValueSetterForBoolOptFFI.allocate((value) -> {
    jFn.accept(memToBool(value));
  }, arena);
}
MemorySegment ptrDataColumnSortCallbackFn(BiConsumer<Integer, Boolean> jFn) {
  return DataColumnSortCallbackFFI.allocate((columnIndex, ascending) -> {
    jFn.accept(columnIndex, intToBool(ascending));
  }, arena);
}
<T> MemorySegment ptrValueChangedForTOptFn(Consumer<NativeObj> jFn) {
  return ValueChangedForTOptFFI.allocate((value) -> {
    jFn.accept((NativeObj) new NativeObj.Base() {{ this.id = value.reinterpret(StarterBridge.C_INT.byteSize()).get(StarterBridge.C_INT, 0); }});
  }, arena);
}
MemorySegment ptrExpansionPanelHeaderBuilderFn(BiFunction<BuildContext, Boolean, Widget> jFn) {
  return ExpansionPanelHeaderBuilderFFI.allocate((context, isExpanded) -> {
    final var jFnRet = jFn.apply(new BuildContext() { public int getId() { return context; } }, intToBool(isExpanded));
    return jFnRet.build().getId();
  }, arena);
}
MemorySegment ptrExpansionPanelCallbackFn(BiConsumer<Integer, Boolean> jFn) {
  return ExpansionPanelCallbackFFI.allocate((panelIndex, isExpanded) -> {
    jFn.accept(panelIndex, intToBool(isExpanded));
  }, arena);
}
<T> MemorySegment ptrPopupMenuItemBuilderForTFn(Function<BuildContext, List<PopupMenuEntry>> jFn) {
  return PopupMenuItemBuilderForTFFI.allocate((context) -> {
    final var jFnRet = jFn.apply(new BuildContext() { public int getId() { return context; } });
    return ptrList(jFnRet);
  }, arena);
}
<T> MemorySegment ptrPopupMenuItemSelectedForTFn(Consumer<NativeObj> jFn) {
  return PopupMenuItemSelectedForTFFI.allocate((value) -> {
    jFn.accept((NativeObj) new NativeObj.Base() {{ this.id = value; }});
  }, arena);
}
MemorySegment ptrPopupMenuCanceledFn(Runnable jFn) {
  return PopupMenuCanceledFFI.allocate(() -> {
    jFn.run();
  }, arena);
}
<T> MemorySegment ptrValueChangedForDateTimeFn(Consumer<DateTime> jFn) {
  return ValueChangedForDateTimeFFI.allocate((value) -> {
    jFn.accept(new DateTime(value));
  }, arena);
}
<T> MemorySegment ptrValueChangedForDurationFn(Consumer<Duration> jFn) {
  return ValueChangedForDurationFFI.allocate((value) -> {
    jFn.accept(new Duration(value));
  }, arena);
}
MemorySegment ptrSelectionOverlayBuilderFn(TriFunction<BuildContext, Integer, Integer, Widget> jFn) {
  return SelectionOverlayBuilderFFI.allocate((context, columnCount, selectedIndex) -> {
    final var jFnRet = jFn.apply(new BuildContext() { public int getId() { return context; } }, columnCount, selectedIndex);
    return jFnRet != null ? jFnRet.build().getId() : null;
  }, arena);
}
MemorySegment ptrCupertinoContextMenuBuilderFn(BiFunction<BuildContext, Animation, Widget> jFn) {
  return CupertinoContextMenuBuilderFFI.allocate((context, animation) -> {
    final var jFnRet = jFn.apply(new BuildContext() { public int getId() { return context; } }, new Animation() { public int getId() { return animation; } });
    return jFnRet.build().getId();
  }, arena);
}
<T extends StatefulWidget> MemorySegment ptrVoidCallbackDartObjFn(Consumer<NativeObj> jFn) {
  return VoidCallbackDartObjFFI.allocate((t) -> {
    jFn.accept((NativeObj) new NativeObj.Base() {{ this.id = t; }});
  }, arena);
}
MemorySegment ptrDartObjCallbackDartObjFn(Function<BuildContext, Widget> jFn) {
  return DartObjCallbackDartObjFFI.allocate((b) -> {
    final var jFnRet = jFn.apply(new BuildContext() { public int getId() { return b; } });
    return jFnRet.build().getId();
  }, arena);
}
MemorySegment ptrDartObjCallbackFn(Supplier<State> jFn) {
  return DartObjCallbackFFI.allocate(() -> {
    final var jFnRet = jFn.get();
    return jFnRet.build().getId();
  }, arena);
}
}
