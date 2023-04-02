module1 = moduleManager.registerModule("KillAura", "Combat");
module1.setKey(19);
function onRender() {
    print(Minecraft.getMinecraftInstance().thePlayer);
}

event.registerEvent("render", onRender);