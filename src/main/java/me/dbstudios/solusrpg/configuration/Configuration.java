package me.dbstudios.solusrpg.configuration;

import java.util.HashMap;
import java.util.Map;

public class Configuration {
	private static final Metadata<String> data = new Metadata<>();

	public static Object get(String key) {
		return Configuration.get(key, null);
	}

	public static Object get(String key, Object def) {
		return data.get(key, def);
	}

	public static <T> T getAs(String key, Class<T> type) {
		return Configuration.getAs(key, type, null);
	}

	public static <T> T getAs(String key, Class<T> type, T def) {
		return data.getAsType(key, type, def);
	}

	public static boolean is(String key) {
		return Configuration.is(key, false);
	}

	public static boolean is(String key, boolean def) {
		return Configuration.getAs(key, Boolean.class, def);
	}

	public static String getString(String key) {
		return Configuration.getString(key, null);
	}

	public static String getString(String key, String def) {
		return Configuration.getAs(key, String.class, def);
	}

	public static Integer getInteger(String key) {
		return Configuration.getInt(key, null);
	}

	public static Integer getInteger(String key, Integer def) {
		return Configuration.getAs(key, Integer.class, def);
	}

	public static Double getDouble(String key) {
		return Configuration.getDouble(key, null);
	}

	public static Double getDouble(String key, Double def) {
		return Configuration.getAs(key, Double.class, def);
	}

	public static void set(String key, Object value) {
		data.set(key, value);
	}

	public static void save() {
		File f = new File(Directories.CONFIG + "config.yml");
		FileConfiguration conf = YamlConfiguration.loadConfiguration(f);

		for (String key : data.keySet())
			conf.set(key, data.get(key));

		try {
			conf.save(f);
		} catch (IOException e) {
			SolusRpgPlugin.log(Level.WARNING, Language.get("system.files.write-error", "config.yml"));

			if (Configuration.is("logging.verbose"))
				e.printStackTrace();
		}
	}
}