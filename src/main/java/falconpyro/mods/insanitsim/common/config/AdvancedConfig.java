package falconpyro.mods.insanitsim.common.config;

import net.minecraftforge.common.config.Configuration;

/**
 * Created by falcon on 04/01/16.
 */
public class AdvancedConfig {

    public static boolean registerCactusMaterialDummy = false;

    public static void init(Configuration config) {
        config.load();
        config.addCustomCategoryComment("items.registration", "All these options may break your saves, use with caution".toUpperCase());
            registerCactusMaterialDummy = config.getBoolean("registerCactusMaterialDummy", "items.registration", registerCactusMaterialDummy, "Overridden by registerCactusMaterialItem, registers Cactus Material as a placeholder with no functionality, can still be used in crafting");
        config.save();
    }
}
