package fuzs.illagerinvasion.data;

import java.util.function.Consumer;

import fuzs.illagerinvasion.init.ModRegistry;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraftforge.data.event.GatherDataEvent;

public class ModRecipeProvider extends RecipeProvider {

    public ModRecipeProvider(GatherDataEvent evt, String modId) {
        super(evt.getGenerator());
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> exporter) {
        ShapedRecipeBuilder.shaped(ModRegistry.HALLOWED_GEM_ITEM.get())
                .define('#', Items.AMETHYST_SHARD)
                .define('B', ModRegistry.UNUSUAL_DUST_ITEM.get())
                .define('R', ModRegistry.ILLUSIONARY_DUST_ITEM.get())
                .define('D', Items.DIAMOND)
                .pattern("#B#")
                .pattern("RDR")
                .pattern("#B#")
                .unlockedBy(getHasName(ModRegistry.UNUSUAL_DUST_ITEM.get()), has(ModRegistry.UNUSUAL_DUST_ITEM.get()))
                .unlockedBy(getHasName(ModRegistry.ILLUSIONARY_DUST_ITEM.get()), has(ModRegistry.ILLUSIONARY_DUST_ITEM.get()))
                .save(exporter);
        ShapedRecipeBuilder.shaped(ModRegistry.IMBUIING_TABLE_ITEM.get())
                .define('#', Items.COPPER_BLOCK)
                .define('P', Items.PAPER)
                .define('O', Items.DARK_OAK_LOG)
                .define('S', ModRegistry.PRIMAL_ESSENCE_ITEM.get())
                .define('E', Items.EXPERIENCE_BOTTLE)
                .pattern("#P#")
                .pattern("OSO")
                .pattern("#E#")
                .unlockedBy(getHasName(ModRegistry.PRIMAL_ESSENCE_ITEM.get()), has(ModRegistry.PRIMAL_ESSENCE_ITEM.get()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(ModRegistry.PLATINUM_SHEET_ITEM.get())
                .requires(ModRegistry.PLATINUM_CHUNK_ITEM.get(), 4)
                .unlockedBy(getHasName(ModRegistry.PLATINUM_CHUNK_ITEM.get()), has(ModRegistry.PLATINUM_CHUNK_ITEM.get()))
                .save(exporter);
        ShapedRecipeBuilder.shaped(ModRegistry.HORN_OF_SIGHT_ITEM.get())
                .define('#', Items.GOLD_INGOT)
                .define('H', Items.GOAT_HORN)
                .define('G', ModRegistry.HALLOWED_GEM_ITEM.get())
                .pattern(" G ")
                .pattern("#H#")
                .pattern(" # ")
                .unlockedBy(getHasName(ModRegistry.HALLOWED_GEM_ITEM.get()), has(ModRegistry.HALLOWED_GEM_ITEM.get()))
                .save(exporter);
    }
}
