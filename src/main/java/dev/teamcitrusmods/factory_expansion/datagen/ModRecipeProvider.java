package dev.teamcitrusmods.factory_expansion.datagen;

import dev.teamcitrusmods.factory_expansion.block.ModBlocks;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> pFinishedRecipeConsumer) {

        ShapedRecipeBuilder.shaped(ModBlocks.TILED_LIGHT_THERMAL_PLATING.get(), 4)
                .define('L', ModBlocks.LIGHT_THERMAL_PLATING.get())
                .pattern("LL")
                .pattern("LL")
                .unlockedBy("has_light_thermal_plating",
                        inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.LIGHT_THERMAL_PLATING.get()).build()))
                .save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(ModBlocks.TILED_DARK_THERMAL_PLATING.get(), 4)
                .define('D', ModBlocks.DARK_THERMAL_PLATING.get())
                .pattern("DD")
                .pattern("DD")
                .unlockedBy("has_dark_thermal_plating",
                        inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.DARK_THERMAL_PLATING.get()).build()))
                .save(pFinishedRecipeConsumer);
    }
}
