package falconpyro.mods.insanitsim;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.ExistingSubstitutionException;
import cpw.mods.fml.common.registry.GameRegistry;
import falconpyro.mods.insanitsim.common.content.item.FalconBow;
import falconpyro.mods.insanitsim.common.entity.FalconChicken;
import falconpyro.mods.insanitsim.common.entity.FalconPlayer;
import falconpyro.mods.insanitsim.common.entity.FalconZombie;
import falconpyro.mods.insanitsim.common.lib.LibModInfo;
import falconpyro.mods.insanitsim.proxy.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

/**
 * Created by falcon on 30/12/15.
 */
@Mod(modid = LibModInfo.MODID, name = LibModInfo.NAME, version = LibModInfo.VERSION)
public class Insanitsim {

    @SidedProxy(clientSide = LibModInfo.CLIENT_PROXY, serverSide = LibModInfo.COMMON_PROXY)
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
        addSubstitutionAliasItem("minecraft:bow", new FalconBow());
        EntityRegistry.registerGlobalEntityID(FalconChicken.class, "FalconChicken", 121, 10592673, 16711680);
        EntityRegistry.registerGlobalEntityID(FalconZombie.class, "FalconZombie", 122);
        Items.diamond.setHarvestLevel("pickaxe", 100);
        Items.diamond.setHarvestLevel("axe", 100);
        Items.diamond.setHarvestLevel("shovel", 100);
        Items.diamond.setHarvestLevel("scoop", 100);
    }

    public void addSubstitutionAliasItem(String name, Item item) {
        try {
            GameRegistry.addSubstitutionAlias(name, GameRegistry.Type.ITEM, item);
        } catch (ExistingSubstitutionException e) {
            e.printStackTrace();
        }
    }

    public void addSubstitutionAliasBlock(String name, Block block) {
        try {
            GameRegistry.addSubstitutionAlias(name, GameRegistry.Type.BLOCK, block);
        } catch (ExistingSubstitutionException e) {
            e.printStackTrace();
        }
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}
