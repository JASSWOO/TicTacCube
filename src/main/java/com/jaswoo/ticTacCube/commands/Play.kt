package com.jaswoo.ticTacCube.commands

import com.jaswoo.ticTacCube.TicTacCube
import com.jaswoo.ticTacCube.TicTacCube.CompanionObject.tieGameMessage
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class Play() : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>?): Boolean {
        if(sender !is Player) return false

        if(TicTacCube.waitingPlayer == null){
            Bukkit.broadcastMessage(TicTacCube.waitingGameMessage.toString().replace("%player%",sender.name))
            TicTacCube.waitingPlayer =sender;

        } else if(TicTacCube.waitingPlayer != sender){

            TicTacCube.newGame(sender)
            TicTacCube.waitingPlayer = null

        }

        return true
    }
}