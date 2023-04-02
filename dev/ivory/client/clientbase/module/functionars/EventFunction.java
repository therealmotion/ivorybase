package dev.ivory.client.clientbase.module.functionars;

import jdk.nashorn.api.scripting.JSObject;

import java.util.LinkedHashMap;
import java.util.Map;

public class EventFunction {
    public Map<String, JSObject> getEventMap() {
        return eventMap;
    }

    private final Map<String , JSObject> eventMap = new LinkedHashMap<>();
    public void registerEvent(String eventName, JSObject event) {
        eventMap.put(eventName, event);
    }
}
