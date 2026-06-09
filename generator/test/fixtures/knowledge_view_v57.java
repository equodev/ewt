
void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Katalon Knowledge Hub',
      theme: ThemeData(
        primarySwatch: Colors.blue,
        primaryColor: const Color(0xFF3F51B5),
        scaffoldBackgroundColor: Colors.white,
        fontFamily: 'Roboto',
        dividerColor: Colors.grey.shade200,
      ),
      home: const KnowledgeHubScreen(),
    );
  }
}

// Data models for steps and substeps
class SubStep {
  final String text;
  bool isCompleted;
  final String progress;

  SubStep({
    required this.text,
    this.isCompleted = false,
    required this.progress,
  });
}

class Step {
  final int number;
  final String title;
  final String description;
  final List<SubStep> subSteps;

  Step({
    required this.number,
    required this.title,
    required this.description,
    required this.subSteps,
  });
}

class KnowledgeHubData {
  static List<Step> getSteps() {
    return [
      Step(
        number: 1,
        title: 'Record your first test case',
        description: 'Get to know how to create your first automation test using Katalon Recorder (Record & Playback).',
        subSteps: [
          SubStep(text: 'Record Login test case', progress: '1/7'),
          SubStep(text: 'Discover Test Explorer menu', progress: '0/2'),
        ],
      ),
      Step(
        number: 2,
        title: 'Run your first test case case',
        description: 'Learn how to execute your test case and view the results.',
        subSteps: [
          SubStep(text: 'Navigate to test case runner', progress: '0/3'),
          SubStep(text: 'Run the test and analyze results', progress: '0/4'),
        ],
      ),
      Step(
        number: 3,
        title: 'Reuse your first test case for a new test scenario',
        description: 'Learn how to duplicate and modify existing test cases.',
        subSteps: [
          SubStep(text: 'Duplicate your login test', progress: '0/2'),
          SubStep(text: 'Modify for new test scenario', progress: '0/3'),
        ],
      ),
      Step(
        number: 4,
        title: 'Create your first test suite',
        description: 'Group your test cases into a test suite for easier management.',
        subSteps: [
          SubStep(text: 'Create a new test suite', progress: '0/2'),
          SubStep(text: 'Add test cases to the suite', progress: '0/3'),
        ],
      ),
      Step(
        number: 5,
        title: 'Run your test suite',
        description: 'Execute all test cases in your test suite at once.',
        subSteps: [
          SubStep(text: 'Access test suite runner', progress: '0/2'),
          SubStep(text: 'Configure execution options', progress: '0/2'),
          SubStep(text: 'Analyze test results', progress: '0/3'),
        ],
      ),
    ];
  }
}

class KnowledgeHubScreen extends StatefulWidget {
  const KnowledgeHubScreen({Key? key}) : super(key: key);

  @override
  State<KnowledgeHubScreen> createState() => _KnowledgeHubScreenState();
}

class _KnowledgeHubScreenState extends State<KnowledgeHubScreen> with SingleTickerProviderStateMixin {
  final List<Step> steps = KnowledgeHubData.getSteps();
  List<bool> expandedSteps = [true, false, false, false, false];
  int currentStep = 0;
  List<int> currentSubSteps = [0, 0, 0, 0, 0];
  Map<int, List<bool>> hoveredSubSteps = {};
  List<bool> hoveredSteps = List.filled(5, false);
  List<bool> hoveredExpandButtons = List.filled(5, false);

  // Animation controller for expanding/collapsing
  late AnimationController _animationController;
  late Map<int, Animation<double>> _expandAnimations;

  @override
  void initState() {
    super.initState();

    // Initialize hover tracking for substeps
    for (int i = 0; i < steps.length; i++) {
      hoveredSubSteps[i] = List.filled(steps[i].subSteps.length, false);
    }

    // Setup animation controller
    _animationController = AnimationController(
      vsync: this,
      duration: Duration(milliseconds: 300),
    );

    // Create animations for each step
    _expandAnimations = {};
    for (int i = 0; i < steps.length; i++) {
      _expandAnimations[i] = Tween<double>(begin: 0.0, end: 1.0).animate(
        CurvedAnimation(
          parent: _animationController,
          curve: Interval(0.0, 1.0, curve: Curves.easeInOut),
        ),
      );
    }
  }

  @override
  void dispose() {
    _animationController.dispose();
    super.dispose();
  }

