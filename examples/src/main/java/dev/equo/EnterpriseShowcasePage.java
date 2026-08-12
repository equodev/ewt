package dev.equo;

import dev.equo.ewt.*;

import java.util.List;

import static dev.equo.ewt.EWT.*;

/**
 * Enterprise widget smoke-test for the web showcase.
 * Verifies that DataTable, NavigationBar, ExpansionTile, SearchBar and
 * CircleAvatar render correctly in the browser.
 *
 * <p>Desktop:
 * <pre>
 *   ./gradlew :examples:run -PuseLocal=true -PmainClass=dev.equo.EnterpriseShowcasePage
 * </pre>
 * <p>Web: select "Enterprise" in the EvolveSamples tab strip.
 */
public class EnterpriseShowcasePage {

    public static void main(String[] args) {
        App.runApp(Root::new);
    }

    static class Root extends SubStatelessWidget {
        @Override
        protected Widget build(BuildContext ctx) {
            return MaterialApp()
                    .title("Enterprise Widgets")
                    .theme(ThemeData()
                            .colorScheme(ColorScheme_fromSeed(Colors.indigo()))
                            .useMaterial3(true))
                    .home(new Page());
        }
    }

    public static class Page extends SubStatefulWidget {
        @Override
        protected State<Page> createState() {
            return new PageState();
        }
    }

    static class PageState extends SubState<Page> {

        int selectedNav = 0;
        boolean sectionExpanded = false;
        String searchQuery = "";

        @Override
        public Widget build(BuildContext ctx) {
            return Scaffold()
                    .appBar(AppBar()
                            .backgroundColor(Colors.indigo().shade700())
                            .foregroundColor(Colors.white())
                            .title(Text("Enterprise Widgets")))
                    .bottomNavigationBar(_navBar())
                    .body(SingleChildScrollView()
                            .child(Padding(EdgeInsets_all(16.0))
                                    .child(Column()
                                            .crossAxisAlignment(CrossAxisAlignment.stretch)
                                            .children(List.of(
                                                    _searchSection(),
                                                    SizedBox().height(16.0),
                                                    _avatarSection(),
                                                    SizedBox().height(16.0),
                                                    _expansionSection(),
                                                    SizedBox().height(16.0),
                                                    _tableSection(),
                                                    SizedBox().height(40.0)
                                            )))));
        }

        // ---- bottom navigation ----

        private Widget _navBar() {
            return NavigationBar()
                    .selectedIndex(selectedNav)
                    .onDestinationSelected(idx -> setState(() -> selectedNav = idx))
                    .addDestinations(
                            NavigationDestination(Icon(Icons.grid_view_rounded())).label("Tables"),
                            NavigationDestination(Icon(Icons.people_rounded())).label("Team"),
                            NavigationDestination(Icon(Icons.bar_chart_rounded())).label("Reports"),
                            NavigationDestination(Icon(Icons.settings_rounded())).label("Settings")
                    );
        }

        // ---- search ----

        private Widget _searchSection() {
            return Column()
                    .crossAxisAlignment(CrossAxisAlignment.stretch)
                    .children(List.of(
                            SearchBar()
                                    .hintText("Search enterprise data...")
                                    .leading(Icon(Icons.search()))
                                    .onChanged(v -> setState(() -> searchQuery = v)),
                            SizedBox().height(8.0),
                            Visibility(Text("Query: " + searchQuery)
                                    .style(TextStyle()
                                            .fontSize(12.0)
                                            .color(Colors.grey().shade600())))
                                    .visible(!searchQuery.isEmpty())
                    ));
        }

        // ---- avatars ----

