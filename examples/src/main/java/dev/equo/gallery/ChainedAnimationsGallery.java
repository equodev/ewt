package dev.equo.gallery;

import java.util.List;

import dev.equo.ewt.*;

import static dev.equo.ewt.EWT.*;

/**
 * Sequences AnimationController phases using the {@code Future<NativeObj>}
 * returned by each imperative call. Every step in the chain fires only after
 * the previous one completes — the same Java code runs on desktop (Flutter
 * engine, native FFI) and on web (Evolve transport with the async-callback
 * broker introduced by issue #60).
 *
 * <p>The controller drives two transitions bound through {@code CurvedAnimation}
 * — an {@code easeInOut} fade and an {@code elasticOut} scale — so the value
 * ticking from 0 → 1 shows up as a preview cube fading in AND bouncing to
 * size, and 1 → 0 as the reverse. The {@code setState} at each step updates
 * the status line so the sequential nature is legible.
 *
 * <p>Run on desktop:
 * <pre>
 *   ./gradlew :examples:run -PuseLocal=true \
 *     -PmainClass=dev.equo.gallery.ChainedAnimationsGallery
 * </pre>
 *
 * <p>Run on web (Evolve):
 * <pre>
 *   (cd evolve-app && flutter build web --no-tree-shake-icons)
 *   ./gradlew :examples:runChainedAnimationsWeb -PuseLocal=true
 * </pre>
 */
public class ChainedAnimationsGallery {

  public static void main(String[] args) {
    App.runApp(MyApp::new);
  }

  static class MyApp extends SubStatelessWidget {
    @Override
    protected Widget build(BuildContext context) {
      return MaterialApp()
          .title("EWT — Chained Animations")
          .theme(ThemeData()
              .colorScheme(ColorScheme_fromSeed(Colors.indigo()))
              .useMaterial3(true))
          .home(new ChainPage());
    }
  }

  public static class ChainPage extends SubStatefulWidget {
    @Override
    protected State<ChainPage> createState() {
      return new ChainPageState();
    }
  }

  static class ChainPageState extends SubAnimatedState<ChainPage> {
    private AnimationController controller;

    private int runId = 0;
    private String currentStep = "idle — press Start";
    private boolean running = false;

    @Override
    public void initState() {
      super.initState();
      controller = animationController(Duration().milliseconds(600));
    }

    private CurvedAnimation curved(Curve curve) {
      return CurvedAnimation(controller, curve).build();
    }

    private void startChain() {
      if (running) return;
      advance("1/5 forward", true);

      controller.forward().then(v1 -> {
        advance("2/5 reverse", true);
        controller.reverse().then(v2 -> {
          advance("3/5 forward again", true);
          controller.forward().then(v3 -> {
            advance("4/5 fling back", true);
            controller.fling(-2.0).then(v4 -> {
              advance("5/5 reset", true);
              controller.reset();
              advance("done ✓ — press Start again", false);
            });
          });
        });
      });
    }

    private void advance(String step, boolean isRunning) {
      setState(() -> {
        currentStep = step;
        running = isRunning;
        if (isRunning && step.startsWith("1/5")) runId++;
      });
    }

    @Override
    public Widget build(BuildContext context) {
      return Scaffold()
          .appBar(AppBar()
              .backgroundColor(Theme.of(context).colorScheme().inversePrimary())
              .title(Text("Chained Animations (Future.then)")))
          .body(Center().child(Padding(EdgeInsets_all(24.0))
              .child(Column()
                  .mainAxisAlignment(MainAxisAlignment.center)
                  .children(List.of(

                      Text("Run #" + runId + "  ·  " + currentStep),
                      SizedBox().height(24.0),

                      // Fade + scale bound to the same controller through two
                      // different curves — one animateTo/fling call sequences
                      // both properties. Transitions rebuild themselves as the
                      // controller ticks, no setState required per frame.
                      FadeTransition(curved(Curves.easeInOut()))
                          .child(ScaleTransition(curved(Curves.elasticOut()))
                              .child(Container()
                                  .width(160.0).height(160.0)
                                  .decoration(BoxDecoration()
                                      .color(Colors.indigo())
                                      .borderRadius(BorderRadius_circular(20.0))))),

                      SizedBox().height(32.0),
                      FilledButton()
                          .onPressed(this::startChain)
                          .child(Text(running ? "Running…" : "Start chain"))
                  )))));
    }
  }
}
