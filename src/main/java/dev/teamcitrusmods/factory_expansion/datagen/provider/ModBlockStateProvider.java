package dev.teamcitrusmods.factory_expansion.datagen.provider;

import cofh.thermal.core.ThermalCore;
import dev.teamcitrusmods.factory_expansion.FactoryExpansion;
import dev.teamcitrusmods.factory_expansion.registry.BlockRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.*;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

import static cofh.thermal.lib.common.ThermalIDs.*;

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

        slabBlockUncheckedWithItem(BlockRegistry.SLAG_BLOCK_SLAB.get(), blockTexture(ThermalCore.BLOCKS.get(ID_SLAG_BLOCK)), new ResourceLocation("thermal", "block/slag_block"));
        stairsBlockUncheckedWithItem(BlockRegistry.SLAG_BLOCK_STAIRS.get(), new ResourceLocation("thermal", "block/slag_block"));
        wallBlockUncheckedWithItem(BlockRegistry.SLAG_BLOCK_WALL.get(), new ResourceLocation("thermal", "block/slag_block"));

        slabBlockUncheckedWithItem(BlockRegistry.SLAG_BRICKS_SLAB.get(), blockTexture(ThermalCore.BLOCKS.get(ID_SLAG_BRICKS)), new ResourceLocation("thermal", "block/slag_bricks"));
        stairsBlockUncheckedWithItem(BlockRegistry.SLAG_BRICKS_STAIRS.get(), new ResourceLocation("thermal", "block/slag_bricks"));
        wallBlockUncheckedWithItem(BlockRegistry.SLAG_BRICKS_WALL.get(), new ResourceLocation("thermal", "block/slag_bricks"));

        slabBlockUncheckedWithItem(BlockRegistry.RICH_SLAG_BLOCK_SLAB.get(), blockTexture(ThermalCore.BLOCKS.get(ID_RICH_SLAG_BLOCK)), new ResourceLocation("thermal", "block/rich_slag_block"));
        stairsBlockUncheckedWithItem(BlockRegistry.RICH_SLAG_BLOCK_STAIRS.get(), new ResourceLocation("thermal", "block/rich_slag_block"));
        wallBlockUncheckedWithItem(BlockRegistry.RICH_SLAG_BLOCK_WALL.get(), new ResourceLocation("thermal", "block/rich_slag_block"));

        slabBlockUncheckedWithItem(BlockRegistry.RICH_SLAG_BRICKS_SLAB.get(), blockTexture(ThermalCore.BLOCKS.get(ID_RICH_SLAG_BRICKS)), new ResourceLocation("thermal", "block/rich_slag_bricks"));
        stairsBlockUncheckedWithItem(BlockRegistry.RICH_SLAG_BRICKS_STAIRS.get(), new ResourceLocation("thermal", "block/rich_slag_bricks"));
        wallBlockUncheckedWithItem(BlockRegistry.RICH_SLAG_BRICKS_WALL.get(), new ResourceLocation("thermal", "block/rich_slag_bricks"));

        simpleBlockPathWithItem(BlockRegistry.THERMAL_BRIGHT_PLATING.get(), "factory_expansion:block/thermal/bright/plating");

        axisBlockPathWithItem(BlockRegistry.THERMAL_BRIGHT_HALVED_PLATING.get(), "factory_expansion:block/thermal/bright/halved_plating", "factory_expansion:block/thermal/bright/plating");
        slabBlockPathWithItem(BlockRegistry.THERMAL_BRIGHT_HALVED_PLATING_SLAB.get(), BlockRegistry.THERMAL_BRIGHT_HALVED_PLATING.get(), "factory_expansion:block/thermal/bright/halved_plating", "factory_expansion:block/thermal/bright/plating", "factory_expansion:block/thermal/bright/plating");

        simpleBlockPathWithItem(BlockRegistry.THERMAL_BRIGHT_TILED_PLATING.get(), "factory_expansion:block/thermal/bright/tiled_plating");
        slabBlockPathWithItem(BlockRegistry.THERMAL_BRIGHT_TILED_PLATING_SLAB.get(), BlockRegistry.THERMAL_BRIGHT_TILED_PLATING.get(), "factory_expansion:block/thermal/bright/tiled_plating", "factory_expansion:block/thermal/bright/tiled_plating", "factory_expansion:block/thermal/bright/tiled_plating");
        stairsBlockPathWithItem(BlockRegistry.THERMAL_BRIGHT_TILED_PLATING_STAIRS.get(), "factory_expansion:block/thermal/bright/tiled_plating");

        simpleBlockPathWithItem(BlockRegistry.THERMAL_DARK_TILED_PLATING.get(), "factory_expansion:block/thermal/dark/tiled_plating");
        slabBlockPathWithItem(BlockRegistry.THERMAL_DARK_TILED_PLATING_SLAB.get(), BlockRegistry.THERMAL_BRIGHT_TILED_PLATING.get(), "factory_expansion:block/thermal/dark/tiled_plating", "factory_expansion:block/thermal/dark/tiled_plating", "factory_expansion:block/thermal/dark/tiled_plating");
        stairsBlockPathWithItem(BlockRegistry.THERMAL_DARK_TILED_PLATING_STAIRS.get(), "factory_expansion:block/thermal/dark/tiled_plating");

        axisBlockPathWithItem(BlockRegistry.THERMAL_DARK_PIPE.get(), "factory_expansion:block/thermal/dark/pipe_side", "factory_expansion:block/thermal/dark/pipe_end");


        //simpleBlockPathWithItem(BlockRegistry.INDUSTRIAL_ROUGH_TILES.get(), "factory_expansion:block/industrial/rough_tiles/rough_tiles");
        //simpleBlockPathWithItem(BlockRegistry.INDUSTRIAL_ROUGH_TILES_WALL.get(), "factory_expansion:block/industrial/rough_tiles/exposed_wall");



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
