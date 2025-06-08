package wiiu.mavity.lib_trident

import wiiu.mavity.lib_trident.tag.LibTridentTags

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.api.ModInitializer
import net.fabricmc.loader.api.FabricLoader

import net.minecraft.item.TridentItem
import net.minecraft.util.Identifier
import net.minecraft.registry.*

import org.slf4j.*

//TODO: Provide API to allow custom render code for the Entity & custom models for in-hand rendering.
object LibTrident : ModInitializer {

	override fun onInitialize() {
		LOGGER.info("LibTrident initialising!")
		LibTridentTags
		if (FabricLoader.getInstance().isDevelopmentEnvironment) Registry.register(Registries.ITEM, Identifier(MOD_ID, "test_trident"), object : TridentItem(FabricItemSettings()) {})
	}

	const val MOD_ID: String = "lib_trident"

	val LOGGER: Logger = LoggerFactory.getLogger(MOD_ID)
}