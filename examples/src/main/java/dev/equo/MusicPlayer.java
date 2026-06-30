package dev.equo;

import dev.equo.ewt.*;
import static dev.equo.ewt.EWT.*;
import java.util.List;

/**
 * "Now Playing" music player demo: a layered, dark UI built entirely with
 * existing widgets. Play/pause, like, shuffle, repeat and track switching are
 * driven by setState. No images are used; each track is represented by a tinted
 * album tile so the demo stays self-contained.
 */
public class MusicPlayer {

  public static void main(String[] args) {
    App.runApp(MusicApp::new);
  }

  static class MusicApp extends SubStatelessWidget {
    @Override
    protected Widget build(BuildContext context) {
      return MaterialApp()
          .title("Now Playing")
          .theme(ThemeData()
              .brightness(Brightness.dark)
              .colorScheme(ColorScheme_fromSeed(Colors.deepPurple()))
              .scaffoldBackgroundColor(Color(0xFF101015))
              .useMaterial3(true))
          .home(new NowPlayingPage());
    }
  }

  static class NowPlayingPage extends SubStatefulWidget {
    @Override
    protected NowPlayingState createState() {
      return new NowPlayingState();
    }
  }

  static class NowPlayingState extends SubState<NowPlayingPage> {
    // Static playlist; index drives the visible track.
    private static final String[] _titles = {"Midnight City", "Holocene", "Nightcall", "Strobe"};
    private static final String[] _artists = {"M83", "Bon Iver", "Kavinsky", "deadmau5"};
    private static final int[] _durations = {244, 339, 258, 634}; // seconds

    private int _track = 0;
    private boolean _playing = false;
    private boolean _liked = false;
    private boolean _shuffle = false;
    private boolean _repeat = false;
    private double _progress = 0.3;

    private void _togglePlay() {
      setState(() -> _playing = !_playing);
    }

    private void _next() {
      setState(() -> {
        _track = (_track + 1) % _titles.length;
        _progress = 0.0;
        _liked = false;
      });
    }

    private void _prev() {
      setState(() -> {
        _track = (_track - 1 + _titles.length) % _titles.length;
        _progress = 0.0;
        _liked = false;
      });
    }

    // Accent color is resolved inside build() so the native color object is
    // created within the build phase (storing it as a field yields a stale id).
    private MaterialColor _accent() {
      return switch (_track) {
        case 1 -> Colors.teal();
        case 2 -> Colors.purple();
        case 3 -> Colors.blue();
        default -> Colors.indigo();
      };
    }

    private String _time(int seconds) {
      int m = seconds / 60;
      int s = seconds % 60;
      return m + ":" + (s < 10 ? "0" + s : Integer.toString(s));
    }

