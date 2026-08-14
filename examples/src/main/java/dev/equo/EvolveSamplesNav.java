package dev.equo;

import dev.equo.ewt.*;

import java.util.List;
import java.util.function.IntConsumer;

import static dev.equo.ewt.EWT.*;

/**
 * Flutter-rendered tab strip for the web showcase window.
 * Renders 5 tabs; calls {@code onTabSelected} (Java lambda) when the user
 * taps a tab so the caller can switch the content EwtWidget region.
 */
public class EvolveSamplesNav extends SubStatefulWidget {

    final IntConsumer onTabSelected;

    public EvolveSamplesNav(IntConsumer onTabSelected) {
        this.onTabSelected = onTabSelected;
    }

    @Override
    protected State<EvolveSamplesNav> createState() {
        return new NavState(onTabSelected);
    }

    static class NavState extends SubState<EvolveSamplesNav> {

        int currentTab = 0;
        private final IntConsumer onTabSelected;

        NavState(IntConsumer onTabSelected) {
            this.onTabSelected = onTabSelected;
        }

        @Override
        public Widget build(BuildContext ctx) {
            return Material().color(Color(0xFF1B2A35)).child(
                    Row().children(List.of(
                            _tab(0, Icons.hub_rounded(), "Showcase"),
                            _tab(1, Icons.play_circle_rounded(), "Animations"),
                            _tab(2, Icons.swap_horiz_rounded(), "Slide"),
                            _tab(3, Icons.phone_iphone_rounded(), "Cupertino"),
                            _tab(4, Icons.code_rounded(), "IDE")
                    ))
            );
        }

        private Widget _tab(int idx, IconDataI icon, String label) {
            boolean active = currentTab == idx;
            return Expanded().child(
                    GestureDetector().onTap(() -> {
                        setState(() -> currentTab = idx);
                        onTabSelected.accept(idx);
                    }).child(
                            Container()
                                    .color(active ? Color(0xFF2E4A5C) : Colors.transparent())
                                    .padding(EdgeInsets_symmetric().vertical(10.0).horizontal(4.0))
                                    .child(Column()
                                            .mainAxisSize(MainAxisSize.min)
                                            .children(List.of(
                                                    Icon(icon)
                                                            .color(active ? Colors.cyan().shade300() : Colors.white38())
                                                            .size(22.0),
                                                    SizedBox().height(3.0),
                                                    Text(label).style(TextStyle()
                                                            .fontSize(10.0)
                                                            .fontWeight(active ? FontWeight.bold() : FontWeight.normal())
                                                            .color(active ? Colors.white() : Colors.white38()))
                                            ))
                    ))
            );
        }
    }
}
