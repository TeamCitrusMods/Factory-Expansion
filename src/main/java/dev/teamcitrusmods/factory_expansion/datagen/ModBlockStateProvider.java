package dev.teamcitrusmods.factory_expansion.datagen;

import cofh.thermal.core.ThermalCore;
import dev.teamcitrusmods.factory_expansion.FactoryExpansion;
import dev.teamcitrusmods.factory_expansion.block.ModBlocks;
import dev.teamcitrusmods.factory_expansion.datagen.ModItemModelProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.*;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

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
        // delete these, not going to be in the final mod
        simpleBlockWithItem(ModBlocks.SMILE.get());
        slabBlockWithItem(ModBlocks.SMILE_SLAB.get(), ModBlocks.SMILE.get());
        stairsBlockWithItem(ModBlocks.SMILE_STAIRS.get(), ModBlocks.SMILE.get());
        wallBlockWithItem(ModBlocks.SMILE_WALL.get(), ModBlocks.SMILE.get());

        slabBlockUncheckedWithItem(ModBlocks.SLAG_BLOCK_SLAB.get(), blockTexture(ThermalCore.BLOCKS.get(ID_SLAG_BLOCK)), new ResourceLocation("thermal", "block/slag_block"));
        stairsBlockUncheckedWithItem(ModBlocks.SLAG_BLOCK_STAIRS.get(), new ResourceLocation("thermal", "block/slag_block"));
        wallBlockUncheckedWithItem(ModBlocks.SLAG_BLOCK_WALL.get(), new ResourceLocation("thermal", "block/slag_block"));

        slabBlockUncheckedWithItem(ModBlocks.SLAG_BRICKS_SLAB.get(), blockTexture(ThermalCore.BLOCKS.get(ID_SLAG_BRICKS)), new ResourceLocation("thermal", "block/slag_bricks"));
        stairsBlockUncheckedWithItem(ModBlocks.SLAG_BRICKS_STAIRS.get(), new ResourceLocation("thermal", "block/slag_bricks"));
        wallBlockUncheckedWithItem(ModBlocks.SLAG_BRICKS_WALL.get(), new ResourceLocation("thermal", "block/slag_bricks"));

        simpleBlockPathWithItem(ModBlocks.THERMAL_BRIGHT_PLATING.get(), "factory_expansion:block/thermal/bright/plating");

        axisBlockPathWithItem(ModBlocks.THERMAL_BRIGHT_HALVED_PLATING.get(), "factory_expansion:block/thermal/bright/halved_plating", "factory_expansion:block/thermal/bright/plating");
        slabBlockPathWithItem(ModBlocks.THERMAL_BRIGHT_HALVED_PLATING_SLAB.get(), ModBlocks.THERMAL_BRIGHT_HALVED_PLATING.get(), "factory_expansion:block/thermal/bright/halved_plating", "factory_expansion:block/thermal/bright/plating", "factory_expansion:block/thermal/bright/plating");

        simpleBlockPathWithItem(ModBlocks.THERMAL_BRIGHT_TILED_PLATING.get(), "factory_expansion:block/thermal/bright/tiled_plating");
        slabBlockPathWithItem(ModBlocks.THERMAL_BRIGHT_TILED_PLATING_SLAB.get(), ModBlocks.THERMAL_BRIGHT_TILED_PLATING.get(), "factory_expansion:block/thermal/bright/tiled_plating", "factory_expansion:block/thermal/bright/tiled_plating", "factory_expansion:block/thermal/bright/tiled_plating");
        stairsBlockPathWithItem(ModBlocks.THERMAL_BRIGHT_TILED_PLATING_STAIRS.get(), "factory_expansion:block/thermal/bright/tiled_plating");

        simpleBlockPathWithItem(ModBlocks.THERMAL_DARK_TILED_PLATING.get(), "factory_expansion:block/thermal/dark/tiled_plating");
        slabBlockPathWithItem(ModBlocks.THERMAL_DARK_TILED_PLATING_SLAB.get(), ModBlocks.THERMAL_BRIGHT_TILED_PLATING.get(), "factory_expansion:block/thermal/dark/tiled_plating", "factory_expansion:block/thermal/dark/tiled_plating", "factory_expansion:block/thermal/dark/tiled_plating");
        stairsBlockPathWithItem(ModBlocks.THERMAL_DARK_TILED_PLATING_STAIRS.get(), "factory_expansion:block/thermal/dark/tiled_plating");

        axisBlockPathWithItem(ModBlocks.THERMAL_DARK_PIPE.get(), "factory_expansion:block/thermal/dark/pipe_side", "factory_expansion:block/thermal/dark/pipe_end");

        simpleBlockPathWithItem(ModBlocks.MANA_CRYSTAL_BLOCK.get(), "factory_expansion:block/mana_crystal/block");
        simpleBlockPathWithItem(ModBlocks.MANA_CRYSTAL_BLOCK_ACTIVE.get(), "factory_expansion:block/mana_crystal/block_active");
        simpleBlockPathWithItem(ModBlocks.MANA_CRYSTAL_POLISHED.get(), "factory_expansion:block/mana_crystal/polished");
        simpleBlockPathWithItem(ModBlocks.MANA_CRYSTAL_POLISHED_ACTIVE.get(), "factory_expansion:block/mana_crystal/polished_active");



        /* tests
        FactoryExpansion.LOGGER.info("------------------------");
        FactoryExpansion.LOGGER.info("------------------------");
        FactoryExpansion.LOGGER.info("SMILE.toString():\n\t" + ModBlocks.SMILE.toString());
        //net.minecraftforge.registries.RegistryObject@63b787e
        FactoryExpansion.LOGGER.info("SMILE.get():\n\t" + ModBlocks.SMILE.get());
        //Block{factory_expansion:smile}
        FactoryExpansion.LOGGER.info("SMILE.getId():\n\t" + ModBlocks.SMILE.getId());
        //factory_expansion:smile
        FactoryExpansion.LOGGER.info("SMILE.getKey():\n\t" + ModBlocks.SMILE.getKey());
        //ResourceKey[minecraft:block / factory_expansion:smile]
        FactoryExpansion.LOGGER.info("SMILE.get().defaultBlockState():\n\t"+ ModBlocks.SMILE.get().defaultBlockState());
        //Block{factory_expansion:smile}
        FactoryExpansion.LOGGER.info("SMILE.get().getDescriptionId:\n\t" + ModBlocks.SMILE.get().getDescriptionId());
        //block.factory_expansion.smile
        FactoryExpansion.LOGGER.info("SMILE.get().getStateDefinition():\n\t" + ModBlocks.SMILE.get().getStateDefinition());
        //StateDefinition{block=Block{factory_expansion:smile}, properties=[]}
        FactoryExpansion.LOGGER.info("SMILE.get().toString:\n\t" + ModBlocks.SMILE.get().toString());
        //Block{factory_expansion:smile}
        FactoryExpansion.LOGGER.info("blockTexture(SMILE.get()):\n\t" + blockTexture(ModBlocks.SMILE.get()));
        //factory_expansion:block/smile <-- <-- <--
        FactoryExpansion.LOGGER.info("models().getExistingFile(blockTexture(SMILE.get())):\n\t" + models().getExistingFile(blockTexture(ModBlocks.SMILE.get())));
        //net.minecraftforge.client.model.generators.ModelFile$ExistingModelFile@389c624
        FactoryExpansion.LOGGER.info("ForgeRegistries.BLOCKS.getKey(SMILE.get()):\n\t" + ForgeRegistries.BLOCKS.getKey(ModBlocks.SMILE.get()));
        //factory_expansion:smile
        FactoryExpansion.LOGGER.info("ForgeRegistries.BLOCKS.getKey(SMILE.get()).getPath():\n\t" + ForgeRegistries.BLOCKS.getKey(ModBlocks.SMILE.get()).getPath());
        //smile
        FactoryExpansion.LOGGER.info("------------------------");
        FactoryExpansion.LOGGER.info("------------------------");
        */

    }


    /*
    * These Helper Methods are used for block models registration.
    *
    * Special thanks to Vivividly for helping me (especially for DEPENDENCIES BLOCKS) - https://github.com/Vivividly
    * */

    // --- NORMAL BLOCKS (resources located in default assets folders)

    public void simpleBlockWithItem(Block block) {
        simpleBlock(block);
        simpleBlockItem(block, models().getExistingFile(blockTexture(block)));
    }

    public void slabBlockWithItem(SlabBlock slab, Block block) {
        // the actual slab, the model for the full block
        slabBlock(slab, blockTexture(block), blockTexture(block));
        simpleBlockItem(slab, models().getExistingFile(blockTexture(slab)));
    }

    public void stairsBlockWithItem(StairBlock stair, Block block) {
        // the actual stair, the texture to apply
        stairsBlock(stair, blockTexture(block));
        simpleBlockItem(stair, models().getExistingFile(blockTexture(stair)));
    }

    // IMPORTANT: walls also need proper tags to connect and item model
    public void wallBlockWithItem(WallBlock wall, Block block) {
        // the actual wall, the texture to apply
        wallBlock(wall, blockTexture(block));
    }


    // TODO: fences, trapdoors, ...


    // --- CUSTOM PATH BLOCKS (resources located in nested folders or other particular textures)

    public void simpleBlockPathWithItem(Block block, String texture) {
        // the actual block, block/path/to/texture
        simpleBlock(block, models().cubeAll(ForgeRegistries.BLOCKS.getKey(block).getPath(), new ResourceLocation(texture)));
        simpleBlockItem(block, models().getExistingFile(blockTexture(block)));
    }    
    
    public void axisBlockPathWithItem(RotatedPillarBlock block, String side, String end) {
        axisBlock(block,
                models().cubeColumn(ForgeRegistries.BLOCKS.getKey(block).getPath(), new ResourceLocation(side), new ResourceLocation(end)),
                models().cubeColumnHorizontal(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_horizontal", new ResourceLocation(side), new ResourceLocation(end)));
        simpleBlockItem(block, models().getExistingFile(blockTexture(block)));
    }

    public void slabBlockPathWithItem(SlabBlock slab, Block block, String side, String bottom, String top) {
        // the actual slab, the model for the full block, the side bottom and top textures
        slabBlock(slab, blockTexture(block), new ResourceLocation(side), new ResourceLocation(bottom), new ResourceLocation(top));
        simpleBlockItem(slab, models().getExistingFile(blockTexture(slab)));
    }

    public void stairsBlockPathWithItem(StairBlock stair, String texture) {
        // the actual stair, the texture to apply
        stairsBlock(stair, new ResourceLocation(texture));
        simpleBlockItem(stair, models().getExistingFile(blockTexture(stair)));
    }


    // --- DEPENDENCIES BLOCKS (resources from other mods)

    /**
     * Identical to {@link BlockStateProvider#slabBlock(SlabBlock, ResourceLocation, ResourceLocation)}
     * however does not check if the texture or model exists. Use for modded textures/models
     */
    public void slabBlockUncheckedWithItem(SlabBlock slab, ResourceLocation doubleslab, ResourceLocation texture) {
        existingFileHelper.trackGenerated(texture, TEXTURE);
        existingFileHelper.trackGenerated(doubleslab, MODEL);

        slabBlock(slab, doubleslab, texture);
        simpleBlockItem(slab, models().getExistingFile(blockTexture(slab)));
    }

    public void stairsBlockUncheckedWithItem(StairBlock stair, ResourceLocation texture) {
        existingFileHelper.trackGenerated(texture, TEXTURE);

        stairsBlock(stair, texture);
        simpleBlockItem(stair, models().getExistingFile(blockTexture(stair)));
    }

    // IMPORTANT: walls also need proper tags to connect and item model
    public void wallBlockUncheckedWithItem(WallBlock wall, ResourceLocation texture) {
        existingFileHelper.trackGenerated(texture, TEXTURE);

        wallBlock(wall ,texture);
    }
}
