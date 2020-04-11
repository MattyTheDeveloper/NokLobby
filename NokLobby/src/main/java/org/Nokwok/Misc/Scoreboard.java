package org.Nokwok.Misc;

import net.milkbowl.vault.chat.Chat;
import org.Nokwok.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;

public class Scoreboard implements Listener {

    Main plugin;
    private Chat chat = null;

    public Scoreboard(Main main, Chat chat) {
        this.plugin = main;
        this.chat = chat;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if (chat.getPlayerPrefix(p) == null) {

            org.bukkit.scoreboard.Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
            Objective obj = board.registerNewObjective("Main", "dummy", ChatColor.translateAlternateColorCodes('&', "&b&lNokwok"));
            obj.setDisplaySlot(DisplaySlot.SIDEBAR);


            Score blank = obj.getScore(ChatColor.GRAY + " ");
            blank.setScore(5);
            Score name = obj.getScore(ChatColor.GRAY + "Name: " + ChatColor.AQUA + p.getDisplayName());
            name.setScore(4);
            Score rank = obj.getScore(ChatColor.GRAY + "Rank: " + ChatColor.AQUA + "N/A");
            rank.setScore(3);
            Score blank1 = obj.getScore(ChatColor.GRAY + "  ");
            blank1.setScore(2);
            Score server = obj.getScore(ChatColor.GRAY + "Lobby: " + ChatColor.AQUA + "#1");
            server.setScore(1);

            p.setScoreboard(board);
        } else {
            org.bukkit.scoreboard.Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
            Objective obj = board.registerNewObjective("Main", "dummy", ChatColor.translateAlternateColorCodes('&', "&b&lNokwok"));
            obj.setDisplaySlot(DisplaySlot.SIDEBAR);


            Score blank = obj.getScore(ChatColor.GRAY + " ");
            blank.setScore(5);
            Score name = obj.getScore(ChatColor.GRAY + "Name: " + ChatColor.AQUA + p.getDisplayName());
            name.setScore(4);
            Score rank = obj.getScore(ChatColor.GRAY + "Rank: " + ChatColor.AQUA + ChatColor.translateAlternateColorCodes('&', chat.getPlayerPrefix(p)));
            rank.setScore(3);
            Score blank1 = obj.getScore(ChatColor.GRAY + "  ");
            blank1.setScore(2);
            Score server = obj.getScore(ChatColor.GRAY + "Lobby: " + ChatColor.AQUA + "#1");
            server.setScore(1);

            p.setScoreboard(board);
        }
    }




}
