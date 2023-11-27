package dev.teamcitrusmods.factory_expansion.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab FACTORY_EXPANSION_TAB =
            new CreativeModeTab("factory_expansion_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.FAUX_COIL.get());
        }
    };
}
