package dev.teamcitrusmods.factory_expansion.datagen;

import dev.teamcitrusmods.factory_expansion.FactoryExpansion;
import dev.teamcitrusmods.factory_expansion.block.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(DataGenerator pGenerator, @Nullable ExistingFileHelper existingFileHelper) {
        super(pGenerator, FactoryExpansion.MODID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        this.tag(BlockTags.WALLS).add(ModBlocks.SMILE_WALL.get());
        this.tag(BlockTags.WALLS).add(ModBlocks.SLAG_BLOCK_WALL.get());
        this.tag(BlockTags.WALLS).add(ModBlocks.SLAG_BRICKS_WALL.get());
        this.tag(BlockTags.WALLS).add(ModBlocks.RICH_SLAG_BLOCK_WALL.get());
        this.tag(BlockTags.WALLS).add(ModBlocks.RICH_SLAG_BRICKS_WALL.get());
    }
}
