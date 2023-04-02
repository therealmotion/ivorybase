package dev.ivory.client.clientbase.module.functionars;

import net.minecraft.client.Minecraft;

public class MinecraftFunction {
    private final int FPS = Minecraft.getDebugFPS();
    private final Minecraft MINECRAFT = Minecraft.getMinecraft();
    public int getFPS() {
        return FPS;
    }
    public Minecraft getMinecraftInstance() {
        return MINECRAFT;
    }
}
