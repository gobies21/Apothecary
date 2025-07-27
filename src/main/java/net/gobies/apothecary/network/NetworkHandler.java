package net.gobies.apothecary.network;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

import java.util.List;
import java.util.Optional;

public class NetworkHandler {
    private static final String PROTOCOL_VERSION = "1";
    public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
            new ResourceLocation("apothecary", "main"),
            () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals
    );

    private static int packetId = 0;

    public static void registerPackets() {
        INSTANCE.registerMessage(packetId++, ShuffleInventoryPacket.class,
                ShuffleInventoryPacket::encode,
                ShuffleInventoryPacket::new,
                ShuffleInventoryPacket::handle,
                Optional.of(NetworkDirection.PLAY_TO_CLIENT));
    }

    public static void sendShuffleInventoryPacket(ServerPlayer player, List<ItemStack> shuffledInventory) {
        INSTANCE.sendTo(new ShuffleInventoryPacket(shuffledInventory), player.connection.connection, NetworkDirection.PLAY_TO_CLIENT);
    }
}