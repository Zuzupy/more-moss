package com.zuzu.moremoss.block;

import com.zuzu.moremoss.MoreMoss;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
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
    }
}
