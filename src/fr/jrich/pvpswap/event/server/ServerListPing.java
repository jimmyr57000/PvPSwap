package fr.jrich.pvpswap.event.server;

import org.bukkit.event.EventHandler;
import org.bukkit.event.server.ServerListPingEvent;

import fr.jrich.pvpswap.PvPSwapListener;
import fr.jrich.pvpswap.PvPSwapPlugin;
import fr.jrich.pvpswap.handler.Step;

public class ServerListPing extends PvPSwapListener {

    public ServerListPing(PvPSwapPlugin plugin) {
        super(plugin);
    }

    @EventHandler
    public void onServerListPing(ServerListPingEvent event) {
        event.setMotd(Step.getMOTD());
    }
}
