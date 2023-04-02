package dev.ivory.client.clientbase.event.impl;


import dev.ivory.client.clientbase.event.Event;

public class EventKey extends Event {
    private final int key;
    public EventKey(int key) {
        this.key = key;
    }
    public int getKey() {
        return key;
    }
}
