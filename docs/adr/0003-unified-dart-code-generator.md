# Single Dart generator emits Java builders, C headers, and Dart factories simultaneously

EWT needs three coordinated artifacts per widget: Java builder classes (user API), C function declarations (native bridge), and Dart factory implementations (Flutter side). We chose a single Dart generator (`generator/bin/generator.dart`) that emits all three in one pass from a curated index (`generation_index.dart`) rather than maintaining three separate toolchains or hand-writing any of the three. The generator uses the Dart analyzer to introspect real Flutter widget constructors, guaranteeing the emitted Java API stays in sync with the actual Flutter widget signatures. Any of the three tools running independently would drift out of sync the moment a Flutter widget's constructor changes.

- **Status**: accepted
- **Date**: 2024-01-01
- **Deciders**: Equo EWT team

## Considered Options

| Option | Outcome |
|--------|---------|
| Hand-written Java builders + C headers | Rejected — ~175 widgets × 3 artifacts = unsustainable maintenance surface |
| Separate generator per output language | Rejected — three sources of truth diverge when Flutter updates |
| Single Dart generator for all three | **Chosen** — one run keeps Java, C, and Dart in lockstep; Dart analyzer provides ground-truth widget signatures |

## Consequences

- Adding a widget means one line in `generation_index.dart` + `./gradlew :generator:generator`; the rest is automatic.
- The pregeneration cache (`generator/build/pregeneration_index.dart.ts`) must be deleted when `generation_index.dart` changes, or `subwidgets.dart` won't regenerate.
- Widgets that use unsupported parameter types (private enums, required `Key`) must be commented out in the index.
