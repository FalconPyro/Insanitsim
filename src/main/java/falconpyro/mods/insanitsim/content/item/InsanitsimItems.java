package falconpyro.mods.insanitsim.content.item;

import net.minecraft.item.Item;

/**
 * Created by falcon on 31/12/15.
 */
public class InsanitsimItems {
    public static Item cactusMaterial, cactusFood;
    public static Item cactusPickaxe, cactusShovel, cactusAxe, cactusHoe, cactusSword;
    public static Item cactusHelmet, cactusChestplate, cactusLeggings, cactusBoots;

    public static void init() {
        cactusMaterial   = new ItemPlaceholder("material.cactus");
        cactusPickaxe    = new ItemPlaceholder("pickaxe.cactus");
        cactusShovel     = new ItemPlaceholder("shovel.cactus");
        cactusAxe        = new ItemPlaceholder("axe.cactus");
        cactusHoe        = new ItemPlaceholder("hoe.cactus");
        cactusSword      = new ItemPlaceholder("sword.cactus");
        cactusFood       = new ItemPlaceholder("food.cactus");
        cactusHelmet     = new ItemPlaceholder("armour.cactus.head");
        cactusChestplate = new ItemPlaceholder("armour.cactus.chest");
        cactusLeggings   = new ItemPlaceholder("armour.cactus.leg");
        cactusBoots      = new ItemPlaceholder("armour.cactus.boot");
    }
}
