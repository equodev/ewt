package dev.equo;

import static dev.equo.ewt.EWT.*;
import dev.equo.ewt.*;
import java.util.List;

public class Temp {
public static void main(String[] args) {
App.runApp(() -> new MyAppT());
}

}
class MyAppT extends SubStatelessWidget {
public MyAppT() {
}
@Override protected  Widget build(BuildContext context) {
return MaterialApp()
.title("Text Field with Button")
.theme(ThemeData()
.useMaterial3(true)
.colorScheme(ColorScheme_fromSeed(Colors.blue())))
.home(new HomeScreen());
}
}
class HomeScreen extends SubStatefulWidget {
public HomeScreen() {
}
@Override protected  State<HomeScreen> createState() {
 return new HomeScreenState();
}
}
class HomeScreenState extends SubState<HomeScreen> {
private final TextEditingController _textController = TextEditingController();
@Override protected  void dispose() {
_textController.dispose();
super.dispose();
}
private void _handleSubmit() {
final var text = _textController.text();
if (text.isNotEmpty()) {
ScaffoldMessenger.of(context()).showSnackBar(SnackBar(Text("Submitted: "+text+"")));
_textController.clear();
}

}
@Override protected  Widget build(BuildContext context) {
return Scaffold()
.appBar(AppBar()
.title(Text("Text Field with Button")))
.body(Padding(EdgeInsets_all(16.0))
.child(Row()
.children(List.of(Expanded()
.child(TextField()
.controller(_textController)
.decoration(InputDecoration()
.hintText("Enter text")
.border(OutlineInputBorder()))
.onSubmitted((_0) -> _handleSubmit())), SizedBox()
.width(12), FilledButton(this::_handleSubmit)
.child(Text("Submit"))))));
}
}
