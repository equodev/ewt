package dev.equo.material.screens;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import dev.equo.ewt.*;
import static dev.equo.ewt.EWT.*;

import dev.equo.material.WalletKit;
import dev.equo.material.WalletPalette;

/**
 * Home tab: a balance card, a quick-actions row, a search field and the recent
 * transactions list (filtered live by the search field) — the same content as the
 * Cupertino twin, rebuilt with an AppBar, a Material TextField and ListTile rows.
 */
public class HomeScreen extends SubStatefulWidget {
    @Override
    protected State<HomeScreen> createState() {
        return new HomeState();
    }
}

class Tx {
    final String merchant, when;
    final double amount;      // negative = spent, positive = received
    // Suppliers, never stored handles: EWT consumes each Color/IconData on first
    // use, so a fresh one must be created inside every build.
    final Supplier<IconDataI> icon;
    final Supplier<Color> color;
    Tx(String merchant, String when, double amount, Supplier<IconDataI> icon, Supplier<Color> color) {
        this.merchant = merchant; this.when = when; this.amount = amount;
        this.icon = icon; this.color = color;
    }
}

class HomeState extends SubState<HomeScreen> {

    private String query = "";
    private final List<Tx> all = new ArrayList<>(List.of(
            new Tx("Apple Store",  "Today, 14:20",  -1299.00, Icons::shopping_bag,    WalletPalette::blue),
            new Tx("Salary",       "Today, 09:00",  40200.00, Icons::arrow_downward,  WalletPalette::green),
            new Tx("Uber",         "Yesterday",       -18.40, Icons::directions_car,  WalletPalette::teal),
            new Tx("Spotify",      "Yesterday",        -9.99, Icons::music_note,      WalletPalette::pink),
            new Tx("Whole Foods",  "Mon",             -76.12, Icons::shopping_cart,   WalletPalette::orange),
            new Tx("Juan P.",      "Mon",             120.00, Icons::arrow_downward,  WalletPalette::green),
            new Tx("Netflix",      "Sun",             -15.49, Icons::tv,              WalletPalette::red)
    ));

    @Override
    public Widget build(BuildContext context) {
        List<Tx> shown = new ArrayList<>();
        for (Tx t : all) {
            if (query.isEmpty() || t.merchant.toLowerCase().contains(query.toLowerCase())) shown.add(t);
        }

        return Scaffold()
                .backgroundColor(WalletPalette.background())
                .appBar(AppBar()
                        .backgroundColor(WalletPalette.bar())
                        .elevation(0.0)
                        .title(Text("Wallet").style(WalletPalette.navTitle())))
                .body(SafeArea().child(SingleChildScrollView().child(Column().children(List.of(
                        SizedBox().height(10.0),
                        balanceCard(),
                        SizedBox().height(22.0),
                        quickActions(),
                        SizedBox().height(20.0),
                        searchField(),
                        WalletKit.header("Recent"),
                        transactions(shown),
                        SizedBox().height(24.0)
                )))));
    }

    // ── Search ─────────────────────────────────────────────────────────────────

    /** Material has no dedicated search field: it is a TextField plus decoration. */
    private Widget searchField() {
        return Padding(EdgeInsets_symmetric().horizontal(16.0).build()).child(
                TextField()
                        .onChanged(v -> setState(() -> query = v))
                        .style(WalletPalette.rowTitle())
                        .decoration(InputDecoration()
                                .hintText("Search")
                                .hintStyle(WalletPalette.rowSub())
                                .prefixIcon(Icon(Icons.search()).color(WalletPalette.secondaryLabel()))
                                .filled(true)
                                .fillColor(WalletPalette.card())
                                .contentPadding(EdgeInsets_symmetric().vertical(4.0).build())
                                .border(OutlineInputBorder()
                                        .borderRadius(BorderRadius_circular(28.0))
                                        .borderSide(BorderSide().width(0.0)
                                                .color(Color_fromARGB(0, 0, 0, 0).build()).build()))));
    }

