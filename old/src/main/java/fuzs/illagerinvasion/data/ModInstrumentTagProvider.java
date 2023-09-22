package fuzs.illagerinvasion.data;

import fuzs.illagerinvasion.init.ModRegistry;
import net.minecraft.data.tags.InstrumentTagsProvider;
import net.minecraftforge.data.event.GatherDataEvent;

public class ModInstrumentTagProvider extends InstrumentTagsProvider {

    public ModInstrumentTagProvider(GatherDataEvent evt, String modId) {
        super(evt.getGenerator(), modId, evt.getExistingFileHelper());
    }

    @Override
    protected void addTags() {
        this.tag(ModRegistry.HORN_OF_SIGHT_INSTRUMENT_TAG).add(ModRegistry.REVEAL_INSTRUMENT.get());
    }
}
