package dev.equo;

import java.util.List;
import dev.equo.ewt.*;
import static dev.equo.ewt.EWT.*;

public class FadeDemo {

    public static void main(String[] args) {
        App.runApp(MyApp::new);
    }

    static class MyApp extends SubStatelessWidget {
        @Override
        protected Widget build(BuildContext context) {
            return MaterialApp()
                    .title("EWT Fade Demo")
                    .home(new FadePage());
        }
    }

    static class FadePage extends SubStatefulWidget {
        @Override
        protected State<FadePage> createState() {
            return new FadePageState();
        }
    }

    static class FadePageState extends SubState<FadePage> {
        AnimationController ctrl;

        @Override
        public Widget build(BuildContext context) {
            return Scaffold()
                    .appBar(AppBar().title(Text("Fade Demo")))
                    .body(Center().child(
                            AnimatedWrapper(
                                    ctrlId -> {
                                        ctrl = AnimationController.byId(ctrlId);
                                        AnimatedWrapper.setDuration(ctrl, Duration().milliseconds(500));
                                    },
                                    () -> Column()
                                            .mainAxisAlignment(MainAxisAlignment.center)
                                            .children(List.of(
                                                    FadeTransition(ctrl).child(Text("Hola, EWT")),
                                                    ElevatedButton(() -> AnimatedWrapper.forward(ctrl))
                                                            .child(Text("Mostrar")),
                                                    ElevatedButton(() -> AnimatedWrapper.reverse(ctrl))
                                                            .child(Text("Ocultar"))
                                            ))
                                            .build()
                            )
                    ));
        }
    }
}
