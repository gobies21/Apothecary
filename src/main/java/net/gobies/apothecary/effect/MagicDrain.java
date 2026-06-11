package net.gobies.apothecary.effect;

import net.gobies.apothecary.compat.ironsspellbooks.IronsSpellbooksAttributes;
import net.gobies.apothecary.config.CommonConfig;
import net.gobies.apothecary.util.ModLoadedUtil;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.UUID;

public class MagicDrain extends MobEffect {
    private static final UUID SPELL_POWER = UUID.fromString("6fe75e59-248e-4162-95db-1d2ac7b5ce4c");

    public MagicDrain(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void addAttributeModifiers(@NotNull LivingEntity livingEntity, @NotNull AttributeMap attributeMap, int amplifier) {
        if (ModLoadedUtil.isIronsSpellbooksLoaded()) {
            this.getAttributeModifiers().put(IronsSpellbooksAttributes.spellPowerAttribute(), createModifier());
            super.addAttributeModifiers(livingEntity, attributeMap, amplifier);
        }
    }

    @Override
    public @NotNull Map<Attribute, AttributeModifier> getAttributeModifiers() {
        if (ModLoadedUtil.isIronsSpellbooksLoaded()) {
            Map<Attribute, AttributeModifier> modifiers = super.getAttributeModifiers();
            modifiers.put(IronsSpellbooksAttributes.spellPowerAttribute(), createModifier());
            return modifiers;
        }
        return Map.of();
    }

    private AttributeModifier createModifier() {
        return new AttributeModifier(SPELL_POWER, this::getDescriptionId, -CommonConfig.MAGIC_DRAIN_DECREASE.get(), AttributeModifier.Operation.MULTIPLY_BASE);
    }
}

