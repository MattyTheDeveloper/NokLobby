package org.Nokwok;

import org.Nokwok.Commands.elytra;
import org.Nokwok.Events.onBlockEvent;
import org.Nokwok.Events.onJoin;
import org.Nokwok.Events.onPvP;
import org.Nokwok.Misc.Scoreboard;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    FileConfiguration config = getConfig();
    
    @Override
    public void onEnable() {
        getLogger().info("Plugin has successfully loaded.");
        config.options().copyDefaults(true);
        saveConfig();

        SetupCmds();
        SetupEvents();
    }

    private void SetupEvents() {
        getServer().getPluginManager().registerEvents(new onJoin(this), this);
        getServer().getPluginManager().registerEvents(new Scoreboard(this), this);
        getServer().getPluginManager().registerEvents(new onPvP(this), this );
        getServer().getPluginManager().registerEvents(new onBlockEvent(this), this);
        getServer().getPluginManager().registerEvents(new serverClickEvent(this), this);
        getServer().getPluginManager().registerEvents(new firstJoin(this), this);
        getServer().getPluginManager().registerEvents(new ItemDropEvent(), this);
    }

    private void SetupCmds() {
        this.getCommand("Elytra").setExecutor(new elytra(this));
    }
}
