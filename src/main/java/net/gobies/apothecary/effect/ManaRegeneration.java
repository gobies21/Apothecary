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

public class ManaRegeneration extends MobEffect {
    private static final UUID MANA_REGENERATION = UUID.fromString("d20189a2-e70a-405d-9960-3d5e3e54ec63");

    public ManaRegeneration(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void addAttributeModifiers(@NotNull LivingEntity livingEntity, @NotNull AttributeMap attributeMap, int amplifier) {
        if (ModLoadedUtil.isIronsSpellbooksLoaded()) {
            this.getAttributeModifiers().put(IronsSpellbooksAttributes.manaRegenerationAttribute(), createModifier());
            super.addAttributeModifiers(livingEntity, attributeMap, amplifier);
        }
    }

    @Override
    public @NotNull Map<Attribute, AttributeModifier> getAttributeModifiers() {
        if (ModLoadedUtil.isIronsSpellbooksLoaded()) {
            Map<Attribute, AttributeModifier> modifiers = super.getAttributeModifiers();
            modifiers.put(IronsSpellbooksAttributes.manaRegenerationAttribute(), createModifier());
            return modifiers;
        }
        return Map.of();
    }

    private AttributeModifier createModifier() {
        return new AttributeModifier(MANA_REGENERATION, this::getDescriptionId, CommonConfig.MANA_REGENERATION_INCREASE.get(), AttributeModifier.Operation.MULTIPLY_BASE);
    }
}
