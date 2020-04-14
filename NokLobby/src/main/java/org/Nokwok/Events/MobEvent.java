package org.Nokwok.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class MobEvent implements Listener {

    @EventHandler
    public void EntitySpawn(EntitySpawnEvent e) {
        e.setCancelled(true);
    }
}
