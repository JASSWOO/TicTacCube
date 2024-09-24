package com.jaswoo.ticTacCube

import org.bukkit.entity.Player
import java.util.UUID

class game (private var player1:Player, private var player2: Player){

    var player1Gui = gameGui(player1)
    var player2Gui = gameGui(player2)

    var board = arrayOf(arrayOf(0,0,0),arrayOf(0,0,0),arrayOf(0,0,0));
    var turn = player1
    var winner = null
    init{
        do {
            move(turn)
        }while (true)
    }
    private fun winCheck(){

    }
    private fun move(player:Player){



        if(turn == player1){
            turn == player2
        } else{
            turn == player1
        }
    }
}