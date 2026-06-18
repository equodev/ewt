//
//  Starter.swift
//  Starter
//
//  Created by Guillermo Zunino on 04/03/2025.
//

import Darwin
import Foundation
import Cocoa
import FlutterMacOS

// Returns the directory containing libStarter.dylib using dladdr self-location.
// #dsohandle is a Swift compiler intrinsic that yields the load address of the
// current dynamic library — guaranteed to be an address within libStarter.dylib.
private func starterDylibDir() -> String? {
    var info = Dl_info()
    guard dladdr(#dsohandle, &info) != 0, let fname = info.dli_fname else { return nil }
    return URL(fileURLWithPath: String(cString: fname))
        .deletingLastPathComponent()
        .path
}

// Resolves the path to App.framework, which FlutterDartProject uses to locate
// flutter_assets/, icudtl.dat and the AOT snapshot.
//
// Resolution order:
//  1. EWT_HOME env var — development builds with a local Flutter checkout.
//  2. Self-locate relative to libStarter.dylib — JAR-embedded mode.
//     Expected layout: native/macos-arm64/lib/libStarter.dylib
//                      native/macos-arm64/data/App.framework
//  3. Fallback to standard .app bundle Frameworks directory.
private func resolveAppFrameworkPath() -> String {
    if let ewtHome = ProcessInfo.processInfo.environment["EWT_HOME"] {
        return "\(ewtHome)/widgets/example/build/macos/Build/Products/Release"
             + "/widgets_example.app/Contents/Frameworks/App.framework"
    }
    if let libDir = starterDylibDir() {
        return URL(fileURLWithPath: libDir)
            .deletingLastPathComponent()        // lib/ -> macos-arm64/
            .appendingPathComponent("data")
            .appendingPathComponent("App.framework")
            .path
    }
    return Bundle.main.bundlePath + "/Contents/Frameworks/App.framework"
}

// EWTAppDelegate defers all Flutter setup to applicationDidFinishLaunching so
// that Metal is fully available when FlutterViewController is initialized.
// Creating FlutterViewController before NSApplication.run() causes
// "Could not acquire Metal device" because the GPU context isn't ready yet.
class EWTAppDelegate: NSObject, NSApplicationDelegate, NSWindowDelegate {
    private var flutterViewController: FlutterViewController?
    private var window: NSWindow?

    func applicationDidFinishLaunching(_ notification: Notification) {
        // chdir to the lib dir so Dart's DynamicLibrary.open("widgets.framework/widgets")
        // resolves relative to the JAR extraction directory rather than the process CWD.
        if let libDir = starterDylibDir() {
            FileManager.default.changeCurrentDirectoryPath(libDir)
        }
        let appFramework = resolveAppFrameworkPath()
        print("EWTAppDelegate: App.framework at \(appFramework)")

        let project = FlutterDartProject(precompiledDartBundle: Bundle(path: appFramework))
        flutterViewController = FlutterViewController(project: project)

        let contentSize = NSSize(width: 800, height: 600)
        let win = NSWindow(
            contentRect: NSRect(origin: .zero, size: contentSize),
            styleMask: [.titled, .closable, .miniaturizable, .resizable],
            backing: .buffered,
            defer: false)
        win.delegate = self
        win.contentViewController = flutterViewController
        // contentViewController uses preferredContentSize (zero before first Flutter frame)
        // to resize the window, making it invisible. Restore the intended size explicitly.
        win.setContentSize(contentSize)
        win.center()
        win.makeKeyAndOrderFront(nil)
        NSApplication.shared.activate(ignoringOtherApps: true)
        self.window = win

        RegisterGeneratedPlugins(registry: flutterViewController!)
    }

    func windowWillClose(_ notification: Notification) {
        NSApplication.shared.stop(nil)
    }
}

@MainActor
class FlutterBridgeController {
    static let shared = FlutterBridgeController()
    private var appDelegate: EWTAppDelegate?

    private init() {}

    func initialize() {
        if !Thread.isMainThread {
            DispatchQueue.main.sync { self.initialize() }
            return
        }

        let app = NSApplication.shared
        app.setActivationPolicy(.regular)
        let delegate = EWTAppDelegate()
        app.delegate = delegate
        self.appDelegate = delegate
        app.activate(ignoringOtherApps: true)
        app.run()   // blocks; Flutter init happens in applicationDidFinishLaunching
    }
}

@_silgen_name("setBuildWidgetTree")
func c_setBuildWidgetTree(_ fn: @convention(c) (UnsafePointer<WidgetFactories>?) -> Int32) -> Void

@MainActor @_cdecl("startApp")
public func StartApp(buildWidgetTree: @convention(c) (UnsafePointer<WidgetFactories>?) -> Int32) -> Int32 {
    c_setBuildWidgetTree(buildWidgetTree)
    FlutterBridgeController.shared.initialize()
    return 0
}
