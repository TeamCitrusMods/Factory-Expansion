package dev.teamcitrusmods.factory_expansion.datagen.provider;

import dev.teamcitrusmods.factory_expansion.FactoryExpansion;
import dev.teamcitrusmods.factory_expansion.registry.BlockRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(DataGenerator pGenerator, @Nullable ExistingFileHelper existingFileHelper) {
        super(pGenerator, FactoryExpansion.MODID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        this.tag(BlockTags.WALLS).add(BlockRegistry.SLAG_BLOCK_WALL.get());
        this.tag(BlockTags.WALLS).add(BlockRegistry.SLAG_BRICKS_WALL.get());
        this.tag(BlockTags.WALLS).add(BlockRegistry.RICH_SLAG_BLOCK_WALL.get());
        this.tag(BlockTags.WALLS).add(BlockRegistry.RICH_SLAG_BRICKS_WALL.get());

        this.tag(BlockTags.FENCES).add(BlockRegistry.EXPOSED_BLASTWALL.get());
    }
}
