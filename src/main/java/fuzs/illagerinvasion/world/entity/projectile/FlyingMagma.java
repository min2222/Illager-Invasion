package fuzs.illagerinvasion.world.entity.projectile;

import fuzs.illagerinvasion.init.ModRegistry;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractHurtingProjectile;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class FlyingMagma extends AbstractHurtingProjectile {

    public FlyingMagma(EntityType<? extends FlyingMagma> entityType, Level world) {
        super(entityType, world);
    }

    public FlyingMagma(Level world, LivingEntity owner, double directionX, double directionY, double directionZ) {
        super(ModRegistry.FLYING_MAGMA_ENTITY_TYPE.get(), owner, directionX, directionY, directionZ, world);
    }

    @Override
    public void tick() {
        if (this.level instanceof ServerLevel) {
            ((ServerLevel) this.level).sendParticles(ParticleTypes.LARGE_SMOKE, this.getX(), this.getY(), this.getZ(), 3, 0.3D, 0.3D, 0.3D, 0.05D);
        }
        super.tick();
    }

    @Override
    public boolean isOnFire() {
        return false;
    }

    @Override
    protected void onHitEntity(EntityHitResult entityHitResult) {
        super.onHitEntity(entityHitResult);
        if (this.level.isClientSide) {
            return;
        }
        Entity entity = entityHitResult.getEntity();
        Entity entity2 = this.getOwner();
        entity.hurt(DamageSource.indirectMagic(this, entity2), 12.0f);
        if (entity2 instanceof LivingEntity) {
            this.doEnchantDamageEffects((LivingEntity) entity2, entity);
        }
        if (this.level instanceof ServerLevel) {
            ((ServerLevel) this.level).sendParticles(ParticleTypes.LAVA, this.getX(), this.getY(), this.getZ(), 15, 0.4D, 0.4D, 0.4D, 0.15D);
        }
    }

    @Override
    protected void onHit(HitResult hitResult) {
        super.onHit(hitResult);
        if (!this.level.isClientSide) {
        	Explosion.BlockInteraction explosion$blockinteraction = net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level, this) ? Explosion.BlockInteraction.DESTROY : Explosion.BlockInteraction.NONE;
            this.level.explode(null, this.getX(), this.getY(), this.getZ(), 1, true, explosion$blockinteraction);
            this.discard();
        }
        if (this.level instanceof ServerLevel) {
            ((ServerLevel) this.level).sendParticles(ParticleTypes.LAVA, this.getX(), this.getY(), this.getZ(), 15, 0.4D, 0.4D, 0.4D, 0.15D);
        }
        this.discard();

    }

    @Override
    public boolean isPickable() {
        return false;
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        return false;
    }

    @Override
    protected boolean shouldBurn() {
        return false;
    }
}

