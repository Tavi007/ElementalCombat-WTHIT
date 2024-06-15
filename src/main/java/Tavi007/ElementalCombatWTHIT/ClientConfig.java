
package Tavi007.ElementalCombatWTHIT;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;

public class ClientConfig {

    public static final ForgeConfigSpec CONFIG_SPEC;
    private static final ClientConfig CLIENT;

    private final BooleanValue defenseDoubleRow;

    static {
        Pair<ClientConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(ClientConfig::new);

        CONFIG_SPEC = specPair.getRight();
        CLIENT = specPair.getLeft();
    }

    ClientConfig(ForgeConfigSpec.Builder builder) {
        defenseDoubleRow = builder
            .comment("If true, displays the defense values of the plugin in two rows (split in element and style).")
            .define("defenseDoubleRow", true);
    }

    public static boolean isDefenseDoubleRow() {
        return CLIENT.defenseDoubleRow.get();
    }
}
