package falconpyro.mods.insanitsim.common.content;

import falconpyro.mods.insanitsim.common.content.inventory.InsanitsimTab;
import falconpyro.mods.insanitsim.common.content.item.InsanitsimItems;
import falconpyro.mods.insanitsim.common.content.recipe.InsanitsimRecipes;
import net.minecraft.creativetab.CreativeTabs;

/**
 * Created by falcon on 30/12/15.
 */
public class InsanitsimContent {

    public static CreativeTabs tab;

    public static void init() {
        tab = new InsanitsimTab();
        InsanitsimItems.init();
        InsanitsimRecipes.init();
    }
}
