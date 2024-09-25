package com.jaswoo.ticTacCube

import org.bukkit.Material
import org.bukkit.entity.Player
import xyz.xenondevs.invui.gui.Gui
import xyz.xenondevs.invui.item.builder.ItemBuilder
import xyz.xenondevs.invui.item.impl.SimpleItem
import xyz.xenondevs.invui.window.Window


class GameGui(gameId:Int,player1: Player,player2: Player,board:Array<Array<Int>>, turn:Player) {


    private val gui = Gui.normal() // Creates the GuiBuilder for a normal GUI
        .setStructure(
            "# # # # # # # # #",
            "# # # 0 1 2 # # #",
            "# # # 3 4 5 # # #",
            "# # # 6 7 8 # # #",
            "# # # # # # # # #")
        .addIngredient('#', SimpleItem(ItemBuilder(Material.BLACK_STAINED_GLASS_PANE)))
        .addIngredient('0',ButtonItem(gameId,0,board,turn))
        .addIngredient('1',ButtonItem(gameId,1,board,turn))
        .addIngredient('2',ButtonItem(gameId,2,board,turn))
        .addIngredient('3',ButtonItem(gameId,3,board,turn))
        .addIngredient('4',ButtonItem(gameId,4,board,turn))
        .addIngredient('5',ButtonItem(gameId,5,board,turn))
        .addIngredient('6',ButtonItem(gameId,6,board,turn))
        .addIngredient('7',ButtonItem(gameId,7,board,turn))
        .addIngredient('8',ButtonItem(gameId,8,board,turn))
        .build()

    val window1 = Window.single()
        .setViewer(player1)
        .setTitle("TicTacCube")
        .setGui(gui)
        .build()

    val window2 = Window.single()
        .setViewer(player2)
        .setTitle("TicTacCube")
        .setGui(gui)
        .build()

        init {
            window1.open()
            window2.open()
        }

}