package malilib.event.forge;

import malilib.MaLiLibReference;
import malilib.event.dispatch.TickEventDispatcherImpl;
import malilib.registry.Registry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(modid = MaLiLibReference.MOD_ID, value = Side.CLIENT)
public class ForgeTickEventHandler
{
    @SubscribeEvent
    public static void onClientTickEnd(TickEvent.ClientTickEvent event)
    {
        if (event.phase == Phase.END)
        {
            ((TickEventDispatcherImpl) Registry.TICK_EVENT_DISPATCHER).onClientTick();
        }
    }
}
