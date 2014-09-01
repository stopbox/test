package me.stopbox123.flag;

import java.util.List;

import me.stopbox123.util.GeometryUtil;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Flag {
	
//	private ArrayList<Block> blocks = new ArrayList<Block>();
	
	private Location loc;
	private int range;
	
	private int tick = 20 * 5;
//	private int players = 0;
	
	public Flag(Location loc, int range) {
		
	}
	
	public void tick() {
		List<Player> nearby = GeometryUtil.getNearbyPlayers(this.loc, this.range);
		
		if (nearby.size() != 0) {
			tick -= nearby.size();
			Bukkit.broadcastMessage("" + tick);
			if (tick <= 0) {
//				for (Block b : blocks) {
		//			if (!b.getData() != 0)
//				}
			}
		}
	}

}
