package me.stopbox123.kit;

import java.util.HashMap;

import org.bukkit.entity.Player;

public class KitData {

	private static HashMap<String, Kit> kits = new HashMap<String, Kit>();
	private static HashMap<String, String> info = new HashMap<String, String>();
	
	public void init() {
		kits = new HashMap<String, Kit>();
		info = new HashMap<String, String>();
	}
	
	public static Kit getKitByName(String name) {
		if (kits.containsKey(name)) {
			return kits.get(name);
		} else {
			return null;
		}
	}
	
	public static String getKit(Player p) {
		return info.get(p.getName());
	}
	
	public static void setKit(Player p, String kitname) {
		info.put(p.getName(), kitname);
	}
	
	public static void put(String name, Kit kit) {
		kits.put(name, kit);
	}
}
