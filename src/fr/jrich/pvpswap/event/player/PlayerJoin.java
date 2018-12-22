package fr.jrich.pvpswap.event.player;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

import fr.jrich.pvpswap.PvPSwapItems;
import fr.jrich.pvpswap.PvPSwapListener;
import fr.jrich.pvpswap.PvPSwapPlugin;
import fr.jrich.pvpswap.handler.Step;
import fr.jrich.pvpswap.scheduler.BeginCountdown;
import fr.jrich.pvpswap.util.SpectatorUtils;
import fr.jrich.pvpswap.util.StatsUtils;

public class PlayerJoin extends PvPSwapListener {

    public PlayerJoin(PvPSwapPlugin plugin) {
        super(plugin);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.getInventory().clear();
        StatsUtils.loadData(player);
        if (!Step.canJoin() && player.hasPermission("games.join")) {
            event.setJoinMessage(null);
            SpectatorUtils.setSpectator(plugin, player);
        } else if (Step.isStep(Step.LOBBY)) {
            event.setJoinMessage(PvPSwapPlugin.prefix + ChatColor.WHITE + player.getName() + ChatColor.GRAY + " a rejoint la partie " + ChatColor.GREEN + "(" + Bukkit.getOnlinePlayers().length + "/" + Bukkit.getMaxPlayers() + ")");
            player.setGameMode(GameMode.ADVENTURE);
            player.getInventory().setItem(8, PvPSwapItems.HUB_ITEM);
            player.teleport(plugin.getLobbyLocation());
            if (!BeginCountdown.started && !plugin.isReady()) {
                BeginCountdown.started = true;
            } else if (!BeginCountdown.started && Bukkit.getOnlinePlayers().length >= Bukkit.getMaxPlayers() / 2) {
                new BeginCountdown(plugin);
            }
        }
    }
}
