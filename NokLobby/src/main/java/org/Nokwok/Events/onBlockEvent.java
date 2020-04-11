package org.Nokwok.Events;

import net.milkbowl.vault.chat.Chat;
import org.Nokwok.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class onBlockEvent implements Listener {

    Main plugin;
    private Chat chat = null;

    public onBlockEvent(Main main, Chat chat) {
        this.plugin = main;
        this.chat = chat;
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        Player p = e.getPlayer();
        if (p.hasPermission(plugin.getConfig().getString("Lobby.Build"))) {
            e.setCancelled(false);
        } else {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        if (p.hasPermission(plugin.getConfig().getString("Lobby.Build"))) {
            e.setCancelled(false);
        } else {
            e.setCancelled(true);
        }
    }
}
