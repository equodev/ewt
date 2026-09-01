import 'dart:ffi';

import 'package:flutter/material.dart';

import 'package:widgets/widgets.dart' as widgets;
import 'package:widgets/factories.dart' as widget_factories;
import 'package:widgets/widgets_bindings_generated.dart';
import 'package:widgets/engine_hooks.dart';

Pointer<WidgetFactories> factories = widget_factories.factories;

void main() {
  // Ensure the binding is initialised before we install persistent callbacks.
  WidgetsFlutterBinding.ensureInitialized();

  print('dart main before runApp');

  // Build the initial widget tree by calling into Java.
  Widget buildRoot() {
    final widgetId = widgets.callToBuildWidgetTree(factories);
    return widget_factories.getWidget(widgetId) as Widget;
  }

  final rootHolder = ValueNotifier<Widget>(buildRoot());

  attachEngineHooks(
    rootHolder: rootHolder,
    rebuildRoot: buildRoot,
  );

  runApp(ValueListenableBuilder<Widget>(
    valueListenable: rootHolder,
    builder: (_, w, __) => w,
  ));

  print('dart main after runApp');
}
