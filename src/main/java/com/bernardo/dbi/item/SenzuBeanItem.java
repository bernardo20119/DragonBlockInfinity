package com.bernardo.dbi.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

/** Senzu Bean — cura total ao comer. */
public class SenzuBeanItem extends Item {

    public SenzuBeanItem() {
        super(new Properties()
            .stacksTo(16)
            .food(new FoodProperties.Builder()
                .nutrition(20)
                .saturationMod(2.0f)
                .alwaysEat()
                .build()));
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.EAT;
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 32;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        if (entity instanceof Player player) {
            player.setHealth(player.getMaxHealth());
            player.getFoodData().setFoodLevel(20);
            player.getFoodData().setSaturation(20.0f);
        }
        return super.finishUsingItem(stack, level, entity);
    }
}
