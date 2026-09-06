package dev.equo.engagements.model;

import java.time.LocalDate;

public record TimeEntry(
    String id,
    String engagementId,
    String personId,
    LocalDate day,
    double hours,
    String note,
    boolean billed) {}
