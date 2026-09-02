package dev.equo.material.screens;

import java.util.List;
import java.util.function.Supplier;
import dev.equo.ewt.*;
import static dev.equo.ewt.EWT.*;

import dev.equo.material.WalletKit;
import dev.equo.material.WalletPalette;

/**
 * Settings tab: a profile header, grouped rows with Material Switch toggles
 * (Face ID, notifications) and chevron rows, plus a log-out action. Same rows as
 * the Cupertino twin, expressed as ListTiles inside Cards.
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
        return Scaffold()
                .backgroundColor(WalletPalette.background())
                .appBar(AppBar()
                        .backgroundColor(WalletPalette.bar())
                        .elevation(0.0)
                        .title(Text("Settings").style(WalletPalette.navTitle())))
                .body(SafeArea().child(SingleChildScrollView().child(Column().children(List.of(
                        SizedBox().height(14.0),
                        profile(),
                        WalletKit.header("Security"),
                        WalletKit.card(Column().children(List.of(
                                switchRow(Icons::lock_outline, WalletPalette::blue,
                                        "Face ID", faceId, v -> setState(() -> faceId = v)),
                                WalletKit.divider(),
                                chevronRow(Icons::pin, WalletPalette::indigo, "Change PIN")
                        ))),
                        WalletKit.header("Notifications"),
                        WalletKit.card(Column().children(List.of(
                                switchRow(Icons::notifications_outlined, WalletPalette::orange,
                                        "Push notifications", push, v -> setState(() -> push = v)),
                                WalletKit.divider(),
                                switchRow(Icons::payments, WalletPalette::green,
                                        "Transaction alerts", txAlerts, v -> setState(() -> txAlerts = v))
                        ))),
                        SizedBox().height(18.0),
                        WalletKit.card(InkWell().onTap(() -> {}).child(
                                Padding(EdgeInsets_symmetric().vertical(16.0).build())
                                        .child(Center().child(Text("Log Out")
                                                .style(TextStyle().fontSize(16.0)
                                                        .fontWeight(FontWeight.w500())
                                                        .color(WalletPalette.red())))))),
                        SizedBox().height(24.0)
                )))));
    }

    private Widget profile() {
        return WalletKit.card(ListTile()
                .onTap(() -> {})
                .contentPadding(EdgeInsets_symmetric().horizontal(16.0).vertical(8.0).build())
                .leading(CircleAvatar()
                        .radius(28.0)
                        .backgroundColor(WalletPalette.indigo())
                        .child(Text("EG").style(TextStyle().fontSize(20.0)
                                .fontWeight(FontWeight.w500()).color(WalletPalette.background()))))
                .title(Text("Esteban G.").style(TextStyle().fontSize(18.0)
                        .fontWeight(FontWeight.w500()).color(WalletPalette.label())))
                .subtitle(Text("esteban@equo.dev").style(WalletPalette.rowSub()))
                .trailing(Icon(Icons.chevron_right()).color(WalletPalette.secondaryLabel()).size(22.0)));
    }

    private Widget switchRow(Supplier<IconDataI> icon, Supplier<Color> color,
                             String title, boolean value, java.util.function.Consumer<Boolean> onChanged) {
        return ListTile()
                .leading(WalletKit.iconTile(icon.get(), color.get(), 32.0))
                .title(Text(title).style(WalletPalette.rowTitle()))
                .trailing(Switch(value).onChanged(v -> onChanged.accept(v))
                        .activeThumbColor(WalletPalette.background())
                        .activeTrackColor(WalletPalette.green()));
    }

    private Widget chevronRow(Supplier<IconDataI> icon, Supplier<Color> color, String title) {
        return ListTile()
                .onTap(() -> {})
                .leading(WalletKit.iconTile(icon.get(), color.get(), 32.0))
                .title(Text(title).style(WalletPalette.rowTitle()))
                .trailing(Icon(Icons.chevron_right()).color(WalletPalette.secondaryLabel()).size(22.0));
    }
}
