package net.gobies.apothecary.effect;

import net.gobies.apothecary.compat.ironsspellbooks.IronsSpellbooksCompat;
import net.gobies.apothecary.config.CommonConfig;
import net.gobies.apothecary.util.ModLoadedUtil;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;

public class ManaRegeneration extends MobEffect {
    public ManaRegeneration(MobEffectCategory category, int color) {
        super(category, color);
    }

    private static final ResourceLocation MANA_REGENERATION_KEY = ResourceLocation.fromNamespaceAndPath("apothecary", "effect.mana_regeneration.mana_regeneration");

    @Override
    public void createModifiers(int amplifier, @NotNull BiConsumer<Holder<Attribute>, AttributeModifier> consumer) {
        double manaRegeneration = CommonConfig.MANA_REGENERATION_INCREASE.get();
        if (ModLoadedUtil.isIronsSpellbooksLoaded()) {
            this.addAttributeModifier(IronsSpellbooksCompat.manaRegenerationAttribute(), MANA_REGENERATION_KEY, manaRegeneration, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
        }
        super.createModifiers(amplifier, consumer);
    }
}
