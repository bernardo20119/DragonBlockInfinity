package com.bernardo.dbi.item.armor;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

public enum GokuArmorMaterial implements ArmorMaterial {
    INSTANCE;

    private static final int[] PROTECTION = {2, 5, 6, 3};

    @Override
    public int getDurabilityForType(net.minecraft.world.item.ArmorItem.Type type) {
        return new int[]{195, 225, 240, 165}[type.ordinal()];
    }

    @Override
    public int getDefenseForType(net.minecraft.world.item.ArmorItem.Type type) {
        return PROTECTION[type.ordinal()];
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
