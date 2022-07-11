package me.wellthatssad.plugins.games.followerkill.follow_kill;

import me.wellthatssad.plugins.games.followerkill.follow_kill.commands.*;
import me.wellthatssad.plugins.games.followerkill.follow_kill.imports.GetFollowerClass;
import me.wellthatssad.plugins.games.followerkill.follow_kill.runnables.GameRunnable;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.lang.management.PlatformLoggingMXBean;

public final class Main extends JavaPlugin {
    // goofyahh main class, Kill me already
    public static Main instance;
    public boolean isOn;

    public String username;

    public boolean hasStopped;

    public static Main getInstance() {
        return instance;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isHasStopped() {
        return hasStopped;
    }

    public void setHasStopped(boolean hasStopped) {
        this.hasStopped = hasStopped;
    }

    @Override
    public void onEnable() {
        instance = this;
        username = "\u0000";
        isOn = false;
        hasStopped = false;
        this.getCommand("start").setExecutor(new StartCommand());
        this.getCommand("setname").setExecutor(new SetNameCommand());
        this.getCommand("hardstop").setExecutor(new HardStopCommand());
        this.getCommand("stop").setExecutor(new StopCommand());
        this.getCommand("help").setExecutor(new HelpCommand());
        this.getLogger().info("commands initialized");
        new GameRunnable().runTaskTimer(this, 0, 20);
        this.getLogger().info("Task initialized");
    }

    @Override
    public void onDisable() {
        this.getLogger().info("Closing plugin");
    }
}
