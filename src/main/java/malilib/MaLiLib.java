package malilib;

import malilib.event.dispatch.InitializationDispatcherImpl;
import malilib.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

@Mod(
        modid = MaLiLibReference.MOD_ID,
        name = MaLiLibReference.MOD_NAME,
        version = MaLiLibReference.MOD_VERSION,
        dependencies = "required-after:mixinbooter@[8.0,)",
        guiFactory = "malilib.config.factory.MaLiLibGuiFactory",
        acceptableRemoteVersions = "*",
        customProperties = {
                @Mod.CustomProperty(k = "license", v = "LGPLv3"),
                @Mod.CustomProperty(k = "issueTrackerUrl", v = "https://github.com/RuiXuqi/malilib/issues")
        }
)
public class MaLiLib
{
    public static final Logger LOGGER = LogManager.getLogger(MaLiLibReference.MOD_ID);

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        // Register all mod handlers
        ((InitializationDispatcherImpl) Registry.INITIALIZATION_DISPATCHER).onGameInitDone();
    }

    public static boolean canShowCoordinates()
    {
        return MaLiLibConfigs.Generic.HIDE_ALL_COORDINATES.getBooleanValue() == false;
    }

    public static void debugLog(String str, Object... args)
    {
        if (MaLiLibConfigs.Debug.DEBUG_MESSAGES.getBooleanValue())
        {
            LOGGER.info(str, args);
        }
    }
}
