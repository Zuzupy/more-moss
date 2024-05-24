package com.zuzu.moremoss.moss_ball;

import com.zuzu.moremoss.config_loader.ConfigLoader;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPointer;
import net.minecraft.util.math.BlockPos;
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

        if (useItem(world, block, context.getBlockPos())) {
            Objects.requireNonNull(context.getPlayer()).getStackInHand(context.getHand()).decrement(1);
            return ActionResult.SUCCESS;
        }

        return ActionResult.FAIL;
    }

    public ItemStack dispenserUseOnBlock(BlockPointer pointer, ItemStack stack) {
        World world = pointer.world();
        BlockPos pos = pointer.pos().offset(world.getBlockState(pointer.pos()).get(Properties.FACING));
        Block block = world.getBlockState(pos).getBlock();

        useItem(world, block, pos);
        stack.decrement(1);

        return stack;
    }

    private static boolean useItem(World world, Block block, BlockPos pos) {
        Block convertTo = ConfigLoader.getConversion(block);

        if (convertTo == null) {
            return false;
        }

        world.playSoundAtBlockCenter(pos, SoundEvents.ITEM_BONE_MEAL_USE, SoundCategory.BLOCKS, 1.0f, 1.0f, true);

        if (!(world.isClient())) {
            world.setBlockState(pos, convertTo.getStateWithProperties(world.getBlockState(pos)));
        }

        return true;
    }
}
