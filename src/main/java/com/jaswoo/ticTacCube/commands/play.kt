package com.jaswoo.ticTacCube.commands

import com.jaswoo.ticTacCube.TicTacCube
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class play(private var plugin:TicTacCube) : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>?): Boolean {
        if(sender !is Player) return false
        if(plugin.waitingPlayer == null){
            plugin.waitingPlayer =sender.uniqueId;
        } else if(plugin.waitingPlayer != sender.uniqueId){
            plugin.waitingPlayer == null
        }

        return true
    }
}