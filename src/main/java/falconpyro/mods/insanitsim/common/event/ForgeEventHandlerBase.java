package falconpyro.mods.insanitsim.common.event;

import net.minecraftforge.common.MinecraftForge;

/**
 * Created by falcon on 03/01/16.
 */
public abstract class ForgeEventHandlerBase {

    public ForgeEventHandlerBase() {
        if(!done) {
            MinecraftForge.EVENT_BUS.register(this);
            done = true;
        }
    }

    boolean done = false;

}
