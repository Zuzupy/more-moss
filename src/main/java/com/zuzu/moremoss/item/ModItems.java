package com.zuzu.moremoss.item;

import com.zuzu.moremoss.MoreMoss;
import com.zuzu.moremoss.moss_ball.MossBall;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.DispenserBlock;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final MossBall MOSS_BALL = (MossBall) registerItem("moss_ball", new MossBall());

    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(MOSS_BALL);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(MoreMoss.MOD_ID, name), item);
    }

    public static void registerModItems() {
        MoreMoss.LOGGER.info("Registering ModItems for " + MoreMoss.MOD_ID);

        DispenserBlock.registerBehavior(MOSS_BALL, (pointer, stack) -> {
            MOSS_BALL.dispenserUseOnBlock(pointer);
            stack.decrement(1);

            return stack;
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}
