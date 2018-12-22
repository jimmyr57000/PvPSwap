package fr.jrich.pvpswap.event.player;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.metadata.FixedMetadataValue;

import fr.jrich.pvpswap.PvPSwapListener;
import fr.jrich.pvpswap.PvPSwapPlugin;
import fr.jrich.pvpswap.handler.Head;
import fr.jrich.pvpswap.handler.Step;
import fr.jrich.pvpswap.util.MathUtils;
import fr.jrich.pvpswap.util.SpectatorUtils;
import fr.jrich.pvpswap.util.StatsUtils;

public class PlayerDeath extends PvPSwapListener {

    public PlayerDeath(PvPSwapPlugin plugin) {
        super(plugin);
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        if (Step.isStep(Step.LOBBY) || SpectatorUtils.isSpectator(event.getEntity())) {
            event.setDeathMessage(null);
            event.getDrops().clear();
            event.setDroppedExp(0);
        } else {
            event.setDeathMessage(PvPSwapPlugin.prefix + event.getDeathMessage());
            Player player = event.getEntity();
            Player killer = player.getKiller();
            if (killer != null) {
                AsyncPlayerChat.specs.clear();
                StatsUtils.addCoins(killer, 2);
            }
            if (!PvPSwapPlugin.duelMode) {
                Head head = Head.values()[MathUtils.random(Head.values().length - 1)];
                player.getWorld().dropItemNaturally(player.getLocation(), head.getItem());
            }
            player.setMetadata("DEATH", new FixedMetadataValue(plugin, player.getLocation()));
            plugin.onPlayerLoose(player);
        }
    }
}
