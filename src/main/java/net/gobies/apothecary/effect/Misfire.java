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

public class Misfire extends MobEffect {
    public Misfire(MobEffectCategory category, int color) {
        super(category, color);
    }

    static {
        MinecraftForge.EVENT_BUS.register(Misfire.class);
    }

    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        if (event.getSource().getEntity() instanceof LivingEntity attacker) {
            if (event.getSource().is(DamageTypes.ARROW)) {
                if (attacker.hasEffect(AEffects.Misfire.get())) {
                    int amplifier = Objects.requireNonNull(attacker.getEffect(AEffects.Misfire.get())).getAmplifier();
                    float reducedDamage = (float) (event.getAmount() * (1.0f - (CommonConfig.MISFIRE_DAMAGE_DECREASE.get() * (amplifier + 1))));
                    event.setAmount(reducedDamage);
                }
            }
        }
    }
}
