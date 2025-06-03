package net.gobies.apothecary.effect;

import net.gobies.apothecary.Config;
import net.gobies.apothecary.init.AEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Objects;

public class Indolence extends MobEffect {
    public Indolence(MobEffectCategory category, int color) {
        super(category, color);
    }

    static {
        MinecraftForge.EVENT_BUS.register(Indolence.class);
    }

    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        Entity entity = event.getEntity();
        if (entity instanceof LivingEntity defender) {
            if (defender.hasEffect(AEffects.Indolence.get())) {
                int amplifier = Objects.requireNonNull(defender.getEffect(AEffects.Indolence.get())).getAmplifier();
                float reducedDamage = (float) (event.getAmount() * (1.0f + (Config.INDOLENCE_DAMAGE_TAKEN.get() * (amplifier + 1))));
                event.setAmount(reducedDamage);
            }
        }
    }
}
