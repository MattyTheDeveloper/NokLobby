package org.Nokwok.Events;


import net.milkbowl.vault.chat.Chat;
import org.Nokwok.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

public class ItemDropEvent implements Listener {

    Main plugin;
    private Chat chat = null;

    public ItemDropEvent(Main main, Chat chat) {
        this.plugin = main;
        this.chat = chat;
    }

    @EventHandler
    public void onItemDrop(PlayerDropItemEvent e){
        Player p = e.getPlayer();
        if (!p.hasPermission("Lobby.drop")){
            e.setCancelled(true);
        }else{
            e.setCancelled(false);
        }
    }
}