package dev.equo;

import static dev.equo.ewt.EWT.*;
import dev.equo.ewt.*;
import java.util.List;
import java.util.Map;
import java.util.Collections;
import java.util.stream.Stream;
import java.util.Objects;

public class KnowledgeView {
public static void main(String[] args) {
App.runApp(() -> new MyApp());
}

}
class MyApp extends SubStatelessWidget {
public MyApp() {
}
@Override protected  Widget build(BuildContext context) {
return MaterialApp()
.title("Katalon Knowledge Hub")
.theme(ThemeData()
.primarySwatch(Colors.blue())
.primaryColor(Color(0xFF3F51B5))
.scaffoldBackgroundColor(Colors.white())
.fontFamily("Roboto")
.dividerColor(Colors.grey().shade200()))
.home(new KnowledgeHubScreen());
}
}
class SubStep {
final String text;
boolean isCompleted;
final String progress;
public SubStep(String text, String progress) {
this.text = text;
this.isCompleted = false;
this.progress = progress;
}
}
class Step {
final int number;
final String title;
final String description;
final List<SubStep> subSteps;
public Step(int number, String title, String description, List<SubStep> subSteps) {
this.number = number;
this.title = title;
this.description = description;
this.subSteps = subSteps;
}
}
class KnowledgeHubData {
static List<Step> getSteps() {
return List.of(new Step(1, "Record your first test case", "Get to know how to create your first automation test using Katalon Recorder (Record & Playback).", List.of(new SubStep("Record Login test case", "1/7"), new SubStep("Discover Test Explorer menu", "0/2"))), new Step(2, "Run your first test case case", "Learn how to execute your test case and view the results.", List.of(new SubStep("Navigate to test case runner", "0/3"), new SubStep("Run the test and analyze results", "0/4"))), new Step(3, "Reuse your first test case for a new test scenario", "Learn how to duplicate and modify existing test cases.", List.of(new SubStep("Duplicate your login test", "0/2"), new SubStep("Modify for new test scenario", "0/3"))), new Step(4, "Create your first test suite", "Group your test cases into a test suite for easier management.", List.of(new SubStep("Create a new test suite", "0/2"), new SubStep("Add test cases to the suite", "0/3"))), new Step(5, "Run your test suite", "Execute all test cases in your test suite at once.", List.of(new SubStep("Access test suite runner", "0/2"), new SubStep("Configure execution options", "0/2"), new SubStep("Analyze test results", "0/3"))));
}
}
class KnowledgeHubScreen extends SubStatefulWidget {
public KnowledgeHubScreen() {
}
@Override protected  State<KnowledgeHubScreen> createState() {
 return new KnowledgeHubScreenState();
}
}
class KnowledgeHubScreenState extends SubState<KnowledgeHubScreen> implements SingleTickerProviderStateMixin {
final List<Step> steps = KnowledgeHubData.getSteps();
List<Boolean> expandedSteps = List.of(true, false, false, false, false);
int currentStep = 0;
List<Integer> currentSubSteps = List.of(0, 0, 0, 0, 0);
Map<Integer, List<Boolean>> hoveredSubSteps = Map.of();
List<Boolean> hoveredSteps = Collections.nCopies(5, false);
List<Boolean> hoveredExpandButtons = Collections.nCopies(5, false);
private AnimationController _animationController;
private Map<Integer, Animation<Double>> _expandAnimations;
@Override protected  void initState() {
super.initState();
for (int i = 0; i < steps.size(); i++) {
hoveredSubSteps.put(i, Collections.nCopies(steps.get(i).subSteps.size(), false));
}

_animationController = AnimationController()
.vsync(this)
.duration(Duration()
.milliseconds(300));
_expandAnimations = Map.of();
for (int i = 0; i < steps.size(); i++) {
_expandAnimations.put(i, Tween()
.begin(0.0)
.end(1.0).animate(CurvedAnimation(_animationController, Interval(0.0, 1.0)
.curve(Curves.easeInOut()))));
}

}
@Override protected  void dispose() {
_animationController.dispose();
super.dispose();
}
double calculateProgress() {
int totalSubSteps = 0;
int completedSubSteps = 0;
for (var step in steps) {
for (var subStep in step.subSteps) {
totalSubSteps++;
if (subStep.isCompleted) {
completedSubSteps++;
}

}

}

return totalSubSteps > 0 ? (completedSubSteps / totalSubSteps) * 100 : 0;
}
void toggleStep(int index) {
setState(() -> {
expandedSteps.get(index) = !expandedSteps.get(index);
if (expandedSteps.get(index)) {
_animationController.forward();
}
 else {
_animationController.reverse();
}

}
);
}
void setCurrentStep(int index) {
setState(() -> {
currentStep = index;
if (!expandedSteps.get(index)) {
expandedSteps.get(index) = true;
}

}
);
}
void setCurrentSubStep(int stepIndex, int subStepIndex) {
setState(() -> {
for (int i = 0; i < subStepIndex; i++) {
steps.get(stepIndex).subSteps.get(i).isCompleted = true;
}

currentStep = stepIndex;
currentSubSteps.get(stepIndex) = subStepIndex;
if (!expandedSteps.get(stepIndex)) {
expandedSteps.get(stepIndex) = true;
}

}
);
}
void setStepHovered(int index, boolean isHovered) {
setState(() -> {
hoveredSteps.get(index) = isHovered;
}
);
}
void setExpandButtonHovered(int index, boolean isHovered) {
setState(() -> {
hoveredExpandButtons.get(index) = isHovered;
}
);
}
void setSubStepHovered(int stepIndex, int subStepIndex, boolean isHovered) {
setState(() -> {
hoveredSubSteps.get(stepIndex)!.get(subStepIndex) = isHovered;
}
);
}
@Override protected  Widget build(BuildContext context) {
return Scaffold()
.body(Container()
.decoration(BoxDecoration()
.border(Border_all()
.color(Colors.grey().shade300()))
.borderRadius(BorderRadius_circular(8)))
.child(Column()
.crossAxisAlignment(CrossAxisAlignment.start)
.children(List.of(Container()
.height(45)
.padding(EdgeInsets_symmetric()
.horizontal(16))
.decoration(BoxDecoration()
.color(Colors.white())
.border(Border()
.bottom(BorderSide()
.color(Colors.grey().shade300())
.width(1))))
.child(Row()
.mainAxisAlignment(MainAxisAlignment.spaceBetween)
.children(List.of(Row()
.children(List.of(Icon(Icons.help_outline())
.color(Color(0xFF3F51B5)), SizedBox()
.width(8), Text("Knowledge Hub")
.style(TextStyle()
.fontWeight(FontWeight.w500())
.fontSize(14)))), Row()
.children(List.of(Icon(Icons.minimize())
.color(Colors.grey()), SizedBox()
.width(8), Icon(Icons.close())
.color(Colors.grey())))))), Expanded()
.child(SingleChildScrollView()
.child(Padding()
.padding(EdgeInsets_all(16.0))
.child(Column()
.crossAxisAlignment(CrossAxisAlignment.start)
.children(List.of(Container()
.padding(EdgeInsets_symmetric()
.vertical(8)
.horizontal(12))
.decoration(BoxDecoration()
.color(Color(0xFF3F51B5))
.borderRadius(BorderRadius_circular(4)))
.child(Row()
.children(List.of(Icon(Icons.arrow_back_ios())
.size(14)
.color(Colors.white()), Text("GETTING STARTED")
.style(TextStyle()
.color(Colors.white())
.fontWeight(FontWeight.bold())
.fontSize(13)
.letterSpacing(0.5)), Spacer(), Text("About 3 mins")
.style(TextStyle()
.color(Colors.white70())
.fontSize(12))))), SizedBox()
.height(16), Text("This tour guides you on creating, running tests, and reviewing test results.")
.style(TextStyle()
.fontSize(13)
.color(Colors.black87())), SizedBox()
.height(16), Container()
.height(4)
.width(double.infinity())
.decoration(BoxDecoration()
.color(Colors.grey().shade200())
.borderRadius(BorderRadius_circular(2)))
.child(FractionallySizedBox()
.alignment(Alignment.centerLeft())
.widthFactor(calculateProgress() / 100)
.child(Container()
.decoration(BoxDecoration()
.color(Color(0xFF3F51B5))
.borderRadius(BorderRadius_circular(2))))), Align()
.alignment(Alignment.centerRight())
.child(Text(""+calculateProgress().toInt()+"%")
.style(TextStyle()
.fontSize(12)
.color(Colors.grey()))), SizedBox()
.height(16), ...List_generate(steps.size(), (index) -> _buildStepItem()
.step(steps.get(index))
.index(index)
.isExpanded(expandedSteps.get(index))
.isCurrent(currentStep == index)))))))))));
}
private Widget _buildStepItem(Step step, int index, boolean isExpanded, boolean isCurrent) {
return MouseRegion()
.onEnter((_0) -> setStepHovered(index, true))
.onExit((_1) -> setStepHovered(index, false))
.child(Container()
.margin(EdgeInsets_only()
.bottom(8))
.decoration(BoxDecoration()
.color(isCurrent ? Color(0xFFF5F5F5) : hoveredSteps.get(index) ? Colors.grey().shade50() : null)
.borderRadius(BorderRadius_circular(4))
.border(isCurrent ? Border_all()
.color(Colors.grey().shade300()) : null))
.child(Column()
.crossAxisAlignment(CrossAxisAlignment.start)
.children(Stream.of(GestureDetector()
.onTap(() -> toggleStep(index))
.onDoubleTap(() -> setCurrentStep(index))
.child(Container()
.padding(EdgeInsets_symmetric()
.vertical(12)
.horizontal(8))
.child(Row()
.children(List.of(Container()
.width(24)
.height(24)
.decoration(BoxDecoration()
.color(isCurrent ? Color(0xFF212121) : Colors.grey().shade200())
.shape(BoxShape.circle)
.border(Border_all()
.color(Colors.grey().shade300())
.width(1)))
.child(Center()
.child(Text(""+step.number+"")
.style(TextStyle()
.fontSize(12)
.fontWeight(FontWeight.bold())
.color(isCurrent ? Colors.white() : Colors.black87())))), SizedBox()
.width(8), Expanded()
.child(Text(step.title)
.style(TextStyle()
.fontSize(13)
.fontWeight(isCurrent ? FontWeight.w600() : FontWeight.w500())
.color(isCurrent ? Colors.black87() : Colors.grey().shade700()))), MouseRegion()
.onEnter((_2) -> setExpandButtonHovered(index, true))
.onExit((_3) -> setExpandButtonHovered(index, false))
.child(Container()
.decoration(BoxDecoration()
.color(hoveredExpandButtons.get(index) ? Colors.grey().shade200() : Colors.transparent())
.borderRadius(BorderRadius_circular(4)))
.padding(EdgeInsets_all(4))
.child(Icon(isExpanded ? Icons.keyboard_arrow_up() : Icons.keyboard_arrow_down())
.color(hoveredExpandButtons.get(index) ? Colors.black87() : Colors.grey()))))))), (isExpanded) ? AnimatedSize()
.duration(Duration()
.milliseconds(200))
.curve(Curves.easeInOut())
.child(Padding()
.padding(EdgeInsets_only()
.left(28)
.bottom(8))
.child(Column()
.crossAxisAlignment(CrossAxisAlignment.start)
.children(List.of(Text(step.description)
.style(TextStyle()
.fontSize(12)
.color(Colors.black87())), SizedBox()
.height(16), ...List_generate(step.subSteps.size(), (subIndex) -> _buildSubStepItem()
.subStep(step.subSteps.get(subIndex))
.stepIndex(index)
.subStepIndex(subIndex)
.isCompleted(step.subSteps.get(subIndex).isCompleted)
.isCurrent(currentStep == index && currentSubSteps.get(index) == subIndex)))))) : null).filter(Objects::nonNull).toList())));
}
private Widget _buildSubStepItem(SubStep subStep, int stepIndex, int subStepIndex, boolean isCompleted, boolean isCurrent) {
boolean isHovered = hoveredSubSteps.get(stepIndex).get(subStepIndex) ?? false;
return MouseRegion()
.onEnter((_4) -> setSubStepHovered(stepIndex, subStepIndex, true))
.onExit((_5) -> setSubStepHovered(stepIndex, subStepIndex, false))
.child(GestureDetector()
.onDoubleTap(() -> setCurrentSubStep(stepIndex, subStepIndex))
.child(Container()
.padding(EdgeInsets_symmetric()
.vertical(6)
.horizontal(4))
.margin(EdgeInsets_only()
.bottom(4))
.decoration(BoxDecoration()
.color(isHovered ? Colors.grey().shade100() : Colors.transparent())
.borderRadius(BorderRadius_circular(4)))
.child(Row()
.crossAxisAlignment(CrossAxisAlignment.start)
.children(List.of(SizedBox()
.width(16)
.child(Column()
.children(Stream.of(Container()
.width(10)
.height(10)
.decoration(BoxDecoration()
.shape(BoxShape.circle)
.color(isCurrent ? Color(0xFF3F51B5) : isCompleted ? Colors.green() : isHovered ? Color(0xFF9FA8DA) : Colors.grey().shade400())), (!isCompleted || subStepIndex < steps.get(stepIndex).subSteps.size() - 1) ? Container()
.height(20)
.width(2)
.color(Colors.grey().shade300())
.margin(EdgeInsets_only()
.top(2)) : null).filter(Objects::nonNull).toList())), SizedBox()
.width(8), Expanded()
.child(Row()
.crossAxisAlignment(CrossAxisAlignment.center)
.children(List.of(Text(subStep.text)
.style(TextStyle()
.fontSize(12)
.fontWeight(isCurrent ? FontWeight.w600() : FontWeight.normal())
.color(isCurrent ? Colors.black87() : isHovered ? Colors.black() : Colors.grey().shade700())), SizedBox()
.width(8), Container()
.padding(EdgeInsets_symmetric()
.horizontal(4)
.vertical(1))
.decoration(BoxDecoration()
.color(Colors.grey().shade200())
.borderRadius(BorderRadius_circular(4)))
.child(Text(subStep.progress)
.style(TextStyle()
.fontSize(10)
.color(Colors.black54())))))))))));
}
}
