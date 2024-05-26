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

        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_COBBLED_DEEPSLATE_SLAB, ModBlocks.MOSSY_COBBLED_DEEPSLATE);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_COBBLED_DEEPSLATE_WALL, ModBlocks.MOSSY_COBBLED_DEEPSLATE);
        createStairsRecipe(ModBlocks.MOSSY_COBBLED_DEEPSLATE_STAIRS.asItem(), Ingredient.ofItems(ModBlocks.MOSSY_COBBLED_DEEPSLATE.asItem()))
                .criterion(hasItem(ModBlocks.MOSSY_DEEPSLATE.asItem()), conditionsFromItem(ModBlocks.MOSSY_DEEPSLATE.asItem()))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.MOSSY_COBBLED_DEEPSLATE_STAIRS.asItem())));

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_COBBLED_DEEPSLATE_SLAB, ModBlocks.MOSSY_COBBLED_DEEPSLATE, 6);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_COBBLED_DEEPSLATE_WALL, ModBlocks.MOSSY_COBBLED_DEEPSLATE, 6);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_COBBLED_DEEPSLATE_STAIRS, ModBlocks.MOSSY_COBBLED_DEEPSLATE, 4);
    }
}