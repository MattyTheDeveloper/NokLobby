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
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("set")) {
                    if (p.hasPermission(plugin.getConfig().getString("Lobby.Command.setspawn"))) {
                        Location loc = p.getLocation();
                        double x = loc.getX();
                        double y = loc.getY();
                        double z = loc.getZ();
                        double pit = loc.getPitch();
                        double yaw =  loc.getYaw();
                        plugin.getConfig().set("Spawn.X", x);
                        plugin.getConfig().set("Spawn.Y", y);
                        plugin.getConfig().set("Spawn.Z", z);
                        plugin.getConfig().set("Spawn.Pitch", pit);
                        plugin.getConfig().set("Spawn.Yaw", yaw);
                        plugin.saveConfig();

                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bSuccessfully set the spawn point to your location."));
                    } else {
                        p.sendMessage(plugin.getConfig().getString("Permission.message"));
                        p.playSound(p.getLocation(), Sound.ENTITY_BAT_DEATH, 1.0F, 0.5F);
                    }
                } else {
                    p.sendMessage(ChatColor.RED + "Incorrect usage: /spawn (set)");
                }
            } else if (args.length == 0) {
                double x = plugin.getConfig().getDouble("Spawn.X");
                double y = plugin.getConfig().getDouble("Spawn.Y");
                double z = plugin.getConfig().getDouble("Spawn.Z");
                float yaw = plugin.getConfig().getInt("Spawn.Yaw");
                float pitch = plugin.getConfig().getInt("Spawn.Pitch");

                p.teleport(new Location(p.getWorld(), x,y,z,yaw,pitch));

                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL, 3.0F, 0.5F);
            } else {
                p.sendMessage(ChatColor.RED+"Incorrect usage: /spawn");
            }
        }

        return false;
    }
}