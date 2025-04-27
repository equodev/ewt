package dev.equo;

import static dev.equo.ewt.EWT.*;

import dev.equo.ewt.*;
import java.util.List;

public class HackaF {
  public static void main(String[] args) {
    App.runApp(() -> new MyApp());
  }
}

class MyApp extends SubStatelessWidget {
  @Override
  protected Widget build(BuildContext context) {
    return MaterialApp()
        .title("Issue Details")
        .theme(ThemeData()
            .brightness(Brightness.dark)
            .scaffoldBackgroundColor(Color(0xFF0D1117))
            .textTheme(TextTheme()
                .bodyMedium(TextStyle().color(Colors.white70()))
                .bodyLarge(TextStyle().color(Colors.white70()))))
        .home(new IssueDetailsScreen());
  }
}

class IssueDetailsScreen extends SubStatelessWidget {
  @Override
  protected Widget build(BuildContext context) {
    return Scaffold()
        .body(SafeArea()
            .child(Padding(EdgeInsets_symmetric().horizontal(16.0))
                .child(Column()
                    .crossAxisAlignment(CrossAxisAlignment.start)
                    .children(List.of(
                        SizedBox().height(20),
                        _buildSectionWithIcon("Assignees", Icons.settings()),
                        SizedBox().height(8),
                        _buildSectionContent("No one - ", "Assign yourself", true),
                        _buildDivider(),
                        SizedBox().height(16),
                        _buildSectionWithIcon("Labels", Icons.settings()),
                        SizedBox().height(8),
                        _buildSectionContent("No labels", "", false),
                        _buildDivider(),
                        SizedBox().height(16),
                        _buildSectionWithIcon("Projects", Icons.settings()),
                        SizedBox().height(8),
                        _buildSectionContent("No projects", "", false),
                        _buildDivider(),
                        SizedBox().height(16),
                        _buildSectionWithIcon("Milestone", Icons.settings()))))));
  }

  private Widget _buildSectionWithIcon(String title, IconData icon) {
    return Row()
        .mainAxisAlignment(MainAxisAlignment.spaceBetween)
        .children(List.of(
            Text(title)
                .style(TextStyle()
                    .color(Color(0xFF768390))
                    .fontSize(16)
                    .fontWeight(FontWeight.w500())),
            Icon(icon).color(Color(0xFF768390)).size(20)));
  }

  private Widget _buildSectionContent(String mainText, String actionText, boolean hasAction) {
    return hasAction
        ? RichText(TextSpan()
            .children(List.of(
                TextSpan()
                    .text(mainText)
                    .style(TextStyle().color(Color(0xFF768390)).fontSize(14)),
                TextSpan()
                    .text(actionText)
                    .style(TextStyle().color(Colors.blue()).fontSize(14)))))
        : Text(mainText).style(TextStyle().color(Color(0xFF768390)).fontSize(14));
  }

  private Widget _buildDivider() {
    return Divider().color(Color(0xFF30363D)).thickness(1).height(32);
  }
}
