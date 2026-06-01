package net.gobies.apothecary.event;
import net.gobies.apothecary.config.CommonConfig;
import net.gobies.apothecary.init.AEffects;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.Input;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.MovementInputUpdateEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Objects;

public class EffectEvents {

    public static void register() {
        MinecraftForge.EVENT_BUS.register(new EffectEvents());
    }

    @SubscribeEvent
    public void onLivingHurt(LivingHurtEvent event) {
        LivingEntity livingEntity = event.getEntity();
        DamageSource source = event.getSource();
        Entity entity = event.getEntity();
        float damageDealt = event.getAmount();
        if (event.getSource().getEntity() instanceof LivingEntity attacker) {
            if (attacker.hasEffect(AEffects.Wrath.get())) {
                int amplifier = Objects.requireNonNull(attacker.getEffect(AEffects.Wrath.get())).getAmplifier();
                float increasedDamage = (float) (event.getAmount() * (1.0f + (CommonConfig.WRATH_DAMAGE_INCREASE.get() * (amplifier + 1))));
                event.setAmount(increasedDamage);
            }
            if (source.is(DamageTypes.ARROW)) {
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
            if (livingEntity.hasEffect(AEffects.Feeble.get())) {
                int amplifier = Objects.requireNonNull(livingEntity.getEffect(AEffects.Feeble.get())).getAmplifier();
                float reducedDamage = event.getAmount() * (1.0f - (0.10f * (amplifier + 1)));
                event.setAmount(reducedDamage);
            }
            if ((event.getSource().is(DamageTypes.MAGIC) || event.getSource().is(DamageTypes.INDIRECT_MAGIC))) {
                if (attacker.hasEffect(AEffects.MagicPower.get())) {
                    int amplifier = Objects.requireNonNull(attacker.getEffect(AEffects.MagicPower.get())).getAmplifier();
                    float increasedDamage = (float) (event.getAmount() * (1.0f + (CommonConfig.MAGIC_POWER_INCREASE.get() * (amplifier + 1))));
                    event.setAmount(increasedDamage);
                }
                if (attacker.hasEffect(AEffects.MagicDrain.get())) {
                    int amplifier = Objects.requireNonNull(attacker.getEffect(AEffects.MagicDrain.get())).getAmplifier();
                    float reducedDamage = (float) (event.getAmount() * (1.0f - (CommonConfig.MAGIC_DRAIN_DECREASE.get() * (amplifier + 1))));
                    event.setAmount(reducedDamage);
                }
            }
        }
        if (entity instanceof LivingEntity defender) {
            if (defender.hasEffect(AEffects.Vulnerable.get())) {
                int amplifier = Objects.requireNonNull(defender.getEffect(AEffects.Vulnerable.get())).getAmplifier();
                float reducedDamage = (float) (event.getAmount() * (1.0f + (CommonConfig.VULNERABLE_DAMAGE_TAKEN.get() * (amplifier + 1))));
                event.setAmount(reducedDamage);
            }
        }
        if (livingEntity.hasEffect(AEffects.Thorns.get()) && source.getEntity() != null && source.getEntity() instanceof LivingEntity attacker) {
            int amplifier = Objects.requireNonNull(livingEntity.getEffect(AEffects.Thorns.get())).getAmplifier();
            float damageReflect = (float) (damageDealt * CommonConfig.THORNS_DAMAGE_REFLECT.get() * (amplifier + 1)) + 1;

            DamageSource thornsDamage = source.getEntity().damageSources().thorns(livingEntity);

            attacker.hurt(thornsDamage, damageReflect);
        }
    }

    @OnlyIn(Dist.CLIENT)
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
