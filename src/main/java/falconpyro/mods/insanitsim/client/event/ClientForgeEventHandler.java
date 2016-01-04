package falconpyro.mods.insanitsim.client.event;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import falconpyro.mods.insanitsim.client.ClientConfig;
import falconpyro.mods.insanitsim.common.event.ForgeEventHandlerBase;
import net.minecraft.item.ItemFood;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Created by falcon on 03/01/16.
 */
public class ClientForgeEventHandler extends ForgeEventHandlerBase{

    @SubscribeEvent
    public void tooltipEvent(ItemTooltipEvent event) {
        if(ClientConfig.displayOreDictNames) {
            int[] oreIDs = OreDictionary.getOreIDs(event.itemStack);
            for (int id : oreIDs) {
                event.toolTip.add(EnumChatFormatting.DARK_GRAY + OreDictionary.getOreName(id));
            }
        }
        if(ClientConfig.displayFoodSaturation) {
            if(event.itemStack.getItem() instanceof ItemFood) {
                event.toolTip.add("Saturation: " + EnumChatFormatting.AQUA + ((ItemFood)event.itemStack.getItem()).func_150905_g(event.itemStack));
            }
        }
        if(ClientConfig.displayFoodHungerHeal) {
            if(event.itemStack.getItem() instanceof ItemFood) {
                event.toolTip.add("Hunger Heal: " + EnumChatFormatting.AQUA + ((ItemFood)event.itemStack.getItem()).func_150906_h(event.itemStack));
            }
        }
    }
}
