package mod.icarus.mmbaubles.items.baubles;

import java.util.List;

import javax.annotation.Nullable;

import com.bobmowzie.mowziesmobs.server.sound.MMSounds;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemLuminousRing extends Item implements IBauble {
    public ItemLuminousRing() {
        this.setMaxStackSize(1);
    }

    @Override
    public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
        player.addPotionEffect(new PotionEffect(MobEffects.GLOWING, 2, 0, false, false));
        player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 2, 0, false, false));
    }

    @Override
    public void onEquipped(ItemStack stack, EntityLivingBase player) {
        player.playSound(MMSounds.ENTITY_LANTERN_PUFF, 2.0F, 0.8F);
    }

    @Override
    public void onUnequipped(ItemStack stack, EntityLivingBase player) {
        player.playSound(MMSounds.ENTITY_LANTERN_POP, 2.0F, 0.8F);
    }

    @Override
    public BaubleType getBaubleType(ItemStack stack) {
        return BaubleType.RING;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World world, List<String> list, ITooltipFlag flag) {
        list.add(I18n.format("tooltip.mmbaubles.luminous_ring.equip"));
    }
}
