package Tavi007.ElementalCombatWTHIT;

import java.awt.Dimension;

import com.mojang.blaze3d.vertex.PoseStack;

import Tavi007.ElementalCombat.api.ElementalCombatDataRenderAPI;
import mcp.mobius.waila.api.ICommonAccessor;
import mcp.mobius.waila.api.ITooltipRenderer;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public class WailaTooltipRenderer implements ITooltipRenderer {

    @Override
    public Dimension getSize(CompoundTag data, ICommonAccessor accessor) {
        if (accessor.getEntity() != null && accessor.getEntity() instanceof LivingEntity) {
            LivingEntity living = (LivingEntity) accessor.getEntity();
            return ElementalCombatDataRenderAPI.getTooltipDimension(ClientConfig.isDefenseDoubleRow(), living);
        } else if (accessor.getStack() != null) {
            ItemStack stack = accessor.getStack();
            return ElementalCombatDataRenderAPI.getTooltipDimension(ClientConfig.isDefenseDoubleRow(), stack);
        }
        return new Dimension();
    }

    @Override
    public void draw(PoseStack poseStack, CompoundTag data, ICommonAccessor accessor, int x, int y) {
        Entity entity = accessor.getEntity();
        if (entity != null && entity instanceof LivingEntity) {
            ElementalCombatDataRenderAPI.renderTextAndIcons(poseStack, x, y, ClientConfig.isDefenseDoubleRow(), (LivingEntity) entity);
            return;
        }

        ItemStack stack = accessor.getStack();
        if (stack != null) {
            ElementalCombatDataRenderAPI.renderTextAndIcons(poseStack, x, y, ClientConfig.isDefenseDoubleRow(), stack);
            return;
        }
    }

}
