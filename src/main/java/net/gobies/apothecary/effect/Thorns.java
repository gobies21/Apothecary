package net.gobies.apothecary.effect;

import net.gobies.apothecary.config.CommonConfig;
import net.gobies.apothecary.init.AEffects;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Objects;

public class Thorns extends MobEffect {
    public Thorns(MobEffectCategory category, int color) {
        super(category, color);
    }

    static {
        MinecraftForge.EVENT_BUS.register(Thorns.class);
    }

    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        LivingEntity entity = event.getEntity();
        DamageSource source = event.getSource();
        float damageDealt = event.getAmount();

        if (entity.hasEffect(AEffects.Thorns.get()) && source.getEntity() != null && source.getEntity() instanceof LivingEntity attacker) {
            int amplifier = Objects.requireNonNull(entity.getEffect(AEffects.Thorns.get())).getAmplifier();
            float damageReflect = (float) (damageDealt * CommonConfig.THORNS_DAMAGE_REFLECT.get() * (amplifier + 1));

            DamageSource thornsDamage = source.getEntity().damageSources().thorns(entity);

            attacker.hurt(thornsDamage, damageReflect);
        }
    }
}
