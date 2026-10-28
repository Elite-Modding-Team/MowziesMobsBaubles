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
        // keeping glowing as duration 2 here since it inherently is not
        // affected by the bad flicker (no need to change, so don't change)
        player.addPotionEffect(new PotionEffect(MobEffects.GLOWING, 2, 0, false, false));
        // in vanilla, 10 seconds left is at the point where night vision effect
        // pulses as a sine wave. flickering occurs if a small duration is
        // constantly set. must be greater than 200, exclusive. 201 is fine.
        // existing value had a small buffer, so 205 is safer.
        player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 205, 0, false, false));
    }

    @Override
    public void onEquipped(ItemStack stack, EntityLivingBase player) {
        player.playSound(MMSounds.ENTITY_LANTERN_PUFF, 3.0F, 0.8F);
    }

    @Override
    public void onUnequipped(ItemStack stack, EntityLivingBase player) {
        player.playSound(MMSounds.ENTITY_LANTERN_POP, 2.0F, 0.8F);
        // simplest handling here which conforms best with existing flow (night
        // vision is always a beneficial effect, no room for abuse in removing
        // this). remove potion effect so that the effect instantly drops,
        // preserving original behaviour of this item
        player.removePotionEffect(MobEffects.NIGHT_VISION);
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
