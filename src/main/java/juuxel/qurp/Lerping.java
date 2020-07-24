package juuxel.qurp;

public final class Lerping {
	public static double qurp(double delta) {
		return -4 * delta * (delta - 1);
	}

	public static double hyperp(double delta) {
		return 2 / (2 - delta) - 1;
	}

	public static double curp(double delta) {
		delta *= 2.7;
		delta = -4 * delta * (delta - 1) + delta * delta * delta;
		delta *= 0.8;

		return delta;
	}

	public static double onLerp(double delta) {
		return Config.lerp.modifyDelta(delta);
	}

	public static double onClampedLerp(double delta) {
		return Config.clampedLerp.modifyDelta(delta);
	}
}
