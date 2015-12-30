package falconpyro.mods.insanitsim;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import falconpyro.mods.insanitsim.lib.LibModInfo;
import falconpyro.mods.insanitsim.proxy.CommonProxy;

/**
 * Created by falcon on 30/12/15.
 */
@Mod(modid = LibModInfo.MODID, name = LibModInfo.NAME, version = LibModInfo.VERSION)
public class Insanitsim {

    @SidedProxy(clientSide = LibModInfo.CLIENT_PROXY, serverSide = LibModInfo.COMMON_PROXY)
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}
