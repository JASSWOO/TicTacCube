package com.jaswoo.ticTacCube.guiElements

import com.jaswoo.ticTacCube.Game
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.inventory.ClickType
import org.bukkit.event.inventory.InventoryClickEvent
import xyz.xenondevs.invui.item.ItemProvider
import xyz.xenondevs.invui.item.builder.ItemBuilder
import xyz.xenondevs.invui.item.impl.AbstractItem

class LeaveItem(var game: Game) : AbstractItem() {
    override fun getItemProvider(): ItemProvider {
        return ItemBuilder(Material.BARRIER).setDisplayName("Surrender")
    }

    override fun handleClick(p0: ClickType, p1: Player, p2: InventoryClickEvent) {
        var winningPlayer = 0
        if(game.player1 == p1)
            { winningPlayer = 2}
        else {
            winningPlayer = 1
        }

        game.endGame(winningPlayer)
    }
}