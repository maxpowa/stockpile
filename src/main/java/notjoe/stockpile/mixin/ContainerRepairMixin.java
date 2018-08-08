package notjoe.stockpile.mixin;

import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerRepair;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import notjoe.stockpile.block.StockpileBlocks;
import notjoe.stockpile.tile.TileBarrel;
import notjoe.stockpile.tile.inventory.MutableMassItemStorage;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * A mixin for ContainerRepair (Anvil container) that allows for Barrels to be upgraded with Chests.
 * <p>
 * This class is written in Java and not Kotlin to prevent more weirdness than is necessary...
 */
@Mixin(ContainerRepair.class)
abstract public class ContainerRepairMixin extends Container {
    private static final int CHEST_UPGRADE_STACKS = 27;
    @Shadow
    public int maximumCost;
    @Shadow
    @Final
    private IInventory outputSlot;
    @Shadow
    @Final
    private IInventory inputSlots;

    @Inject(method = "updateRepairOutput", at = @At("RETURN"))
    private void onRepairOutputUpdated(CallbackInfo ci) {
        ItemStack currentInput = inputSlots.getStackInSlot(0);
        ItemStack currentModifier = inputSlots.getStackInSlot(1);
        if (currentInput.getItem() != StockpileBlocks.Definitions.getBarrel().getItem()) {
            return;
        }

        if (currentModifier.getItem() == Blocks.CHEST.getItem()) {
            int availableChests = currentModifier.getCount();
            outputSlot.setInventorySlotContents(0, getUpgradedBarrelStack(currentInput, CHEST_UPGRADE_STACKS * availableChests));
            maximumCost = (int) (0.6 * availableChests + 1);
            detectAndSendChanges();
        }
    }

    private ItemStack getUpgradedBarrelStack(ItemStack barrelStack, int addedStacks) {
        ItemStack upgradedStack = barrelStack.copy();
        NBTTagCompound inventoryCompound = getOrInitBarrelCompound(upgradedStack).getCompoundTag("Inventory");
        int existingMax = inventoryCompound.getInteger(MutableMassItemStorage.MAX_STACKS_KEY);
        inventoryCompound.setInteger(MutableMassItemStorage.MAX_STACKS_KEY, existingMax + addedStacks);
        return upgradedStack;
    }

    private NBTTagCompound getOrInitBarrelCompound(ItemStack barrelStack) {
        NBTTagCompound stackCompound = barrelStack.func_196082_o();

        if (!stackCompound.hasKey("BarrelTileData")) {
            NBTTagCompound defaultBarrelNBT = new TileBarrel().writePersistentValuesToNBT(new NBTTagCompound());
            stackCompound.setTag("BarrelTileData", defaultBarrelNBT);
        }

        return stackCompound.getCompoundTag("BarrelTileData");
    }
}