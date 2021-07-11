package Compass;

import java.util.ArrayList;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

import me.blume.murdermystery.Main;

public class CantDrop implements Listener{

	CompassItem items = new CompassItem();
	private Main plugin;
	public CantDrop(Main plugin) {
		this.plugin=plugin;
		
	}
	@EventHandler
	public void trackerDrops(PlayerDropItemEvent event) {
		if(plugin.hunter!=null) {
			if(plugin.hunter.equals(event.getPlayer())) {
				if(event.getItemDrop().getItemStack().getEnchantments().containsValue(2001)) {
					event.setCancelled(true);
					return;
				}
			}
		}
	}
	@EventHandler
	public void trackerDeath1(PlayerDeathEvent event) {
		if(plugin.hunter == event.getEntity()) {
			ArrayList<ItemStack> drops = new ArrayList<ItemStack>(event.getDrops());
			for(ItemStack drop : drops) {
				if(drop!=null) {
					if(drop.getEnchantmentLevel(Enchantment.DURABILITY)==2001) {
						event.getDrops().remove(event.getDrops().indexOf(drop));
					}
				}
			}
		}
	}
	@EventHandler
	public void trackerRespawn(PlayerRespawnEvent event) {
		if(plugin.hunter == event.getPlayer()) {
			event.getPlayer().getInventory().addItem(items.Tracker());
			return;
		}
		else return;
	}
}

