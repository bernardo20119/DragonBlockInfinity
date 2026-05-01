package com.bernardo.dbi.client.menu;

import com.bernardo.dbi.core.PlayerPreview;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

/**
 * Tela única do mod. Renderiza painéis diferentes conforme o pageId.
 * Nunca colocar lógica de jogo aqui — só renderização e input.
 */
public class DBIGuiScreen extends Screen {

    private final int pageId;

    public DBIGuiScreen(int pageId) {
        super(Component.translatable("screen.dragonblockinfinity.main"));
        this.pageId = pageId;
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    @Override
    public void render(GuiGraphics gui, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(gui);
        switch (this.pageId) {
            case MenuControl.ID_CHARACTER_CREATION  -> renderCharacterCreation(gui, mouseX, mouseY);
            case MenuControl.ID_RACE_SELECT         -> renderRaceSelect(gui, mouseX, mouseY);
            case MenuControl.ID_COLOR_PICKER        -> renderColorPicker(gui, mouseX, mouseY);
            case MenuControl.ID_CLASS_SELECT        -> renderClassSelect(gui, mouseX, mouseY);
            case MenuControl.ID_STATS               -> renderStats(gui, mouseX, mouseY);
            case MenuControl.ID_SKILLS              -> renderSkills(gui, mouseX, mouseY);
            case MenuControl.ID_TRANSFORMATIONS     -> renderTransformations(gui, mouseX, mouseY);
            case MenuControl.ID_DRAGON_RADAR        -> renderDragonRadar(gui, mouseX, mouseY);
            case MenuControl.ID_FINALIZING          -> renderFinalizing(gui, mouseX, mouseY);
            default -> renderNotImplemented(gui, mouseX, mouseY);
        }
        super.render(gui, mouseX, mouseY, partialTick);
    }

    // ── PÁGINAS ───────────────────────────────────────────────────

    private void renderCharacterCreation(GuiGraphics gui, int mx, int my) {
        int cx = this.width / 2;
        int cy = this.height / 2;
        gui.blit(MenuControl.GUI_BG, cx - 128, cy - 128, 0, 0, 256, 256, 256, 256);
        PlayerPreview.render(gui, cx - 40, cy + 60, 40, 0f);
        gui.drawCenteredString(this.font,
            Component.translatable("screen.dragonblockinfinity.character_creation"),
            cx, cy - 120, 0xFFFFFF);
    }

    private void renderRaceSelect(GuiGraphics gui, int mx, int my) {
        int cx = this.width / 2;
        int cy = this.height / 2;
        gui.blit(MenuControl.GUI_BG, cx - 128, cy - 128, 0, 0, 256, 256, 256, 256);
        gui.drawCenteredString(this.font,
            Component.literal("Race Selection"), cx, cy - 120, 0xFFFFFF);
    }

    private void renderColorPicker(GuiGraphics gui, int mx, int my) {
        int cx = this.width / 2;
        int cy = this.height / 2;
        gui.blit(MenuControl.GUI_BG2, cx - 128, cy - 128, 0, 0, 256, 256, 256, 256);
        gui.drawCenteredString(this.font,
            Component.literal("Color Picker"), cx, cy - 120, 0xFFFFFF);
    }

    private void renderClassSelect(GuiGraphics gui, int mx, int my) {
        int cx = this.width / 2;
        int cy = this.height / 2;
        gui.blit(MenuControl.GUI_BG, cx - 128, cy - 128, 0, 0, 256, 256, 256, 256);
        gui.drawCenteredString(this.font,
            Component.literal("Class Selection"), cx, cy - 120, 0xFFFFFF);
    }

    private void renderStats(GuiGraphics gui, int mx, int my) {
        int cx = this.width / 2;
        int cy = this.height / 2;
        gui.blit(MenuControl.GUI_BG, cx - 128, cy - 128, 0, 0, 256, 256, 256, 256);
        gui.drawCenteredString(this.font,
            Component.literal("Stats"), cx, cy - 120, 0xFFFFFF);
    }

    private void renderSkills(GuiGraphics gui, int mx, int my) {
        int cx = this.width / 2;
        int cy = this.height / 2;
        gui.blit(MenuControl.GUI_BG, cx - 128, cy - 128, 0, 0, 256, 256, 256, 256);
        gui.drawCenteredString(this.font,
            Component.literal("Skills"), cx, cy - 120, 0xFFFFFF);
    }

    private void renderTransformations(GuiGraphics gui, int mx, int my) {
        int cx = this.width / 2;
        int cy = this.height / 2;
        gui.blit(MenuControl.GUI_BG, cx - 128, cy - 128, 0, 0, 256, 256, 256, 256);
        gui.drawCenteredString(this.font,
            Component.literal("Transformations"), cx, cy - 120, 0xFFFFFF);
    }

    private void renderDragonRadar(GuiGraphics gui, int mx, int my) {
        int cx = this.width / 2;
        int cy = this.height / 2;
        gui.blit(MenuControl.GUI_BG2, cx - 128, cy - 128, 0, 0, 256, 256, 256, 256);
        gui.drawCenteredString(this.font,
            Component.literal("Dragon Radar"), cx, cy - 120, 0xFFFFFF);
    }

    private void renderFinalizing(GuiGraphics gui, int mx, int my) {
        int cx = this.width / 2;
        int cy = this.height / 2;
        gui.blit(MenuControl.GUI_BG, cx - 128, cy - 128, 0, 0, 256, 256, 256, 256);
        PlayerPreview.render(gui, cx, cy + 60, 50, 0f);
        gui.drawCenteredString(this.font,
            Component.literal("Confirm Character"), cx, cy - 120, 0xFFFFFFFF);
    }

    private void renderNotImplemented(GuiGraphics gui, int mx, int my) {
        gui.drawCenteredString(this.font,
            Component.literal("Page " + pageId + " not implemented"),
            this.width / 2, this.height / 2, 0xFF0000);
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (keyCode == 256) { // ESC
            MenuControl.close();
            return true;
        }
        return super.keyPressed(keyCode, scanCode, modifiers);
    }
}
