package net.gobies.apothecary.network;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

public class PacketHandler {
    private static final String PROTOCOL_VERSION = "1";
    public static PayloadRegistrar INSTANCE;

    private static int packetId = 0;

    @SubscribeEvent
    public static void register(final RegisterPayloadHandlersEvent event) {
        INSTANCE = event.registrar(PROTOCOL_VERSION);

    }
}