package me.wellthatssad.plugins.games.followerkill.follow_kill.commands;

import me.wellthatssad.plugins.games.followerkill.follow_kill.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class StopCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Main main = Main.getInstance();
        if(main.isOn()){
            main.setOn(false);

            sender.sendMessage(ChatColor.GOLD + "Game stopped");
            return true;
        }
        else{
            sender.sendMessage(ChatColor.RED + "The game is not on yet");
            return true;
        }
    }
    // I am going to kill myself
}
