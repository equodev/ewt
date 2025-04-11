// model.dart - Shared data models for the Knowledge Hub

class SubStep {
  final String text;
  bool isCompleted;
  final String progress;
  final List<String> actions;
  int currentAction;

  SubStep({
    required this.text,
    this.isCompleted = false,
    required this.progress,
    required this.actions,
    this.currentAction = 0,
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
        description: 'Get to know how to create your first automation test using Katalon Recorder.',
        subSteps: [
          SubStep(
            text: 'Record Login test case',
            progress: '1/7',
            actions: [
              'Click Record icon to record test steps with Katalon Recorder.',
              'Navigate to the login page',
              'Enter username in the input field',
              'Enter password in the input field',
              'Click the login button',
              'Verify successful login',
              'Click Stop to complete recording',
            ],
          ),
          SubStep(
            text: 'Discover Test Explorer menu',
            progress: '0/2',
            actions: [
              'Open Test Explorer from the sidebar',
              'Navigate through the test case folders',
            ],
          ),
        ],
      ),
      Step(
        number: 2,
        title: 'Run your first test case case',
        description: 'Learn how to execute your test case and view the results.',
        subSteps: [
          SubStep(
            text: 'Navigate to test case runner',
            progress: '0/3',
            actions: [
              'Select your test case in Test Explorer',
              'Click the Run button in the toolbar',
              'Configure execution settings if needed',
            ],
          ),
          SubStep(
            text: 'Run the test and analyze results',
            progress: '0/4',
            actions: [
              'Start test execution',
              'Monitor test progress',
              'View test results summary',
              'Examine detailed logs if there are failures',
            ],
          ),
        ],
      ),
    ];
  }
}