package me.nate.deathlocation.listeners;

import me.nate.deathlocation.DeathLocation;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import static org.bukkit.World.Environment.*;

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
        World.Environment di = deathLoc.getWorld().getEnvironment();
        String x = String.valueOf(Math.round(deathLoc.getX()));
        String y = String.valueOf(Math.round(deathLoc.getY()));
        String z = String.valueOf(Math.round(deathLoc.getZ()));
        String ds = x+", "+y+", "+z ;
        String ps = String.valueOf(p.getPlayerListName());
        if (di == NORMAL) {
            String dim = "The Overworld";
            s.broadcastMessage(ps+" died at "+ds+" in "+dim);
        } else if (di == NETHER) {
            String dim = "The Nether";
            s.broadcastMessage(ps+" died at "+ds+" in "+dim);
        } else if (di == THE_END) {
            String dim = "The End";
            s.broadcastMessage(ps+" died at "+ds+" in "+dim);
        }
    }
}
