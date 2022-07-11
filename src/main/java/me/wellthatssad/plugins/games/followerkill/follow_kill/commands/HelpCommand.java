package me.wellthatssad.plugins.games.followerkill.follow_kill.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.lang.invoke.SwitchPoint;

public class HelpCommand implements CommandExecutor {
    @Override
    public boolean onCommand (CommandSender sender, Command command, String label, String[] args) {
        switch(args.length)
        {
            case 0:
                    sender.sendMessage(ChatColor.LIGHT_PURPLE + "Welcome to the follower kill plugin, this plugin uses Twitch api integration to" +
                            "create a fun challenge for twitch streamers or creative players made by Well_thatssad.");
                sender.sendMessage(ChatColor.YELLOW + "In case you are curious on what commands to use run /help commands \n" +
                        "In case you are curious about how it works internally or how it's played run /help workings [internal,practice]\n" +
                        "In case you are curious about the author and his socials, or want to send feedback run /help author\n");
                return true;
            case 1:
                    switch (args[0]){
                        case "commands":
                            sender.sendMessage(ChatColor.LIGHT_PURPLE + "The commands of this plugin and their usages are the following:\n");
                            sender.sendMessage(ChatColor.YELLOW + "\n/setname [Twitch username], sets what will be the username of the streamer which followers are tracked \n" +
                                    "\n/start, starts the game, pretty obvious innit\n" +
                                    "\n/stop, soft stop/pause the game, you can restart again with \"/start\"(used for pausing for a sec or changing usernames)\n" +
                                    "\n/hardstop, stop the game until next reload, used for emergencies like console spams or memory leaks,\n in case of any of those" +
                                    " problems send feedback on github or the spigot page of the plugin\n");
                            return true;

                        case "workings":
                            sender.sendMessage(ChatColor.LIGHT_PURPLE + "\nIn case you are curious about the internal workings of the plugin run:\n" +
                                    "\n/help workings internal\n" +
                                    "\nIn case you need help understanding how to play with it run: /help workings practice\n");
                                return true;

                        case "author":
                            sender.sendMessage(ChatColor.LIGHT_PURPLE + "The author of this plugin is well_thatssad and his socials are the following\n");
                            sender.sendMessage(ChatColor.YELLOW + "\nGithub(send feedback here) https://github.com/Wellthatssad\n" +
                                    "\nTwitch twitch.tv/well_thatssad\n" +
                                    "\nTwitter: @Well_thatssad\n" +
                                    "\nDiscord: Well_thatssad#6427\n");
                            return true;

                        default:
                            return false;
                    }
            case 2:
                if(args[0].equals("workings")){
                    switch (args[1]){
                        case "internal":
                            sender.sendMessage(ChatColor.LIGHT_PURPLE + "The internal workings are pretty simple using http get requests and Gson, more can be found on my github");
                            return true;
                        case "practice":
                            sender.sendMessage(ChatColor.LIGHT_PURPLE + "after you have set an username and used /start, every time someone follows the user associated\n" +
                                    "with the username every player on the server that is currently on survival mode dies.");
                            return true;
                        default:
                            return false;
                    }
                }

            default:
                return false;
        }

    }
}
