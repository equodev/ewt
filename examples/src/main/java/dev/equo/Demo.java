package dev.equo;

import dev.equo.ewt.*;
import static dev.equo.ewt.EWT.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Demo {

  public static void main(String[] args) {
    App.runApp(DemoApp::new);
  }

  static class DemoApp extends SubStatelessWidget {
    @Override
    protected Widget build(BuildContext context) {
      return MaterialApp()
          .title("EWT Demo")
          .theme(ThemeData()
              .colorScheme(ColorScheme_fromSeed(Colors.indigo()))
              .useMaterial3(true))
          .home(new DemoRoot());
    }
  }

  static class DemoRoot extends SubStatefulWidget {
    @Override
    protected DemoState createState() {
      return new DemoState();
    }
  }

  static class DemoState extends SubState<DemoRoot> {
    private int _page = 0; // 0=login, 1=loading, 2=dashboard
    private String _email = "";
    private String _password = "";
    private boolean _autofilled = false;
    private String _newTag = "";
    private final List<String> _tags = new ArrayList<>(List.of("Flutter Dev", "Java", "Open Source"));

    private void _autofill() {
      setState(() -> {
        _email = "demo@equo.dev";
        _password = "demo1234";
        _autofilled = true;
      });
    }

    private void _login() {
      setState(() -> _page = 1);
      new Thread(() -> {
        try { Thread.sleep(1500); } catch (InterruptedException ignored) {}
        setState(() -> _page = 2);
      }).start();
    }

    private void _showAddTag() {
      _newTag = "";
      showDialog(context(), ctx ->
          AlertDialog()
              .title(Text("Nuevo tag"))
              .content(TextField()
                  .decoration(InputDecoration()
                      .hintText("Ej: Android")
                      .border(OutlineInputBorder()))
                  .onChanged(v -> _newTag = v))
              .actions(List.of(
                  TextButton(() -> Navigator.pop(ctx)).child(Text("Cancelar")),
                  FilledButton(() -> {
                    Navigator.pop(ctx);
                    if (!_newTag.isBlank()) setState(() -> _tags.add(_newTag));
                  }).child(Text("Agregar"))
              ))
      );
    }

    @Override
    public Widget build(BuildContext context) {
      return switch (_page) {
        case 1 -> _buildLoading();
        case 2 -> _buildDashboard();
        default -> _buildLogin();
      };
    }

    // ── Login ─────────────────────────────────────────────────────────────────

    private Widget _buildLogin() {
      return Scaffold()
          .body(Center()
              .child(Container()
                  .width(360.0)
                  .padding(EdgeInsets_all(32.0))
                  .child(Column()
                      .mainAxisSize(MainAxisSize.min)
                      .crossAxisAlignment(CrossAxisAlignment.stretch)
                      .children(List.of(
                          Center().child(
                              Container()
                                  .width(72.0)
                                  .height(72.0)
                                  .decoration(BoxDecoration()
                                      .color(Colors.indigo())
                                      .borderRadius(BorderRadius_circular(20.0)))
                                  .alignment(Alignment.center())
                                  .child(Text("EWT")
                                      .style(TextStyle()
                                          .fontSize(20.0)
                                          .fontWeight(FontWeight.bold())
                                          .color(Colors.white())))),
                          SizedBox().height(24.0),
                          Text("EWT Demo")
                              .style(TextStyle()
                                  .fontSize(26.0)
                                  .fontWeight(FontWeight.bold())),
                          SizedBox().height(4.0),
                          Text("Ingresá para continuar")
                              .style(TextStyle()
                                  .fontSize(14.0)
                                  .color(Colors.grey().shade600())),
                          SizedBox().height(28.0),
                          TextField()
                              .decoration(InputDecoration()
                                  .labelText("Email")
                                  .border(OutlineInputBorder()))
                              .onChanged(v -> _email = v),
                          SizedBox().height(16.0),
                          TextField()
                              .decoration(InputDecoration()
                                  .labelText("Contraseña")
                                  .border(OutlineInputBorder()))
                              .obscureText(true)
                              .onChanged(v -> _password = v),
                          SizedBox().height(24.0),
                          FilledButton(this::_login)
                              .child(Text("Ingresar")),
                          SizedBox().height(16.0),
                          Center().child(
                              GestureDetector()
                                  .onLongPress(this::_autofill)
                                  .child(_autofilled
                                      ? Text("✓ demo@equo.dev cargado")
                                          .style(TextStyle()
                                              .fontSize(12.0)
                                              .color(Colors.green()))
                                      : Text("¿Usar cuenta demo? (mantener presionado)")
                                          .style(TextStyle()
                                              .fontSize(12.0)
                                              .color(Colors.indigo().shade400()))))
                      )))));
    }

    // ── Loading ───────────────────────────────────────────────────────────────

    private Widget _buildLoading() {
      return Scaffold()
          .body(Column()
              .children(List.of(
                  LinearProgressIndicator().color(Colors.indigo()),
                  Expanded().child(
                      Center()
                          .child(Column()
                              .mainAxisSize(MainAxisSize.min)
                              .children(List.of(
                                  CircularProgressIndicator().color(Colors.indigo()),
                                  SizedBox().height(24.0),
                                  Text("Iniciando sesión...")
                                      .style(TextStyle()
                                          .fontSize(16.0)
                                          .color(Colors.grey().shade600()))
                              ))))
              )));
    }

    // ── Dashboard ─────────────────────────────────────────────────────────────

    private Widget _buildDashboard() {
      double progress = Math.min(_tags.size() / 8.0, 1.0);
      int pct = (int) (progress * 100);
      String displayEmail = _email.isEmpty() ? "demo@equo.dev" : _email;
      List<WidgetI> tagChips = _tags.stream()
          .map(t -> (WidgetI) Chip().label(Text(t)))
          .collect(Collectors.toList());

      return Scaffold()
          .appBar(AppBar()
              .title(Text("Bienvenido"))
              .backgroundColor(Theme.of(context()).colorScheme().primaryContainer()))
          .floatingActionButton(FloatingActionButton()
              .onPressed(this::_showAddTag)
              .tooltip("Agregar tag")
              .child(Icon(Icons.add())))
          .body(SingleChildScrollView()
              .padding(EdgeInsets_all(16.0))
              .child(Column()
                  .crossAxisAlignment(CrossAxisAlignment.start)
                  .children(List.of(

                      // Profile card
                      Card().child(
                          Container()
                              .padding(EdgeInsets_all(16.0))
                              .child(Column()
                                  .crossAxisAlignment(CrossAxisAlignment.start)
                                  .children(List.of(
                                      Row().children(List.of(
                                          Container()
                                              .width(56.0)
                                              .height(56.0)
                                              .decoration(BoxDecoration()
                                                  .color(Colors.indigo())
                                                  .shape(BoxShape.circle))
                                              .alignment(Alignment.center())
                                              .child(Text("D")
                                                  .style(TextStyle()
                                                      .fontSize(24.0)
                                                      .fontWeight(FontWeight.bold())
                                                      .color(Colors.white()))),
                                          SizedBox().width(16.0),
                                          Column()
                                              .crossAxisAlignment(CrossAxisAlignment.start)
                                              .mainAxisSize(MainAxisSize.min)
                                              .children(List.of(
                                                  Text("Demo User")
                                                      .style(TextStyle()
                                                          .fontSize(18.0)
                                                          .fontWeight(FontWeight.bold())),
                                                  Text(displayEmail)
                                                      .style(TextStyle()
                                                          .fontSize(13.0)
                                                          .color(Colors.grey().shade600()))
                                              ))
                                      )),
                                      SizedBox().height(16.0),
                                      Wrap()
                                          .spacing(8.0)
                                          .runSpacing(8.0)
                                          .children(tagChips)
                                  )))),
                      SizedBox().height(16.0),

                      // Profile completion
                      Text("Completitud del perfil")
                          .style(TextStyle().fontWeight(FontWeight.bold())),
                      SizedBox().height(8.0),
                      LinearProgressIndicator()
                          .value(progress)
                          .color(Colors.indigo()),
                      SizedBox().height(4.0),
                      Text(pct + "% — agregá tags con el botón +")
                          .style(TextStyle()
                              .fontSize(12.0)
                              .color(Colors.grey().shade600())),
                      SizedBox().height(24.0),

                      // Recent activity
                      Text("Actividad reciente")
                          .style(TextStyle().fontWeight(FontWeight.bold())),
                      SizedBox().height(8.0),
                      Card().child(Column()
                          .children(List.of(
                              ListTile()
                                  .leading(Icon(Icons.done()).color(Colors.green()))
                                  .title(Text("Login exitoso"))
                                  .subtitle(Text("Hace un momento")),
                              Divider(),
                              ListTile()
                                  .leading(Icon(Icons.person()).color(Colors.indigo()))
                                  .title(Text("Perfil creado"))
                                  .subtitle(Text(displayEmail)),
                              Divider(),
                              ListTile()
                                  .leading(Icon(Icons.label()).color(Colors.orange()))
                                  .title(Text("Tags activos"))
                                  .subtitle(Text(_tags.size() + " tags"))
                          ))),
                      SizedBox().height(80.0)

                  ))));
    }
  }
}
