package dev.ivory.client.clientbase;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import dev.ivory.client.clientbase.event.impl.EventKey;
import dev.ivory.client.clientbase.module.ModuleManager;
import org.lwjgl.input.Keyboard;


public class ClientBase {
    /* world's best client base
        made by ivory */
    private static final ClientBase clientBase = new ClientBase();
    private final EventBus eventBus;
    private ModuleManager moduleManager;
    public ClientBase() {
        eventBus = new EventBus();
        System.out.println("initialization");
    }

    public void start() {
        this.moduleManager = new ModuleManager();
        this.moduleManager.initialize();
        // bindbindibndinbdinbdinbdinbdinbindbindinbdinbdinbdi0nbdinbbinbdinbdinbdinbdibndibnddbinbdinbdbidnbdinbdinbdbinbdinbdibnbi0nnbibnbindbinbdbidndbindbindbdinbdinb
        eventBus.register(this);
    }

    @Subscribe
    public void onKey(EventKey eventKey) {
        System.out.println(eventKey.getKey());
        getModuleManager().getModuleHashSet().forEach(module -> {
            if(module.getKey() == eventKey.getKey()) {
                System.out.println("match");
                module.setToggleState(!module.getToggleState());
            }
        });
    };

    // lombok who?
    public static ClientBase getInstance() {
        return clientBase;
    }

    public ModuleManager getModuleManager() {
        return moduleManager;
    }

    public EventBus getEventBus() {
        return eventBus;
    }
}
