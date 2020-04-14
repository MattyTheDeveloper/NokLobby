package org.Nokwok;

import net.milkbowl.vault.chat.Chat;
import org.Nokwok.Commands.elytra;
import org.Nokwok.Commands.spawn;
import org.Nokwok.Events.*;
import org.Nokwok.Misc.Scoreboard;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;

import java.io.*;

public class Main extends JavaPlugin implements Listener {
    FileConfiguration config = getConfig();
    private Chat chat = null;
    
    @Override
    public void onEnable() {

        getLogger().info("Plugin has successfully loaded.");
        config.options().copyDefaults(true);
        saveConfig();

        setupChat();
        SetupCmds();
        SetupEvents();
        getLogger().info(config.getString("test"));

    }


    private void SetupEvents() {
        getServer().getPluginManager().registerEvents(new onJoin(this, chat), this);
        getServer().getPluginManager().registerEvents(new Scoreboard(this, chat), this);
        getServer().getPluginManager().registerEvents(new onPvP(this, chat), this );
        getServer().getPluginManager().registerEvents(new onBlockEvent(this, chat), this);
        getServer().getPluginManager().registerEvents(new onChat(this, chat), this);
        getServer().getPluginManager().registerEvents(new RideEvent(this, chat), this);
        getServer().getPluginManager().registerEvents(new ItemDropEvent(this, chat), this);
        getServer().getPluginManager().registerEvents(new MobEvent(), this);
        getServer().getPluginManager().registerEvents(new InventoryEvent(this, chat), this);
    }

    private void SetupCmds() {
        this.getCommand("spawn").setExecutor(new spawn(this, chat));
        this.getCommand("elytra").setExecutor(new elytra(this));
    }

    private boolean setupChat() {
        RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
        chat = rsp.getProvider();
        return chat != null;
    }

    public Chat getChat() {
        return chat;
    }

}

