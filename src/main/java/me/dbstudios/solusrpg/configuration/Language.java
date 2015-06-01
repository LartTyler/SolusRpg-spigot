package me.dbstudios.solusrpg.configuration;

import java.util.HashMap;
import java.util.Map;

public class Language {
	private static final Map<String, String> languages = new HashSet<>();
	// private static final Map<String, String> phrases = new HashMap<>();

	static {
		Language.init();
	}

	private static void init() {
		File f = new File(Directories.CONFIG_LANG + "registry.yml");

		if (!f.exists())
			throw new RuntimeException("No language registry found. SolusRpg cannot function without a language file.");

		FileConfiguration registry = YamlConfiguration.loadConfiguration(f);
		ConfigurationSection language = registry.getConfigurationSection("language");

		if (language != null)
			for (String key : language.getKeys(false))
				registry.put(key, language.getString(key, key));
		else
			throw new RuntimeException("No language files exist in the registry. SolusRpg cannot function without a language file.");
	}
}