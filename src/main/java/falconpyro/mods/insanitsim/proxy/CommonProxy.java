package falconpyro.mods.insanitsim.proxy;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import falconpyro.mods.insanitsim.common.config.InsanitsimConfig;
import falconpyro.mods.insanitsim.common.content.InsanitsimContent;
import falconpyro.mods.insanitsim.common.content.recipe.InsanitsimRecipes;
import falconpyro.mods.insanitsim.common.event.ForgeEventHandler;
import net.minecraftforge.common.config.Configuration;

/**
 * Created by falcon on 30/12/15.
 */
public class CommonProxy {

    public ForgeEventHandler forgeEvents;

    public void preInit(FMLPreInitializationEvent event){
        forgeEvents = new ForgeEventHandler();
        InsanitsimConfig.init(new Configuration(event.getSuggestedConfigurationFile()));
        InsanitsimContent.init();
    }

    public void init(FMLInitializationEvent event){}

    public void postInit(FMLPostInitializationEvent event){
        InsanitsimRecipes.refresh();
    }
}
