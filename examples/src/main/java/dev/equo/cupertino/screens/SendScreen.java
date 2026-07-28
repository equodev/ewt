package dev.equo.cupertino.screens;

import java.util.ArrayList;
import java.util.List;
import dev.equo.ewt.*;
import static dev.equo.ewt.EWT.*;

import dev.equo.cupertino.WalletKit;
import dev.equo.cupertino.WalletPalette;

/**
 * Send tab: a CupertinoFormSection with the recipient, a CupertinoPicker wheel
 * for the amount, and a Send button that flips the screen to an in-place success
 * confirmation (no modal, since showDialog isn't usable yet). A live
 * CupertinoActivityIndicator sits at the top as an "updating rates" spinner.
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
        return CupertinoPageScaffold()
                .backgroundColor(WalletPalette.background())
                .navigationBar(CupertinoNavigationBar()
                        .backgroundColor(WalletPalette.bar())
                        .middle(Text("Send Money").style(WalletPalette.navTitle())))
                .child(SafeArea().child(sent ? success() : form()));
    }

    // ── Form ───────────────────────────────────────────────────────────────────

    private Widget form() {
        List<WidgetI> wheel = new ArrayList<>();
        for (int a : AMOUNTS) {
            wheel.add(Center().child(Text("$" + a)
                    .style(TextStyle().fontSize(24.0).color(WalletPalette.label()))));
        }
        return SingleChildScrollView().child(Column().children(List.of(
                ratesRow(),
                WalletKit.header("TO"),
                WalletKit.card(CupertinoFormSection(List.of(
                        formRow(CupertinoIcons.person_crop_circle_fill(), "Recipient", "Alex Kim"),
                        formRow(CupertinoIcons.number(), "Account", "•••• 8890")
                )).backgroundColor(WalletPalette.card())),
                WalletKit.header("AMOUNT"),
                WalletKit.card(Container().height(160.0).child(CupertinoPicker()
                        .itemExtent(40.0)
                        .backgroundColor(WalletPalette.card())
                        .onSelectedItemChanged(i -> setState(() -> amountIndex = i))
                        .addAllChildren(wheel))),
                SizedBox().height(24.0),
                Padding(EdgeInsets_symmetric().horizontal(16.0).build()).child(
                        CupertinoButton_filled(Text("Send $" + AMOUNTS[amountIndex])
                                .style(TextStyle().color(Colors.white()).fontWeight(FontWeight.w600())))
                                .onPressed(() -> setState(() -> sent = true))),
                SizedBox().height(24.0)
        )));
    }

    private Widget ratesRow() {
        return Padding(EdgeInsets_all(16.0)).child(Row().children(List.of(
                CupertinoActivityIndicator().color(WalletPalette.secondaryLabel()),
                SizedBox().width(10.0),
                Text("Updating exchange rates…").style(WalletPalette.rowSub())
        )));
    }

    private Widget formRow(IconDataI icon, String label, String value) {
        return CupertinoFormRow(Row().children(List.of(
                WalletKit.iconTile(icon, WalletPalette.blue(), 30.0),
                SizedBox().width(12.0),
                Expanded().child(Text(label).style(WalletPalette.rowTitle())),
                Text(value).style(WalletPalette.rowSub())
        )));
    }

    // ── Success (in place, no modal) ────────────────────────────────────────────

    private Widget success() {
        return Center().child(Column().mainAxisSize(MainAxisSize.min).children(List.of(
                Container()
                        .width(84.0).height(84.0)
                        .decoration(BoxDecoration().color(WalletPalette.green())
                                .borderRadius(BorderRadius_circular(42.0)))
                        .child(Center().child(Icon(CupertinoIcons.checkmark_alt())
                                .color(Colors.white()).size(48.0))),
                SizedBox().height(20.0),
                Text("Sent $" + AMOUNTS[amountIndex]).style(TextStyle().fontSize(24.0)
                        .fontWeight(FontWeight.w700()).color(WalletPalette.label())),
                SizedBox().height(4.0),
                Text("to Alex Kim").style(WalletPalette.rowSub()),
                SizedBox().height(28.0),
                CupertinoButton(Text("New Transfer").style(TextStyle().color(WalletPalette.blue())))
                        .onPressed(() -> setState(() -> sent = false))
        )));
    }
}