    @Override
    public Widget build(BuildContext context) {
      MaterialColor accent = _accent();
      int total = _durations[_track];
      int elapsed = (int) (_progress * total);

      return Scaffold()
          .body(SafeArea()
              .child(Padding(EdgeInsets_symmetric().horizontal(24.0))
                  .child(Column()
                      .children(List.of(

                          // ── Top bar ───────────────────────────────────────
                          Row()
                              .mainAxisAlignment(MainAxisAlignment.spaceBetween)
                              .children(List.of(
                                  IconButton()
                                      .icon(Icon(Icons.expand_more()))
                                      .color(Colors.white())
                                      .onPressed(() -> {}),
                                  Text("NOW PLAYING")
                                      .style(TextStyle()
                                          .fontSize(12.0)
                                          .fontWeight(FontWeight.w600())
                                          .color(Colors.white70())),
                                  IconButton()
                                      .icon(Icon(Icons.more_horiz()))
                                      .color(Colors.white())
                                      .onPressed(() -> {})
                              )),

                          // ── Album art ─────────────────────────────────────
                          Expanded().child(Center().child(Container()
                              .width(300.0)
                              .height(300.0)
                              .decoration(BoxDecoration()
                                  .color(accent)
                                  .borderRadius(BorderRadius_circular(28.0))
                                  .boxShadow(List.of(
                                      BoxShadow()
                                          .color(Color_fromRGBO(0, 0, 0, 0.45))
                                          .blurRadius(40.0)
                                          .offset(Offset(0.0, 20.0)))))
                              .alignment(Alignment.center())
                              .child(Icon(Icons.album())
                                  .size(140.0)
                                  .color(Colors.white24())))),

                          // ── Title + like ──────────────────────────────────
                          Row()
                              .mainAxisAlignment(MainAxisAlignment.spaceBetween)
                              .crossAxisAlignment(CrossAxisAlignment.center)
                              .children(List.of(
                                  Expanded().child(Column()
                                      .crossAxisAlignment(CrossAxisAlignment.start)
                                      .children(List.of(
                                          Text(_titles[_track])
                                              .maxLines(1)
                                              .style(TextStyle()
                                                  .fontSize(26.0)
                                                  .fontWeight(FontWeight.bold())
                                                  .color(Colors.white())),
                                          SizedBox().height(6.0),
                                          Text(_artists[_track])
                                              .style(TextStyle()
                                                  .fontSize(16.0)
                                                  .color(Colors.white70()))
                                      ))),
                                  IconButton()
                                      .icon(Icon(_liked ? Icons.favorite() : Icons.favorite_border()))
                                      .color(_liked ? Colors.pinkAccent() : Colors.white())
                                      .iconSize(28.0)
                                      .onPressed(() -> setState(() -> _liked = !_liked))
                              )),
                          SizedBox().height(28.0),

                          // ── Progress bar ──────────────────────────────────
                          LinearProgressIndicator()
                              .value(_progress)
                              .minHeight(5.0)
                              .borderRadius(BorderRadius_circular(3.0))
                              .color(Colors.white())
                              .backgroundColor(Colors.white24()),
                          SizedBox().height(8.0),
                          Row()
                              .mainAxisAlignment(MainAxisAlignment.spaceBetween)
                              .children(List.of(
                                  Text(_time(elapsed))
                                      .style(TextStyle().fontSize(12.0).color(Colors.white54())),
                                  Text(_time(total))
                                      .style(TextStyle().fontSize(12.0).color(Colors.white54()))
                              )),
                          SizedBox().height(20.0),

                          // ── Transport controls ────────────────────────────
                          Row()
                              .mainAxisAlignment(MainAxisAlignment.spaceBetween)
                              .crossAxisAlignment(CrossAxisAlignment.center)
                              .children(List.of(
                                  IconButton()
                                      .icon(Icon(Icons.shuffle()))
                                      .color(_shuffle ? Colors.deepPurpleAccent() : Colors.white54())
                                      .iconSize(24.0)
                                      .onPressed(() -> setState(() -> _shuffle = !_shuffle)),
                                  IconButton()
                                      .icon(Icon(Icons.skip_previous()))
                                      .color(Colors.white())
                                      .iconSize(42.0)
                                      .onPressed(this::_prev),
                                  _playButton(),
                                  IconButton()
                                      .icon(Icon(Icons.skip_next()))
                                      .color(Colors.white())
                                      .iconSize(42.0)
                                      .onPressed(this::_next),
                                  IconButton()
                                      .icon(Icon(Icons.repeat()))
                                      .color(_repeat ? Colors.deepPurpleAccent() : Colors.white54())
                                      .iconSize(24.0)
                                      .onPressed(() -> setState(() -> _repeat = !_repeat))
                              )),
                          SizedBox().height(28.0)

                      )))));
    }

    private Widget _playButton() {
      return GestureDetector()
          .onTap(this::_togglePlay)
          .child(Container()
              .width(76.0)
              .height(76.0)
              .decoration(BoxDecoration()
                  .color(Colors.white())
                  .shape(BoxShape.circle)
                  .boxShadow(List.of(
                      BoxShadow()
                          .color(Color_fromRGBO(0, 0, 0, 0.3))
                          .blurRadius(16.0)
                          .offset(Offset(0.0, 6.0)))))
              .alignment(Alignment.center())
              .child(Icon(_playing ? Icons.pause() : Icons.play_arrow())
                  .size(38.0)
                  .color(Colors.black())));
    }
  }
}
