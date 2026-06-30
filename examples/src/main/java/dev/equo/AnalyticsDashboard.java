package dev.equo;

import dev.equo.ewt.*;
import static dev.equo.ewt.EWT.*;
import java.util.List;

/**
 * Analytics dashboard demo: stat cards with shadows, a faux bar chart, traffic
 * source bars and a recent-activity list. The selected time range (7d/30d/90d)
 * is driven by a custom segmented control and rescales every metric via setState.
 */
public class AnalyticsDashboard {

  public static void main(String[] args) {
    App.runApp(DashboardApp::new);
  }

  static class DashboardApp extends SubStatelessWidget {
    @Override
    protected Widget build(BuildContext context) {
      return MaterialApp()
          .title("Analytics")
          .theme(ThemeData()
              .colorScheme(ColorScheme_fromSeed(Colors.indigo()))
              .scaffoldBackgroundColor(Color(0xFFF4F5F7))
              .useMaterial3(true))
          .home(new DashboardPage());
    }
  }

  static class DashboardPage extends SubStatefulWidget {
    @Override
    protected DashboardState createState() {
      return new DashboardState();
    }
  }

  static class DashboardState extends SubState<DashboardPage> {
    // 0 = last 7 days, 1 = last 30 days, 2 = last 90 days.
    private int _range = 0;

    private static final String[] _rangeLabels = {"7 days", "30 days", "90 days"};
    // Per-range scale factor applied to the base metrics.
    private static final double[] _rangeScale = {1.0, 4.1, 11.6};
    // Relative bar heights for the sales chart, one set per range.
    private static final double[][] _chartData = {
        {0.45, 0.62, 0.38, 0.80, 0.55, 0.95, 0.70},
        {0.60, 0.40, 0.72, 0.50, 0.88, 0.66, 0.92},
        {0.30, 0.55, 0.48, 0.70, 0.62, 0.85, 1.00}
    };
    private static final String[] _chartLabels = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

    private void _selectRange(int range) {
      setState(() -> _range = range);
    }

    @Override
    public Widget build(BuildContext context) {
      double scale = _rangeScale[_range];

      return Scaffold()
          .appBar(AppBar()
              .title(Text("Analytics"))
              .backgroundColor(Colors.white())
              .foregroundColor(Colors.black())
              .elevation(0.5)
              .actions(List.of(
                  IconButton()
                      .icon(Icon(Icons.search()))
                      .onPressed(() -> {}),
                  IconButton()
                      .icon(Icon(Icons.notifications_none()))
                      .onPressed(() -> {}),
                  SizedBox().width(8.0)
              )))
          .body(SingleChildScrollView()
              .padding(EdgeInsets_all(16.0))
              .child(Column()
                  .crossAxisAlignment(CrossAxisAlignment.start)
                  .children(List.of(

                      // ── Header + range selector ───────────────────────────
                      Text("Overview")
                          .style(TextStyle()
                              .fontSize(22.0)
                              .fontWeight(FontWeight.bold())),
                      SizedBox().height(4.0),
                      Text("Performance for the last " + _rangeLabels[_range])
                          .style(TextStyle()
                              .fontSize(13.0)
                              .color(Colors.grey().shade600())),
                      SizedBox().height(16.0),
                      _rangeSelector(),
                      SizedBox().height(20.0),

                      // ── Stat cards (2 x 2) ────────────────────────────────
                      Row().children(List.of(
                          Expanded().child(_statCard(
                              "Revenue", "$" + _money(12480 * scale),
                              Icons.attach_money(), Colors.green(), 12.5, true)),
                          SizedBox().width(14.0),
                          Expanded().child(_statCard(
                              "Users", _money(3420 * scale),
                              Icons.people_outline(), Colors.blue(), 8.2, true))
                      )),
                      SizedBox().height(14.0),
                      Row().children(List.of(
                          Expanded().child(_statCard(
                              "Orders", _money(872 * scale),
                              Icons.shopping_cart_outlined(), Colors.orange(), 3.1, false)),
                          SizedBox().width(14.0),
                          Expanded().child(_statCard(
                              "Conversion", "3.8%",
                              Icons.show_chart(), Colors.purple(), 1.4, true))
                      )),
                      SizedBox().height(24.0),

                      // ── Sales bar chart ───────────────────────────────────
                      _card(Column()
                          .crossAxisAlignment(CrossAxisAlignment.start)
                          .children(List.of(
                              Text("Sales performance")
                                  .style(TextStyle()
                                      .fontSize(16.0)
                                      .fontWeight(FontWeight.w600())),
                              SizedBox().height(20.0),
                              SizedBox().height(160.0).child(_barChart())
                          ))),
                      SizedBox().height(20.0),

                      // ── Traffic sources ───────────────────────────────────
                      _card(Column()
                          .crossAxisAlignment(CrossAxisAlignment.start)
                          .children(List.of(
                              Text("Traffic sources")
                                  .style(TextStyle()
                                      .fontSize(16.0)
                                      .fontWeight(FontWeight.w600())),
                              SizedBox().height(16.0),
                              _trafficRow("Organic search", 0.52, Colors.indigo()),
                              SizedBox().height(14.0),
                              _trafficRow("Direct", 0.27, Colors.teal()),
                              SizedBox().height(14.0),
                              _trafficRow("Social", 0.14, Colors.orange()),
                              SizedBox().height(14.0),
                              _trafficRow("Referral", 0.07, Colors.pink())
                          ))),
                      SizedBox().height(20.0),

                      // ── Recent activity ───────────────────────────────────
                      Text("Recent activity")
                          .style(TextStyle()
                              .fontSize(16.0)
                              .fontWeight(FontWeight.w600())),
                      SizedBox().height(8.0),
                      _card(Column().children(List.of(
                          ListTile()
                              .leading(_avatar(Icons.person(), Colors.blue()))
                              .title(Text("New subscription"))
                              .subtitle(Text("Acme Inc. upgraded to Pro"))
                              .trailing(Text("2m")
                                  .style(TextStyle().fontSize(12.0).color(Colors.grey().shade500()))),
                          Divider().height(1.0),
                          ListTile()
                              .leading(_avatar(Icons.shopping_bag_outlined(), Colors.green()))
                              .title(Text("Order completed"))
                              .subtitle(Text("Order #10482 shipped"))
                              .trailing(Text("18m")
                                  .style(TextStyle().fontSize(12.0).color(Colors.grey().shade500()))),
                          Divider().height(1.0),
                          ListTile()
                              .leading(_avatar(Icons.warning_amber(), Colors.orange()))
                              .title(Text("Payment failed"))
                              .subtitle(Text("Retry scheduled for tomorrow"))
                              .trailing(Text("1h")
                                  .style(TextStyle().fontSize(12.0).color(Colors.grey().shade500())))
                      ))),
                      SizedBox().height(32.0)

                  ))));
    }

