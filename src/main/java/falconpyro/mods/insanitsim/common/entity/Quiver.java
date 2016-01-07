package falconpyro.mods.insanitsim.common.entity;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

/**
 * Created by falcon on 05/01/16.
 */
public class Quiver {

    //Variables
    int ammo, maxAmmo, ammoDrop;
    ItemStack ammoType;

    public Quiver(int startAmmo, int maxAmmo, int maxAmmoDropped, ItemStack ammoType) {
        this.ammo = startAmmo;
        this.maxAmmo = maxAmmo;
        this.ammoDrop = maxAmmoDropped;
        this.ammoType = ammoType;
    }

    public void writeToNBT(NBTTagCompound tagCompound) {
        NBTTagCompound tag = new NBTTagCompound();
        tag.setInteger("Ammo", ammo);
        tag.setInteger("MaxAmmo", maxAmmo);
        tag.setInteger("AmmoDrop", ammoDrop);
        tagCompound.setTag("FalconQuiver", tag);
    }

    public void readFromNBT(NBTTagCompound tagCompound) {
        System.out.println(tagCompound.getCompoundTag("FalconQuiver"));
        System.out.println(tagCompound.getCompoundTag("FalconQuiver").getInteger("Ammo"));
        NBTTagCompound tag = tagCompound.getCompoundTag("FalconQuiver");
        ammo = tag.getInteger("Ammo");
        maxAmmo = tag.getInteger("MaxAmmo");
        ammoDrop = tag.getInteger("AmmoDrop");
        System.out.println("Ammo: " + ammo + "/" + maxAmmo);
        System.out.println("Ammo Drop: " + ammoDrop);
    }

    public boolean hasAmmo() {
        return ammo > 0;
    }

    public boolean collectItem(EntityItem arrow) {
        if(arrow.delayBeforeCanPickup <= 0 && arrow.getEntityItem().isItemEqual(ammoType)) {
            System.out.println("Collecting Items");
            if(ammo < maxAmmo) {
                ammo += arrow.getEntityItem().splitStack(arrow.getEntityItem().stackSize).stackSize;
                System.out.println(ammo+ "/" + maxAmmo);
                return true;
            }
        }
        return false;
    }

    public void fireArrow(EntityLivingBase source, EntityLivingBase target, float damage) {
        if(hasAmmo()) {
            EntityArrow entityarrow = new EntityArrow(source.worldObj, source, target, 1.6F, (float) (14 - source.worldObj.difficultySetting.getDifficultyId() * 4));
            int i = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, source.getHeldItem());
            int j = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, source.getHeldItem());
            entityarrow.setDamage((double) (damage * 2.0F) + source.getRNG().nextGaussian() * 0.25D + (double) ((float) source.worldObj.difficultySetting.getDifficultyId() * 0.11F));

            if (i > 0) {
                entityarrow.setDamage(entityarrow.getDamage() + (double) i * 0.5D + 0.5D);
            }

            if (j > 0) {
                entityarrow.setKnockbackStrength(j);
            }

            if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, source.getHeldItem()) > 0) {
                entityarrow.setFire(100);
            }

            source.playSound(getShootSound(), 1.0F, 1.0F / (source.getRNG().nextFloat() * 0.4F + 0.8F));
            source.worldObj.spawnEntityInWorld(entityarrow);
            ammo--;

            System.out.println("Firing Arrows");
        }
        System.out.println(ammo + "/" + maxAmmo);
    }

    public String getShootSound() {
        return "random.bow";
    }

    public void drop(EntityLivingBase entity) {
        if(ammoType != null) {
            if (ammo > ammoDrop) {
                for (int i = 0; i < ammoDrop; i++) {
                    entity.entityDropItem(ammoType.copy(), 1);
                }
            } else {
                for (int i = 0; i < ammo; i++) {
                    entity.entityDropItem(ammoType.copy(), 1);
                }
            }
        }
    }
}
