import me.blackvein.quests.CustomObjective;
import me.blackvein.quests.Quest;
import me.blackvein.quests.Quests;
import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTameEvent;



public class ChadQuestStage1 extends CustomObjective implements Listener {
    // Get the Quests plugin
    Quests qp = (Quests)Bukkit.getServer().getPluginManager().getPlugin("Quests");

    // Construct the objective
    public ChadQuestStage1() {
        this.setName("1: Chad ConQuest");
        this.setAuthor("Chad");
        this.setShowCount(false);
        this.setDisplay("Tame a Wild Cat");
    }


    @EventHandler
    public void onEntityTameEvent(EntityTameEvent evt){
        for (Quest quest : (qp.getQuester(evt.getOwner().getUniqueId())).getCurrentQuests().keySet()) {
            if(evt.getEntityType() == EntityType.CAT){
                incrementObjective((Player) evt.getOwner(), this, 1, quest);
            }
        }
    }
} 