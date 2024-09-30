package com.jaswoo.ticTacCube.listeners

import com.jaswoo.ticTacCube.Game
import com.jaswoo.ticTacCube.TicTacCube
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerQuitEvent

class playerQuitListener :Listener {
    @EventHandler
    public fun onPlayerQuit(event: PlayerQuitEvent){
        for (game: Game in TicTacCube.games){
            if(event.player == game.player1){
                TicTacCube.deleteGame(1,game.gameId,game.player1,game.player2)
                break
            } else if(event.player == game.player2){
                TicTacCube.deleteGame(2,game.gameId,game.player1,game.player2)
                break
            }
        }
    }
}