    // ── Range selector (custom segmented control) ─────────────────────────────

    private Widget _rangeSelector() {
      return Container()
          .padding(EdgeInsets_all(4.0))
          .decoration(BoxDecoration()
              .color(Colors.grey().shade200())
              .borderRadius(BorderRadius_circular(12.0)))
          .child(Row().children(List.of(
              Expanded().child(_segment(0)),
              Expanded().child(_segment(1)),
              Expanded().child(_segment(2))
          )));
    }

    private Widget _segment(int index) {
      boolean selected = _range == index;
      BoxDecorationBoxDecorationBuilder decoration = BoxDecoration()
          .color(selected ? Colors.white() : Colors.transparent())
          .borderRadius(BorderRadius_circular(9.0));
      if (selected) {
        decoration = decoration.boxShadow(List.of(
            BoxShadow()
                .color(Color_fromRGBO(0, 0, 0, 0.10))
                .blurRadius(6.0)
                .offset(Offset(0.0, 2.0))));
      }
      return GestureDetector()
          .onTap(() -> _selectRange(index))
          .child(Container()
              .padding(EdgeInsets_symmetric().vertical(10.0))
              .decoration(decoration)
              .alignment(Alignment.center())
              .child(Text(_rangeLabels[index])
                  .style(TextStyle()
                      .fontSize(13.0)
                      .fontWeight(selected ? FontWeight.w600() : FontWeight.w400())
                      .color(selected ? Colors.indigo() : Colors.grey().shade600()))));
    }

    // ── Stat card ─────────────────────────────────────────────────────────────

