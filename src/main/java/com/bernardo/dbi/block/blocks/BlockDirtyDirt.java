package com.bernardo.dbi.block.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

public class BlockDirtyDirt extends Block {
    public BlockDirtyDirt() {
        super(BlockBehaviour.Properties.of()
            .mapColor(MapColor.DIRT)
            .strength(0.5f)
            .sound(SoundType.GRAVEL));
    }
}
