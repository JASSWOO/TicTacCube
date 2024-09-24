package com.jaswoo.ticTacCube

import org.bukkit.Material
import org.bukkit.entity.Player
import xyz.xenondevs.invui.gui.Gui
import xyz.xenondevs.invui.item.builder.ItemBuilder
import xyz.xenondevs.invui.item.impl.SimpleItem
import xyz.xenondevs.invui.window.Window
import java.util.UUID

class gameGui(var player: Player) {

    val gui = Gui.normal() // Creates the GuiBuilder for a normal GUI
        .setStructure(
            "# # # # # # # # #",
            "# # # . . . # # #",
            "# # # . . . # # #",
            "# # # . . . # # #",
            "# # # # # # # # #")
        .addIngredient('#', SimpleItem(ItemBuilder(Material.BLACK_STAINED_GLASS_PANE)))
        .build()

    val window = Window.single()
        .setViewer(player)
        .setTitle("InvUI")
        .setGui(gui)
        .build()

}