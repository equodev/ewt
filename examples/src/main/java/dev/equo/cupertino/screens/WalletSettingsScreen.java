package dev.equo.cupertino.screens;

import java.util.List;
import java.util.function.Supplier;
import dev.equo.ewt.*;
import static dev.equo.ewt.EWT.*;

import dev.equo.cupertino.WalletKit;
import dev.equo.cupertino.WalletPalette;

/**
 * Settings tab: a profile header, grouped rows with CupertinoSwitch toggles
 * (Face ID, notifications) and chevron rows, plus a log-out action.
 */
public class WalletSettingsScreen extends SubStatefulWidget {
    @Override
    protected State<WalletSettingsScreen> createState() {
        return new WalletSettingsState();
    }
}

class WalletSettingsState extends SubState<WalletSettingsScreen> {

    private boolean faceId = true;
    private boolean push = true;
    private boolean txAlerts = false;

    @Override
    public Widget build(BuildContext context) {
        return CupertinoPageScaffold()
                .backgroundColor(WalletPalette.background())
                .navigationBar(CupertinoNavigationBar()
                        .backgroundColor(WalletPalette.bar())
                        .middle(Text("Settings").style(WalletPalette.navTitle())))
                .child(SafeArea().child(SingleChildScrollView().child(Column().children(List.of(
                        SizedBox().height(14.0),
                        profile(),
                        WalletKit.header("SECURITY"),
                        WalletKit.card(Column().children(List.of(
                                switchRow(CupertinoIcons::lock_fill, WalletPalette::blue,
                                        "Face ID", faceId, v -> setState(() -> faceId = v)),
                                WalletKit.divider(),
                                chevronRow(CupertinoIcons::number, WalletPalette::indigo, "Change PIN")
                        ))),
                        WalletKit.header("NOTIFICATIONS"),
                        WalletKit.card(Column().children(List.of(
                                switchRow(CupertinoIcons::bell_fill, WalletPalette::orange,
                                        "Push notifications", push, v -> setState(() -> push = v)),
                                WalletKit.divider(),
                                switchRow(CupertinoIcons::money_dollar_circle_fill, WalletPalette::green,
                                        "Transaction alerts", txAlerts, v -> setState(() -> txAlerts = v))
                        ))),
                        SizedBox().height(18.0),
                        WalletKit.card(GestureDetector().onTap(() -> {}).child(
                                Padding(EdgeInsets_symmetric().vertical(14.0).build())
                                        .child(Center().child(Text("Log Out")
                                                .style(TextStyle().fontSize(17.0).color(WalletPalette.red())))))),
                        SizedBox().height(24.0)
                )))));
    }

    private Widget profile() {
        return WalletKit.card(Padding(EdgeInsets_all(14.0)).child(Row().children(List.of(
                Container()
                        .width(56.0).height(56.0)
                        .decoration(BoxDecoration().color(WalletPalette.indigo())
                                .borderRadius(BorderRadius_circular(28.0)))
                        .child(Center().child(Text("EG").style(TextStyle().fontSize(22.0)
                                .fontWeight(FontWeight.w600()).color(Colors.white())))),
                SizedBox().width(14.0),
                Expanded().child(Column().crossAxisAlignment(CrossAxisAlignment.start).children(List.of(
                        Text("Esteban G.").style(TextStyle().fontSize(19.0)
                                .fontWeight(FontWeight.w600()).color(WalletPalette.label())),
                        SizedBox().height(2.0),
                        Text("esteban@equo.dev").style(WalletPalette.rowSub())
                ))),
                Icon(CupertinoIcons.chevron_right()).color(WalletPalette.secondaryLabel()).size(18.0)
        ))));
    }

    private Widget switchRow(Supplier<IconDataI> icon, Supplier<Color> color,
                             String title, boolean value, java.util.function.Consumer<Boolean> onChanged) {
        return Padding(EdgeInsets_symmetric().horizontal(14.0).vertical(8.0).build())
                .child(Row().crossAxisAlignment(CrossAxisAlignment.center).children(List.of(
                        WalletKit.iconTile(icon.get(), color.get(), 32.0),
                        SizedBox().width(12.0),
                        Expanded().child(Text(title).style(WalletPalette.rowTitle())),
                        CupertinoSwitch(value, v -> onChanged.accept(v)).activeColor(WalletPalette.green())
                )));
    }

    private Widget chevronRow(Supplier<IconDataI> icon, Supplier<Color> color, String title) {
        return GestureDetector().onTap(() -> {}).child(Padding(EdgeInsets_symmetric().horizontal(14.0).vertical(10.0).build())
                .child(Row().crossAxisAlignment(CrossAxisAlignment.center).children(List.of(
                        WalletKit.iconTile(icon.get(), color.get(), 32.0),
                        SizedBox().width(12.0),
                        Expanded().child(Text(title).style(WalletPalette.rowTitle())),
                        Icon(CupertinoIcons.chevron_right()).color(WalletPalette.secondaryLabel()).size(18.0)
                ))));
    }
}
