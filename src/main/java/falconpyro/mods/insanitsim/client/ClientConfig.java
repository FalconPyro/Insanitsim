package falconpyro.mods.insanitsim.client;

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
            displayOreDictNames = config.getBoolean("displayOreDictNames", "tooltip", displayOreDictNames, "Display Ore Dictionary Names");
            displayFoodSaturation = config.getBoolean("displayFoodSaturation", "tooltip", displayFoodSaturation, "Display The Saturation of food");
            displayFoodHungerHeal = config.getBoolean("displayFoodHungerHeal", "tooltip", displayFoodHungerHeal, "Display the amount of hunger food restores");
        config.save();
    }
}
