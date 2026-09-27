package net.gobies.apothecary.mixin;

import net.gobies.apothecary.init.AAttributes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Mixin(MobEffect.class)
public class MobEffectMixin {

    @Shadow
    @Final
    @Mutable
    private Map<Attribute, AttributeModifier> attributeModifiers;

    @Inject(
            method = "getAttributeModifiers",
            at = @At("TAIL")
    )
    private void reorderAttributes(CallbackInfoReturnable<Map<Attribute, AttributeModifier>> ci) {
        if (this.attributeModifiers == null || this.attributeModifiers.isEmpty() || this.attributeModifiers instanceof LinkedHashMap) {
            return;
        }

        List<Map.Entry<Attribute, AttributeModifier>> original = new ArrayList<>(this.attributeModifiers.entrySet());
        Map<Attribute, AttributeModifier> sortedMap = new LinkedHashMap<>();

        for (var entry : original) {
            if (entry.getKey() == Attributes.ATTACK_DAMAGE) {
                sortedMap.put(entry.getKey(), entry.getValue());
            }
        }

        for (var entry : original) {
            if (entry.getKey() == Attributes.ATTACK_SPEED) {
                sortedMap.put(entry.getKey(), entry.getValue());
            }
        }

        for (var entry : original) {
            if (entry.getKey() == Attributes.ATTACK_KNOCKBACK) {
                sortedMap.put(entry.getKey(), entry.getValue());
            }
        }

        for (var entry : original) {
            if (entry.getKey() == AAttributes.PROJECTILE_DAMAGE.get()) {
                sortedMap.put(entry.getKey(), entry.getValue());
            }
        }

        for (var entry : original) {
            if (entry.getKey() == AAttributes.DRAW_SPEED.get()) {
                sortedMap.put(entry.getKey(), entry.getValue());
            }
        }

        for (var entry : original) {
            if (entry.getKey() == AAttributes.PROJECTILE_VELOCITY.get()) {
                sortedMap.put(entry.getKey(), entry.getValue());
            }
        }

        for (var entry : original) {
            if (entry.getKey() == AAttributes.MAGIC_DAMAGE.get()) {
                sortedMap.put(entry.getKey(), entry.getValue());
            }
        }

        for (var entry : original) {
            if (!sortedMap.containsKey(entry.getKey()) && entry.getKey() != Attributes.MOVEMENT_SPEED) {
                sortedMap.put(entry.getKey(), entry.getValue());
            }
        }

        for (var entry : original) {
            if (entry.getKey() == Attributes.MOVEMENT_SPEED) {
                sortedMap.put(entry.getKey(), entry.getValue());
            }
        }

        this.attributeModifiers = sortedMap;
    }
}