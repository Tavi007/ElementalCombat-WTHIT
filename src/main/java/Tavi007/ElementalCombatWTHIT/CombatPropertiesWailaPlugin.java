package Tavi007.ElementalCombatWTHIT;

import mcp.mobius.waila.api.IRegistrar;
import mcp.mobius.waila.api.IWailaPlugin;
import mcp.mobius.waila.api.TooltipPosition;
import mcp.mobius.waila.api.WailaPlugin;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;

@WailaPlugin(id = ElementalCombatWTHIT.MOD_ID)
public class CombatPropertiesWailaPlugin implements IWailaPlugin {

    static final ResourceLocation COMBAT_PROPERTIES = new ResourceLocation(ElementalCombatWTHIT.MOD_ID, "combat_properties");

    @Override
    public void register(IRegistrar registrar) {
        registrar.addComponent(HUDHandlerEntities.INSTANCE, TooltipPosition.BODY, LivingEntity.class);
        registrar.addRenderer(COMBAT_PROPERTIES, new WailaTooltipRenderer());
        ElementalCombatWTHIT.LOGGER.info("Waila Plugin registered.");
    }
}
