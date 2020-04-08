package org.Nokwok.Events;



import org.Nokwok.Main;

import org.bukkit.ChatColor;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import org.bukkit.event.EventHandler;

import org.bukkit.event.Listener;

import org.bukkit.event.player.PlayerJoinEvent;

import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;


public class firstJoin implements Listener {
Main plugin;

    public firstJoin(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler

    public void firstJoin(PlayerJoinEvent e) {

        Player p = e.getPlayer();

        if (p.hasPermission("event.firstjoin")) {
            if (!p.hasPlayedBefore()) {
                ItemStack server = new ItemStack(Material.COMPASS);
                ItemMeta servermeta = server.getItemMeta();
                servermeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&7Server List"));
                ArrayList<String> serverlore = new ArrayList<>();
                serverlore.add(ChatColor.translateAlternateColorCodes('&', "&7Server List"));
                servermeta.setLore(serverlore);
                p.getInventory().addItem(server);
            }
        }
    }
}

