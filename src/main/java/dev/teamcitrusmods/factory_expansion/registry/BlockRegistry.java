package dev.teamcitrusmods.factory_expansion.registry;

import cofh.thermal.core.ThermalCore;
import static cofh.thermal.core.util.RegistrationHelper.registerBlockAndItem;

import cofh.thermal.core.util.RegistrationHelper;
import dev.teamcitrusmods.factory_expansion.FactoryExpansion;
import dev.teamcitrusmods.factory_expansion.block.ComponentBlock;
import dev.teamcitrusmods.factory_expansion.block.FluxLampBlock;
import dev.teamcitrusmods.factory_expansion.block.BlastwallBlock;
import dev.teamcitrusmods.factory_expansion.block.PillarBlock;
import net.minecraft.client.resources.model.Material;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;


public class BlockRegistry {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, FactoryExpansion.MODID);

    public static final String ID_SLAG_BLOCK = "slag_block";
    public static final String ID_RICH_SLAG_BLOCK = "rich_slag_block";


    // --- THERMAL BLOCKS


    public static final RegistryObject<SlabBlock> SLAG_BLOCK_SLAB = registerBlock("slag_block_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(ThermalCore.BLOCKS.get(ID_SLAG_BLOCK))), CreativeModeTabRegistry.FACTORY_EXPANSION_TAB);
    public static final RegistryObject<StairBlock> SLAG_BLOCK_STAIRS = registerBlock("slag_block_stairs", () -> new StairBlock(() -> ThermalCore.BLOCKS.get(ID_SLAG_BLOCK).defaultBlockState(), BlockBehaviour.Properties.copy(ThermalCore.BLOCKS.get(ID_SLAG_BLOCK))), CreativeModeTabRegistry.FACTORY_EXPANSION_TAB);
    public static final RegistryObject<WallBlock> SLAG_BLOCK_WALL = registerBlock("slag_block_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(ThermalCore.BLOCKS.get(ID_SLAG_BLOCK))), CreativeModeTabRegistry.FACTORY_EXPANSION_TAB);

    public static final RegistryObject<SlabBlock> SLAG_BRICKS_SLAB = registerBlock("slag_bricks_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(ThermalCore.BLOCKS.get(ID_SLAG_BRICKS))), CreativeModeTabRegistry.FACTORY_EXPANSION_TAB);
    public static final RegistryObject<StairBlock> SLAG_BRICKS_STAIRS = registerBlock("slag_bricks_stairs", () -> new StairBlock(() -> ThermalCore.BLOCKS.get(ID_SLAG_BRICKS).defaultBlockState(), BlockBehaviour.Properties.copy(ThermalCore.BLOCKS.get(ID_SLAG_BRICKS))), CreativeModeTabRegistry.FACTORY_EXPANSION_TAB);
    public static final RegistryObject<WallBlock> SLAG_BRICKS_WALL = registerBlock("slag_bricks_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(ThermalCore.BLOCKS.get(ID_SLAG_BRICKS))), CreativeModeTabRegistry.FACTORY_EXPANSION_TAB);

    public static final RegistryObject<SlabBlock> RICH_SLAG_BLOCK_SLAB = registerBlock("rich_slag_block_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(ThermalCore.BLOCKS.get(ID_SLAG_BLOCK))), CreativeModeTabRegistry.FACTORY_EXPANSION_TAB);
    public static final RegistryObject<StairBlock> RICH_SLAG_BLOCK_STAIRS = registerBlock("rich_slag_block_stairs", () -> new StairBlock(() -> ThermalCore.BLOCKS.get(ID_SLAG_BLOCK).defaultBlockState(), BlockBehaviour.Properties.copy(ThermalCore.BLOCKS.get(ID_SLAG_BLOCK))), CreativeModeTabRegistry.FACTORY_EXPANSION_TAB);
    public static final RegistryObject<WallBlock> RICH_SLAG_BLOCK_WALL = registerBlock("rich_slag_block_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(ThermalCore.BLOCKS.get(ID_SLAG_BLOCK))), CreativeModeTabRegistry.FACTORY_EXPANSION_TAB);

    public static final RegistryObject<SlabBlock> RICH_SLAG_BRICKS_SLAB = registerBlock("rich_slag_bricks_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(ThermalCore.BLOCKS.get(ID_SLAG_BRICKS))), CreativeModeTabRegistry.FACTORY_EXPANSION_TAB);
    public static final RegistryObject<StairBlock> RICH_SLAG_BRICKS_STAIRS = registerBlock("rich_slag_bricks_stairs", () -> new StairBlock(() -> ThermalCore.BLOCKS.get(ID_SLAG_BRICKS).defaultBlockState(), BlockBehaviour.Properties.copy(ThermalCore.BLOCKS.get(ID_SLAG_BRICKS))), CreativeModeTabRegistry.FACTORY_EXPANSION_TAB);
    public static final RegistryObject<WallBlock> RICH_SLAG_BRICKS_WALL = registerBlock("rich_slag_bricks_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(ThermalCore.BLOCKS.get(ID_SLAG_BRICKS))), CreativeModeTabRegistry.FACTORY_EXPANSION_TAB);


    // --- FACTORY_EXPANSION BLOCKS

    public static final RegistryObject<Block> THERMAL_BRIGHT_PLATING = registerBlock("thermal_bright_plating", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)), CreativeModeTabRegistry.FACTORY_EXPANSION_TAB);
    public static final RegistryObject<RotatedPillarBlock> THERMAL_BRIGHT_HALVED_PLATING = registerBlock("thermal_bright_halved_plating", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)), CreativeModeTabRegistry.FACTORY_EXPANSION_TAB);
    public static final RegistryObject<SlabBlock> THERMAL_BRIGHT_HALVED_PLATING_SLAB = registerBlock("thermal_bright_halved_plating_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)), CreativeModeTabRegistry.FACTORY_EXPANSION_TAB);
    public static final RegistryObject<Block> THERMAL_BRIGHT_TILED_PLATING = registerBlock("thermal_bright_tiled_plating", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)), CreativeModeTabRegistry.FACTORY_EXPANSION_TAB);
    public static final RegistryObject<SlabBlock> THERMAL_BRIGHT_TILED_PLATING_SLAB = registerBlock("thermal_bright_tiled_plating_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)), CreativeModeTabRegistry.FACTORY_EXPANSION_TAB);
    public static final RegistryObject<StairBlock> THERMAL_BRIGHT_TILED_PLATING_STAIRS = registerBlock("thermal_bright_tiled_plating_stairs", () -> new StairBlock(() -> THERMAL_BRIGHT_TILED_PLATING.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)), CreativeModeTabRegistry.FACTORY_EXPANSION_TAB);

    public static final RegistryObject<Block> THERMAL_DARK_TILED_PLATING = registerBlock("thermal_dark_tiled_plating", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)), CreativeModeTabRegistry.FACTORY_EXPANSION_TAB);
    public static final RegistryObject<SlabBlock> THERMAL_DARK_TILED_PLATING_SLAB = registerBlock("thermal_dark_tiled_plating_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)), CreativeModeTabRegistry.FACTORY_EXPANSION_TAB);
    public static final RegistryObject<StairBlock> THERMAL_DARK_TILED_PLATING_STAIRS = registerBlock("thermal_dark_tiled_plating_stairs", () -> new StairBlock(() -> THERMAL_BRIGHT_TILED_PLATING.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)), CreativeModeTabRegistry.FACTORY_EXPANSION_TAB);
    public static final RegistryObject<RotatedPillarBlock> THERMAL_DARK_PIPE = registerBlock("thermal_dark_pipe", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)), CreativeModeTabRegistry.FACTORY_EXPANSION_TAB);

    // this one needs fixes
    public static final RegistryObject<Block> THERMAL_BRIGHT_DARK_TRANSITION = registerBlock("thermal_bright_dark_transition", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)), CreativeModeTabRegistry.FACTORY_EXPANSION_TAB);

    public static final RegistryObject<Block> SANDED_LEAD_BLOCK = registerBlock("sanded_lead_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)), CreativeModeTabRegistry.FACTORY_EXPANSION_TAB);

    public static final RegistryObject<Block> TREATED_PLANKS = registerBlock("treated_planks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), CreativeModeTabRegistry.FACTORY_EXPANSION_TAB);
    public static final RegistryObject<Block> TREATED_ENCASED_PLANKS = registerBlock("treated_encased_planks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), CreativeModeTabRegistry.FACTORY_EXPANSION_TAB);

    // these need custom behaviour
    public static final RegistryObject<Block> CLINKER_BRICKS = registerBlock("clinker_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.ANDESITE)), CreativeModeTabRegistry.FACTORY_EXPANSION_TAB);
    public static final RegistryObject<Block> MIXED_CLINKER_BRICKS = registerBlock("mixed_clinker_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.ANDESITE)), CreativeModeTabRegistry.FACTORY_EXPANSION_TAB);
    public static final RegistryObject<Block> SOULSAND_BRICKS = registerBlock("soulsand_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.ANDESITE)), CreativeModeTabRegistry.FACTORY_EXPANSION_TAB);
    public static final RegistryObject<Block> SOULSAND_BRICKS_EMPTY = registerBlock("soulsand_bricks_empty", () -> new Block(BlockBehaviour.Properties.copy(Blocks.ANDESITE)), CreativeModeTabRegistry.FACTORY_EXPANSION_TAB);
    public static final RegistryObject<Block> SOULSAND_BRICKS_LEFT = registerBlock("soulsand_bricks_left", () -> new Block(BlockBehaviour.Properties.copy(Blocks.ANDESITE)), CreativeModeTabRegistry.FACTORY_EXPANSION_TAB);
    public static final RegistryObject<Block> SOULSAND_BRICKS_RIGHT = registerBlock("soulsand_bricks_right", () -> new Block(BlockBehaviour.Properties.copy(Blocks.ANDESITE)), CreativeModeTabRegistry.FACTORY_EXPANSION_TAB);
    public static final RegistryObject<Block> WARM_CLINKER_BRICKS = registerBlock("warm_clinker_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.ANDESITE)), CreativeModeTabRegistry.FACTORY_EXPANSION_TAB);

    public static final RegistryObject<BlastwallBlock> EXPOSED_BLASTWALL = registerBlock("exposed_blastwall",
            () -> new BlastwallBlock(BlockBehaviour.Properties.copy(Blocks.ANDESITE)), CreativeModeTabRegistry.FACTORY_EXPANSION_TAB);

    public static final RegistryObject<BlastwallBlock> INVAR_TILES_DAMAGED_BLASTWALL = registerBlock("invar_tiles_damaged_blastwall",
            () ->new BlastwallBlock(BlockBehaviour.Properties.copy(Blocks.ANDESITE), 4, EXPOSED_BLASTWALL.get()), CreativeModeTabRegistry.FACTORY_EXPANSION_TAB);


    public static final RegistryObject<BlastwallBlock> INVAR_TILES_BLASTWALL = registerBlock("invar_tiles_blastwall",
            () ->new BlastwallBlock(BlockBehaviour.Properties.copy(Blocks.ANDESITE), INVAR_TILES_DAMAGED_BLASTWALL.get()), CreativeModeTabRegistry.FACTORY_EXPANSION_TAB);



    public static final RegistryObject<PillarBlock> DEFAULT_PILLAR = registerBlock("default_pillar",
            () -> new PillarBlock(BlockBehaviour.Properties.copy(Blocks.ANDESITE)), CreativeModeTabRegistry.FACTORY_EXPANSION_TAB);

    public static final RegistryObject<FluxLampBlock> FLUX_LAMP = registerBlock("flux_lamp",
            () -> new FluxLampBlock(BlockBehaviour.Properties
                    .copy(Blocks.IRON_BLOCK)
                    .strength(6f)
                    .requiresCorrectToolForDrops()
                    .lightLevel(litBlockEmission(15))
                    .noOcclusion()), CreativeModeTabRegistry.FACTORY_EXPANSION_TAB);

    public static final RegistryObject<FluxLampBlock> FLUX_LAMP_INVERTED = registerBlock("flux_lamp_inverted",
            () -> new FluxLampBlock(BlockBehaviour.Properties
                    .copy(Blocks.IRON_BLOCK)
                    .strength(6f)
                    .requiresCorrectToolForDrops()
                    .lightLevel(litBlockEmission(0))
                    .noOcclusion()), CreativeModeTabRegistry.FACTORY_EXPANSION_TAB);

    public static final RegistryObject<ComponentBlock> HARDENED_COMPONENT_BLOCK = registerBlock("hardened_component_block",
            () -> new ComponentBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)), CreativeModeTabRegistry.FACTORY_EXPANSION_TAB);

    public static final RegistryObject<ComponentBlock> REINFORCED_COMPONENT_BLOCK = registerBlock("reinforced_component_block",
            () -> new ComponentBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)), CreativeModeTabRegistry.FACTORY_EXPANSION_TAB);
    public static final RegistryObject<ComponentBlock> RESONANT_COMPONENT_BLOCK = registerBlock("resonant_component_block",
            () -> new ComponentBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)), CreativeModeTabRegistry.FACTORY_EXPANSION_TAB);



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
        return ItemRegistry.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}