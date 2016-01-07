package falconpyro.mods.devtools;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import falconpyro.mods.devtools.common.lib.ModInfo;
import falconpyro.mods.devtools.config.Config;
import falconpyro.mods.devtools.event.TooltipHandler;
import net.minecraftforge.common.config.Configuration;

/**
 * Created by falcon on 06/01/16.
 */
@Mod(modid = ModInfo.MODID, version = ModInfo.VERSION)
public class DevTools {

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        Config.init(new Configuration(event.getSuggestedConfigurationFile()));
        TooltipHandler.init();
    }
}
