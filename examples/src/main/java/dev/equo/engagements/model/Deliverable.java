package dev.equo.engagements.model;

import java.time.LocalDate;

public record Deliverable(
    String id,
    String engagementId,
    String title,
    LocalDate due,
    DeliverableStatus status,
    String ownerPersonId) {

  public Deliverable withStatus(DeliverableStatus s) {
    return new Deliverable(id, engagementId, title, due, s, ownerPersonId);
  }
}
