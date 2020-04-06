package org.Nokwok;

import org.Nokwok.Events.onJoin;
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
    }

    private void SetupCmds() {
    }
}
