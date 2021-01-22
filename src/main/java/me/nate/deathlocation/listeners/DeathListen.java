package me.nate.deathlocation.listeners;

import me.nate.deathlocation.DeathLocation;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathListen implements Listener {
    private DeathLocation plugin;
    public DeathListen(DeathLocation plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler
    public void deathEvent(PlayerDeathEvent d) {
        Player p = d.getEntity();
        Location deathLoc = p.getLocation();
        Server s = p.getServer();
        String x = String.valueOf(deathLoc.getX());
        String y = String.valueOf(deathLoc.getY());
        String z = String.valueOf(deathLoc.getZ());
        String ds = x+", "+y+", "+z ;
        String ps = String.valueOf(p.getPlayerListName());
        s.broadcastMessage(ps+" died at "+ds);
    }
}
