package dev.ivory.client.clientbase.module;

import dev.ivory.client.clientbase.ClientBase;

public abstract class Module {
    private final String name;
    private final Category category;
    private int key = 0;
    private boolean toggleState;

    public Module(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    public void setToggleState(boolean toggleState) {
        if (toggleState)
            onEnable();
        else
            onDisable();
        this.toggleState = toggleState;
    }

    private void onEnable() {
        ClientBase.getInstance().getEventBus().register(this);
    }

    private void onDisable() {
        ClientBase.getInstance().getEventBus().unregister(this);
    }

    public boolean getToggleState() {
        return toggleState;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
}
