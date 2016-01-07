package falconpyro.mods.devtools.event;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import falconpyro.mods.devtools.config.Config;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.oredict.OreDictionary;

import java.util.List;
import java.util.Set;

/**
 * Created by falcon on 06/01/16.
 */
public class TooltipHandler {

    protected static final TooltipHandler INSTANCE = new TooltipHandler();
    protected static boolean registered = false;
    public static void init() {
        if(!registered) {
            MinecraftForge.EVENT_BUS.register(INSTANCE);
            registered = true;
        }
    }

    @SubscribeEvent
    public void tooltip(ItemTooltipEvent event) {
        if(event.itemStack.getItem() instanceof ItemFood) {
            foodTooltip(event.itemStack, (ItemFood) event.itemStack.getItem(), event.toolTip);
        }
        oreDictTooltip(event.itemStack, event.toolTip);
        toolTooltip(event.itemStack, event.toolTip);
        event.toolTip.add("Max Stack Size: " + event.itemStack.getMaxStackSize());
        containerTooltip(event.itemStack, event.toolTip);
        armourTooltip(event.itemStack.getItem(), event.toolTip);
    }

    public void foodTooltip(ItemStack stack, ItemFood food, List<String> tooltip) {
        if(Config.tooltipHungerHeal) {
            tooltip.add("Hunger Heal: " + EnumChatFormatting.AQUA + food.func_150905_g(stack));
        }
        if(Config.tooltipSaturation) {
            tooltip.add("Saturation: " + EnumChatFormatting.AQUA + food.func_150906_h(stack));
        }
    }

    public void oreDictTooltip(ItemStack stack, List<String> tooltip) {
        if(Config.tooltipListOD) {
            int[] ids = OreDictionary.getOreIDs(stack);
            if (ids.length != 0)
                tooltip.add("Ore Dictionary: ");
            for (int id : ids) {
                tooltip.add("    " + OreDictionary.getOreName(id));
            }
        }
    }

    public void toolTooltip(ItemStack stack, List<String> tooltip) {
        if(Config.tooltipToolInfo) {
            Set<String> classes = stack.getItem().getToolClasses(stack);
            if (!classes.isEmpty())
                tooltip.add("Mining Levels: ");
            for (String toolClass : classes) {
                char letterOne = Character.toUpperCase(toolClass.charAt(0));
                String otherLetters = toolClass.substring(1);
                tooltip.add("    " + letterOne + otherLetters + ": " + EnumChatFormatting.AQUA + stack.getItem().getHarvestLevel(stack, toolClass));
            }
        }
    }

    public void containerTooltip(ItemStack stack, List<String> tooltip) {
        if(Config.tooltipContainerInfo) {
            if (stack.getItem().hasContainerItem(stack)) {
                tooltip.add("Container Item: " + stack.getItem().getContainerItem(stack).getDisplayName());
            }
        }
    }

    public void armourTooltip(Item item, List<String> tooltip) {
        if(Config.tooltipArmourInfo) {
            if (item instanceof ItemArmor) {
                tooltip.add("Armour Type: " + ((ItemArmor) item).armorType);
                tooltip.add("Damage Reduce Amount: " + ((ItemArmor) item).damageReduceAmount);
                tooltip.add("Armour Material: " + ((ItemArmor) item).getArmorMaterial().name());
                ItemStack repairItem = new ItemStack(((ItemArmor) item).getArmorMaterial().func_151685_b());
                tooltip.add("Repair Item: " + repairItem.getDisplayName());
                tooltip.add("Render Index: " + ((ItemArmor) item).renderIndex);
            }
        }
    }

}
