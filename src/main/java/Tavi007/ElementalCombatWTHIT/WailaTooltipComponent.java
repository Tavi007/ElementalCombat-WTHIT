package Tavi007.ElementalCombatWTHIT;

import java.awt.Dimension;

import com.mojang.blaze3d.vertex.PoseStack;

import Tavi007.ElementalCombat.api.ElementalCombatDataRenderAPI;
import Tavi007.ElementalCombat.capabilities.attack.AttackLayer;
import Tavi007.ElementalCombat.capabilities.defense.DefenseLayer;
import mcp.mobius.waila.api.ITooltipComponent;

public class WailaTooltipComponent implements ITooltipComponent {

    private AttackLayer attackLayer;
    private DefenseLayer defenseLayer;
    private Dimension dimension;

    public WailaTooltipComponent(AttackLayer attackLayer, DefenseLayer defenseLayer) {
        this.attackLayer = attackLayer;
        this.defenseLayer = defenseLayer;
        this.dimension = ElementalCombatDataRenderAPI.getTooltipDimension(ClientConfig.isDefenseDoubleRow(), attackLayer, defenseLayer);
    }

    @Override
    public int getWidth() {
        return (int) dimension.getWidth();
    }

    @Override
    public int getHeight() {
        return (int) dimension.getHeight();
    }

    @Override
    public void render(PoseStack poseStack, int posX, int posY, float delta) {
        ElementalCombatDataRenderAPI.renderTextAndIcons(poseStack, posX, posY, false, attackLayer, defenseLayer);
    }

}
