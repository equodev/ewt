package dev.equo.ide.model;

public enum BottomTabId {
    CONSOLE("Console"),
    PROBLEMS("Problems"),
    TERMINAL("Terminal");

    private final String label;

    BottomTabId(String label) {
        this.label = label;
    }

    public String label() {
        return label;
    }
}
