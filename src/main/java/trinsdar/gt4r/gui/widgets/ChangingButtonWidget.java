package trinsdar.gt4r.gui.widgets;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import muramasa.antimatter.Antimatter;
import muramasa.antimatter.gui.ButtonBody;
import muramasa.antimatter.gui.ButtonOverlay;
import muramasa.antimatter.gui.GuiInstance;
import muramasa.antimatter.gui.IGuiElement;
import muramasa.antimatter.gui.event.IGuiEvent;
import muramasa.antimatter.gui.widget.ButtonWidget;
import muramasa.antimatter.gui.widget.ScreenWidget;
import muramasa.antimatter.gui.widget.WidgetSupplier;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;
import java.util.function.Consumer;

public class ChangingButtonWidget extends ButtonWidget {
    public ChangingButtonWidget(GuiInstance instance, IGuiElement parent, ResourceLocation res, @Nullable ButtonBody body, @Nullable ButtonOverlay overlay, @Nullable Consumer<ButtonWidget> onPress) {
        super(instance, parent, res, body, overlay, onPress);
    }

    public static WidgetSupplier build(ResourceLocation res, ButtonBody body, ButtonOverlay overlay, IGuiEvent ev, int id) {
        return builder(((a,b) -> new ChangingButtonWidget(a,b, res, body, overlay, but -> Antimatter.NETWORK.sendToServer(but.gui.handler.createGuiPacket(ev, id, Screen.hasShiftDown() ? 1 : 0))))).clientSide();
    }

    @Override
    public void render(MatrixStack matrixStack, double mouseX, double mouseY, float partialTicks) {
        Minecraft minecraft = Minecraft.getInstance();
        minecraft.getTextureManager().bindTexture(res);
        RenderSystem.disableDepthTest();
        boolean isActive = activeHandler == null || activeHandler.apply(this);
        if (body != null) {
            int xTex = body.getX();
            int yTex = body.getY();
            if (isActive) {
                xTex += body.getX2();
                yTex += body.getY2();
            }
            ScreenWidget.blit(matrixStack, realX(), realY(), this.getW(), this.getH(), xTex, yTex, body.getW(), body.getH(), 256, 256);
        }
    }
}