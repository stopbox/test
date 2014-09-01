package me.stopbox123.event;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathEvent implements Listener {
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		e.getDrops().clear();
	}

}
