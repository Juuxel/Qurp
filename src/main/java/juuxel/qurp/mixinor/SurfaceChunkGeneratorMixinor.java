package juuxel.qurp.mixinor;

import juuxel.qurp.Lerping;
import net.minecraft.world.gen.chunk.SurfaceChunkGenerator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(SurfaceChunkGenerator.class)
abstract class SurfaceChunkGeneratorMixinor {
	@ModifyArg(method = "populateNoise", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/math/MathHelper;lerp(DDD)D"), index = 0)
	private double modifyPopulateNoise(double delta) {
		return Lerping.onLerp(delta);
	}

	@ModifyArg(method = "sampleNoiseColumn([DII)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/math/MathHelper;clampedLerp(DDD)D"), index = 0)
	private double modifySampleNoiseColumn(double delta) {
		return Lerping.onClampedLerp(delta);
	}

	@ModifyArg(method = "sampleNoise", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/math/MathHelper;clampedLerp(DDD)D"), index = 0)
	private double modifySampleNoise(double delta) {
		return Lerping.onClampedLerp(delta);
	}
}
