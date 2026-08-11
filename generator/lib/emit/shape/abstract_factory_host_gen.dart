part of '../../gen.dart';

/// Emitter for abstract Flutter classes that expose public `factory`
/// constructors that we want to expose as static Java factories via
/// Immutables' `@Builder.Factory` — currently `ImageFilter` (`.blur`,
/// `.matrix`, …) and `ColorFilter` (`.mode`, `.matrix`, …).
///
/// Two conditions must be true for a class to land here (checked in
/// [Types.getGen]):
///
///   1. `dartClass.isAbstract` — obvious.
///   2. Has at least one public factory constructor.
///   3. **Not** emitted as a Java interface (interfaces can't hold
///      `@Builder.Factory` static methods that reference `factories`).
///   4. **No** concrete widget in the set inherits from it (otherwise
///      emitting factories on both would produce Java-illegal covariant
///      static hiding — the case for `BorderRadiusGeometry` /
///      `BorderRadius`, `EdgeInsetsGeometry` / `EdgeInsets`, etc.).
///
/// Under those rules, adding a new abstract-factory Flutter class to
/// `generation_index.dart` routes it here automatically — no per-class
/// subclass needed. The two classes `ImageFilter` / `ColorFilter`
/// previously had one hardcoded generator each; now they share this one.
class AbstractFactoryHostGen extends WidgetGen {
  AbstractFactoryHostGen(super.types, super.dartClass);

  @override
  bool get isAbstractFactoryHost => true;
}
