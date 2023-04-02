package dev.ivory.client.clientbase.module;

import dev.ivory.client.clientbase.ClientBase;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class ModuleManager {
    private final HashSet<Module> moduleHashSet;

    public ModuleManager() {
        moduleHashSet = new HashSet<>();
    }

    public void initialize() {
        System.out.println("loading modules...");
        loadModules();
    }

    public void loadModules() {

        try {
            FilenameFilter filter = (f, name) -> name.endsWith(".js");
            File dir = new File(Objects.requireNonNull(ClientBase.class.getClassLoader().getResource("assets/minecraft/clientBase/")).getFile());

            File[] files = dir.listFiles(filter);

            for (int i = 0; i < files.length; i++) {
                System.out.println(files[i].getName());
                new ModuleLoader().loadModule(files[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public HashSet<Module> getModuleHashSet() {
        return moduleHashSet;
    }

    public List<Module> getModuleList() {
        return new ArrayList<>(moduleHashSet);
    }
}
