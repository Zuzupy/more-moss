package com.zuzu.moremoss.datagen;

import com.zuzu.moremoss.block.ModBlocks;
import com.zuzu.moremoss.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.MOSS_BALL, RecipeCategory.MISC, Blocks.MOSS_BLOCK);

        createStairsRecipe(ModBlocks.MOSSY_COBBLED_DEEPSLATE_STAIRS.asItem(), Ingredient.ofItems(ModBlocks.MOSSY_COBBLED_DEEPSLATE.asItem()))
                .criterion(hasItem(ModBlocks.MOSSY_DEEPSLATE.asItem()), conditionsFromItem(ModBlocks.MOSSY_DEEPSLATE.asItem()))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.MOSSY_COBBLED_DEEPSLATE_STAIRS.asItem())));
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_COBBLED_DEEPSLATE_SLAB, ModBlocks.MOSSY_COBBLED_DEEPSLATE);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_COBBLED_DEEPSLATE_WALL, ModBlocks.MOSSY_COBBLED_DEEPSLATE);

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_COBBLED_DEEPSLATE_STAIRS, ModBlocks.MOSSY_COBBLED_DEEPSLATE, 4);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_COBBLED_DEEPSLATE_SLAB, ModBlocks.MOSSY_COBBLED_DEEPSLATE, 6);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_COBBLED_DEEPSLATE_WALL, ModBlocks.MOSSY_COBBLED_DEEPSLATE, 6);

        createStairsRecipe(ModBlocks.MOSSY_BRICK_STAIRS.asItem(), Ingredient.ofItems(ModBlocks.MOSSY_BRICKS.asItem()))
                .criterion(hasItem(Blocks.BRICKS.asItem()), conditionsFromItem(Blocks.BRICKS.asItem()))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.MOSSY_BRICK_STAIRS.asItem())));
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_BRICK_SLAB, ModBlocks.MOSSY_BRICKS);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_BRICK_WALL, ModBlocks.MOSSY_BRICKS);
    }
}