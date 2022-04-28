import org.bukkit.event.entity.EntityBreedEvent;
import me.blackvein.quests.CustomObjective;
import me.blackvein.quests.Quest;
import me.blackvein.quests.Quests;
import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;



public class sheepbreed extends CustomObjective implements Listener {
    // Get the Quests plugin
    Quests qp = (Quests)Bukkit.getServer().getPluginManager().getPlugin("Quests");

    // Construct the objective
    public sheepbreed() {
        this.setName("Baby Sheep");
        this.setAuthor("akbrr");
        this.setShowCount(false);
        this.setDisplay("Breed One Baby Sheep");
    }


    @EventHandler
    public void onEntityBreedEvent(EntityBreedEvent evt){
        if(Bukkit.getPlayer(evt.getBreeder().getUniqueId()) instanceof Player) {
    	Player p = (Player) Bukkit.getPlayer(evt.getBreeder().getUniqueId());
    	for (Quest quest : (qp.getQuester(p.getUniqueId())).getCurrentQuests().keySet()) {
            if(evt.getEntityType() == EntityType.SHEEP){
                incrementObjective(p, this, 1, quest);
            }
        }
        }
    }
} 
