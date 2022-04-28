import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.blackvein.quests.CustomReward;

public class ChadReward extends CustomReward {
	// Construct the reward

	public ChadReward() {
		this.setName("Chad's Reward");
		this.setAuthor("Chad");
	}

	// Give loot reward to a player
	@Override
	public void giveReward(Player player, Map<String, Object> data) {
		ItemStack g = new ItemStack(Material.GOLDEN_HELMET, 1);
		ItemMeta im = g.getItemMeta();
		im.setDisplayName(ChatColor.AQUA + "Chad's Crown of Conquest");
		g.setItemMeta(im);
		g.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
		g.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
		g.addUnsafeEnchantment(Enchantment.MENDING, 1);
		g.addUnsafeEnchantment(Enchantment.WATER_WORKER, 3);
		g.addUnsafeEnchantment(Enchantment.OXYGEN, 1);

		ItemStack h = new ItemStack(Material.COOKED_BEEF, 1);
		ItemMeta im2 = h.getItemMeta();
		im2.setDisplayName(ChatColor.DARK_AQUA + "X-TRA TUFF STEAK");
		h.setItemMeta(im2);
		h.addUnsafeEnchantment(Enchantment.KNOCKBACK, 2);
		player.getInventory().addItem(g);
		player.getInventory().addItem(h);

	}
}
