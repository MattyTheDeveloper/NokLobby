package org.Nokwok.Events;

import org.Nokwok.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class onPvP implements Listener {

    Main plugin;

    public onPvP(Main instance) {
        plugin = instance;
    }

    @EventHandler
    public void onPvp(EntityDamageByEntityEvent e) {
        if (plugin.getConfig().getString("PVP").equals(false)) {
            e.setCancelled(true);
        } else {
            e.setCancelled(false);
        }
    }

}
