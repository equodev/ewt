package dev.equo.engagements.model;

public record Person(String id, String name, String role, int weeklyCapacityHours) {
  public String initials() {
    String[] parts = name.trim().split("\\s+");
    if (parts.length == 1) return parts[0].substring(0, Math.min(2, parts[0].length())).toUpperCase();
    return ("" + parts[0].charAt(0) + parts[parts.length - 1].charAt(0)).toUpperCase();
  }
}
