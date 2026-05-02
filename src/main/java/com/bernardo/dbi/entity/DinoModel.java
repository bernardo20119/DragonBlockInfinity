package com.bernardo.dbi.entity;

import com.bernardo.dbi.DragonBlockInfinity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

/** GeoModel do Dinossauro. */
public class DinoModel extends GeoModel<DinoEntity> {

    @Override
    public ResourceLocation getModelResource(DinoEntity entity) {
        return new ResourceLocation(DragonBlockInfinity.MOD_ID, "geo/entity/dino.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(DinoEntity entity) {
        return new ResourceLocation(DragonBlockInfinity.MOD_ID, "textures/entity/dino.png");
    }

    @Override
    public ResourceLocation getAnimationResource(DinoEntity entity) {
        return new ResourceLocation(DragonBlockInfinity.MOD_ID, "animations/dino.animation.json");
    }
}
