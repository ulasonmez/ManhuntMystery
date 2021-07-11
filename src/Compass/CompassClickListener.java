package Compass;

import java.util.List;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.CompassMeta;

import me.blume.murdermystery.Main;
import net.md_5.bungee.api.ChatColor;

public class CompassClickListener implements Listener {
	private Main plugin;
	public CompassClickListener(Main plugin) {
		this.plugin=plugin;
	}
	CompassItem ci = new CompassItem();
	@EventHandler
	public void onClickCompass(PlayerInteractEvent event) {
		Player hunter = event.getPlayer();
		Action action = event.getAction();
		ItemStack item = event.getItem();
		if(action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.RIGHT_CLICK_BLOCK)) {
			if (item != null && item.getEnchantmentLevel(Enchantment.DURABILITY)==2001) {
			//if (item.equals(ci.Tracker())) {
				Player closestVictim = getClosestVictim(hunter);
				if (closestVictim != null) {
					CompassMeta meta = (CompassMeta) item.getItemMeta();

					if (meta == null) {
						meta = (CompassMeta) (new ItemStack(Material.COMPASS).getItemMeta());
					}

					meta.setLodestoneTracked(false);
					meta.setLodestone(closestVictim.getLocation());
					item.setItemMeta(meta);

					//  hunter.sendMessage(ChatColor.AQUA + "Now tracking " + closestVictim.getName() + ".");
				} else {
					hunter.sendMessage(ChatColor.AQUA + "Could not find a player to track in your world.");
				}
			}
		}
	}
	private Player getClosestVictim(Player hunter) {
		Player hunterPlayer = plugin.hunter;
		Location hunterLocation = hunter.getLocation();
		Player closestPlayer = null;
		double closestDistanceSquared = Double.MAX_VALUE;

		List<Player> candidates = hunter.getWorld().getPlayers();
		for (Player p : candidates) {
			if (!hunterPlayer.equals(p) && p.getGameMode() == GameMode.SURVIVAL) {
				double distanceSquared = p.getLocation().distanceSquared(hunterLocation);
				if (distanceSquared <= closestDistanceSquared) {
					closestDistanceSquared = distanceSquared;
					closestPlayer = p;
				}
			}
		}
		return closestPlayer;
	}
}
