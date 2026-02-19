package malilib.event.forge;

import malilib.MaLiLibReference;
import malilib.input.InputDispatcherImpl;
import malilib.registry.Registry;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(modid = MaLiLibReference.MOD_ID, value = Side.CLIENT)
public class ForgeInputEventHandler
{
//    @SubscribeEvent
//    public static void onKeyboardInput(InputEvent.KeyInputEvent event)
//    {
//        // This event isn't cancellable, and is fired after vanilla key handling >_>
//        // So this one is handled with a Mixin in MixinMinecraft
//        //((InputDispatcherImpl) Registry.INPUT_DISPATCHER).onKeyInput();
//    }

    @SubscribeEvent
    public static void onMouseEvent(MouseEvent event)
    {
        if (((InputDispatcherImpl) Registry.INPUT_DISPATCHER).onMouseInput())
        {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onGuiKeyboardInputPre(GuiScreenEvent.KeyboardInputEvent.Pre event)
    {
        if (((InputDispatcherImpl) Registry.INPUT_DISPATCHER).onKeyInput())
        {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onGuiMouseInputPre(GuiScreenEvent.MouseInputEvent.Pre event)
    {
        if (((InputDispatcherImpl) Registry.INPUT_DISPATCHER).onMouseInput())
        {
            event.setCanceled(true);
        }
    }
}
