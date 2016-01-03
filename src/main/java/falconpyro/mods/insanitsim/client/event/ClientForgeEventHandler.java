package falconpyro.mods.insanitsim.client.event;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import falconpyro.mods.insanitsim.common.event.ForgeEventHandlerBase;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Created by falcon on 03/01/16.
 */
public class ClientForgeEventHandler extends ForgeEventHandlerBase{

    @SubscribeEvent
    public void tooltipEvent(ItemTooltipEvent event) {
        int[] oreIDs = OreDictionary.getOreIDs(event.itemStack);
        for(int id : oreIDs) {
            event.toolTip.add(OreDictionary.getOreName(id));
        }
    }
}
