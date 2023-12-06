package dev.teamcitrusmods.factory_expansion.datagen.loot;

import dev.teamcitrusmods.factory_expansion.registry.BlockRegistry;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockLootTables extends BlockLoot {
    @Override
    protected void addTables() {
        this.dropSelf(BlockRegistry.FLUX_LAMP.get());
        this.dropSelf(BlockRegistry.FLUX_LAMP_INVERTED.get());

        this.dropSelf(BlockRegistry.THERMAL_BRIGHT_PLATING.get());

        this.dropSelf(BlockRegistry.SLAG_BRICKS_SLAB.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BlockRegistry.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
