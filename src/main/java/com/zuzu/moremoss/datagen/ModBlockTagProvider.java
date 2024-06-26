package com.zuzu.moremoss.datagen;

import com.zuzu.moremoss.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BlockTags.STAIRS)
                .add(ModBlocks.MOSSY_COBBLED_DEEPSLATE_STAIRS)
                .add(ModBlocks.MOSSY_BRICK_STAIRS);

        getOrCreateTagBuilder(BlockTags.SLABS)
                .add(ModBlocks.MOSSY_COBBLED_DEEPSLATE_SLAB)
                .add(ModBlocks.MOSSY_BRICK_SLAB);

        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.MOSSY_COBBLED_DEEPSLATE_WALL)
                .add(ModBlocks.MOSSY_BRICK_WALL);

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.MOSSY_DEEPSLATE)
                .add(ModBlocks.MOSSY_COBBLED_DEEPSLATE)
                .add(ModBlocks.MOSSY_COBBLED_DEEPSLATE_STAIRS)
                .add(ModBlocks.MOSSY_COBBLED_DEEPSLATE_SLAB)
                .add(ModBlocks.MOSSY_COBBLED_DEEPSLATE_WALL)

                .add(ModBlocks.MOSSY_BRICKS)
                .add(ModBlocks.MOSSY_BRICK_STAIRS)
                .add(ModBlocks.MOSSY_BRICK_SLAB)
                .add(ModBlocks.MOSSY_BRICK_WALL);
    }
}
