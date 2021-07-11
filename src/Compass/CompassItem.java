package Compass;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class CompassItem {

	public ItemStack Tracker() {
		ItemStack tracker = new ItemStack(Material.COMPASS);
		ItemMeta meta = tracker.getItemMeta();
		meta.setDisplayName(ChatColor.AQUA+"Tracker");
		meta.addEnchant(Enchantment.DURABILITY, 2001, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		tracker.setItemMeta(meta);
		return tracker;
	}
}
