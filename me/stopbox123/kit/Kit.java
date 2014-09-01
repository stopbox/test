package me.stopbox123.kit;

import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

public class Kit {

	private ItemStack[] items;
	private ItemStack[] armor;
	
	private PotionEffect[] effects;
	private double health;
	
	public Kit(ItemStack[] items, ItemStack[] armor) {
		this.items = items;
		this.armor = armor;
		this.health = 20;
	}
	
	public Kit(ItemStack[] items, ItemStack[] armor, PotionEffect[] effects) {
		this.items = items;
		this.armor = armor;
		this.effects = effects;
		this.health = 20;
	}
	
	public Kit(ItemStack[] items, ItemStack[] armor, PotionEffect[] effects, boolean sprint, double health) {
		this.items = items;
		this.armor = armor;
		this.effects = effects;
		this.health = health;
	}
	
	public ItemStack[] getItems() {
		return items;
	}
	
	public ItemStack[] getArmor() {
		return armor;
	}
	
	public PotionEffect[] getPotionEffects() {
		return effects;
	}
	
	public double getHealth() {
		return health;
	}
}
