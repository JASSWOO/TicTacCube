package com.jaswoo.ticTacCube

import com.jaswoo.ticTacCube.commands.play
import org.bukkit.plugin.java.JavaPlugin
import java.util.UUID

class TicTacCube : JavaPlugin() {
    var waitingPlayer :UUID? = null
    override fun onEnable() {
        this.getCommand("play")?.setExecutor(play());

        // Plugin startup logic
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}
