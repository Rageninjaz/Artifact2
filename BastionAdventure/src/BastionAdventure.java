import me.blackvein.quests.CustomObjective;
import me.blackvein.quests.Quest;
import me.blackvein.quests.Quests;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.StructureType;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.World.Environment;;

public class BastionAdventure extends CustomObjective implements Listener {
	// Get the Quests plugin
	Quests qp = (Quests) Bukkit.getServer().getPluginManager().getPlugin("Quests");

	// Construct the objective
	public BastionAdventure() {
		this.setName("Bastion Adventure");
		this.setAuthor("akbrr");
		this.setShowCount(false);
		this.setDisplay("Locate a Bastion Remnant");
	}

	@EventHandler
	public void onPlayerMoveEvent(PlayerMoveEvent evt) {
		if (evt.getPlayer().getWorld().getEnvironment() == Environment.NETHER) {
			for (Quest quest : (qp.getQuester(evt.getPlayer().getUniqueId())).getCurrentQuests().keySet()) {
				if (evt.getPlayer().getLocation().distance(evt.getPlayer().getWorld().locateNearestStructure(evt.getPlayer().getLocation(), StructureType.BASTION_REMNANT, 100, false)) <= 91) {
					incrementObjective(evt.getPlayer(), this, 1, quest);
				}
			}
		}
	}
}