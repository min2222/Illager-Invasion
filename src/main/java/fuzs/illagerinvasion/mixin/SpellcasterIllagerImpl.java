package fuzs.illagerinvasion.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.SpellcasterIllager;
import net.minecraft.world.level.Level;

// this is just a dummy class to get us access to net.minecraft.world.entity.monster.SpellcasterIllager$IllagerSpell
public abstract class SpellcasterIllagerImpl extends SpellcasterIllager {

    private SpellcasterIllagerImpl(EntityType<? extends SpellcasterIllager> p_33724_, Level p_33725_) {
        super(p_33724_, p_33725_);
    }

    @Mixin(IllagerSpell.class)
    public static abstract class IllagerSpellForgeMixin {

        // remove the final modifier from the $VALUES field, so we can change it via reflection
        @Shadow
        @Mutable
        private static IllagerSpell[] $VALUES;
    }

    @Mixin(IllagerSpell.class)
    public interface IllagerSpellForgeAccessor {

        // access to internal enum constructor
        @Invoker("<init>")
        static IllagerSpell illagerinvasion$init(String internalName, int ordinalId, int spellId, double spellColorRed, double spellColorGreen, double spellColorBlue) {
            throw new RuntimeException();
        }

        @Accessor("id")
        @Mutable
        static void illagerinvasion$setById(int byId) {
            throw new RuntimeException();
        }

        @Accessor("id")
        int illagerinvasion$getId();
    }
}
