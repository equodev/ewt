# EWT uses Evolve's comm as its transport when running in web mode

EWT needs to render widgets in a browser when embedded inside an Evolve web deployment. FFM (the native C bridge used on desktop) is not available in a browser environment, so a different transport is required. We chose to reuse Evolve's existing comm infrastructure — EWT serializes its widget tree as `VEwt*` JSON and sends it over the same WebSocket that Evolve uses — rather than building a separate web transport for EWT.

The transport is selected at runtime: EWT inspects a property that Evolve sets to indicate web mode. If the property is present, EWT attaches to Evolve's comm; otherwise (desktop, standalone, or EWT+Evolve desktop), it uses FFM. This means the same EWT user code runs unmodified regardless of the target platform — only the backend transport changes.

- **Status**: accepted
- **Date**: 2026-01-01
- **Deciders**: Equo EWT team

## Considered Options

| Option | Outcome |
|--------|---------|
| Dedicated EWT web transport (separate WebSocket or HTTP) | Rejected — duplicates Evolve's existing comm infrastructure; requires additional server-side routing |
| WebAssembly FFI | Rejected — not mature enough; would require porting the entire C bridge to WASM |
| Reuse Evolve's comm (WebSocket + `VEwt*` JSON) | **Chosen** — zero new infrastructure; Evolve already has a working web comm pipeline; EWT widget serialization can be generated alongside the existing Java builders |

## Consequences

- On desktop (EWT standalone or EWT+Evolve desktop), FFM is used — fast, no serialization overhead. See [ADR-0001](0001-ffm-over-jni.md) and [ADR-0007](0007-single-engine-dual-transports.md).
- On web (EWT+Evolve web), EWT serializes widget trees as `VEwt*` JSON over Evolve's WebSocket comm.
- The transport selection is runtime (property detection), not compile-time — one binary, one deployment, two modes.
- The EWT generator must emit `VEwt*` serialization code alongside the existing Java builders and C headers; this is an additional output of the generation pipeline (see [ADR-0003](0003-unified-dart-code-generator.md)).
- EWT's Dart widget layer is reused as-is on both transports — only the Java-side encoding and the Dart-side decoding differ between FFM and comm.
