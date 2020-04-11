package org.Nokwok.Commands;

import net.milkbowl.vault.chat.Chat;
import org.Nokwok.Main;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class spawn implements CommandExecutor {
    Main plugin;
    private Chat chat = null;

    public spawn(Main main, Chat chat) {
        this.plugin = main;
        this.chat = chat;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Player only command");
        } else {
            if (args.length == 0) {
                int x = plugin.getConfig().getInt("Spawn.X");
                int y = plugin.getConfig().getInt("Spawn.Y");
                int z = plugin.getConfig().getInt("Spawn.Z");
                p.teleport(new Location(p.getWorld(), x,y,z));
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL, 3.0F, 0.5F);
            } else {
                p.sendMessage(ChatColor.RED+"Incorrect usage: /spawn");
            }
        }

        return false;
    }
}