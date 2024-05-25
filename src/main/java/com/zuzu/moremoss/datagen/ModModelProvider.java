package com.zuzu.moremoss.datagen;

import com.zuzu.moremoss.block.ModBlocks;
import com.zuzu.moremoss.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MOSSY_DEEPSLATE);

        BlockStateModelGenerator.BlockTexturePool mossy_cobbled_deepslate_pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MOSSY_COBBLED_DEEPSLATE);
        mossy_cobbled_deepslate_pool.slab(ModBlocks.MOSSY_COBBLED_DEEPSLATE_SLAB);
        mossy_cobbled_deepslate_pool.wall(ModBlocks.MOSSY_COBBLED_DEEPSLATE_WALL);
        mossy_cobbled_deepslate_pool.stairs(ModBlocks.MOSSY_COBBLED_DEEPSLATE_STAIRS);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.MOSS_BALL, Models.GENERATED);
    }
}
