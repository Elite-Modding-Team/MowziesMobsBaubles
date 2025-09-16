package mod.icarus.mmbaubles.init;

import mod.icarus.mmbaubles.MMBConfig;
import mod.icarus.mmbaubles.MowziesMobsBaubles;
import mod.icarus.mmbaubles.items.baubles.*;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.registries.IForgeRegistry;

import javax.annotation.Nonnull;

import com.bobmowzie.mowziesmobs.server.item.ItemHandler;

@SuppressWarnings("deprecation")
@EventBusSubscriber(modid = MowziesMobsBaubles.MODID)
@GameRegistry.ObjectHolder(MowziesMobsBaubles.MODID)
public class MMBItems {
    @GameRegistry.ObjectHolder("earth_trinket")
    public static ItemEarthTrinket earthTrinket;
    @GameRegistry.ObjectHolder("luminous_ring")
    public static ItemLuminousRing luminousRing;
    @GameRegistry.ObjectHolder("naga_ring")
    public static ItemNagaRing nagaRing;
    @GameRegistry.ObjectHolder("sun_trinket")
    public static ItemSunTrinket sunTrinket;

    @SubscribeEvent
    public static void registerItems(@Nonnull final RegistryEvent.Register<Item> event) {
        final IForgeRegistry<Item> registry = event.getRegistry();

        if (MMBConfig.general_settings.EARTH_TRINKET)
            registry.register(MMBRegistry.setup(new ItemEarthTrinket(), "earth_trinket"));
        if (MMBConfig.general_settings.LUMINOUS_RING)
            registry.register(MMBRegistry.setup(new ItemLuminousRing(), "luminous_ring"));
        if (MMBConfig.general_settings.NAGA_RING)
            registry.register(MMBRegistry.setup(new ItemNagaRing(), "naga_ring"));
        if (MMBConfig.general_settings.SUN_TRINKET)
            registry.register(MMBRegistry.setup(new ItemSunTrinket(), "sun_trinket"));
    }

    @SubscribeEvent
    public static void registerRecipes(RegistryEvent.Register<IRecipe> event) {
        final IForgeRegistry<IRecipe> registry = event.getRegistry();

        // Configurable recipes
        if (MMBConfig.general_settings.EARTH_TRINKET && MMBConfig.general_settings.EARTH_TRINKET_RECIPE) {
            registry.register(new ShapedOreRecipe(null, earthTrinket, "#X#", "X*X", "#X#", '#', "dirt", 'X', "cobblestone", '*', "netherStar")
                    .setRegistryName(MowziesMobsBaubles.MODID, "earth_trinket"));
        }

        if (MMBConfig.general_settings.LUMINOUS_RING && MMBConfig.general_settings.LUMINOUS_RING_RECIPE) {
            registry.register(new ShapedOreRecipe(null, luminousRing, "#X#", "X*X", "#X#", '#', ItemHandler.GLOWING_JELLY, 'X', "ingotGold", '*', "dustGlowstone")
                    .setRegistryName(MowziesMobsBaubles.MODID, "luminous_ring"));
        }

        if (MMBConfig.general_settings.NAGA_RING && MMBConfig.general_settings.NAGA_RING_RECIPE) {
            registry.register(new ShapedOreRecipe(null, nagaRing, "#X#", "X*X", "#X#", '#', ItemHandler.NAGA_FANG, 'X', "ingotGold", '*', Items.FERMENTED_SPIDER_EYE)
                    .setRegistryName(MowziesMobsBaubles.MODID, "naga_ring"));
        }

        if (MMBConfig.general_settings.SUN_TRINKET && MMBConfig.general_settings.SUN_TRINKET_RECIPE) {
            registry.register(new ShapedOreRecipe(null, sunTrinket, "#X#", "#*#", "###", '#', "blockGold", 'X', new ItemStack(ItemHandler.BARAKO_MASK, 1, OreDictionary.WILDCARD_VALUE), '*', "netherStar")
                    .setRegistryName(MowziesMobsBaubles.MODID, "sun_trinket"));
        }
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void onRegisterModelsEvent(@Nonnull final ModelRegistryEvent event) {
        // Item Models
        for (final Item item : ForgeRegistries.ITEMS.getValues()) {
            if (item.getRegistryName().getNamespace().equals(MowziesMobsBaubles.MODID)) {
                ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
            }
        }
    }
}
