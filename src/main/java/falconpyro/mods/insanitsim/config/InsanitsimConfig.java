package falconpyro.mods.insanitsim.config;

import net.minecraftforge.common.config.Configuration;

/**
 * Created by falcon on 30/12/15.
 */
public class InsanitsimConfig {
    public static boolean bonemealCactus = true;
    public static boolean allowCactusMaterialCrafting = true;
    public static boolean allowCactusPickaxeCrafting = true;

    public static void init(Configuration config) {
        config.load();
            bonemealCactus = config.getBoolean("bonemealCactus", "misc", bonemealCactus, "Allow the use of bonemeal on Vanilla Cactus");
            allowCactusMaterialCrafting = config.getBoolean("allowCrafting", "items.cactusMaterial", allowCactusMaterialCrafting, "Allow crafting Cactus Material");
            allowCactusPickaxeCrafting = config.getBoolean("allowCrafting", "items.cactusPickaxe", allowCactusPickaxeCrafting, "Allow crafting Cactus Pickaxe");
        config.save();
    }

}
