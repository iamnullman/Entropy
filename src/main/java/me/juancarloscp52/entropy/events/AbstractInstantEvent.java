package me.juancarloscp52.entropy.events;

import me.juancarloscp52.entropy.Variables;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.math.MathHelper;

public abstract class AbstractInstantEvent implements Event {

    public void end() {
    }

    @Override
    @Environment(EnvType.CLIENT)
    public void endClient() {
    }

    @Environment(EnvType.CLIENT)
    public void render(MatrixStack matrixStack, float tickdelta) {
    }

    @Environment(EnvType.CLIENT)
    public void renderQueueItem(MatrixStack matrixStack, float tickdelta, int x, int y) {
        if(Variables.doNotShowEvents)
            return;
        MinecraftClient client = MinecraftClient.getInstance();
        int size = client.textRenderer.getWidth(new TranslatableText(EventRegistry.getTranslationKey(this)));
        DrawableHelper.drawTextWithShadow(matrixStack, MinecraftClient.getInstance().textRenderer, new TranslatableText(EventRegistry.getTranslationKey(this)), client.getWindow().getScaledWidth() - size - 40, y, MathHelper.packRgb(255, 255, 255));
    }

    public void tick() {
    }

    @Environment(EnvType.CLIENT)
    public void tickClient() {
    }

    public short getTickCount() {
        return 0;
    }

    @Override
    public void setTickCount(short index) {
    }

    public short getDuration() {
        return 0;
    }

    public boolean hasEnded() {
        return true;
    }

    @Override
    public void setEnded(boolean ended) {
    }
}
