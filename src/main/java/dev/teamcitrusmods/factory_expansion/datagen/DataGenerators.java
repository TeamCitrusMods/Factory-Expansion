package dev.teamcitrusmods.factory_expansion.datagen;

import dev.teamcitrusmods.factory_expansion.FactoryExpansion;
import net.minecraft.data.DataGenerator;
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
    }
}
