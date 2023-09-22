package fuzs.illagerinvasion.data;

import fuzs.illagerinvasion.init.ModRegistry;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.tags.EntityTypeTags;
import net.minecraftforge.data.event.GatherDataEvent;

public class ModEntityTypeTagProvider extends EntityTypeTagsProvider {

    public ModEntityTypeTagProvider(GatherDataEvent evt, String modId) {
        super(evt.getGenerator(), modId, evt.getExistingFileHelper());
    }

    @Override
    protected void addTags() {
        this.tag(EntityTypeTags.RAIDERS).add(ModRegistry.BASHER_ENTITY_TYPE.get(), ModRegistry.PROVOKER_ENTITY_TYPE.get(), ModRegistry.NECROMANCER_ENTITY_TYPE.get(), ModRegistry.SORCERER_ENTITY_TYPE.get(), ModRegistry.ARCHIVIST_ENTITY_TYPE.get(), ModRegistry.MARAUDER_ENTITY_TYPE.get(), ModRegistry.INQUISITOR_ENTITY_TYPE.get(), ModRegistry.ALCHEMIST_ENTITY_TYPE.get());
        //TODO
        //this.tag(FALL_DAMAGE_IMMUNE).add(ModRegistry.INVOKER_ENTITY_TYPE.get());
    }
}
