package mod.icarus.mmbaubles.init;

import javax.annotation.Nonnull;

import com.bobmowzie.mowziesmobs.server.creativetab.CreativeTabHandler;
import com.google.common.base.Preconditions;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistryEntry;

import mod.icarus.mmbaubles.MowziesMobsBaubles;

@SuppressWarnings("rawtypes")
@Mod.EventBusSubscriber(modid = MowziesMobsBaubles.MODID)
public class MMBRegistry {
    @Nonnull
    public static <T extends IForgeRegistryEntry> T setup(@Nonnull final T entry, @Nonnull final String name) {
        return setup(entry, new ResourceLocation(MowziesMobsBaubles.MODID, name));
    }

    @Nonnull
    public static <T extends IForgeRegistryEntry> T setup(@Nonnull final T entry, @Nonnull final ResourceLocation registryName) {
        Preconditions.checkNotNull(entry, "Entry to setup must not be null!");
        Preconditions.checkNotNull(registryName, "Registry name to assign must not be null!");

        entry.setRegistryName(registryName);
        if (entry instanceof Item)
            ((Item) entry).setTranslationKey(registryName.getNamespace() + "." + registryName.getPath()).setCreativeTab(CreativeTabHandler.INSTANCE.creativeTab);
        return entry;
    }
}
