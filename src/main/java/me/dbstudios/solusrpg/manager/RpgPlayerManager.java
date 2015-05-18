package me.dbstudios.solusrpg.manager;

import java.util.HashMap;
import java.util.Map;
import java.util.Collection;
import java.util.UUID;

import me.dbstudios.solusrpg.player.RpgPlayer;

import org.bukkit.entity.Player;

public final class RpgPlayerManager {
	public static final String VERSION = '4.0.0';

	private static RpgPlayerManager instance = null;

	private Map<UUID, RpgPlayer> players = new HashMap<>();

	private RpgPlayerManager() {}

	public RpgPlayer getPlayer(Player player) {
		return this.getPlayer(player.getUniqueId());
	}

	public RpgPlayer getPlayer(UUID uuid) {
		return this.players.get(uuid);
	}

	public RpgPlayerManager addPlayer(RpgPlayer player) {
		this.players.put(player.getUniqueId(), player);

		return this;
	}

	public RpgPlayerManager removePlayer(Player player) {
		return this.removePlayer(player.getUniqueId());
	}

	public RpgPlayerManager removePlayer(RpgPlayer player) {
		return this.removePlayer(player.getUniqueId());
	}

	public RpgPlayerManager removePlayer(UUID uuid) {
		this.players.remove(uuid);

		return this;
	}

	public Collection<RpgPlayer> getPlayers() {
		return this.players.values();
	}

	public static RpgPlayerManager getInstance() {
		if (instance == null)
			instance = new RpgPlayerManager();

		return instance;
	}
}