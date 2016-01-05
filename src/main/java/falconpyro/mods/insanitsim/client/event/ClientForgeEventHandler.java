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
        if(true) {
//            if(event.itemStack.getItem().isItemTool(event.itemStack)){
                for(String toolClass : event.itemStack.getItem().getToolClasses(event.itemStack)) {
                    event.toolTip.add("Mining Levels: ");
                    event.toolTip.add("   " + toolClass + " " + EnumChatFormatting.AQUA + event.itemStack.getItem().getHarvestLevel(event.itemStack, toolClass));
//                    event.toolTip.add("Mining Level: (" + toolClass + ") " + EnumChatFormatting.AQUA + event.itemStack.getItem().getHarvestLevel(event.itemStack, toolClass));
                }
//            }
        }
        if(!event.showAdvancedItemTooltips) {
            if(event.itemStack.getItem().isItemTool(event.itemStack)) {
                int durability = event.itemStack.getItem().getDamage(event.itemStack);
                int maxDur = event.itemStack.getItem().getMaxDamage(event.itemStack);
                EnumChatFormatting chat = EnumChatFormatting.GREEN;
                if(durability > 0) {
                    double percent = ((maxDur - durability) / durability) * 100;
                    if (percent < 100 / 3) {
                        chat = EnumChatFormatting.RED;
                    } else if (percent > 100 / 3 && percent < (100 / 3) * 2) {
                        chat = EnumChatFormatting.YELLOW;
                    }
                }
                event.toolTip.add("Durability: " + chat + (maxDur - durability) + EnumChatFormatting.DARK_GRAY + "/" + EnumChatFormatting.AQUA + maxDur);
            }
            if(event.itemStack.getItem().getItemEnchantability(event.itemStack) > 0) {
                event.toolTip.add("Enchantability: " + EnumChatFormatting.AQUA + event.itemStack.getItem().getItemEnchantability(event.itemStack));
            }
        }
    }
}
