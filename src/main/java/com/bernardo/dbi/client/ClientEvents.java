package com.bernardo.dbi.client;

import com.bernardo.dbi.client.menu.MenuControl;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import com.bernardo.dbi.DragonBlockInfinity;

@Mod.EventBusSubscriber(modid = DragonBlockInfinity.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;
        Minecraft mc = Minecraft.getInstance();
        Player player = mc.player;

        if (player == null) {
            return;
        }

        if (KeyBindings.CHARACTER_KEY.consumeClick()) {
            MenuControl.open(MenuControl.ID_CHARACTER_CREATION);
        }

        // TESTE: aura sempre ativa
        // AuraManager.showAura(player.getUUID());
    }
}