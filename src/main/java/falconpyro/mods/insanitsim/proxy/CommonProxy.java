package falconpyro.mods.insanitsim.proxy;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import falconpyro.mods.insanitsim.content.inventory.InsanitsimTab;
import falconpyro.mods.insanitsim.content.item.ItemPlaceholder;
import falconpyro.mods.insanitsim.content.item.InsanitsimContent;

/**
 * Created by falcon on 30/12/15.
 */
public class CommonProxy {

    public void preInit(FMLPreInitializationEvent event){
        InsanitsimContent.tab = new InsanitsimTab();
        InsanitsimContent.cactusMaterial = new ItemPlaceholder("material.cactus");
        InsanitsimContent.cactusPickaxe  = new ItemPlaceholder("pickaxe.cactus");
        InsanitsimContent.cactusShovel   = new ItemPlaceholder("shovel.cactus");
        InsanitsimContent.cactusAxe      = new ItemPlaceholder("axe.cactus");
        InsanitsimContent.cactusHoe      = new ItemPlaceholder("hoe.cactus");
        InsanitsimContent.cactusSword    = new ItemPlaceholder("sword.cactus");
        InsanitsimContent.cactusFood     = new ItemPlaceholder("food.cactus");
    }

    public void init(FMLInitializationEvent event){}
    public void postInit(FMLPostInitializationEvent event){}
}
