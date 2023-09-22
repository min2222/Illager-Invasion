package fuzs.illagerinvasion.data;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;

import fuzs.illagerinvasion.init.ModRegistry;
import net.minecraft.data.loot.EntityLoot;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTable.Builder;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.LootingEnchantFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.LootItemKilledByPlayerCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceWithLootingCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.data.event.GatherDataEvent;

public class ModEntityTypeLootProvider extends LootTableProvider {

    public ModEntityTypeLootProvider(GatherDataEvent evt) {
        super(evt.getGenerator());
    }
    
	@Override
	protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, Builder>>>, LootContextParamSet>> getTables()
	{
		return ImmutableList.of(Pair.of(ModEntityTypeLoot::new, LootContextParamSets.ENTITY));
	}
	
	public static class ModEntityTypeLoot extends EntityLoot
	{
	    @Override
	    public void addTables() {
	        this.add(ModRegistry.ALCHEMIST_ENTITY_TYPE.get(), LootTable.lootTable()
	                .withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.EMERALD)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
	                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))
	                                        .when(LootItemKilledByPlayerCondition.killedByPlayer())
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.GUNPOWDER)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F)))
	                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.GLASS_BOTTLE)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F)))
	                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))
	                                )
	                )
	        );
	        this.add(ModRegistry.ARCHIVIST_ENTITY_TYPE.get(), LootTable.lootTable()
	                .withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.EMERALD)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
	                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))
	                                        .when(LootItemKilledByPlayerCondition.killedByPlayer())
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.BOOK)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
	                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.PAPER)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F)))
	                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))
	                                )
	                )
	        );
	        this.add(ModRegistry.BASHER_ENTITY_TYPE.get(), LootTable.lootTable()
	                .withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.EMERALD)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
	                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))
	                                        .when(LootItemKilledByPlayerCondition.killedByPlayer())
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.IRON_NUGGET)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(3.0F, 7.0F)))
	                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 2.0F)))
	                                )
	                )
	        );
	        this.add(ModRegistry.FIRECALLER_ENTITY_TYPE.get(), LootTable.lootTable()
	                .withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.EMERALD)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
	                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))
	                                        .when(LootItemKilledByPlayerCondition.killedByPlayer())
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.FIRE_CHARGE)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F)))
	                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))
	                                )
	                )
	        );
	        this.add(ModRegistry.INQUISITOR_ENTITY_TYPE.get(), LootTable.lootTable()
	                .withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.EMERALD)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
	                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))
	                                        .when(LootItemKilledByPlayerCondition.killedByPlayer())
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.IRON_INGOT)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 3.0F)))
	                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 2.0F)))
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.LEATHER)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F)))
	                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 2.0F)))
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(ModRegistry.PLATINUM_CHUNK_ITEM.get())
	                                        .when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.5F, 0.0625F))
	                                        .when(LootItemKilledByPlayerCondition.killedByPlayer())
	                                )
	                )
	        );
	        this.add(ModRegistry.INVOKER_ENTITY_TYPE.get(), LootTable.lootTable()
	                .withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.EMERALD)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(3.0F, 5.0F)))
	                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 2.0F)))
	                                        .when(LootItemKilledByPlayerCondition.killedByPlayer())
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(ModRegistry.PRIMAL_ESSENCE_ITEM.get())
	                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
	                                        .when(LootItemKilledByPlayerCondition.killedByPlayer())
	                                )
	                )
	        );
	        this.add(ModRegistry.MARAUDER_ENTITY_TYPE.get(), LootTable.lootTable()
	                .withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.EMERALD)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
	                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))
	                                        .when(LootItemKilledByPlayerCondition.killedByPlayer())
	                                )
	                )
	        );
	        this.add(ModRegistry.NECROMANCER_ENTITY_TYPE.get(), LootTable.lootTable()
	                .withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.EMERALD)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
	                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))
	                                        .when(LootItemKilledByPlayerCondition.killedByPlayer())
	                                )
	                )
	        );
	        this.add(ModRegistry.PROVOKER_ENTITY_TYPE.get(), LootTable.lootTable()
	                .withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.EMERALD)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
	                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))
	                                        .when(LootItemKilledByPlayerCondition.killedByPlayer())
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.ARROW)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F)))
	                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))
	                                )
	                )
	        );
	        this.add(ModRegistry.SORCERER_ENTITY_TYPE.get(), LootTable.lootTable()
	                .withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.EMERALD)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
	                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))
	                                        .when(LootItemKilledByPlayerCondition.killedByPlayer())
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(Items.BOOK)
	                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F)))
	                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))
	                                )
	                ).withPool(
	                        LootPool.lootPool()
	                                .setRolls(ConstantValue.exactly(1.0F))
	                                .add(LootItem.lootTableItem(ModRegistry.UNUSUAL_DUST_ITEM.get()))
	                                .when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.4F, 0.2F))
	                                .when(LootItemKilledByPlayerCondition.killedByPlayer())
	                )
	        );
	        this.add(ModRegistry.SURRENDERED_ENTITY_TYPE.get(), LootTable.lootTable());
	    }

	    @Override
	    protected boolean isNonLiving(EntityType<?> entityType) {
	        return entityType.getCategory() != MobCategory.MISC;
	    }
	}
}
