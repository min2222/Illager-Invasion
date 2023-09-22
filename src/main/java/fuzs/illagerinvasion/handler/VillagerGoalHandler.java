package fuzs.illagerinvasion.handler;

import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

import org.jetbrains.annotations.Nullable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import fuzs.illagerinvasion.init.ModRegistry;
import fuzs.illagerinvasion.world.entity.monster.Alchemist;
import fuzs.illagerinvasion.world.entity.monster.Archivist;
import fuzs.illagerinvasion.world.entity.monster.Basher;
import fuzs.illagerinvasion.world.entity.monster.Firecaller;
import fuzs.illagerinvasion.world.entity.monster.Inquisitor;
import fuzs.illagerinvasion.world.entity.monster.Invoker;
import fuzs.illagerinvasion.world.entity.monster.Marauder;
import fuzs.illagerinvasion.world.entity.monster.Necromancer;
import fuzs.illagerinvasion.world.entity.monster.Provoker;
import fuzs.illagerinvasion.world.entity.monster.Sorcerer;
import fuzs.illagerinvasion.world.entity.monster.Surrendered;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.sensing.VillagerHostilesSensor;
import net.minecraft.world.entity.npc.AbstractVillager;

public class VillagerGoalHandler {
    private static final List<AvoidVillagerEnemy<?>> VILLAGER_ENEMIES = ImmutableList.<AvoidVillagerEnemy<?>>builder()
            .add(new AvoidVillagerEnemy<>(Alchemist.class, ModRegistry.ALCHEMIST_ENTITY_TYPE::get, 12.0F))
            .add(new AvoidVillagerEnemy<>(Archivist.class, ModRegistry.ARCHIVIST_ENTITY_TYPE::get, 12.0F))
            .add(new AvoidVillagerEnemy<>(Basher.class, ModRegistry.BASHER_ENTITY_TYPE::get, 8.0F))
            .add(new AvoidVillagerEnemy<>(Firecaller.class, ModRegistry.FIRECALLER_ENTITY_TYPE::get, 12.0F))
            .add(new AvoidVillagerEnemy<>(Inquisitor.class, ModRegistry.INQUISITOR_ENTITY_TYPE::get, 15.0F))
            .add(new AvoidVillagerEnemy<>(Invoker.class, ModRegistry.INVOKER_ENTITY_TYPE::get, 15.0F))
            .add(new AvoidVillagerEnemy<>(Marauder.class, ModRegistry.MARAUDER_ENTITY_TYPE::get, 12.0F))
            .add(new AvoidVillagerEnemy<>(Necromancer.class, ModRegistry.NECROMANCER_ENTITY_TYPE::get, 15.0F))
            .add(new AvoidVillagerEnemy<>(Provoker.class, ModRegistry.PROVOKER_ENTITY_TYPE::get, 12.0F))
            .add(new AvoidVillagerEnemy<>(Sorcerer.class, ModRegistry.SORCERER_ENTITY_TYPE::get, 12.0F))
            .add(new AvoidVillagerEnemy<>(Surrendered.class, ModRegistry.SURRENDERED_ENTITY_TYPE::get, 8.0F))
            .build();

    public static void onEntityJoinServerLevel(Entity entity, ServerLevel level, @Nullable MobSpawnType spawnType) {

        // do not do this for generic abstract villager, villagers that use the brain system instead of the goals seem to try to run both and flee much slower than they should
        if (entity.getType() == EntityType.WANDERING_TRADER) {

            for (AvoidVillagerEnemy<?> villagerEnemy : VILLAGER_ENEMIES) {

                villagerEnemy.addGoal((AbstractVillager) entity);
            }
        }
    }

    public static void init() {
    	
        Map<EntityType<?>, Float> map = new IdentityHashMap<>(VillagerHostilesSensor.ACCEPTABLE_DISTANCE_FROM_HOSTILES);
        for (AvoidVillagerEnemy<?> villagerEnemy : VILLAGER_ENEMIES) {

            villagerEnemy.addAcceptableDistance(map::put);
        }

        VillagerHostilesSensor.ACCEPTABLE_DISTANCE_FROM_HOSTILES = ImmutableMap.copyOf(map);
    }

    private record AvoidVillagerEnemy<T extends LivingEntity>(Class<T> clazz, Supplier<EntityType<T>> type, float acceptableDistance) {

        public void addGoal(AbstractVillager abstractVillager) {
            abstractVillager.goalSelector.addGoal(1, this.makeGoal(abstractVillager));
        }

        private Goal makeGoal(AbstractVillager abstractVillager) {
            return new AvoidEntityGoal<>(abstractVillager, this.clazz, this.acceptableDistance, 0.5, 0.5);
        }

        public void addAcceptableDistance(BiConsumer<EntityType<?>, Float> consumer) {
            consumer.accept(this.type.get(), this.acceptableDistance);
        }
    }
}
