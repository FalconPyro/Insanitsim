package falconpyro.mods.insanitsim.proxy;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import falconpyro.mods.insanitsim.client.event.ClientForgeEventHandler;

/**
 * Created by falcon on 30/12/15.
 */
public class ClientProxy extends CommonProxy {
    protected ClientForgeEventHandler events;

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
        events = new ClientForgeEventHandler();
    }
}
