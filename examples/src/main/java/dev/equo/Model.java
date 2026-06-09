package dev.equo;

import java.util.List;

class SubStep {
  final String text;
  boolean isCompleted;
  final String progress;
  final List<String> actions;
  int currentAction;

  public SubStep(String text, String progress, List<String> actions) {
    this.text = text;
    this.isCompleted = false;
    this.progress = progress;
    this.actions = actions;
    this.currentAction = 0;
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
    return List.of(
        new Step(
            1,
            "Record your first test case",
            "Get to know how to create your first automation test using Katalon Recorder.",
            List.of(
                new SubStep(
                    "Record Login test case",
                    "1/7",
                    List.of(
                        "Click Record icon to record test steps with Katalon Recorder.",
                        "Navigate to the login page",
                        "Enter username in the input field",
                        "Enter password in the input field",
                        "Click the login button",
                        "Verify successful login",
                        "Click Stop to complete recording")),
                new SubStep(
                    "Discover Test Explorer menu",
                    "0/2",
                    List.of(
                        "Open Test Explorer from the sidebar",
                        "Navigate through the test case folders")))),
        new Step(
            2,
            "Run your first test case case",
            "Learn how to execute your test case and view the results.",
            List.of(
                new SubStep(
                    "Navigate to test case runner",
                    "0/3",
                    List.of(
                        "Select your test case in Test Explorer",
                        "Click the Run button in the toolbar",
                        "Configure execution settings if needed")),
                new SubStep(
                    "Run the test and analyze results",
                    "0/4",
                    List.of(
                        "Start test execution",
                        "Monitor test progress",
                        "View test results summary",
                        "Examine detailed logs if there are failures")))));
  }
}
