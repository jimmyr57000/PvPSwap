package fr.jrich.pvpswap.event.player;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import fr.jrich.pvpswap.PvPSwapListener;
import fr.jrich.pvpswap.PvPSwapPlugin;

public class PlayerCommandPreprocess extends PvPSwapListener {

    public PlayerCommandPreprocess(PvPSwapPlugin plugin) {
        super(plugin);
    }

    @EventHandler
    public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();
        if (player.isOp() && event.getMessage().split(" ")[0].equalsIgnoreCase("/reload")) {
            event.setCancelled(true);
            player.sendMessage(ChatColor.RED + "Cette fonctionnalit� est d�sactiv�e par le plugin PVPSwap � cause de contraintes techniques (reset des maps).");
        }
    }
}
