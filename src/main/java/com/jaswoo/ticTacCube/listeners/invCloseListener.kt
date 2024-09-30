package com.jaswoo.ticTacCube.listeners

import com.jaswoo.ticTacCube.Game
import com.jaswoo.ticTacCube.TicTacCube
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryCloseEvent

class invCloseListener : Listener {
    @EventHandler
    public fun onPlayerCloseInv(event:InventoryCloseEvent){
        for (game:Game in TicTacCube.games){
            if(event.player == game.player1){
                game.Gui.window1.open()
                break
            } else if(event.player == game.player2){
                game.Gui.window2.open()
                break
            }
        }
    }
}