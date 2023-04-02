package dev.ivory.client.clientbase.module.functionars;

import dev.ivory.client.clientbase.misc.IMinecraft;
import net.minecraft.client.gui.FontRenderer;

public class RenderFunction implements IMinecraft {
    public FontRenderer getFontRenderer() {
        return mc.fontRendererObj;
    }
}
