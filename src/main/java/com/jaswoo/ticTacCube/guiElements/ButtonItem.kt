package com.jaswoo.ticTacCube.guiElements

import com.jaswoo.ticTacCube.Game
import com.jaswoo.ticTacCube.TicTacCube
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.inventory.ClickType
import org.bukkit.event.inventory.InventoryClickEvent
import xyz.xenondevs.invui.item.ItemProvider
import xyz.xenondevs.invui.item.builder.ItemBuilder
import xyz.xenondevs.invui.item.impl.AbstractItem

class ButtonItem(var game:Game,private var id:Int,var board:Array<Array<Int>>,var turn:Player) : AbstractItem() {

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
            turn = game.turn

            if(type != 0) return
            if(turn != player) return
            if(game.player1 == player){
                this.type = 1
            } else{
                this.type = 2
            }

            board[id/3][id%3] = type

            game.move()
            notifyWindows()
        }

    }
}