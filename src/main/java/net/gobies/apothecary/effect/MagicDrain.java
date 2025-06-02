package net.gobies.apothecary.effect;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraftforge.fml.ModList;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class MagicDrain extends MobEffect {
    private static final UUID SPELL_POWER_UUID = UUID.randomUUID();

    public MagicDrain(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void addAttributeModifiers(@NotNull LivingEntity entity, @NotNull AttributeMap attribute, int amplifier) {
        super.addAttributeModifiers(entity, attribute, amplifier);
        if (ModList.get().isLoaded("irons_spellbooks")) {
            var spellPower = entity.getAttribute(AttributeRegistry.SPELL_POWER.get());
            if (spellPower != null && spellPower.getModifier(SPELL_POWER_UUID) == null) {
                double power = 0.1 * (amplifier + 1);
                spellPower.addTransientModifier(
                        new AttributeModifier(SPELL_POWER_UUID, "Magic Drain", -power, AttributeModifier.Operation.ADDITION));
            }
        }
    }

    @Override
    public void removeAttributeModifiers(@NotNull LivingEntity entity, @NotNull AttributeMap attribute, int amplifier) {
        super.removeAttributeModifiers(entity, attribute, amplifier);
        if (ModList.get().isLoaded("irons_spellbooks")) {
            var spellPower = entity.getAttribute(AttributeRegistry.SPELL_POWER.get());
            if (spellPower != null && spellPower.getModifier(SPELL_POWER_UUID) != null) {
                spellPower.removeModifier(SPELL_POWER_UUID);
            }
        }
    }
}
