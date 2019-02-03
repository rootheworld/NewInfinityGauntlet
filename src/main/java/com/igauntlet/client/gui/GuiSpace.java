package com.igauntlet.client.gui;


import com.igauntlet.network.NetworkHandler;
import com.igauntlet.network.packets.MessageNoCoords;
import com.igauntlet.network.packets.MessageSpace;
import com.igauntlet.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;

import java.io.IOException;



public class GuiSpace extends GuiScreen {

    public GuiTextField xCoord;
    public GuiTextField yCoord;
    public GuiTextField zCoord;
    private GuiButton warp;
    private GuiButton coord;
    private GuiButton dimensions;

    static final int GUI_WIDTH = 256;
    static final int GUI_HEIGHT = 256;


    public static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MODID, "textures/gui/gui_gauntlet_space.png");


    private Minecraft mc;
    private FontRenderer fr;

    public GuiSpace() {
        mc = Minecraft.getMinecraft();
        fr = mc.fontRenderer;
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        if (button == this.warp) {
            BlockPos tpPos = new BlockPos(getInt(xCoord.getText(), XYZ.X), getInt(yCoord.getText(), XYZ.Y), getInt(zCoord.getText(), XYZ.Z));
            NetworkHandler.NETWORK.sendToServer(new MessageSpace(tpPos, mc.player.getEntityId()));
            Minecraft.getMinecraft().displayGuiScreen(null);
        }

        if(button == this.dimensions) {
            Minecraft.getMinecraft().displayGuiScreen(null);
        }

        super.actionPerformed(button);
    }

    private int getInt(String num, XYZ type) {
        if (num != null && !num.isEmpty()) {
            int i;
            try {
                i = Integer.parseInt(num);
            } catch (Exception e) {
                i = 0;
            }
            return i;
        } else {
            NetworkHandler.NETWORK.sendToServer(new MessageNoCoords(true));

            switch (type) {
                case X:
                    return (int) mc.player.posX;
                case Y:
                    return (int) mc.player.posY;
                case Z:
                    return (int) mc.player.posZ;
                default:
                    return 0;
            }
        }

    }

    @Override
    public void initGui() {
        int x = width / 2 - 15;
        int y = height / 2 - 15;
        String warpButton = "Warp";
        String dimension = "Dimension";

        int yOffset = fr.FONT_HEIGHT + 3;

        xCoord = new GuiTextField(0, fr, x - 40, y * 1 + 10, 100, fr.FONT_HEIGHT);
        yCoord = new GuiTextField(1, fr, x - 40, y + yOffset * 2, 100, fr.FONT_HEIGHT);
        zCoord = new GuiTextField(2, fr, x - 40, y + yOffset * 3 + 1, 100, fr.FONT_HEIGHT);
        warp = new GuiButton(3, x + 11, y + yOffset * 9, warpButton);
        dimensions = new GuiButton(4, x + 11, y + yOffset - 108, dimension);
        warp.x -= warp.width / 2;
        dimensions.x -= dimensions.width / 2;
        xCoord.setFocused(true);

        this.buttonList.clear();
        this.addButton(warp);
        this.addButton(dimensions);
    }


    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        xCoord.mouseClicked(mouseX, mouseY, mouseButton);
        yCoord.mouseClicked(mouseX, mouseY, mouseButton);
        zCoord.mouseClicked(mouseX, mouseY, mouseButton);
        super.mouseClicked(mouseX, mouseY, mouseButton);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {

        int x = (width - GUI_WIDTH) / 2;
        int y = (height - GUI_HEIGHT) / 2;

        mc.getTextureManager().bindTexture(TEXTURE);
        this.drawTexturedModalRect(x, y, 0, 0, GUI_WIDTH, GUI_HEIGHT);
        xCoord.drawTextBox();
        yCoord.drawTextBox();
        zCoord.drawTextBox();


        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException {
        xCoord.textboxKeyTyped(typedChar, keyCode);
        yCoord.textboxKeyTyped(typedChar, keyCode);
        zCoord.textboxKeyTyped(typedChar, keyCode);
        super.keyTyped(typedChar, keyCode);
    }

    @Override
    public void updateScreen() {
        xCoord.updateCursorCounter();
        yCoord.updateCursorCounter();
        zCoord.updateCursorCounter();
        super.updateScreen();
    }

    public enum XYZ {
        X, Y, Z
    }
}