  // Calculate overall progress percentage
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
    setState(() {
      expandedSteps[index] = !expandedSteps[index];
      if (expandedSteps[index]) {
        _animationController.forward();
      } else {
        _animationController.reverse();
      }
    });
  }

  void setCurrentStep(int index) {
    setState(() {
      currentStep = index;
      if (!expandedSteps[index]) {
        expandedSteps[index] = true;
      }
    });
  }

  void setCurrentSubStep(int stepIndex, int subStepIndex) {
    setState(() {
      // Mark all previous substeps as completed
      for (int i = 0; i < subStepIndex; i++) {
        steps[stepIndex].subSteps[i].isCompleted = true;
      }

      currentStep = stepIndex;
      currentSubSteps[stepIndex] = subStepIndex;
      if (!expandedSteps[stepIndex]) {
        expandedSteps[stepIndex] = true;
      }
    });
  }

  void setStepHovered(int index, bool isHovered) {
    setState(() {
      hoveredSteps[index] = isHovered;
    });
  }

  void setExpandButtonHovered(int index, bool isHovered) {
    setState(() {
      hoveredExpandButtons[index] = isHovered;
    });
  }

  void setSubStepHovered(int stepIndex, int subStepIndex, bool isHovered) {
    setState(() {
      hoveredSubSteps[stepIndex]![subStepIndex] = isHovered;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Container(
        decoration: BoxDecoration(
          border: Border.all(color: Colors.grey.shade300),
          borderRadius: BorderRadius.circular(8),
        ),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            // Knowledge Hub header
            Container(
              height: 45,
              padding: const EdgeInsets.symmetric(horizontal: 16),
              decoration: BoxDecoration(
                color: Colors.white,
                border: Border(
                  bottom: BorderSide(color: Colors.grey.shade300, width: 1),
                ),
              ),
              child: Row(
                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                children: [
                  Row(
                    children: [
                      Icon(Icons.help_outline, color: const Color(0xFF3F51B5)),
                      const SizedBox(width: 8),
                      Text(
                        'Knowledge Hub',
                        style: TextStyle(
                          fontWeight: FontWeight.w500,
                          fontSize: 14,
                        ),
                      ),
                    ],
                  ),
                  Row(
                    children: [
                      Icon(Icons.minimize, color: Colors.grey),
                      const SizedBox(width: 8),
                      Icon(Icons.close, color: Colors.grey),
                    ],
                  ),
                ],
              ),
            ),

            // Main content
            Expanded(
              child: SingleChildScrollView(
                child: Padding(
                  padding: const EdgeInsets.all(16.0),
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      // GETTING STARTED header
                      Container(
                        padding: const EdgeInsets.symmetric(vertical: 8, horizontal: 12),
                        decoration: BoxDecoration(
                          color: const Color(0xFF3F51B5),
                          borderRadius: BorderRadius.circular(4),
                        ),
                        child: Row(
                          children: [
                            Icon(Icons.arrow_back_ios, size: 14, color: Colors.white),
                            Text(
                              'GETTING STARTED',
                              style: TextStyle(
                                color: Colors.white,
                                fontWeight: FontWeight.bold,
                                fontSize: 13,
                                letterSpacing: 0.5,
                              ),
                            ),
                            Spacer(),
                            Text(
                              'About 3 mins',
                              style: TextStyle(
                                color: Colors.white70,
                                fontSize: 12,
                              ),
                            ),
                          ],
                        ),
                      ),
                      const SizedBox(height: 16),

                      // Description text
                      Text(
                        'This tour guides you on creating, running tests, and reviewing test results.',
                        style: TextStyle(
                          fontSize: 13,
                          color: Colors.black87,
                        ),
                      ),
                      const SizedBox(height: 16),

                      // Progress bar
                      Container(
                        height: 4,
                        width: double.infinity,
                        decoration: BoxDecoration(
                          color: Colors.grey.shade200,
                          borderRadius: BorderRadius.circular(2),
                        ),
                        child: FractionallySizedBox(
                          alignment: Alignment.centerLeft,
                          widthFactor: calculateProgress() / 100,
                          child: Container(
                            decoration: BoxDecoration(
                              color: const Color(0xFF3F51B5),
                              borderRadius: BorderRadius.circular(2),
                            ),
                          ),
                        ),
                      ),

                      Align(
                        alignment: Alignment.centerRight,
                        child: Text(
                          '${calculateProgress().toInt()}%',
                          style: TextStyle(
                            fontSize: 12,
                            color: Colors.grey,
                          ),
                        ),
                      ),
                      const SizedBox(height: 16),

                      // Steps
                      ...List.generate(steps.length, (index) =>
                          _buildStepItem(
                            step: steps[index],
                            index: index,
                            isExpanded: expandedSteps[index],
                            isCurrent: currentStep == index,
                          )
                      ),
                    ],
                  ),
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }

  Widget _buildStepItem({
    required Step step,
    required int index,
    required bool isExpanded,
    required bool isCurrent,
  }) {
    return MouseRegion(
      onEnter: (_) => setStepHovered(index, true),
      onExit: (_) => setStepHovered(index, false),
      child: Container(
        margin: const EdgeInsets.only(bottom: 8),
        decoration: BoxDecoration(
          color: isCurrent ? const Color(0xFFF5F5F5) :
          hoveredSteps[index] ? Colors.grey.shade50 : null,
          borderRadius: BorderRadius.circular(4),
          border: isCurrent ? Border.all(color: Colors.grey.shade300) : null,
        ),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            GestureDetector(
              onTap: () => toggleStep(index),
              onDoubleTap: () => setCurrentStep(index),
              child: Container(
                padding: const EdgeInsets.symmetric(vertical: 12, horizontal: 8),
                child: Row(
                  children: [
                    Container(
                      width: 24,
                      height: 24,
                      decoration: BoxDecoration(
                        color: isCurrent ? const Color(0xFF212121) : Colors.grey.shade200,
                        shape: BoxShape.circle,
                        border: Border.all(color: Colors.grey.shade300, width: 1),
                      ),
                      child: Center(
                        child: Text(
                          '${step.number}',
                          style: TextStyle(
                            fontSize: 12,
                            fontWeight: FontWeight.bold,
                            color: isCurrent ? Colors.white : Colors.black87,
                          ),
                        ),
                      ),
                    ),
                    const SizedBox(width: 8),
                    Expanded(
                      child: Text(
                        step.title,
                        style: TextStyle(
                          fontSize: 13,
                          fontWeight: isCurrent ? FontWeight.w600 : FontWeight.w500,
                          color: isCurrent ? Colors.black87 : Colors.grey.shade700,
                        ),
                      ),
                    ),
                    MouseRegion(
                      onEnter: (_) => setExpandButtonHovered(index, true),
                      onExit: (_) => setExpandButtonHovered(index, false),
                      child: Container(
                        decoration: BoxDecoration(
                          color: hoveredExpandButtons[index] ? Colors.grey.shade200 : Colors.transparent,
                          borderRadius: BorderRadius.circular(4),
                        ),
                        padding: const EdgeInsets.all(4),
                        child: Icon(
                          isExpanded ? Icons.keyboard_arrow_up : Icons.keyboard_arrow_down,
                          color: hoveredExpandButtons[index] ? Colors.black87 : Colors.grey,
                        ),
                      ),
                    ),
                  ],
                ),
              ),
            ),
            if (isExpanded)
              AnimatedSize(
                duration: const Duration(milliseconds: 200),
                curve: Curves.easeInOut,
                child: Padding(
                  padding: const EdgeInsets.only(left: 28, bottom: 8),
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      Text(
                        step.description,
                        style: TextStyle(fontSize: 12, color: Colors.black87),
                      ),
                      const SizedBox(height: 16),
                      ...List.generate(step.subSteps.length, (subIndex) =>
                          _buildSubStepItem(
                            subStep: step.subSteps[subIndex],
                            stepIndex: index,
                            subStepIndex: subIndex,
                            isCompleted: step.subSteps[subIndex].isCompleted,
                            isCurrent: currentStep == index && currentSubSteps[index] == subIndex,
                          )
                      ),
                    ],
                  ),
                ),
              ),
          ],
        ),
      ),
    );
  }

  Widget _buildSubStepItem({
    required SubStep subStep,
    required int stepIndex,
    required int subStepIndex,
    required bool isCompleted,
    required bool isCurrent,
  }) {
    bool isHovered = hoveredSubSteps[stepIndex]?[subStepIndex] ?? false;

    return MouseRegion(
      onEnter: (_) => setSubStepHovered(stepIndex, subStepIndex, true),
      onExit: (_) => setSubStepHovered(stepIndex, subStepIndex, false),
      child: GestureDetector(
        onDoubleTap: () => setCurrentSubStep(stepIndex, subStepIndex),
        child: Container(
          padding: const EdgeInsets.symmetric(vertical: 6, horizontal: 4),
          margin: const EdgeInsets.only(bottom: 4),
          decoration: BoxDecoration(
            color: isHovered ? Colors.grey.shade100 : Colors.transparent,
            borderRadius: BorderRadius.circular(4),
          ),
          child: Row(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              SizedBox(
                width: 16,
                child: Column(
                  children: [
                    Container(
                      width: 10,
                      height: 10,
                      decoration: BoxDecoration(
                        shape: BoxShape.circle,
                        color: isCurrent ? const Color(0xFF3F51B5) :
                        isCompleted ? Colors.green :
                        isHovered ? const Color(0xFF9FA8DA) : Colors.grey.shade400,
                      ),
                    ),
                    if (!isCompleted || subStepIndex < steps[stepIndex].subSteps.length - 1)
                      Container(
                        height: 20,
                        width: 2,
                        color: Colors.grey.shade300,
                        margin: const EdgeInsets.only(top: 2),
                      ),
                  ],
                ),
              ),
              const SizedBox(width: 8),
              Expanded(
                child: Row(
                  crossAxisAlignment: CrossAxisAlignment.center,
                  children: [
                    Text(
                      subStep.text,
                      style: TextStyle(
                        fontSize: 12,
                        fontWeight: isCurrent ? FontWeight.w600 : FontWeight.normal,
                        color: isCurrent ? Colors.black87 :
                        isHovered ? Colors.black : Colors.grey.shade700,
                      ),
                    ),
                    const SizedBox(width: 8),
                    Container(
                      padding: const EdgeInsets.symmetric(horizontal: 4, vertical: 1),
                      decoration: BoxDecoration(
                        color: Colors.grey.shade200,
                        borderRadius: BorderRadius.circular(4),
                      ),
                      child: Text(
                        subStep.progress,
                        style: const TextStyle(
                          fontSize: 10,
                          color: Colors.black54,
                        ),
                      ),
                    ),
                  ],
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}