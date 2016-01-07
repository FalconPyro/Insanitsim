package falconpyro.mods.insanitsim.common.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by falcon on 05/01/16.
 */
public class FalconZombie extends EntityZombie implements IRangedAttackMob {

    protected EntityAIArrowAttack arrowAI = new EntityAIArrowAttack(this, 1.0D, 20, 60, 15.0F);

    ItemStack pocketItem = new ItemStack(Items.wooden_sword);

    public FalconZombie(EntityZombie zombie) {
        this(zombie.worldObj);
        copyDataFrom(zombie, true);
        if(getHeldItem() != null && pocketItem == null)
            switchItem();
        setCurrentItemOrArmor(0, new ItemStack(Items.bow));
        setCombatTask();
    }

    private void switchItem() {
        System.out.println("Switching: " + getHeldItem() + "/" + pocketItem);
        ItemStack temp = getHeldItem().copy();
        setCurrentItemOrArmor(0, pocketItem);
        pocketItem = temp;
    }

    public FalconZombie(World world) {
        super(world);
        setCanPickUpLoot(true);
    }

    protected Quiver quiver = new Quiver(10, 100, 100, new ItemStack(Items.arrow));

    @Override
    public void onItemPickup(Entity p_71001_1_, int p_71001_2_) {
        System.out.println("Picking Up :" + p_71001_2_ + " (" + p_71001_1_ + ")");
        quiver.collectItem((EntityItem) p_71001_1_);
        setCombatTask();
        super.onItemPickup(p_71001_1_, p_71001_2_);
    }

    @Override
    public void attackEntityWithRangedAttack(EntityLivingBase p_82196_1_, float p_82196_2_) {
        System.out.println("Attacking With Ranged");
        if(quiver.hasAmmo()) {
            quiver.fireArrow(this, p_82196_1_, p_82196_2_);
        } else {
            System.out.println("I Have no Arrows");
        }
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound tag) {
        super.writeEntityToNBT(tag);
        quiver.writeToNBT(tag);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound tag) {
        super.readEntityFromNBT(tag);
        quiver.readFromNBT(tag);
        setCombatTask();
    }

    @Override
    public void setCurrentItemOrArmor(int slot, ItemStack stack) {
        super.setCurrentItemOrArmor(slot, stack);
        setCombatTask();
    }

    @Override
    public void onDeath(DamageSource source) {
        super.onDeath(source);
        quiver.drop(this);
    }

    @Override
    protected void collideWithEntity(Entity entity) {
        System.out.println(entity);
        if(entity instanceof EntityItem) {
            quiver.collectItem((EntityItem) entity);
        } else {
            super.collideWithEntity(entity);
        }
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if(isDead)
            return;
        if (quiver.maxAmmo > quiver.ammo) {
            List<EntityItem> arrows = worldObj.getEntitiesWithinAABB(EntityItem.class, AxisAlignedBB.getBoundingBox(posX - 2, posY - 2, posZ - 2, posX + 2, posY + 2, posZ + 2));
            for (EntityItem item : arrows) {
                quiver.collectItem(item);
            }
        }
        if(ticksExisted % 20 == 0) {
            if(!quiver.hasAmmo() && (getHeldItem().getItem() == Items.bow)) {
                switchItem();
            } else if(quiver.hasAmmo() && pocketItem.getItem() == Items.bow) {
                switchItem();
            }
        }
        if(getAITarget() != null) {
            System.out.println(getAITarget().getDistance(posX, posY, posZ));
            if (getAITarget().getDistance(posX, posY, posZ) > 10) {
                setRanged();
            } else {
                setMelee();
            }
        }
    }

    private void setRanged() {
        tasks.addTask(1, arrowAI);
        if(getHeldItem().getItem() == Items.wooden_sword) {
            ItemStack temp = getHeldItem().copy();
            setCurrentItemOrArmor(0, pocketItem);
            pocketItem = temp;
        }
    }

    private void setMelee() {
        tasks.removeTask(arrowAI);
        if(getHeldItem().getItem() == Items.bow) {
            ItemStack temp = getHeldItem().copy();
            setCurrentItemOrArmor(0, pocketItem);
            pocketItem = temp;
        }
    }

    public void setCombatTask() {
        System.out.println("Deciding On AI");
//        if (tasks.taskEntries.contains(arrowAI))
        this.tasks.removeTask(arrowAI);
        ItemStack itemstack = getHeldItem();

        if (itemstack != null && quiver.hasAmmo()) {
            tasks.addTask(1, arrowAI);
            System.out.println("Bow Chosen");
        }
    }
}
