package com.akbr.customBlue;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

import com.akbr.events.customBlueEvents;
import com.akbr.item.itemMan;

public class customBlue extends JavaPlugin{
	@Override
	public void onEnable() {
		itemMan.init();
		getCommand("hat").setExecutor(new customBlueCommands());
		getServer().getPluginManager().registerEvents(new customBlueEvents(), this);
		getServer().getConsoleSender().sendMessage(ChatColor.DARK_AQUA + "[CustomBlue] Plugin is enabled ;)");
	}
	
	public void onDisable() {
		
		
		getServer().getConsoleSender().sendMessage(ChatColor.DARK_AQUA + "[CustomBlue] Plugin is disabled :(");
	}
	
	
}
