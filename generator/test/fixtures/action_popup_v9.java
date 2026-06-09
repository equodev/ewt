package dev.equo;

import static dev.equo.ewt.EWT.*;

import dev.equo.ewt.*;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class KnowledgeFloating {
  public static void main(String[] args) {
    App.runApp(() -> MaterialApp().home(new ActionPopupDemo()));
  }
}

class ActionPopup extends SubStatefulWidget {
  final SubStep subStep;
  final Runnable onClose;
  final Runnable onNext;
  final boolean isLastSubStep;

  public ActionPopup(SubStep subStep, Runnable onClose, Runnable onNext) {
    this.subStep = subStep;
    this.onClose = onClose;
    this.onNext = onNext;
    this.isLastSubStep = false;
  }

  @Override
  protected State<ActionPopup> createState() {
    return new ActionPopupState();
  }
}

class ActionPopupState extends SubState<ActionPopup> implements SingleTickerProviderStateMixin {
  private AnimationController _animationController;
  private Animation<Double> _animation;
  private boolean _isActionButtonHovered = false;

  @Override
  protected void initState() {
    super.initState();
    _animationController = AnimationController().vsync(this).duration(Duration().milliseconds(300));
    _animation = CurvedAnimation(_animationController, Curves.easeInOut());
    _animationController.forward();
  }

  @Override
  protected void dispose() {
    _animationController.dispose();
    super.dispose();
  }

  private String _buttonText() {
    if (widget().subStep.currentAction >= widget().subStep.actions.size() - 1) {
      return widget().isLastSubStep ? "Finish Step" : "Next Substep";
    }

    return "Next";
  }

