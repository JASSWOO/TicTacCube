package com.jaswoo.ticTacCube

import com.jaswoo.ticTacCube.commands.Play
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin

class TicTacCube : JavaPlugin() {

    companion object CompanionObject{
        var waitingPlayer :Player? = null
        var joiningPlayer : Player? = null
        var games: MutableList<Game> = ArrayList()
        fun newGame(player: Player){
            joiningPlayer = player
            games += Game(games.size,(waitingPlayer as Player),(joiningPlayer as Player))
        }
        fun deleteGame(winner: Int, gameId: Int,player1:Player,player2:Player){
            if(winner == 3){
                Bukkit.broadcastMessage("${player1.name}'s and ${player2.name}'s TicTacCube game ended as a tie! /play to play")

            } else if (winner == 1){
                Bukkit.broadcastMessage("${player1.name} defeated ${player2.name} in TicTacCube game! /play to play")

            } else{
                Bukkit.broadcastMessage("${player2.name} defeated ${player1.name} in TicTacCube game! /play to play")

            }

            games.removeAt(gameId)

        }
    }




    override fun onEnable() {
        this.getCommand("play")?.setExecutor(Play())

        // Plugin startup logic
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}
