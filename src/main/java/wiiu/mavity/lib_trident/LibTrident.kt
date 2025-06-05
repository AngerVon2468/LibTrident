package wiiu.mavity.lib_trident

import wiiu.mavity.lib_trident.tag.LibTridentTags

import net.fabricmc.api.ModInitializer

import org.slf4j.*

//TODO: Provide API to allow custom render code for the Entity & custom models for in-hand rendering.
object LibTrident : ModInitializer {

	override fun onInitialize() {
		LOGGER.info("LibTrident initialising!")
		LibTridentTags
	}

	const val MOD_ID: String = "lib_trident"

	val LOGGER: Logger = LoggerFactory.getLogger(MOD_ID)
}