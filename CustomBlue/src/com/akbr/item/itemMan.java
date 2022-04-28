package com.akbr.item;
import org.bukkit.Material;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class itemMan {
	public static ItemStack mirror;
	public static void init() {
        createMirror();
    }

    private static void createMirror() {
    	ItemStack item = new ItemStack(Material.BARRIER, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Mirror");
        List<String> lore = new ArrayList<>();
        lore.add("Access to Hat GUI");
        meta.setLore(lore);
        item.setItemMeta(meta);
        mirror = item;
    }
}
