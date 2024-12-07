package mod.icarus.mmbaubles;

import mod.icarus.mmbaubles.MowziesMobsBaubles;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = MowziesMobsBaubles.MODID, name = MowziesMobsBaubles.NAME, version = MowziesMobsBaubles.VERSION, dependencies = MowziesMobsBaubles.DEPENDENCIES)
public class MowziesMobsBaubles {
    public static final String MODID = Tags.MOD_ID;
    public static final String NAME = "Mowzie's Mobs' Baubles";
    public static final String VERSION = Tags.VERSION;
    public static final String DEPENDENCIES = "required-after:llibrary;required-after:mowziesmobs;required-after:baubles;";

    @Mod.Instance
    public static MowziesMobsBaubles instance;

    public static boolean isServer() {
        return FMLCommonHandler.instance().getEffectiveSide() == Side.SERVER;
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
    }

    @EventHandler
    public void postinit(FMLPostInitializationEvent event) {
    }
}
