package com.zuzu.moremoss.block;

import com.zuzu.moremoss.MoreMoss;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block MOSSY_DEEPSLATE = registerBlock("mossy_deepslate",
            new Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE))
    );

    public static final Block MOSSY_COBBLED_DEEPSLATE = registerBlock("mossy_cobbled_deepslate",
            new Block(FabricBlockSettings.copyOf(Blocks.COBBLED_DEEPSLATE))
    );

    public static final Block MOSSY_COBBLED_DEEPSLATE_SLAB = registerBlock("mossy_cobbled_deepslate_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.COBBLED_DEEPSLATE_SLAB))
    );

    public static final Block MOSSY_COBBLED_DEEPSLATE_WALL = registerBlock("mossy_cobbled_deepslate_wall",
            new WallBlock(FabricBlockSettings.copyOf(Blocks.COBBLED_DEEPSLATE_WALL))
    );

    private static void addBlocksToBuildingBlockItemGroup(FabricItemGroupEntries entries) {
        entries.add(MOSSY_DEEPSLATE);
        entries.add(MOSSY_COBBLED_DEEPSLATE);
        entries.add(MOSSY_COBBLED_DEEPSLATE_SLAB);
        entries.add(MOSSY_COBBLED_DEEPSLATE_WALL);
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);

        return Registry.register(
                Registries.BLOCK,
                new Identifier(MoreMoss.MOD_ID, name),
                block
        );
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(
                Registries.ITEM,
                new Identifier(MoreMoss.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()
            )
        );
    }

    public static void registerModBlocks() {
        MoreMoss.LOGGER.info("Registering ModBlocks for " + MoreMoss.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(ModBlocks::addBlocksToBuildingBlockItemGroup);
    }
}
