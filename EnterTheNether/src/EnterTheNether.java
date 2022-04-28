import me.blackvein.quests.CustomObjective;
import me.blackvein.quests.Quest;
import me.blackvein.quests.Quests;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;

public class EnterTheNether extends CustomObjective implements Listener {
    // Get the Quests plugin
    Quests qp = (Quests)Bukkit.getServer().getPluginManager().getPlugin("Quests");

    // Construct the objective
    public EnterTheNether() {
        this.setName("Enter The Nether");
        this.setAuthor("akbrr");
        this.setShowCount(false);
        this.setDisplay("Enter The Nether");
    }


    @EventHandler
    public void onPlayerPortalEvent(PlayerPortalEvent evt){
        for (Quest quest : (qp.getQuester(evt.getPlayer().getUniqueId())).getCurrentQuests().keySet()) {
            if(evt.getCause() == TeleportCause.NETHER_PORTAL){
                incrementObjective(evt.getPlayer(), this, 1, quest);
            }
        }
    }
} 