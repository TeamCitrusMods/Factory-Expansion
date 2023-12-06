package dev.teamcitrusmods.factory_expansion.item;

import cofh.thermal.lib.item.EnergyContainerItemAugmentable;
import cofh.thermal.lib.item.IFlexibleEnergyContainerItem;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.energy.IEnergyStorage;

public class RFBrushItem extends EnergyContainerItemAugmentable implements IFlexibleEnergyContainerItem {
    public RFBrushItem(Properties builder, int maxEnergy, int maxTransfer) {
        super(builder, maxEnergy, maxTransfer);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        ItemStack stack = pContext.getPlayer().getItemInHand(pContext.getHand());
        if(!pContext.getLevel().isClientSide()) {
            pContext.getLevel().setBlock(pContext.getClickedPos(), Blocks.RED_WOOL.defaultBlockState(), 11);
            extractEnergy(stack, 20, false);
        }
        return super.useOn(pContext);
    }
}
