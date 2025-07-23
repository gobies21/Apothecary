package net.gobies.apothecary.effect;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import net.gobies.apothecary.util.ModLoadedUtil;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class ManaRegeneration extends MobEffect {
    private static final UUID MANA_REGENERATION_UUID = UUID.randomUUID();

    public ManaRegeneration(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void addAttributeModifiers(@NotNull LivingEntity entity, @NotNull AttributeMap attribute, int amplifier) {
        super.addAttributeModifiers(entity, attribute, amplifier);
        if (ModLoadedUtil.isIronsSpellbooksLoaded()) {
            var manaRegen = entity.getAttribute(AttributeRegistry.MANA_REGEN.get());
            if (manaRegen != null && manaRegen.getModifier(MANA_REGENERATION_UUID) == null) {
                double regen= 0.25 * (amplifier + 1);
                manaRegen.addPermanentModifier(
                        new AttributeModifier(MANA_REGENERATION_UUID, "Mana Regen", regen, AttributeModifier.Operation.ADDITION));
            }
        }
    }

    @Override
    public void removeAttributeModifiers(@NotNull LivingEntity entity, @NotNull AttributeMap attribute, int amplifier) {
        super.removeAttributeModifiers(entity, attribute, amplifier);
        if (ModLoadedUtil.isIronsSpellbooksLoaded()) {
            var manaRegen = entity.getAttribute(AttributeRegistry.MANA_REGEN.get());
            if (manaRegen != null && manaRegen.getModifier(MANA_REGENERATION_UUID) != null) {
                manaRegen.removeModifier(MANA_REGENERATION_UUID);
            }
        }
    }
}
