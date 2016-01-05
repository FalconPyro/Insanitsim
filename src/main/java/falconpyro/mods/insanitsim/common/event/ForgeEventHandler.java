package falconpyro.mods.insanitsim.common.event;

import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import falconpyro.mods.insanitsim.common.config.InsanitsimConfig;
import falconpyro.mods.insanitsim.common.entity.FalconChicken;
import falconpyro.mods.insanitsim.common.entity.FalconPlayer;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Created by falcon on 30/12/15.
 */
public class ForgeEventHandler extends ForgeEventHandlerBase{

//    public ForgeEventHandler(){
//        MinecraftForge.EVENT_BUS.register(this);
//    }

    @SubscribeEvent
    public void bonemealEvent(BonemealEvent event) {
        if(InsanitsimConfig.bonemealCactus) {
            if (event.block == Blocks.cactus) {
                event.setResult(Event.Result.ALLOW);
                if (event.y + 1 < event.world.getHeight() && event.y > 1) {
                    if(event.world.isAirBlock(event.x, event.y + 1, event.z)) {
                        float r = event.world.rand.nextFloat();
                        System.out.println(r);
                        if (r > 0.5) {
                            event.world.setBlock(event.x, event.y + 1, event.z, event.block, 0, 2);
                        }
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public void joinWorldEvent(EntityJoinWorldEvent event) {
        if(!event.world.isRemote) {
            if (event.entity.getClass() == EntityChicken.class) {
                System.out.println("You spawned a Chicken");
                EntityChicken replace = new FalconChicken((EntityChicken) event.entity);
                event.entity.setDead();
                event.world.spawnEntityInWorld(replace);
            }
        }
    }
}
