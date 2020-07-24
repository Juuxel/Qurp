package juuxel.qurp;

import net.fabricmc.api.ModInitializer;

public final class Init implements ModInitializer {
	@Override
	public void onInitialize() {
		Config.init();
	}
}
