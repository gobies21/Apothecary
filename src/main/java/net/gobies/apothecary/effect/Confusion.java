package net.gobies.apothecary.effect;

import net.gobies.apothecary.init.AEffects;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.Input;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.client.event.MovementInputUpdateEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class Confusion extends MobEffect {
    public Confusion(MobEffectCategory category, int color) {
        super(category, color);
    }

    static {
        MinecraftForge.EVENT_BUS.register(Confusion.class);
    }

    @SubscribeEvent
    public static void MovementEvent(MovementInputUpdateEvent event) {
        Minecraft player = Minecraft.getInstance();
        if (event.getEntity().hasEffect(AEffects.Confusion.get())) {
            Input input = event.getInput();
            input.leftImpulse *= -1;
            input.forwardImpulse *= -1;
            input.up = !input.up;
            input.down = !input.down;
            input.jumping=player.options.keyShift.isDown();
            input.shiftKeyDown=player.options.keyJump.isDown();
        }
    }
}
