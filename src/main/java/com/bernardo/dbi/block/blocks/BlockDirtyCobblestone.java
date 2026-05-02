package com.bernardo.dbi.block.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

public class BlockDirtyCobblestone extends Block {
    public BlockDirtyCobblestone() {
        super(BlockBehaviour.Properties.of()
            .mapColor(MapColor.STONE)
            .requiresCorrectToolForDrops()
            .strength(2.0f, 6.0f)
            .sound(SoundType.STONE));
    }
}
