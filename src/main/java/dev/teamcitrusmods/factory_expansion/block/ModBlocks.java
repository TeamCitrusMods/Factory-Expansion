package dev.teamcitrusmods.factory_expansion.block;

import dev.teamcitrusmods.factory_expansion.FactoryExpansion;
import dev.teamcitrusmods.factory_expansion.block.custom.FluxLampBlock;
import dev.teamcitrusmods.factory_expansion.item.ModCreativeModeTab;
import dev.teamcitrusmods.factory_expansion.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, FactoryExpansion.MODID);

    public static final RegistryObject<Block> SLAG_BRICKS_SLAB = registerBlock("slag_bricks_slab",
            () -> new SlabBlock(BlockBehaviour.Properties
                    .of(Material.STONE)
                    .strength(6f)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.FACTORY_EXPANSION_TAB);

    public static final RegistryObject<Block> FLUX_LAMP = registerBlock("flux_lamp",
            () -> new FluxLampBlock(BlockBehaviour.Properties
                    .of(Material.METAL)
                    .strength(6f)
                    .requiresCorrectToolForDrops()
                    .lightLevel(litBlockEmission(15))
                    .noOcclusion()), ModCreativeModeTab.FACTORY_EXPANSION_TAB);

    public static final RegistryObject<Block> FLUX_LAMP_INVERTED = registerBlock("flux_lamp_inverted",
            () -> new FluxLampBlock(BlockBehaviour.Properties
                    .of(Material.METAL)
                    .strength(6f)
                    .requiresCorrectToolForDrops()
                    .lightLevel(litBlockEmission(0))
                    .noOcclusion()), ModCreativeModeTab.FACTORY_EXPANSION_TAB);

    private static ToIntFunction<BlockState> litBlockEmission(int pLightValue) {
        return (p_50763_) -> {
            return p_50763_.getValue(BlockStateProperties.LIT) ? pLightValue : 15 - pLightValue;
        };
    }



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block,
                                                                     CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                          CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}