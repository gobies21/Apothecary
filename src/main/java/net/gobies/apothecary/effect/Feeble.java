package net.gobies.apothecary.effect;

import net.gobies.apothecary.init.AEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Objects;

public class Feeble extends MobEffect {
    public Feeble(MobEffectCategory category, int color) {
        super(category, color);
        MinecraftForge.EVENT_BUS.register(this);
    }

    static {
        MinecraftForge.EVENT_BUS.register(Feeble.class);
    }

    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        if (event.getSource().getEntity() instanceof LivingEntity entity) {
            if (entity.hasEffect(AEffects.Feeble.get())) {
                int amplifier = Objects.requireNonNull(entity.getEffect(AEffects.Feeble.get())).getAmplifier();
                float reducedDamage = event.getAmount() * (1.0f - (0.10f * (amplifier + 1)));
                event.setAmount(reducedDamage);
            }
        }
    }
}
