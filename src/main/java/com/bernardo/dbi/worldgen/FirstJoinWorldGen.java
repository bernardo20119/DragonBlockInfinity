package com.bernardo.dbi.worldgen;

import com.bernardo.dbi.DragonBlockInfinity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.saveddata.SavedData;
import net.minecraftforge.event.level.LevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/** Executa geração de mundo apenas na primeira vez que o mundo é carregado. */
@Mod.EventBusSubscriber(modid = DragonBlockInfinity.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class FirstJoinWorldGen {

    private static final String DATA_KEY = "dragonblockinfinity_worldgen";

    @SubscribeEvent
    public static void onWorldLoad(LevelEvent.Load event) {
        if (!(event.getLevel() instanceof ServerLevel level)) return;
        if (!level.dimension().equals(ServerLevel.OVERWORLD)) return;

        DBIWorldGenData data = level.getDataStorage()
            .computeIfAbsent(DBIWorldGenData::load, DBIWorldGenData::new, DATA_KEY);

        if (!data.hasGenerated()) {
            DragonBlockInfinity.LOGGER.info("DBI: Primeira vez — gerando mundo...");
            data.setGenerated(true);
            data.setDirty();
        }
    }

    /** SavedData para persistir se já gerou ou não. */
    public static class DBIWorldGenData extends SavedData {

        private boolean generated = false;

        public DBIWorldGenData() {}

        public static DBIWorldGenData load(CompoundTag tag) {
            DBIWorldGenData data = new DBIWorldGenData();
            data.generated = tag.getBoolean("generated");
            return data;
        }

        @Override
        public CompoundTag save(CompoundTag tag) {
            tag.putBoolean("generated", this.generated);
            return tag;
        }

        public boolean hasGenerated() { return generated; }
        public void setGenerated(boolean value) { this.generated = value; }
    }
}
