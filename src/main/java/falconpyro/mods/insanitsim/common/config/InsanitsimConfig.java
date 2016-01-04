package falconpyro.mods.insanitsim.common.config;

import falconpyro.mods.insanitsim.common.lib.LibConfig;
import net.minecraftforge.common.config.Configuration;

/**
 * Created by falcon on 30/12/15.
 */
public class InsanitsimConfig {
    public static boolean bonemealCactus = true;
    public static boolean allowCactusMaterialCrafting = true;
    public static boolean allowCactusPickaxeCrafting = true;
    public static boolean allowCactusAxeCrafting = true;
    public static boolean allowCactusShovelCrafting = true;
    public static boolean allowCactusHoeCrafting = true;
    public static boolean allowCactusSwordCrafting = true;
    public static boolean allowCactusFoodCrafting = true;
    public static boolean allowCactusHelmetCrafting = true;
    public static boolean allowCactusChestplateCrafting = true;
    public static boolean allowCactusLeggingCrafting = true;
    public static boolean allowCactusBootsCrafting = true;
    public static boolean useAdvancedConfig = true;

    protected static Configuration config;

    public static void init(Configuration config) {
        if(InsanitsimConfig.config == null)
           InsanitsimConfig.config = config;
        config.load();
            bonemealCactus = config.getBoolean(LibConfig.KEY_BONEMEAL_CACTUS, LibConfig.CAT_MISC, bonemealCactus, LibConfig.COM_KEY_BONEMEAL_CACTUS);
            allowCactusMaterialCrafting = config.getBoolean(LibConfig.KEY_ALLOW_CRAFT_CACTUS_MATERIAL, LibConfig.CAT_CRAFTING, allowCactusMaterialCrafting, LibConfig.COM_KEY_ALLOW_CRAFT_CACTUS_MATERIAL);
            allowCactusPickaxeCrafting = config.getBoolean(LibConfig.KEY_ALLOW_CRAFT_CACTUS_PICK, LibConfig.CAT_CRAFTING, allowCactusPickaxeCrafting, LibConfig.COM_KEY_ALLOW_CRAFT_CACTUS_PICK);

            useAdvancedConfig = config.getBoolean(LibConfig.KEY_ENABLE_ADV_CONFIG, LibConfig.CAT_ADV_CONFIG, useAdvancedConfig, LibConfig.COM_KEY_ENABLE_ADV_CONFIG);
        config.save();
    }
}
