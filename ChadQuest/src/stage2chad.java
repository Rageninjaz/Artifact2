import me.blackvein.quests.CustomObjective;
import me.blackvein.quests.Quest;
import me.blackvein.quests.Quests;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class stage2chad extends CustomObjective implements Listener {
	// Get the Quests plugin
	Quests qp = (Quests) Bukkit.getServer().getPluginManager().getPlugin("Quests");

	// Construct the objective
	public stage2chad() {
		this.setName("2: Show Your Dominance");
		this.setAuthor("Chad");
		this.setShowCount(false);
		this.setDisplay("Kill a Villager with only an Emerald Block in your hand");
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onEntityDeathEvent(EntityDeathEvent evt) {
		if (evt.getEntity().getKiller() instanceof Player) {
			Player p = (Player) evt.getEntity().getKiller();
			for (Quest quest : (qp.getQuester(p.getUniqueId())).getCurrentQuests().keySet()) {
				if (evt.getEntityType() == EntityType.VILLAGER
						&& p.getItemInHand().getType() == Material.EMERALD_BLOCK) {
					incrementObjective(p, this, 1, quest);
				}
			}
		}
	}
}
