package dev.equo;

import dev.equo.ewt.*;
import static dev.equo.ewt.EWT.*;
import java.util.List;

/**
 * Calculator demo: the entire arithmetic logic lives in plain Java and drives a
 * Flutter UI via setState. The button grid is built from Expanded + Container
 * cells, with operators highlighted in amber, iOS-style.
 */
public class Calculator {

  public static void main(String[] args) {
    App.runApp(CalculatorApp::new);
  }

  static class CalculatorApp extends SubStatelessWidget {
    @Override
    protected Widget build(BuildContext context) {
      return MaterialApp()
          .title("Calculator")
          .theme(ThemeData()
              .colorScheme(ColorScheme_fromSeed(Colors.amber()))
              .scaffoldBackgroundColor(Color(0xFF17171C))
              .useMaterial3(true))
          .home(new CalculatorPage());
    }
  }

  static class CalculatorPage extends SubStatefulWidget {
    @Override
    protected CalculatorState createState() {
      return new CalculatorState();
    }
  }

  static class CalculatorState extends SubState<CalculatorPage> {
    private String _display = "0";
    private double _operand = 0.0;
    private String _op = null;     // pending operator: + - x /
    private boolean _fresh = true; // next digit starts a new number

    // ── Input handling ─────────────────────────────────────────────────────────

    private void _inputDigit(String d) {
      setState(() -> {
        if (_fresh) {
          _display = d.equals(".") ? "0." : d;
          _fresh = false;
        } else if (d.equals(".")) {
          if (!_display.contains(".")) _display = _display + ".";
        } else {
          _display = _display.equals("0") ? d : _display + d;
        }
      });
    }

    private void _applyOp(String op) {
      setState(() -> {
        double current = _parse(_display);
        if (_op != null && !_fresh) {
          _operand = _compute(_operand, current, _op);
          _display = _format(_operand);
        } else {
          _operand = current;
        }
        _op = op;
        _fresh = true;
      });
    }

    private void _equals() {
      setState(() -> {
        if (_op != null) {
          _operand = _compute(_operand, _parse(_display), _op);
          _display = _format(_operand);
          _op = null;
          _fresh = true;
        }
      });
    }

    private void _clear() {
      setState(() -> {
        _display = "0";
        _operand = 0.0;
        _op = null;
        _fresh = true;
      });
    }

    private void _negate() {
      setState(() -> _display = _format(-_parse(_display)));
    }

    private void _percent() {
      setState(() -> _display = _format(_parse(_display) / 100.0));
    }

    private double _compute(double a, double b, String op) {
      return switch (op) {
        case "+" -> a + b;
        case "-" -> a - b;
        case "x" -> a * b;
        case "/" -> b == 0.0 ? 0.0 : a / b;
        default -> b;
      };
    }

    private double _parse(String s) {
      try {
        return Double.parseDouble(s);
      } catch (NumberFormatException e) {
        return 0.0;
      }
    }

    private String _format(double v) {
      if (v == Math.rint(v) && !Double.isInfinite(v)) {
        return Long.toString((long) v);
      }
      String s = Double.toString(v);
      // Trim trailing zeros while keeping a meaningful decimal part.
      if (s.contains(".")) {
        s = s.replaceAll("0+$", "").replaceAll("\\.$", "");
      }
      return s;
    }

    // ── UI ─────────────────────────────────────────────────────────────────────

    @Override
    public Widget build(BuildContext context) {
      return Scaffold()
          .body(SafeArea()
              .child(Padding(EdgeInsets_all(16.0))
                  .child(Column()
                      .children(List.of(

                          // Display
                          Expanded().child(Container()
                              .alignment(Alignment.bottomRight())
                              .padding(EdgeInsets_symmetric().horizontal(12.0).vertical(24.0))
                              .child(Text(_display)
                                  .maxLines(1)
                                  .style(TextStyle()
                                      .fontSize(72.0)
                                      .fontWeight(FontWeight.w300())
                                      .color(Colors.white())))),

                          // Keypad
                          _row(List.of(
                              _funcKey("AC", this::_clear),
                              _funcKey("+/-", this::_negate),
                              _funcKey("%", this::_percent),
                              _opKey("/", "÷"))),
                          _row(List.of(
                              _digitKey("7"), _digitKey("8"), _digitKey("9"),
                              _opKey("x", "×"))),
                          _row(List.of(
                              _digitKey("4"), _digitKey("5"), _digitKey("6"),
                              _opKey("-", "−"))),
                          _row(List.of(
                              _digitKey("1"), _digitKey("2"), _digitKey("3"),
                              _opKey("+", "+"))),
                          _row(List.of(
                              _digitKey2("0"), _digitKey("."),
                              _equalsKey()))
                      )))));
    }

    private Widget _row(List<WidgetI> keys) {
      return Padding(EdgeInsets_symmetric().vertical(5.0))
          .child(Row().children(keys));
    }

    // ── Key variants ────────────────────────────────────────────────────────────

    private Widget _digitKey(String label) {
      return _key(label, Color(0xFF2E2E38), Colors.white(), 1,
          () -> _inputDigit(label));
    }

    // Wide "0" key spanning two columns.
    private Widget _digitKey2(String label) {
      return _key(label, Color(0xFF2E2E38), Colors.white(), 2,
          () -> _inputDigit(label));
    }

    private Widget _funcKey(String label, Runnable onTap) {
      return _key(label, Color(0xFF4A4A55), Colors.white(), 1, onTap);
    }

    private Widget _opKey(String value, String label) {
      return _key(label, Colors.amber().shade700(), Colors.white(), 1,
          () -> _applyOp(value));
    }

    private Widget _equalsKey() {
      return _key("=", Colors.amber().shade700(), Colors.white(), 1, this::_equals);
    }

    private Widget _key(String label, ColorI bg, ColorI fg, int flex, Runnable onTap) {
      return Expanded()
          .flex(flex)
          .child(Padding(EdgeInsets_all(5.0))
              .child(GestureDetector()
                  .onTap(onTap)
                  .child(Container()
                      .height(72.0)
                      .decoration(BoxDecoration()
                          .color(bg)
                          .borderRadius(BorderRadius_circular(20.0)))
                      .alignment(Alignment.center())
                      .child(Text(label)
                          .style(TextStyle()
                              .fontSize(28.0)
                              .fontWeight(FontWeight.w500())
                              .color(fg))))));
    }
  }
}
