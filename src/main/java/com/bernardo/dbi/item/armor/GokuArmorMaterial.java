package com.bernardo.dbi.item.armor;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

public enum GokuArmorMaterial implements ArmorMaterial {
    INSTANCE;

    private static final int[] PROTECTION = {5, 6, 3};

    @Override
    public int getDurabilityForType(net.minecraft.world.item.ArmorItem.Type type) {
        if (type == net.minecraft.world.item.ArmorItem.Type.CHESTPLATE) {
            return 225;
        } else if (type == net.minecraft.world.item.ArmorItem.Type.LEGGINGS) {
            return 240;
        } else if (type == net.minecraft.world.item.ArmorItem.Type.BOOTS) {
            return 165;
        }
        return 0;
    }

    @Override
    public int getDefenseForType(net.minecraft.world.item.ArmorItem.Type type) {
        if (type == net.minecraft.world.item.ArmorItem.Type.CHESTPLATE) {
            return PROTECTION[0];
        } else if (type == net.minecraft.world.item.ArmorItem.Type.LEGGINGS) {
            return PROTECTION[1];
        } else if (type == net.minecraft.world.item.ArmorItem.Type.BOOTS) {
            return PROTECTION[2];
        }
        return 0;
    }

    @Override
    public int getEnchantmentValue() { return 15; }

    @Override
    public SoundEvent getEquipSound() { return SoundEvents.ARMOR_EQUIP_LEATHER; }

    @Override
    public Ingredient getRepairIngredient() { return Ingredient.EMPTY; }

    @Override
    public String getName() { return "goku"; }

    @Override
    public float getToughness() { return 1.5f; }

    @Override
    public float getKnockbackResistance() { return 0.1f; }
}
