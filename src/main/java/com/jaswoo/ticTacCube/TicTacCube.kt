package com.jaswoo.ticTacCube

import com.jaswoo.ticTacCube.commands.play
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin
import java.util.UUID

class TicTacCube : JavaPlugin() {
    var waitingPlayer :Player? = null
    override fun onEnable() {
        this.getCommand("play")?.setExecutor(play(this));

        // Plugin startup logic
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}
