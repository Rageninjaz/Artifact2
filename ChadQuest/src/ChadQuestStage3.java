import me.blackvein.quests.CustomObjective;
import me.blackvein.quests.Quest;
import me.blackvein.quests.Quests;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;

public class ChadQuestStage3 extends CustomObjective implements Listener {
	// Get the Quests plugin
	Quests qp = (Quests) Bukkit.getServer().getPluginManager().getPlugin("Quests");

	// Construct the objective
	public ChadQuestStage3() {
		this.setName("4: Celebrate With a Drink!");
		this.setAuthor("Chad");
		this.setShowCount(false);
		this.setDisplay("Drink A Potion of Poison");
	}

	@EventHandler
	public void onPlayerItemConsumeEvent(PlayerItemConsumeEvent evt) {

		Player p = evt.getPlayer();
		if (evt.getItem() != null && evt.getItem().hasItemMeta()) {
			if (evt.getItem().getItemMeta() instanceof PotionMeta) {

				final PotionMeta meta = (PotionMeta) evt.getItem().getItemMeta();
				final PotionData data = meta.getBasePotionData();

				for (Quest quest : (qp.getQuester(p.getUniqueId())).getCurrentQuests().keySet()) {
					if (data.getType() == PotionType.POISON) {
						incrementObjective(p, this, 1, quest);
					}
				}
			}
		}
	}

}