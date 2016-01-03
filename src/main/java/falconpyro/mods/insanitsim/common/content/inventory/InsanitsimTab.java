package falconpyro.mods.insanitsim.common.content.inventory;

import falconpyro.mods.insanitsim.common.content.item.InsanitsimItems;
import falconpyro.mods.insanitsim.common.lib.LibModInfo;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by falcon on 30/12/15.
 */
public class InsanitsimTab extends CreativeTabs{
    public InsanitsimTab() {
        super(LibModInfo.MODID);
    }

    @Override
    public Item getTabIconItem() {
        return InsanitsimItems.cactusPickaxe;
    }
}
