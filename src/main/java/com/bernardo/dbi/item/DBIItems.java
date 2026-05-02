package com.bernardo.dbi.item;

import com.bernardo.dbi.DragonBlockInfinity;
import com.bernardo.dbi.block.DBIBlocks;
import com.bernardo.dbi.item.armor.GokuArmorItem;
import com.bernardo.dbi.entity.ModEntities;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DBIItems {

    public static final DeferredRegister<Item> ITEMS =
        DeferredRegister.create(ForgeRegistries.ITEMS, DragonBlockInfinity.MOD_ID);

    // ── BLOCOS PLUS ───────────────────────────────────────────────
    public static final RegistryObject<Item> BLOCK_PLUS_WHITE      = ITEMS.register("block_plus_white",      () -> new BlockItem(DBIBlocks.BLOCK_PLUS_WHITE.get(),      new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_PLUS_ORANGE     = ITEMS.register("block_plus_orange",     () -> new BlockItem(DBIBlocks.BLOCK_PLUS_ORANGE.get(),     new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_PLUS_MAGENTA    = ITEMS.register("block_plus_magenta",    () -> new BlockItem(DBIBlocks.BLOCK_PLUS_MAGENTA.get(),    new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_PLUS_LIGHT_BLUE = ITEMS.register("block_plus_light_blue", () -> new BlockItem(DBIBlocks.BLOCK_PLUS_LIGHT_BLUE.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_PLUS_YELLOW     = ITEMS.register("block_plus_yellow",     () -> new BlockItem(DBIBlocks.BLOCK_PLUS_YELLOW.get(),     new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_PLUS_LIME       = ITEMS.register("block_plus_lime",       () -> new BlockItem(DBIBlocks.BLOCK_PLUS_LIME.get(),       new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_PLUS_PINK       = ITEMS.register("block_plus_pink",       () -> new BlockItem(DBIBlocks.BLOCK_PLUS_PINK.get(),       new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_PLUS_GRAY       = ITEMS.register("block_plus_gray",       () -> new BlockItem(DBIBlocks.BLOCK_PLUS_GRAY.get(),       new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_PLUS_LIGHT_GRAY = ITEMS.register("block_plus_light_gray", () -> new BlockItem(DBIBlocks.BLOCK_PLUS_LIGHT_GRAY.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_PLUS_CYAN       = ITEMS.register("block_plus_cyan",       () -> new BlockItem(DBIBlocks.BLOCK_PLUS_CYAN.get(),       new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_PLUS_PURPLE     = ITEMS.register("block_plus_purple",     () -> new BlockItem(DBIBlocks.BLOCK_PLUS_PURPLE.get(),     new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_PLUS_BLUE       = ITEMS.register("block_plus_blue",       () -> new BlockItem(DBIBlocks.BLOCK_PLUS_BLUE.get(),       new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_PLUS_BROWN      = ITEMS.register("block_plus_brown",      () -> new BlockItem(DBIBlocks.BLOCK_PLUS_BROWN.get(),      new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_PLUS_GREEN      = ITEMS.register("block_plus_green",      () -> new BlockItem(DBIBlocks.BLOCK_PLUS_GREEN.get(),      new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_PLUS_RED        = ITEMS.register("block_plus_red",        () -> new BlockItem(DBIBlocks.BLOCK_PLUS_RED.get(),        new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_PLUS_BLACK      = ITEMS.register("block_plus_black",      () -> new BlockItem(DBIBlocks.BLOCK_PLUS_BLACK.get(),      new Item.Properties()));

    // ── BLOCOS NAMEK ──────────────────────────────────────────────
    public static final RegistryObject<Item> BLOCK_NAMEKGRASS      = ITEMS.register("block_namekgrass",      () -> new BlockItem(DBIBlocks.BLOCK_NAMEKGRASS.get(),      new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_NAMEKDIRT       = ITEMS.register("block_namekdirt",       () -> new BlockItem(DBIBlocks.BLOCK_NAMEKDIRT.get(),       new Item.Properties()));

    // ── BLOCOS DIRTY STONE ────────────────────────────────────────
    public static final RegistryObject<Item> DIRTY_STONE           = ITEMS.register("dirty_stone",           () -> new BlockItem(DBIBlocks.DIRTY_STONE.get(),           new Item.Properties()));
    public static final RegistryObject<Item> DIRTY_DIRT            = ITEMS.register("dirty_dirt",            () -> new BlockItem(DBIBlocks.DIRTY_DIRT.get(),            new Item.Properties()));
    public static final RegistryObject<Item> DIRTY_COBBLESTONE     = ITEMS.register("dirty_cobblestone",     () -> new BlockItem(DBIBlocks.DIRTY_COBBLESTONE.get(),     new Item.Properties()));

    // ── COMIDA ────────────────────────────────────────────────────
    public static final RegistryObject<Item> DINO_MEAT_RAW = ITEMS.register("dino_meat_raw",
        () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
            .nutrition(4).saturationMod(0.3f).meat().build())));

    public static final RegistryObject<Item> DINO_MEAT_COOKED = ITEMS.register("dino_meat_cooked",
        () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
            .nutrition(12).saturationMod(0.8f).meat().build())));

    public static final RegistryObject<Item> SENZU_BEAN = ITEMS.register("senzu_bean",
        () -> new Item(new Item.Properties().stacksTo(16)));

    // ── ARMADURA GOKU ─────────────────────────────────────────────
    public static final RegistryObject<Item> GOKU_HELMET     = ITEMS.register("goku_helmet",     () -> new GokuArmorItem(ArmorItem.Type.HELMET));
    public static final RegistryObject<Item> GOKU_CHESTPLATE = ITEMS.register("goku_chestplate", () -> new GokuArmorItem(ArmorItem.Type.CHESTPLATE));
    public static final RegistryObject<Item> GOKU_LEGGINGS   = ITEMS.register("goku_leggings",   () -> new GokuArmorItem(ArmorItem.Type.LEGGINGS));
    public static final RegistryObject<Item> GOKU_BOOTS      = ITEMS.register("goku_boots",      () -> new GokuArmorItem(ArmorItem.Type.BOOTS));

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