    private Widget _statCard(String label, String value, IconData icon,
                             ColorI accent, double delta, boolean positive) {
      return _card(Column()
          .crossAxisAlignment(CrossAxisAlignment.start)
          .children(List.of(
              Row()
                  .mainAxisAlignment(MainAxisAlignment.spaceBetween)
                  .children(List.of(
                      Container()
                          .padding(EdgeInsets_all(8.0))
                          .decoration(BoxDecoration()
                              .color(_tint(accent))
                              .borderRadius(BorderRadius_circular(10.0)))
                          .child(Icon(icon).color(accent).size(20.0)),
                      Icon(Icons.more_vert()).color(Colors.grey().shade400()).size(18.0)
                  )),
              SizedBox().height(14.0),
              Text(value)
                  .style(TextStyle()
                      .fontSize(22.0)
                      .fontWeight(FontWeight.bold())),
              SizedBox().height(2.0),
              Text(label)
                  .style(TextStyle()
                      .fontSize(13.0)
                      .color(Colors.grey().shade600())),
              SizedBox().height(10.0),
              Row().children(List.of(
                  Icon(positive ? Icons.trending_up() : Icons.trending_down())
                      .size(16.0)
                      .color(positive ? Colors.green() : Colors.red()),
                  SizedBox().width(4.0),
                  Text((positive ? "+" : "-") + delta + "%")
                      .style(TextStyle()
                          .fontSize(12.0)
                          .fontWeight(FontWeight.w600())
                          .color(positive ? Colors.green() : Colors.red())),
                  SizedBox().width(4.0),
                  Text("vs prev")
                      .style(TextStyle().fontSize(12.0).color(Colors.grey().shade500()))
              ))
          )));
    }

    // ── Bar chart ───────────────────────────────────────────────────────────--

    private Widget _barChart() {
      double[] data = _chartData[_range];
      java.util.List<WidgetI> bars = new java.util.ArrayList<>();
      for (int i = 0; i < data.length; i++) {
        bars.add(_bar(data[i], _chartLabels[i], i == 5));
      }
      return Row()
          .mainAxisAlignment(MainAxisAlignment.spaceBetween)
          .crossAxisAlignment(CrossAxisAlignment.end)
          .children(bars);
    }

    private Widget _bar(double value, String label, boolean highlight) {
      // Chart frame is 160px tall; reserve ~24px for the label below each bar.
      double height = 8.0 + value * 120.0;
      return Column()
          .mainAxisSize(MainAxisSize.min)
          .mainAxisAlignment(MainAxisAlignment.end)
          .children(List.of(
              Container()
                  .width(22.0)
                  .height(height)
                  .decoration(BoxDecoration()
                      .color(highlight ? Colors.indigo() : Colors.indigo().shade100())
                      .borderRadius(BorderRadius_circular(6.0))),
              SizedBox().height(6.0),
              Text(label)
                  .style(TextStyle()
                      .fontSize(11.0)
                      .color(Colors.grey().shade600()))
          ));
    }

    // ── Traffic source row ─────────────────────────────────────────────────────

    private Widget _trafficRow(String label, double fraction, ColorI color) {
      int pct = (int) Math.round(fraction * 100);
      return Column()
          .crossAxisAlignment(CrossAxisAlignment.start)
          .children(List.of(
              Row()
                  .mainAxisAlignment(MainAxisAlignment.spaceBetween)
                  .children(List.of(
                      Text(label).style(TextStyle().fontSize(13.0)),
                      Text(pct + "%")
                          .style(TextStyle().fontSize(13.0).fontWeight(FontWeight.w600()))
                  )),
              SizedBox().height(6.0),
              LinearProgressIndicator()
                  .value(fraction)
                  .minHeight(8.0)
                  .borderRadius(BorderRadius_circular(4.0))
                  .color(color)
                  .backgroundColor(Colors.grey().shade200())
          ));
    }

    // ── Shared helpers ─────────────────────────────────────────────────────────

    private Widget _card(WidgetI child) {
      return Container()
          .padding(EdgeInsets_all(16.0))
          .decoration(BoxDecoration()
              .color(Colors.white())
              .borderRadius(BorderRadius_circular(16.0))
              .boxShadow(List.of(
                  BoxShadow()
                      .color(Color_fromRGBO(0, 0, 0, 0.06))
                      .blurRadius(14.0)
                      .offset(Offset(0.0, 4.0)))))
          .child(child);
    }

    private Widget _avatar(IconData icon, ColorI color) {
      return Container()
          .width(40.0)
          .height(40.0)
          .decoration(BoxDecoration()
              .color(_tint(color))
              .shape(BoxShape.circle))
          .alignment(Alignment.center())
          .child(Icon(icon).color(color).size(20.0));
    }

    // Light translucent tint of an accent color for icon backgrounds.
    private ColorI _tint(ColorI color) {
      return Color.alphaBlend(Color_fromRGBO(255, 255, 255, 0.85), color);
    }

    private String _money(double v) {
      long n = Math.round(v);
      String s = Long.toString(n);
      StringBuilder out = new StringBuilder();
      int count = 0;
      for (int i = s.length() - 1; i >= 0; i--) {
        out.append(s.charAt(i));
        if (++count % 3 == 0 && i != 0) out.append(',');
      }
      return out.reverse().toString();
    }
  }
}
