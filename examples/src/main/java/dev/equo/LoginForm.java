package dev.equo;

import dev.equo.ewt.*;
import static dev.equo.ewt.EWT.*;
import java.util.List;

public class LoginForm {

  public static void main(String[] args) {
    App.runApp(LoginFormApp::new);
  }

  static class LoginFormApp extends SubStatelessWidget {
    @Override
    protected Widget build(BuildContext context) {
      return MaterialApp()
          .title("Login Form")
          .theme(ThemeData()
              .colorScheme(ColorScheme_fromSeed(Colors.deepPurple()))
              .useMaterial3(true))
          .home(new LoginPage());
    }
  }

  static class LoginPage extends SubStatefulWidget {
    @Override
    protected LoginPageState createState() {
      return new LoginPageState();
    }
  }

  static class LoginPageState extends SubState<LoginPage> {
    private String _email = "";
    private String _password = "";

    private void _login() {
      if (_email.isEmpty() || _password.isEmpty()) {
        showDialog(context(), ctx ->
            AlertDialog()
                .title(Text("Missing fields"))
                .content(Text("Please fill in both email and password."))
                .actions(List.of(
                    TextButton(() -> Navigator.pop(ctx)).child(Text("OK"))
                ))
        );
      } else {
        showDialog(context(), ctx ->
            AlertDialog()
                .title(Text("Welcome!"))
                .content(Text("Logged in as " + _email))
                .actions(List.of(
                    TextButton(() -> Navigator.pop(ctx)).child(Text("OK"))
                ))
        );
      }
    }

    @Override
    public Widget build(BuildContext context) {
      return Scaffold()
          .appBar(AppBar()
              .title(Text("Sign In")))
          .body(Center()
              .child(Container()
                  .width(360.0)
                  .padding(EdgeInsets_all(24.0))
                  .child(Column()
                      .mainAxisSize(MainAxisSize.min)
                      .crossAxisAlignment(CrossAxisAlignment.stretch)
                      .children(List.of(
                          Text("Welcome Back")
                              .style(TextStyle()
                                  .fontSize(28.0)
                                  .fontWeight(FontWeight.bold())),
                          SizedBox().height(8.0),
                          Text("Sign in to continue")
                              .style(TextStyle()
                                  .fontSize(14.0)
                                  .color(Colors.grey().shade600())),
                          SizedBox().height(32.0),
                          TextField()
                              .decoration(InputDecoration()
                                  .labelText("Email")
                                  .hintText("you@example.com")
                                  .border(OutlineInputBorder()))
                              .onChanged(v -> _email = v),
                          SizedBox().height(16.0),
                          TextField()
                              .decoration(InputDecoration()
                                  .labelText("Password")
                                  .border(OutlineInputBorder()))
                              .obscureText(true)
                              .onChanged(v -> _password = v),
                          SizedBox().height(28.0),
                          FilledButton(this::_login)
                              .child(Text("Sign In"))
                      ))
              ))
          );
    }
  }
}
