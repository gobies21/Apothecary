package net.gobies.apothecary.effect;

import net.gobies.apothecary.config.CommonConfig;
import net.gobies.apothecary.init.AEffects;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Objects;

public class Archery extends MobEffect {
    public Archery(MobEffectCategory category, int color) {
        super(category, color);
        MinecraftForge.EVENT_BUS.register(this);
    }

    static {
        MinecraftForge.EVENT_BUS.register(Archery.class);
    }

    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        if (event.getSource().getEntity() instanceof LivingEntity attacker) {
            if (event.getSource().is(DamageTypes.ARROW)) {
                if (attacker.hasEffect(AEffects.Archery.get())) {
                    int amplifier = Objects.requireNonNull(attacker.getEffect(AEffects.Archery.get())).getAmplifier();
                    float increasedDamage = (float) (event.getAmount() * (1.0f + (CommonConfig.ARCHERY_DAMAGE_INCREASE.get() * (amplifier + 1))));
                    event.setAmount(increasedDamage);
                }
            }
        }
    }
}
