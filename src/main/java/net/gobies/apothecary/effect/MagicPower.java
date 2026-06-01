package net.gobies.apothecary.effect;

import net.gobies.apothecary.compat.ironsspellbooks.IronsSpellbooksAttributes;
import net.gobies.apothecary.config.CommonConfig;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.UUID;

public class MagicPower extends MobEffect {
    private static final UUID SPELL_POWER = UUID.randomUUID();

    public MagicPower(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void addAttributeModifiers(@NotNull LivingEntity livingEntity, @NotNull AttributeMap attributeMap, int amplifier) {
        this.getAttributeModifiers().put(IronsSpellbooksAttributes.spellPowerAttribute(), createModifier());
        super.addAttributeModifiers(livingEntity, attributeMap, amplifier);
    }

    @Override
    public @NotNull Map<Attribute, AttributeModifier> getAttributeModifiers() {
        Map<Attribute, AttributeModifier> modifiers = super.getAttributeModifiers();
        modifiers.put(IronsSpellbooksAttributes.spellPowerAttribute(), createModifier());
        return modifiers;
    }

    private AttributeModifier createModifier() {
        return new AttributeModifier(SPELL_POWER, this::getDescriptionId, CommonConfig.MAGIC_POWER_INCREASE.get(), AttributeModifier.Operation.MULTIPLY_BASE);
    }
}
