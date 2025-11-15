package net.gobies.apothecary.event;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EffectEvents {

    public static void register() {
        MinecraftForge.EVENT_BUS.register(new EffectEvents());
    }

    @SubscribeEvent
    public void onMobEffectApplicable(MobEffectEvent.Applicable event) {
        LivingEntity livingEntity = event.getEntity();
        MobEffect effect = event.getEffectInstance().getEffect();

    }
}
