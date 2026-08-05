package dev.equo.gallery;

import java.util.List;

import dev.equo.ewt.*;

import static dev.equo.ewt.EWT.*;

/**
 * Interactive gallery for Cupertino widgets — both the new additions and the
 * established controls. Every interactive widget is wired to state so toggling
 * one updates the labels (the Flutter→C→Java→setState→rebuild round trip).
 *
 *   ./gradlew :examples:run -PuseLocal=true -PmainClass=dev.equo.gallery.CupertinoGallery
 */
public class CupertinoGallery {

  public static void main(String[] args) {
    App.runApp(MyApp::new);
  }

  static class MyApp extends SubStatelessWidget {
    @Override
    protected Widget build(BuildContext ctx) {
      return CupertinoApp()
          .title("EWT — Cupertino")
          .home(new GalleryPage());
    }
  }

  static class GalleryPage extends SubStatefulWidget {
    @Override
    protected State<GalleryPage> createState() {
      return new GalleryState();
    }
  }

  static class GalleryState extends SubState<GalleryPage> {
    boolean _checkA = true;
    boolean _checkB = false;
    boolean _switchOn = true;
    double _sliderVal = 0.5;
    int _tabIndex = 0;

    @Override
    public Widget build(BuildContext ctx) {
      return CupertinoPageScaffold()
          .navigationBar(CupertinoNavigationBar()
              .leading(CupertinoNavigationBarBackButton()
                  .color(Color(0xFF007AFF))
                  .onPressed(() -> {}))
              .middle(Text("Cupertino Widgets")))
          .child(SafeArea().child(
              SingleChildScrollView().child(
                  Padding(EdgeInsets_symmetric().horizontal(16.0).vertical(20.0)).child(
                      Column()
                          .crossAxisAlignment(CrossAxisAlignment.start)
                          .children(List.of(

                              // ── CupertinoTextField ──────────────────────────
                              _sectionLabel("CupertinoTextField"),
                              CupertinoTextField()
                                  .placeholder("Search..."),
                              SizedBox().height(8.0),
                              CupertinoTextField_borderless()
                                  .placeholder("Borderless variant"),

                              SizedBox().height(24.0),

                              // ── CupertinoCheckbox ───────────────────────────
                              _sectionLabel("CupertinoCheckbox"),
                              Row().children(List.of(
                                  CupertinoCheckbox(_checkA)
                                      .onChanged(v -> setState(() -> _checkA = v)),
                                  SizedBox().width(8.0),
                                  Text("Option A  "),
                                  SizedBox().width(24.0),
                                  CupertinoCheckbox(_checkB)
                                      .onChanged(v -> setState(() -> _checkB = v)),
                                  SizedBox().width(8.0),
                                  Text("Option B")
                              )),

                              SizedBox().height(24.0),

                              // ── CupertinoExpansionTile ──────────────────────
                              _sectionLabel("CupertinoExpansionTile"),
                              CupertinoExpansionTile(
                                  Text("Tap to expand"),
                                  Padding(EdgeInsets_all(12.0)).child(
                                      Text("Any widget can go inside — lists, forms, images.")
                                  )
                              ),

                              SizedBox().height(24.0),

                              // ── CupertinoContextMenu ────────────────────────
                              _sectionLabel("CupertinoContextMenu  (long-press the card)"),
                              Center().child(
                                  CupertinoContextMenu(
                                      List.of(
                                          CupertinoContextMenuAction(
                                                  Row().mainAxisSize(MainAxisSize.min).children(List.of(
                                                      Icon(Icons.copy_rounded()).size(18.0),
                                                      SizedBox().width(8.0),
                                                      Text("Copy"))))
                                              .onPressed(() -> {}),
                                          CupertinoContextMenuAction(
                                                  Row().mainAxisSize(MainAxisSize.min).children(List.of(
                                                      Icon(Icons.share_rounded()).size(18.0),
                                                      SizedBox().width(8.0),
                                                      Text("Share"))))
                                              .onPressed(() -> {}),
                                          CupertinoContextMenuAction(
                                                  Row().mainAxisSize(MainAxisSize.min).children(List.of(
                                                      Icon(Icons.delete_rounded()).size(18.0),
                                                      SizedBox().width(8.0),
                                                      Text("Delete"))))
                                              .isDestructiveAction(true)
                                              .onPressed(() -> {})
                                      ),
                                      Container()
                                          .width(140.0).height(100.0)
                                          .decoration(BoxDecoration()
                                              .color(Color(0xFF007AFF))
                                              .borderRadius(BorderRadius_circular(14.0)))
                                          .child(Center().child(
                                              Column()
                                                  .mainAxisSize(MainAxisSize.min)
                                                  .children(List.of(
                                                      Icon(Icons.touch_app_rounded())
                                                          .color(Colors.white()).size(28.0),
                                                      SizedBox().height(4.0),
                                                      Text("Long press").style(TextStyle()
                                                          .color(Colors.white())
                                                          .fontSize(12.0))
                                                  ))))
                                  )
                              ),

                              SizedBox().height(24.0),

                              // ── CupertinoTabBar ─────────────────────────────
                              _sectionLabel("CupertinoTabBar"),
                              CupertinoTabBar(List.of(
                                  BottomNavigationBarItem(Icon(Icons.home_rounded()))
                                      .label("Home"),
                                  BottomNavigationBarItem(Icon(Icons.search_rounded()))
                                      .label("Search"),
                                  BottomNavigationBarItem(Icon(Icons.person_rounded()))
                                      .label("Profile")
                              ))
                                  .currentIndex(_tabIndex)
                                  .onTap(i -> setState(() -> _tabIndex = i)),

                              SizedBox().height(24.0),

                              // ── CupertinoTimerPicker ────────────────────────
                              _sectionLabel("CupertinoTimerPicker"),
                              SizedBox().height(160.0).child(
                                  CupertinoTimerPicker()
                                      .initialTimerDuration(Duration().minutes(5))
                                      .onTimerDurationChanged(d -> {})
                              ),

                              SizedBox().height(24.0),

                              // ── Existing: switch + slider + search ──────────
                              _sectionLabel("CupertinoSwitch / CupertinoSlider / CupertinoSearchTextField"),
                              CupertinoListSection_insetGrouped().children(List.of(
                                  CupertinoListTile(Text("Notifications"))
                                      .trailing(CupertinoSwitch(_switchOn,
                                          v -> setState(() -> _switchOn = v))),
                                  CupertinoListTile(Text("Volume"))
                                      .subtitle(CupertinoSlider(_sliderVal,
                                          v -> setState(() -> _sliderVal = v))
                                          .min(0.0).max(1.0))
                              )),
                              SizedBox().height(12.0),
                              CupertinoSearchTextField(),

                              SizedBox().height(40.0)
                          ))
                  )
              )
          ));
    }

    private static Widget _sectionLabel(String title) {
      return Padding(EdgeInsets_only().bottom(8.0))
          .child(Text(title).style(TextStyle()
              .fontSize(12.0)
              .fontWeight(FontWeight.w600())
              .color(Color(0xFF8E8E93))
              .letterSpacing(0.3)));
    }
  }
}
