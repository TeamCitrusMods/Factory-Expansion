package dev.teamcitrusmods.factory_expansion.datagen;

import cofh.thermal.core.ThermalCore;
import dev.teamcitrusmods.factory_expansion.FactoryExpansion;
import dev.teamcitrusmods.factory_expansion.block.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import static cofh.thermal.lib.common.ThermalIDs.ID_SLAG_BRICKS;


public class ModBlockStateProvider extends BlockStateProvider {

    private static final ExistingFileHelper.ResourceType MODEL = new ExistingFileHelper.ResourceType(PackType.CLIENT_RESOURCES, ".json", "models");
    private static final ExistingFileHelper.ResourceType TEXTURE = new ExistingFileHelper.ResourceType(PackType.CLIENT_RESOURCES, ".png", "textures");
    private final ExistingFileHelper existingFileHelper;
    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, FactoryExpansion.MODID, exFileHelper);
        this.existingFileHelper = exFileHelper;
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlockWithItem(ModBlocks.LIGHT_THERMAL_PLATING.get());

        simpleBlockWithItem(ModBlocks.TILED_LIGHT_THERMAL_PLATING.get());

        stairsBlockWithItem(ModBlocks.TILED_LIGHT_THERMAL_PLATING_STAIRS.get(), blockTexture(ModBlocks.TILED_LIGHT_THERMAL_PLATING.get()));

        simpleBlockWithItem(ModBlocks.DARK_THERMAL_PLATING.get());

        simpleBlockWithItem(ModBlocks.TILED_DARK_THERMAL_PLATING.get());

        slabBlockUncheckedWithItem(ModBlocks.SLAG_BRICKS_SLAB.get(), blockTexture(ThermalCore.BLOCKS.get(ID_SLAG_BRICKS)), new ResourceLocation("thermal", "block/slag_bricks"));
    }

    /**
     * Identical to {@link BlockStateProvider#slabBlock(SlabBlock, ResourceLocation, ResourceLocation)}
     * however does not check if the texture or model exists. Use for modded textures/models
     */
    public void slabBlockUnchecked(SlabBlock block, ResourceLocation doubleslab, ResourceLocation texture) {
        existingFileHelper.trackGenerated(texture, TEXTURE);
        existingFileHelper.trackGenerated(doubleslab, MODEL);

        slabBlock(block, doubleslab, texture);
    }


    public void simpleBlockWithItem(Block block) {
        simpleBlock(block);
        simpleBlockItem(block, models().getExistingFile(blockTexture(block)));
    }

    public void stairsBlockWithItem(StairBlock block, ResourceLocation texture) {
        stairsBlock(block, texture);
        simpleBlockItem(block, models().getExistingFile(blockTexture(block)));
    }

    public void slabBlockWithItem(SlabBlock block, ResourceLocation doubleslab, ResourceLocation texture) {
        slabBlock(block, doubleslab, texture);
        simpleBlockItem(block, models().getExistingFile(blockTexture(block)));
    }

    public void slabBlockUncheckedWithItem(SlabBlock block, ResourceLocation doubleslab, ResourceLocation texture) {
        slabBlockUnchecked(block, doubleslab, texture);
        simpleBlockItem(block, models().getExistingFile(blockTexture(block)));
    }
}
