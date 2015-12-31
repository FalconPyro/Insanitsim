package falconpyro.mods.insanitsim.event;

import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import falconpyro.mods.insanitsim.config.InsanitsimConfig;
import net.minecraft.init.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.oredict.OreDictionary;

import java.util.List;

/**
 * Created by falcon on 30/12/15.
 */
public class ForgeEventHandler {

    public ForgeEventHandler(){
        MinecraftForge.EVENT_BUS.register(this);
    }

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
    public void tooltipEvent(ItemTooltipEvent event) {
        int[] oreIDs = OreDictionary.getOreIDs(event.itemStack);
        for(int id : oreIDs) {
            event.toolTip.add(OreDictionary.getOreName(id));
        }
    }
}
