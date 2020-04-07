package org.Nokwok.Events;

import org.Nokwok.Main;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class onJoin implements Listener {

    Main plugin;
    public onJoin(Main instance) {
        plugin = instance;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e ) {
        Player p = e.getPlayer();

        if (p.hasPermission("event.join")) {
            e.setJoinMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Joinformat").replace("<player>", p.getName())));
        } else {
            e.setJoinMessage(null);
        }
    }

    @EventHandler
    public void onJoin(PlayerQuitEvent e ) {
        Player p = e.getPlayer();

        if (p.hasPermission("event.join")) {
            p.setAllowFlight(true);
            e.setQuitMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Leaveformat").replace("<player>", p.getName())));
        } else {
            p.setAllowFlight(true);
            e.setQuitMessage(null);
        }
    }
}
