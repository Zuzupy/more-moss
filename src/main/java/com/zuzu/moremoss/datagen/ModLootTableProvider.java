package com.zuzu.moremoss.datagen;

import com.zuzu.moremoss.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.MOSSY_DEEPSLATE);

        addDrop(ModBlocks.MOSSY_COBBLED_DEEPSLATE);
        addDrop(ModBlocks.MOSSY_COBBLED_DEEPSLATE_STAIRS);
        addDrop(ModBlocks.MOSSY_COBBLED_DEEPSLATE_SLAB, slabDrops(ModBlocks.MOSSY_COBBLED_DEEPSLATE_SLAB));
        addDrop(ModBlocks.MOSSY_COBBLED_DEEPSLATE_WALL);

        addDrop(ModBlocks.MOSSY_BRICKS);
        addDrop(ModBlocks.MOSSY_BRICK_STAIRS);
        addDrop(ModBlocks.MOSSY_BRICK_SLAB, slabDrops(ModBlocks.MOSSY_BRICK_SLAB));
        addDrop(ModBlocks.MOSSY_BRICK_WALL);
    }
}
