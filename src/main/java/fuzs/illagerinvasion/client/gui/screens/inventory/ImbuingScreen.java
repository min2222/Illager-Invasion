package fuzs.illagerinvasion.client.gui.screens.inventory;

import javax.annotation.Nullable;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;

import fuzs.illagerinvasion.IllagerInvasion;
import fuzs.illagerinvasion.world.inventory.ImbuingMenu;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class ImbuingScreen extends AbstractContainerScreen<ImbuingMenu> {
    private static final ResourceLocation TEXTURE_LOCATION = IllagerInvasion.id("textures/gui/container/imbuing_table.png");

    @Nullable
    private Component tooltip;
    
    public ImbuingScreen(ImbuingMenu handler, Inventory inventory, Component title) {
        super(handler, inventory, title);
    }

    @Override
    public void render(PoseStack guiGraphics, int mouseX, int mouseY, float delta) {
        this.renderBackground(guiGraphics);
        this.renderBg(guiGraphics, delta, mouseX, mouseY);
        super.render(guiGraphics, mouseX, mouseY, delta);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
        if (this.tooltip != null) {
        	this.renderTooltip(guiGraphics, this.tooltip, mouseX, mouseY);
        }
    }

    @Override
    protected void renderBg(PoseStack guiGraphics, float delta, int mouseX, int mouseY) {
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
    	RenderSystem.setShaderTexture(0, TEXTURE_LOCATION);
        this.blit(guiGraphics, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);
        ImbuingMenu.InvalidImbuingState state = ImbuingMenu.InvalidImbuingState.values()[this.menu.invalidState.get()];
        if (state != ImbuingMenu.InvalidImbuingState.ALL_GOOD) {
        	this.blit(guiGraphics, this.leftPos + 74, this.topPos + 32, 176, 0, 28, 21);
            if (this.isHovering(74, 32, 28, 21, mouseX, mouseY)) {
            	//TODO
                this.setTooltip(state.component);
            }
        }
    }

    void setTooltip(@Nullable Component p_101082_) {
    	this.tooltip = p_101082_;
    }
}
