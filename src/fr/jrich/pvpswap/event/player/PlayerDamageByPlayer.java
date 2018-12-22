package fr.jrich.pvpswap.event.player;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import fr.jrich.pvpswap.PvPSwapListener;
import fr.jrich.pvpswap.PvPSwapPlugin;
import fr.jrich.pvpswap.handler.Step;

public class PlayerDamageByPlayer extends PvPSwapListener {

    public PlayerDamageByPlayer(PvPSwapPlugin plugin) {
        super(plugin);
    }

    @EventHandler
    public void onEntityDamageByPlayer(EntityDamageByEntityEvent event) {
        if (PvPSwapPlugin.godMode && event.getEntity() instanceof Player && (event.getDamager() instanceof Player || event.getDamager() instanceof Projectile && ((Projectile) event.getDamager()).getShooter() instanceof Player)) {
            event.setCancelled(true);
            if (Step.isStep(Step.IN_GAME)) {
                Player damager = (Player) (event.getDamager() instanceof Player ? event.getDamager() : ((Projectile) event.getDamager()).getShooter());
                damager.sendMessage(PvPSwapPlugin.prefix + ChatColor.RED + "Le pvp n'est pas activé.");
            }
        }
    }
}
