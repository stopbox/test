package me.stopbox123.event;

import java.util.Collections;

import me.stopbox123.kit.Kit;
import me.stopbox123.kit.KitData;


//import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class SignClickEvent implements Listener {

	@EventHandler
	public void onClick(PlayerInteractEvent e) {
//		Bukkit.broadcastMessage("Check1");
		if (e.getAction() == Action.LEFT_CLICK_BLOCK) {
//			Bukkit.broadcastMessage("Check2");
			if (e.getClickedBlock().getType() == Material.WALL_SIGN) {
//				Bukkit.broadcastMessage("Check3");
				Sign sign = (Sign)e.getClickedBlock().getState();
//				Bukkit.broadcastMessage("Line 0 empty: " + sign.getLine(0).isEmpty());
				if (sign.getLine(0).isEmpty()) {
//					Bukkit.broadcastMessage("Check4");
					String name = sign.getLine(2);
					Kit kit = KitData.getKitByName(name);
					KitData.setKit(e.getPlayer(), name);
					ItemStack[] armor = kit.getArmor();
					ItemStack[] items = kit.getItems();
					Player p = e.getPlayer();
					p.getInventory().clear();
					p.getInventory().setArmorContents(null);
					
					p.getInventory().setHelmet(armor[0]);
					p.getInventory().setChestplate(armor[1]);
					p.getInventory().setLeggings(armor[2]);
					p.getInventory().setBoots(armor[3]);
					
					p.setMaxHealth(kit.getHealth());
					p.setHealth(p.getMaxHealth());
					
					for (int index = 0; index < items.length; index++) {
						p.getInventory().addItem(items[index]);
					}
					
					if (!(kit.getPotionEffects() == null)) {
						for (int index = 0; index < kit.getPotionEffects().length; index++) {
							p.addPotionEffect(kit.getPotionEffects()[index]);
						}
					}
				}
			}
		}
	}
	
}
