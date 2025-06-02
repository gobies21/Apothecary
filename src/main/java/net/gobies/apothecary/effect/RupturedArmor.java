package net.gobies.apothecary.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class RupturedArmor extends MobEffect {
    private static final UUID ARMOR_TOUGHNESS_UUID = UUID.randomUUID();

    public RupturedArmor(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void addAttributeModifiers(@NotNull LivingEntity entity, @NotNull AttributeMap attribute, int amplifier) {
        super.addAttributeModifiers(entity, attribute, amplifier);
        var ArmorToughness = entity.getAttribute(Attributes.ARMOR_TOUGHNESS);
        if (ArmorToughness != null && ArmorToughness.getModifier(ARMOR_TOUGHNESS_UUID) == null) {
            double armorToughness = 2 * (amplifier + 1);
            ArmorToughness.addTransientModifier(
                    new AttributeModifier(ARMOR_TOUGHNESS_UUID, "Ruptured Armor", -armorToughness, AttributeModifier.Operation.ADDITION));
        }
    }

    @Override
    public void removeAttributeModifiers(@NotNull LivingEntity entity, @NotNull AttributeMap attribute, int amplifier) {
        super.removeAttributeModifiers(entity, attribute, amplifier);
        var ArmorToughness = entity.getAttribute(Attributes.ARMOR_TOUGHNESS);
        if (ArmorToughness != null && ArmorToughness.getModifier(ARMOR_TOUGHNESS_UUID) != null) {
            ArmorToughness.removeModifier(ARMOR_TOUGHNESS_UUID);
        }
    }
}
