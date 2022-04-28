import me.blackvein.quests.CustomObjective;
import me.blackvein.quests.Quest;
import me.blackvein.quests.Quests;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;



public class Chad4 extends CustomObjective implements Listener {
    // Get the Quests plugin
    Quests qp = (Quests)Bukkit.getServer().getPluginManager().getPlugin("Quests");

    // Construct Chad4 objective
    public Chad4() {
        this.setName("3: Absolute Power");
        this.setAuthor("Chad");
        this.setShowCount(false);
        this.setDisplay("Destroy an Obsidian Block with your bare fists");
    }


    @SuppressWarnings("deprecation")
	@EventHandler
    public void onBlockBreakEvent(BlockBreakEvent evt){
        if(evt.getBlock().getType() == Material.OBSIDIAN) {
    	for (Quest quest : (qp.getQuester(evt.getPlayer().getUniqueId())).getCurrentQuests().keySet()) {
            if(evt.getPlayer().getItemInHand().getType() == Material.AIR){
                incrementObjective(evt.getPlayer(), this, 1, quest);
            }
    	}
        }
    }
} 