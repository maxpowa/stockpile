package me.branchpanic.mods.stockpile.content.client.renderer

import me.branchpanic.mods.stockpile.api.storage.Quantizer
import me.branchpanic.mods.stockpile.content.blockentity.ItemBarrelBlockEntity
import net.minecraft.client.MinecraftClient
import net.minecraft.client.render.OverlayTexture
import net.minecraft.client.render.VertexConsumerProvider
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher
import net.minecraft.client.render.model.json.ModelTransformation.Type
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.item.ItemStack

class ItemBarrelRenderer(dispatcher: BlockEntityRenderDispatcher) :
    AbstractBarrelRenderer<ItemBarrelBlockEntity, ItemStack>(dispatcher) {
    override fun drawIcon(
        matrixStack: MatrixStack,
        vertexConsumerProvider: VertexConsumerProvider,
        contents: Quantizer<ItemStack>,
        i: Int,
        j: Int
    ) {
        matrixStack.translate(0.5, 0.5, 0.0)
        matrixStack.scale(0.8f, 0.8f, 0.01f)

        MinecraftClient.getInstance().itemRenderer.renderItem(
            contents.reference,
            Type.GUI,
            0xFF,
            OverlayTexture.DEFAULT_UV,
            matrixStack,
            vertexConsumerProvider
        )
    }

    override fun shouldSkipRenderingFor(barrel: ItemBarrelBlockEntity): Boolean =
        barrel.storage.contents.reference.isEmpty
}
