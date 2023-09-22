package fuzs.illagerinvasion.client;

import fuzs.illagerinvasion.IllagerInvasion;
import fuzs.illagerinvasion.client.gui.screens.inventory.ImbuingScreen;
import fuzs.illagerinvasion.client.handler.EnchantmentTooltipHandler;
import fuzs.illagerinvasion.client.init.ClientModRegistry;
import fuzs.illagerinvasion.client.model.ArmoredIllagerEntityModel;
import fuzs.illagerinvasion.client.model.BrimmedHatIllagerEntityModel;
import fuzs.illagerinvasion.client.model.HatIllagerEntityModel;
import fuzs.illagerinvasion.client.model.IllagerWithStaffEntityModel;
import fuzs.illagerinvasion.client.model.InvokerEntityModel;
import fuzs.illagerinvasion.client.model.InvokerFangsModel;
import fuzs.illagerinvasion.client.render.entity.AlchemistRender;
import fuzs.illagerinvasion.client.render.entity.ArchivistRender;
import fuzs.illagerinvasion.client.render.entity.BasherRender;
import fuzs.illagerinvasion.client.render.entity.FirecallerRender;
import fuzs.illagerinvasion.client.render.entity.HatchetRender;
import fuzs.illagerinvasion.client.render.entity.InquisitorRender;
import fuzs.illagerinvasion.client.render.entity.InvokerFangsRenderer;
import fuzs.illagerinvasion.client.render.entity.InvokerRender;
import fuzs.illagerinvasion.client.render.entity.MagmaEntityRender;
import fuzs.illagerinvasion.client.render.entity.MarauderRender;
import fuzs.illagerinvasion.client.render.entity.NecromancerRender;
import fuzs.illagerinvasion.client.render.entity.ProvokerRender;
import fuzs.illagerinvasion.client.render.entity.SkullBoltRender;
import fuzs.illagerinvasion.client.render.entity.SorcererRender;
import fuzs.illagerinvasion.client.render.entity.SurrenderedRender;
import fuzs.illagerinvasion.init.ModRegistry;
import fuzs.puzzleslib.client.core.ClientModConstructor;
import fuzs.puzzleslib.client.core.ClientModConstructor.BlockRenderTypesContext;
import fuzs.puzzleslib.core.ModConstructor.ModLifecycleContext;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.model.geom.LayerDefinitions;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.FlameParticle;
import net.minecraft.client.particle.HeartParticle;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class IllagerInvasionClient implements ClientModConstructor {

    @Override
    public void onConstructMod() {
    	
    }

    @SubscribeEvent
    public static void itemTooltip(ItemTooltipEvent event)
    {
    	EnchantmentTooltipHandler.onItemTooltip$1(event.getItemStack(), event.getEntity(), event.getToolTip(), event.getFlags());
    }

    @Override
    public void onClientSetup(ModLifecycleContext context) {
        MenuScreens.register(ModRegistry.IMBUING_MENU_TYPE.get(), ImbuingScreen::new);
    }

    @Override
    public void onRegisterEntityRenderers(EntityRenderersContext context) {
        context.registerEntityRenderer(ModRegistry.PROVOKER_ENTITY_TYPE.get(), ProvokerRender::new);
        context.registerEntityRenderer(ModRegistry.INVOKER_ENTITY_TYPE.get(), InvokerRender::new);
        context.registerEntityRenderer(ModRegistry.SURRENDERED_ENTITY_TYPE.get(), SurrenderedRender::new);
        context.registerEntityRenderer(ModRegistry.NECROMANCER_ENTITY_TYPE.get(), NecromancerRender::new);
        context.registerEntityRenderer(ModRegistry.SKULL_BOLT_ENTITY_TYPE.get(), SkullBoltRender::new);
        context.registerEntityRenderer(ModRegistry.BASHER_ENTITY_TYPE.get(), BasherRender::new);
        context.registerEntityRenderer(ModRegistry.SORCERER_ENTITY_TYPE.get(), SorcererRender::new);
        context.registerEntityRenderer(ModRegistry.ARCHIVIST_ENTITY_TYPE.get(), ArchivistRender::new);
        context.registerEntityRenderer(ModRegistry.INQUISITOR_ENTITY_TYPE.get(), InquisitorRender::new);
        context.registerEntityRenderer(ModRegistry.MARAUDER_ENTITY_TYPE.get(), MarauderRender::new);
        context.registerEntityRenderer(ModRegistry.ALCHEMIST_ENTITY_TYPE.get(), AlchemistRender::new);
        context.registerEntityRenderer(ModRegistry.FIRECALLER_ENTITY_TYPE.get(), FirecallerRender::new);
        context.registerEntityRenderer(ModRegistry.INVOKER_FANGS_ENTITY_TYPE.get(), InvokerFangsRenderer::new);
        context.registerEntityRenderer(ModRegistry.HATCHET_ENTITY_TYPE.get(), HatchetRender::new);
        context.registerEntityRenderer(ModRegistry.FLYING_MAGMA_ENTITY_TYPE.get(), MagmaEntityRender::new);
    }

    @Override
    public void onRegisterParticleProviders(ParticleProvidersContext context) {
        context.registerParticleFactory(ModRegistry.MAGIC_FLAME_PARTICLE_TYPE.get(), FlameParticle.Provider::new);
        context.registerParticleFactory(ModRegistry.NECROMANCER_BUFF_PARTICLE_TYPE.get(), HeartParticle.Provider::new);
    }

    @Override
    public void onRegisterLayerDefinitions(LayerDefinitionsContext context) {
        context.registerLayerDefinition(ClientModRegistry.CAPED_ILLAGER, () -> InvokerEntityModel.getTexturedModelData(CubeDeformation.NONE));
        context.registerLayerDefinition(ClientModRegistry.INVOKER_SHIELD, () -> InvokerEntityModel.getTexturedModelData(LayerDefinitions.INNER_ARMOR_DEFORMATION));
        context.registerLayerDefinition(ClientModRegistry.NECROMANCER_SHIELD, () -> ClientModRegistry.createIllagerBodyLayer(LayerDefinitions.INNER_ARMOR_DEFORMATION));
        context.registerLayerDefinition(ClientModRegistry.INVOKER_FANGS, InvokerFangsModel::getTexturedModelData);
        context.registerLayerDefinition(ClientModRegistry.ARMORED_ILLAGER, ArmoredIllagerEntityModel::getTexturedModelData);
        context.registerLayerDefinition(ClientModRegistry.HAT_ILLAGER, HatIllagerEntityModel::getTexturedModelData);
        context.registerLayerDefinition(ClientModRegistry.STAFF_ILLAGER, IllagerWithStaffEntityModel::getTexturedModelData);
        context.registerLayerDefinition(ClientModRegistry.BRIM_HAT_ILLAGER, BrimmedHatIllagerEntityModel::getTexturedModelData);
    }

    @Override
    public void onRegisterBlockRenderTypes(BlockRenderTypesContext context) {
        context.registerBlock(ModRegistry.MAGIC_FIRE_BLOCK.get(), RenderType.cutout());
    }

    @Override
    public void onRegisterItemModelProperties(ItemModelPropertiesContext context) {
        context.registerItemProperty(IllagerInvasion.id("tooting"), (ItemStack itemStack, ClientLevel clientLevel, LivingEntity livingEntity, int i) -> {
            return livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == itemStack ? 1.0F : 0.0F;
        }, ModRegistry.HORN_OF_SIGHT_ITEM.get());
    }
}
