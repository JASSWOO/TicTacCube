package com.jaswoo.ticTacCube.guiElements

import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.inventory.ClickType
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.SkullMeta
import xyz.xenondevs.invui.item.ItemProvider
import xyz.xenondevs.invui.item.builder.ItemBuilder
import xyz.xenondevs.invui.item.builder.SkullBuilder
import xyz.xenondevs.invui.item.impl.AbstractItem

class HeadItem(val player: Player) : AbstractItem() {
    override fun getItemProvider(): ItemProvider {
        return try {
            SkullBuilder(player.uniqueId).setDisplayName(player.name)
        } catch (e: Exception) {
            ItemBuilder(Material.PLAYER_HEAD).setDisplayName(player.name)
        }
    }

    override fun handleClick(p0: ClickType, p1: Player, p2: InventoryClickEvent) {
        return;
    }
}