package wiiu.mavity.lib_trident.tag

import net.minecraft.item.Item
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.tag.TagKey
import net.minecraft.util.Identifier

import wiiu.mavity.lib_trident.LibTrident

object LibTridentTags {

	init {
		LibTrident.LOGGER.info("Registering Tags for LibTrident!")
	}

	@JvmField val TRIDENTS: TagKey<Item> = TagKey.of(RegistryKeys.ITEM, Identifier(LibTrident.MOD_ID, "tridents"))
}