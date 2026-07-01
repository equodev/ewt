package dev.equo.ide.model;

public record Problem(Severity severity, String file, int line, String message) {
    public enum Severity { ERROR, WARN, INFO }
}
