package dev.ivory.client.clientbase.module.functionars;

import com.google.common.eventbus.Subscribe;
import dev.ivory.client.clientbase.ClientBase;
import dev.ivory.client.clientbase.event.impl.EventRender;
import dev.ivory.client.clientbase.module.Category;
import dev.ivory.client.clientbase.module.Module;
import dev.ivory.client.clientbase.module.ModuleLoader;
import dev.ivory.client.clientbase.module.ModuleManager;
import org.lwjgl.Sys;

import java.util.Objects;

public class ModuleFunction {
    private final ModuleLoader moduleLoader;
    public ModuleFunction(ModuleLoader moduleLoader) {
        this.moduleLoader = moduleLoader;
    }

    public Module registerModule(String name, String category) {
        Module module = new ModuleGamerz(name, Category.valueOf(category.toUpperCase()));
        getModuleLoader().setModule(module);
        ClientBase.getInstance().getModuleManager().getModuleHashSet().add(module);
        System.out.println(module.getClass());
        return module;
    }


    public ModuleLoader getModuleLoader() {
        return moduleLoader;
    }

    public ModuleManager getModuleManager() {
        return ClientBase.getInstance().getModuleManager();
    }
    class ModuleGamerz extends Module {
        private final String name;
        public ModuleGamerz(String name, Category category) {
            super(name, category);
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }

        @Subscribe
        public void onRender(EventRender e) {
            moduleLoader.registerEvent("render", e);
        };
    }
}
