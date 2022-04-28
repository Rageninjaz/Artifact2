import org.bukkit.event.entity.EntityBreedEvent;
import me.blackvein.quests.CustomObjective;
import me.blackvein.quests.Quest;
import me.blackvein.quests.Quests;
import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;



public class cowbreed extends CustomObjective implements Listener {
    // Get the Quests plugin
    Quests qp = (Quests)Bukkit.getServer().getPluginManager().getPlugin("Quests");

    // Construct the objective
    public cowbreed() {
        this.setName("Baby Cow");
        this.setAuthor("akbrr");
        this.setShowCount(false);
        this.setDisplay("Breed One Baby Cow");
    }


    @EventHandler
    public void onEntityBreedEvent(EntityBreedEvent evt){
        if(Bukkit.getPlayer(evt.getBreeder().getUniqueId()) instanceof Player) {
    	Player p = (Player) Bukkit.getPlayer(evt.getBreeder().getUniqueId());
    	for (Quest quest : (qp.getQuester(p.getUniqueId())).getCurrentQuests().keySet()) {
            if(evt.getEntityType() == EntityType.COW){
                incrementObjective(p, this, 1, quest);
            }
        }
        }
    }
} 
