package dev.ivory.client.clientbase.module;

public enum Category {
    COMBAT("Combat"),
    MOVEMENT("Movement"),
    MISC("Misc"),
    PLAYER("Player"),
    RENDER("Render");
    private final String name;
    Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
