package com.akbr.events;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.permissions.PermissionAttachmentInfo;

import com.akbr.gui.inventory;

public class customBlueEvents implements Listener {

	@EventHandler
	public void onPlayerInteractEvent(PlayerInteractEvent evt) {
		if (evt.getAction() == Action.RIGHT_CLICK_BLOCK
				&& evt.getClickedBlock().getBlockData().getAsString().equals("Mirror")) {
			Player p = evt.getPlayer();

			ArrayList<String> comp = new ArrayList<String>();
			ArrayList<String> item = new ArrayList<String>();
			comp.add("hat.name1");
			for (String s : comp) {
				if (p.hasPermission(s)) {
					item.add(s.replaceFirst("hat.", ""));
				}
			}
			inventory ret = new inventory(item);
			ret.openInventory(p);
			
		}
	}
}