        private Widget _avatarSection() {
            return Card().child(Padding(EdgeInsets_all(16.0)).child(
                    Column().crossAxisAlignment(CrossAxisAlignment.start).children(List.of(
                            Text("Team").style(TextStyle()
                                    .fontSize(16.0).fontWeight(FontWeight.bold())),
                            SizedBox().height(12.0),
                            Row().children(List.of(
                                    _avatar("A", Colors.indigo()),
                                    SizedBox().width(8.0),
                                    _avatar("B", Colors.teal()),
                                    SizedBox().width(8.0),
                                    _avatar("C", Colors.orange()),
                                    SizedBox().width(8.0),
                                    _avatar("D", Colors.pink()),
                                    SizedBox().width(8.0),
                                    CircleAvatar()
                                            .radius(22.0)
                                            .backgroundColor(Colors.grey().shade300())
                                            .child(Text("+5").style(TextStyle()
                                                    .fontSize(12.0)
                                                    .color(Colors.grey().shade700())))
                            ))
                    ))
            ));
        }

        private Widget _avatar(String initial, ColorI color) {
            return CircleAvatar()
                    .radius(22.0)
                    .backgroundColor(color)
                    .child(Text(initial).style(TextStyle()
                            .color(Colors.white())
                            .fontWeight(FontWeight.bold())));
        }

        // ---- expansion tile ----

        private Widget _expansionSection() {
            return Card().child(
                    ExpansionTile()
                            .leading(Icon(Icons.bar_chart_rounded())
                                    .color(Colors.indigo()))
                            .title(Text("Quarterly Report"))
                            .subtitle(Text("Q3 2026 — tap to expand"))
                            .onExpansionChanged(v -> setState(() -> sectionExpanded = v))
                            .children(List.of(
                                    ListTile()
                                            .title(Text("Revenue"))
                                            .trailing(Text("$1.2M").style(TextStyle()
                                                    .color(Colors.green()).fontWeight(FontWeight.bold()))),
                                    ListTile()
                                            .title(Text("Expenses"))
                                            .trailing(Text("$0.8M").style(TextStyle()
                                                    .color(Colors.red()))),
                                    ListTile()
                                            .title(Text("Profit"))
                                            .trailing(Text("$0.4M").style(TextStyle()
                                                    .color(Colors.teal()).fontWeight(FontWeight.bold())))
                            ))
            );
        }

        // ---- data table ----

        private Widget _tableSection() {
            return Card().child(
                    Padding(EdgeInsets_all(4.0)).child(
                            Column().crossAxisAlignment(CrossAxisAlignment.start).children(List.of(
                                    Padding(EdgeInsets_symmetric().horizontal(12.0).vertical(12.0))
                                            .child(Text("Users").style(TextStyle()
                                                    .fontSize(16.0).fontWeight(FontWeight.bold()))),
                                    SingleChildScrollView()
                                            .scrollDirection(Axis.horizontal)
                                            .child(DataTable(List.of(
                                                    DataColumn(Text("Name")),
                                                    DataColumn(Text("Role")),
                                                    DataColumn(Text("Department")),
                                                    DataColumn(Text("Status"))
                                            )).addRows(
                                                    _row("Alice Martin", "Admin", "Engineering", true),
                                                    _row("Bob Chen", "Editor", "Product", false),
                                                    _row("Carol White", "Viewer", "Design", true),
                                                    _row("David Kim", "Admin", "Sales", true),
                                                    _row("Eva Torres", "Editor", "Marketing", false)
                                            ))
                            ))
                    )
            );
        }

        private DataRowI _row(String name, String role, String dept, boolean active) {
            return DataRow().addCells(
                    DataCell(Row().children(List.of(
                            CircleAvatar()
                                    .radius(14.0)
                                    .backgroundColor(Colors.indigo().shade100())
                                    .child(Text(name.substring(0, 1)).style(TextStyle()
                                            .fontSize(11.0).color(Colors.indigo()))),
                            SizedBox().width(8.0),
                            Text(name)
                    ))),
                    DataCell(Text(role)),
                    DataCell(Text(dept)),
                    DataCell(Chip()
                            .label(Text(active ? "Active" : "Offline"))
                            .backgroundColor(active
                                    ? Colors.green().shade100()
                                    : Colors.grey().shade200()))
            );
        }
    }
}
