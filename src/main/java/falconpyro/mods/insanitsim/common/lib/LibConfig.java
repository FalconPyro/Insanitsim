package falconpyro.mods.insanitsim.common.lib;

/**
 * Created by falcon on 04/01/16.
 * Naming Rules for this file,
 * CAT_{CAT_NAME_SHORT} For Categories
 * COM_{THING_COMMENTING} For Comments
 * KEY_{KEY_NAME_SHORT} For Keys
 */
public class LibConfig {
    public static final String
            CAT_ITEM_REG= "items.register",
            CAT_MISC = "misc",
            CAT_CRAFTING = "crafting",
            CAT_ADV_CONFIG = "config.advanced",
            CAT_TOOLTIP = "tooltip";

    public static final String
            COM_CAT_ITEM_REG = "All these options may break your saves, use with caution",
            COM_KEY_REG_CACTUS_MATERIAL_DUMMY = "ALL THESE OPTIONS MAY BREAK YOUR SAVES, USE WITH CAUTION",
            COM_KEY_BONEMEAL_CACTUS = "Allow the use of bonemeal on Vanilla Cactus",
            COM_KEY_ALLOW_CRAFT_CACTUS_MATERIAL = "Allow crafting Cactus Material",
            COM_KEY_ALLOW_CRAFT_CACTUS_PICK = "Allow crafting Cactus Pickaxe",
            COM_KEY_ENABLE_ADV_CONFIG = "This activates the AdvancedConfig, this may cause issues";

    public static final String
            KEY_REG_CACTUS_MATERIAL_DUMMY = "registerCactusMaterialDummy",
            KEY_BONEMEAL_CACTUS = "bonemealCactus",
            KEY_ALLOW_CRAFT_CACTUS_MATERIAL = "allowCactusMaterialCraft",
            KEY_ALLOW_CRAFT_CACTUS_PICK = "allowCactusPickCraft",
            KEY_ENABLE_ADV_CONFIG = "useAdvancedConfig";
}
