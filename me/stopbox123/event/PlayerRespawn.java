package me.stopbox123.event;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class PlayerRespawn implements Listener {
	
	@EventHandler
	public void onRespawn(PlayerRespawnEvent e) { 
		Location loc = new Location(Bukkit.getWorlds().get(0), -333.5, 4.5, 159.5, 90, 0);
		e.setRespawnLocation(loc);
	}

}
