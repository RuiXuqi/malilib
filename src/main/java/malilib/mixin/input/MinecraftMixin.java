package malilib.mixin.input;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.Minecraft;

import malilib.MinecraftClientAccessor;
import malilib.input.InputDispatcherImpl;
import malilib.input.KeyBindImpl;
import malilib.registry.Registry;

@Mixin(Minecraft.class)
public abstract class MinecraftMixin implements MinecraftClientAccessor
{
    @Shadow private boolean actionKeyF3;

    @Unique
    @Override
    public void setActionKeyF3(boolean value)
    {
        this.actionKeyF3 = value;
    }

    @Inject(method = "runTickKeyboard", cancellable = true,
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/Minecraft;dispatchKeypresses()V"))
    private void onKeyboardInput(CallbackInfo ci)
    {
        if (((InputDispatcherImpl) Registry.INPUT_DISPATCHER).onKeyInput())
        {
            ci.cancel();
        }
    }

    @Inject(method = "runTick", at = @At("RETURN"))
    private void onPostKeyboardInput(CallbackInfo ci)
    {
        KeyBindImpl.reCheckPressedKeys();
    }
}
