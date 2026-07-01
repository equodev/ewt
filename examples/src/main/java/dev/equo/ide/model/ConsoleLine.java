package dev.equo.ide.model;

public record ConsoleLine(Level level, String timestamp, String text) {
    public enum Level { INFO, WARN, ERROR }
}
