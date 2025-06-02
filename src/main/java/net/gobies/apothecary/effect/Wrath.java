package net.gobies.apothecary.effect;

import net.gobies.apothecary.Config;
import net.gobies.apothecary.init.AEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Objects;

public class Wrath extends MobEffect {

    public Wrath(MobEffectCategory category, int color) {
        super(category, color);
    }

    static {
        MinecraftForge.EVENT_BUS.register(Wrath.class);
    }

    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        if (event.getSource().getEntity() instanceof LivingEntity attacker) {
            if (attacker.hasEffect(AEffects.Wrath.get())) {
                int amplifier = Objects.requireNonNull(attacker.getEffect(AEffects.Wrath.get())).getAmplifier();
                float increasedDamage = (float) (event.getAmount() * (1.0f + (Config.ARCHERY_DAMAGE_INCREASE.get() * (amplifier + 1))));
                event.setAmount(increasedDamage);
            }
        }
    }
}