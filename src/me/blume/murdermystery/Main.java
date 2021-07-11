package me.blume.murdermystery;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import Compass.CantDrop;
import Compass.CompassClickListener;
import me.blume.manhuntmystery.commands.StartMystery;
import me.blume.manhuntmystery.commands.StopMystery;
import me.blume.manhuntmystery.listeners.DeadSpeedRunners;


public class Main extends JavaPlugin{
	public HashMap<Player,String> names = new HashMap<Player,String>();
	public Player hunter = null;
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new CompassClickListener(this), this);
		getServer().getPluginManager().registerEvents(new CantDrop(this), this);
		getServer().getPluginManager().registerEvents(new DeadSpeedRunners(this), this);
		getCommand("startmystery").setExecutor(new StartMystery(this));
		getCommand("stopmystery").setExecutor(new StopMystery(this));
	}
	@Override
	public void onDisable() {
		
	}
	
}
