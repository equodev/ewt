package dev.equo.engagements.ui;

import dev.equo.engagements.model.DeliverableStatus;
import dev.equo.engagements.model.EngagementStatus;
import dev.equo.ewt.Chip;
import dev.equo.ewt.ColorI;
import dev.equo.ewt.Colors;
import dev.equo.ewt.EdgeInsets;
import dev.equo.ewt.TextStyle;
import dev.equo.ewt.Widget;

import static dev.equo.ewt.EWT.Chip;
import static dev.equo.ewt.EWT.Color_fromARGB;
import static dev.equo.ewt.EWT.EdgeInsets_symmetric;
import static dev.equo.ewt.EWT.Text;
import static dev.equo.ewt.EWT.TextStyle;
import static dev.equo.ewt.EWT.VisualDensity;

/** Small rounded status pill used for both engagement and deliverable states. */
public final class StatusChip {

  private StatusChip() {}

  public static Chip forEngagement(EngagementStatus s) {
    return build(label(s.name()), engagementFill(s), engagementInk(s));
  }

  public static Chip forDeliverable(DeliverableStatus s) {
    return build(label(s.name()), deliverableFill(s), deliverableInk(s));
  }

  private static Chip build(String text, ColorI fill, ColorI ink) {
    EdgeInsets pad = EdgeInsets_symmetric().horizontal(8.0).vertical(0.0).build();
    return Chip().label(Text(text).style(TextStyle().color(ink).fontSize(11.0)))
        .backgroundColor(fill)
        .visualDensity(VisualDensity().horizontal(-3.0).vertical(-3.0).build())
        .padding(pad)
        .labelPadding(EdgeInsets_symmetric().horizontal(4.0).build())
        .build();
  }

  private static String label(String enumName) {
    // camelCase -> "Camel Case"
    String s = enumName.replaceAll("([a-z])([A-Z])", "$1 $2");
    return Character.toUpperCase(s.charAt(0)) + s.substring(1);
  }

  private static ColorI engagementFill(EngagementStatus s) {
    return switch (s) {
      case active     -> Colors.teal().shade100();
      case proposed   -> Colors.amber().shade100();
      case paused     -> Colors.orange().shade100();
      case completed  -> Colors.grey().shade200();
    };
  }

  private static ColorI engagementInk(EngagementStatus s) {
    return switch (s) {
      case active     -> Colors.teal().shade800();
      case proposed   -> Colors.amber().shade900();
      case paused     -> Colors.deepOrange().shade800();
      case completed  -> Colors.grey().shade700();
    };
  }

  private static ColorI deliverableFill(DeliverableStatus s) {
    return switch (s) {
      case done        -> Colors.teal().shade100();
      case inProgress  -> Color_fromARGB(255, 244, 224, 208).build();
      case blocked     -> Colors.red().shade100();
      case notStarted  -> Colors.grey().shade200();
    };
  }

  private static ColorI deliverableInk(DeliverableStatus s) {
    return switch (s) {
      case done        -> Colors.teal().shade800();
      case inProgress  -> Colors.deepOrange().shade800();
      case blocked     -> Colors.red().shade800();
      case notStarted  -> Colors.grey().shade700();
    };
  }
}
