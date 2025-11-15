package net.gobies.apothecary.compat.spartanweaponry;

import com.oblivioussp.spartanweaponry.init.ModDamageTypes;
import net.gobies.apothecary.config.CommonConfig;
import net.gobies.apothecary.init.AEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Objects;

public class SpartanWeaponryCompat {

    public static void loadCompat() {
        MinecraftForge.EVENT_BUS.register(new SpartanWeaponryCompat());
    }

    @SubscribeEvent
    public void onLivingHurt(LivingHurtEvent event) {
        if (event.getSource().getEntity() instanceof LivingEntity attacker) {
            if (event.getSource().is(ModDamageTypes.KEY_ARMOR_PIERCING_BOLT)) {
                if (attacker.hasEffect(AEffects.Archery.get())) {
                    int amplifier = Objects.requireNonNull(attacker.getEffect(AEffects.Archery.get())).getAmplifier();
                    int increasedDamage = (int) (event.getAmount() + CommonConfig.ARCHERY_DAMAGE_INCREASE.get() * (amplifier + 1));
                    event.setAmount(increasedDamage);
                }
                if (attacker.hasEffect(AEffects.Misfire.get())) {
                    int amplifier = Objects.requireNonNull(attacker.getEffect(AEffects.Misfire.get())).getAmplifier();
                    int reducedDamage = (int) (event.getAmount() - CommonConfig.MISFIRE_DAMAGE_DECREASE.get() * (amplifier + 1));
                    if (reducedDamage < 1) {
                        reducedDamage = 1;
                    }
                    event.setAmount(reducedDamage);
                }
            }
        }
    }
}
