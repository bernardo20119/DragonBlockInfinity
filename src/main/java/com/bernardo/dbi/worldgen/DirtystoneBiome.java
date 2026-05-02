package com.bernardo.dbi.worldgen;

import com.bernardo.dbi.DragonBlockInfinity;
import com.bernardo.dbi.entity.ModEntities;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

/** Bioma Dirty Stone — montanhas altas, solo sujo, dinossauros frequentes. */
public class DirtystoneBiome {

    public static final ResourceKey<Biome> KEY = ResourceKey.create(
        Registries.BIOME,
        new ResourceLocation(DragonBlockInfinity.MOD_ID, "dirty_stone")
    );

    public static Biome create(
            HolderGetter<PlacedFeature> features,
            HolderGetter<ConfiguredWorldCarver<?>> carvers) {

        BiomeGenerationSettings.Builder gen =
            new BiomeGenerationSettings.Builder(features, carvers);

        MobSpawnSettings.Builder mobs = new MobSpawnSettings.Builder();

        // Rate 20 = muito frequente, min 2 max 4 por grupo
        mobs.addSpawn(MobCategory.MONSTER,
            new MobSpawnSettings.SpawnerData(
                ModEntities.DINO.get(), 20, 2, 4));

        return new Biome.BiomeBuilder()
            .temperature(0.3f)
            .downfall(0.1f)
            .hasPrecipitation(false)
            .specialEffects(new BiomeSpecialEffects.Builder()
                .skyColor(0x7BA4FF)
                .fogColor(0xC0D8FF)
                .waterColor(0x3F76E4)
                .waterFogColor(0x050533)
                .build())
            .generationSettings(gen.build())
            .mobSpawnSettings(mobs.build())
            .build();
    }
}
