package dev.equo.material.screens;

import java.util.ArrayList;
import java.util.List;
import dev.equo.ewt.*;
import static dev.equo.ewt.EWT.*;

import dev.equo.material.WalletKit;
import dev.equo.material.WalletPalette;

/**
 * Send tab: recipient rows, an amount selector, and a Send button that flips the
 * screen to an in-place success confirmation. A CircularProgressIndicator sits at
 * the top as an "updating rates" spinner.
 *
 * The one place where the two apps genuinely diverge: iOS picks the amount with a
 * CupertinoPicker wheel, which Material has no equivalent for — the Material way
 * is a row of choice chips, so that is what this side uses. Same function (pick
 * one of six amounts), different interaction.
 */
public class SendScreen extends SubStatefulWidget {
    @Override
    protected State<SendScreen> createState() {
        return new SendState();
    }
}

class SendState extends SubState<SendScreen> {

    private static final int[] AMOUNTS = { 10, 25, 50, 100, 250, 500 };
    private int amountIndex = 2; // $50
    private boolean sent = false;

    @Override
    public Widget build(BuildContext context) {
        return Scaffold()
                .backgroundColor(WalletPalette.background())
                .appBar(AppBar()
                        .backgroundColor(WalletPalette.bar())
                        .elevation(0.0)
                        .title(Text("Send Money").style(WalletPalette.navTitle())))
                .body(SafeArea().child(sent ? success() : form()));
    }

    // ── Form ───────────────────────────────────────────────────────────────────

    private Widget form() {
        return SingleChildScrollView().child(Column().children(List.of(
                ratesRow(),
                WalletKit.header("To"),
                WalletKit.card(Column().children(List.of(
                        formRow(Icons.person(), "Recipient", "Alex Kim"),
                        WalletKit.divider(),
                        formRow(Icons.pin(), "Account", "•••• 8890")
                ))),
                WalletKit.header("Amount"),
                amountChips(),
                SizedBox().height(24.0),
                Padding(EdgeInsets_symmetric().horizontal(16.0).build()).child(
                        Row().children(List.of(Expanded().child(
                                FilledButton().onPressed(() -> setState(() -> sent = true))
                                        .child(Padding(EdgeInsets_symmetric().vertical(14.0).build())
                                                .child(Text("Send $" + AMOUNTS[amountIndex])
                                                        .style(TextStyle().fontSize(16.0)
                                                                .fontWeight(FontWeight.w500())))))))),
                SizedBox().height(24.0)
        )));
    }

    /** Choice chips: the Material counterpart of the iOS picker wheel. */
    private Widget amountChips() {
        List<WidgetI> chips = new ArrayList<>();
        for (int i = 0; i < AMOUNTS.length; i++) {
            final int idx = i;
            boolean selected = idx == amountIndex;
            chips.add(InkWell()
                    .onTap(() -> setState(() -> amountIndex = idx))
                    .borderRadius(BorderRadius_circular(10.0))
                    .child(Container()
                            .decoration(BoxDecoration()
                                    .color(selected ? WalletPalette.primary() : WalletPalette.card())
                                    .borderRadius(BorderRadius_circular(10.0))
                                    .border(Border_all()
                                            .color(selected ? WalletPalette.primary() : WalletPalette.separator())
                                            .width(1.0).build()))
                            .padding(EdgeInsets_symmetric().horizontal(20.0).vertical(12.0).build())
                            .child(Text("$" + AMOUNTS[idx]).style(TextStyle().fontSize(16.0)
                                    .fontWeight(selected ? FontWeight.w600() : FontWeight.w400())
                                    .color(selected ? WalletPalette.background() : WalletPalette.label())))));
        }
        return Padding(EdgeInsets_symmetric().horizontal(16.0).build())
                .child(Wrap().spacing(10.0).runSpacing(10.0).children(chips));
    }

    private Widget ratesRow() {
        return Padding(EdgeInsets_all(16.0)).child(Row().children(List.of(
                SizedBox().width(18.0).height(18.0).child(
                        CircularProgressIndicator().strokeWidth(2.0).color(WalletPalette.primary())),
                SizedBox().width(12.0),
                Text("Updating exchange rates…").style(WalletPalette.rowSub())
        )));
    }

    private Widget formRow(IconDataI icon, String label, String value) {
        return ListTile()
                .leading(WalletKit.iconTile(icon, WalletPalette.blue(), 30.0))
                .title(Text(label).style(WalletPalette.rowTitle()))
                .trailing(Text(value).style(WalletPalette.rowSub()));
    }

    // ── Success (in place, no modal) ────────────────────────────────────────────

    private Widget success() {
        return Center().child(Column().mainAxisSize(MainAxisSize.min).children(List.of(
                CircleAvatar()
                        .radius(42.0)
                        .backgroundColor(WalletPalette.green())
                        .child(Icon(Icons.check()).color(WalletPalette.background()).size(48.0)),
                SizedBox().height(20.0),
                Text("Sent $" + AMOUNTS[amountIndex]).style(TextStyle().fontSize(24.0)
                        .fontWeight(FontWeight.w400()).color(WalletPalette.label())),
                SizedBox().height(4.0),
                Text("to Alex Kim").style(WalletPalette.rowSub()),
                SizedBox().height(28.0),
                TextButton().onPressed(() -> setState(() -> sent = false))
                        .child(Text("New Transfer").style(TextStyle().fontSize(16.0)
                                .color(WalletPalette.primary())))
        )));
    }
}
