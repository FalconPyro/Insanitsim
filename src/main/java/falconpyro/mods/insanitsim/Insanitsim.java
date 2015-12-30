package falconpyro.mods.insanitsim;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import falconpyro.mods.insanitsim.proxy.CommonProxy;

/**
 * Created by falcon on 30/12/15.
 */
@Mod(modid = Insanitsim.MODID, name = Insanitsim.NAME, version = Insanitsim.VERSION)
public class Insanitsim {

    //MOD INFO START
    public static final String MODID = "insanitsim", NAME = "Insanitsim", VERSION = "@VERSION@";
    //MOD INFO END

    @SidedProxy(clientSide = "falconpyro.mods.insanitsim.proxy.ClientProxy", serverSide = "falconpyro.mods.insanitsim.proxy.CommonProxy")
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
