package com.jaswoo.ticTacCube

import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.inventory.ClickType
import org.bukkit.event.inventory.InventoryClickEvent
import xyz.xenondevs.invui.item.ItemProvider
import xyz.xenondevs.invui.item.builder.ItemBuilder
import xyz.xenondevs.invui.item.impl.AbstractItem

class ButtonItem(var gameId:Int,private var id:Int,var board:Array<Array<Int>>,var turn:Player) : AbstractItem() {

//    private var turn = TicTacCube.games[gameId].turn
//    private var board = TicTacCube.games[gameId].board
    private var type = 0

    override fun getItemProvider(): ItemProvider {
        return if(type == 1){
            ItemBuilder(Material.DIAMOND).setDisplayName("O")
        } else if(type == 2){
            ItemBuilder(Material.DIAMOND_SWORD).setDisplayName("X")
        } else{
            ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setDisplayName("Empty")
        }
    }

    override fun handleClick(clickType: ClickType, player: Player, event: InventoryClickEvent) {

        if(clickType.isLeftClick){
            turn = TicTacCube.games[this.gameId].turn

            if(type != 0) return
            if(turn != player) return
            if(TicTacCube.games[this.gameId].player1 == player){
                this.type = 1
            } else{
                this.type = 2
            }

            board[id/3][id%3] = type

            TicTacCube.games[this.gameId].move()
            notifyWindows()
        }

    }
}