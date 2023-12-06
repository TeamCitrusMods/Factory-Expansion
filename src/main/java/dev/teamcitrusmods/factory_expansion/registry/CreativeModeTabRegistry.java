package dev.teamcitrusmods.factory_expansion.registry;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class CreativeModeTabRegistry {
    public static final CreativeModeTab FACTORY_EXPANSION_TAB =
            new CreativeModeTab("factory_expansion_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(BlockRegistry.FLUX_LAMP_INVERTED.get());
        }
    };
}
