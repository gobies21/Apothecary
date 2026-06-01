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

public class ManaExhaustion extends MobEffect {
    private static final UUID MANA_EXHAUSTION = UUID.randomUUID();

    public ManaExhaustion(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void addAttributeModifiers(@NotNull LivingEntity livingEntity, @NotNull AttributeMap attributeMap, int amplifier) {
        this.getAttributeModifiers().put(IronsSpellbooksAttributes.manaRegenerationAttribute(), createModifier());
        super.addAttributeModifiers(livingEntity, attributeMap, amplifier);
    }

    @Override
    public @NotNull Map<Attribute, AttributeModifier> getAttributeModifiers() {
        Map<Attribute, AttributeModifier> modifiers = super.getAttributeModifiers();
        modifiers.put(IronsSpellbooksAttributes.manaRegenerationAttribute(), createModifier());
        return modifiers;
    }

    private AttributeModifier createModifier() {
        return new AttributeModifier(MANA_EXHAUSTION, this::getDescriptionId, -CommonConfig.MANA_EXHAUSTION_DECREASE.get(), AttributeModifier.Operation.MULTIPLY_BASE);
    }
}
