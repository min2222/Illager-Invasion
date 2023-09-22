package fuzs.illagerinvasion.data;

import fuzs.illagerinvasion.init.ModRegistry;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.data.event.GatherDataEvent;

public class ModBlockTagProvider extends BlockTagsProvider {

    public ModBlockTagProvider(GatherDataEvent evt, String modId) {
        super(evt.getGenerator(), modId, evt.getExistingFileHelper());
    }

    @Override
    protected void addTags() {
        this.tag(BlockTags.MINEABLE_WITH_AXE).add(ModRegistry.IMBUING_TABLE_BLOCK.get());
        this.tag(BlockTags.FIRE).add(ModRegistry.MAGIC_FIRE_BLOCK.get());
    }
}
