package me.dbstudios.solusrpg.plugin;

import org.bukkit.plugin.java.JavaPlugin;

public class SolusRpgPlugin extends JavaPlugin {
	public void onEnable() {
		this.getLogger().info("SolusRpg enabled!");
	}

	public void onDisable() {
		this.getLogger().info("SolusRpg disabled.");
	}
}