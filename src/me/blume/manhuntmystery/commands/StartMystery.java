package me.blume.manhuntmystery.commands;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Compass.CompassItem;
import me.blume.murdermystery.Main;
import me.blume.murdermystery.methods.ChangeNames;
import net.md_5.bungee.api.ChatColor;

public class StartMystery implements CommandExecutor{

	private Main plugin;
	public StartMystery(Main plugin) {
		this.plugin=plugin;
	}
	CompassItem ci = new CompassItem();
	ChangeNames cn = new ChangeNames();
	Random rand = new Random();
	@SuppressWarnings("static-access")
	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String label, String[] args) {
		if(sender instanceof Player) {
			if(label.equals("startmystery")) {
				if(args.length==0) {
					if(plugin.hunter==null) {
						
						Player hunterPlayer = randomPlayer();
						plugin.hunter = hunterPlayer;
						for(Player p : Bukkit.getOnlinePlayers()) {
							if(p.equals(hunterPlayer)) {
								p.sendMessage(ChatColor.RED+"You are the HUNTER");
							}
							else {
								p.sendMessage(ChatColor.GREEN+"You are a speed runner");
							}
						}
						hunterPlayer.getInventory().setItem(3, ci.Tracker());
						Player randomPlayer = randomPlayer();
						for(Player p : Bukkit.getOnlinePlayers()) {
							plugin.names.put(p, p.getName());
						}
						/*for(Player p : Bukkit.getOnlinePlayers()) {
							if(!p.equals(randomPlayer)) 
								Bukkit.dispatchCommand(p, "skin "+randomPlayer.getName());
						}*/
						for(Player p : Bukkit.getOnlinePlayers()) {
							if(!p.equals(randomPlayer)) 
								cn.changeName(randomPlayer.getName(), p);
						}
					}
				}
			}
		}
		return false;
	}
	int count;
	public Player randomPlayer() {
		count = rand.nextInt(Bukkit.getOnlinePlayers().size());
		int i = 0;
		for(Player p : Bukkit.getOnlinePlayers()) {
			if(i == count) {
				return p;
			}
			i++;
		}
		return null;
	}
	
}
