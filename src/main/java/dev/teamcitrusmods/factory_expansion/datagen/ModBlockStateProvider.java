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
import net.minecraftforge.client.model.generators.*;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import static cofh.thermal.lib.common.ThermalIDs.ID_SLAG_BLOCK;
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
        slabBlockUncheckedWithItem(ModBlocks.SLAG_BLOCK_SLAB.get(), blockTexture(ThermalCore.BLOCKS.get(ID_SLAG_BLOCK)), new ResourceLocation("thermal", "block/slag_block"));
        stairsBlockUncheckedWithItem(ModBlocks.SLAG_BLOCK_STAIRS.get(), blockTexture((ThermalCore.BLOCKS.get(ID_SLAG_BLOCK))));

        slabBlockUncheckedWithItem(ModBlocks.SLAG_BRICKS_SLAB.get(), blockTexture(ThermalCore.BLOCKS.get(ID_SLAG_BRICKS)), new ResourceLocation("thermal", "block/slag_bricks"));
        stairsBlockUncheckedWithItem(ModBlocks.SLAG_BRICKS_STAIRS.get(), blockTexture((ThermalCore.BLOCKS.get(ID_SLAG_BRICKS))));

        simpleBlockPathWithItem(ModBlocks.LIGHT_THERMAL_PLATING, new ResourceLocation("factory_expansion:block/thermal/bright/plating"));

        simpleBlockPathWithItem(ModBlocks.TILED_LIGHT_THERMAL_PLATING, new ResourceLocation("factory_expansion:block/thermal/bright/tiled_plating"));
        // stairsBlockWithItem(ModBlocks.TILED_LIGHT_THERMAL_PLATING_STAIRS.get(), blockTexture(ModBlocks.TILED_LIGHT_THERMAL_PLATING.get()));
        // slabBlockWithItem(ModBlocks.TILED_LIGHT_THERMAL_PLATING_SLAB.get(), blockTexture(ModBlocks.TILED_LIGHT_THERMAL_PLATING.get()), blockTexture(ModBlocks.TILED_LIGHT_THERMAL_PLATING.get()));

        simpleBlockPathWithItem(ModBlocks.DARK_THERMAL_PLATING, new ResourceLocation("factory_expansion:block/thermal/dark/tiled_plating"));

        // simpleBlockWithItem(ModBlocks.DARK_THERMAL_PLATING.get());

        // simpleBlockWithItem(ModBlocks.TILED_DARK_THERMAL_PLATING.get());

        // simpleBlockWithItem(ModBlocks.MANA_CRYSTAL_BLOCK.get());

        // simpleBlockWithItem(ModBlocks.MANA_CRYSTAL_BLOCK_ACTIVE.get());
    }

    public void simpleBlockPath(RegistryObject<Block> block, ResourceLocation texture) {
        simpleBlock(block.get(),
                this.models().cubeAll(block.getId().getPath(),
                        texture));
    }

    public void simpleBlockPathWithItem(RegistryObject<Block> block, ResourceLocation texture) {
        simpleBlockPath(block, texture);
        simpleBlockItem(block.get(), models().getExistingFile(blockTexture(block.get())));
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

    public void stairsBlockUnchecked(StairBlock block, ResourceLocation texture) {
        existingFileHelper.trackGenerated(texture, TEXTURE);

        stairsBlock(block, texture);
    }


    public void simpleBlockWithItem(Block block) {
        simpleBlock(block);
        simpleBlockItem(block, models().getExistingFile(blockTexture(block)));
    }

    public void stairsBlockWithItem(StairBlock block, ResourceLocation texture) {
        stairsBlock(block, texture);
        simpleBlockItem(block, models().getExistingFile(blockTexture(block)));
    }

    public void stairsBlockUncheckedWithItem(StairBlock block, ResourceLocation texture) {
        stairsBlockUnchecked(block, texture);
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
