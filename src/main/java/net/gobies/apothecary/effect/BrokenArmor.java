package net.gobies.apothecary.effect;

import net.gobies.apothecary.config.CommonConfig;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class BrokenArmor extends MobEffect {
    private static final UUID ARMOR_UUID = UUID.randomUUID();

    public BrokenArmor(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void addAttributeModifiers(@NotNull LivingEntity entity, @NotNull AttributeMap attribute, int amplifier) {
        super.addAttributeModifiers(entity, attribute, amplifier);
        var Armor = entity.getAttribute(Attributes.ARMOR);
        if (Armor != null && Armor.getModifier(ARMOR_UUID) == null) {
            double armorReduction = CommonConfig.BROKEN_ARMOR_ARMOR_DECREASE.get() * (amplifier + 1);
            Armor.addPermanentModifier(
                    new AttributeModifier(ARMOR_UUID, "Broken Armor", -armorReduction, AttributeModifier.Operation.ADDITION));
        }
    }

    @Override
    public void removeAttributeModifiers(@NotNull LivingEntity entity, @NotNull AttributeMap attribute, int amplifier) {
        super.removeAttributeModifiers(entity, attribute, amplifier);
        var Armor = entity.getAttribute(Attributes.ARMOR);
        if (Armor != null && Armor.getModifier(ARMOR_UUID) != null) {
            Armor.removeModifier(ARMOR_UUID);
        }
    }
}
