package juuxel.qurp.mixinor;

import juuxel.qurp.Lerping;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(MathHelper.class)
abstract class MathHelperMixinor {
	@ModifyVariable(method = "lerp3", at = @At("HEAD"), argsOnly = true, ordinal = 0)
	private static double modifyLerp3X(double delta) {
		return Lerping.onLerp(delta);
	}

	@ModifyVariable(method = "lerp3", at = @At("HEAD"), argsOnly = true, ordinal = 2)
	private static double modifyLerp3Y(double delta) {
		return Lerping.onLerp(delta);
	}

	@ModifyVariable(method = "lerp3", at = @At("HEAD"), argsOnly = true, ordinal = 4)
	private static double modifyLerp3Z(double delta) {
		return Lerping.onLerp(delta);
	}
}
