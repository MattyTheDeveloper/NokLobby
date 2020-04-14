package org.Nokwok.Events;

import net.milkbowl.vault.chat.Chat;
import org.Nokwok.Main;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

import java.util.ArrayList;

public class onJoin implements Listener {

    Main plugin;
    private Chat chat = null;

    public onJoin(Main main, Chat chat) {
        this.plugin = main;
        this.chat = chat;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e ) {
        Player p = e.getPlayer();
        p.setGameMode(GameMode.ADVENTURE);
        p.setAllowFlight(true);
        p.setFlying(true);

        int x = plugin.getConfig().getInt("Spawn.X");
        int y = plugin.getConfig().getInt("Spawn.Y");
        int z = plugin.getConfig().getInt("Spawn.Z");
        p.teleport(new Location(p.getWorld(), x,y,z));

        p.setPlayerListName(ChatColor.translateAlternateColorCodes('&', chat.getPlayerPrefix(p)+p.getName()));

        if (p.hasPlayedBefore()) {
            if (p.hasPermission(plugin.getConfig().getString("Lobby.Join"))) {
                e.setJoinMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("format.join").replace("<prefix>", chat.getPlayerPrefix(p)).replace("<player>", p.getName())));
            } else {
                e.setJoinMessage(null);
            }
        } else {
            int unique = plugin.getConfig().getInt("firstjoins");
            unique++;
            plugin.getConfig().set("firstjoins", unique);
            plugin.saveConfig();

            String uniquestring = String.valueOf(unique);
            e.setJoinMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("format.firstjoin").replace("[UNIQUE]", uniquestring).replace("<player>", p.getName())));
        }
    }

    @EventHandler
    public void onJoin(PlayerQuitEvent e ) {
        Player p = e.getPlayer();

        if (p.hasPermission(plugin.getConfig().getString("Lobby.Join"))) {
            e.setQuitMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("format.quit").replace("<prefix>", chat.getPlayerPrefix(p)).replace("<player>", p.getName())));
        } else {
            p.setAllowFlight(true);
            e.setQuitMessage(null);
        }
    }

}

