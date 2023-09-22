package fuzs.illagerinvasion.util;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.FishingRodItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.TridentItem;
import net.minecraftforge.common.Tags;

public interface ToolTypeHelper {
    ToolTypeHelper INSTANCE = new ToolTypeHelper() {
	};
    /**
     * Tests if an {@link ItemStack} is a sword.
     *
     * @param stack the stack to test
     * @return is this stack a sword
     */
    default boolean isSword(ItemStack stack) {
        return stack.getItem() instanceof SwordItem || stack.is(Tags.Items.TOOLS_SWORDS);
    }

    /**
     * Tests if an {@link ItemStack} is an axe.
     *
     * @param stack the stack to test
     * @return is this stack an axe
     */
    default boolean isAxe(ItemStack stack) {
        return stack.getItem() instanceof AxeItem || stack.is(Tags.Items.TOOLS_AXES);
    }

    /**
     * Tests if an {@link ItemStack} is a hoe.
     *
     * @param stack the stack to test
     * @return is this stack a hoe
     */
    default boolean isHoe(ItemStack stack) {
        return stack.getItem() instanceof HoeItem || stack.is(Tags.Items.TOOLS_HOES);
    }

    /**
     * Tests if an {@link ItemStack} is a pickaxe.
     *
     * @param stack the stack to test
     * @return is this stack a pickaxe
     */
    default boolean isPickaxe(ItemStack stack) {
        return stack.getItem() instanceof PickaxeItem || stack.is(Tags.Items.TOOLS_PICKAXES);
    }

    /**
     * Tests if an {@link ItemStack} is a shovel.
     *
     * @param stack the stack to test
     * @return is this stack a shovel
     */
    default boolean isShovel(ItemStack stack) {
        return stack.getItem() instanceof AxeItem || stack.is(Tags.Items.TOOLS_SHOVELS);
    }

    /**
     * Tests if an {@link ItemStack} is a shears item.
     *
     * @param stack the stack to test
     * @return is this stack a shears item
     */
    default boolean isShears(ItemStack stack) {
        return stack.getItem() instanceof ShearsItem;
    }

    /**
     * Tests if an {@link ItemStack} is a shield.
     *
     * @param stack the stack to test
     * @return is this stack a shield
     */
    default boolean isShield(ItemStack stack) {
        return stack.getItem() instanceof ShieldItem;
    }

    /**
     * Tests if an {@link ItemStack} is a bow.
     *
     * @param stack the stack to test
     * @return is this stack a bow
     */
    default boolean isBow(ItemStack stack) {
        return stack.getItem() instanceof BowItem;
    }

    /**
     * Tests if an {@link ItemStack} is a crossbow.
     *
     * @param stack the stack to test
     * @return is this stack a crossbow
     */
    default boolean isCrossbow(ItemStack stack) {
        return stack.getItem() instanceof CrossbowItem;
    }

    /**
     * Tests if an {@link ItemStack} is a fishing rod.
     *
     * @param stack the stack to test
     * @return is this stack a fishing rod
     */
    default boolean isFishingRod(ItemStack stack) {
        return stack.getItem() instanceof FishingRodItem;
    }

    /**
     * Tests if an {@link ItemStack} is a trident.
     *
     * @param stack the stack to test
     * @return is this stack a trident
     */
    default boolean isTrident(ItemStack stack) {
        return stack.getItem() instanceof TridentItem;
    }

    /**
     * Tests if an {@link ItemStack} is a weapon used for melee combat.
     *
     * @param stack the stack to test
     * @return is this stack a melee weapon
     */
    default boolean isMeleeWeapon(ItemStack stack) {
        return this.isSword(stack) || this.isAxe(stack) || this.isTrident(stack);
    }

    /**
     * Tests if an {@link ItemStack} is a weapon used for ranged combat.
     *
     * @param stack the stack to test
     * @return is this stack a ranged weapon
     */
    default boolean isRangedWeapon(ItemStack stack) {
        return this.isBow(stack) || this.isCrossbow(stack) || this.isTrident(stack);
    }

    /**
     * Tests if an {@link ItemStack} is a weapon.
     *
     * @param stack the stack to test
     * @return is this stack a weapon
     */
    default boolean isWeapon(ItemStack stack) {
        return this.isMeleeWeapon(stack) || this.isRangedWeapon(stack);
    }

    /**
     * Tests if an {@link ItemStack} is a tool used for mining blocks.
     *
     * @param stack the stack to test
     * @return is this stack a mining tool
     */
    default boolean isMiningTool(ItemStack stack) {
        return this.isAxe(stack) || this.isHoe(stack) || this.isPickaxe(stack) || this.isShovel(stack);
    }

    /**
     * Tests if an {@link ItemStack} is any sort of tool, mainly in the sense of {@link Tags.Items#TOOLS}.
     *
     * @param stack the stack to test
     * @return is this stack a tool
     */
    default boolean isTool(ItemStack stack) {
        return this.isMiningTool(stack) || this.isMeleeWeapon(stack) || stack.is(Tags.Items.TOOLS);
    }
}
