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

    static class FadePageState extends SubAnimatedState<FadePage> {
        private AnimationController ctrl;

        @Override
        public void initState() {
            super.initState();
            ctrl = animationController(Duration().milliseconds(500));
        }

        @Override
        public Widget build(BuildContext context) {
            return Scaffold()
                    .appBar(AppBar().title(Text("Fade Demo")))
                    .body(Center().child(body()));
        }

        private Widget body() {
            return Column()
                    .mainAxisAlignment(MainAxisAlignment.center)
                    .children(List.of(
                            fadingText(),
                            button("Mostrar", ctrl::forward),
                            button("Ocultar", ctrl::reverse)
                    ));
        }

        private Widget fadingText() {
            return FadeTransition(ctrl).child(Text("Hola, EWT"));
        }

        private Widget button(String label, Runnable action) {
            return ElevatedButton(action).child(Text(label));
        }
    }
}
