package com.bernardo.dbi.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.core.particles.SimpleParticleType;

public class DinoMeatParticleProvider implements ParticleProvider<SimpleParticleType> {

    private final SpriteSet sprites;

    public DinoMeatParticleProvider(SpriteSet sprites) {
        this.sprites = sprites;
    }

    @Override
    public TextureSheetParticle createParticle(SimpleParticleType type, ClientLevel level,
            double x, double y, double z, double dx, double dy, double dz) {
        net.minecraft.client.particle.BreakingItemParticle particle =
            net.minecraft.client.particle.BreakingItemParticle.createBreaking(
                level, x, y, z, net.minecraft.world.item.Items.PORKCHOP);
        particle.pickSprite(sprites);
        return particle;
    }
}
