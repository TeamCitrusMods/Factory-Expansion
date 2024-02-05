package dev.teamcitrusmods.factory_expansion.datagen;

import dev.teamcitrusmods.factory_expansion.FactoryExpansion;
import dev.teamcitrusmods.factory_expansion.datagen.provider.ModBlockStateProvider;
import dev.teamcitrusmods.factory_expansion.datagen.provider.ModBlockTagProvider;
import dev.teamcitrusmods.factory_expansion.datagen.provider.ModItemModelProvider;
import dev.teamcitrusmods.factory_expansion.datagen.provider.ModRecipeProvider;
import net.minecraft.data.DataGenerator;
//import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.DataProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = FactoryExpansion.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper file = event.getExistingFileHelper();

        ModBlockStateProvider blockStateProvider = new ModBlockStateProvider(generator, file);
        ModItemModelProvider itemModelProvider = new ModItemModelProvider(generator, file);
        // ModLootTableProvider lootTableProvider = new ModLootTableProvider(generator, file);
        ModRecipeProvider recipeProvider = new ModRecipeProvider(generator);

        generator.addProvider(event.includeClient(), blockStateProvider);
        generator.addProvider(event.includeClient(), itemModelProvider);
        // generator.addProvider(event.includeClient(), lootTableProvider);
        generator.addProvider(event.includeClient(), recipeProvider);

        ModBlockTagProvider blockTags = new ModBlockTagProvider(generator, file);
        // ! ! ! generator.addProvider(event.includeClient(), DataProvider.Factory<blockTags>);
    }
}
