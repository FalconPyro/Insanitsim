package falconpyro.mods.insanitsim.common.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created by falcon on 04/01/16.
 */
public class FalconChicken extends EntityChicken {


    public FalconChicken(World world) {
        super(world);
    }

    public FalconChicken(EntityChicken parent) {
        super(parent.worldObj);
        this.copyDataFrom(parent, true);
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if(!this.worldObj.isRemote && !this.isChild() && !this.func_152116_bZ() && this.ticksExisted % 20 == 0) {
            this.playSound("mob.chicken.plop", 1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
            this.dropItem(Items.diamond, 1);
        }
    }
}
