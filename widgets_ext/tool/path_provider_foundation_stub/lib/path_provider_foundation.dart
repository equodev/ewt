// Pure-Dart stand-in for path_provider_foundation (macOS/iOS). See pubspec.yaml
// in this directory for the full rationale. In short: it registers itself as the
// PathProviderPlatform instance via `registerWith()` (invoked by the Dart plugin
// registrant Flutter generates from `dartPluginClass`), but ships NO native Swift
// plugin — so the macOS build links without CocoaPods/SPM. EwtMapView never calls
// path_provider at runtime, so the inherited UnimplementedError defaults from
// PathProviderPlatform are never reached.
import 'package:path_provider_platform_interface/path_provider_platform_interface.dart';

/// Dart-only implementation of [PathProviderPlatform] for macOS/iOS.
///
/// Intentionally implements nothing: it exists so the macOS/iOS registrant has a
/// Dart class to register instead of a native plugin. All path methods fall back
/// to [PathProviderPlatform]'s `UnimplementedError` defaults, which is safe because
/// nothing in the EWT tree calls path_provider on macOS/iOS.
class PathProviderFoundation extends PathProviderPlatform {
  /// Registers this class as the default [PathProviderPlatform] instance.
  ///
  /// Called automatically by Flutter's generated Dart plugin registrant because
  /// the pubspec declares `dartPluginClass: PathProviderFoundation`.
  static void registerWith() {
    PathProviderPlatform.instance = PathProviderFoundation();
  }
}
