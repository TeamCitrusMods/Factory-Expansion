package dev.teamcitrusmods.factory_expansion.registry;

import dev.teamcitrusmods.factory_expansion.FactoryExpansion;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FactoryExpansion.MODID);

    // ITEMS

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
