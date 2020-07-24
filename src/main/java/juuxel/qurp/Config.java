package juuxel.qurp;

import net.fabricmc.loader.api.FabricLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;

final class Config {
	static Algorithm lerp = Algorithm.HYPERP;
	static Algorithm clampedLerp = Algorithm.NONE;

	private static final Path CONFIG_PATH = FabricLoader.getInstance().getConfigDirectory().toPath().resolve("Qurp.properties");
	private static final Logger LOGGER = LogManager.getLogger("Qurp/Config");

	static void init() {
		try {
			if (Files.exists(CONFIG_PATH)) {
				load();
			}

			save();
		} catch (Exception e) {
			LOGGER.error("Could not load Qurp config", e);
		}

		if (lerp == Algorithm.CURP || clampedLerp == Algorithm.CURP) {
			LOGGER.warn("The CURP algorithm is enabled for lerping! This will be extremely slow.");
		}
	}

	private static void save() throws IOException {
		Properties props = new Properties();
		props.setProperty("Lerp", lerp.name());
		props.setProperty("ClampedLerp", clampedLerp.name());
		try (Writer writer = Files.newBufferedWriter(CONFIG_PATH)) {
			props.store(writer, "Algorithms: " + Stream.of(Algorithm.values()).map(Algorithm::name).collect(Collectors.joining(", ")));
		}
	}

	private static void load() throws IOException {
		Properties props = new Properties();
		try (Reader reader = Files.newBufferedReader(CONFIG_PATH)) {
			props.load(reader);
			lerp = Algorithm.valueOf(props.getProperty("Lerp", lerp.name()));
			clampedLerp = Algorithm.valueOf(props.getProperty("ClampedLerp", clampedLerp.name()));
		}
	}
}
