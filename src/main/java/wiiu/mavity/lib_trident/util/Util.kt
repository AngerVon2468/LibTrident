package wiiu.mavity.lib_trident.util

import net.minecraft.item.*
import net.minecraft.registry.tag.TagKey

import wiiu.mavity.lib_trident.tag.LibTridentTags

operator fun TagKey<Item>.contains(stack: ItemStack): Boolean = stack.isIn(this)

fun ItemStack.isTrident(): Boolean = this in LibTridentTags.TRIDENT