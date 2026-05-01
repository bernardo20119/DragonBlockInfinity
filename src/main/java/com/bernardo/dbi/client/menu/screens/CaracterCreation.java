package com.bernardo.dbi.client.menu.screens;

import com.bernardo.dbi.client.menu.DBIGuiScreen;
import com.bernardo.dbi.client.menu.MenuControl;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import com.bernardo.dbi.core.PlayerPreview;
import net.minecraft.client.gui.screens.Screen;

public class CaracterCreation extends DBIGuiScreen {
   public static final ResourceLocation GUI = new ResourceLocation("dragonblockinfinity", "textures/gui/gui.png");
   public int guiWidget = 256;
   public int guiHeight =256;

    public CaracterCreation() {
        super(MenuControl.ID_CHARACTER_CREATION);
    }

    public void render(GuiGraphics gui, int mouseX, int mouseY, float partialTick) {
        this.renderbackground(gui);
        super.render(guiGraphics, mouseX, mouseY, delta);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
        

    }
}