package fuzs.illagerinvasion.data;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;

import fuzs.illagerinvasion.init.ModRegistry;
import net.minecraft.data.loot.ChestLoot;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTable.Builder;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.EnchantWithLevelsFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemDamageFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.data.event.GatherDataEvent;

public class ModChestLootProvider extends LootTableProvider {

    public ModChestLootProvider(GatherDataEvent evt) {
        super(evt.getGenerator());
    }
    
	@Override
	protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, Builder>>>, LootContextParamSet>> getTables()
	{
		return ImmutableList.of(Pair.of(ModChestLoot::new, LootContextParamSets.CHEST));
	}
    
	public static class ModChestLoot extends ChestLoot
	{
		@Override
		public void accept(BiConsumer<ResourceLocation, Builder> p_124363_) 
		{
			p_124363_.accept(ModRegistry.ILLAGER_FORT_TOWER_LOOT_TABLE, LootTable.lootTable()
	                .withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.SWEET_BERRIES)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(3.0F, 8.0F)))
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.CROSSBOW)
	                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
	                                        .apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.1F, 0.5F)))
	                                        .when(LootItemRandomChanceCondition.randomChance(0.3F))
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.SPRUCE_SAPLING)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 3.0F)))
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.NAME_TAG)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
	                                        .when(LootItemRandomChanceCondition.randomChance(0.6F))
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.BREAD)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 6.0F)))
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.EMERALD)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 8.0F)))
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.ARROW)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(3.0F, 10.0F)))
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.IRON_AXE)
	                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
	                                        .apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.15F, 0.6F)))
	                                        .apply(EnchantWithLevelsFunction.enchantWithLevels(UniformGenerator.between(15.0F, 25.0F)))
	                                        .when(LootItemRandomChanceCondition.randomChance(0.2F))
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.SHIELD)
	                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
	                                        .apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.15F, 0.5F)))
	                                        .when(LootItemRandomChanceCondition.randomChance(0.2F))
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.STICK)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(3.0F, 5.0F)))
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.BOOK)
	                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
	                                        .apply(EnchantWithLevelsFunction.enchantWithLevels(ConstantValue.exactly(20.0F)))
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.GOLDEN_APPLE)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(3.0F, 3.0F)))
	                                        .when(LootItemRandomChanceCondition.randomChance(0.8F))
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.MELON_SEEDS)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 5.0F)))
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.ENCHANTED_GOLDEN_APPLE)
	                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
	                                        .when(LootItemRandomChanceCondition.randomChance(0.1F))
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.GOLD_INGOT)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F)))
	                                        .when(LootItemRandomChanceCondition.randomChance(0.6F))
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.DIAMOND)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
	                                        .when(LootItemRandomChanceCondition.randomChance(0.3F))
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.IRON_INGOT)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F)))
	                                        .when(LootItemRandomChanceCondition.randomChance(0.6F))
	                                )
	                )
	        );
	        p_124363_.accept(ModRegistry.ILLAGER_FORT_GROUND_LOOT_TABLE, LootTable.lootTable()
	                .withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.SWEET_BERRIES)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(3.0F, 8.0F)))
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.CROSSBOW)
	                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
	                                        .apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.1F, 0.5F)))
	                                        .when(LootItemRandomChanceCondition.randomChance(0.25F))
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.SPRUCE_SAPLING)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.NAME_TAG)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
	                                        .when(LootItemRandomChanceCondition.randomChance(0.2F))
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.BREAD)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 3.0F)))
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.EMERALD)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 4.0F)))
	                                        .when(LootItemRandomChanceCondition.randomChance(0.5F))
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.ARROW)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 6.0F)))
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.IRON_AXE)
	                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
	                                        .apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.15F, 0.6F)))
	                                        .apply(EnchantWithLevelsFunction.enchantWithLevels(UniformGenerator.between(5.0F, 15.0F)))
	                                        .when(LootItemRandomChanceCondition.randomChance(0.15F))
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.SHIELD)
	                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
	                                        .apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.15F, 0.5F)))
	                                        .when(LootItemRandomChanceCondition.randomChance(0.15F))
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.STICK)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F)))
	                                )
	                )
	        );
	        p_124363_.accept(ModRegistry.ILLUSIONER_TOWER_STAIRS_LOOT_TABLE, LootTable.lootTable()
	                .withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.WHEAT)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 6.0F)))
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.STRING)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 6.0F)))
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.IRON_INGOT)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F)))
	                                        .when(LootItemRandomChanceCondition.randomChance(0.5F))
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.EMERALD)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F)))
	                                        .when(LootItemRandomChanceCondition.randomChance(0.5F))
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.PAPER)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 6.0F)))
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.STICK)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 8.0F)))
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.COPPER_INGOT)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F)))
	                                        .when(LootItemRandomChanceCondition.randomChance(0.5F))
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.BOOK)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 3.0F)))
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.NAME_TAG)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.GUNPOWDER)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 3.0F)))
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(ModRegistry.ILLUSIONARY_DUST_ITEM.get())
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F)))
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.GOLDEN_APPLE)
	                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
	                                        .when(LootItemRandomChanceCondition.randomChance(0.5F))
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.BOOK)
	                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
	                                        .apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.2F, 0.6F)))
	                                        .when(LootItemRandomChanceCondition.randomChance(0.75F))
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.LAPIS_LAZULI)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 6.0F)))
	                                )
	                )
	        );
	        p_124363_.accept(ModRegistry.ILLUSIONER_TOWER_ENTRANCE_LOOT_TABLE, LootTable.lootTable()
	                .withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.WHEAT)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 6.0F)))
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.STRING)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 6.0F)))
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.IRON_INGOT)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F)))
	                                        .when(LootItemRandomChanceCondition.randomChance(0.5F))
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.EMERALD)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F)))
	                                        .when(LootItemRandomChanceCondition.randomChance(0.5F))
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.PAPER)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 6.0F)))
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.STICK)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 8.0F)))
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.COPPER_INGOT)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F)))
	                                        .when(LootItemRandomChanceCondition.randomChance(0.5F))
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.BOOK)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 3.0F)))
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.NAME_TAG)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.GUNPOWDER)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 3.0F)))
	                                )
	                )
	        );
	        p_124363_.accept(ModRegistry.LABYRINTH_LOOT_TABLE, LootTable.lootTable()
	                .withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.NAME_TAG)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.COPPER_INGOT)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 7.0F)))
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.GOLDEN_APPLE)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F)))
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.ENCHANTED_GOLDEN_APPLE)
	                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
	                                        .when(LootItemRandomChanceCondition.randomChance(0.1F))
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.BREAD)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 6.0F)))
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.IRON_INGOT)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 8.0F)))
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.DIAMOND)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F)))
	                                        .when(LootItemRandomChanceCondition.randomChance(0.5F))
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.MELON_SEEDS)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 6.0F)))
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.GOLD_INGOT)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 6.0F)))
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.BOOK)
	                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
	                                        .apply(EnchantWithLevelsFunction.enchantWithLevels(UniformGenerator.between(25.0F, 35.0F)))
	                                        .when(LootItemRandomChanceCondition.randomChance(0.25F))
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.EMERALD)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 6.0F)))
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.STRING)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 5.0F)))
	                                )
	                )
	        );
	        p_124363_.accept(ModRegistry.LABYRINTH_MAP_LOOT_TABLE, LootTable.lootTable()
	                .withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(3.0F))
	                                .add(LootItem.lootTableItem(Items.COMPASS))
	                                .add(LootItem.lootTableItem(Items.MAP))
	                                .add(LootItem.lootTableItem(Items.CLOCK))
	                                .add(LootItem.lootTableItem(ModRegistry.LOST_CANDLE_ITEM.get()))
	                                .add(LootItem.lootTableItem(Items.PAPER)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 10.0F)))
	                                        .setWeight(20)
	                                ).add(LootItem.lootTableItem(Items.FEATHER)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 5.0F)))
	                                        .setWeight(10)
	                                ).add(LootItem.lootTableItem(Items.BOOK)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 5.0F)))
	                                        .setWeight(5)
	                                )
	                )
	        );
	        p_124363_.accept(ModRegistry.SORCERER_HUT_LOOT_TABLE, LootTable.lootTable()
	                .withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.PAPER)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(4.0F, 11.0F)))
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.BOOK)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F)))
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.BOOK)
	                                        .apply(EnchantWithLevelsFunction.enchantWithLevels(ConstantValue.exactly(30.0F)))
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.DARK_OAK_SAPLING)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 4.0F)))
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(ModRegistry.UNUSUAL_DUST_ITEM.get())
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.EMERALD)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F)))
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.NAME_TAG)
	                                        .when(LootItemRandomChanceCondition.randomChance(0.5F))
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.GOLDEN_APPLE)
	                                        .when(LootItemRandomChanceCondition.randomChance(0.25F))
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.ENCHANTED_GOLDEN_APPLE)
	                                        .when(LootItemRandomChanceCondition.randomChance(0.05F))
	                                )
	                )
	        );
	    }	
	}
}
