package wiiu.mavity.lib_trident.mixin;

import net.minecraft.item.*;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import com.llamalad7.mixinextras.injector.wrapoperation.*;

@Mixin(TridentItem.class)
public class TridentItemMixin {

	/**
	 * Based on the way Vanilla handles the ability to throw Tridents, if you make a custom Trident with infinite durability (value of 0),
	 * or a durability of 1, then it will be unable to be thrown because of the first check in {@link TridentItem#use}.
	 * This Mixin modifies that behaviour so that if your trident does
	 * have a maximum durability of 1 or less, it can still be thrown without having to override the {@link TridentItem#use} method.
	 */
	@WrapOperation(
		method = "use(Lnet/minecraft/world/World;Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/util/Hand;)Lnet/minecraft/util/TypedActionResult;",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/item/ItemStack;getDamage()I"
		)
	)
	private int allowInfiniteDurability(ItemStack instance, Operation<Integer> original) {
		// The check is "itemStack.getDamage() >= itemStack.getMaxDamage() - 1"
		// Therefore, if return a smaller value than -1 (the smallest possible value it would allow) only if the max durability is 1 or less
		// and call original otherwise, it should be compatible.
		if (instance.getMaxDamage() <= 1) return -2;
		else return original.call(instance);
	}
}