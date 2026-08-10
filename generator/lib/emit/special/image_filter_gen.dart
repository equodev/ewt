part of '../../gen.dart';

/// Emitter for `ImageFilter` — an abstract class whose public
/// `factory` constructors (`ImageFilter.blur`, `.matrix`, …) should be
/// exposed as static Java factories via Immutables. See [isAbstractFactoryHost].
class ImageFilterGen extends WidgetGen {
  ImageFilterGen(super.types, super.dartClass);

  @override
  bool get isAbstractFactoryHost => true;
}
