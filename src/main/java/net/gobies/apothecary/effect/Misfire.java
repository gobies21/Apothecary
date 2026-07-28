package net.gobies.apothecary.effect;

import net.gobies.apothecary.config.CommonConfig;
import net.gobies.apothecary.init.AAttributes;
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

public class Misfire extends MobEffect {
    public Misfire(MobEffectCategory category, int color) {
        super(category, color);
    }

    private static final UUID PROJECTILE_DAMAGE = UUID.fromString("803a074d-2dcf-47e5-bfc8-92dc90511cf4");

    @Override
    public void addAttributeModifiers(@NotNull LivingEntity livingEntity, @NotNull AttributeMap attributeMap, int amplifier) {
        if (ModLoadedUtil.isIronsSpellbooksLoaded()) {
            this.getAttributeModifiers().put(AAttributes.PROJECTILE_DAMAGE.get(), createModifier());
            super.addAttributeModifiers(livingEntity, attributeMap, amplifier);
        }
    }

    @Override
    public @NotNull Map<Attribute, AttributeModifier> getAttributeModifiers() {
        Map<Attribute, AttributeModifier> modifiers = super.getAttributeModifiers();
        modifiers.put(AAttributes.PROJECTILE_DAMAGE.get(), createModifier());
        return modifiers;
    }

    private AttributeModifier createModifier() {
        return new AttributeModifier(PROJECTILE_DAMAGE, this::getDescriptionId, -CommonConfig.MISFIRE_DAMAGE_DECREASE.get(), AttributeModifier.Operation.ADDITION);
    }
}
