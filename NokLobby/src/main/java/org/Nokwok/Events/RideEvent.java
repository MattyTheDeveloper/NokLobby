package org.Nokwok.Events;

import net.milkbowl.vault.chat.Chat;
import org.Nokwok.Main;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

public class RideEvent implements Listener {

    Main plugin;
    private Chat chat = null;

    public RideEvent(Main main, Chat chat) {
        this.plugin = main;
        this.chat = chat;
    }

    @EventHandler
    public void onRightClick(PlayerInteractAtEntityEvent e) {
        Player p = e.getPlayer();
        if (e.getRightClicked().getType().equals(EntityType.PLAYER)) {
            Entity target = e.getRightClicked();
            if (p.hasPermission(plugin.getConfig().getString("Lobby.Ride"))) {
                target.addPassenger(p);
                p.playSound(p.getLocation(), Sound.ENTITY_BAT_TAKEOFF, 3.0F, 0.5F);

            }

        }
    }


}
