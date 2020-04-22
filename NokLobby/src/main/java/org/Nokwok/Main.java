package org.Nokwok;

import net.milkbowl.vault.chat.Chat;
import org.Nokwok.Commands.elytra;
import org.Nokwok.Commands.event;
import org.Nokwok.Commands.spawn;
import org.Nokwok.Events.*;
import org.Nokwok.Misc.Scoreboard;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;

import java.io.*;

public class Main extends JavaPlugin implements Listener {
    FileConfiguration config = getConfig();
    private Chat chat = null;
    
    @Override
    public void onEnable() {
        org.bukkit.scoreboard.Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective obj = board.registerNewObjective("Main", "dummy", ChatColor.translateAlternateColorCodes('&', "&b&lNokwok"));

        getLogger().info("Plugin has successfully loaded.");
        config.options().copyDefaults(true);
        saveConfig();

        setupChat();
        SetupCmds();
        SetupEvents();
        SetupScoreboard();
        getLogger().info(config.getString("test"));


        getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            public void run() {
                for (Player a : getServer().getOnlinePlayers()) {
                    obj.setDisplaySlot(DisplaySlot.SIDEBAR);
                }
            }
        }, 1, 1);

    }



    private void SetupEvents() {
        getServer().getPluginManager().registerEvents(new onJoin(this, chat), this);
        getServer().getPluginManager().registerEvents(new onPvP(this, chat), this );
        getServer().getPluginManager().registerEvents(new onBlockEvent(this, chat), this);
        getServer().getPluginManager().registerEvents(new onChat(this, chat), this);
        getServer().getPluginManager().registerEvents(new ItemDropEvent(this, chat), this);
        getServer().getPluginManager().registerEvents(new MobEvent(), this);
        getServer().getPluginManager().registerEvents(new InventoryEvent(this, chat), this);
        getServer().getPluginManager().registerEvents(new MiniHitEvent(), this);

        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
    }

    private void SetupCmds() {
        this.getCommand("spawn").setExecutor(new spawn(this, chat));
        this.getCommand("elytra").setExecutor(new elytra(this));
        this.getCommand("event").setExecutor(new event(this));
    }

    private boolean setupChat() {
        RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
        chat = rsp.getProvider();
        return chat != null;
    }

    private void SetupScoreboard() {
        for (Player a : Bukkit.getOnlinePlayers()) {
            org.bukkit.scoreboard.Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
            Objective obj = board.registerNewObjective("Main", "dummy", ChatColor.translateAlternateColorCodes('&', "&b&lNokwok"));
            obj.setDisplaySlot(DisplaySlot.SIDEBAR);


            Score blank = obj.getScore(ChatColor.GRAY + " ");
            Score ONLINE = obj.getScore(ChatColor.GRAY+"Online: "+ChatColor.AQUA+Bukkit.getOnlinePlayers().size());
            Score name = obj.getScore(ChatColor.GRAY + "Name: " + ChatColor.AQUA + a.getDisplayName());
            Score rank = obj.getScore(ChatColor.GRAY + "Rank: " + ChatColor.AQUA + ChatColor.translateAlternateColorCodes('&', chat.getPlayerPrefix(a)));
            Score blank1 = obj.getScore(ChatColor.GRAY + "  ");
            Score server = obj.getScore(ChatColor.GRAY + "Lobby: " + ChatColor.AQUA + "#1");
            Score unique = obj.getScore(ChatColor.GRAY + "Unique Joins: #" + ChatColor.AQUA + this.getConfig().getString("firstjoins"));
            blank.setScore(6);
            name.setScore(5);
            rank.setScore(4);
            blank1.setScore(3);
            server.setScore(2);
            unique.setScore(1);
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p =e.getPlayer();
        p.setScoreboard(board);
    }

    public Chat getChat() {
        return chat;
    }

}

