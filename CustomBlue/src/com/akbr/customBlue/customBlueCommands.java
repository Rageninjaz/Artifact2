package com.akbr.customBlue;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.akbr.item.itemMan;

public class customBlueCommands implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player))
			return false;
		Player p = (Player) sender;
		
		if (!cmd.getName().equalsIgnoreCase("hat")) {
			return false;
		}

		if (args == null || args.length == 0) {
			p.sendMessage(ChatColor.DARK_AQUA + "/hat help");
			return true;
		}

		switch (args[0].toLowerCase()) {
		case "help":
			p.sendMessage("Access the GUI from the mirror");
			if (p.getServer().getDefaultGameMode() == GameMode.CREATIVE) {
				p.sendMessage("Use /hat mirror to recieve hat GUI Mirror (Only in Creative)");
			}
			return true;
		case "mirror":
			if (p.getServer().getDefaultGameMode() == GameMode.CREATIVE) {
				p.getInventory().addItem(itemMan.mirror);
				p.sendMessage(ChatColor.DARK_AQUA + "I was too lazy to make it craftable");
			} else {
				p.sendMessage(ChatColor.DARK_AQUA + "Only accessible in Creative Mode");
			}
			return true;
		default:
			p.sendMessage("/hat help");
			return true;
		}
	}
}
