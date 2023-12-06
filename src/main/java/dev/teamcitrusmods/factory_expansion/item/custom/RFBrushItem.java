package dev.teamcitrusmods.factory_expansion.item.custom;

import cofh.thermal.lib.item.EnergyContainerItemAugmentable;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.energy.IEnergyStorage;

public class RFBrushItem extends EnergyContainerItemAugmentable {
    public RFBrushItem(Properties builder, int maxEnergy, int maxTransfer) {
        super(builder, maxEnergy, maxTransfer);
    }

    @Override
    public Capability<? extends IEnergyStorage> getEnergyCapability() {
        return null;
    }
}
