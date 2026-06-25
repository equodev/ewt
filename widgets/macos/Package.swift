// swift-tools-version: 5.9
import PackageDescription

let package = Package(
    name: "widgets",
    platforms: [.macOS("10.15")],
    products: [
        .library(name: "widgets", type: .dynamic, targets: ["widgets"])
    ],
    targets: [
        .target(
            name: "widgets",
            path: "Classes",
            sources: ["widgets.c"]
        )
    ]
)
