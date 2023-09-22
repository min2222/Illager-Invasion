package fuzs.illagerinvasion.data;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;

import fuzs.illagerinvasion.init.ModRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable.Builder;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

public class ModBlockLootProvider extends LootTableProvider {
    public ModBlockLootProvider(DataGenerator p_124437_)
    {
		super(p_124437_);
	}
	
	@Override
	protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, Builder>>>, LootContextParamSet>> getTables()
	{
		return ImmutableList.of(Pair.of(ModBlockLoot::new, LootContextParamSets.BLOCK));
	}
	
	public static class ModBlockLoot extends BlockLoot
	{
		@Override
	    public void addTables() 
		{
	        this.dropSelf(ModRegistry.IMBUING_TABLE_BLOCK.get());
	        this.add(ModRegistry.MAGIC_FIRE_BLOCK.get(), noDrop());
	    }
	}
}
