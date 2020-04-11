package org.Nokwok.Events;

import net.milkbowl.vault.chat.Chat;
import org.Nokwok.Main;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class onChat implements Listener {

    Main plugin;
    private Chat chat = null;

    public onChat(Main main, Chat chat) {
        this.plugin = main;
        this.chat = chat;
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e ) {
        Player p = e.getPlayer();
        String msg = e.getMessage();
        e.setFormat(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("format.chat").replace("<prefix>", chat.getPlayerPrefix(p)).replace("<player>", p.getName()).replace("<message>", msg)));

    }
}
