package com.bernardo.dbi.entity;

import com.bernardo.dbi.DragonBlockInfinity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/** Registro de todas as entidades do mod. */
public class ModEntities {

    public static final DeferredRegister<EntityType<?>> ENTITIES =
        DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, DragonBlockInfinity.MOD_ID);

    public static final RegistryObject<EntityType<DinoEntity>> DINO =
        ENTITIES.register("dino", () -> EntityType.Builder
            .of(DinoEntity::new, MobCategory.MONSTER)
            .sized(1.8f, 2.0f)
            .build("dino"));
}
