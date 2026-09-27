 package net.gobies.apothecary.effect;

import net.gobies.apothecary.config.CommonConfig;
import net.gobies.apothecary.init.AAttributes;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;

 public class Lethargy extends MobEffect {
     public Lethargy(MobEffectCategory category, int color) {
         super(category, color);
     }

     private static final ResourceLocation DRAW_SPEED_KEY = ResourceLocation.fromNamespaceAndPath("apothecary", "effect.lethargy.draw_speed");
     private static final ResourceLocation PROJECTILE_VELOCITY_KEY = ResourceLocation.fromNamespaceAndPath("apothecary", "effect.lethargy.projectile_velocity");

     @Override
     public void createModifiers(int amplifier, @NotNull BiConsumer<Holder<Attribute>, AttributeModifier> consumer) {
         double drawSpeed = CommonConfig.LETHARGY_SPEED_DECREASE.get();
         double projectileVelocity = CommonConfig.LETHARGY_VELOCITY_DECREASE.get();
         this.addAttributeModifier(AAttributes.DRAW_SPEED, DRAW_SPEED_KEY, -drawSpeed, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
         this.addAttributeModifier(AAttributes.PROJECTILE_VELOCITY, PROJECTILE_VELOCITY_KEY, -projectileVelocity, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
         super.createModifiers(amplifier, consumer);
     }
 }