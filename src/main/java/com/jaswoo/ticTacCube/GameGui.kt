package com.jaswoo.ticTacCube

import com.jaswoo.ticTacCube.guiElements.ButtonItem
import com.jaswoo.ticTacCube.guiElements.HeadItem
import com.jaswoo.ticTacCube.guiElements.LeaveItem
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.entity.Player
import xyz.xenondevs.invui.gui.Gui
import xyz.xenondevs.invui.item.builder.ItemBuilder
import xyz.xenondevs.invui.item.impl.SimpleItem
import xyz.xenondevs.invui.window.Window


class GameGui(var game: Game,player1: Player,player2: Player,board:Array<Array<Int>>, turn:Player) {


    private val gui = Gui.normal() // Creates the GuiBuilder for a normal GUI
        .setStructure(
            "# # # # # # # # #",
            "# # # 0 1 2 # # #",
            "# < # 3 4 5 # > #",
            "# # # 6 7 8 # # #",
            "# # # # # # # # #",
            "# # # # X # # # #")
        .addIngredient('#', SimpleItem(ItemBuilder(Material.BLACK_STAINED_GLASS_PANE)))
        .addIngredient('0', ButtonItem(game,0,board,turn))
        .addIngredient('1', ButtonItem(game,1,board,turn))
        .addIngredient('2', ButtonItem(game,2,board,turn))
        .addIngredient('3', ButtonItem(game,3,board,turn))
        .addIngredient('4', ButtonItem(game,4,board,turn))
        .addIngredient('5', ButtonItem(game,5,board,turn))
        .addIngredient('6', ButtonItem(game,6,board,turn))
        .addIngredient('7', ButtonItem(game,7,board,turn))
        .addIngredient('8', ButtonItem(game,8,board,turn))
        .addIngredient('<', HeadItem(player1))
        .addIngredient('>', HeadItem(player2))
        .addIngredient('X', LeaveItem(game))
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