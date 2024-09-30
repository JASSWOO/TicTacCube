package com.jaswoo.ticTacCube

import org.bukkit.block.data.type.Switch
import org.bukkit.entity.Player

class Game (private var gameId:Int,  var player1:Player,  var player2: Player){
    var board = arrayOf(arrayOf(0,0,0),arrayOf(0,0,0),arrayOf(0,0,0))
    var turn = player1

//    var player1Gui = GameGui(gameId,player1, 1,board,turn)
//    var player2Gui = GameGui(gameId,player2, 2,board,turn)

    var Gui = GameGui(gameId,player1,player2,board,turn)

    var winner = null

    var moves = 0

    private fun winCheck() : Int{
        for (nums in 0..2){
            if(board[1][nums] == board[2][nums] && board[2][nums] == board[0][nums] && board[1][nums] != 0){
                return board[1][nums];
            }
            if(board[nums][1] == board[nums][2] && board[nums][2] == board[nums][0] && board[nums][1] != 0){
                return board[1][nums];
            }
        }
        if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[1][1] != 0){
            return board[0][0]
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[1][1] != 0){
            return board[0][2]
        }
        if(moves == 9){
            return 3
        }
        return 0
    }

     fun move(){
        moves += 1
        val win = winCheck()
         if(win == 0){
             if(turn == player1){
                 turn = player2
             } else{
                 turn = player1
             }
         } else{
             TicTacCube.deleteGame(win,gameId,player1,player2)
             Gui.window1.close();
             Gui.window2.close();

             return
         }

    }
}