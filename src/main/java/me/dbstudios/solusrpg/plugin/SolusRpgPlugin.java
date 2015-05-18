package me.dbstudios.solusrpg.plugin;

import org.bukkit.plugin.java.JavaPlugin;

public class SolusRpgPlugin extends JavaPlugin {
	private static SolusRpgPlugin instance = null;

	public void onEnable() {
		instance = this;

		this.getLogger().info("SolusRpg enabled!");
	}

	public void onDisable() {
		this.getLogger().info("SolusRpg disabled.");
	}

	public static SolusRpgPlugin getInstance() {
		return instance;
	}
}