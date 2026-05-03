package com.bernardo.dbi.client.particle;

import com.bernardo.dbi.DragonBlockInfinity;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.core.particles.ParticleType;
import net.minecraftforge.eventbus.api.IEventBus;

public class ModParticles {

    public static final DeferredRegister<ParticleType<?>> PARTICLES =
        DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, DragonBlockInfinity.MOD_ID);

    public static final RegistryObject<SimpleParticleType> DINO_MEAT_RAW =
        PARTICLES.register("dino_meat_raw_particle", () -> new SimpleParticleType(false));

    public static final RegistryObject<SimpleParticleType> DINO_MEAT_COOKED =
        PARTICLES.register("dino_meat_cooked_particle", () -> new SimpleParticleType(false));

    public static void register(IEventBus bus) {
        PARTICLES.register(bus);
    }
}
