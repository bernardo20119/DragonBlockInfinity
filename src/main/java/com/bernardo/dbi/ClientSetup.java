package com.bernardo.dbi;

import com.bernardo.dbi.client.KeyBindings;
import com.bernardo.dbi.entity.DinoRenderer;
import com.bernardo.dbi.client.particle.ModParticles;
import com.bernardo.dbi.client.particle.DinoMeatParticleProvider;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import com.bernardo.dbi.entity.ModEntities;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = DragonBlockInfinity.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetup {

    @SubscribeEvent
    public static void init(final FMLClientSetupEvent event) {}

    @SubscribeEvent
    public static void onRegisterKeyMappings(RegisterKeyMappingsEvent event) {
        KeyBindings.register(event);
    }

    @SubscribeEvent
    public static void onRegisterParticles(net.minecraftforge.client.event.RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(ModParticles.DINO_MEAT_RAW.get(), DinoMeatParticleProvider::new);
        event.registerSpriteSet(ModParticles.DINO_MEAT_COOKED.get(), DinoMeatParticleProvider::new);
    }

    @SubscribeEvent
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.DINO.get(), DinoRenderer::new);
    }
}
