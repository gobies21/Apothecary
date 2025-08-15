package net.gobies.apothecary.effect;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import net.gobies.apothecary.config.CommonConfig;
import net.gobies.apothecary.init.AEffects;
import net.gobies.apothecary.util.ModLoadedUtil;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.UUID;

public class MagicPower extends MobEffect {
    private static final UUID SPELL_POWER_UUID = UUID.randomUUID();

    public MagicPower(MobEffectCategory category, int color) {
        super(category, color);
    }

    static {
        MinecraftForge.EVENT_BUS.register(MagicPower.class);
    }

    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        if (event.getSource().getEntity() instanceof LivingEntity attacker) {
            if ((event.getSource().is(DamageTypes.MAGIC) || event.getSource().is(DamageTypes.INDIRECT_MAGIC))) {
                if (attacker.hasEffect(AEffects.MagicPower.get())) {
                    int amplifier = Objects.requireNonNull(attacker.getEffect(AEffects.MagicPower.get())).getAmplifier();
                    float reducedDamage = (float) (event.getAmount() * (1.0f + (CommonConfig.MAGIC_POWER_INCREASE.get() * (amplifier + 1))));
                    event.setAmount(reducedDamage);
                }
            }
        }
    }

    @Override
    public void addAttributeModifiers(@NotNull LivingEntity livingEntity, @NotNull AttributeMap attribute, int amplifier) {
        super.addAttributeModifiers(livingEntity, attribute, amplifier);
        if (ModLoadedUtil.isIronsSpellbooksLoaded()) {
            var spellPower = livingEntity.getAttribute(AttributeRegistry.SPELL_POWER.get());
            if (spellPower != null && spellPower.getModifier(SPELL_POWER_UUID) == null) {
                double power = CommonConfig.MAGIC_POWER_INCREASE.get() * (amplifier + 1);
                spellPower.addPermanentModifier(
                        new AttributeModifier(SPELL_POWER_UUID, "Magic Power", power, AttributeModifier.Operation.ADDITION));
            }
        }
    }

    @Override
    public void removeAttributeModifiers(@NotNull LivingEntity livingEntity, @NotNull AttributeMap attribute, int amplifier) {
        super.removeAttributeModifiers(livingEntity, attribute, amplifier);
        if (ModLoadedUtil.isIronsSpellbooksLoaded()) {
            var spellPower = livingEntity.getAttribute(AttributeRegistry.SPELL_POWER.get());
            if (spellPower != null && spellPower.getModifier(SPELL_POWER_UUID) != null) {
                spellPower.removeModifier(SPELL_POWER_UUID);
            }
        }
    }
}
