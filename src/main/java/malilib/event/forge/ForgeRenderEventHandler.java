package malilib.event.forge;

import malilib.MaLiLibReference;
import malilib.event.dispatch.RenderEventDispatcherImpl;
import malilib.registry.Registry;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.client.event.RenderTooltipEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(modid = MaLiLibReference.MOD_ID, value = Side.CLIENT)
public class ForgeRenderEventHandler
{
    @SubscribeEvent
    public static void onRenderGameOverlayPost(RenderGameOverlayEvent.Post event)
    {
        if (event.getType() == ElementType.ALL)
        {
            ((RenderEventDispatcherImpl) Registry.RENDER_EVENT_DISPATCHER).onRenderGameOverlayPost();
        }
    }

    @SubscribeEvent
    public static void onRenderTooltipPost(RenderTooltipEvent.PostText event)
    {
        ((RenderEventDispatcherImpl) Registry.RENDER_EVENT_DISPATCHER).onRenderTooltipPost(event.getStack(), event.getX(), event.getY());
    }

    @SubscribeEvent
    public static void onDrawScreenPost(GuiScreenEvent.DrawScreenEvent.Post event)
    {
        ((RenderEventDispatcherImpl) Registry.RENDER_EVENT_DISPATCHER).onRenderScreenPost(event.getRenderPartialTicks());
    }

    @SubscribeEvent
    public static void onRenderWorldLast(RenderWorldLastEvent event)
    {
        ((RenderEventDispatcherImpl) Registry.RENDER_EVENT_DISPATCHER).onRenderWorldLast(event.getPartialTicks());
    }
}
