package dev.ivory.client.clientbase.misc;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;

public interface IMinecraft {
    Minecraft mc = Minecraft.getMinecraft();
    ScaledResolution sr = new ScaledResolution(mc);
}
