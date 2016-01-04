package falconpyro.mods.insanitsim.proxy;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.ExistingSubstitutionException;
import cpw.mods.fml.common.registry.GameRegistry;
import falconpyro.mods.insanitsim.common.config.AdvancedConfig;
import falconpyro.mods.insanitsim.common.config.InsanitsimConfig;
import falconpyro.mods.insanitsim.common.content.InsanitsimContent;
import falconpyro.mods.insanitsim.common.content.item.FalconBow;
import falconpyro.mods.insanitsim.common.content.recipe.InsanitsimRecipes;
import falconpyro.mods.insanitsim.common.event.ForgeEventHandler;
import falconpyro.mods.insanitsim.common.lib.LibModInfo;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

/**
 * Created by falcon on 30/12/15.
 */
public class CommonProxy {

    public ForgeEventHandler forgeEvents;
    protected File configDir;

    public void preInit(FMLPreInitializationEvent event){
        forgeEvents = new ForgeEventHandler();
        configDir = new File(event.getModConfigurationDirectory() + "/" + LibModInfo.MODID);
        InsanitsimConfig.init(new Configuration(new File(configDir + "/Common.cfg")));
        if(InsanitsimConfig.useAdvancedConfig)
            AdvancedConfig.init(new Configuration(new File(configDir + "/Advanced.cfg")));

        InsanitsimContent.init();
    }

    public void init(FMLInitializationEvent event){}

    public void postInit(FMLPostInitializationEvent event){
        InsanitsimRecipes.refresh();
    }

}
