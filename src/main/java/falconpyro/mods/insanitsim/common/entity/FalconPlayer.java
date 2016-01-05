package falconpyro.mods.insanitsim.common.entity;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.GameProfileRepository;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.ItemInWorldManager;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

/**
 * Created by falcon on 04/01/16.
 */
public class FalconPlayer extends EntityPlayerMP {

    public FalconPlayer(World world) {
        super(MinecraftServer.getServer(), MinecraftServer.getServer().worldServers[world.provider.dimensionId], null, null);
    }

    public FalconPlayer(EntityPlayerMP player) {
        super(MinecraftServer.getServer(), MinecraftServer.getServer().worldServerForDimension(player.worldObj.provider.dimensionId), player.getGameProfile(), player.theItemInWorldManager);
        copyDataFrom(player, true);
    }

    public FalconPlayer(MinecraftServer p_i45285_1_, WorldServer p_i45285_2_, GameProfile p_i45285_3_, ItemInWorldManager p_i45285_4_) {
        super(p_i45285_1_, p_i45285_2_, p_i45285_3_, p_i45285_4_);
    }
}
