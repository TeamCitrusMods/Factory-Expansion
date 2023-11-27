package dev.teamcitrusmods.factory_expansion.datagen.loot;

import dev.teamcitrusmods.factory_expansion.block.ModBlocks;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockLootTables extends BlockLoot {
    @Override
    protected void addTables() {
        this.dropSelf(ModBlocks.FLUX_LAMP.get());
        this.dropSelf(ModBlocks.FLUX_LAMP_INVERTED.get());

        this.dropSelf(ModBlocks.LIGHT_THERMAL_PLATING.get());
        this.dropSelf(ModBlocks.TILED_LIGHT_THERMAL_PLATING.get());

        this.dropSelf(ModBlocks.DARK_THERMAL_PLATING.get());
        this.dropSelf(ModBlocks.TILED_DARK_THERMAL_PLATING.get());

        this.dropSelf(ModBlocks.SLAG_BRICKS_SLAB.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
