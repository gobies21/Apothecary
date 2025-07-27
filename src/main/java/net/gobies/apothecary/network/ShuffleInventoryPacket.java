package net.gobies.apothecary.network;


import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.NetworkEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class ShuffleInventoryPacket {

    private final List<ItemStack> shuffledInventory;

    public ShuffleInventoryPacket(List<ItemStack> shuffledInventory) {
        this.shuffledInventory = shuffledInventory;
    }

    public ShuffleInventoryPacket(FriendlyByteBuf buffer) {
        int size = buffer.readInt();
        shuffledInventory = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            shuffledInventory.add(buffer.readItem());
        }
    }

    public void encode(FriendlyByteBuf buffer) {
        buffer.writeInt(shuffledInventory.size());
        for (ItemStack itemStack : shuffledInventory) {
            buffer.writeItem(itemStack);
        }
    }

    public void handle(Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {
            Player player = context.getSender();
            if (player != null) {
                shufflePlayerInventory(player);
            }
        });
        context.setPacketHandled(true);
    }

    private void shufflePlayerInventory(Player player) {

        int inventoryIndex = 0;
        for (int i = 0; i < player.getInventory().getContainerSize(); i++) {
            if (i < 36 || i > 39) { // Skip armor slots (36 to 39)
                player.getInventory().setItem(i, shuffledInventory.get(inventoryIndex));
                inventoryIndex++;
            }
        }

        player.getInventory().setChanged();
        player.containerMenu.broadcastChanges();
    }
}