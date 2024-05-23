package com.zuzu.moremoss.moss_ball;

import com.zuzu.moremoss.config_loader.ConfigLoader;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import java.util.Objects;

public class MossBall extends Item {

    public MossBall() {
        super(new FabricItemSettings());
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block block = world.getBlockState(context.getBlockPos()).getBlock();
        Block convertTo = ConfigLoader.getConversion(block);

        if (convertTo == null) {
            return super.useOnBlock(context);
        }

        if (world.isClient()) {
            Objects.requireNonNull(context.getPlayer()).playSound(SoundEvents.ITEM_BONE_MEAL_USE, 1.0f, 1.0f);
        } else {
            world.setBlockState(context.getBlockPos(), convertTo.getStateWithProperties(world.getBlockState(context.getBlockPos())));
            Objects.requireNonNull(context.getPlayer()).getStackInHand(context.getHand()).decrement(1);
        }

        return ActionResult.SUCCESS;
    }
}