  @Override
  protected Widget build(BuildContext context) {
    return AnimatedBuilder()
        .animation(_animation)
        .builder((bldContext, child) -> {
          return Transform_scale()
              .scale(_animation.value())
              .child(Opacity().opacity(_animation.value()).child(child));
        })
        .child(Material()
            .color(Colors.transparent())
            .child(Stack()
                .clipBehavior(Clip.none)
                .children(List.of(
                    Container()
                        .width(300)
                        .decoration(BoxDecoration()
                            .color(Color(0xFF3F51B5))
                            .borderRadius(BorderRadius_circular(8))
                            .boxShadow(List.of(BoxShadow()
                                .color(Colors.black26())
                                .blurRadius(10)
                                .offset(Offset(0, 4)))))
                        .child(Column()
                            .crossAxisAlignment(CrossAxisAlignment.start)
                            .mainAxisSize(MainAxisSize.min)
                            .children(List.of(
                                Padding()
                                    .padding(EdgeInsets_only().top(8).right(8))
                                    .child(
                                        Align()
                                            .alignment(Alignment.topRight())
                                            .child(
                                                IconButton()
                                                    .icon(
                                                        Icon(Icons.close())
                                                            .color(Colors.white70())
                                                            .size(18))
                                                    .onPressed(
                                                        () -> {
                                                          _animationController
                                                              .reverse()
                                                              .then(
                                                                  (_0) -> {
                                                                    widget()
                                                                        .onClose
                                                                        .run();
                                                                  });
                                                        })
                                                    .padding(EdgeInsets_all(4))
                                                    .constraints(BoxConstraints())
                                                    .iconSize(18)
                                                    .splashRadius(16))),
                                Padding()
                                    .padding(EdgeInsets_fromLTRB(16, 0, 16, 16))
                                    .child(
                                        Column()
                                            .crossAxisAlignment(CrossAxisAlignment.start)
                                            .children(
                                                Stream.of(
                                                        Text("Click Record icon to start")
                                                            .style(
                                                                TextStyle()
                                                                    .color(Colors.white())
                                                                    .fontSize(15)
                                                                    .fontWeight(FontWeight.bold())),
                                                        SizedBox().height(12),
                                                        RichText()
                                                            .text(
                                                                TextSpan()
                                                                    .style(
                                                                        TextStyle()
                                                                            .color(Colors.white())
                                                                            .fontSize(14))
                                                                    .children(
                                                                        List.of(
                                                                            TextSpan()
                                                                                .text(
                                                                                    widget()
                                                                                            .subStep
                                                                                            .actions
                                                                                            .get(
                                                                                                widget()
                                                                                                    .subStep
                                                                                                    .currentAction)
                                                                                            .split(
                                                                                                " ")
                                                                                            .subList(
                                                                                                0,
                                                                                                2)
                                                                                            .join(
                                                                                                " ")
                                                                                        + " ")
                                                                                .style(
                                                                                    TextStyle()
                                                                                        .fontWeight(
                                                                                            FontWeight
                                                                                                .bold())),
                                                                            TextSpan()
                                                                                .text(
                                                                                    widget()
                                                                                        .subStep
                                                                                        .actions
                                                                                        .get(
                                                                                            widget()
                                                                                                .subStep
                                                                                                .currentAction)
                                                                                        .split(" ")
                                                                                        .subList(2)
                                                                                        .join(
                                                                                            " "))))),
                                                        (widget().subStep.currentAction == 0)
                                                            ? Padding()
                                                                .padding(
                                                                    EdgeInsets_only()
                                                                        .top(16))
                                                                .child(
                                                                    Row()
                                                                        .mainAxisAlignment(
                                                                            MainAxisAlignment.start)
                                                                        .children(
                                                                            List.of(
                                                                                MouseRegion()
                                                                                    .onEnter(
                                                                                        (_1) ->
                                                                                            setState(
                                                                                                () ->
                                                                                                    _isActionButtonHovered =
                                                                                                        true))
                                                                                    .onExit(
                                                                                        (_2) ->
                                                                                            setState(
                                                                                                () ->
                                                                                                    _isActionButtonHovered =
                                                                                                        false))
                                                                                    .child(
                                                                                        Container()
                                                                                            .padding(
                                                                                                EdgeInsets_all(
                                                                                                    8))
                                                                                            .decoration(
                                                                                                BoxDecoration()
                                                                                                    .color(
                                                                                                        _isActionButtonHovered
                                                                                                            ? Colors
                                                                                                                .white()
                                                                                                                .withOpacity(
                                                                                                                    0.2)
                                                                                                            : Colors
                                                                                                                .transparent())
                                                                                                    .borderRadius(
                                                                                                        BorderRadius_circular(
                                                                                                            4)))
                                                                                            .child(
                                                                                                Row()
                                                                                                    .children(
                                                                                                        List
                                                                                                            .of(
                                                                                                                Icon(
                                                                                                                        Icons
                                                                                                                            .play_circle_outline())
                                                                                                                    .color(
                                                                                                                        Colors
                                                                                                                            .white())
                                                                                                                    .size(
                                                                                                                        20),
                                                                                                                SizedBox()
                                                                                                                    .width(
                                                                                                                        8),
                                                                                                                Text(
                                                                                                                        "Start"
                                                                                                                            + " Recording")
                                                                                                                    .style(
                                                                                                                        TextStyle()
                                                                                                                            .color(
                                                                                                                                Colors
                                                                                                                                    .white())
                                                                                                                            .fontSize(
                                                                                                                                13)))))))))
                                                            : null)
                                                    .filter(Objects::nonNull)
                                                    .toList())),
                                Container().height(1).color(Colors.white().withOpacity(0.2)),
                                Padding()
                                    .padding(EdgeInsets_all(12))
                                    .child(
                                        Row()
                                            .mainAxisAlignment(MainAxisAlignment.spaceBetween)
                                            .children(
                                                List.of(
                                                    Text(
                                                            "" + widget().subStep.currentAction + 1
                                                                + "/"
                                                                + widget()
                                                                    .subStep
                                                                    .actions
                                                                    .size() + "")
                                                        .style(
                                                            TextStyle()
                                                                .color(Colors.white70())
                                                                .fontSize(12)),
                                                    OutlinedButton()
                                                        .onPressed(
                                                            () -> {
                                                              if (widget().subStep.currentAction
                                                                  >= widget()
                                                                          .subStep
                                                                          .actions
                                                                          .size()
                                                                      - 1) {
                                                                _animationController
                                                                    .reverse()
                                                                    .then(
                                                                        (_3) -> {
                                                                          widget()
                                                                              .onNext
                                                                              .run();
                                                                        });
                                                              } else {
                                                                setState(
                                                                    () -> {
                                                                      widget()
                                                                          .subStep
                                                                          .currentAction++;
                                                                    });
                                                              }
                                                            })
                                                        .style(
                                                            OutlinedButton.styleFrom()
                                                                .backgroundColor(Color(0xFF3F51B5))
                                                                .side(
                                                                    BorderSide()
                                                                        .color(Colors.white())
                                                                        .width(1))
                                                                .shape(
                                                                    RoundedRectangleBorder()
                                                                        .borderRadius(
                                                                            BorderRadius_circular(
                                                                                4)))
                                                                .padding(
                                                                    EdgeInsets_symmetric()
                                                                        .horizontal(16)
                                                                        .vertical(8)))
                                                        .child(
                                                            Text(_buttonText())
                                                                .style(
                                                                    TextStyle()
                                                                        .color(Colors.white())
                                                                        .fontWeight(
                                                                            FontWeight.bold())
                                                                        .fontSize(13))))))))),
                    Positioned()
                        .left(-8)
                        .top(20)
                        .child(Container()
                            .width(0)
                            .height(0)
                            .decoration(BoxDecoration().color(Colors.transparent()))
                            .child(CustomPaint()
                                .size(Size(10, 15))
                                .painter(new TrianglePainter())))))));
  }
}

