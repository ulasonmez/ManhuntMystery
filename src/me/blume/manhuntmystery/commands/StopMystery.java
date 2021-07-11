package me.blume.manhuntmystery.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.blume.murdermystery.Main;
import me.blume.murdermystery.methods.ChangeNames;

public class StopMystery implements CommandExecutor{

	@SuppressWarnings("unused")
	private Main plugin;
	public StopMystery(Main plugin) {
		this.plugin=plugin;
	}
	ChangeNames cn = new ChangeNames();
	@SuppressWarnings("static-access")
	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String label, String[] args) {
		if(args.length==0) {
			if(label.equals("stopmystery")) {
				if(sender instanceof Player) {
					for(Player p : Bukkit.getOnlinePlayers()) {
						cn.changeName(plugin.names.get(p), p);
					}
					for(Player p : Bukkit.getOnlinePlayers()) {
						Bukkit.dispatchCommand(p, "skin clear");
					}
					plugin.hunter = null;
				}
			}
		}


		return false;
	}
	
}
