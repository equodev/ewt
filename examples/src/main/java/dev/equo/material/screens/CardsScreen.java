package dev.equo.material.screens;

import java.util.List;
import java.util.function.Supplier;
import dev.equo.ewt.*;
import static dev.equo.ewt.EWT.*;

import dev.equo.material.WalletKit;
import dev.equo.material.WalletPalette;

/**
 * Cards tab: a payment-card face plus its controls — a Material Switch to freeze
 * the card and toggle online payments, and a Material Slider for the monthly
 * spending limit (updates live). Same state and behaviour as the Cupertino twin;
 * the switches and the slider are the widgets that look most different.
 */
public class CardsScreen extends SubStatefulWidget {
    @Override
    protected State<CardsScreen> createState() {
        return new CardsState();
    }
}

class CardsState extends SubState<CardsScreen> {

    private boolean frozen = false;
    private boolean online = true;
    private double limit = 2000.0;

    @Override
    public Widget build(BuildContext context) {
        return Scaffold()
                .backgroundColor(WalletPalette.background())
                .appBar(AppBar()
                        .backgroundColor(WalletPalette.bar())
                        .elevation(0.0)
                        .title(Text("Cards").style(WalletPalette.navTitle())))
                .body(SafeArea().child(SingleChildScrollView().child(Column().children(List.of(
                        SizedBox().height(12.0),
                        cardFace(),
                        WalletKit.header("Card controls"),
                        WalletKit.card(Column().children(List.of(
                                controlRow(Icons::ac_unit, WalletPalette::teal,
                                        "Freeze card", frozen, v -> setState(() -> frozen = v)),
                                WalletKit.divider(),
                                controlRow(Icons::wifi, WalletPalette::blue,
                                        "Online payments", online, v -> setState(() -> online = v))
                        ))),
                        WalletKit.header("Monthly spending limit"),
                        limitCard(),
                        SizedBox().height(24.0)
                )))));
    }

    private Widget cardFace() {
        double opacity = frozen ? 0.5 : 1.0;
        return Padding(EdgeInsets_symmetric().horizontal(16.0).build()).child(Opacity(opacity).child(
                Container()
                        .height(200.0)
                        .decoration(BoxDecoration()
                                .color(WalletPalette.cardViolet())
                                .borderRadius(BorderRadius_circular(16.0))
                                .boxShadow(List.of(BoxShadow()
                                        .color(Color_fromRGBO(0, 0, 0, 0.4).build())
                                        .blurRadius(18.0).offset(Offset(0.0, 6.0)))))
                        .padding(EdgeInsets_all(22.0))
                        .child(Column().crossAxisAlignment(CrossAxisAlignment.start).children(List.of(
                                Row().children(List.of(
                                        Text("EWT Bank").style(TextStyle().fontSize(15.0)
                                                .fontWeight(FontWeight.w500()).color(WalletPalette.onCardMuted())),
                                        Expanded().child(Align().alignment(Alignment.centerRight()).child(
                                                Text("VISA").style(TextStyle().fontSize(18.0)
                                                        .fontWeight(FontWeight.w700()).color(Colors.white()))))
                                )),
                                Expanded().child(SizedBox()),
                                Text("4242  4242  4242  4242").style(TextStyle().fontSize(19.0)
                                        .letterSpacing(2.0).color(Colors.white())),
                                SizedBox().height(14.0),
                                Row().children(List.of(
                                        Text("ESTEBAN G.").style(TextStyle().fontSize(13.0)
                                                .letterSpacing(1.0).color(WalletPalette.onCardMuted())),
                                        Expanded().child(Align().alignment(Alignment.centerRight()).child(
                                                Text("09/27").style(TextStyle().fontSize(13.0)
                                                        .color(WalletPalette.onCardMuted()))))
                                ))
                        )))));
    }

    private Widget controlRow(Supplier<IconDataI> icon, Supplier<Color> color,
                              String title, boolean value, java.util.function.Consumer<Boolean> onChanged) {
        return ListTile()
                .leading(WalletKit.iconTile(icon.get(), color.get(), 34.0))
                .title(Text(title).style(WalletPalette.rowTitle()))
                .trailing(Switch(value).onChanged(v -> onChanged.accept(v))
                        .activeThumbColor(WalletPalette.background())
                        .activeTrackColor(WalletPalette.green()));
    }

    private Widget limitCard() {
        return WalletKit.card(Padding(EdgeInsets_all(16.0)).child(Column().children(List.of(
                Row().children(List.of(
                        Text("$" + (int) limit).style(TextStyle().fontSize(28.0)
                                .fontWeight(FontWeight.w400()).color(WalletPalette.label())),
                        Expanded().child(Align().alignment(Alignment.centerRight()).child(
                                Text("/ month").style(WalletPalette.rowSub())))
                )),
                SizedBox().height(6.0),
                // Material's slider shows a value label above the thumb while dragging;
                // the Cupertino one has no label at all.
                Slider(limit)
                        .onChanged(v -> setState(() -> limit = v))
                        .min(500.0).max(5000.0).divisions(18)
                        .label("$" + (int) limit)
                        .activeColor(WalletPalette.primary())
                        .inactiveColor(WalletPalette.card2())
        ))));
    }
}
