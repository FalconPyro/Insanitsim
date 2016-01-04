package falconpyro.mods.insanitsim.common.content.recipe;

import falconpyro.mods.insanitsim.Insanitsim;
import falconpyro.mods.insanitsim.common.config.InsanitsimConfig;
import falconpyro.mods.insanitsim.common.content.item.InsanitsimItems;
import net.minecraft.init.Blocks;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.oredict.ShapedOreRecipe;

/**
 * Created by falcon on 31/12/15.
 */
public class InsanitsimRecipes {

    public static IRecipe cactusMaterial, cactusPickaxe, cactusAxe, cactusShovel, cactusHoe, cactusSword, cactusFood,
        cactusHelmet, cactusChestplate, cactusLeggings, cactusBoots;

    public static final String
            OD_IRON_INGOT = "ingotIron",
            OD_WOODEN_STICK = "stickWood";

    public static void init() {
        if(InsanitsimConfig.allowCactusMaterialCrafting) {
            cactusMaterial = new ShapedOreRecipe(InsanitsimItems.cactusMaterial,
                    " c ",
                    "cic",
                    " c ",
                    'c', Blocks.cactus,
                    'i', OD_IRON_INGOT
            );
        }

        if(InsanitsimConfig.allowCactusPickaxeCrafting) {
            cactusPickaxe = new ShapedOreRecipe(InsanitsimItems.cactusPickaxe,
                    "ccc",
                    " s ",
                    " s ",
                    's', OD_WOODEN_STICK,
                    'c', InsanitsimItems.cactusMaterial
            );
        }
    }

    protected static CraftingManager manager = CraftingManager.getInstance();

    public static void refresh() {
        registerRecipe(InsanitsimConfig.allowCactusMaterialCrafting, cactusMaterial);
        registerRecipe(InsanitsimConfig.allowCactusPickaxeCrafting, cactusPickaxe);
        registerRecipe(InsanitsimConfig.allowCactusAxeCrafting, cactusAxe);
        registerRecipe(InsanitsimConfig.allowCactusShovelCrafting, cactusShovel);
        registerRecipe(InsanitsimConfig.allowCactusHoeCrafting, cactusHoe);
        registerRecipe(InsanitsimConfig.allowCactusSwordCrafting, cactusSword);
        registerRecipe(InsanitsimConfig.allowCactusFoodCrafting, cactusFood);
        registerRecipe(InsanitsimConfig.allowCactusHelmetCrafting, cactusHelmet);
        registerRecipe(InsanitsimConfig.allowCactusChestplateCrafting, cactusChestplate);
        registerRecipe(InsanitsimConfig.allowCactusLeggingCrafting, cactusLeggings);
        registerRecipe(InsanitsimConfig.allowCactusBootsCrafting, cactusBoots);
    }

    protected static void registerRecipe(boolean canCraft, IRecipe recipe) {
        if(recipe == null)
            return;

        if(canCraft) {
            manager.getRecipeList().add(recipe);
        } else {
            if(manager.getRecipeList().contains(recipe)) {
                manager.getRecipeList().remove(recipe);
            }
        }
    }
}
