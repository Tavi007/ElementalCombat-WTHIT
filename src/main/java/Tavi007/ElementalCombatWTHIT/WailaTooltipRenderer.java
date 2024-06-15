package Tavi007.ElementalCombatWTHIT;

import java.awt.Dimension;

import com.mojang.blaze3d.matrix.MatrixStack;

import Tavi007.ElementalCombat.api.ElementalCombatDataRenderAPI;
import mcp.mobius.waila.api.ICommonAccessor;
import mcp.mobius.waila.api.ITooltipRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;

public class WailaTooltipRenderer implements ITooltipRenderer {

    @Override
    public Dimension getSize(CompoundNBT data, ICommonAccessor accessor) {
        if (accessor.getEntity() != null && accessor.getEntity() instanceof LivingEntity) {
            LivingEntity living = (LivingEntity) accessor.getEntity();
            return ElementalCombatDataRenderAPI.getTooltipDimension(true, living);
        } else if (accessor.getStack() != null) {
            ItemStack stack = accessor.getStack();
            return ElementalCombatDataRenderAPI.getTooltipDimension(true, stack);
        }
        return new Dimension();
    }

    @Override
    public void draw(CompoundNBT data, ICommonAccessor accessor, int x, int y) {
        Entity entity = accessor.getEntity();
        if (entity != null && entity instanceof LivingEntity) {
            ElementalCombatDataRenderAPI.renderTextAndIcons(new MatrixStack(), x, y, true, (LivingEntity) entity);
            return;
        }

        ItemStack stack = accessor.getStack();
        if (stack != null) {
            ElementalCombatDataRenderAPI.renderTextAndIcons(new MatrixStack(), x, y, true, stack);
            return;
        }
    }

}