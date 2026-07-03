#
# To learn more about a Podspec see http://guides.cocoapods.org/syntax/podspec.html.
# Run `pod lib lint widgets.podspec` to validate before publishing.
#
# NOTE: This podspec exists ALONGSIDE macos/widgets/Package.swift to make the
# plugin dual-support (Swift Package Manager + CocoaPods), matching the layout
# of first-party FFI plugins (e.g. url_launcher_macos). It does NOT force
# CocoaPods: when SPM is enabled and the Runner is SPM-migrated, macOS builds
# via SPM and `pod install` never runs. Its purpose is compatibility: without a
# podspec, the Flutter tool classifies the plugin as "Swift Package Manager
# only" and refuses it on hosts that cannot use SPM (e.g. a Linux host building
# the Linux target of an app whose macos/ runner directory exists), aborting the
# build even though the macOS plugin is never compiled there.
#
Pod::Spec.new do |s|
  s.name             = 'widgets'
  s.version          = '0.0.1'
  s.summary          = 'EWT native layer: a Flutter FFI plugin exposing the Flutter engine to Java.'
  s.description      = <<-DESC
EWT native layer: a Flutter FFI plugin exposing the Flutter engine to Java.
                       DESC
  s.homepage         = 'http://example.com'
  s.license          = { :file => '../LICENSE' }
  s.author           = { 'Equo' => 'info@equo.dev' }

  # This ensures the shared C sources are included in the native builds of apps
  # using this FFI plugin. Podspec does not support relative paths, so Classes/
  # contains a forwarder C file that relatively imports ../src/* so the C sources
  # can be shared among all target platforms.
  s.source           = { :path => '.' }
  s.source_files = 'Classes/**/*'

  s.dependency 'FlutterMacOS'

  s.platform = :osx, '10.11'
  s.pod_target_xcconfig = { 'DEFINES_MODULE' => 'YES' }
  s.swift_version = '5.0'
end
