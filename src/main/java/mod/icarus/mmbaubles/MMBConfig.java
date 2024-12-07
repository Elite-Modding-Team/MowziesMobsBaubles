package mod.icarus.mmbaubles;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class MMBConfig {
    @Config.Comment("General")
    public static GeneralSettings general_settings = new GeneralSettings();

    public static class GeneralSettings {
        @Config.Name("Bauble: Trinket of Earth")
        @Config.Comment("Enables the Trinket of Earth, which provides the Geomancy effect while equipped. [default: true]")
        @Config.RequiresMcRestart
        public boolean EARTH_TRINKET = true;

        @Config.Name("Bauble: Trinket of the Sun")
        @Config.Comment("Enables the Trinket of the Sun, which provides the Sun's Blessing effect while equipped. [default: true]")
        @Config.RequiresMcRestart
        public boolean SUN_TRINKET = true;

        @Config.Name("Recipe: Trinket of Earth")
        @Config.Comment("Enables a default recipe for the Trinket of Earth, leave this disabled if you want to add your own recipe. [default: true]")
        @Config.RequiresMcRestart
        public boolean EARTH_TRINKET_RECIPE = true;

        @Config.Name("Recipe: Trinket of the Sun")
        @Config.Comment("Enables a default recipe for the Trinket of the Sun, leave this disabled if you want to add your own recipe. [default: true]")
        @Config.RequiresMcRestart
        public boolean SUN_TRINKET_RECIPE = true;
    }

    @Mod.EventBusSubscriber(modid = MowziesMobsBaubles.MODID)
    public static class EventHandler {
        @SubscribeEvent
        public static void onConfigChanged(final ConfigChangedEvent.OnConfigChangedEvent event) {
            if (event.getModID().equals(MowziesMobsBaubles.MODID)) {
                ConfigManager.sync(MowziesMobsBaubles.MODID, Config.Type.INSTANCE);
            }
        }
    }
}
