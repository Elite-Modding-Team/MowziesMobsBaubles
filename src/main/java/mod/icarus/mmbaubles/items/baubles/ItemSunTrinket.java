package mod.icarus.mmbaubles.items.baubles;

import java.util.List;

import javax.annotation.Nullable;

import com.bobmowzie.mowziesmobs.server.potion.PotionHandler;
import com.bobmowzie.mowziesmobs.server.sound.MMSounds;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemSunTrinket extends Item implements IBauble {
    @Override
    public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
        player.addPotionEffect(new PotionEffect(PotionHandler.SUNS_BLESSING, 2, 0, false, false));
    }

    @Override
    public void onEquipped(ItemStack stack, EntityLivingBase player) {
        player.playSound(MMSounds.ENTITY_SUPERNOVA_START, 0.65F, 1.25F);
    }

    @Override
    public void onUnequipped(ItemStack stack, EntityLivingBase player) {
        player.playSound(MMSounds.ENTITY_SUPERNOVA_BLACKHOLE, 0.6F, 1.0F);
    }

    @Override
    public BaubleType getBaubleType(ItemStack stack) {
        return BaubleType.TRINKET;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World world, List<String> list, ITooltipFlag flag) {
        list.add(I18n.format("tooltip.mmbaubles.sun_trinket.equip"));
        list.add(I18n.format(""));
        list.add(I18n.format("item.grantSunsBlessing.text.1"));
        list.add(I18n.format("item.grantSunsBlessing.text.2.nocooldown"));
    }
}
