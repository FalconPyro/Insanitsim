package falconpyro.mods.devtools.config;

import net.minecraftforge.common.config.Configuration;

/**
 * Created by falcon on 06/01/16.
 */
public class Config {
    public static final String
            CAT_TOOLTIP = "client.tooltip";
    public static boolean
            tooltipHungerHeal = false,
            tooltipSaturation = false,
            tooltipListOD = false,
            tooltipArmourInfo = false,
            tooltipContainerInfo = false,
            tooltipToolInfo = false,
            tooltipMaxStackSize = false;

    public static void init(Configuration config) {
        config.load();
            tooltipHungerHeal = config.getBoolean("Hunger Heal Amount", CAT_TOOLTIP, false, "");
            tooltipSaturation = config.getBoolean("Saturation Amount", CAT_TOOLTIP, false, "");
            tooltipListOD = config.getBoolean("List All Ore Dictionary Names", CAT_TOOLTIP, false, "");
            tooltipArmourInfo = config.getBoolean("List Armour Info", CAT_TOOLTIP, false, "");
            tooltipContainerInfo = config.getBoolean("What an item's container item is", CAT_TOOLTIP, false, "");
            tooltipToolInfo = config.getBoolean("Tool Info", CAT_TOOLTIP, false, "");
            tooltipMaxStackSize = config.getBoolean("Max Stack Size", CAT_TOOLTIP, false, "");
        config.save();
    }
}
