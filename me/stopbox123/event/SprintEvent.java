package me.stopbox123.event;

import me.stopbox123.kit.KitData;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSprintEvent;

public class SprintEvent implements Listener {
	
	@EventHandler(ignoreCancelled = true)
	public void onToggle(PlayerToggleSprintEvent e) {
		if (KitData.getKit(e.getPlayer()) == "halberdier") {
			e.setCancelled(true);
			if (e.getPlayer().isSprinting()) {
				e.getPlayer().setSprinting(false);
			}
		}
	}

}
