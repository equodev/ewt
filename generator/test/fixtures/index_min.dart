// Minimal generation-index fixture used by generation_test.dart. Keeps the
// analyzer setup fast and hermetic (no dependency on the gitignored
// subwidgets.dart / generation_index.dart tree).
//
// The first entry is treated as `widgetElement` by Types(); the rest are the
// widgets to be generated.
import 'package:flutter/widgets.dart' as w;
import 'package:flutter/material.dart' as m;

w.Widget? widget;
w.Text? text;
w.InlineSpan? inlineSpan;
w.TextSpan? textSpan;
w.Center? center;
w.Icon? icon;
w.Padding? padding;
w.Column? column;
w.GestureDetector? gestureDetector;
m.Icons? icons;
w.EdgeInsetsGeometry? edgeInsetsGeometry;
w.IconData? iconData;
