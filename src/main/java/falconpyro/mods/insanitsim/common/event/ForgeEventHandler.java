package falconpyro.mods.insanitsim.common.event;

import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import falconpyro.mods.insanitsim.common.config.InsanitsimConfig;
import falconpyro.mods.insanitsim.common.entity.FalconChicken;
import falconpyro.mods.insanitsim.common.entity.FalconPlayer;
import falconpyro.mods.insanitsim.common.entity.FalconZombie;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.oredict.OreDictionary;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by falcon on 30/12/15.
 */
public class ForgeEventHandler extends ForgeEventHandlerBase{

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
            replaceEntity(event.world, event.entity, EntityChicken.class, FalconChicken.class);
            replaceEntity(event.world, event.entity, EntityZombie.class, FalconZombie.class);
        }
    }

    public void replaceEntity(World world, Entity entity, Class toReplace, Class replacement) {
        if(toReplace == replacement)
            return;
        if(entity.getClass() == toReplace) {
            try {
                Constructor constructor = replacement.getConstructor(toReplace);
                entity.setDead();
                world.spawnEntityInWorld((Entity) constructor.newInstance(entity));
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}
