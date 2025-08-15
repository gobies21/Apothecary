package net.gobies.apothecary.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.MinecraftForge;
import org.jetbrains.annotations.NotNull;

public class Flight extends MobEffect {
    public Flight(MobEffectCategory category, int color) {
        super(category, color);
    }

    private boolean allowFlying = false;

    static {
        MinecraftForge.EVENT_BUS.register(Flight.class);
    }

    @Override
    public void applyEffectTick(@NotNull LivingEntity livingEntity, int amplifier) {
        if (livingEntity instanceof Player player) {
            if (!player.getAbilities().mayfly) {
                player.getAbilities().mayfly = true;
                player.onUpdateAbilities();
                allowFlying = true;
            }
        }
    }

    @Override
    public void removeAttributeModifiers(@NotNull LivingEntity livingEntity, @NotNull AttributeMap attributes, int amplifier) {
        super.removeAttributeModifiers(livingEntity, attributes, amplifier);
        if (livingEntity instanceof Player player) {
            if (!player.isCreative() && !player.isSpectator() && allowFlying) {
                player.getAbilities().flying = false;
                player.getAbilities().mayfly = false;
                player.onUpdateAbilities();
                allowFlying = false;
            }
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}
