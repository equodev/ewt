package dev.equo.engagements.model;

import java.time.LocalDate;
import java.util.List;

public record Engagement(
    String id,
    String clientId,
    String name,
    EngagementStatus status,
    LocalDate start,
    LocalDate targetEnd,
    List<String> teamPersonIds,
    String leadPersonId,
    double budgetHours) {

  public Engagement withStatus(EngagementStatus s) {
    return new Engagement(id, clientId, name, s, start, targetEnd, teamPersonIds, leadPersonId, budgetHours);
  }
}
