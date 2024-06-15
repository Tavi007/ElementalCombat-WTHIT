package Tavi007.ElementalCombatWTHIT;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig.Type;

@Mod("elementalcombat_wthit")
public class ElementalCombatWTHIT {

    public static ElementalCombatWTHIT instance;
    public static final String MOD_ID = "elementalcombat_wthit";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public ElementalCombatWTHIT() {
        instance = this;
        MinecraftForge.EVENT_BUS.register(this);
        ModLoadingContext.get().registerConfig(Type.CLIENT, ClientConfig.CONFIG_SPEC, ElementalCombatWTHIT.MOD_ID + "-client.toml");
    }
}
