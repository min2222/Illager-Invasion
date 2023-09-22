package fuzs.illagerinvasion;

import fuzs.illagerinvasion.data.ModBiomeTagProvider;
import fuzs.illagerinvasion.data.ModBlockLootProvider;
import fuzs.illagerinvasion.data.ModBlockTagProvider;
import fuzs.illagerinvasion.data.ModChestLootProvider;
import fuzs.illagerinvasion.data.ModEnchantmentTagProvider;
import fuzs.illagerinvasion.data.ModEntityInjectLootProvider;
import fuzs.illagerinvasion.data.ModEntityTypeLootProvider;
import fuzs.illagerinvasion.data.ModEntityTypeTagProvider;
import fuzs.illagerinvasion.data.ModInstrumentTagProvider;
import fuzs.illagerinvasion.data.ModRecipeProvider;
import fuzs.illagerinvasion.init.ForgeModRegistry;
import fuzs.puzzleslib.core.CommonFactories;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;

@Mod(IllagerInvasion.MOD_ID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class IllagerInvasionForge {

    @SubscribeEvent
    public static void onConstructMod(final FMLConstructModEvent evt) {
        ForgeModRegistry.touch();
        CommonFactories.INSTANCE.modConstructor(IllagerInvasion.MOD_ID).accept(new IllagerInvasion());
    }

    @SubscribeEvent
    public static void onGatherData(final GatherDataEvent evt) {
        evt.getGenerator().addProvider(true, new ModBiomeTagProvider(evt, IllagerInvasion.MOD_ID));
        evt.getGenerator().addProvider(true, new ModBlockLootProvider(evt.getGenerator()));
        evt.getGenerator().addProvider(true, new ModBlockTagProvider(evt, IllagerInvasion.MOD_ID));
        evt.getGenerator().addProvider(true, new ModChestLootProvider(evt));
        evt.getGenerator().addProvider(true, new ModEnchantmentTagProvider(evt, IllagerInvasion.MOD_ID));
        evt.getGenerator().addProvider(true, new ModEntityInjectLootProvider(evt, IllagerInvasion.MOD_ID));
        evt.getGenerator().addProvider(true, new ModEntityTypeLootProvider(evt));
        evt.getGenerator().addProvider(true, new ModEntityTypeTagProvider(evt, IllagerInvasion.MOD_ID));
        evt.getGenerator().addProvider(true, new ModInstrumentTagProvider(evt, IllagerInvasion.MOD_ID));
        //evt.getGenerator().addProvider(true, new ModItemTagProvider(evt, IllagerInvasion.MOD_ID));
        //evt.getGenerator().addProvider(true, new ModLanguageProvider(evt, IllagerInvasion.MOD_ID));
        //evt.getGenerator().addProvider(true, new ModModelProvider(evt, IllagerInvasion.MOD_ID));
        //evt.getGenerator().addProvider(true, new ModParticleDescriptionProvider(evt, IllagerInvasion.MOD_ID));
        evt.getGenerator().addProvider(true, new ModRecipeProvider(evt, IllagerInvasion.MOD_ID));
        //evt.getGenerator().addProvider(true, new ModSpriteSourceProvider(evt, IllagerInvasion.MOD_ID));
        //evt.getGenerator().addProvider(true, new ModTrimMaterialDataProvider(evt, IllagerInvasion.MOD_ID));
    }
}
