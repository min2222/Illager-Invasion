package fuzs.illagerinvasion;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fuzs.illagerinvasion.config.RaidWavesConfigHelper;
import fuzs.illagerinvasion.config.ServerConfig;
import fuzs.illagerinvasion.core.CommonAbstractions;
import fuzs.illagerinvasion.init.ModRegistry;
import fuzs.puzzleslib.config.ConfigHolder;
import fuzs.puzzleslib.core.CommonFactories;
import fuzs.puzzleslib.core.ModConstructor;
import fuzs.puzzleslib.init.PotionBrewingRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.PatrollingMonster;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = IllagerInvasion.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class IllagerInvasion implements ModConstructor {
    public static final String MOD_ID = "illagerinvasion";
    public static final String MOD_NAME = "Illager Invasion";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);
	public static CreativeModeTab ILLAGER_TAB = new CreativeModeTab("illagerinvasion.main")
	{
		@Override
		public ItemStack makeIcon() 
		{
			return new ItemStack(ModRegistry.HORN_OF_SIGHT_ITEM.get());
		}
	};

    public static final ConfigHolder CONFIG = CommonFactories.INSTANCE.serverConfig(ServerConfig.class, () -> new ServerConfig());

    @Override
    public void onConstructMod() {
        ModRegistry.touch();
    }
    
    @SubscribeEvent
    public static void injectLootPool(LootTableLoadEvent event)
    {
    	event.getLootTableManager().get(EntityType.ILLUSIONER.getDefaultLootTable()).addPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootTableReference.lootTableReference(ModRegistry.ILLUSIONER_INJECT_LOOT_TABLE)).build());
        event.getLootTableManager().get(EntityType.PILLAGER.getDefaultLootTable()).addPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootTableReference.lootTableReference(ModRegistry.PILLAGER_INJECT_LOOT_TABLE)).build());
        event.getLootTableManager().get(EntityType.RAVAGER.getDefaultLootTable()).addPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootTableReference.lootTableReference(ModRegistry.RAVAGER_INJECT_LOOT_TABLE)).build());
    }

    @Override
    public void onCommonSetup(ModLifecycleContext context) {
        registerRaiderTypes();
        registerPotionRecipes();
    }

    private static void registerRaiderTypes() {
        String s = MOD_ID.toUpperCase(Locale.ROOT) + "$";
        CommonAbstractions.INSTANCE.registerRaiderType(s + "BASHER", ModRegistry.BASHER_ENTITY_TYPE.get(), RaidWavesConfigHelper.BASHER_RAID_WAVES);
        CommonAbstractions.INSTANCE.registerRaiderType(s + "PROVOKER", ModRegistry.PROVOKER_ENTITY_TYPE.get(), RaidWavesConfigHelper.PROVOKER_RAID_WAVES);
        CommonAbstractions.INSTANCE.registerRaiderType(s + "NECROMANCER", ModRegistry.NECROMANCER_ENTITY_TYPE.get(), RaidWavesConfigHelper.NECROMANCER_RAID_WAVES);
        CommonAbstractions.INSTANCE.registerRaiderType(s + "SORCERER", ModRegistry.SORCERER_ENTITY_TYPE.get(), RaidWavesConfigHelper.SORCERER_RAID_WAVES);
        CommonAbstractions.INSTANCE.registerRaiderType(s + "ILLUSIONER", EntityType.ILLUSIONER, RaidWavesConfigHelper.ILLUSIONER_RAID_WAVES);
        CommonAbstractions.INSTANCE.registerRaiderType(s + "ARCHIVIST", ModRegistry.ARCHIVIST_ENTITY_TYPE.get(), RaidWavesConfigHelper.ARCHIVIST_RAID_WAVES);
        CommonAbstractions.INSTANCE.registerRaiderType(s + "MARAUDER", ModRegistry.MARAUDER_ENTITY_TYPE.get(), RaidWavesConfigHelper.MARAUDER_RAID_WAVES);
        CommonAbstractions.INSTANCE.registerRaiderType(s + "INQUISITOR", ModRegistry.INQUISITOR_ENTITY_TYPE.get(), RaidWavesConfigHelper.INQUISITOR_RAID_WAVES);
        CommonAbstractions.INSTANCE.registerRaiderType(s + "ALCHEMIST", ModRegistry.ALCHEMIST_ENTITY_TYPE.get(), RaidWavesConfigHelper.ALCHEMIST_RAID_WAVES);
    }

    private static void registerPotionRecipes() {
        PotionBrewingRegistry.INSTANCE.registerPotionRecipe(Potions.AWKWARD, Items.GOAT_HORN, ModRegistry.BERSERKING_POTION.get());
        PotionBrewingRegistry.INSTANCE.registerPotionRecipe(ModRegistry.BERSERKING_POTION.get(), Items.REDSTONE, ModRegistry.LONG_BERSERKING_POTION.get());
        PotionBrewingRegistry.INSTANCE.registerPotionRecipe(ModRegistry.BERSERKING_POTION.get(), Items.GLOWSTONE_DUST, ModRegistry.STRONG_BERSERKING_POTION.get());
    }

    @Override
    public void onEntityAttributeCreation(EntityAttributesCreateContext context) {
        context.registerEntityAttributes(ModRegistry.ALCHEMIST_ENTITY_TYPE.get(), Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 24.0).add(Attributes.MOVEMENT_SPEED, 0.38));
        context.registerEntityAttributes(ModRegistry.ARCHIVIST_ENTITY_TYPE.get(), Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 24.0D).add(Attributes.MOVEMENT_SPEED, 0.36D));
        context.registerEntityAttributes(ModRegistry.BASHER_ENTITY_TYPE.get(), Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 32.0D).add(Attributes.MOVEMENT_SPEED, 0.31D).add(Attributes.ATTACK_DAMAGE, 3.0D).add(Attributes.ATTACK_KNOCKBACK, 0.2D));
        context.registerEntityAttributes(ModRegistry.FIRECALLER_ENTITY_TYPE.get(), Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 32.0).add(Attributes.MOVEMENT_SPEED, 0.38));
        context.registerEntityAttributes(ModRegistry.INQUISITOR_ENTITY_TYPE.get(), Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 80.0).add(Attributes.MOVEMENT_SPEED, 0.33).add(Attributes.ATTACK_DAMAGE, 10.0).add(Attributes.ATTACK_KNOCKBACK, 1.6).add(Attributes.KNOCKBACK_RESISTANCE, 0.8));
        context.registerEntityAttributes(ModRegistry.INVOKER_ENTITY_TYPE.get(), Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 250.0D).add(Attributes.MOVEMENT_SPEED, 0.36D).add(Attributes.KNOCKBACK_RESISTANCE, 0.3D).add(Attributes.ATTACK_DAMAGE, 8.0D));
        context.registerEntityAttributes(ModRegistry.MARAUDER_ENTITY_TYPE.get(), Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 24.0D).add(Attributes.MOVEMENT_SPEED, 0.30D));
        context.registerEntityAttributes(ModRegistry.PROVOKER_ENTITY_TYPE.get(), Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 24.0D).add(Attributes.MOVEMENT_SPEED, 0.38D));
        context.registerEntityAttributes(ModRegistry.SORCERER_ENTITY_TYPE.get(), Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 32.0D).add(Attributes.MOVEMENT_SPEED, 0.38D));
        context.registerEntityAttributes(ModRegistry.SURRENDERED_ENTITY_TYPE.get(), Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 14.0D).add(Attributes.ATTACK_DAMAGE, 5.0D));
        context.registerEntityAttributes(ModRegistry.NECROMANCER_ENTITY_TYPE.get(), Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 32.0).add(Attributes.MOVEMENT_SPEED, 0.38));
    }

    @Override
    public void onRegisterSpawnPlacements(SpawnPlacementsContext context) {
        context.registerSpawnPlacement(ModRegistry.ALCHEMIST_ENTITY_TYPE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, PatrollingMonster::checkPatrollingMonsterSpawnRules);
        context.registerSpawnPlacement(ModRegistry.ARCHIVIST_ENTITY_TYPE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, PatrollingMonster::checkPatrollingMonsterSpawnRules);
        context.registerSpawnPlacement(ModRegistry.BASHER_ENTITY_TYPE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, PatrollingMonster::checkPatrollingMonsterSpawnRules);
        context.registerSpawnPlacement(ModRegistry.FIRECALLER_ENTITY_TYPE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, PatrollingMonster::checkPatrollingMonsterSpawnRules);
        context.registerSpawnPlacement(ModRegistry.INQUISITOR_ENTITY_TYPE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, PatrollingMonster::checkPatrollingMonsterSpawnRules);
        context.registerSpawnPlacement(ModRegistry.INVOKER_ENTITY_TYPE.get(), SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
        context.registerSpawnPlacement(ModRegistry.MARAUDER_ENTITY_TYPE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, PatrollingMonster::checkPatrollingMonsterSpawnRules);
        context.registerSpawnPlacement(ModRegistry.PROVOKER_ENTITY_TYPE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, PatrollingMonster::checkPatrollingMonsterSpawnRules);
        context.registerSpawnPlacement(ModRegistry.SORCERER_ENTITY_TYPE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, PatrollingMonster::checkPatrollingMonsterSpawnRules);
        context.registerSpawnPlacement(ModRegistry.SURRENDERED_ENTITY_TYPE.get(), SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
        context.registerSpawnPlacement(ModRegistry.NECROMANCER_ENTITY_TYPE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, PatrollingMonster::checkPatrollingMonsterSpawnRules);
    }

    public static ResourceLocation id(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}
