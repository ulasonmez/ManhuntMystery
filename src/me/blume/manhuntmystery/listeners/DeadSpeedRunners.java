package me.blume.manhuntmystery.listeners;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import me.blume.murdermystery.Main;

public class DeadSpeedRunners implements Listener{
	
	private Main plugin;
	public DeadSpeedRunners(Main plugin) {
		this.plugin=plugin;
	}
	@EventHandler
	public void onDeath(PlayerDeathEvent event) {
		if(plugin.hunter!=null) {
			if(!event.getEntity().equals(plugin.hunter)) {
				Player player = event.getEntity();
				player.setGameMode(GameMode.SPECTATOR);
			}
		}
	}

}
