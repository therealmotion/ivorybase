module = moduleManager.registerModule("HUD", "Render");
module.setKey(25);

function renderHUD() {
    render.getFontRenderer().drawStringWithShadow('IvoryWare', 5, 5, -1);
    for(i = 0; i < moduleManager.getModuleManager().getModuleHashSet().size(); i++) {
        module = moduleManager.getModuleManager().getModuleList().get(i);
        render.getFontRenderer().drawStringWithShadow('> ' + module.getName() + " - " + module.getKey() + ' - ' + module.getToggleState(), 5, 17 + (i * 12), -1);
    }
}

event.registerEvent("render", renderHUD);
