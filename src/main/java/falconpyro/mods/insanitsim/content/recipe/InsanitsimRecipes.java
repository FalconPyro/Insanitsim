package falconpyro.mods.insanitsim.content.recipe;

import falconpyro.mods.insanitsim.config.InsanitsimConfig;
import falconpyro.mods.insanitsim.content.item.InsanitsimItems;
import net.minecraft.init.Blocks;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.oredict.ShapedOreRecipe;

/**
 * Created by falcon on 31/12/15.
 */
public class InsanitsimRecipes {

    public static IRecipe cactusMaterial, cactusPickaxe;

    public static final String
            OD_IRON_INGOT = "ingotIron",
            OD_WOODEN_STICK = "stickWood";

    public static void init() {
        cactusMaterial = new ShapedOreRecipe(InsanitsimItems.cactusMaterial,
            " c ",
            "cic",
            " c ",
            'c', Blocks.cactus,
            'i', OD_IRON_INGOT
        );

        cactusPickaxe = new ShapedOreRecipe(InsanitsimItems.cactusPickaxe,
            "ccc",
            " s ",
            " s ",
            's', OD_WOODEN_STICK,
            'c', InsanitsimItems.cactusMaterial
        );
    }

    protected static CraftingManager manager = CraftingManager.getInstance();

    public static void refresh() {
        registerRecipe(InsanitsimConfig.allowCactusMaterialCrafting, cactusMaterial);
        registerRecipe(InsanitsimConfig.allowCactusPickaxeCrafting, cactusPickaxe);
    }

    protected static void registerRecipe(boolean canCraft, IRecipe recipe) {
        if(canCraft) {
            manager.getRecipeList().add(recipe);
        } else {
            if(manager.getRecipeList().contains(recipe)) {
                manager.getRecipeList().remove(recipe);
            }
        }
    }
}
