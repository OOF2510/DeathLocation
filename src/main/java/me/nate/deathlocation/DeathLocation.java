package me.nate.deathlocation;

import me.nate.deathlocation.listeners.DeathListen;
import org.bukkit.plugin.java.JavaPlugin;

public final class DeathLocation extends JavaPlugin {

    @Override
    public void onEnable() {
        new DeathListen(this);
    }
}
