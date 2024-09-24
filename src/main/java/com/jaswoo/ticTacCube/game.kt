package com.jaswoo.ticTacCube

import java.util.UUID

class game (var player1:UUID, var player2: UUID){
    var board = arrayOf(arrayOf(0,0,0),arrayOf(0,0,0),arrayOf(0,0,0));
    var turn = player1
    var winner = null
    init{
        do {
            move(turn)
        }while (true)
    }
    fun winCheck(){

    }
    fun move(player:UUID){



        if(turn == player1){
            turn == player2
        } else{
            turn == player1
        }
    }
}