class TrianglePainter extends SubCustomPainter {
  @Override
  protected void paint(Canvas canvas, Size size) {
    final var paint = Paint().color(Color(0xFF3F51B5)).style(PaintingStyle.fill);
    final var path = Path()
        .moveTo(size.width(), size.height() / 2)
        .lineTo(0, 0)
        .lineTo(0, size.height())
        .close();
    canvas.drawPath(path, paint);
  }

  @Override
  protected boolean shouldRepaint(CustomPainter oldDelegate) {
    return false;
  }
}

class ActionPopupDemo extends SubStatefulWidget {
  public ActionPopupDemo() {}

  @Override
  protected State<ActionPopupDemo> createState() {
    return new ActionPopupDemoState();
  }
}

class ActionPopupDemoState extends SubState<ActionPopupDemo> {
  final List<Step> steps = KnowledgeHubData.getSteps();
  boolean isPopupVisible = true;
  int currentStep = 0;
  int currentSubStep = 0;

  void closePopup() {
    setState(() -> {
      isPopupVisible = false;
    });
  }

  void nextAction() {
    setState(() -> {
      final var currentSubStepObj = steps.get(currentStep).subSteps.get(currentSubStep);
      currentSubStepObj.isCompleted = true;
      if (currentSubStep < steps.get(currentStep).subSteps.size() - 1) {
        currentSubStep++;
      } else {
        if (currentStep < steps.size() - 1) {
          currentStep++;
          currentSubStep = 0;
        }
      }

      isPopupVisible = true;
    });
  }

  void showPopup() {
    setState(() -> {
      currentStep = 0;
      currentSubStep = 0;
      steps.get(0).subSteps.get(0).currentAction = 0;
      isPopupVisible = true;
    });
  }

  @Override
  protected Widget build(BuildContext context) {
    return Scaffold()
        .appBar(AppBar().title(Text("Action Popup Demo")).backgroundColor(Color(0xFF3F51B5)))
        .body(Stack()
            .children(Stream.of(
                    Center()
                        .child(Column()
                            .mainAxisAlignment(MainAxisAlignment.center)
                            .children(List.of(
                                Text("Step " + currentStep + 1 + ": " + steps.get(currentStep).title
                                        + "")
                                    .style(TextStyle().fontSize(18).fontWeight(FontWeight.bold())),
                                SizedBox().height(8),
                                Text("Substep: "
                                        + steps.get(currentStep).subSteps.get(currentSubStep).text
                                        + "")
                                    .style(TextStyle().fontSize(16)),
                                SizedBox().height(24),
                                ElevatedButton()
                                    .onPressed(isPopupVisible ? this::closePopup : this::showPopup)
                                    .style(ElevatedButton.styleFrom()
                                        .backgroundColor(Color(0xFF3F51B5)))
                                    .child(Text(isPopupVisible ? "Hide Popup" : "Show Popup")),
                                SizedBox().height(100),
                                Container()
                                    .padding(EdgeInsets_all(8))
                                    .decoration(BoxDecoration()
                                        .border(Border_all().color(Color(0xFF3F51B5)))
                                        .borderRadius(BorderRadius_circular(4)))
                                    .child(Icon(Icons.play_circle_outline())
                                        .color(Color(0xFF3F51B5))
                                        .size(32))))),
                    (isPopupVisible)
                        ? Positioned()
                            .top(100)
                            .left(50)
                            .child(new ActionPopup(
                                steps.get(currentStep).subSteps.get(currentSubStep),
                                this::closePopup,
                                this::nextAction,
                                currentSubStep
                                    == steps.get(currentStep).subSteps.size() - 1))
                        : null)
                .filter(Objects::nonNull)
                .toList()));
  }
}
