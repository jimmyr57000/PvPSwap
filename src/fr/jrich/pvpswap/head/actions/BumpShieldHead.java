package fr.jrich.pvpswap.head.actions;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import fr.jrich.pvpswap.PvPSwapPlugin;
import fr.jrich.pvpswap.handler.Head.HeadAction;
import fr.jrich.pvpswap.util.MathUtils;

public class BumpShieldHead extends HeadAction {

    @Override
    public void onDamage(Player player, Player damager) {
        player.sendMessage(PvPSwapPlugin.prefix + "Votre bouclier vous a protégé de l'attaque !");
        damager.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 60, 1));
        damager.setVelocity(new Vector(MathUtils.random(0.8F), MathUtils.random(0.8F) + 0.6F, MathUtils.random(0.8F)));
    }

    @Override
    public void onRun(Player player) {}
}
