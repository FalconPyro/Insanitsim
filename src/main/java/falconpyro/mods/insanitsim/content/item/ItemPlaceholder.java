package falconpyro.mods.insanitsim.content.item;

import cpw.mods.fml.common.registry.GameRegistry;
import falconpyro.mods.insanitsim.content.InsanitsimContent;
import falconpyro.mods.insanitsim.lib.LibModInfo;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.List;

/**
 * Created by falcon on 30/12/15.
 */
public class ItemPlaceholder extends Item {
    public ItemPlaceholder(String name) {
        setUnlocalizedName(LibModInfo.MODID + "." + name);
        setTextureName(LibModInfo.MODID + ":" + name.replace('.', '/'));
        setCreativeTab(InsanitsimContent.tab);
        GameRegistry.registerItem(this, name);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List tooltip, boolean debug) {
        tooltip.add("This item does nothing");
    }
}
