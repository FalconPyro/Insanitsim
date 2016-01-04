package falconpyro.mods.insanitsim.client;

import falconpyro.mods.insanitsim.common.lib.LibConfig;
import net.minecraftforge.common.config.Configuration;

/**
 * Created by falcon on 03/01/16.
 */
public class ClientConfig {

    public static boolean displayOreDictNames = false;
    public static boolean displayFoodHungerHeal = false;
    public static boolean displayFoodSaturation = false;

    public static void init(Configuration config) {
        config.load();
            displayOreDictNames = config.getBoolean("displayOreDictNames", LibConfig.CAT_TOOLTIP, displayOreDictNames, "Display Ore Dictionary Names");
            displayFoodSaturation = config.getBoolean("displayFoodSaturation", LibConfig.CAT_TOOLTIP, displayFoodSaturation, "Display The Saturation of food");
            displayFoodHungerHeal = config.getBoolean("displayFoodHungerHeal", LibConfig.CAT_TOOLTIP, displayFoodHungerHeal, "Display the amount of hunger food restores");
        config.save();
    }
}
