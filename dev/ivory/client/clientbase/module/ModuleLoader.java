package dev.ivory.client.clientbase.module;

import dev.ivory.client.clientbase.ClientBase;
import dev.ivory.client.clientbase.event.Event;
import dev.ivory.client.clientbase.module.functionars.EventFunction;
import dev.ivory.client.clientbase.module.functionars.MinecraftFunction;
import dev.ivory.client.clientbase.module.functionars.ModuleFunction;
import dev.ivory.client.clientbase.module.functionars.RenderFunction;
import jdk.nashorn.api.scripting.JSObject;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.Objects;
import java.util.Scanner;

public class ModuleLoader {
    // pls don't take this seriously
    private final ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("javascript");
    private final EventFunction eventFunction = new EventFunction();
    private Module module;

    public void loadModule(File file) {
        StringBuilder scriptContext = new StringBuilder();
        this.registerFunctionerz();
        try {
            Scanner reader = new Scanner(file);
            while(reader.hasNextLine()) {
                scriptContext.append(reader.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("what the fuck??? dude are you fucking sped???? what the fuck are you doing, I mean hoW?????");
        }

        try {
            scriptEngine.eval(String.valueOf(scriptContext));
        } catch (ScriptException e) {
            System.out.println();
            e.printStackTrace();
        }
    }

    private void registerFunctionerz() {
        this.scriptEngine.put("moduleManager", new ModuleFunction(this));
        this.scriptEngine.put("event", this.eventFunction);
        this.scriptEngine.put("render", new RenderFunction());
        this.scriptEngine.put("Minecraft", new MinecraftFunction());
    }

    public void registerEvent(final String name, Event event) {
        if(module != null) {
            final JSObject jsObject = getEventFunction().getEventMap().get(name);
            jsObject.call(String.valueOf(jsObject), event);
        }
    }
    public EventFunction getEventFunction() {
        return eventFunction;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public Module getModule() {
        return module;
    }
}