    // ── Balance card ───────────────────────────────────────────────────────────

    private Widget balanceCard() {
        return Padding(EdgeInsets_symmetric().horizontal(16.0).build()).child(
                Container()
                        .decoration(BoxDecoration()
                                .color(WalletPalette.cardViolet())
                                .borderRadius(BorderRadius_circular(16.0))
                                .boxShadow(List.of(BoxShadow()
                                        .color(Color_fromRGBO(0, 0, 0, 0.45).build())
                                        .blurRadius(18.0).offset(Offset(0.0, 6.0)))))
                        .padding(EdgeInsets_all(22.0))
                        .child(Column().crossAxisAlignment(CrossAxisAlignment.start).children(List.of(
                                Row().children(List.of(
                                        Text("EWT Bank").style(TextStyle().fontSize(15.0)
                                                .fontWeight(FontWeight.w500()).color(WalletPalette.onCardMuted())),
                                        Expanded().child(Align().alignment(Alignment.centerRight())
                                                .child(Icon(Icons.wifi()).color(WalletPalette.onCardMuted()).size(22.0)))
                                )),
                                SizedBox().height(20.0),
                                Text("Total balance").style(TextStyle().fontSize(14.0).color(WalletPalette.onCardMuted())),
                                SizedBox().height(4.0),
                                Text("$12,480.50").style(TextStyle().fontSize(34.0)
                                        .fontWeight(FontWeight.w400()).color(Colors.white())),
                                SizedBox().height(22.0),
                                Row().children(List.of(
                                        Text("••••  4242").style(TextStyle().fontSize(15.0)
                                                .letterSpacing(1.5).color(WalletPalette.onCardMuted())),
                                        Expanded().child(Align().alignment(Alignment.centerRight())
                                                .child(Text("09/27").style(TextStyle().fontSize(15.0)
                                                        .color(WalletPalette.onCardMuted()))))
                                ))
                        ))));
    }

    // ── Quick actions ──────────────────────────────────────────────────────────

    private Widget quickActions() {
        return Padding(EdgeInsets_symmetric().horizontal(12.0).build())
                .child(Row().mainAxisAlignment(MainAxisAlignment.spaceAround).children(List.of(
                        WalletKit.circleAction(Icons.add(), "Add", WalletPalette.green(), () -> {}),
                        WalletKit.circleAction(Icons.send(), "Send", WalletPalette.blue(), () -> {}),
                        WalletKit.circleAction(Icons.arrow_downward(), "Request", WalletPalette.teal(), () -> {}),
                        WalletKit.circleAction(Icons.more_horiz(), "More", WalletPalette.secondaryLabel(), () -> {})
                )));
    }

    // ── Transactions ───────────────────────────────────────────────────────────

    private Widget transactions(List<Tx> list) {
        if (list.isEmpty()) {
            return WalletKit.card(Padding(EdgeInsets_all(24.0))
                    .child(Center().child(Text("No matches").style(WalletPalette.rowSub()))));
        }
        List<WidgetI> rows = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) rows.add(WalletKit.divider());
            rows.add(txRow(list.get(i)));
        }
        return WalletKit.card(Column().children(rows));
    }

    /** A Material ListTile does the three-slot row layout iOS builds by hand. */
    private Widget txRow(Tx t) {
        boolean incoming = t.amount > 0;
        String amountText = (incoming ? "+$" : "-$") + String.format("%.2f", Math.abs(t.amount));
        return ListTile()
                .onTap(() -> {})
                .leading(WalletKit.iconTile(t.icon.get(), t.color.get(), 40.0))
                .title(Text(t.merchant).style(WalletPalette.rowTitle()))
                .subtitle(Text(t.when).style(WalletPalette.rowSub()))
                .trailing(Text(amountText).style(WalletPalette.amount(
                        incoming ? WalletPalette.green() : WalletPalette.label())));
    }
}
