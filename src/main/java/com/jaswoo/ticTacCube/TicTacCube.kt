package com.jaswoo.ticTacCube

import com.jaswoo.ticTacCube.commands.Play
import com.jaswoo.ticTacCube.listeners.LeaveListener
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin

class TicTacCube : JavaPlugin() {

    companion object CompanionObject{
        var waitingGameMessage = "Error loading config"
        var wonGameMessage = "Error loading config"
        var tieGameMessage = "Error loading config"
        var waitingPlayer :Player? = null
        var joiningPlayer : Player? = null
        var games: MutableList<Game> = ArrayList()
        fun newGame(player: Player){
            joiningPlayer = player
            games += Game(games.size,(waitingPlayer as Player),(joiningPlayer as Player))
        }
        fun deleteGame(winner: Int, gameId: Int,player1:Player,player2:Player){

            if(winner == 3){

                Bukkit.broadcastMessage(tieGameMessage.toString().replace("%player1%",player1.name).replace("%player2%",player2.name))

            } else if (winner == 1){
                Bukkit.broadcastMessage(wonGameMessage.toString().replace("%player1%",player1.name).replace("%player2%",player2.name))

            } else{
                Bukkit.broadcastMessage(wonGameMessage.toString().replace("%player2%",player1.name).replace("%player1%",player2.name))

            }

            games.removeAt(gameId)

        }
    }




    override fun onEnable() {
        saveDefaultConfig()

        TicTacCube.waitingGameMessage = config.getString("message.waitingForGame").toString()
        TicTacCube.wonGameMessage = config.getString("message.wonGame").toString()
        TicTacCube.tieGameMessage = config.getString("message.tieGame").toString()

        config.getString("commandName")?.let { this.getCommand(it)?.setExecutor(Play()) }
        server.pluginManager.registerEvents(LeaveListener(),this)
        // Plugin startup logic

    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}
