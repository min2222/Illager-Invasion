package fuzs.illagerinvasion.init;

import static fuzs.illagerinvasion.init.ModRegistry.REGISTRY;

import fuzs.illagerinvasion.world.entity.projectile.Hatchet;
import fuzs.illagerinvasion.world.entity.projectile.SkullBolt;
import fuzs.puzzleslib.init.RegistryReference;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class ForgeModRegistry {
    public static final RegistryReference<EntityType<SkullBolt>> SKULL_BOLT_ENTITY_TYPE = REGISTRY.registerEntityTypeBuilder("skull_bolt", () -> EntityType.Builder.<SkullBolt>of(SkullBolt::new, MobCategory.MISC).sized(0.3f, 0.3f).setTrackingRange(4).setUpdateInterval(10));
    public static final RegistryReference<EntityType<Hatchet>> HATCHET_ENTITY_TYPE = REGISTRY.registerEntityTypeBuilder("hatchet", () -> EntityType.Builder.<Hatchet>of(Hatchet::new, MobCategory.MISC).sized(0.35f, 0.35f).setTrackingRange(4).setUpdateInterval(10));

    public static void touch() {
	
    }
}
