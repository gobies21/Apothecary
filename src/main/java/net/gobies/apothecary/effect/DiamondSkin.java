package net.gobies.apothecary.effect;

import net.gobies.apothecary.Config;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class DiamondSkin extends MobEffect {
    private static final UUID ARMOR_TOUGHNESS_UUID = UUID.randomUUID();

    public DiamondSkin(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void addAttributeModifiers(@NotNull LivingEntity entity, @NotNull AttributeMap attribute, int amplifier) {
        super.addAttributeModifiers(entity, attribute, amplifier);
        var Armor = entity.getAttribute(Attributes.ARMOR_TOUGHNESS);
        if (Armor != null && Armor.getModifier(ARMOR_TOUGHNESS_UUID) == null) {
            double armorToughness = Config.DIAMOND_SKIN_ARMOR_INCREASE.get() * (amplifier + 1);
            Armor.addTransientModifier(
                    new AttributeModifier(ARMOR_TOUGHNESS_UUID, "Diamond Skin", armorToughness, AttributeModifier.Operation.ADDITION));
        }
    }

    @Override
    public void removeAttributeModifiers(@NotNull LivingEntity entity, @NotNull AttributeMap attribute, int amplifier) {
        super.removeAttributeModifiers(entity, attribute, amplifier);
        var Armor = entity.getAttribute(Attributes.ARMOR_TOUGHNESS);
        if (Armor != null && Armor.getModifier(ARMOR_TOUGHNESS_UUID) != null) {
            Armor.removeModifier(ARMOR_TOUGHNESS_UUID);
        }
    }
}
