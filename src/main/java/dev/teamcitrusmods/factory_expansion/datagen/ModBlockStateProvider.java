package dev.teamcitrusmods.factory_expansion.datagen;

import dev.teamcitrusmods.factory_expansion.FactoryExpansion;
import dev.teamcitrusmods.factory_expansion.block.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;


public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, FactoryExpansion.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(ModBlocks.LIGHT_THERMAL_PLATING.get());
        simpleBlockItem(ModBlocks.LIGHT_THERMAL_PLATING.get(), cubeAll(ModBlocks.LIGHT_THERMAL_PLATING.get()));

        simpleBlock(ModBlocks.TILED_LIGHT_THERMAL_PLATING.get());
        simpleBlockItem(ModBlocks.TILED_LIGHT_THERMAL_PLATING.get(), cubeAll(ModBlocks.TILED_LIGHT_THERMAL_PLATING.get()));

        stairsBlock(ModBlocks.TILED_LIGHT_THERMAL_PLATING_STAIRS.get(), blockTexture(ModBlocks.TILED_LIGHT_THERMAL_PLATING.get()));
        simpleBlockItem(ModBlocks.TILED_LIGHT_THERMAL_PLATING_STAIRS.get(), models().withExistingParent("tiled_light_thermal_plating_stairs", "stairs"));

        simpleBlock(ModBlocks.DARK_THERMAL_PLATING.get());
        simpleBlockItem(ModBlocks.DARK_THERMAL_PLATING.get(), cubeAll(ModBlocks.DARK_THERMAL_PLATING.get()));

        simpleBlock(ModBlocks.TILED_DARK_THERMAL_PLATING.get());
        simpleBlockItem(ModBlocks.TILED_DARK_THERMAL_PLATING.get(), cubeAll(ModBlocks.TILED_DARK_THERMAL_PLATING.get()));

        /*
        slabBlock(ModBlocks.SLAG_BRICKS_SLAB.get(),
                blockTexture(ThermalCore.BLOCKS.get(ID_SLAG_BRICKS)),
                new ResourceLocation("thermal", "block/slag_bricks"),
                new ResourceLocation("thermal", "block/slag_bricks"),
                new ResourceLocation("thermal", "block/slag_bricks"));

         */
    }
}
