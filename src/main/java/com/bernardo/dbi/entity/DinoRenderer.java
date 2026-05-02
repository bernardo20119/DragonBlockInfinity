package com.bernardo.dbi.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

/** Renderer do Dinossauro. */
public class DinoRenderer extends GeoEntityRenderer<DinoEntity> {

    public DinoRenderer(EntityRendererProvider.Context context) {
        super(context, new DinoModel());
    }
}
