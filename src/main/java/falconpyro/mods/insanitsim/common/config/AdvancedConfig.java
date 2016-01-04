package falconpyro.mods.insanitsim.common.config;

import falconpyro.mods.insanitsim.common.lib.LibConfig;
import net.minecraftforge.common.config.Configuration;

/**
 * Created by falcon on 04/01/16.
 */
public class AdvancedConfig {

    public static boolean registerCactusMaterialDummy = false;

    public static void init(Configuration config) {
        config.load();
        config.addCustomCategoryComment(LibConfig.CAT_ITEM_REG, LibConfig.COM_CAT_ITEM_REG);
            registerCactusMaterialDummy = config.getBoolean(LibConfig.KEY_REG_CACTUS_MATERIAL_DUMMY, LibConfig.CAT_ITEM_REG, registerCactusMaterialDummy, LibConfig.COM_KEY_REG_CACTUS_MATERIAL_DUMMY);
        config.save();
    }
}
