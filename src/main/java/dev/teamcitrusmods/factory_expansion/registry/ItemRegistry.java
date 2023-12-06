package dev.teamcitrusmods.factory_expansion.registry;

import dev.teamcitrusmods.factory_expansion.FactoryExpansion;
import dev.teamcitrusmods.factory_expansion.item.RFBrushItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FactoryExpansion.MODID);

    // ITEMS

    public static final RegistryObject<RFBrushItem> FLUXBRUSH = ITEMS.register("fluxbrush",
            () -> new RFBrushItem(new Item.Properties().stacksTo(1).tab(CreativeModeTabRegistry.FACTORY_EXPANSION_TAB), 10000, 100));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
