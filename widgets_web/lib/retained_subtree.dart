// A subtree built once and handed back unchanged on every later build, until the owner says
// the content changed.
//
// An EWT region sits inside Evolve's widget tree, and Evolve rebuilds that tree freely: a
// bounds-only diff on a control, a Sash drag relaying out a workbench, any ancestor Composite
// re-running build(). None of that changes what the EWT subtree shows, but a region whose
// build() reconstructed the subtree every time paid the whole construction on each of those
// rebuilds — the full Java builder over FFM (one native call per widget), or a full decode of
// the retained node map over comm. With N regions and a drag at 60 events/s, that was the
// resize slowness.
//
// Flutter skips a subtree whose Widget instance is identical to the one it already holds
// (Element.updateChild), so returning the same instance is all it takes to keep the subtree
// out of a parent's rebuild. The content only changes when the Java side says so, and the
// owner expresses that by bumping [generation].
import 'package:flutter/widgets.dart';

/// Builds its content once per [generation] and returns the identical Widget on every build
/// in between, so a parent rebuild never reaches into the subtree.
///
/// The content is rebuilt when:
/// - [generation] changes (the owner learned from Java that the content changed);
/// - an inherited dependency the build read through its context changes (a Theme swap), via
///   [State.didChangeDependencies];
/// - the app reassembles (hot reload), via [State.reassemble].
///
/// Give it a [key] that identifies what is being built (the transport, say): a different key
/// discards this State and starts over.
class EwtRetainedSubtree extends StatefulWidget {
  final int generation;
  final WidgetBuilder builder;

  const EwtRetainedSubtree({
    super.key,
    required this.generation,
    required this.builder,
  });

  @override
  State<EwtRetainedSubtree> createState() => _EwtRetainedSubtreeState();
}

class _EwtRetainedSubtreeState extends State<EwtRetainedSubtree> {
  Widget? _built;

  @override
  void didUpdateWidget(EwtRetainedSubtree oldWidget) {
    super.didUpdateWidget(oldWidget);
    if (oldWidget.generation != widget.generation) _built = null;
  }

  @override
  void didChangeDependencies() {
    super.didChangeDependencies();
    _built = null;
  }

  @override
  void reassemble() {
    super.reassemble();
    _built = null;
  }

  @override
  Widget build(BuildContext context) => _built ??= widget.builder(context);
}
