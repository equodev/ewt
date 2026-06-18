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

class WindowDelegate: NSObject, NSWindowDelegate {
    func windowWillClose(_ notification: Notification) {
        NSApplication.shared.stop(nil)
    }
}

// Class to hold our Flutter instances
@MainActor
class FlutterBridgeController {
    static let shared = FlutterBridgeController()

    private var flutterViewController: FlutterViewController?
    private var window: NSWindow?
    private var delegate: AppDelegate?

    private init() {
        print("FlutterBridgeController.init")
    }

    func initialize() {
        print("FlutterBridgeController.initialize")
        // Ensure we're on the main thread
        if !Thread.isMainThread {
            print("FlutterBridgeController.initialize NOT MAIN THREAD")
            DispatchQueue.main.sync {
                self.initialize()
            }
            return
        }

        self.delegate = AppDelegate()
        let app = NSApplication.shared
        app.setActivationPolicy(.regular)
        app.delegate = self.delegate
        app.activate(ignoringOtherApps: true)
        let appFramework = resolveAppFrameworkPath()
        print("FlutterBridgeController: App.framework at \(appFramework)")
        let project = FlutterDartProject(precompiledDartBundle: Bundle(path: appFramework))
        // Create Flutter view controller
        flutterViewController = FlutterViewController(project: project)
        print("FlutterBridgeController.initialize 2")

        // Create a new window if no parent (fallback case)
        let window = NSWindow(
            contentRect: NSRect(x: 0, y: 0, width: 800, height: 600),
            styleMask: [.titled, .closable, .miniaturizable, .resizable],
            backing: .buffered,
            defer: false)
        let windowDelegate = WindowDelegate()
        window.delegate = windowDelegate // Set the delegate

        self.delegate!.mainFlutterWindow = window

        let windowFrame = window.frame
        window.contentViewController = flutterViewController
        window.setFrame(windowFrame, display: true)
        window.center()
        window.makeKeyAndOrderFront(nil)
        self.window = window
        RegisterGeneratedPlugins(registry: flutterViewController!)

        print("FlutterBridgeController.initialize 3")
        app.run()
        print("FlutterBridgeController.initialize 4")
    }
}

@_silgen_name("setBuildWidgetTree")
func c_setBuildWidgetTree(_ fn: @convention(c) (UnsafePointer<WidgetFactories>?) -> Int32) -> Void

@MainActor @_cdecl("startApp")
public func StartApp(buildWidgetTree: @convention(c) (UnsafePointer<WidgetFactories>?) -> Int32) -> Int32 {
    print("swift StartApp")
    c_setBuildWidgetTree(buildWidgetTree)
    FlutterBridgeController.shared.initialize()
    return 0
}