package net.slimesurvival.mixin;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.hud.BossBarHud;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

/*
	Fixes bossbars with custom styles losing transparency if they're not first
	Fixed in 22w11a (1.19)
	Source: https://github.com/ModsByLeo/MultiBossBarFix/blob/1.16/src/main/java/adudecalledleo/multibossbarfix/mixin/MixinBossBarHud.java
*/

@Mixin(BossBarHud.class)
public class BossBarHudMixin {
	@Redirect(method = "renderBossBar", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/hud/BossBarHud;drawTexture(Lnet/minecraft/client/util/math/MatrixStack;IIIIII)V", ordinal = 1))
	private void slimesurvival$blitOverlay(BossBarHud bossBarHud, MatrixStack matrixStack, int x, int y, int u, int v, int width, int height) {
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		bossBarHud.drawTexture(matrixStack, x, y, u, v, width, height);
		RenderSystem.disableBlend();
	}

	@Redirect(method = "renderBossBar", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/hud/BossBarHud;drawTexture(Lnet/minecraft/client/util/math/MatrixStack;IIIIII)V", ordinal = 3))
	private void slimesurvival$blitOverlayFill(BossBarHud bossBarHud, MatrixStack matrixStack, int x, int y, int u, int v, int width, int height) {
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		bossBarHud.drawTexture(matrixStack, x, y, u, v, width, height);
		RenderSystem.disableBlend();
	}
}
