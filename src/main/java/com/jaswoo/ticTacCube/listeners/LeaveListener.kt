package com.jaswoo.ticTacCube.listeners

import com.jaswoo.ticTacCube.TicTacCube
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerQuitEvent

class LeaveListener : Listener {
    @EventHandler
    fun leaveListener(event: PlayerQuitEvent) {
        TicTacCube.games.forEach {
            if (it.player1 == event.player) {
                it.endGame(2);
                return;

            } else if (it.player2 == event.player) {
                it.endGame(1);
                return;

            }
        }
    }
}