package com.bernardo.dbi.client.menu.screens;

import com.bernardo.dbi.client.menu.DBIGuiScreen;
import com.bernardo.dbi.client.menu.MenuControl;
import net.minecraft.client.gui.GuiGraphics;

/** Tela de criação de personagem — delega renderização ao DBIGuiScreen. */
public class CaracterCreation extends DBIGuiScreen {

    public CaracterCreation() {
        super(MenuControl.ID_CHARACTER_CREATION);
    }

    @Override
    public void render(GuiGraphics gui, int mouseX, int mouseY, float partialTick) {
        super.render(gui, mouseX, mouseY, partialTick);
    }
}
