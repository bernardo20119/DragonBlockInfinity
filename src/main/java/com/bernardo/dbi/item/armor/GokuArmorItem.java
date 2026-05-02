package com.bernardo.dbi.item.armor;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;

public class GokuArmorItem extends ArmorItem {

    public GokuArmorItem(Type type) {
        super(GokuArmorMaterial.INSTANCE, type, new Properties());
    }

    @Override
    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) {
        return false;
    }

    public static int countEquipped(LivingEntity entity) {
        int count = 0;
        for (EquipmentSlot slot : new EquipmentSlot[]{
                EquipmentSlot.HEAD, EquipmentSlot.CHEST,
                EquipmentSlot.LEGS, EquipmentSlot.FEET}) {
            if (entity.getItemBySlot(slot).getItem() instanceof GokuArmorItem) {
                count++;
            }
        }
        return count;
    }
}
