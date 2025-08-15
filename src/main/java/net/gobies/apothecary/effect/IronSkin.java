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

public class IronSkin extends MobEffect {
    private static final UUID ARMOR_UUID = UUID.randomUUID();

    public IronSkin(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void addAttributeModifiers(@NotNull LivingEntity entity, @NotNull AttributeMap attribute, int amplifier) {
        super.addAttributeModifiers(entity, attribute, amplifier);
        var Armor = entity.getAttribute(Attributes.ARMOR);
        if (Armor != null && Armor.getModifier(ARMOR_UUID) == null) {
            double armor = CommonConfig.IRON_SKIN_ARMOR_INCREASE.get() * (amplifier + 1);
            Armor.addPermanentModifier(
                    new AttributeModifier(ARMOR_UUID, "Iron Skin", armor, AttributeModifier.Operation.ADDITION));
        }
    }

    @Override
    public void removeAttributeModifiers(@NotNull LivingEntity livingEntity, @NotNull AttributeMap attribute, int amplifier) {
        super.removeAttributeModifiers(livingEntity, attribute, amplifier);
        var Armor = livingEntity.getAttribute(Attributes.ARMOR);
        if (Armor != null && Armor.getModifier(ARMOR_UUID) != null) {
            Armor.removeModifier(ARMOR_UUID);
        }
    }
}