package me.stopbox123.battle;

import me.stopbox123.event.DeathEvent;
import me.stopbox123.event.PlayerJoin;
import me.stopbox123.event.PlayerRespawn;
import me.stopbox123.event.SignClickEvent;
import me.stopbox123.event.SprintEvent;
import me.stopbox123.kit.Kit;
import me.stopbox123.kit.KitData;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		/*
		 * Archer
		 */
		ItemStack[] archeri = new ItemStack[5];
		archeri[0] = new ItemStack(Material.WOOD_SWORD, 1);
		archeri[1] = new ItemStack(Material.BOW, 1);
		archeri[1].addEnchantment(Enchantment.ARROW_DAMAGE, 1);
		archeri[2] = new ItemStack(Material.ARROW, 48);
		archeri[3] = new ItemStack(Material.LADDER, 4);
		archeri[4] = new ItemStack(Material.COOKED_BEEF, 1);
		ItemStack[] archera = new ItemStack[4];
		archera[0] = new ItemStack(Material.LEATHER_HELMET, 1);
		archera[1] = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
		archera[2] = new ItemStack(Material.LEATHER_LEGGINGS, 1);
		archera[3] = new ItemStack(Material.LEATHER_BOOTS, 1);
		Kit archer = new Kit(archeri, archera);

		/*
		 * Swords Men
		 */

		ItemStack[] swordsi = new ItemStack[3];
		swordsi[0] = new ItemStack(Material.IRON_SWORD, 1);
		swordsi[1] = new ItemStack(Material.LADDER, 4);
		swordsi[2] = new ItemStack(Material.COOKED_BEEF, 1);
		ItemStack[] swordsa = new ItemStack[4];
		swordsa[0] = new ItemStack(Material.IRON_HELMET, 1);
		swordsa[1] = new ItemStack(Material.IRON_CHESTPLATE, 1);
		swordsa[2] = new ItemStack(Material.IRON_LEGGINGS, 1);
		swordsa[3] = new ItemStack(Material.IRON_BOOTS, 1);
		Kit swords = new Kit(swordsi, swordsa);

		/*
		 * Halberdier
		 */
		
		ItemStack[] halbi = new ItemStack[2];
		halbi[0] = new ItemStack(Material.IRON_AXE, 1);
		halbi[0].addEnchantment(Enchantment.DAMAGE_ALL, 3);
		ItemStack[] halba = new ItemStack[4];
		halba[0] = new ItemStack(Material.CHAINMAIL_HELMET, 1);
		halba[1] = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
		halba[1].addEnchantment(Enchantment.THORNS, 3);
		halba[2] = new ItemStack(Material.CHAINMAIL_LEGGINGS, 1);
		halba[3] = new ItemStack(Material.IRON_BOOTS, 1);
		PotionEffect[] potioneffects = new PotionEffect[4];
		potioneffects[0] = new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, Integer.MAX_VALUE, 1, true);
		potioneffects[1] = new PotionEffect(PotionEffectType.SLOW, Integer.MAX_VALUE, 2, true);
		potioneffects[2] = new PotionEffect(PotionEffectType.SLOW_DIGGING, Integer.MAX_VALUE, 9, true);
		potioneffects[3] = new PotionEffect(PotionEffectType.REGENERATION, Integer.MAX_VALUE, 1, true);
		Kit halb = new Kit(halbi, halba, potioneffects, false, 30);
		/*
		 * Save Kits
		 */

		KitData.put("archer", archer);
		KitData.put("swordsmen", swords);
		KitData.put("halberdier", halb);

		/*
		 * Register Events
		 */

		PluginManager pm = Bukkit.getPluginManager();

		pm.registerEvents(new SignClickEvent(), this);
		pm.registerEvents(new DeathEvent(), this);
		pm.registerEvents(new PlayerJoin(), this);
		pm.registerEvents(new PlayerRespawn(), this);
		pm.registerEvents(new SprintEvent(), this);
		
		/*
		 * Init all Task
		 */
		
		initFoodTask();
	}

	public void initFoodTask() {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			@SuppressWarnings("deprecation")
			public void run() {
				for (Player p : Bukkit.getOnlinePlayers()) {
					if (!p.getInventory().contains(Material.COOKED_BEEF) && !p.isDead()) {
						p.getInventory().addItem(new ItemStack(Material.COOKED_BEEF, 1));
						p.updateInventory();
					}
				}
			}
		}, 1L, 1L);
	}
	
}
