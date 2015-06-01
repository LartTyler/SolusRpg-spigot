package me.dbstudios.solusrpg.configuration;

import java.io.File;

public enum Directories {
	BASE("plugins::dbstudios::SolusRpg::"),
	CONFIG(BASE + "config::"),
	CONFIG_LANG(CONFIG + "language::");

	private final String path;

	private Directories(String path) {
		this.path = path.replace("::", File.separator);
	}

	public String toString() {
		return this.path;
	}
}