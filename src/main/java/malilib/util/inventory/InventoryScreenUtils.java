package malilib.util.inventory;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Slot;

public class InventoryScreenUtils
{
    public static int getGuiPosX(GuiContainer gui)
    {
        return gui.getGuiLeft();
    }

    public static int getGuiPosY(GuiContainer gui)
    {
        return gui.getGuiTop();
    }

    public static int getGuiSizeX(GuiContainer gui)
    {
        return gui.getXSize();
    }

    public static int getGuiSizeY(GuiContainer gui)
    {
        return gui.getYSize();
    }

    public static Slot getSlotUnderMouse(GuiContainer gui)
    {
        return gui.getSlotUnderMouse();
    }
}
