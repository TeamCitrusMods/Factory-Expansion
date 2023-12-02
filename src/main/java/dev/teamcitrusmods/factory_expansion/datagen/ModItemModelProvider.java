package dev.teamcitrusmods.factory_expansion.datagen;

import dev.teamcitrusmods.factory_expansion.FactoryExpansion;
import dev.teamcitrusmods.factory_expansion.block.ModBlocks;
import dev.teamcitrusmods.factory_expansion.item.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WallBlock;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    private static final ExistingFileHelper.ResourceType TEXTURE = new ExistingFileHelper.ResourceType(PackType.CLIENT_RESOURCES, ".png", "textures");
    private final ExistingFileHelper existingFileHelper;
    public ModItemModelProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, FactoryExpansion.MODID, exFileHelper);
        this.existingFileHelper = exFileHelper;
    }

    @Override
    public void registerModels() {
        simpleItem(ModItems.MANA_CRYSTAL);

        simpleItem(ModItems.MANA_CRYSTAL_ACTIVE);

        wallItem(ModBlocks.SMILE_WALL.get(), ModBlocks.SMILE.get());
        wallItemUnchecked(ModBlocks.SLAG_BLOCK_WALL.get(), new ResourceLocation("thermal", "block/slag_block"));
        wallItemUnchecked(ModBlocks.SLAG_BRICKS_WALL.get(), new ResourceLocation("thermal", "block/slag_bricks"));
    }


    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(FactoryExpansion.MODID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(FactoryExpansion.MODID,"item/" + item.getId().getPath()));
    }

    public void wallItem(WallBlock wall, Block block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(wall).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall", new ResourceLocation(FactoryExpansion.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(block).getPath()));
    }

    public void wallItemUnchecked(WallBlock wall, ResourceLocation texture) {
        existingFileHelper.trackGenerated(texture , TEXTURE);
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(wall).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall", texture);
    }

}
