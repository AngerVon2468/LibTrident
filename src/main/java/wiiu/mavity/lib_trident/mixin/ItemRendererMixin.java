/*
 * MIT License
 *
 * Copyright (c) 2021-2024 OroArmor (Eli Orona)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package wiiu.mavity.lib_trident.mixin;

import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.item.*;

import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;

import com.llamalad7.mixinextras.injector.wrapoperation.*;

import static wiiu.mavity.lib_trident.util.UtilKt.isTrident;

/**
 * Repurposed Mixin from "Multi Item Lib", check it out at <a href="https://github.com/OroArmorModding/Multi-Item-Lib/">this repo</a>
 * (Specifically <a href="https://github.com/OroArmorModding/Multi-Item-Lib/blob/master/src/main/java/com/oroarmor/multiitemlib/mixin/render/ItemRendererMixin.java">this file</a>)
 */
@Mixin(ItemRenderer.class)
public abstract class ItemRendererMixin {

    @WrapOperation(
		method = "renderItem(Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/render/model/json/ModelTransformationMode;ZLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;IILnet/minecraft/client/render/model/BakedModel;)V",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z",
			ordinal = 0
		)
    )
    private boolean renderItemTrident0(ItemStack instance, Item item, Operation<Boolean> original) {
        return isTrident(instance) || original.call(instance, item);
    }

    @WrapOperation(
		method = "renderItem(Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/render/model/json/ModelTransformationMode;ZLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;IILnet/minecraft/client/render/model/BakedModel;)V",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z",
			ordinal = 2
		)
    )
    private boolean renderItemTrident2(ItemStack instance, Item item, Operation<Boolean> original) {
        return isTrident(instance) || original.call(instance, item);
    }

    @WrapOperation(
		method = "getModel",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z",
			ordinal = 0
		)
    )
    private boolean getModelTrident(ItemStack instance, Item item, Operation<Boolean> original) {
        return isTrident(instance) || original.call(instance, item);
    }
}