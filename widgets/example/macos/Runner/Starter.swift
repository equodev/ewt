//
//  Starter.swift
//  Starter
//
//  Created by Guillermo Zunino on 04/03/2025.
//

import Foundation
import Cocoa
import FlutterMacOS

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
    private var window: NSWindow? // Keep for standalone window case if needed
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
        let project = FlutterDartProject.init(precompiledDartBundle: Bundle(path: "/Users/guillez/ws/ewt/widgets/example/build/macos/Build/Products/Release/widgets_example.app/Contents/Frameworks/App.framework"))
        // Create Flutter view controller
        flutterViewController = FlutterViewController.init(project: project)
        print("FlutterBridgeController.initialize 2")

        // Create a new window if no parent (fallback case)
        let window = NSWindow(
            contentRect: NSRect(x: 0, y: 0, width: 800, height: 600),
            styleMask: [.titled, .closable, .miniaturizable, .resizable],
            backing: .buffered,
            defer: false)
        let windowDelegate = WindowDelegate()
        window.delegate = windowDelegate // Set the delegate

        self.delegate!.mainFlutterWindow = window;

        let windowFrame = window.frame
        window.contentViewController = flutterViewController
//        flutterViewController!.engine.run(withEntrypoint: "main")
        window.setFrame(windowFrame, display: true)
        window.center()
        window.makeKeyAndOrderFront(nil)
        self.window = window
        RegisterGeneratedPlugins(registry: flutterViewController!)
//        window.awakeFromNib()

        print("FlutterBridgeController.initialize 3")
        app.run() // This starts the event loop and blocks until app terminates
        print("FlutterBridgeController.initialize 4")
    }

}

//func setBuildWidgetTree(_ fn: @convention(c) () -> Int)

@MainActor @_cdecl("startApp")
public func StartApp(buildWidgetTree: @convention(c) (WidgetFactories) -> Int32) -> Int32 {
    print("swift StartApp")
    setBuildWidgetTree(buildWidgetTree)
    FlutterBridgeController.shared.initialize()
    return 0
}
